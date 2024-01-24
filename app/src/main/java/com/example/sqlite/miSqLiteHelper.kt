package com.example.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class miSqLiteHelper(context: Context) : SQLiteOpenHelper(
    context, "gente.db",null,1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val ordenCreacion = "CREATE TABLE gente" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT," +
                "email TEXT, " +
                "edad INT)"
        db!!.execSQL(ordenCreacion)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS gente"
        db!!.execSQL(ordenBorrado)
        onCreate(db)
    }

    fun addDato(nombre: String, email: String, edad: Int){
        val datos = ContentValues()
        datos.put("nombre",nombre)
        datos.put("email",email)
        datos.put("edad",edad)

        val db = this.writableDatabase
        db.insert("gente",null,datos)
        db.close()
    }




}