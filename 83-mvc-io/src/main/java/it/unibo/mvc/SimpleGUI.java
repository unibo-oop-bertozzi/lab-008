package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame();
    /**
     * @param c
     */
    public SimpleGUI(final Controller c) {
        final JPanel newJPanel = new JPanel();
        final JPanel buttonPanel = new JPanel();
        newJPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        final JTextField textField = new JTextField();
        newJPanel.add(textField, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();
        newJPanel.add(textArea, BorderLayout.CENTER);
        final JButton print = new JButton("Print");
        buttonPanel.add(print, BorderLayout.LINE_START);
        final JButton history = new JButton("Show history");
        buttonPanel.add(history, BorderLayout.LINE_END);
        newJPanel.add(buttonPanel, BorderLayout.SOUTH);
        frame.setContentPane(newJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.setString(textField.getText());
                c.printCurrentString();
            }
        });
         /*
         * Handlers
         */
        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                textArea.setText(c.getHistory().toString());
            }
        });
    }

    private void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String... args) {
       new SimpleGUI(new SimpleController()).display();
    }
}
