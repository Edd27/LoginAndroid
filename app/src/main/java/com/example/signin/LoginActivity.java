// Desarrollado por: Edgar Benavides
// Instituto Tecnologico Superior del Sur de Guanajuato
// Programacion Movil 1
// Noveno semestre
// Grupo W71A

package com.example.signin;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btn;

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        Usuario user = (Usuario)intent.getSerializableExtra("usuario");
                        Log.e("Username", user.getName());
                        Log.e("Phone", user.getPhone());
                        Log.e("Email", user.getEmail());
                        Log.e("Password", user.getPassword());
                        String values = "Name: " + user.getName() + "\nPhone: " + user.getPhone() + "\nEmail: " + user.getEmail() + "\nPassword: " + user.getPassword();
                        Toast.makeText(LoginActivity.this, values, Toast.LENGTH_LONG).show();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = findViewById(R.id.btnToRegister);

        btn.setOnClickListener(view -> {
            mStartForResult.launch(new Intent(this,
                    RegisterActivity.class));
        });
    }
}