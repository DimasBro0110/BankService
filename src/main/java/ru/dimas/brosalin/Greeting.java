/**
 * Created by DmitriyBrosalin on 11/09/16.
 */

package ru.dimas.brosalin;


public class Greeting {

    private final long id;
    private final String word;

    public Greeting(long id, String word){

        this.id = id;
        this.word = word;

    }

    public long getId(){
        return this.id;
    }

    public String getWord(){
        return this.word;
    }

}
