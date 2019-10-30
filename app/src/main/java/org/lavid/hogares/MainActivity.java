package org.lavid.hogares;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.widget.ImageView;
import android.view.MenuItem;
import android.widget.Toast;

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




         imgLectura = findViewById(R.id.imgLectura);
         imgLectura.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 Intent mainIntent = new Intent(getApplicationContext(), planActivity.class);
                 startActivity(mainIntent);
             }
         });


        imgSermon = findViewById(R.id.imgSermon);
        imgSermon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), oracionesMenu.class);
                startActivity(mainIntent);
            }
        });


         imgBiblia = findViewById(R.id.imgBiblia);
         imgBiblia.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 Intent mainIntent = new Intent(getApplicationContext(), BookIndexActivity.class);
                 startActivity(mainIntent);
             }
         });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
        if (requestCode == REQUEST) {
            if (grantResults.length <= 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Para utilizar el Plan Anual de Estudio Bíblico de manera correcta, favor de permitir a la aplicación acceder al almacenamiento.", Toast.LENGTH_LONG).show();
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
