package exampleprilognew.ru.muzis.model.pojo.music;

import io.realm.RealmObject;

/**
 * Created by Максим on 02.10.2017.
 */

public class RealmString extends RealmObject {

    private String track;

    public RealmString() {

    }


    public RealmString(String track) {
        this.track = track;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }
}
