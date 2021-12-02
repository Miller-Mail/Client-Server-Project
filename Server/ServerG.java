package Server;

import java.awt.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
//import Server.java;


public class ServerG extends JFrame {

    private final int WIDTH = 680;
    private final int HEIGHT = 450;
    private ServerG owner = null;

    private Server server;
    private BottomPanel low;
    private FieldPanel con;

    public ServerG() {
        setTitle("Server");

        // -- size of the frame: width, height
        setSize(WIDTH, HEIGHT);

        // -- center the frame on the screen
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // -- set the layout manager and add items
        // 5, 5 is the border around the edges of the areas
        setLayout(new BorderLayout(15, 5));
         con = new FieldPanel();
        this.add(con, BorderLayout.CENTER);


         low = new BottomPanel();
        this.add(low, BorderLayout.SOUTH);

        // MENU Settings
        JMenuBar MenBar = new JMenuBar();
        JButton Act = new JButton("Activate Surver");
      //  JButton DeAct = new JButton("Deactivate Server");
        JButton Conf = new JButton("Edit Config");
        JButton AConnect = new JButton("Number of Active Connections");


       // MenBar.add(Menu1);
        MenBar.add(Act);
       // MenBar.add(DeAct);
        MenBar.add(Conf);
        MenBar.add(AConnect);


            // Activate Server
            Act.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    server = new Server(owner);
                        server.start();
                        server.stop();
                        requestFocus();


                    }


            });
            // Deactivate Server
//            DeAct.addActionListener(new ActionListener(){
//                @Override
//                public void actionPerformed(ActionEvent e) {
//
//                }
//
//            });
// Config File Button
        Conf.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });


        AConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(server);
                int p = server.getconnections();
                addToTextArea(p + "");
                requestFocus();
            }

        });



        this.add(MenBar, BorderLayout.NORTH);


        JMenuBar MenBar2 = new JMenuBar();
        JButton WhoLog = new JButton("Who is Logged in ");
        JButton NumLog = new JButton("Number Logged in ");
        JButton NumReg = new JButton("Number Registered");
        JButton WhoLock = new JButton("Who is Locked Out");


        MenBar2.add(WhoLog);
        MenBar2.add(NumLog);
        MenBar2.add(NumReg);
        MenBar2.add(WhoLock);



        this.add(MenBar2, BorderLayout.SOUTH);

        setVisible(true);

    }
    public void addToTextArea(String s)
  {
    	con.addToTextArea(s);
   }



    public class FieldPanel extends JPanel {

        //private JButton loadButton;
       private TextArea Text;
        public FieldPanel(){
            setLayout(new FlowLayout(20,20,10));

            Text = new TextArea("Information Will be Displayed Here", 20,50);

            this.add(Text);




        }
        public void addToTextArea(String x){
            Text.setText("");
            Text.append("SERVER receive: " + x + "\n");
        }



    }

    public class BottomPanel extends JPanel {
        private JButton Close;
        private JButton Done;


        public BottomPanel(){


            Close = new JButton("Exit");
            Done = new JButton("Create");




            this.add(Close);
            this.add(Done);

            PrepareButtons();
        }


        public void PrepareButtons(){

            // Close Button Action
            Close.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    System.exit(0);
                }
            });

            // Forgot Button Action
            Done.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                }
            });
        }

    }


    public static void main(String[] args) {
        new ServerG();
    }
}


