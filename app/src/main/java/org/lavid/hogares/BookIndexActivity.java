package org.lavid.hogares;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.recyclerview.widget.*;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;


public class BookIndexActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter booksAdapter;
    private RecyclerView.LayoutManager layoutManager;

    String[] booksDataset;
    DatabaseHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_index);

        Toolbar toolbar = findViewById(R.id.toolbar);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        toolbar.setTitle("La Biblia de Las Americas");
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
