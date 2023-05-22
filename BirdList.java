import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BirdList extends JFrame{
    Random r = new Random();
    ArrayList<Bird> gameList = new ArrayList<Bird>();
    Bird ans;
    int count;
    public BirdList(){
        createList();
        ans = generateBird();
        setUp(ans.getName());
        runTurn();


    }

    public void runTurn(){
        //count++;
        while(count < 6){
            count++;
            Bird birdGuess = findBird(guesser());
            if(sameBird(birdGuess)){
                JOptionPane.showMessageDialog(null, "Nice job!");
                return;
            }
            processGuess(birdGuess);
        }
        JOptionPane.showMessageDialog(null, "Out of guesses.  Better luck next time!");
    }

    public void playAgain(){

    }

    public void setUp(String bird){
        var f = new JFrame();
        var icon = new ImageIcon(bird+".jpg");
        var label = new JLabel(icon);
        f.add(label);
        f.setSize(1000, 1000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        
       
    }
    public String guesser(){
        String bird = JOptionPane.showInputDialog(null,
         "Please enter a bird.");
        System.out.println(bird);
        //JTextField userField = new JTextField();
        return bird;
    }

    public Bird findBird(String name){
        for (Bird bird : gameList) {
            if(bird.getName().equals(name)){
                return bird;
            }
        }
        return null;
    }

    public void processGuess(Bird guess){
        if(related(guess)){
            JOptionPane.showMessageDialog(null, 
            "close!  "+"you have "+Integer.toString(6-count)+" guesses remaining.");
            //share relatednessr
        }else
        JOptionPane.showMessageDialog(null,
        "no.  "+"you have "+Integer.toString(6-count)+" guesses remaining.");
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