import es.indra.druida.DruidaConector;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.rep.logicanegocio.ConstantesREP;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;

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


public class PREProdAsignCodVenta extends LPSICCBase {
  
  public PREProdAsignCodVenta() {
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
        getConfiguracionMenu("PREProdAsignCodVenta");
      }
      
    }catch (Exception ex) {
                           
      //pagina("contenido_informe_comparativo_paises_generar");
      //getConfiguracionMenu("INCComparativoPaisesRetencion");
      
      ByteArrayOutputStream stack = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(stack);
      ex.printStackTrace(out);
      traza("EXCEPCION:" + stack.toString());
      lanzarPaginaError(ex);
      
      /*try{
          cargarPagina();
        }catch(Exception e){
          e.printStackTrace();
        }*/
        
    }
    
  }

  private void cargarPagina() throws Exception{
    
    pagina("contenido_informe_productos_asignacion_codigos_venta_catalogo_generar");
    
    ComposerViewElementList cv = crearParametrosEntrada();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    conector.ejecucion();
    DruidaConector resultados = conector.getConector();
    traza(" 4 " + resultados.getXML());
    
    
    asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");
    asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
    
    
    asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
    asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
    
    
    //cargo el combo de accesos
    DTOOID dto = new DTOOID();
    MareBusinessID id = new MareBusinessID("SEGObtenerAccesosSinFiltro");
    dto.setOidIdioma(UtilidadesSession.getIdioma(this));
    Vector vec = new Vector();
    vec.add(dto);
    vec.add(id);
    DTOSalida dtoSal = (DTOSalida)conectar("ConectorAccesos",vec).objeto("dtoSalida");
    RecordSet acceso = (RecordSet)dtoSal.getResultado();
    Vector colACCESO = acceso.getColumnIdentifiers();
    DruidaConector accesos = generarConector("DTOSalida.accesos_ROWSET",acceso, colACCESO);
    asignar("COMBO", "cbAcceso", accesos, "DTOSalida.accesos_ROWSET");
    
    //carga el combo de catalogo
    DTOBelcorp dtoCAT = new DTOBelcorp();
    MareBusinessID idCAT = new MareBusinessID("MAVCargarCatalagosBP");
    dtoCAT.setOidPais(UtilidadesSession.getPais(this));
    Vector vecCAT = new Vector();
    vecCAT.add(dtoCAT);
    vecCAT.add(idCAT);
    DTOSalida dtoSalCAT = (DTOSalida)conectar("ConectorCatalogos",vecCAT).objeto("dtoSalida"); 
    RecordSet catalogo = (RecordSet)dtoSalCAT.getResultado();
    Vector colCATALOGO = catalogo.getColumnIdentifiers();
    DruidaConector catalogos = generarConector("DTOSalida.catalogos_ROWSET",catalogo, colCATALOGO);
    asignar("COMBO", "cbCatalogo", catalogos, "DTOSalida.catalogos_ROWSET");
    
    this.getFormatosValidaciones();
  
  }
  
  private void generarReporte() throws Exception{
  
    HashMap datos = new HashMap();
    datos.put("MODULO", "PRE");
    
    String marca = conectorParametroLimpia("marca","",true);
    datos.put(ConstantesREP.MARCA,marca);
    
    String canal = conectorParametroLimpia("canal","",true);
    datos.put(ConstantesREP.CANAL, canal);
    
    String periodo = conectorParametroLimpia("periodo","",true);
    datos.put(ConstantesREP.PERIODO, periodo);
    
    String acceso = conectorParametroLimpia("acceso","",true);
    if (!acceso.equals("")){
      datos.put(ConstantesREP.ACCESO, acceso);
    }
    
    String catalogo = conectorParametroLimpia("catalogo","",true);
    if (!catalogo.equals("")){
      datos.put(ConstantesREP.CATALOGOS, catalogo);
    }
    
    String soloImprimibles = conectorParametroLimpia("soloImprimibles","",true);
    if(soloImprimibles.equals("S")){
      datos.put(ConstantesREP.SOLOIMPRIMIBLES, "1");
    }
    
    String codigoUnicoVenta = conectorParametroLimpia("codigoUnicoVenta","",true);
    datos.put(ConstantesREP.CODIGOVENTA, codigoUnicoVenta);
    
    
    String marcaDesc = conectorParametroLimpia("marcaDesc","",true);
    datos.put(ConstantesREP.MARCADESC,marcaDesc);
    
    String canalDesc = conectorParametroLimpia("canalDesc","",true);
    datos.put(ConstantesREP.CANALDESC,canalDesc);
    
    String periodoDesc = conectorParametroLimpia("periodoDesc","",true);
    datos.put(ConstantesREP.PERIODODESC,periodoDesc);
    
    String criteriosSeleccion = conectorParametroLimpia("criteriosSeleccion","",true);
    datos.put(ConstantesREP.CRITERIOSELECCIONDESC,criteriosSeleccion);
    
    
    datos.put(ConstantesREP.TITULO, "Reporte de Productos para asignación de Sufijos en Catálogo");
    traza("++++++Antes de enviar a reportes " + datos);
    
    String formato = conectorParametroLimpia("formato", "", true);
    
    if(formato.equals("xls")){
      datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
    }
    
    ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-300", formato);
    
  }
  
  private DruidaConector generarConector(String rowsetID, RecordSet datos,Vector columns) throws DOMException, Exception {
   
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
           e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
           e_campo2.setAttribute("TIPO", "OBJECTO");
           e_campo2.setAttribute("LONGITUD", "50");
           
           Text txt = docDestino.createTextNode(((datos.getValueAt(i, j) == null)? "" : datos.getValueAt(i, j).toString()));
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

  
  private DruidaConector generaConector(RecordSet rs, String ID_Rows, String campoCod,String campoNom, String campoF) throws Exception {
  
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
      
      Text txtCod = docDestino.createTextNode(((rs.getValueAt(i, campoCod) == null) ? "": rs.getValueAt(i, campoCod).toString()));
      e_campo1.appendChild(txtCod);
      e_row.appendChild(e_campo1);
      
      Element e_campo2 = docDestino.createElement("CAMPO");
      e_campo2.setAttribute("NOMBRE", campoNom);
      e_campo2.setAttribute("TIPO", "OBJECTO");
      e_campo2.setAttribute("LONGITUD", "50");
      
      Text txtDesc = docDestino.createTextNode(((rs.getValueAt(i, campoNom) == null) ? "": rs.getValueAt(i, campoNom).toString()));
      e_campo2.appendChild(txtDesc);
      e_row.appendChild(e_campo2);
      
      if (campoF != null) {
         Element e_campo3 = docDestino.createElement("CAMPO");
         e_campo3.setAttribute("NOMBRE", campoF);
         e_campo3.setAttribute("TIPO", "OBJECTO");
         e_campo3.setAttribute("LONGITUD", "50");
      
         Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoF) == null) ? "": rs.getValueAt(i, campoF).toString()));
         e_campo3.appendChild(txtF);
         e_row.appendChild(e_campo3);
      }
    }

    DruidaConector conect = new DruidaConector();
    conect.setXML(docDestino.getDocumentElement());
    
    return conect;
    
  }

}
