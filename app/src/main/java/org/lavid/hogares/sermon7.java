package org.lavid.hogares;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class sermon7 extends AppCompatActivity {

    WebView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sermon7);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        view = findViewById(R.id.txtSermon7);
        view.getSettings().setTextZoom(60);
        view.getSettings().setJavaScriptEnabled(true);
        view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        view.loadData(getString(R.string.sermon7_text), "text/html", "UTF-8");

        view.setLongClickable(false);
        view.setHapticFeedbackEnabled(false);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });

        view.addJavascriptInterface(new WebAppInterface(view), "Android");

        FloatingActionButton small = (FloatingActionButton) findViewById(R.id.small);
        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textSmaller();
            }
        });

        FloatingActionButton big = (FloatingActionButton) findViewById(R.id.big);
        big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textBigger();
            }
        });
    }


    private void textBigger() {

        view = findViewById(R.id.txtSermon7);
        WebSettings settings = view.getSettings();
        if (settings.getTextZoom() <= 140)
            settings.setTextZoom(settings.getTextZoom() + 10);
    }

    private void textSmaller() {

        view = findViewById(R.id.txtSermon7);
        WebSettings settings = view.getSettings();
        if (settings.getTextZoom() >= 20)
            settings.setTextZoom(settings.getTextZoom() - 10);
    }


}




