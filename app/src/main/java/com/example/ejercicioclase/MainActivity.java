package com.example.ejercicioclase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText etNumero1, etNumero2;
    private Button btnSumar, btnRestar, btnMultiplicar, btnDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero1 = findViewById(R.id.etNumero1);
        etNumero2 = findViewById(R.id.etNumero2);
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);

        btnSumar.setOnClickListener(v -> ejecutarOperacion("+"));
        btnRestar.setOnClickListener(v -> ejecutarOperacion("-"));
        btnMultiplicar.setOnClickListener(v -> ejecutarOperacion("*"));
        btnDividir.setOnClickListener(v -> ejecutarOperacion("/"));
    }

    private void ejecutarOperacion(String operador) {
        String textoNum1 = etNumero1.getText().toString().trim();
        String textoNum2 = etNumero2.getText().toString().trim();

        if (TextUtils.isEmpty(textoNum1) || TextUtils.isEmpty(textoNum2)) {
            Toast.makeText(this, "Por favor, completa ambos campos", Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(textoNum1);
        double n2 = Double.parseDouble(textoNum2);

        OperacionesMatematicas operaciones = new OperacionesMatematicas(n1, n2);
        String resultado = "";

        switch (operador) {
            case "+":
                resultado = String.valueOf(operaciones.sumar());
                break;
            case "-":
                resultado = String.valueOf(operaciones.restar());
                break;
            case "*":
                resultado = String.valueOf(operaciones.multiplicar());
                break;
            case "/":
                resultado = operaciones.dividir();
                break;
        }

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("CLAVE_RESULTADO", resultado);
        startActivity(intent);
    }
}