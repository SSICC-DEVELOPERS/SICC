import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.ListaEditableDinamica;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;

import es.indra.sicc.dtos.mav.DTOActividadMAV;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

      
public class LPRecibirEstadisticas extends LPSICCBase {

  public LPRecibirEstadisticas() {
    super();
  }
    
  public void inicio() throws Exception {
    pagina("generar_fichero_de_usuarios");
    asignarAtributo("PAGINA","generar_fichero_de_usuarios","cod","0929");
      asignarAtributo("PAGINA","generar_fichero_de_usuarios","titulo","0929");
       this.getConfiguracionMenu("LPRecibirEstadisticas","");
  }
  public void ejecucion() throws Exception { 
       rastreo();
    setTrazaFichero();
    String accion = conectorParametro("accion");
    accion = (accion==null )?"":accion;
    traza("accion en LPRecibirEstadisticas: " + accion);   
   
    this.getConfiguracionMenu();
    if (accion == null || "".equals(accion)) {
      this.generar();
      asignarAtributo("VAR","accion","valor","generado");
 
    } 
    traza("termino la ejecucion");
  }

  private void generar() throws Exception {
    try{
    
      //MareBusinessID idBusiness = new MareBusinessID("NDGRecibirEstadisticas");
      MareBusinessID idBusiness = new MareBusinessID("NDGCargarEstadisticasLotes");
      Vector params = new Vector();
       
      DTOAuditableSICC dto = new DTOAuditableSICC();
      dto.setOidPais(this.getOidPais());
       
      params.add(dto);
      params.add(idBusiness);
      
      traza("se va a hacer el conectar con lotes");
      DruidaConector con = conectar("ConectorCargarEstadisticasLotes", params);
      
      DTOSalida dtoSalida = (DTOSalida) con.objeto("dtoSalida");
      dtoSalida.setOidPais(this.getOidPais());

  	  //con = conectar("ConectorGenerarFicheroDeUsuarios", params);
      idBusiness = new MareBusinessID("NDGCargarEstadisticasRegistros");
      params = new Vector();
      params.add(dtoSalida);
      params.add(idBusiness);
      traza("se va a hacer el conectar con registros");
       conectar("ConectorGenerarFicheroDeUsuarios", params);
		

       asignarAtributo("VAR","errDescripcion","valor","Se efectuó la recuperación del Fichero");
      
    }catch (Exception ex) {
    traza("hubo un error, llama a logStackTrace");
    logStackTrace(ex);
         java.io.StringWriter sw = new java.io.StringWriter();
         java.io.PrintWriter pw = new java.io.PrintWriter(sw);
         ex.printStackTrace(pw);
         pw.flush();      
         ex.printStackTrace();
         traza("el error fue " + ex);
         asignarAtributo("VAR","errDescripcion","valor","La Recepción del Fichero no fue Generada Correctamente");
         //this.lanzarPaginaError(ex);
      }
      
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());
 
        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
 
        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }
 
        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
    }

    
  
  }
