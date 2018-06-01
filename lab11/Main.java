package ua.lpnuai.oop.ryvak11;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

import java.util.Scanner;




public class Main {



    public static void main(String[] args) {

        ConsoleWork work = new ConsoleWork();

        LinkedC<FilmInfo> conteiner = null;

        Object[] array = null;

        Scanner in = null;

        boolean flag = true;



        do {

            System.out.println("Please, input the command(input \'-help\' for help)");

            in = new Scanner(System.in);

            String n = in.next();

            switch (n) {

                case "-seeData":

                    printData(conteiner);

                    break;

                case "-addData":

                    conteiner = addData(conteiner);

                    break;

                case "-removeData":

                    conteiner = removeData(conteiner);

                    break;

                case "-serializeData":

                    in = new Scanner(System.in);

                    System.out.println("Please input the way for file");

                    serializeData(in.next(), conteiner);

                    break;

                case "-deserializeData":

                    in = new Scanner(System.in);

                    System.out.println("Please input the way for file");

                    try {

                        conteiner = deserializeData(in.next());

                    } catch (IOException e) {

                        System.err.println("Can`t find file");

                    }

                    break;

                case "-xmlEncode":

                    in = new Scanner(System.in);

                    System.out.println("Please input the way for file(for \'.xml\' file)");

                    encodeData(in.next(), conteiner);

                    break;

                case "-xmlDecode":

                    in = new Scanner(System.in);

                    System.out.println("Please input the way for file(for \'.xml\' file)");

                    conteiner = decodeData(in.next());

                    break;

                case "-createContein":

                    conteiner = createContein(conteiner);

                    break;

                case "-toString":

                    if (conteiner != null || conteiner.size() != 0)

                        System.out.println(conteiner.toString());

                    else

                        System.out.println("Container is null or has 0 elements");

                    break;

                case "-toArray":

                    array = conteiner.toArray();

                    break;

                case "-contain":

                    if (conteiner != null) {

                        try {

                            if (conteiner.contains(work.addFilmInfoFromConsole())) {

                                System.out.println("Found");

                            } else

                                System.out.println("Don`t have same objects");

                        } catch (Exception ex) {

                            System.err.println("Something wrong");

                        }

                    } else

                        System.out.println("Container is null or has 0 elements");

                    break;

                case "-containAll":

                    if (conteiner != null)

                        conteiner.containsAll(createListOfNewElements());

                    else

                        System.out.println("Container is null or has 0 elements");

                    break;

                case "-help":

                    help();

                    break;

                case "-stop":

                    flag = false;

                    break;

                default:

                    System.out.println("Incorrect command!!!");

                    System.out.println("Try again");

                    break;

            }

        } while (flag);

    }



    /**

     * Method that create new fresh list without

     * elements and saved last data to special file

     *

     * @param conteiner in this list will be added new element

     * @return conteiner list of elements

     **/

    public static LinkedC<FilmInfo> createContein(LinkedC<FilmInfo> conteiner) {

        System.err.println("Warning!!!");

        System.err.println("If you have elements in container, it will be lost");

       // System.err.println("So programme saved your last data, on \'D:\\saved.dat\'");

        if (conteiner != null)

            serializeData("D:\\saved.dat", conteiner);

        conteiner = new LinkedC<>();

        System.out.println("Container is created!");

        return conteiner;

    }



  

    public static LinkedC<FilmInfo> removeData(LinkedC<FilmInfo> conteiner) {

        Scanner in;

        if (conteiner != null) {

            if (conteiner.size() != 0) {

                in = new Scanner(System.in);

                System.out.println("Input the index:");

                try {

                    conteiner.removeByIndex(in.nextInt());

                } catch (Exception ex) {

                    System.err.println("Something wrong");

                }

                System.out.println("Done!");

            } else

                System.err.println("Container has 0 elements");

        } else

            System.err.println("Container is null");

        return conteiner;

    }



    /**

     * Method that add new element

     * and return new/fresh list of elemtns

     *

     * @param conteiner in this list will be added new element

     **/

    public static LinkedC<FilmInfo> addData(LinkedC<FilmInfo> conteiner) {

        ConsoleWork work = new ConsoleWork();

        if (conteiner == null)

            conteiner = new LinkedC<>();

        try {

            conteiner.add(work.addFilmInfoFromConsole());

        } catch (Exception ex) {

            System.err.println("Something wrong");

        }



        return conteiner;

    }



   
    public static LinkedC<FilmInfo> createListOfNewElements() {

    	LinkedC<FilmInfo> list = new LinkedC<>();// new conteiner

        ConsoleWork work = new ConsoleWork();// object to print on console

        Scanner in = new Scanner(System.in);// scanner to get data from console

        boolean flag = true;// flag to continue the work in loop



        do {

            switch (in.next()) {

                case "-add":

                    try {

                        list.add(work.addFilmInfoFromConsole());

                    } catch (Exception ex) {

                        System.err.println("Incorrect data");

                    }

                    break;

                case "-stop":

                    flag = false;

                    break;

                default:

                    System.out.println("Try again");

                    break;

            }

        } while (flag);

        return list;

    }




    public static void printData(LinkedC<FilmInfo> conteiner) {

        ConsoleWork work = new ConsoleWork();

        if (conteiner == null || conteiner.size() == 0) {

            System.out.println("Conteiner are empty");

            return;

        }

        for (FilmInfo p : conteiner) {

            work.printFilm(p);

        }

    }





    public static void serializeData(String way, LinkedC<FilmInfo> conteiner) {

        if (conteiner == null)

            return;

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(way));

            oos.writeObject(conteiner);

            oos.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

        System.out.println("Done!");

    }



   

    public static void encodeData(String way, LinkedC<FilmInfo> conteiner) {

        try {

            XMLEncoder encoder = new XMLEncoder(new FileOutputStream(way));

            for (FilmInfo info : conteiner)

                encoder.writeObject(info);

            encoder.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }

        System.out.println("Done!");

    }



   

    public static LinkedC<FilmInfo> deserializeData(String way) throws IOException {

    	LinkedC<FilmInfo> conteiner = null;

        try {

            ObjectInputStream is = new ObjectInputStream(new FileInputStream(way));

            conteiner = (LinkedC<FilmInfo>) is.readObject();

            is.close();

        } catch (IOException e) {

            throw new IOException();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        System.out.println("Done!");

        return conteiner;

    }



   

    public static LinkedC<FilmInfo> decodeData(String way) {

    	LinkedC<FilmInfo> conteiner = new LinkedC<FilmInfo>();

        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream(way))) {

            while (true) {

                FilmInfo info = (FilmInfo) decoder.readObject();

                conteiner.add(info);

            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (ArrayIndexOutOfBoundsException ex) {

        }

        System.out.println("Done!");

        return conteiner;

    }



    /**

     * Method help to print information about commands

     */

    public static void help() {

        System.out.println("Команда -seeData - показує дані контейнера");

        System.out.println("Команда -addData - додавання елемента");

        System.out.println("Команда -removeData - видалення елемента");

        System.out.println("Команда -serializeData - Серіализація");

       System.out.println("Команда -deserializeData - Десериалізація");

        System.out.println("Команда -createContein - створення контейнера");

   

        System.out.println("Команда -contain - перевірка елемента на присутність в масиві");

        System.out.println("Команда -containAll - перевірка на елементи");

    }

}
