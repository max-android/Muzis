package exampleprilognew.ru.muzis.model.pojo.singers;

import io.realm.RealmObject;

/**
 * Created by Максим on 29.09.2017.
 */

public class Artist extends RealmObject {

    private String artist_name;
    private int artist_rating;


    public Artist(){

    }

    public Artist(String artist_name, int artist_rating) {
        this.artist_name = artist_name;
        this.artist_rating = artist_rating;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public int getArtist_rating() {
        return artist_rating;
    }


    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public void setArtist_rating(int artist_rating) {
        this.artist_rating = artist_rating;
    }
}
