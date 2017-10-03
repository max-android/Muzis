package exampleprilognew.ru.muzis.model;

import exampleprilognew.ru.muzis.model.pojo.singers.Singers;
import exampleprilognew.ru.muzis.model.pojo.songs.Songs;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by Максим on 29.09.2017.
 */


public interface MusicService {

    @GET(Constants.SINGERS)
   public Call<Singers> singers();

    @GET(Constants.SONGS)
    public Call<Songs> songs(@Query(Constants.ARTISTS) String singer);

}
