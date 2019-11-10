package pe.avilca.notesapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pe.avilca.notesapp.R;
import pe.avilca.notesapp.repositories.UserRepository;

public class RegisterActivity extends AppCompatActivity {
    private EditText usernameinp, fullnameinp, emailinp, passinp;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usernameinp=findViewById(R.id.username);
        fullnameinp=findViewById(R.id.fullname_input);
        emailinp=findViewById(R.id.Email);
        passinp=findViewById(R.id.pass);

        btn_register=findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDoRegister();
            }
        });
    }
    public void callDoRegister() {

        String user_name = usernameinp.getText().toString();
        String fullname = fullnameinp.getText().toString();
        String email = emailinp.getText().toString();
        String password = passinp.getText().toString();

        if( user_name.isEmpty() || fullname.isEmpty() || email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Complete los todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        UserRepository.create(user_name,fullname, email, password);
        Toast.makeText(this, fullname+" Se ha realizado correctamente el registro", Toast.LENGTH_SHORT).show();
        finish();

    }
}
