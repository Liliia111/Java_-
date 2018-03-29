package Command;



/* public class Application {
	
	public static void main(String[] args) {
        if (args != null ){
            int length = args.length;
            if  (length == 1) {
                String first = args[0];
                if ("help".equals(first))
                    new Help().execute();
                else if ("exit".equals(first))
                    new Exit().execute();
                else
                    System.out.println("sdfsfd");
            }
            else if( length ==2 ) {
                String first = args[0];
                if ("echo".equals(first))
                    new Echo(args).execute();
                else if ("date".equals(first) && "now".endsWith(args[1]))
                    new Date().execute();
                else
                    System.out.println("tyjtyj");
            }
            else
                System.out.println("bnnbv");
        }
        else
            System.out.println("xzzx");
}
	}
*/

class Application { /*
	public static void main(String[] args) { 
		if (args.length < 1 || args.length > 2) 
		{ 
			System.out.println("Error"); return; 
			
	}

String command;

command = args[0];

switch (command) {
    case "help":
        if (args.length > 1) {
            System.out.println("Error");
            return;
        }
        new Help().execute();
        break;
    case "echo":
        if (args.length < 2) {
            System.out.println("Error");
            return;
        }
        Echo c = new Echo(args);
        c.s = args[1];
        c.execute();

        break;
    case "date":
        if (args.length < 2 || !args[1].equals("now")) {
            System.out.println("Error1");
            return;
        }
        new Date().execute();

        break;
    case "exit":
        if (args.length > 1) {
            System.out.println("Error");
            return;
        }
        new Exit().execute();
        break;
    default:
        System.out.println("Error");
        return;
}
} }*/
public static void main(String[] args){
    //YOUR CODE COMES HERE
    Command command;

    if (args == null || args.length == 0)
    {
    	System.out.println("Error");
    }

    else if (args[0].equals("help") && args.length == 1)
    {
        command = new Help();
    }

    else if (args[0].equals("exit") && args.length == 1)
    {
        command = new Exit();
    }

    else if (args[0].equals("date")  && args[1].equals("now") && args.length == 2)
    {
        command = new Date();
    }

    else if (args[0].equals("echo") && args.length == 2)
    {
    	new Echo(args).execute();
    }

    else
    {
    	new Echo(args).execute();
    }

  
}
}

