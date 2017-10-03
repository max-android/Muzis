package exampleprilognew.ru.muzis.model.pojo.music;


import exampleprilognew.ru.muzis.model.pojo.singers.Person;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Максим on 29.09.2017.
 */

public class Music extends RealmObject {

    @PrimaryKey
    private String id;
    private Person person;

    private RealmList<RealmString> tracks;

    public Music(){

    }

    public Music(Person person, RealmList<RealmString> tracks) {
        this.person = person;
        this.tracks = tracks;
    }

    public Music(String id, Person person, RealmList<RealmString> tracks) {
        this.id=id;
        this.person = person;
        this.tracks = tracks;
    }


    public Person getPerson() {
        return person;
    }

    public RealmList<RealmString> getTracks() {
        return tracks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setTracks(RealmList<RealmString> tracks) {
        this.tracks = tracks;
    }
}
