package Test_DamMay;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static String checkNumberType(int number) {
        StringBuilder result = new StringBuilder("Số " + number + " là: ");

        if (isPrime(number)) result.append("số nguyên tố, ");
        if (isPerfectSquare(number)) result.append("số chính phương, ");
        if (isPerfectNumber(number)) result.append("số hoàn hảo, ");
        if (isArmstrong(number)) result.append("số Armstrong, ");

        if (result.toString().equals("Số " + number + " là: ")) {
            return "Số " + number + " không thuộc loại số đặc biệt nào.";
        }

        return result.substring(0, result.length() - 2) + "."; // Xóa dấu phẩy cuối cùng
    }

    //kiểm tra số nguyên tố
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Kiểm tra số chính phương
    private static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    // Kiểm tra số hoàn hảo
    private static boolean isPerfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }

    // Kiểm tra số Armstrong
    private static boolean isArmstrong(int n) {
        int original = n, sum = 0, digits = String.valueOf(n).length();
        while (n > 0) {
            sum += Math.pow(n % 10, digits);
            n /= 10;
        }
        return sum == original;
    }

    public static String TongTich(int number) {
        int c=number;
        int tong=0;
        int tich=1;
        while (number>0){
            int du = number%10;
            tong += du;
            tich *= du;
            number /=10;
        }
        if(c==0)
            tich=0;
        return "Tổng các chữ số của "+c+" là: "+tong+"\nTích các chữ số của "+c+" là: "+tich;    }

    public static int UCLN(int a, int b) {
        while (b !=0){
            int tg = b;
            b=a%b;
            a=tg;
        }
        return a;    }

    public static int BCNN(int a, int b) {
        return Math.abs(a*b)/UCLN(a,b);    }

    public static String DaoNguoc(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return "Chuỗi đảo ngược: "+reversed;    }

    public static String swapCase(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static int countWords(String str) {
        if (str.trim().isEmpty()) {
            return 0;
        }
        return str.trim().split("\\s+").length;
    }

    public static String extractVowels(String str) {
        StringBuilder vowels = new StringBuilder();
        String vowelChars = "AEIOUaeiou";
        for (char c : str.toCharArray()) {
            if (vowelChars.indexOf(c) != -1) {
                vowels.append(c).append(" ");
            }
        }
        return vowels.toString().trim();
    }

    public static String printWords(String str) {
        StringBuilder result = new StringBuilder("Các từ trong chuỗi:\n");
        String[] words = str.trim().split("\\s+"); // Tách từ bằng dấu cách
        for (String word : words) {
            result.append(word).append("\n");
        }
        return result.toString();
    }

    public static String printCharacterFrequency(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        StringBuilder result = new StringBuilder("Bảng tần số ký tự:\n");
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            result.append("'").append(entry.getKey()).append("' xuất hiện ")
                    .append(entry.getValue()).append(" lần\n");
        }
        return result.toString();
    }

    public static String phanTichChuoi(String str) {
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("").append(DaoNguoc(str)).append("\n");
        responseBuilder.append("Chuỗi thành chữ hoa: ").append(str.toUpperCase()).append("\n");
        responseBuilder.append("Chuỗi thành chữ thường: ").append(str.toLowerCase()).append("\n");
        responseBuilder.append("Chuỗi đổi hoa thành thường và ngược lại: ").append(swapCase(str)).append("\n");
        responseBuilder.append("Số từ trong chuỗi: ").append(countWords(str)).append("\n");
        responseBuilder.append("Các nguyên âm trong chuỗi: ").append(extractVowels(str)).append("\n");
        return responseBuilder.toString();
    }

    public static String phanTichKyTu(String str) {
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("In mỗi từ trong chuỗi ra từng dòng:\n").append(printWords(str)).append("\n");
        responseBuilder.append("Tần số xuất hiện:\n").append(printCharacterFrequency(str)).append("\n");
        return responseBuilder.toString();
    }
}
