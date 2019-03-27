package com.example.ammamentar;

/**
 * Criado por Alan Dantas 08/03/2019
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.nio.channels.WritableByteChannel;

public class DBHelper extends SQLiteOpenHelper {

    private static int versao = 1;
    private static String nome = "Login_Cadastro_BaseDados.db";

    public DBHelper(Context context) {
        super(context, nome, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String str = "CREATE TABLE Utilizador(usuario TEXT PRIMARY KEY, senha TEXT);";
        db.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Utilizador;");
        onCreate(db);
    }

    public long CrierUtilizable(String usuario, String senha) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("usuario", usuario);
        cv.put("senha", senha);
        long result = db.insert("Utilizador", null, cv);
        return result;
    }

    public String ValidaLogin(String usuario, String senha) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Utilizador WHERE usuario=? AND senha=?", new String[]{usuario, senha});
        if (c.getCount() > 0) {
            return "OK";
        }
        return "Erro";
    }
}




