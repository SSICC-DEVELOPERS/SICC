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

public class COBComisionesPagar extends LPSICCBase {           
   public COBComisionesPagar() {	 
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
           getConfiguracionMenu("COBComisionesPagar");
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
     pagina("contenido_informe_comisiones_pagar_generar");   
    
     DTOBelcorp dtoMC = new DTOBelcorp();
     dtoMC.setOidIdioma(UtilidadesSession.getIdioma(this));
     dtoMC.setOidPais(UtilidadesSession.getPais(this));
          
     MareBusinessID idMC = new MareBusinessID("COBObtenerUsuariosCobCombo");
     Vector vecMC = new Vector();
          
     vecMC.add(dtoMC);
     vecMC.add(idMC);
     DTOSalida dtoMCS = (DTOSalida)conectar("ConectorUA",vecMC).objeto("dtoSalida"); 
     RecordSet mc = (RecordSet)dtoMCS.getResultado();
     Vector colMC = mc.getColumnIdentifiers();
     DruidaConector mcs = generarConector("DTOSalida.mc_ROWSET",mc, colMC);
     
     asignar("COMBO", "cbUsuario", mcs, "DTOSalida.mc_ROWSET");  
     
     //cargo el combo de grupo de usuarios
     MareBusinessID id = new MareBusinessID("COBObtenerGruposUsuarios");
     Vector vec = new Vector();
          
     vec.add(dtoMC);
     vec.add(id);
     DTOSalida dtoSal = (DTOSalida)conectar("ConectorUA",vec).objeto("dtoSalida"); 
     RecordSet gu = (RecordSet)dtoSal.getResultado();
     Vector colGU = gu.getColumnIdentifiers();
     DruidaConector gus = generarConector("DTOSalida.gu_ROWSET",gu, colGU);
     
     asignar("COMBO", "cbGrupoUsuarios", gus, "DTOSalida.gu_ROWSET");  
  
      
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
  
      
  }
  
 
   

          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "COB");
     
     //comienzo de los parametrso de filtrado
        
     String usuario        = conectorParametroLimpia("usuario", "", true);
     if(!usuario.equals("")){
        datos.put(ConstantesREP.USUARIOCOBRANZA, usuario);
     } 
     
     String grupoUsuario        = conectorParametroLimpia("grupoUsuario", "", true);
     if(!grupoUsuario.equals("")){
        datos.put(ConstantesREP.GRUPOUSUARIOS, grupoUsuario);
     } 
     
     String etapa        = conectorParametroLimpia("etapa", "", true);
     if(!etapa.equals("")){
        datos.put(ConstantesREP.ETAPACOBRANZA, etapa);
     } 
     
     
     
     String marca        = conectorParametroLimpia("marca", "", true);
     if(!marca.equals("")){
        datos.put(ConstantesREP.MARCA, marca);
     } 
     
     String canal        = conectorParametroLimpia("canal", "", true);
     if(!canal.equals("")){
        datos.put(ConstantesREP.CANAL, canal);
     } 
     
     String periodo        = conectorParametroLimpia("periodo", "", true);
     if(!periodo.equals("")){
        datos.put(ConstantesREP.PERIODO, periodo);
     } 
     
     String fechaAsignacion        = conectorParametroLimpia("fechaAsignacion", "", true);
     if(!fechaAsignacion.equals("")){
        datos.put(ConstantesREP.FECHAASIGNACION, fechaAsignacion);
     } 
         
     String formatoSalida = conectorParametroLimpia("formatoSalida", "", true);
     String formato = null;
     
     if(formatoSalida.equals("xls")){
        datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
        formato = "xls";
     }else{
        formato = "pdf";
     }
       
     datos.put(ConstantesREP.TITULO, "Informe Comisiones a Pagar");     
     traza("++++++Antes de enviar a reportes " + datos); 
       
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-127", formato);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-127", formato);
          
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
















