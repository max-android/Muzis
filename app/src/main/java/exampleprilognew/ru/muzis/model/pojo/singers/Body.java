package exampleprilognew.ru.muzis.model.pojo.singers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 29.09.2017.
 */

public class Body {

    private List<Person> artist_list=new ArrayList<>();


    public Body(List<Person> artist_list) {
        this.artist_list = artist_list;
    }

    public List<Person> getArtist_list() {
        return artist_list;
    }



}
