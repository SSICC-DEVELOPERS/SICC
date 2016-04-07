import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Vector;
//import es.indra.sicc.dtos.mae.DTOTipoSubtipo;

public class FACDTRListadoSegmentoConsultora extends LPSICCBase {           
   public FACDTRListadoSegmentoConsultora() {	 
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
           getConfiguracionMenu("FACDTRListadoSegmentoConsultora");
        }
     
     } catch (Exception ex) {
     			
      // cargarPagina();
      //  getConfiguracionMenu("EDUFichaTecnicaCurso");
               
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
     pagina("contenido_listado_segmento_consultora_3");   
        
     ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
           
     asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");              
     asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
  
     this.generarHiddenFormatoFecha();
     
     DTOBelcorp dto = new DTOBelcorp();
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     dto.setOidPais(UtilidadesSession.getPais(this));
          
     MareBusinessID id = new MareBusinessID("FACObtenerNivel");
     Vector vec = new Vector();
          
     vec.add(dto);
     vec.add(id);
     DTOSalida dtoTP = (DTOSalida)conectar("ConectorUA",vec).objeto("dtoSalida"); 
     RecordSet mc = (RecordSet)dtoTP.getResultado();
     Vector colMC = mc.getColumnIdentifiers();
     DruidaConector mcs = generarConector("DTOSalida.mc_ROWSET",mc, colMC);
     
     asignar("COMBO", "cbNivel", mcs, "DTOSalida.mc_ROWSET");  
   
      
  }
  
 
    
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "FAC-DTR");
     
     //comienzo de los parametrso de filtrado
        
     String marca        = conectorParametroLimpia("marca", "", true);
     datos.put(ConstantesREP.MARCA, marca);
     
     String marcaDesc        = conectorParametroLimpia("marcaDesc", "", true);
     datos.put(ConstantesREP.MARCADESC, marcaDesc);
     
     String canal        = conectorParametroLimpia("canal", "", true);
     datos.put(ConstantesREP.CANAL, canal);
     
     String canalDesc        = conectorParametroLimpia("canalDesc", "", true);
     datos.put(ConstantesREP.CANALDESC, canalDesc);
     
     String periodoDesde        = conectorParametroLimpia("periodoDesde", "", true);
     datos.put(ConstantesREP.PERIODODESDE, periodoDesde);
     
     String periodoDesdeDesc        = conectorParametroLimpia("periodoDesdeDesc", "", true);
     datos.put(ConstantesREP.PERIODODESDEDESC, periodoDesdeDesc);
     
     String periodoHasta        = conectorParametroLimpia("periodoHasta", "", true);
     datos.put(ConstantesREP.PERIODOHASTA, periodoHasta);
     
     String periodoHastaDesc        = conectorParametroLimpia("periodoHastaDesc", "", true);
     datos.put(ConstantesREP.PERIODOHASTADESC, periodoHastaDesc);
     
     String nivel        = conectorParametroLimpia("nivel", "", true);
     datos.put(ConstantesREP.NIVEL, nivel);
     
     String region        = conectorParametroLimpia("region", "", true);
     if(!region.equals("")){
        datos.put(ConstantesREP.REGION, region);
     }
     
     String zona        = conectorParametroLimpia("zona", "", true);
     if(!zona.equals("")){
        datos.put(ConstantesREP.ZONA, zona);
     }
     
      
     String reporte = null;
     
   
     datos.put(ConstantesREP.TITULO, "Listado de Posibles Egresos");     
     traza("++++++Antes de enviar a reportes " + datos); 
     
     String formato = conectorParametroLimpia("formato", "", true);
     
       
     //ejecutarReporte(datos, "REPGenerarReporte", "RFD-008", formato);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_RFD-008", formato);
    
          
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
  
  private DruidaConector generarConector(String rowsetID, RecordSet datos,
           Vector columns) throws DOMException, Exception {
           StringBuffer salida = new StringBuffer();
 
           int sizeColums = datos.getColumnCount();
           int sizeRows = datos.getRowCount();
 
           if (columns == null) {
                columns = new Vector();
           }
 
           Vector columsDesc = datos.getColumnIdentifiers();
 
           DruidaConector conectorValoresPosibles = new DruidaConector();
           XMLDocument xmlDoc = new XMLDocument();
           Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
           Element e_rows = docDestino.createElement("ROWSET");
           e_rows.setAttribute("ID", rowsetID);
           docDestino.getDocumentElement().appendChild(e_rows);
 
           for (int i = 0; i < sizeRows; i++) {
                Element e_row = docDestino.createElement("ROW");
                e_rows.appendChild(e_row);
 
                for (int j = 0; j < sizeColums; j++) {
                      if (columns.contains(columsDesc.elementAt(j))) {
                            Element e_campo2 = docDestino.createElement("CAMPO");
                            e_campo2.setAttribute("NOMBRE",
                                  columsDesc.elementAt(j).toString());
                            e_campo2.setAttribute("TIPO", "OBJECTO");
                            e_campo2.setAttribute("LONGITUD", "50");
 
                            Text txt = docDestino.createTextNode(((datos.getValueAt(i, j) == null)
                                         ? "" : datos.getValueAt(i, j).toString()));
                            e_campo2.appendChild(txt);
                            e_row.appendChild(e_campo2);
                      }
                }
           }
 
           conectorValoresPosibles.setXML(docDestino.getDocumentElement());
 
           return conectorValoresPosibles;
    }
 

  
            
}




















