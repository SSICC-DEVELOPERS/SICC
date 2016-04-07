import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
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

public class CALLlamadasRangoFechas extends LPSICCBase {           
   public CALLlamadasRangoFechas() {	 
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
           getConfiguracionMenu("CALLlamadasRangoFechas");
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
     pagina("contenido_llamadas_registradas_rango_fechas_obtener");   
    
     ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
          
     asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
     asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
     
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
     
        
   
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "CAL");
     
     //comienzo de los parametrso de filtrado
              
     String marca        = conectorParametroLimpia("marca", "", true);
     datos.put(ConstantesREP.MARCA, marca);     
         
     String canal        = conectorParametroLimpia("canal", "", true);
     datos.put(ConstantesREP.CANAL, canal);     
     
     String fechaInicio        = conectorParametroLimpia("fechaInicio", "", true);
     datos.put(ConstantesREP.FECHAINICIO, fechaInicio);     
     
     String fechaFin        = conectorParametroLimpia("fechaFin", "", true);
     datos.put(ConstantesREP.FECHAFIN, fechaFin);     
          
     
     String sgv        = conectorParametroLimpia("sgv", "", true);
     if(!sgv.equals("")){
        datos.put(ConstantesREP.SUBGERENCIAVENTA, sgv);     
     }
     
     String region        = conectorParametroLimpia("region", "", true);
     if(!region.equals("")){
        datos.put(ConstantesREP.REGIONES, region);     
     }
     
     String zona        = conectorParametroLimpia("zona", "", true);
     if(!zona.equals("")){
        datos.put(ConstantesREP.ZONAS, zona);     
     }
     
     String tipoCliente1        = conectorParametroLimpia("tipoCliente1", "", true);
     datos.put(ConstantesREP.TIPOCLIENTE1, tipoCliente1);     
     
     String tipoCliente2        = conectorParametroLimpia("tipoCliente2", "", true);
     if(!tipoCliente2.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE2, tipoCliente2);     
     }
     
     String tipoCliente3        = conectorParametroLimpia("tipoCliente3", "", true);
     if(!tipoCliente3.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE3, tipoCliente3);     
     }
     
     String tipoCliente4        = conectorParametroLimpia("tipoCliente4", "", true);
     if(!tipoCliente4.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE4, tipoCliente4);     
     }
     
     String tipoCliente5        = conectorParametroLimpia("tipoCliente5", "", true);
     if(!tipoCliente5.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE5, tipoCliente5);     
     }
     
     String tipoCliente6        = conectorParametroLimpia("tipoCliente6", "", true);
     if(!tipoCliente6.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE6, tipoCliente6);     
     }
     
     String tipoCliente1Desc        = conectorParametroLimpia("tipoCliente1Desc", "", true);
     datos.put(ConstantesREP.TIPOCLIENTE1DESC, tipoCliente1Desc);     
     
     String tipoCliente2Desc        = conectorParametroLimpia("tipoCliente2Desc", "", true);
     if(!tipoCliente2Desc.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE2DESC, tipoCliente2Desc);     
     }
     
     String tipoCliente3Desc        = conectorParametroLimpia("tipoCliente3Desc", "", true);
     if(!tipoCliente3Desc.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE3DESC, tipoCliente3Desc);     
     }
     
     String tipoCliente4Desc        = conectorParametroLimpia("tipoCliente4Desc", "", true);
     if(!tipoCliente4Desc.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE4DESC, tipoCliente4Desc);     
     }
     
     String tipoCliente5Desc        = conectorParametroLimpia("tipoCliente5Desc", "", true);
     if(!tipoCliente5Desc.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE5DESC, tipoCliente5Desc);     
     }
     
     String tipoCliente6Desc        = conectorParametroLimpia("tipoCliente6Desc", "", true);
     if(!tipoCliente6Desc.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE6DESC, tipoCliente6Desc);     
     }
        
     
     String formatoSalida = conectorParametroLimpia("formatoSalida", "", true);
     String formato = null;
     
     if(formatoSalida.equals("EXCEL")){
        formato = "xls";
     }else{
        formato = "pdf";
     }
             
       
     datos.put(ConstantesREP.TITULO, "Cantidad de Llamadas Registradas");     
     traza("++++++Antes de enviar a reportes " + datos); 
     
     traza("el formaro es  " + formato);
      //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-084", formato);
      ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-084", formato);
          
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











