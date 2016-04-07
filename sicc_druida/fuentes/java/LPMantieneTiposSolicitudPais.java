/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       23/07/2004
 * @version     1.0
 * @autor       Maximiliano Dello Russo
 * Descripcion: 
 */


import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.mln.MareBusinessID;
import java.util.Vector;
//import java.util.Iterator;
import es.indra.sicc.dtos.cra.DTOActividad;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudPais;

public class LPMantieneTiposSolicitudPais extends LPSICCBase{
	private String accion;

	public LPMantieneTiposSolicitudPais(){
		super();
	}

	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
		// Si accion == "modificar"{ 
		// muestraCarga(true) 
		// modifica() 
		// } 
		// Si accion == "muestraConsulta"{ 
		// muestraCarga(false) 
		// } 
		// Si accion =="muestraBorrado"{ 
		// muestraCarga(false) 
		// } 
		// Si accion =="muestraModificacion"{ 
		// muestraCarga(false) 
		// } 
		// Si accion =="muestraInsercion"{ 
		// muestraCarga(true) 
		// } 
		// Si accion == "guardar"{ 
		// guarda() 
		// }              
		setTrazaFichero();
		traza("> Entrando a LPMantieneTiposSolicitudPais.ejecucion");
		accion = conectorParametroLimpia("accion", "", true);
		traza("Accion de sesion: " + accion);
        try{
			if( accion.equals("modificar") || accion.equals("muestraDetalle") ){
				muestraCarga(true);
				modifica();
				if( accion.equals("modificar") ){
					getConfiguracionMenu("LPMantieneTiposSolicitudPais", "modificar");	
					asignarAtributoPagina("cod", "0609");
				}else{
					getConfiguracionMenu("LPMantieneTiposSolicitudPais", "consultar");	
					asignarAtributoPagina("cod", "0610");
				}
			}
			if( accion.equals("muestraConsulta") ){
				muestraCarga(false);
				getConfiguracionMenu("LPMantieneTiposSolicitudPais", "buscar/consultar");
				asignarAtributoPagina("cod", "0610");
			}
			if( accion.equals("muestraBorrado") ){
				muestraCarga(false);
				getConfiguracionMenu("LPMantieneTiposSolicitudPais", "buscar/eliminar");
				asignarAtributoPagina("cod", "0611");
			}
			if( accion.equals("muestraModificacion") ){
				muestraCarga(false);
				getConfiguracionMenu("LPMantieneTiposSolicitudPais", "buscar/modificar");
				asignarAtributoPagina("cod", "0609");
			}
			if( accion.equals("muestraInsercion") ){
				muestraCarga(true);
				getConfiguracionMenu("LPMantieneTiposSolicitud", "insertar");
				asignarAtributoPagina("cod", "0608");				
			}
			if( accion.equals("guardar") ){
				guarda();
			}
		} catch(Exception e){
			traza(e);
			lanzarPaginaError(e);
		}
	}

	private void muestraCarga(boolean esInsercion) throws Exception{
		// Si (esInsercion) entonces se muestra PantallaGuardarTiposSolicitudPais 
		// Sino se muestra PantallaBuscarTiposSolicitudPais 
		traza("> muestraCarga");
		if( esInsercion ){
			pagina("contenido_tipo_solicitud_pais_insertar");
		}else{
			pagina("contenido_tipo_solicitud_pais_buscar");
			Integer formato = new Integer(LPSICCBase.FORMATO_DEFAULT);
			asignar("VAR", "formato",  formato.toString() );
		}
		asignar("VAR", "accion", accion);

		if( accion.equals("muestraInsercion") ){
			traza("Sociedad: " + UtilidadesSession.getSociedadPorDefecto(this).toString());
			asignar("VAR", "sociedad", UtilidadesSession.getSociedadPorDefecto(this).toString());
		}

		asignar("VAR", "pais", UtilidadesSession.getPais(this).toString());
		asignar("VAR", "idioma", UtilidadesSession.getIdioma(this).toString());
		// Con el siguiente proceso: 

		// 1.- Crear un DTOBelcorp dtoe y un DTOActividad (CRA) dtoa con: 
		// - pais = Pais activo 
		// - idioma = Idioma del usuario 
		DTOBelcorp dtoe = new DTOBelcorp();
//		DTOActividad dtoa = new DTOActividad();
		dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));
		dtoe.setOidPais(UtilidadesSession.getPais(this));
//		dtoa.setOidIdioma(UtilidadesSession.getIdioma(this));
//		dtoa.setOidPais(UtilidadesSession.getPais(this));
		// 2.- Crear una lista ComposerViewElementList 
		ComposerViewElementList listaCompView = new ComposerViewElementList();
		// 3.- Los elementos de la lista son: 

		// Crear un elemento de tipo ComposerViewElement() 
		// elem.IDBusiness="PEDobtieneTiposSolicitud"; 
		// elem.DTOE=dtoe; 
		// Añadir el elemento a la lista 
		ComposerViewElement elementoCV = new ComposerViewElement();
		elementoCV.setIDBusiness("PEDobtieneTiposSolicitud");
		elementoCV.setDTOE(dtoe);
		listaCompView.addViewElement(elementoCV);
		traza("Seteo el elemento PEDobtieneTiposSolicitud");         
		// Crear un elemento de tipo ComposerViewElement() 
		// elem.IDBusiness="PEDconsultaTiposConsolidado"; 
		// elem.DTOE=dtoe; 
		// Añadir el elemento a la lista 
		elementoCV = new ComposerViewElement();
		elementoCV.setIDBusiness("PEDconsultaTiposConsolidado");                  
		elementoCV.setDTOE(dtoe);
		listaCompView.addViewElement(elementoCV);
		traza("Seteo el elemento PEDconsultaTiposConsolidado");
		// Crear un elemento de tipo ComposerViewElement() 
		// elem.IDBusiness="FACObtenerTipoDocumentoLegal"; 
		// elem.DTOE=dtoe; 
		// Añadir el elemento a la lista 
		elementoCV = new ComposerViewElement();
		elementoCV.setIDBusiness("FACObtenerTiposDocumentoLegal");                  
		elementoCV.setDTOE(dtoe);
		listaCompView.addViewElement(elementoCV);
		traza("Seteo el elemento FACObtenerTiposDocumentoLegal");
		// Crear un elemento de tipo ComposerViewElement() 
		// elem.IDBusiness="BELFormasPagoPais"; 
		// elem.DTOE=dtoe; 
		// Añadir el elemento a la lista 
		elementoCV = new ComposerViewElement();
		elementoCV.setIDBusiness("BELFormasPagoPais");                  
		elementoCV.setDTOE(dtoe);
		listaCompView.addViewElement(elementoCV);
		traza("Seteo el elemento BELFormasPagoPais");
		// Crear un elemento de tipo ComposerViewElement() 
		// elem.IDBusiness="BELObtenerAlmacenes"; 
		// elem.DTOE=dtoe; 
		// Añadir el elemento a la lista 
		elementoCV = new ComposerViewElement();
		elementoCV.setIDBusiness("BELObtenerAlmacenes");                  
		elementoCV.setDTOE(dtoe);
		listaCompView.addViewElement(elementoCV);
		traza("Seteo el elemento BELObtenerAlmacenes");
		// Crear un elemento de tipo ComposerViewElement() 
		// elem.IDBusiness="BELObtenerTiposMovimientosAlmacen"; 
		// elem.DTOE=dtoe; 
		// Añadir el elemento a la lista 
		elementoCV = new ComposerViewElement();
		elementoCV.setIDBusiness("BELObtenerTiposMovimientosAlmacen");                  
		elementoCV.setDTOE(dtoe);
		listaCompView.addViewElement(elementoCV);
		traza("Seteo el elemento BELObtenerTiposMovimientosAlmacen");
		// Crear un elemento de tipo ComposerViewElement() 
		// elem.IDBusiness="CRAObtieneActividad"; 
		// elem.DTOE=dtoa; 
		// Añadir el elemento a la lista 
/* 
///////////// Eliminado por incidencia 10913 INICIO
		elementoCV = new ComposerViewElement();
		elementoCV.setIDBusiness("CRAObtieneActividad");                  
		elementoCV.setDTOE(dtoa);
		listaCompView.addViewElement(elementoCV);
		traza("Seteo el elemento CRAObtieneActividad");
///////////// Eliminado por incidencia 10913 FIN
 */
		// Crear un elemento de tipo ComposerViewElement() 
		// elem.IDBusiness="SEGObtenerEmpresasPorPais"; 
		// elem.DTOE=dtoe; 
		// Añadir el elemento a la lista 
		elementoCV = new ComposerViewElement();
		elementoCV.setIDBusiness("SEGObtenerEmpresasPorPais");                  
		elementoCV.setDTOE(dtoe);
		listaCompView.addViewElement(elementoCV);
		traza("Seteo el elemento SEGObtenerEmpresasPorPais");
		// Crear un elemento de tipo ComposerViewElement() 
		// elem.IDBusiness="SEGObtenerMonedas"; 
		// elem.DTOE=dtoe; 
		// Añadir el elemento a la lista 
		elementoCV = new ComposerViewElement();
		elementoCV.setIDBusiness("SEGObtenerMonedas");                  
		elementoCV.setDTOE(dtoe);
		listaCompView.addViewElement(elementoCV);
		traza("Seteo el elemento SEGObtenerMonedas");
		// 4.- Invocar al subsistema GestorCargaPantalla 
		traza("Conectando");
		ConectorComposerView conector = new ConectorComposerView(listaCompView, this.getRequest());
		conector.ejecucion();
		traza("Ejecutado");                                    
		// 5.- DruidaConector conConsultar = conectar("ConectorCargaPantalla", paramEntrada); 
		DruidaConector conConsultar = conector.getConector(); 
		// 6.- 
		// asignar("COMBO", "cmbTipoSolicitud", conConsultar, "PEDobtieneTiposSolicitud"); 
		// asignar("COMBO", "cmbTipoConsolidado", conConsultar, "PEDconsultaTiposConsolidado"); 
		// asignar("COMBO", "cmbTipoDocumentoLegal", conConsultar, "FACObtenerTipoDocumentoLegal"); 
		// asignar("COMBO", "cmbFormaPago", conConsultar, "BELFormasPagoPais"); 
		// asignar("COMBO", "cmbAlmacen", conConsultar, "BELObtenerAlmacenes"); 
		// asignar("COMBO", "cmbTipoMovAsignacion", conConsultar, "BELObtenerTiposMovimientosAlmacen"); 
		// asignar("COMBO", "cmbTipoMovReserva", conConsultar, "BELObtenerTiposMovimientosAlmacen"); 
		// asignar("COMBO", "cmbTipoMovFacturacion", conConsultar, "BELObtenerTiposMovimientosAlmacen"); 
		// asignar("COMBO", "cmbActividad", conConsultar, "CRAObtieneActividad" con DTOActividad); 
		// asignar("COMBO", "cmbSociedad", conConsultar, "SEGObtenerEmpresasPorPais"); 
		// asignar("COMBO", "cmbMoneda", conConsultar, "SEGObtenerMonedas"); 
		asignar("COMBO", "cbTipoSolicitud", conConsultar, "PEDobtieneTiposSolicitud");
		asignar("COMBO", "cbTipoConsolidado", conConsultar, "PEDconsultaTiposConsolidado");
		asignar("COMBO", "cbTipoDocumentoLegal", conConsultar, "FACObtenerTiposDocumentoLegal");
		asignar("COMBO", "cbFormaPago", conConsultar, "BELFormasPagoPais");
		asignar("COMBO", "cbAlmacen", conConsultar, "BELObtenerAlmacenes");
		asignar("COMBO", "cbTipoMovimientoAsignacionStock", conConsultar, "BELObtenerTiposMovimientosAlmacen");
		asignar("COMBO", "cbTipoMovimientoReservaStock", conConsultar, "BELObtenerTiposMovimientosAlmacen");
		asignar("COMBO", "cbTipoMovimientoFacturacion", conConsultar, "BELObtenerTiposMovimientosAlmacen");
/* 
///////////// Eliminado por incidencia 10913 INICIO
		asignar("COMBO", "cbCodActividadCronograma", conConsultar, "CRAObtieneActividad");
///////////// Eliminado por incidencia 10913 FIN
*/    
		asignar("COMBO", "cbSociedad", conConsultar, "SEGObtenerEmpresasPorPais");
		asignar("COMBO", "cbMoneda", conConsultar, "SEGObtenerMonedas");
		traza("Combos cargados");
		this.getFormatosValidaciones();
		// 7.- Si esInsercion hay que tener en cuenta para la pantalla: 
		// - txtNumSolicitudesLote: Valor Numérico. Debe ser un valor positivo. 
		// - txtAlarmaNumUnidades: Valor Numérico. Debe ser un valor positivo, por defecto cero. 
		// - cmbTipoConsolidado: 
		// Si chkPermiteUnion=Activo, será un dato obligatorio 
		// Si chkPermiteUnion=Desactivo, se informará a nulos sin ser manipulable por el usuario. 
		// ### EL PTO 7 SERA RESUELTO EN EL JS ###
	}

	private void modifica() throws Exception{
		// - Se crea un DTOOID y se rellena sólo el atributo oid con el ítem seleccionado de lstResultados 
		traza("Entrando a modifica");
		traza("Capturando lstResultados");
		String seleccion = conectorParametroLimpia("seleccion", "", true);
		traza("Seleccion capturada: " + seleccion);
        DTOOID dto = new DTOOID();
		dto.setOidIdioma(UtilidadesSession.getIdioma(this));
		dto.setOidPais(UtilidadesSession.getPais(this));
		dto.setOid(new Long(seleccion));
		// - Se crea idNegocio = "PEDdetallesTiposSolicitudPais" 
		MareBusinessID businessID = new MareBusinessID("PEDdetallesTiposSolicitudPais");
		// - Se invoca a ConectorDetallesTiposSolicitudPais 
		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(businessID);
		traza("Conectado a ConectorDetallesTiposSolicitudPais");
		DruidaConector conector = conectar("ConectorDetallesTiposSolicitudPais", parametros);		                  
		// - Se rellena la pantalla PantallaGuardarTiposSolicitudPais con el DTOTipoSolicitud devuelto así: 
		traza("Conexion OK");
		DTOTipoSolicitudPais dtoResultado = (DTOTipoSolicitudPais)conector.objeto("DTOSalida");
		traza("Se capturo resultado");
		asignar("VAR", "idioma", UtilidadesSession.getIdioma(this).toString());
		asignar("VAR", "pais", UtilidadesSession.getPais(this).toString());		
		// dtos.oid -> varOid 
		traza("Seteando varOid: " + dtoResultado.getOid().toString());
		asignar("VAR", "varOid", dtoResultado.getOid().toString());
		traza("Set ok.");                 
		// dtos.numPorLote -> txtNumSolicitudesLote 
		if( dtoResultado.getNumPorLote() != null ){
			traza("Seteando txtNumSolicitudesLote: " + dtoResultado.getNumPorLote().toString());
			asignar("VAR", "numSolicitudesLote", dtoResultado.getNumPorLote().toString());
		}
		// dtos.alarmaNumUnidades -> txtAlarmaNumUnidades 
		if( dtoResultado.getAlarmaNumUnidades() != null ){
			traza("Seteando txtAlarmaNumUnidades: " + dtoResultado.getAlarmaNumUnidades().toString());
			asignar("VAR", "alarmaNumUnidades", UtilidadesBelcorp.formateaNumeroSICC(
				dtoResultado.getAlarmaNumUnidades().toString(), LPSICCBase.FORMATO_DEFAULT, this) );
		}
		// dtos.sujetoFlete -> chkSujetoAFlete 
		if( dtoResultado.getSujetoFlete() != null ){
			traza("Seteando chkSujetoAFlete: " + dtoResultado.getSujetoFlete().toString());
			asignar("VAR", "sujetoAFlete", dtoResultado.getSujetoFlete().toString());
		}
		// dtos.permiteUnionSolicitudes -> chkPermiteUnion 
		if( dtoResultado.getPermiteUnionSolicitudes() != null ){
			traza("Seteando chkPermiteUnion: " + dtoResultado.getPermiteUnionSolicitudes().toString());
			asignar("VAR", "permiteUnion", dtoResultado.getPermiteUnionSolicitudes().toString());
		}
		// dtos.reservaStock -> chkReservaStock 
		if( dtoResultado.getReservaStock() != null ){
			traza("Seteando chkReservaStock: " + dtoResultado.getReservaStock().toString());
			asignar("VAR", "reservaStock", dtoResultado.getReservaStock().toString());
		}
		// dtos.permiteReversion -> chkPermitirReversion 
		if( dtoResultado.getPermiteReversion() != null ){
			traza("Seteando chkPermitirReversion: " + dtoResultado.getPermiteReversion().toString());
			asignar("VAR", "permitirReversion", dtoResultado.getPermiteReversion().toString());
		}
		// dtos.indPedidoPrueba -> chkIndPedidoPrueba 
		if( dtoResultado.getIndPedidoPrueba() != null ){
			traza("Seteando chkIndPedidoPrueba: " + dtoResultado.getIndPedidoPrueba().toString());
			asignar("VAR", "indPedidoPrueba", dtoResultado.getIndPedidoPrueba().toString());
		}
		// dtos.indComisionable -> chkIndComisionable 
		if( dtoResultado.getIndComisionable() != null ){
			traza("Seteando chkIndComisionable: " + dtoResultado.getIndComisionable().toString());
			asignar("VAR", "indComisionable", dtoResultado.getIndComisionable().toString());
		}
		// dtos.indPedGtZona -> chkIndPegGtZona 
		if( dtoResultado.getIndPedGtZona() != null ){
			traza("Seteando chkIndPegGtZona: " + dtoResultado.getIndPedGtZona().toString());
			asignar("VAR", "indPedGtZona", dtoResultado.getIndPedGtZona().toString());
		}
		// dtos.indCambioVentaBEL -> chkIndCambioVenta 
		if( dtoResultado.getIndCambioVentaBEL() != null ){
			traza("Seteando chkIndCambioVenta: " + dtoResultado.getIndCambioVentaBEL().toString());
			asignar("VAR", "indCambioVentaBEL", dtoResultado.getIndCambioVentaBEL().toString());
		}
		// dtos.indVentaSAB14 -> chkFlagVentaSAB14 
		if( dtoResultado.getIndVentaSAB14() != null ){
			traza("Seteando chkFlagVentaSAB14: " + dtoResultado.getIndVentaSAB14().toString());
			asignar("VAR", "indVentaSAB14", dtoResultado.getIndVentaSAB14().toString());
		}
		// dtos.sociedad -> cmbSociedad 
		if( dtoResultado.getSociedad() != null ){
			traza("Seteando cmbSociedad: " + dtoResultado.getSociedad().toString());
			asignar("VAR", "sociedad", dtoResultado.getSociedad().toString());
		}
		// dtos.formaPago -> cmbFormaPago 
		if( dtoResultado.getFormaPago() != null ){
			traza("Seteando cmbFormaPago: " + dtoResultado.getFormaPago().toString());
			asignar("VAR", "formaPago", dtoResultado.getFormaPago().toString());
		}
		// dtos.tipoDocumentoLegal -> cmbTipoDocumentoLegal 
		if( dtoResultado.getTipoDocumentoLegal() != null ){
			traza("Seteando cmbTipoDocumentoLegal: " + dtoResultado.getTipoDocumentoLegal().toString());
			asignar("VAR", "tipoDocumentoLegal", dtoResultado.getTipoDocumentoLegal().toString());
		}
		// dtos.moneda -> cmbMoneda 
		if( dtoResultado.getMoneda() != null ){
			traza("Seteando cmbMoneda: " + dtoResultado.getMoneda().toString());
			asignar("VAR", "moneda", dtoResultado.getMoneda().toString());
		}
		// dtos.actividad -> cmbActividad 
		if( dtoResultado.getActividad() != null ){
			traza("Seteando cmbActividad: " + dtoResultado.getActividad().toString());
			asignar("VAR", "actividad", dtoResultado.getActividad().toString());
		}
		// dtos.tipoMovReserva -> cmbTipoMovReserva
		if( dtoResultado.getTipoMovReserva() != null ){
			traza("Seteando cmbTipoMovReserva: " + dtoResultado.getTipoMovReserva().toString());
			asignar("VAR", "tipoMovReserva", dtoResultado.getTipoMovReserva().toString());
		}
		// dtos.tipoMovAsigna -> cmbTipoMovAsignacion 
		if( dtoResultado.getTipoMovAsigna() != null ){
			traza("Seteando cmbTipoMovAsignacion: " + dtoResultado.getTipoMovAsigna().toString());
			asignar("VAR", "tipoMovAsigna", dtoResultado.getTipoMovAsigna().toString());
		}
		// dtos.tipoMovFacturacion -> cmbTipoMovFacturacion 
		if( dtoResultado.getTipoMovFacturacion() != null ){
			traza("Seteando cmbTipoMovFacturacion: " + dtoResultado.getTipoMovFacturacion().toString());
			asignar("VAR", "tipoMovFacturacion", dtoResultado.getTipoMovFacturacion().toString());
		}
		// dtos.tipoSolicitud -> cmbTipoSolicitud 
		if( dtoResultado.getTipoSolicitud() != null ){
			traza("Seteando cmbTipoSolicitud: " + dtoResultado.getTipoSolicitud().toString());
			asignar("VAR", "tipoSolicitud", dtoResultado.getTipoSolicitud().toString());
		}
		// dtos.tipoConsolidado -> cmbTipoConsolidado 
		if( dtoResultado.getTipoConsolidado() != null ){
			traza("Seteando cmbTipoConsolidado: " + dtoResultado.getTipoConsolidado().toString());
			asignar("VAR", "tipoConsolidado", dtoResultado.getTipoConsolidado().toString());
		}
		// dtos.glosa -> txtGlosa 
		if( dtoResultado.getGlosa() != null ){
			traza("Seteando txtGlosa: " + dtoResultado.getGlosa());
			asignar("VAR", "observaciones", dtoResultado.getGlosa());
		}
		// dtos.almacen -> cmbAlmacen
		if( dtoResultado.getAlmacen() != null ){
			traza("Seteando cmbAlmacen: " + dtoResultado.getAlmacen().toString());
			asignar("VAR", "almacen", dtoResultado.getAlmacen().toString());
		}
	}

	private void guarda() throws Exception{
		try{
			traza("Guardando");
			String datosPagina = null;
			pagina("salidaGenerica");
			// - Se crea DTOTipoSolicitudPais con todos los campos rellenos: 
			DTOTipoSolicitudPais dto = new DTOTipoSolicitudPais();
			dto.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
			dto.setPrograma(UtilidadesSession.getFuncion(this));
			// dto.oid <- varOid 
			datosPagina = conectorParametroLimpia("varOid", "", true);
			if( !datosPagina.equals("") )
				dto.setOid(new Long(datosPagina));
			// dto.numPorLote <- txtNumSolicitudesLote 
			datosPagina = conectorParametroLimpia("txtNumSolicitudesLote", "", true);
			traza("txtNumSolicitudesLote: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setNumPorLote(new Integer(datosPagina));
			// dto.alarmaNumUnidades <- txtAlarmaNumUnidades 
			
			datosPagina = conectorParametroNumero("txtAlarmaNumUnidades", LPSICCBase.FORMATO_DEFAULT);
			//conectorParametroLimpia("txtAlarmaNumUnidades", "", true);
			traza("txtAlarmaNumUnidades: " + datosPagina);
			if( !datosPagina.equals("") ){
				dto.setAlarmaNumUnidades(new Integer(datosPagina));
			}
			// dto.sujetoFlete <- chkSujetoAFlete 
			datosPagina = conectorParametroLimpia("ckSujetoFlete", "", true);
			traza("ckSujetoFlete: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setSujetoFlete(new Boolean(datosPagina.equalsIgnoreCase("S")));
			// dto.permiteUnionSolicitudes <- chkPermiteUnion 
			datosPagina = conectorParametroLimpia("ckPermiteUnionSolicitudes", "", true);
			traza("ckPermiteUnionSolicitudes: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setPermiteUnionSolicitudes(new Boolean(datosPagina.equalsIgnoreCase("S")));		
			// dto.reservaStock <- chkReservaStock 
			datosPagina = conectorParametroLimpia("chkReservaStock", "", true);
			traza("chkReservaStock: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setReservaStock(new Boolean(datosPagina.equalsIgnoreCase("S")));		
			// dto.permiteReversion <- chkPermitirReversion 
			datosPagina = conectorParametroLimpia("ckPermitirReversion", "", true);
			traza("ckPermitirReversion: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setPermiteReversion(new Boolean(datosPagina.equalsIgnoreCase("S")));		
			// dto.indPedidoPrueba <- chkIndPedidoPrueba 
			datosPagina = conectorParametroLimpia("ckPedidoPrueba", "", true);
			traza("ckPedidoPrueba: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setIndPedidoPrueba(new Boolean(datosPagina.equalsIgnoreCase("S")));		
			// dto.indComisionable <- chkIndComisionable 
			datosPagina = conectorParametroLimpia("ckComisionable", "", true);
			traza("ckComisionable: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setIndComisionable(new Boolean(datosPagina.equalsIgnoreCase("S")));		
			// dto.indPedGtZona <- chkIndPegGtZona 
			datosPagina = conectorParametroLimpia("ckPedGtZona", "", true);
			traza("ckPedGtZona: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setIndPedGtZona(new Boolean(datosPagina.equalsIgnoreCase("S")));		
			// dto.indCambioVentaBEL <- chkIndCambioVenta 
			datosPagina = conectorParametroLimpia("ckCambioVentaBelcenter", "", true);
			traza("ckCambioVentaBelcenter: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setIndCambioVentaBEL(new Boolean(datosPagina.equalsIgnoreCase("S")));		
			// dto.indVentaSAB14 <- chkFlagVentaSAB14 
			datosPagina = conectorParametroLimpia("ckVentaInterfazSAB14", "", true);
			traza("ckVentaInterfazSAB14: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setIndVentaSAB14(new Boolean(datosPagina.equalsIgnoreCase("S")));		
			// dto.sociedad <- cmbSociedad 
			datosPagina = conectorParametroLimpia("cbSociedad", "", true);
			traza("cbSociedad: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setSociedad(new Long(datosPagina));		
			// dto.formaPago <- cmbFormaPago 
			datosPagina = conectorParametroLimpia("cbFormaPago", "", true);
			traza("cbFormaPago: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setFormaPago(new Long(datosPagina));		
			// dto.tipoDocumentoLegal <- cmbTipoDocumentoLegal 
			datosPagina = conectorParametroLimpia("cbTipoDocumentoLegal", "", true);
			traza("cbTipoDocumentoLegal: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setTipoDocumentoLegal(new Long(datosPagina));		
			// dto.moneda <- cmbMoneda 
			datosPagina = conectorParametroLimpia("cbMoneda", "", true);
			traza("cbMoneda: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setMoneda(new Long(datosPagina));	
			// dto.actividad <- cmbActividad 
			datosPagina = conectorParametroLimpia("cbCodActividadCronograma", "", true);
			traza("cbCodActividadCronograma: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setActividad(new Long(datosPagina));	
			// dto.tipoMovReserva <- cmbTipoMovReserva 
			datosPagina = conectorParametroLimpia("cbTipoMovimientoReservaStock", "", true);
			traza("cbTipoMovimientoReservaStock: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setTipoMovReserva(new Long(datosPagina));	
			// dto.tipoMovAsigna <- cmbTipoMovAsignacion 
			datosPagina = conectorParametroLimpia("cbTipoMovimientoAsignacionStock", "", true);
			traza("cbTipoMovimientoAsignacionStock: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setTipoMovAsigna(new Long(datosPagina));	
			// dto.tipoMovFacturacion <- cmbTipoMovFacturacion 
			datosPagina = conectorParametroLimpia("cbTipoMovimientoFacturacion", "", true);
			traza("cbTipoMovimientoFacturacion: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setTipoMovFacturacion(new Long(datosPagina));	
			// dto.tipoSolicitud <- cmbTipoSolicitud 
			datosPagina = conectorParametroLimpia("cbTipoSolicitud", "", true);
			traza("cbTipoSolicitud: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setTipoSolicitud(new Long(datosPagina));	
			// dto.tipoConsolidado <- cmbTipoConsolidado 
			datosPagina = conectorParametroLimpia("cbTipoConsolidado", "", true);
			traza("cbTipoConsolidado: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setTipoConsolidado(new Long(datosPagina));	
			// dto.glosa <- txtGlosa 
			datosPagina = conectorParametroLimpia("atxtObservaciones", "", true);
			traza("atxtObservaciones: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setGlosa(new String(datosPagina));	
			// dto.almacen <- cmbAlmacen 
			datosPagina = conectorParametroLimpia("cbAlmacen", "", true);
			traza("cbAlmacen: " + datosPagina);
			if( !datosPagina.equals("") )
				dto.setAlmacen(new Long(datosPagina));	
			// dto.pais <- pais sesión 
			dto.setOidPais(UtilidadesSession.getPais(this));
			// dto.idioma <- idioma sesión 
			dto.setOidIdioma(UtilidadesSession.getIdioma(this));
			// - Se crea idNegocio = "PEDguardaTiposSolicitudPais" 
			MareBusinessID businessId = new MareBusinessID("PEDguardaTiposSolicitudPais");
			// - Se invoca a ConectorGuardarTiposSolicitudPais 
			Vector parametros = new Vector();
			traza(dto);
			parametros.add(dto);
			parametros.add(businessId);
			DruidaConector conector = conectar("ConectorGuardarTiposSolicitudPais", parametros);
			traza("Guardado");
			datosPagina = conectorParametro("casoDeUso");
			traza("casoDeUso: " + datosPagina);
			if( datosPagina.equals("modificar") ){
				asignarAtributo("VAR", "ejecutar", "valor", "retornoModal()");
			} else {
				asignarAtributo("VAR", "ejecutar", "valor", "borrarTodo()");
			}	
		}catch(Exception e){
			traza("Llamando a funcion errorAlGuardar2");
			asignarAtributo("VAR", "ejecutarError", "valor", "errorAlGuardar()");
			throw e;
		}
	}

}
