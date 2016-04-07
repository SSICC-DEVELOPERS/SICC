/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       13/07/2004
 * @version     1.0
 * @autor       Maximiliano Dello Russo
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
import java.util.Iterator;
import es.indra.sicc.dtos.ped.DTOTipoSolicitud;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;


public class LPMantieneTiposSolicitud extends LPSICCBase{

	private Long oidI18N;
	private String accion;
	
	public LPMantieneTiposSolicitud(){
		super();
	}

	public void inicio() throws Exception {}
	
	public void ejecucion() throws Exception{
		// Si accion == "modificar"{ 
		// muestraCarga(true) 
		// modifica() 
		//} 
		//Si accion == "muestraConsulta"{ 
		//muestraCarga(false) 
		//} 
		//Si accion =="muestraBorrado"{ 
		//muestraCarga(false) 
		//} 
		//Si accion =="muestraModificacion"{ 
		//muestraCarga(false) 
		//} 
		//Si accion =="muestraInsercion"{ 
		//muestraCarga(true) 
		//} 
		//Si accion == "guardar"{ 
		//guarda() 
		//}
		setTrazaFichero();
		traza("> Entrando a LPMantieneTiposSolicitud.ejecucion");
		accion = conectorParametroLimpia("accion", "", true);
		traza("Accion de sesion: " + accion);
		try{
			if( accion.equals("modificar") ){
				muestraCarga(true);
				modifica();
				anyadeHiddensI18N(true, "PED_TIPO_SOLIC", oidI18N, new Integer(1), "frmInsertar", "txtDescripcion", false);
				getConfiguracionMenu("LPMantieneTiposSolicitud", "modificar");	
				asignarAtributoPagina("cod", "0476");
			}
			if( accion.equals("muestraConsulta") ){
				muestraCarga(false);
				getConfiguracionMenu("LPMantieneTiposSolicitud", "buscar/consultar");
				asignarAtributoPagina("cod", "0477");
			}
			if( accion.equals("muestraBorrado") ){
				muestraCarga(false);
				getConfiguracionMenu("LPMantieneTiposSolicitud", "buscar/eliminar");
				asignarAtributoPagina("cod", "0478");
				
			}
			if( accion.equals("muestraModificacion") ){
				muestraCarga(false);
				getConfiguracionMenu("LPMantieneTiposSolicitud", "buscar/modificar");
				asignarAtributoPagina("cod", "0476");
			}
			if( accion.equals("muestraInsercion") ){
				muestraCarga(true);
				anyadeHiddensI18N(false, "PED_TIPO_SOLIC", oidI18N, new Integer(1), "frmInsertar", "txtDescripcion", false);
				getConfiguracionMenu("LPMantieneTiposSolicitud", "insertar");
				asignarAtributoPagina("cod", "0475");
			}

			if( accion.equals("muestraDetalle") ){
				muestraCarga(true);
				modifica(); // Llama a este método para que se carguen los valores de la página
				anyadeHiddensI18N(true, "PED_TIPO_SOLIC", oidI18N, new Integer(1), "frmInsertar", "txtDescripcion", true);
				getConfiguracionMenu("LPMantieneTiposSolicitud", "consultar");
				asignarAtributoPagina("cod", "0477");
			}
			
			if( accion.equals("guardar") ){
				guarda();				
			}
		} catch(Exception e){
			traza(e);
			lanzarPaginaError(e);
		}
	}

	// A partir del ítem seleccionado en la pantalla de búsqueda se muestran los detalles en la pantalla de detalle. 
	public void modifica() throws Exception{
		// - Se crea un DTOOID y se rellena sólo el atributo oid con el ítem seleccionado de lstResultados 
		traza("Entrando a modifica");
		DTOOID dto = new DTOOID();
		String seleccion = conectorParametroLimpia("seleccion", "", true);
		dto.setOid(new Long(seleccion));
		dto.setOidIdioma(UtilidadesSession.getIdioma(this));
		dto.setOidPais(UtilidadesSession.getPais(this));
		// - Se crea idNegocio = "PEDdetallesTipoSolicitud" 
		MareBusinessID businessId = new MareBusinessID("PEDDetalleTipoSolicitud");
		// - Se invoca a ConectorDetallesTiposSolicitud 
		Vector parametros = new Vector();

		parametros.add(dto);
		parametros.add(businessId);
		DruidaConector conector = conectar("ConectorDetallesTiposSolicitud", parametros);
		// - Se rellena la pantalla PantallaGuardarTipoSolicitud con el DTOTipoSolicitud devuelto así: 
		DTOTipoSolicitud dtoResultado = (DTOTipoSolicitud)conector.objeto("DTOSalida");
		// dto.oid -> varOid 
		asignar("VAR", "varOid", dtoResultado.getOid().toString());
		// dto.codigo -> txtTipoSolicitud 
		if( dtoResultado.getCodigo() != null )
			asignar("CTEXTO", "txtTipoSolicitud", dtoResultado.getCodigo().toString());
		// dto.attriTraducible -> txtDescripcion 
		if( dtoResultado.getAttriTraducible() != null ){

			Iterator it = dtoResultado.getAttriTraducible().iterator();

			DTOI18nSICC dtoTraducible = null;

			while(it.hasNext()){

				dtoTraducible = (DTOI18nSICC)it.next();

				if( dtoTraducible.getOidIdioma().equals(UtilidadesSession.getIdioma(this)) ){

					asignar("CTEXTO", "txtDescripcion", dtoTraducible.getValorI18n());

					oidI18N = new Long(dtoResultado.getOid().longValue());

					break;

				}

			}
		}
		// dto.claseSolicitud -> cmbClaseSolicitud 
		if(dtoResultado.getClaseSolicitud() != null){
			asignar("VAR", "claseSolicitud", dtoResultado.getClaseSolicitud().toString());			
		}
		// dto.indConsolidado -> chkConsolidado 
		if(dtoResultado.getIndConsolidado() != null){
			asignar("VAR", "consolidado", dtoResultado.getIndConsolidado().toString());			
		}
		// dto.indSolNegativa -> chkSolicitudNegativa 
		if(dtoResultado.getIndSolNegativa() != null){
			asignar("VAR", "solNegativa", dtoResultado.getIndSolNegativa().toString());			
		}
		// dto.indDevoluciones -> chkDevoluciones 
		if(dtoResultado.getIndDevoluciones() != null){
			asignar("VAR", "devoluciones", dtoResultado.getIndDevoluciones().toString());			
		}
		// dto.indAnulacion -> chkAnulaciones 
		if(dtoResultado.getIndAnulacion() != null){
			asignar("VAR", "Anulaciones", dtoResultado.getIndAnulacion().toString());			
		}
		// dto.marca -> cmbMarca 
		if(dtoResultado.getMarca() != null){
			asignar("VAR", "marca", dtoResultado.getMarca().toString());			
		}
		// dto.canal -> cmbCanal 
		if(dtoResultado.getCanal() != null){
			asignar("VAR", "canal", dtoResultado.getCanal().toString());			
		}
		// dto.acceso -> cmbAcceso 
		if(dtoResultado.getAcceso() != null){
			asignar("VAR", "acceso", dtoResultado.getAcceso().toString());			
		}
		// dto.subacceso -> cmbSubacceso 
		if(dtoResultado.getSubacceso() != null){
			asignar("VAR", "subAcceso", dtoResultado.getSubacceso().toString());			
		}
		// dto.tipoCliente -> cmbTipoCliente 
		if(dtoResultado.getTipoCliente() != null){
			asignar("VAR", "tipoCliente", dtoResultado.getTipoCliente().toString());			
		}
		// - txtTipoSolicitud se pone read-only. 
		// Esto ultimo se resolvera por medio de JS
		
	}

	public void muestraCarga(boolean esInsercion) throws Exception{
		// Si (esInsercion) entonces se muestra PantallaGuardarTiposSolicitud 
		// Sino se muestra PantallaBuscarTiposSolicitud 
		traza("************ Entre a muestraCarga");

		if( esInsercion ){
			traza("************ esInsercion true");
			pagina("contenido_tipo_solicitud_insertar");
		}
		else{
			traza("************ esInsercion false");
			pagina("contenido_tipo_solicitud_buscar");
		}

		asignar("VAR", "accion", accion);
		StringBuffer oidsBelcenter = new StringBuffer();
		
		for(int i=0; i < ConstantesSEG.OID_ACCESO_BELCENTER.length; i++){
			traza("************ Entro al for " + i);
			oidsBelcenter.append(ConstantesSEG.OID_ACCESO_BELCENTER[i].toString());
			if( (i + 1) < ConstantesSEG.OID_ACCESO_BELCENTER.length ) 
				oidsBelcenter.append("|");
		}
		
		asignar("VAR", "OID_ACCESO_BELCENTER", oidsBelcenter.toString());
		
		if( accion.equals("muestraInsercion") ){
			traza("************ Obteniendo marca");
			asignar("VAR", "marca", UtilidadesSession.getMarcaPorDefecto(this).toString());
			traza("************ Obteniendo canal");
			asignar("VAR", "canal", UtilidadesSession.getCanalPorDefecto(this).toString());
			traza("************ Obteniendo acceso");
			asignar("VAR", "acceso", UtilidadesSession.getAccesoPorDefecto(this).toString());
			traza("************ Obteniendo subacceso");
			asignar("VAR", "subAcceso", UtilidadesSession.getSubaccesoPorDefecto(this).toString());
		}
		
		// Con el siguiente proceso: 
		// Crear un DTOBelcorp dtoe con: 
		// - pais = Pais activo 
		// - idioma = Idioma del usuario 
  	    traza("************ Creando DTOBelcorp");
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidIdioma(UtilidadesSession.getIdioma(this));
		dtoBelcorp.setOidPais(UtilidadesSession.getPais(this));

		// Crear una lista ComposerViewElementList 
		ComposerViewElementList listaCompView = new ComposerViewElementList();
		
		// Crear un elemento de tipo ComposerViewElement() 
		// elem.IDBusiness="SEGConsultaCanales"; 
		// elem.DTOE=dtoe; 
		// Añadir el elemento a la lista 
		ComposerViewElement elementoCV = new ComposerViewElement();
		elementoCV.setIDBusiness("SEGConsultaCanales");
		elementoCV.setDTOE(dtoBelcorp);
		listaCompView.addViewElement(elementoCV);
		// Crear un elemento de tipo ComposerViewElement() 
		// elem.IDBusiness="SEGConsultaMarcas"; 
		// elem.DTOE=dtoe; 
		// Añadir el elemento a la lista 
		elementoCV = new ComposerViewElement();
		elementoCV.setIDBusiness("SEGConsultaMarcas");
		elementoCV.setDTOE(dtoBelcorp);
		listaCompView.addViewElement(elementoCV);
		// Crear un elemento de tipo ComposerViewElement() 
		// elem.IDBusiness="MAEObtenerTipos"; 
		// elem.DTOE=dtoe; 
		// Añadir el elemento a la lista 
		elementoCV = new ComposerViewElement();
		elementoCV.setIDBusiness("MAEObtenerTipos");
		elementoCV.setDTOE(dtoBelcorp);
		listaCompView.addViewElement(elementoCV);
		// Crear un elemento de tipo ComposerViewElement() 
		// elem.IDBusiness="PEDconsultaClasesSolicitud"; 
		// elem.DTOE=dtoe; 
		// Añadir el elemento a la lista 
		elementoCV = new ComposerViewElement();
		elementoCV.setIDBusiness("PEDConsultaClasesSolicitud");
		elementoCV.setDTOE(dtoBelcorp);
		listaCompView.addViewElement(elementoCV);

    // **************************************************************************
    // Agregado por ssantana por inc. 9737.
    // **************************************************************************
    
    elementoCV = new ComposerViewElement();
    elementoCV.setIDBusiness("PEDAccesosBelcenter");
    elementoCV.setDTOE(dtoBelcorp);
		listaCompView.addViewElement(elementoCV);    

		// Invocar al subsistema GestorCargaPantalla 
 	    traza("************ Llamando a ejecucion");
		ConectorComposerView conector = new ConectorComposerView(listaCompView, this.getRequest());
		conector.ejecucion();
				
		/*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
		// DruidaConector conConsultar = conectar("ConectorCargaPantalla", paramEntrada); 
   	    traza("************ Ante de conectar");
		DruidaConector conConsultar = conector.getConector(); 
		traza("************ Despues de conectar");

		/*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla correspondiente utilizando 
		el String que representa el BusinessID en cada caso. 

		asignar("COMBO", "cmbCanal", conConsultar, "SEGConsultaCanales"); 
		asignar("COMBO", "cmbMarca", conConsultar, "SEGConsultaMarcas"); 
		asignar("COMBO", "cmbTipoCliente", conConsultar, "MAEObtenerTipos"); 
		asignar("COMBO", "cmbClaseSolicitud", conConsultar, "PEDconsultaClasesSolicitud");*/
		asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales");
		asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas");
		asignar("COMBO", "cbTipoCliente", conConsultar, "MAEObtenerTipos");
		asignar("COMBO", "cbClaseSolicitud", conConsultar, "PEDConsultaClasesSolicitud");
		traza("Asigna");
    if (esInsercion)
  		asignar("LISTADOA", "listaAccesos", conConsultar, "PEDAccesosBelcenter");
		// Agregado por Maximiliano Dello Russo:
		// Seteo el idioma y el pais en variables ocultas de la página
		asignar("VAR", "idioma", UtilidadesSession.getIdioma(this).toString());
		asignar("VAR", "pais", UtilidadesSession.getPais(this).toString());		
	}

	// Guarda los datos. 
	public void guarda() throws Exception{
		try{
			traza("********** Entro a guarda");

			String datosPagina = null;
			// - Se crea DTOTipoSolicitud con todos los campos rellenos: 
			pagina("salidaGenerica");

			traza("********** Seteando valores para DTOTipoSolicitud");
			DTOTipoSolicitud dto = new DTOTipoSolicitud();
			dto.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
			dto.setPrograma(UtilidadesSession.getFuncion(this));
			// dto.pais <- pais de sesión 
			dto.setOidPais(UtilidadesSession.getPais(this));
			// dto.idioma <- idioma de sesión 
			dto.setOidIdioma(UtilidadesSession.getIdioma(this));

			// dto.oid <- varOid 
			datosPagina = conectorParametroLimpia("varOid", "", true);
			if( !datosPagina.equals("") )
				dto.setOid(new Long(datosPagina));

			// dto.codigo <- txtTipoSolicitud 
			datosPagina = conectorParametroLimpia("txtTipoSolicitud", "", true);

			traza("********** setCodigo");
			dto.setCodigo(datosPagina.toUpperCase());
			// dto.attriTraducible <- recuperaTraduccionesI18N(); 
			datosPagina = conectorParametroLimpia("txtDescripcion", "", true);
			Vector descripciones = this.recuperaTraduccionesI18N(new Integer(1));
			traza("********** setAttirTraducible");
			dto.setAttriTraducible(descripciones);
			// dto.claseSolicitud <- cmbClaseSolicitud 
			datosPagina = conectorParametroLimpia("cbClaseSolicitud", "", true);
			traza("********** setClaseSolicitud");
			dto.setClaseSolicitud(new Long(datosPagina));
			// dto.indConsolidado <- chkConsolidado 
			datosPagina = conectorParametroLimpia("ChkConsolidado", "", true);
			traza("********** setIndConsolidado");
			dto.setIndConsolidado(new Boolean(datosPagina.equalsIgnoreCase("S")));
			// dto.indSolNegativa <- chkSolicitudNegativa 
			datosPagina = conectorParametroLimpia("ChkSolicitudNegativa", "", true);
			traza("********** setIndSolNegativa");
			dto.setIndSolNegativa(new Boolean(datosPagina.equalsIgnoreCase("S")));
			// dto.indDevoluciones <- chkDevoluciones 
			datosPagina = conectorParametroLimpia("ChkDevoluciones", "", true);
			traza("********** setIndDevoluciones");
			dto.setIndDevoluciones(new Boolean(datosPagina.equalsIgnoreCase("S")));
			// dto.indAnulacion <- chkAnulaciones 
			datosPagina = conectorParametroLimpia("ChkAnulaciones", "", true);
			traza("********** setIndAnulacion");
			dto.setIndAnulacion(new Boolean(datosPagina.equalsIgnoreCase("S")));
			// dto.marca <- cmbMarca 
			datosPagina = conectorParametroLimpia("cbMarca", "", true);
			traza("********** setMarca");
			dto.setMarca(new Long(datosPagina));
			// dto.canal <- cmbCanal 
			datosPagina = conectorParametroLimpia("cbCanal", "", true);
			traza("********** setCanal");
			dto.setCanal(new Long(datosPagina));
			// dto.acceso <- cmbAcceso 
			datosPagina = conectorParametroLimpia("cbAcceso", "", true);
			traza("********** datosPagina " + datosPagina);
			traza("********** setAcceso");
			dto.setAcceso(new Long(datosPagina));
			// dto.subacceso <- cmbSubacceso 
			
			//datosPagina = conectorParametroLimpia("cbSubacceso", "", true);
			datosPagina = conectorParametroLimpia("comboSubacceso", "", true);

			traza("********** datosPagina " + datosPagina);
			if( !datosPagina.equals("") ) dto.setSubacceso(new Long(datosPagina));			
			
			
			// dto.tipoCliente <- cmbTipoCliente 
			datosPagina = conectorParametroLimpia("cbTipoCliente", "", true);
			traza("********** setTipoCliente");
			dto.setTipoCliente(new Long(datosPagina));
			// - Se crea idNegocio = "PEDguardaTipoSolicitud" 
			MareBusinessID businessID = new MareBusinessID("PEDGuardaTipoSolicitud");
			// - Se invoca a ConectorGuardarTiposSolicitud
			Vector parametros = new Vector();
			traza("DTO: " + dto);
			parametros.add(dto);
			parametros.add(businessID);
			traza("********** Antes de conectar");
			DruidaConector conector = conectar("ConectorGuardarTiposSolicitud", parametros);
			traza("********** Despues de conectar");

			datosPagina = conectorParametro("casoDeUso");
			if( datosPagina.equals("modificar") ){
				asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");
			} else {
				asignarAtributo("VAR", "ejecutar", "valor", "borrarTodo()");
			}
		}catch(Exception e){
			asignarAtributo("VAR", "ejecutarError", "valor", "errorAlGuardar()");
			throw e;
		}
	}		
	
}
