package exampleprilognew.ru.muzis.di;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import exampleprilognew.ru.muzis.model.Constants;
import exampleprilognew.ru.muzis.model.MusicService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Максим on 29.09.2017.
 */


@Module
@Singleton
public class MusicServiceModule {


    @Provides
    @Singleton
    public Retrofit createRetrofit(){

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    @Provides
    @Singleton
    public MusicService createMusicService(@NonNull Retrofit retrofit){

        return retrofit.create(MusicService.class);

    }

}
