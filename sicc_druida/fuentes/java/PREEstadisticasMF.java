//01-02-2005 mdolce

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


public class PREEstadisticasMF extends LPSICCBase {
  
  public PREEstadisticasMF() {
  
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
        getConfiguracionMenu("PREEstadisticasMF");
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
    
    pagina("contenido_reporte_estadistica_matriz_generar");
    
    ComposerViewElementList cv = crearParametrosEntrada();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    conector.ejecucion();
    DruidaConector resultados = conector.getConector();
    traza(" 4 " + resultados.getXML());
    
    asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");
    asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
    
    asignarAtributo("LABELC", "lbldtPais", "valor", UtilidadesSession.getDescripcionPais(this));
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
    
    
    //carga el combo tipos de solicitud
    
    DTOBelcorp dtoOTS = new DTOBelcorp();
    
    MareBusinessID idTS = new MareBusinessID("PEDobtieneTiposSolicitud");
    
    dtoOTS.setOidPais(UtilidadesSession.getPais(this));
    dtoOTS.setOidIdioma(UtilidadesSession.getIdioma(this));
    
    Vector vecTS = new Vector();
    
    vecTS.add(dtoOTS);
    vecTS.add(idTS);
    
    DTOSalida dtoTS = (DTOSalida)conectar("ConectorUA",vecTS).objeto("dtoSalida"); 
    RecordSet ts = (RecordSet)dtoTS.getResultado();
    Vector colTS = ts.getColumnIdentifiers();
    DruidaConector tss = generarConector("DTOSalida.ts_ROWSET",ts, colTS);
    asignar("COMBO", "cbTipoSolicitud", tss, "DTOSalida.ts_ROWSET");
    
    
    //carga el combo tipos de linea
    
    DTOBelcorp dtoOTL = new DTOBelcorp();
    
    MareBusinessID idTL = new MareBusinessID("PEDconsultaTiposPosicion");
    
    dtoOTL.setOidPais(UtilidadesSession.getPais(this));
    dtoOTL.setOidIdioma(UtilidadesSession.getIdioma(this));
    
    Vector vecTL = new Vector();
    
    vecTL.add(dtoOTL);
    vecTL.add(idTL);
    
    DTOSalida dtoTL = (DTOSalida)conectar("ConectorUA",vecTL).objeto("dtoSalida");
    RecordSet tl = (RecordSet)dtoTL.getResultado();
    Vector colTL = tl.getColumnIdentifiers();
    DruidaConector tls = generarConector("DTOSalida.tl_ROWSET",tl, colTL);
    asignar("COMBO", "cbTipoLinea", tls, "DTOSalida.tl_ROWSET");
    
    
    
    this.getFormatosValidaciones();
  
  }
  
  private void generarReporte() throws Exception{
  
    HashMap datos = new HashMap();
    datos.put("MODULO", "PRE");
    
    String marca = conectorParametroLimpia("marca","",true);
    datos.put(ConstantesREP.MARCA,marca);
    
    String marcaDesc = conectorParametroLimpia("marcaDesc","",true);
    datos.put(ConstantesREP.MARCADESC,marcaDesc);
    
    String canal = conectorParametroLimpia("canal","",true);
    datos.put(ConstantesREP.CANAL, canal);
    
    String canalDesc = conectorParametroLimpia("canalDesc","",true);
    datos.put(ConstantesREP.CANALDESC, canalDesc);
    
    String periodo = conectorParametroLimpia("periodo","",true);
    datos.put(ConstantesREP.PERIODO, periodo);
    
    String periodoDesc = conectorParametroLimpia("periodoDesc","",true);
    datos.put(ConstantesREP.PERIODODESC, periodoDesc);
    
    String acceso = conectorParametroLimpia("acceso","",true);
    datos.put(ConstantesREP.ACCESO, acceso);
    
    String accesoDesc = conectorParametroLimpia("accesoDesc","",true);
    datos.put(ConstantesREP.ACCESODESC, accesoDesc);
    
    String productoDesde = conectorParametroLimpia("productoDesde","",true);
    if (!productoDesde.equals("")){
      datos.put(ConstantesREP.CODIGOPRODUCTODESDE, productoDesde);
    }
    
    String productoHasta = conectorParametroLimpia("productoHasta","",true);
    if (!productoHasta.equals("")){
      datos.put(ConstantesREP.CODIGOPRODUCTOHASTA, productoHasta);
    }
    
    String ventaDesde = conectorParametroLimpia("ventaDesde","",true);
    if (!ventaDesde.equals("")){
      datos.put(ConstantesREP.CODIGOVENTADESDE, ventaDesde);
    }
    
    String ventaHasta = conectorParametroLimpia("ventaHasta","",true);
    if (!ventaHasta.equals("")){
      datos.put(ConstantesREP.CODIGOVENTAHASTA, ventaHasta);
    }
    
    String descripcion = conectorParametroLimpia("descripcion","",true);
    if (!descripcion.equals("")){
      datos.put(ConstantesREP.DESCRIPCION, descripcion);
    }
    
    String catalogo = conectorParametroLimpia("catalogo","",true);
    if (!catalogo.equals("")){
      datos.put(ConstantesREP.CATALOGO, catalogo);
    }
    
    String paginaDesde = conectorParametroLimpia("paginaDesde","",true);
    if (!paginaDesde.equals("")){
      datos.put(ConstantesREP.PAGINADESDE, paginaDesde);
    }
    
    String paginaHasta = conectorParametroLimpia("paginaHasta","",true);
    if (!paginaHasta.equals("")){
      datos.put(ConstantesREP.PAGINAHASTA, paginaHasta);
    }
    
    String operadorPrecioCatalogo = conectorParametroLimpia("operadorPrecioCatalogo","",true);
    if (!operadorPrecioCatalogo.equals("")){
      datos.put(ConstantesREP.OPERADORPRECIOCATALOGO, operadorPrecioCatalogo);
    }
    
    String precioCatalogo = conectorParametroLimpia("precioCatalogo","",true);
    if (!precioCatalogo.equals("")){
      datos.put(ConstantesREP.PRECIOCATALOGO, precioCatalogo);
    }
    
    String tipoSolicitud = conectorParametroLimpia("tipoSolicitud","",true);
    if (!tipoSolicitud.equals("")){
      datos.put(ConstantesREP.TIPOSOLICITUD, tipoSolicitud);
    }
    
    String tipoLinea = conectorParametroLimpia("tipoLinea","",true);
    if (!tipoLinea.equals("")){
      datos.put(ConstantesREP.TIPOLINEA, tipoLinea);
    }
    
    String operadorUnidadesTotales = conectorParametroLimpia("operadorUnidadesTotales","",true);
    if (!operadorUnidadesTotales.equals("")){
      datos.put(ConstantesREP.OPERADORUNIDADESTOTALES, operadorUnidadesTotales);
    }
    
    String unidadesTotales = conectorParametroLimpia("unidadesTotales","",true);
    if (!unidadesTotales.equals("")){
      datos.put(ConstantesREP.UNIDADESTOTALES, unidadesTotales);
    }
    
    String operadorUnidadesFaltantes = conectorParametroLimpia("operadorUnidadesFaltantes","",true);
    if (!operadorUnidadesFaltantes.equals("")){
      datos.put(ConstantesREP.OPERADORUNIDADESFALTANTES, operadorUnidadesFaltantes);
    }
    
    String unidadesFaltantes = conectorParametroLimpia("unidadesFaltantes","",true);
    if (!unidadesFaltantes.equals("")){
      datos.put(ConstantesREP.UNIDADESFALTANTES, unidadesFaltantes);
    }
    
    String vista = conectorParametroLimpia("vista","",true);
    datos.put(ConstantesREP.VISTA, vista);
    
    String criterioOrdenacion1 = conectorParametroLimpia("criterioOrdenacion1","",true);
    if (!criterioOrdenacion1.equals("")){
      datos.put(ConstantesREP.CRITERIOORDENACION1, criterioOrdenacion1);
    }
    
    String criterioOrdenacion2 = conectorParametroLimpia("criterioOrdenacion2","",true);
    if (!criterioOrdenacion2.equals("")){
      datos.put(ConstantesREP.CRITERIOORDENACION2, criterioOrdenacion2);
    }
    
    String criterioOrdenacion3 = conectorParametroLimpia("criterioOrdenacion3","",true);
    if (!criterioOrdenacion3.equals("")){
      datos.put(ConstantesREP.CRITERIOORDENACION3, criterioOrdenacion3);
    }
    
    
    String criteriosSeleccionDesc = conectorParametroLimpia("criteriosSeleccionDesc", "", true);
    datos.put(ConstantesREP.CRITERIOSELECCIONDESC,criteriosSeleccionDesc);
    
    
    datos.put(ConstantesREP.TITULO, "Resultados de Estadisticos de Matriz de Facturación " + periodoDesc);
    traza("++++++Antes de enviar a reportes " + datos);
    
    String formato = conectorParametroLimpia("formato", "", true);
    
    if(formato.equals("xls")){
      datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
    }
    
    String reporte = conectorParametroLimpia("reporte", "", true);
    
    ejecutarReporte2(datos, "REPGenerarReporteBatch", reporte, formato);
    
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

