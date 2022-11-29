package org.example;

import java.sql.*;
import java.util.Properties;

public class ConectDB {
    // Блок объявления констант
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String DB_Driver = "org.postgresql.Driver";

    public static void main(String[] args) {
        try {
            Class.forName(DB_Driver); //Проверяем наличие JDBC драйвера для работы с БД
            Connection connection = DriverManager.getConnection(DB_URL,"postgres","123");//соединениесБД
            System.out.println("Соединение с СУБД выполнено.");
            Statement stat = connection.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM author");
            while (res.next()) {
                String author = res.getString(2);
                System.out.println(author);
            }
            connection.close();       // отключение от БД
            System.out.println("Отключение от СУБД выполнено.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }
    }
}
