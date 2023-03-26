package GUI;

import consultationmanager.Patient;
import consultationmanager.WestminsterSkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Consultation extends JFrame {

    private JLabel title,name,sname,dob,mobileNo,id,costLbl,docName,docLicence,cDate,cTime,noteLbl;
    private JTextField txtName,txtSname,txtDob,txtMobileNo,txtId,costTxt;
    private JComboBox doctor,hour,minutes,getduration;
    private JTextArea note;

    public Consultation(){
        setSize(900,900);
        setTitle("Westminster Skin Consultation Manager");
        setDefaultCloseOperation(2);
        setLocationRelativeTo(null);

        JPanel main=new JPanel(new BorderLayout());

        //title panel---------------------------------------------------------------------
        JPanel Ptitle=new JPanel(new GridBagLayout());
        GridBagConstraints gbcTitle =new GridBagConstraints();
        title=new JLabel("Consultation");
        title.setFont(new Font("SansSerif",Font.CENTER_BASELINE,35));
        gbcTitle.insets=new Insets(150,100,100,300);
        Ptitle.add(title,gbcTitle);

        //details panel-----------------------------------------------------------------
        JPanel pDetails=new JPanel(new BorderLayout());
        //panel for add doctor details////////////////////////////////////////
        JPanel pDoc=new JPanel(new GridBagLayout());
        pDoc.setBorder(BorderFactory.createTitledBorder("Doctor Details"));
        GridBagConstraints gbc0 =new GridBagConstraints();
        gbc0.insets=new Insets(50,5,100,5);

        //doctor name label
        docName= new JLabel("Full Name ");
        docName.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc0.insets=new Insets(5,-580,5,200);
        gbc0.gridx=0;
        gbc0.gridy=0;
        pDoc.add(docName,gbc0);

        //doctor medical licence label
        docLicence= new JLabel("Medical Licence Number ");
        docLicence.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc0.insets=new Insets(5,-580,5,200);
        gbc0.gridx=0;
        gbc0.gridy=1;
        pDoc.add(docLicence,gbc0);

        //doctor date label
        cDate= new JLabel("Consult Date ");
        cDate.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc0.insets=new Insets(5,-580,5,200);
        gbc0.gridx=1;
        gbc0.gridy=0;
        pDoc.add(cDate,gbc0);

        //doctor consult time
        cTime= new JLabel("Consult Time ");
        cTime.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc0.insets=new Insets(5,-580,5,200);
        gbc0.gridx=1;
        gbc0.gridy=1;
        pDoc.add(cTime,gbc0);



        //panel for add patient details//////////////////////////////////////////////////////////
        JPanel pPatient=new JPanel(new GridBagLayout());
        pPatient.setBorder(BorderFactory.createTitledBorder("Patient Details"));
        pPatient.setPreferredSize(new Dimension(850,300));
        GridBagConstraints gbc =new GridBagConstraints();
        gbc.insets=new Insets(10,5,100,5);

        //name label
        name= new JLabel("First Name ");
        name.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc.insets=new Insets(-380,-600,100,120);
        gbc.gridx=0;
        gbc.gridy=0;
        pPatient.add(name,gbc);

        // name text field
        txtName=new JTextField(20);
        txtName.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc.insets=new Insets(-380,-300,100,80);
        gbc.gridx=1;
        gbc.gridy=0;
        pPatient.add(txtName,gbc);

        //sure name label
        sname= new JLabel("Second Name ");
        sname.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc.insets=new Insets(-380,-300,100,-400);
        gbc.gridx=2;
        gbc.gridy=0;
        pPatient.add(sname,gbc);

        //sure name text field
        txtSname=new JTextField(20);
        txtSname.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc.insets=new Insets(-380,120,100,-320);
        gbc.gridx=3;
        gbc.gridy=0;
        pPatient.add(txtSname,gbc);

        //bod label
        dob= new JLabel("Date of Birth ");
        dob.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc.insets=new Insets(-305,-590,85,120);
        gbc.gridx=0;
        gbc.gridy=1;
        pPatient.add(dob,gbc);

        //bod text field
        txtDob=new JTextField(20);
        txtDob.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc.insets=new Insets(-310,-300,80,80);
        gbc.gridx=1;
        gbc.gridy=1;
        pPatient.add(txtDob,gbc);

        //id label
        id= new JLabel("ID Number ");
        id.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc.insets=new Insets(-230,-590,70,130);
        gbc.gridx=0;
        gbc.gridy=2;
        pPatient.add(id,gbc);

        //id txtfield
        txtId=new JTextField(20);
        txtId.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc.insets=new Insets(-230,-300,70,80);
        gbc.gridx=1;
        gbc.gridy=2;
        pPatient.add(txtId,gbc);


        //mobile number label
        mobileNo= new JLabel("Mobile Number ");
        mobileNo.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc.insets=new Insets(-265,-300,70,-410);
        gbc.gridx=1;
        gbc.gridy=3;
        pPatient.add(mobileNo,gbc);

        //mobile number text field
        txtMobileNo=new JTextField(20);
        txtMobileNo.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc.insets=new Insets(-265,-110,70,-580);
        gbc.gridx=2;
        gbc.gridy=3;
        pPatient.add(txtMobileNo,gbc);





        //panel for add consultation details////////////////////////////////////////////////////
        JPanel pConslutation=new JPanel(new GridBagLayout());
        pConslutation.setBorder(BorderFactory.createTitledBorder("Consultation Details"));
        GridBagConstraints gbc2 =new GridBagConstraints();

        String[] hrs = { "Hour","08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20","21","22" };
        String[] min = { "Minutes","00", "15", "30", "45" };
        String[] duration = { "Hours","01", "02", "03", "04"};

        //Create combo box for consultation
        hour=new JComboBox(hrs);
        hour.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc2.gridx=0;
        gbc2.gridy=0;
        pConslutation.add(hour,gbc2);

        minutes=new JComboBox(min);
        minutes.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc2.gridx=0;
        gbc2.gridy=1;
        pConslutation.add(minutes,gbc2);


        getduration=new JComboBox(duration);
        getduration.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc2.gridx=0;
        gbc2.gridy=2;
        pConslutation.add(getduration,gbc2);



        costLbl= new JLabel("Cost ");
        costLbl.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc.gridx=0;
        gbc.gridy=4;
        pConslutation.add(costLbl,gbc2);

        costTxt=new JTextField(50);
        costTxt.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc.gridx=0;
        gbc.gridy=5;
        pConslutation.add(costTxt,gbc2);

        noteLbl=new JLabel("Special Note");
        noteLbl.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc.gridx=0;
        gbc.gridy=5;
        pConslutation.add(noteLbl,gbc2);

        note=new JTextArea(3,20);
        note.setFont(new Font("SansSerif",Font.PLAIN,14));
        gbc.gridx=0;
        gbc.gridy=5;
        pConslutation.add(note,gbc2);

        pDetails.add("North",pDoc);
        pDetails.add("Center",pPatient);
        pDetails.add("South",pConslutation);








        //button panel------------------------------------------------------------------------------
        JPanel pButton=new JPanel(new BorderLayout());
        //create buttons
        JButton submitButton=new JButton("Submit");
        submitButton.setFont(new Font("SansSerif",Font.PLAIN,16));
        //submitButton.setBounds(0,0,10,10);
        //back button
        JButton backButton=new JButton("Back");
        backButton.setFont(new Font("SansSerif",Font.PLAIN,16));
        //backButton.setBounds(10,0,10,10);
        //action listner for buttons
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(submitButton, "Data Saved Successfully");
            }
        });
        //add buttons to button panel
        pButton.add(submitButton);
        pButton.add(backButton);

        //add panels to main panel
        main.add("North",title);
        main.add("Center",pDetails);
        main.add("South",pButton);
        this.add(main);
        setVisible(true);

    }

    public static void main(String[] args) {
       new Consultation().setVisible(true);
    }

}
