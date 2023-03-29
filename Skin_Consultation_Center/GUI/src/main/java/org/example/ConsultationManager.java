package org.example;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.exit;
public class ConsultationManager implements WestminsterSkinConsultationManager{

    public static void main(String[] args) {
        ConsultationManager consultationManager = new ConsultationManager();

        //Console Menu
        while(true){
            try {
                Scanner input = new Scanner(System.in);
                System.out.println();
                System.out.println("----------Select one option --------------");
                System.out.println("1. Add new doctor");
                System.out.println("2. Delete a doctor");
                System.out.println("3. Print the list of the doctors");
                System.out.println("4. Save in a file");
                System.out.println("5. Load file");
                System.out.println("6. GUI");
                System.out.println("7. Exit");
                System.out.print("Select one number in menu options: ");
                int menu = input.nextInt();
                System.out.println();

                switch (menu) {
                    case 1 -> consultationManager.addDoctors();
                    case 2 -> consultationManager.deleteDoctor();
                    case 3 -> consultationManager.listOfTheDoctors();
                    case 4 -> consultationManager.fileWrite();
                    case 5 -> consultationManager.loadFile();
                    case 6 -> {
                        Menu frame = new Menu();
                        frame.setSize(1500,1000);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);
                    }
                    case 7 -> {
                        System.out.println("Exit program");
                        exit(0);
                    }
                    default -> System.out.println("Invalid integer");
                }
    }catch (Exception ex){
                System.out.println("Enter valid input! ");
                System.out.println();
            }
        }
    }
        //Name and surname error handling method
       public static String ValidateString(String userInput) {
           Pattern pattern = Pattern.compile("[a-zA-Z\\s]+");
           Matcher matcher = pattern.matcher(userInput);
           String space = " ";
           // Aggressive Mode
           if (!userInput.isEmpty() && !userInput.equals(space) && userInput.length() < 15 && matcher.matches()) {
               try {
                   Integer.parseInt(userInput);
                   throw new InputMismatchException("Invalid input!");
               } catch (NumberFormatException Ne) {
                   return userInput;
               } catch (InputMismatchException Re) {
                   throw new RuntimeException("Invalid input!");
               }
           } else {
               throw new RuntimeException("Input not allowed!");
           }
       }

       // Validate Input [Integer]
       public static int ValidateInteger(int userInput) {
           try {
               if (userInput > 0) {
                       return userInput;
               } else {
                   throw new RuntimeException("Input cannot be add!");
               }
           }catch (Exception Ex){
               throw new RuntimeException("Input not allowed!");
           }
       }

       // Specialisation Error handling method
       private static String ValidateString1(Scanner input){
           String userInput = input.next();
           String space = " ";
           try {
               if (!userInput.isEmpty() && !userInput.equals(space) && userInput.length()<30){
                   return userInput;
               } else {
                   throw new RuntimeException("Input not allowed!");
               }
           }catch (Exception Ex){
               throw new RuntimeException("Input not allowed!");
           }
       }

       //Date of birth error handling method
       private static String ValidateDateOfBirth(Scanner input) {
           SimpleDateFormat dateInput = new SimpleDateFormat("yyyy-MM-dd");
           String userInput = input.nextLine();
           try {
               // Validate date of birth length
               if (userInput.length() > 10) {throw new RuntimeException("Invalid date of birth");}

               // Parse year
               int year = Integer.parseInt(userInput.substring(0, 4));
               if (year > LocalDate.now().getYear()) {throw new RuntimeException("Date of birth cannot be higher than current year");}

               // Parse month
               int month = Integer.parseInt(userInput.substring(5, 7));
               if (month > 12 || month < 1) {throw new RuntimeException("Invalid month");}

               // Parse Date
               int date = Integer.parseInt(userInput.substring(8, 10));
               if (date > 31 || date < 1) {throw new RuntimeException("Invalid date");}

               Date dob = dateInput.parse(userInput);
               new SimpleDateFormat("yyyy-MM-dd").format(dob);
           } catch (Exception e) {
               throw new RuntimeException(e.getMessage());
           }
           return userInput;
       }

       //Mobile number error handling method
       private static String ValidateMobileNumber(Scanner input){
           String userInput = input.next();
           String space = " ";
           try {
               Integer.parseInt(userInput);
               if (!userInput.equals(space) && userInput.length() == 10) {
                   return userInput;
               } else {
                   throw new RuntimeException("Input not allowed!");
               }
           }catch (Exception Ex){
               throw new RuntimeException("Input not allowed!");
           }
       }

       //Add doctor method
       public void addDoctors(){
           Scanner input = new Scanner(System.in);
           System.out.print("Enter doctor name: ");
           String name = ValidateString(input.nextLine());

           System.out.print("Enter doctor surname: ");
           String surname = ValidateString(input.nextLine());

           System.out.print("Enter doctor dateOfBirth (yyyy/MM/dd): ");
           String dateOfBirth = ValidateDateOfBirth(input);

           System.out.print("Enter doctor mobile number: ");
           String mobileNumber = ValidateMobileNumber(input);

           System.out.print("Enter doctor medical number: (e.g. 12345):");
           int medicalNumber = ValidateInteger(input.nextInt());

           System.out.print("Enter doctor specialisation: (e.g. cosmeticDermatology, medicalDermatology, paediatricDermatology ):");
           String specialisation = ValidateString1(input);

           Doctor doctor = new Doctor(name,surname,dateOfBirth,mobileNumber,medicalNumber,specialisation);
           DoctorList.getInstance().addDoctor(medicalNumber,doctor);
       }

       //Delete doctor method
       public void deleteDoctor() {
           try {
               Scanner input = new Scanner(System.in);
               if (DoctorList.getInstance().getDoctorHashMap().isEmpty()) {
                   System.out.println("Empty,NO Doctor Available");
               } else {
                   System.out.print("Enter your license number: ");
                   int licenseNumber = input.nextInt();
                   if (DoctorList.getInstance().getDoctorHashMap().containsKey(licenseNumber)) {
                       DoctorList.getInstance().removeDoctor(licenseNumber);
                       System.out.println("Doctor remove successfully");
                   } else {
                       System.out.println("Enter a valid key! ");
                       deleteDoctor();
                   }
               }
           } catch (Exception ex) {
               System.out.println("Enter valid number! ");
               deleteDoctor();
           }
       }

       // use for sorting
    private static Doctor setDoctor(String name, String surname, String dob,
                                    Integer license, String specialisation, String phone) {
        return new Doctor(name, surname, dob, phone, license, specialisation);
    }

    //Sort by Surname
    public void listOfTheDoctors(){
        if (DoctorList.getInstance().getDoctorHashMap().isEmpty()) {
            System.out.println("Empty,NO Doctor Available");
        }else{
            LinkedList<Doctor> sorted = new LinkedList<>();
            ((Map<Integer, Doctor>) DoctorList.getInstance().getDoctorHashMap()).entrySet()
                    .stream()
                    .sorted(Comparator.comparing(o -> o.getValue().getSurname()))
                    .forEach((doctor) -> sorted.add(setDoctor(doctor.getValue().getName(), doctor.getValue().getSurname(),
                            doctor.getValue().getDateOfBirth(), doctor.getValue().getMedicalLicenceNumber(), doctor.getValue().getSpecialisation(),
                            doctor.getValue().getMobileNumber())));

            System.out.println("Ordered by surname: \n");
            for (Doctor doctor : sorted) {
                System.out.println(doctor.toString() + "\n");
            }
            System.out.println("\n");
        }
    }

    //Store program
    public void fileWrite() {
        //store program in to the file
        if (DoctorList.getInstance().getDoctorHashMap().isEmpty()) {
            System.out.println("Empty,NO Doctor Available");
        }else{
            try {
                File myObj = new File("filename.txt");
                System.out.println("File created : " + myObj.getName());
                FileWriter file = new FileWriter("data.txt");
                for (int i : DoctorList.getInstance().getDoctorHashMap().keySet()) {
                    if (DoctorList.getInstance().getDoctorHashMap().isEmpty()) {
                        file.write("Empty\n");
                    } else {
                        Doctor doctor1 = DoctorList.getInstance().getDoctor(i);
                        file.write(doctor1.getName() + "\n" + doctor1.getSurname() + "\n"
                                + doctor1.getDateOfBirth() + "\n" + doctor1.getMobileNumber() +
                                "\n" + doctor1.getMedicalLicenceNumber() + "\n" + doctor1.getSpecialisation() + "\n");
                    }
                }
                file.write("\n");
                file.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException ex) {
                System.out.println("An error occurred.");
                ex.printStackTrace();
            }
        }
    }

    //Load program
    public void loadFile() {
            try {
                File myObj = new File("data.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String currentLine = myReader.nextLine();
                    if (Objects.equals(currentLine, "")) {
                        break;
                    } else {
                        String name = currentLine;
                        String surname = myReader.nextLine();
                        String dateOfBirth = myReader.nextLine();
                        String mobileNumber = myReader.nextLine();
                        int medicalNumber = Integer.parseInt(myReader.nextLine());
                        String specialisation = myReader.nextLine();

                        Doctor doctor = new Doctor(name,surname,dateOfBirth,mobileNumber,medicalNumber,specialisation);
                        DoctorList.getInstance().addDoctor(medicalNumber,doctor);
                    }
                }
                myReader.close();
                System.out.println("Data Loaded Successfully.");
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Invalid input");
            }

    }
}


