package es.indra.sicc.cmn.negocio.interfaces.buzones;

import es.indra.sicc.cmn.negocio.interfaces.Interfaz;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;

import es.indra.sicc.util.UtilidadesLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuzonEntrada extends Buzon{
  private File ficheroActual = null;
  private BufferedReader in = null;
  private Buzon destino = null;

  public BuzonEntrada( String path )
  {
    super( path );
  }

  public void abrir( Interfaz interfaz ) throws InterfacesException
  {
    UtilidadesLog.info("BuzonEntrada.abrir( Interfaz interfaz ): Entrada");
    ficheros = obtenerFicheros( interfaz.getPatronNombre() );
    if( ficheros.isEmpty() ) {
			String mensaje = "No se ha recibido el fichero de interfaz";
			//interfaz.registrarError(mensaje, null); // Eliminado - eiraola 28/08/2007 - BELC400000647
			interfaz.registrarErrorInterfaz(mensaje); // Agregado  - eiraola 28/08/2007 - BELC400000647
			throw new InterfacesException( mensaje );
		}
    ficheroActual = (File)ficheros.get( 0 );
    UtilidadesLog.info("BuzonEntrada.abrir( Interfaz interfaz ): Salida");
  }
	
	public File getFichero() {
		return ficheroActual;
	}
  
  private File siguienteFichero(){
    File f = null;
    if( !ficheros.isEmpty() ){
      f = (File)ficheros.get( 0 );
      ficheros.remove( 0 );
    }
    return f;
  }
  
  public void cerrar( Interfaz interfaz ) throws InterfacesException{
    
  }

  public String cargarRegistro() throws FileNotFoundException, IOException {
    String linea = null;
    if( in == null ){
      in = new BufferedReader( new FileReader( ficheroActual ) );
    }
      
    linea = in.readLine();
	while( linea != null && linea.trim().equals("") )
		linea = in.readLine();

    if( linea == null ) {
      in.close();
    }
    return linea;
  }
  
  //Agregado por Cristian Valenzuela - 17/10/2005
  public void reset() throws IOException  {
      if(in!=null) {
          in.close();
          in = null;
      }
  }
  //FIN - Agregado por Cristian Valenzuela - 17/10/2005

  public void anyadirRegistro(String registro) throws IOException
  {
  }
  
  public void transferir( Buzon destino ) throws InterfacesException
  {
    boolean enviado = ficheroActual.renameTo( new File( destino, ficheroActual.getName() ) );
    if (!enviado) {
        throw new InterfacesException( "Error al mover archivo: " +
          "origen( " + ficheroActual.getAbsolutePath() + " ) - destino( " + destino.getAbsolutePath() );
    }
  }
  
  public void copiar( Buzon destino )
  {
    
  }
  
  public final List obtenerFicheros( String patronNombres )
  {  
    final Pattern patron = Pattern.compile( patronNombres );
    FileFilter filtro = new FileFilter() {
        Matcher matcher;
        public boolean accept(File f) {
          matcher = patron.matcher( f.getName() );
          return ( matcher.matches() && !f.isDirectory() );
        }
    };
    
    File[] fichs = listFiles( filtro );
	if( fichs == null )
		return null;
    List lista = new ArrayList( fichs.length );
    
    for( int i = 0; i < fichs.length; i++ )
      lista.add( fichs[i] );
      
    return lista;
  }
}