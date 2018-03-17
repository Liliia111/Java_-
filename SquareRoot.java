package SquareRoot;

public class SquareRoot {
  public static void main(String[] args) {
        double a = 3;
	      double b = 2.5;
	      double c = -0.5;
	      double x1, x2;
		  double D=(b*b) - (4*a*c);
	        if (D < 0) {
	                     System.out.println("x1=");
				         System.out.println("x2=");
	                     return;
	                }
	                D = Math.sqrt(D);


			if (D>0) {
	            if (a==0 && c==0){
	                 x1=x2=0.0;
	                 System.out.println("x1=" + x1);
				     System.out.println("x2=" + x2);
	                 return;}
	            else {
				x1= (-b + D)/(2*a);
				x2= (-b - D)/(2*a);
				System.out.println("x1=" + x1);
				System.out.println("x2=" + x2);return;}
			 }
			else if (D==0) {
	            if (a==0){
	             
	                 System.out.println("x1=");
				     System.out.println("x2=");
	                 return;}
				x1= (-b)/(2*a);
				x2=x1;
				System.out.println("x1=" + x1);
				System.out.println("x2=" + x2); return;
			}
			else {
				System.out.println("x1=");
				System.out.println("x2=");
			}
		}

}
