package exampleprilognew.ru.muzis.controller;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import exampleprilognew.ru.muzis.R;
import exampleprilognew.ru.muzis.controller.utilities.MusicSinglton;
import exampleprilognew.ru.muzis.controller.utilities.NetInspector;
import exampleprilognew.ru.muzis.controller.utilities.SwipeManager;
import exampleprilognew.ru.muzis.di.App;
import exampleprilognew.ru.muzis.model.MusicService;
import exampleprilognew.ru.muzis.model.MusixmatchService;
import exampleprilognew.ru.muzis.model.pojo.music.Music;
import exampleprilognew.ru.muzis.model.storage.MusicDatabase;


public class MusicActivity extends AppCompatActivity implements Transmitter {


    private CoordinatorLayout coordinatorLayout;
    private RecyclerView recyclerMusixmatch;
    private ProgressBar musicProgress;
    private SwipeRefreshLayout musicSwipeRefresh;
    private SwipeManager swipeManager;
    private List<Music> finalMusicList;

    private boolean statusNet;

    @Inject
    public MusicService musicService;

    @Inject
    public MusicDatabase musicDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        statusNet=NetInspector.isOnline(this);

        App.getAppComponent().injectMusicActivity(this);

        initComponents();

        if(statusNet){

            launchService();

        }else{

            launchDatabase();
        }
    }

    @Override
    public MusicService getMusicService() {

        return  musicService;
    }

    @Override
    public Context getContext() {
        return MusicActivity.this;
    }

    @Override
    public View getView() {
        return coordinatorLayout;
    }

    @Override
    public void transferListMusic(List<Music> musicList) {

            finalMusicList = new ArrayList<>(musicList);

            showMusicList(finalMusicList);

    }

    @Override
    public ProgressBar getProgress() {
        return musicProgress;
    }


    private void showMusicList(List<Music> musicList){

        recyclerMusixmatch.setAdapter(new MusicAdapter(musicList, this));


        if(statusNet){


            musicDatabase.copyOrUpdate(musicList);
        }


        musicProgress.setVisibility(View.INVISIBLE);

    }


    private  void initComponents(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        coordinatorLayout =(CoordinatorLayout)findViewById(R.id.coordMusic);
        recyclerMusixmatch=(RecyclerView)findViewById(R.id.recyclerMusixmatch);
        LinearLayoutManager mLayoutManager=new LinearLayoutManager(this);
        recyclerMusixmatch.setLayoutManager(mLayoutManager);
        recyclerMusixmatch.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        musicProgress=(ProgressBar)findViewById(R.id.musicProgress);
        musicProgress.setVisibility(View.VISIBLE);
        musicSwipeRefresh=(SwipeRefreshLayout)findViewById(R.id.musicSwipeRefresh);
        musicSwipeRefresh.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.CYAN);
        swipeManager=new SwipeManager(musicSwipeRefresh,musicProgress,this);
        musicSwipeRefresh.setOnRefreshListener(swipeManager);
        musicSwipeRefresh.setRefreshing(false);

    }

    private void launchService(){

        if(MusicSinglton.getMusicSinglton().getMusicCollection()!=null){

            showMusicList(MusicSinglton.getMusicSinglton().getMusicCollection());

        }else{

            MusixmatchService musixmatchService=new MusixmatchService(this);

            musixmatchService.executeMusixmatchService();

        }
    }

    private void launchDatabase(){

        showMusicList(musicDatabase.getAll());

    }


    @Override
    protected void onPause() {
        super.onPause();

        if(finalMusicList!=null) {

            MusicSinglton.getMusicSinglton().saveMusicCollection(finalMusicList);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        musicDatabase.close();

    }
}
