package ua.lpnuai.oop.ryvak09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import java.util.Scanner;




public class Main {

    /**

     * started method
    

     * */

    public static void main(String[] args) throws UnsupportedEncodingException {
    	
    	
    	 String str = System.getProperty("console.Encoding", "utf-8");

         if (str != null) {

             try {

                 System.setOut(new PrintStream(System.out, true, str));

             } catch (UnsupportedEncodingException e) {

                 e.printStackTrace();

             }

         }

         
         
            
     

        boolean flag = true;




        website cardBoard = new website();

        Scanner in = new Scanner(System.in);

        ConsoleWork work = new ConsoleWork();



        do{

        	System.out.println("Введіть команду:");

            String command = in.next();

            switch (command){

                case "-add":

                    try {

                        cardBoard.addFilm(work.addFilmInfoFromConsole());

                    } catch (Exception e) {

                        System.out.println("Something wrong");

                    }

                    break;

                case "-remove":

                    in = new Scanner(System.in);

                    System.out.println("Введіть номер фільму: ");

                    cardBoard.removeFilm(in.nextInt());

                    break;

                case "-print":

                    work.printArray(cardBoard);

                    break;

                case "-getByIndex":

                    in = new Scanner(System.in);

                    ConsoleWork.printFilm(cardBoard.get(in.nextInt()));

                    break;

                case "-stop":

                    flag = false;

                    break;

                default:

                    System.out.println("Incorrect command");

                    System.out.println("Try again");

                    break;

            }

        }while(flag);

        }}
