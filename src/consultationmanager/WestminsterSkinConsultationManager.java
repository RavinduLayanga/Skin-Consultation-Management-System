package consultationmanager;


import GUI.Consultation;
import GUI.DoctorTable;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    private static ArrayList<Doctor> doctorsarray = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        WestminsterSkinConsultationManager wscm = new WestminsterSkinConsultationManager();

        boolean repeat = true;
        menuLoop:
        while (repeat) {

            System.out.print("\n\t\t----------------------WestminsterSkinConsultationManager-----------------------\n\n" +
                    "\t\t\t\t\t 01.Add Doctor.             \t\t\t 02.Delete Doctor.\n\n" +
                    "\t\t\t\t\t 03.Print List of Doctor.   \t\t\t 04.Save In File.\n\n" +
                    "\t\t\t\t\t 05.Load Data.              \t\t\t 07.GUI.\n\n" +
                    "\n\t\t Please Enter here your Choice :- ");
            String choice = sc.next();

            switch (choice) {
                case "1":
                case "01":
                    wscm.AddDoctor();
                    break;
                case "2":
                case "02":
                    wscm.DeleteDoctor();
                    break;
                case "3":
                case "03":
                    wscm.SortDoctorsList();
                    break;
                case "4":
                case "04":
                   wscm.printListOfDoctors();
                    wscm.SaveInFile();
                    break;
                case "5":
                case "05":
                    wscm.LoadFile();
                    break;
                case "6":
                case "06":
                    wscm.ReadFile();
                    break;
                case "7":
                case "07":
                    wscm.LoadFile();
                    //new DoctorTable(wscm).setVisible(true);
                    new Consultation().setVisible(true);
                    break;
                case "8":
                case "08":
                    System.out.println("Program end. Thank you.");
                    break menuLoop;

                default:
                    System.out.println("invalid Choice number check again ");
            }
        }


    }

    @Override
    public void AddDoctor() {
        System.out.println("\n\t\t-------------------Add Doctor----------------");
        /*validate username and sure name
        https://www.geeksforgeeks.org/how-to-validate-a-username-using-regular-expressions-in-java/
         */

        String regex = "^[A-Za-z]\\w{2,29}$";
        Pattern p = Pattern.compile(regex);
        //check doctor count less than or equal 10
        if (doctorsarray.size() <= 10) {
            String fname, sname, medlicences,specialisation, mobileNo;
            LocalDate dob = LocalDate.parse("2022-01-22");
            boolean valid = true;
            //getting inputs for first name and validate.
            do {
                System.out.print("Enter Doctor First Name  :- ");
                fname = sc.next().trim();
                Matcher fn = p.matcher(fname);
                if (fn.matches()) {
                    valid = false;
                } else {
                    System.out.println("\n** Please check name again.\n" +
                            "** Dont use any number or symbols for name.\n" +
                            "** Name should contain At least 3 Letters. ");
                }
            } while (valid);
            //getting inputs for second name and validate.
            valid = true;
            do {
                System.out.print("Enter Doctor Second Name :- ");
                sname = sc.next().trim();

                Matcher sn = p.matcher(sname);
                if (sn.matches()) {
                    valid = false;
                } else {
                    System.out.println("\n ** Please check Second Name again.\n" +
                            "** Dont use any number or symbols for name.\n" +
                            "** Name should contain At least 3 Letters. ");
                }
            } while (valid);
            //getting inputs for Date of birth and validate.
            valid = true;
            do {
                try{
                    System.out.print("Enter Doctor Date Of Birth. " +
                            "Please Use this format for Add date YYYY-MM-DD :-");
                    dob = LocalDate.parse(sc.next());
                    //Calculate doctor age is between 22 or 60.
                    LocalDate today = LocalDate.now();
                    int years = Period.between(dob, today).getYears();
                    if (years < 22 || years > 60) {
                        System.out.println("\n** Age must be between 22 to 60 years Please Check again.");
                    } else {
                        valid = false;
                    }
                }catch(Exception e){
                    System.out.println("\n** Invalid Date. Try Again...\n" +
                            "** Please use this format Add date YYYY-MM-DD eg:- 2022-02-05");
                }
            } while (valid);

            //getting inputs for mobile number and validate.
            valid=true;
            do{
                System.out.print("Enter Doctor Mobile Number :- ");
                mobileNo=Strinput().trim();
                boolean valid2=MobileNoValidator(mobileNo);
                if(valid2){
                    valid=false;
                }else{
                    System.out.println("\n** Entered phone number wrong.\n" +
                            "** Please enter mobile number in this format:- 0712566363");
                }
            }while(valid);

            //getting inputs for medical licence
            do {
                System.out.print("Enter Doctor Medical Licence No :- ");
                medlicences =Strinput().trim();

                valid = doctorsarray.size()!= 0;
                for (Doctor doctor : doctorsarray) {
                    if (doctor.getMedicalLicence().equals(medlicences)) {
                        System.out.println("\n** Entered Medical Licence Number Already Exist.\n" +
                                           "** Please Enter Correct Medical Licence Number.");
                    } else {
                        valid = false;
                    }
                }
            }while(valid);

            //getting inputs for specialisation.
            System.out.print("Enter Doctor Specialisation :- ");
            specialisation=Strinput().trim();

           //Add input data to arraylist
            doctorsarray.add(new Doctor(fname,sname,dob,mobileNo,medlicences,specialisation));
            System.out.println("Successfully added doctor.");
        }else{
            System.out.println("\n** Can't add Doctors anymore. only 10 doctors can added to the system.");
        }
    }

    public  ArrayList<Doctor> getDoctorsarray() {
        return doctorsarray;
    }
    public  Doctor getDoctor(int position) {
        return doctorsarray.get(position);
    }

    //method for get String Inputs
    public String Strinput(){
        Scanner newsc=new Scanner(System.in);
        return newsc.nextLine();
    }

    //method for validate mobile number
    public  boolean MobileNoValidator(String str){
        //[0-9]: then contains digits 0 to 9
        //{10} : for check 10 numbers
        Pattern mo = Pattern.compile("[0-9]{10}");
        //the matcher() method creates a matcher that will match the given input against this pattern
        Matcher match = mo.matcher(str);
        //returns a boolean value
        return (match.find() && match.group().equals(str));

    }

    //method for delete doctor
    @Override
    public void DeleteDoctor() {
        System.out.println("\n\t\t--------------------Delete Doctor-------------------\n\n\n" +
                "here is the list of doctor details");
        SortDoctorsList();
        boolean valid;
        String number;
        do{
            System.out.println("\nPlease enter doctors Medical licence number that want to delete :- ");
            number=Strinput().trim();
            valid = doctorsarray.size()!= 0;
            for (int i = 0; i< doctorsarray.size(); i++) {
                if (number.equals(doctorsarray.get(i).getMedicalLicence())){
                    System.out.println("\nDetails of Doctor want to remove.\n");
                    System.out.printf(" %-10s  %-10s  %-10s  %-13s  %-13s  %-15s %n", "First Name", "Sure Name", "Date of Birth","Mobile Number","Medical Licence","Specialisation");
                    System.out.printf(" %-10s  %-10s  %-10s  %-13s  %-13s  %-15s %n", doctorsarray.get(i).getName(), doctorsarray.get(i).getSureName(), doctorsarray.get(i).getDateOfBirth(), doctorsarray.get(i).getMobileNo(), doctorsarray.get(i).getMedicalLicence(), doctorsarray.get(i).getSpecialisation());
                    doctorsarray.remove(i);
                    if(doctorsarray.size()==1){
                        System.out.println("\nSuccessfully removed doctor details form system.\n" +
                                "Only one doctor remain in the System now.");
                        SortDoctorsList();
                    } else if (doctorsarray.size()>1) {
                        System.out.println("\nSuccessfully removed doctor details form system.\n" +
                                doctorsarray.size()+" Doctors are remain in the System now.");
                        SortDoctorsList();
                    }else{
                        System.out.println("\nSuccessfully removed doctor details form system.\n");
                        SortDoctorsList();
                    }
                    valid = false;
                    break;
                }else{
                    System.out.println("\n** Entered medical licence number wrong please check again.");
                }
            }
        }while(valid);

    }

    //method for print sorted doctor list
    public  void SortDoctorsList(){
        if(doctorsarray.size()!=0){
            ArrayList <Doctor> tempArray=new ArrayList<>();
            for(Doctor doctor: doctorsarray){
                tempArray.add(new Doctor(doctor.getName(), doctor.getSureName(),doctor.getDateOfBirth(), doctor.getMobileNo(), doctor.getMedicalLicence(), doctor.getSpecialisation()));
            }
            System.out.printf("\n %-10s  %-10s  %-10s  %-13s  %-13s  %-15s %n", "First Name", "Sure Name", "Date of Birth","Mobile Number","Medical Licence","Specialisation");
            tempArray.sort(Comparator.comparing(Person::getSureName));
            for(Doctor doctor: tempArray){
                System.out.printf("\n %-10s  ",doctor.getName());
                System.out.printf(" %-10s  ",doctor.getSureName());
                System.out.printf(" %-10s  ",doctor.getDateOfBirth());
                System.out.printf(" %-13s  ",doctor.getMobileNo());
                System.out.printf(" %-13s  ",doctor.getMedicalLicence());
                System.out.printf(" %-15s  ",doctor.getSpecialisation());
            }
        }else{
            System.out.println("No Doctors Exist in the system.");
        }
    }

    //method for print doctors details
    @Override
    public void printListOfDoctors() {
        if(doctorsarray.size()!=0){
            System.out.printf("\n %-10s  %-10s  %-10s  %-13s  %-13s  %-15s %n", "First Name", "Sure Name", "Date of Birth","Mobile Number","Medical Licence","Specialisation");
            for(Doctor doctor: doctorsarray){
                System.out.printf("\n %-10s  ",doctor.getName());
                System.out.printf(" %-10s  ",doctor.getSureName());
                System.out.printf(" %-10s  ",doctor.getDateOfBirth());
                System.out.printf(" %-13s  ",doctor.getMobileNo());
                System.out.printf(" %-13s  ",doctor.getMedicalLicence());
                System.out.printf(" %-15s  ",doctor.getSpecialisation());
            }
        }else{
            System.out.println("No Doctors Exist in the system.");
        }
    }

    //method for save data in file.
    @Override
    public void SaveInFile() {
        try {
            BufferedWriter writer  = new BufferedWriter(new FileWriter("Doctors Details.txt"));
            BufferedWriter fileWriter  = new BufferedWriter(new FileWriter("fileWriter.txt"));
            for (Doctor doctor : doctorsarray) {
                fileWriter.write(doctor.getName() + "\n" + doctor.getSureName() + "\n" + doctor.getDateOfBirth() + "\n" + doctor.getMobileNo() + "\n" + doctor.getMedicalLicence() + "\n" + doctor.getSpecialisation() + "\n\n");
            }
            for(int i = 0; i< doctorsarray.size(); i++) {
                writer.write("\n ------------- Doctor " + (i + 1) + " Details.-------------\n");
                writer.write("\n01.First Name      :- " + doctorsarray.get(i).getName());
                writer.write("\n02.Sure Name       :- " + doctorsarray.get(i).getSureName());
                writer.write("\n03.Date of Birth   :- " + doctorsarray.get(i).getDateOfBirth());
                writer.write("\n04.Mobile Number   :- " + doctorsarray.get(i).getMobileNo());
                writer.write("\n05.Medical Licence :- " + doctorsarray.get(i).getMedicalLicence());
                writer.write("\n06.Specialisation  :- " + doctorsarray.get(i).getSpecialisation());
            }
            System.out.println("Successfully store data in 'Doctors Details.txt' File ");
            writer.close();
            fileWriter.close();
        }catch (IOException e){
            System.out.println("Error. ");
        }

    }

    //method for read saved data from file.
    public void ReadFile(){
        try {
            String line ;
            BufferedReader bfReader  = new BufferedReader(new FileReader("Doctors Details.txt"));
            while ((line= bfReader.readLine()) != null){
                System.out.println(line);
            }
            bfReader.close();
        }catch (IOException e){
            System.out.println("Error. ");
        }
    }

    //method for load data from file.
    @Override
    public void LoadFile() {
        try {
            String line;
            ArrayList<String> loadList = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("fileWriter.txt"));
            while ((line = reader.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                } else {
                    loadList.add(line);
                }
            }
            if(loadList.size()==0){
                System.out.println("\nNO old data found!!!!! ");
            }
            while ( 0 < (loadList.size() / 6)) {
                if (doctorsarray.size() == 0) {
                    doctorsarray.add(new Doctor(loadList.get(0), loadList.get(1), LocalDate.parse(loadList.get(2)), loadList.get(3), loadList.get(4), loadList.get(5)));
                    loadList.subList(0, 6).clear();
                } else {
                    if (doctorsarray.size() <= 10) {
                        boolean valid = true;
                        for (Doctor doctor : doctorsarray) {
                            if (doctor.getMedicalLicence().equals(loadList.get(4))) {
                                valid = false;
                                loadList.subList(0, 6).clear();
                            } else {
                                valid = true;
                            }
                        }
                        if (valid) {

                            doctorsarray.add(new Doctor(loadList.get(0), loadList.get(1), LocalDate.parse(loadList.get(2)), loadList.get(3), loadList.get(4), loadList.get(5)));
                            loadList.subList(0, 6).clear();
                        }
                    }
                }
            }
            System.out.println("Successfully load details to the system.");
            reader.close();
        } catch (Exception e) {
            System.out.println("Something Wrong!");

        }

    }

}
