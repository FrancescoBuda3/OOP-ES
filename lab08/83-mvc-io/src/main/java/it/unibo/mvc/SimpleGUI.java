package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static int PROPORTION = 5;

    private final JFrame frame = new JFrame();
    private final Controller cont = new SimpleController();


    public SimpleGUI() {

        // elements of the GUI
        JPanel window = new JPanel();
        JTextField top = new JTextField();
        JTextArea history = new JTextArea();
        JPanel bottom = new JPanel();
        JButton print = new JButton("Print");
        JButton showHistory = new JButton("Show history");

        // setting the elements
        this.frame.add(window);
        window.setLayout(new BorderLayout());
        bottom.setLayout(new FlowLayout());
        history.setEditable(false);

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // assembling the elements
        window.add(top, BorderLayout.NORTH);
        window.add(history, BorderLayout.CENTER);
        bottom.add(print);
        bottom.add(showHistory);
        window.add(bottom, BorderLayout.SOUTH);

        // setting the bottons
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                try {
                    cont.setNextString(top.getText());
                    cont.printString();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, e.getMessage());
                }
            }  
        });

        showHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                history.setText(cont.getStringHistory().toString()); 
                frame.setVisible(true);
            }
        });        
    }

    public void display() {
        this.frame.setVisible(true);
    }

    public static void main(String args[]){
        new SimpleGUI().display();
        
    }

}
