FROM openjdk:17
COPY . /app
WORKDIR /app
RUN javac Test_DamMay/Server_BAiTapDaLuong.java Test_DamMay/Utils.java
CMD ["java", "Test_DamMay.Server_BAiTapDaLuong"]
