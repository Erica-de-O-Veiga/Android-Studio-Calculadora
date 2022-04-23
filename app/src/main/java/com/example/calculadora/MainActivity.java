package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Btn_soma, Btn_subtracao, Btn_multiplicacao, Btn_divisao;
    TextView txtNumero1, txtNumero2, txt_Resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vinculoComponentes();
        CriarListeners();
    }

    private  void vinculoComponentes(){
        Btn_soma = findViewById(R.id.btnsoma);
        Btn_subtracao = findViewById(R.id.btnSubtracao);
        Btn_multiplicacao = findViewById(R.id.btnMultiplicacao);
        Btn_divisao = findViewById(R.id.btnDivisao);
        txtNumero1 = findViewById(R.id.txtNum1);
        txtNumero2= findViewById(R.id.txtNum2);
        txt_Resultado=findViewById(R.id.txtResultado);

    }
    private void  CriarListeners(){

        Btn_soma.setOnClickListener(evt -> Calcular("+"));
        Btn_subtracao.setOnClickListener(evt -> Calcular("-"));
        Btn_multiplicacao.setOnClickListener(evt -> Calcular("*"));
        Btn_divisao.setOnClickListener(evt -> Calcular("/"));


    }
    private void Calcular(String operacao){

        String strNumero1 = txtNumero1.getText().toString();
        String strNumero2 = txtNumero2.getText().toString();

        if(strNumero1.isEmpty() || strNumero2.isEmpty()){
            Toast.makeText(this, "Digite dois números", Toast.LENGTH_SHORT).show();
            return  ;
        }
        double numero1= Double.parseDouble(strNumero1);
        double numero2= Double.parseDouble(strNumero2);
        double resultado =0;

       /* resultado = EfetuarCalculo(operacao, numero1, numero2);*/
        if (operacao.equals("+") ) {
               resultado = Adicionar(numero1,numero2);
           }
           else if (operacao.equals("-"))
            {
                resultado = Subtrair(numero1,numero2);
            }
            else if (operacao.equals( "*"))
            {
                resultado = Multiplicar(numero1,numero2);
            }
           else if (operacao.equals( "/")) {
            resultado = Dividir(numero1, numero2);
        }

        finalizarProcesso(resultado);
    }

    private void finalizarProcesso(double resultado){

        txt_Resultado.setText(String.valueOf(resultado));


    }

    /*private double EfetuarCalculo(String operacao,double numero1, double numero2){
        double resultado =  Double.parseDouble(numero1 + operacao + numero2);
        return resultado;

    }*/


    private double Adicionar(double numero1, double numero2){
        return  (numero1 + numero2);
    };
    private double Subtrair(double numero1, double numero2){
        return numero1 - numero2;
    };
    private double Multiplicar(double numero1, double numero2){
        return numero1 * numero2;
    };
    private double Dividir(double numero1, double numero2){
        return numero1 / numero2;
    };
}