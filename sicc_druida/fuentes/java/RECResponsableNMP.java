import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
//import es.indra.sicc.dtos.mae.DTOTipoSubtipo;

public class RECResponsableNMP extends LPSICCBase {           
   public RECResponsableNMP() {	 
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
           getConfiguracionMenu("RECResponsableNMP");
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
 
  
  
  private void cargarPagina() throws Exception{
     pagina("contenido_informe_responsable_nmp_generar");   
     
     asignarAtributo("LABELC", "lbldtPais", "valor", UtilidadesSession.getDescripcionPais(this));
        
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
          
     MareBusinessID id = new MareBusinessID("RECComboTipoOperaciones");
     Vector vec = new Vector();
          
     vec.add(dto);
     vec.add(id);
     DTOSalida dtoTP = (DTOSalida)conectar("ConectorUA",vec).objeto("dtoSalida"); 
     RecordSet mc = (RecordSet)dtoTP.getResultado();
     Vector colMC = mc.getColumnIdentifiers();
     DruidaConector mcs = generarConector("DTOSalida.mc_ROWSET",mc, colMC);
     
     asignar("COMBO", "cbTipoOperacion", mcs, "DTOSalida.mc_ROWSET");  
     
    /*MareBusinessID id2 = new MareBusinessID("MAEUsuarioResponsable");
     Vector vec2 = new Vector();
          
     vec2.add(dto);
     vec2.add(id2);
     DTOSalida dtoUR = (DTOSalida)conectar("ConectorUA",vec2).objeto("dtoSalida"); 
     RecordSet ur = (RecordSet)dtoUR.getResultado();
     Vector colUR = ur.getColumnIdentifiers();
     DruidaConector urs = generarConector("DTOSalida.ur_ROWSET",ur, colUR);
     
     asignar("COMBO", "cbResponsablePerdida", urs, "DTOSalida.ur_ROWSET");  */
     
     MareBusinessID id3 = new MareBusinessID("PEDObtenertipoSolicitudPaisREP");
     Vector vec3 = new Vector();
          
     vec3.add(dto);
     vec3.add(id3);
     DTOSalida dtoTS = (DTOSalida)conectar("ConectorUA",vec3).objeto("dtoSalida"); 
     RecordSet ts = (RecordSet)dtoTS.getResultado();
     Vector colTS = ts.getColumnIdentifiers();
     DruidaConector tss = generarConector("DTOSalida.ts_ROWSET",ts, colTS);
     
     asignar("COMBO", "cbTipoSolicitudGenerada", tss, "DTOSalida.ts_ROWSET");  
     

      
  }
  
 
    
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "REC");
     
     //comienzo de los parametrso de filtrado
        
     String marca        = conectorParametroLimpia("marca", "", true);
     if(!marca.equals("")){
        datos.put(ConstantesREP.MARCA, marca);
     }
     
     String canal        = conectorParametroLimpia("canal", "", true);
     if(!canal.equals("")){
        datos.put(ConstantesREP.CANAL, canal);
     }
     
     String tipoOperacion        = conectorParametroLimpia("tipoOperacion", "", true);
     if(!tipoOperacion.equals("")){
        datos.put(ConstantesREP.TIPOOPERACIONES, tipoOperacion);
     }
     
     String numeroPropuesto        = conectorParametroLimpia("numeroPropuesto", "", true);
     if(!numeroPropuesto.equals("")){
        datos.put(ConstantesREP.NUMEROPROPUESTOS, numeroPropuesto);
     }
     
     String responsablesPropuestos        = conectorParametroLimpia("responsablesPropuestos", "", true);
     if(!responsablesPropuestos.equals("")){
        datos.put(ConstantesREP.RESPONSABLESPERDIDA, responsablesPropuestos);
     }
     
     String asumePerdida        = conectorParametroLimpia("asumePerdida", "", true);
     if(!asumePerdida.equals("")){
        datos.put(ConstantesREP.ASUMEPERDIDAS, asumePerdida);
     }
     
     String fechaDesde        = conectorParametroLimpia("fechaDesde", "", true);
     if(!fechaDesde.equals("")){
        datos.put(ConstantesREP.FECHADESDE, fechaDesde);
     }
     
     String fechaHasta        = conectorParametroLimpia("fechaHasta", "", true);
     if(!fechaHasta.equals("")){
        datos.put(ConstantesREP.FECHAHASTA, fechaHasta);
     }
     
     String periodoDesde        = conectorParametroLimpia("periodoDesde", "", true);
     if(!periodoDesde.equals("")){
        datos.put(ConstantesREP.PERIODODESDE, periodoDesde);
     }
     
     String periodoHasta        = conectorParametroLimpia("periodoHasta", "", true);
     if(!periodoHasta.equals("")){
        datos.put(ConstantesREP.PERIODOHASTA, periodoHasta);
     }
     
     String tipoSolicitud        = conectorParametroLimpia("tipoSolicitud", "", true);
     if(!tipoSolicitud.equals("")){
        datos.put(ConstantesREP.TIPOSOLICITUDES, tipoSolicitud);
     }  
     
     
     String criteriosSeleccion = conectorParametroLimpia("criteriosSeleccion", "", true);
     datos.put(ConstantesREP.CRITERIOSELECCIONDESC, criteriosSeleccion);
     
     
     datos.put(ConstantesREP.TITULO, "Responsable de NMP");
     traza("++++++Antes de enviar a reportes " + datos); 
     
     String formato = conectorParametroLimpia("formato", "", true);
     
     if(formato.equals("xls")){
        datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
     }
	 String tipoReporte = conectorParametroLimpia("tipoReporte", "", true);
	 datos.put(ConstantesREP.TIPOREPORTE, tipoReporte);
     
       
//     ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-165", formato);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-165", formato);

    
          
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

  
            
}




















