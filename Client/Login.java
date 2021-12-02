package Client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Login extends JFrame {
    private final int WIDTH = 750;
    private final int HEIGHT = 250;
    private boolean Visibility;
    Client client = null;

    public Login() {
        setTitle("Client.Login Screen");

        // -- size of the frame: width, height
        setSize(WIDTH, HEIGHT);

        // -- center the frame on the screen
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // -- set the layout manager and add items
        // 5, 5 is the border around the edges of the areas
        setLayout(new BorderLayout(5, 5));
       FieldPanel con = new FieldPanel();
        this.add(con, BorderLayout.CENTER);


        BottomPanel low = new BottomPanel();
        this.add(low, BorderLayout.SOUTH);
        this.setVisible(true);
        Visibility = true;

    }
    private void SetVis(){
        this.setVisible(Visibility);
    }

    public class FieldPanel extends JPanel {

        //private JButton loadButton;
       private JLabel Us;
       private JTextField User;
       private JLabel pas;
        private JTextField Pass;
public FieldPanel(){
    setLayout(new FlowLayout(20,20,10));
Us = new JLabel("Username");
    User = new JTextField("", 20);
    pas = new JLabel("Password");
    Pass = new JTextField("", 20);


    this.add(Us);
    this.add(User);
    this.add(pas);
    this.add(Pass);
}


    }

    public class BottomPanel extends JPanel {
        private JButton Close;
        private JButton Log;
        private JButton Forgot;
        private JButton CreateA;
        private JButton Disconnect;
        private CreateAccount A;

        public BottomPanel(){

            Forgot = new JButton("Recover Password");
            Close = new JButton("Close");
            Log = new JButton("Client.Login");
            CreateA = new JButton("Create Account");
            Disconnect = new JButton("Disconnect");

            this.add(Forgot,BorderLayout.WEST,-1);
            this.add(Log);
            this.add(CreateA);
            this.add(Disconnect);
            this.add(Close);

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
            Forgot.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                }
            });

            // Log Button Action
            Log.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                }
            });

            // Help Button Action
            CreateA.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    Visibility = false;
                    SetVis();
                    A = new CreateAccount();

                }
            });

            Disconnect.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    client.disconnect();
           		client = null;
               	requestFocus();
                }
            });



        }



    }


    public static void main(String[] args) {
new Login();
    }
}