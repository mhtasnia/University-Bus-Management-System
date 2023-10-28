package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Studensignup extends JFrame{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/signup";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    private static boolean signupUser(String id, String email, String password) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO signupinfo (student_id, Stdent_mail, account_pass) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database connection error: " + e.getMessage());
        }
        return false;
    }
    Studensignup(){
        this.setContentPane(this.panel1);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(200, 50, 400, 300);
        this.setTitle("Signup");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField2.getText();
                String email = textfield1.getText();
                String password = new String(passfield1.getPassword());

                if (signupUser(id, email, password)) {
                    JOptionPane.showMessageDialog(null, "Signup Successful!");
                } else {
                    dispose();
                    JOptionPane.showMessageDialog(null, "Signup Failed. User with the same ID or Email already exists.");
                }
            }
        });
    }
    private JPanel panel1;
    private JTextField textField2;
    private JButton signUpButton;
    private JPasswordField passfield1;
    private JTextField textfield1;

    public static void main(String[] args) {
        Studensignup f4 = new Studensignup();
    }
}
