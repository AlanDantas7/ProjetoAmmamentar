package com.example.ammamentar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.Calendar;

public class CadastroActivity extends AppCompatActivity {

    //Base de Dados
    DBHelper db;

    //Cadastrar voltar
    EditText txtRegEmail, txtRegSenha, txtRegSenha2;
    Button btnRegistrar;
    Button btnVoltarMain;


    // Calendário
    TextView mTV;
    Button mBtn;
    Calendar c;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Base de Dados
        db = new DBHelper(this);


        //Cadastro
        txtRegEmail = (EditText) findViewById(R.id.txtRegEmail);
        txtRegSenha = (EditText) findViewById(R.id.txtRegSenha);
        txtRegSenha2 = (EditText) findViewById(R.id.txtRegSenha2);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);


        //btnRegistrar = (Button) findViewById(R.id.btnRegistrarnovo);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = txtRegEmail.getText().toString();
                String s1 = txtRegSenha.getText().toString();
                String s2 = txtRegSenha2.getText().toString();

                if (ValidateEmail.isEmailValid(usuario)) {
                    // Toast.makeText(CadastroActivity.this, "Email válido", Toast.LENGTH_SHORT).show();
                    if (usuario.equals("")) {
                        Toast.makeText(CadastroActivity.this, "Usuario ou senha não inserido corretamente, tente novamente", Toast.LENGTH_SHORT).show();
                    } else if (s1.equals("") || s2.equals("")) {
                        Toast.makeText(CadastroActivity.this, "Deve preencher o usuário corretamente, tente novamente", Toast.LENGTH_SHORT).show();
                    } else if (!s1.equals(s2)) {
                        Toast.makeText(CadastroActivity.this, "As senhas não correspondem, tente novamente", Toast.LENGTH_SHORT).show();
                    } else {
                        long res = db.CrierUtilizable(usuario, s1);
                        if (res > 0) {
                            Toast.makeText(CadastroActivity.this, "Registrado com sucesso", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(CadastroActivity.this, "Usuario inválido, tente novamente", Toast.LENGTH_SHORT).show();
                        }
                    }

                    Intent i = new Intent(CadastroActivity.this, MainActivity.class);
                    startActivity(i);

                } else {
                    Toast.makeText(CadastroActivity.this, "Tente registrar um email válido", Toast.LENGTH_SHORT).show();

                }

            }
        });

        //Fim Cadastro


        // Calendário
        /**mTV = (TextView) findViewById(R.id.txtData);
         mBtn = (Button) findViewById(R.id.btnData);

         mBtn.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {

        c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        dpd = new DatePickerDialog(CadastroActivity.this, new DatePickerDialog.OnDateSetListener() {
        @Override public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {

        mTV.setText(mDay + "/" + (mMonth + 1) + "/" + mYear);

        }
        }, day, month, year);
        dpd.show();
        }
        });
         // Fim Calendário

         }
         //Voltar para Tela Login

         public void voltarMain(View view) {

         Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
         startActivity(intent2);
         }
         //Fim voltar Tela Logon*/

        //btn VoltarMain
        btnVoltarMain = (Button) findViewById(R.id.btnVoltarMain);

        btnVoltarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CadastroActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        // Fim Btn VoltarMain
    }
}
