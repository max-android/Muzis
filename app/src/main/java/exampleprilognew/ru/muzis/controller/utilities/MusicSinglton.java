package exampleprilognew.ru.muzis.controller.utilities;

import java.util.ArrayList;
import java.util.List;

import exampleprilognew.ru.muzis.model.pojo.music.Music;

/**
 * Created by Максим on 30.09.2017.
 */

public class MusicSinglton {

    private MusicSinglton(){

    }

    private List<Music> repository;

    public static MusicSinglton singlton;

    public static MusicSinglton getMusicSinglton() {

        if(singlton==null){

            singlton=new MusicSinglton();

        }

        return singlton;
    }

    public void saveMusicCollection(List<Music> musicList){

        repository=new ArrayList<>(musicList);

    }

    public List<Music> getMusicCollection(){

        return repository;
    }
}
