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
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class CCCMovAlmaFact extends LPSICCBase {           
   public CCCMovAlmaFact() {	 
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
           getConfiguracionMenu("CCCMovAlmaFact");
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
     pagina("contenido_informe_movimiento_almacen_generar");  
     
     ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
      
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());

     asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
     asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
      
     this.generarHiddenFormatoFecha();
     String fechaActual = null;
     java.util.Date fecha = new java.util.Date(System.currentTimeMillis());
     String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
     formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
            
     SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion);
     fechaActual = simpleDate.format(fecha);
     traza("la fecha actual " + fechaActual);
     asignarAtributo("VAR", "fechaActual", "valor", fechaActual); 
     
     //cargo el combo de clase
     DTOBelcorp dto = new DTOBelcorp();
     
     dto.setOidPais(UtilidadesSession.getPais(this));
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));

     MareBusinessID id2 = new MareBusinessID("MAEObtenerNegocioPorPais");
     Vector parametros2 = new Vector();
     parametros2.add(dto);
     parametros2.add(id2);
          
     DTOSalida dtoSal2 = (DTOSalida) conectar("ConectorNegocios",parametros2).objeto("dtoSalida"); 
     RecordSet negocio = (RecordSet)dtoSal2.getResultado();
     Vector colNeg = negocio.getColumnIdentifiers();
     DruidaConector negocios = generarConector("DTOSalida.negocios_ROWSET",negocio, colNeg);
     traza("negocio "+dtoSal2.getResultado());
     traza("negocio "+dtoSal2.getResultado().getColumnIdentifiers());
     asignar("COMBO", "cbClase", negocios, "DTOSalida.negocios_ROWSET");  
     
     cargarRegiones();

	 /* Comentado por HRCS (Fecha 06/01/2007)
     //comienzo a cargar las listas ocultas de zona, seccion, territorio
	   DTOSalida dtoZona = new DTOSalida();
	   DTOSalida dtoSeccion = new DTOSalida();	 
	   //DTOSalida dtoTerr = new DTOSalida();

     DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
     dtoUA.setOidIdioma(UtilidadesSession.getIdioma(this));
     dtoUA.setOidPais(UtilidadesSession.getPais(this));
     dtoUA.setOidMarca(null);
     dtoUA.setOidCanal(null);
      
	 traza("antes zona");
	 DruidaConector conZona = null;         		 
	 Vector paramEntradaZon = new Vector();
	 paramEntradaZon.add(dtoUA);
	 paramEntradaZon.add(new MareBusinessID("ZONObtenerZonasPorRegiones"));
	 conZona = conectar("ConectorObjeto", paramEntradaZon);
	 dtoZona = (DTOSalida) conZona.objeto("DTOSalida");
	 conZona = generaConector(dtoZona.getResultado(), "dtoSalida",
			  "OID_ZONA", "ZORG_OID_REGI", "DES_ZONA","MARCA","CANAL",null);
	 asignar("COMBO", "lstZona", conZona, "dtoSalida");
	 traza("termino zona");

	 traza("antes seccion");
	 DruidaConector conSecc = null;   
	 Vector paramEntradaSecc = new Vector();
	 paramEntradaSecc.add(dtoUA);
	 paramEntradaSecc.add(new MareBusinessID("ZONObtenerSeccionesPorZonas"));
	 conSecc = conectar("ConectorObjeto", paramEntradaSecc);
	 dtoSeccion = (DTOSalida) conSecc.objeto("DTOSalida");
	 conSecc = generaConector(dtoSeccion.getResultado(), "dtoSalida",
			  "OID_ZONA", "OID_SECC", "DES_SECCI",null, null, null);	
	 asignar("COMBO", "lstSecciones", conSecc, "dtoSalida");
	 traza("termino seccion");
	 */

	/* DruidaConector conTerr = null;   
	 Vector paramEntradaTerr = new Vector();
	 paramEntradaTerr.add(dtoUA);     
	 paramEntradaTerr.add(new MareBusinessID("ZONObtenerTerritoriosPorSecciones"));
	 conTerr = conectar("ConectorObjeto", paramEntradaTerr);
	 dtoTerr = (DTOSalida) conTerr.objeto("DTOSalida");
	 conTerr = generaConector(dtoTerr.getResultado(), "dtoSalida",
			  "OID_SECC", "TERR_OID_TERR", "COD_TERR",null, null, null);
	 asignar("COMBO", "lstTerritorios", conTerr, "dtoSalida"); */   
   
      
  }
  
  private void cargarRegiones() throws Exception {
    
         DTOSalida dtoS = new DTOSalida();
         DTOOID dto = new DTOOID();
         dto.setOidIdioma(UtilidadesSession.getIdioma(this));
         dto.setOidPais(UtilidadesSession.getPais(this));
         dto.setOid(null);
         
         DruidaConector conRegion = null;         

         Vector paramEntrada = new Vector();
         paramEntrada.add(dto);
         paramEntrada.add(new MareBusinessID("ZONObtenerRegionesPorPais"));

         conRegion = conectar("ConectorObjeto", paramEntrada);

         dtoS = (DTOSalida) conRegion.objeto("DTOSalida");


         conRegion = generaConector(dtoS.getResultado(), "dtoSalida",
                  "OID", "DESCRIPCION", "MARCA", "CANAL", null, null);
         asignar("COMBO", "lstRegion", conRegion, "dtoSalida");
         
    }  

	
  
  private DruidaConector generaConector(RecordSet rs, String ID_Rows, String campoCod,
         String campoNom, String campoF, String campoG, String campoH, String campoI) throws Exception {
         XMLDocument xmlDoc = new XMLDocument();
         Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");

         String formatoFechaPais = UtilidadesSession.getFormatoFecha(this);

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
             if (campoG != null) {
                  Element e_campo4 = docDestino.createElement("CAMPO");
                  e_campo4.setAttribute("NOMBRE", campoG);
                  e_campo4.setAttribute("TIPO", "OBJECTO");
                  e_campo4.setAttribute("LONGITUD", "50");

                  Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoG) == null) ? ""
                                                                                                      : rs.getValueAt(
                                i, campoG).toString()));
                  e_campo4.appendChild(txtF);
                  e_row.appendChild(e_campo4);
             }  
             if (campoH != null) {
                  Element e_campo5 = docDestino.createElement("CAMPO");
                  e_campo5.setAttribute("NOMBRE", campoG);
                  e_campo5.setAttribute("TIPO", "OBJECTO");
                  e_campo5.setAttribute("LONGITUD", "50");

                  Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoH) == null) ? ""
                                                                                                      : rs.getValueAt(
                                i, campoH).toString()));
                  e_campo5.appendChild(txtF);
                  e_row.appendChild(e_campo5);
             }        
             if (campoI != null) {
                  Element e_campo6 = docDestino.createElement("CAMPO");
                  e_campo6.setAttribute("NOMBRE", campoI);
                  e_campo6.setAttribute("TIPO", "OBJECTO");
                  e_campo6.setAttribute("LONGITUD", "50");

                  Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoI) == null) ? ""
                                                                                                      : rs.getValueAt(
                                i, campoI).toString()));
                  e_campo6.appendChild(txtF);
                  e_row.appendChild(e_campo6);
             }               
         }

         DruidaConector conect = new DruidaConector();
         conect.setXML(docDestino.getDocumentElement());

         return conect;
    }    

  
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "CCC");
     
     //comienzo de los parametrso de filtrado
     
     String marca        = conectorParametroLimpia("marca", "", true);
     datos.put(ConstantesREP.MARCAS, marca);
     
     String marcaDesc = conectorParametroLimpia("marcaDesc", "", true);
     datos.put(ConstantesREP.MARCASDESC, marcaDesc);
     
     String canal        = conectorParametroLimpia("canal", "", true);
     datos.put(ConstantesREP.CANALES, canal);
     
     String canalDesc = conectorParametroLimpia("canalDesc", "", true);
     datos.put(ConstantesREP.CANALESDESC, canalDesc);
     
     String fechaValorDesde        = conectorParametroLimpia("fechaValorDesde", "", true);
     datos.put(ConstantesREP.FECHADEVALORDESDE, fechaValorDesde);
     
     String fechaValorHasta        = conectorParametroLimpia("fechaValorHasta", "", true);
     datos.put(ConstantesREP.FECHADEVALORHASTA, fechaValorHasta);
         
     String clase        = conectorParametroLimpia("clase", "", true);
     String claseDesc        = conectorParametroLimpia("claseDesc", "", true);
     if(!clase.equals("")){
        datos.put(ConstantesREP.CLASES, clase);
		datos.put(ConstantesREP.CLASESOLICITUDES, claseDesc);
     }    
	
     
     String codProducto        = conectorParametroLimpia("codProducto", "", true);
	 String codProdCabecera        = conectorParametroLimpia("codProdCabecera", "", true);
     if(!codProducto.equals("")){
        datos.put(ConstantesREP.CODIGOPRODUCTO, codProdCabecera);
		datos.put(ConstantesREP.CODIGOPRODUCTOS, codProducto);
     }      

     
     String region = conectorParametroLimpia("region", "", true);
     String regionDesc = conectorParametroLimpia("regionDesc", "", true);
     if(!region.equals("")){
        datos.put(ConstantesREP.REGIONES, region);
        datos.put(ConstantesREP.REGIONESDESC, regionDesc);
     }
     
     String zona = conectorParametroLimpia("zona", "", true);
     String zonaDesc = conectorParametroLimpia("zonaDesc", "", true);
     if(!zona.equals("")){
        datos.put(ConstantesREP.ZONAS, zona);
        datos.put(ConstantesREP.ZONASDESC, zonaDesc);
     }  
     
     String seccion = conectorParametroLimpia("seccion", "", true);
     String seccionDesc = conectorParametroLimpia("seccionDesc", "", true);
     if(!seccion.equals("")){
        datos.put(ConstantesREP.SECCIONES, seccion);
        datos.put(ConstantesREP.SECCIONESDESC, seccionDesc);
     }  
     
     String territorioDesde        = conectorParametroLimpia("territorioDesde", "", true);
     if(!territorioDesde.equals("")){
        datos.put(ConstantesREP.TERRITORIODESDE, territorioDesde);
     }
     String territorioHasta        = conectorParametroLimpia("territorioHasta", "", true);
     if(!territorioHasta.equals("")){
        datos.put(ConstantesREP.TERRITORIOHASTA, territorioHasta);
     }
        
       
     String formatoSalida = conectorParametroLimpia("formatoSalida", "", true);
     String formato = null;
     
     if(formatoSalida.equals("xls")){
        datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
        formato = "xls";
     }else{
        formato = "pdf";
     }
     
     String criterio        = conectorParametroLimpia("criterio", "", true);
     String tipoReporte        = conectorParametroLimpia("tipoReporte", "", true);
     datos.put(ConstantesREP.TIPOREPORTE, tipoReporte);     

	 String criterioDesc        = conectorParametroLimpia("criterioDesc", "", true);
     datos.put(ConstantesREP.CRITERIOSELECCIONDESC, criterioDesc);
     
     String tipoReporteDesc        = conectorParametroLimpia("tipoReporteDesc", "", true);
     datos.put(ConstantesREP.TIPOREPORTEDESC, tipoReporteDesc);
     
     String reporte = null;
     if(criterio.equals("1")){
        reporte = "RD_REP-143";
     }else{
        if(criterio.equals("2")){
           reporte = "RD_REP-143_01";
        }else{
           reporte = "RD_REP-143_02";
        }
     }
       
     
     
     datos.put(ConstantesREP.TITULO, "Movimiento de Almacén por Facturación");     
     traza("++++++Antes de enviar a reportes " + datos); 
        
     
     traza("el formaro es  " + formato);
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

















