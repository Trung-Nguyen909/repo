FROM openjdk:17
COPY . /app
WORKDIR /app
RUN javac Server_Client_DaLuong/Server_BAiTapDaLuong.java Server_Client_DaLuong/Utils.java
CMD ["java", "Server_Client_DaLuong.Server_BAiTapDaLuong"]
