
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import java.util.Vector;
import es.indra.sicc.util.xml.XMLDocument;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;

public class PREGuiaProductos extends LPSICCBase {           
   public PREGuiaProductos() {	 
     super();
  }

  public void inicio() throws Exception { 
     
  }

  public void ejecucion() throws Exception {		
     String accion = conectorParametroLimpia("accion","", true);
     setTrazaFichero();
     try {
        this.rastreo();
        
        if (accion.equals("generar")){
           generarReporte(); 
           traza("termino de generar el reporte");
          //cargarPagina();
        }else{
           cargarPagina();
           getConfiguracionMenu("PREGuiaProductos");
        }
     
     } catch (Exception ex) {
     			
        cargarPagina();
        getConfiguracionMenu("PREGuiaProductos");
               
        ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			  ex.printStackTrace(out);
	      traza("EXCEPCION:" + stack.toString());
		    lanzarPaginaError(ex);
      /*  try{
            cargarPagina();
        }catch(Exception e){
            e.printStackTrace();
        }*/

     }

    
  }
  
  private void cargarPagina() throws Exception{
      pagina("contenido_reporte_guia_producto_generar");   
    
      ComposerViewElementList cv = crearParametrosEntrada();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      traza(" 4 " + resultados.getXML());
          
      asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
      asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
      asignarAtributo("LABELC", "lbldtPais", "valor", UtilidadesSession.getDescripcionPais(this));
      asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());           
      asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());           
     
        
   
  }
  
  
 
  private ComposerViewElementList crearParametrosEntrada() throws Exception{
     traza("metodo crearParametrosEntrada() ");
     DTOBelcorp dtoBel = new DTOBelcorp();
     
     dtoBel.setOidPais(UtilidadesSession.getPais(this));
     dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
       
     ComposerViewElementList lista = new ComposerViewElementList();
     
     //Carga de combo marca
     ComposerViewElement cbMarca = new ComposerViewElement();
     cbMarca.setIDBusiness("SEGConsultaMarcas");
     cbMarca.setDTOE(dtoBel);
     
     //Carga de combo canales
     ComposerViewElement cbCanales = new ComposerViewElement();
     cbCanales.setIDBusiness("SEGConsultaCanales");
     cbCanales.setDTOE(dtoBel);
                          
     lista.addViewElement(cbMarca);
     lista.addViewElement(cbCanales);   
        
     
     return lista;
  }
         
  
  private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "PRE");
     
     //comienzo de los parametrso de filtrado
     String marca        = conectorParametroLimpia("marca", "", true);
     datos.put(ConstantesREP.MARCA, marca);     
         
     String canal        = conectorParametroLimpia("canal", "", true);
     datos.put(ConstantesREP.CANAL, canal);     
     
     String marcaDesc        = conectorParametroLimpia("marcaDesc", "", true);
     datos.put(ConstantesREP.MARCADESC, marcaDesc);     
         
     String canalDesc        = conectorParametroLimpia("canalDesc", "", true);
     datos.put(ConstantesREP.CANALDESC, canalDesc);     
         
     String periodo        = conectorParametroLimpia("periodo", "", true);
     datos.put(ConstantesREP.PERIODO, periodo);     
     
     String nLineaDesde        = conectorParametroLimpia("nLineaDesde", "", true);
     if(!nLineaDesde.equals("")){
        datos.put(ConstantesREP.NUMEROLINEADESDE, nLineaDesde);     
     }
     String nLineaHasta        = conectorParametroLimpia("nLineaHasta", "", true);
     if(!nLineaHasta.equals("")){
        datos.put(ConstantesREP.NUMEROLINEAHASTA, nLineaHasta);     
     }
     
     String criteriosSeleccionDesc = conectorParametroLimpia("criteriosSeleccionDesc", "", true);
     datos.put(ConstantesREP.CRITERIOSELECCIONDESC,criteriosSeleccionDesc);
     
     
     String formatoSalida = conectorParametroLimpia("formatoSalida", "", true);
     String extension = null;
     if(!formatoSalida.equals("")){
        datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
        extension = "xls";
     }else{
        extension = "pdf";
     }
     
     String periodoDesc        = conectorParametroLimpia("periodoDesc", "", true);
     
     
     datos.put(ConstantesREP.TITULO, "Reporte de Guia de Productos para Campaña " + periodoDesc);   
     traza("los datos son " + datos);
     traza("++++++Antes de enviar a reportes"); 
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-043", extension);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-043", extension);
          
  } 

}
