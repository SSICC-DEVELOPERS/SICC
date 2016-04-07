package es.indra.sicc.cmn.negocio.interfaces;

import es.indra.sicc.cmn.negocio.interfaces.buzones.Buzon;
import es.indra.sicc.cmn.negocio.interfaces.buzones.IBuzon;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;

import es.indra.sicc.util.UtilidadesLog;
import java.io.IOException;
import java.util.Date;

public class InterfazSalida extends Interfaz
{
  public InterfazSalida( InterfazDef def, String numeroLote )
    throws InterfacesException
  {
    super( def, numeroLote );
    buzonTemporal = Buzon.obtenerBuzon( IBuzon.BUZON_SALIDA, def.getPathBuzonTemporal() );
    buzonTemporal.abrir( this );
    buzonES = Buzon.obtenerBuzon( IBuzon.BUZON_SALIDA, def.getPathBuzonES() );
  }

  public IRegistroSicc cargarRegistro(boolean bCerrarInterfaz) throws InterfacesException
  {
    String mensaje = "No se puede cargar un registro desde una interfaz de salida";
    getLogger().error( mensaje );
    throw new InterfacesException( mensaje );
  }
  
  public IRegistroSicc cargarRegistro() throws InterfacesException
  {
    return cargarRegistro(true);
  }

    /**
     * @cambio incidencia 21117 - Faltaba incrementar registrosProcesados y registros erroneos, como se hace en InterfazEntrada.
     * @autor gdmarzi
     */
  public void anyadirRegistro( IRegistroSicc registroSicc )
    throws InterfacesException, IOException
  {
    try
    {
      getBuzonTemporal().anyadirRegistro( registro.serializar(registroSicc) );
    } catch( IOException ioex )
    {
      if( isLogErrores() )
      {
        String motivo = "Error de escritura" + 
                      "\nRegistro número: " + 
                      getRegistrosProcesados() +
                      "\nRegistro: " + registroSicc;
                      
        getLogger().error( motivo, ioex );
      }
	  incrementarRegistrosProcesados();
	  incrementarRegistrosErroneos();
      throw ioex;
    } catch( InterfacesException iex ) {
	  if( isLogErrores() ) {
		getLogger().error( iex.getMotivo(), iex );
	  }
	  incrementarRegistrosErroneos();
	}
	incrementarRegistrosProcesados();
  }

  public void enviar() throws InterfacesException
  {
    setFechaFinProceso( new Date() );
    getBuzonTemporal().cerrar( this );
    getBuzonTemporal().copiar( getBuzonHistorico() );
    getBuzonTemporal().transferir( getBuzonES() );
  }

  public void cerrarInterfaz() throws InterfacesException
  {
    String mensaje = "No se puede cerrar una interfaz de salida";
    getLogger().error( mensaje );
    throw new InterfacesException( mensaje );
  }
  
   //Agregado por Cristian Valenzuela - 17/10/2005
   public void reset() throws InterfacesException, IOException {
    String mensaje = "No se puede resetear una interfaz de salida";
    getLogger().error( mensaje );
    throw new InterfacesException( mensaje );
  }
  //FIN - Agregado por Cristian Valenzuela - 17/10/2005
    
}