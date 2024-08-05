package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final String TITLE = "My first java graphical interface";
    private static final int PROPORTION = 5;


    private final JFrame frame = new JFrame(TITLE);
    //private final Controller cont = new Controller();

    public SimpleGUI() {
        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        JButton save = new JButton("save");
        canvas.add(save, BorderLayout.SOUTH);
        JTextArea text = new JTextArea();
        canvas.add(text, BorderLayout.CENTER);
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
        new SimpleGUI().display();
    }

}
