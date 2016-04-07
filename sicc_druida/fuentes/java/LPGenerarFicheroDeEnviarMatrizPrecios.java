import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.ListaEditableDinamica;
import es.indra.sicc.dtos.intsys.DTOGenerarFicheroDeEnviarConsultoras;
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

import es.indra.sicc.dtos.intsys.DTOEntradaGenerarFicheroMatrizPrecios;
      
public class LPGenerarFicheroDeEnviarMatrizPrecios extends LPSICCBase {
  private HashMap param = new HashMap();

  public LPGenerarFicheroDeEnviarMatrizPrecios() {
    super();
  }
    
 public void inicio() throws Exception {
     pagina("contenido_matriz_precios_enviar");
      this.getConfiguracionMenu();
  }

  public void ejecucion() throws Exception {
	  rastreo();
      setTrazaFichero();
      String accion = conectorParametro("accion");
      //accion = (accion==null )?"":accion;
      traza("accion de entrada " + accion);   
      try{
	asignarAtributo("PAGINA","contenido_matriz_precios_enviar","cod","0925");
  	asignarAtributo("PAGINA","contenido_matriz_precios_enviar","titulo","0925");
	if("Guardar".equals(accion)){
		pagina("salidaGenerica");
		param=conectorParametro();
		this.generarFicheroDeEnviarMatrizDePrecios();
		asignarAtributo("VAR", "ejecutar", "valor", "ok()");
	}

      
      }catch(Exception  e){
		traza("ERROR: " + e);
        e.printStackTrace();
		asignarAtributo("VAR","errDescripcion","valor","Error al generar fichero");
      }
  }

  private void generarFicheroDeEnviarMatrizDePrecios() throws Exception {
	
	DTOEntradaGenerarFicheroMatrizPrecios dto = new DTOEntradaGenerarFicheroMatrizPrecios(); 
	dto.setOidPais( UtilidadesSession.getPais(this));

	dto.setOidCanal( new Long(param.get("canal").toString()));
	

	dto.setOidMarca( new Long(param.get("marca").toString())); 
  	if(param.get("acceso") != null && !"".equals(param.get("acceso").toString().trim())) {
    	    dto.setOidAcceso( new Long(param.get("acceso").toString()));
  	}
    
	dto.setOidPeriodoDesde ( new Long(param.get("desde").toString()));
	
  if(param.get("hasta")!=null && !"".equals(param.get("hasta").toString().trim()) ){
    dto.setOidPeriodoHasta ( new Long(param.get("hasta").toString()));
	} else {
		dto.setOidPeriodoHasta ( null );
	}
  
  String aux = conectorParametro("labelLote");
  Long numeroLote = null;
  if(aux != null && !"".equals(aux)) {
      numeroLote = new Long(aux);
  }    
  dto.setNumeroLote( numeroLote ); 
	
  dto.setDescripcion ( param.get("txtDescLote").toString() ) ;
	if (param.get("txtObservaciones") != null) {
		traza("txtObservaciones: " + param.get("txtObservaciones"));
    dto.setObservaciones( param.get("txtObservaciones").toString() );
	}

    MareBusinessID idBusiness = new MareBusinessID("INTGenerarFicheroMatrizPrecios");
    Vector params = new Vector();
    params.add(dto);
    params.add(idBusiness);
    conectar("ConectorGenerarFicheroMatrizPrecios", params);

  }

}
