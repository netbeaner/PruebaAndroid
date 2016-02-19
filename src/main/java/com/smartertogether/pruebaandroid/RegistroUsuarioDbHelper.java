package com.smartertogether.pruebaandroid;

import com.smartertogether.pruebaandroid.Constantes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.HashMap;


public class RegistroUsuarioDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PruebaAndroid.db";
    public static final String CONTACTS_TABLE_NAME = "usuario";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CONTACTS_COLUMN_PASSWORD = "password";

    private HashMap hp;

    public RegistroUsuarioDbHelper(Context context) {
        super(context,
                DATABASE_NAME,
                null,//factory
                Constantes.DATABASE_VERSION//int version
        );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crear la base de datos
        db.execSQL(
                "CREATE TABLE usuario " +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Actualizar la base de datos
        db.execSQL("DROP TABLE IF EXISTS usuario");
        onCreate(db);
    }

    public boolean insertContact  (String email, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        db.insert("usuario", null, contentValues);
        return true;
    }

}