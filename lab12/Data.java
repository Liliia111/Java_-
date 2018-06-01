package ua.lpnuai.oop.ryvak11;






import java.util.HashMap;

import java.util.Map;



public class Data {

    private LinkedC<FilmInfo> conteiner;// conteiner with clients

    private Map<Integer,LinkedC<FilmInfo>> mapOfData;// map of pair-clients

    private int counter = 0;// counter for mapOfData



   

    public Data(LinkedC<FilmInfo> conteiner) {

        this.conteiner = conteiner;

    }




    public Map<Integer,LinkedC<FilmInfo>> createDataMap(){

        mapOfData = new HashMap<>();

        for (int i = 0; i < conteiner.size(); i++) {

            for (int j = 0; j < conteiner.size(); j++) {

                if (i == j)

                    continue;

              if (equalsObjs(conteiner.get(i),conteiner.get(j))){

                  if (mapOfData.size() == 0) {
                      addToMaps(i, j);

                   } else {

                       if (!checkTheObjectsInMap(conteiner.get(i),conteiner.get(j)))

                           addToMaps(i, j);
                    }

                }

           }

        }

        return mapOfData;

    }




    private boolean checkTheObjectsInMap(FilmInfo f1, FilmInfo f2){

        for (Map.Entry<Integer,LinkedC<FilmInfo>> entry : mapOfData.entrySet()){

        	LinkedC<FilmInfo> list = entry.getValue();

            if (list.contains(f1) && list.contains(f2))

                return true;

        }

        return false;

    }



    private void addToMaps(int i,int j){

    	LinkedC<FilmInfo> listFilms = new LinkedC<>();

        listFilms.add(conteiner.get(i));

        listFilms.add(conteiner.get(j));

        mapOfData.put(counter++,listFilms);

    }



    

   private boolean equalsObjs(FilmInfo f1, FilmInfo f2) {

        final String TIMERPATTERN = "12.12.1990";

        
       if ((f1.getfduration().matches(TIMERPATTERN) && f2.getfduration().matches(TIMERPATTERN))) {

            

            return true;

        }

    return false;

    }

}