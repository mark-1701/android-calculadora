package com.example.calculadoraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import org.w3c.dom.ls.LSOutput;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private Button btnIgual;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnPunto;
    private Button btnC;
    private Button btnA;
    private Button btnPorcentaje;
    private Button btnDivision;
    private Button btnMultiplicacion;
    private Button btnResta;
    private Button btnSuma;
    private boolean borrarConsola = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResultado = findViewById(R.id.textResultado);
        btnIgual = findViewById(R.id.btnIgual);
        btnPunto = findViewById(R.id.btnPunto);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnC = findViewById(R.id.btnC);
        btnA = findViewById(R.id.btnA);
        btnPorcentaje = findViewById(R.id.btnPorcentaje);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        btnResta = findViewById(R.id.btnResta);
        btnSuma = findViewById(R.id.btnSuma);

        //textResultado.setText(String.valueOf(result));

        Switch switchToggle = findViewById(R.id.switchPantallas);
        switchToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Intent siguiente = new Intent(MainActivity.this, Conversiones.class);
                    startActivity(siguiente);
                }
            }
        });

        btnPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir(".");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir("9");
            }
        });

        btnPorcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir("%");
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir("/");
            }
        });

        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir("*");
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir("-");
            }
        });

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimir("+");
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResultado.setText("");
            }
        });

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = textResultado.getText().toString();
                if (!expression.isEmpty()) {
                    expression = expression.substring(0, expression.length() - 1);
                    textResultado.setText(expression);
                }
            }
        });


        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = textResultado.getText().toString();
                Expression exp = new ExpressionBuilder(expression).build();
                double result = exp.evaluate();
                String numeroFormateado = String.valueOf(result);
                if (numeroFormateado.endsWith(".0")) {
                    numeroFormateado = numeroFormateado.substring(0, numeroFormateado.length() - 2);
                }
                textResultado.setText(String.valueOf(numeroFormateado));
                //borrarConsola = true;
            }
        });
    }

    public void imprimir(String entrada) {
        /*
        if (borrarConsola) {
            textResultado.setText(entrada);
            borrarConsola = false;
        } else {
            String expression = textResultado.getText().toString() + entrada;
            textResultado.setText(expression);
        }*/
        String expression = textResultado.getText().toString() + entrada;
        textResultado.setText(expression);
    }
}