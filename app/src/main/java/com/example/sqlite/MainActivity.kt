package com.example.sqlite

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonGuardar = findViewById<Button>(R.id.BotonGuardar)
        val botonConsultar= findViewById<Button>(R.id.Botonconsultar)




        val genteDBHelper = miSqLiteHelper(this)

        botonGuardar.setOnClickListener {
            val nombre = findViewById<EditText>(R.id.editTextNombre).text.toString()
            val email = findViewById<EditText>(R.id.editTextEmail).text.toString()
            val edad = findViewById<EditText>(R.id.editTextEdad).text.toString().toInt()

            genteDBHelper.addDato(nombre,email,edad)
            Toast.makeText(this, "Persona guardada Correctamente", Toast.LENGTH_SHORT).show()
        }


        botonConsultar.setOnClickListener {

        val info = findViewById<TextView>(R.id.textViewInfo)
        val db : SQLiteDatabase = genteDBHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM gente",null)

        if (cursor.moveToFirst()){
            do {
                info.append(cursor.getInt(0).toString() + ": ")
                info.append(cursor.getString(1).toString()+", ")
                info.append(cursor.getString(2).toString()+", ")
                info.append(cursor.getInt(3).toString()+"\n")
            }while (cursor.moveToNext())
        }
    }


    }
}