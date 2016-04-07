import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
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

public class BELMovimientosKardex extends LPSICCBase {           
   public BELMovimientosKardex() {	 
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
           getConfiguracionMenu("BELMovimientosKardex");
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
     pagina("contenido_consulta_movimientos_Kardex_obtener");   
    
     DTOBelcorp dto = new DTOBelcorp();
     dto.setOidPais(UtilidadesSession.getPais(this));
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     
     MareBusinessID id5 = new MareBusinessID("BELObtenerAlmacenes");
     
     Vector parametros5 = new Vector();
     parametros5.add(dto);
     parametros5.add(id5);
     
     DTOSalida dtoSal5 = (DTOSalida) conectar("ConectorAlmacenes",parametros5).objeto("dtoSalida"); 
     RecordSet almacen = (RecordSet)dtoSal5.getResultado();
     Vector colAlm = almacen.getColumnIdentifiers();
     DruidaConector almacenes = generarConector("DTOSalida.almacenes_ROWSET",almacen, colAlm);
     traza("almacen "+dtoSal5.getResultado());
     traza("almacen "+dtoSal5.getResultado().getColumnIdentifiers());
     asignar("COMBO", "cbAlmacen", almacenes, "DTOSalida.almacenes_ROWSET");
     
     MareBusinessID id6 = new MareBusinessID("BELObtenerEstadosMercancia");
     
     Vector parametros6 = new Vector();
     parametros6.add(dto);
     parametros6.add(id6);
     
     DTOSalida dtoSal6 = (DTOSalida) conectar("ConectorEstadosMercancia",parametros6).objeto("dtoSalida"); 
     RecordSet estado = (RecordSet)dtoSal6.getResultado();
     Vector colEst = estado.getColumnIdentifiers();
     DruidaConector estados = generarConector("DTOSalida.estados_ROWSET",estado, colEst);
     traza("estados "+dtoSal6.getResultado());
     traza("estados "+dtoSal6.getResultado().getColumnIdentifiers());
     
     asignar("COMBO", "cbEstadoMercaderia", estados, "DTOSalida.estados_ROWSET");
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
        
     this.generarHiddenFormatoFecha();
      
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "BEL");
     
     //comienzo de los parametrso de filtrado
             
     String almacen        = conectorParametroLimpia("almacen", "", true);
     datos.put(ConstantesREP.ALMACENES, almacen);     
          
     String estadoMercancia        = conectorParametroLimpia("estadoMercancia", "", true);
     datos.put(ConstantesREP.ESTADOMERCANCIA, estadoMercancia);     
          
     String codigoProducto        = conectorParametroLimpia("codigoProducto", "", true);
     datos.put(ConstantesREP.CODIGOPRODUCTO, codigoProducto);     
         
     String fechaDesde        = conectorParametroLimpia("fechaDesde", "", true);
     datos.put(ConstantesREP.FECHADESDE, fechaDesde);     
     
     String fechaHasta        = conectorParametroLimpia("fechaHasta", "", true);
     datos.put(ConstantesREP.FECHAHASTA, fechaHasta);                
     
     String formatoSalida = conectorParametroLimpia("formatoSalida", "", true);
     String formato = null;
     
     if(formatoSalida.equals("xls")){
        formato = "xls";
        datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
     }else{
        formato = "pdf";
     }
    
     datos.put(ConstantesREP.TITULO, "Consulta Movimiento Kardex");     
     traza("++++++Antes de enviar a reportes " + datos);         
          
     traza("el formaro es  " + formato);
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-095", formato);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-095", formato);
          
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














