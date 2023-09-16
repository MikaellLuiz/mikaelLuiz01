package com.example.mikaelluiz01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalcular = (Button)this.findViewById(R.id.btnLimpar);
        Button btnLimpar = (Button)this.findViewById(R.id.btnLimpar);

        EditText insertText = (EditText)this.findViewById(R.id.insertText);
        TextView txvLabel1 = (TextView)this.findViewById((R.id.txvLabel1));
        TextView txvLabe2 = (TextView)this.findViewById((R.id.txvLabel2));

        Button btnFinalizar = (Button) this.findViewById(R.id.btnFinalizar);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }

        });

    }
}