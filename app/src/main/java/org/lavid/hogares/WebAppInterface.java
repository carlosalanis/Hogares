package org.lavid.hogares;

import android.content.DialogInterface;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.app.AlertDialog;
import android.os.Build;

public class WebAppInterface {
    View mView;

    /** Instantiate the interface and set the context */
    WebAppInterface(View v) {
        mView = v;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String txt, String cita) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(mView.getContext(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(mView.getContext());
        }

        builder.setMessage(txt);
        if (!cita.equals("undefined"))
            builder.setNeutralButton(cita, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) { }});
        builder.setPositiveButton("CERRAR", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {  } })
                .show();

        /*Snackbar snackbar = Snackbar.make(mView, msg, Snackbar.LENGTH_INDEFINITE)
                .setAction("CERRAR", new View.OnClickListener() { @Override public void onClick(View view) { } });
        TextView snackbarTextView = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
        snackbarTextView.setTextSize(12); snackbarTextView.setMaxLines(50); snackbarTextView.setSingleLine(false);
        snackbar.show();*/

    }
}
