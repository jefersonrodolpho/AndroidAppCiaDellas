package com.ciadellas.imccalc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView_resultadoIMC;
    private EditText editText_peso;
    private EditText editText_altura;
    private Button bt_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_resultadoIMC = findViewById(R.id.textView_resultadoIMC);
        bt_ok = findViewById(R.id.button);
        editText_peso = findViewById(R.id.editText_peso);
        editText_altura = findViewById(R.id.editText_altura);

        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!editText_peso.getText().toString().isEmpty() && !editText_altura.getText().toString().isEmpty()) {

                    double peso = Double.parseDouble(editText_peso.getText().toString());
                    double altura = Double.parseDouble(editText_altura.getText().toString());
                    double IMC = peso / (altura * altura);

                    if (IMC < 18.5) {
                        textView_resultadoIMC.setText(IMC + "\nCuidado!\nVocê está abaixo do peso");
                    } else if (IMC >= 18.5 && IMC < 25) {
                        textView_resultadoIMC.setText(IMC + "\nParabéns!\nVocê está no peso ideal");
                    } else if (IMC >= 25 && IMC < 30) {
                        textView_resultadoIMC.setText(IMC + "\nAtenção!\nVocê está com sobrepeso");
                    } else if (IMC >= 30 && IMC < 35) {
                        textView_resultadoIMC.setText(IMC + "\nCuide da saúde!\nVocê está com Obesidade Grau 1");
                    } else if (IMC >= 35 && IMC < 40) {
                        textView_resultadoIMC.setText(IMC + "\nCuidado!\nVocê está com Obesidade Grau 2");
                    } else if (IMC > 40) {
                        textView_resultadoIMC.setText(IMC + "\nProcure um médico urgente!\nVocê está com Obesidade Grau 3");
                    }
                    else {
                        AlertDialog.Builder a = new AlertDialog.Builder(v.getContext());
                        a.setTitle("Informação!");
                        a.setMessage("Os campos \"Peso\" e \"Altura\" não podem estar vazios. Por favor, insira os valores e tente novamente!");
                        a.setPositiveButton ( "Ok", null);
                        a.create();
                        a.show();
                        textView_resultadoIMC.setText("");
                    }
                    ;
                }
            }

        });
    }
}