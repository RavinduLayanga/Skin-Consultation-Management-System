package GUI;

import consultationmanager.Doctor;
import consultationmanager.WestminsterSkinConsultationManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class DoctorTable extends JFrame {
    public DoctorTable(WestminsterSkinConsultationManager wcs){
        setSize(600,600);
        setTitle("Doctor Details");
        setDefaultCloseOperation(2);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        ArrayList <Doctor> tempArray=new ArrayList<>();
        for(int i=0;i<wcs.getDoctorsarray().size();i++){
            tempArray.add(wcs.getDoctor(i));
        }


        JScrollPane scrollPane=new JScrollPane(docArray(tempArray));
        JScrollPane scrollPane2=new JScrollPane(sortArray(tempArray));
        add("Center",scrollPane);

        JButton sortButton=new JButton("Sort");
        JButton exitButton=new JButton("Exit");

        //set action listener for sort button
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                remove(scrollPane);
                add("Center",scrollPane2);
                setVisible(true);

            }
        });

        //set action listener for exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        JPanel panel=new JPanel(new FlowLayout());
        panel.add(sortButton);
        panel.add(exitButton);
        add("South",panel);


    }
    private JTable docArray(ArrayList<Doctor> docArray){
        String[] col={"Name","Sure Name","Date of Birth","Mobile Number","Medical Licence","Specialisation"};
        String[][] raw=new String[docArray.size()][col.length];

        for (int i=0;i<docArray.size();i++){
            for(int j=0;j<col.length;j++){
                if(j==0){
                    raw[i][j]=docArray.get(i).getName();
                } else if (j==1) {
                    raw[i][j]=docArray.get(i).getSureName();
                }else if (j==2) {
                    raw[i][j] =String.valueOf(docArray.get(i).getDateOfBirth());
                }else if (j==3) {
                    raw[i][j] = docArray.get(i).getMobileNo();
                } else if (j==4) {
                    raw[i][j] = docArray.get(i).getMedicalLicence();
                }else {
                    raw[i][j]=docArray.get(i).getSpecialisation();
                }
            }
        }
        return new JTable(raw,col);
    }
    private JTable sortArray(ArrayList<Doctor> docArray){
        String[] col={"Name","Sure Name","Date of Birth","Mobile Number","Medical Licence","Specialisation"};
        String[][] raw=new String[docArray.size()][col.length];

        // Sort sure Names
        for(int i=0;i<docArray.size()-1;i++) {
            for (int j = i + 1; j < docArray.size(); j++) {
                //Compares Each Elements Of The Array To All The Remaining Elements
                if (docArray.get(i).getSureName().compareToIgnoreCase(docArray.get(j).getSureName()) > 0) {
                    //Swapping Array Elements
                    Doctor temp = docArray.get(i);
                    docArray.set(i, docArray.get(j));
                    docArray.set(j, temp);
                }
            }
        }


        for (int i=0;i<docArray.size();i++){
            for(int j=0;j<col.length;j++){
                if(j==0){
                    raw[i][j]=docArray.get(i).getName();
                } else if (j==1) {
                    raw[i][j]=docArray.get(i).getSureName();
                }else if (j==2) {
                    raw[i][j] =String.valueOf(docArray.get(i).getDateOfBirth());
                }else if (j==3) {
                    raw[i][j] = docArray.get(i).getMobileNo();
                } else if (j==4) {
                    raw[i][j] = docArray.get(i).getMedicalLicence();
                }else {
                    raw[i][j]=docArray.get(i).getSpecialisation();
                }
            }
        }

        return new JTable(raw,col);
    }
}
