package org.lavid.hogares;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.widget.ImageView;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ImageView imgMujeres;
    ImageView imgLectura;
    ImageView imgBiblia;
    ImageView imgReco;

    private DrawerLayout mDrawer;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private Toolbar toolbar;

    private static final int REQUEST = 112;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         // Find our drawer view
         //mDrawer = findViewById(R.id.drawer_layout);
         //drawerToggle = setupDrawerToggle();
         // Setup toggle to display hamburger icon with nice animation
         //drawerToggle.setDrawerIndicatorEnabled(true);
         //drawerToggle.syncState();

         // Tie DrawerLayout events to the ActionBarToggle
         //mDrawer.addDrawerListener(drawerToggle);

        // Permissions
         if (Build.VERSION.SDK_INT >= 23) {
             String[] PERMISSIONS = {android.Manifest.permission.WRITE_EXTERNAL_STORAGE};
             if (!hasPermissions(this, PERMISSIONS)) {
                 ActivityCompat.requestPermissions(this, PERMISSIONS, REQUEST );
             }
         }

         // Find and setup drawer view
         //nvDrawer = findViewById(R.id.nvView);
         //setupDrawerContent(nvDrawer);


         imgLectura = findViewById(R.id.imgLectura);
         imgLectura.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 Intent mainIntent = new Intent(getApplicationContext(), planActivity.class);
                 startActivity(mainIntent);
             }
         });

         imgMujeres = findViewById(R.id.imgMujeres);
         imgMujeres.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 Intent mainIntent = new Intent(getApplicationContext(), mujeresMenu.class);
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


         imgReco = findViewById(R.id.imgReco);
         imgReco.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 Intent mainIntent = new Intent(getApplicationContext(), recoMenu.class);
                 startActivity(mainIntent);
             }
         });

         DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext(), true);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //drawerToggle.onConfigurationChanged(newConfig);
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
        if (drawerToggle.onOptionsItemSelected(item)) {
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

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.navigation_drawer_open,  R.string.navigation_drawer_close);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }


    public void selectDrawerItem(MenuItem menuItem) {
        Intent mainIntent;
        //switch(menuItem.getItemId()) {
            //case R.id.nav_mujeres:
            //    mainIntent = new Intent(getApplicationContext(), mujeresMenu.class);
            //    startActivity(mainIntent);
            //    break;
            //case R.id.nav_recomendados:
            //    mainIntent = new Intent(getApplicationContext(), planActivity.class);
            //    startActivity(mainIntent);
            //    break;
            //case R.id.nav_especiales:
            //    mainIntent = new Intent(getApplicationContext(), especialesMenu.class);
            //    startActivity(mainIntent);
            //    break;
        //}

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Close the navigation drawer
        mDrawer.closeDrawers();
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
