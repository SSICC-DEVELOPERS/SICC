import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
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

public class CALLlamadasRecibidas extends LPSICCBase {           
   public CALLlamadasRecibidas() {	 
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
           getConfiguracionMenu("CALLlamadasRecibidas");
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
     pagina("contenido_seguimiento_llamadas_recibidas_obtener");   
        
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
     
     DTOTipoSubtipo dtotsubtipo = new DTOTipoSubtipo(); 
     DTOBelcorp dtoBelcorp = new DTOBelcorp();
     dtoBelcorp.setOidPais(UtilidadesSession.getPais(this));
     dtoBelcorp.setOidIdioma(UtilidadesSession.getIdioma(this));
     dtotsubtipo = (DTOTipoSubtipo) obtenerDatosSalida("MAEObtenerTipoSubtipo", "ConectorTipoSubtipo", (DTOBelcorp) dtoBelcorp);
     RecordSet tipo = (RecordSet) dtotsubtipo.getTipos();
     Vector colID = tipo.getColumnIdentifiers();
     DruidaConector dtipo = this.generarConector("DTOSalida.tipos_ROWSET", tipo, colID);
     asignar("COMBO", "cbTipoCliente1", dtipo, "DTOSalida.tipos_ROWSET");
     asignar("COMBO", "cbTipoCliente2", dtipo, "DTOSalida.tipos_ROWSET");
     asignar("COMBO", "cbTipoCliente3", dtipo, "DTOSalida.tipos_ROWSET");
     asignar("COMBO", "cbTipoCliente4", dtipo, "DTOSalida.tipos_ROWSET");
     asignar("COMBO", "cbTipoCliente5", dtipo, "DTOSalida.tipos_ROWSET");
     asignar("COMBO", "cbTipoCliente6", dtipo, "DTOSalida.tipos_ROWSET");
     
     this.generarHiddenFormatoFecha();
     
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
     asignar("COMBO", "cbAreaSeguimiento", mcs, "DTOSalida.mc_ROWSET");  
     
     MareBusinessID idCU = new MareBusinessID("MENObtenerCodUsuarios");
     Vector vecCU = new Vector();
     
     vecCU.add(dtoMC);
     vecCU.add(idCU);
     DTOSalida dtoCU = (DTOSalida)conectar("ConectorUA",vecCU).objeto("dtoSalida"); 
     RecordSet cu = (RecordSet)dtoCU.getResultado();
     Vector colCU = cu.getColumnIdentifiers();
     DruidaConector cus = generarConector("DTOSalida.cu_ROWSET",cu, colCU);
     asignar("COMBO", "cbAgente", cus, "DTOSalida.cu_ROWSET");  
     
      
         
   
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "CAL");
     
     //comienzo de los parametrso de filtrado
     
    
     
     String fechaInicio        = conectorParametroLimpia("fechaInicio", "", true);
     datos.put(ConstantesREP.FECHAINICIO, fechaInicio);     
     
     String fechaFin        = conectorParametroLimpia("fechaFin", "", true);
     datos.put(ConstantesREP.FECHAFIN, fechaFin);     
     
     String areaSeguimiento        = conectorParametroLimpia("areaSeguimiento", "", true);
     if(!areaSeguimiento.equals("")){
        datos.put(ConstantesREP.AREASEGUIMIENTO, areaSeguimiento);     
     }
     
     String agente        = conectorParametroLimpia("agente", "", true);
     if(!agente.equals("")){
        datos.put(ConstantesREP.AGENTE, agente);     
     }
         
     String tipoCliente1        = conectorParametroLimpia("tipoCliente1", "", true);
     String tipoCliente1Desc        = conectorParametroLimpia("tipoCliente1Desc", "", true);
    
     datos.put(ConstantesREP.TIPOCLIENTE1, tipoCliente1);     
     datos.put(ConstantesREP.TIPOCLIENTE1DESC, tipoCliente1Desc);     
     
     String tipoCliente2        = conectorParametroLimpia("tipoCliente2", "", true);
     String tipoCliente2Desc        = conectorParametroLimpia("tipoCliente2Desc", "", true);
     
     if(!tipoCliente2.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE2, tipoCliente2);     
        datos.put(ConstantesREP.TIPOCLIENTE2DESC, tipoCliente2Desc);     
     }
     
     String tipoCliente3        = conectorParametroLimpia("tipoCliente3", "", true);
     String tipoCliente3Desc        = conectorParametroLimpia("tipoCliente3Desc", "", true);
     
     if(!tipoCliente3.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE3, tipoCliente3);     
        datos.put(ConstantesREP.TIPOCLIENTE3DESC, tipoCliente3Desc);     
     }
     
     String tipoCliente4        = conectorParametroLimpia("tipoCliente4", "", true);
     String tipoCliente4Desc        = conectorParametroLimpia("tipoCliente4Desc", "", true);
     
     if(!tipoCliente4.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE4, tipoCliente4);     
        datos.put(ConstantesREP.TIPOCLIENTE4DESC, tipoCliente4Desc);     
     }
     
     String tipoCliente5        = conectorParametroLimpia("tipoCliente5", "", true);
     String tipoCliente5Desc    = conectorParametroLimpia("tipoCliente5Desc", "", true);
     
     if(!tipoCliente5.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE5, tipoCliente5);     
        datos.put(ConstantesREP.TIPOCLIENTE5DESC, tipoCliente5Desc);     
     }
     
     String tipoCliente6        = conectorParametroLimpia("tipoCliente6", "", true);
     String tipoCliente6Desc        = conectorParametroLimpia("tipoCliente6Desc", "", true);
     
     if(!tipoCliente6.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE6, tipoCliente6);     
        datos.put(ConstantesREP.TIPOCLIENTE6DESC, tipoCliente6Desc);     
     }
     
     String reporte = conectorParametroLimpia("reporte", "", true);
     String idReporte = null;
     
     if(reporte.equals("1")){
        idReporte = "RD_REP-086_01";
        datos.put(ConstantesREP.TITULO, "Seguimiento de llamadas Recibidas por Agentes");     
     }else{
        idReporte = "RD_REP-086_02";
        datos.put(ConstantesREP.TITULO, "Seguimiento de llamadas Recibidas por Areas Responsables");     
     }
     
     traza("++++++Antes de enviar a reportes " + datos); 
         
     //ejecutarReporte(datos, "REPGenerarReporte", idReporte , null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", idReporte, "pdf");
          
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

  
  

    
  
 
 


}














