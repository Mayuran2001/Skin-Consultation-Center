package org.example;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;

import static java.awt.Color.*;
import static java.awt.Font.BOLD;


/**
 * @author Surendran Mayuran (Ph.D)
 */
public class DoctorSortingTable extends JFrame {
        JLabel l;
        JRadioButton radioButton1,radioButton2,radioButton3;
        JButton button,button1;
        public DoctorSortingTable() {
        String[] columnsName = {"Name", "Surname", "Date of Birth", "Mobile Number", "Medical Number", "Specialisation"};


        Container body = getContentPane();
        body.setLayout(null);

        JPanel frame = new JPanel();
        frame.setLayout(null);
        frame.setBounds(0, 0, 1500, 1000);
        frame.setBackground(gray);

        // Create a table
        DefaultTableModel defaultTableModel = new DefaultTableModel() {

            // Set cell editable to false - cannot modify its data
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable jtable = new JTable(defaultTableModel);
        jtable.setFont(new Font("Serif", Font.PLAIN, 17));
        jtable.setBackground(Color.lightGray);
        jtable.getTableHeader().setFont( new Font( "Arial" , Font.PLAIN, 18 ));
        jtable.setAlignmentX(Component.CENTER_ALIGNMENT);
        jtable.setLayout(null);


        defaultTableModel.setColumnIdentifiers(columnsName);

        jtable.setModel(defaultTableModel);
        frame.add(jtable);

        JLabel tableHeadingName = new JLabel("Doctor Details Table");
        tableHeadingName.setFont(new Font("Serif", BOLD, 24));
        tableHeadingName.setBounds(650, 35, 230, 30);
        frame.add(tableHeadingName);

        JScrollPane jScrollPane = new JScrollPane(jtable);
        jScrollPane.setBounds(250,70,1000,600);
        frame.add(jScrollPane);

        Object[] row = new Object[6];
        for (int i : DoctorList.getInstance().getDoctorHashMap().keySet()) {
            Doctor doctor1 = DoctorList.getInstance().getDoctor(i);
            row[0] = doctor1.getName();
            row[1] = doctor1.getSurname();
            row[2] = doctor1.getDateOfBirth();
            row[3] = doctor1.getMobileNumber();
            row[4] = doctor1.getMedicalLicenceNumber();
            row[5] = doctor1.getSpecialisation();

            defaultTableModel.addRow(row);
        }
        Color color1 = new Color(202, 207, 210 );
        l=new JLabel("Sorting Doctor information");
        l.setBounds(30,150,300,20);
        l.setFont(new Font("Serif", Font.PLAIN, 18));
        radioButton1=new JRadioButton("Name");
        radioButton1.setBounds(80,180,120,20);
        radioButton1.setBackground(color1);
        radioButton1.setFont(new Font("Serif", Font.PLAIN, 16));

        radioButton2=new JRadioButton("Surname");
        radioButton2.setBounds(80,210,120,20);
        radioButton2.setBackground(color1);
        radioButton2.setFont(new Font("Serif", Font.PLAIN, 16));

        radioButton3=new JRadioButton("Specialization");
        radioButton3.setBounds(80,240,120,20);
        radioButton3.setBackground(color1);
        radioButton3.setFont(new Font("Serif", Font.PLAIN, 16));

        button=new JButton("Submit");
        button.setBounds(50,270,80,30);
        button.setBackground(black);
        button.setForeground(white);

        button1=new JButton("Back");
        button1.setBounds(20,20,100,30);
        button1.setBackground(black);
        button1.setForeground(white);
        add(button1);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);

        button.addActionListener(e -> {
            if(radioButton1.isSelected() && !radioButton2.isSelected() || !radioButton3.isSelected()){
                ((DefaultTableModel)jtable.getModel()).setRowCount(0);
                LinkedList<Doctor> sorted = sortingName();

                Object[] row1 = new Object[6];
                for (Doctor doctor1 : sorted) {
                    row1[0] = doctor1.getName();
                    row1[1] = doctor1.getSurname();
                    row1[2] = doctor1.getDateOfBirth();
                    row1[3] = doctor1.getMobileNumber();
                    row1[4] = doctor1.getMedicalLicenceNumber();
                    row1[5] = doctor1.getSpecialisation();

                    defaultTableModel.addRow(row1);
                }
            } else if (radioButton2.isSelected() && !radioButton1.isSelected() || !radioButton3.isSelected()) {
                ((DefaultTableModel)jtable.getModel()).setRowCount(0);
                LinkedList<Doctor> sorted = sortingSurname();

                Object[] row1 = new Object[6];
                for (Doctor doctor1 : sorted) {
                    row1[0] = doctor1.getName();
                    row1[1] = doctor1.getSurname();
                    row1[2] = doctor1.getDateOfBirth();
                    row1[3] = doctor1.getMobileNumber();
                    row1[4] = doctor1.getMedicalLicenceNumber();
                    row1[5] = doctor1.getSpecialisation();

                    defaultTableModel.addRow(row1);
                }
            } else if (radioButton3.isSelected() && !radioButton1.isSelected() || !radioButton2.isSelected()) {
                ((DefaultTableModel)jtable.getModel()).setRowCount(0);
                LinkedList<Doctor> sorted = sortingSpecialization();

                Object[] row1 = new Object[6];
                for (Doctor doctor1 : sorted) {
                    row1[0] = doctor1.getName();
                    row1[1] = doctor1.getSurname();
                    row1[2] = doctor1.getDateOfBirth();
                    row1[3] = doctor1.getMobileNumber();
                    row1[4] = doctor1.getMedicalLicenceNumber();
                    row1[5] = doctor1.getSpecialisation();

                    defaultTableModel.addRow(row1);
                }
            }
        });

        //back button to the menu
        button1.addActionListener(e -> {
            if(e.getActionCommand().equals("Back")){
                this.setVisible(false);
                new Menu().setVisible(true);
            }
        });
        add(l);add(radioButton1);add(radioButton2);add(radioButton3);add(button);

        add(frame);
    }

    // doctor name sorting by name
    public LinkedList<Doctor> sortingName(){
        LinkedList<Doctor> sorted = new LinkedList<>();
        ((Map<Integer, Doctor>) DoctorList.getInstance().getDoctorHashMap()).entrySet()
                .stream()
                .sorted((Comparator.comparing(o -> o.getValue().getName())))
                .forEach((doctor) -> sorted.add(setDoctor(doctor.getValue().getName(), doctor.getValue().getSurname(),
                        doctor.getValue().getDateOfBirth(), doctor.getValue().getMedicalLicenceNumber(),
                        doctor.getValue().getSpecialisation(), doctor.getValue().getMobileNumber())));
        return sorted;
    }

    // doctor name sorting by surname
    public LinkedList<Doctor> sortingSurname(){
        LinkedList<Doctor> sorted = new LinkedList<>();
        ((Map<Integer, Doctor>) DoctorList.getInstance().getDoctorHashMap()).entrySet()
                .stream()
                .sorted(Comparator.comparing(o -> o.getValue().getSurname()))
                .forEach((doctor) -> sorted.add(setDoctor(doctor.getValue().getName(), doctor.getValue().getSurname(),
                        doctor.getValue().getDateOfBirth(), doctor.getValue().getMedicalLicenceNumber(), doctor.getValue().getSpecialisation(),
                        doctor.getValue().getMobileNumber())));
        return sorted;
    }

    // doctor name sorting by specialisation
    public LinkedList<Doctor> sortingSpecialization() {
        LinkedList<Doctor> sorted = new LinkedList<>();
        ((Map<Integer, Doctor>) DoctorList.getInstance().getDoctorHashMap()).entrySet()
                .stream()
                .sorted((Comparator.comparing(o -> o.getValue().getSpecialisation())))
                .forEach((doctor) -> sorted.add(setDoctor(doctor.getValue().getName(), doctor.getValue().getSurname(),
                        doctor.getValue().getDateOfBirth(), doctor.getValue().getMedicalLicenceNumber(),
                        doctor.getValue().getSpecialisation(), doctor.getValue().getMobileNumber())));
        return sorted;
    }
    private Doctor setDoctor(String name, String surname, String dob,
                             Integer license, String specialisation, String phone) {
        return new Doctor(name, surname, dob, phone, license, specialisation);
    }
}