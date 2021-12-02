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

public class CreateAccountGUI extends JFrame {

    private final int WIDTH = 200;
    private final int HEIGHT = 400;

    public CreateAccountGUI() {
        setTitle("Create Account");

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
        private final JLabel Us;
        private final JTextField User;
        private final JLabel pas;
        private final JTextField Pass;
        private final JLabel em;
        private final JTextField email;
        private final JLabel repas;
        private final JTextField rePass;
        public FieldPanel(){
            setLayout(new FlowLayout(20,20,10));


            Us = new JLabel("Username");
            User = new JTextField("", 10);

            em = new JLabel ("Email");
            email = new JTextField("",10);


            pas = new JLabel("Password");
            Pass = new JTextField("", 10);
            repas = new JLabel("Re-enter Password");
            rePass = new JTextField("", 10);




            this.add(Us);
            this.add(User);
            this.add(em);
            this.add(email);
            this.add(pas);
            this.add(Pass);
            this.add(repas);
            this.add(rePass);

        }


    }

    public class BottomPanel extends JPanel {
        private final JButton Close;
        private final JButton Done;
        private LoginGUI L;


        public BottomPanel() {


            Close = new JButton("Exit");
            Done = new JButton("Create");

            this.add(Close);
            this.add(Done);

            PrepareButtons();
        }

        public void PrepareButtons() {

            // Close Button Action
            Close.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    dispose();
                    L = new LoginGUI();

                }
            });

            Done.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    System.exit(0);
                }
            });

        }
    }

        public static void main(String[] args) {
            new CreateAccountGUI();
        }
    }


