package consultationmanager;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tester {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
       // System.out.printf("| %-15s | %-20s | %-20s | %-25s | %-25s | %-27s |%n", "First Name", "Sure Name", "Date of Birth","Mobile Number","Medical Licence","Specialisation");
        //System.out.printf("| %-15s | %-20s | %-20s | %-25s | %-25s | %-27s |%n"+doctor.getName()+doctor.getSureName()+doctor.getDateOfBirth()+doctor.getMobileNo()+doctor.getMedicalLicence()+doctor.getSpecialisation());

//        boolean valid2=true;
//        do{
//            System.out.println("gsfdjshghj");
//            String a= sc.nextLine();
//            boolean valid3=MobileNoValidator(a);
//            System.out.println(valid3);
//            if(valid3){
//                valid2=false;
//            }else{
//                System.out.println("Enterd phone number wrong.");
//            }
//
//        }while(valid2);
//
//    }
//    public static boolean MobileNoValidator(String str){
//        //(0/91): number starts with (0/91)
//        //[7-9]: starting of the number may contain a digit between 0 to 9
//        //[0-9]: then contains digits 0 to 9
//        Pattern mo = Pattern.compile("(0/91)?[0-9][0-9]{9}");
//        //the matcher() method creates a matcher that will match the given input against this pattern
//        Matcher match = mo.matcher(str);
//        //returns a boolean value
//        return (match.find() && match.group().equals(str));
//
//    }
//    public String Strinput(){
//            Scanner newsc=new Scanner(System.in);
//            return newsc.nextLine();
//        }
}
}
