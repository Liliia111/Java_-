package lineSorter;
import java.util.Arrays;
import java.util.Scanner;
public class lineSorter {

	public static void main(String[] args) throws Exception  {
		
		        new Task().execute();
		        Scanner s = new Scanner(System.in);
		        String line = s.nextLine();
		        while(!("e".equals(line))){
		            if("-h".equals(line) || "-help".equals(line))
		                new Help().execute();

		            else if("a".equals(line))
		                new Add().execute();

		            else if("b".equals(line))
		               new View(new Add().getstr()).execute();

		            else if("c".equals(line))
		                new Sorter(new Add().getstr()).method();

		          

		            else
		                new Other().execute();
		            System.out.print("New command: ");
		            line = s.nextLine();
		        }
		        new Exit().execute();
		    }
		

	}


