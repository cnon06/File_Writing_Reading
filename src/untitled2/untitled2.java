package untitled2;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class untitled2 extends JFrame

{
    static String fileName = "sample.txt", outcome="";
    JTextField jtf1;
    JLabel jl1;

    untitled2()
    {


        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        //setLayout(null);

        JPanel jp1 = new JPanel();
        jp1.setLocation(0,0);
        jp1.setSize(getSize());
        jp1.setLayout(null);
        //jp1.setLayout();
        add(jp1);

        JButton jb1 = new JButton("Read");
        jb1.setSize(80,30);
        jb1.setLocation(10,10);
        
        jb1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                try(FileReader fileReader = new FileReader( fileName)) {
                    int ch = fileReader.read();
                    while(ch != -1) {


                        outcome+=(char)ch;

                        ch = fileReader.read();
                    }
                } catch (Exception etr) {
                    System.out.println(etr);
                }
               jl1.setText(outcome);
                outcome="";

            }
        });

        jp1.add(jb1);


        JButton jb2 = new JButton("Write");
        jb2.setSize(80,30);
        jb2.setLocation(100,10);

        jb2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                try(FileWriter fileWriter = new FileWriter( fileName)) {

                    String fileContent = jtf1.getText();
                    fileWriter.write(fileContent);
                } catch (IOException ej) {
                    
                }

            }
        });
        
        jp1.add(jb2);



        jtf1 = new JTextField("Income");
        jtf1.setSize(200,30);
        jtf1.setLocation(10,50);
        jp1.add(jtf1);

        jl1 = new JLabel("Outcome");
        jl1.setSize(200,30);
        jl1.setLocation(10,80);
        jl1.setVisible(true);
        jp1.add(jl1);

        
        

setVisible(true);

    }



    public static void main(String [] args)
    {
        new untitled2();
    }

}
