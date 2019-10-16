package org.lavid.hogares;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChapterIndexActivity extends AppCompatActivity {
    private RecyclerView.Adapter chaptersAdapter;
    private RecyclerView.LayoutManager layoutManager;

    String[] chaptersDataset;
    DatabaseHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_index);

        Toolbar toolbar = findViewById(R.id.toolbar);

        int idLibro =  getIntent().getIntExtra("IDLIBRO", 1);
        String nombreLibro =  getIntent().getStringExtra("NOMBRELIBRO");

        toolbar.setTitle(nombreLibro);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.chaptersRView);
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
