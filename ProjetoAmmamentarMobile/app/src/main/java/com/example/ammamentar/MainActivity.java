package com.example.ammamentar;

/**
 * Criado por Alan Dantas 08/03/2019
 */

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class MainActivity extends AppCompatActivity {


    // Tela Splash / Login
    RelativeLayout rellay1, rellay2;

    Handler handler = new Handler();
    Runnable runable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);

        }
    };// Final Splash / Login

    //Login
    EditText txtEmail, txtSenha;
    Button btnEntrar;

    // Btn  Cadastrar
    Button btnCadatrar;

    //Base de Dados
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Base de Dados
        db = new DBHelper(this);


        // Tela Splash / Login
        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);
        handler.postDelayed(runable, 2000);
        // Final Splash / Login

        //Login
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String usuario = txtEmail.getText().toString();
                String senha = txtSenha.getText().toString();

                if (ValidateEmail.isEmailValid(usuario)) {

                    if (usuario.equals("")) {
                        Toast.makeText(MainActivity.this, "Email não digitado corretamente,tente novamente", Toast.LENGTH_SHORT).show();

                    } else if (senha.length() == 0) {
                        Toast.makeText(MainActivity.this, "Senha não digitada corretamente, tente novamente", Toast.LENGTH_SHORT).show();
                        txtSenha.setError("Informe a senha");
                    } else {
                        String res = db.ValidaLogin(usuario, senha);

                        if (res.equals("OK")) {
                            Intent i = new Intent(MainActivity.this, ConsultaActivity.class);
                            startActivity(i);
                            Toast.makeText(MainActivity.this, "Bem vindo", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Login errado, tente novamente", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Tente inserir um registro válido", Toast.LENGTH_SHORT).show();
                    txtEmail.setError("Informe o email");
                }
            }

        }); //Fim btn_entrar

        // Botao Cadastrar

        btnCadatrar = (Button)

                findViewById(R.id.btnCadatrar);

        btnCadatrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(l);
            }
        });
        // Fim Btn Entrar Cadastrar


    }


}
