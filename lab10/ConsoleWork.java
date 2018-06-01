package ua.lpnuai.oop.ryvak09;

import java.util.LinkedList;
import java.util.Scanner;

public class ConsoleWork {



 

    public FilmInfo addFilmInfoFromConsole() throws Exception {

        try{

        	FilmInfo info = new FilmInfo();
        	Scanner in9 = new Scanner(System.in);
        	 System.out.print("Назва: ");
        	 info.setfname(getNameFromConsole());
        	 Scanner in10 = new Scanner(System.in);
        	 System.out.print("Жанр: ");
        	 info.setfgenre(getGenreFromConsole());
        	 Scanner in11 = new Scanner(System.in);
        	 System.out.print("Опис: ");
        	 info.setftext(getTextFromConsole());
            Scanner in = new Scanner(System.in);

            {
           
                
                System.out.print("Рейтинг: ");

                info.setfrate(in.nextFloat());
                
          
                
                System.out.print("Дата створення: ");

                info.setfdate(in.next());
               
                System.out.print("Тривалість: ");

                info.setfduration(in.next());
          

                
            }

          
            in = new Scanner(System.in);
            System.out.println("Актори ( -stop, щоб зупинитись)");

           info.setactors(getActorsFromConsole());

           Scanner in3 = new Scanner(System.in);
           System.out.println("Режисер ( -stop, щоб зупинитись)");
           info.setfdirector(getDirectorFromConsole());

            return info;

        }catch (Exception ex){

            throw new Exception();

        }

    }



 
    public static LinkedList<String> getActorsFromConsole(){

        LinkedList<String> list = new LinkedList<>();

        Scanner in2 = new Scanner(System.in);

        boolean flag = true;

        do {

            String text = in2.nextLine();

            if(text.equals("-stop")){

                flag = false;

            }else

                list.add(text);

        } while (flag);

        return list;

    }
    public static LinkedList<String> getDirectorFromConsole(){

        LinkedList<String> list = new LinkedList<>();

        Scanner in2 = new Scanner(System.in);

        boolean flag = true;

        do {

            String text = in2.nextLine();

            if(text.equals("-stop")){

                flag = false;

            }else

                list.add(text);

        } while (flag);

        return list;

    }
    public static LinkedList<String> getNameFromConsole(){

        LinkedList<String> list = new LinkedList<>();

        Scanner in2 = new Scanner(System.in);

        boolean flag = true;

        do {

            String text = in2.nextLine();

            if(text.equals("-stop")){

                flag = false;

            }else

                list.add(text);

        } while (flag);

        return list;

    }
    public static LinkedList<String> getGenreFromConsole(){

        LinkedList<String> list = new LinkedList<>();

        Scanner in2 = new Scanner(System.in);

        boolean flag = true;

        do {

            String text = in2.nextLine();

            if(text.equals("-stop")){

                flag = false;

            }else

                list.add(text);

        } while (flag);

        return list;

    }
    public static LinkedList<String> getTextFromConsole(){

        LinkedList<String> list = new LinkedList<>();

        Scanner in2 = new Scanner(System.in);

        boolean flag = true;

        do {

            String text = in2.nextLine();

            if(text.equals("-stop")){

                flag = false;

            }else

                list.add(text);

        } while (flag);

        return list;

    }


    /**

     * Method that print hobbies of person

     *

     * @param _list list of hobbies

     * */

    public static void printActors(LinkedList<String> _list){

        System.out.println();

        System.out.println("\nАктори:");

        for (int j = 0; j < _list.size(); j++) {

            System.out.println( _list.get(j));

        }

    }
    public static void printDirector(LinkedList<String> _list){

        System.out.println();

        System.out.println("Режисер: ");

        for (int j = 0; j < _list.size(); j++) {

            System.out.println(_list.get(j));

        }

    }
    public static void printName(LinkedList<String> _list){

        System.out.println();

        System.out.println("Назва: ");

        for (int j = 0; j < _list.size(); j++) {

           System.out.println(_list.get(j));

        }

    }
    public static void printGenre(LinkedList<String> _list){

        System.out.println();

        System.out.println("Жанр: ");

        for (int j = 0; j < _list.size(); j++) {

            System.out.println( _list.get(j));

        }

    }
    public static void printText(LinkedList<String> _list){

        System.out.println();

        System.out.println("Опис: ");

        for (int j = 0; j < _list.size(); j++) {

          System.out.println(_list.get(j));

        }

    }



   

    public Cinema pretendToCandidat(){

        Cinema cinema = new Cinema();

      

        Scanner in = new Scanner(System.in);

        System.out.print("Назва: ");

        cinema.setfname(getNameFromConsole());

        System.out.print("Жанр: ");

        cinema.setfgenre(getGenreFromConsole());
        
        System.out.print("Опис: ");
        
        cinema.setftext(getTextFromConsole());
        
        System.out.print("Режисер: ");
        
        cinema.setfdirector(getDirectorFromConsole());

        System.out.print("Рейтинг: ");

        String str = in.next();

        if (str.equals("-"))

            cinema.setfrate(0.0f);

        else

           cinema.setfrate(Float.parseFloat(str));

       

        System.out.print("Дата створення: ");

        cinema.setfdate(in.next());
        
        System.out.print("Тривалість: ");

        cinema.setfduration(in.next());

        System.out.println("Актори: (������� -stop ��� ����������� ������)");
//
       cinema.setactors(getActorsFromConsole());

        return cinema;

    }



   
    public void printArray(website cardBoard) {

        if (cardBoard == null || cardBoard.getFilm() == null){

            System.out.println("Array empty");

            return;

        }

        FilmInfo[] prisoner = cardBoard.getFilm();



       if (prisoner.length != 0) {

            for (int i = 0; i < prisoner.length; i++) {

                System.out.printf("%30s\n","Фільм " + (i + 1));

               printFilm(prisoner[i]);
//
           }
//
        }else {

            System.out.println("Nothing to show");

        }

    }




    public static void printFilm(FilmInfo film){

        CorrectPrint print = new CorrectPrint(new int[]{30,22,11,19});

   
        printName(film.getfname());
   
        
        printText(film.getftext());

        System.out.printf("\nДата створення\n");
        
        print.printLine(film.getfdate());

        System.out.printf("\n\nТривалість\n");
        
        print.printLine(film.getfduration());
        
       
        
        System.out.printf( "\n\nРейтинг\n");
        
        print.printLine(film.frate());
       
    
        
        printActors(film.getactors());
     




        print = new CorrectPrint(new int[]{30});

     


        print = new CorrectPrint(new int[]{30,22,11,19});

     
      

    }

}