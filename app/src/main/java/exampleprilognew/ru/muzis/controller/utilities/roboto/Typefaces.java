package exampleprilognew.ru.muzis.controller.utilities.roboto;

import android.content.Context;
import android.graphics.Typeface;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Максим on 01.10.2017.
 */

public class Typefaces {

    private static final ConcurrentMap<String, Typeface> cache = new ConcurrentHashMap<String, Typeface>();

    public static Typeface get(Context c, String assetPath) {
        synchronized (cache) {
            if (!cache.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(c.getAssets(),
                            assetPath);
                    cache.put(assetPath, t);
                } catch (Exception e) {
                    return null;
                }
            }
            return cache.get(assetPath);
        }
    }
}
