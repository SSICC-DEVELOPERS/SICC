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
import es.indra.sicc.dtos.men.DTOEntradaInsertarElementodeMenu;
import es.indra.sicc.dtos.men.DTOEntradaPresentarMenu;

import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.math.BigDecimal;
import es.indra.sicc.util.DTOSalida;


/**
 * Sistema:              Belcorp - SICC
 * Modulo:                 MEN - Menu
 * Componente:          LPInsertarElementoMenu
 * Fecha:                   07/04/2003
 * Dcoumentacion:    Este componente se construyó de acuerdo a los siguientes
 *                             documentos: SICC-DMCO-MEN-201-307
 * Observaciones:
 * @version             1.0
 * @author              Gaston Acevedo
 */
public class LPInsertarElementoMenu extends LPSICCBase {
   private final String nombreLogica = "LPInsertarElementoMenu";
   private int nextRow = 1;

   public LPInsertarElementoMenu() {
      super();
   }

   public void inicio() throws Exception {
      ;
   }

   public void ejecucion() throws Exception {
                  rastreo();
      setTrazaFichero();
      try {
          String accion = conectorParametroLimpia("accion", "", true);
          if (accion.equals("")) {
             inicioLp();
             obtenerFuncionesMenu();
             getConfiguracionMenu(nombreLogica, accion);
          } else if(accion.equals("seleccionar")) {//viene de seleccionar la funcion
             pagina("contenido_elemento_menu_insertar");
             asignarAtributo("VAR", "conectorAction", "valor", nombreLogica);
             asignarAtributo("VAR", "accion", "valor", "grabar");
             asignarAtributo("VAR", "seleccion", "valor", conectorParametroLimpia("seleccion","",true));
             getConfiguracionMenu(nombreLogica, accion);
          }else{//viene de completar los datos, grabo             
             //inicioLp();
             grabarDatos();
             //obtenerFuncionesMenu();   
             //getConfiguracionMenu(nombreLogica, "");
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
      pagina("contenido_jerarquia_menu_seleccionar");
      asignarAtributoPagina("cod", "048");
      asignarAtributo("VAR", "conectorAction", "valor", nombreLogica);
      asignarAtributo("VAR", "accion", "valor", "seleccionar");
      asignarAtributo("CAPA", "capaInsertar", "visibilidad", "visible");
      asignarAtributo("CAPA", "capaEliminar", "visibilidad", "hidden");
      asignarAtributo("CAPA", "capaConsultar", "visibilidad", "hidden");
      asignarAtributo("CAPA", "capaModificar", "visibilidad", "hidden");
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
                  
                  DTOSalida dto = (DTOSalida)conectorFunciones.objeto("dtoSalida");
                  RecordSet recordset = (RecordSet)dto.getResultado();
                  //traza(crearArbol(recordset).getXML().toString());
      //asignar("REJILLA", "RArbol", transformar("XSLFuncionesMenu_Mantenimiento",conectorFunciones));
                  DruidaConector drd = new DruidaConector();
                  drd.setXML(crearArbol(recordset).getXML());
                  asignar("REJILLA", "RArbol", drd);
   }

   private void grabarDatos() throws Exception{
      traza("grabando Datos");
      pagina("salidaGenerica");
      String nombreFuncion = conectorParametroLimpia("hidNombre","",true);
      String rastreo = conectorParametroLimpia("hidRastreo","",true);
      String tipoFuncion = conectorParametroLimpia("hidNivel","",true);
      String nombrePrograma = conectorParametroLimpia("hidEjecutable","",true);
      String oidJerarquia = conectorParametroLimpia("seleccion","",true);

      traza("nombreFuncion: "+nombreFuncion);
      traza("rastreo: "+rastreo);
      traza("tipoFuncion: "+tipoFuncion);
      traza("nombrePrograma: "+nombrePrograma);
      traza("oidJerarquia: "+oidJerarquia);

      DTOEntradaInsertarElementodeMenu dtoe = new DTOEntradaInsertarElementodeMenu();

	  String usuario = (String)conectorParametroSesion("DruidaUsuario");
	  String contrasenia = (String)conectorParametroSesion("DruidaPassword");
	  dtoe.setUsuario(usuario);
	  dtoe.setPassword(contrasenia);
		

      Vector descripciones = new Vector();
      DTOI18nSICC dtoIdioma = new DTOI18nSICC();
      dtoIdioma.setOidAtriuto(new Long(1));
      dtoIdioma.setValorI18n(nombreFuncion);
      //dtoIdioma.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoIdioma.setOidIdioma(new Long("1"));
      descripciones.add(dtoIdioma);
      
      dtoe.setIdIdioma(descripciones);
      dtoe.setIndicadorDeRastreo( new Boolean(((rastreo.equals("S")?"true":"false"))));
      dtoe.setIndicadorFunciónFinal(new Boolean(((tipoFuncion.equals("S")?"true":"false"))));
      dtoe.setNombreElementoMenu(nombreFuncion);
      dtoe.setNombreProgramaEjecutable(nombrePrograma);
      dtoe.setIdFuncJerarquia(new Long(oidJerarquia));
      dtoe.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
      dtoe.setPrograma(UtilidadesSession.getFuncion(this));
      Vector params = new Vector();
      params.add(dtoe);
      params.add(new MareBusinessID("MENInsertaElementoMenu"));
      conectar("ConectorInsertarElementodeMenu", params);
   }




   private DruidaDOMObjeto crearArbol(RecordSet recordSet) throws Exception{

      DruidaDOMObjeto miObj = new DruidaDOMObjeto();
      Document document = getXML();

      Element element = document.createElement("ARBOL");

      element.setAttribute("x", "0");
      element.setAttribute("y", "0");
      element.setAttribute("nombre", "menu");
      element.setAttribute("id", "menu");
      element.setAttribute("ancho", "750");
      element.setAttribute("alto", "");
      element.setAttribute("colorf", "#999999");
      element.setAttribute("visibilidad", "");
      element.setAttribute("incx", "5");
      element.setAttribute("incy", "5");
      element.setAttribute("altofila", "19");
      element.setAttribute("indentado", "10");
      //element.setAttribute("padreSeleccionable", "S");
      //element.setAttribute("dobleClickAbre", "S");

      Element element2 = document.createElement("ICONOS");
      element.appendChild(element2);

      /*Element element3b = document.createElement("ICONO");
      element3b.setAttribute("src", "flechaMenuHorzG.gif");
      element2.appendChild(element3b);*/
      
      Element element3_0 = document.createElement("ICONO");
      element3_0.setAttribute("src", "b.gif");
      element2.appendChild(element3_0);

      Element element3_1 = document.createElement("ICONO");
      element3_1.setAttribute("src", "flechaMenuVert.gif");
      element2.appendChild(element3_1);

      Element element3_2 = document.createElement("ICONO");
      element3_2.setAttribute("src", "flechaMenuHorz.gif");
      element2.appendChild(element3_2);


      Element element4 = document.createElement("RAMA");
      element4.setAttribute("nombre", "root");
      element4.setAttribute("icono", "");
      element4.setAttribute("codigo", "root");
      element4.setAttribute("texto", "BELCORP");
      element.appendChild(element4);

      //element4.setAttribute("padreSeleccionable", "S");
      //element4.setAttribute("dobleClickAbre","S"); 
      crearHijos(element4, document, recordSet);

      miObj.setXML(element);
      return miObj;
   }

  /* private void crearHijos(Element padre, Document document, RecordSet recordSet) throws Exception{
      Element element;

      Vector filaSig, fila = recordSet.getRow(nextRow);
      int levelOriginal = ((BigDecimal)fila.elementAt(6)).intValue();
         while((levelOriginal == ((BigDecimal)fila.elementAt(6)).intValue()) && (nextRow < recordSet.getRowCount())){
         ++nextRow;
          if(nextRow == recordSet.getRowCount()){
             element = document.createElement("HOJA");
             element.setAttribute("nombre", ((BigDecimal)fila.elementAt(0)).toString()); 
             element.setAttribute("codigo", ((BigDecimal)fila.elementAt(0)).toString());
             element.setAttribute("texto", (String)fila.elementAt(1));
             element.setAttribute("icono", "0");
             element.setAttribute("onclick", "");
             padre.appendChild(element);
          }else{
             filaSig = recordSet.getRow(nextRow);
             if(((BigDecimal)filaSig.elementAt(6)).intValue() <= levelOriginal){
                 // HOJA
                 element = document.createElement("HOJA");
                 element.setAttribute("nombre", ((BigDecimal)fila.elementAt(0)).toString());
                 element.setAttribute("codigo", ((BigDecimal)fila.elementAt(0)).toString());
                 element.setAttribute("texto", fila.elementAt(1).toString());
                 element.setAttribute("icono", "0");
                 element.setAttribute("onclick", "");
             } else{
                 // NIVEL INTERMEDIO
                 element = document.createElement("RAMA");

                                    //element.setAttribute("padreSeleccionable", "S");
                                    //element.setAttribute("dobleClickAbre","S"); 

                 element.setAttribute("nombre", ((BigDecimal)fila.elementAt(0)).toString());
                 element.setAttribute("icono", "2");
                 element.setAttribute("codigo", ((BigDecimal)fila.elementAt(0)).toString());
                 element.setAttribute("texto", fila.elementAt(1).toString());
                 element.setAttribute("onclick", "seleccionMenu(\\'" + ((BigDecimal)fila.elementAt(0)).toString() + "\\');");
                 crearHijos(element, document, recordSet);
             }

             padre.appendChild(element);
             if(nextRow < recordSet.getRowCount()){
                 fila = recordSet.getRow(nextRow);
             }
          }
      }
   }*/
   
  private void crearHijos(Element padre, Document document, RecordSet recordSet) throws Exception{
      Element element;


      Vector filaSig, fila = recordSet.getRow(nextRow);


      int levelOriginal = ((BigDecimal)fila.elementAt(6)).intValue();
         while((levelOriginal == ((BigDecimal)fila.elementAt(6)).intValue()) && (nextRow < recordSet.getRowCount())){
         ++nextRow;
          if(nextRow == recordSet.getRowCount()){
             element = document.createElement("HOJA");
             element.setAttribute("nombre", extenderLongitudCodigo(((BigDecimal)fila.elementAt(0)).toString(), 12)); 
             element.setAttribute("codigo", extenderLongitudCodigo(((BigDecimal)fila.elementAt(0)).toString(), 12));
             element.setAttribute("texto", (String)fila.elementAt(1));
             element.setAttribute("icono", "0");
             element.setAttribute("onclick", "");
             padre.appendChild(element);
          }else{
             filaSig = recordSet.getRow(nextRow);
             if(((BigDecimal)filaSig.elementAt(6)).intValue() <= levelOriginal){
                 // HOJA
                 element = document.createElement("HOJA");
                 element.setAttribute("nombre", extenderLongitudCodigo(((BigDecimal)fila.elementAt(0)).toString(), 12));
                 element.setAttribute("codigo", extenderLongitudCodigo(((BigDecimal)fila.elementAt(0)).toString(), 12));
                 element.setAttribute("texto", (String)fila.elementAt(1));
                 element.setAttribute("icono", "0");
                 element.setAttribute("onclick", "");
             } else{
                 // NIVEL INTERMEDIO
                 element = document.createElement("RAMA");
                 element.setAttribute("nombre", extenderLongitudCodigo(((BigDecimal)fila.elementAt(0)).toString(), 12));
                 element.setAttribute("icono", "2");
                 element.setAttribute("codigo", extenderLongitudCodigo(((BigDecimal)fila.elementAt(0)).toString(), 12));
                 element.setAttribute("texto", (String)fila.elementAt(1));
                 element.setAttribute("onclick", "seleccionMenu(\\'" + ((BigDecimal)fila.elementAt(0)).toString() + "\\');");
                 crearHijos(element, document, recordSet);
             }

             padre.appendChild(element);
             if(nextRow < recordSet.getRowCount()){
                 fila = recordSet.getRow(nextRow);
             }
          }
      }
   }


 private String extenderLongitudCodigo(String codigo, int cantidad) {
          String salida = "";
          for (int i = 0 ; i < (cantidad - codigo.length()); i ++) {
                   salida = salida.concat("0");
          }
          salida = salida.concat(codigo);
          return salida;
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

