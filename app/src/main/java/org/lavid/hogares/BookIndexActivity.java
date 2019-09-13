package org.lavid.hogares;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


public class BookIndexActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter booksAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar pBar;
    private TextView txtBar;

    String[] booksDataset;
    DatabaseHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_index);

        Toolbar toolbar = findViewById(R.id.toolbar);
        pBar = findViewById(R.id.pBar);
        txtBar = findViewById(R.id.txtBar);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        toolbar.setTitle("Libros");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
