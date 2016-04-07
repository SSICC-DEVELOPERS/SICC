import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import java.text.SimpleDateFormat;

import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.dtos.mae.DTOClasificaciones;

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


public class INCComparativoPaisesRetencion extends LPSICCBase {
   
  public INCComparativoPaisesRetencion() {
    super();
  }
  
  public void inicio() throws Exception { 
     
  }
  
  private void cargarPagina() throws Exception{
    
    pagina("contenido_informe_comparativo_paises_generar");
    
    ComposerViewElementList cv = crearParametrosEntrada();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    conector.ejecucion();
    DruidaConector resultados = conector.getConector();
    traza(" 4 " + resultados.getXML());
    
    
    asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");
    asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
       
    
    asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
    asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
    
    
    // Carga Paises
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
    
    
    //cargo 1 combo y 3 listas------
    cargarTipoSubtipo();
    cargarClasificaciones();
    //-------------------------------

    this.getFormatosValidaciones();

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
        getConfiguracionMenu("INCComparativoPaisesRetencion");
      }
     
      } catch (Exception ex) {
     			
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

  //TODO dar funcionalidad a este metodo
  
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
  
  
   private void generarReporte() throws Exception{

    HashMap datos = new HashMap();
    datos.put("MODULO", "INC");

   
    String pais = conectorParametroLimpia("pais", "", true);
    datos.put(ConstantesREP.PAISES, pais);
    
    String marca = conectorParametroLimpia("marca","",true);
    datos.put(ConstantesREP.MARCA,marca);
    
    String marcaDesc = conectorParametroLimpia("marcaDesc","",true);
    datos.put(ConstantesREP.MARCADESC,marcaDesc);
    
    String canal = conectorParametroLimpia("canal","",true);
    datos.put(ConstantesREP.CANAL, canal);
    
    String tipoCliente = conectorParametroLimpia("tipoCliente","",true);
    if(!tipoCliente.equals("")){
      datos.put(ConstantesREP.TIPOCLIENTES,tipoCliente);
    }
    
    String tipoClienteDesc = conectorParametroLimpia("tipoClienteDesc","",true);
    if(!tipoClienteDesc.equals("")){
      datos.put(ConstantesREP.TIPOCLIENTEDESC,tipoClienteDesc);
    }

    String subtipoCliente = conectorParametroLimpia("subtipoCliente","",true);
    if(!subtipoCliente.equals("")){
      datos.put(ConstantesREP.SUBTIPOCLIENTES,subtipoCliente);
    }
  
    String subtipoClienteDesc = conectorParametroLimpia("subtipoClienteDesc","",true);
    if(!subtipoClienteDesc.equals("")){
      datos.put(ConstantesREP.SUBTIPOCLIENTEDESC,subtipoClienteDesc);
    }
  
    String tipoClasificacion = conectorParametroLimpia("tipoClasificacion","",true);
    if(!tipoClasificacion.equals("")){
      datos.put(ConstantesREP.TIPOCLASIFICACIONES,tipoClasificacion);
    }
  
    String tipoClasificacionDesc = conectorParametroLimpia("tipoClasificacionDesc","",true);
    if(!tipoClasificacionDesc.equals("")){
      datos.put(ConstantesREP.TIPOCLASIFICACIONDESC,tipoClasificacionDesc);
    }
  
    String clasificacion = conectorParametroLimpia("clasificacion","",true);
    if(!clasificacion.equals("")){
      datos.put(ConstantesREP.CLASIFICACIONES,clasificacion);
    }
    
    String clasificacionDesc = conectorParametroLimpia("clasificacionDesc","",true);
    if(!clasificacionDesc.equals("")){
      datos.put(ConstantesREP.CLASIFICACIONDESC,clasificacionDesc);
    }
    
    String unidadNegocio = conectorParametroLimpia("unidadNegocio","",true);
    if(!unidadNegocio.equals("")){
      datos.put(ConstantesREP.UNIDADNEGOCIOS,unidadNegocio);
    }
  
    String unidadNegocioDesc = conectorParametroLimpia("unidadNegocioDesc","",true);
    if(!unidadNegocioDesc.equals("")){
      datos.put(ConstantesREP.UNIDADNEGOCIODESC,unidadNegocioDesc);
    }
  
    String negocio = conectorParametroLimpia("negocio","",true);
    if(!negocio.equals("")){
      datos.put(ConstantesREP.NEGOCIOS,negocio);
    }
    
    String negocioDesc = conectorParametroLimpia("negocioDesc","",true);
    if(!negocioDesc.equals("")){
      datos.put(ConstantesREP.NEGOCIODESC,negocioDesc);
    }
    
    String anio = conectorParametroLimpia("anio","",true);
    datos.put(ConstantesREP.ANIO,anio);
    
    String pedidosAnioAnterior = conectorParametroLimpia("pedidosAnioAnterior","",true);
    datos.put(ConstantesREP.NUMEROPEDIDOANIOANTERIOR,pedidosAnioAnterior);
    
    datos.put(ConstantesREP.TITULO, "Comparativo de Paises de retencion de Pedidos");
    traza("++++++Antes de enviar a reportes " + datos);
    
    String formato = conectorParametroLimpia("formato", "", true);
    
    if(formato.equals("xls")){
      datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
    }
    
    ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-056", formato);
    
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


      //MareDTO dtoSalida = (DTOTipoSubtipo) conTipoSubtipo.objeto("DTOSalida");
      //dto = (DTOTipoSubtipo) dtoSalida.getProperty("resultado");
      //conectorParametroSesion("TIPOSUBTIPO", dto);
    
    }
    
    //Tipo
    conTipoSubtipo = generaConector(dto.getTipos(), "dtoSalida.tipos_ROWSET","OID_TIPO_CLIE", "VAL_I18N", null); //DES_MAE_TIPO_CLIEN
    asignar("COMBO", "cbTipoCliente", conTipoSubtipo, "dtoSalida.tipos_ROWSET");
    //asignarAtributo("VAR", "hTipo", "valor", this.tipoCliente);
         
    //Subtipo
         
    conTipoSubtipo = generaConector(dto.getSubtipos(), "dtoSalida.subtipos_ROWSET","OID_SUBT_CLIE", "TICL_OID_TIPO_CLIE", "VAL_I18N"); //"DES_MAE_TIPO_CLIEN", "DES_MAE_SUBTI_CLIEN"
    asignar("COMBO", "lstSubtipo", conTipoSubtipo, "dtoSalida.subtipos_ROWSET");
    
     String fechaActual = null;
        java.util.Date fecha = new java.util.Date(System.currentTimeMillis());
        String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
        formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
                 
        SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion);
        fechaActual = simpleDate.format(fecha);
        traza("la fecha actual " + fechaActual);
        String anio = fechaActual.substring(6);
             
        asignarAtributo("VAR", "anio", "valor", anio);
  
  }
  
  
  private void cargarClasificaciones() throws Exception {
    
    traza("ENTRO A CARGAR CLASIFICACIONES......");
         
    traza("paso 1");
    DruidaConector conClasificacion = null;
    traza("paso 2");
    
    Long idioma = UtilidadesSession.getIdioma( this );
    
    traza("paso 3");
    DTOBelcorp dtoE = new DTOBelcorp();
    traza("paso 4");
    dtoE.setOidIdioma(idioma);
    traza("paso 5");

    Vector paramEntrada = new Vector();
    traza("paso 6");
    paramEntrada.add(dtoE);
    traza("paso 7");
    paramEntrada.add(new MareBusinessID("MSGObtenerClasificacion"));
    traza("paso 8");
    conClasificacion = conectar("ConectorObtenerModulos", paramEntrada);
    traza("paso 9");

    //this.ratrearFuncion();
        
    DTOClasificaciones dtoSalida = (DTOClasificaciones) conClasificacion.objeto("dtoSalidaObjeto");
    traza("paso 10");
        
    //dto = (DTOClasificaciones) dtoSalida.getProperty("resultado");
    traza("paso 11");
    //conectorParametroSesion("CLASIFICACION", dto);
    traza("paso 12");
       
    traza("//Tipo Clasificacion");
    //Tipo Clasificacion
    conClasificacion = generaConector(dtoSalida.getTipoClasificacion(),"dtoSalida.tipoclasificacion_ROWSET", "OID_TIPO_CLAS","SBTI_OID_SUBT_CLIE", "VAL_I18N"); //DES_MAE_TIPO_CLASI_CLIEN
    asignar("COMBO", "lstTipoClasificacion", conClasificacion,"dtoSalida.tipoclasificacion_ROWSET");
    
    //asignar("COMBO", "cbTipoClasificacion", conClasificacion, "dtoSalida.tipoclasificacion_ROWSET");
    
    //asignarAtributo("VAR", "hTipoClasificacion", "valor", this.tipoClasificacion);

    traza("//Clasificacion");
    conClasificacion = generaConector(dtoSalida.getClasificacion(),"dtoSalida.clasificacion_ROWSET", "OID_CLAS", "TCCL_OID_TIPO_CLAS", "VAL_I18N"); //"TCCL_OID_TIPO_CLAS", "DES_MAE_CLASI"
    asignar("COMBO", "lstClasificacion", conClasificacion, "dtoSalida.clasificacion_ROWSET");
    //asignarAtributo("VAR", "hClasificacion", "valor", this.clasificacion);
  
  }
  
}

