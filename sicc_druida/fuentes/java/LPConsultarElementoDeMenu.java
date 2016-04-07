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

import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

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
public class LPConsultarElementoDeMenu extends LPSICCBase {
   private final String nombreLogica = "LPConsultarElementoDeMenu";

   public LPConsultarElementoDeMenu() {
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
            pagina("contenido_jerarquia_menu_seleccionar");
            asignarAtributoPagina("cod", "05");
            asignarAtributo("VAR", "conectorAction", "valor", nombreLogica);
            asignarAtributo("VAR", "accion", "valor", "consultar");
            asignarAtributo("CAPA","capaInsertar","visibilidad","hidden");
            asignarAtributo("CAPA","capaConsultar","visibilidad","visible");
            obtenerFuncionesMenu();
         } else  {
            pagina("contenido_elemento_menu_consultar");
            asignarAtributoPagina("cod", "05");
            asignarAtributo("VAR", "conectorAction", "valor", nombreLogica);
            asignarAtributo("VAR", "accion", "valor", "");
            obtenerDescripcionFuncion();
         }
         getConfiguracionMenu(nombreLogica, accion);

      } catch (Exception e) {
         ByteArrayOutputStream pila = new ByteArrayOutputStream();
         PrintStream out = new PrintStream(pila);
         e.printStackTrace(out);
         traza("EL STACK ES COMO SIGUE : " + pila.toString());
         lanzarPaginaError(e);
      }
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
      asignar("REJILLA", "RArbol", transformar("XSLFuncionesMenu_Consultar",conectorFunciones));
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

      String nombreFuncionSalida = descFuncion.getValueAt(0,1).toString();
      String idFuncion = descFuncion.getValueAt(0,0).toString();
      String nombrePrograma = "";
      if(descFuncion.getValueAt(0,2)!=null){
          nombrePrograma = descFuncion.getValueAt(0,2).toString();
      }
      String nodoFinal = ((descFuncion.getValueAt(0,4).toString().equals("0"))?"N":"S");
      String indicadorRastreo = ((descFuncion.getValueAt(0,5).toString().equals("0"))?"N":"S");
      
      asignarAtributo("CTEXTO","txtNombreElementoMenu","valor",nombreFuncionSalida);
      asignarAtributo("CTEXTO","txtProgramaEjecutable","valor",nombrePrograma);
      asignarAtributo("VAR","hidRastreo","valor",indicadorRastreo);
      asignarAtributo("VAR","hidNivel","valor",nodoFinal);
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
