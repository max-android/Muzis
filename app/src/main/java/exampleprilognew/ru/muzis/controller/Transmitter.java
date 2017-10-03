package exampleprilognew.ru.muzis.controller;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import exampleprilognew.ru.muzis.model.MusicService;
import exampleprilognew.ru.muzis.model.pojo.music.Music;

/**
 * Created by Максим on 29.09.2017.
 */

public interface Transmitter {

 MusicService getMusicService();

     Context getContext();

    View getView();

     void transferListMusic(List<Music> musicList);
    ProgressBar getProgress();

}
