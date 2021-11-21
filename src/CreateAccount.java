
import javax.swing.*;
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class CreateAccount extends JFrame {

    private final int WIDTH = 200;
    private final int HEIGHT = 400;

    public CreateAccount() {
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
        private JLabel Us;
        private JTextField User;
        private JLabel pas;
        private JTextField Pass;
        private JLabel em;
        private JTextField email;
        private JLabel repas;
        private JTextField rePass;
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
        private JButton Close;
        private JButton Done;


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
                    System.exit(0);
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
            new CreateAccount();
        }
    }


