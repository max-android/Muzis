package exampleprilognew.ru.muzis.di;

import android.app.Application;


/**
 * Created by Максим on 29.09.2017.
 */

public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .musicServiceModule(new MusicServiceModule())
                .musicDatabaseModule(new MusicDatabaseModule(this))
                .build();
    }
}
