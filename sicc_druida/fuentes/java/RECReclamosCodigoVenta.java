import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.sicc.rep.dtos.DTOValidaCodigoVenta;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
//import es.indra.sicc.dtos.mae.DTOTipoSubtipo;

public class RECReclamosCodigoVenta extends LPSICCBase {           
   public RECReclamosCodigoVenta() {	 
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
        }else if(accion.equals("validaCodigoVenta")){
                  pagina("salidaGenerica");
                  validaCodigoVenta();	
              }else{
                 cargarPagina();
                 getConfiguracionMenu("RECReclamosCodigoVenta");
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
     pagina("contenido_informe_consulta_reclamo_codVenta_generar");
     
     
     asignarAtributo("VAR", "casoDeUso", "valor", "referencia");
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
    

     ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
           
     asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");              
     asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
     
     DTOBelcorp dtoMC = new DTOBelcorp();
     dtoMC.setOidIdioma(UtilidadesSession.getIdioma(this));
     dtoMC.setOidPais(UtilidadesSession.getPais(this));
          
 
////////////////////////////////////////////////////////////////////////////////////////
     MareBusinessID id2 = null;
     //cargo el combo de Unidades Negocio
     id2 = new MareBusinessID("SEGRecuperaAccesos");
     
     Vector parametros2 = new Vector();
     parametros2.add(dtoMC);
     parametros2.add(id2);
     
     DTOSalida dtoSal2 = (DTOSalida) conectar("ConectorUA",parametros2).objeto("dtoSalida"); 
          
     RecordSet unidad2 = (RecordSet)dtoSal2.getResultado();
     Vector colUN2 = unidad2.getColumnIdentifiers();
     DruidaConector unidades2 = generarConector("DTOSalida.unidades2_ROWSET",unidad2, colUN2);
     traza("unidades negocio "+dtoSal2.getResultado());
     traza("unidades negocio "+dtoSal2.getResultado().getColumnIdentifiers());
     asignar("COMBO", "cbPuntoIngreso", unidades2, "DTOSalida.unidades2_ROWSET");  
    
   
     MareBusinessID idCAT2 = new MareBusinessID("RECComboOperaciones");
     Vector vecCAT2 = new Vector();
     vecCAT2.add(dtoMC);
     vecCAT2.add(idCAT2);
     DTOSalida dtoSalCAT2 = (DTOSalida)conectar("ConectorUA",vecCAT2).objeto("dtoSalida"); 
     RecordSet catalogo2 = (RecordSet)dtoSalCAT2.getResultado();
     Vector colCATALOGO2 = catalogo2.getColumnIdentifiers();
     DruidaConector catalogos2 = generarConector("DTOSalida.operaciones_ROWSET",catalogo2, colCATALOGO2);
     asignar("COMBO", "cbOperaciones", catalogos2, "DTOSalida.operaciones_ROWSET");  
      
  }

  private void validaCodigoVenta() throws Exception{
  
	   String marca = conectorParametroLimpia("hidMarca", "", true);
	   String canal = conectorParametroLimpia("hidCanal", "", true);
	   String campana = conectorParametroLimpia("hidCampana", "", true);
	   String campanaDesc = conectorParametroLimpia("hidCampanaDesc", "", true);
	   String puntoIngreso = conectorParametroLimpia("hidPeriodoHastaDesc", "", true);
	   String codigoVenta = conectorParametroLimpia("hidCodigoVenta", "", true);
	   String operacion1 = conectorParametroLimpia("operacion1", "", true);
	   String operacion2 = conectorParametroLimpia("operacion2", "", true);
	   String operacion3 = conectorParametroLimpia("operacion3", "", true);
	   String operacion4 = conectorParametroLimpia("operacion4", "", true);
	   
	   DTOValidaCodigoVenta dto = new DTOValidaCodigoVenta();
	   dto.setPeriodoReferencia(new Long(campana));
	   dto.setCodigoVenta(codigoVenta);

	   String params = marca + "|" + canal + "|" + campana + "|" + campanaDesc + "|" +
								puntoIngreso + "|" + codigoVenta + "|" + operacion1 + "|" + operacion2 + "|" + operacion3 + "|" + operacion4;



	   MareBusinessID id = new MareBusinessID("REPValidaCodigoVenta");
	   Vector vec = new Vector();
		 
	   vec.add(dto);
	   vec.add(id); 

	   DTOBoolean dtoB = (DTOBoolean)conectar("ConectorPrimerPeriodo",vec).objeto("dtoSalida");
		
	   if(dtoB.getValor()){
		  asignarAtributo("VAR", "ejecutar", "valor", "cadenaParam('" + params + "')");    
	   }else{
		  asignarAtributo("VAR", "ejecutar", "valor", "alertaErrorCodigoVenta()");    	 
	   }
  
  
  
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
     
     String puntoIngreso        = conectorParametroLimpia("puntoIngreso", "", true);
     if(!puntoIngreso.equals("")){
        datos.put(ConstantesREP.PUNTOINGRESOS, puntoIngreso);
     } 
     
     String codigoVenta        = conectorParametroLimpia("codigoVenta", "", true);
     datos.put(ConstantesREP.CODIGOVENTAS, codigoVenta); 
     
     String campana        = conectorParametroLimpia("campana", "", true);
     datos.put(ConstantesREP.CAMPANIA, campana);
     
     String campanaDesc        = conectorParametroLimpia("campanaDesc", "", true);
     datos.put(ConstantesREP.CAMPANIADESC, campanaDesc);
       
     String operaciones1        = conectorParametroLimpia("operaciones1", "", true);
     if(!operaciones1.equals("")){
        datos.put(ConstantesREP.OPERACION1, operaciones1);  
     }
     
     String operaciones2        = conectorParametroLimpia("operaciones2", "", true);
     if(!operaciones2.equals("")){
        datos.put(ConstantesREP.OPERACION2, operaciones2);  
     }
     
     String operaciones3        = conectorParametroLimpia("operaciones3", "", true);
     if(!operaciones3.equals("")){
        datos.put(ConstantesREP.OPERACION3, operaciones3);  
     }
     
     String operaciones4        = conectorParametroLimpia("operaciones4", "", true);
     if(!operaciones4.equals("")){
        datos.put(ConstantesREP.OPERACION4, operaciones4);  
     }
     
         
 
     datos.put(ConstantesREP.TITULO, "Consulta de Reclamos por Codigo de venta");
     traza("++++++Antes de enviar a reportes " + datos); 
     String formato = conectorParametroLimpia("formato", "", true);   
     
     traza("el formaro es  " + formato);
//     ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-105", formato);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-105", formato);

    
          
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















