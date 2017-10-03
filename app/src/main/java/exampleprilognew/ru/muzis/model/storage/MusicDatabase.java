package exampleprilognew.ru.muzis.model.storage;

import android.content.Context;

import java.util.List;

import exampleprilognew.ru.muzis.model.Constants;
import exampleprilognew.ru.muzis.model.pojo.music.Music;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Максим on 01.10.2017.
 */


public class MusicDatabase {

    private Realm realm;

    public MusicDatabase(Context context) {

        Realm.init(context);

        RealmConfiguration configuration=new RealmConfiguration.Builder()
                .name(Constants.NAME_DATABASE)
                .build();
        realm=Realm.getInstance(configuration);


    }

           public void copyOrUpdate(List<Music> dbList){
               realm.beginTransaction();
               realm.copyToRealmOrUpdate(dbList);
               realm.commitTransaction();

           }

           public List<Music> getAll(){

               return realm.where(Music.class).findAll();
           }

              public void close(){

              if(!realm.isClosed()){
                   realm.close();
                              }

                      }
}
