package com.example.ejercicioclase; // Asegúrate de que coincida con tu paquete

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tvResultado = findViewById(R.id.tvResultado);

        String resultadoFinal = getIntent().getStringExtra("CLAVE_RESULTADO");

        if (resultadoFinal != null) {
            tvResultado.setText(resultadoFinal);
        }
    }
}