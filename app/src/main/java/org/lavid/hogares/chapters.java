package org.lavid.hogares;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class chapters extends AppCompatActivity {

    WebView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        view = findViewById(R.id.webChapters);
        view.getSettings().setTextZoom(60);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebChromeClient(new WebChromeClient());
//        view.setWebChromeClient(new WebChromeClient() {
//
//            @Override
//            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
//                String title = "";
//                String[] msg = message.split("\\|");
//                if(msg.length > 1) title = msg[1];
//                AlertDialog dialog = new AlertDialog.Builder(view.getContext()).
//                        setTitle("").
//                        setMessage(msg[0]).
//                        setNegativeButton(title, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //do nothing
//                            }
//                        }).
//                        setPositiveButton("CERRAR", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //do nothing
//                            }
//                        }).create();
//                dialog.show();
//                result.confirm();
//                return true;
//            } });

        view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        //view.loadData(getString(R.string.sermon1_text), "text/html", "UTF-8");
        Intent intent = getIntent();
        String cap = intent.getStringExtra("cap");
        view.loadUrl("file:///android_asset/" + cap);

        view.setLongClickable(false);
        view.setHapticFeedbackEnabled(false);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });

        view.addJavascriptInterface(new WebAppInterface(view), "Android");

        FloatingActionButton small = findViewById(R.id.small);
        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textSmaller();
            }
        });

        FloatingActionButton big = findViewById(R.id.big);
        big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textBigger();
            }
        });
    }


    private void textBigger() {

        view = findViewById(R.id.webChapters);
        WebSettings settings = view.getSettings();
        if (settings.getTextZoom() <= 140)
            settings.setTextZoom(settings.getTextZoom() + 10);
    }

    private void textSmaller() {

        view = findViewById(R.id.webChapters);
        WebSettings settings = view.getSettings();
        if (settings.getTextZoom() >= 20)
            settings.setTextZoom(settings.getTextZoom() - 10);
    }


}




