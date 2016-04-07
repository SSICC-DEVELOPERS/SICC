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
    $Id: LPPedirSolicitudes.java,v 1.1 2009/12/03 18:35:58 pecbazalar Exp $
    DESC
 */

/**
 * Sistema:           Belcorp
 * Modulo:            DTO
 * Submódulo:         
 * Componente:        LPPedirSolicitudes.java
 * Fecha:             30/07/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * @version           1.0
 * @autor             Andrés Pollitzer
 */


import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import java.util.ArrayList;
import java.util.StringTokenizer;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import java.util.Vector;
import es.indra.mare.common.mln.MareBusinessID;


public class LPPedirSolicitudes extends LPSICCBase {

  String accion;

  String oidDescuento;
  String oidSolicitud;
  String codCliente;
  String nombreCliente;
  String campaniaSolicitud;
  String fechaSolicitud;
  String montoTotalSolicitud;
  String oidsSolicSelec;


	public LPPedirSolicitudes ()  {
      super();
  }

  public void inicio() throws Exception  {
    pagina("contenido_solicitudes_pedir");
  }

  public void ejecucion() throws Exception  {
    try{
        setTrazaFichero();
		 traza("esta es la longitud del cliente: "+this.obtenerLongitudCodigoCliente().toString());
      accion = conectorParametroLimpia("accion","",true);
      
      oidDescuento = conectorParametroLimpia("oidDescSel","",true);
      oidSolicitud = conectorParametroLimpia("hOidSolicitud","",true);
      codCliente = conectorParametroLimpia("hCodCliente","",true);
      nombreCliente = conectorParametroLimpia("hNombreCliente","",true);
      campaniaSolicitud = conectorParametroLimpia("hCampaniaSolicitud","",true);
      fechaSolicitud = conectorParametroLimpia("hFechaSolicitud","",true);
      montoTotalSolicitud = conectorParametroLimpia("hMontoTotalSolicitud","",true);
      oidsSolicSelec = conectorParametroLimpia("hOidsSolicSelec","",true);

        traza(" ");
        traza("********************************************************");
        traza("******* ejecucion() LPPedirSolicitudes ********");
        traza("********************************************************");
        traza("accion : "               + accion);

        traza("oidDescuento : "         + oidDescuento);
        traza("oidSolicitud : "         + oidSolicitud);
        traza("codCliente : "           + codCliente);
        traza("nombreCliente : "        + nombreCliente);
        traza("campaniaSolicitud : "    + campaniaSolicitud);
        traza("fechaSolicitud : "       + fechaSolicitud);
        traza("montoTotalSolicitud : "  + montoTotalSolicitud);
        traza("oidsSolicSelec : "       + oidsSolicSelec);
        

//accion == "" ---------------------------------------------------------------------------
      if (accion.equals(""))  {
          traza("Entra en accion vacia");
        cargarPaginaPedirSolicitudes();
        getConfiguracionMenu("LPPedirSolicitudes","");
          traza("Sale de accion vacia");
      }

//accion == "detalle" ---------------------------------------------------------------------------
      else if (accion.equals("detalle"))  {
          traza("Entra en accion detalle");
        cargarDetalle();
        getConfiguracionMenu("LPPedirSolicitudes","detalle");
          traza("Sale de accion detalle");
      }

//accion == "aceptar" ---------------------------------------------------------------------------
      else if (accion.equals("aceptar") )  {
          traza("Entra en accion aceptar");
          aceptar();
          traza("Sale de accion aceptar");
      }
      asignarAtributo("VAR","accion","valor",accion);
      asignarAtributo("VAR","oidDescSel","valor",oidDescuento);
                              
      

    } catch (Exception e) {
        lanzarPaginaError(e);
    }


  }//fin ejecucion()

//-----------------------------------------------------------------------------------------------------------------------------
  private void cargarPaginaPedirSolicitudes() throws Exception  {
    pagina("contenido_solicitudes_pedir");
	 asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
    DTOBelcorp dtoB = new DTOBelcorp();
    cargarCombos();
    //-> Deshabilitar el CText "codigoCliente", usuario debe pulsar el icono para buscar un cliente.
  }


  public void cargarCombos() throws Exception  {
      traza("Entra en cargarCombos");
    DTOBelcorp dtoBelcorp = new DTOBelcorp();
    UtilidadesSession sesion = new UtilidadesSession();
    dtoBelcorp.setOidPais(sesion.getPais(this));
    dtoBelcorp.setOidIdioma(sesion.getIdioma(this));
    asignarAtributo("VAR","hOidIdioma","valor",sesion.getIdioma(this).toString());
    //Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametros(dtoBelcorp);
    //Invocar al subsistema GestorCargaPantalla
    //Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
      traza("resultados: " + resultados.getXML() );
    //Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla correspondiente
    //utilizando el String que representa el BusinessID en cada caso.
    asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
    asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
      traza("Sale de cargarCombos");
	}


  private ComposerViewElementList crearParametros(DTOBelcorp dto) throws Exception {
      traza("Entra en crearParametros");
    ComposerViewElementList lista = new ComposerViewElementList(); 
		//combo cbMarca
		ComposerViewElement cVE1 = new ComposerViewElement();
		cVE1.setIDBusiness("SEGConsultaMarcas");
		cVE1.setDTOE(dto);
		//combo cbCanal
		ComposerViewElement cVE2 = new ComposerViewElement();
		cVE2.setIDBusiness("SEGConsultaCanales");
		cVE2.setDTOE(dto);
		lista.addViewElement(cVE1);
		lista.addViewElement(cVE2);
      traza( "lista : " + lista.toString() );
      traza("Sale de crearParametros");
		return lista;
	}

//-----------------------------------------------------------------------------------------------------------------------------
  private void cargarDetalle() throws Exception {
    pagina("contenido_solicitudes_pedir_detalle");
    //-> Tomar los datos del registro seleccionado en la pantalla "contenido_solicitudes_pedir" para
    //mapearlos en las etiquetas de la cabecera de la pantalla "contenido_solicitudes_pedir_detalle"
    asignarAtributo("LABELC","lbldtCodCliente","valor",codCliente);
    asignarAtributo("LABELC","lbldtNombreCliente","valor",nombreCliente);
    asignarAtributo("LABELC","lbldtCampanaSolicitud","valor",campaniaSolicitud);
    asignarAtributo("LABELC","lbldtFechaSolicitud","valor",fechaSolicitud);
    asignarAtributo("LABELC","lbldtMontoTotalSolicitud","valor",montoTotalSolicitud);

    DTOOID dtoOID = new DTOOID();
    dtoOID.setOid( Long.valueOf(oidSolicitud) );
    Vector objBusiness = new Vector();
    objBusiness.add(dtoOID);
    objBusiness.add( new MareBusinessID("DTOPedirSolicitudesDetalle") );
      traza("cargarDetalle() objBusiness: " + objBusiness);
    DruidaConector con = conectar("ConectorPedirSolicitudesDetalle",objBusiness);
    //-> Mapear RecordSet del DTOSalida obtenido en la lista "productosSolicitud" de la pantalla asignada al principio
    asignar("LISTADOA","listado1",con,"dtoSalida.resultado_ROWSET");
  }//fin cargarDetalle()
//-----------------------------------------------------------------------------------------------------------------------------
  private void aceptar() throws Exception  {
    //-> Tomar de pantalla los oidSolicitud de los registros seleccionados en la lista solicitudesSeleccionadas
    //y crear un arrayList con ellos.
    //Nota del desarrollador: se enviara el pipe como string separado por | y el arrayList se creara en LPSimulacionDescuento
    conectorAction("LPSimulacionDescuento");
    conectorActionParametro("accion","");
    conectorActionParametro("oidDesc",oidDescuento);
    conectorActionParametro("solicitudesSeleccionadas",oidsSolicSelec);
    conectorActionParametro("formatoFechaPais",conectorParametro("hFormatoFechaPais"));

  }



}//fin clase



/*****************************************************************************************************************

Class LPPedirSolicitudes {Java}
*******************************
Operation --Not Named-- ejecucion (), in Class LPPedirSolicitudes

Documentation
Si accion = "" entonces 
-> ejecutar método privado cargarPaginaPedirSolicitudes 
Si no Si accion = "detalle" entonces 
-> ejecutar método privado cargarDetalle 
Si no Si accion = "aceptar" entonces 
-> ejecutar método privado aceptar 
Fin Si 
-----------------------------------------------------------------------------------------------------------------------------

Operation --Not Named-- cargarPaginaPedirSolicitudes (), in Class LPPedirSolicitudes

Documentation
-> Asignar página "contenido_solicitudes_pedir" 
-> Crear objeto DTOBelcorp 
-> Llamar al subsistema GestorCargaPantalla con la siguiente información 
- idBusiness = "SEGConsultaMarcas" => llena combo "marca" 
- idBusiness = "SEGConsultaCanales" y DTOBelcorp => llena combo "canal" 
-> Deshabilitar el CText "codigoCliente", usuario debe pulsar el icono para buscar un cliente.
-----------------------------------------------------------------------------------------------------------------------------

Operation --Not Named-- detalle (), in Class LPPedirSolicitudes

Documentation
-> Asignar página "contenido_solicitudes_pedir_detalle" 
-> Tomar los datos del registro seleccionado en la pantalla "contenido_solicitudes_pedir" para mapearlos en las etiquetas de la cabecera de la pantalla "contenido_solicitudes_pedir_detalle" 
-> Crear objeto DTOOID con el oid de la solicitud seleccionada en la lista resultadosBusqueda de la pantalla "contenido_solicitudes_pedir" 
-> Crear idBusiness "DTOPedirSolicitudesDetalle" 
-> Asignar conector "ConectorPedirSolicitudesDetalle" 
-> Mapear RecordSet del DTOSalida obtenido en la lista "productosSolicitud" de la pantalla asignada al principio 

-----------------------------------------------------------------------------------------------------------------------------

Operation --Not Named-- aceptar (), in Class LPPedirSolicitudes

Documentation
-> Tomar de pantalla los oidSolicitud de los registros seleccionados en la lista solicitudesSeleccionadas y crear un arrayList con ellos. 
-> Llamar a la lp LPSimulacionDescuento con acción "" pasando el arrayList de oids de solicitudes seleccionada a la sesión con el nombre "solicitudesSeleccionadas" y la variable oculta oidDescuento de la pantalla

*****************************************************************************************************************/
