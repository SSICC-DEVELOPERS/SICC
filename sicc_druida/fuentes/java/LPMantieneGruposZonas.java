/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 3523/09/2004
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
**/

/*
*
* @author  enozigli
*
*/

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import es.indra.mare.common.mgu.manager.Property;

import es.indra.sicc.dtos.cra.DTOCargarPaisMarcaCanal;
import es.indra.sicc.dtos.cra.DTOEntradaConsultarGruposZonas;
import es.indra.sicc.dtos.cra.DTOCabecerasGruposZonas;
import es.indra.sicc.dtos.cra.DTODetallesGruposZonas;
import es.indra.sicc.dtos.cra.DTOGruposZonas;
import es.indra.sicc.dtos.cra.DTORegionesZonas;
import es.indra.sicc.dtos.cra.DTOZonas;
import es.indra.sicc.dtos.cra.DTOEntradaCalendario;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cra.*;
import es.indra.sicc.dtos.zon.*;
import es.indra.sicc.util.*;
import java.util.HashMap.*;
import java.util.*;
import java.math.*;
import es.indra.sicc.util.xml.XMLDocument;
//import LPSICCBase;


public class LPMantieneGruposZonas extends LPSICCBase {

  private String pais;
  private Long idiomaUsuario;
  private String accion;
  private String casoDeUso;


  private final String GRUPOS_ZONAS = "GruposZonas";
  private final String GRUPO_ASIGNAR = "GrupoAsignar";
  private final String GRUPO_MODIFICAR = "GrupoModificar";
  HashMap hmTiposFact = null;
  
  public LPMantieneGruposZonas(){
    super();
  }
  
  public void inicio() throws Exception{	   
  }//inicio()

  public void ejecucion() throws Exception{
  
    Long oidGrupoZona = null;
    Long oidMarca = null;
    Long oidCanal = null;
	
    //this.rastreo();
    setTrazaFichero();	

    traza("ejec1");
    accion = (String)conectorParametro("accion");    
    casoDeUso = (String)conectorParametroSesion("casoDeUso");
    conectorParametroSesion("casoDeUso",casoDeUso);
        
    try{
      traza("ejec2");      
	  this.pais = (UtilidadesSession.getPais(this).toString() == null) ? "" : UtilidadesSession.getPais(this).toString();
	  this.idiomaUsuario = UtilidadesSession.getIdioma(this);

	  traza("pais g: " + pais);
	  traza("Accion: " + accion);
      traza("casoDeUso: " + casoDeUso);
        traza("ejec3");
        if (accion.equals("")){
        } else if (accion.equals("muestraConsulta")){   
            muestraBuscar(); 
        } else if (accion.equals("muestraBorrado")){
            muestraBuscar();
        } else if (accion.equals("muestraModificacion")){
            muestraBuscar();
        } else if (accion.equals("muestraInsercion")){
            muestraInsertar();
        } else if (accion.equals("consultar")){
            consulta(); //ARBOL
            //consultar(pais,conectorParametro("cbMarcas"),new String("1")); //ARBOLISTA
        } else if (accion.equals("guardar")){
            guarda();
        } else if (accion.equals("eliminar")){
            elimina();
        } else if (accion.equals("asignarZonas")){
            asignaZonas();
        } else if (accion.equals("aceptaZonas")){
            aceptaZonas();
        } else if (accion.equals("guardarModificarDatos")){
            guardaModificarDatos();
        } else if (accion.equals("modificarDatosGrupo")){
            modificaDatosGrupo();
        } else if (accion.equals("aceptarDatosGrupo")){
            aceptarDatosGrupo();
        } else if (accion.equals("moverEntreGrupos")){
            moverEntreGrupos(false);
        } else if (accion.equals("aceptaGrupos")){
            aceptaGrupos();
        } else if (accion.equals("cambioGrupoFinal")){
            actualizarCombos();
        } else if (accion.equals("limpiarMover")){
            moverEntreGrupos(true);
        }
		getFormatosValidaciones();

    } catch(Exception ex){
      traza("accion:"+accion);
      traza("casodeuso:"+this.casoDeUso);
      traza("ENTRO A ZONA DE ERRORES");
      
      if (casoDeUso.equals("eliminar")) {
         if (accion.equals("eliminar")) {
              cargaCombos(false);
              asignarAtributo("VAR", "accion", "valor", accion);
              asignarAtributo("VAR", "hCasoDeUso", "valor", casoDeUso);    
              asignarAtributo("LABELC","lblPaisActual", "valor", UtilidadesSession.getDescripcionPais(this));              
              asignarAtributo("VAR","hPais","valor",pais);
              asignarAtributo("VAR","hMarca","valor",conectorParametro("cbMarcas"));
              asignarAtributo("VAR","hCanal","valor",conectorParametro("cbCanales"));
              try{this.consulta();}catch(Exception e){}
         } else if (accion.equals("consultar")) {
              this.asignarAtributoPagina("cod", "067");
              this.getConfiguracionMenu("LPEliminarGruposZonas",""); 
              asignarAtributo("VAR", "accion", "valor", "muestraBuscar");  
         }          
      } else if (casoDeUso.equals("modificar")) {
         if (accion.equals("aceptarDatosGrupo")){
              pagina("contenido_datos_grupo_modificar");
              this.cargaCombosTipoFact();
              asignarAtributo("VAR", "accion", "valor", accion);
              asignarAtributo("VAR", "hCasoDeUso", "valor", casoDeUso);              
              this.preservaHiddensI18n(new Integer(1),"CRA_CABEC_GRUPO_ZONA","frmModificarDatosGrupo","txtNombreDeGrupo",false);
              asignarAtributo("LABELC","lblCodigoDeGrupo","valor",conectorParametro("hCodigoDeGrupo"));
              asignarAtributo("VAR","hCodigoDeGrupo","valor",conectorParametro("hCodigoDeGrupo"));
              asignarAtributo("CTEXTO","txtNombreDeGrupo","valor",conectorParametro("txtNombreDeGrupo"));
              asignarAtributo("VAR","hNombreGrupo","valor",conectorParametro("hNombreGrupo"));              
              asignarAtributo("VAR","hFactPreserva","valor",conectorParametro("cbTipoFacturacion"));
              asignarAtributo("VAR","hFacturacion","valor",conectorParametro("hFacturacion"));
         } else if (accion.equals("consultar")){
              asignarAtributo("VAR", "accion", "valor", "muestraBuscar");                 
         }
      } else if (casoDeUso.equals("consultar")) {
              asignarAtributo("VAR", "accion", "valor", "muestraBuscar");   
      } else if (casoDeUso.equals("insercion")) {
          if (accion.equals("guardar")){
              pagina("contenido_grupos_zonas_crear");   
				  asignarSeparadoresDecimales();
				  cargaCombos(true);
              asignarAtributo("LABELC","lblPaisActual", "valor", UtilidadesSession.getDescripcionPais(this));
              asignarAtributo("VAR","hPais","valor",pais);
              asignarAtributo("VAR","hMarca","valor",conectorParametro("cbMarcas"));
              asignarAtributo("VAR","hCanal","valor",conectorParametro("cbCanales"));
              asignarAtributo("VAR","hTipoDeFacturacion","valor",conectorParametro("cbTipoFacturacion"));
              asignarAtributo("VAR","hCodigoDeGrupo","valor",conectorParametro("hCodigoDeGrupo"));
              asignarAtributo("VAR","hNombreDeGrupo","valor",conectorParametro("hNombreDeGrupo"));
              asignarAtributo("VAR","hZonasSeleccionadas","valor",conectorParametro("hZonasSeleccionadas"));
              asignarAtributo("VAR","hDescSeleccionadas","valor",conectorParametro("hDescSeleccionadas"));
              this.preservaHiddensI18n(new Integer(1),"CRA_CABEC_GRUPO_ZONA","frmInsertarGruposZonas","txtNombreDeGrupo",false);
          }
      }
      this.logStackTrace(ex);
      this.lanzarPaginaError(ex);
    }
  }//ejecucion
//-------------------------------METODOS PRIVADOS----------------------------------------  

private void asignarSeparadoresDecimales() throws Exception{
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) {
			separadorMiles = ".";
		}
		asignar("VAR","hSeparadorMilesPais", separadorMiles);
		asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hSeparadorDecimalPais", separadorDecimales);
 }
 
 private void muestraBuscar() throws Exception{    

    pagina("contenido_grupos_zonas_modificar");
    traza("muestraBuscar()1");

    asignarAtributo("LABELC", "lblPaisActual", "valor", UtilidadesSession.getDescripcionPais(this));
    asignarAtributo("VAR", "accion", "valor", accion);
    asignarAtributo("VAR", "hCasoDeUso", "valor", casoDeUso);    
    cargaCombos(false); 
    traza("muestraBuscar()2");
    if (casoDeUso.equalsIgnoreCase("consultar")) { //buscar
        this.asignarAtributoPagina("cod", "0103");
        this.getConfiguracionMenu("LPBuscarGruposZonas","");     
    } else if (casoDeUso.equalsIgnoreCase("eliminar")) { //eliminar
        this.asignarAtributoPagina("cod", "067");
        this.getConfiguracionMenu("LPEliminarGruposZonas","");    
    } else if (casoDeUso.equalsIgnoreCase("modificar")) { //modificar
        this.asignarAtributoPagina("cod", "066");
        this.getConfiguracionMenu("LPModificarGruposZonas","");    
    }
    traza("muestraBuscar()3");
                
 }//muestraBuscar()
 
 private void muestraInsertar() throws Exception{
    traza("muestraInsertar()1");
    pagina("contenido_grupos_zonas_crear");
    this.anyadeHiddensI18N(true,"CRA_CABEC_GRUPO_ZONA", null, new Integer(1),"frmInsertarGruposZonas","txtNombreDeGrupo",false);
    traza("muestraInsertar()2");
    asignarAtributo("LABELC", "lblPaisActual", "valor", UtilidadesSession.getDescripcionPais(this));
    asignarAtributo("VAR", "hPais", "valor", pais);
    asignarAtributo("VAR", "accion", "valor", accion);
    asignarAtributo("VAR", "hCasoDeUso", "valor", casoDeUso);
    Long canaldef = UtilidadesSession.getCanalPorDefecto(this);
    Long marcadef = UtilidadesSession.getMarcaPorDefecto(this);
    Integer regiondef = UtilidadesSession.getRegion(this);

    asignarAtributo("VAR", "hCanalDefecto", "valor", (canaldef!=null?canaldef.toString():""));
    asignarAtributo("VAR", "hMarcaDefecto", "valor", (marcadef!=null?marcadef.toString():"") );
    asignarAtributo("VAR", "hRegionDefecto", "valor", (regiondef!=null?regiondef.toString():"") );
    cargaCombos(true);
    traza("muestraInsertar()3");
    this.asignarAtributoPagina("cod", "065");
	 
	asignarSeparadoresDecimales();
  
	this.getConfiguracionMenu("LPCrearGruposZonas","crear");
    
 }//muestraInsertar()
 
 private void consulta() throws Exception{//para ARBOL
 
    traza("consulta()1");    
    pagina("contenido_grupos_zonas_modificar");
    
    String marca = conectorParametro("cbMarcas");
    String canal = conectorParametro("cbCanales");
    
    asignarAtributo("LABELC", "lblPaisActual", "valor", UtilidadesSession.getDescripcionPais(this));
    asignarAtributo("VAR", "hMarca", "valor", marca);
    asignarAtributo("VAR", "hCanal", "valor", canal);    
    asignarAtributo("VAR", "accion", "valor", accion);
    asignarAtributo("VAR", "hCasoDeUso", "valor", casoDeUso);
    cargaCombos(false); 
    
 		DTOEntradaCalendario dtoe = new DTOEntradaCalendario();
		Collection colGruposZonas = new ArrayList();    
 
    traza("consulta()2 "+conectorParametro("cbMarcas"));
		dtoe.setPais(new Long(pais));
		dtoe.setMarca(new Long(marca));
		dtoe.setCanal(new Long(canal));
    dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));

		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoe);
		paramEntrada.add(new MareBusinessID("CRAConsultarGruposZonasDetalles"));

		DruidaConector conectorObtenZonasPorGruposZonas = conectar("ConectorObtenZonasPorGruposZonas",paramEntrada);
		IMareDTO dto = (IMareDTO)conectorObtenZonasPorGruposZonas.objeto("DTO");
		
		colGruposZonas = (Collection)dto.getProperty("resultado");

    traza("se va a conectar CRAObtenerTiposFacturacion");
    DTOBelcorp dtoen = new DTOBelcorp();    
    dtoen.setOidPais(new Long(this.pais));
    dtoen.setOidIdioma(this.idiomaUsuario);
    
    Vector paramEntrada2 = new Vector();
		paramEntrada2.add(dtoen);
		paramEntrada2.add(new MareBusinessID("CRAObtenerTiposFacturacion"));

		DruidaConector conectorTipoFact = conectar("ConectorObtenerZonasNoAsignadasCRA",paramEntrada2);
		DTOSalida dtos = (DTOSalida)conectorTipoFact.objeto("dtoSalida");
    traza("salida:"+dtos);
    traza("salida:"+dtos.getResultado().getTable().keys().nextElement().getClass());

    hmTiposFact = new HashMap();
    
    Hashtable htTiposFact = dtos.getResultado().getTable();
    Enumeration en = dtos.getResultado().getTable().keys();
    
    while (en.hasMoreElements()){
          Vector vec = (Vector)htTiposFact.get(en.nextElement());      
          traza("primero"+vec.firstElement()+" "+vec.firstElement().getClass());
          traza("ultimo"+vec.lastElement());
          hmTiposFact.put(vec.firstElement(),vec.lastElement());
    }    

    conectorParametroSesion(GRUPOS_ZONAS,colGruposZonas);    

    this.crearArbol(colGruposZonas);

    asignarAtributo("CAPA", "capaMostrarArbolGruposZonas", "visibilidad", "visible");

    if (casoDeUso.equalsIgnoreCase("consultar")) { //buscar
        this.asignarAtributoPagina("cod", "0103");
        this.getConfiguracionMenu("LPBuscarGruposZonas","consultar");     
    } else if (casoDeUso.equalsIgnoreCase("eliminar")) { //eliminar
        this.asignarAtributoPagina("cod", "067");
        this.getConfiguracionMenu("LPEliminarGruposZonas","eliminar");    
    } else if (casoDeUso.equalsIgnoreCase("modificar")) { //modificar
        this.asignarAtributoPagina("cod", "066");
        this.getConfiguracionMenu("LPModificarGruposZonas","consultar");    
    }
    
 }//consulta()
 
 private void guarda() throws Exception{
    //falta i18n|
  pagina("contenido_grupos_zonas_crear");
  
	traza("guarda()1");
  asignarSeparadoresDecimales();
  String codGrupo = conectorParametro("hCodigoDeGrupo");
  String nomGrupo = conectorParametro("hNombreDeGrupo");
  String tipoFact = conectorParametro("hTipoDeFacturacion");  
  String strZonasSelec = conectorParametro("hZonasSeleccionadas");
  String marca = conectorParametro("cbMarcas");
  String canal = conectorParametro("cbCanales");
  
	traza("guarda()2");

  DTOCabecerasGruposZonas dtoCabeceraGruposZonas = new DTOCabecerasGruposZonas();
  dtoCabeceraGruposZonas.setPais(new Long(this.pais));
  dtoCabeceraGruposZonas.setOidPais(new Long(this.pais));
  dtoCabeceraGruposZonas.setMarca(new Long(marca));
  dtoCabeceraGruposZonas.setCanal(new Long(canal));
  dtoCabeceraGruposZonas.setCodigoGrupo(new Integer(codGrupo));
  dtoCabeceraGruposZonas.setNombreGrupo(nomGrupo);
  dtoCabeceraGruposZonas.setTipoFacturacion(new Long(tipoFact));
	dtoCabeceraGruposZonas.setPrograma(UtilidadesSession.getFuncion(this));
  dtoCabeceraGruposZonas.setIpCliente(UtilidadesBelcorp.getIPCliente(this));

  //i18n
  dtoCabeceraGruposZonas.setAttriTraducible(this.recuperaTraduccionesI18N(new Integer(1)));

	traza("guarda()4"+strZonasSelec);
  StringTokenizer strTok = new StringTokenizer(strZonasSelec,"|");
  int codGrupoDetalle = 0;
  Vector vecDetallesGruposZonas = new Vector();
  DTOZonas dtoZonas;
	DTODetallesGruposZonas dtoDetallesGruposZonas;
	String zonSelec;
	traza("guarda()5");
  while (strTok.hasMoreTokens())
  {
    zonSelec = strTok.nextToken();
    dtoZonas = new DTOZonas();
    dtoZonas.setPais(new Long(this.pais));
    dtoZonas.setMarca(new Long(marca));
    dtoZonas.setCanal(new Long(canal));    
    traza("setCodigoZona"+zonSelec);
    dtoZonas.setCodigoZona(zonSelec);
    dtoZonas.setOidZona(new Long(zonSelec));
    //dtoZonas.setSubgerenciaVentas((String)hashZonasSGV.get(zonSelec));
    dtoZonas.setCodigoEstadoZona(new Long(1));
    dtoZonas.setCodigoGerente("1");
    traza("guarda()6");
    dtoDetallesGruposZonas = new DTODetallesGruposZonas();
    dtoDetallesGruposZonas.setCodigoGrupoDetalle(String.valueOf(codGrupoDetalle++));
    dtoDetallesGruposZonas.setZona(dtoZonas);
    dtoDetallesGruposZonas.setOidZona(new Long(zonSelec));    
    dtoCabeceraGruposZonas.setPrograma(UtilidadesSession.getFuncion(this));
    dtoDetallesGruposZonas.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
    vecDetallesGruposZonas.addElement(dtoDetallesGruposZonas);
  }
	traza("guarda()7");
  dtoCabeceraGruposZonas.setZonas(vecDetallesGruposZonas);
  Vector paramEntrada = new Vector();
  paramEntrada.add(dtoCabeceraGruposZonas);
  traza("---------------------------dtoCabeceraGruposZonas: "+dtoCabeceraGruposZonas);

  
  paramEntrada.add(new MareBusinessID("CRACrearGruposZonas"));
	traza("guarda()8");
  DruidaConector conectorCrearGruposZonas = conectar("ConectorCrearGruposZonas",paramEntrada);
  //PRUEBA!!
  //throw new Exception();
	traza("guarda()9");
  this.muestraInsertar();
 
 }//guarda()
 
 private void elimina() throws Exception{
    traza("elimina() 1");
    pagina("contenido_grupos_zonas_modificar");

    String marca = conectorParametro("hMarca");
    String canal = conectorParametro("hCanal");
    
    String oidGrupo = conectorParametro("hGrupoSeleccionado");
    
    DTOEntradaEliminarGrupoZonas dto = new DTOEntradaEliminarGrupoZonas();
    dto.setCanal(new Long(marca));
    dto.setOidPais(new Long(pais));
    dto.setPais(new Long(pais));
    dto.setMarca(new Long(canal));
    
    dto.setOidGrupo(new Long(oidGrupo));

    //Asignar el business id que corresponde a eliminacion de grupos de zonas
		MareBusinessID id = new MareBusinessID("CRAEliminarGruposZonas");

		traza("elimina() 2");

		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dto);
		paramEntrada.addElement(id);

		traza("elimina() 3");

		DruidaConector conectorEliminarGrupoZona = conectar("ConectorEliminarGrupoZona",paramEntrada);

		traza("elimina() 4");
		traza("elimina() terminado");

    asignarAtributo("LABELC", "lblPaisActual", "valor", UtilidadesSession.getDescripcionPais(this));
    asignarAtributo("VAR", "accion", "valor", accion);
    asignarAtributo("VAR", "hCasoDeUso", "valor", casoDeUso);    
    cargaCombos(false);
    asignarAtributo("VAR", "hMarca", "valor", marca);
    asignarAtributo("VAR", "hCanal", "valor", canal);
    this.consulta();
 
 }//elimina()
 
 private void asignaZonas() throws Exception{

    pagina("contenido_zonas_disponibles_asignar");

    String grupoDeZonasBusqueda = conectorParametro("hGrupoSeleccionado");
    String marca = conectorParametro("hMarca");
    String canal = conectorParametro("hCanal");
    //Obtiene todas los grupos de zonas con sus zonas
    Collection zonasDeGrupos = (Collection)conectorParametroSesion(GRUPOS_ZONAS);
    
    DTOCabecerasGruposZonas dtoGrupoBusqueda = this.getCabecera(grupoDeZonasBusqueda,zonasDeGrupos);

    //Guarda en la sesion el DTOCabecera del  Grupo de Busqueda
    conectorParametroSesion(GRUPO_ASIGNAR,dtoGrupoBusqueda);

    //Carga el combo de Grupos de Zonas con el grupo de busqueda
    this.cargarGrupoDeZonasAsignar(dtoGrupoBusqueda);

    Collection zg = new ArrayList();
    zg.add(dtoGrupoBusqueda);
    Collection zonasGrupoAsignar = this.obtenerColeccionZonas(zg,grupoDeZonasBusqueda);
    this.cargarZonas(zonasGrupoAsignar,"comboZonasGrupo");
    String sZonasIniciales = this.zonasInicialesParaLimpiar(zonasGrupoAsignar);
    String sRegionDeCZona = this.zonasConSuRegion(zonasGrupoAsignar);

    //Obtiene todas las regiones con zonas disponibles y lo guarda en la sesion
    cargaCombosAsignar(marca, canal);
    
    Integer regionDefecto = UtilidadesSession.getRegion(this);
    
    asignarAtributo("VAR","hMarca","valor", marca);
    asignarAtributo("VAR","hCanal","valor", canal);
    asignarAtributo("VAR","hPais","valor", pais);
    asignarAtributo("VAR","sZonasInicial","valor", sZonasIniciales);
    asignarAtributo("VAR","sRegionDeCZona","valor", sRegionDeCZona);    
    asignarAtributo("VAR","hRegionDefecto","valor", (regionDefecto!=null?regionDefecto.toString():""));

    traza("asignaZonas()2");    

    getConfiguracionMenu("LPModificarGruposZonas","asignarZonas");
    this.asignarAtributoPagina("cod", "064");
        
 }//asignaZonas()
 
 private void aceptaZonas() throws Exception{
  pagina("contenido_zonas_disponibles_asignar");
  this.asignarZonasAGrupo();
  this.guardarAsignarZonas();
  asignarAtributo("VAR","hcerrar","valor","true");
 
 }//aceptaZonas()
 
	// Este metodo actualiza los datos los datos del Grupo de Zonas seleccionado
	private void guardaModificarDatos() throws Exception{

    pagina("contenido_datos_grupo_modificar");
    traza("guardaModificarDatos()1");
		DTOCabecerasGruposZonas dtoGrupo = (DTOCabecerasGruposZonas) conectorParametroSesion(GRUPO_MODIFICAR);
		dtoGrupo.setNombreGrupo(conectorParametroLimpia("txtNombreDeGrupo","",true));    
	  dtoGrupo.setTipoFacturacion(new Long(conectorParametro("cbTipoFacturacion")));
    dtoGrupo.setAttriTraducible(recuperaTraduccionesI18N(new Integer(1)));
    traza("guardaModificarDatos()2");
    
  	Vector paramEntrada = new Vector();
		paramEntrada.add(dtoGrupo);
		paramEntrada.add(new MareBusinessID("CRAModificarGruposZonas"));
    //throw new Exception();
    traza("guardaModificarDatos()3");
		DruidaConector conectorModificarGruposZonas = conectar("ConectorModificarGruposZonas",paramEntrada);
    
    asignarAtributo("VAR","hcerrar","valor","true");
    traza("guardaModificarDatos()4");   
    
	}//guardaModificarDatos()
 
 private void modificaDatosGrupo() throws Exception{

  pagina("contenido_datos_grupo_modificar");

  //aca crea una instancia dtoGrupoZonas de DTOGrupoZonas y se rellena con todos los datos del grupo de zonas seleccionado. 
  String grupoDeZonasBusqueda = this.conectorParametro("hGrupoSeleccionado");
  Collection zonasDeGrupos = (Collection)this.conectorParametroSesion(GRUPOS_ZONAS);
  DTOCabecerasGruposZonas dtoGrupoBusqueda = this.getCabecera(grupoDeZonasBusqueda,zonasDeGrupos);

  //i18n  
  this.anyadeHiddensI18N(true,"CRA_CABEC_GRUPO_ZONA", new Long(grupoDeZonasBusqueda), new Integer(1),"frmModificarDatosGrupo","txtNombreDeGrupo",false);

  //Guarda en la sesion el DTOCabecera del  Grupo de Busqueda
  conectorParametroSesion(GRUPO_MODIFICAR,dtoGrupoBusqueda);
        
  this.cargarCapaModificarDatos(dtoGrupoBusqueda);
  
  cargaCombosTipoFact();  

  //menu secundario
  getConfiguracionMenu("LPModificarGruposZonas","modificarDatos");
  this.asignarAtributoPagina("cod", "234");
   
 }//modificaDatosGrupo()
 
 private void aceptarDatosGrupo() throws Exception{

  this.guardaModificarDatos();
 
 }//aceptarDatosGrupo()
 
 private void moverEntreGrupos(boolean limpiar) throws Exception{
          traza("marca1:"+conectorParametro("hMarca"));
        pagina("contenido_entre_grupos_mover");

        String marca = conectorParametro("hMarca");
        String canal = conectorParametro("hCanal");
        String grupoSeleccionado = null;
        
        if (limpiar){
            grupoSeleccionado = conectorParametro("sGrupoDeZonasBusqueda");
            DTOEntradaCalendario dtoe = new DTOEntradaCalendario();
            Collection colGruposZonas = new ArrayList();    
 
            traza("consulta()2 "+conectorParametro("cbMarcas"));
            dtoe.setPais(new Long(pais));
            dtoe.setMarca(new Long(marca));
            dtoe.setCanal(new Long(canal));
            dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));

            Vector paramEntrada = new Vector();
            paramEntrada.add(dtoe);
            paramEntrada.add(new MareBusinessID("CRAConsultarGruposZonasDetalles"));

            DruidaConector conectorObtenZonasPorGruposZonas = conectar("ConectorObtenZonasPorGruposZonas",paramEntrada);
            IMareDTO dto = (IMareDTO)conectorObtenZonasPorGruposZonas.objeto("DTO");
		
            colGruposZonas = (Collection)dto.getProperty("resultado");

            conectorParametroSesion(GRUPOS_ZONAS,colGruposZonas);
        } else {
            grupoSeleccionado = conectorParametro("hGrupoSeleccionado");
        }
  			traza("moverZonas1");
				Collection zonasDeGrupos = (Collection)conectorParametroSesion(GRUPOS_ZONAS);//this.obtenerZonasPorGruposZonas(pais,conectorParametro("cbMarcas"),conectorParametro("cbCanales"));

				conectorParametroSesion(GRUPOS_ZONAS,zonasDeGrupos);//?

				this.cargarGrupoInicial(zonasDeGrupos,grupoSeleccionado);
				this.cargarGrupoFinal(zonasDeGrupos,grupoSeleccionado);
				traza("moverZonas2");
				Collection zonasGrupoInicial = this.obtenerColeccionZonas(zonasDeGrupos,grupoSeleccionado);
				this.cargarZonas(zonasGrupoInicial,"comboZonas");

				traza("moverZonas 2 y medio");
				String primerGrupo = this.obtenerPrimerGrupoDistinto(zonasDeGrupos,grupoSeleccionado);
				traza("hay esto--z>"+primerGrupo);
        asignarAtributo("VAR","sGrupoDeZonasBusqueda","valor",grupoSeleccionado);
				asignarAtributo("VAR","sGrupoDeZonasPrevio","valor",primerGrupo);

      	asignarAtributo("VAR","hPais","valor",pais);
        traza("marca2:"+conectorParametro("hMarca"));
        asignarAtributo("VAR","hMarca","valor",marca);
        asignarAtributo("VAR","hCanal","valor",canal);
           
				traza("moverZonas3");
				Collection zonasGrupoFinal = this.obtenerColeccionZonas(zonasDeGrupos,primerGrupo);
				this.cargarZonas(zonasGrupoFinal,"comboZonas2");

				traza("moverZonas4");
        
				getConfiguracionMenu("LPModificarGruposZonas","moverZonas");
        this.asignarAtributoPagina("cod", "076");
        traza("moverZonas5");
        
 }//moverEntreGrupos() 
 
 private void aceptaGrupos() throws Exception{
 
  this.actualizarCombos();
  this.guardarMoverZonas();
  asignarAtributo("VAR","hcerrar","valor","true");
 
 }//aceptaGrupos() 
 
//-------------------------------FIN METODOS PRIVADOS----------------------------------------

//---------------------------------METODOS DE APOYO------------------------------------------

//----------------------------------CARGA INICIAL--------------------------------------------
    private void cargaCombosAsignar(String marca, String canal) throws Exception{
		//Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametrosEntradaAsignar(marca, canal);
		
		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
		
		//Cargamos los combos con los resultados
    asignar("COMBO", "cbRegiones", resultados, "ZONObtenerRegiones");
    asignar("COMBO", "comboZonas2", resultados, "CRAObtenerZonasNoAsignadasPorRegion");
	}

  private ComposerViewElementList crearParametrosEntradaAsignar(String marca, String canal) throws Exception{

		ComposerViewElementList lista = new ComposerViewElementList(); 

    DTOUnidadAdministrativa dtoe = new DTOUnidadAdministrativa();   
    
    dtoe.setOidPais(new Long(this.pais));
    dtoe.setOidMarca(new Long(marca));
    dtoe.setOidCanal(new Long(canal));
        
		//Primer combo
		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("ZONObtenerRegiones");
		ci1.setDTOE(dtoe);

		ci1.setPosOID((byte)0);
		ci1.setPosDesc((byte)5);    

    traza("Region Defecto:"+UtilidadesSession.getRegion(this) +"pais "+pais+" marca "+marca+" canal "+canal);
    DTOGrupoZonas dto2 = new DTOGrupoZonas();
    dto2.setOidPais(new Long(pais));
    dto2.setOidMarca(new Long(marca));
    dto2.setOidCanal(new Long(canal));
    dto2.setOidRegion(new Long(UtilidadesSession.getRegion(this).longValue()));
    
		//Segundo combo
		ComposerViewElement ci2 = new ComposerViewElement();
		ci2.setIDBusiness("CRAObtenerZonasNoAsignadasPorRegion");
		ci2.setDTOE(dto2);
    
		lista.addViewElement(ci1);
		lista.addViewElement(ci2);

		return lista;
	}
  

		private void cargaCombosTipoFact() throws Exception{
		//Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametrosEntradaTipoFact();
		
		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
		
		//Cargamos los combos con los resultados
    asignar("COMBO", "cbTipoFacturacion", resultados, "CRAObtenerTiposFacturacion");
	}

  private ComposerViewElementList crearParametrosEntradaTipoFact(){
		ComposerViewElementList lista = new ComposerViewElementList(); 

    DTOBelcorp dtoe = new DTOBelcorp();    
    dtoe.setOidPais(new Long(this.pais));
    dtoe.setOidIdioma(this.idiomaUsuario);
    
		//Primer combo
    ComposerViewElement ci1 = new ComposerViewElement();
    ci1.setIDBusiness("CRAObtenerTiposFacturacion");
    ci1.setDTOE(dtoe);    
    
		lista.addViewElement(ci1);
    
		return lista;
	}
  
	private void cargaCombos(boolean insercion) throws Exception{
		//Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametrosEntrada(insercion);
		
		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
		
		//Cargamos los combos con los resultados
		asignar("COMBO", "cbCanales", resultados, "SEGConsultaCanales");
		asignar("COMBO", "cbMarcas", resultados, "SEGConsultaMarcas");
    if (insercion) asignar("COMBO", "cbTipoFacturacion", resultados, "CRAObtenerTiposFacturacion");
	}
  
	private ComposerViewElementList crearParametrosEntrada(boolean insercion){
		ComposerViewElementList lista = new ComposerViewElementList(); 

    DTOBelcorp dtoe = new DTOBelcorp();    
    dtoe.setOidPais(new Long(this.pais));
    dtoe.setOidIdioma(this.idiomaUsuario);
    
		//Primer combo
		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("SEGConsultaCanales");
		ci1.setDTOE(dtoe);


		//Segundo combo
		ComposerViewElement ci2 = new ComposerViewElement();
		ci2.setIDBusiness("SEGConsultaMarcas");
		ci2.setDTOE(dtoe);

		/*//Redefinimos la posición de las columnas porque el resultado de 
		// la operación de negocio no es estándar
		ci2.setPosOID((byte)2);
		ci2.setPosDesc((byte)0);
		*/
    
		lista.addViewElement(ci1);
		lista.addViewElement(ci2);
    if (insercion) {
      //Tercer combo
      ComposerViewElement ci3 = new ComposerViewElement();
      ci3.setIDBusiness("CRAObtenerTiposFacturacion");
      ci3.setDTOE(dtoe);
      lista.addViewElement(ci3);
    }   
    
		return lista;
	}
//----------------------------FIN------CARGA INICIAL-----------------------------------------
	private void logStackTrace(Throwable e) throws Exception{

		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
		
		if (e instanceof MareException){
			MareException e2 = (MareException)e;
			traza("Es una mare Exception con codigo de error: " + e2.getCode());
		}

		e.printStackTrace(out);
		traza("stack Trace : " + pila.toString());

	}//logStackTrace()
  
     private void crearArbol(Collection colGrupos) throws Exception{
    	DruidaDOMObjeto miObj = new DruidaDOMObjeto();
		  Document document = this.getXML();

      traza("entrada"+colGrupos.toString());
      
		  Element element = document.createElement("ARBOL");
		  miObj.setXML(element);
      
  		this.setAttr2MenuTag(element,"0");
	
		  Element elementAux = this.getXML().createElement("RAMA");
		  elementAux.setAttribute("nombre", "root");
		  elementAux.setAttribute("icono", "1");
 		  elementAux.setAttribute("codigo", "root");
		  elementAux.setAttribute("texto", "Grupos de zonas");
      elementAux.setAttribute("onclick", "miFuncionArbol(name0,p1,p2,p4,soypadre);");
		  element.appendChild(elementAux);
		  this.addBranches(colGrupos,elementAux, false);
  		DruidaConector drd = new DruidaConector();
	  	drd.setXML(miObj.getXML());
      
      traza("drd.getXML().......: " + elementAux.toString());
      traza("drd.getXML().......: " + miObj.getXML());
      traza("salida.......: " + drd.getXML());      
      
   		asignar("REJILLA", "RArbol", drd);

  }

	private Element addElement(Object dto,Element element,String tag) throws Exception{
		Element elementAux;    
		elementAux = this.getXML().createElement(tag);

    if (tag.equals("RAMA")){      
      DTOCabecerasGruposZonas hijo = (DTOCabecerasGruposZonas)dto;
      traza("creo Rama "+hijo.getOidGrupo().toString());
      elementAux.setAttribute("nombre", "name"+hijo.getOidGrupo().toString());
      elementAux.setAttribute("icono", "1");
      elementAux.setAttribute("codigo", hijo.getOidGrupo().toString()); 
      elementAux.setAttribute("texto", hijo.getNombreGrupo() +" ("+ hmTiposFact.get(new BigDecimal(hijo.getTipoFacturacion().longValue()))+")" );
      //elementAux.setAttribute("onclick", "funcionOnClick(\\'" + hijo.getOidGrupo() + "\\', \\'" + hijo.getNombreGrupo() + "\\');");
       elementAux.setAttribute("onclick", "miFuncionArbol(name0,p1,p2,p4,soypadre);");    
    } else {
      //Nuevo
      traza(dto.getClass().getName());
      if (dto.getClass().getName().equals("es.indra.sicc.dtos.cra.DTODetallesGruposZonas")){
          DTODetallesGruposZonas hijo = (DTODetallesGruposZonas)dto;
          traza("creo Hoja "+hijo.getOidDetalle().toString());
          elementAux.setAttribute("nombre", "name"+hijo.getOidDetalle().toString());
          elementAux.setAttribute("icono", "2");
          elementAux.setAttribute("codigo", hijo.getOidDetalle().toString());
          elementAux.setAttribute("onclick", "fhoja();");
          if (hijo.getZona().getCodigoZona()!=null) //CAMBIAR CODIGO POR DESCRIPCIOn
              elementAux.setAttribute("texto", hijo.getZona().getDescZona());
          else
              elementAux.setAttribute("texto", "Zona Sin Descripcion");
      }else{
          DTOCabecerasGruposZonas hijo = (DTOCabecerasGruposZonas)dto;
          traza("creo Hoja/RAMA "+hijo.getOidGrupo().toString());
          elementAux.setAttribute("nombre", "name"+hijo.getOidGrupo().toString());
          elementAux.setAttribute("icono", "2");
          elementAux.setAttribute("codigo", hijo.getOidGrupo().toString());
          elementAux.setAttribute("onclick", "miFuncionArbol(name0,p1,p2,p4,soypadre);");
          if (hijo.getNombreGrupo()!=null) //CAMBIAR CODIGO POR DESCRIPCIOn
              elementAux.setAttribute("texto", hijo.getNombreGrupo());
          else
              elementAux.setAttribute("texto", "Rama Sin Descripcion");
      }
      
    }
    traza("addElement:"+elementAux.toString()); 
		element.appendChild(elementAux);
		return elementAux;
	}

	private void addBranches(Collection collection,Element element, boolean hojas) throws Exception{	

    Iterator itcol = collection.iterator();
    
		while (itcol.hasNext()){
			 //	Por cada uno de ellos añadimos un rama/hoja que depende del raiz.
       if (hojas){
          DTODetallesGruposZonas hoja = (DTODetallesGruposZonas)itcol.next();	
  				this.addElement(hoja, element, "HOJA");    
       }else{
           DTOCabecerasGruposZonas rama = (DTOCabecerasGruposZonas)itcol.next();
           if (rama.getZonas().size()>0){
              Element elementAux = this.addElement(rama, element, "RAMA");
              this.addBranches(rama.getZonas(),elementAux, true);
           }else{//Es hoja
              Element elementAux = this.addElement(rama, element, "HOJA");
           }
       }
       /*if (hojas){
          DTODetallesGruposZonas hoja = (DTODetallesGruposZonas)itcol.next();	
  				this.addElement(hoja, element, "HOJA");          
       } else {
          DTOCabecerasGruposZonas rama = (DTOCabecerasGruposZonas)itcol.next();			  
          Element elementAux = this.addElement(rama, element, "RAMA");
          traza("rama--> "+elementAux.toString());
          this.addBranches(rama.getZonas(),elementAux, true);
          traza("rama-c/hojas-> "+elementAux.toString());
       }*/
		}
	}
  
	private void setAttr2MenuTag(Element element,String oid) throws Exception{
		element.setAttribute("x","1" ) ;
    element.setAttribute("y", "1");
		element.setAttribute("nombre", "name"+oid);
		element.setAttribute("id", "datosCampos");
    element.setAttribute("ancho", "300"); 
		element.setAttribute("alto", "210");
    element.setAttribute("multisel", "S");    
		element.setAttribute("incx", "10");
		element.setAttribute("incy", "10");
	  element.setAttribute("visibilidad", "");
    element.setAttribute("padreSeleccionable", "S");
    element.setAttribute("oncolor", "#D0D9E8");
    element.setAttribute("overcolor", "#DDDDDD");

	 	this.addIconos(element);
	}
  
	private void addIconos(Element element) throws Exception{
			Element elementAux = this.getXML().createElement("ICONOS");
			element.appendChild(elementAux);
			element = this.getXML().createElement("ICONO");
      element.setAttribute("src", "b.gif");
      elementAux.appendChild(element);
			element = this.getXML().createElement("ICONO");
      element.setAttribute("src", "flechaMenuVert.gif");
	    elementAux.appendChild(element);
			element = this.getXML().createElement("ICONO");
      element.setAttribute("src", "flechaMenuHorz.gif");
      elementAux.appendChild(element);
	}


  //Este metodo actualiza los datos al mover entre zonas
  private void guardarMoverZonas() throws Exception{
   
	IMareDTO dtoe = new MareDTO();

	Collection zonasDeGrupos = (Collection)conectorParametroSesion(GRUPOS_ZONAS);

	//Se Agregan Parametros auditoria------------------------------------------------
	DTOCabecerasGruposZonas dtoCabeceraGZ;
	Iterator iteradorGrupos = zonasDeGrupos.iterator();
  traza("guardarMoverZonas()1");
	while (iteradorGrupos.hasNext()) {
		dtoCabeceraGZ = (DTOCabecerasGruposZonas) iteradorGrupos.next();
		Iterator iteradorZonas = dtoCabeceraGZ.getZonas().iterator();
		while (iteradorZonas.hasNext())
		{
			DTODetallesGruposZonas dtoDetalleGZ = (DTODetallesGruposZonas) iteradorZonas.next();
			dtoDetalleGZ.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
			dtoDetalleGZ.setPrograma(UtilidadesSession.getFuncion(this));

			DTOZonas dtoZonas = dtoDetalleGZ.getZona();	

			dtoDetalleGZ.setOidGrupo(dtoCabeceraGZ.getOidGrupo());
			dtoDetalleGZ.setOidZona(dtoZonas.getOidZona());
		}
		dtoCabeceraGZ.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
		dtoCabeceraGZ.setPrograma(UtilidadesSession.getFuncion(this));
	}
    traza("guardarMoverZonas()2");
	//FIN - Se Agregan Parametros auditoria------------------------------------------

    dtoe.addProperty("coleccion",zonasDeGrupos);
	Vector paramEntrada = new Vector();
	paramEntrada.add(dtoe);
	paramEntrada.add( new MareBusinessID("CRAMueveZonas") );

    traza("ENTRANDO A CONECTOR CRAMUEVEZONAS!");
    traza("CONTENIDO DEL MAREDTO:"+dtoe);
	DruidaConector conectorModificarGruposZonas = conectar("ConectorModificarGruposZonas",paramEntrada);

    traza("PASO A CONECTOR CRAMUEVEZONAS!");

   }//guardarMoverZonas()

	// Este metodo actualiza los datos al asignar y desasignar zonas
	private void guardarAsignarZonas() throws Exception{

    //Aca falta actualizar las zonas que se agregaron al combo.
    
		DTOCabecerasGruposZonas dtoCGZ = (DTOCabecerasGruposZonas)conectorParametroSesion(GRUPO_ASIGNAR);

		Collection colDetZonas = dtoCGZ.getZonas();
		Iterator itDetZonas = colDetZonas.iterator();
		while(itDetZonas.hasNext())
		{	
			DTODetallesGruposZonas dtoDetalle = (DTODetallesGruposZonas)itDetZonas.next();

			DTOZonas dtoZonas = dtoDetalle.getZona();	

			dtoDetalle.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
			dtoDetalle.setPrograma(UtilidadesSession.getFuncion(this));
			dtoDetalle.setOidGrupo(dtoCGZ.getOidGrupo());
			dtoDetalle.setOidZona(dtoZonas.getOidZona());
		}
		dtoCGZ.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
		dtoCGZ.setPrograma(UtilidadesSession.getFuncion(this));

		traza("guardarAsignarZonas()1");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoCGZ);
		paramEntrada.add( new MareBusinessID("CRAAsignarZonasAGrupos") );

		traza("ENTRANDO A CONECTOR CRA-ASIGNAR-ZONAS!");
		traza("CONTENIDO DEL MAREDTO:"+dtoCGZ);
		
		try{
			DruidaConector conectorModificarGruposZonas = conectar("ConectorModificarGruposZonas",paramEntrada);
		}catch(Exception e){
			this.logStackTrace(e);
			traza("EL ERROR ES:"+e.getClass().toString());
			traza("EL ERROR ES:"+((com.evermind.server.rmi.OrionRemoteException) e).detail.getClass());
		}
		
		traza("PASO A CONECTOR CRA-ASIGNAR-ZONAS!");
	
	}//guardarAsignarZonas()


    /**
     * 
     */
    private void cargarGrupoInicial(Collection zonasDeGrupos,String grupoSeleccionado) throws Exception{
        /** Generar conector */
        String campoOid = "COD";
        String campoNombre = "NOM";
        String ID_Rows = "dtoSalida.gruposzonas_ROWSET";
        
        XMLDocument xmlDoc  = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");

        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID", ID_Rows);
        docDestino.getDocumentElement().appendChild(e_rows);

		Iterator iter = zonasDeGrupos.iterator();

        while (iter.hasNext()) {
            DTOCabecerasGruposZonas grupoZona = (DTOCabecerasGruposZonas)iter.next();

            //Si el grupoZona es igual al grupoSeleccionado
			if ( (grupoZona.getOidGrupo().toString()).equals(grupoSeleccionado)) {
            
                Element e_row = docDestino.createElement("ROW");
                e_rows.appendChild(e_row);

                Element e_campo1 = docDestino.createElement("CAMPO");
                e_campo1.setAttribute("NOMBRE", campoOid);
                e_campo1.setAttribute("TIPO", "OBJECTO");
                e_campo1.setAttribute("LONGITUD", "50");
                Text txtOid = docDestino.createTextNode(grupoZona.getOidGrupo()==null?"":grupoZona.getOidGrupo().toString());
                e_campo1.appendChild(txtOid);
                e_row.appendChild(e_campo1);

                Element e_campo2 = docDestino.createElement("CAMPO");
                e_campo2.setAttribute("NOMBRE", campoNombre);
                e_campo2.setAttribute("TIPO", "OBJECTO");
                e_campo2.setAttribute("LONGITUD", "50");
                Text txtNombre = docDestino.createTextNode(grupoZona.getNombreGrupo()==null?"":grupoZona.getNombreGrupo().toString());
                e_campo2.appendChild(txtNombre);
                e_row.appendChild(e_campo2);
            }
        }

        DruidaConector conectorGruposZonas = new DruidaConector();
        conectorGruposZonas.setXML(docDestino.getDocumentElement());

        /** Asignar conector al combo */
		asignar("COMBO","comboGrupoInicial",conectorGruposZonas,"dtoSalida.gruposzonas_ROWSET");

	}//cargarGrupoInicial()


    /**
     * 
     */
  	private void cargarGrupoFinal(Collection zonasDeGrupos,String grupoSeleccionado) throws Exception{
        /** Generar conector */
        String campoOid = "COD";
        String campoNombre = "NOM";
        String ID_Rows = "dtoSalida.gruposzonas_ROWSET";
        
        XMLDocument xmlDoc  = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");

        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID", ID_Rows);
        docDestino.getDocumentElement().appendChild(e_rows);

		Iterator iter = zonasDeGrupos.iterator();

        while (iter.hasNext())  {
            DTOCabecerasGruposZonas grupoZona = (DTOCabecerasGruposZonas)iter.next();

            //Si el grupoZona es distinto al grupoSeleccionado
			if ( ! (grupoZona.getOidGrupo().toString()).equals(grupoSeleccionado)) {
            
                Element e_row = docDestino.createElement("ROW");
                e_rows.appendChild(e_row);

                Element e_campo1 = docDestino.createElement("CAMPO");
                e_campo1.setAttribute("NOMBRE", campoOid);
                e_campo1.setAttribute("TIPO", "OBJECTO");
                e_campo1.setAttribute("LONGITUD", "50");
                Text txtOid = docDestino.createTextNode(grupoZona.getOidGrupo()==null?"":grupoZona.getOidGrupo().toString());
                e_campo1.appendChild(txtOid);
                e_row.appendChild(e_campo1);

                Element e_campo2 = docDestino.createElement("CAMPO");
                e_campo2.setAttribute("NOMBRE", campoNombre);
                e_campo2.setAttribute("TIPO", "OBJECTO");
                e_campo2.setAttribute("LONGITUD", "50");
                Text txtNombre = docDestino.createTextNode(grupoZona.getNombreGrupo()==null?"":grupoZona.getNombreGrupo().toString());
                e_campo2.appendChild(txtNombre);
                e_row.appendChild(e_campo2);
            }
        }

        DruidaConector conectorGruposZonas = new DruidaConector();
        conectorGruposZonas.setXML(docDestino.getDocumentElement());

        /** Asignar conector al combo */
        HashMap campoGZ = new HashMap();
        campoGZ.put("campo","NOM");
		asignar("COMBO","comboGrupoFinal",transformar("XSLOrdenarGenerico",conectorGruposZonas),"dtoSalida.gruposzonas_ROWSET");
	}//cargarGrupoFinal()
	

  private Collection obtenerColeccionZonas(Collection zonasDeGrupos,String grupoDeZonas) throws Exception{

		Collection colZonas = new ArrayList();
		Iterator colGrupos = zonasDeGrupos.iterator();
		DTOCabecerasGruposZonas dto;
		while (colGrupos.hasNext()){
			dto = (DTOCabecerasGruposZonas)colGrupos.next();
			if ((dto.getOidGrupo().toString()).equals(grupoDeZonas)){
				colZonas = (ArrayList)dto.getZonas();
				return colZonas;
			}
		}
		return colZonas;

	}//obtenerColeccionZonas()

  //Convierte las zonas iniciales en un string para cuando el usuario presione limpiar
  private String zonasInicialesParaLimpiar(Collection zonas) throws Exception{
    StringBuffer resultado = new StringBuffer();
    Iterator colZonas = zonas.iterator();
		DTODetallesGruposZonas dtoDGZ;
		DTOZonas dtoZona;
		while (colZonas.hasNext()){
			dtoDGZ = (DTODetallesGruposZonas)colZonas.next();
			dtoZona = dtoDGZ.getZona();     
      resultado.append(dtoZona.getOidZona());
      resultado.append("~~");
      resultado.append(dtoZona.getDescZona());
      resultado.append("~~");
    }    
    return resultado.toString(); 
  }

  //Devuelve las zonas del grupo con su respectiva region para saber en cual
  //ponerla cuando el usuario la saca y aun no figura en la BD.
  private String zonasConSuRegion(Collection zonas) throws Exception{
    StringBuffer resultado = new StringBuffer();
    Iterator colZonas = zonas.iterator();
		DTODetallesGruposZonas dtoDGZ;
		DTOZonas dtoZona;
		while (colZonas.hasNext()){
			dtoDGZ = (DTODetallesGruposZonas)colZonas.next();
			dtoZona = dtoDGZ.getZona();     
      resultado.append(dtoZona.getOidZona());
      resultado.append("~~");
      resultado.append(dtoZona.getOidRegion());
      resultado.append("~~");
    }    
    return resultado.toString(); 
  }
  
	// Carga las zonas en el combo correspondiente
	private void cargarZonas(Collection zonas, String nombreCombo) throws Exception{

		StringBuffer salida = new StringBuffer();
		salida.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?><ROWSET NOMBRE=\"dtoSalida.resultado\" ID=\"dtoSalida.resultado\" FORMATO=\"MARETABLA\" LONGITUD=\"50\">");

		Iterator colZonas = zonas.iterator();
		DTODetallesGruposZonas dtoDGZ;
		DTOZonas dtoZona;
		while (colZonas.hasNext()){
			dtoDGZ = (DTODetallesGruposZonas)colZonas.next();
			dtoZona = dtoDGZ.getZona();
			
			salida.append("<ROW>");
			salida.append("<CAMPO NOMBRE=\"COD\" TIPO=\"STRING\">" + dtoZona.getOidZona() + "</CAMPO>");
			salida.append("<CAMPO NOMBRE=\"COD\" TIPO=\"STRING\">" + dtoZona.getDescZona() + "</CAMPO>");		
			salida.append("</ROW>");
		}
		salida.append("</ROWSET>");

		traza("Zonas:"+salida.toString());
		ByteArrayInputStream streamSalida = new ByteArrayInputStream(salida.toString().getBytes("ISO-8859-1"));
		Document docSalida = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(streamSalida);

		DruidaConector conectorPrueba = new DruidaConector();
		conectorPrueba.setXML(docSalida.getDocumentElement());
		asignar("COMBO",nombreCombo,conectorPrueba,"dtoSalida.resultado");
	
	}//cargarZonas()

  
	private String obtenerPrimerGrupoDistinto(Collection zonasDeGrupos,String grupoDeZonasBusqueda) throws Exception{
		
		Iterator colGrupos = zonasDeGrupos.iterator();
		traza("obtenerPrimerGrupoDistinto grupo zona:"+grupoDeZonasBusqueda);
		boolean exit = false;
		String grupo = "";
		DTOCabecerasGruposZonas dto;
		while ((colGrupos.hasNext()) && (!exit)){
			dto = (DTOCabecerasGruposZonas)colGrupos.next();
			traza("obtenerPrimerGrupoDistintoA"+dto);
			if (!((dto.getCodigoGrupo().toString()).equals(grupoDeZonasBusqueda))){
				traza("obtenerPrimerGrupoDistinto1");
				grupo = dto.getCodigoGrupo().toString();
				traza("obtenerPrimerGrupoDistinto2"+grupo);
				exit = true;
			}
			traza("obtenerPrimerGrupoDistinto3");
		}
		traza("obtenerPrimerGrupoDistinto4");
		return grupo;

	}//obtenerPrimerGrupoDistinto()

  private void actualizarCombos() throws Exception{
    
    pagina("contenido_entre_grupos_mover");

    String marca = conectorParametro("hMarca");
    String canal = conectorParametro("hCanal");
    
		String  grupoDeZonasBusqueda = conectorParametroLimpia("sGrupoDeZonasBusqueda","",true);
		String  grupoDeZonasPrevio = conectorParametroLimpia("sGrupoDeZonasPrevio","",true);
		String  grupoDeZonasActual = conectorParametroLimpia("comboGrupoFinal","",true);
		String  zonasInicial= conectorParametroLimpia("sZonasInicial","",true);
		String  zonasFinal = conectorParametroLimpia("sZonasFinal","",true);

    traza("actualizarCombos()1"+grupoDeZonasBusqueda +"   "+grupoDeZonasActual);
    traza("actualizarCombos()1"+zonasInicial +"   "+zonasFinal);
		Collection colDTOZonasInicial = this.convertirDTO(zonasInicial,pais,marca,canal);
		Collection colDTOZonasFinal = this.convertirDTO(zonasFinal,pais,marca,canal);

    traza("actualizarCombos()2"+zonasInicial);
		Collection zg = (Collection)conectorParametroSesion(GRUPOS_ZONAS);

		this.mover(grupoDeZonasBusqueda,colDTOZonasInicial,grupoDeZonasPrevio,colDTOZonasFinal,zg);

    traza("actualizarCombos()3"+grupoDeZonasPrevio);
		this.cargarGrupoFinal(zg,grupoDeZonasBusqueda);
		this.cargarGrupoInicial(zg,grupoDeZonasBusqueda);

    traza("actualizarCombos()4"+grupoDeZonasPrevio);
		Collection colZonasInicial = this.obtenerColeccionZonas(zg,grupoDeZonasBusqueda);
		this.cargarZonas(colZonasInicial,"comboZonas");

    traza("actualizarCombos()5"+grupoDeZonasActual);
		Collection colZonasFinal = this.obtenerColeccionZonas(zg,grupoDeZonasActual);
		this.cargarZonas(colZonasFinal,"comboZonas2");

		asignarAtributo("VAR","sGrupoDeZonasPrevio","valor",grupoDeZonasActual);
		asignarAtributo("VAR","sGrupoDeZonasBusqueda","valor",grupoDeZonasBusqueda);
    asignarAtributo("VAR","hMarca","valor",marca);
    asignarAtributo("VAR","hCanal","valor",canal);
    asignarAtributo("VAR","hPais","valor",pais);
               
	
	}//actualizarCombos()

  private Collection convertirDTO(String todasZonas,String pais,String marca,String canal) throws Exception{
		
		Collection colZonas = new ArrayList();
		StringTokenizer sToken = null;
		String value, text;
		
		if(todasZonas != null && todasZonas.length() != 0){

			sToken = new StringTokenizer(todasZonas,"~~");
			DTOZonas dtoZona;
			while (sToken.hasMoreTokens()){
				value = sToken.nextToken();
				text = sToken.nextToken();
				//DTODetallesGruposZonas dtoGZ = new DTODetallesGruposZonas();
				dtoZona = new DTOZonas();
        traza("Valor:"+value);
        traza("Texto:"+text);
				dtoZona.setOidZona(new Long(value));
				dtoZona.setPais(new Long(pais));
				dtoZona.setMarca(new Long(marca));
				dtoZona.setCanal(new Long(canal));
				//dtoGZ.setZona(dtoZona);
				colZonas.add(dtoZona);
			}
		}
		
		return colZonas;
	
	}//convertirDTO()
  
  private void mover(String codigoGrupoOrigen,Collection zonasOrigen,String codigoGrupoDestino,Collection zonasDestino, Collection grupos) throws Exception{
		traza("GRUPOS"+grupos);
	    DTOCabecerasGruposZonas cabeceraOrigen = getCabecera(codigoGrupoOrigen,grupos);
	    DTOCabecerasGruposZonas cabeceraDestino = getCabecera(codigoGrupoDestino,grupos);
	    sincronizar(zonasOrigen,cabeceraOrigen,cabeceraDestino);
	    sincronizar(zonasDestino,cabeceraDestino,cabeceraOrigen);
	}//mover()
  private void sincronizar(Collection requerido,DTOCabecerasGruposZonas cabeceraOrigen,DTOCabecerasGruposZonas cabeceraDestino) throws Exception{
	
    Iterator i = requerido.iterator();
    DTOZonas zona;
    Integer maximo;
    Collection detalles;
    DTODetallesGruposZonas detalle;
    while (i.hasNext()){
      zona = (DTOZonas)i.next();
      detalles = cabeceraOrigen.getZonas();
      traza("DETALLES"+detalles);

      if ((maximo = obtenerMaximoSiNoExiste(zona,detalles)) != null){
          detalle = obtenerDetalle(zona,cabeceraDestino);
          cabeceraDestino.getZonas().remove(detalle);
          traza("Saqué " + detalle + " de " + cabeceraDestino.getNombreGrupo());
          detalle.setCodigoGrupoDetalle(String.valueOf(maximo.intValue()+1));
          cabeceraOrigen.getZonas().add(detalle);
          traza("Agregue " + detalle + " a " + cabeceraOrigen.getNombreGrupo());
      }
    }

  }//sincronizar()
  
  private DTODetallesGruposZonas obtenerDetalle(DTOZonas buscado,DTOCabecerasGruposZonas cabecera){

	Iterator i = cabecera.getZonas().iterator();
	DTODetallesGruposZonas detalle;
    while (i.hasNext()){
        detalle = (DTODetallesGruposZonas)i.next();
        if (detalle.getZona().getOidZona().equals(buscado.getOidZona())){
          return detalle;
        }
    }
    
	return null;

  }//obtenerDetalle()

  //Devuelve null si <buscado> existe en la <coleccion>
  private Integer obtenerMaximoSiNoExiste(DTOZonas buscado,Collection coleccion) throws Exception{
	
	traza("COLECCION    " + coleccion + "      BUSCADO       " + buscado);
    Integer maximo = null;
    Integer valor;
    Iterator i = coleccion.iterator();

	if (!(i.hasNext()))
		maximo = new Integer(-1);

	DTODetallesGruposZonas detalle;
	while (i.hasNext()){
		detalle = (DTODetallesGruposZonas)i.next();
        
		if (zonasIguales(detalle.getZona(),buscado)){
          maximo = null;
          break;
        }
        
		valor = new Integer(detalle.getCodigoGrupoDetalle());
        if ((maximo == null) || (valor.intValue() > maximo.intValue()))
            maximo = valor;
    }
    
	return maximo;
  
  }//obtenerMaximoSiNoExiste()

  private boolean zonasIguales(DTOZonas existente,DTOZonas buscado){

    return ((existente.getOidZona().equals(buscado.getOidZona())) &&
              //(existente.getSubgerenciaVentas().equals(buscado.getSubgerenciaVentas())) &&
              (existente.getPais().equals(buscado.getPais())) && (existente.getMarca().equals(buscado.getMarca())) &&
              (existente.getCanal().equals(buscado.getCanal())));
  
  }//zonasIguales()
  private DTOCabecerasGruposZonas getCabecera(String codigo,Collection grupos) throws Exception{

	Iterator i = grupos.iterator();
    DTOCabecerasGruposZonas cabecera;
    while (i.hasNext()){
      cabecera = (DTOCabecerasGruposZonas)i.next();
      if (cabecera.getOidGrupo().toString().equals(codigo)) return cabecera;
    }
    return null;
  
  }//getCabecera()
  private void cargarCapaModificarDatos(DTOCabecerasGruposZonas grupo) throws Exception {
  
    asignarAtributo("CTEXTO","txtNombreDeGrupo","valor", grupo.getNombreGrupo());
    asignarAtributo("VAR","hNombreGrupo","valor", grupo.getNombreGrupo());
    asignarAtributo("VAR", "hFacturacion", "valor", grupo.getTipoFacturacion().toString());
    asignarAtributo("LABELC", "lblCodigoDeGrupo", "valor", grupo.getCodigoGrupo().toString());
    asignarAtributo("VAR", "hCodigoDeGrupo", "valor", grupo.getCodigoGrupo().toString());
    traza("Tipo Facturacion: ************* "+grupo.getTipoFacturacion());
    
  }//cargarCapaModificarDatos()  
//---------------------------------FIN METODOS DE APOYO------------------------------------------

//-------------------------------------METODOS  APOYO 2--------------------------------------

 private void consultar(String pais,String marca,String canal) throws Exception{
  //PARA ARBOLISTA
  pagina("contenido_grupos_zonas_modificar");
  cargaCombos(false); 
  traza("consultarzzz()1");
	Collection c = cargarArbol(pais,marca,canal);
  traza("consultarzzz()2");
	String s = armarArrayString(c);
  traza("consultarzzz()3");
	asignarAtributo("VAR","hArbol","valor",s);
  traza("consultarzzz()fin");
	asignarAtributo("CAPA","capaMostrarArbolGruposZonas","visibilidad","visible");
  }//consultar()

  private Collection cargarArbol(String pais,String marca,String canal) throws Exception{

	DTOEntradaCalendario dtoe = new DTOEntradaCalendario();
	dtoe.setPais(new Long(pais));
	dtoe.setMarca(new Long(marca));
	dtoe.setCanal(new Long(canal));

	Vector paramEntrada = new Vector();
	paramEntrada.add(dtoe);
	paramEntrada.add(new MareBusinessID("CRAConsultarGruposZonasDetalles"));

	DruidaConector conectorObtenZonasPorGruposZonas = conectar("ConectorObtenZonasPorGruposZonas",paramEntrada);
	IMareDTO dto = (IMareDTO)conectorObtenZonasPorGruposZonas.objeto("DTO");
	Collection colGruposZonas = (Collection)dto.getProperty("resultado");

  traza("Recultados:"+colGruposZonas);
	//Se verifica si la collection trae elementos
	//Si esta vacia se asigna el error a la pagina ("No hay datos")
	Iterator it = colGruposZonas.iterator();
	MareException me = new MareException();
  
	if(!it.hasNext()){
		asignarAtributo("VAR","errCodigo", "valor", "" + "5");
		asignarAtributo("VAR","errDescripcion", "valor", "No hay datos");
	}
	
	return colGruposZonas;
	
   }//cargarArbol()

	//Este metodo toma los datos de Grupos y Zonas y los vuelca en un String
	//con formato de array javascript, para que el javascript de la pagina
	//lo evalue y asigne al ARBOLLISTA	 
	private String armarArrayString(Collection c){

		DTOCabecerasGruposZonas dtoCGZ = null;
		DTODetallesGruposZonas dtoDGZ = null;
		DTOGruposZonas dtoGZ = null;
		DTOZonas dtoZ = null;

		String sCodGrupo = null;
		String sNomGrupo = null;
		String sZona = null;
		String sLineaVector = null;
		String sTempStr = null;
		String sTipoFact = null;

		StringBuffer sbArbol = new StringBuffer();
		StringBuffer sbZonas = null;

		Collection zonas = null;
		
		Iterator iZonas = null;

		boolean firstLine = true;

		try{
	      Iterator i = c.iterator();
	      sbArbol.append("[");

	      while(i.hasNext()){
	  		String textoTipoFact = null;
	        dtoCGZ = (DTOCabecerasGruposZonas)i.next();
	        sCodGrupo = dtoCGZ.getCodigoGrupo().toString();  //getCodigoGrupo devuelve un Integer
	        sNomGrupo = dtoCGZ.getNombreGrupo();
			sTipoFact = dtoCGZ.getTipoFacturacion().toString();
		
			if (sTipoFact.equals("0"))
			{ textoTipoFact = "MONO";
			}else if (sTipoFact.equals("1"))
			{ textoTipoFact = "MULTI";
			}else if (sTipoFact.equals("2"))
			{ textoTipoFact = "SEMANAL";
			}
	        //Cargar la linea que representa al grupo en el StringBuffer
		    sTempStr = "[\'" + sCodGrupo + "\',null,[\'" + sNomGrupo + "\',\'" + textoTipoFact + "\']]";
	        sLineaVector = (firstLine) ? sTempStr : "," + sTempStr;
        
			if (firstLine)
				firstLine  = false;

			sbArbol.append(sLineaVector);

			//Se obtienen las zonas para el grupo con el que estamos trabajando
			zonas = dtoCGZ.getZonas();

			//Si hay zonas en este grupo
			if(zonas != null){
				iZonas = zonas.iterator();
				while(iZonas.hasNext()){
					dtoDGZ = (DTODetallesGruposZonas)iZonas.next();
					dtoZ = dtoDGZ.getZona();
					sZona = dtoZ.getCodigoZona();
					sLineaVector = ",[\'" + sCodGrupo + "." + sZona + "\',null,[\'" + sZona + "\']]";
					sbArbol.append(sLineaVector);
				}//while
			}
		  }//while

		  sbArbol.append("]");
        
		}catch(Exception e){
			return "[]";
		}
  
		return sbArbol.toString();

	}//armarArrayString()

//---------------------------------FIN METODOS APOYO 2--------------------------------------

//---------------------------------METODOS VIEJOS------------------------------------------ 

	// Carga el Combo GrupoDeZonasAsignar para la accion asignar.. si es posible optimizar
	private void cargarGrupoDeZonasAsignar(DTOCabecerasGruposZonas dtoCabecera) throws Exception{
	
    if (dtoCabecera.getNombreGrupo()!=null)
        asignarAtributo("LABELC","lblGrupoInicialXX","valor",dtoCabecera.getNombreGrupo());
    else
        asignarAtributo("LABELC","lblGrupoInicialXX","valor","No hay Nombre");

	}//cargarGrupoDeZonasAsignar()

  //Actualiza las zonas del Grupo Seleccionado y de las zonas de la region
	private void asignarZonasAGrupo() throws Exception{

		String zonasInicial= conectorParametroLimpia("sZonasInicial","",true);
    String pais = conectorParametro("hPais");
    String marca = conectorParametro("hMarca");
    String canal = conectorParametro("hCanal");

		//Obtiene el DTOCabeceraGruposZonas del Grupo a asignar zonas
		Collection colDTODetallesCGZ = this.convertirDTODetallesGruposZonas(zonasInicial,pais,marca,canal);

		//Obtiene DTOCabeceraGruposZonas del Grupo a asignar que se encuentra en la sesion
		DTOCabecerasGruposZonas dtoCabGZSesion = (DTOCabecerasGruposZonas)conectorParametroSesion(GRUPO_ASIGNAR);
    
		traza("ANTES DEL CAMBIO");
		traza("SESION GZ"+dtoCabGZSesion);
		traza("FIN ANTES DEL CAMBIO---------------------------------");

    dtoCabGZSesion.setZonas(colDTODetallesCGZ);

		traza("DESPUES DEL CAMBIO-------------------------------------");
		traza("DTOSESSION:"+dtoCabGZSesion);
		traza("FIN DEL CAMBIO");
    
	    conectorParametroSesion(GRUPO_ASIGNAR,dtoCabGZSesion);
      
	}//asignarZonasAGrupo()

	
  
  //Convierte todas las zonas detectadas en un String en DTODetallesGruposZonas
  private Collection convertirDTODetallesGruposZonas(String todasZonas,String pais,String marca,String canal){
	
	Collection colZonas = new ArrayList();
	StringTokenizer sToken = null;
	String value,text;
	
	if(todasZonas != null && todasZonas.length() != 0){
		sToken = new StringTokenizer(todasZonas,"~~");
		DTOZonas dtoZona;
		while (sToken.hasMoreTokens()){
			value = sToken.nextToken();
			text = sToken.nextToken();
			DTODetallesGruposZonas dtoDGZ = new DTODetallesGruposZonas();
			dtoZona = new DTOZonas();
			dtoZona.setCodigoZona(value);
      dtoZona.setOidZona(new Long(value));
			dtoZona.setPais(new Long(pais));
			dtoZona.setMarca(new Long(marca));
			dtoZona.setCanal(new Long(canal));
			dtoDGZ.setZona(dtoZona);
			colZonas.add(dtoDGZ);
		}
	 }
	
	 return colZonas;

	}//convertirDTODetallesGruposZonas() 

//---------------------------------FIN METODOS VIEJOS------------------------------------------

//----------------------------------METODOS EN DESUSO-------------------------------------------
/*  

  
    String marca = conectorParametroLimpia("cbMarcas","",true);
    String canal = conectorParametroLimpia("cbCanales","",true);
    String nombreGrupo = conectorParametroLimpia("hNombreGrupo","",true);
    String regionPrevia = conectorParametroLimpia("sRegionPrevia","",true);
    String grupoDeZonasPrevio = conectorParametroLimpia("sGrupoDeZonasPrevio","",true);
    String grupoDeZonasBusqueda = conectorParametroLimpia("sGrupoDeZonasBusqueda","",true);
    String vZonasAsignadasOriginales = conectorParametroLimpia("vZonasAsignadasOriginales","",true);
    String tZonasAsignadasOriginales = conectorParametroLimpia("tZonasAsignadasOriginales","",true);
    String vZonasRegionesOriginales = conectorParametroLimpia("vZonasRegionesOriginales","",true);
    String tZonasRegionesOriginales = conectorParametroLimpia("tZonasRegionesOriginales","",true);
	
    boolean error=false;
		 
    nombreGrupo = (nombreGrupo == null) ? "" : nombreGrupo;
    regionPrevia = (regionPrevia == null) ? "" : regionPrevia;
    grupoDeZonasPrevio = (grupoDeZonasPrevio == null) ? "" : grupoDeZonasPrevio;

    vZonasAsignadasOriginales = (vZonasAsignadasOriginales == null) ? "" : vZonasAsignadasOriginales;
    tZonasAsignadasOriginales = (tZonasAsignadasOriginales == null) ? "" : tZonasAsignadasOriginales;
    vZonasRegionesOriginales = (vZonasRegionesOriginales == null) ? "" : vZonasRegionesOriginales;
    tZonasRegionesOriginales = (tZonasRegionesOriginales == null) ? "" : tZonasRegionesOriginales;

      asignarAtributo("VAR","hNombreGrupo","valor",nombreGrupo);
      asignarAtributo("VAR","sGrupoDeZonasPrevio","valor",regionPrevia);
      asignarAtributo("VAR","sGrupoDeZonasBusqueda","valor",grupoDeZonasPrevio);
      asignarAtributo("VAR","vZonasAsignadasOriginales","valor",vZonasAsignadasOriginales);
      asignarAtributo("VAR","tZonasAsignadasOriginales","valor",tZonasAsignadasOriginales);
      asignarAtributo("VAR","vZonasRegionesOriginales","valor",vZonasRegionesOriginales);
      asignarAtributo("VAR","tZonasRegionesOriginales","valor",tZonasRegionesOriginales);
*/

	private Collection obtenerZonasPorGruposZonas(String pais,String marca,String canal) throws Exception{

		DTOEntradaCalendario dtoe = new DTOEntradaCalendario();
		Collection colGruposZonas = new ArrayList();

		dtoe.setPais(new Long(pais));
		dtoe.setMarca(new Long(marca));
		dtoe.setCanal(new Long(canal));

		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoe);
		paramEntrada.add(new MareBusinessID("CRAConsultarGruposZonasDetalles"));

		DruidaConector conectorObtenZonasPorGruposZonas = conectar("ConectorObtenZonasPorGruposZonas",paramEntrada);
		IMareDTO dto = (IMareDTO)conectorObtenZonasPorGruposZonas.objeto("DTO");
		
		colGruposZonas = (Collection)dto.getProperty("resultado");

		Iterator colGrupos = colGruposZonas.iterator();
		DTOCabecerasGruposZonas dtoCabecera;
		while (colGrupos.hasNext()){
			dtoCabecera = (DTOCabecerasGruposZonas)colGrupos.next();
			if (dtoCabecera.getZonas() == null){
				dtoCabecera.setZonas(new ArrayList());
			} 
		}

		return colGruposZonas;
		
	}//obtenerZonasPorGruposZonas()  
//------------------------------FIN-METODOS EN DESUSO-------------------------------------------  
}
