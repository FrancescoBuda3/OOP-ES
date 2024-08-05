package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "My second java graphical interface";
    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame(TITLE);
    private final Controller cont = new Controller();

    public SimpleGUIWithFileChooser() {
        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        JButton save = new JButton("save");
        canvas.add(save, BorderLayout.SOUTH);
        JTextArea text = new JTextArea();
        canvas.add(text, BorderLayout.CENTER);
        JPanel topper = new JPanel();
        topper.setLayout(new BorderLayout());
        JTextField toBrowse = new JTextField();
        JButton browse = new JButton("Browse...");
        canvas.add(topper, BorderLayout.NORTH);
        topper.add(toBrowse, BorderLayout.CENTER);
        topper.add(browse, BorderLayout.LINE_END);
        toBrowse.setEditable(false);
        toBrowse.setText(this.cont.getPathString());
        JFileChooser browser = new JFileChooser();
        browse.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                switch (browser.showSaveDialog(browse)) {

                    case JFileChooser.APPROVE_OPTION:
                        cont.setCurrentFile(browser.getSelectedFile());
                        toBrowse.setText(cont.getPathString());
                        frame.setVisible(true);
                        break;
                    case  JFileChooser.CANCEL_OPTION:
                        break;
                    default :
                        JOptionPane.showMessageDialog(frame, "An error has occurred while choosing the file");
                }          
            }    
        });

        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                try {
                    cont.writeString(text.getText());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(frame, "errore nella scrittura della stringa");
                }
                
            }
            
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);

    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);


        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new SimpleGUIWithFileChooser().display();
    }

}
