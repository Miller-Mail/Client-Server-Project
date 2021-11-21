
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

public class Server extends JFrame {

    private final int WIDTH = 840;
    private final int HEIGHT = 450;

    public Server() {
        setTitle("Server");

        // -- size of the frame: width, height
        setSize(WIDTH, HEIGHT);

        // -- center the frame on the screen
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // -- set the layout manager and add items
        // 5, 5 is the border around the edges of the areas
        setLayout(new BorderLayout(15, 5));
        FieldPanel con = new FieldPanel();
        this.add(con, BorderLayout.CENTER);


        BottomPanel low = new BottomPanel();
        this.add(low, BorderLayout.SOUTH);

        // MENU Settings
        JMenuBar MenBar = new JMenuBar();
        JMenu Menu1 = new JMenu("Activate Server");
        JMenu Menu2 = new JMenu("Deactivate Server");
        JMenu Menu3 = new JMenu("Edit Config");


        MenBar.add(Menu1);
        MenBar.add(Menu2);
        MenBar.add(Menu3);


            // Activate Server
            Menu1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    System.exit(0);
                }
            });
            // Deactivate Server
            Menu2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                }
            });



        this.add(MenBar, BorderLayout.NORTH);


        JMenuBar MenBar2 = new JMenuBar();
        JMenu Menu4 = new JMenu("Number of Active Connections");
        JMenu Menu5 = new JMenu("Who is Logged in ");
        JMenu Menu6 = new JMenu("Number Logged in ");
        JMenu Menu7 = new JMenu("Number Registered");
        JMenu Menu8 = new JMenu("Who is Locked Out");


        MenBar2.add(Menu4);
        MenBar2.add(Menu5);
        MenBar2.add(Menu6);
        MenBar2.add(Menu7);
        MenBar2.add(Menu8);

        this.add(MenBar2, BorderLayout.SOUTH);

        setVisible(true);

    }


    public class FieldPanel extends JPanel {

        //private JButton loadButton;
       private TextArea Text;
        public FieldPanel(){
            setLayout(new FlowLayout(20,20,10));

            Text = new TextArea("Information Will be Displayed Here", 20,50);

            this.add(Text);


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
        new Server();
    }
}


