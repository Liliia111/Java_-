package ua.lpnuai.oop.ryvak09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Main {



    public static String[] divide(String s) {

        ArrayList<String> tmp = new ArrayList<String>();

        int i = 0;



        for (int j = 0; j < s.length(); j++) {

            if (s.charAt(j) == ' ') {

                if (j > i) {

                    tmp.add(s.substring(i, j));

                }

                i = j + 1;

            }

        }

        if (i < s.length()) {

            tmp.add(s.substring(i));

        }

        return tmp.toArray(new String[tmp.size()]);

    }



    public static void main(String[] args) {



        Scanner InWord = new Scanner(System.in);

        Scanner InText = new Scanner(System.in);

        System.out.print("Enter Text: ");

        String s = InText.nextLine();

        final String sentences[] = s.split("\\s+");

        String[] r = divide(s);

        System.out.println("entered text:");
        System.out.println(s);


        //for (int i = 0; i < r.length; i++)

           // System.out.println(r[i]);
            
       String num = s;
       num = num.replace( "a", " 1");
       num =  num.replace( "b", " 2");
       num = num.replace( "c", " 3");
       num = num.replace( "d", " 4");
       num = num.replace( "e", " 5");
       num = num.replace( "f", " 6");
       num =  num.replace( "g", " 7");
       num =  num.replace( "h", " 8");
       num =  num.replace( "i", " 9");
       num =  num.replace( "j", " 10");
       num =  num.replace( "k", " 11");
       num =  num.replace( "l", " 12");
       num =  num.replace( "m", " 13");
       num =   num.replace( "n", " 14");
       num =  num.replace( "o", " 15");
       num =  num.replace( "p", " 16");
     num =  num.replace( "q", " 17");
     num =  num.replace( "r", " 18");
     num =  num.replace( "s", " 19");
     num =  num.replace( "t", " 20");
     num = num.replace( "u", " 21");
     num = num.replace( "v", " 22");
     num =  num.replace( "w", " 23");
     num =   num.replace( "x", " 24");
     num =  num.replace( "y", " 25");
     num =  num.replace( "z", " 26");
     StringBuilder sb = new StringBuilder();
     s = s.replace( "a", "a ");
     s = s.replace( "b", "b ");
     s = s.replace( "c", "c ");
     s = s.replace( "d", "d ");
     s = s.replace( "e", "e ");
     s = s.replace( "f", "f ");
     s = s.replace( "g", "g ");
     s = s.replace( "h", "h ");
     s = s.replace( "i", "i ");
  s = s.replace( "j", " j ");
   s=s.replace( "k", " k ");
   s=s.replace( "l", " l ");
   s=s.replace( "m", " m ");
   s=s.replace( "n", " n ");
   s=s.replace( "o", " o ");
   s=s.replace( "p", " p ");
   s=s.replace( "q", " q ");
   s=s.replace( "r", " r ");
   s=s.replace( "s", " s ");
   s=s.replace( "t", " t ");
   s=s.replace( "u", " u ");
   s=s.replace( "v", " v ");
   s=s.replace( "w", " w ");
   s=s.replace( "x", " x ");
   s=s.replace( "y", " y ");
   s=s.replace( "z", " z ");
     for (char c: s.toCharArray()) {
       for(int j = 0; j<10000; j++)
    	  sb.append(c).append(" ");
     }
        System.out.println("words: ");
        
        
        System.out.println(" " + s);
        System.out.println(num);
        String [] SS = s.split("\\\\s+");

      

        for(String S1:SS) {



            
            
        Arrays.sort(sentences);
    	String word = Arrays.toString(sentences);
    	
    	String b = word.replace(",", "");
   String c = b.replace("[", "");
    	String v = c.replace("]", "");
    	v.trim();
    	
    	System.out.println(v);

       

                



        



    	 Container container = new Container(sentences);



      //  System.out.println("Enter word that you would like to Add/Find");

      //  String str = InWord.nextLine();

        System.out.println("Operations:");

        System.out.println("1 - Add Word");

        System.out.println("2 - Find entered word");

        System.out.println("3 - Display Array");

        System.out.println("4 - Exit");
        System.out.println("5 - Delete all");

        System.out.println("Enter Number");

        int k = InWord.nextInt();
        String str = InWord.nextLine();


       while(k!=4){
          if(k == 1){
        	  container.AddElement(str);
        	 str = str.replaceAll("\\s+","");
        	 

            for (String item : container) {
            	
            	item = item.replaceAll("\\s+", "");
            	String h = item.replaceAll("\n|\r\n", "");
                System.out.println(h);
                
            }
k=0;
        }



        else if(k == 2){
str = str.replaceAll("\\s+","");
            System.out.println(container.FindElement(str));
k=0;
        }



        else if(k == 3) {

            for (int i =0; i < r.length; i++)

                System.out.println(r[i]);
k=0;
        }
        else if(k == 5)
        {
        	container.deleteAll();
        	 System.out.println("String was deleted");
        	 k=0;
        }
         
        else 
        	{ k = InWord.nextInt();
                str = InWord.nextLine();}
        	
        	

    }
       if(k == 4){

        System.out.println("Goodbye");

       }
        }}}

    
        
    

    


