package exampleprilognew.ru.muzis.controller.utilities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ProgressBar;

import exampleprilognew.ru.muzis.controller.Transmitter;
import exampleprilognew.ru.muzis.model.MusixmatchService;

/**
 * Created by Максим on 30.09.2017.
 */

public class SwipeManager implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout musicSwipeRefresh;
    private ProgressBar musicProgress;
    private Transmitter transmitter;



    public SwipeManager(SwipeRefreshLayout musicSwipeRefresh, ProgressBar musicProgress, Transmitter transmitter) {
        this.musicSwipeRefresh = musicSwipeRefresh;
        this.musicProgress = musicProgress;
        this.transmitter = transmitter;
    }


    @Override
    public void onRefresh() {

    musicSwipeRefresh.setRefreshing(true);
    musicProgress.setVisibility(View.VISIBLE);
    launchService();
    musicSwipeRefresh.setRefreshing(false);

    }


private void launchService(){
    MusixmatchService musixmatchService=new MusixmatchService(transmitter);
    musixmatchService.executeMusixmatchService();

}

}
