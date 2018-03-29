package Application;

public class Application {

	public static void main(String[] args) {

			
			 if (args== null && args.length== 0 && args[0] == null)
			 {		 
char c = args[0].charAt(0);

int counter = 0;
for (int i = 0; i < args[0].length(); i++) {
	if(c  == args[0].charAt(i)){
		if(counter == 9){
			System.out.print(c);
			System.out.print(counter);
			counter = 0;
		}
		counter++;
	}
	else{
		System.out.print(c);
		if(counter > 1){
			System.out.print(counter);
		}
		counter = 1;
		c = args[0].charAt(i);
		
	}
}
System.out.print(c);
if(counter > 0){
	System.out.print(counter);
}
}
	}
	}

