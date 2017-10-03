package exampleprilognew.ru.muzis.model;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import exampleprilognew.ru.muzis.R;
import exampleprilognew.ru.muzis.controller.Transmitter;
import exampleprilognew.ru.muzis.controller.utilities.Info;
import exampleprilognew.ru.muzis.model.pojo.music.Music;
import exampleprilognew.ru.muzis.model.pojo.music.RealmString;
import exampleprilognew.ru.muzis.model.pojo.singers.Person;
import exampleprilognew.ru.muzis.model.pojo.singers.Singers;
import exampleprilognew.ru.muzis.model.pojo.songs.Song;
import exampleprilognew.ru.muzis.model.pojo.songs.Songs;
import io.realm.RealmList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Максим on 29.09.2017.
 */

public class MusixmatchService {

private Transmitter transmitter;

    private Info info;


    private List<Music> musicList;



    public MusixmatchService(Transmitter transmitter) {
        this.transmitter = transmitter;
        info=new Info(transmitter.getView(),transmitter.getContext());

    }

    public void executeMusixmatchService(){

        createSingers();


    }

    private void createSingers(){

        transmitter.getMusicService().singers().enqueue(new Callback<Singers>() {
            @Override
            public void onResponse(Call<Singers> call, Response<Singers> response) {
                if (response.isSuccessful()) {

                    Singers singers=response.body();

                    List<Person> singersList = singers.getMessage().getBody().getArtist_list();

                    createSongs(singersList);



                }else{

                    info.showMessage(R.string.error_connect);
                    transmitter.getProgress().setVisibility(View.INVISIBLE);
            }
            }

            @Override
            public void onFailure(Call<Singers> call, Throwable t) {
                info.showMessage(R.string.not_network);
                transmitter.getProgress().setVisibility(View.INVISIBLE);
            }
        });

}

private void createSongs(final List<Person> singersList){

    musicList=new ArrayList<>();

    for(final Person person:singersList) {



        transmitter.getMusicService().songs(person.getArtist().getArtist_name()).enqueue(new Callback<Songs>() {
            @Override
            public void onResponse(Call<Songs> call, Response<Songs> response) {

                if (response.isSuccessful()) {
                    Songs songs = response.body();

                    List<Song> songsList = songs.getMessage().getBody().getTrack_list();


                    RealmList<RealmString> tracks = new RealmList<RealmString>();

                    for(Song song:songsList){

                        tracks.add(new RealmString(song.getTrack().getTrack_name()));

                    }

                   int id = singersList.indexOf(person);

                    musicList.add(new Music(String.valueOf(id),person,tracks));

                    if(musicList.size()==singersList.size()) {
                        transmitter.transferListMusic(musicList);
                    }

                } else {

                    info.showMessage(R.string.error_connect);

                }

            }
            @Override
            public void onFailure(Call<Songs> call, Throwable t) {

                info.showMessage(R.string.not_network);

            }
        });

    }
}

}
