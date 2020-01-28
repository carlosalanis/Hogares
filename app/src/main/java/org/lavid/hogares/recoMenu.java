package org.lavid.hogares;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class recoMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ImageView imgReco; int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reco_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<String> list = new ArrayList<>();
        list.add("1/elpresagio/El Presagio/Jonathan Cahn");
        list.add("2/hacedordecirculos/El Hacedor de Circulos/Mark Batterson");

        String[] recoDataset = new String[list.size()];
        list.toArray(recoDataset);

        recyclerView = findViewById(R.id.recoRView);

        // use a linear layout manager
        layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new recoAdapter(recoDataset);
        recyclerView.setAdapter(mAdapter);

    }

}
