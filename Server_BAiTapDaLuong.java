package Test_DamMay;

import java.io.*;
import java.net.*;

public class Server_BAiTapDaLuong {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server đang chạy...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client mới đã kết nối: " + clientSocket.getInetAddress());

                // Tạo một luồng riêng để xử lý client
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Lớp xử lý riêng cho từng client
class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream())
        ) {
            while (true) {
                int choice = dis.readInt();
                String response = "";

                if (choice == 7) {
                    response = "Đã thoát chương trình.";
                    dos.writeUTF(response);
                    dos.flush();
                    break;
                }

                switch (choice) {
                    case 1 -> {
                        int number = dis.readInt();
                        response = Utils.checkNumberType(number);
                    }
                    case 2 -> {
                        int number = dis.readInt();
                        response = Utils.TongTich(number);
                    }
                    case 3 -> {
                        int a = dis.readInt();
                        int b = dis.readInt();
                        response = "Ước chung lớn nhất của " + a + " và " + b + " là: " + Utils.UCLN(a, b) +
                                "\nBội chung nhỏ nhất của " + a + " và " + b + " là: " + Utils.BCNN(a, b);
                    }
                    case 4 -> {
                        String str = dis.readUTF();
                        response = Utils.DaoNguoc(str);
                    }
                    case 5 -> {
                        String str = dis.readUTF();
                        response = Utils.phanTichChuoi(str);
                    }
                    case 6 -> {
                        String str = dis.readUTF();
                        response = Utils.phanTichKyTu(str);
                    }
                    default -> response = "Lựa chọn không hợp lệ.";
                }

                String clientMessage = dis.readUTF();
                System.out.println("Client (" + socket.getInetAddress() + "): " + clientMessage);

                dos.writeUTF(response);
                dos.flush();
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("Client ngắt kết nối: " + socket.getInetAddress());
        }
    }
}
