package com.example.mikaelluiz01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;

public class MainActivity extends AppCompatActivity {
    private EditText insertText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalcular = (Button)this.findViewById(R.id.btnCalcular);
        Button btnLimpar = (Button)this.findViewById(R.id.btnCalcular);
        EditText insertText = (EditText)this.findViewById(R.id.insertText);
        EditText insertText2 = (EditText)this.findViewById(R.id.insertText2);

        TextView txvLabel1 = (TextView)this.findViewById(R.id.txvLabel1);
        TextView txvLabel2 = (TextView)this.findViewById(R.id.txvLabel2);
        TextView textView6 = (TextView)this.findViewById(R.id.textView6);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertText.setText("");
                txvLabel1.setText("");

            }
        });
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = insertText.getText().toString().toLowerCase();
                String caracter = insertText2.getText().toString().toLowerCase();
                if (texto.equals("")){
                    Toast.makeText(getApplicationContext(), "O campo de texto está vazio. Insira e Tente novamente!", Toast.LENGTH_LONG).show();
                }else if(caracter.equals("")){
                    Toast.makeText(getApplicationContext(), "O campo de caracter está vazio. Insira e Tente novamente!", Toast.LENGTH_LONG).show();
                }else{
                    //Calcula o numero de caracteres do texto
                    int tamanho = texto.length();
                    txvLabel1.setText(String.valueOf(tamanho).toString());

                    //calcula o numero de caracters do caracter selecionado
                    int contCaracter = 0;
                    for(int i=0; i<tamanho; i++){
                        if(texto.charAt(i)==caracter.charAt(0)){
                            contCaracter++;
                        }
                    }
                    txvLabel2.setText(String.valueOf(contCaracter).toString());
                    textView6.setText("Numero de Caracteres '"+caracter+"'");
                }
                //Responsavel por remover o teclado quando o botão calcular for selecionado
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(insertText.getWindowToken(), 0);
            }
        });

        //Responsavel por remover o teclado quando o elemento EditText perde o foco
        View rootView = findViewById(android.R.id.content);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertText.clearFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(insertText.getWindowToken(), 0);
            }
        });

        Button btnFinalizar = (Button) this.findViewById(R.id.btnFinalizar);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }

        });
    }
}