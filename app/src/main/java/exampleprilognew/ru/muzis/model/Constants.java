package exampleprilognew.ru.muzis.model;

/**
 * Created by Максим on 29.09.2017.
 */

public class Constants {

    //key=classified information

    public static final String SINGERS = "chart.artists.get?page=1&page_size=100&country=ru&format=json&apikey=key";

    public static final String SONGS = "track.search?&page_size=10&page=1&s_track_rating=desc&apikey=key";

    public static final String ARTISTS = "q_artist";

    public static final String BASE_URL = "http://api.musixmatch.com/ws/1.1/";

    public static final int TIME=3000;

    public static final String NAME_DATABASE="music_db";

}
