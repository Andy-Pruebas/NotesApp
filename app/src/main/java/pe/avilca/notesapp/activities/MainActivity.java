package pe.avilca.notesapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pe.avilca.notesapp.R;
import pe.avilca.notesapp.models.User;
import pe.avilca.notesapp.repositories.UserRepository;

public class MainActivity extends AppCompatActivity {
    private EditText user_et, password_et;
    private Button login_btn, register_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_et=findViewById(R.id.username_input);
        password_et=findViewById(R.id.password_input);
        login_btn=findViewById(R.id.ingresar);
        register_btn=findViewById(R.id.register);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowRegister();
            }
        });
    }
    public void Login(){
        String user = user_et.getText().toString();
        String password = password_et.getText().toString();

        User newUser = UserRepository.login(user, password);

        if (newUser == null) {
            Toast.makeText(this, "Crendeciales Incorrectas", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        sp.edit().putBoolean("isLogged", true).putString("username", newUser.getFullname()).apply();

        startActivity(new Intent(this, NotesActivity.class));
        finish();
    }

    public void ShowRegister(){
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
