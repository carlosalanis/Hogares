package org.lavid.hogares;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class readerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter capAdapter;
    private RecyclerView.LayoutManager layoutManager;
    DatabaseHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);
        Toolbar toolbar = findViewById(R.id.toolbar);


        final int id =  getIntent().getIntExtra("ID", 0);
        int idLibro =  getIntent().getIntExtra("IDLIBRO", 1);
        int capitulo =  getIntent().getIntExtra("CAPITULO", 1);
        int versiculoini =  getIntent().getIntExtra("VERSICULOINI",0);
        int versiculofin =  getIntent().getIntExtra("VERSICULOFIN",0);


        recyclerView = findViewById(R.id.versesRView);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        // Extract data
        dbHelper = new DatabaseHelper(this);
        String nombreLibro = dbHelper.getBookName(idLibro);
        String[] capDataset = dbHelper.getTextFromBible(idLibro, capitulo, versiculoini , versiculofin);
        Boolean leido = dbHelper.GetLeido(id);


        if(versiculoini!=0) toolbar.setTitle(nombreLibro + " " + capitulo + ":" + versiculoini + "-" + versiculofin);
        else toolbar.setTitle(nombreLibro + " " + capitulo);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Set controls
        capAdapter = new bibleAdapter(capDataset);
        recyclerView.setAdapter(capAdapter);


        final FloatingActionButton fab = findViewById(R.id.fab);
        if(leido)
            fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBlue)));
        else
            fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGray)));




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Update data
                dbHelper = new DatabaseHelper(view.getContext());
                dbHelper.SetLeido(id);

                Boolean leido = dbHelper.GetLeido(id);
                if(leido)
                    fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBlue)));
                else
                    fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGray)));



            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}


