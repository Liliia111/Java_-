package Fibonacci;

public class Fibonacci {
	
	    public long getNumber(int position) {
	        if (position > 2)
	            return getNumber(position - 1 ) + getNumber(position-2);
	        else if(position>=1)
	            return 1;
	        else
	        	return -1;
	}
}
