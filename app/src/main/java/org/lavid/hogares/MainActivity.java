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

public class MainActivity extends AppCompatActivity {

    ImageView imgSermon;
    ImageView imgLectura;
    ImageView imgBiblia;


    private static final int REQUEST = 112;


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


         imgBiblia = (ImageView) findViewById(R.id.imgBiblia);
         imgBiblia.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 Intent mainIntent = new Intent(getApplicationContext(), BookIndexActivity.class);
                 startActivity(mainIntent);
             }
         });

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
