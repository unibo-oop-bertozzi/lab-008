package it.unibo.mvc;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame();
    public SimpleGUIWithFileChooser(final Controller ctrl) {
        final JPanel newJPanel = new JPanel();   
        newJPanel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        newJPanel.add(textArea, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        newJPanel.add(save, BorderLayout.SOUTH);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    ctrl.WriteFIle(textArea.getText());
                } catch (IOException IOE) {
                    JOptionPane.showMessageDialog(frame, IOE, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        final JPanel topPanel = new JPanel();   
        final JTextField textField = new JTextField(ctrl.getPath());
        final JFileChooser browse = new JFileChooser("Browse...");
        topPanel.add(textField, BorderLayout.CENTER);
        textField.setEditable(false);
        topPanel.add(browse, BorderLayout.LINE_END);
        newJPanel.add(topPanel,BorderLayout.NORTH);
        frame.setContentPane(newJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    JFileChooser chooser = new JFileChooser();
                int returnVal = chooser.showSaveDialog(frame);
                if(returnVal == JFileChooser.APPROVE_OPTION) { 
                    ctrl.setCurrentFile(chooser.getSelectedFile());
                }
                } catch (Exception e) {
                    // TODO: handle exception
                    JOptionPane.showMessageDialog();
                }
                
            }
        });
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
        public static void main(final String... args) {
        new SimpleGUIWithFileChooser(new Controller()).display();
     }
}
