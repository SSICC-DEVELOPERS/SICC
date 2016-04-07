import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import java.util.Vector;
import java.util.StringTokenizer;

import java.lang.reflect.InvocationTargetException;
import com.evermind.server.rmi.OrionRemoteException;
import java.io.*;
import java.util.*;


import es.indra.mare.common.mgu.manager.Property;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareCredentials;

import es.indra.sicc.dtos.seg.ParametrosClaveDTO;

import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import java.sql.Date;

import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;

// $Id: LPModificacionParametrosClave.java,v 1.1 2009/12/03 18:40:13 pecbazalar Exp $  							  	
public class LPModificacionParametrosClave extends LPSICCBase
{
  private final String sNombreLP = "LPModificacionParametrosClave";

  public LPModificacionParametrosClave() 
  {
    super();
  }

  public void inicio() throws Exception {      
      pagina("contenido_clave_seguridad_configurar");
  }

  public void ejecucion() throws Exception 
  {
      asignarAtributoPagina("cod", "04");
      
      setTrazaFichero();  
      String sAccion = conectorParametroLimpia("accion","",true );
      //String sCasoDeUso				= conectorParametro("hidCasoDeUso");
      String sDiasDeCambio = null;
      String sNumRepeticiones	= null;
      String sLongMinima = null;
      String sNumMaxIntentos = null;
      
      String idFuncion = (String)conectorParametroSesion("idFuncion");      
      traza("idFuncion: " + idFuncion);
      
      if (sAccion == null)
         sAccion = "";

      traza("sAccion: " + sAccion);

      HashMap propiedades  = (HashMap) conectorParametroSesion("propiedades");
      traza("propiedades en Sesion: " + propiedades.toString() );
  
      try
     {

        if (sAccion.equals("") )
        {

          // Rastreo
          rastreo();
   
          traza("Entro por vacío");
          // Obtiene los parámetros para cargar los datos
          // en la pantalla.
          ParametrosClaveDTO dtoe = new ParametrosClaveDTO();
          DruidaConector ConectorBusquedaParametrosClave = null;          
          MareBusinessID bussID = new MareBusinessID("MLNFBusquedaParametrosClave");

          Vector params = new Vector();
          params.add(dtoe);
          params.add(bussID); 
          traza("Antes de conectar");
          DruidaConector con = conectar("ConectorBusquedaParametrosClave",params);
          traza("Despues de conectar");

          dtoe = (ParametrosClaveDTO) con.objeto("dtoSalida");
          traza("dtoe Consulta: " + dtoe.toString() );

          sDiasDeCambio = dtoe.getDiasCambio().toString();
          traza("sDiasDeCambio: " + sDiasDeCambio );          
          sNumRepeticiones = dtoe.getNumeroRepeticiones().toString();
          traza("sNumRepeticiones: " + sNumRepeticiones );          
          sLongMinima = dtoe.getLongitudMinina().toString();          
          traza("sLongMinima: " + sLongMinima );          
          if (dtoe.getNumeroMaximoIntentos() == null)
            traza("sNumMaxIntentos es null");
          sNumMaxIntentos = dtoe.getNumeroMaximoIntentos().toString();
          traza("sNumMaxIntentos: " + sNumMaxIntentos.toString() );          
          
          asignarAtributo( "CTEXTO", "txtDiasCambio", "valor", sDiasDeCambio.toString() );
          asignarAtributo( "CTEXTO", "txtNumRepeticiones", "valor", sNumRepeticiones.toString() );
          asignarAtributo( "CTEXTO", "txtLongMinima", "valor", sLongMinima.toString() );
          asignarAtributo( "CTEXTO", "txtNumMaxIntentos", "valor", sNumMaxIntentos.toString() );

          getFormatosValidaciones();
          
        } else
        if ( sAccion.equals("guardar") )
        {
           pagina("salidaGenerica");
           
           traza("Entro por guardar");
           sDiasDeCambio = conectorParametroLimpia("txtDiasCambio","",true );
           if (sDiasDeCambio == null)
              sDiasDeCambio = "";
           sNumRepeticiones	= conectorParametroLimpia("txtNumRepeticiones","",true ); 
           if (sNumRepeticiones == null)
              sNumRepeticiones = "";
           sLongMinima = conectorParametroLimpia("txtLongMinima", "", true); 
           if (sLongMinima == null)
              sLongMinima = "";
           sNumMaxIntentos = conectorParametroLimpia("txtNumMaxIntentos", "", true); 
           if (sNumMaxIntentos == null)
              sNumMaxIntentos = "";

           traza("sAccion: " + sAccion);
           traza("sDiasDeCambio: " + sDiasDeCambio);
           traza("sNumRepeticiones: " + sNumRepeticiones);
           traza("sLongMinima: " + sLongMinima);
           traza("sNumMaxIntentos: " + sNumMaxIntentos);
         
        
           traza("Entro por Guardar");
           MareBusinessID bussID = new MareBusinessID("MLNFModificacionParametrosClave");
           ParametrosClaveDTO dtoe = new ParametrosClaveDTO();

           traza("diasCambio: " + sDiasDeCambio);
           dtoe.setDiasCambio( new Integer(sDiasDeCambio) );
           traza("numeroRepeticiones: " + sNumRepeticiones);
           dtoe.setNumeroRepeticiones( new Integer(sNumRepeticiones) );
           traza("longMinima: " + sLongMinima);
           dtoe.setLongitudMinima( new Integer(sLongMinima) );
           traza("sNumMaxIntentos: " + sNumMaxIntentos);
           dtoe.setNumeroMaximoIntentos( new Integer(sNumMaxIntentos) );

           // Setea IPCLiente y Codigo de funcion.
           dtoe.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
           dtoe.setPrograma( UtilidadesSession.getFuncion(this) );
           Vector params = new Vector();
           params.add(dtoe);
           params.add(bussID);

           traza("Antes de conectar");
           this.rastreo();
           DruidaConector con = conectar("ConectorModificacionParametrosClave", params);
           traza("Despues de conectar");

           //asignarAtributo( "CTEXTO", "txtDiasCambio", "valor", sDiasDeCambio.toString() );
           //asignarAtributo( "CTEXTO", "txtNumRepeticiones", "valor", sNumRepeticiones.toString() );
           //asignarAtributo( "CTEXTO", "txtLongMinima", "valor", sLongMinima.toString() );           
           //asignarAtributo( "CTEXTO", "txtNumMaxIntentos", "valor", sNumMaxIntentos.toString() );

           traza("llamo a fSeteoCajas");
           asignarAtributo("VAR", "ejecutar", "valor", "fSeteoCajas('" + sDiasDeCambio +"', '" + sNumRepeticiones + "', '" +sLongMinima + "', '" +sNumMaxIntentos + "');");
           traza("llame a fSeteoCajas");
        }
     	
     } catch (Exception ex) 
     {
        traza("entre en la excepcion");
        traza("Se produjo una excepcion: " + ex.toString());
        traza("Nombre de la clase: " + ex.getClass().getName());
        traza("Mensaje de error: " + ex.getMessage());
        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
        ex.printStackTrace(out);
        traza("EL STACK ES COMO SIGUE : " +  pila.toString());

        this.lanzarPaginaError(ex);
        asignarAtributo("VAR", "ejecutar", "valor", "errorGrabacion();");
      }   
      traza("llegue al final");
      this.getConfiguracionMenu();

 }

}
