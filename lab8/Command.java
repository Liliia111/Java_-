

package lineSorter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
public interface Command {

	void execute();
}

class Task implements Command {
    @Override
    public void execute() {
        System.out.println("this program puts the entered strings in alphabetical order "
        		+ "(first priority) and in order of increasing their length (second priority).\n" +
                "Write -h or -help to call help menu.");
       
    }
}
    
    class Help implements Command {
        @Override
        public void execute() {
            System.out.println("Help instruction:\n" +
                    "1. Press A to input text.\n" + 
                    "2. Press B to to view entered text.\n" +
                    "3. Press C to operate with text.\n" +
                    "4. Press D to get result.\n" +
                    "5. Press E to exit program.");
        }
    }
    class Add implements Command{
        private Scanner s = new Scanner(System.in);
        private static String str = "";

        @Override
        public void execute() {
            System.out.println("Your text: ");
            this.str = s.nextLine();
          
            System.out.println("Press C to operate with text message or B to see your data.");
        }

        public String getstr() {
            return str;
        }
    }
    class View implements Command{
        private static String str;

        View(String str){
            this.str = str;
        }

        @Override
        public void execute() {
            if(str == null || str == "")
                System.out.println("You haven't write your text yet. Press 'A' to add a text.");
            else
                System.out.println("Your text message: " + str);
        }
    }
class Sorter{
	private static String str;
    private static String s[];
    private static int number[];

    Sorter(String str) {
        this.str = str;
    }
    public void method() {
        if ("".equals(str))
            System.out.println("You haven't write your text message yet. Press 'A' to add a text.");
        else {
        	
        	
        	String[] words = str.split("\\s+");
        	//System.out.println("Unsorted strings: " + Arrays.toString(words));
        	Arrays.sort(words);
        	String word = Arrays.toString(words);
        	
        	String b = word.replace(",", "");
       String c = b.replace("[", "");
        	String v = c.replace("]", "");
        	v.trim();
        	
        	System.out.println("Sorted strings: " + v);
        	
            
        }
        }
    
 
 
    public String[] getS() {
        return s;
}
}

class Exit implements Command{
    @Override
    public void execute() {
        System.out.println("Your welcome,the program successfully closed");
    }
}
class Other implements Command{

    @Override
    public void execute() {
        System.out.println("Incorrect input. Command not find. \n Press 'H' or 'help' to call help menu.");
    }
}
