package org.lavid.hogares;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class readerActivity extends AppCompatActivity {
    DatabaseHelper dbHelper = null;

    int idLibro;
    int capitulo;
    int versiculoini;
    int versiculofin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reader);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Boolean leido = false;

        final int id =  getIntent().getIntExtra("ID", 0);
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
        String[] capDataset = dbHelper.getTextFromBible(idLibro, capitulo, versiculoini , versiculofin);
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
        if(id > 0) {
            if (leido)
                fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPurple)));
            else
                fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDarkGray)));
        }
        else {
            fab.hide();
        }



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Update data
                if(id > 0) {
                    dbHelper = new DatabaseHelper(view.getContext());
                    dbHelper.SetLeido(id);

                    Boolean leido = dbHelper.GetLeido(id);
                    if (leido)
                        fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPurple)));
                    else
                        fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDarkGray)));
                }

            }
        });


        ImageButton btnLBLA = findViewById(R.id.btnLBLA);
        btnLBLA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Extract data
                dbHelper = new DatabaseHelper(getApplicationContext());
                String[] capDataset = dbHelper.getTextFromBible(idLibro, capitulo, versiculoini , versiculofin);
                // Set controls
                RecyclerView recyclerView = findViewById(R.id.versesRView);
                RecyclerView.Adapter capAdapter = new bibleAdapter(capDataset);
                recyclerView.setAdapter(capAdapter);
            }
        });

        ImageButton btnRVR = findViewById(R.id.btnRVR);
        btnRVR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Extract data
                dbHelper = new DatabaseHelper(getApplicationContext());
                String[] capDataset = dbHelper.getTextFromBibleRVR(idLibro, capitulo, versiculoini , versiculofin);
                // Set controls
                RecyclerView recyclerView = findViewById(R.id.versesRView);
                RecyclerView.Adapter capAdapter = new bibleAdapter(capDataset);
                recyclerView.setAdapter(capAdapter);
            }
        });



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}


