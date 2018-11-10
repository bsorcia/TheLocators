package utl.org.thelocators;

import java.util.Vector;

public interface AlmacenarRegistrosUsers
{
    public void guardarRegistroU(String nombreUsuario, String emailUsuario,String password, String telefono);

    public Vector<String> getData();
}
