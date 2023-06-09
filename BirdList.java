import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class BirdList extends JPanel implements ActionListener {
    Random r = new Random();
    ArrayList<Bird> gameList = new ArrayList<Bird>();
    Bird ans;
    int count;
    JLabel l;
    JTextField t;
    JLabel result;
    JLabel guess1;
    JLabel guess2;
    JLabel guess3;
    JLabel guess4;
    JLabel guess5;
    JLabel guess6;
    ArrayList<String> guesses = new ArrayList<String>();
    JFrame f;
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    ArrayList<JLabel> labelGuess = new ArrayList<JLabel>();
    JLabel endWords;
    
    
    
    public BirdList(){
        createList();
        ans = generateBird();
        setUp(ans.getName());
       


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
        guess1 = new JLabel("");
        guess2 = new JLabel("");
        guess3 = new JLabel("");
        guess4 = new JLabel("");
        guess5 = new JLabel("");
        guess6 = new JLabel("");
        labelGuess.add(guess1);
        labelGuess.add(guess2);
        labelGuess.add(guess3);
        labelGuess.add(guess4);
        labelGuess.add(guess5);
        labelGuess.add(guess6);
        endWords = new JLabel("");
        this.setLayout(layout);
        //guess1 = new JLabel("  ");
       

        //gridlayout format
        gbc.fill = GridBagConstraints.HORIZONTAL;
         gbc.gridx = 3;
        gbc.gridy = 1;
        b.addActionListener(this);
        
        this.add(label,gbc);
        gbc.gridx=1;
        gbc.gridy = 3;
        this.add(l,gbc);
        gbc.gridx=3;
        gbc.gridy=3;
        this.add(t,gbc);
        gbc.gridx = 3;
        gbc.gridy = 5;
        this.add(guess1,gbc);
        gbc.gridx = 3;
        gbc.gridy = 6;
        this.add(guess2,gbc);
        gbc.gridx = 3;
        gbc.gridy = 7;
        this.add(guess3,gbc);
        gbc.gridx = 3;
        gbc.gridy = 8;
        this.add(guess4,gbc);
        gbc.gridx = 3;
        gbc.gridy = 9;
        this.add(guess5,gbc);
        gbc.gridx = 3;
        gbc.gridy = 10;
        this.add(guess6,gbc);
        gbc.gridx = 3;
        gbc.gridy = 11;
        this.add(b,gbc);
        gbc.gridx = 3;
        gbc.gridy=12;
        this.add(endWords,gbc);
        // gbc.gridx=3;
        // gbc.gridy=8;
        // this.add(guess1,gbc);
        
        f.add(this);
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        //result.setBounds(400, 400, 50,50);        
       
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

    public void processGuess(String guess){
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
    
    public boolean related(String guess){
        if(ans.compareGenus(findBird(guess))){
            return true;
        }
        return false;
    }


    public Bird generateBird(){
        return gameList.get(r.nextInt(gameList.size()));
    }
    public void actionPerformed(ActionEvent e)
    {
        count++;
        
        if(checkGuesses()){
        String birdEntry = t.getText();
        System.out.println("test");
        String s = e.getActionCommand();
       
        guesses.add(birdEntry);
        t.setText("");
        if (s.equals("submit")) {
            System.out.println("xxx");
            // set the text of the label to the text of the field
            if(ans.getName().equals(birdEntry)){
                System.out.println("yes");
                (labelGuess.get(count-1)).setText(birdEntry+": yes");
                endWords.setText("congratulations, you guessed the bird!  it was a "+ birdEntry);
                return;
            }else if(related(birdEntry)){
                System.out.println("close");
                labelGuess.get(count-1).setText(birdEntry+": related");
                return;
            }else{
                System.out.println("no");
                labelGuess.get(count-1).setText(birdEntry+": no");
               
            }
        }}else{
        System.out.println("out of guesses");
        endWords.setText("out of guess.  the correct answer was a "+ ans.getName());
        }
        
        // String temp = "";
        // int num=1;
        // for (String bird : guesses) {
        //     temp += "Guess "+num+": "+bird;
        //     num++; 
        // }
        // guess1.setText(temp);
        
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