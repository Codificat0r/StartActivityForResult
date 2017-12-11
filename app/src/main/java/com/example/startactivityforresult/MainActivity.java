package com.example.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txvMessageSurname;
    private TextView txvMessageName;
    private Button btnName;
    private Button btnSurname;
    private static final int NAME = 0;
    private static final int SURNAME = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvMessageName = (TextView) findViewById(R.id.txvMessageName);
        txvMessageSurname = (TextView) findViewById(R.id.txvMessageSurname);
        btnName = (Button) findViewById(R.id.btnName);

        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SecondaryActivity.class);
                startActivityForResult(i, NAME);
            }
        });

        btnSurname = (Button) findViewById(R.id.btnSurname);

        btnSurname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SecondaryActivity.class);
                startActivityForResult(i, MainActivity.SURNAME);
            }
        });
    }

    //Se trata de un metodo callback que sera llamado cuando SecondaryActivity finalize.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //1. Se comprueba el código de la peticion

        switch (requestCode) {
            case NAME:
                if (resultCode == Activity.RESULT_OK) {
                    String message = data.getExtras().getString("message");
                    txvMessageName.setText(message);
                }
                break;
            case SURNAME:
                if (resultCode == Activity.RESULT_OK) {
                    String message = data.getExtras().getString("message");
                    txvMessageSurname.setText(message);
                }
                break;
        }

        //2. Se comprueba el resultado
    }
}
