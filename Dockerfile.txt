FROM openjdk:17
COPY . /app
WORKDIR /app
RUN javac Server_BAiTapDaLuong.java Utils.java
CMD ["java", "Server_BAiTapDaLuong"]
