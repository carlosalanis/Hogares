package org.lavid.hogares;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class mujeresMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mujeres_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ArrayList<String> list = new ArrayList<>();
        list.add("1/COMO VENCER/EL MAL/Cristo viene");


        String[] estudiosDataset = new String[list.size()];
        list.toArray(estudiosDataset);

        recyclerView = findViewById(R.id.mujeresRView);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new mujeresAdapter(estudiosDataset);
        recyclerView.setAdapter(mAdapter);
        
    }

}
