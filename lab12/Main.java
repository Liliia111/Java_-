package ua.lpnuai.oop.ryvak11;

import java.util.Scanner;





public class Main {

    private static LinkedC<FilmInfo> conteiner = new LinkedC<>();// container

    // down line is an array of command

    private static String cArrayOfCommand[] = {"-add", "-remove", "-finder", "-print", "-readFromFile", "-writeInFile",

            "-stop"};



    public static void main(String[] args) {

        boolean mAutoFlag = false; // flag for single/auto work

        boolean mFlag = true;// flag for stop method

        Scanner mIn;// read data fom console

        String mStr;// chooser for switch-case signature



        do {

            System.out.println("Input the command(command -help for print help information):");

            if (!mAutoFlag) {

                mIn = new Scanner(System.in);

                mStr = mIn.next();

            } else {

                mStr = cArrayOfCommand[(int) (0 + Math.random() * cArrayOfCommand.length)];

            }

            switch (mStr) {

                case "-finder":

                    if (conteiner.size() < 2 || conteiner == null)

                        System.err.println("Can`t work without data");

                    if (!mAutoFlag) {

                        Search finder = new Search(conteiner);

                        String regex = "(A.|Actor)? (Name|N|NAME)  (Surname|Lastname)? ";

                        finder.find(regex);

                    } else {

                    	 Search finder = new  Search(conteiner);

                        String regex = "(A.|Actor)? (Name|N|NAME)  (Surname|Lastname)? ";

                        finder.find(regex);
                        System.out.println("Yes");

                    }

                    break;

                case "-add":

                    System.out.println("------Add element------");

                    if (conteiner == null)

                        conteiner = new LinkedC<>();

                    if (!mAutoFlag) {

                        try {

                            conteiner.add(ReadWithRegex.readFromConsole());

                         //   if (conteiner.size() != 0)

                               // WriteInFile.writeToFile(conteiner, "D:\\autogenerate.json");

                      //  
                            } catch (NoMatchData ex) {

                          ex.printError();

                       }

                   } 
                            else {

                        System.out.println("------auto work------");

                        if (conteiner != null || conteiner.size() != 0) {

                            conteiner.add(conteiner.get((int) (0 + Math.random() * conteiner.size())));

                           // if (conteiner.size() != 0)

                               // WriteInFile.writeToFile(conteiner, "D:\\autogenerate.json");

                        }

                    }

                    break;

                case "-remove":

                    System.out.println("------Remove element------");

                    if (!mAutoFlag) {

                        mIn = new Scanner(System.in);

                        System.out.print("Input the index for delete the element: ");

                        if (conteiner != null || conteiner.size() != 0) {

                            conteiner.removeByIndex(mIn.nextInt());

                           // if (conteiner.size() != 0)

                           //     WriteInFile.writeToFile(conteiner, "D:\\autogenerate.json");

                            System.out.println();

                        }

                    } else {

                        System.out.println("------auto work------");

                        if (conteiner != null || conteiner.size() != 0) {

                            int index = (int) (0 + Math.random() * conteiner.size());

                            System.out.println("deleting index = " + index);

                            conteiner.removeByIndex(index);

                        //    if (conteiner.size() != 0)

                          //      WriteInFile.writeToFile(conteiner, "D:\\autogenerate.json");

                        }

                    }

                    break;
                    

                case "-print":

                    System.out.println("------Print elements------");

                    printData();

                    break;

                case "-readFromFile":

                    System.out.println("------Read from file------");

                    if (!mAutoFlag) {

                        mIn = new Scanner(System.in);

                        System.out.println("Input the way to file");

                       // try {

                          //  conteiner = ReadWithRegex.readFromFile(new File(mIn.next()));

                      //  } catch (NoMatchData ex) {

                       //     ex.printError();

                       // }

                  // } else {

                   //     try {

                     //       System.out.println("load out data from autogenerate.json file");

                           // conteiner = ReadWithRegex.readFromFile(new File("D:\\autogenerate.json"));

                       // } catch (NoMatchData ex) {

                       //     ex.printError();

                       // }

                    }

                    break;

                case "-writeInFile":

                    System.out.println("------Write in file------");

                    if (conteiner == null)

                        break;



                    if (!mAutoFlag) {

                        mIn = new Scanner(System.in);

                        System.out.println("Input the way to file");

                     //   WriteInFile.writeToFile(conteiner, mIn.next());

                    } else {

                        System.out.println("Load in data to autogenerate.json");

                       // WriteInFile.writeToFile(conteiner, "D:\\autogenerate.json");

                    }

                    break;

                case "-auto":

                    System.out.println("------Auto/Single Mode------");

                    if (mAutoFlag) {

                        System.err.println("Changed to single work");

                        mAutoFlag = false;

                    } else {

                        System.err.println("Changed to auto work");

                        mAutoFlag = true;

                    }

                    break;

                case "-help":

                    System.out.println("------Help------");

                    helpInfo();

                    break;

                case "-stop":

                    System.err.println("Stop the process");

                    mFlag = false;

                    break;

                default:

                    System.out.println("Bad command");

            }

        } while (mFlag);

    }



    /**

     * Method print all about client

     * by using special class that was developed myself

     */

    private static void printData() {

        if (conteiner == null || conteiner.size() == 0) {

            System.err.println("Container is null or don`t have elements");

            return;

        }

        ConsoleWork work = new ConsoleWork();

        for (FilmInfo film : conteiner) {

            work.printFilm(film);

        }

    }



    /**

     * Help method

     * print all data in console

     */

    private static void helpInfo() {

        System.out.println("Команда -add - додати елемент");

        System.out.println("Команда -remove - видалити елемент");

        System.out.println("Команда -print - вивести все");

     //   System.out.println("Команда -finder - находит клиентов по регулярке");

     //System.out.println("Команда -readFromFile - чтение данных из файла");

       // System.out.println("Команда -writeInFile - запись данных в файла");

        System.out.println("Команда -auto -  авто робота");

    }

}

