package ua.lpnuai.oop.ryvak11;


import java.io.*;

import java.util.ArrayList;

import java.util.Comparator;

import java.util.List;

import java.util.Scanner;




public class Main {



    private static String cArrayOfCommand[] = {"-add","-remove","-print","-sort",

            "-serialize","-deserialize","-stop"};// arrray of command



    public static void main(String[] args) {

        ConsoleWork work = new ConsoleWork();// class console work

        boolean mAutoFlag = false;// flag for auto-single work

        boolean flag = true;// flag for main loop for getting console comand

        String mStr;// name of comand

        Scanner in;// scaner for read from console

        ArrayList<FilmInfo> list = new ArrayList<>();// list of clients



        if (args.length != 0) {

            if (args[0].equals("-auto"))

                mAutoFlag = true;

        }



        do {

            System.out.println("Введіть команду( \'-help\' для допомоги)");

            if (!mAutoFlag) {

                in = new Scanner(System.in);

                mStr = in.next();

            } else {

                mStr = cArrayOfCommand[(int) (0 + Math.random() * cArrayOfCommand.length)];

            }

            switch (mStr) {

                case "-print":

                    System.out.println("------See Data------");

                    printData(list);

                    break;

                case "-add":

                    System.out.println("------Add Data------");

                    if (list == null)

                        break;

                    if (!mAutoFlag){

                        try {

                            list.add(work.addFilmInfoFromConsole());

                           // serializeData(getWaySerializeble(true), list);

                        } catch (Exception e) {

                            e.printStackTrace();

                        }

                    } 



                    break;

                case "-remove":

                    System.out.println("------Remove Data------");

                    if (list == null && list.size() < 1)

                        break;

                    if (!mAutoFlag){

                        in = new Scanner(System.in);

                        System.out.print("Введите индекс элемента ");

                        int index = in.nextInt();

                        try{

                            list.remove(index);

                        }catch (IndexOutOfBoundsException ex){

                            System.out.println("Невозможно удалить этот элемент");

                        }

                    } else {

                        try{

                            list.remove((int)(0 + Math.random()*(list.size()-1)));

                        }catch (IndexOutOfBoundsException ex){

                            System.out.println("Невозможно удалить этот элемент");

                        }

                    }

                    break;

                case "-sort":

                    System.out.println("------Sort Data------");

                    if (list != null && list.size() > 1)

                        list.sort(new myCompare());

                    else

                        System.out.println("Невозможно отсортировать");

                    break;

                case "-serialize":

                    System.out.println("------Serialize Data------");

                    if (list != null && list.size() != 0)

                    	System.out.println();
                        //serializeData(getWaySerializeble(mAutoFlag), list);

                    else

                        System.out.println("Список пуст");

                    break;

                case "-deserialize":

                    System.out.println("------Deserialize Data------");

                    //list = deserializeData(getWaySerializeble(mAutoFlag));

                    break;

               

                case "-auto":

                    System.out.println("------Auto/Single Mode------");

                    if (mAutoFlag) {

                        System.err.println("Смена на роботу с пользователем");

                        mAutoFlag = false;

                    } else {

                        System.err.println("Смена на автоматическую работу");

                        mAutoFlag = true;

                    }

                    break;

                case "-help":

                    help();

                    break;

                case "-stop":

                    System.out.println("------Stop Process------");

                    flag = false;

                    break;

                default:

                    System.out.println("Неправильно введена команда!!!");

                    System.out.println("Потвторите снова");

                    break;

            }

        }while (flag) ;

    }



    /**

     * Method that print data from list

     * */

    private static void printData(List<FilmInfo> list) {

        if (list == null || list.size() == 0)

            return;

        for (FilmInfo p : list){

            ConsoleWork.printFilm(p);

        }

    }



    private static void serializeData(String way, List<FilmInfo> list){

        if (list == null)

            return;

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(way));

            oos.writeObject(list);

            oos.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }



    /**

     * Method tha load data from file

     * with serialization

     *

     * @param way way to file

     * @return ArrayList - list of prisoners

     **/

    public static ArrayList<FilmInfo> deserializeData(String way){

        ArrayList<FilmInfo> conteiner = null;

        try {

            ObjectInputStream is = new ObjectInputStream(new FileInputStream(way));

            conteiner = (ArrayList<FilmInfo>) is.readObject();

            is.close();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return conteiner;

    }



   

    


    /**

     * Method help to print information about command

     */

    private static void help() {

        System.out.println("Команда -print - показує дані контейнера");

        System.out.println("Команда -add - додавання елемента");

        System.out.println("Команда -remove - видалення елемента");


        System.out.println("Команда -serialize - Серіалізація(запис)");

        System.out.println("Команда -deserialize - Десереалізація(читання)");

        System.out.println("Команда -sort - сортуванняі");

        System.out.println("Команда -auto - авто");

        System.out.println("Команда -stop - завершення");



    }



 

    public static class myCompare implements Comparator<FilmInfo> {

        @Override

        public int compare(FilmInfo o1, FilmInfo o2) {

            if (o1.frate() < o2.frate())

                return -1;

            else if (o1.frate() > o2.frate())

                return 1;

            return 0;

        }

    }

}