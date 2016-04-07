import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.bel.DTOCaja;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
//import LPSICCBase;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;

public class LPCerrarCajasBelcenter extends LPSICCBase {
  private String mAccion = null;
  private String mPais = null;     
  private String mIdioma = null;   

  public LPCerrarCajasBelcenter() { super(); }

	public void inicio() throws Exception { }
  
  public void ejecucion() throws Exception {  
    setTrazaFichero();    

    mAccion = conectorParametroLimpia("accion", "", true);
    mPais = UtilidadesSession.getPais(this).toString();
    mIdioma = UtilidadesSession.getIdioma(this).toString();

    traza("************ Entre a ejecucion - LPCerrarCajasBelcenter");

    traza("************ mAccion: " + mAccion);
    traza("************ mPais: " + mPais);
    traza("************ mIdioma: " + mIdioma);
    
    try {      
       if(mAccion.equals("")) {   
          pagina("contenido_cajas_belcenter_cerrar");
          cargarMenuSecundario();
          cargarPagina();
       }        
       else {
          if(mAccion.equals("resumen")) {
            pagina("contenido_cajas_belcenter_cerrar_resumen");
            cargarMenuSecundario();
            cargarPaginaResumen();
          }else { 
            if (mAccion.equals("Salir")) {
              conectorAction("LPInicioBelcorp");        
            }
          }
       }
       cargarMenuSecundario();         
    }
    catch (Exception e) {
      ByteArrayOutputStream pila = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(pila);
      e.printStackTrace(out);
		  e.printStackTrace(); 
		  e.getMessage();
		  lanzarPaginaError(e);
    }
  }

   private void cargarPagina() throws Exception {
      traza("******************* Entre a cargarPagina - LPCerrarCajasBelcenter");

      //********************* Primer conectar ***************************
      //try{
            String cadena = UtilidadesBelcorp.getIPCliente(this);
            traza("******************* cadena " + cadena);
            
            DTOString dtoString = new DTOString();
            dtoString.setCadena(cadena);
            dtoString.setOidIdioma(new Long(mIdioma));
            dtoString.setOidPais(new Long(mPais));
      
            MareBusinessID businessID1 = new MareBusinessID("BELObtenerDatosCaja");
      
            Vector parametros1 = new Vector();
            parametros1.add(dtoString);
            parametros1.add(businessID1);
      
            traza("******************* Antes de conectar - 1");
            DruidaConector con1 = conectar("ConectorObtenerDatosCaja", parametros1);
            traza("******************* Despues de conectar - 1");
            
            DTOCaja caja = (DTOCaja)con1.objeto("dtoSalida");
            caja.setOidIdioma(new Long(mIdioma));
            caja.setOidPais(new Long(mPais));
      
            traza("******************* caja: " + caja);
      
            conectorParametroSesion("datosCaja",caja);
      
            Date fech = caja.getFecha();
            String sFech = this.dateToString(fech);
      
            asignarAtributo("VAR", "varCanal", "valor", caja.getCodigoCanal());
            asignarAtributo("VAR", "varAcceso", "valor", caja.getCodigoAcceso());
            asignarAtributo("VAR", "varSubacceso", "valor", caja.getCodigoSubacceso());
            asignarAtributo("VAR", "varFecha", "valor", sFech);
            asignarAtributo("VAR", "varEstado", "valor", "DESCUADRE");
      
            //********************* Segundo conectar ***************************      
            
            MareBusinessID businessID2 = new MareBusinessID("BELCerrarCajasBELC");
      
            Vector parametros2 = new Vector();
            parametros2.add(caja);
            parametros2.add(businessID2);
      
            traza("******************* Antes de conectar - 2");
            DruidaConector con2 = conectar("ConectorCerrarCajasBELC", parametros2);
            traza("******************* Despues de conectar - 2");
      
            traza("conector: " + con2.getXML());
            DTOSalida dtoSalida = (DTOSalida) con2.objeto("dtoSalida");
            traza("******************* dtoSalida.getResultado()" + dtoSalida.getResultado());
            
            //PZERBINO Incidencia BELC300023487 8/8/2006      
            
            if (!dtoSalida.getResultado().esVacio()){                
                asignar("LISTADOA", "listado1",con2, "dtoSalida.resultado_ROWSET");             
            }
      /*}catch (Exception e) {
        traza("dentro del error");  
        if (e instanceof InvocationTargetException) {
          traza("obtenerError: es InvocationTargetException");
          if (((InvocationTargetException) e).getTargetException() instanceof MareException) {
              traza("obtenerError: es MareException");
              MareException mareException = (MareException) ((InvocationTargetException) e).getTargetException();
              traza("a.1");
              traza("mareException.getCode()" + mareException.getCode());
              if  ((String.valueOf(mareException.getCode())).equals("30006")){
                  asignarAtributo("VAR", "errCodigo", "valor", "3006");                  
                  this.lanzarPaginaError(e);
              }else {
                this.lanzarPaginaError(e);
              }
              traza("a.2");
          }
        }
      }*/
   }
   private void cargarPaginaResumen() throws Exception {
      traza("******************* Entre a cargarPaginaResumen - LPCerrarCajasBelcenter");

      DTOCaja dtoCaja = (DTOCaja)conectorParametroSesion("datosCaja");
      traza("******************* dtoCaja: " + dtoCaja);

      MareBusinessID businessID = new MareBusinessID("BELCerrarCajasBELCResumen");

      Vector parametros = new Vector();
      parametros.add(dtoCaja);
      parametros.add(businessID);

      traza("******************* Antes de conectar");
      DruidaConector con = conectar("ConectorCerrarCajasBELCResumen", parametros);
      traza("******************* Despues de conectar");
      
      asignar("LISTADOA", "listado1",con, "dtoSalida.resultado_ROWSET");

      Date fech = dtoCaja.getFecha();
      String sFech = this.dateToString(fech);

      asignarAtributo("VAR", "varCanal", "valor", dtoCaja.getCodigoCanal());
      asignarAtributo("VAR", "varAcceso", "valor", dtoCaja.getCodigoAcceso());
      asignarAtributo("VAR", "varSubacceso", "valor", dtoCaja.getCodigoSubacceso());
      asignarAtributo("VAR", "varFecha", "valor", sFech);
      asignarAtributo("VAR", "varEstado", "valor", "DESCUADRE");
   }

  private String dateToString(Date dFecha) throws Exception{
    traza("******************* Entre a dateToString - LPCerrarCajasBelcenter");
    String formato = UtilidadesSession.getFormatoFecha(this);
    formato = formato.replace('m', 'M');
		SimpleDateFormat miFecha = new SimpleDateFormat(formato);
	  String fechaRes = miFecha.format(dFecha);		
    traza("********** fechaRes: " + fechaRes);
		return fechaRes;
  }

   private void cargarMenuSecundario() throws Exception {
      traza("******************* Entre a cargarMenuSecundario - LPCerrarCajasBelcenter");
      
      if(mAccion.equals("")) {
        getConfiguracionMenu("LPCerrarCajasBelcenter","");
      }        
      else {
        if(mAccion.equals("resumen")) {
          getConfiguracionMenu("LPCerrarCajasBelcenter","resumen");
        }                   
      }
   }
}
