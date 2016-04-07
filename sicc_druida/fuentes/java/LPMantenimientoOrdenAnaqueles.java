/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * Autor: SCS
 * 
 * vbongiov -- 03/09/2007
 */
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOLineaArmado;
import es.indra.sicc.dtos.ape.DTOSublineasLineaOrdenacion;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Boolean;
import java.math.BigDecimal;

import java.util.Vector;
import java.util.StringTokenizer;
import java.util.ArrayList;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.ape.DTOOrdenAnaquelesCabecera;
import es.indra.sicc.dtos.ape.DTOMapaCentroDistribucionDetalle;
import es.indra.sicc.dtos.ape.DTOMapaCentroDistribucionCabecera;
import es.indra.sicc.dtos.ape.DTOSublineaArmado;
import es.indra.sicc.dtos.ape.DTOOrdenAnaquelesCabeceraDetalles;
import es.indra.sicc.dtos.ape.DTOMapaZonasCabecera;
import es.indra.sicc.dtos.ape.DTOOrdenAnaquelesDetalle;

public class LPMantenimientoOrdenAnaqueles extends LPSICCBase {

    Long pais = null;
    Long idioma = null;
    int CANTLINEASANAQUELPAG = 100;
    
    public LPMantenimientoOrdenAnaqueles() {     
         super();
    }

    public void inicio() throws Exception { 
    }

    public void ejecucion() throws Exception {
      try {      
         setTrazaFichero();
         String accion = conectorParametroLimpia("accion", "", true);
         traza("SCS accion: " + accion);
         
         pais = UtilidadesSession.getPais(this);
         idioma = UtilidadesSession.getIdioma(this);
         
         if(accion.equals("")) {                                                  //inicializar
           this.cargarPantalla();
           
         } else if(accion.equals("Buscar")){ 
           this.buscar(); 

         } else if(accion.equals("AsignarOrden")){ 
           this.asignarOrden(); 
           
         } else if(accion.equals("verificarAnaquelPaginaSiguiente") || accion.equals("verificarAnaquelPaginaAnterior")
                    || accion.equals("verificarAnaquelPaginaAceptar")){ 
           this.verificarAnaquelPagina(); 
         
         } else if(accion.equals("guardarAnaquelPagina")){ 
           this.guardarAnaquelPagina(); 
           
         } else if(accion.equals("guardarAnaquelPaginaAceptar")){ 
           this.guardarAnaquelPaginaAceptar(); 

         } else if(accion.equals("Guardar")){ 
           this.guardar(); 

         } else if(accion.equals("GuardarModificacion")){ 
           this.guardarModif(); 
           
         } else if(accion.equals("limpiarAnaquelPagina")){ 
           this.limpiarAnaquelPagina();
           
         } else if(accion.equals("modificar")){ 
           this.obtenerOrdenAnaqueles();
           
         } else if(accion.equals("consultar")){ 
           this.obtenerOrdenAnaqueles(); 
           
         } else if(accion.equals("eliminar")){ 
           this.obtenerOrdenAnaqueles(); 
                  
         } else if(accion.equals("eliminarConfirmado")){ 
           this.eliminarOrdenAnaqueles(); 
         }
         
      } catch (Exception e){   
                    //preservaHiddensI18n(new Integer(1), "APE_ORDEN_ANAQU_CABEC", "formulario", "txtDescripcion", false);
           traza(e);      
           this.lanzarPaginaError(e);
      }
      getConfiguracionMenu();
    }

  private void cargarPantalla() throws Exception{
    String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
    traza("SCS opcionMenu: " + opcionMenu);

    pais = UtilidadesSession.getPais(this);
    idioma = UtilidadesSession.getIdioma(this);

    String oidOrdenAnaquelCabecera = null;
    oidOrdenAnaquelCabecera = conectorParametroLimpia("oidOrdenAnaqCabecera", "", true);
         
         if(opcionMenu.equals("insertar")) {
      pagina("contenido_orden_anaquel_insertar");      
      asignarAtributoPagina("cod", "0958");
             anyadeHiddensI18N(false, "APE_ORDEN_ANAQU_CABEC", null, new Integer(1), "formulario", "txtDescripcion", false);
      
    } else {
    
      pagina("contenido_orden_anaquel_modificar");
      // Titulo de la pagina
      if(opcionMenu.equals("insertar")) {
         asignarAtributoPagina("cod", "0958");
      } else if(opcionMenu.equals("modificar")) {
         traza("............opcion modificar............");
         asignarAtributoPagina("cod", "0959");
      } else if(opcionMenu.equals("consultar")) {
         asignarAtributoPagina("cod", "0960");
      } else if(opcionMenu.equals("eliminar")) {
         asignarAtributoPagina("cod", "0961");
      }
           //anyadeHiddensI18N(true, "APE_ORDEN_ANAQU_CABEC", null, new Integer(1), "formulario", "txtDescripcion", true);
    }

    // Validaciones
    getFormatosValidaciones();
    
    asignarAtributo("VAR","opcionMenu","valor", opcionMenu);  
    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));

         this.cargarCombos();

  }

  private void cargarCombos() throws Exception{
  
    traza("antes de ComposerViewElementList  ");
    ComposerViewElementList cv = crearParametrosEntrada();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    traza("SCS antes del conector.ejecucion");
    conector.ejecucion();
    traza("SCS despues del conector");
    DruidaConector resultados = conector.getConector();
  
    traza(resultados.getXML());
         
    asignar("COMBO","cbCentroDistribucion",resultados,"APEObtenerDescripcionesCD");   
    
    // Valores de defecto
    DTOBelcorp dtoBel = new DTOBelcorp();      
    dtoBel.setOidPais(pais);
    dtoBel.setOidIdioma(idioma);
      
    MareBusinessID mareBusinessID = new MareBusinessID("APEObtenerValoresDefecto");
         Vector params = new Vector();		
         params.addElement(dtoBel);
    params.addElement(mareBusinessID);
 
    traza("SCS antes del conector");
         DruidaConector dc  =	conectar("ConectorObtenerValoresDefecto", params);
    traza("SCS despues del conector");
    
    DTOSalida dtoSalida = (DTOSalida)dc.objeto("DTOSalida"); 
    
    asignarAtributo("VAR", "hCbCentroDistribucion", "valor", obtenerCDDef(dtoSalida));
    asignarAtributo("VAR", "hCbLineaArmadoCDDef", "valor", aplanarLineaArmadoCDDef(dtoSalida));
    asignarAtributo("VAR", "hCbMapaZonasDef", "valor", obtenerMapaZonasDef(dtoSalida));
  }

  private ComposerViewElementList crearParametrosEntrada() throws Exception{
      traza("SCS metodo ComposerViewElementList");
      ComposerViewElementList lista = new ComposerViewElementList();
      //combo codigo configuracion
      ComposerViewElement descripcionesCD = new ComposerViewElement();
  
      DTOBelcorp dtoBel = new DTOBelcorp();
      traza("SCS antes de asignar al dtobelcorp");
      dtoBel.setOidPais(pais);
      dtoBel.setOidIdioma(idioma);
           
      descripcionesCD.setIDBusiness("APEObtenerDescripcionesCD");
      descripcionesCD.setDTOE(dtoBel);
           
      lista.addViewElement(descripcionesCD);
      
      return lista;
  }

  private String aplanarLineaArmadoCDDef(DTOSalida dtoSalida) throws Exception{ 
    traza("SCS dentro a aplanarLineaArmadoCDDef");
    RecordSet valoresDef = dtoSalida.getResultado();
    String lineaArmadoCDDef = "";
    int cant = valoresDef.getRowCount();
         
    for(int i=0; i<cant; i++){      
      if(((String)(valoresDef.getValueAt(i,"COMBO"))).equals(ConstantesAPE.LINEA_ARMADO)){
           lineaArmadoCDDef = lineaArmadoCDDef + "," + ((BigDecimal)valoresDef.getValueAt(i,"OID")).toString();
      }
    }   
    
    if(!lineaArmadoCDDef.equals("")){
         traza("lineaArmadoCDDef :" + lineaArmadoCDDef.substring(1));
         return lineaArmadoCDDef.substring(1);
    } else {
         traza("SCS No hay linea armado por defecto");
         return "";
    }
  }

  private String obtenerMapaZonasDef(DTOSalida dtoSalida) throws Exception{
    traza("SCS entro a obtenerMapaZonasDef");
    RecordSet valoresDef = dtoSalida.getResultado();
    String CDDef = "";
    int cant = valoresDef.getRowCount();
    
    for(int i=0; i<cant; i++){      
      if(((String)(valoresDef.getValueAt(i,"COMBO"))).equals(ConstantesAPE.MAPA_ZONA)){
          traza("SCS CDDef :" + valoresDef.getValueAt(i,"OID"));
          return ((BigDecimal)valoresDef.getValueAt(i,"OID")).toString();
      }
    }   
    traza("SCS No hay CD por defecto");
    return "";

  }

  private String obtenerCDDef(DTOSalida dtoSalida) throws Exception{
    traza("SCS entro a obtenerCDDef");
    RecordSet valoresDef = dtoSalida.getResultado();
    String CDDef = "";
    int cant = valoresDef.getRowCount();
    
    for(int i=0; i<cant; i++){      
      if(((String)(valoresDef.getValueAt(i,"COMBO"))).equals(ConstantesAPE.CONFIGURACION_CD)){
          traza("SCS CDDef :" + valoresDef.getValueAt(i,"OID"));
          return ((BigDecimal)valoresDef.getValueAt(i,"OID")).toString();
      }
    }   
    traza("SCS No hay CD por defecto");
    return "";
  }
  
  private void limpiarAnaquelPagina() throws Exception{
   
      pagina("contenido_orden_anaquel_insertar_detalle");    
      
      // Validaciones
      this.getFormatosValidaciones();    
      
      String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
      traza("opcionMenu: " + opcionMenu);
      
      asignarAtributo("VAR","opcionMenu","valor", opcionMenu);  
      
      if(opcionMenu.equals("insertar")) {   
         asignarAtributoPagina("cod", "0958");
      } else if(opcionMenu.equals("modificar")) {
         asignarAtributoPagina("cod", "0959");
      } else if(opcionMenu.equals("consultar")) {
         asignarAtributoPagina("cod", "0960");
      } else if(opcionMenu.equals("eliminar")) {
         asignarAtributoPagina("cod", "0961");
      }            
                    
     // String ordenPagina = conectorParametroLimpia("ordenPagina", "", true);
    //  String pagina = conectorParametroLimpia("pagina", "", true);
      String paginaAMostrar = conectorParametroLimpia("paginaAMostrar", "", true);
           
      asignarAtributo("VAR","pagina","valor", paginaAMostrar +""); 
      
      ArrayList anaquelesSublinea = new ArrayList();
      ArrayList anaquelesPag = new ArrayList();      
      DTOOrdenAnaquelesDetalle dtoOrdenAnaquelesDetalle = null;
      
      // Obtener los anaqueles de la subLinea  
      anaquelesSublinea = (ArrayList)this.getSessionCache().get("DTOAnaquelesSublinea");
                
      // Armo los anaqueles de la nueva pagina a mostrar    
      anaquelesPag = (ArrayList)anaquelesSublinea.get(Integer.valueOf(paginaAMostrar).intValue()-1);
      int cantPagAMostrar = anaquelesPag.size();
      
      traza("arma lista");
      
      RecordSet rs = new RecordSet();          
      rs.addColumn("oid");
      rs.addColumn("numAnaq");
      rs.addColumn("numOrden");
      rs.addColumn("IndAnaqExp");
      rs.addColumn("NumAnaquelDestino");
      
      for(int i=0; i<cantPagAMostrar; i++){
           dtoOrdenAnaquelesDetalle =(DTOOrdenAnaquelesDetalle)anaquelesPag.get(i);
           
           rs.addRow(new Object[] {
                      dtoOrdenAnaquelesDetalle.getOidAnaquel(), 
                      dtoOrdenAnaquelesDetalle.getNumeroAnaquel(), 
                      dtoOrdenAnaquelesDetalle.getNumeroOrden(), 
                      dtoOrdenAnaquelesDetalle.getIndExpandido(), 
                      (dtoOrdenAnaquelesDetalle.getNumeroAnaquelDestino().equals("BLANCO")?"":dtoOrdenAnaquelesDetalle.getNumeroAnaquelDestino())}); 
      }
           
      traza("rs: " + rs);
      asignarAtributo("VAR","cantPaginas","valor", anaquelesSublinea.size()+"");            
      asignar("LISTADOA", "listado1", generarConector("ROWSET", rs, (Vector)rs.getColumnIdentifiers()),"ROWSET");                                                      	  
  }
  
  
  private void guardarAnaquelPaginaAceptar() throws Exception{
   
      pagina("salidaGenerica");
      
      try {     
                    
           String ordenPagina = conectorParametroLimpia("ordenPagina", "", true);
           String pagina = conectorParametroLimpia("pagina", "", true);
           String paginaAMostrar = conectorParametroLimpia("paginaAMostrar", "", true);
             
           ArrayList anaquelesSublinea = new ArrayList();
           ArrayList anaquelesPag = new ArrayList();
           DTOOrdenAnaquelesDetalle dtoOrdenAnaquelesDetalle = null;
           StringTokenizer ordenAnaquel = new StringTokenizer(ordenPagina,"|");;
           String oidAnaquelC = null;
           String oidAnaquel = null;
           String numAnaquel = null;
           String numOrden = null;
           String indExpAnaq = null;
           String anaquelDest = null;
           
           // Obtener los anaqueles de la subLinea  
           anaquelesSublinea = (ArrayList)this.getSessionCache().get("DTOAnaquelesSublinea");
           
           // Guarda el orden ingresado en la pagina
           anaquelesPag = (ArrayList)anaquelesSublinea.get(Integer.valueOf(pagina).intValue()-1);
           int cantPag = anaquelesPag.size();
           
           for(int i=0; i<cantPag; i++){
                dtoOrdenAnaquelesDetalle =(DTOOrdenAnaquelesDetalle)anaquelesPag.get(i);
                dtoOrdenAnaquelesDetalle.setNumeroOrden(Long.valueOf(ordenAnaquel.nextToken()));           
           }
           
           // Armo string 
           int cantPaginas = anaquelesSublinea.size();
           cantPag = 0;
           StringBuffer detalleSubLinea = new StringBuffer();
    
           for(int i=0; i<cantPaginas; i++){
                
                anaquelesPag = (ArrayList)anaquelesSublinea.get(i);
                cantPag = anaquelesPag.size();
                
                for(int j=0; j<cantPag; j++){
                   dtoOrdenAnaquelesDetalle =(DTOOrdenAnaquelesDetalle)anaquelesPag.get(j);
                    
                   detalleSubLinea.append("|").append(dtoOrdenAnaquelesDetalle.getOidAnaquel().toString());
                   detalleSubLinea.append("#").append(dtoOrdenAnaquelesDetalle.getNumeroAnaquel());
                   detalleSubLinea.append("#").append(dtoOrdenAnaquelesDetalle.getNumeroOrden());
                   detalleSubLinea.append("#").append(dtoOrdenAnaquelesDetalle.getIndExpandido());
                   detalleSubLinea.append("#").append(dtoOrdenAnaquelesDetalle.getNumeroAnaquelDestino());
                }
           }
           
           // Limpio los anaqueles por pagina en session 
           this.getSessionCache().put("DTOAnaquelesSublinea", null); 
           
           asignarAtributo("VAR", "ejecutar", "valor", "retornarDetalleSubLinea('" + detalleSubLinea.toString().substring(1) + "');");
           
      } catch(Exception e) {
         asignarAtributo("VAR", "ejecutarError", "valor", "focalizaNroOrden();");
         throw e;
      }
  }
  
  private void verificarAnaquelPagina() throws Exception{
  
      pagina("salidaGenerica");
      asignarAtributo("VAR","cerrarVentana","valor", "false");  
      
      Long numOrdenRepetido = null;
      int posicion = 0;
 
      try {           
           String accion = conectorParametroLimpia("accion", "", true);
           String ejecutarOK = null;
           
           if(accion.equals("verificarAnaquelPaginaSiguiente")){
                ejecutarOK = "okSiguiente();";
           } else if(accion.equals("verificarAnaquelPaginaAnterior")){ 
                ejecutarOK = "okAnterior();";
           } else if(accion.equals("verificarAnaquelPaginaAceptar")){ 
                ejecutarOK = "okAceptar();";
           }
           
           traza("ejecutarOK: " + ejecutarOK);
        
           String ordenPagina = conectorParametroLimpia("ordenPagina", "", true);
           String pagina = conectorParametroLimpia("pagina", "", true);
                    
           ArrayList anaquelesSublinea = new ArrayList();
           ArrayList anaquelesPag = new ArrayList();
           DTOOrdenAnaquelesDetalle dtoOrdenAnaquelesDetalle = null;
           StringTokenizer ordenAnaquel = new StringTokenizer(ordenPagina,"|");
           Long numOrden = null;
           
           // Obtener los anaqueles de la subLinea  
           anaquelesSublinea = (ArrayList)this.getSessionCache().get("DTOAnaquelesSublinea");
           int cantPaginas = anaquelesSublinea.size();
           int cantPag = 0;
           
           while (ordenAnaquel.hasMoreTokens()) {

                numOrden = Long.valueOf(ordenAnaquel.nextToken());
                posicion++;
                traza("posicion: " + posicion);
                
                for(int i=0; i<cantPaginas; i++){

                    if(i!=(Integer.valueOf(pagina).intValue()-1)){
                    
                         anaquelesPag = (ArrayList)anaquelesSublinea.get(i);
                         cantPag = anaquelesPag.size();
                         
                         for(int j=0; j<cantPag; j++){
                             dtoOrdenAnaquelesDetalle =(DTOOrdenAnaquelesDetalle)anaquelesPag.get(j);
                             
                             if(numOrden.equals(dtoOrdenAnaquelesDetalle.getNumeroOrden())){
                                  numOrdenRepetido = numOrden;
                                  throw new MareException(null, null,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE + "0055"));  
                             }
                         }
                    }
                }
           }    
           asignarAtributo("VAR", "ejecutar", "valor", ejecutarOK);
           
      } catch(Exception e) {
         traza("numOrdenRepetido: " + numOrdenRepetido);
         posicion--;
         traza("posicion: " + posicion);
         asignarAtributo("VAR", "ejecutarError", "valor", "verificacionNoOK("+ posicion + ");");
         throw e;
      }
  }
  
  private void guardarAnaquelPagina() throws Exception{
   
      pagina("contenido_orden_anaquel_insertar_detalle");    
      
      // Validaciones
      this.getFormatosValidaciones();    
      
      String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
      traza("opcionMenu: " + opcionMenu);
      
      asignarAtributo("VAR","opcionMenu","valor", opcionMenu);  
      
      if(opcionMenu.equals("insertar")) {   
         asignarAtributoPagina("cod", "0958");
      } else if(opcionMenu.equals("modificar")) {
         asignarAtributoPagina("cod", "0959");
      } else if(opcionMenu.equals("consultar")) {
         asignarAtributoPagina("cod", "0960");
      } else if(opcionMenu.equals("eliminar")) {
         asignarAtributoPagina("cod", "0961");
      }            
                    
      String ordenPagina = conectorParametroLimpia("ordenPagina", "", true);
      String pagina = conectorParametroLimpia("pagina", "", true);
      String paginaAMostrar = conectorParametroLimpia("paginaAMostrar", "", true);
           
      asignarAtributo("VAR","pagina","valor", paginaAMostrar +""); 
      
      ArrayList anaquelesSublinea = new ArrayList();
      ArrayList anaquelesPag = new ArrayList();
      DTOOrdenAnaquelesDetalle dtoOrdenAnaquelesDetalle = null;
      StringTokenizer ordenAnaquel = new StringTokenizer(ordenPagina,"|");;
      String oidAnaquelC = null;
      String oidAnaquel = null;
      String numAnaquel = null;
      String numOrden = null;
      String indExpAnaq = null;
      String anaquelDest = null;
      
      // Obtener los anaqueles de la subLinea  
      anaquelesSublinea = (ArrayList)this.getSessionCache().get("DTOAnaquelesSublinea");
      
      // Guarda el orden ingresado en la pagina
      anaquelesPag = (ArrayList)anaquelesSublinea.get(Integer.valueOf(pagina).intValue()-1);
      int cantPag = anaquelesPag.size();
      
      for(int i=0; i<cantPag; i++){
           dtoOrdenAnaquelesDetalle =(DTOOrdenAnaquelesDetalle)anaquelesPag.get(i);
           dtoOrdenAnaquelesDetalle.setNumeroOrden(Long.valueOf(ordenAnaquel.nextToken()));           
      }
      
      // Guardo los anaqueles por pagina en session 
      this.getSessionCache().put("DTOAnaquelesSublinea", anaquelesSublinea);   
      
      traza("anaquelesSublinea: " + anaquelesSublinea);
      
          
      // Armo los anaqueles de la nueva pagina a mostrar    
      anaquelesPag = (ArrayList)anaquelesSublinea.get(Integer.valueOf(paginaAMostrar).intValue()-1);
      int cantPagAMostrar = anaquelesPag.size();
      
      traza("arma lista");
      
      RecordSet rs = new RecordSet();          
      rs.addColumn("oid");
      rs.addColumn("numAnaq");
      rs.addColumn("numOrden");
      rs.addColumn("IndAnaqExp");
      rs.addColumn("NumAnaquelDestino");
      
      for(int i=0; i<cantPagAMostrar; i++){
           dtoOrdenAnaquelesDetalle =(DTOOrdenAnaquelesDetalle)anaquelesPag.get(i);
           
           rs.addRow(new Object[] {
                      dtoOrdenAnaquelesDetalle.getOidAnaquel(), 
                      dtoOrdenAnaquelesDetalle.getNumeroAnaquel(), 
                      dtoOrdenAnaquelesDetalle.getNumeroOrden(), 
                      dtoOrdenAnaquelesDetalle.getIndExpandido(), 
                      (dtoOrdenAnaquelesDetalle.getNumeroAnaquelDestino().equals("BLANCO")?"":dtoOrdenAnaquelesDetalle.getNumeroAnaquelDestino())}); 
      }
           
      traza("rs: " + rs);
      asignarAtributo("VAR","cantPaginas","valor", anaquelesSublinea.size()+"");            
      asignar("LISTADOA", "listado1", generarConector("ROWSET", rs, (Vector)rs.getColumnIdentifiers()),"ROWSET");                                                      	  
  }
  

   private void asignarOrden() throws Exception{
   
      pagina("contenido_orden_anaquel_insertar_detalle");     
      
      // Validaciones
      this.getFormatosValidaciones();    
      
      String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
      traza("opcionMenu: " + opcionMenu);
      
      asignarAtributo("VAR","opcionMenu","valor", opcionMenu);  
      
      if(opcionMenu.equals("insertar")) {   
         asignarAtributoPagina("cod", "0958");
      } else if(opcionMenu.equals("modificar")) {
         asignarAtributoPagina("cod", "0959");
      } else if(opcionMenu.equals("consultar")) {
         asignarAtributoPagina("cod", "0960");
      } else if(opcionMenu.equals("eliminar")) {
         asignarAtributoPagina("cod", "0961");
      } 
           
                    DTOMapaCentroDistribucionDetalle dtoMCDD = new DTOMapaCentroDistribucionDetalle();
                    DTOMapaCentroDistribucionCabecera dtoMCDC = new DTOMapaCentroDistribucionCabecera();
      DTOSalida dtoLstAquelesAOrdenar = null;

                    DTOSublineaArmado dtoSLA = new DTOSublineaArmado();
                    String oidMapaCentrDistri = conectorParametroLimpia("hOidMapaCentrDistr", "", true);
                  String oidSublnArmado	    = conectorParametroLimpia("hOidSublnArmado", "", true);
      String detalleSubLinea = conectorParametroLimpia("detalleSubLinea", "", true);
      
      asignarAtributo("VAR","hOidMapaCentrDistr","valor", oidMapaCentrDistri);  
      asignarAtributo("VAR","hOidSublnArmado","valor", oidSublnArmado);  

                    traza("oidMapaCentrDistri: " + oidMapaCentrDistri);
                    traza("oidSublnArmado: " + oidSublnArmado);
      
      if(opcionMenu.equals("insertar") || detalleSubLinea.equals("")){ 

           dtoMCDC.setOid(Long.valueOf(oidMapaCentrDistri));
           dtoSLA.setOid(Long.valueOf(oidSublnArmado));
    
           dtoMCDD.setMapaCentroDistribucionCabecera(dtoMCDC);
           dtoMCDD.setSublineaArmado(dtoSLA);
    
           traza("dtoMCDD: " + dtoMCDD);
    
           MareBusinessID mareBusinessID1 = new MareBusinessID("APEObtenerObtenerNroAnaquelesAOrdenar");
           Vector params1 = new Vector();                  
           params1.addElement(dtoMCDD);
           params1.addElement(mareBusinessID1);
    
           traza("antes del conector");
           DruidaConector dc1  = conectar("ConectorObtenerNroAnaquelesAOrdenar", params1);
           traza("despues del conector");
    
           dtoLstAquelesAOrdenar = (DTOSalida)dc1.objeto("DTOSalida");           
      }
      
      asignarAtributo("VAR","detalleSubLinea","valor", detalleSubLinea);  
      asignarAtributo("VAR","pagina","valor", "1"); 
   
      ArrayList anaquelesSublinea = new ArrayList();
      ArrayList anaquelesPag = new ArrayList();
      DTOOrdenAnaquelesDetalle dtoOrdenAnaquelesDetalle = null;
      StringTokenizer detAnaquel = null;
      String oidAnaquel = null;
      String numAnaquel = null;
      String numOrden = null;
      String indExpAnaq = null;
      String anaquelDest = null;
      int cantPag = 0;
      
      traza("arma lista");
      // Armo Detalle
      RecordSet rs = new RecordSet();          
      rs.addColumn("oid");
      rs.addColumn("numAnaq");
      rs.addColumn("numOrden");
      rs.addColumn("IndAnaqExp");
      rs.addColumn("NumAnaquelDestino");
      
      traza("detalleSubLinea: " + detalleSubLinea);
      
      if(opcionMenu.equals("insertar") || detalleSubLinea.equals("")){ 
           traza("insertar o no");
           
           RecordSet anaquelesOrdenar = dtoLstAquelesAOrdenar.getResultado();
           int cant = anaquelesOrdenar.getRowCount();
           
           traza("anaquelesOrdenar: " + anaquelesOrdenar);
           traza("anaquelesOrdenar cant: " + anaquelesOrdenar.getRowCount());
           
           if ((dtoLstAquelesAOrdenar.getResultado()==null)||(dtoLstAquelesAOrdenar.getResultado().getRowCount()<=0)) {
                traza(" No se encontraron anaqueles sin expandir para el Mapa, Línea y Sublínea seleccionado");
                
                throw new MareException(null, null,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE + "APE_0055"));  
           }
           
           // Armo los anaqueles por pagina 
           for(int i=0; i<cant; i++){
                dtoOrdenAnaquelesDetalle = new DTOOrdenAnaquelesDetalle();
                cantPag++;
                
                oidAnaquel = ((BigDecimal)anaquelesOrdenar.getValueAt(i,"OID_MAPA_CENT_DIST_DETA")).toString();
                numAnaquel = (String)anaquelesOrdenar.getValueAt(i,"NANAQUEL");
             
                indExpAnaq = ((BigDecimal)anaquelesOrdenar.getValueAt(i,"IND_EXPA")).toString();
                anaquelDest = (String)anaquelesOrdenar.getValueAt(i,"NUM_ANAQ_DEST");
                
                
                dtoOrdenAnaquelesDetalle.setOidAnaquel(Long.valueOf(oidAnaquel));
                dtoOrdenAnaquelesDetalle.setIndExpandido(indExpAnaq);
                dtoOrdenAnaquelesDetalle.setNumeroAnaquelDestino(anaquelDest);
                dtoOrdenAnaquelesDetalle.setNumeroAnaquel(numAnaquel);
                
                // Genero la primera pagina
                if(i < CANTLINEASANAQUELPAG){
                    rs.addRow(new Object[] {
                      oidAnaquel, numAnaquel , "", indExpAnaq, (anaquelDest.equals("BLANCO")?"":anaquelDest)}); 
                }
                
                if(cantPag <= CANTLINEASANAQUELPAG){
                    anaquelesPag.add(dtoOrdenAnaquelesDetalle);
                    
                    if(cantPag == CANTLINEASANAQUELPAG){
                         anaquelesSublinea.add(anaquelesPag);
                         anaquelesPag = new ArrayList();
                         cantPag = 0;
                    }
                    
                    if(i==(cant-1)){
                        anaquelesSublinea.add(anaquelesPag);
                    }
                }
           }                
           
           traza("anaquelesSublinea: " + anaquelesSublinea);
            // Guardo los anaqueles por pagina en session 
           this.getSessionCache().put("DTOAnaquelesSublinea", anaquelesSublinea);          
           
      } else {
           traza("no insertar");
           StringTokenizer stkDetalleSubLinea = new StringTokenizer(detalleSubLinea,"|");
           StringTokenizer regSubLinea = null;
           int j=0;
           
           while (stkDetalleSubLinea.hasMoreTokens()) {
           
             // Armo los anaqueles por pagina
             dtoOrdenAnaquelesDetalle = new DTOOrdenAnaquelesDetalle();
             cantPag++;
             j++;
         
             regSubLinea = new StringTokenizer(stkDetalleSubLinea.nextToken(),"#");
             oidAnaquel = regSubLinea.nextToken();
             numAnaquel = regSubLinea.nextToken();
             numOrden = regSubLinea.nextToken();
             indExpAnaq = regSubLinea.nextToken();
             anaquelDest = regSubLinea.nextToken();
             
             dtoOrdenAnaquelesDetalle.setOidAnaquel(Long.valueOf(oidAnaquel));
             dtoOrdenAnaquelesDetalle.setNumeroAnaquel(numAnaquel);
             dtoOrdenAnaquelesDetalle.setNumeroOrden(Long.valueOf(numOrden));
             dtoOrdenAnaquelesDetalle.setIndExpandido(indExpAnaq);
             dtoOrdenAnaquelesDetalle.setNumeroAnaquelDestino(anaquelDest);
             
             // Genero la primera pagina
             if(j <= CANTLINEASANAQUELPAG){
                  rs.addRow(new Object[] {
                    oidAnaquel, numAnaquel , numOrden, indExpAnaq, (anaquelDest.equals("BLANCO")?"":anaquelDest)}); 
             }
             
             if(cantPag <= CANTLINEASANAQUELPAG){
                  anaquelesPag.add(dtoOrdenAnaquelesDetalle);
                  
                  if(cantPag == CANTLINEASANAQUELPAG){
                      anaquelesSublinea.add(anaquelesPag);
                      anaquelesPag = new ArrayList();
                      cantPag = 0;
                  }
             } 
           }     
           
           // Guardo la ultima pagina
           anaquelesSublinea.add(anaquelesPag);
           
           traza("anaquelesSublinea: " + anaquelesSublinea);
           
           // Guardo los anaqueles por pagina en session 
           this.getSessionCache().put("DTOAnaquelesSublinea", anaquelesSublinea);   
      }
      
      traza("rs: " + rs);
      asignarAtributo("VAR","cantPaginas","valor", anaquelesSublinea.size()+"");            
      asignar("LISTADOA", "listado1", generarConector("ROWSET", rs, (Vector)rs.getColumnIdentifiers()),"ROWSET");  
                  
  }

  
    
  private void buscar() throws Exception{
           pagina("salidaGenerica"); 
           String ejecutarError = null;
    String ejecutarOK = null;

           DTOOID dtoOOID = new DTOOID();
           String oidMapaZona = conectorParametroLimpia("hOidMapaZona", "", true); 
           dtoOOID.setOid(Long.valueOf(oidMapaZona));
    dtoOOID.setOidPais(pais);
    dtoOOID.setOidIdioma(idioma);

    MareBusinessID mareBusinessID = new MareBusinessID("APEObtenerDefaultOrdenAnaqueles");
           Vector params = new Vector();		
           params.addElement(dtoOOID);
    params.addElement(mareBusinessID);
           String ordenPorDef = conectorParametroLimpia("hChkOrdenPorDefecto", "", true); 

           traza("antes del conector");
           DruidaConector dc  =	conectar("ConectorObtenerDefaultOrdenAnaqueles", params);
      traza("despues del conector");

           Object obj = (Object)dc.objeto("DTOSalida"); 

           DTOOrdenAnaquelesCabecera dtoDefecto = (DTOOrdenAnaquelesCabecera)dc.objeto("DTOSalida");

           traza("el dtoDefecto, es: " + dtoDefecto);
           traza("ordenPorDef.trim(): " + ordenPorDef.trim());

           if (dtoDefecto.getOid()!=null)
                    traza("y la gran flauta");
           if (ordenPorDef.trim().equals("S"))
                    traza("y la gran flauta II");

           if ( (dtoDefecto.getOid()!=null) && (ordenPorDef.trim().equals("S")) )	 {
                    traza("dtoDefecto!=null");
                    // Agregado - eiraola 02/Jul/2007 para mensaje parametrizado - Inicio
                    String descCD = "";
                    String descMapaCD = "";
                    String descMapaZona = "";
                    String descMapaAnaquel = "";
                    
                    if (dtoDefecto.getDescOrdenAnaqueles() != null) {
                             descMapaAnaquel = dtoDefecto.getDescOrdenAnaqueles();
                    }

                    if (dtoDefecto.getMapaZonaCabecera() != null) {
                             Vector descripciones = dtoDefecto.getMapaZonaCabecera().getDescripcionMapaZonas();
                             
                             if (descripciones != null && descripciones.size() > 0) {
                                      DTOI18nSICC dtoDescI18n = (DTOI18nSICC) descripciones.get(0);
                                      descMapaZona = dtoDescI18n.getValorI18n();
                             }
                             
                             if (dtoDefecto.getMapaZonaCabecera().getMapaCentroDistribucionCabecerea() != null) {
                                      
                                      if (dtoDefecto.getMapaZonaCabecera().getMapaCentroDistribucionCabecerea().getDescripcionMapa() != null) {
                                                descMapaCD = dtoDefecto.getMapaZonaCabecera().getMapaCentroDistribucionCabecerea().getDescripcionMapa();
                                      }
                                      
                                      if (dtoDefecto.getMapaZonaCabecera().getMapaCentroDistribucionCabecerea().getCentroDistribucion() != null) {
                                                descCD = dtoDefecto.getMapaZonaCabecera().getMapaCentroDistribucionCabecerea().getCentroDistribucion().getDescripcion();
                                      }
                             }
                    }
                    // Agregado - eiraola 02/Jul/2007 para mensaje parametrizado - Fin

                    //mensaje de error
                    ejecutarOK = "yaExisteUnOrdenAnaqPorDef('"+ descCD +"', '"+ descMapaCD +"', '"+ descMapaZona +"', '"+ descMapaAnaquel +"');"; // Modificado - eiraola 02/Jul/2007 agrego paso de parametros
                    traza(" --- vamos a lanzar mensaje al usuario con: " + ejecutarOK);
                    asignarAtributo("VAR", "ejecutar", "valor", ejecutarOK);

           } else {
    
      asignarAtributo("VAR", "ejecutar", "valor", "buscarSubLineas();");
           }										 
           
  }

  private void eliminarOrdenAnaqueles() throws Exception{
           pagina("salidaGenerica");
    String ejecutarOK = null;
    String ejecutarError = null;
           String oidOrdenAnaquelCabecera = null;

           traza("dentro de....eliminarOrdenAnaqueles()");
      oidOrdenAnaquelCabecera = conectorParametroLimpia("cbOrdenAnaquel", "", true);  
      traza("oidOrdenAnaquelCabecera (eliminacion!): " + oidOrdenAnaquelCabecera);

           try {           

           DTOOrdenAnaquelesCabeceraDetalles  dtoOrdAnaqCabDet = new DTOOrdenAnaquelesCabeceraDetalles();
           dtoOrdAnaqCabDet.setOid(Long.valueOf(oidOrdenAnaquelCabecera));
           dtoOrdAnaqCabDet.setOidIdioma(idioma);
           dtoOrdAnaqCabDet.setOidPais(pais);
    
           MareBusinessID mareBusinessID = new MareBusinessID("APEEliminarOrdenAnaquelesCabeceraDetalles");
           Vector params = new Vector();          
           params.addElement(dtoOrdAnaqCabDet);
             params.addElement(mareBusinessID);
    
           traza("dtoOrdAnaqCabDet defecto: " + dtoOrdAnaqCabDet.getValorDefecto());
    
           traza("*************** Antes de conectar (eliminar)");
           DruidaConector con = conectar("ConectorEliminarOrdenAnaqueles", params);
           traza("*************** Despues de conectar (eliminar)");
    
           ejecutarOK = "fLimpiar();";
           asignarAtributo("VAR", "ejecutar", "valor", ejecutarOK);

      } catch(Exception e) {
         traza("Excepcion: " + e);
         asignarAtributo("VAR", "ejecutarError", "valor", "focoCentroDistribucion();");
         throw e;
      }
  }

  private void guardarModif() throws Exception{
      this.guardar();          
  }

  private void guardar() throws Exception{
      pagina("salidaGenerica");

      String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);      
      String ejecutarOK = null;
      String ejecutarError = null;
             String oidOrdenAnaquelCabecera = null;
             Boolean lContinuo = new Boolean(true);

           //anyadeHiddensI18N(true, "APE_ORDEN_ANAQU_CABEC", null, new Integer(1), "formulario", "txtDescripcion", false);

      if(opcionMenu.equals("modificar")) {
           String chkOrdenPorDefecto = conectorParametroLimpia("ChkOrdenPorDefecto", "", true);
           String tengoDefaultOrdenAnaqueles = conectorParametroLimpia("tengoDefaultOrdenAnaqueles", "", true);
           traza("hChkOrdenPorDefecto, en modificar: " + chkOrdenPorDefecto);
           traza("tengoDefaultOrdenAnaqueles, en modificar (guardado): " + tengoDefaultOrdenAnaqueles);
           
                    boolean continuar = verificarDefaultOrdenAnaquel();
                    
                    if (continuar) {
                             guardoDefinitivo();
                    } else {
                             return;
                    }
           }

           if (lContinuo.booleanValue()){
           //continuo ok
                traza("voy por aca!!(2)");
           this.guardoDefinitivo();
           }else{
                ejecutarOK = "yaExisteUnOrdenAnaqPorDef();";
                    traza(" --- [MODIFICAR] vamos a lanzar mensaje al usuario con: " + ejecutarOK);
         asignarAtributo("VAR", "ejecutar", "valor", ejecutarOK);
           }
  }

  private void guardoDefinitivo() throws Exception{
      String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);      
      String ejecutarOK = null;
      String ejecutarError = null;
             String oidOrdenAnaquelCabecera = null;

      if(opcionMenu.equals("insertar")) {            
           ejecutarOK = "limpiaYhabilitaObjetos();";
           ejecutarError = "focoDescripcion();";
      } else if(opcionMenu.equals("modificar")) { 
           oidOrdenAnaquelCabecera = conectorParametroLimpia("oidOrdenAnaqCabecera", "", true);  
           traza("oidOrdenAnaquelCabecera: " + oidOrdenAnaquelCabecera);
      }

      try {           

           String oidMapaZona = conectorParametroLimpia("cbMapaZonas", "", true); 
           String oidLinArmado = conectorParametroLimpia("cbLineaArmado", "", true); 
           String ordenPorDef = conectorParametroLimpia("ChkOrdenPorDefecto", "", true); 
           String descripcion = conectorParametroLimpia("txtDescripcion", "", true); 
           String detalles = conectorParametroLimpia("listaDetalles", "", true); 
    
           traza("oidMapaZona: " + oidMapaZona);
           traza("oidLinArmado: " + oidLinArmado);
           traza("ordenPorDef: " + ordenPorDef.trim());                                                                                                                           
           traza("descripcion: " + descripcion);
           traza("detalles: " + detalles);
    
           DTOOrdenAnaquelesCabeceraDetalles  dtoOrdAnaqCabDet = new DTOOrdenAnaquelesCabeceraDetalles();
           DTOMapaZonasCabecera                 dtoMapaZonCabe   = new DTOMapaZonasCabecera();
           DTOSublineaArmado                                                    dtoSublnArmad    = new DTOSublineaArmado();
           DTOLineaArmado                        dtoLineaArmado = new DTOLineaArmado();
            
           dtoMapaZonCabe.setOid(Long.valueOf(oidMapaZona));
           
           dtoLineaArmado = new DTOLineaArmado();
           dtoLineaArmado.setOid(Long.valueOf(oidLinArmado));
           dtoSublnArmad.setLineaArmado(dtoLineaArmado);
    
           if(opcionMenu.equals("modificar")) { 
             dtoOrdAnaqCabDet.setOid(Long.valueOf(oidOrdenAnaquelCabecera));
           }
           
           dtoOrdAnaqCabDet.setMapaZonaCabecera(dtoMapaZonCabe);
           dtoOrdAnaqCabDet.setSublineaArmado(dtoSublnArmad);
    
           traza("ordenPorDef: " + ordenPorDef.trim());
    
           if (ordenPorDef.trim().equals("S")){
             dtoOrdAnaqCabDet.setValorDefecto(new Boolean(true));
           }else{
             dtoOrdAnaqCabDet.setValorDefecto(new Boolean(false));
           }
           
           traza("Traduccciones: "+ recuperaTraduccionesI18N(new Integer(1)));
           dtoOrdAnaqCabDet.setDescripcionOrdenAnaqueles(recuperaTraduccionesI18N(new Integer(1)));
    
           dtoOrdAnaqCabDet.setOidIdioma(idioma);
           dtoOrdAnaqCabDet.setOidPais(pais);
           
           traza("dtoOrdAnaqCabDet: " + dtoOrdAnaqCabDet);
           
           // Detalles
           ArrayList detallesArr = new ArrayList();
           StringTokenizer stkListaDetalles = new StringTokenizer(detalles,"%");
           StringTokenizer stkRegDetalle = null;
    
           String oidSubLinea = null;
           String numOrdenStr   = null;
           String numAnaquel = null;
           String oidAnaquel = null;
           String numOrden   = null;
           StringTokenizer stkListaSubLinea = null;
           StringTokenizer stkRegOrdenAnaquel = null;
           StringTokenizer stkDetAnaquel = null;
    
           while (stkListaDetalles.hasMoreTokens()) {
             stkRegDetalle = new StringTokenizer(stkListaDetalles.nextToken(),"$");
             
             oidSubLinea = stkRegDetalle.nextToken();
             numOrdenStr = stkRegDetalle.nextToken();
             
             traza("oidSubLinea: " + oidSubLinea);
             
             stkListaSubLinea = new StringTokenizer(numOrdenStr,"|");
             
             while (stkListaSubLinea.hasMoreTokens()) {
             
                  stkRegOrdenAnaquel = new StringTokenizer(stkListaSubLinea.nextToken(),"#");
                  
                  DTOOrdenAnaquelesDetalle dtoDetalle = new DTOOrdenAnaquelesDetalle();
         
                  oidAnaquel = stkRegOrdenAnaquel.nextToken();
                  numAnaquel = stkRegOrdenAnaquel.nextToken();                  
                  numOrden   = stkRegOrdenAnaquel.nextToken();
         
                  dtoDetalle.setOidAnaquel(Long.valueOf(oidAnaquel));  
                  dtoDetalle.setNumeroOrden(Long.valueOf(numOrden));
         
                  detallesArr.add(dtoDetalle);
                  traza("dtoDetalle: " + dtoDetalle);
             }
           }
           
           dtoOrdAnaqCabDet.setDetalles(detallesArr);
    
    
           MareBusinessID mareBusinessID = new MareBusinessID("APEActualizarOrdenAnaquelesCabeceraDetalles");
           Vector params = new Vector();          
           params.addElement(dtoOrdAnaqCabDet);
           params.addElement(mareBusinessID);
    
           traza("*************** Antes de conectar");
           DruidaConector con = conectar("ConectorActualizarOrdenAnaqueles", params);
           traza("*************** Despues de conectar");
    
           if(opcionMenu.equals("insertar")) {
                asignarAtributo("VAR", "ejecutar", "valor", ejecutarOK);
           }
           if(opcionMenu.equals("modificar")) {
             ejecutarOK = "modificarOk();";
             asignarAtributo("VAR", "ejecutar", "valor", ejecutarOK);
           }

      } catch(Exception e) {
         traza("Excepcion: " + e);
         asignarAtributo("VAR", "ejecutarError", "valor", ejecutarError);
         throw e;
      }
  }

  private DruidaConector generarConector(String rowsetID, RecordSet datos, Vector columns) throws DOMException, Exception{
      traza("generarConector entro");
      StringBuffer salida = new StringBuffer();
      int sizeColums = datos.getColumnCount();
      int sizeRows = datos.getRowCount();
      
      if ( columns == null ){
         columns = new Vector();
      }
  
      Vector columsDesc = datos.getColumnIdentifiers();          
      
      DruidaConector conectorValoresPosibles = new DruidaConector();
      
      XMLDocument xmlDoc  = new XMLDocument();
      Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");                    
      Element e_rows = docDestino.createElement("ROWSET");
      e_rows.setAttribute("ID",rowsetID);
      docDestino.getDocumentElement().appendChild(e_rows);
      
      for (int i=0; i < sizeRows; i++){
         Element e_row = docDestino.createElement("ROW");
         e_rows.appendChild(e_row);
  
         Element e_campo0   = docDestino.createElement("CAMPO");
  
         for(int j=0; j < sizeColums; j++){
           if( columns.contains(columsDesc.elementAt(j))){
             Element e_campo2   = docDestino.createElement("CAMPO");
             
             if(j == 0){
                e_campo0.setAttribute("NOMBRE","oculto");
             }else{
                e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
             }
             e_campo2.setAttribute("TIPO","OBJECTO");
             e_campo2.setAttribute("LONGITUD","50");
             Text txt0 = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
             e_campo2.appendChild(txt0);
             e_row.appendChild(e_campo2);
           }
         }
      }
      conectorValoresPosibles.setXML(docDestino.getDocumentElement());
      traza("DruidaConector: " + conectorValoresPosibles.getXML());
      return conectorValoresPosibles;
  }


  private RecordSet agregarBlanco(RecordSet entrada) throws Exception{
      RecordSet rsNuevo = new RecordSet();
      
      if(entrada!=null){
           
           rsNuevo.setColumnIdentifiers(entrada.getColumnIdentifiers());
           
           rsNuevo.addRow(new Object[] {"", " "});
           
        /*   // Borrar
           for(int i=0; i < 1; i++){
                rsNuevo.addRow(entrada.getRow(i));
           } */
           
          /* for(int i=0; i < entrada.getRowCount(); i++){
                rsNuevo.addRow(entrada.getRow(i));
           }*/
      }
      return rsNuevo;
  }

  private void obtenerOrdenAnaqueles() throws Exception{
    String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
    traza("(obtenerOrdenAnaqueles())opcionMenu: " + opcionMenu);

    String accion = conectorParametroLimpia("accion", "", true);
    traza("accion: " + accion);
   
    pagina("contenido_orden_anaquel_insertar");      

    if(opcionMenu.equals("modificar")) {
         traza("............opcion modificar............");
         asignarAtributoPagina("cod", "0959");
    } else if(opcionMenu.equals("consultar")) {
         traza("............opcion consultar............");
         asignarAtributoPagina("cod", "0960");
    } else if(opcionMenu.equals("eliminar")) {
             traza("............opcion eliminar............");
         asignarAtributoPagina("cod", "0961");
    }
    // Validaciones
    getFormatosValidaciones();
    
    asignarAtributo("VAR","accion","valor", accion);  
    asignarAtributo("VAR","opcionMenu","valor", opcionMenu);  
    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));

    rellenarPantalla();

  }

  private void rellenarPantalla() throws Exception{
      cargarCabecera(); 
  }

  private void cargarCabecera() throws Exception{
    traza("Entra a cargarCabecera");
           String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);

           DTOOrdenAnaquelesCabecera dtoOrdAnaqCabec = new DTOOrdenAnaquelesCabecera();
           DTOMapaZonasCabecera      dtoMapaZonCabe  = new DTOMapaZonasCabecera(); 

           String oidMapaZona = conectorParametroLimpia("hOidMapaZonas", "", true);
           String mapaOrdenAnaquel = conectorParametroLimpia("hOidOrdenAnaquel", "", true);
    
    asignarAtributo("VAR","hOidMapaZonas","valor", oidMapaZona);
    asignarAtributo("VAR","hOidOrdenAnaquel","valor", mapaOrdenAnaquel);

           traza("oidMapaZona: " + oidMapaZona);
           traza("mapaOrdenAnaquel: " + mapaOrdenAnaquel);

           dtoMapaZonCabe.setOid(Long.valueOf(oidMapaZona));
           //dtoOrdAnaqCabec.setCodigoMapaOrden(Long.valueOf(mapaOrdenAnaquel)); // eliminado eiraola 03/Jul/2007
           dtoOrdAnaqCabec.setOid(Long.valueOf(mapaOrdenAnaquel));                 // agregado  eiraola 03/Jul/2007

           dtoOrdAnaqCabec.setMapaZonaCabecera(dtoMapaZonCabe);
           dtoOrdAnaqCabec.setOidIdioma(idioma);
           dtoOrdAnaqCabec.setOidPais(pais);

    traza("cargarCabecera, dtoOrdAnaqCabec es: " + dtoOrdAnaqCabec);

           MareBusinessID mareBusinessID = new MareBusinessID("APEObtenerOrdenAnaquelesCabeceraDetalles");
           Vector params = new Vector();		
           params.addElement(dtoOrdAnaqCabec);
      params.addElement(mareBusinessID);

           traza("SCS antes del conector");
           DruidaConector dc  =	conectar("ConectorObtenerOrdenAnaquelesCabeceraDetalles", params);
      traza("SCS despues del conector");
    
      DTOOrdenAnaquelesCabeceraDetalles dtoCabDet = (DTOOrdenAnaquelesCabeceraDetalles)dc.objeto("DTOSalida"); 
      if(opcionMenu.equals("modificar")) {
                traza("............opcion modificar rellenarPantalla()............");
                    //anyadeHiddensI18N(true, "APE_ORDEN_ANAQU_CABEC", Long.valueOf(dtoCabDet.getOid().toString()), new Integer(1), "formulario", "txtDescripcion", true);
      } else if(opcionMenu.equals("consultar")) {
                    traza("............opcion consultar rellenarPantalla()............");
                    //anyadeHiddensI18N(true, "APE_ORDEN_ANAQU_CABEC", Long.valueOf(dtoCabDet.getOid().toString()), new Integer(1), "formulario", "txtDescripcion", true);
      } else if(opcionMenu.equals("eliminar")) {
                traza("............opcion eliminar rellenarPantalla()............");
                    //anyadeHiddensI18N(true, "APE_ORDEN_ANAQU_CABEC", Long.valueOf(dtoCabDet.getOid().toString()), new Integer(1), "formulario", "txtDescripcion", true);
      }
           if (!opcionMenu.equals("insertar")){			
                anyadeHiddensI18N(true, "APE_ORDEN_ANAQU_CABEC", Long.valueOf(dtoCabDet.getOid().toString()), new Integer(1), "formulario", "txtDescripcion", true);
           }
           
           mostrarDatosPGInsertarOrdenAnaqueles(dtoCabDet);

  }

  private void mostrarDatosPGInsertarOrdenAnaqueles(DTOOrdenAnaquelesCabeceraDetalles DTOE) throws Exception{
      traza("Entra a mostrarDatosPGInsertarOrdenAnaqueles(DTOOrdenAnaquelesCabeceraDetalles DTOE)");
      traza("antes de ComposerViewElementList  ");
      String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
      traza("DTOOrdenAnaquelesCabeceraDetalles DTOE: " + DTOE);

           //combo centros de distribucion, obtengo descripciones
      ComposerViewElementList cv = crearParametrosEntradaTotal(DTOE.getSublineaArmado().getLineaArmado().getOid().toString());

      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      traza("SCS antes del conector.ejecucion");
      conector.ejecucion();
      traza("SCS despues del conector");
      DruidaConector resultados = conector.getConector();
  
      traza("resultados: " + resultados.getXML());

      asignar("COMBO","cbCentroDistribucion",resultados,"APEObtenerDescripcionesCD");   
      asignar("COMBO","cbMapaCentroDistribucion",resultados,"APEObtenerMapasCDPorCD");
      asignar("COMBO","cbMapaZonas",resultados,"APEObtenerMapaZonaPorMapaCD");
      asignar("COMBO","cbLineaArmado",resultados,"APEObtenerLineasMapaCD");

      traza("asigne combos!!");

      String oidCentroDistribucion = conectorParametroLimpia("hOidCentroDistribucion", "", true);
      String oidMapaCentroDistribucion = conectorParametroLimpia("hOidMapaCentroDistribucion", "", true);
      String oidMapaZonas = conectorParametroLimpia("hOidMapaZonas", "", true);

      asignarAtributo("VAR","hOidCentroDistribucion","valor", oidCentroDistribucion);
      asignarAtributo("VAR","hOidMapaCentroDistribucion","valor", oidMapaCentroDistribucion);

      asignarAtributo("VAR","hTxtDescripcion","valor", DTOE.getDescOrdenAnaqueles());
      asignarAtributo("VAR","hCbCentroDistribucion","valor", oidCentroDistribucion);
      asignarAtributo("VAR","hOidMapaCentrDistr","valor", oidMapaCentroDistribucion);
      asignarAtributo("VAR","hOidMapaZona","valor", oidMapaZonas);
      asignarAtributo("VAR","hOidLnArmado","valor", DTOE.getSublineaArmado().getLineaArmado().getOid().toString());

           //me guardo el oid (OID_ANAQ_CABE), de la tabla: APE_ORDEN_ANAQU_CABEC, para luego mandar a modificar!!

      asignarAtributo("VAR","oidOrdenAnaqCabecera","valor", DTOE.getOid().toString());
      traza("DTOE.getOid().toString(): " + DTOE.getOid().toString());
      traza("oidOrdenAnaqCabecera: " + conectorParametroLimpia("oidOrdenAnaqCabecera", "", true));        


           traza("SCS2");
           traza("DTOE.getValorDefecto(): " + DTOE.getValorDefecto());

           String ordenPorDef = null;
      if (DTOE.getValorDefecto().booleanValue()){
           ordenPorDef="S";
      }else    {
           ordenPorDef="N";
      }    
           traza("ordenPorDef: " + ordenPorDef);
           asignarAtributo("VAR","hChkOrdenPorDefecto","valor", ordenPorDef);
           asignarAtributo("VAR","hiddenDefault","valor", ordenPorDef); // Agregado eiraola 03/Jul/2007
    
    // Sublineas
    DTOSublineasLineaOrdenacion dtoSublineasLineaOrdenacion = new DTOSublineasLineaOrdenacion();
    
    dtoSublineasLineaOrdenacion.setOidLinea(DTOE.getSublineaArmado().getLineaArmado().getOid());
    dtoSublineasLineaOrdenacion.setOidOrdenAnaquelCab(DTOE.getOid());    
    dtoSublineasLineaOrdenacion.setOidIdioma(idioma);
         
           MareBusinessID mareBusinessID = new MareBusinessID("APEObtenerSublineasLineaOrdenacion");
           Vector params = new Vector();		
           params.addElement(dtoSublineasLineaOrdenacion);
           params.addElement(mareBusinessID);
           
    traza("antes del conector");
    DruidaConector dc1  =        conectar("ConectorObtenerSublineasLineaOrdenacion", params);
    traza("despues del conector");
         
    asignar("LISTADOA", "listado1", dc1 ,"dtoSalida.resultado_ROWSET");  

     // Orden de anaquel default
      DTOOID dtoOOID = new DTOOID();
      dtoOOID.setOid(Long.valueOf(oidMapaZonas));
      dtoOOID.setOidPais(pais);
      dtoOOID.setOidIdioma(idioma);

      traza("voy a: APEObtenerDefaultOrdenAnaqueles, con: " + dtoOOID);

      MareBusinessID mareBusinessID1 = new MareBusinessID("APEObtenerDefaultOrdenAnaqueles");
      Vector params1 = new Vector();             
      params1.addElement(dtoOOID);
      params1.addElement(mareBusinessID1);

      traza("antes del conector..ConectorObtenerDefaultOrdenAnaqueles");
      DruidaConector dc  =      conectar("ConectorObtenerDefaultOrdenAnaqueles", params1);
      traza("despues del conector..ConectorObtenerDefaultOrdenAnaqueles");
      Object obj = (Object)dc.objeto("DTOSalida"); 

      DTOOrdenAnaquelesCabecera dtoDefecto = (DTOOrdenAnaquelesCabecera)dc.objeto("DTOSalida");

      traza("el dtoDefecto, es: " + dtoDefecto);

      if (dtoDefecto.getOid()!=null){
         asignarAtributo("VAR","tengoDefaultOrdenAnaqueles","valor", "S");
         }else{
         asignarAtributo("VAR","tengoDefaultOrdenAnaqueles","valor", "N");
      }

      traza("tengoDefaultOrdenAnaqueles: " + conectorParametroLimpia("tengoDefaultOrdenAnaqueles", "", true).trim());
  }

  private String buscoOidCorrespondienteAValor(Long valorDeCombo, RecordSet recordValoresPosiblesCombo) throws Exception{
           int mide = recordValoresPosiblesCombo.getRowCount();
           Long oid = new Long(0);
           for (int indice = 0; indice < mide; indice++) {
                    String valor = recordValoresPosiblesCombo.getValueAt(indice, 1).toString();

           traza("comparo: " + valor + " con: " + valorDeCombo.toString());

                    if (valor.equals(valorDeCombo.toString())){
                             oid = new Long(valorDeCombo.toString());
                             return oid.toString();
                    }
           }
           return oid.toString();
  }

  private ComposerViewElementList crearParametrosEntradaTotal(String oidLinArm) throws Exception{
      traza("SCS metodo ComposerViewElementList");
      ComposerViewElementList lista = new ComposerViewElementList();

      DTOBelcorp dtoBel = new DTOBelcorp();
      dtoBel.setOidPais(pais);
      dtoBel.setOidIdioma(idioma);

           DTOOID dtoOOID = new DTOOID();
           String oidCentroDistribucion = conectorParametroLimpia("hOidCentroDistribucion", "", true);
           dtoOOID.setOid(Long.valueOf(oidCentroDistribucion));
      dtoOOID.setOidPais(pais);
      dtoOOID.setOidIdioma(idioma);
           
      //centros distr.
      ComposerViewElement descripcionesCD = new ComposerViewElement();
      descripcionesCD.setIDBusiness("APEObtenerDescripcionesCD");
      descripcionesCD.setDTOE(dtoBel);
      lista.addViewElement(descripcionesCD);

           //mapas ctr. distr.
           ComposerViewElement descripcionesMCD = new ComposerViewElement();
           descripcionesMCD.setIDBusiness("APEObtenerMapasCDPorCD");
           descripcionesMCD.setDTOE(dtoOOID);
           lista.addViewElement(descripcionesMCD);

           //mapa zonas 
           String oidMapaCentroDistribucion = conectorParametroLimpia("hOidMapaCentroDistribucion", "", true);
           dtoOOID.setOid(Long.valueOf(oidMapaCentroDistribucion));

           ComposerViewElement descripcionesMZ = new ComposerViewElement();
           descripcionesMZ.setIDBusiness("APEObtenerMapaZonaPorMapaCD");
           descripcionesMZ.setDTOE(dtoOOID);
           lista.addViewElement(descripcionesMZ);

           //lineas armado
           ComposerViewElement descripcionesLA = new ComposerViewElement();
           descripcionesLA.setIDBusiness("APEObtenerLineasMapaCD");
           descripcionesLA.setDTOE(dtoOOID);
           lista.addViewElement(descripcionesLA);
  
      return lista;
  }

  private boolean verificarDefaultOrdenAnaquel() throws Exception {
           traza("*** LPMantenimientoOrdenAnaquel - verificarDefaultOrdenAnaquel - Entrada");
           DTOOID dtoOOID = new DTOOID();
           String oidMapaZona = conectorParametroLimpia("cbMapaZonas", "", true); 
           dtoOOID.setOid(Long.valueOf(oidMapaZona));
    dtoOOID.setOidPais(pais);
    dtoOOID.setOidIdioma(idioma);

      MareBusinessID mareBusinessID = new MareBusinessID("APEObtenerDefaultOrdenAnaqueles");
           Vector params = new Vector();		
           params.addElement(dtoOOID);
      params.addElement(mareBusinessID);
           String ordenPorDef = conectorParametroLimpia("hChkOrdenPorDefecto", "", true);
           traza("--- check ordenPorDefecto: " + ordenPorDef);
           String strOidOrdenAnaqCabecera = conectorParametroLimpia("oidOrdenAnaqCabecera", "", true);
           Long oidOrdenAnaqCabecera = (strOidOrdenAnaqCabecera.equals("")) ? null : new Long(strOidOrdenAnaqCabecera);
           traza("--- oidOrdenAnaqCabecera (solo si es Modificar): " + oidOrdenAnaqCabecera);

           traza("antes del conector");
           DruidaConector dc  =	conectar("ConectorObtenerDefaultOrdenAnaqueles", params);
      traza("despues del conector");

           Object obj = (Object)dc.objeto("DTOSalida"); 

           DTOOrdenAnaquelesCabecera dtoDefecto = (DTOOrdenAnaquelesCabecera)dc.objeto("DTOSalida");

           traza("--- el Orden por Defecto es: " + dtoDefecto.getOid());

           if (dtoDefecto.getOid() == null) { // No hay Orden por defecto
                    traza(" --- No hay Orden por defecto");
                    if (!ordenPorDef.trim().equals("S")) {
                             traza(" --- No hay Orden por defecto.... deberia marcar al actual como Default (ERROR)");
                             /*asignarAtributo("VAR", "cerrarVentana", "valor", "false");
                             asignarAtributo("VAR", "ejecutar", "valor", "noExisteUnOrdenAnaqDefault();");
                             return false;*/
                             return true;
                    } else {
                             traza(" --- No hay Orden por defecto.... pero al actual lo estoy marcando como Default (OK)");
                         return true;
                    }

           } else { // Hay guardado un Orden por defecto
                    traza(" --- Hay un Orden por defecto");
                    if (ordenPorDef.trim().equals("S")) {
                         if (oidOrdenAnaqCabecera != null && !dtoDefecto.getOid().equals(oidOrdenAnaqCabecera)) { // Hay un Orden por defecto pero no es el que estoy modificando
                                      traza(" --- Hay un Orden por defecto pero no es el que estoy modificando");
                                      // Agregado - eiraola 02/Jul/2007 para mensaje parametrizado - Inicio
                                      String descCD = "";
                                      String descMapaCD = "";
                                      String descMapaZona = "";
                                      String descMapaAnaquel = "";
                                      
                                      if (dtoDefecto.getDescOrdenAnaqueles() != null) {
                                                descMapaAnaquel = dtoDefecto.getDescOrdenAnaqueles();
                                      }

                                      if (dtoDefecto.getMapaZonaCabecera() != null) {
                                                Vector descripciones = dtoDefecto.getMapaZonaCabecera().getDescripcionMapaZonas();
                                                
                                                if (descripciones != null && descripciones.size() > 0) {
                                                         DTOI18nSICC dtoDescI18n = (DTOI18nSICC) descripciones.get(0);
                                                         descMapaZona = dtoDescI18n.getValorI18n();
                                                }
                                                
                                                if (dtoDefecto.getMapaZonaCabecera().getMapaCentroDistribucionCabecerea() != null) {
                                                         
                                                         if (dtoDefecto.getMapaZonaCabecera().getMapaCentroDistribucionCabecerea().getDescripcionMapa() != null) {
                                                                  descMapaCD = dtoDefecto.getMapaZonaCabecera().getMapaCentroDistribucionCabecerea().getDescripcionMapa();
                                                         }
                                                         
                                                         if (dtoDefecto.getMapaZonaCabecera().getMapaCentroDistribucionCabecerea().getCentroDistribucion() != null) {
                                                                  descCD = dtoDefecto.getMapaZonaCabecera().getMapaCentroDistribucionCabecerea().getCentroDistribucion().getDescripcion();
                                                         }
                                                }
                                      }
                                      String ejecutar = "yaExisteUnOrdenAnaqPorDef('"+ descCD +"', '"+ descMapaCD +"', '"+ descMapaZona +"', '"+ descMapaAnaquel +"');";
                                      traza(" --- vamos a lanzar mensaje al usuario con: " + ejecutar);
                                      asignarAtributo("VAR", "cerrarVentana", "valor", "false");
                                      asignarAtributo("VAR", "ejecutar", "valor", ejecutar);
                                      traza("*** LPMantenimientoOrdenAnaquel - verificarDefaultOrdenAnaquel - Salida (A)");
                                      return false;
                             } else {
                                      traza(" --- Hay un Orden por defecto y es justamente el que estoy modificando... y que seguira como Default (OK)");
                                  return true;
                             }
                    } else { // (ordenPorDef != "S")
                         if (oidOrdenAnaqCabecera != null && !dtoDefecto.getOid().equals(oidOrdenAnaqCabecera)) {
                                      traza(" --- Hay un Orden por defecto, y al actual (que no es el x default guardado) no lo estoy marcando como Default (OK)");
                                      return true;
                             } else {
                                  traza(" --- Hay un Orden por defecto y es el que estoy modificando... Cuidado! le estoy sacando la marca Default (ALERTA)");
                             return true;
                             }

                    }
           } // fin else (Hay guardado un Orden por defecto)

  }
 
}