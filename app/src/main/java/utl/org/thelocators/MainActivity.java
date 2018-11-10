package utl.org.thelocators;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tvRegistrarte;
    private EditText txtNombreUsuario;
    private EditText txtContrasenia;
    private List<String> lstUsuarios;
    AlmacenarRegistrosUsuarios aru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvRegistrarte = (TextView) findViewById(R.id.txt);
        txtNombreUsuario = (EditText) findViewById(R.id.txtNombreUsuario);
        txtContrasenia = (EditText) findViewById(R.id.txtContrasenia);
    }


    public void onClickRegistrarse(View v){
        Intent intent = new Intent(this,RegistrarActivity.class);
        startActivity(intent);
    }

    public void validarDatos(View v){
        String nombreUsuario = txtNombreUsuario.getText().toString();
        String contrasenia = txtContrasenia.getText().toString();
        if(nombreUsuario.trim().length() <= 0 || contrasenia.trim().length() <= 0){
            Toast.makeText(this, "¡Por favor, llena todos los campos!", Toast.LENGTH_SHORT).show();
        }else{
            if(verificarRegistro(nombreUsuario,contrasenia)){

            }else{
                Toast.makeText(this, "¡Datos incorrectos, intente de nuevo!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public boolean verificarRegistro(String nombreUsuario, String password){
        lstUsuarios = new ArrayList<String>();
        aru = new AlmacenarRegistrosUsuarios(this);
        lstUsuarios = aru.getData();
        for(String cadena : lstUsuarios){
            if(nombreUsuario.equalsIgnoreCase(cadena.split("¬")[1]) && password.equalsIgnoreCase(cadena.split("¬")[2]))
                return true;
        }
        return false;
    }

}
