package org.lavid.hogares;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.core.Amplify;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class mujeresMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ImageView imgMujeres; int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mujeres_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int week = calendar.get(Calendar.WEEK_OF_YEAR);

        // Get from the SharedPreferences
        SharedPreferences settings = getApplicationContext().getSharedPreferences("HOGARES_PREFS", 0);
        boolean isAdmin = settings.getBoolean("isAdmin", false);

        imgMujeres = findViewById(R.id.imgMDLB);
        imgMujeres.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                counter++;
                if((counter == 10) && !isAdmin) {
                    SharedPreferences settings = getApplicationContext().getSharedPreferences("HOGARES_PREFS", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean("isAdmin", true);
                    editor.apply();

                    Toast.makeText(mujeresMenu.this, "Listo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //S3FileInfo info = new S3FileInfo();
        //String[] fileList = info.listFiles();

        //new S3DownloadFileFromURL(mujeresMenu.this).execute("");

        ArrayList<String> list = new ArrayList<>();
        list.add("1/EVA/MADRE DE TODOS LOS VIVIENTES/vida eterna");

        list.add(0,"2/SARA/HEROÍNA DE LA FE/promesa cumplida");
        list.add(0,"3/REBECA/MATRIARCA DEL PUEBLO DE DIOS/pueblo escogido");
        list.add(0,"4/LEA Y RAQUEL/EDIFICARON LA CASA DE ISRAEL/servicio");
        list.add(0,"5/RAHAB/UNA VIDA REDIMIDA/generosidad");
        list.add(0,"6/DÉBORA/LA MADRE Y JUEZ DE ISRAEL/alabanza");
        list.add(0,"7/RUT/UNA HISTORIA DE LEALTAD Y REDENCIÓN/lealtad");
        list.add(0,"8/ANA/MUJER DE ORACIÓN Y FE/anhelo");
        list.add(0,"9/ESTER/LA REINA QUE INTERCEDIÓ POR SU PUEBLO/proposito");
        list.add(0,"10/MARÍA/UNA VIDA DE FE, OBEDIENCIA Y HUMILDAD/obediencia");
        list.add(0,"11/ELISABET/LA MADRE DEL MAYOR HOMBRE QUE HAYA NACIDO/humildad");
        list.add(0,"12/LA SAMARITANA/SU ENCUENTRO CON EL AGUA VIVA/entrega");
        list.add(0,"13/LIDIA/UN CORAZÓN DISPUESTO Y HOSPITALARIO/fidelidad");
        list.add(0,"14/MARTA Y MARÍA/TRABAJO Y ADORACIÓN/adoracion");
        String[] estudiosDataset = new String[list.size()];
        list.toArray(estudiosDataset);

        recyclerView = findViewById(R.id.mujeresRView);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new mujeresAdapter(estudiosDataset);
        recyclerView.setAdapter(mAdapter);

    }

    private void uploadFile() {
        File sampleFile = new File(getApplicationContext().getFilesDir(), "sample.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(sampleFile));
            writer.append("Howdy World!");
            writer.close();
        }
        catch(Exception exception) {
            Log.e("StorageQuickstart", exception.getMessage(), exception);
        }

        Amplify.Storage.uploadFile(
                "myUploadedFileName.txt",
                sampleFile.getAbsolutePath(),
                result -> Log.i("StorageQuickStart", "Successfully uploaded: " + result.getKey()),
                storageFailure -> Log.e("StorageQuickstart", "Upload error.", storageFailure)
        );
    }

}
