package id.hridev.myapplication.model;

public class alatCounting {
    private int counter;


    public void menambah() {
        counter++;
    }

    public void mereset() {
        counter = 0;
    }

    public void mengurangi() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }
}
