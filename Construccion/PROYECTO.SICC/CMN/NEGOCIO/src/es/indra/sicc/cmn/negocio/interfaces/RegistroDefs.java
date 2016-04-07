package es.indra.sicc.cmn.negocio.interfaces;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.InterfazDef;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.util.Util;

import java.util.Map;

public class RegistroDefs 
{
  private static RegistroDefs instancia;
  private static Map registro;

  private RegistroDefs() throws InterfacesException, MareException
  {
    registro = Util.cargarInterfaces();
  }

  public static synchronized RegistroDefs obtenerRegistro()
    throws InterfacesException, MareException
  {
    if( instancia == null )
      instancia = new RegistroDefs();
    return instancia;
  }

  public static InterfazDef obtenerInterfaz( String codigo ) throws InterfacesException
  {
    InterfazDef interfaz = (InterfazDef)registro.get( codigo );
    if( interfaz == null )
      throw new InterfacesException( "Interfaz no definida: " + codigo );
    return interfaz;
  }

  public static void recargarInterfaces() throws InterfacesException, MareException
  {
    instancia = new RegistroDefs();
  }
}