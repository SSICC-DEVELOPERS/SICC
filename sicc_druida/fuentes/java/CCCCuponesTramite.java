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

import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
//import es.indra.sicc.dtos.mae.DTOTipoSubtipo;

public class CCCCuponesTramite extends LPSICCBase {           
   public CCCCuponesTramite() {	 
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
           getConfiguracionMenu("CCCCuponesTramite");
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
     pagina("contenido_informe_cupones_tramite_generar");   
    
    DTOBelcorp dto = new DTOBelcorp();
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     dto.setOidPais(UtilidadesSession.getPais(this));
          
     MareBusinessID id = new MareBusinessID("CCCObtieneBancos");
     Vector vec = new Vector();
          
     vec.add(dto);
     vec.add(id);
     DTOSalida dtoTP = (DTOSalida)conectar("ConectorUA",vec).objeto("dtoSalida"); 
     RecordSet mc = (RecordSet)dtoTP.getResultado();
     Vector colMC = mc.getColumnIdentifiers();
     DruidaConector mcs = generarConector("DTOSalida.mc_ROWSET",mc, colMC);
     
     asignar("COMBO", "cbBanco", mcs, "DTOSalida.mc_ROWSET");  
       
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());

        
     this.generarHiddenFormatoFecha();
     
     String fechaActual = null;
     java.util.Date fecha = new java.util.Date(System.currentTimeMillis());
     String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
     formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
            
     SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion);
     fechaActual = simpleDate.format(fecha);
     traza("la fecha actual " + fechaActual);
     asignarAtributo("VAR", "fechaActual", "valor", fechaActual);     
      
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "CCC");
     
     //comienzo de los parametrso de filtrado
        
     String fechaValorDesde        = conectorParametroLimpia("fechaValorDesde", "", true);
     datos.put(ConstantesREP.FECHADEVALORDESDE, fechaValorDesde);
     
     String fechaValorHasta        = conectorParametroLimpia("fechaValorHasta", "", true);
     datos.put(ConstantesREP.FECHADEVALORHASTA, fechaValorHasta);
     
     String fechaProcesoDesde        = conectorParametroLimpia("fechaProcesoDesde", "", true);
     if(!fechaProcesoDesde.equals("")){
          datos.put(ConstantesREP.FECHADEPROCESODESDE, fechaProcesoDesde);
     }
     
     String fechaProcesoHasta        = conectorParametroLimpia("fechaProcesoHasta", "", true);
     if(!fechaProcesoHasta.equals("")){
          datos.put(ConstantesREP.FECHADEPROCESOHASTA, fechaProcesoHasta);
     }
            
     String banco        = conectorParametroLimpia("banco", "", true);
     if(!banco.equals("")){
        datos.put(ConstantesREP.BANCOS, banco);
     } 
     
	 String bancoDesc        = conectorParametroLimpia("bancoDesc", "", true);
     if(!bancoDesc.equals("")){
        datos.put(ConstantesREP.BANCOSDESC, bancoDesc);
     } 
     String orden        = conectorParametroLimpia("orden", "", true);
     if(orden.equals("1")){
        datos.put(ConstantesREP.CRITERIODEORDENAMIENTO, "'FECHA_VALOR, CODIGO'");  
     }else{
        datos.put(ConstantesREP.CRITERIODEORDENAMIENTO, "'CODIGO ,FECHA_VALOR'");  
     }

     String ordenDesc        = conectorParametroLimpia("ordenDesc", "", true);
	 datos.put(ConstantesREP.ORDENDESC, ordenDesc);	
       
   
     String formatoSalida = conectorParametroLimpia("formatoSalida", "", true);
     String formato = null;
     
     if(formatoSalida.equals("xls")){
        datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
        formato = "xls";
     }else{
        formato = "pdf";
     }
    
     datos.put(ConstantesREP.TITULO, "Cupones en Tramite sin Aplicar");     
     traza("++++++Antes de enviar a reportes " + datos); 
        
     
     traza("el formaro es  " + formato);
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-140", formato);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-140", formato);
          
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
  
  
    private Object obtenerDatosSalida(String bID, String conector, Object dto) throws Exception {
      
             //traza("entro a ObtenerDatos Salida");
             Vector paramEntrada = new Vector();
             MareBusinessID id = new MareBusinessID(bID);
             paramEntrada.add(dto);
             paramEntrada.add(id);

             //traza("****************dto del obtener: " + dto);
             //traza("****************id del obtener: " + id.getBusinessID());
             //traza("*********Conector " + conector);
             DruidaConector ver = conectar(conector, paramEntrada);
             Object obj = ver.objeto("DTOSalida");

             //traza("ver DTOSalida " + obj.toString());
             return obj;
         
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














