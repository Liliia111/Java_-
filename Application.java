package Command;





class Application { 
public static void main(String[] args){
   
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

