//01-02-2005 mdolce
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

public class CALBuzonUsuarios extends LPSICCBase {           
   public CALBuzonUsuarios() {	 
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
           getConfiguracionMenu("CALBuzonUsuarios");
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
     pagina("contenido_buzon_usuarios_obtener");   
       
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
     asignarAtributo("VAR","hLongCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
     
     DTOBelcorp dtoMC = new DTOBelcorp();
     dtoMC.setOidIdioma(UtilidadesSession.getIdioma(this));
     dtoMC.setOidPais(UtilidadesSession.getPais(this));
     
     MareBusinessID idMC = new MareBusinessID("CALObtenerCabeceraBuzonCombo");
     Vector vecMC = new Vector();
     
     vecMC.add(dtoMC);
     vecMC.add(idMC);
     DTOSalida dtoMCS = (DTOSalida)conectar("ConectorUA",vecMC).objeto("dtoSalida"); 
     RecordSet mc = (RecordSet)dtoMCS.getResultado();
     Vector colMC = mc.getColumnIdentifiers();
     DruidaConector mcs = generarConector("DTOSalida.mc_ROWSET",mc, colMC);
     asignar("COMBO", "cbBuzon", mcs, "DTOSalida.mc_ROWSET");  
     
         
     this.generarHiddenFormatoFecha();
     
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "CAL");
     
     //comienzo de los parametrso de filtrado
       
     String fechaInicio        = conectorParametroLimpia("fechaInicio", "", true);
     datos.put(ConstantesREP.FECHAINICIO, fechaInicio);     
     
     String fechaFin        = conectorParametroLimpia("fechaFin", "", true);
     datos.put(ConstantesREP.FECHAFIN, fechaFin);     
         
     String buzon        = conectorParametroLimpia("buzon", "", true);
     String buzonDesc        = conectorParametroLimpia("buzonDesc", "", true);
     if(!buzon.equals("")){
        datos.put(ConstantesREP.BUZON, buzon);     
        datos.put(ConstantesREP.BUZONDESC, buzonDesc);     
     }
     
     String codigoCliente        = conectorParametroLimpia("codigoCliente", "", true);
     if(!codigoCliente.equals("")){
        datos.put(ConstantesREP.CODIGOCLIENTE, codigoCliente);     
     }
     
   
     datos.put(ConstantesREP.TITULO, "Buzon de Usuarios");     
     
     String reporte = conectorParametroLimpia("reporte", "", true);
     
     traza("++++++Antes de enviar a reportes " + datos); 
         
     //ejecutarReporte(datos, "REPGenerarReporte", reporte , null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-088", "pdf");
          
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
  
 
  
  

    
  
 
 
















