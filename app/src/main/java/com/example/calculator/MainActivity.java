package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    ImageView btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    ImageView btn_dot, btn_equals, btn_plus, btn_minus, btn_multiply,divide, btn_ac, btn_remove, btn_module;
    TextView input_text,output_text;

    String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_dot = findViewById(R.id.btn_dot);
        btn_equals = findViewById(R.id.btn_equals);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_multiply = findViewById(R.id.btn_multiply);
        divide = findViewById(R.id.btn_divide);
        btn_ac = findViewById(R.id.btn_AC);
        btn_remove = findViewById(R.id.btn_remove);
        btn_module = findViewById(R.id.btn_module);

        input_text = findViewById(R.id.input_text);
        output_text = findViewById(R.id.output_text);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+"0");

            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+"1");

            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+"2");

            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+"3");

            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+"4");

            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+"5");

            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+"6");

            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+"7");

            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+"8");

            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+"9");

            }
        });


        // Operations Button Click Listner



        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+".");

            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+"+");

            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+"-");

            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+"x");

            }
        });

        btn_module.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+"%");

            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= input_text.getText().toString();
                input_text.setText(data+"÷");

            }
        });

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input_text.setText("");
                output_text.setText("");

            }
        });

        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input_text.getText().toString();
                data= data.replaceAll("x","*");
                data= data.replaceAll("÷","/");
                data= data.replaceAll("%","/100");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult="";

                Scriptable scriptable=rhino.initStandardObjects();
                finalResult=rhino.evaluateString(scriptable,data,"Javsscript",1,null).toString();
                output_text.setText(finalResult);



            }
        });

        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=input_text.getText().toString();
                s=s.substring(0,s.length()-1);
                input_text.setText(s);

            }
        });















    }
}