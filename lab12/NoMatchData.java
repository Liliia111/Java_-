package ua.lpnuai.oop.ryvak11;

public class NoMatchData extends Exception {

    private String text = "";//text

    NoMatchData(String text){

        this.text = text;

    }



    public void printError(){

        System.err.println("Data that must match, doesn`t match in this text =======>  " + "\"" + text + "\"");

    }

}