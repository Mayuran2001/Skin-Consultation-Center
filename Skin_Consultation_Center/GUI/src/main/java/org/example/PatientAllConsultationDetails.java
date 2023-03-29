package org.example;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import static java.awt.Color.black;
import static java.awt.Color.white;
import static java.awt.Font.BOLD;

public class PatientAllConsultationDetails extends JFrame {
    PatientAllConsultationDetails(){
        Container body = getContentPane();
        body.setLayout(null);

        JPanel frame = new JPanel();
        frame.setLayout(null);
        frame.setBounds(0, 0, 1500, 1000);

        // Patient all details table
        String[] columnsName = {"Patient Name", "Surname","DateOfBirth","MobileNumber", "NIC", "Doctor Name",
                "Doctor Id","Specialisation","Date","Start Time","Duration","cost"};

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
        jtable.setLayout(null);

        defaultTableModel.setColumnIdentifiers(columnsName);
        jtable.setModel(defaultTableModel);
        frame.add(jtable);

        JLabel tableHeadingName = new JLabel("Patient Details Table");
        tableHeadingName.setFont(new Font("Serif", BOLD, 24));
        tableHeadingName.setBounds(520, 30, 230, 30);
        frame.add(tableHeadingName);

        JLabel searchConsultation = new JLabel("Search Consultation");
        searchConsultation.setFont(new Font("Serif", BOLD, 24));
        searchConsultation.setBounds(200, 570, 230, 30);
        frame.add(searchConsultation);

        JLabel patientId = new JLabel("Patient NIC");
        patientId.setFont(new Font("Serif", Font.PLAIN, 20));
        patientId.setForeground(Color.BLACK);
        patientId.setBackground(Color.white);
        patientId.setBounds(100, 610, 150, 30);
        frame.add(patientId);

        JTextField textPatientId = new JTextField();
        textPatientId.setFont(new Font("Serif", Font.PLAIN, 16));
        textPatientId.setBounds(250, 610, 200, 30);
        frame.add(textPatientId);
        add(frame);

        JScrollPane jScrollPane = new JScrollPane(jtable);
        jScrollPane.setBounds(20,70,1330,500);
        frame.add(jScrollPane);

        JButton button1 = new JButton("Back");
        button1.setBounds(20,20,100,40);
        button1.setBackground(black);
        button1.setForeground(white);
        frame.add(button1);

        JButton button2 = new JButton("Submit");
        button2.setBounds(460,610,100,30);
        button2.setBackground(black);
        button2.setForeground(white);
        frame.add(button2);

        // Back button to the main menu
        button1.addActionListener(e -> {
            if(e.getActionCommand().equals("Back")){
                this.setVisible(false);
                new Menu().setVisible(true);
            }
        });

        updateTable(defaultTableModel, textPatientId, 1);
        add(frame);
        button2.addActionListener(e -> updateTable(defaultTableModel, textPatientId, 0));
    }

    private void updateTable(DefaultTableModel defaultTableModel, JTextField textPatientId, int mode) {
        defaultTableModel.setRowCount(0);
        for (int i = 0; i < PatientAvailabilityList.getInstance().getPatientAvailabilityArraylist().size(); i++) {
            Patient patient1 = PatientAvailabilityList.getInstance().getAvailabilityPatient(i);

            switch(mode) {
                case 0 -> {
                    if (patient1.getPatientId().equals(textPatientId.getText())) {
                        defaultTableModel.addRow(new Object[]{
                                patient1.getName(), patient1.getSurname(), patient1.getDateOfBirth(),
                                patient1.getMobileNumber(), patient1.getPatientId(), patient1.getDoctorName(),
                                patient1.getDoctorId(), patient1.getSpecialisation(), patient1.getDate(),
                                patient1.getStartTime(), patient1.getDuration(), patient1.getCost()
                        });
                    }
                }
                case 1 -> defaultTableModel.addRow(new Object[]{
                        patient1.getName(), patient1.getSurname(), patient1.getDateOfBirth(),
                        patient1.getMobileNumber(), patient1.getPatientId(), patient1.getDoctorName(),
                        patient1.getDoctorId(), patient1.getSpecialisation(), patient1.getDate(),
                        patient1.getStartTime(), patient1.getDuration(), patient1.getCost()
                });
            }
        }
    }
}
