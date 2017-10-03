package exampleprilognew.ru.muzis.model.pojo.singers;

import io.realm.RealmObject;

/**
 * Created by Максим on 29.09.2017.
 */

public class Person extends RealmObject {


    private Artist artist;


    public Person(){

    }

    public Person(Artist artist) {
        this.artist = artist;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
