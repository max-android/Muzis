package exampleprilognew.ru.muzis.di;

import javax.inject.Singleton;

import dagger.Component;
import exampleprilognew.ru.muzis.controller.MusicActivity;

/**
 * Created by Максим on 29.09.2017.
 */

    @Singleton
    @Component(modules = {MusicServiceModule.class,
                          MusicDatabaseModule.class,

    })

    public interface AppComponent {

        void injectMusicActivity(MusicActivity activity);

    }



