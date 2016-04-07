package es.indra.sicc.cmn.negocio.interfaces;

import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;

import java.util.Hashtable;
import java.util.Map;

public class RegistroInterfaces 
{
  private static RegistroInterfaces instancia = null;
  private Map registro;

  private RegistroInterfaces()
  {
    registro = new Hashtable();
  }

  public static synchronized RegistroInterfaces obtenerRegistroInterfaces()
  {
    if( instancia == null )
      instancia = new RegistroInterfaces();
    return instancia;
  }

  public void registrarInterfaz( String clave, Interfaz interfaz )
    throws InterfacesException
  {
    Interfaz temp = (Interfaz)registro.get( clave );
    if( temp != null )
      throw new InterfacesException( "La interfaz ya está en uso: " + clave );

    registro.put( clave, interfaz );
  }

  public Interfaz obtenerInterfaz( InterfazInfo info ) throws InterfacesException
  {
    if( info == null )
      throw new InterfacesException( "Identificador de interfaz nulo" );

    Interfaz interfaz = (Interfaz)registro.get( info.getCodigoInterfaz() + info.getNumeroLote() );
    if( interfaz == null )
      throw new InterfacesException( "Interfaz no encontrada: " + interfaz );

    return interfaz;
  }

  public void eliminarInterfaz( String clave ) throws InterfacesException
  {
    registro.remove(clave);
  }
}