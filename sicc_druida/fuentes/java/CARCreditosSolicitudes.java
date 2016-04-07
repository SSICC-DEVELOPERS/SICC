import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
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

public class CARCreditosSolicitudes extends LPSICCBase {           
   public CARCreditosSolicitudes() {	 
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
           getConfiguracionMenu("CARCreditosSolicitudes");
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
     pagina("contenido_evaluacion_credito_solicitudes_obtener");   
    
     ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
          
     asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
     asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
     
     //cargo la lista oculta de zonas
     /*DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
     MareBusinessID idUA = new MareBusinessID("ZONObtenerZonasPorRegiones");
     Vector vec = new Vector();
     dtoUA.setOidPais(UtilidadesSession.getPais(this));
     dtoUA.setOidIdioma(UtilidadesSession.getIdioma(this));
     vec.add(dtoUA);
     vec.add(idUA);
     DTOSalida dtoZonas = (DTOSalida) conectar("ConectorUA",vec).objeto("dtoSalida"); 
     RecordSet zona = (RecordSet)dtoZonas.getResultado();
     Vector colZona = zona.getColumnIdentifiers();
     DruidaConector zonas = generarConector("DTOSalida.zonas_ROWSET",zona, colZona);
     traza("regiones "+dtoZonas.getResultado());
     traza("regiones "+dtoZonas.getResultado().getColumnIdentifiers());
     this.crearListaLP(colZona, zona.getColumnCount(), "CapaZona","ListaZonas", "14", "200");
     asignar("LISTA", "ListaZonas", zonas, "DTOSalida.zonas_ROWSET");  */
     
     //lleno el combo de tipo solicitud
     DTOBelcorp dto = new DTOBelcorp();
     dto.setOidPais(UtilidadesSession.getPais(this));
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     Vector vecTS = new Vector();
     MareBusinessID idTS = new MareBusinessID("PEDobtieneTiposSolicitud");
     vecTS.add(dto);
     vecTS.add(idTS);
     DTOSalida dtoTS = (DTOSalida)conectar("ConectorUA",vecTS).objeto("dtoSalida"); 
     RecordSet ts = (RecordSet)dtoTS.getResultado();
     Vector colTS = ts.getColumnIdentifiers();
     DruidaConector tss = generarConector("DTOSalida.ts_ROWSET",ts, colTS);
     asignar("COMBO", "cbTipoSolicitud", tss, "DTOSalida.ts_ROWSET");  
     
     //lleno el combo de estados de solicitud
     Vector vecES = new Vector();
     MareBusinessID idES = new MareBusinessID("PEDObtenerEstadosSolicitud");
     vecES.add(dto);
     vecES.add(idES);
     DTOSalida dtoES = (DTOSalida)conectar("ConectorUA",vecES).objeto("dtoSalida"); 
     RecordSet es = (RecordSet)dtoES.getResultado();
     Vector colES = es.getColumnIdentifiers();
     DruidaConector ess = generarConector("DTOSalida.es_ROWSET",es, colES);
     asignar("COMBO", "cbEstatusSolicitud", ess, "DTOSalida.es_ROWSET");  
     
     //lleno el combo de status de credito
     Vector vecEC = new Vector();
     MareBusinessID idEC = new MareBusinessID("CARObtenerEstatusPedido");
     vecEC.add(dto);
     vecEC.add(idEC);
     DTOSalida dtoEC = (DTOSalida)conectar("ConectorUA",vecEC).objeto("dtoSalida"); 
     RecordSet ec = (RecordSet)dtoEC.getResultado();
     Vector colEC = ec.getColumnIdentifiers();
     DruidaConector ecs = generarConector("DTOSalida.ec_ROWSET",ec, colEC);
     asignar("COMBO", "cbEstatusCreditoSolicitud", ecs, "DTOSalida.ec_ROWSET");  
     
     //cargo el combo de representante de credito
     
     Vector vecRC = new Vector();
     MareBusinessID idRC = new MareBusinessID("CARObtenerEjecutivos");
     vecRC.add(dto);
     vecRC.add(idRC);
     DTOSalida dtoRC = (DTOSalida)conectar("ConectorUA",vecRC).objeto("dtoSalida"); 
     RecordSet rc = (RecordSet)dtoRC.getResultado();
     Vector colRC = rc.getColumnIdentifiers();
     DruidaConector rcs = generarConector("DTOSalida.rc_ROWSET",rc, colRC);
     asignar("COMBO", "cbRepresentanteCredito", rcs, "DTOSalida.rc_ROWSET");  
     
     //cargo el combo de niveles de riesgo
     
     DTOOID dtoNR = new DTOOID();
     dtoNR.setOidIdioma(UtilidadesSession.getIdioma(this));
     MareBusinessID idNR = new MareBusinessID("CARNivelesRiesgo");
     Vector vecNR = new Vector();
     vecNR.add(dtoNR);
     vecNR.add(idNR);
     DTOSalida dtoNivel = (DTOSalida)conectar("ConectorUA",vecNR).objeto("dtoSalida"); 
     RecordSet nr = (RecordSet)dtoNivel.getResultado();
     Vector colNR = nr.getColumnIdentifiers();
     DruidaConector nrs = generarConector("DTOSalida.nr_ROWSET",nr, colNR);
     asignar("COMBO", "cbNivelRiesgo", nrs, "DTOSalida.nr_ROWSET");  
     
     //lleno el combo de codigos de arpobacion
     
     Vector vecCA = new Vector();
     MareBusinessID idCA = new MareBusinessID("CARObtenerCodigosAprobacion");
     vecCA.add(dto);
     vecCA.add(idCA);
     DTOSalida dtoCA = (DTOSalida)conectar("ConectorUA",vecCA).objeto("dtoSalida"); 
     RecordSet ca = (RecordSet)dtoCA.getResultado();
     Vector colCA = ca.getColumnIdentifiers();
     DruidaConector cas = generarConector("DTOSalida.ca_ROWSET",ca, colCA);
     asignar("COMBO", "cbMotivoAprobacion", cas, "DTOSalida.ca_ROWSET");  
      
     
     
      
      
     
     
         
   
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "CAR");
     
     //comienzo de los parametrso de filtrado
              
     String marca        = conectorParametroLimpia("marca", "", true);
     if(!marca.equals("")){
        datos.put(ConstantesREP.MARCA, marca);     
     }
     
     String canal        = conectorParametroLimpia("canal", "", true);
     String canalDesc        = conectorParametroLimpia("canalDesc", "", true);
     if(!canal.equals("")){
        datos.put(ConstantesREP.CANAL, canal);     
        datos.put(ConstantesREP.CANALDESC, canalDesc);     
     }
     
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
     
     String acceso        = conectorParametroLimpia("acceso", "", true);
     if(!acceso.equals("")){
        datos.put(ConstantesREP.ACCESO, acceso);     
     }
     
     String periodo        = conectorParametroLimpia("periodo", "", true);
     if(!periodo.equals("")){
        datos.put(ConstantesREP.PERIODO, periodo);     
     }
     
     String tipoSolicitud        = conectorParametroLimpia("tipoSolicitud", "", true);
     if(!tipoSolicitud.equals("")){
        datos.put(ConstantesREP.TIPOSOLICITUDES, tipoSolicitud);     
     }
     
     String estatusSolicitud        = conectorParametroLimpia("estatusSolicitud", "", true);
     if(!estatusSolicitud.equals("")){
        datos.put(ConstantesREP.ESTATUSSOLICITUD, estatusSolicitud);     
     }
     
     String estatusCreditoSolicitud        = conectorParametroLimpia("estatusCreditoSolicitud", "", true);
     if(!estatusCreditoSolicitud.equals("")){
        datos.put(ConstantesREP.ESTATUSCREDITOSOLICITUD, estatusCreditoSolicitud);     
     }
     
     String representanteCredito        = conectorParametroLimpia("representanteCredito", "", true);
     if(!representanteCredito.equals("")){
        datos.put(ConstantesREP.REPRESENTANTECREDITO, representanteCredito);     
     }
     
     String nivelRiesgo        = conectorParametroLimpia("nivelRiesgo", "", true);
     if(!nivelRiesgo.equals("")){
        datos.put(ConstantesREP.NIVELRIESGO, nivelRiesgo);     
     }
     
     String motivoBloqueo        = conectorParametroLimpia("motivoBloqueo", "", true);
     if(!motivoBloqueo.equals("")){
        datos.put(ConstantesREP.MOTIVOBLOQUEO, motivoBloqueo);     
     }
     
     String motivoAprobacion        = conectorParametroLimpia("motivoAprobacion", "", true);
     if(!motivoAprobacion.equals("")){
        datos.put(ConstantesREP.MOTIVOAPROBACION, motivoAprobacion);     
     }
     
     String informadoGerente        = conectorParametroLimpia("informadoGerente", "", true);
     if(!informadoGerente.equals("")){
        datos.put(ConstantesREP.INFORMADOGERENTEZONA, informadoGerente);     
     }
     
     String tipoOrden        = conectorParametroLimpia("tipoOrden", "", true);
     String reporte = null;
     
     String order1 = "'REGI.COD_REGI, CLIEN.COD_CLIE, ZONA.COD_ZONA, SOL_ENTR.FEC_DOCU, SOL_ENTR.VAL_MONT_ORDE'";
     String order2 = "'REGI.COD_REGI, ZONA.COD_ZONA, CLIEN.COD_CLIE, SOL_ENTR.FEC_DOCU DESC'";
     String order3 = "'EJECTA.USER_EJEC_CUEN, RIESGO.COD_NIVE_RIES, CLIEN_ADICI.IMP_MONT_LINE_CRED, SOL_ENTR.VAL_MONT_ORDE'";
     String order4 = "'T_SOLIC.COD_TIPO_SOLI, GEN_ESTADO_FINAL.ESTADO_FINAL, GEN_ESTADO_EVAL_AUTO.ESTADO_EVAL_AUTO,  (DECODE(SOL_ENTR.IND_VALI_1,1,'B1 ','') || DECODE(SOL_ENTR.IND_VALI_2,1,'B2 ','') || DECODE(SOL_ENTR.IND_VALI_3,1,'B3 ','') || DECODE(SOL_ENTR.IND_VALI_4,1,'B4 ',''))'";
     String order5 = "'GEN_ESTADO_FINAL.ESTADO_FINAL, SOL_ENTR.FEC_DOCU, (DECODE(SOL_ENTR.IND_VALI_1,1,'B1 ','') || DECODE(SOL_ENTR.IND_VALI_2,1,'B2 ','') || DECODE(SOL_ENTR.IND_VALI_3,1,'B3 ','') || DECODE(SOL_ENTR.IND_VALI_4,1,'B4 ','')), SOL_ENTR.EJCU_OID_USUA_LIBE'";

     
     if(tipoOrden.equals("") || (tipoOrden.equals("N"))){
        datos.put(ConstantesREP.TIPOORDEN, order1);     
        reporte = "RD_REP-091_01";
     }else{
        if(tipoOrden.equals("0")){
           datos.put(ConstantesREP.TIPOORDEN, order2);     
           reporte = "RD_REP-091_02";
        }else{
           if(tipoOrden.equals("1")){
              datos.put(ConstantesREP.TIPOORDEN, order3);     
              reporte = "RD_REP-091_03";
           }else{
              if(tipoOrden.equals("2")){
                 datos.put(ConstantesREP.TIPOORDEN, order4);     
                 reporte = "RD_REP-091_04";
              }else{
                 datos.put(ConstantesREP.TIPOORDEN, order5);     
                 reporte = "RD_REP-091_05";
              }
           
           }
        }
     }
     
     String formatoSalida = conectorParametroLimpia("formatoSalida", "", true);


     
     if(formatoSalida.equals("xls")){
      datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
     }
              
       
     datos.put(ConstantesREP.TITULO, "Reporte de Evaluacion de Credito de Solicitudes");     
     traza("++++++Antes de enviar a reportes " + datos); 
     traza("el reporte es " + reporte);
  //   traza("el formaro es  " + formato);
     //ejecutarReporte(datos, "REPGenerarReporte", reporte, formato);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", reporte, formatoSalida);
          
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
  
  

    
  
 
 


}










