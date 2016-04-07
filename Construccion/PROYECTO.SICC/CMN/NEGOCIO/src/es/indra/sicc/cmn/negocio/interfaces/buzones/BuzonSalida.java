package es.indra.sicc.cmn.negocio.interfaces.buzones;

import es.indra.sicc.cmn.negocio.interfaces.Interfaz;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BuzonSalida extends Buzon
{
  private File fichero;
  private FileWriter fw;

  public BuzonSalida(String path)
  {
    super( path );
  }

  public void abrir(Interfaz interfaz) throws InterfacesException
  {
    fichero = new File( getAbsolutePath() + 
                        System.getProperty("file.separator") + 
                        interfaz.getNombreFichero() );
    try
    {
      boolean ficheroCreado = fichero.createNewFile();
      if( !ficheroCreado )
        throw new InterfacesException( "El fichero ya existe: " + fichero.getAbsolutePath() );
    } catch( IOException ioex ) 
    {
      throw new InterfacesException( "Fallo al crear el fichero: " + 
        fichero.getAbsolutePath(), ioex );
    }

    try
    {
      fw = new FileWriter( fichero );
    } catch( IOException ioex )
    {
      throw new InterfacesException( 
        "Error de escritura de fichero: " + fichero.getAbsolutePath(), ioex );
    }
  }
	
	public File getFichero() {
		return fichero;
	}
  
  public void cerrar( Interfaz interfaz ) throws InterfacesException
  {
    try 
    {
      fw.close();
    } catch( IOException ioex ) 
    {
      throw new InterfacesException( "Error de escritura de fichero: " +
        fichero.getAbsolutePath(), ioex );
    }
  }

  public void anyadirRegistro( String registro ) throws IOException
  {
    fw.write( registro + System.getProperty( "line.separator" ) );
  }

  public String cargarRegistro() throws FileNotFoundException, IOException
  {
    return null;
  }
  
  //Agregado por Cristian Valenzuela - 17/10/2005
  public void reset() throws IOException  { }
  //FIN - Agregado por Cristian Valenzuela - 17/10/2005
  
  public void transferir( Buzon destino ) throws InterfacesException
  {
    boolean enviado = fichero.renameTo( new File( destino, fichero.getName() ) );
    if (!enviado) {
        throw new InterfacesException( "Error al mover archivo: " +
          "origen( " + fichero.getAbsolutePath() + " ) - destino( " + destino.getAbsolutePath() );
    }

  }
  
  public void copiar( Buzon destino ) throws InterfacesException
  {
    try
    {
      InputStream in = new FileInputStream( fichero );
      File fDestino = new File( destino, fichero.getName() );
      OutputStream out = new FileOutputStream( fDestino );
    
      byte[] buf = new byte[1024];
      int len;
      while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
      }
      in.close();
      out.close();
    } catch( IOException ioex ) 
    {
      throw new InterfacesException( "Error al copiar archivo: origen( " + 
        fichero.getAbsolutePath() + " ) - destino( " + destino.getAbsolutePath() );
    }
  }
}