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
import es.indra.sicc.dtos.cra.DTOPeriodo;
//import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.util.DTOOID;

public class CCCResumenVentas extends LPSICCBase {           
   public CCCResumenVentas() {	 
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
           getConfiguracionMenu("CCCResumenVentas");
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
     pagina("contenido_informe_resumen_ventas_generar");
	 this.getFormatosValidaciones();
     this.generarHiddenFormatoFecha();
     
     DTOBelcorp dto = new DTOBelcorp();
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     dto.setOidPais(UtilidadesSession.getPais(this));
          
     MareBusinessID id = new MareBusinessID("SEGObtenerTiposPeriodo");
     Vector vec = new Vector();
          
     vec.add(dto);
     vec.add(id);
     DTOSalida dtoTP = (DTOSalida)conectar("ConectorUA",vec).objeto("dtoSalida"); 
     RecordSet mc = (RecordSet)dtoTP.getResultado();
     Vector colMC = mc.getColumnIdentifiers();
     DruidaConector mcs = generarConector("DTOSalida.mc_ROWSET",mc, colMC);
     
     asignar("COMBO", "cbTipoPeriodo", mcs, "DTOSalida.mc_ROWSET");  
      
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "CCC");
     
     //comienzo de los parametrso de filtrado
        
     String fechaContable = conectorParametroLimpia("fechaContable", "", true);
     if(!fechaContable.equals("")){
       datos.put(ConstantesREP.FECHACONTABLE, fechaContable);
     }
     
     String periodo = conectorParametroLimpia("periodo", "", true);
     if(!periodo.equals("")){
       datos.put(ConstantesREP.PERIODOCONTABLE, periodo);
     }
     
     String ejercicio = conectorParametroLimpia("ejercicio", "", true);
     if(!ejercicio.equals("")){
       datos.put(ConstantesREP.EJERCICIO, ejercicio);
     }
     
     String tipoPeriodo = conectorParametroLimpia("tipoPeriodo", "", true);
     if(!tipoPeriodo.equals("")){
       datos.put(ConstantesREP.TIPODEPERIODO, tipoPeriodo);
     }
     
     String periodoComercial = conectorParametroLimpia("periodoComercial", "", true);
    if(!periodoComercial.equals("") && !tipoPeriodo.equals("")){
	   //RECUPERAR CODIGO DE PERIODO COMERCIAL, PASANDO LA CAMPAÑA(ENTERO DE 1 A 18)
	   String l_codigoperiodoComercial=null;
	   DTOPeriodo dto = new DTOPeriodo();
	   dto.setOidPeriodoCorporativo(new Long(periodoComercial));
	   dto.setTipo(new Long(tipoPeriodo));
	   traza("++++++Antes de obtenerCodigoPeriodoComercial: periodoComercial:" + periodoComercial + ",tipoPeriodo:" + tipoPeriodo );
	   l_codigoperiodoComercial = this.obtenerCodigoPeriodoComercial(dto).toString();
	   traza("++++++Despues de obtenerCodigoPeriodoComercial: l_codigoperiodoComercial:" + l_codigoperiodoComercial );

       datos.put(ConstantesREP.PERIODOCOMERCIAL,l_codigoperiodoComercial);
     }
       
     
     String vista = conectorParametroLimpia("vista", "", true);
     String vistaDesc = conectorParametroLimpia("vistaDesc", "", true);
     
     datos.put(ConstantesREP.TIPOREPORTEDESC, vistaDesc);
     
     String reporte = null;
     
  
     if(vista.equals("1")){
        reporte = "RD_REP-135";
     }else{
        reporte = "RD_REP-135_01";
     }
      
     String formato = conectorParametroLimpia("formato", "", true);

     if(formato.equals("xls")){
          datos.put(ConstantesREP.FORMATOSALIDA,"EXCEL");
     }

     datos.put(ConstantesREP.TITULO, "Resumen de Ventas");     
     traza("++++++Antes de enviar a reportes " + datos); 
     
     String criterioSeleccionDesc = conectorParametroLimpia("criterioDesc", "", true);
     datos.put(ConstantesREP.CRITERIOSELECCIONDESC, criterioSeleccionDesc);
     
     
     //ejecutarReporte(datos, "REPGenerarReporte", reporte, formato);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", reporte, formato);
    
    
          
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

	private Long obtenerCodigoPeriodoComercial(DTOPeriodo dto) throws Exception{
		 
		 /*DTOPeriodo dto = new DTOPeriodo();
		 dto.setOidIdioma(UtilidadesSession.getIdioma(this));
		 dto.setOidPais(UtilidadesSession.getPais(this));*/
			  
		 MareBusinessID id = new MareBusinessID("REPObtenerCodigoPeriodoComercial");
		 Vector vec = new Vector();
		 vec.add(dto);
		 vec.add(id);
		 DTOOID dtoTP = (DTOOID)conectar("ConectorCodigoPeriodoComercial",vec).objeto("dtoOID"); 
		 Long codigoperiodocomercial = dtoTP.getOid();
		 return codigoperiodocomercial;
  }
}
  

















