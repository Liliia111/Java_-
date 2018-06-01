package ua.lpnuai.oop.ryvak09;

import java.io.Serializable;






public class FilmInfo extends Cinema implements Serializable {

 

    private Cinema mDemandsfilm;// demand film



    /**

     * Simple constructor

     * initialize all data to null/0

     * */

    public FilmInfo(){

        super();

       

        mDemandsfilm = null;
        }


    synchronized public Cinema getMDemandsfilm() {

        return mDemandsfilm;

    }



    /**

     * set-method that set demands of client

     *

     * @param mDemands - demands of client

     * */

    synchronized public void setMDemandsHuman(Cinema mDemands) {

        this.mDemandsfilm = mDemands;

    }
}