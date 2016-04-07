import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
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


public class INCProgramaRedExito extends LPSICCBase {
   
  public INCProgramaRedExito() {
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
           getConfiguracionMenu("INCProgramaRedExito");
        }
     
     } catch (Exception ex) {
     			
//        pagina("contenido_informe_pedidos_escala_generar");
   //     getConfiguracionMenu("INCRangoCuotas");
               
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
 
  
  //TODO dar funcionalidad a este metodo
  
  private void cargarPagina() throws Exception{
     pagina("contenido_informe_red_exito_generar");   
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
     asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
     
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
     
     //cargo la lista oculta de Regiones 
    /* DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
     dtoUA.setOidPais(UtilidadesSession.getPais(this));
     dtoUA.setOidIdioma(UtilidadesSession.getIdioma(this));
 
     traza("antesde la lista oculta de Regiones");
     MareBusinessID idRegiones = new MareBusinessID("ZONObtenerRegionesPorSGV");
     Vector vecReg = new Vector();
     vecReg.add(dtoUA);
     vecReg.add(idRegiones);
     DTOSalida dtoRegiones = (DTOSalida) conectar("ConectorUA",vecReg).objeto("dtoSalida"); 
     RecordSet region = (RecordSet)dtoRegiones.getResultado();
     Vector colRegion = region.getColumnIdentifiers();
     DruidaConector regiones = generarConector("DTOSalida.regiones_ROWSET",region, colRegion);
     traza("regiones "+dtoRegiones.getResultado());
     traza("regiones "+dtoRegiones.getResultado().getColumnIdentifiers());
     this.crearListaLP(colRegion, region.getColumnCount(), "CapaReg","ListaRegiones", "14", "200");
     asignar("LISTA", "ListaRegiones", regiones, "DTOSalida.regiones_ROWSET");  
     
     //cargo la lista oculta de Zonas 
     traza("antesde la lista oculta de Zonas");
     MareBusinessID idZonas = new MareBusinessID("ZONObtenerZonasPorRegiones");
     Vector vecZ = new Vector();
     vecZ.add(dtoUA);
     vecZ.add(idZonas);
     DTOSalida dtoZonas = (DTOSalida) conectar("ConectorUA",vecZ).objeto("dtoSalida"); 
     RecordSet zona = (RecordSet)dtoZonas.getResultado();
     Vector colZona = zona.getColumnIdentifiers();
     DruidaConector zonas = generarConector("DTOSalida.zonas_ROWSET",zona, colZona);
     traza("zonas "+dtoZonas.getResultado());
     traza("zonas "+dtoZonas.getResultado().getColumnIdentifiers());
     this.crearListaLP(colZona, zona.getColumnCount(), "CapaZon","ListaZonas", "14", "200");
     asignar("LISTA", "ListaZonas", zonas, "DTOSalida.zonas_ROWSET"); */ 
     
    /*MareBusinessID id = null;
     //cargo el combo de Unidades Negocio
     id = new MareBusinessID("MAEObtenerUnidadesNegocioPorPais");
     
     Vector parametros = new Vector();
     parametros.add(dto);
     parametros.add(id);
     
     DTOSalida dtoSal = (DTOSalida) conectar("ConectorUnidadesNegocio",parametros).objeto("dtoSalida"); 
          
     RecordSet unidad = (RecordSet)dtoSal.getResultado();
     Vector colUN = unidad.getColumnIdentifiers();
     DruidaConector unidades = generarConector("DTOSalida.unidades_ROWSET",unidad, colUN);
     traza("unidades negocio "+dtoSal.getResultado());
     traza("unidades negocio "+dtoSal.getResultado().getColumnIdentifiers());
     asignar("COMBO", "cbUnidadNegocio", unidades, "DTOSalida.unidades_ROWSET");  
     
     //cargo el combo de Negocios
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
     asignar("COMBO", "cbNegocio", negocios, "DTOSalida.negocios_ROWSET");  */
     
     MareBusinessID id3 = new MareBusinessID("SEGObtenerMonedas");
     Vector parametros3 = new Vector();
     parametros3.add(dto);
     parametros3.add(id3);
     
     DTOSalida dtoSal3 = (DTOSalida) conectar("ConectorNegocios",parametros3).objeto("dtoSalida"); 
     RecordSet moneda = (RecordSet)dtoSal3.getResultado();
     Vector colMoneda = moneda.getColumnIdentifiers();
     DruidaConector monedas = generarConector("DTOSalida.moneda_ROWSET",moneda, colMoneda);
     traza("negocio "+dtoSal3.getResultado());
     traza("negocio "+dtoSal3.getResultado().getColumnIdentifiers());
     asignar("COMBO", "cbMoneda", monedas, "DTOSalida.moneda_ROWSET");  
       
     
  
  }
  
  private void crearListaLP(Vector nomColumns, int cantColumns,
           String nomCapa, String nomLista, String XCapa, String YCapa)
           throws Exception {
           traza("dentro de crearListaLP()  " + nomColumns + " " + cantColumns);
 
           Document document = getXML();
 
           Element eCapa = document.createElement("CAPA");
           eCapa.setAttribute("nombre", nomCapa);
           eCapa.setAttribute("alto", "162");
           eCapa.setAttribute("ancho", "580");
           eCapa.setAttribute("colorf", "");
           eCapa.setAttribute("borde", "1");
           eCapa.setAttribute("imagenf", "");
           eCapa.setAttribute("repeat", "");
           eCapa.setAttribute("padding", "");
           eCapa.setAttribute("visibilidad", "hidden");
           eCapa.setAttribute("contravsb", "");
           eCapa.setAttribute("zindex", "");
           eCapa.setAttribute("x", XCapa);
           eCapa.setAttribute("y", YCapa);
 
           Element eLista = document.createElement("LISTA");
 
           eLista.setAttribute("seleccion", "boton");
           eLista.setAttribute("nombre", nomLista);
           eLista.setAttribute("ancho", "580");
           eLista.setAttribute("alto", "150");
           eLista.setAttribute("multisel", "0");
           eLista.setAttribute("incy", "1");
           eLista.setAttribute("incx", "10");
           eLista.setAttribute("colorf", "#EFEFEF");
           eLista.setAttribute("imagenoff", "close_no.gif");
           eLista.setAttribute("imagenon", "close_up.gif");
           eLista.setAttribute("accion", "");
           eLista.setAttribute("sep", "|");
           eLista.setAttribute("pixelsborde", "3");
           eLista.setAttribute("colorborde", "#CCCCCC");
 
           Element eCABECERA = document.createElement("CABECERA");
           eCABECERA.setAttribute("nombre", "cabecera");
           eCABECERA.setAttribute("height", "20");
 
           Integer anchoCab;
 
           if (cantColumns < 4) {
                anchoCab = new Integer(580 / cantColumns);
           } else {
                anchoCab = new Integer(150);
           }
 
           Element eCOL_1 = document.createElement("COL");
           eCOL_1.setAttribute("id", "fondoCabecera");
           eCOL_1.setAttribute("ancho", anchoCab.toString());
 
           Element eCOL_2 = document.createElement("COL");
           eCOL_2.setAttribute("id", "fondoCabecera");
           eCOL_2.setAttribute("ancho", anchoCab.toString());
 
           Element eCOL_3 = document.createElement("COL");
           eCOL_3.setAttribute("id", "fondoCabecera");
           eCOL_3.setAttribute("ancho", anchoCab.toString());
 
           Element eCOL_4 = document.createElement("COL");
           eCOL_4.setAttribute("id", "fondoCabecera");
           eCOL_4.setAttribute("ancho", anchoCab.toString());
 
           Element eCOL_5 = document.createElement("COL");
           eCOL_5.setAttribute("id", "fondoCabecera");
           eCOL_5.setAttribute("ancho", anchoCab.toString());
 
           Element eCOL_6 = document.createElement("COL");
           eCOL_6.setAttribute("id", "fondoCabecera");
           eCOL_6.setAttribute("ancho", anchoCab.toString());
 
           Vector columnas = new Vector();
 
           for (int i = 0; i < cantColumns; i++) {
                Element eLABEL_2 = document.createElement("LABELC");
                eLABEL_2.setAttribute("id", "fondoCabecera");
                eLABEL_2.setAttribute("nombre", "lbDivisionesPoliticas" + i);
                eLABEL_2.setAttribute("ancho", anchoCab.toString());
                eLABEL_2.setAttribute("alto", "20");
                eLABEL_2.setAttribute("filas", "1");
                eLABEL_2.setAttribute("id", "datosCamposCabecera");
 
                if (i != 0) {
                      eLABEL_2.setAttribute("valor", (String) nomColumns.get(i));
                } else {
                      eLABEL_2.setAttribute("cod", "199");
                }
 
                eLABEL_2.setAttribute("enviaroculto", "N");
                columnas.add(eLABEL_2); //Agrego label a la columna
           }
 
           traza("despues de poner en variables los titulos " + columnas + " " +
                cantColumns);
 
           if (cantColumns >= 1) {
                eCOL_1.appendChild((Element) columnas.get(0));
                eCABECERA.appendChild(eCOL_1);
                traza("1");
           }
 
           if (cantColumns >= 2) {
                eCOL_2.appendChild((Element) columnas.get(1));
                eCABECERA.appendChild(eCOL_2);
                traza("1");
           }
 
           if (cantColumns >= 3) {
                eCOL_3.appendChild((Element) columnas.get(2));
                eCABECERA.appendChild(eCOL_3);
                traza("1");
           }
 
           if (cantColumns >= 4) {
                eCOL_4.appendChild((Element) columnas.get(3));
                eCABECERA.appendChild(eCOL_4);
                traza("1");
           }
 
           if (cantColumns >= 5) {
                eCOL_5.appendChild((Element) columnas.get(4));
                eCABECERA.appendChild(eCOL_5);
                traza("1");
           }
 
           if (cantColumns >= 6) {
                eCOL_6.appendChild((Element) columnas.get(5));
                eCABECERA.appendChild(eCOL_6);
                traza("1");
           }
 
           Element ePRESENTACION = document.createElement("PRESENTACION");
           Integer ancho = new Integer(cantColumns * anchoCab.intValue());
           ePRESENTACION.setAttribute("ancho", ancho.toString());
           ePRESENTACION.setAttribute("filas", "1");
 
           int swX1 = 0;
           StringBuffer cadena = new StringBuffer("['datosCamposCenterImpar'");
           traza("break brain");
 
           for (int i = 1; i < cantColumns; i++) {
                if (swX1 == 0) {
                      cadena.append(", 'datosCamposCenterPar'");
                      swX1 = 1;
                } else {
                      cadena.append(", 'datosCamposCenterImpar'");
                      swX1 = 0;
                }
           }
 
           for (int i = 0; i < cantColumns; i++) {
                Element eCOLP_2 = document.createElement("COL");
                eCOLP_2.setAttribute("ancho", anchoCab.toString());
                eCOLP_2.setAttribute("caracteres", "150");
                ePRESENTACION.appendChild(eCOLP_2); //Agrego columna a la presentacion
           }
 
           cadena.append("]");
 
           traza("### " + cadena.toString());
           ePRESENTACION.setAttribute("bloquesid", cadena.toString());
 
           Element eROWSET = document.createElement("ROWSET");
 
           eLista.appendChild(eCABECERA); //Agrego la cabecera de la lista
           eLista.appendChild(ePRESENTACION); //Agrego la presentacion de la lista
           eLista.appendChild(eROWSET); //Agrego el rowset de la lista
 
           eCapa.appendChild(eLista);
 
           getXML().getElementsByTagName("FORMULARIO").item(0).appendChild(eCapa);
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
    datos.put("MODULO", "INC");

  
    String pais = conectorParametroLimpia("pais", "", true);
    datos.put(ConstantesREP.PAIS, pais);
    
    String marca = conectorParametroLimpia("marca", "", true);
    datos.put(ConstantesREP.MARCA, marca);
    
    String canal = conectorParametroLimpia("canal", "", true);
    datos.put(ConstantesREP.CANAL, canal);
    
    String periodo = conectorParametroLimpia("periodo", "", true);
    datos.put(ConstantesREP.PERIODO, periodo);
    
    String sgv = conectorParametroLimpia("sgv","",true);
    if(!sgv.equals("")){
      datos.put(ConstantesREP.SUBGERENCIAVENTAS,sgv);
    }
    
    String region = conectorParametroLimpia("region","",true);
    if(!region.equals("")){
      datos.put(ConstantesREP.REGIONES,region);
    }
    
    String zona = conectorParametroLimpia("zona", "", true);
    datos.put(ConstantesREP.ZONAS, zona);
    
    String moneda = conectorParametroLimpia("moneda", "", true);
    datos.put(ConstantesREP.MONEDA, moneda);
    
    String tipoventa = conectorParametroLimpia("tipoVenta", "", true);
    datos.put(ConstantesREP.TIPOVENTA, tipoventa);
    
    String tipoventaDesc = conectorParametroLimpia("tipoVentaDesc", "", true);
    datos.put(ConstantesREP.TIPOVENTADESC, tipoventaDesc);

    String unidadnegocio = conectorParametroLimpia("unidadNegocio","",true);
    if(!unidadnegocio.equals("")){
      datos.put(ConstantesREP.UNIDADNEGOCIOS,unidadnegocio);
    }
    
    String negocio = conectorParametroLimpia("negocio","",true);
    if(!negocio.equals("")){
      datos.put(ConstantesREP.NEGOCIOS,negocio);
    }
    
    String numeroConcurso = conectorParametroLimpia("numeroConcurso", "", true);
    datos.put(ConstantesREP.NUMEROCONCURSO, numeroConcurso);

	String numeroConcursoDesc = conectorParametroLimpia("numeroConcursoDesc", "", true);
    datos.put(ConstantesREP.NUMEROCONCURSODESC, numeroConcursoDesc);
    
    String periodoDesc = conectorParametroLimpia("periodoDesc", "", true);
    datos.put(ConstantesREP.PERIODODESC, periodoDesc);
    
    datos.put(ConstantesREP.TITULO, "Programa Red del Exito - Al Periodo " + periodoDesc);
    traza("++++++Antes de enviar a reportes " + datos); 
    
    String formato = conectorParametroLimpia("formato", "", true);
     
    if(formato.equals("xls")){
      datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
    }
    
     String reporte;
        
    if(region.equals("")){
       reporte = "RD_REP-081_02";    
    }else{
       if(zona.equals("")){
          reporte = "RD_REP-081_01";
       }else{
          reporte = "RD_REP-081";
       }
    }    
    
    ejecutarReporte2(datos, "REPGenerarReporteBatch",reporte, formato);
    
  }

}
