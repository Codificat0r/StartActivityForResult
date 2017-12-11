package com.example.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondaryActivity extends AppCompatActivity {

    private EditText edtMessage;
    private Button btnCancel;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        edtMessage = (EditText) findViewById(R.id.edtMessage);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        btnSend = (Button) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1. Comprobar que el mensaje no esté vacío
                if (!edtMessage.getText().toString().trim().isEmpty()) {
                    //2. Se añade el mensaje al intent
                    Intent intent = new Intent();
                    intent.putExtra("message", edtMessage.getText().toString());
                    //3. Indicar que el resultado ha sido correcto
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
