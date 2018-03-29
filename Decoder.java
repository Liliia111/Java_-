package Decoder;

public class Decoder {

	public static void main(String[] args) {
		String str; StringBuilder decoded = new StringBuilder( "");
        if (args.length == 1) {
            str = args[0];
            if (str.equalsIgnoreCase("")) {
                System.out.println("");
                return;
            } else {
            	 for (int i = 0; i < str.length()-1; i++) {
                     if ((Character.isDigit(str.charAt(i))&&Character.isDigit(str.charAt(i+1))) || Character.isDigit(str.charAt(0))) {
                         return;
                     }
                     else if (str.charAt(i)==str.charAt(i+1))
                     {
                         return;
                     }
 }
                for (int i = 0; i < str.length(); i++) {
                    if (Character.isDigit(str.charAt(i)))
                    {
                        

                        for (int j = 0; j <  Character.getNumericValue(str.charAt(i))-1; j++) {
                        	 decoded.append(str.charAt(i - 1));
                        }
                    }
                    else {
                    	 decoded.append(str.charAt(i));
                    }
                }
            	
            	}
            }
        System.out.println(decoded);
        }
	}

	


