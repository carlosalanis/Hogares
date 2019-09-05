package org.lavid.hogares;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.view.MenuItem;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView imgSermon;
    ImageView imgLectura;

    ViewPager viewPager;
    Integer[] imageId = {
            R.drawable.imghogares, R.drawable.img15, R.drawable.img07, R.drawable.img22, R.drawable.img04,
            R.drawable.img26, R.drawable.img25, R.drawable.img09, R.drawable.img28, R.drawable.img13,
            R.drawable.img14, R.drawable.img02, R.drawable.img16, R.drawable.img17, R.drawable.img29,
            R.drawable.img19, R.drawable.img21, R.drawable.img05, R.drawable.img23, R.drawable.img24,
            R.drawable.img08, R.drawable.img18, R.drawable.img27, R.drawable.img01, R.drawable.img06 };
    int currentPage = 0;
    int NUM_PAGES = 27;
    private static final int REQUEST = 112;
    Timer timer;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Permissions
         if (Build.VERSION.SDK_INT >= 23) {
             String[] PERMISSIONS = {android.Manifest.permission.WRITE_EXTERNAL_STORAGE};
             if (!hasPermissions(this, PERMISSIONS)) {
                 ActivityCompat.requestPermissions(this, PERMISSIONS, REQUEST );
             }
         }


        /* IMAGE PAGER */
        viewPager = findViewById(R.id.autoviewpager);
        PagerAdapter adapter = new CustomAdapter(MainActivity.this,imageId);
        viewPager.setAdapter(adapter);
        viewPager.bringToFront();
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES-1) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };
        timer = new Timer(); // This will create a new Thread
        timer .schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 1000, 10000);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

         imgLectura = (ImageView) findViewById(R.id.imgLectura);
         imgLectura.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 Intent mainIntent = new Intent(getApplicationContext(), planActivity.class);
                 startActivity(mainIntent);
             }
         });


        imgSermon = (ImageView) findViewById(R.id.imgSermon);
        imgSermon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), oracionesMenu.class);
                startActivity(mainIntent);
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //do here
                } else {
                    Toast.makeText(this, "Para utilizar el Plan Anual de Estudio Bíblico de manera correcta, favor de permitir a la aplicacion acceder al almacenamiento.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


    private static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }


}
