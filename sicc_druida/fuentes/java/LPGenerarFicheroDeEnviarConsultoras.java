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
      
public class LPGenerarFicheroDeEnviarConsultoras extends LPSICCBase {

  public LPGenerarFicheroDeEnviarConsultoras() {
    super();
  }
    
 public void inicio() throws Exception {
     pagina("generar_fichero_de_usuarios");
      this.getConfiguracionMenu();
  }

  public void ejecucion() throws Exception {
	  rastreo();
      setTrazaFichero();
      String accion = conectorParametro("accion");
      //accion = (accion==null )?"":accion;
      traza("accion de entrada " + accion);   
      try{
      if(accion.equals("Guardar")){
		pagina("salidaGenerica");
        this.guardar();
		asignarAtributo("VAR", "ejecutar", "valor", "ok()");
      }

      
      }catch(Exception  e){
        traza("ERROR: " + e);
        e.printStackTrace();
        //asignarAtributo("VAR","errDescripcion","valor","Error al generar fichero");
        this.lanzarPaginaError(e);
      }
  }

  private void guardar() throws Exception{
    traza("metodo guardar 1");
    MareBusinessID idBusiness = new MareBusinessID("INTGenerarFicheroDeEnviarConsultoras");
    traza("metodo guardar 2");
	Vector params = new Vector();
    DTOGenerarFicheroDeEnviarConsultoras dto = new DTOGenerarFicheroDeEnviarConsultoras(); 
    dto.setOidPais( UtilidadesSession.getPais(this) ); 
    traza("metodo guardar 3");
    // dto.setNumeroLote( numeroLote ); 
    // dto.setDescripcion( descripcion ); 
    traza("metodo guardar 4 " + conectorParametro("txtDscLote"));
    dto.setObservaciones ( conectorParametro("txtDscLote") ); 
    params.add(dto);
    params.add(idBusiness);
    traza("se va a hacer el conectar");
    conectar("ConectorGenerarFicheroDeEnviarConsultoras", params);
	//DruidaConector con = conectar("OCRGenerarFicheroDeEnviarConsultoras", params);


  }
}
