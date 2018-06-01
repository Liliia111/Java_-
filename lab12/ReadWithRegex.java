package ua.lpnuai.oop.ryvak11;

import java.io.File;

import java.io.FileReader;

import java.io.IOException;

import java.util.Iterator;

import java.util.LinkedList;

import java.util.Scanner;

import java.util.regex.Matcher;

import java.util.regex.Pattern;


import static ua.lpnuai.oop.ryvak11.ConsoleWork.getDirectorFromConsole;






public class ReadWithRegex {

    private static final String DATEPATTERN = "((0[1-9]|[1-2][0-9]|3[0-1])(\\.|\\,)(0[1-9]|1[0-2])(\\.|\\,)" + "([0-9]{4}))|(-)";

   

   

    private static final String NAMEPATTERN = "(\\D+)|(-)";

    private static final String REGNUMPATTERN = "([a-zA-Zа-яА-я]){2}\\s(\\d){5,20}";

   



   
    public static FilmInfo readFromConsole() throws NoMatchData {

        Scanner in = new Scanner(System.in);

        FilmInfo film = new FilmInfo();



        System.out.println("Input the information about client");

       

        {


            in = new Scanner(System.in);

         

        }



     
        System.out.print("Назва: ");

        film.setfname(getDataFromConsole(in,NAMEPATTERN));

  System.out.print(" Дата: ");

    film.setfduration(getDataFromConsole(in,DATEPATTERN));



        System.out.println(" Режисер: (-stop)");

        Scanner in2 = new Scanner(System.in);

        boolean flag = true;

        LinkedList<String> list = new LinkedList<>();

        do {

            String text = in.nextLine();

            if (text.equals("-stop")) {

                flag = false;

            } else

                list.add(text);

        } while (flag);

        film.setfdirector(list);



       




        return film;

    }







    public static Cinema pretendToCandidat(){

        Cinema cinema = new Cinema();
        Scanner in = new Scanner(System.in);

     System.out.print("Дата: ");

cinema.setfduration(getDataFromConsole(in,DATEPATTERN));
        System.out.println(" Режисер: (-stop)");

        cinema.setfdirector(getDirectorFromConsole());

        return cinema;

    }
    
    



  

    private static String getDataFromConsole(Scanner in,String PATTERN){

        boolean flag;

        String data;

        do {

            data = in.nextLine();

            try{

                checkExpression(data,PATTERN);

                flag = false;

            }catch (NoMatchData ex){

                ex.printError();

                flag = true;

                System.out.println("Repeat input the data");

            }

        }while (flag);

        return data;

    }




   private static void checkExpression(String data,String regex) throws NoMatchData {

        if (!checkByRegex(data, regex))

            throw new NoMatchData(data);

    }




    private static boolean checkByRegex(String data,String regEx){

        Pattern pattern = Pattern.compile(regEx);

        Matcher matcher = pattern.matcher(data);

        return matcher.matches();

    }

}