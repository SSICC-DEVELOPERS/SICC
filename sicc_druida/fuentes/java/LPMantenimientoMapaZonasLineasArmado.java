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
 * Autor: Viviana Bongiovanni
 */
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

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

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;

import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;
import es.indra.sicc.dtos.ape.DTOMapaCentroDistribucionCabecera;
import es.indra.sicc.dtos.ape.DTOMapaZonasCabecera;
import es.indra.sicc.dtos.ape.DTOMapaZonasDetalle;
import es.indra.sicc.dtos.ape.DTOLineaArmado;
import es.indra.sicc.dtos.ape.DTOSublineaArmado;
import es.indra.sicc.dtos.ape.DTOMapaZonasLineasArmado;
import es.indra.sicc.dtos.ape.DTOMapaZonasDetalleSubLineas;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.ape.DTOCopiarMapaZonas;

public class LPMantenimientoMapaZonasLineasArmado extends LPSICCBase {

    Long pais = null;
    Long idioma = null;
        
    public LPMantenimientoMapaZonasLineasArmado() {	 
        super();
    }

    public void inicio() throws Exception { 
    }

    public void ejecucion() throws Exception {
        try {      
        setTrazaFichero();
        String accion = conectorParametroLimpia("accion", "", true);
        traza("accion: " + accion);
        
        pais = UtilidadesSession.getPais(this);
        idioma = UtilidadesSession.getIdioma(this);
        
        if(accion.equals("")) { 
          this.cargarPantalla();
          
        } else if(accion.equals("guardar")){ 
          this.guardar(); 
          
        } else if(accion.equals("modificar")|| accion.equals("detalle") || accion.equals("detalleEliminar")){ 
          this.mostrarDetalle(); 
          
        } else if(accion.equals("eliminar")){ 
          this.eliminarMapZona(); 
          
        } else if(accion.equals("copiar")){ 
          this.copiarMapa (); 
        }
        
      } catch (Exception e){   
          traza(e);      
          this.lanzarPaginaError(e);
      }
      getConfiguracionMenu();
    }
    
    
  private void copiarMapa() throws Exception{
      pagina("salidaGenerica");
      
      try {      
          anyadeHiddensI18N(false, "APE_MAPA_ZONA_CABEC", null, new Integer(1),
                            "formulario", "txtDescripcionMapaDestino", false);
    
          String cbCentroDistribucion = conectorParametroLimpia("cbCentroDistribucion", "", true);    
          String cbMapaZonasOrigen = conectorParametroLimpia("cbMapaZonasOrigen", "", true);
          String cbMapaCentroDistDestino = conectorParametroLimpia("cbMapaCentroDistDestino", "", true);
          String txtDescripcionMapaDestino = conectorParametroLimpia("txtDescripcionMapaDestino", "", true);
          String cbLineas = conectorParametroLimpia("cbLinea", "", true);
       
          String descMapaCD = conectorParametroLimpia("hDescMapaCD", "", true);  
          
         
          DTOMapaZonasCabecera dtoMapaZonasCabeceraOrigen = new DTOMapaZonasCabecera();      
          dtoMapaZonasCabeceraOrigen.setOid(Long.valueOf(cbMapaZonasOrigen));
          
          DTOLineaArmado dtoLineaArmado = new DTOLineaArmado();
          dtoLineaArmado.setOid(Long.valueOf(cbLineas));
          
          DTOSublineaArmado dtoSublineaArmado = new DTOSublineaArmado();
          dtoSublineaArmado.setLineaArmado(dtoLineaArmado);
          
          DTOMapaZonasDetalle dtoMapaZonasDetalleOrigen = new DTOMapaZonasDetalle();
          dtoMapaZonasDetalleOrigen.setMapaZonaCabecera(dtoMapaZonasCabeceraOrigen);
          dtoMapaZonasDetalleOrigen.setSublineaArmado(dtoSublineaArmado);  
          
          DTOMapaCentroDistribucionCabecera dtoMapaCentroDistribucionCabecera = new DTOMapaCentroDistribucionCabecera();      
          dtoMapaCentroDistribucionCabecera.setOid(Long.valueOf(cbMapaCentroDistDestino));
          dtoMapaCentroDistribucionCabecera.setDescripcionMapa(descMapaCD);
          
          DTOMapaZonasCabecera dtoMapaZonasCabeceraDestino = new DTOMapaZonasCabecera();      
          dtoMapaZonasCabeceraDestino.setOid(null);
          dtoMapaZonasCabeceraDestino.setCodigoMapaZonas(null);
          
          traza("Traduccciones: "+ recuperaTraduccionesI18N(new Integer(1)));
          dtoMapaZonasCabeceraDestino.setDescripcionMapaZonas(recuperaTraduccionesI18N(new Integer(1)));
          
          dtoMapaZonasCabeceraDestino.setValorDefecto(Boolean.FALSE);
          dtoMapaZonasCabeceraDestino.setMapaCentroDistribucionCabecerea(dtoMapaCentroDistribucionCabecera);
          dtoMapaZonasCabeceraDestino.setOidPais(pais);
          dtoMapaZonasCabeceraDestino.setOidIdioma(idioma);    
          
          DTOCopiarMapaZonas dtoCopiarMapaZonas = new DTOCopiarMapaZonas();
          dtoCopiarMapaZonas.setMapaZonasCabecera(dtoMapaZonasCabeceraDestino);
          dtoCopiarMapaZonas.setMapaZonasDetalle(dtoMapaZonasDetalleOrigen);
          
          traza("copiar: " + dtoCopiarMapaZonas);
          
          MareBusinessID id = new MareBusinessID("APECopiarMapaZonasLineasArmado");            
          Vector paramEntrada = new Vector();
        
          paramEntrada.add(dtoCopiarMapaZonas);
          paramEntrada.add(id);
          traza("*************** Antes de conectar");
          DruidaConector con = conectar("ConectorCopiarMapaZonasLineasArmado", paramEntrada);
          traza("*************** Despues de conectar");
              
          asignarAtributo("VAR", "ejecutar", "valor", "ejecutarOK();");
          
      } catch(Exception e) {
        traza("Excepcion: " + e);
        asignarAtributo("VAR", "ejecutarError", "valor", "focalizaCD();");
        throw e;
      }
  }


  private void eliminarMapZona() throws Exception{
  
      pagina("salidaGenerica");
 
      try {          
          String oidMapa = conectorParametroLimpia("cbMapaZonas", "", true); 
          
          StringTokenizer stkOidMapa = new StringTokenizer(oidMapa,"|");          
          oidMapa = stkOidMapa.nextToken();
          
          DTOOID dtoOid = new DTOOID();
          dtoOid.setOid(Long.valueOf(oidMapa));
          dtoOid.setOidIdioma(idioma);
          
          traza("DTOOID: " + dtoOid);
          
          MareBusinessID id = new MareBusinessID("APEEliminarMapaZonas");            
          Vector paramEntrada = new Vector();
        
          paramEntrada.add(dtoOid);
          paramEntrada.add(id);
          traza("*************** Antes de conectar");
          DruidaConector con = conectar("ConectorEliminarMapaZonas", paramEntrada);
          traza("*************** Despues de conectar");
          
          asignarAtributo("VAR", "ejecutar", "valor", "fLimpiar();");
          
      } catch(Exception e) {
        traza("Excepcion: " + e);
        asignarAtributo("VAR", "ejecutarError", "valor", "focalizaCD();");
        throw e;
      }
  }


  private void mostrarDetalle() throws Exception{
  
    String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
    traza("opcionMenu: " + opcionMenu);

    String accion = conectorParametroLimpia("accion", "", true);
    traza("accion: " + accion);
    
    String oidMapaZona = conectorParametroLimpia("oidMapaZona", "", true);
   
    pagina("contenido_mapa_zonas_lineas_armado_insertar");      
    
    // Titulo de la pagina
    if(opcionMenu.equals("modificar")) {
      asignarAtributoPagina("cod", "0951");
      
      anyadeHiddensI18N(true, "APE_MAPA_ZONA_CABEC", Long.valueOf(oidMapaZona), new Integer(1),
                          "formulario", "txtMapaZonas", false);
                          
    } else if(opcionMenu.equals("consultar") && accion.equals("detalle")) {
      asignarAtributoPagina("cod", "0952");
      
      anyadeHiddensI18N(true, "APE_MAPA_ZONA_CABEC", Long.valueOf(oidMapaZona), new Integer(1),
                          "formulario", "txtMapaZonas", true);
                          
    } else if(opcionMenu.equals("consultar") && accion.equals("detalleEliminar")) {
      asignarAtributoPagina("cod", "0953");
      
      anyadeHiddensI18N(true, "APE_MAPA_ZONA_CABEC", Long.valueOf(oidMapaZona), new Integer(1),
                          "formulario", "txtMapaZonas", true);
    }
    
    // Validaciones
    getFormatosValidaciones();
    
    asignarAtributo("VAR","opcionMenu","valor", opcionMenu);  
    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));
    
    rellenarPantalla();
    
  }
  
  private void rellenarPantalla() throws Exception{
      cargarCabecera(); 
      cargarDetalle();
  }
  
  private void cargarCabecera() throws Exception{
      traza("Entra a cargarCabecera");
      String oidMapaZona = conectorParametroLimpia("oidMapaZona", "", true);
      
      // Valores de defecto
      DTOOID dtoe = new DTOOID();      
      dtoe.setOidPais(pais);
      dtoe.setOidIdioma(idioma);
      dtoe.setOid(Long.valueOf(oidMapaZona));
        
      MareBusinessID mareBusinessID = new MareBusinessID("APEObtenerMapaZonasCabecera");
      Vector params = new Vector();		
      params.addElement(dtoe);
      params.addElement(mareBusinessID);
   
      traza("antes del conector");
      DruidaConector dc  =	conectar("ConectorObtenerMapaZonasCabecera", params);
      traza("despues del conector");
      
      DTOSalida dtoSalida = (DTOSalida)dc.objeto("DTOSalida");       
      RecordSet rs = dtoSalida.getResultado();
      
      String comboCD = ((BigDecimal)rs.getValueAt(0,"CCDI_OID_CONF_CENT_DIST")).toString() + 
                        "," + rs.getValueAt(0,"DESC_CONFCEN");
                        
      String comboMapCen = ((BigDecimal)rs.getValueAt(0,"MCDC_OID_MAPA_CENT_DIST_CABE")).toString() + 
                        "," + rs.getValueAt(0,"DESC_MAPCEN");                        
      
      asignarAtributo("VAR","oidMapaZona","valor", oidMapaZona);  
      asignarAtributo("VAR","cbCentroDistribucion_detalle","valor", comboCD);  
      asignarAtributo("VAR","cbMapaCentroDistribucion_detalle","valor", comboMapCen);  
      asignarAtributo("VAR","txtMapaZonas_detalle","valor", (String)rs.getValueAt(0,"DESC_MAPZONA"));  
      asignarAtributo("VAR","chkValorDefecto_detalle","valor", (String)rs.getValueAt(0,"VAL_DEFE"));  
  }
  
  private void cargarDetalle() throws Exception{
      traza("Entra a cargarDetalle");
  
      String oidMapaZona = conectorParametroLimpia("oidMapaZona", "", true);
      
      traza("idioma: " + idioma);
      
      // Valores de defecto
      DTOOID dtoe = new DTOOID();      
      dtoe.setOidPais(pais);
      dtoe.setOidIdioma(idioma);
      dtoe.setOid(Long.valueOf(oidMapaZona));
        
      MareBusinessID mareBusinessID = new MareBusinessID("APEObtenerMapaZonasDetalle");
      Vector params = new Vector();		
      params.addElement(dtoe);
      params.addElement(mareBusinessID);
   
      traza("antes del conector");
      DruidaConector dc  =	conectar("ConectorObtenerMapaZonasDetalle", params);
      traza("despues del conector");
      
      DTOMapaZonasDetalleSubLineas dtoSalida = (DTOMapaZonasDetalleSubLineas)dc.objeto("DTOSalida"); 
      
      // Obtiene los detalles
      RecordSet rsDetalle = dtoSalida.getMapaZonasDetalle();
      
      // Arma el combo Linea
      String comboLin = ((BigDecimal)rsDetalle.getValueAt(0,"LIAR_OID_LINE_ARMA")).toString() + 
                        "," + rsDetalle.getValueAt(0,"DESC_LIN");
    
      asignarAtributo("VAR","cbLineas_detalle","valor", comboLin);  
      
      //Asigna el combo subLineas
      RecordSet rsSubLineas = agregarBlanco(dtoSalida.getSubLineas());
      traza("rsSubLineas: " + rsSubLineas);
      asignar("COMBO","comboSubLinea",generarConector("ROWSET", rsSubLineas, (Vector)rsSubLineas.getColumnIdentifiers()),"ROWSET");  
      
      // Armo Detalle
      RecordSet rs = new RecordSet();         
      rs.addColumn("oid");
      rs.addColumn("oidSubLinea");
      rs.addColumn("zona");
      rs.addColumn("bahiaIni");
      rs.addColumn("bahiaFin");	
      rs.addColumn("oidDetalle");
      
      int cant = rsDetalle.getRowCount();
      
      for(int i=0; i<cant; i++){
        rs.addRow(new Object[] {
            Integer.toString(i), 
            ((BigDecimal)rsDetalle.getValueAt(i,"SBAR_OID_SUBL_ARMA")).toString(),
            ((BigDecimal)rsDetalle.getValueAt(i,"NUM_IDZO")).toString(),
            ((BigDecimal)rsDetalle.getValueAt(i,"NUM_BAHI_DESD")).toString(),
            ((BigDecimal)rsDetalle.getValueAt(i,"NUM_BAHI_HAST")).toString(),
            ((BigDecimal)rsDetalle.getValueAt(i,"OID_MAPA_ZONA_DETA")).toString()}); 
      }
      
      asignar("LISTADOA", "listado1", generarConector("ROWSET", rs, (Vector)rs.getColumnIdentifiers()),"ROWSET");      
  }
  
  
  private RecordSet agregarBlanco(RecordSet entrada) throws Exception{
      RecordSet rsNuevo = new RecordSet();
      
      if(entrada!=null){
          
          rsNuevo.setColumnIdentifiers(entrada.getColumnIdentifiers());
          
          rsNuevo.addRow(new Object[] {"", ""});
          
          for(int i=0; i < entrada.getRowCount(); i++){
              rsNuevo.addRow(entrada.getRow(i));
          }
      }
      return rsNuevo;
  }
  
  

  private void guardar() throws Exception{
      pagina("salidaGenerica");
      
      String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);      
      String ejecutarOK = null;
      String ejecutarError = null;
      
      if(opcionMenu.equals("insertar")) {           
          ejecutarOK = "fLimpiar();";
          ejecutarError = "focalizaCD();";
      } else if(opcionMenu.equals("modificar")) { 
          ejecutarOK = "cerrarModal();";
          ejecutarError = "focalizaChkValorDefecto();";
      }
      
      try {          
      
          anyadeHiddensI18N(false, "APE_MAPA_ZONA_CABEC", null, new Integer(1),
                            "formulario", "txtMapaZonas", false);
      
          String oidMapa = conectorParametroLimpia("oidMapaZona", "", true); 
          String cbCentroDistribucion = conectorParametroLimpia("cbCentroDistribucion", "", true);    
          String cbMapaCentroDistribucion = conectorParametroLimpia("cbMapaCentroDistribucion", "", true);
          String chkValorDefecto = conectorParametroLimpia("ChkValorDefecto", "", true);
          String txtMapaZonas = conectorParametroLimpia("txtMapaZonas", "", true);
          String cbLineas = conectorParametroLimpia("cbLineas", "", true);
          
          String descCD = conectorParametroLimpia("hDescCD", "", true);    
          String descMapaCD = conectorParametroLimpia("hDescMapaCD", "", true);  
          
          String listaDetalles = conectorParametroLimpia("listaDetalles", "", true);
          String detallesEliminados = conectorParametroLimpia("hDetallesEliminados", "", true);
          
          DTOMapaZonasLineasArmado dtoMapaZonasLineasArmado = new DTOMapaZonasLineasArmado();
          ArrayList detalles= new ArrayList();
          
          traza("Cabecera");
          
          // Arma la cabecera
          DTOMapaCentroDistribucionCabecera dtoMapaCentroDistribucionCabecera = new DTOMapaCentroDistribucionCabecera();      
          dtoMapaCentroDistribucionCabecera.setOid(Long.valueOf(cbMapaCentroDistribucion));
          dtoMapaCentroDistribucionCabecera.setDescripcionMapa(descMapaCD);
                
          DTOConfiguracionCentroDistribucion dtoConfiguracionCentroDistribucion = new DTOConfiguracionCentroDistribucion();
          dtoConfiguracionCentroDistribucion.setDescripcion(descCD);
          
          dtoMapaCentroDistribucionCabecera.setCentroDistribucion(dtoConfiguracionCentroDistribucion);
     
          DTOMapaZonasCabecera dtoMapaZonasCabecera = new DTOMapaZonasCabecera();      
          dtoMapaZonasCabecera.setOid(oidMapa.equals("")?null:Long.valueOf(oidMapa));
          dtoMapaZonasCabecera.setCodigoMapaZonas(null);
          
          traza("Traduccciones: "+ recuperaTraduccionesI18N(new Integer(1)));
          dtoMapaZonasCabecera.setDescripcionMapaZonas(recuperaTraduccionesI18N(new Integer(1)));
          
          dtoMapaZonasCabecera.setValorDefecto(chkValorDefecto.equals("S")?Boolean.TRUE:Boolean.FALSE);
          dtoMapaZonasCabecera.setMapaCentroDistribucionCabecerea(dtoMapaCentroDistribucionCabecera);
          dtoMapaZonasCabecera.setOidPais(pais);
          dtoMapaZonasCabecera.setOidIdioma(idioma);
          
          DTOLineaArmado dtoLineaArmado = new DTOLineaArmado();
          dtoLineaArmado.setOid(Long.valueOf(cbLineas));
          
          traza("Detalle");
          // Arma el detalle
          if(!listaDetalles.equals("")) {
              
            StringTokenizer stkListaDetalles = new StringTokenizer(listaDetalles,"|");
            StringTokenizer stkRegDetalle = null;
            DTOSublineaArmado dtoSublineaArmado = null;
            DTOMapaZonasDetalle dtoMapaZonasDetalle = null;
            String oidSublinea = null;
            String zona = null;
            String bahiaIni = null;
            String bahiaFin = null;
            String oidDetalle = null;  
                    
            while (stkListaDetalles.hasMoreTokens()) {
              stkRegDetalle = new StringTokenizer(stkListaDetalles.nextToken(),"#");
              dtoSublineaArmado = new DTOSublineaArmado();
              dtoMapaZonasDetalle = new DTOMapaZonasDetalle();
                           
              oidSublinea = stkRegDetalle.nextToken();
              dtoSublineaArmado.setOid(Long.valueOf(oidSublinea));
              dtoSublineaArmado.setLineaArmado(dtoLineaArmado);
              
              zona = stkRegDetalle.nextToken();
              dtoMapaZonasDetalle.setOidZona(Long.valueOf(zona));
             
              bahiaIni = stkRegDetalle.nextToken();
              dtoMapaZonasDetalle.setBahiaDesde(Long.valueOf(bahiaIni));
            
              bahiaFin = stkRegDetalle.nextToken();
              dtoMapaZonasDetalle.setBahiaHasta(Long.valueOf(bahiaFin));
             
              oidDetalle = stkRegDetalle.nextToken();
              dtoMapaZonasDetalle.setOid(oidDetalle.equals("BLANCO")?null:Long.valueOf(oidDetalle));
             
              dtoMapaZonasDetalle.setMapaZonaCabecera(dtoMapaZonasCabecera);
              dtoMapaZonasDetalle.setSublineaArmado(dtoSublineaArmado);   
                          
              detalles.add(dtoMapaZonasDetalle);
            }
          }          
          traza("detalles: " + detalles);
          
          // Guardar
          if(opcionMenu.equals("insertar")) { 
              traza("insertar");
              
              dtoMapaZonasLineasArmado.setMapaZonasCabecera(dtoMapaZonasCabecera);
              dtoMapaZonasLineasArmado.setMapaZonasDetalles(detalles);
              
              MareBusinessID id = new MareBusinessID("APEInsertarMapaZonasLineasArmado");            
              Vector paramEntrada = new Vector();
            
              paramEntrada.add(dtoMapaZonasLineasArmado);
              paramEntrada.add(id);
              traza("*************** Antes de conectar");
              DruidaConector con = conectar("ConectorInsertarMapaZonasLineasArmado", paramEntrada);
              traza("*************** Despues de conectar");
              
          } else if(opcionMenu.equals("modificar")) { 
              traza("modificar");
              
              dtoMapaZonasLineasArmado.setMapaZonasCabecera(dtoMapaZonasCabecera);
              dtoMapaZonasLineasArmado.setMapaZonasDetalles(detalles);
              dtoMapaZonasLineasArmado.setDetallesEliminados(armarDetallesEliminados(detallesEliminados));
              
              MareBusinessID id = new MareBusinessID("APEModificarMapaZonasLineasArmado");            
              Vector paramEntrada = new Vector();
            
              paramEntrada.add(dtoMapaZonasLineasArmado);
              paramEntrada.add(id);
              traza("*************** Antes de conectar");
              DruidaConector con = conectar("ConectorModificarMapaZonasLineasArmado", paramEntrada);
              traza("*************** Despues de conectar");
          }
          
          asignarAtributo("VAR", "ejecutar", "valor", ejecutarOK);
          
      } catch(Exception e) {
        traza("Excepcion: " + e);
        asignarAtributo("VAR", "ejecutarError", "valor", ejecutarError);
        throw e;
      }
  }
  
  private DTOOIDs armarDetallesEliminados(String detallesEliminados) throws Exception{
  
      DTOOIDs oidsDetallesEliminados = null;
      traza("detallesEliminados: " + detallesEliminados);
      
      if(!detallesEliminados.equals("")){
          oidsDetallesEliminados = new DTOOIDs();
          StringTokenizer stkDetallesEliminados = new StringTokenizer(detallesEliminados,",");
          
          Long[] oids = new Long[stkDetallesEliminados.countTokens()];
          int k = 0;
          
          while (stkDetallesEliminados.hasMoreTokens()) {
            oids[k] = Long.valueOf(stkDetallesEliminados.nextToken());
            k++;
          }  
          
          oidsDetallesEliminados.setOids(oids);          
      }
      
      return oidsDetallesEliminados;
  }
    
  private void cargarPantalla() throws Exception{

    String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
    traza("opcionMenu: " + opcionMenu);
    
    if(opcionMenu.equals("insertar")) {
      pagina("contenido_mapa_zonas_lineas_armado_insertar");      
      asignarAtributoPagina("cod", "0950");
      
      anyadeHiddensI18N(true, "APE_MAPA_ZONA_CABEC", null, new Integer(1),
                          "formulario", "txtMapaZonas", false);
      
    } else if(opcionMenu.equals("copiar")) {
        pagina("contenido_mapa_zonas_lineas_armado_copiar");      
        asignarAtributoPagina("cod", "3115");   
        
        anyadeHiddensI18N(true, "APE_MAPA_ZONA_CABEC", null, new Integer(1),
                          "formulario", "txtDescripcionMapaDestino", false);
         
            
    } else {
      pagina("contenido_mapa_zonas_lineas_armado_modificar");
      
      // Titulo de la pagina
      if(opcionMenu.equals("insertar")) {
        asignarAtributoPagina("cod", "0950");
                          
      } else if(opcionMenu.equals("modificar")) {
        asignarAtributoPagina("cod", "0951");    
                          
      } else if(opcionMenu.equals("consultar")) {
        asignarAtributoPagina("cod", "0952");
        
      } else if(opcionMenu.equals("eliminar")) {
        asignarAtributoPagina("cod", "0953");
      }
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
    traza("antes del conector.ejecucion");
    conector.ejecucion();
    traza("despues del conector");
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
 
    traza("antes del conector");
		DruidaConector dc  =	conectar("ConectorObtenerValoresDefecto", params);
    traza("despues del conector");
    
    DTOSalida dtoSalida = (DTOSalida)dc.objeto("DTOSalida"); 
    
    asignarAtributo("VAR", "hCbCentroDistribucion", "valor", obtenerCDDef(dtoSalida));
    asignarAtributo("VAR", "hCbLineasCDDef", "valor", aplanarLineasCDDef(dtoSalida));
  }
  
  private String aplanarLineasCDDef(DTOSalida dtoSalida) throws Exception{ 
    traza("entro a aplanarLineasCDDef");
    RecordSet valoresDef = dtoSalida.getResultado();
    String lineasCDDef = "";
    int cant = valoresDef.getRowCount();
        
    for(int i=0; i<cant; i++){      
      if(((String)(valoresDef.getValueAt(i,"COMBO"))).equals(ConstantesAPE.LINEA_ARMADO)){
          lineasCDDef = lineasCDDef + "," + ((BigDecimal)valoresDef.getValueAt(i,"OID")).toString();
      }
    }   
    
    if(!lineasCDDef.equals("")){
        return lineasCDDef.substring(1);
    } else {
        traza("No hay linea por defecto");
        return "";
    }
  }
  
  private String obtenerCDDef(DTOSalida dtoSalida) throws Exception{
    RecordSet valoresDef = dtoSalida.getResultado();
    String CDDef = "";
    int cant = valoresDef.getRowCount();
    
    for(int i=0; i<cant; i++){      
      if(((String)(valoresDef.getValueAt(i,"COMBO"))).equals(ConstantesAPE.CONFIGURACION_CD)){
         traza("CDDef :" + valoresDef.getValueAt(i,"OID"));
         return ((BigDecimal)valoresDef.getValueAt(i,"OID")).toString();
      }
    }   
    traza("No hay CD por defecto");
    return "";
  }
    
  private ComposerViewElementList crearParametrosEntrada() throws Exception{
      traza("metodo ComposerViewElementList");
      ComposerViewElementList lista = new ComposerViewElementList();
      //combo codigo configuracion
      ComposerViewElement descripcionesCD = new ComposerViewElement();
  
      DTOBelcorp dtoBel = new DTOBelcorp();
      traza("antes de asignar al dtobelcorp");
      dtoBel.setOidPais(pais);
      dtoBel.setOidIdioma(idioma);
          
      descripcionesCD.setIDBusiness("APEObtenerDescripcionesCD");
      descripcionesCD.setDTOE(dtoBel);
          
      lista.addViewElement(descripcionesCD);
      
      return lista;
    }
    
    private DruidaConector generarConector(String rowsetID, RecordSet datos, Vector columns) throws DOMException, Exception{
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
      return conectorValoresPosibles;
	}
}
