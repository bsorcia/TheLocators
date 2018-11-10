package utl.org.thelocators;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class AlmacenarRegistrosUsuarios implements AlmacenarRegistrosUsers {

    private static String ARCHIVO = "registroUsuarios.txt"; //Definimos el nombre del archivo
    private Context context;

    //Constructor
    public AlmacenarRegistrosUsuarios(Context context)
    {
        this.context = context;
    }

    @Override
    public void guardarRegistroU(String nombreUsuario, String emailUsuario, String password, String telefono) {

        //Método que permite guardar una nueva puntuación en el archivo puntuaciones.txt.
        try
        {
            FileOutputStream fos = context.openFileOutput(ARCHIVO, Context.MODE_APPEND);
            String texto = nombreUsuario + "¬" + emailUsuario + "¬" + password + "¬" + telefono + System.getProperty("line.separator");
            fos.write(texto.getBytes());
            fos.close();
        }
        catch(Exception ex)
        {
            Log.e("Uso ListView", ex.getMessage(), ex);
        }

    }

    @Override
    public Vector<String> getData() {
        Vector<String> result = new Vector<String>();

        try
        {
            FileInputStream fis = context.openFileInput(ARCHIVO);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(fis));
            String linea = "";
            do
            {
                linea = entrada.readLine();
                if(linea != null)
                {
                    result.add(linea);
                }
            }
            while(linea != null);
            fis.close();
        }
        catch (Exception e) {
            Log.e("Uso ListView", e.getMessage());
        }
        return result;
    }
}
