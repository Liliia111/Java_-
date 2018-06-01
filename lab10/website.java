package ua.lpnuai.oop.ryvak09;

public class website {

    private FilmInfo[] films;// all clients in our "DataBase"



    /**

     * Simple constructor

     * initialize data to null

     * */

    public website(){

        films = null;

    }



    /**

     * Constructor with arguments

     * that set ClientInfo array to this.ClientInfo array

     *

     * @param films array of films

     * */

    public website(FilmInfo[] films){

        this.films = films;

    }



    /**

     * get-method that return array of clients

     *

     * @return ClientInfo - array of clients

     * */

    synchronized public FilmInfo[] getFilm() {

        return films;

    }



    /**

     * set-method that set array of clients

     *

     * @param clients - array of clients

     * */

    synchronized public void setFilms(FilmInfo[] films) {

    	 this.films = films;

    }



    /**

     * method that add object in array

     *

     * @param client object that will be added

     * */

    synchronized public void addFilm(FilmInfo film){

        if (films == null){

        	films = new FilmInfo[0];

        }

        int f = films.length;

        FilmInfo[] copyArrayOfFilms = new FilmInfo[films.length + 1];

        for (int i = 0; i < f; i++) {

            copyArrayOfFilms[i] = films[i];

        }

        copyArrayOfFilms[f] = film;

        films = null;

        films = copyArrayOfFilms;

    }



    /**

     * method that remove object from array by index

     *

     * @param index index of object in array

     * @return boolean - result of work

     * */

    synchronized public boolean removeFilm(int index){

        if (films == null || films.length == 0 || (index < 0 || index >= films.length)){

            System.out.println("Can not to delete");

            return false;

        }

        int f = films.length;

        FilmInfo[] copyArrayOfFilms = new FilmInfo[films.length - 1];

        for (int i = 0, j = 0; i < f; i++) {

            if (i != index){

                copyArrayOfFilms[j] = films[i];

                j++;

            }

        }

        films = null;

        films = copyArrayOfFilms;

        return true;

    }



    /**

     * get-method that return object by index

     *

     * @param index index of object in array

     * @return ClientInfo - object with information

     * */

    synchronized public FilmInfo get(int index){

        if (index < films.length

                && index >= 0

                && films != null){

            return films[index];

        }

        return null;

    }

}
