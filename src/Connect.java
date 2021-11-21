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

public class Connect extends JFrame {

    private final int WIDTH = 740;
    private final int HEIGHT = 250;

    public Connect() {
        setTitle("Connect");

        // -- size of the frame: width, height
        setSize(WIDTH, HEIGHT);

        // -- center the frame on the screen
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // -- set the layout manager and add items
        // 5, 5 is the border around the edges of the areas
        setLayout(new BorderLayout(15, 5));
        DataPanel x = new DataPanel();
      //  x.setLayout(new BoxLayout(x,BoxLayout.Y_AXIS));
        this.add(x, BorderLayout.CENTER);

        BottomPanel y = new BottomPanel();
        this.add(y,BorderLayout.SOUTH);
        setVisible(true);
    }

    public class DataPanel extends JPanel{
        private JLabel I;
        private JTextField IP;
        private JButton Adv;
        private JLabel Portn;
        private JTextField portnum;

        DataPanel(){
           setLayout(new FlowLayout(1,1,1));


            I = new JLabel("HostName");
            IP = new JTextField("", 25);

            Portn = new JLabel ("Port Number");
            portnum = new JTextField("",10);



            Adv= new JButton("Advanced...");

            this.add(I);
            this.add(IP);
            this.add(Portn);
            this.add(portnum);
            this.add(Adv);


        }


    }

    public class BottomPanel extends JPanel {
        private JButton Connect;
        private JButton Close;


        public BottomPanel() {


            Connect = new JButton("Connect");
            Close = new JButton("Close");

            this.add(Connect);
            this.add(Close);

            PrepareButtons();
        }
        public void PrepareButtons(){
            //Action Handlers here
        }

    }






    public static void main(String[] args) {
        new Connect();
    }
}

