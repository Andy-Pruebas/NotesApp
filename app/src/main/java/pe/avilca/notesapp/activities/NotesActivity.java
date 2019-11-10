package pe.avilca.notesapp.activities;

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
import pe.avilca.notesapp.repositories.NotesRepository;
import pe.avilca.notesapp.repositories.UserRepository;

public class NotesActivity extends AppCompatActivity {
    private EditText input_Title,input_Des;
    private Button register_notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        input_Title=findViewById(R.id.inputTitle);
        input_Des=findViewById(R.id.inputDescription);
        register_notes=findViewById(R.id.register_note);
        register_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callRegisterNote();
            }
        });
    }
    public void callRegisterNote(){
        String title = input_Title.getText().toString();
        String descrip = input_Des.getText().toString();

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sp.getString("user",null);

        User usuario;
        usuario = UserRepository.findByUsername(username);

        if( title.isEmpty() || descrip.isEmpty()){
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        NotesRepository.create(title,descrip,usuario.getId());
        finish();
    }

}
