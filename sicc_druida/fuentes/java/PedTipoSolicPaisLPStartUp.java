/*
    INDRA/CAR/mmg
    $Id: PedTipoSolicPaisLPStartUp.java,v 1.1 2009/12/03 18:40:25 pecbazalar Exp $
    DESC
*/
import java.util.*;

import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Element;

import es.indra.utils.*;
import es.indra.druida.Contexto;
import es.indra.druida.DruidaConector;
import es.indra.druida.belcorp.MMGDruidaBase;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.druida.belcorp.MMGException;
import es.indra.druida.belcorp.MMGNoSessionException;
import es.indra.druida.belcorp.MMGNoLanguageException;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import java.text.DecimalFormatSymbols;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class PedTipoSolicPaisLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 1029;
	public static final short CREATEFORM_SIZE = 1007;
	public static final short UPDATEFORM_SIZE = 1007;
	public static final short VIEWFORM_SIZE = 1007;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGPedTipoSolicPaisQueryFromToUserPage";
	
	
				public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisViewQueryFromToUser";
				public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisViewConectorCombo";
	
				public static final String BUSINESSID_TSOLOIDTIPOSOLI_QUERY ="MMGPedTipoSolicViewQueryFromToUser";
				public static final String TSOLOIDTIPOSOLI_COMBO_CONNECTOR = "PedTipoSolicViewConectorCombo";
	
				public static final String BUSINESSID_FOPAOIDFORMPAGO_QUERY ="MMGBelFormaPagoQueryFromToUser";
				public static final String FOPAOIDFORMPAGO_COMBO_CONNECTOR = "BelFormaPagoConectorCombo";
	
				public static final String BUSINESSID_CACTOIDACTI_QUERY ="MMGCraActivQueryFromToUser";
				public static final String CACTOIDACTI_COMBO_CONNECTOR = "CraActivConectorCombo";
	
				public static final String BUSINESSID_MONEOIDMONE_QUERY ="MMGSegMonedQueryFromToUser";
				public static final String MONEOIDMONE_COMBO_CONNECTOR = "SegMonedConectorCombo";
	
				public static final String BUSINESSID_TMALOIDTIPOMOVIASIG_QUERY ="MMGBelTipoMovimAlmacQueryFromToUser";
				public static final String TMALOIDTIPOMOVIASIG_COMBO_CONNECTOR = "BelTipoMovimAlmacConectorCombo";
	
				public static final String BUSINESSID_TMALOIDTIPOMOVIRESE_QUERY ="MMGBelTipoMovimAlmacQueryFromToUser";
				public static final String TMALOIDTIPOMOVIRESE_COMBO_CONNECTOR = "BelTipoMovimAlmacConectorCombo";
	
				public static final String BUSINESSID_TMALOIDTIPOMOVIFACT_QUERY ="MMGBelTipoMovimAlmacQueryFromToUser";
				public static final String TMALOIDTIPOMOVIFACT_COMBO_CONNECTOR = "BelTipoMovimAlmacConectorCombo";
	
				public static final String BUSINESSID_TIDOOIDTIPODOCU_QUERY ="MMGFacTipoDocumQueryFromToUser";
				public static final String TIDOOIDTIPODOCU_COMBO_CONNECTOR = "FacTipoDocumConectorCombo";
	
				public static final String BUSINESSID_ALMCOIDALMA_QUERY ="MMGBelAlmacQueryFromToUser";
				public static final String ALMCOIDALMA_COMBO_CONNECTOR = "BelAlmacConectorCombo";
	
				public static final String BUSINESSID_SOCIOIDSOCI_QUERY ="MMGSegSocieQueryFromToUser";
				public static final String SOCIOIDSOCI_COMBO_CONNECTOR = "SegSocieConectorCombo";
	
				public static final String BUSINESSID_TSOLOIDTIPOCONS_QUERY ="MMGPedTipoSolicPaisViewQueryFromToUser";
				public static final String TSOLOIDTIPOCONS_COMBO_CONNECTOR = "PedTipoSolicPaisViewConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public PedTipoSolicPaisLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("PedTipoSolicPaisPage");
	}

	public void ejecucion() throws Exception {
		try{
			//Llamamos al metodo sobresctrito de la clase padre para ejecutar las acciones comunes:
			//obtener configuración del mantenimiento
			super.ejecucion();
		
			this.getFormatosValidaciones();

			//Activamos las trazas
			setTrazaFichero();
			
			//Establecemos el tamaño de la página
			buildJsPageSize("PedTipoSolicPais");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "PedTipoSolicPaisPage", "cod", "PedTipoSolicPais." + accion + ".label");
			
			//Ponemos en la página el idioma de usuario, el idioma de la pagina para mostrar los errores, 
			//y el codigo del idioma por defecto
			asignar("VAR", VAR_IDIOMA, MMGDruidaHelper.getUserDefaultLanguage(this));
			asignar("VAR", VAR_IDIOMA_XML, MMGDruidaHelper.getIdioma(this));
			asignar("VAR", VAR_DEFAULT_LANGUAGE_CODE, MMGDruidaHelper.getUserDefaultLanguage(this));
			
			//Establecemos los tamaños y posiciones de la capas de la pantalla
			establecerSizeCapas(accion, origen);
			
			//Establecemos los valores por defecto de la entidades estructurales
			setDefaultStructuralValues();
			
			//Limpiamos la botonera
			limpiarBotoneraLista("pedTipoSolicPais", accion);
			
			
			
			
			
			//Ejecutanos la acción solicitada		
			System.out.println("accion " + accion + " origen " + origen);
			if(accion.equals(ACCION_LOV)) cmdLov();
			else if(accion.equals(ACCION_QUERY)) cmdQuery();
			else if(accion.equals(ACCION_CREATE)) cmdCreate();
			else if(accion.equals(ACCION_REMOVE)) cmdRemove();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("menu")) cmdUpdate();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("pagina")) cmdPreUpdateForm();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")) cmdUpdateForm();
			else if(accion.equals(ACCION_VIEW) && origen.equals("pagina")) cmdPreView();
			else if(accion.equals(ACCION_VIEW) && origen.equals("preview")) cmdView();
			
			//Eliminamos los TRs del formulario que no tengan campos
			eliminarTrsVacios(accion, origen);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	/**Acciones que se realizan cuando la pantalla se arranca en modo lov*/
	protected void cmdLov() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();
	
		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos(null);
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		
		asignarAtributo("TEXT", "numSoliLote", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "numUnidAlar", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
		
		asignarAtributo("TEXT", "indSujeFlet", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indReseStoc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPermReve", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPediPrue", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indComi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indVentInteSab14", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
		
		
		
		asignarAtributo("TEXT", "indPermUnio", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPediGtZona", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indCambVentBel", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		asignarAtributo("TEXT", "valGlos", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 255);");
		
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "pedTipoSolicPaisLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "PedTipoSolicPaisPage", "onblur", "window.focus();");
		
		//Borramos los elementos de internacionalización()
		removeLocalizationElements();
		removeNonSearchElements();
	}

	/**Acción previa para poder permitir la carga de datos en el formulario 
	de view con ventana oculta. Para ello simplemente redireccionamos al método*/
	protected void cmdPreView() throws Exception{
		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION) != null?
			conectorParametro(VAR_LAST_QUERY_TO_SESSION): "");

		//Redirigimos a la acción de view pasando la accion, y la acción anterior y actulizando el origen
		conectorAction("PedTipoSolicPaisLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro(PARAMETRO_GENERICO_ACCION)!= null?  
			conectorParametro(PARAMETRO_GENERICO_ACCION): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preview");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
		conectorActionParametro(VAR_APPLY_STRUCTURAL_ENTITY, conectorParametro(VAR_APPLY_STRUCTURAL_ENTITY));
			
	}
	
	/**Acciones que se realizan cunado la pantalla se arranca en modo view
	*/
	protected void cmdView() throws Exception{
		//Construimos el mso con los elementos de la búsqueda a partir del id que
		//lo sacamos de la request
		PedTipoSolicPaisData pedTipoSolicPaisQuery= new PedTipoSolicPaisData();
		pedTipoSolicPaisQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		PedTipoSolicPaisData datosResult = (PedTipoSolicPaisData)getSingleObject(BUSINESSID_QUERY, pedTipoSolicPaisQuery, 
			pedTipoSolicPaisQuery.clone(), "pedTipoSolicPais");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		PedTipoSolicPaisData pedTipoSolicPais = datosResult;
		es.indra.belcorp.mso.PedTipoSolicViewData tsolOidTipoSoli = pedTipoSolicPais.getTsolOidTipoSoli();
		if(tsolOidTipoSoli != null && tsolOidTipoSoli.getId() != null) checkCombo("tsolOidTipoSoli" , tsolOidTipoSoli.getId().toString());
		asignar("TEXT", "numSoliLote", FormatUtils.formatObject(pedTipoSolicPais.getNumSoliLote(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numUnidAlar", FormatUtils.formatObject(pedTipoSolicPais.getNumUnidAlar(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.BelFormaPagoData fopaOidFormPago = pedTipoSolicPais.getFopaOidFormPago();
		if(fopaOidFormPago != null && fopaOidFormPago.getId() != null) checkCombo("fopaOidFormPago" , fopaOidFormPago.getId().toString());
		asignar("TEXT", "indSujeFlet", FormatUtils.formatObject(pedTipoSolicPais.getIndSujeFlet(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indReseStoc", FormatUtils.formatObject(pedTipoSolicPais.getIndReseStoc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indPermReve", FormatUtils.formatObject(pedTipoSolicPais.getIndPermReve(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indPediPrue", FormatUtils.formatObject(pedTipoSolicPais.getIndPediPrue(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indComi", FormatUtils.formatObject(pedTipoSolicPais.getIndComi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indVentInteSab14", FormatUtils.formatObject(pedTipoSolicPais.getIndVentInteSab14(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.CraActivData cactOidActi = pedTipoSolicPais.getCactOidActi();
		if(cactOidActi != null && cactOidActi.getId() != null) checkCombo("cactOidActi" , cactOidActi.getId().toString());
		es.indra.belcorp.mso.SegMonedData moneOidMone = pedTipoSolicPais.getMoneOidMone();
		if(moneOidMone != null && moneOidMone.getId() != null) checkCombo("moneOidMone" , moneOidMone.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviAsig = pedTipoSolicPais.getTmalOidTipoMoviAsig();
		if(tmalOidTipoMoviAsig != null && tmalOidTipoMoviAsig.getId() != null) checkCombo("tmalOidTipoMoviAsig" , tmalOidTipoMoviAsig.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviRese = pedTipoSolicPais.getTmalOidTipoMoviRese();
		if(tmalOidTipoMoviRese != null && tmalOidTipoMoviRese.getId() != null) checkCombo("tmalOidTipoMoviRese" , tmalOidTipoMoviRese.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviFact = pedTipoSolicPais.getTmalOidTipoMoviFact();
		if(tmalOidTipoMoviFact != null && tmalOidTipoMoviFact.getId() != null) checkCombo("tmalOidTipoMoviFact" , tmalOidTipoMoviFact.getId().toString());
		es.indra.belcorp.mso.FacTipoDocumData tidoOidTipoDocu = pedTipoSolicPais.getTidoOidTipoDocu();
		if(tidoOidTipoDocu != null && tidoOidTipoDocu.getId() != null) checkCombo("tidoOidTipoDocu" , tidoOidTipoDocu.getId().toString());
		asignar("TEXT", "indPermUnio", FormatUtils.formatObject(pedTipoSolicPais.getIndPermUnio(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indPediGtZona", FormatUtils.formatObject(pedTipoSolicPais.getIndPediGtZona(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indCambVentBel", FormatUtils.formatObject(pedTipoSolicPais.getIndCambVentBel(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.BelAlmacData almcOidAlma = pedTipoSolicPais.getAlmcOidAlma();
		if(almcOidAlma != null && almcOidAlma.getId() != null) checkCombo("almcOidAlma" , almcOidAlma.getId().toString());
		es.indra.belcorp.mso.SegSocieData sociOidSoci = pedTipoSolicPais.getSociOidSoci();
		if(sociOidSoci != null && sociOidSoci.getId() != null) checkCombo("sociOidSoci" , sociOidSoci.getId().toString());
		asignar("TEXT", "valGlos", FormatUtils.formatObject(pedTipoSolicPais.getValGlos(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.PedTipoSolicPaisViewData tsolOidTipoCons = pedTipoSolicPais.getTsolOidTipoCons();
		if(tsolOidTipoCons != null && tsolOidTipoCons.getId() != null) checkCombo("tsolOidTipoCons" , tsolOidTipoCons.getId().toString());
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		
					asignarAtributo("COMBO", "tsolOidTipoSoli", "disabled", "S");asignarAtributo("TEXT", "numSoliLote", "disabled", "S");
		asignarAtributo("TEXT", "numUnidAlar", "disabled", "S");
		
					asignarAtributo("COMBO", "fopaOidFormPago", "disabled", "S");asignarAtributo("TEXT", "indSujeFlet", "disabled", "S");
		asignarAtributo("TEXT", "indReseStoc", "disabled", "S");
		asignarAtributo("TEXT", "indPermReve", "disabled", "S");
		asignarAtributo("TEXT", "indPediPrue", "disabled", "S");
		asignarAtributo("TEXT", "indComi", "disabled", "S");
		asignarAtributo("TEXT", "indVentInteSab14", "disabled", "S");
		
					asignarAtributo("COMBO", "cactOidActi", "disabled", "S");
					asignarAtributo("COMBO", "moneOidMone", "disabled", "S");
					asignarAtributo("COMBO", "tmalOidTipoMoviAsig", "disabled", "S");
					asignarAtributo("COMBO", "tmalOidTipoMoviRese", "disabled", "S");
					asignarAtributo("COMBO", "tmalOidTipoMoviFact", "disabled", "S");
					asignarAtributo("COMBO", "tidoOidTipoDocu", "disabled", "S");asignarAtributo("TEXT", "indPermUnio", "disabled", "S");
		asignarAtributo("TEXT", "indPediGtZona", "disabled", "S");
		asignarAtributo("TEXT", "indCambVentBel", "disabled", "S");
		
					asignarAtributo("COMBO", "almcOidAlma", "disabled", "S");
					asignarAtributo("COMBO", "sociOidSoci", "disabled", "S");asignarAtributo("TEXT", "valGlos", "disabled", "S");
		
					asignarAtributo("COMBO", "tsolOidTipoCons", "disabled", "S");
		
	
		//Ponemos la pagina en modo view: Eliminamos el botón de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando sólo el campo simple
		//Eliminamos los elementos correspondientes a la internacionalizacion
		removeLovElements();
		removeQueryElements();
		removeNonViewElements();
		
	}
	
	/**Acciones que se realizan cuando la pantalla se arranca en modo create*/
	protected void cmdCreate() throws Exception{
		

		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos(null);
	
		//Ponemos los campos requeridos a true
		asignarAtributo("COMBO", "tsolOidTipoSoli", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el 
		//valor del idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		
		asignarAtributo("TEXT", "numSoliLote", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "numUnidAlar", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
		
		asignarAtributo("TEXT", "indSujeFlet", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indReseStoc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPermReve", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPediPrue", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indComi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indVentInteSab14", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
		
		
		
		asignarAtributo("TEXT", "indPermUnio", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPediGtZona", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indCambVentBel", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		asignarAtributo("TEXT", "valGlos", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 255);");
		
		
		
		//Ponemos la pagina en modo view: 
		//Eliminamos el botón de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando sólo el campo simple
		removeLovElements();
		removeQueryElements();
		removeNonInsertElements();
	}
	
	/**Acciones a ejecutar cuando la ventana se abre en modo remove*/
	protected void cmdRemove() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
		userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		
		asignarAtributo("TEXT", "numSoliLote", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "numUnidAlar", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
		
		asignarAtributo("TEXT", "indSujeFlet", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indReseStoc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPermReve", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPediPrue", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indComi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indVentInteSab14", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
		
		
		
		asignarAtributo("TEXT", "indPermUnio", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPediGtZona", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indCambVentBel", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		asignarAtributo("TEXT", "valGlos", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 255);");
		
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		//Cargamos las combos finales de las jerarquías de herencia
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}else loadLeafDependenceCombos(null);

		//Eliminamos los elementos correspondientes a la internacionalizacion y lov
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
	}

	/**Acciones a ejecutar cuando la ventana se abre en modo query*/
	protected void cmdQuery() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
		userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		
		asignarAtributo("TEXT", "numSoliLote", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "numUnidAlar", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
		
		asignarAtributo("TEXT", "indSujeFlet", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indReseStoc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPermReve", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPediPrue", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indComi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indVentInteSab14", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
		
		
		
		asignarAtributo("TEXT", "indPermUnio", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPediGtZona", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indCambVentBel", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		asignarAtributo("TEXT", "valGlos", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 255);");
		
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Cargamos las combos finales de las jerarquías de herencia
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}loadLeafDependenceCombos(null);

		//Eliminamos los elementos correspondientes a la internacionalizacion
		//elimnamos el botón lov de null selection
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
	}
	
	/**Acciones a ejecutar cuando la ventana se abre en modo update*/
	protected void cmdUpdate() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		
		asignarAtributo("TEXT", "numSoliLote", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "numUnidAlar", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
		
		asignarAtributo("TEXT", "indSujeFlet", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indReseStoc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPermReve", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPediPrue", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indComi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indVentInteSab14", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
		
		
		
		asignarAtributo("TEXT", "indPermUnio", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPediGtZona", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indCambVentBel", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		asignarAtributo("TEXT", "valGlos", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 255);");
		
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Cargamos las combos finales de las jerarquías de herencia
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}loadLeafDependenceCombos(null);

		//Simplemente elimnamos el botón lov de null selection y la internacionalización
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
	}

	
	/**Acción previa para poder permitir la carga de datos en el formulario 
	de updatecon ventana oculta. Para ello simplemente redireccionamos al método*/
	protected void cmdPreUpdateForm() throws Exception{
		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION) != null?
			conectorParametro(VAR_LAST_QUERY_TO_SESSION): "");

		//Redirigimos al update form
		conectorAction("PedTipoSolicPaisLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro("accion") != null?
			conectorParametro("accion"): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preupdate");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
		conectorActionParametro(VAR_APPLY_STRUCTURAL_ENTITY, conectorParametro(VAR_APPLY_STRUCTURAL_ENTITY));
			
	}
	
	/**Prepara el formulario para mostrar los datos de un elemento de la entidad
	y estos puedan ser modificados*/  
	protected void cmdUpdateForm() throws Exception{
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));

		//Actualizamos el valor de enviar de forma oculta el formulario. 
		//asignarAtributo("FORMULARIO", "pedTipoSolicPaisFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("COMBO", "tsolOidTipoSoli", "req", "S");
		
		//Asignamos a los campos internacionalizables la función de onblur para actualizar el valor
		//para el idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		Long loidPais = UtilidadesSession.getPais(this);
		userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		
			
			asignarAtributo("TEXT", "numSoliLote", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
			asignarAtributo("TEXT", "numUnidAlar", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
			
			asignarAtributo("TEXT", "indSujeFlet", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indReseStoc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indPermReve", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indPediPrue", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indComi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indVentInteSab14", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			
			
			
			
			
			
			asignarAtributo("TEXT", "indPermUnio", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indPediGtZona", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indCambVentBel", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			
			
			asignarAtributo("TEXT", "valGlos", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 255);");
			

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando PedTipoSolicPais");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		PedTipoSolicPaisData pedTipoSolicPaisQuery= new PedTipoSolicPaisData();
		pedTipoSolicPaisQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		PedTipoSolicPaisData  datosResult = (PedTipoSolicPaisData)getSingleObject(BUSINESSID_QUERY, pedTipoSolicPaisQuery, 
			pedTipoSolicPaisQuery.clone(), "pedTipoSolicPais");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		PedTipoSolicPaisData pedTipoSolicPais = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		es.indra.belcorp.mso.PedTipoSolicViewData tsolOidTipoSoli = pedTipoSolicPais.getTsolOidTipoSoli();
		if(tsolOidTipoSoli != null && tsolOidTipoSoli.getId() != null) checkCombo("tsolOidTipoSoli" , tsolOidTipoSoli.getId().toString());
		asignar("TEXT", "numSoliLote", FormatUtils.formatObject(pedTipoSolicPais.getNumSoliLote(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numUnidAlar", FormatUtils.formatObject(pedTipoSolicPais.getNumUnidAlar(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.BelFormaPagoData fopaOidFormPago = pedTipoSolicPais.getFopaOidFormPago();
		if(fopaOidFormPago != null && fopaOidFormPago.getId() != null) checkCombo("fopaOidFormPago" , fopaOidFormPago.getId().toString());
		asignar("TEXT", "indSujeFlet", FormatUtils.formatObject(pedTipoSolicPais.getIndSujeFlet(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indReseStoc", FormatUtils.formatObject(pedTipoSolicPais.getIndReseStoc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indPermReve", FormatUtils.formatObject(pedTipoSolicPais.getIndPermReve(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indPediPrue", FormatUtils.formatObject(pedTipoSolicPais.getIndPediPrue(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indComi", FormatUtils.formatObject(pedTipoSolicPais.getIndComi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indVentInteSab14", FormatUtils.formatObject(pedTipoSolicPais.getIndVentInteSab14(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.CraActivData cactOidActi = pedTipoSolicPais.getCactOidActi();
		if(cactOidActi != null && cactOidActi.getId() != null) checkCombo("cactOidActi" , cactOidActi.getId().toString());
		es.indra.belcorp.mso.SegMonedData moneOidMone = pedTipoSolicPais.getMoneOidMone();
		if(moneOidMone != null && moneOidMone.getId() != null) checkCombo("moneOidMone" , moneOidMone.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviAsig = pedTipoSolicPais.getTmalOidTipoMoviAsig();
		if(tmalOidTipoMoviAsig != null && tmalOidTipoMoviAsig.getId() != null) checkCombo("tmalOidTipoMoviAsig" , tmalOidTipoMoviAsig.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviRese = pedTipoSolicPais.getTmalOidTipoMoviRese();
		if(tmalOidTipoMoviRese != null && tmalOidTipoMoviRese.getId() != null) checkCombo("tmalOidTipoMoviRese" , tmalOidTipoMoviRese.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviFact = pedTipoSolicPais.getTmalOidTipoMoviFact();
		if(tmalOidTipoMoviFact != null && tmalOidTipoMoviFact.getId() != null) checkCombo("tmalOidTipoMoviFact" , tmalOidTipoMoviFact.getId().toString());
		es.indra.belcorp.mso.FacTipoDocumData tidoOidTipoDocu = pedTipoSolicPais.getTidoOidTipoDocu();
		if(tidoOidTipoDocu != null && tidoOidTipoDocu.getId() != null) checkCombo("tidoOidTipoDocu" , tidoOidTipoDocu.getId().toString());
		asignar("TEXT", "indPermUnio", FormatUtils.formatObject(pedTipoSolicPais.getIndPermUnio(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indPediGtZona", FormatUtils.formatObject(pedTipoSolicPais.getIndPediGtZona(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indCambVentBel", FormatUtils.formatObject(pedTipoSolicPais.getIndCambVentBel(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.BelAlmacData almcOidAlma = pedTipoSolicPais.getAlmcOidAlma();
		if(almcOidAlma != null && almcOidAlma.getId() != null) checkCombo("almcOidAlma" , almcOidAlma.getId().toString());
		es.indra.belcorp.mso.SegSocieData sociOidSoci = pedTipoSolicPais.getSociOidSoci();
		if(sociOidSoci != null && sociOidSoci.getId() != null) checkCombo("sociOidSoci" , sociOidSoci.getId().toString());
		asignar("TEXT", "valGlos", FormatUtils.formatObject(pedTipoSolicPais.getValGlos(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.PedTipoSolicPaisViewData tsolOidTipoCons = pedTipoSolicPais.getTsolOidTipoCons();
		if(tsolOidTipoCons != null && tsolOidTipoCons.getId() != null) checkCombo("tsolOidTipoCons" , tsolOidTipoCons.getId().toString());
		

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(pedTipoSolicPais.jdoGetTimeStamp()));
		
		//Ponemos la pagina en modo view: Eliminamos el botón de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando sólo el campo simple
		//Borramos los elementos correspondientes a la internacionalización
		removeLovElements();
		removeQueryElements();
		removeNonModifyFields();
		/** por eloy mier pérez para agregar funcionalidad de desactivacion de campos */
		traza("MMG: antes de llamar a desactivateNonModifyFields .....");
		desactivateNonModifyFields();
		traza("MMG: despues de llamar a desactivateNonModifyFields ......");
		/** 
			por eloy mier pérez para agregar funcionalidad de desactivacion de campos
			para reescribir funciones ontab y onshtab.
		 */
		cambiarAcciones();
	}

	/**
		Por EMP.
		Nos permite cambiar el evento ontab y onshtab de los objetos druida necesarios en el modo
		de modificación.
	*/
	protected void cambiarAcciones() throws Exception{
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",1, false)");
					asignarAtributo("COMBO","paisOidPais", "ontab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",2, true)");
					asignarAtributo("COMBO","paisOidPais", "onshtab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",2, false)");
					asignarAtributo("COMBO","tsolOidTipoSoli", "ontab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",3, true)");
					asignarAtributo("COMBO","tsolOidTipoSoli", "onshtab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",3, false)");
				asignarAtributo("AREATEXTO", "numSoliLote", "ontab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",4, true)");
				asignarAtributo("AREATEXTO", "numSoliLote", "onshtab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",4, false)");
				asignarAtributo("AREATEXTO", "numUnidAlar", "ontab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",5, true)");
				asignarAtributo("AREATEXTO", "numUnidAlar", "onshtab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",5, false)");
					asignarAtributo("COMBO","fopaOidFormPago", "ontab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",6, true)");
					asignarAtributo("COMBO","fopaOidFormPago", "onshtab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",6, false)");
				asignarAtributo("AREATEXTO", "indSujeFlet", "ontab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",7, true)");
				asignarAtributo("AREATEXTO", "indSujeFlet", "onshtab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",7, false)");
				asignarAtributo("AREATEXTO", "indReseStoc", "ontab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",8, true)");
				asignarAtributo("AREATEXTO", "indReseStoc", "onshtab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",8, false)");
				asignarAtributo("AREATEXTO", "indPermReve", "ontab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",9, true)");
				asignarAtributo("AREATEXTO", "indPermReve", "onshtab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",9, false)");
				asignarAtributo("AREATEXTO", "indPediPrue", "ontab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",10, true)");
				asignarAtributo("AREATEXTO", "indPediPrue", "onshtab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",10, false)");
				asignarAtributo("AREATEXTO", "indComi", "ontab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",11, true)");
				asignarAtributo("AREATEXTO", "indComi", "onshtab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",11, false)");
				asignarAtributo("AREATEXTO", "indVentInteSab14", "ontab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",12, true)");
				asignarAtributo("AREATEXTO", "indVentInteSab14", "onshtab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",12, false)");
					asignarAtributo("COMBO","cactOidActi", "ontab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",13, true)");
					asignarAtributo("COMBO","cactOidActi", "onshtab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",13, false)");
					asignarAtributo("COMBO","moneOidMone", "ontab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",14, true)");
					asignarAtributo("COMBO","moneOidMone", "onshtab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",14, false)");
					asignarAtributo("COMBO","tmalOidTipoMoviAsig", "ontab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",15, true)");
					asignarAtributo("COMBO","tmalOidTipoMoviAsig", "onshtab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",15, false)");
					asignarAtributo("COMBO","tmalOidTipoMoviRese", "ontab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",16, true)");
					asignarAtributo("COMBO","tmalOidTipoMoviRese", "onshtab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",16, false)");
					asignarAtributo("COMBO","tmalOidTipoMoviFact", "ontab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",17, true)");
					asignarAtributo("COMBO","tmalOidTipoMoviFact", "onshtab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",17, false)");
					asignarAtributo("COMBO","tidoOidTipoDocu", "ontab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",18, true)");
					asignarAtributo("COMBO","tidoOidTipoDocu", "onshtab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",18, false)");
				asignarAtributo("AREATEXTO", "indPermUnio", "ontab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",19, true)");
				asignarAtributo("AREATEXTO", "indPermUnio", "onshtab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",19, false)");
				asignarAtributo("AREATEXTO", "indPediGtZona", "ontab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",20, true)");
				asignarAtributo("AREATEXTO", "indPediGtZona", "onshtab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",20, false)");
				asignarAtributo("AREATEXTO", "indCambVentBel", "ontab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",21, true)");
				asignarAtributo("AREATEXTO", "indCambVentBel", "onshtab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",21, false)");
					asignarAtributo("COMBO","almcOidAlma", "ontab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",22, true)");
					asignarAtributo("COMBO","almcOidAlma", "onshtab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",22, false)");
					asignarAtributo("COMBO","sociOidSoci", "ontab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",23, true)");
					asignarAtributo("COMBO","sociOidSoci", "onshtab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",23, false)");
				asignarAtributo("AREATEXTO", "valGlos", "ontab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",24, true)");
				asignarAtributo("AREATEXTO", "valGlos", "onshtab","ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",24, false)");
					asignarAtributo("COMBO","tsolOidTipoCons", "ontab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",25, true)");
					asignarAtributo("COMBO","tsolOidTipoCons", "onshtab", "ejecutarAccionFocoModificacion(\"pedTipoSolicPaisFrm\",25, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","pedTipoSolicPaisTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","pedTipoSolicPaisTrButtons");

		//Borramos los elementos no necesarios de la búsqueda para los campos con búsquda
		//por intervalo
	}
	
	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de view
	*/
	protected void removeNonViewElements() throws Exception{
		
						borrarCampo("id");
							borrarCampo("paisOidPais");
	}

	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario en el
	* modo de inserción
	*/
	protected void removeNonInsertElements() throws Exception{
		
						borrarCampo("id");
							borrarCampo("paisOidPais");
	}

	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario en el
	* modo de remove
	*/
	protected void removeNonSearchElements() throws Exception{
		borrarCampo("id");
		borrarCampo("paisOidPais");
		
	}
	
	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario 
	* de modificación
	*/
	protected void removeNonModifyFields() throws Exception{
		borrarCampo("id");
		borrarCampo("paisOidPais");
		
	}
	
	/**
	* Nos permite desactivar los campos del formulario que no deben aparecer en el formulario 
	* para modificación
	*/
	protected void desactivateNonModifyFields() throws Exception{
			traza("MMG: en desactivateNonModifyFields ");		
		
				traza("MMG: el atributo es id...");		
				
				traza("MMG: el atributo es paisOidPais...");		
				
				traza("MMG: el atributo es tsolOidTipoSoli...");		
				
				traza("MMG: el atributo es numSoliLote...");		
				
				traza("MMG: el atributo es numUnidAlar...");		
				
				traza("MMG: el atributo es fopaOidFormPago...");		
				
				traza("MMG: el atributo es indSujeFlet...");		
				
				traza("MMG: el atributo es indReseStoc...");		
				
				traza("MMG: el atributo es indPermReve...");		
				
				traza("MMG: el atributo es indPediPrue...");		
				
				traza("MMG: el atributo es indComi...");		
				
				traza("MMG: el atributo es indVentInteSab14...");		
				
				traza("MMG: el atributo es cactOidActi...");		
				
				traza("MMG: el atributo es moneOidMone...");		
				
				traza("MMG: el atributo es tmalOidTipoMoviAsig...");		
				
				traza("MMG: el atributo es tmalOidTipoMoviRese...");		
				
				traza("MMG: el atributo es tmalOidTipoMoviFact...");		
				
				traza("MMG: el atributo es tidoOidTipoDocu...");		
				
				traza("MMG: el atributo es indPermUnio...");		
				
				traza("MMG: el atributo es indPediGtZona...");		
				
				traza("MMG: el atributo es indCambVentBel...");		
				
				traza("MMG: el atributo es almcOidAlma...");		
				
				traza("MMG: el atributo es sociOidSoci...");		
				
				traza("MMG: el atributo es valGlos...");		
				
				traza("MMG: el atributo es tsolOidTipoCons...");		
				
		}

	/**
	* Nos permite establecer el tamaño de las capas de la pantalla según el modo
	* Esto se debe a que dependiendo del modo aparecen unos campos u otros 
	*/
	protected void establecerSizeCapas(String accion, String origen) throws Exception{
		//Dependiendo del modo el tamaño del formualrio será uno u otro
		int sizeForm = 0;
		if(accion.equals(ACCION_LOV)) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_VIEW)) sizeForm = VIEWFORM_SIZE;
		else if(accion.equals(ACCION_CREATE)) sizeForm = CREATEFORM_SIZE;
		else if(accion.equals(ACCION_REMOVE)) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_QUERY)) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_UPDATE) && origen.equals("menu")) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_UPDATE) && origen.equals("pagina")) sizeForm = UPDATEFORM_SIZE;
		else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")) sizeForm = UPDATEFORM_SIZE;
		
		//Establecemos el tamaño de la capa del formulario
		asignarAtributo("CAPA","pedTipoSolicPaisFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","pedTipoSolicPaisListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","pedTipoSolicPaisListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(PedTipoSolicPaisData pedTipoSolicPais) throws Exception{
		HashMap checkedCombos = new HashMap();
		SegPaisViewData paisOidPais = new SegPaisViewData();
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, 
			paisOidPais, paisOidPais.clone(), "segPaisView", "paisOidPais", "result_ROWSET" );
		if(pedTipoSolicPais != null && pedTipoSolicPais.getPaisOidPais() != null){
				checkCombo("paisOidPais" , pedTipoSolicPais.getPaisOidPais().getId().toString());
			}
		String paisOidPaisDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPaisView");
		if(paisOidPaisDefaultValue != null && !paisOidPaisDefaultValue.trim().equals("")){
			checkCombo("paisOidPais", paisOidPaisDefaultValue);
			checkedCombos.put("paisOidPais",paisOidPaisDefaultValue);
			cascadeComboLoad(checkedCombos, "paisOidPais");
		}						 
		PedTipoSolicViewData tsolOidTipoSoli = new PedTipoSolicViewData();
		
						asignarComboResultados(BUSINESSID_TSOLOIDTIPOSOLI_QUERY,TSOLOIDTIPOSOLI_COMBO_CONNECTOR, 
			tsolOidTipoSoli, tsolOidTipoSoli.clone(), "pedTipoSolicView", "tsolOidTipoSoli", "result_ROWSET" );
		if(pedTipoSolicPais != null && pedTipoSolicPais.getTsolOidTipoSoli() != null){
				checkCombo("tsolOidTipoSoli" , pedTipoSolicPais.getTsolOidTipoSoli().getId().toString());
			}
		BelFormaPagoData fopaOidFormPago = new BelFormaPagoData();
		
						asignarComboResultados(BUSINESSID_FOPAOIDFORMPAGO_QUERY,FOPAOIDFORMPAGO_COMBO_CONNECTOR, 
			fopaOidFormPago, fopaOidFormPago.clone(), "belFormaPago", "fopaOidFormPago", "result_ROWSET" );
		if(pedTipoSolicPais != null && pedTipoSolicPais.getFopaOidFormPago() != null){
				checkCombo("fopaOidFormPago" , pedTipoSolicPais.getFopaOidFormPago().getId().toString());
			}
		CraActivData cactOidActi = new CraActivData();
		
						asignarComboResultados(BUSINESSID_CACTOIDACTI_QUERY,CACTOIDACTI_COMBO_CONNECTOR, 
			cactOidActi, cactOidActi.clone(), "craActiv", "cactOidActi", "result_ROWSET" );
		if(pedTipoSolicPais != null && pedTipoSolicPais.getCactOidActi() != null){
				checkCombo("cactOidActi" , pedTipoSolicPais.getCactOidActi().getId().toString());
			}
		SegMonedData moneOidMone = new SegMonedData();
		
						asignarComboResultados(BUSINESSID_MONEOIDMONE_QUERY,MONEOIDMONE_COMBO_CONNECTOR, 
			moneOidMone, moneOidMone.clone(), "segMoned", "moneOidMone", "result_ROWSET" );
		if(pedTipoSolicPais != null && pedTipoSolicPais.getMoneOidMone() != null){
				checkCombo("moneOidMone" , pedTipoSolicPais.getMoneOidMone().getId().toString());
			}
		BelTipoMovimAlmacData tmalOidTipoMoviAsig = new BelTipoMovimAlmacData();
		
						asignarComboResultados(BUSINESSID_TMALOIDTIPOMOVIASIG_QUERY,TMALOIDTIPOMOVIASIG_COMBO_CONNECTOR, 
			tmalOidTipoMoviAsig, tmalOidTipoMoviAsig.clone(), "belTipoMovimAlmac", "tmalOidTipoMoviAsig", "result_ROWSET" );
		if(pedTipoSolicPais != null && pedTipoSolicPais.getTmalOidTipoMoviAsig() != null){
				checkCombo("tmalOidTipoMoviAsig" , pedTipoSolicPais.getTmalOidTipoMoviAsig().getId().toString());
			}
		BelTipoMovimAlmacData tmalOidTipoMoviRese = new BelTipoMovimAlmacData();
		
						asignarComboResultados(BUSINESSID_TMALOIDTIPOMOVIRESE_QUERY,TMALOIDTIPOMOVIRESE_COMBO_CONNECTOR, 
			tmalOidTipoMoviRese, tmalOidTipoMoviRese.clone(), "belTipoMovimAlmac", "tmalOidTipoMoviRese", "result_ROWSET" );
		if(pedTipoSolicPais != null && pedTipoSolicPais.getTmalOidTipoMoviRese() != null){
				checkCombo("tmalOidTipoMoviRese" , pedTipoSolicPais.getTmalOidTipoMoviRese().getId().toString());
			}
		BelTipoMovimAlmacData tmalOidTipoMoviFact = new BelTipoMovimAlmacData();
		
						asignarComboResultados(BUSINESSID_TMALOIDTIPOMOVIFACT_QUERY,TMALOIDTIPOMOVIFACT_COMBO_CONNECTOR, 
			tmalOidTipoMoviFact, tmalOidTipoMoviFact.clone(), "belTipoMovimAlmac", "tmalOidTipoMoviFact", "result_ROWSET" );
		if(pedTipoSolicPais != null && pedTipoSolicPais.getTmalOidTipoMoviFact() != null){
				checkCombo("tmalOidTipoMoviFact" , pedTipoSolicPais.getTmalOidTipoMoviFact().getId().toString());
			}
		FacTipoDocumData tidoOidTipoDocu = new FacTipoDocumData();
		
						asignarComboResultados(BUSINESSID_TIDOOIDTIPODOCU_QUERY,TIDOOIDTIPODOCU_COMBO_CONNECTOR, 
			tidoOidTipoDocu, tidoOidTipoDocu.clone(), "facTipoDocum", "tidoOidTipoDocu", "result_ROWSET" );
		if(pedTipoSolicPais != null && pedTipoSolicPais.getTidoOidTipoDocu() != null){
				checkCombo("tidoOidTipoDocu" , pedTipoSolicPais.getTidoOidTipoDocu().getId().toString());
			}
		BelAlmacData almcOidAlma = new BelAlmacData();
		
						asignarComboResultados(BUSINESSID_ALMCOIDALMA_QUERY,ALMCOIDALMA_COMBO_CONNECTOR, 
			almcOidAlma, almcOidAlma.clone(), "belAlmac", "almcOidAlma", "result_ROWSET" );
		if(pedTipoSolicPais != null && pedTipoSolicPais.getAlmcOidAlma() != null){
				checkCombo("almcOidAlma" , pedTipoSolicPais.getAlmcOidAlma().getId().toString());
			}
		SegSocieData sociOidSoci = new SegSocieData();
		
						asignarComboResultados(BUSINESSID_SOCIOIDSOCI_QUERY,SOCIOIDSOCI_COMBO_CONNECTOR, 
			sociOidSoci, sociOidSoci.clone(), "segSocie", "sociOidSoci", "result_ROWSET" );
		if(pedTipoSolicPais != null && pedTipoSolicPais.getSociOidSoci() != null){
				checkCombo("sociOidSoci" , pedTipoSolicPais.getSociOidSoci().getId().toString());
			}
		String sociOidSociDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegSocie");
		if(sociOidSociDefaultValue != null && !sociOidSociDefaultValue.trim().equals("")){
			checkCombo("sociOidSoci", sociOidSociDefaultValue);
			checkedCombos.put("sociOidSoci",sociOidSociDefaultValue);
			cascadeComboLoad(checkedCombos, "sociOidSoci");
		}						 
		PedTipoSolicPaisViewData tsolOidTipoCons = new PedTipoSolicPaisViewData();
		
						asignarComboResultados(BUSINESSID_TSOLOIDTIPOCONS_QUERY,TSOLOIDTIPOCONS_COMBO_CONNECTOR, 
			tsolOidTipoCons, tsolOidTipoCons.clone(), "pedTipoSolicPaisView", "tsolOidTipoCons", "result_ROWSET" );
		if(pedTipoSolicPais != null && pedTipoSolicPais.getTsolOidTipoCons() != null){
				checkCombo("tsolOidTipoCons" , pedTipoSolicPais.getTsolOidTipoCons().getId().toString());
			}
		
	}
	
	/**
	* Nos permite cargar en cascada jerarquía de combos dependientes por la selección de valor en uno de sus elementos
	*/
	public void cascadeComboLoad(HashMap checkedCombos, String comboName) throws Exception{
		
	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param pedTipoSolicPais La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(PedTipoSolicPaisData pedTipoSolicPais) 
		throws Exception{
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		PedTipoSolicPaisData pedTipoSolicPais = 
			(PedTipoSolicPaisData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(pedTipoSolicPais.getPaisOidPais() != null){
			pedTipoSolicPais.setPaisOidPais((es.indra.belcorp.mso.SegPaisViewData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			pedTipoSolicPais.getPaisOidPais(),
			pedTipoSolicPais.getPaisOidPais().clone(),
			"segPaisView"));
		}
		if(pedTipoSolicPais.getTsolOidTipoSoli() != null){
			pedTipoSolicPais.setTsolOidTipoSoli((es.indra.belcorp.mso.PedTipoSolicViewData)
			getSingleObject(BUSINESSID_TSOLOIDTIPOSOLI_QUERY, 
			pedTipoSolicPais.getTsolOidTipoSoli(),
			pedTipoSolicPais.getTsolOidTipoSoli().clone(),
			"pedTipoSolicView"));
		}
		if(pedTipoSolicPais.getFopaOidFormPago() != null){
			pedTipoSolicPais.setFopaOidFormPago((es.indra.belcorp.mso.BelFormaPagoData)
			getSingleObject(BUSINESSID_FOPAOIDFORMPAGO_QUERY, 
			pedTipoSolicPais.getFopaOidFormPago(),
			pedTipoSolicPais.getFopaOidFormPago().clone(),
			"belFormaPago"));
		}
		if(pedTipoSolicPais.getCactOidActi() != null){
			pedTipoSolicPais.setCactOidActi((es.indra.belcorp.mso.CraActivData)
			getSingleObject(BUSINESSID_CACTOIDACTI_QUERY, 
			pedTipoSolicPais.getCactOidActi(),
			pedTipoSolicPais.getCactOidActi().clone(),
			"craActiv"));
		}
		if(pedTipoSolicPais.getMoneOidMone() != null){
			pedTipoSolicPais.setMoneOidMone((es.indra.belcorp.mso.SegMonedData)
			getSingleObject(BUSINESSID_MONEOIDMONE_QUERY, 
			pedTipoSolicPais.getMoneOidMone(),
			pedTipoSolicPais.getMoneOidMone().clone(),
			"segMoned"));
		}
		if(pedTipoSolicPais.getTmalOidTipoMoviAsig() != null){
			pedTipoSolicPais.setTmalOidTipoMoviAsig((es.indra.belcorp.mso.BelTipoMovimAlmacData)
			getSingleObject(BUSINESSID_TMALOIDTIPOMOVIASIG_QUERY, 
			pedTipoSolicPais.getTmalOidTipoMoviAsig(),
			pedTipoSolicPais.getTmalOidTipoMoviAsig().clone(),
			"belTipoMovimAlmac"));
		}
		if(pedTipoSolicPais.getTmalOidTipoMoviRese() != null){
			pedTipoSolicPais.setTmalOidTipoMoviRese((es.indra.belcorp.mso.BelTipoMovimAlmacData)
			getSingleObject(BUSINESSID_TMALOIDTIPOMOVIRESE_QUERY, 
			pedTipoSolicPais.getTmalOidTipoMoviRese(),
			pedTipoSolicPais.getTmalOidTipoMoviRese().clone(),
			"belTipoMovimAlmac"));
		}
		if(pedTipoSolicPais.getTmalOidTipoMoviFact() != null){
			pedTipoSolicPais.setTmalOidTipoMoviFact((es.indra.belcorp.mso.BelTipoMovimAlmacData)
			getSingleObject(BUSINESSID_TMALOIDTIPOMOVIFACT_QUERY, 
			pedTipoSolicPais.getTmalOidTipoMoviFact(),
			pedTipoSolicPais.getTmalOidTipoMoviFact().clone(),
			"belTipoMovimAlmac"));
		}
		if(pedTipoSolicPais.getTidoOidTipoDocu() != null){
			pedTipoSolicPais.setTidoOidTipoDocu((es.indra.belcorp.mso.FacTipoDocumData)
			getSingleObject(BUSINESSID_TIDOOIDTIPODOCU_QUERY, 
			pedTipoSolicPais.getTidoOidTipoDocu(),
			pedTipoSolicPais.getTidoOidTipoDocu().clone(),
			"facTipoDocum"));
		}
		if(pedTipoSolicPais.getAlmcOidAlma() != null){
			pedTipoSolicPais.setAlmcOidAlma((es.indra.belcorp.mso.BelAlmacData)
			getSingleObject(BUSINESSID_ALMCOIDALMA_QUERY, 
			pedTipoSolicPais.getAlmcOidAlma(),
			pedTipoSolicPais.getAlmcOidAlma().clone(),
			"belAlmac"));
		}
		if(pedTipoSolicPais.getSociOidSoci() != null){
			pedTipoSolicPais.setSociOidSoci((es.indra.belcorp.mso.SegSocieData)
			getSingleObject(BUSINESSID_SOCIOIDSOCI_QUERY, 
			pedTipoSolicPais.getSociOidSoci(),
			pedTipoSolicPais.getSociOidSoci().clone(),
			"segSocie"));
		}
		if(pedTipoSolicPais.getTsolOidTipoCons() != null){
			pedTipoSolicPais.setTsolOidTipoCons((es.indra.belcorp.mso.PedTipoSolicPaisViewData)
			getSingleObject(BUSINESSID_TSOLOIDTIPOCONS_QUERY, 
			pedTipoSolicPais.getTsolOidTipoCons(),
			pedTipoSolicPais.getTsolOidTipoCons().clone(),
			"pedTipoSolicPaisView"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(pedTipoSolicPais);
		loadLeafDependenceCombos(pedTipoSolicPais);
	}
	
	/**
	*	Por defecto en los campos que tienen la búsqueda por intervalo el label del campo es el label
	*	correspondiente a campos normal (como si no fuera un campo con intervalor). En los modos de busqueda 
	*	(search, update search y remove search) tendremos que poner el label a la búsqueda "desde"
	*/
	protected void setIntervalSearchFromLavels() throws Exception{
	}
	
	/**
	*	Metodo que nos elimina los trs que quedan vacíos por no aparecer sus campos por el modo
	*/
	protected void eliminarTrsVacios(String accion, String origen) throws Exception{
		if(accion.equals(ACCION_QUERY) || accion.equals(ACCION_LOV) ||
			(accion.equals(ACCION_UPDATE) && origen.equals("menu")) ||
			(accion.equals(ACCION_REMOVE) && origen.equals("menu"))){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			
		}else if(accion.equals(ACCION_VIEW) && origen.equals("preview")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			
		}else if(accion.equals(ACCION_CREATE)){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			
		}else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			
		}
	}
	
	
	
		
}





