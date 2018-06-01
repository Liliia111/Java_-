package ua.lpnuai.oop.ryvak11;
import java.util.LinkedList;

import java.util.Map;

import java.util.regex.Matcher;

import java.util.regex.Pattern;





public class Search {

    private LinkedC<FilmInfo> conteiner;// films

    private Map<Integer,LinkedC<FilmInfo>> mapOfData;//films



    public Search(LinkedC<FilmInfo> conteiner) {

        this.conteiner = conteiner;

    }




    public boolean find(String regex) {

        Data data = new Data(conteiner);

        mapOfData = data.createDataMap();

        for (Map.Entry<Integer, LinkedC<FilmInfo>> entry : mapOfData.entrySet()) {

        	LinkedC<FilmInfo> films = entry.getValue();

            LinkedList<String> list1 = films.get(0).getMDemandsfilm().getfdirector();

            LinkedList<String> list2 = films.get(1).getMDemandsfilm().getfdirector();



            if (specialFinder(list1, regex, parseRegex(regex)) && specialFinder(list2, regex, parseRegex(regex)))

                printSpecClient(films);

        }

        return true;

    }



    

    private void printSpecClient(LinkedC<FilmInfo> films) {

        System.out.println(" Фільми з однаковим режисером ");

        ConsoleWork work = new ConsoleWork();

        for (FilmInfo film : films) {

            work.printFilm(film);

        }

        System.out.println();

    }



  

    private boolean specialFinder(LinkedList<String> list, String PATTERN, LinkedList<LinkedList<String>> specialKeys) {

        Pattern pattern = Pattern.compile(PATTERN);

        for (String data : list) {

            Matcher matcher = pattern.matcher(data);

            if (matcher.find())

                return true;

        }

        return deepSearching(list, specialKeys);

    }



 
    private boolean deepSearching(LinkedList<String> list, LinkedList<LinkedList<String>> specialKeys) {

        int numberOfWord[] = new int[specialKeys.size()];

        int sum = 0;

        for (String text : list) {

            String arraOfWords[] = text.split(" ");



            for (int n : numberOfWord)

                sum += n;

            if (sum >= specialKeys.size()) {

                for (int n : numberOfWord){

                    if (n == 0)

                        return false;

                }

                return true;

            } else {

                sum = 0;

                numberOfWord = new int[specialKeys.size()];

            }

            for (String str : arraOfWords) {

                StringBuilder word = new StringBuilder(str);

                char ch = word.charAt(word.length() - 1);

                if (ch == '.' || ch == ',' || ch == '!' || ch == '?') {

                    word.delete(word.length() - 1, word.length());

                }

                goThrow:

                for (int i = 0; i < specialKeys.size(); i++) {

                    if (numberOfWord[i] != 0)

                        continue;

                    LinkedList<String> list1 = specialKeys.get(i);

                    if (list1.getLast().equals("?"))

                        numberOfWord[i]++;

                    for (String word2 : list1) {

                        if (word.toString().equals(word2)) {

                            numberOfWord[i]++;

                            break goThrow;

                        }

                    }

                }

            }

        }



        for (int n : numberOfWord)

            sum += n;

        if (sum >= specialKeys.size()) {

            for (int n : numberOfWord){

                if (n == 0)

                    return false;

            }

            return true;

        }

        return false;

    }



    

    private LinkedList<LinkedList<String>> parseRegex(String regex) {

        LinkedList<LinkedList<String>> list = new LinkedList<>();

        LinkedList<String> listOfString = new LinkedList<>();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < regex.length(); i++) {

            char ch = regex.charAt(i);

            if (ch == '|') {

                listOfString.add(builder.toString());

                builder.delete(0, builder.length());

            } else if (ch == '?') {

                listOfString = list.get(list.size() - 1);

                listOfString.add("?");

                listOfString = new LinkedList<>();

            } else if (ch != '(' && ch != ')' && ch != ' ') {

                builder.append(ch);

            } else {

                if (!builder.toString().isEmpty()) {

                    listOfString.add(builder.toString());

                    list.add(listOfString);

                    listOfString = new LinkedList<>();

                }

                builder.delete(0, builder.length());

            }

        }

        return list;

    }

}