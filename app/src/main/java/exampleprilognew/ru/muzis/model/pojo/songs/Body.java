package exampleprilognew.ru.muzis.model.pojo.songs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 28.09.2017.
 */

public class Body {

    private List<Song> track_list=new ArrayList<>();

    public Body(List<Song> track_list) {
        this.track_list = track_list;
    }

    public List<Song> getTrack_list() {
        return track_list;
    }
}
