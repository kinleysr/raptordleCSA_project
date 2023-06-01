
import java.awt.event.*;
import javax.swing.*;
public class graphics extends JFrame implements ActionListener {
    // JTextField
    
    static JTextField t;
 
    // JFrame
    static JFrame f;
 
    // JButton
    static JButton b;
 
    // label to display text
    static JLabel l;
 
    // default constructor
    graphics(){
    }
 
    // main class
    public static void main(String[] args)
    {
        String bird = "Merlin";
        // create a new frame to store text field and button
        f = new JFrame("raptordle");
        var icon = new ImageIcon(bird +".jpg");
        var label = new JLabel(icon);
        // create a label to display text
        l = new JLabel("enter bird: ");
 
        // create a new button
        b = new JButton("submit");
 
        // create a object of the text class
        graphics te = new graphics();
 
        // addActionListener to button
        b.addActionListener(te);
 
        // create a object of JTextField with 16 columns
        t = new JTextField(25);
 
        // create a panel to add buttons and textfield
        JPanel p = new JPanel();
 
        // add buttons and textfield to panel
        p.add(label);
        p.add(l);
        p.add(t);
        p.add(b);
 
        // add panel to frame
        f.add(p);
 
        // set the size of frame
        f.setSize(500, 750);
    }
 
    // if the button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("submit")) {
            // set the text of the label to the text of the field
            l.setText(t.getText());
 
            // set the text of field to blank
            t.setText(" ");
        }
    }

}
