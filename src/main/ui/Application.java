package ui;

import ui.menu.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Application extends UserDetails{
    private JTabbedPane mainMenu;
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField findnameTextField;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField4;
    private JButton submitButton;
    private JButton submitButton1;
    private JButton submitButton2;
    private JButton submitButton3;
    private JTextArea textArea1;
    private JButton clearButton;


    public Application() {
        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                redirectSystemStreams();
                String custName = textField1.getText();
                Integer custNum = Integer.valueOf(textField2.getText());
                Double custSpent = Double.valueOf(textField3.getText());
                new JsonNewCustomer(custName, custNum, custSpent, 0);
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
        });


        submitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redirectSystemStreams();
                String findcustbyname = findnameTextField.getText();
                new JsonFindCustomerByName(findcustbyname);
                findnameTextField.setText("");
            }
        });

        submitButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redirectSystemStreams();
                Integer findcustbynum = Integer.valueOf(textField4.getText());
                new JsonFindCustomerByNumber(findcustbynum);
                textField4.setText("");
            }
        });

        submitButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redirectSystemStreams();
                Integer getcustnum = Integer.valueOf(textField5.getText());
                Double addamtspent = Double.valueOf(textField6.getText());
                new JsonAddCustomerSpent(getcustnum, addamtspent);
                textField5.setText("");
                textField6.setText("");
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");

            }
        });
    }

    private void updateTextArea(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                textArea1.append(text);
            }
        });
    }

    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                updateTextArea(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextArea(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CLAPP");
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new Application().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 720);
        frame.setVisible(true);
    }

    // Rudimentary customer discount algorithm
    public static int getDiscount(UserDetails c) {
        if (c.getCustomerSpent() <= 0)
            return 0;
        else if (c.getCustomerSpent() < 50)
            return 4;
        else
            return 8;
    }


}
