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
/*
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
import es.indra.sicc.dtos.ape.DTOMapaZonasDetalleSubLineas;*/
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.ape.DTOComprobarAlarmas;
import es.indra.sicc.dtos.ape.DTOErrorValoresCubicaje;
import es.indra.sicc.util.DTOColeccion;

public class LPAlarmas extends LPSICCBase {

    Long pais = null;
    Long idioma = null;
         
    public LPAlarmas() {      
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
           
         } else if(accion.equals("comprobarProductos")){ 
           this.comprobarProductos(); 
           
         } else if(accion.equals("comprobarValoresCubicaje")){ 
           this.comprobarValoresCubicaje(); 
         } 
         
      } catch (Exception e){   
           traza(e);      
           this.lanzarPaginaError(e);
      }
      getConfiguracionMenu();
  }
    
  
  private void comprobarValoresCubicaje() throws Exception{
  
      pagina("salidaGenerica");
 
      try {           
           String cbCentroDistribucion = conectorParametroLimpia("cbCentroDistribucion", "", true);    
           String cbLineas = conectorParametroLimpia("cbLineas", "", true);
           
           String descCD = conectorParametroLimpia("hDescCD", "", true);    
           String descLinea = conectorParametroLimpia("hDescLinea", "", true);   
           
           DTOComprobarAlarmas dtoComprobarAlarmas = new DTOComprobarAlarmas();
           dtoComprobarAlarmas.setOidCentroDistribucion(Long.valueOf(cbCentroDistribucion));
           dtoComprobarAlarmas.setOidLineaArmado(cbLineas.equals("")?null:Long.valueOf(cbLineas));
           dtoComprobarAlarmas.setDescripcionCD(descCD);
           dtoComprobarAlarmas.setDescripcionLinea(descLinea);
           dtoComprobarAlarmas.setOidIdioma(idioma);
           dtoComprobarAlarmas.setOidPais(pais);
           
           MareBusinessID id = new MareBusinessID("APEComprobarAlarmasValoresCubicaje");             
           Vector paramEntrada = new Vector();
         
           paramEntrada.add(dtoComprobarAlarmas);
           paramEntrada.add(id);
           traza("*************** Antes de conectar");
           DruidaConector con = conectar("ConectorComprobarAlarmasValoresCubicaje", paramEntrada);
           traza("*************** Despues de conectar");
           
           DTOColeccion dtoColeccion = (DTOColeccion)con.objeto("DTOColeccion");            
           ArrayList listaErrores = dtoColeccion.getLista();
           
           int cantErrores = listaErrores.size();
           StringBuffer listaErroresPlana = new StringBuffer();
           DTOErrorValoresCubicaje dtoErrorValoresCubicaje = null;
           
           for(int i=0; i<cantErrores; i++){
              dtoErrorValoresCubicaje = (DTOErrorValoresCubicaje)listaErrores.get(i);
              listaErroresPlana.append("|");
              listaErroresPlana.append(dtoErrorValoresCubicaje.getDescripcionLinea()==null?"BLANCO":dtoErrorValoresCubicaje.getDescripcionLinea());              
              listaErroresPlana.append("#");
              listaErroresPlana.append(dtoErrorValoresCubicaje.getInformacionRegistroProblemas()==null?"BLANCO":dtoErrorValoresCubicaje.getInformacionRegistroProblemas());              
              listaErroresPlana.append("#");
              listaErroresPlana.append(dtoErrorValoresCubicaje.getError());            
           }
           
           traza("listaErroresPlana: " + listaErroresPlana.toString());

		   if(listaErroresPlana.toString().length()>0) {
				asignarAtributo("VAR", "ejecutar", "valor", "llenarListaErrores('" + listaErroresPlana.toString().substring(1) + "');");
		   }
		   else {
			    listaErroresPlana.append("null");
				asignarAtributo("VAR", "ejecutar", "valor", "llenarListaErrores('" + listaErroresPlana.toString() + "');");
		   }
           
           
           
      } catch(Exception e) {
         traza("Excepcion: " + e);
         asignarAtributo("VAR", "ejecutarError", "valor", "focalizaCD();");
         throw e;
      }
  }
    
  private void comprobarProductos() throws Exception{  
      pagina("salidaGenerica");
 
      try {           
           String cbCentroDistribucion = conectorParametroLimpia("cbCentroDistribucion", "", true);   
           String descCD = conectorParametroLimpia("hDescCD", "", true);   
           String cbPeriodo = conectorParametroLimpia("cbPeriodo", "", true);

           traza("*************** cbCentroDistribucion " + cbCentroDistribucion);
           traza("*************** descCD " + descCD);
           
           DTOComprobarAlarmas dtoComprobarAlarmas = new DTOComprobarAlarmas();
           dtoComprobarAlarmas.setOidCentroDistribucion(Long.valueOf(cbCentroDistribucion));
           dtoComprobarAlarmas.setDescripcionCD(descCD);
           dtoComprobarAlarmas.setOidIdioma(idioma);
           dtoComprobarAlarmas.setOidPeriodo(Long.valueOf(cbPeriodo));
           
           MareBusinessID id = new MareBusinessID("APEComprobarAlarmasRelativasAProductos");             
           Vector paramEntrada = new Vector();
           
           traza("dtoComprobarAlarmas: " + dtoComprobarAlarmas);
         
           paramEntrada.add(dtoComprobarAlarmas);
           paramEntrada.add(id);
           traza("*************** Antes de conectar");
           DruidaConector con = conectar("ConectorComprobarAlarmasRelativasAProductos", paramEntrada);
           traza("*************** Despues de conectar");
           
           asignarAtributo("VAR", "ejecutar", "valor", "fLimpiar();");
           
      } catch(Exception e) {
         traza("Excepcion: " + e);
         asignarAtributo("VAR", "ejecutarError", "valor", "focalizaCD();");
         throw e;
      }
  }

 private void cargarPantalla() throws Exception{

    String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
    traza("opcionMenu: " + opcionMenu);
    
    if(opcionMenu.equals("alarmasRelativasAProductos")) {
      pagina("contenido_relativas_productos_alarmas");      
      asignarAtributoPagina("cod", "0604");
      
      this.cargarCombosARProductos();
      
    } else if(opcionMenu.equals("alarmaValoresCubicaje")) {
       pagina("contenido_valores_cubicaje_alarma");      
       asignarAtributoPagina("cod", "0603");    
       
       this.cargarCombos();
    } 
    // Validaciones
    getFormatosValidaciones();
    
    asignarAtributo("VAR","opcionMenu","valor", opcionMenu);  
    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));
  }
  
  private void cargarCombosARProductos() throws Exception{
  
    traza("antes de ComposerViewElementList  ");
    ComposerViewElementList cv = crearParametrosEntrada1();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    traza("antes del conector.ejecucion");
    conector.ejecucion();
    traza("despues del conector");
    DruidaConector resultados = conector.getConector();
  
    traza(resultados.getXML());
         
    asignar("COMBO","cbCentroDistribucion",resultados,"APEObtenerDescripcionesCD");   
    asignar("COMBO","cbMarca",resultados,"SEGObtenerMarcasSinFiltro");   
    asignar("COMBO","cbCanal",resultados,"SEGObtenerCanalesSinFiltro");   
    
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
    
  private ComposerViewElementList crearParametrosEntrada1() throws Exception{
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
      
      //Combo Marcas
      ComposerViewElement marcas = new ComposerViewElement();
          
      marcas.setIDBusiness("SEGObtenerMarcasSinFiltro");
      marcas.setDTOE(dtoBel);
          
      lista.addViewElement(marcas);
      
      //Combo Canales
      ComposerViewElement canales = new ComposerViewElement();
          
      canales.setIDBusiness("SEGObtenerCanalesSinFiltro");
      canales.setDTOE(dtoBel);
          
      lista.addViewElement(canales);
      
      return lista;
    }
      
}
