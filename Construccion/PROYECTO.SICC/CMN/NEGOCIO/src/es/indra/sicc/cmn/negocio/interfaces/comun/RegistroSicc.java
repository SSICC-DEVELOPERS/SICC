package es.indra.sicc.cmn.negocio.interfaces.comun;

import java.io.Serializable;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import es.indra.sicc.util.UtilidadesLog;

public class RegistroSicc implements IRegistroSicc, Serializable
{
  private Map registroCampos;

  public RegistroSicc()
  {
    registroCampos = new HashMap();
  }

  public Object obtenerCampo( String campo )
  {
    return registroCampos.get( campo );
  }

  public void anyadirCampo( String nombre, Object valor ) throws InterfacesException
  {
	if( registroCampos.containsKey( nombre ) )
		throw new InterfacesException( "Se intenta insertar una clave ya existente: " + nombre );
    registroCampos.put( nombre, valor );
  }

  public int numeroCampos() 
  {
    return registroCampos.size();
  }
  
  public String toString()
  {
    StringBuffer buffer = new StringBuffer();
    String clave;
	Set claves = registroCampos.keySet();
	Iterator it = claves.iterator();
	while( it.hasNext() ) {
		clave = (String)it.next();
		buffer.append( clave + "(" + registroCampos.get(clave) + ")\n" );
	}
	
    //for (Enumeration claves = registroCampos.keys() ; claves.hasMoreElements() ;) 
    //{
    //  clave = (String)claves.nextElement();
    //  buffer.append( clave + "(" + registroCampos.get(clave) + ")\n" );
    //}

    return buffer.toString();
  }
  
  public static void main( String[] args ) {
	  RegistroSicc reg = new RegistroSicc();
	  
	  try {
		reg.anyadirCampo( "id", null );
		reg.anyadirCampo( "direccion", null );
		UtilidadesLog.debug( String.valueOf(reg.numeroCampos()) );
		UtilidadesLog.debug( reg.obtenerCampo("id"));
	  } catch( InterfacesException iex ) {
		  UtilidadesLog.debug( iex.getMotivo() );
	  }
  }
  
  public void vaciar() {
	  registroCampos.clear();
  }
  
}