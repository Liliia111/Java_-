package ua.lpnuai.oop.ryvak09;

import java.io.Serializable;

import java.util.LinkedList;





public class Cinema implements Serializable {

	private LinkedList<String> fname;

	private LinkedList<String> fgenre;

    private LinkedList<String> fdirector;

 

    private LinkedList<String> ftext;
   
    private String fdate;
    
    private String fduration;
    
    private String fformat;
    
    private float frate;

    private LinkedList<String> actors;



    /**

     * Simple constructor

     * initialize all data to null/0

     * */

    public Cinema() {

        this.fname = null;

        this.fgenre =  null;

        this.fdirector = null;

        this.actors = null;

        this.ftext = null;

        this.fdate = null;
        
        this.fduration = null;
        
        this.fformat = null;
        
        this.frate = 0;

    }


/////////////////////////////////

    synchronized public LinkedList<String> getfname() {

        return fname;

    }


    synchronized public void setfname(LinkedList<String> fname) {

        this.fname= fname;

    }///////////////////////////////////


    
    synchronized public LinkedList<String> getfgenre() {

        return fgenre;

    }


    synchronized public void setfgenre(LinkedList<String> fgenre) {

        this.fgenre = fgenre;

    }


//////////////////////////////////////////////////////
   


    synchronized public LinkedList<String> getfdirector() {

        return fdirector;

    }


    synchronized public void setfdirector(LinkedList<String> fdirector) {

        this.fdirector = fdirector;

    }
///////////////////////////////////
    

    synchronized public String getfformat() {

        return fformat;

    }

    synchronized public void setfformat(String fformat) {

        this.fformat = fformat;

    }

   /////////////////////////////////////////////////
    synchronized public String getfduration() {

        return fduration;

    }




    synchronized public void setfduration(String fduration) {

        this.fduration = fduration;

    }

   //////////////////////////////////////////////////////////// 
    synchronized public LinkedList<String> getftext() {

        return ftext;

    }


    synchronized public void setftext(LinkedList<String> ftext) {

        this.ftext = ftext;

    }

//////////////////////////////////////////////////////////////////////

    synchronized public String getfdate() {

        return fdate;

    }



    synchronized public void setfdate(String fdate) {

        this.fdate = fdate;

    }

/////////////////////////////////////////////////////////


    synchronized public LinkedList<String> getactors() {

        return actors;

    }


    synchronized public void setactors(LinkedList<String> actors) {

        this.actors = actors;

    }
   /////////////////////////////////////////////////////////////
    
    synchronized public float frate() {

        return frate;

    }



    synchronized public void setfrate(float frate) {

        this.frate = frate;

    }

/////////////////////////////////////////////
}