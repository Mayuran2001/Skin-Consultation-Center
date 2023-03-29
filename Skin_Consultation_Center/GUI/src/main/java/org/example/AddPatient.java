package org.example;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.EOFException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.awt.Color.black;
import static java.awt.Color.white;
import static java.awt.Font.BOLD;


public class AddPatient extends JFrame {

    public AddPatient() {
        Container body = getContentPane();
        body.setLayout(null);

        JPanel frame = new JPanel();
        frame.setLayout(null);
        frame.setBounds(0, 0, 1500, 1000);

        //Patient information

        JLabel heading = new JLabel("Book Consultation");
        heading.setFont(new Font("Serif", Font.PLAIN, 24));
        heading.setForeground(Color.BLACK);
        heading.setBackground(Color.white);
        heading.setBounds(160, 75, 250, 40);
        frame.add(heading);

        JLabel date = new JLabel("Appointment Date");
        date.setFont(new Font("Serif", Font.PLAIN, 18));
        date.setForeground(Color.BLACK);
        date.setBackground(Color.white);
        date.setBounds(50, 130, 150, 30);
        frame.add(date);

        //User Date get
        DatePickerSettings settings = new DatePickerSettings();
        DatePicker datePicker = new DatePicker(settings);
        LocalDate currentDate = LocalDate.now();
        settings.setDateRangeLimits(currentDate, currentDate.plusDays(365));

        datePicker.setFont(new Font("Serif", Font.PLAIN, 16));
        datePicker.setBounds(190, 130, 200, 30);
        frame.add(datePicker);
        add(frame);

        JLabel startTime = new JLabel("Start Time");
        startTime.setFont(new Font("Serif", Font.PLAIN, 18));
        startTime.setForeground(Color.BLACK);
        startTime.setBackground(Color.white);
        startTime.setBounds(50, 175, 150, 30);
        frame.add(startTime);

        //User Time Get
        TimePickerSettings startTimeSettings = new TimePickerSettings();
        startTimeSettings.use24HourClockFormat();
        TimePicker patientAppointmentStartTime = new TimePicker(startTimeSettings);

        patientAppointmentStartTime.setFont(new Font("Serif", Font.PLAIN, 16));
        patientAppointmentStartTime.setBounds(190, 175, 200, 30);
        frame.add(patientAppointmentStartTime);
        add(frame);

        JLabel durationLbl = new JLabel("Duration (Hr)");
        durationLbl.setFont(new Font("Serif", Font.PLAIN, 18));
        durationLbl.setForeground(Color.BLACK);
        durationLbl.setBackground(Color.white);
        durationLbl.setBounds(50, 215, 150, 30);
        frame.add(durationLbl);

        // combo box for get consultation duration time
        JComboBox<Integer> duration = new JComboBox<>();
        for (int i = 30; i < 330; i += 30) {
            duration.addItem(i);
        }

        duration.setFont(new Font("Serif", Font.PLAIN, 16));
        duration.setBounds(190, 215, 200, 30);
        frame.add(duration);
        add(frame);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Serif", Font.PLAIN, 18));
        name.setForeground(Color.BLACK);
        name.setBackground(Color.white);
        name.setBounds(50, 255, 150, 30);
        frame.add(name);

        JTextField textName = new JTextField();
        textName.setFont(new Font("Serif", Font.PLAIN, 16));
        textName.setBounds(190, 255, 200, 30);
        frame.add(textName);

        JLabel surname = new JLabel("Surname");
        surname.setFont(new Font("Serif", Font.PLAIN, 18));
        surname.setForeground(Color.BLACK);
        surname.setBackground(Color.white);
        surname.setBounds(50, 295, 150, 30);
        frame.add(surname);

        JTextField textSurname = new JTextField();
        textSurname.setFont(new Font("Serif", Font.PLAIN, 16));
        textSurname.setBounds(190, 295, 200, 30);
        frame.add(textSurname);

        JLabel dateOfBirth = new JLabel("Date Of Birth");
        dateOfBirth.setFont(new Font("Serif", Font.PLAIN, 18));
        dateOfBirth.setForeground(Color.BLACK);
        dateOfBirth.setBackground(Color.white);
        dateOfBirth.setBounds(50, 335, 150, 30);
        frame.add(dateOfBirth);

        JTextField textDateOfBirth = new JTextField();
        textDateOfBirth.setFont(new Font("Serif", Font.PLAIN, 16));
        textDateOfBirth.setBounds(190, 335, 200, 30);
        frame.add(textDateOfBirth);

        JLabel mobileNumber = new JLabel("Mobile number");
        mobileNumber.setFont(new Font("Serif", Font.PLAIN, 18));
        mobileNumber.setForeground(Color.BLACK);
        mobileNumber.setBackground(Color.white);
        mobileNumber.setBounds(50, 375, 150, 30);
        frame.add(mobileNumber);

        JTextField textMobileNumber = new JTextField();
        textMobileNumber.setFont(new Font("Serif", Font.PLAIN, 16));
        textMobileNumber.setBounds(190, 375, 200, 30);
        frame.add(textMobileNumber);

        JLabel patientId = new JLabel("Patient NIC");
        patientId.setFont(new Font("Serif", Font.PLAIN, 18));
        patientId.setForeground(Color.BLACK);
        patientId.setBackground(Color.white);
        patientId.setBounds(50, 415, 150, 30);
        frame.add(patientId);

        JTextField textPatientId = new JTextField();
        textPatientId.setFont(new Font("Serif", Font.PLAIN, 16));
        textPatientId.setBounds(190, 415, 200, 30);
        frame.add(textPatientId);
        add(frame);

        JButton jSubmit = new JButton("Submit");
        jSubmit.setFont(new Font("Serif", Font.PLAIN, 18));
        jSubmit.setForeground(Color.BLACK);
        jSubmit.setBackground(Color.gray);
        jSubmit.setBounds(160, 470, 100, 40);
        frame.add(jSubmit);

        // Back to the menu
        JButton button1 = new JButton("Back");
        button1.setBounds(10, 10, 100, 30);
        button1.setBackground(black);
        button1.setForeground(white);
        frame.add(button1);

        button1.addActionListener(e -> {
            if (e.getActionCommand().equals("Back")) {
                this.setVisible(false);
                new Menu().setVisible(true);
            }
        });

        // Table to show the consultation booking patient details
        String[] columnsName = {"PatientName", "Date", "AppointmentTime", " Duration", "DoctorName"};

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
        jtable.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 18));
        jtable.setLayout(null);

        defaultTableModel.setColumnIdentifiers(columnsName);
        jtable.setModel(defaultTableModel);
        frame.add(jtable);

        JLabel tableHeadingName = new JLabel("Doctor Details Table");
        tableHeadingName.setFont(new Font("Serif", BOLD, 24));
        tableHeadingName.setBounds(800, 35, 230, 30);
        frame.add(tableHeadingName);

        JScrollPane jScrollPane = new JScrollPane(jtable);
        jScrollPane.setBounds(500, 70, 800, 500);
        frame.add(jScrollPane);

        jSubmit.addActionListener(e -> {
            try {
                String patientName = ValidateString(textName.getText());
                String patientSurname = ValidateString(textSurname.getText());
                String patientDOB = ValidateDateOfBirth(textDateOfBirth.getText());
                String patientContact = ValidateMobileNumber(textMobileNumber.getText());
                String patientNIC = textPatientId.getText();

                if (patientNIC.length() < 12) {throw new RuntimeException("NIC length should be greater than 12!");}
                LocalDate startDate = datePicker.getDate();
                LocalTime appointmentStartTime = patientAppointmentStartTime.getTime();

                if (!textName.getText().isEmpty() && !textSurname.getText().isEmpty() && !textDateOfBirth.getText().isEmpty()
                        && !textMobileNumber.getText().isEmpty() && !datePicker.getText().isEmpty() &&
                        !patientAppointmentStartTime.getText().isEmpty() && !textPatientId.getText().isEmpty()) {
                    long appointmentDuration = Long.parseLong(Objects.requireNonNull(duration.getSelectedItem()).toString());

                    // cost calculated method
                    int cost = (int) Consultation.getCost(appointmentStartTime, appointmentDuration, patientNIC);

                    Doctor doctor;
                    Set<Integer> keys = DoctorList.getInstance().getDoctorHashMap().keySet();
                    int count = 0;
                    while (true) {
                        int number = PatientAvailabilityList.getInstance().generateRandomNumber(keys.size());
                        doctor = PatientAvailabilityList.getInstance().getDoctorByIndex(number);
                        if (!PatientAvailabilityList.getInstance().isConsultationExists(doctor, startDate,
                                appointmentStartTime, appointmentDuration)) {

                            // Add consultation
                            Patient patient = new Patient(patientName, patientSurname, patientDOB, patientContact,
                                    patientNIC, doctor.getName(), doctor.getMedicalLicenceNumber(),
                                    doctor.getSpecialisation(), startDate, appointmentStartTime,
                                    appointmentDuration, cost);
                            PatientAvailabilityList.getInstance().addPatient(patient);
                            break;
                        } else if (count == keys.size()) {
                            throw new EOFException();
                        } else {
                            count++;
                        }
                    }

                    JOptionPane.showMessageDialog(null, String.format("""
                                                     Doctor Information
                                             
                                    Doctor name            : %s
                                    Doctor surname         : %s
                                    Doctor specialisation  : %s
                                                       
                                    Appointment start date : %s
                                    Appointment start time : %s
                                    Appointment duration   : %s Minutes
                                    Appointment Cost       : %d
                                    """, doctor.getName(), doctor.getSurname(), doctor.getSpecialisation(),
                            startDate.toString(), appointmentStartTime, appointmentDuration, cost));

                    textName.setText("");
                    textSurname.setText("");
                    textDateOfBirth.setText("");
                    textMobileNumber.setText("");
                    textPatientId.setText("");
                    datePicker.setText("");
                    patientAppointmentStartTime.setText("");

                    defaultTableModel.setRowCount(0);
                    Object[] row = new Object[5];
                    for (int i = 0; i < PatientAvailabilityList.getInstance().getPatientAvailabilityArraylist().size(); i++) {
                        Patient patient1 = PatientAvailabilityList.getInstance().getAvailabilityPatient(i);
                        row[0] = patient1.getName();
                        row[1] = patient1.getDate();
                        row[2] = patient1.getStartTime();
                        row[3] = patient1.getDuration();
                        row[4] = patient1.getDoctorName();

                        defaultTableModel.addRow(row);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Patient Details Cannot Empty");
                }
            } catch (EOFException eof) {
                JOptionPane.showMessageDialog(null, "No doctor available at the moment!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        add(frame);
    }

    // Text Field string error handling method
    private String ValidateString(String string) {
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+");
        Matcher matcher = pattern.matcher(string);
        String space = " ";

        // Aggressive Mode
        if (!string.isEmpty() && !string.equals(space) && string.length() < 15 && matcher.matches()) {
            try {
                Integer.parseInt(string);
                throw new InputMismatchException("Invalid input!");
            } catch (NumberFormatException Ne) {
                return string;
            } catch (InputMismatchException Re) {
                throw new RuntimeException("Invalid input!");
            }
        } else {
            throw new RuntimeException("Input not allowed!");
        }
    }

    // Date of birth error handling method
    private static String ValidateDateOfBirth(String userInput) throws java.text.ParseException {
        SimpleDateFormat dateInput = new SimpleDateFormat("yyyy-MM-dd");

        // Validate date of birth length
        if (userInput.length() > 10) {
            throw new RuntimeException("Invalid date of birth");
        }

        // Parse year
        int year = Integer.parseInt(userInput.substring(0, 4));
        if (year > LocalDate.now().getYear()) {
            throw new RuntimeException("Date of birth cannot be higher than current year");
        }

        // Parse month
        int month = Integer.parseInt(userInput.substring(5, 7));
        if (month > 12 || month < 1) {
            throw new RuntimeException("Invalid month");
        }

        // Parse Date
        int date = Integer.parseInt(userInput.substring(8, 10));
        if (date > 31 || date < 1) {
            throw new RuntimeException("Invalid date");
        }

        Date dob = dateInput.parse(userInput);
        new SimpleDateFormat("yyyy-MM-dd").format(dob);

        return userInput;
    }

    // Mobile Number Error handling method
    private static String ValidateMobileNumber(String userInput) throws NumberFormatException {
        String space = " ";
        int input = Integer.parseInt(userInput);
        if (!userInput.equals(space) && userInput.length() == 10) {
            return userInput;
        } else {
            throw new RuntimeException("Input not allowed!");
        }
    }
}
