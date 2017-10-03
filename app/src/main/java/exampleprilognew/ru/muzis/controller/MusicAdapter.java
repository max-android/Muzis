package exampleprilognew.ru.muzis.controller;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import exampleprilognew.ru.muzis.R;
import exampleprilognew.ru.muzis.model.pojo.music.Music;

/**
 * Created by Максим on 27.09.2017.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {


private List<Music> musics;

    private Context context;

    public MusicAdapter(List<Music> musics, Context context) {
        this.musics = musics;
        this.context=context;
    }

    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());

        View view=inflater.inflate(R.layout.item_music,parent,false);

        return  new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MusicViewHolder holder, int position) {

        Music music= musics.get(position);
        holder.bindTo(music);

    }

    @Override
    public int getItemCount() {
        return musics.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder{

        private final TextView name;
        private final RecyclerView rvSongs;

    public MusicViewHolder(View itemView) {
        super(itemView);

        name=(TextView)itemView.findViewById(R.id.name);
        rvSongs=(RecyclerView)itemView.findViewById(R.id.rvSongs);
        LinearLayoutManager mLayoutManager=new LinearLayoutManager(context);
        rvSongs.setLayoutManager(mLayoutManager);
        rvSongs.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

    }
        public  void bindTo(Music music){

                name.setText(music.getPerson().getArtist().getArtist_name());
                rvSongs.setAdapter(new SongsAdapter(music.getTracks()));

        }

}


}
