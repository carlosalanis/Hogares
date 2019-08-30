package org.lavid.hogares;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "LBLA.db";
    private final static String DATABASE_PATH = "/data/data/org.lavid.hogares/databases/";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase dataBase;
    private final Context dbContext;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.dbContext = context;
        // checking database and open it if exists
        if (checkDataBase()) {
            openDataBase();
        } else {
            try {
                this.getReadableDatabase();
                copyDataBase();
                this.close();
                openDataBase();

            } catch (IOException e) {
                throw new Error("Error copying database");
            }
            //Toast.makeText(context, "Initial database is created", Toast.LENGTH_LONG).show();
        }
    }

    public void onCreate(SQLiteDatabase db) {

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void copyDataBase() throws IOException {
        InputStream myInput = dbContext.getAssets().open(DATABASE_NAME);
        String outFileName = DATABASE_PATH + DATABASE_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDataBase() {
        String dbPath = DATABASE_PATH + DATABASE_NAME;
        dataBase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        boolean exist = false;
        try {
            String dbPath = DATABASE_PATH + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(dbPath, null,
                    SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            Log.v("db log", "database does't exist");
        }

        if (checkDB != null) {
            exist = true;
            checkDB.close();
        }
        return exist;
    }

    //Select data for the given id
    public String[] getTextFromBible(int idLibro, int capitulo, int versiculoini, int versiculofin) {
        SQLiteDatabase db = this.getReadableDatabase();
        String consulta = "SELECT versiculo, texto FROM bible WHERE idlibro = " + idLibro +  " and capitulo = " + capitulo;

        if(versiculoini != 0) consulta = consulta + " and versiculo >= " + versiculoini;
        if(versiculofin != 0) consulta = consulta + " and versiculo <= " + versiculofin;

        Cursor cursor = db.rawQuery(consulta,null);
        cursor.moveToFirst();
        ArrayList<String> list = new ArrayList<>();

        do {
            list.add(cursor.getString(0) + ":" + cursor.getString(1));
        } while (cursor.moveToNext());

        cursor.close();
        db.close();

        String[] array = new String[list.size()];
        array = list.toArray(array);

        return array;
    }



    public String getBookName(int idLibro) {
        SQLiteDatabase db = this.getReadableDatabase();
        String consulta = "SELECT nombre FROM libros WHERE id = " + idLibro;

        Cursor cursor = db.rawQuery(consulta,null);
        cursor.moveToFirst();

        String nombreLibro = cursor.getString(0);

        cursor.close();
        db.close();

        return nombreLibro;
    }


    public Boolean GetLeido(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String consulta = "SELECT leido FROM plan WHERE id = " + id;

        Cursor cursor = db.rawQuery(consulta,null);
        cursor.moveToFirst();

        String leido = cursor.getString(0);

        cursor.close();
        db.close();
        if(leido.equals("1"))
            return true;
        else
            return false;

    }

    public void SetLeido(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String script = "UPDATE plan SET leido = NOT Leido WHERE id = " + id;

        db.execSQL(script);

        db.close();

    }




    public String[] getCitas() {
        SQLiteDatabase db = this.getReadableDatabase();
        String consulta = "SELECT p.id,mes,dia, idLibro, l.nombre, capitulo, versiculos, p.leido FROM [plan] p, libros l ON p.idLibro = l.id WHERE mes = strftime('%m',date('now')) AND dia = strftime('%d',date('now'))";

        Cursor cursor = db.rawQuery(consulta,null);
        cursor.moveToFirst();

        ArrayList<String> list = new ArrayList<>();

        do {
            list.add(cursor.getString(0) + ":" + cursor.getString(1) + ":" + cursor.getString(2) + ":" + cursor.getString(3) + ":" + cursor.getString(4) + ":" + cursor.getString(5) + ":" + cursor.getString(6) + ":" + cursor.getString(7));
        } while (cursor.moveToNext());

        cursor.close();
        db.close();

        String[] array = new String[list.size()];
        array = list.toArray(array);

        return array;

    }
}