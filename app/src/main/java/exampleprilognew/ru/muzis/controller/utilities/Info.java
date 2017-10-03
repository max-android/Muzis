package exampleprilognew.ru.muzis.controller.utilities;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import exampleprilognew.ru.muzis.R;
import exampleprilognew.ru.muzis.model.Constants;

/**
 * Created by Максим on 29.09.2017.
 */

public class Info {

private View view;
private Context context;

    public Info(View view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void showMessage(int id){

        Snackbar snackbar= Snackbar.make(view,id, Snackbar.LENGTH_SHORT);
        snackbar.setDuration(Constants.TIME);
        View snackbarView =snackbar.getView();
        snackbarView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorSnackbar));
        TextView snackTextView = (TextView)
                snackbarView.findViewById(R.id.snackbar_text);
        Typeface typeSnack =
                Typeface.createFromAsset(context.getResources().getAssets(),"fonts/Roboto-Medium.ttf");
        snackTextView.setTextColor(ContextCompat.getColor(context,R.color.textSnack));
        snackTextView.setTypeface(typeSnack);
        snackTextView.setTextSize(context.getResources().getDimension(R.dimen.text_size_snack));
        snackbar.show();
    }

}
