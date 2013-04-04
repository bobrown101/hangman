import java.util.*;
public class hangman {
    private static String[] words = {"insert","moron","fool","bored","crazy","hello","nice","word","brother","senior","junior",
                "glasses","tiny","floor","code","internet","lake","sport","prince","aunt","seven","cartoon","trump","zebra","chalk",
                "random","person","movie","place","thing","rabbi","chest","hairy","clothes","close","open","closed","filled",
                "waste","find","easy","hard","pitch","base","come","twins","cracka","whatever","keyboard","actually","alabama","sixteen","computer","telephone","habitat","hangman","java" };
    public String chosenWord;
    public String x;
    public String guessedLetters = "";
    public String wrongLetters = "";
    public int counter = 0;//variable to increase in case of double letter.
    public hangman(){
        double r = 1 + Math.random()*words.length;
        chosenWord = words[(int)r]; // eventually this should be used
        //chosenWord="pizza"; // but its good to use what you know while building n testing your code.
    }
    public void checkInput(Scanner is){
        boolean[] pos = new boolean[chosenWord.length()];
        int counter = 0;
        while(counter!=chosenWord.length() && !(wrongLetters.length() >5)){//i put 5 because it will already be in the loop when it reached 6
        	System.out.println("----------------------------------"); //spacer
        	System.out.println("Please enter a letter: ");
            String ip = is.nextLine();
            if(guessedLetters.contains(ip)){
            	System.out.println("You have already guessed that letter... dumbass");
            }
            else if (ip.length() >1){
            	System.out.println("What you have entered is more than one character long. Your and idiot");
            }
            else if (!(isAcceptable(ip))){
            	System.out.println("Well, you have done something studpid enough that I don't know what you entered. Your name must be kaleb");
            }
            
            else{	
            	guessedLetters = guessedLetters + ip;
	        	for(int i = 0 ; i < pos.length ; i++){
	                if(ip.charAt(0)==chosenWord.charAt(i)){
	                    pos[i] = true;
	                    counter++;
	                }
	            }
	            if(!(isIn(ip, pos))) {
	            	wrongLetters = wrongLetters + ip; //if the guess is not in the word, then add it to wrongLetters
	            }
	            
	            display_hangman(wrongLetters.length());
	            System.out.println("Guessed Letters: " + guessedLetters);
	            
	            int i = 0;
	            while(i<pos.length){
	                if(pos[i]) System.out.print(" " + chosenWord.charAt(i));
	                else System.out.print(" -");
	                i++;
	            }
            }
            System.out.println(); // this is a spacer
        }
        if(counter == chosenWord.length()) {
        	System.out.println("*********************************");
        	System.out.println("*It looks like you won... try-hard ");
        	System.out.println("*********************************");
        }
        else {
        	System.out.println("*****************************************************************");
        	System.out.println("* Well that sucks for you. YOU LOST..... LOSER The word was: " + chosenWord);
        	System.out.println("*****************************************************************");
        }
    }
    private void myGraphics(int bodyParts) {
        switch (bodyParts) {
        case 0:
            System.out.println( "*** You have 6 body parts left*** ");
            System.out.println( "|--|     ");
            System.out.println( "|     ");      
            System.out.println( "|     "); 
            System.out.println( "|     ");
            System.out.println( "|______");
            System.out.println( "|______|");
            break;
        case 1:
            System.out.println( "*** You have 5 body parts left*** ");
            System.out.println( "|--|     ");
            System.out.println( "|  o  ");      
            System.out.println( "|     "); 
            System.out.println( "|     ");
            System.out.println( "|______");
            System.out.println( "|______|");
            break;
        case 2:
            System.out.println( "*** You have 4 body parts left*** ");
            System.out.println( "|--|     ");
            System.out.println( "|  o  ");      
            System.out.println( "|  |  "); 
            System.out.println( "|     ");
            System.out.println( "|______");
            System.out.println( "|______|");
            break;
        case 3:
            System.out.println( "*** You have 3 body parts left*** ");
            System.out.println( "|--|     ");
            System.out.println( "|  o  ");      
            System.out.println( "| /" + "|" + "  " ); 
            System.out.println( "|     ");
            System.out.println( "|______");
            System.out.println( "|______|");
            break;
        case 4:
            System.out.println( "*** You have 2 body parts left*** ");
            System.out.println( "|--|     ");
            System.out.println( "|  o  ");      
            System.out.println( "| /" + "|" + "\\  " );
            System.out.println( "|     ");
            System.out.println( "|______");
            System.out.println( "|______|");
            break;
        case 5:
            System.out.println( "*** You have 1 body parts left*** ");
            System.out.println( "|--|     ");
            System.out.println( "|  o  ");      
            System.out.println( "| /" + "|" + "\\  " ); 
            System.out.println( "| /   ");
            System.out.println( "|______");
            System.out.println( "|______|");
            break;
        case 6:
            System.out.println( "*** You have 0 body parts left*** ");
            System.out.println( "|--|     ");
            System.out.println( "|  o  ");      
            System.out.println( "| /" + "|" + "\\  " ); 
            System.out.println( "| / \\ ");
            System.out.println( "|______");
            System.out.println( "|______|");
            break;
        default:
            break;
        }
    }
    public void display_hangman(int x){
        myGraphics(x);
    }
    public boolean isIn(String ip, boolean[] pos){
    	int checker = 0;
    	for(int i = 0 ; i < pos.length ; i++){
            if(ip.charAt(0)==chosenWord.charAt(i)){
                pos[i] = true;
                checker++;
            }
        }
    	if(checker != 0) return true;
    	else return false;
    }
    public static boolean isAcceptable(String letter){
    	return letter.matches("[a-zA-Z]+");
    }
    public static void main(String[] args){
        Scanner is = new Scanner(System.in);
        hangman h = new hangman();
        System.out.println("This is a hangman game made by Brady Brown. Have Fun!!");
        h.checkInput(is);
    }
}
