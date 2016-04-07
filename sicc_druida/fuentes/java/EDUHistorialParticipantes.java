import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
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

public class EDUHistorialParticipantes extends LPSICCBase {           
   public EDUHistorialParticipantes() {	 
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
           getConfiguracionMenu("EDUHistorialParticipantes");
        }
     
     } catch (Exception ex) {
     			
       // cargarPagina();
      //  getConfiguracionMenu("EDUHistorialParticipantes");
               
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
     pagina("contenido_informe_historial_participantes_generar");   
    
     DTOBelcorp dto = new DTOBelcorp();
     dto.setOidPais(UtilidadesSession.getPais(this));
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     Vector vec = new Vector();
     MareBusinessID idPais = new MareBusinessID("REPRecuperarPaises");
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     vec.add(dto);
     vec.add(idPais);
     DTOSalida dtoSalPais = (DTOSalida)conectar("ConectorPaises",vec).objeto("dtoSalida"); 
     RecordSet pais = (RecordSet)dtoSalPais.getResultado();
     Vector colPAIS = pais.getColumnIdentifiers();
     DruidaConector paises = generarConector("DTOSalida.paises_ROWSET",pais, colPAIS);
     asignar("COMBO", "cbPais", paises, "DTOSalida.paises_ROWSET");  
     
     ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
          
     asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
          
     this.generarHiddenFormatoFecha();
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
     cargarTipoSubtipo();    
     asignarAtributo("VAR", "hLongCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
   
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "EDU");
     
     //comienzo de los parametrso de filtrado
       
     String pais        = conectorParametroLimpia("paisSelec", "", true);
     if(!pais.equals("")){
        datos.put(ConstantesREP.PAIS, pais);     
     }
          
     String tipoCliente        = conectorParametroLimpia("tipoCliente", "", true);
     if(!tipoCliente.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTE, tipoCliente);     
     }
               
     String subtipoCliente        = conectorParametroLimpia("subtipoCliente", "", true);
     if(!subtipoCliente.equals("")){
        datos.put(ConstantesREP.SUBTIPOCLIENTE, subtipoCliente); 
     }
               
     String codigoCliente        = conectorParametroLimpia("codigoCliente", "", true);
     if(!codigoCliente.equals("")){
        datos.put(ConstantesREP.CODIGOCLIENTE, codigoCliente); 
     }
        
     String marca        = conectorParametroLimpia("marca", "", true);
     if(!marca.equals("")){
        datos.put(ConstantesREP.MARCA, marca); 
     }
        
       
       
     datos.put(ConstantesREP.TITULO, "Historial de Participantes");     
     traza("++++++Antes de enviar a reportes " + datos); 
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-015", null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-015", "pdf");
          
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
    
    private void cargarTipoSubtipo() throws Exception {
    
          DTOTipoSubtipo dto = (DTOTipoSubtipo) conectorParametroSesion("TIPOSUBTIPO");
          DruidaConector conTipoSubtipo = null;
          Long idioma = UtilidadesSession.getIdioma( this );

          if (dto == null) {
          
              DTOBelcorp dtoE = new DTOBelcorp();
              dtoE.setOidIdioma(idioma);

              Vector paramEntrada = new Vector();
              paramEntrada.add(dtoE);
              paramEntrada.add(new MareBusinessID("MAEObtenerTipoSubtipo"));

              conTipoSubtipo = conectar("ConectorTipoSubtipo", paramEntrada);

              dto = (DTOTipoSubtipo) conTipoSubtipo.objeto("DTOSalida");


//              MareDTO dtoSalida = (DTOTipoSubtipo) conTipoSubtipo.objeto("DTOSalida");
//              dto = (DTOTipoSubtipo) dtoSalida.getProperty("resultado");
             // conectorParametroSesion("TIPOSUBTIPO", dto);
          }

          //Tipo
          conTipoSubtipo = generaConector(dto.getTipos(), "dtoSalida.tipos_ROWSET","OID_TIPO_CLIE", "VAL_I18N", null); //DES_MAE_TIPO_CLIEN
          asignar("COMBO", "cbTipoCliente", conTipoSubtipo, "dtoSalida.tipos_ROWSET");
                    //asignarAtributo("VAR", "hTipo", "valor", this.tipoCliente);

          //Subtipo
          conTipoSubtipo = generaConector(dto.getSubtipos(), "dtoSalida.subtipos_ROWSET",
                    "OID_SUBT_CLIE", "TICL_OID_TIPO_CLIE", "VAL_I18N"); //"DES_MAE_TIPO_CLIEN", "DES_MAE_SUBTI_CLIEN"
          asignar("COMBO", "lstSubtipo", conTipoSubtipo, "dtoSalida.subtipos_ROWSET");
          
    }
    
    private DruidaConector generaConector(RecordSet rs, String ID_Rows, String campoCod,
          String campoNom, String campoF) throws Exception {
          XMLDocument xmlDoc = new XMLDocument();
          Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");

          Element e_rows = docDestino.createElement("ROWSET");
          e_rows.setAttribute("ID", ID_Rows);
          docDestino.getDocumentElement().appendChild(e_rows);

          for (int i = 0; i < rs.getRowCount(); i++) {
              Element e_row = docDestino.createElement("ROW");
              e_rows.appendChild(e_row);

              Element e_campo1 = docDestino.createElement("CAMPO");
              e_campo1.setAttribute("NOMBRE", campoCod);
              e_campo1.setAttribute("TIPO", "OBJECTO");
              e_campo1.setAttribute("LONGITUD", "50");

              Text txtCod = docDestino.createTextNode(((rs.getValueAt(i, campoCod) == null) ? ""
                                                                                                                    : rs.getValueAt(
                              i, campoCod).toString()));
              e_campo1.appendChild(txtCod);
              e_row.appendChild(e_campo1);

              Element e_campo2 = docDestino.createElement("CAMPO");
              e_campo2.setAttribute("NOMBRE", campoNom);
              e_campo2.setAttribute("TIPO", "OBJECTO");
              e_campo2.setAttribute("LONGITUD", "50");

              Text txtDesc = docDestino.createTextNode(((rs.getValueAt(i, campoNom) == null) ? ""
                                                                                                                      : rs.getValueAt(
                              i, campoNom).toString()));
              e_campo2.appendChild(txtDesc);
              e_row.appendChild(e_campo2);

              if (campoF != null) {
                    Element e_campo3 = docDestino.createElement("CAMPO");
                    e_campo3.setAttribute("NOMBRE", campoF);
                    e_campo3.setAttribute("TIPO", "OBJECTO");
                    e_campo3.setAttribute("LONGITUD", "50");

                    Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoF) == null) ? ""
                                                                                                                    : rs.getValueAt(
                                    i, campoF).toString()));
                    e_campo3.appendChild(txtF);
                    e_row.appendChild(e_campo3);
              }
          }

          DruidaConector conect = new DruidaConector();
          conect.setXML(docDestino.getDocumentElement());

          return conect;
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
        
                              
     lista.addViewElement(cbMarca);
     
        
     
     return lista;
  }
  
  
}








//01-02-2005 mdolce
