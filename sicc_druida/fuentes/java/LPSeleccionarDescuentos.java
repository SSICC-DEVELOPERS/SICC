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
 /*
    INDRA/CAR/PROY
    $Id: LPSeleccionarDescuentos.java,v 1.1 2009/12/03 18:36:14 pecbazalar Exp $
    DESC
 */

/**
 * Sistema:           Belcorp
 * Modulo:            DTO
 * Submódulo:         
 * Componente:        LPSeleccionarDescuentos.java
 * Fecha:             30/07/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * @version           1.0
 * @autor             Andrés Pollitzer
 */


import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
import java.util.Vector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import es.indra.sicc.util.DTOSalida;

public class LPSeleccionarDescuentos extends LPSICCBase {

  String accion;

  String oidDescuentoSeleccionado;


	public LPSeleccionarDescuentos ()  {
      super();
  }

  public void inicio() throws Exception  {

  }

  public void ejecucion() throws Exception  {
    try{
      rastreo();
        setTrazaFichero();

      accion = conectorParametroLimpia("accion","",true);

      oidDescuentoSeleccionado = conectorParametroLimpia("hOidDescuentoSeleccionado","",true);

        traza(" ");
        traza("********************************************************");
        traza("******* ejecucion() LPSeleccionarDescuentos ********");
        traza("********************************************************");
        traza("accion : "               + accion);

        traza("oidDescuentoSeleccionado : " + oidDescuentoSeleccionado );

//accion == "vacia" ---------------------------------------------------------------------------
      if (accion.equals(""))  {
          traza("Entra en accion vacia");
        pagina("contenido_descuento_seleccionar");
//NOTA: Por incidencia 7760: se debe cargar en onload desde pantalla contenido_descuento_seleccionar pues requiere paginado
//        cargarListaDescuentos();
        getConfiguracionMenu("LPSeleccionarDescuentos","");
        UtilidadesSession sesion = new UtilidadesSession();
        asignarAtributo("VAR","hOidIdioma","valor",sesion.getIdioma(this).toString());
        asignarAtributo("VAR","hOidPais","valor",sesion.getPais(this).toString());
          traza("Sale de accion vacia");
      }

//accion == "seleccionar" ---------------------------------------------------------------------------
      else if (accion.equals("seleccionar"))  {
          traza("Entra en accion seleccionar");
          seleccionar();
          traza("Sale de accion seleccionar");
      }
      asignarAtributo("VAR","accion","valor",accion);

    } catch (Exception e) {
        lanzarPaginaError(e);
      }


  }//fin ejecucion()

/*NOTA: Por incidencia 7760: se debe cargar en onload desde pantalla contenido_descuento_seleccionar pues requiere paginado
  private void cargarListaDescuentos() throws Exception  {
      traza("Entra en cagarListaDescuentos()");
    pagina("contenido_descuento_seleccionar");
    DTOSiccPaginacion dtoSP = new DTOSiccPaginacion();
    UtilidadesSession sesion = new UtilidadesSession();
    dtoSP.setOidPais(sesion.getPais(this));
    dtoSP.setOidIdioma(sesion.getIdioma(this));
    asignarAtributo("VAR","hOidIdioma","valor",sesion.getIdioma(this).toString());
    Vector objBusiness = new Vector();
    objBusiness.add( dtoSP );
    objBusiness.add( new MareBusinessID("DTOObtenerDescuentosActivos") );
      traza("cagarListaDescuentos() objBusiness: " + objBusiness);
    DruidaConector con = conectar("ConectorObtenerDescuentosActivos",objBusiness);

    //-> Asignar RecordSet de DTOSalida obtenido de llamada anterior a la 
    //lista editable "descuentos" de la pantalla
    asignar("LISTADOA","listado1",con,"dtoSalida.resultado_ROWSET");
      traza("Sale de cagarListaDescuentos()");
  }//fin cagarListaDescuentos()
*/
//-----------------------------------------------------------------------------------------------------------------------------

  private void seleccionar() throws Exception  {
      traza("Entra en seleccionar()");
    conectorAction("LPPedirSolicitudes");
    conectorActionParametro("accion","");
    conectorActionParametro("oidDescSel",oidDescuentoSeleccionado);
      traza("Sale de seleccionar()");
  }//fin seleccionar()



}//fin LPSeleccionarDescuentos

/*****************************************************************************************************************

Class LPSeleccionarDescuentos {Java}
************************************

Operation --Not Named-- ejecucion (), in Class LPSeleccionarDescuentos

Documentation
Si acción = "" entonces 
-> ejecutar método privado cargarListaDescuentos() NOTA: Por incidencia 7760: se debe cargar en onload desde pantalla contenido_descuento_seleccionar pues requiere paginado
Si no Si acción = "seleccionar" entonces 
-> ejecutar método privado seleccionar() 
Fin Si
-----------------------------------------------------------------------------------------------------------------------------

Operation --Not Named-- cargarListaDescuentos (), in Class LPSeleccionarDescuentos

Documentation
-> Asignar página "contenido_descuento_seleccionar" 
-> Crear objeto DTOSiccPaginacion con pais e idioma del usuario activo 
-> Crear idBusiness = "DTOObtenerDescuentosActivos" 
-> Asignar conector "ConectorObtenerDescuentosActivos" con idBusiness y dto creados 
-> Asignar RecordSet de DTOSalida obtenido de llamada anterior a la lista editable "descuentos" de la pantalla
-----------------------------------------------------------------------------------------------------------------------------

Operation --Not Named-- seleccionar (), in Class LPSeleccionarDescuentos

Documentation
-> Llamar a la lp LPPedirSolicitudes con acción = "" y pasando como parámetro la variable oculta de pantalla "oidDescuentoSeleccionado"
*****************************************************************************************************************/
