package org.lavid.hogares;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class bibleActivity extends AppCompatActivity {
    DatabaseHelper dbHelper = null;

    int id;
    int idLibro;
    int capitulo;
    int versiculoini;
    int versiculofin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bible);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Boolean leido = false;

        id =  getIntent().getIntExtra("ID", 0);
        idLibro =  getIntent().getIntExtra("IDLIBRO", 1);
        capitulo =  getIntent().getIntExtra("CAPITULO", 1);
        versiculoini =  getIntent().getIntExtra("VERSICULOINI",0);
        versiculofin =  getIntent().getIntExtra("VERSICULOFIN",0);


        RecyclerView recyclerView = findViewById(R.id.versesRView);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        // Extract data
        dbHelper = new DatabaseHelper(this);
        String nombreLibro = dbHelper.getBookName(idLibro);
        String[] capDataset = GetTextFromBible();
        if (id > 0) leido = dbHelper.GetLeido(id);

        if(versiculoini!=0) toolbar.setTitle(nombreLibro + " " + capitulo + ":" + versiculoini + "-" + versiculofin);
        else toolbar.setTitle(nombreLibro + " " + capitulo);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Set controls
        RecyclerView.Adapter capAdapter = new bibleAdapter(capDataset);
        recyclerView.setAdapter(capAdapter);


        final FloatingActionButton fab = findViewById(R.id.fab);
        /*
        if(id > 0) {
            if (leido)
                fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorNewRedLight)));
            else
                fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDarkGray)));
        }
        else {
            fab.hide();
        }
        */

        fab.hide();



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Update data
                if(id > 0) {
                    dbHelper = new DatabaseHelper(view.getContext());
                    dbHelper.SetLeido(id);

                    Boolean leido = dbHelper.GetLeido(id);
                    if (leido)
                        fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorNewRedLight)));
                    else
                        fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDarkGray)));
                }

            }
        });


        ImageButton btnLBLA = findViewById(R.id.btnLBLA);
        ImageButton btnRVR = findViewById(R.id.btnRVR);
        ImageButton btnNTV = findViewById(R.id.btnNTV);
        ImageButton btnRVA = findViewById(R.id.btnRVA);

        SetButtons();

        btnLBLA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBible(0);
                // Extract data
                dbHelper = new DatabaseHelper(getApplicationContext());
                String[] capDataset = GetTextFromBible();
                // Set controls
                RecyclerView recyclerView = findViewById(R.id.versesRView);
                RecyclerView.Adapter capAdapter = new bibleAdapter(capDataset);
                recyclerView.setAdapter(capAdapter);
                RestartButtons();
                btnLBLA.setImageResource(R.drawable.lbla_sel);
            }
        });


        btnRVR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBible(1);
                // Extract data
                dbHelper = new DatabaseHelper(getApplicationContext());
                String[] capDataset = GetTextFromBible();
                // Set controls
                RecyclerView recyclerView = findViewById(R.id.versesRView);
                RecyclerView.Adapter capAdapter = new bibleAdapter(capDataset);
                recyclerView.setAdapter(capAdapter);
                RestartButtons();
                btnRVR.setImageResource(R.drawable.rvr_sel);
            }
        });

        btnRVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBible(2);
                // Extract data
                dbHelper = new DatabaseHelper(getApplicationContext());
                String[] capDataset = GetTextFromBible();
                // Set controls
                RecyclerView recyclerView = findViewById(R.id.versesRView);
                RecyclerView.Adapter capAdapter = new bibleAdapter(capDataset);
                recyclerView.setAdapter(capAdapter);
                RestartButtons();
                btnRVA.setImageResource(R.drawable.rva_sel);
            }
        });

        btnNTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBible(3);
                // Extract data
                dbHelper = new DatabaseHelper(getApplicationContext());
                String[] capDataset = GetTextFromBible();
                // Set controls
                RecyclerView recyclerView = findViewById(R.id.versesRView);
                RecyclerView.Adapter capAdapter = new bibleAdapter(capDataset);
                recyclerView.setAdapter(capAdapter);
                RestartButtons();
                btnNTV.setImageResource(R.drawable.ntv_sel);
            }
        });



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(id == 0)
            getMenuInflater().inflate(R.menu.activity_reader_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        RecyclerView recyclerView = findViewById(R.id.versesRView);
        dbHelper = new DatabaseHelper(this);

        int id = item.getItemId();

        if (id == R.id.action_preview) {
            if (capitulo == 1) {
                if(idLibro == 1) return false;
                idLibro = idLibro - 1;
                capitulo = dbHelper.getMaxChapter(idLibro);
            }
            else
            {
                capitulo = capitulo - 1;
            }
         }

        if (id == R.id.action_next) {
            // Extract data
            int max = dbHelper.getMaxChapter(idLibro);

            if(capitulo >= max) {
                if (idLibro == 66) return false;
                idLibro = idLibro + 1;
                capitulo = 1;
            } else {
                capitulo = capitulo + 1;
            }
        }

        String[] capDataset = GetTextFromBible();
        String nombreLibro = dbHelper.getBookName(idLibro);


        if(versiculoini!=0) toolbar.setTitle(nombreLibro + " " + capitulo + ":" + versiculoini + "-" + versiculofin);
        else toolbar.setTitle(nombreLibro + " " + capitulo);

        toolbar.setTitle(nombreLibro + " " + capitulo);
        RecyclerView.Adapter capAdapter = new bibleAdapter(capDataset);
        recyclerView.setAdapter(capAdapter);


        return super.onOptionsItemSelected(item);
    }




    private void SetButtons() {
        RestartButtons();

        ImageButton btnLBLA = findViewById(R.id.btnLBLA);
        ImageButton btnRVR = findViewById(R.id.btnRVR);
        ImageButton btnNTV = findViewById(R.id.btnNTV);
        ImageButton btnRVA = findViewById(R.id.btnRVA);

        int bible = getBible();
        if(bible==0)
            btnLBLA.setImageResource(R.drawable.lbla_sel);
        if(bible==1)
            btnRVR.setImageResource(R.drawable.rvr_sel);
        if(bible==2)
            btnRVA.setImageResource(R.drawable.rva_sel);
        if(bible==3)
            btnNTV.setImageResource(R.drawable.ntv_sel);
    }

    private void RestartButtons() {
        ImageButton btnLBLA = findViewById(R.id.btnLBLA);
        ImageButton btnRVR = findViewById(R.id.btnRVR);
        ImageButton btnNTV = findViewById(R.id.btnNTV);
        ImageButton btnRVA = findViewById(R.id.btnRVA);

        btnLBLA.setImageResource(R.drawable.lbla);
        btnRVR.setImageResource(R.drawable.rvr);
        btnNTV.setImageResource(R.drawable.ntv);
        btnRVA.setImageResource(R.drawable.rva);
    }

    private String[] GetTextFromBible() {
        int bible = getBible();
        if (bible == 0) {
            return dbHelper.getTextFromBibleLBLA(idLibro, capitulo, versiculoini, versiculofin);
        }
        if (bible == 1) {
            return dbHelper.getTextFromBibleRVR(idLibro, capitulo, versiculoini, versiculofin);
        }
        if (bible == 2) {
            return  dbHelper.getTextFromBibleRVA(idLibro, capitulo, versiculoini, versiculofin);
        }
        if (bible == 3) {
            return  dbHelper.getTextFromBibleNTV(idLibro, capitulo, versiculoini, versiculofin);
        }

        return dbHelper.getTextFromBibleLBLA(idLibro, capitulo, versiculoini, versiculofin);
    }

    private void saveBible(int pbible){
        SharedPreferences settings = getApplicationContext().getSharedPreferences("HOGARES_PREFS", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("bible", pbible);
        editor.apply();
    }


    private int getBible(){
        SharedPreferences settings = getApplicationContext().getSharedPreferences("HOGARES_PREFS", 0);
        return settings.getInt("bible", 0);
    }




}


