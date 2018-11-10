package utl.org.thelocators;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegistrarActivity extends AppCompatActivity {
    private EditText txtNombreR;
    private EditText txtEmailR;
    private EditText txtPassword;
    private EditText txtTelefono;
    private List<String> lstUsuarios;
    AlmacenarRegistrosUsuarios aru;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        txtNombreR = (EditText) findViewById(R.id.txtNombreUsuarioR);
        txtEmailR = (EditText) findViewById(R.id.txtEmailR);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtTelefono = (EditText) findViewById(R.id.txtTelefonoR);
    }


    public void onClickRegistrar(View v){
        String nombreUsuario = txtNombreR.getText().toString();
        String emailR = txtEmailR.getText().toString();
        String password = txtPassword.getText().toString();
        String telefono = txtTelefono.getText().toString();
        if(nombreUsuario.trim().length() <= 0 || emailR.trim().length() <=0 || password.trim().length() <= 0 || telefono.trim().length() <=0){
            Toast.makeText(this, "¡Por favor, llena todos los campos!", Toast.LENGTH_SHORT).show();
        }else{
            if(!verificarRegistro(emailR)){

            }else{
                Toast.makeText(this, "¡El correo ya está registrado, prueba con otro.!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public boolean verificarRegistro(String nombreUsuario){
        lstUsuarios = new ArrayList<String>();
        aru = new AlmacenarRegistrosUsuarios(this);
        lstUsuarios = aru.getData();
        for(String cadena : lstUsuarios){
            if(nombreUsuario.equalsIgnoreCase(cadena.split("¬")[1]))
                return false;
        }
        return true;
    }

    public void onClickRegistrarUsuario(View v){
        String nombreUsuario = txtNombreR.getText().toString();
        String emailR = txtEmailR.getText().toString();
        String password = txtPassword.getText().toString();
        String telefono = txtTelefono.getText().toString();

        aru.guardarRegistroU(nombreUsuario,emailR,password,telefono);
        Toast.makeText(this, "¡Registro exitoso!", Toast.LENGTH_SHORT).show();
    }

}
