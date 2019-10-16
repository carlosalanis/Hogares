package org.lavid.hogares;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class planActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private int month;
    private int day;
    private int dayCounter;

    String[] planDataset;
    DatabaseHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        Toolbar toolbar = findViewById(R.id.toolbar);
        ProgressBar pBar = findViewById(R.id.pBar);
        TextView txtBar = findViewById(R.id.txtBar);

        toolbar.setTitle("Lecturas para hoy");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.citasRView);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Extract data
        dbHelper = new DatabaseHelper(this);
        planDataset = dbHelper.getCitas();

        // Get actual date
        SimpleDateFormat formateadorfecha = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("MX"));
        SimpleDateFormat formateadordia = new SimpleDateFormat("EEEE", new Locale("MX"));
        Date fechaDate = new Date();

        String fecha = formateadorfecha.format(fechaDate);
        String dia = formateadordia.format(fechaDate);
        month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        // Set controls
        TextView txtDia = findViewById(R.id.txtDia);
        TextView txtFecha = findViewById(R.id.txtFecha);
        txtFecha.setText(fecha);
        txtDia.setText(dia);

        recyclerView.setAdapter(new planAdapter(planDataset));

        int avance = dbHelper.getAvance();
        txtBar.setText(Integer.toString(avance));
        pBar.setProgress(avance);


    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Extract data
        dbHelper = new DatabaseHelper(this);
        planDataset = dbHelper.getCitasDate(month,day);
        recyclerView.setAdapter(new planAdapter(planDataset));

    }


    public void BackPressed(View view){
        dayCounter--;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, dayCounter);
        Date fecha = cal.getTime();
        month = cal.get(Calendar.MONTH) + 1;
        day = cal.get(Calendar.DAY_OF_MONTH);

        // Extract data
        dbHelper = new DatabaseHelper(this);
        planDataset = dbHelper.getCitasDate(month, day);

        // Get actual date
        SimpleDateFormat formateadorfecha = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("MX"));
        SimpleDateFormat formateadordia = new SimpleDateFormat("EEEE", new Locale("MX"));



        String fechaTexto = formateadorfecha.format(fecha);
        String diaTexto = formateadordia.format(fecha);

        // Set controls
        TextView txtDia = findViewById(R.id.txtDia);
        TextView txtFecha = findViewById(R.id.txtFecha);
        txtFecha.setText(fechaTexto);
        txtDia.setText(diaTexto);

        recyclerView.setAdapter(new planAdapter(planDataset));
    }

    public void FwdPressed(View view){
        dayCounter++;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, dayCounter);
        Date fecha = cal.getTime();
        month = cal.get(Calendar.MONTH) + 1;
        day = cal.get(Calendar.DAY_OF_MONTH);

        // Extract data
        dbHelper = new DatabaseHelper(this);
        planDataset = dbHelper.getCitasDate(month, day);

        // Get actual date
        SimpleDateFormat formateadorfecha = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("MX"));
        SimpleDateFormat formateadordia = new SimpleDateFormat("EEEE", new Locale("MX"));

        String fechaTexto = formateadorfecha.format(fecha);
        String diaTexto = formateadordia.format(fecha);

        // Set controls
        TextView txtDia = findViewById(R.id.txtDia);
        TextView txtFecha = findViewById(R.id.txtFecha);
        txtFecha.setText(fechaTexto);
        txtDia.setText(diaTexto);

        recyclerView.setAdapter(new planAdapter(planDataset));

    }


}
