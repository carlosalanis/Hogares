package org.lavid.hogares;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class estudios extends AppCompatActivity {

    WebView view;
    int fontSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudios);

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fontSize = getFontSize();

        view = findViewById(R.id.webChapters);
        view.getSettings().setTextZoom(fontSize);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebChromeClient(new WebChromeClient());
        view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        Intent intent = getIntent();
        String cap = intent.getStringExtra("cap");
        Boolean bible = intent.getBooleanExtra("bible", false);

        view.loadUrl("file:///android_asset/" + cap);

        view.setLongClickable(true);
        view.setHapticFeedbackEnabled(true);
        //view.setOnLongClickListener(new View.OnLongClickListener() {
        //    @Override
        //    public boolean onLongClick(View v) {
        //        return true;
        //    }
        //});

        view.addJavascriptInterface(new WebAppInterface(view), "Android");

        FloatingActionButton small = findViewById(R.id.small);
        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textSmaller();
            }
        });

        FloatingActionButton cbible = findViewById(R.id.bible);
        cbible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBible();
            }
        });

        if(bible) cbible.show();
        else cbible.hide();

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
        int size = settings.getTextZoom();
        if (size <= 140)
            size = size + 10;

        settings.setTextZoom(size);
        setFontSize(size);
    }

    private void textSmaller() {
        view = findViewById(R.id.webChapters);
        WebSettings settings = view.getSettings();
        int size = settings.getTextZoom();
        if (size >= 20)
            size = size - 10;

        settings.setTextZoom(size);
        setFontSize(size);

    }

    private void goBible() {
        Intent mainIntent = new Intent(getApplicationContext(), BookIndexActivity.class);
        startActivity(mainIntent);
    }


    private int getFontSize(){
        SharedPreferences settings = getApplicationContext().getSharedPreferences("HOGARES_PREFS", 0);
        return settings.getInt("fontSize", 50);
    }

    private void setFontSize(int fontSize){
        SharedPreferences settings = getApplicationContext().getSharedPreferences("HOGARES_PREFS", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("fontSize", fontSize);
        editor.apply();
    }


}




