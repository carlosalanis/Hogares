package org.lavid.hogares;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String OLD_DATABASE_NAME = "LBLA.db";
    private static String DATABASE_NAME = "Bible.db";
    private final static String DATABASE_PATH = "/data/data/org.lavid.hogares/databases/";
    private static final int DATABASE_VERSION = 4;

    private final Context dbContext;


    public DatabaseHelper(Context context, boolean clear) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.dbContext = context;

        context.deleteDatabase(OLD_DATABASE_NAME);
        context.deleteDatabase(DATABASE_NAME);

    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.dbContext = context;

        // checking database and open it if exists
        if (!checkDataBase()) {
            try {
                //this.getReadableDatabase();
                copyDataBaseFromAsset();
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
        try {
            if(newVersion>oldVersion) {
                copyDataBaseFromAsset();
            }
        } catch (IOException e) {
            throw new Error("Error copying database");
        }

    }

    private void copyDataBaseFromAsset() throws IOException {
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
        SQLiteDatabase dataBase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        boolean exist = false;
        try {
            String dbPath = DATABASE_PATH + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLiteException e) {
            Log.v("db log", "database does't exist");
        }

        if (checkDB != null) {
            exist = true;
            checkDB.close();
        }
        return exist;
    }






    public String[] getTextFromBibleLBLA(int idLibro, int capitulo, int versiculoini, int versiculofin) {
        SQLiteDatabase db = this.getReadableDatabase();
        String consulta = "SELECT versiculo, texto FROM bibleLBLA WHERE idlibro = " + idLibro +  " and capitulo = " + capitulo;

        if(versiculoini != 0) consulta = consulta + " and versiculo >= " + versiculoini;
        if(versiculofin != 0) consulta = consulta + " and versiculo <= " + versiculofin;

        Cursor cursor = db.rawQuery(consulta,null);
        cursor.moveToFirst();
        ArrayList<String> list = new ArrayList<>();

        do {
            list.add(cursor.getString(0) + "/" + cursor.getString(1));
        } while (cursor.moveToNext());

        cursor.close();
        db.close();

        String[] array = new String[list.size()];
        array = list.toArray(array);

        return array;
    }



    public String[] getTextFromBibleRVR(int idLibro, int capitulo, int versiculoini, int versiculofin) {
        SQLiteDatabase db = this.getReadableDatabase();
        String consulta = "SELECT versiculo, texto FROM bibleRVR WHERE idlibro = " + idLibro +  " and capitulo = " + capitulo;

        if(versiculoini != 0) consulta = consulta + " and versiculo >= " + versiculoini;
        if(versiculofin != 0) consulta = consulta + " and versiculo <= " + versiculofin;

        Cursor cursor = db.rawQuery(consulta,null);
        cursor.moveToFirst();
        ArrayList<String> list = new ArrayList<>();

        do {
            list.add(cursor.getString(0) + "/" + cursor.getString(1));
        } while (cursor.moveToNext());

        cursor.close();
        db.close();

        String[] array = new String[list.size()];
        array = list.toArray(array);

        return array;
    }


    public String[] getTextFromBibleNTV(int idLibro, int capitulo, int versiculoini, int versiculofin) {
        SQLiteDatabase db = this.getReadableDatabase();
        String consulta = "SELECT versiculo, texto FROM bibleNTV WHERE idlibro = " + idLibro +  " and capitulo = " + capitulo;

        if(versiculoini != 0) consulta = consulta + " and versiculo >= " + versiculoini;
        if(versiculofin != 0) consulta = consulta + " and versiculo <= " + versiculofin;

        Cursor cursor = db.rawQuery(consulta,null);
        cursor.moveToFirst();
        ArrayList<String> list = new ArrayList<>();

        do {
            list.add(cursor.getString(0) + "/" + cursor.getString(1));
        } while (cursor.moveToNext());

        cursor.close();
        db.close();

        String[] array = new String[list.size()];
        array = list.toArray(array);

        return array;
    }


    public String[] getTextFromBibleRVA(int idLibro, int capitulo, int versiculoini, int versiculofin) {
        SQLiteDatabase db = this.getReadableDatabase();
        String consulta = "SELECT versiculo, texto FROM bibleRVR15 WHERE idlibro = " + idLibro +  " and capitulo = " + capitulo;

        if(versiculoini != 0) consulta = consulta + " and versiculo >= " + versiculoini;
        if(versiculofin != 0) consulta = consulta + " and versiculo <= " + versiculofin;

        Cursor cursor = db.rawQuery(consulta,null);
        cursor.moveToFirst();
        ArrayList<String> list = new ArrayList<>();

        do {
            list.add(cursor.getString(0) + "/" + cursor.getString(1));
        } while (cursor.moveToNext());

        cursor.close();
        db.close();

        String[] array = new String[list.size()];
        array = list.toArray(array);

        return array;
    }



    public String[] getCitas() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        Date fechaDate = new Date();
        SimpleDateFormat formateadorMes = new SimpleDateFormat("MM", new Locale("MX"));
        SimpleDateFormat formateadorDia = new SimpleDateFormat("dd", new Locale("MX"));
        String mes = formateadorMes.format(fechaDate);
        String dia = formateadorDia.format(fechaDate);
        String[] array = null;

        String consulta = "SELECT p.id,mes,dia, idLibro, l.nombre, capitulo, versiculos, p.leido FROM [plan] p, libros l ON p.idLibro = l.id WHERE mes = " + mes + " AND dia = "  +  dia;

        cursor = db.rawQuery(consulta, null);
        cursor.moveToFirst();


        ArrayList<String> list = new ArrayList<>();

        do {
            list.add(cursor.getString(0) + "/" + cursor.getString(1) + "/" + cursor.getString(2) + "/" + cursor.getString(3) + "/" + cursor.getString(4) + "/" + cursor.getString(5) + "/" + cursor.getString(6) + "/" + cursor.getString(7));
        } while (cursor.moveToNext());

        cursor.close();
        db.close();

        array = new String[list.size()];
        list.toArray(array);

        return array;

    }



    public String[] getCitasDate(int mes,int dia) {
        SQLiteDatabase db = this.getReadableDatabase();

        String consulta = "SELECT p.id,mes,dia, idLibro, l.nombre, capitulo, versiculos, p.leido FROM [plan] p, libros l ON p.idLibro = l.id WHERE mes = " + mes + " AND dia = "  +  dia;

        Cursor cursor = db.rawQuery(consulta,null);
        cursor.moveToFirst();

        ArrayList<String> list = new ArrayList<>();

        do {
            list.add(cursor.getString(0) + "/" + cursor.getString(1) + "/" + cursor.getString(2) + "/" + cursor.getString(3) + "/" + cursor.getString(4) + "/" + cursor.getString(5) + "/" + cursor.getString(6) + "/" + cursor.getString(7));
        } while (cursor.moveToNext());

        cursor.close();
        db.close();

        String[] array = new String[list.size()];
        list.toArray(array);

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
        return leido.equals("1");
    }



    public void SetLeido(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String script = "UPDATE plan SET leido = NOT Leido WHERE id = " + id;

        db.execSQL(script);

        db.close();

    }

    public int getMaxChapter(int idLibro) {
        SQLiteDatabase db = this.getReadableDatabase();
        String consulta = "select max(capitulo) from bibleLBLA where idLibro = " + idLibro;

        Cursor cursor = db.rawQuery(consulta,null);
        cursor.moveToFirst();

        int max = cursor.getInt(0);

        cursor.close();
        db.close();
        return max;
    }



//    public int getAvance() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String consulta = "SELECT AVG(leido = 1) * 100 AS Avance FROM [plan]";
//
//        Cursor cursor = db.rawQuery(consulta,null);
//        cursor.moveToFirst();
//
//        int avance = cursor.getInt(0);
//
//        cursor.close();
//        db.close();
//
//        return avance;
//    }



    public String GetNumVersiculos(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String consulta = "SELECT count(versiculos) as versiculos FROM [plan] p, bibleLBLA b ON p.idLibro = b.IdLibro AND p.Capitulo = b.capitulo WHERE p.id = " + id;

        Cursor cursor = db.rawQuery(consulta,null);
        cursor.moveToFirst();

        String versiculos = cursor.getString(0);

        cursor.close();
        db.close();

        return versiculos;

    }


    public String[] getLibros(String tipo) {
        SQLiteDatabase db = this.getReadableDatabase();

        String consulta = "SELECT id, nombre FROM [libros]";
        switch(tipo) {
            case "1":
                consulta = consulta + " where id < 40";
                break;
            case "2":
                consulta = consulta + " where id >= 40";
                break;
            default:
                break;
        }


        Cursor cursor = db.rawQuery(consulta,null);
        cursor.moveToFirst();

        ArrayList<String> list = new ArrayList<>();

        do {
            list.add(cursor.getInt(0) + "/" + cursor.getString(1));
        } while (cursor.moveToNext());

        cursor.close();
        db.close();

        String[] array = new String[list.size()];
        list.toArray(array);

        return array;

    }


    public String[] getCaps(int idLibro) {
        SQLiteDatabase db = this.getReadableDatabase();

        String consulta = "SELECT max(capitulo) FROM bibleLBLA where idLibro = " + idLibro;

        Cursor cursor = db.rawQuery(consulta,null);
        cursor.moveToFirst();

        int caps = cursor.getInt(0);

        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<caps;i++) {
            list.add(String.valueOf(i+1));
        }

        String[] array = new String[list.size()];
        list.toArray(array);

        cursor.close();
        db.close();

        return array;

    }


}