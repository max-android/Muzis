package exampleprilognew.ru.muzis.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import exampleprilognew.ru.muzis.model.storage.MusicDatabase;

/**
 * Created by Максим on 01.10.2017.
 */


@Module
@Singleton
public class MusicDatabaseModule {

    private Context context;

    public MusicDatabaseModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public MusicDatabase createMusicDatabase(){

        MusicDatabase musicDatabase=new MusicDatabase(context);

        return musicDatabase;

    }



}
