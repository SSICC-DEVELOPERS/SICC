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

import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;


/**
 * Sistema:             Belcorp - SICC
 * Modulo:               MEN - Menu
 * Componente:         LPInsertarElementoMenu
 * Fecha:                 07/04/2003
 * Dcoumentacion:    Este componente se construyó de acuerdo a los siguientes
 *                          documentos: SICC-DMCO-MEN-201-307
 * Observaciones:
 * @version            1.0
 * @author             Gaston Acevedo
 */
public class LPEliminarElementoDeMenu extends LPSICCBase {
   private final String nombreLogica = "LPEliminarElementoDeMenu";

   public LPEliminarElementoDeMenu() {
      super();
   }

   public void inicio() throws Exception {
      pagina("contenido_jerarquia_menu_seleccionar");
   }

   public void ejecucion() throws Exception {
      setTrazaFichero();
      try {
         String accion = conectorParametroLimpia("accion", "", true);
         if (accion.equals("")) {
            inicioLp();
            asignarAtributo("VAR", "accion", "valor", "eliminar");
            obtenerFuncionesMenu();
            getConfiguracionMenu(nombreLogica, accion);
         } else{//viene de seleccionar la funcion
            inicioLp();
            grabarDatos();
            asignarAtributo("VAR", "accion", "valor", "");
            obtenerFuncionesMenu();
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

   private void inicioLp() throws Exception{
      asignarAtributo("VAR", "conectorAction", "valor", nombreLogica);
      asignarAtributo("CAPA","capaInsertar","visibilidad","hidden");
      asignarAtributo("CAPA","capaEliminar","visibilidad","visible");
      asignarAtributoPagina("cod","09");
         
   }

   private void obtenerFuncionesMenu() throws Exception {
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
      asignar("REJILLA", "RArbol", transformar("XSLFuncionesMenu_Elminar",conectorFunciones));
   }

   private void grabarDatos() throws Exception{
      traza("Eliminando");

      String oidFuncion = conectorParametroLimpia("seleccion","",true);
      String nombreFuncion = conectorParametroLimpia("nombreFuncion","",true);

      traza("oidFuncion: "+oidFuncion);
      
      DTOEntradaFuncionSeleccionada dtoe = new DTOEntradaFuncionSeleccionada();
 	  String usuario = (String)conectorParametroSesion("DruidaUsuario");
	  String contrasenia = (String)conectorParametroSesion("DruidaPassword");
	  dtoe.setUsuario(usuario);
	  dtoe.setPassword(contrasenia);
      dtoe.setId(new Long(oidFuncion));
      dtoe.setNombreFuncion(nombreFuncion);
      dtoe.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
      dtoe.setPrograma(UtilidadesSession.getFuncion(this));

      Vector params = new Vector();
      params.add(dtoe);
      params.add(new MareBusinessID("MENEliminaElementoMenu"));
      conectar("ConectorEliminarElementodeMenu", params);
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
