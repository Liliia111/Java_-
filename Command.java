package Command;



public interface Command {
	public void execute();
}
class Help implements Command{
    @Override
    public void execute() {
        System.out.println("Help executed");
    }
}
class Echo implements Command{
    String s;
    String[] args;
    Echo (String[] args){
        this.args = args;
            s = args[1];
    }
    @Override
    public void execute() {
        System.out.println(s);
    }
}
class Date implements Command{
   @Override
    public void execute() {
        System.out.println(System.currentTimeMillis());
    }
}
class Exit implements Command{
   @Override
    public void execute() {
        System.out.println("Goodbye!");
    }
}


