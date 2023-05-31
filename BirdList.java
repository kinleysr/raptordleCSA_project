import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.*;

public class BirdList extends JPanel implements ActionListener {
    Random r = new Random();
    ArrayList<Bird> gameList = new ArrayList<Bird>();
    Bird ans;
    int count;
    JLabel l;
    JTextField t;
    JLabel result;
    ArrayList<String> guesses = new ArrayList<String>();
    JFrame f;
    
    
    public BirdList(){
        createList();
        ans = generateBird();
        setUp(ans.getName());
       // runTurn();


    }

    public void runTurn(){
        //count++;
        while(count < 6){
            count++;
            Bird birdGuess = findBird(guesser());
            if(sameBird(birdGuess)){
                JOptionPane.showMessageDialog(null, "Nice job!  The correct answer is "+ ans.getName()+".  You got it with "+count +" guesses");
                return;
            }
            processGuess(birdGuess);
        }
        JOptionPane.showMessageDialog(null, "Out of guesses.  The correct answer is " + ans.getName()  + ".  Better luck next time!");
    }

    public void playAgain(){

    }
    public boolean checkGuesses(){
        return (count<=6);
    }

    public void setUp(String bird){
        f = new JFrame();
        var icon = new ImageIcon(bird+".jpg");
        
        t = new JTextField(27);
        var label = new JLabel(icon);
        //JPanel p = new JPanel();
        JButton b = new JButton("submit");
        l = new JLabel("enter bird: ");
        result = new JLabel("");
       
        
        // // addActionListener to button
        // b.addActionListener(te);
        b.addActionListener(this);
        this.add(label);
        this.add(l);
        this.add(t);
        this.add(b);
        this.add(result);
        
        f.add(this);
        f.setSize(750, 1000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        result.setBounds(150, 100, 50,50);        
       
    }
    public String guesser(){
        System.out.println("test2");
        String bird = t.getText();
        System.out.println(bird);
        //JTextField userField = new JTextField();
        return bird;
    }

    public Bird findBird(String name){
        for (Bird bird : gameList) {
            // if(bird.getName().equals(null)){
            //     JOptionPane.showMessageDialog(null, "no bird found.  Try again. make sure you have the correct spelling/capitalization");
            //     findBird(guesser());
            // }
            if(bird.getName().equals(name)){
                System.out.println("test1");
                return bird;

            }
            
        }
            new JLabel("no bird found.  Try again. make sure you have the correct spelling/capitalization");
            return findBird(guesser());
            // System.out.println("sdfdsafasd");
            // return null;
        
        //return null;
    }

    public void processGuess(Bird guess){
        if(related(guess)){
            new JLabel("close!  "+"you have "+Integer.toString(6-count)+" guesses remaining.");
            //share relatednessr
        }else
        new JLabel("no.  "+"you have "+Integer.toString(6-count)+" guesses remaining.");
        //end game
    }


    public boolean sameBird(Bird guess){
        if(ans.compareName(guess)){
            return true;
        }
        return false;
    }
    
    public boolean related(Bird guess){
        if(ans.compareGenus(guess)){
            return true;
        }
        return false;
    }


    public Bird generateBird(){
        return gameList.get(r.nextInt(gameList.size()-1));
    }
    public void actionPerformed(ActionEvent e)
    {
        count++;
        if(checkGuesses()){
        System.out.println("test");
        String s = e.getActionCommand();
        String birdEntry = t.getText();
        guesses.add(birdEntry);
        t.setText("");
        if (s.equals("submit")) {
            System.out.println("xxx");
            // set the text of the label to the text of the field
            if(ans.getName().equals(birdEntry)){
                System.out.println("yes");
                result.setText("yes");
                return;
            }else if(ans.getGenus().equals(findBird(birdEntry).getGenus())){
                System.out.println("close");
                return;
            }else{
                System.out.println("no");
            }
        }}else
        System.out.println("out of guesses");
            // set the text of field to blank
            
        
    }



    public ArrayList<Bird> createList(){
        gameList.add(new Bird("American Kestrel","Falco"));
        gameList.add(new Bird("Bald Eagle","Haliaeetus"));
        gameList.add(new Bird("Broad-winged Hawk","Buteo"));
        gameList.add(new Bird("California Condor","Gymnogyps"));
        gameList.add(new Bird("Cooper's Hawk","Accipiter"));
        gameList.add(new Bird("Ferruginous Hawk","Buteo"));
        gameList.add(new Bird("Golden Eagle","Aquila"));
        gameList.add(new Bird("Merlin","Falco"));
        gameList.add(new Bird("Northern Goshawk","Accipiter"));
        gameList.add(new Bird("Northern Harrier","Circus"));
        gameList.add(new Bird("Osprey","Pandion"));
        gameList.add(new Bird("Peregrine Falcon","Falco"));
        gameList.add(new Bird("Prairie Falcon","Falco"));
        gameList.add(new Bird("Red-shouldered Hawk","Buteo"));
        gameList.add(new Bird("Red-tailed Hawk","Buteo"));
        gameList.add(new Bird("Rough-legged Hawk","Buteo"));
        gameList.add(new Bird("Sharp-shinned Hawk","Accipiter"));
        gameList.add(new Bird("Swainson's Hawk","Buteo"));
        gameList.add(new Bird("Turkey Vulture","Cathartes"));
        gameList.add(new Bird("White-tailed Kite","Elanus"));
        return gameList;
    }


    public static void main(String[] args) {
        new BirdList();
    }
}