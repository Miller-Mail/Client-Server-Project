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



public class ConnectGUI extends JFrame {

    private final int WIDTH = 740;
    private final int HEIGHT = 250;
    Client client = null;
    DataPanel Data;

    public ConnectGUI() {
        setTitle("Client.Connect");

        // -- size of the frame: width, height
        setSize(WIDTH, HEIGHT);

        // -- center the frame on the screen
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // -- set the layout manager and add items
        // 5, 5 is the border around the edges of the areas
        setLayout(new BorderLayout(15, 5));
        Data = new DataPanel();
        //  x.setLayout(new BoxLayout(x,BoxLayout.Y_AXIS));
        this.add(Data, BorderLayout.CENTER);

        BottomPanel y = new BottomPanel();
        this.add(y, BorderLayout.SOUTH);
        setVisible(true);
    }

    public class DataPanel extends JPanel {
        private JLabel I;
        private JTextField IP;
        private JButton Adv;
        private JLabel Portn;
        private JTextField portnum;

        DataPanel() {
            setLayout(new FlowLayout(1, 1, 1));


            I = new JLabel("HostName");

            IP = new JTextField("", 25);

            Portn = new JLabel("Port Number");

            portnum = new JTextField("", 10);

            Adv = new JButton("Advanced...");

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
        private LoginGUI Log;



        public BottomPanel() {


            Connect = new JButton("Client.Connect");
            Close = new JButton("Close");



            this.add(Connect);
            this.add(Close);

            PrepareButtons();
        }

        public void PrepareButtons() {
            //Action Handlers here

            Connect.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (client == null) {
                        try {
                          // String host = "127.0.0.1";// "192.168.1.8";//"127.0.0.1";
                          // int port = 8000;
                           String host = Data.IP.getText();
                           int port = Integer.parseInt(Data.portnum.getText());
                           System.out.println(host);
                           System.out.println(port);
                            client = new Client(host, port);
                            Log = new LoginGUI();

                        }catch(Exception m){

                        }
                    }
                }

            });


        }
    }


        public static void main(String[] args) {
            new ConnectGUI();
        }
    }


