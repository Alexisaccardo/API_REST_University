package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BD {
    String register_not_found =  "No se pudo realizar el registrar";
    String course_not_updated = "No se encontro un curso con el nombre ingresado";
    public BD() {
    }
    public University register(String course, String teacher, int number_students, String schedule, String semester, String working_day, String campus) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/university";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usus");


            // Sentencia INSERT
            String sql = "INSERT INTO usus (course, teacher, number_students, schedule, semester, working_day, campus) VALUES (?, ?, ?, ?, ?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, course);
            preparedStatement.setString(2, teacher);
            preparedStatement.setInt(3, number_students);
            preparedStatement.setString(4, schedule);
            preparedStatement.setString(5, semester);
            preparedStatement.setString(6, working_day);
            preparedStatement.setString(7, campus);

            // Ejecutar la sentencia
            int files = preparedStatement.executeUpdate();

            if (files > 0) {
                System.out.println("Registrado realizado de manera exitosa.");
                return new University(course, teacher, number_students, schedule, semester, working_day, campus);
            } else {
                System.out.println(register_not_found);
            }

            preparedStatement.close();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new University(null, null, 0, null, null, null, null);
    }

    public University Edit(String course, String teacher, int number_students, String schedule, String semester, String working_day, String campus) throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/university";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        String consult = "UPDATE usus SET teacher = ?, number_students = ?, schedule = ?, semester = ?, working_day = ?, campus = ? WHERE course = ?";
        PreparedStatement preparedStatement = connection2.prepareStatement(consult);

        preparedStatement.setString(1, teacher);
        preparedStatement.setInt(2, number_students);
        preparedStatement.setString(3, schedule);
        preparedStatement.setString(4, semester);
        preparedStatement.setString(5, working_day);
        preparedStatement.setString(6,campus);
        preparedStatement.setString(7, course);

        int files = preparedStatement.executeUpdate();
        if (files > 0) {
            System.out.println("Curso actualizado de manera exitosa");
            return new University(course, teacher, number_students, schedule, semester, working_day, campus);
        } else {
            System.out.println(course_not_updated);
        }

        preparedStatement.close();
        connection2.close();
        return new University(null, null, 0, null, null, null, null);
    }

    public List<University> Select_course() throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/university";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM usus");

        List<University> list = new ArrayList<>();

        while (resultSet2.next()) {
            String course = resultSet2.getString("course");
            String teacher = resultSet2.getString("teacher");
            int number_students = resultSet2.getInt("number_students");
            String schedule = resultSet2.getString("schedule");
            String semester = resultSet2.getString("semester");
            String working_day = resultSet2.getString("working_day");
            String campus = resultSet2.getString("campus");

            University university = new University(course, teacher, number_students, schedule, semester, working_day, campus);

            list.add(university);

        }
        return list;
    }

    public University Select_user(String course) throws SQLException, ClassNotFoundException {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/university";
        String username = "root";
        String password = "";

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String consult_SQL = "SELECT * FROM usus WHERE course = ?";

        PreparedStatement statement = connection.prepareStatement(consult_SQL);
        statement.setString(1, course); // Establecer el valor del parámetro

        // Ejecutar la consulta
        ResultSet resultSet2 = statement.executeQuery();

        // Procesar el resultado si existe
        if (resultSet2.next()) {

            course = resultSet2.getString("course");
            String teacher = resultSet2.getString("teacher");
            int number_students = resultSet2.getInt("number_students");
            String schedule = resultSet2.getString("schedule");
            String semester = resultSet2.getString("semester");
            String working_day = resultSet2.getString("working_day");
            String campus = resultSet2.getString("campus");

            University university = new University (course, teacher, number_students, schedule, semester, working_day, campus);

            return university;
        }
        // Cerrar recursos
        resultSet2.close();
        statement.close();
        connection.close();

        return null;
    }

    public int Delete(String course) throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/university";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        String sentenciaSQL = "DELETE FROM usus WHERE course = ?";
        PreparedStatement prepareStatement = connection2.prepareStatement(sentenciaSQL);
        prepareStatement.setString(1, course);
        int f = prepareStatement.executeUpdate();

        System.out.println("curso eliminado correctamente");
        return f;
    }
    }



