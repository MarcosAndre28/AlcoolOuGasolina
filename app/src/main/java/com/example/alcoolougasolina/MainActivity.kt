package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun btCalcular(view: View){
        //recupera valores digitados
        //Utilizando o kotlin extensions
        val precoAlcool = precoAlcool.text.toString()
        val precoGasolina = precoGasolina.text.toString()

        val validacampos = validarCampos(precoAlcool, precoGasolina)
        if (validacampos){
            calcularMelhorPreco(precoAlcool, precoGasolina)
        }else{
            opcaodeescolha.setText("Preencha os preços primeiro!")
        }


    }
    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String){
        //Converter valores string para numeros
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val resultadoPreco = valorAlcool / valorGasolina
        if (resultadoPreco >= 0.7){
            opcaodeescolha.setText("Melhor Utilizar Gasolina")
        }else{
            opcaodeescolha.setText("Melhor Utilizar Álcool")
        }

    }
    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean{
        var camposValidados: Boolean = true

        if (precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if (precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }

        return camposValidados
    }
}