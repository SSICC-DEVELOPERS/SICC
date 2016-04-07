package es.indra.sicc.cmn.negocio.interfaces.buzones;

import es.indra.sicc.cmn.negocio.interfaces.Interfaz;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface IBuzon {
  public static final String BUZON_ENTRADA = "BUZON_ENTRADA";
  public static final String BUZON_SALIDA = "BUZON_SALIDA";  

  public void abrir(Interfaz interfaz) throws InterfacesException;
  public void cerrar(Interfaz interfaz) throws InterfacesException;
  public void anyadirRegistro( String registro ) throws IOException;
  public String cargarRegistro() throws FileNotFoundException, IOException;
  public void transferir( Buzon destino ) throws InterfacesException;
  public void copiar( Buzon destino ) throws InterfacesException;
  //Agregado por Cristian Valenzuela - 17/10/2005
  public void reset() throws IOException;
  //FIN - Agregado por Cristian Valenzuela - 17/10/2005  
}