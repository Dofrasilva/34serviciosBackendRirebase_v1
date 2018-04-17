package mx.edu.ittepic.a34_serviciosbackendrirebase_v1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {
    private TextView tvEmail;
    Button guardar;
    String men, control;
    EditText texto1,texto2;
DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
DatabaseReference mensajeref=databaseReference.child("Nombre");
    DatabaseReference controlref=databaseReference.child("NoControl");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvEmail = (TextView) findViewById(R.id.tvEmailProfile);

        texto1=findViewById(R.id.texto1);
        texto2=findViewById(R.id.texto2);

        tvEmail.setText(getIntent().getExtras().getString("Email"));
        guardar=findViewById(R.id.boton);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                men=texto1.getText().toString();
                mensajeref.setValue(men);
                control=texto2.getText().toString();
                controlref.setValue(control);
            }
        });
    }
}
