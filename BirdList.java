import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
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

        // Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        // System.out.println("Enter bird");
        // Bird birdGuess = findBird(myObj.nextLine());  // Read user input
        
    }

    public void runTurn(){
        count++;
        if(count < 6){
            Bird birdGuess = findBird(guesser());
            processGuess(birdGuess);//replace ans w guess
        }
    }

    public void setUp(String bird){
        // JFrame frame = new JFrame("Raptordle");
        // frame.setSize(750, 750);
        // frame.setLocationRelativeTo(null);
        // frame.setVisible(true);
        var f = new JFrame();
        var icon = new ImageIcon(bird+".jpg");
        var label = new JLabel(icon);
        f.add(label);
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
        if(sameBird(guess)){
            JOptionPane.showMessageDialog(null, "Yes!");;
            //guess again
        }else
        if(related(guess)){
            
            JOptionPane.showMessageDialog(null, "close!");
            //share relatednessr
        }else
        JOptionPane.showMessageDialog(null, "no.");
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