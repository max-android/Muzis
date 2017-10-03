package exampleprilognew.ru.muzis.controller.utilities.roboto;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import exampleprilognew.ru.muzis.R;

/**
 * Created by Максим on 01.10.2017.
 */

public class MediumTextView extends AppCompatTextView {


    public MediumTextView(Context context) {
        super(context);
    }

    public MediumTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MediumTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }


    private void setFont(Context context) {
        Typeface face = Typefaces.get(context, context.getText(R.string.font_roboto_medium).toString());
        setTypeface(face);
    }

}
