package exampleprilognew.ru.muzis.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import exampleprilognew.ru.muzis.R;
import exampleprilognew.ru.muzis.model.pojo.music.RealmString;


public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder> {


    private List<RealmString> songs;


    public SongsAdapter(List<RealmString> songs) {
        this.songs = songs;
    }

    @Override
    public SongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());

        View view=inflater.inflate(R.layout.item_songs,parent,false);

        return  new SongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongsViewHolder holder, int position) {
        String track= songs.get(position).getTrack();
        holder.bindTo(track);
    }


    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class SongsViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvTrack;

        public SongsViewHolder(View itemView) {
            super(itemView);
            tvTrack=(TextView) itemView.findViewById(R.id.tvTrack);

        }

        public  void bindTo(String track){

            tvTrack.setText(track);

        }
    }

}
