package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usertypechoose extends JFrame{
    private JPanel panel1;
    private JButton StudentloginButton;
    private JButton AdminloginButton;
    private JButton VerifierloginButton;
    private JLabel stext;
    private JLabel atext;
    private JLabel vtext;


    public Usertypechoose() {
        StudentloginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentLoginpage f2 = new StudentLoginpage();
                dispose();
                f2.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        Usertypechoose frame = new Usertypechoose();
        frame.setContentPane(frame.panel1);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 400, 300);
        frame.setTitle("Login");

    }
}