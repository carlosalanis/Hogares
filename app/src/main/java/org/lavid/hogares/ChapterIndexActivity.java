package org.lavid.hogares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ChapterIndexActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter chaptersAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar pBar;
    private TextView txtBar;

    String[] chaptersDataset;
    DatabaseHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_index);

        Toolbar toolbar = findViewById(R.id.toolbar);
        pBar = findViewById(R.id.pBar);
        txtBar = findViewById(R.id.txtBar);

        int idLibro =  getIntent().getIntExtra("IDLIBRO", 1);
        String nombreLibro =  getIntent().getStringExtra("NOMBRELIBRO");

        toolbar.setTitle(nombreLibro);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.chaptersRView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));

        // Extract data
        dbHelper = new DatabaseHelper(this);
        chaptersDataset = dbHelper.getCaps(idLibro);

        recyclerView.setAdapter(new chaptersAdapter(chaptersDataset, idLibro));

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
