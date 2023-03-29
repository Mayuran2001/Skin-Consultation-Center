package org.example;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

public class Menu extends JFrame {
    public Menu(){
        // Main Menu
        Container body = getContentPane();
        body.setLayout(null);

        JPanel frame = new JPanel();
        frame.setLayout(null);
        frame.setBounds(0, 0, 1500, 1000);

        JLabel name = new JLabel("Skin Consultation Center");
        name.setFont(new Font("Serif", Font.BOLD, 44));
        name.setForeground(black);
        name.setBackground(Color.gray);
        name.setBounds(450, 40, 800, 150);
        frame.add(name);

        //Doctor details Table
        JButton button1 = new JButton("Doctor Details Table");
        button1.setBounds(100,250,350,300);
        button1.setFont(new Font("Serif", Font.PLAIN, 24));
        button1.setBackground(darkGray);
        button1.setForeground(white);
        frame.add(button1);

        //Add Patient
        JButton button3 = new JButton("Book consultation");
        button3.setBounds(500,250,350,300);
        button3.setFont(new Font("Serif", Font.PLAIN, 24));
        button3.setBackground(darkGray);
        button3.setForeground(white);
        frame.add(button3);

        //Patient All details
        JButton button4 = new JButton("Patient Details");
        button4.setBounds(900,250,350,300);
        button4.setFont(new Font("Serif", Font.PLAIN, 24));
        button4.setBackground(darkGray);
        button4.setForeground(white);
        frame.add(button4);

        //Doctor Details Table
        button1.addActionListener(e -> {
            DoctorSortingTable createTable = new DoctorSortingTable();
            createTable.setSize(1500, 1000);
            createTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            createTable.setVisible(true);

        });
        //Patient doctor availability checking and booking
        button3.addActionListener(e -> {
            AddPatient addPatient = new AddPatient();
            addPatient.setSize(1500, 1000);
            addPatient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            addPatient.setVisible(true);
        });
        //Patient Details Table
        button4.addActionListener(e -> {
            PatientAllConsultationDetails doctorAppointmentTable = new PatientAllConsultationDetails();
            doctorAppointmentTable.setSize(1500, 1000);
            doctorAppointmentTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            doctorAppointmentTable.setVisible(true);

        });
        add(frame);
    }
}
