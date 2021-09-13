// Desarrollado por: Edgar Benavides
// Instituto Tecnologico Superior del Sur de Guanajuato
// Programacion Movil 1
// Noveno semestre
// Grupo W71A

package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    Button btn, register;
    EditText name, phone, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn = (Button)findViewById(R.id.btnCancel);
        register = (Button)findViewById(R.id.btnRegister);
        name = (EditText)findViewById(R.id.inputUsername);
        phone = (EditText)findViewById(R.id.inputPhone);
        email = (EditText)findViewById(R.id.inputEmail);
        password = (EditText)findViewById(R.id.inputPassword);

        btn.setOnClickListener(view -> {
            Intent login = new Intent(RegisterActivity.this, LoginActivity.class);
            RegisterActivity.this.startActivity(login);
        });

        register.setOnClickListener(view -> {
            Usuario user = new Usuario();
            user.setName(name.getText().toString());
            user.setPhone(phone.getText().toString());
            user.setEmail(email.getText().toString());
            user.setPassword(password.getText().toString());
            Intent intent = new Intent();
            intent.putExtra("usuario", user);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}