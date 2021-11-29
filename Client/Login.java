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
    private final int WIDTH = 470;
    private final int HEIGHT = 250;

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
        setVisible(true);

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
    User = new JTextField("", 10);
    pas = new JLabel("Password");
    Pass = new JTextField("", 10);


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
        private JButton Help;

        public BottomPanel(){

            Forgot = new JButton("Recover Password");
            Close = new JButton("Close");
            Log = new JButton("Client.Login");
            Help = new JButton("Help");

            this.add(Forgot,BorderLayout.WEST,-1);
            this.add(Log);
            this.add(Close);
            this.add(Help);

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
            Help.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                }
            });


        }



    }


    public static void main(String[] args) {
new Login();
    }
}