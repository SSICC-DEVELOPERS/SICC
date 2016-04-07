package es.indra.sicc.cmn.negocio.interfaces;

import es.indra.sicc.cmn.negocio.interfaces.buzones.Buzon;
import es.indra.sicc.cmn.negocio.interfaces.buzones.IBuzon;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Date;

import es.indra.sicc.util.UtilidadesLog;


public class InterfazEntrada extends Interfaz
{
  public InterfazEntrada( InterfazDef def, String numeroLote )
    throws InterfacesException
  {
    super( def, numeroLote );
    buzonTemporal = Buzon.obtenerBuzon( IBuzon.BUZON_ENTRADA, def.getPathBuzonTemporal() );
    buzonES = Buzon.obtenerBuzon( IBuzon.BUZON_ENTRADA, def.getPathBuzonES() );
    buzonES.abrir( this );
    buzonES.transferir( getBuzonTemporal() );
    buzonTemporal.abrir( this );
  }

  public IRegistroSicc cargarRegistro(boolean bCerrarInterfaz)
	throws InterfacesException, FileNotFoundException, IOException
  {
    String cadena = null;
    try
    {
      cadena = getBuzonTemporal().cargarRegistro();
    } catch( FileNotFoundException fex )
    {
      if( isLogErrores() )
      {
        String motivo = "Error de lectura" + 
                      "\nRegistro número: " + 
                      getRegistrosProcesados() +
                      "\nRegistro: " + cadena;
                      
        getLogger().error( motivo, fex );
      }
	  incrementarRegistrosErroneos();
      incrementarRegistrosProcesados();
      throw fex;
    } catch( IOException ioex )
    {
      if( isLogErrores() )
      {
        String motivo = "Error de lectura" + 
                      "\nRegistro número: " + 
                      getRegistrosProcesados() +
                      "\nRegistro: " + cadena;
                      
        getLogger().error( motivo, ioex );
      }
	  incrementarRegistrosErroneos();
      incrementarRegistrosProcesados();
      throw ioex;
    }
    
    if( cadena == null)
    {
		UtilidadesLog.debug("dentro de cadena null");
	  if (bCerrarInterfaz)
	  {
		UtilidadesLog.debug("cierro");
		  getBuzonTemporal().transferir( getBuzonHistorico() );
		  setFechaFinProceso( new Date() );
	  } 
	  return null;
    }
    
    IRegistroSicc registroSicc = null;
    try
    {
      registroSicc = registro.parsear( cadena );
    } catch( InterfacesException iex )
    {
      incrementarRegistrosErroneos();
      if( isLogErrores() )
      {
        String motivo = iex.getMotivo() + 
                        "\nRegistro número: " + 
                        getRegistrosProcesados() +
                        "\nRegistro: " + cadena;
        //getLogger().error( motivo );             // Eliminado - eiraola 29/08/2007 - Inc. BELC400000647
        this.registrarErrorInterfaz(motivo);       // Agregado  - eiraola 29/08/2007 - Inc. BELC400000647
      }
      UtilidadesLog.debug("... paso al proximo registro, con parametro: " + bCerrarInterfaz);
      registroSicc = cargarRegistro(bCerrarInterfaz);
      
    }
    incrementarRegistrosProcesados();

    return registroSicc;    
  }

  public IRegistroSicc cargarRegistro() 
    throws InterfacesException, FileNotFoundException, IOException
  {
	return cargarRegistro(true);
  }

  public void anyadirRegistro( IRegistroSicc registro )
  {
    if( logErrores )
      getLogger().error( "No se puede añadir un registro a una interfaz de entrada" );
  }

  public void enviar() throws InterfacesException
  {
    String mensaje = "No se puede enviar una interfaz de entrada" ;
    getLogger().error( mensaje );
    throw new InterfacesException( mensaje );
  }

  public void cerrarInterfaz() throws InterfacesException
  {
	UtilidadesLog.debug("cerrando interfaz");
    getBuzonTemporal().transferir( getBuzonHistorico() );
    setFechaFinProceso( new Date() );  
	try {
        this.getBuzonTemporal().reset();    //  Agregado por Incidencia SiCC20080604
    } catch(IOException io) { 
        UtilidadesLog.error("InterfazEntrada.cerrarInterfaz(): Error en reset: " + io.getMessage());
    }
    UtilidadesLog.debug("interfaz cerrada.");
  }
  
  //Agregado por Cristian Valenzuela - 17/10/2005
  public void reset() throws InterfacesException, IOException {
    UtilidadesLog.info("InterfazEntrada.reset(): Entrada");      
    this.getBuzonTemporal().reset();   
    UtilidadesLog.info("InterfazEntrada.reset(): Salida");      
  }
  //FIN - Agregado por Cristian Valenzuela - 17/10/2005
  
}