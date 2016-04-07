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
public class PREMatrizRecuperacion extends LPSICCBase {           
   public PREMatrizRecuperacion() {	 
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
           getConfiguracionMenu("PREMatrizRecuperacion");
        }
     
     } catch (Exception ex) {
     			
        cargarPagina();
        getConfiguracionMenu("PREMatrizRecuperacion");
               
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
      pagina("contenido_informe_matriz_recuperacion_generar");   
    
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
      
      //cargo el combo de estrategias
   
      DTOBelcorp dtoB = new DTOBelcorp();
      MareBusinessID id = new MareBusinessID("PREBuscarEstrategias");
      dtoB.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoB.setOidPais(UtilidadesSession.getPais(this));
      Vector vec = new Vector();
      vec.add(dtoB);
      vec.add(id);
      DTOSalida dtoSal = (DTOSalida)conectar("ConectorEstrategias",vec).objeto("dtoSalida"); 
      RecordSet estrategia = (RecordSet)dtoSal.getResultado();
      Vector colESTRATEGIA = estrategia.getColumnIdentifiers();
      DruidaConector estrategias = generarConector("DTOSalida.estrategias_ROWSET",estrategia, colESTRATEGIA);
      asignar("COMBO", "cbEstrategia", estrategias, "DTOSalida.estrategias_ROWSET");  
      
        
   
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
     String marca = conectorParametroLimpia("marca", "", true);
     datos.put(ConstantesREP.MARCA, marca);     
     
     String canal = conectorParametroLimpia("canal", "", true);
     datos.put(ConstantesREP.CANAL, canal);
     
     String marcaDesc = conectorParametroLimpia("marcaDesc", "", true);
     datos.put(ConstantesREP.MARCADESC, marcaDesc);
      
     String canalDesc = conectorParametroLimpia("canalDesc", "", true);
     datos.put(ConstantesREP.CANALDESC, canalDesc);
     
     String periodo = conectorParametroLimpia("periodo", "", true);
     datos.put(ConstantesREP.PERIODO, periodo);
     
     String periodoDesc = conectorParametroLimpia("periodoDesc", "", true);
     datos.put(ConstantesREP.PERIODODESC, periodoDesc);
     
     String tipoRecuperacion = conectorParametroLimpia("tipoRecuperacion", "", true);
     if(!tipoRecuperacion.equals("") ){
        datos.put(ConstantesREP.TIPORECUPERACION, tipoRecuperacion);
     }
     
     String recuperacionDesde = conectorParametroLimpia("recuperacionDesde", "", true);
     datos.put(ConstantesREP.CODIGORECUPERACIONDESDE,recuperacionDesde);
         
     String recuperacionHasta = conectorParametroLimpia("recuperacionHasta", "", true);
     datos.put(ConstantesREP.CODIGORECUPERACIONHASTA,recuperacionHasta);
     
     String estrategia = conectorParametroLimpia("estrategia", "", true);
     if(!estrategia.equals("") ){
        datos.put(ConstantesREP.ESTRATEGIA, estrategia);
     }
     
     String vista = conectorParametroLimpia("vista", "", true);
     datos.put(ConstantesREP.VISTA,vista);
     
     String region = conectorParametroLimpia("region", "", true);
     if(!region.equals("") ){
        datos.put(ConstantesREP.REGION,region);
     }  
     
     
     String criteriosSeleccionDesc = conectorParametroLimpia("criteriosSeleccionDesc", "", true);
     datos.put(ConstantesREP.CRITERIOSELECCIONDESC,criteriosSeleccionDesc);
     
     
     String reporte = null;
     
     
     if(vista.equals("1")){
        if(tipoRecuperacion.equals("")){
           reporte = "RD_REP-046_01";
        }
        
        if(tipoRecuperacion.equals("1")){
           reporte = "RD_REP-046_02";
        }
        
        if(tipoRecuperacion.equals("2")){
           reporte = "RD_REP-046_03";
        }
        
        if(tipoRecuperacion.equals("3")){
           reporte = "RD_REP-046_04";
        }
     }else{
        if(tipoRecuperacion.equals("")){
           reporte = "RD_REP-046_01_D";
        }
        
        if(tipoRecuperacion.equals("1")){
           reporte = "RD_REP-046_02_D";
        }
        
        if(tipoRecuperacion.equals("2")){
           reporte = "RD_REP-046_03_D";
        }
        
        if(tipoRecuperacion.equals("3")){
           reporte = "RD_REP-046_04_D";
        }
     }
     
     datos.put(ConstantesREP.TITULO, "Matriz de Recuperacion " + periodoDesc);
     traza("los datos son " + datos);
     traza("++++++Antes de enviar a reportes"); 
     //ejecutarReporte(datos, "REPGenerarReporte", reporte, null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", reporte, "pdf");
          
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


