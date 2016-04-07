package es.indra.sicc.cmn.negocio.interfaces.buzones;

import es.indra.sicc.cmn.negocio.interfaces.Interfaz;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;

public abstract class Buzon extends File implements IBuzon {
  protected List ficheros;

  public Buzon( String path ) {
    super( path );
  }

  public static Buzon obtenerBuzon(String tipo, String path) throws InterfacesException  {
    if( tipo.equals( IBuzon.BUZON_ENTRADA ) )
      return new BuzonEntrada( path );
    else if( tipo.equals( IBuzon.BUZON_SALIDA ) )
      return new BuzonSalida( path );
    throw new InterfacesException( "Tipo de buzón erróneo: " + tipo );
  }
	
  public abstract File getFichero();

  public abstract void abrir(Interfaz interfaz) throws InterfacesException;

  public abstract void cerrar(Interfaz interfaz) throws InterfacesException;

  public abstract void anyadirRegistro( String registro ) throws IOException;
  
  public abstract void copiar( Buzon destino ) throws InterfacesException;
  
  public abstract String cargarRegistro() throws FileNotFoundException, IOException;
  
  //Agregado por Cristian Valenzuela - 17/10/2005
  public abstract void reset() throws IOException;
  //FIN - Agregado por Cristian Valenzuela - 17/10/2005
}