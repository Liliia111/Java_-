package MatrixPrint;

public class MatrixPrint {

		public static void main(String args[]){
				 int [][] array = new int [5][5];
		        int a = 1;
		        for (int i = 0; i < array.length; i++) {
		            for (int j = 0; j < array.length; j++) { 
		                if ((i ==j) | (i + j == array.length - 1))
		                System.out.print(" * ");
		                else if(a<10){                   
		                    System.out.print (" " + a + " ");                    
		                }    
	                    else
	                    {
	                     System.out.print (a + " ");
	                    }
		                
		                ++a;
		            }
		            System.out.println();
		    }
		}
	}
	      


