   /**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
//import LPSICCBase;
import es.indra.sicc.dtos.men.DTOEntradaFuncionSeleccionada;
import es.indra.sicc.dtos.men.DTOEntradaPresentarMenu;
import es.indra.sicc.dtos.men.DTOModificarElementoMenu;

import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;
import java.util.HashMap;


/**
 * Sistema:             Belcorp - SICC
 * Modulo:               MEN - Menu
 * Componente:         LPModificarElementoDeMenu
 * Fecha:                 07/04/2003
 * Dcoumentacion:    Este componente se construyó de acuerdo a los siguientes
 *                          documentos: SICC-DMCO-MEN-201-307
 * Observaciones:
 * @version            1.0
 * @author             Gaston Acevedo
 */
public class LPModificarElementoDeMenu extends LPSICCBase {
   private final String nombreLogica = "LPModificarElementoDeMenu";
   private String nombreFuncionSalida = "";
   private String idFuncion = "";
   private String nombrePrograma = "";
   private String nodoFinal = "";
   private String indicadorRastreo = "";
   private String jerarquia = "";
   
   public LPModificarElementoDeMenu() {
      super();
   }

   public void inicio() throws Exception {
      ;
   }

   public void ejecucion() throws Exception {
      setTrazaFichero();
      try {
         
         String accion = conectorParametroLimpia("accion", "", true);
         if (accion.equals("")) {
            inicioLP();
            obtenerFuncionesMenu(0);
            getConfiguracionMenu(nombreLogica, accion);
         } else if(accion.equals("seleccion"))  {
            pagina("contenido_elemento_menu_modificar");
            asignarAtributo("VAR", "conectorAction", "valor", nombreLogica);
            asignarAtributo("VAR", "accion", "valor", "grabar");
            asignarAtributo("VAR", "seleccion", "valor", conectorParametroLimpia("seleccion","",true));
            asignarAtributo("VAR", "nivel", "valor", conectorParametroLimpia("nivel","",true));
            obtenerFuncionesMenu(1);
            getConfiguracionMenu(nombreLogica, accion);
         }else{//graba            
            inicioLP();
			grabarDatos();
            obtenerFuncionesMenu(0);
            getConfiguracionMenu(nombreLogica, "");
         }
      } catch (Exception e) {
         ByteArrayOutputStream pila = new ByteArrayOutputStream();
         PrintStream out = new PrintStream(pila);
         e.printStackTrace(out);
         traza("EL STACK ES COMO SIGUE : " + pila.toString());
         lanzarPaginaError(e);
      }
   }

   private void grabarDatos()throws Exception{
      traza("grabando Datos");
      String nombreFuncion = conectorParametroLimpia("hidNombre","",true);
      String rastreo = conectorParametroLimpia("hidRastreo","",true);
      String tipoFuncion = conectorParametroLimpia("hidNivel","",true);
      String nombrePrograma = conectorParametroLimpia("hidEjecutable","",true);
      String oidJerarquia = conectorParametroLimpia("hidJerarquia","",true);
      String oidFuncion = conectorParametroLimpia("seleccion","",true);

      traza("nombreFuncion: "+nombreFuncion);
      traza("rastreo: "+rastreo);
      traza("tipoFuncion: "+tipoFuncion);
      traza("nombrePrograma: "+nombrePrograma);
      traza("oidJerarquia: "+oidJerarquia);
      traza("oidFuncion: "+oidFuncion);
      
      DTOModificarElementoMenu dtoe = new DTOModificarElementoMenu();

	  String usuario = (String)conectorParametroSesion("DruidaUsuario");
	  String contrasenia = (String)conectorParametroSesion("DruidaPassword");
	  dtoe.setUsuario(usuario);
	  dtoe.setPassword(contrasenia);		

      Vector descripciones = new Vector();
      DTOI18nSICC dtoIdioma = new DTOI18nSICC();
      dtoIdioma.setOidAtriuto(new Long(1));
      dtoIdioma.setValorI18n(nombreFuncion);
      dtoIdioma.setOidIdioma(UtilidadesSession.getIdioma(this));
      descripciones.add(dtoIdioma);
      
      //dtoe.setIdIdioma(descripciones);
      dtoe.setIndicadorRastreo( new Boolean(((rastreo.equals("S")?"true":"false"))));
      dtoe.setIndicadorFuncionFinal(new Boolean(((tipoFuncion.equals("S")?"true":"false"))));
      dtoe.setNombreFuncion(descripciones);
      dtoe.setIdFuncion(new Long(oidFuncion));
      dtoe.setIdFuncionJerarquiaDestino(new Long(oidJerarquia));
      dtoe.setProgramaEjecutable(nombrePrograma);
      dtoe.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
      dtoe.setPrograma(UtilidadesSession.getFuncion(this));
      Vector params = new Vector();
      params.add(dtoe);
      params.add(new MareBusinessID("MENModificaElementoMenu"));
      conectar("ConectorModificarElementoMenu", params);
   }

   private void inicioLP()throws Exception{
      pagina("contenido_jerarquia_menu_seleccionar");
      asignarAtributoPagina("cod", "029");
      asignarAtributo("VAR", "conectorAction", "valor", nombreLogica);
      asignarAtributo("VAR", "accion", "valor", "seleccion");
		asignarAtributo("VAR", "modificable", "valor",conectorParametroLimpia("modificable","0",true) );
      asignarAtributo("VAR", "seleccion", "valor", conectorParametroLimpia("seleccion","",true));
      asignarAtributo("CAPA","capaInsertar","visibilidad","hidden");
      asignarAtributo("CAPA","capaModificar","visibilidad","visible");
   }
   
   private void obtenerFuncionesMenu(int tipo) throws Exception {
      Vector params = new Vector();
      DTOEntradaPresentarMenu dtoe = new DTOEntradaPresentarMenu();
	  String usuario = (String)conectorParametroSesion("DruidaUsuario");
	  String contrasenia = (String)conectorParametroSesion("DruidaPassword");
	  dtoe.setUsuario(usuario);
	  dtoe.setPassword(contrasenia);
		
      dtoe.setIdIdioma(UtilidadesSession.getIdioma(this));
      params.add(dtoe);
      params.add(new MareBusinessID("MENObtenerFunciones"));
      DruidaConector conectorFunciones = conectar("ConectorConsultarFunciones", params);
      HashMap mapa = new HashMap();
      if (tipo == 0){
         mapa.put("menu","1");
         asignar("REJILLA", "RArbol", transformar("XSLFuncionesMenu_Consultar",conectorFunciones,mapa));
      }else{
         obtenerDescripcionFuncion();
         String oidFuncion = conectorParametroLimpia("seleccion","",true);
         mapa.put("seleccion",oidFuncion);
         mapa.put("padre",jerarquia);
         String nivel = conectorParametroLimpia("nivel","",true);
         traza("nivel:"+ nivel);
         if(nivel.length()>0){
            mapa.put("nivel",nivel);   
         }
         asignar("REJILLA", "RArbol", transformar("XSLFuncionesMenu_Modificar",conectorFunciones,mapa));
      }
   }

   private void obtenerDescripcionFuncion()throws Exception{

      String oidFuncion = conectorParametroLimpia("seleccion","",true);
      String nombreFuncion = conectorParametroLimpia("nombreFuncion","",true);

      DTOEntradaFuncionSeleccionada dtoe = new DTOEntradaFuncionSeleccionada();

	  String usuario = (String)conectorParametroSesion("DruidaUsuario");
	  String contrasenia = (String)conectorParametroSesion("DruidaPassword");
	  dtoe.setUsuario(usuario);
	  dtoe.setPassword(contrasenia);
		
      dtoe.setId(new Long(oidFuncion));
      dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoe.setNombreFuncion(nombreFuncion);
      dtoe.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
      dtoe.setPrograma(UtilidadesSession.getFuncion(this));

      Vector params = new Vector();
      params.add(dtoe);
      params.add(new MareBusinessID("MENConsultaElementoMenu"));
      DruidaConector conectorFuncion = conectar("ConectorConsultarElementoDeMenu", params);

      DTOSalida salida = (DTOSalida)conectorFuncion.objeto("dtoSalida");
      RecordSet descFuncion = (RecordSet)salida.getResultado();

      nombreFuncionSalida = descFuncion.getValueAt(0,1).toString();
      idFuncion = descFuncion.getValueAt(0,0).toString();
      if(descFuncion.getValueAt(0,2)!=null){
          nombrePrograma = descFuncion.getValueAt(0,2).toString();
      }else{
         traza("no trae el programa ejecutable");
      }
      if(descFuncion.getValueAt(0,3)!=null){
         jerarquia = descFuncion.getValueAt(0,3).toString();





      }else{
         traza("no trae la jerarquia");
      }
      nodoFinal = ((descFuncion.getValueAt(0,4).toString().equals("0"))?"N":"S");
      indicadorRastreo = ((descFuncion.getValueAt(0,5).toString().equals("0"))?"N":"S");
      
      asignarAtributo("CTEXTO","txtNombreElementoMenu","valor",nombreFuncionSalida);
      asignarAtributo("CTEXTO","txtProgramaEjecutable","valor",nombrePrograma);
      asignarAtributo("VAR","hidRastreo","valor",indicadorRastreo);
      asignarAtributo("VAR","hidNivel","valor",nodoFinal);
		asignarAtributo("VAR", "modificable", "valor",conectorParametroLimpia("modificable","0",true) );
   }


   private void traza(String mensaje){
      try{
         if(mensaje != null){
            System.out.println(mensaje);   
            super.traza(mensaje);
         }
      }catch(Exception e){
         ;//lo siento
      }
   }
}
