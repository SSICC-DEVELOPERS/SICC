
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
import java.util.Vector;
import es.indra.sicc.util.xml.XMLDocument;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;

public class PREConfigMF extends LPSICCBase {           
   public PREConfigMF() {	 
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
           getConfiguracionMenu("PREConfigMF");
        }
     
     } catch (Exception ex) {
     			
       // cargarPagina();
       // getConfiguracionMenu("PREConfigMF");
               
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
      pagina("contenido_informe_configuracion_matriz_generar");   
    
      ComposerViewElementList cv = crearParametrosEntrada();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      traza(" 4 " + resultados.getXML());
          
      asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
      asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
      asignarAtributo("LABELC", "lbldtPais", "valor", UtilidadesSession.getDescripcionPais(this));
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
      
      //carga el combo de ciclos de vida
      DTOBelcorp dtoB = new DTOBelcorp();
      MareBusinessID idCV = new MareBusinessID("PREObtenerCiclosVida");
      dtoB.setOidIdioma(UtilidadesSession.getIdioma(this));
      Vector vecCV = new Vector();
      vecCV.add(dtoB);
      vecCV.add(idCV);
      DTOSalida dtoSalCV = (DTOSalida)conectar("ConectorCicloVida",vecCV).objeto("dtoSalida"); 
      RecordSet ciclo = (RecordSet)dtoSalCV.getResultado();
      Vector colCICLO = ciclo.getColumnIdentifiers();
      DruidaConector ciclos = generarConector("DTOSalida.ciclos_ROWSET",ciclo, colCICLO);
      asignar("COMBO", "cbCicloVida", ciclos, "DTOSalida.ciclos_ROWSET");  
      
      //carga el combo de tipo oferta
      DTOOID dtoTO = new DTOOID();
      MareBusinessID idTO = new MareBusinessID("PREObtenerTiposOfertaPorCanal");
      dtoTO.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoTO.setOid(UtilidadesSession.getCanalPorDefecto(this));
      Vector vecTO = new Vector();
      vecTO.add(dtoTO);
      vecTO.add(idTO);
      DTOSalida dtoSalTO = (DTOSalida)conectar("ConectorTipoOferta",vecTO).objeto("dtoSalida"); 
      RecordSet oferta = (RecordSet)dtoSalTO.getResultado();
      Vector colOFERTA = oferta.getColumnIdentifiers();
      DruidaConector ofertas = generarConector("DTOSalida.ofertas_ROWSET",oferta, colOFERTA);
      asignar("COMBO", "cbTipoOferta", ofertas, "DTOSalida.ofertas_ROWSET");   
         
      //carga el combo de tipo de estrategia
      DTOBelcorp dtoTE = new DTOBelcorp();
      MareBusinessID idTE = new MareBusinessID("PREObtenerTiposEstrategia");
      dtoTE.setOidIdioma(UtilidadesSession.getIdioma(this));
      Vector vecTE = new Vector();
      vecTE.add(dtoTE);
      vecTE.add(idTE);
      DTOSalida dtoSalTE = (DTOSalida)conectar("ConectorTipoEstrategia",vecTE).objeto("dtoSalida"); 
      RecordSet estrategia = (RecordSet)dtoSalTE.getResultado();
      Vector colESTRATEGIA = estrategia.getColumnIdentifiers();
      DruidaConector estrategias = generarConector("DTOSalida.estrategias_ROWSET",estrategia, colESTRATEGIA);
      asignar("COMBO", "cbTipoEstrategia", estrategias, "DTOSalida.estrategias_ROWSET");  
      
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
       
      
      //carga el combo de forma de pago
      DTOBelcorp dtoFP = new DTOBelcorp();
      MareBusinessID idFP = new MareBusinessID("BELObtenerFormasPagoCabecera");
      dtoFP.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoFP.setOidPais(UtilidadesSession.getPais(this));
      Vector vecFP = new Vector();
      vecFP.add(dtoFP);
      vecFP.add(idFP);
      DTOSalida dtoSalFP = (DTOSalida)conectar("ConectorFormasPago",vecFP).objeto("dtoSalida"); 
      RecordSet formaPago = (RecordSet)dtoSalFP.getResultado();
      Vector colFORMAPAGO = formaPago.getColumnIdentifiers();
      DruidaConector formasPago = generarConector("DTOSalida.formasPago_ROWSET",formaPago, colFORMAPAGO);
      asignar("COMBO", "cbFormaPago", formasPago, "DTOSalida.formasPago_ROWSET");  
      
        
   
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
         
  
  private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "PRE");
     traza("entro");
     
     //comienzo de los parametrso de filtrado
     String marca        = conectorParametroLimpia("marca", "", true);
     if(!marca.equals("")){
        datos.put(ConstantesREP.MARCA, marca);     
     }
     
     String canal        = conectorParametroLimpia("canal", "", true);
     if(!canal.equals("")){
        datos.put(ConstantesREP.CANAL, canal);     
     }
     
     String marcaDesc        = conectorParametroLimpia("marcaDesc", "", true);
     if(!marcaDesc.equals("")){
        datos.put(ConstantesREP.MARCADESC, marcaDesc);     
     }
     
     String canalDesc        = conectorParametroLimpia("canalDesc", "", true);
     if(!canalDesc.equals("")){
        datos.put(ConstantesREP.CANALDESC, canalDesc);     
     }
     
     String periodo        = conectorParametroLimpia("periodo", "", true);
     if(!periodo.equals("")){
        datos.put(ConstantesREP.PERIODO, periodo);     
     }
     
     String periodoDesc = conectorParametroLimpia("periodoDesc", "", true);
     if(!periodoDesc.equals("")){
        datos.put(ConstantesREP.PERIODODESC, periodoDesc);
     }
     
     String acceso        = conectorParametroLimpia("acceso", "", true);
     if(!acceso.equals("")){
        datos.put(ConstantesREP.ACCESOS, acceso);     
     }
     
     String cicloVida        = conectorParametroLimpia("cicloVida", "", true);
     if(!cicloVida.equals("")){
        datos.put(ConstantesREP.CICLOVIDA, cicloVida);     
     }
     
     String tipoOferta        = conectorParametroLimpia("tipoOferta", "", true);
     if(!tipoOferta.equals("")){
        datos.put(ConstantesREP.TIPOOFERTA, tipoOferta);     
     }
     
     String codigoProductoDesde        = conectorParametroLimpia("codigoProductoDesde", "", true);
     if(!codigoProductoDesde.equals("")){
        datos.put(ConstantesREP.CODIGOPRODUCTODESDE, codigoProductoDesde);     
     }
         
     String codigoProductoHasta       = conectorParametroLimpia("codigoProductoHasta", "", true);
     if(!codigoProductoHasta.equals("")){
        datos.put(ConstantesREP.CODIGOPRODUCTOHASTA, codigoProductoHasta);     
     }
     
     String codigoVentaDesde       = conectorParametroLimpia("codigoVentaDesde", "", true);
     if(!codigoVentaDesde.equals("")){
        datos.put(ConstantesREP.CODIGOVENTADESDE, codigoVentaDesde);     
     }
     
     String codigoVentaHasta       = conectorParametroLimpia("codigoVentaHasta", "", true);
     if(!codigoVentaHasta.equals("")){
        datos.put(ConstantesREP.CODIGOVENTAHASTA, codigoVentaHasta);     
     }
     
     String tipoEstrategia       = conectorParametroLimpia("tipoEstrategia", "", true);
     if(!tipoEstrategia.equals("")){
        datos.put(ConstantesREP.TIPOESTRATEGIA, tipoEstrategia);     
     }
     
     String operadorPrecioCatalogo       = conectorParametroLimpia("operadorPrecioCatalogo", "", true);
     if(!operadorPrecioCatalogo.equals("")){
        
        if(operadorPrecioCatalogo.equals("1")){
           operadorPrecioCatalogo = "'<'";
        }
        
        if(operadorPrecioCatalogo.equals("2")){
           operadorPrecioCatalogo = "'>'";
        }
        
        if(operadorPrecioCatalogo.equals("3")){
           operadorPrecioCatalogo = "'='";
        }
        
        if(operadorPrecioCatalogo.equals("4")){
           operadorPrecioCatalogo = "'<='";
        }
        
        if(operadorPrecioCatalogo.equals("5")){
           operadorPrecioCatalogo = "'>='";
        }
        
        
        datos.put(ConstantesREP.OPERADORPRECIOCATALOGO, operadorPrecioCatalogo);     
     }
     
     String precioCatalogo       = conectorParametroLimpia("precioCatalogo", "", true);
     if(!precioCatalogo.equals("")){
        datos.put(ConstantesREP.PRECIOCATALOGO, precioCatalogo);     
     }
     
     String operadorPrecioContable       = conectorParametroLimpia("operadorPrecioContable", "", true);
     if(!operadorPrecioContable.equals("")){
     
        if(operadorPrecioContable.equals("1")){
           operadorPrecioContable = "'<'";
        }
        
        if(operadorPrecioContable.equals("2")){
           operadorPrecioContable = "'>'";
        }
        
        if(operadorPrecioContable.equals("3")){
           operadorPrecioContable = "'='";
        }
        
        if(operadorPrecioContable.equals("4")){
           operadorPrecioContable = "'<='";
        }
        
        if(operadorPrecioContable.equals("5")){
           operadorPrecioContable = "'>='";
        }
        datos.put(ConstantesREP.OPERADORPRECIOCONTABLE, operadorPrecioContable);     
     }
     
     String precioContable       = conectorParametroLimpia("precioContable", "", true);
     if(!precioContable.equals("")){
        datos.put(ConstantesREP.PRECIOCONTABLE, precioContable);     
     }
     
     String catalogo       = conectorParametroLimpia("catalogo", "", true);
     if(!catalogo.equals("")){
        datos.put(ConstantesREP.CATALOGO, catalogo);     
     }
     
     String paginaDesde       = conectorParametroLimpia("paginaDesde", "", true);
     if(!paginaDesde.equals("")){
        datos.put(ConstantesREP.PAGINADESDE, paginaDesde);     
     }
     
     String paginaHasta       = conectorParametroLimpia("paginaHasta", "", true);
     if(!paginaHasta.equals("")){
        datos.put(ConstantesREP.PAGINAHASTA, paginaHasta);     
     }
     
     String formasPago       = conectorParametroLimpia("formasPago", "", true);
     if(!formasPago.equals("")){
        datos.put(ConstantesREP.FORMAPAGO, formasPago);     
     }
     
     String vista       = conectorParametroLimpia("vista", "", true);
     String reporte = null;
     if(vista.equals("1")){
        reporte = "RD_REP-042_01";
     }else{
        reporte = "RD_REP-042_02";
     }
          
     String critOrden1       = conectorParametroLimpia("critOrden1", "", true);
     if(!critOrden1.equals("")){
        datos.put(ConstantesREP.CRITERIOORDENACION1, critOrden1);     
     }
     
     String critOrden2     = conectorParametroLimpia("critOrden2", "", true);
     if(!critOrden2.equals("")){
        datos.put(ConstantesREP.CRITERIOORDENACION2, critOrden2);     
     }
     
     String critOrden3     = conectorParametroLimpia("critOrden3", "", true);
     if(!critOrden3.equals("")){
        datos.put(ConstantesREP.CRITERIOORDENACION3, critOrden3);     
     }
   
     String formatoSalida = conectorParametroLimpia("formatoSalida", "", true);
     String formato = null;
     
     if(formatoSalida.equals("xls")){
  		datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
        formato = "xls";
     }else{
        formato = "pdf";
     }
     
     datos.put(ConstantesREP.TITULO, "Configuracion de Matriz de Facturacion " + periodoDesc);
     
     traza("los datos son " + datos);
     traza("++++++Antes de enviar a reportes"); 
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
  
 


}
