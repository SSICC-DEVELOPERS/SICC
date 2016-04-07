/*
    INDRA/CAR/mmg
    $Id: BelParamBelceLPStartUp.java,v 1.1 2009/12/03 18:38:25 pecbazalar Exp $
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
public class BelParamBelceLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 1155;
	public static final short CREATEFORM_SIZE = 1229;
	public static final short UPDATEFORM_SIZE = 1229;
	public static final short VIEWFORM_SIZE = 1229;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGBelParamBelceQueryFromToUserPage";
	
	
				public static final String BUSINESSID_SBACOIDSBAC_ACCEOIDACCE_CANAOIDCANA_QUERY ="MMGSegCanalViewQueryFromToUser";
				public static final String BUSINESSID_SBACOIDSBAC_ACCEOIDACCE_QUERY ="MMGSegAccesQueryFromToUser";
				public static final String BUSINESSID_SBACOIDSBAC_QUERY ="MMGSegSubacQueryFromToUser";
				public static final String SBACOIDSBAC_ACCEOIDACCE_CANAOIDCANA_COMBO_CONNECTOR = "SegCanalViewConectorCombo";
	
				public static final String SBACOIDSBAC_ACCEOIDACCE_COMBO_CONNECTOR = "SegAccesConectorCombo";
	
				public static final String SBACOIDSBAC_COMBO_CONNECTOR = "SegSubacConectorCombo";
	
				public static final String BUSINESSID_CLIEOIDCLIE_QUERY ="MMGMaeClienViewQueryFromToUser";
				public static final String CLIEOIDCLIE_COMBO_CONNECTOR = "MaeClienViewConectorCombo";
	
				public static final String BUSINESSID_SOCIOIDSOCI_QUERY ="MMGSegSocieViewQueryFromToUser";
				public static final String SOCIOIDSOCI_COMBO_CONNECTOR = "SegSocieViewConectorCombo";
	
				public static final String BUSINESSID_TTRAOIDTIPOTRAN_QUERY ="MMGCccTipoTransViewQueryFromToUser";
				public static final String TTRAOIDTIPOTRAN_COMBO_CONNECTOR = "CccTipoTransViewConectorCombo";
	
				public static final String BUSINESSID_CCBAOIDCUENCORRBANC_SOCIOIDSOCI_QUERY ="MMGSegSocieQueryFromToUser";
				public static final String BUSINESSID_CCBAOIDCUENCORRBANC_CUCOOIDCCTESO_QUERY ="MMGCccCuentContaQueryFromToUser";
				public static final String BUSINESSID_CCBAOIDCUENCORRBANC_CUCOOIDCCPNTE_QUERY ="MMGCccCuentContaQueryFromToUser";
				public static final String BUSINESSID_CCBAOIDCUENCORRBANC_SUCUOIDSUCU_CBANOIDBANC_QUERY ="MMGCccBancoQueryFromToUser";
				public static final String BUSINESSID_CCBAOIDCUENCORRBANC_SUCUOIDSUCU_QUERY ="MMGCccSucurQueryFromToUser";
				public static final String BUSINESSID_CCBAOIDCUENCORRBANC_QUERY ="MMGCccCuentCorriBancaQueryFromToUser";
				public static final String CCBAOIDCUENCORRBANC_SOCIOIDSOCI_COMBO_CONNECTOR = "SegSocieConectorCombo";
	
				public static final String CCBAOIDCUENCORRBANC_CUCOOIDCCTESO_COMBO_CONNECTOR = "CccCuentContaConectorCombo";
	
				public static final String CCBAOIDCUENCORRBANC_CUCOOIDCCPNTE_COMBO_CONNECTOR = "CccCuentContaConectorCombo";
	
				public static final String CCBAOIDCUENCORRBANC_SUCUOIDSUCU_CBANOIDBANC_COMBO_CONNECTOR = "CccBancoConectorCombo";
	
				public static final String CCBAOIDCUENCORRBANC_SUCUOIDSUCU_COMBO_CONNECTOR = "CccSucurConectorCombo";
	
				public static final String CCBAOIDCUENCORRBANC_COMBO_CONNECTOR = "CccCuentCorriBancaConectorCombo";
	
				public static final String BUSINESSID_TMVCOIDCOBR_QUERY ="MMGBelTipoMovimCajaQueryFromToUser";
				public static final String TMVCOIDCOBR_COMBO_CONNECTOR = "BelTipoMovimCajaConectorCombo";
	
				public static final String BUSINESSID_TMVCOIDCIER_QUERY ="MMGBelTipoMovimCajaQueryFromToUser";
				public static final String TMVCOIDCIER_COMBO_CONNECTOR = "BelTipoMovimCajaConectorCombo";
	
				public static final String BUSINESSID_TMALOIDCONFSTOC_QUERY ="MMGBelTipoMovimAlmacViewQueryFromToUser";
				public static final String TMALOIDCONFSTOC_COMBO_CONNECTOR = "BelTipoMovimAlmacViewConectorCombo";
	
				public static final String BUSINESSID_TMALOIDCONFSTOCTRAN_QUERY ="MMGBelTipoMovimAlmacViewQueryFromToUser";
				public static final String TMALOIDCONFSTOCTRAN_COMBO_CONNECTOR = "BelTipoMovimAlmacViewConectorCombo";
	
				public static final String BUSINESSID_TMALOIDSTOCTRAN_QUERY ="MMGBelTipoMovimAlmacViewQueryFromToUser";
				public static final String TMALOIDSTOCTRAN_COMBO_CONNECTOR = "BelTipoMovimAlmacViewConectorCombo";
	
				public static final String BUSINESSID_TMALOIDSTOCDEVO_QUERY ="MMGBelTipoMovimAlmacViewQueryFromToUser";
				public static final String TMALOIDSTOCDEVO_COMBO_CONNECTOR = "BelTipoMovimAlmacViewConectorCombo";
	
				public static final String BUSINESSID_TMALOIDREGU_QUERY ="MMGBelTipoMovimAlmacViewQueryFromToUser";
				public static final String TMALOIDREGU_COMBO_CONNECTOR = "BelTipoMovimAlmacViewConectorCombo";
	
				public static final String BUSINESSID_TMALOIDREGUSAP_QUERY ="MMGBelTipoMovimAlmacViewQueryFromToUser";
				public static final String TMALOIDREGUSAP_COMBO_CONNECTOR = "BelTipoMovimAlmacViewConectorCombo";
	
				public static final String BUSINESSID_TMALOIDDEVOSTOC_QUERY ="MMGBelTipoMovimAlmacViewQueryFromToUser";
				public static final String TMALOIDDEVOSTOC_COMBO_CONNECTOR = "BelTipoMovimAlmacViewConectorCombo";
	
				public static final String BUSINESSID_TMALOIDPETIEXIS_QUERY ="MMGBelTipoMovimAlmacViewQueryFromToUser";
				public static final String TMALOIDPETIEXIS_COMBO_CONNECTOR = "BelTipoMovimAlmacViewConectorCombo";
	
				public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisViewQueryFromToUser";
				public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisViewConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public BelParamBelceLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("BelParamBelcePage");
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
			buildJsPageSize("BelParamBelce");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "BelParamBelcePage", "cod", "BelParamBelce." + accion + ".label");
			
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
			limpiarBotoneraLista("belParamBelce", accion);
			
			
			
			
			
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
		
		asignarAtributo("TEXT", "valDire", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 50);");
		asignarAtributo("TEXT", "valTfno", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 30);");
		asignarAtributo("TEXT", "valMontMaxiDife", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valMontMaxiDife', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valLimiEfecCaja", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valLimiEfecCaja', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numCaja", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "valNombLoca", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "valTiempRepo", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
		asignarAtributo("TEXT", "valFactLoca", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valFactLoca', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numMaxiProd", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "valAlerStoc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 10, 0, 9999999999);");
		asignarAtributo("TEXT", "valUsua", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "belParamBelceLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "BelParamBelcePage", "onblur", "window.focus();");
		
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
		conectorAction("BelParamBelceLPStartUp");
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
		BelParamBelceData belParamBelceQuery= new BelParamBelceData();
		belParamBelceQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		BelParamBelceData datosResult = (BelParamBelceData)getSingleObject(BUSINESSID_QUERY, belParamBelceQuery, 
			belParamBelceQuery.clone(), "belParamBelce");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		BelParamBelceData belParamBelce = datosResult;
		es.indra.belcorp.mso.SegSubacData sbacOidSbac = belParamBelce.getSbacOidSbac();
		if(sbacOidSbac != null && sbacOidSbac.getId() != null) checkCombo("sbacOidSbac" , sbacOidSbac.getId().toString());
		asignar("TEXT", "valDire", FormatUtils.formatObject(belParamBelce.getValDire(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valTfno", FormatUtils.formatObject(belParamBelce.getValTfno(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valMontMaxiDife", FormatUtils.formatObject(belParamBelce.getValMontMaxiDife(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valLimiEfecCaja", FormatUtils.formatObject(belParamBelce.getValLimiEfecCaja(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numCaja", FormatUtils.formatObject(belParamBelce.getNumCaja(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valNombLoca", FormatUtils.formatObject(belParamBelce.getValNombLoca(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valTiempRepo", FormatUtils.formatObject(belParamBelce.getValTiempRepo(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valFactLoca", FormatUtils.formatObject(belParamBelce.getValFactLoca(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numMaxiProd", FormatUtils.formatObject(belParamBelce.getNumMaxiProd(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valAlerStoc", FormatUtils.formatObject(belParamBelce.getValAlerStoc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valUsua", FormatUtils.formatObject(belParamBelce.getValUsua(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.MaeClienViewData clieOidClie = belParamBelce.getClieOidClie();
		if(clieOidClie != null && clieOidClie.getId() != null) checkCombo("clieOidClie" , clieOidClie.getId().toString());
		es.indra.belcorp.mso.SegSocieViewData sociOidSoci = belParamBelce.getSociOidSoci();
		if(sociOidSoci != null && sociOidSoci.getId() != null) checkCombo("sociOidSoci" , sociOidSoci.getId().toString());
		es.indra.belcorp.mso.CccTipoTransViewData ttraOidTipoTran = belParamBelce.getTtraOidTipoTran();
		if(ttraOidTipoTran != null && ttraOidTipoTran.getId() != null) checkCombo("ttraOidTipoTran" , ttraOidTipoTran.getId().toString());
		es.indra.belcorp.mso.CccCuentCorriBancaData ccbaOidCuenCorrBanc = belParamBelce.getCcbaOidCuenCorrBanc();
		if(ccbaOidCuenCorrBanc != null && ccbaOidCuenCorrBanc.getId() != null) checkCombo("ccbaOidCuenCorrBanc" , ccbaOidCuenCorrBanc.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimCajaData tmvcOidCobr = belParamBelce.getTmvcOidCobr();
		if(tmvcOidCobr != null && tmvcOidCobr.getId() != null) checkCombo("tmvcOidCobr" , tmvcOidCobr.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimCajaData tmvcOidCier = belParamBelce.getTmvcOidCier();
		if(tmvcOidCier != null && tmvcOidCier.getId() != null) checkCombo("tmvcOidCier" , tmvcOidCier.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidConfStoc = belParamBelce.getTmalOidConfStoc();
		if(tmalOidConfStoc != null && tmalOidConfStoc.getId() != null) checkCombo("tmalOidConfStoc" , tmalOidConfStoc.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidConfStocTran = belParamBelce.getTmalOidConfStocTran();
		if(tmalOidConfStocTran != null && tmalOidConfStocTran.getId() != null) checkCombo("tmalOidConfStocTran" , tmalOidConfStocTran.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidStocTran = belParamBelce.getTmalOidStocTran();
		if(tmalOidStocTran != null && tmalOidStocTran.getId() != null) checkCombo("tmalOidStocTran" , tmalOidStocTran.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidStocDevo = belParamBelce.getTmalOidStocDevo();
		if(tmalOidStocDevo != null && tmalOidStocDevo.getId() != null) checkCombo("tmalOidStocDevo" , tmalOidStocDevo.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidRegu = belParamBelce.getTmalOidRegu();
		if(tmalOidRegu != null && tmalOidRegu.getId() != null) checkCombo("tmalOidRegu" , tmalOidRegu.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidReguSap = belParamBelce.getTmalOidReguSap();
		if(tmalOidReguSap != null && tmalOidReguSap.getId() != null) checkCombo("tmalOidReguSap" , tmalOidReguSap.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidDevoStoc = belParamBelce.getTmalOidDevoStoc();
		if(tmalOidDevoStoc != null && tmalOidDevoStoc.getId() != null) checkCombo("tmalOidDevoStoc" , tmalOidDevoStoc.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidPetiExis = belParamBelce.getTmalOidPetiExis();
		if(tmalOidPetiExis != null && tmalOidPetiExis.getId() != null) checkCombo("tmalOidPetiExis" , tmalOidPetiExis.getId().toString());
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		
									asignarAtributo("COMBO", "sbacOidSbac_acceOidAcce_canaOidCana", "disabled", "S");

									asignarAtributo("COMBO", "sbacOidSbac_acceOidAcce", "disabled", "S");

					asignarAtributo("COMBO", "sbacOidSbac", "disabled", "S");asignarAtributo("TEXT", "valDire", "disabled", "S");
		asignarAtributo("TEXT", "valTfno", "disabled", "S");
		asignarAtributo("TEXT", "valMontMaxiDife", "disabled", "S");
		asignarAtributo("TEXT", "valLimiEfecCaja", "disabled", "S");
		asignarAtributo("TEXT", "numCaja", "disabled", "S");
		asignarAtributo("TEXT", "valNombLoca", "disabled", "S");
		asignarAtributo("TEXT", "valTiempRepo", "disabled", "S");
		asignarAtributo("TEXT", "valFactLoca", "disabled", "S");
		asignarAtributo("TEXT", "numMaxiProd", "disabled", "S");
		asignarAtributo("TEXT", "valAlerStoc", "disabled", "S");
		asignarAtributo("TEXT", "valUsua", "disabled", "S");
		
					asignarAtributo("COMBO", "clieOidClie", "disabled", "S");
					asignarAtributo("COMBO", "sociOidSoci", "disabled", "S");
					asignarAtributo("COMBO", "ttraOidTipoTran", "disabled", "S");
									asignarAtributo("COMBO", "ccbaOidCuenCorrBanc_sociOidSoci", "disabled", "S");

									asignarAtributo("COMBO", "ccbaOidCuenCorrBanc_cucoOidCcTeso", "disabled", "S");

									asignarAtributo("COMBO", "ccbaOidCuenCorrBanc_cucoOidCcPnte", "disabled", "S");

									asignarAtributo("COMBO", "ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc", "disabled", "S");

									asignarAtributo("COMBO", "ccbaOidCuenCorrBanc_sucuOidSucu", "disabled", "S");

					asignarAtributo("COMBO", "ccbaOidCuenCorrBanc", "disabled", "S");
					asignarAtributo("COMBO", "tmvcOidCobr", "disabled", "S");
					asignarAtributo("COMBO", "tmvcOidCier", "disabled", "S");
					asignarAtributo("COMBO", "tmalOidConfStoc", "disabled", "S");
					asignarAtributo("COMBO", "tmalOidConfStocTran", "disabled", "S");
					asignarAtributo("COMBO", "tmalOidStocTran", "disabled", "S");
					asignarAtributo("COMBO", "tmalOidStocDevo", "disabled", "S");
					asignarAtributo("COMBO", "tmalOidRegu", "disabled", "S");
					asignarAtributo("COMBO", "tmalOidReguSap", "disabled", "S");
					asignarAtributo("COMBO", "tmalOidDevoStoc", "disabled", "S");
					asignarAtributo("COMBO", "tmalOidPetiExis", "disabled", "S");
		
	
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
		asignarAtributo("COMBO", "sbacOidSbac", "req", "S");
		asignarAtributo("TEXT", "valDire", "req", "S");
		asignarAtributo("TEXT", "valMontMaxiDife", "req", "S");
		asignarAtributo("TEXT", "valLimiEfecCaja", "req", "S");
		asignarAtributo("TEXT", "numCaja", "req", "S");
		asignarAtributo("TEXT", "valNombLoca", "req", "S");
		asignarAtributo("TEXT", "valTiempRepo", "req", "S");
		asignarAtributo("TEXT", "valFactLoca", "req", "S");
		asignarAtributo("TEXT", "numMaxiProd", "req", "S");
		asignarAtributo("TEXT", "valAlerStoc", "req", "S");
		asignarAtributo("TEXT", "valUsua", "req", "S");
		asignarAtributo("COMBO", "clieOidClie", "req", "S");
		asignarAtributo("COMBO", "sociOidSoci", "req", "S");
		asignarAtributo("COMBO", "ttraOidTipoTran", "req", "S");
		asignarAtributo("COMBO", "ccbaOidCuenCorrBanc", "req", "S");
		asignarAtributo("COMBO", "tmvcOidCobr", "req", "S");
		asignarAtributo("COMBO", "tmvcOidCier", "req", "S");
		asignarAtributo("COMBO", "tmalOidConfStoc", "req", "S");
		asignarAtributo("COMBO", "tmalOidConfStocTran", "req", "S");
		asignarAtributo("COMBO", "tmalOidStocTran", "req", "S");
		asignarAtributo("COMBO", "tmalOidStocDevo", "req", "S");
		asignarAtributo("COMBO", "tmalOidRegu", "req", "S");
		asignarAtributo("COMBO", "tmalOidReguSap", "req", "S");
		asignarAtributo("COMBO", "tmalOidDevoStoc", "req", "S");
		asignarAtributo("COMBO", "tmalOidPetiExis", "req", "S");
		
		
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
		
		asignarAtributo("TEXT", "valDire", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 50);");
		asignarAtributo("TEXT", "valTfno", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 30);");
		asignarAtributo("TEXT", "valMontMaxiDife", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valMontMaxiDife', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valLimiEfecCaja", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valLimiEfecCaja', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numCaja", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "valNombLoca", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "valTiempRepo", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
		asignarAtributo("TEXT", "valFactLoca", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valFactLoca', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numMaxiProd", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "valAlerStoc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 10, 0, 9999999999);");
		asignarAtributo("TEXT", "valUsua", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
		
		asignarAtributo("TEXT", "valDire", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 50);");
		asignarAtributo("TEXT", "valTfno", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 30);");
		asignarAtributo("TEXT", "valMontMaxiDife", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valMontMaxiDife', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valLimiEfecCaja", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valLimiEfecCaja', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numCaja", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "valNombLoca", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "valTiempRepo", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
		asignarAtributo("TEXT", "valFactLoca", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valFactLoca', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numMaxiProd", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "valAlerStoc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 10, 0, 9999999999);");
		asignarAtributo("TEXT", "valUsua", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
		
		asignarAtributo("TEXT", "valDire", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 50);");
		asignarAtributo("TEXT", "valTfno", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 30);");
		asignarAtributo("TEXT", "valMontMaxiDife", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valMontMaxiDife', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valLimiEfecCaja", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valLimiEfecCaja', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numCaja", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "valNombLoca", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "valTiempRepo", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
		asignarAtributo("TEXT", "valFactLoca", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valFactLoca', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numMaxiProd", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "valAlerStoc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 10, 0, 9999999999);");
		asignarAtributo("TEXT", "valUsua", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
		
		asignarAtributo("TEXT", "valDire", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 50);");
		asignarAtributo("TEXT", "valTfno", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 30);");
		asignarAtributo("TEXT", "valMontMaxiDife", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valMontMaxiDife', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valLimiEfecCaja", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valLimiEfecCaja', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numCaja", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "valNombLoca", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "valTiempRepo", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
		asignarAtributo("TEXT", "valFactLoca", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valFactLoca', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numMaxiProd", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "valAlerStoc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 10, 0, 9999999999);");
		asignarAtributo("TEXT", "valUsua", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
		conectorAction("BelParamBelceLPStartUp");
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
		//asignarAtributo("FORMULARIO", "belParamBelceFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("COMBO", "sbacOidSbac", "req", "S");
				asignarAtributo("TEXT", "valDire", "req", "S");
				asignarAtributo("TEXT", "valMontMaxiDife", "req", "S");
				asignarAtributo("TEXT", "valLimiEfecCaja", "req", "S");
				asignarAtributo("TEXT", "numCaja", "req", "S");
				asignarAtributo("TEXT", "valNombLoca", "req", "S");
				asignarAtributo("TEXT", "valTiempRepo", "req", "S");
				asignarAtributo("TEXT", "valFactLoca", "req", "S");
				asignarAtributo("TEXT", "numMaxiProd", "req", "S");
				asignarAtributo("TEXT", "valAlerStoc", "req", "S");
				asignarAtributo("TEXT", "valUsua", "req", "S");
				asignarAtributo("COMBO", "clieOidClie", "req", "S");
				asignarAtributo("COMBO", "sociOidSoci", "req", "S");
				asignarAtributo("COMBO", "ttraOidTipoTran", "req", "S");
				asignarAtributo("COMBO", "ccbaOidCuenCorrBanc", "req", "S");
				asignarAtributo("COMBO", "tmvcOidCobr", "req", "S");
				asignarAtributo("COMBO", "tmvcOidCier", "req", "S");
				asignarAtributo("COMBO", "tmalOidConfStoc", "req", "S");
				asignarAtributo("COMBO", "tmalOidConfStocTran", "req", "S");
				asignarAtributo("COMBO", "tmalOidStocTran", "req", "S");
				asignarAtributo("COMBO", "tmalOidStocDevo", "req", "S");
				asignarAtributo("COMBO", "tmalOidRegu", "req", "S");
				asignarAtributo("COMBO", "tmalOidReguSap", "req", "S");
				asignarAtributo("COMBO", "tmalOidDevoStoc", "req", "S");
				asignarAtributo("COMBO", "tmalOidPetiExis", "req", "S");
		
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
		
			
			asignarAtributo("TEXT", "valDire", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 50);");
			asignarAtributo("TEXT", "valTfno", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 30);");
			asignarAtributo("TEXT", "valMontMaxiDife", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valMontMaxiDife', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
			asignarAtributo("TEXT", "valLimiEfecCaja", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valLimiEfecCaja', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
			asignarAtributo("TEXT", "numCaja", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
			asignarAtributo("TEXT", "valNombLoca", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
			asignarAtributo("TEXT", "valTiempRepo", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
			asignarAtributo("TEXT", "valFactLoca", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'BelParamBelce.valFactLoca', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
			asignarAtributo("TEXT", "numMaxiProd", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
			asignarAtributo("TEXT", "valAlerStoc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 10, 0, 9999999999);");
			asignarAtributo("TEXT", "valUsua", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
			
			
			
			
			
			
			
			
			
			
			
			
			
			

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando BelParamBelce");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		BelParamBelceData belParamBelceQuery= new BelParamBelceData();
		belParamBelceQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		BelParamBelceData  datosResult = (BelParamBelceData)getSingleObject(BUSINESSID_QUERY, belParamBelceQuery, 
			belParamBelceQuery.clone(), "belParamBelce");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		BelParamBelceData belParamBelce = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		es.indra.belcorp.mso.SegSubacData sbacOidSbac = belParamBelce.getSbacOidSbac();
		if(sbacOidSbac != null && sbacOidSbac.getId() != null) checkCombo("sbacOidSbac" , sbacOidSbac.getId().toString());
		asignar("TEXT", "valDire", FormatUtils.formatObject(belParamBelce.getValDire(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valTfno", FormatUtils.formatObject(belParamBelce.getValTfno(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valMontMaxiDife", FormatUtils.formatObject(belParamBelce.getValMontMaxiDife(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valLimiEfecCaja", FormatUtils.formatObject(belParamBelce.getValLimiEfecCaja(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numCaja", FormatUtils.formatObject(belParamBelce.getNumCaja(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valNombLoca", FormatUtils.formatObject(belParamBelce.getValNombLoca(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valTiempRepo", FormatUtils.formatObject(belParamBelce.getValTiempRepo(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valFactLoca", FormatUtils.formatObject(belParamBelce.getValFactLoca(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numMaxiProd", FormatUtils.formatObject(belParamBelce.getNumMaxiProd(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valAlerStoc", FormatUtils.formatObject(belParamBelce.getValAlerStoc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valUsua", FormatUtils.formatObject(belParamBelce.getValUsua(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.MaeClienViewData clieOidClie = belParamBelce.getClieOidClie();
		if(clieOidClie != null && clieOidClie.getId() != null) checkCombo("clieOidClie" , clieOidClie.getId().toString());
		es.indra.belcorp.mso.SegSocieViewData sociOidSoci = belParamBelce.getSociOidSoci();
		if(sociOidSoci != null && sociOidSoci.getId() != null) checkCombo("sociOidSoci" , sociOidSoci.getId().toString());
		es.indra.belcorp.mso.CccTipoTransViewData ttraOidTipoTran = belParamBelce.getTtraOidTipoTran();
		if(ttraOidTipoTran != null && ttraOidTipoTran.getId() != null) checkCombo("ttraOidTipoTran" , ttraOidTipoTran.getId().toString());
		es.indra.belcorp.mso.CccCuentCorriBancaData ccbaOidCuenCorrBanc = belParamBelce.getCcbaOidCuenCorrBanc();
		if(ccbaOidCuenCorrBanc != null && ccbaOidCuenCorrBanc.getId() != null) checkCombo("ccbaOidCuenCorrBanc" , ccbaOidCuenCorrBanc.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimCajaData tmvcOidCobr = belParamBelce.getTmvcOidCobr();
		if(tmvcOidCobr != null && tmvcOidCobr.getId() != null) checkCombo("tmvcOidCobr" , tmvcOidCobr.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimCajaData tmvcOidCier = belParamBelce.getTmvcOidCier();
		if(tmvcOidCier != null && tmvcOidCier.getId() != null) checkCombo("tmvcOidCier" , tmvcOidCier.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidConfStoc = belParamBelce.getTmalOidConfStoc();
		if(tmalOidConfStoc != null && tmalOidConfStoc.getId() != null) checkCombo("tmalOidConfStoc" , tmalOidConfStoc.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidConfStocTran = belParamBelce.getTmalOidConfStocTran();
		if(tmalOidConfStocTran != null && tmalOidConfStocTran.getId() != null) checkCombo("tmalOidConfStocTran" , tmalOidConfStocTran.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidStocTran = belParamBelce.getTmalOidStocTran();
		if(tmalOidStocTran != null && tmalOidStocTran.getId() != null) checkCombo("tmalOidStocTran" , tmalOidStocTran.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidStocDevo = belParamBelce.getTmalOidStocDevo();
		if(tmalOidStocDevo != null && tmalOidStocDevo.getId() != null) checkCombo("tmalOidStocDevo" , tmalOidStocDevo.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidRegu = belParamBelce.getTmalOidRegu();
		if(tmalOidRegu != null && tmalOidRegu.getId() != null) checkCombo("tmalOidRegu" , tmalOidRegu.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidReguSap = belParamBelce.getTmalOidReguSap();
		if(tmalOidReguSap != null && tmalOidReguSap.getId() != null) checkCombo("tmalOidReguSap" , tmalOidReguSap.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidDevoStoc = belParamBelce.getTmalOidDevoStoc();
		if(tmalOidDevoStoc != null && tmalOidDevoStoc.getId() != null) checkCombo("tmalOidDevoStoc" , tmalOidDevoStoc.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidPetiExis = belParamBelce.getTmalOidPetiExis();
		if(tmalOidPetiExis != null && tmalOidPetiExis.getId() != null) checkCombo("tmalOidPetiExis" , tmalOidPetiExis.getId().toString());
		

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(belParamBelce.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",1, false)");
					asignarAtributo("COMBO","sbacOidSbac_acceOidAcce_canaOidCana", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",2, true)");
					asignarAtributo("COMBO","sbacOidSbac_acceOidAcce_canaOidCana", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",2, false)");
					asignarAtributo("COMBO","sbacOidSbac_acceOidAcce", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",2, true)");
					asignarAtributo("COMBO","sbacOidSbac_acceOidAcce", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",2, false)");
					asignarAtributo("COMBO","sbacOidSbac", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",2, true)");
					asignarAtributo("COMBO","sbacOidSbac", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",2, false)");
				asignarAtributo("AREATEXTO", "valDire", "ontab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",3, true)");
				asignarAtributo("AREATEXTO", "valDire", "onshtab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",3, false)");
				asignarAtributo("AREATEXTO", "valTfno", "ontab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",4, true)");
				asignarAtributo("AREATEXTO", "valTfno", "onshtab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",4, false)");
				asignarAtributo("AREATEXTO", "valMontMaxiDife", "ontab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",5, true)");
				asignarAtributo("AREATEXTO", "valMontMaxiDife", "onshtab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",5, false)");
				asignarAtributo("AREATEXTO", "valLimiEfecCaja", "ontab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",6, true)");
				asignarAtributo("AREATEXTO", "valLimiEfecCaja", "onshtab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",6, false)");
				asignarAtributo("AREATEXTO", "numCaja", "ontab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",7, true)");
				asignarAtributo("AREATEXTO", "numCaja", "onshtab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",7, false)");
				asignarAtributo("AREATEXTO", "valNombLoca", "ontab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",8, true)");
				asignarAtributo("AREATEXTO", "valNombLoca", "onshtab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",8, false)");
				asignarAtributo("AREATEXTO", "valTiempRepo", "ontab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",9, true)");
				asignarAtributo("AREATEXTO", "valTiempRepo", "onshtab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",9, false)");
				asignarAtributo("AREATEXTO", "valFactLoca", "ontab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",10, true)");
				asignarAtributo("AREATEXTO", "valFactLoca", "onshtab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",10, false)");
				asignarAtributo("AREATEXTO", "numMaxiProd", "ontab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",11, true)");
				asignarAtributo("AREATEXTO", "numMaxiProd", "onshtab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",11, false)");
				asignarAtributo("AREATEXTO", "valAlerStoc", "ontab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",12, true)");
				asignarAtributo("AREATEXTO", "valAlerStoc", "onshtab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",12, false)");
				asignarAtributo("AREATEXTO", "valUsua", "ontab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",13, true)");
				asignarAtributo("AREATEXTO", "valUsua", "onshtab","ejecutarAccionFocoModificacion(\"belParamBelceFrm\",13, false)");
					asignarAtributo("COMBO","clieOidClie", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",14, true)");
					asignarAtributo("COMBO","clieOidClie", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",14, false)");
					asignarAtributo("COMBO","sociOidSoci", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",15, true)");
					asignarAtributo("COMBO","sociOidSoci", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",15, false)");
					asignarAtributo("COMBO","ttraOidTipoTran", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",16, true)");
					asignarAtributo("COMBO","ttraOidTipoTran", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",16, false)");
					asignarAtributo("COMBO","ccbaOidCuenCorrBanc_sociOidSoci", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",17, true)");
					asignarAtributo("COMBO","ccbaOidCuenCorrBanc_sociOidSoci", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",17, false)");
					asignarAtributo("COMBO","ccbaOidCuenCorrBanc_cucoOidCcTeso", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",17, true)");
					asignarAtributo("COMBO","ccbaOidCuenCorrBanc_cucoOidCcTeso", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",17, false)");
					asignarAtributo("COMBO","ccbaOidCuenCorrBanc_cucoOidCcPnte", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",17, true)");
					asignarAtributo("COMBO","ccbaOidCuenCorrBanc_cucoOidCcPnte", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",17, false)");
					asignarAtributo("COMBO","ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",17, true)");
					asignarAtributo("COMBO","ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",17, false)");
					asignarAtributo("COMBO","ccbaOidCuenCorrBanc_sucuOidSucu", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",17, true)");
					asignarAtributo("COMBO","ccbaOidCuenCorrBanc_sucuOidSucu", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",17, false)");
					asignarAtributo("COMBO","ccbaOidCuenCorrBanc", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",17, true)");
					asignarAtributo("COMBO","ccbaOidCuenCorrBanc", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",17, false)");
					asignarAtributo("COMBO","tmvcOidCobr", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",18, true)");
					asignarAtributo("COMBO","tmvcOidCobr", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",18, false)");
					asignarAtributo("COMBO","tmvcOidCier", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",19, true)");
					asignarAtributo("COMBO","tmvcOidCier", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",19, false)");
					asignarAtributo("COMBO","tmalOidConfStoc", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",20, true)");
					asignarAtributo("COMBO","tmalOidConfStoc", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",20, false)");
					asignarAtributo("COMBO","tmalOidConfStocTran", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",21, true)");
					asignarAtributo("COMBO","tmalOidConfStocTran", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",21, false)");
					asignarAtributo("COMBO","tmalOidStocTran", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",22, true)");
					asignarAtributo("COMBO","tmalOidStocTran", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",22, false)");
					asignarAtributo("COMBO","tmalOidStocDevo", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",23, true)");
					asignarAtributo("COMBO","tmalOidStocDevo", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",23, false)");
					asignarAtributo("COMBO","tmalOidRegu", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",24, true)");
					asignarAtributo("COMBO","tmalOidRegu", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",24, false)");
					asignarAtributo("COMBO","tmalOidReguSap", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",25, true)");
					asignarAtributo("COMBO","tmalOidReguSap", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",25, false)");
					asignarAtributo("COMBO","tmalOidDevoStoc", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",26, true)");
					asignarAtributo("COMBO","tmalOidDevoStoc", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",26, false)");
					asignarAtributo("COMBO","tmalOidPetiExis", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",27, true)");
					asignarAtributo("COMBO","tmalOidPetiExis", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",27, false)");
					asignarAtributo("COMBO","paisOidPais", "ontab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",28, true)");
					asignarAtributo("COMBO","paisOidPais", "onshtab", "ejecutarAccionFocoModificacion(\"belParamBelceFrm\",28, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","belParamBelceTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","belParamBelceTrButtons");

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
				
				traza("MMG: el atributo es sbacOidSbac...");		
				
				traza("MMG: el atributo es valDire...");		
				
				traza("MMG: el atributo es valTfno...");		
				
				traza("MMG: el atributo es valMontMaxiDife...");		
				
				traza("MMG: el atributo es valLimiEfecCaja...");		
				
				traza("MMG: el atributo es numCaja...");		
				
				traza("MMG: el atributo es valNombLoca...");		
				
				traza("MMG: el atributo es valTiempRepo...");		
				
				traza("MMG: el atributo es valFactLoca...");		
				
				traza("MMG: el atributo es numMaxiProd...");		
				
				traza("MMG: el atributo es valAlerStoc...");		
				
				traza("MMG: el atributo es valUsua...");		
				
				traza("MMG: el atributo es clieOidClie...");		
				
				traza("MMG: el atributo es sociOidSoci...");		
				
				traza("MMG: el atributo es ttraOidTipoTran...");		
				
				traza("MMG: el atributo es ccbaOidCuenCorrBanc...");		
				
				traza("MMG: el atributo es tmvcOidCobr...");		
				
				traza("MMG: el atributo es tmvcOidCier...");		
				
				traza("MMG: el atributo es tmalOidConfStoc...");		
				
				traza("MMG: el atributo es tmalOidConfStocTran...");		
				
				traza("MMG: el atributo es tmalOidStocTran...");		
				
				traza("MMG: el atributo es tmalOidStocDevo...");		
				
				traza("MMG: el atributo es tmalOidRegu...");		
				
				traza("MMG: el atributo es tmalOidReguSap...");		
				
				traza("MMG: el atributo es tmalOidDevoStoc...");		
				
				traza("MMG: el atributo es tmalOidPetiExis...");		
				
				traza("MMG: el atributo es paisOidPais...");		
				
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
		asignarAtributo("CAPA","belParamBelceFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","belParamBelceListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","belParamBelceListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(BelParamBelceData belParamBelce) throws Exception{
		HashMap checkedCombos = new HashMap();
		SegCanalViewData sbacOidSbac_acceOidAcce_canaOidCana = new SegCanalViewData();
		
						asignarComboResultados(BUSINESSID_SBACOIDSBAC_ACCEOIDACCE_CANAOIDCANA_QUERY,SBACOIDSBAC_ACCEOIDACCE_CANAOIDCANA_COMBO_CONNECTOR, 
			sbacOidSbac_acceOidAcce_canaOidCana, sbacOidSbac_acceOidAcce_canaOidCana.clone(), "segCanalView", "sbacOidSbac_acceOidAcce_canaOidCana", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getSbacOidSbac().getAcceOidAcce().getCanaOidCana() != null){
				checkCombo("sbacOidSbac_acceOidAcce_canaOidCana" , belParamBelce.getSbacOidSbac().getAcceOidAcce().getCanaOidCana().getId().toString());
			}
		String sbacOidSbac_acceOidAcce_canaOidCanaDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegCanalView");
		if(sbacOidSbac_acceOidAcce_canaOidCanaDefaultValue != null && !sbacOidSbac_acceOidAcce_canaOidCanaDefaultValue.trim().equals("")){
			checkCombo("sbacOidSbac_acceOidAcce_canaOidCana", sbacOidSbac_acceOidAcce_canaOidCanaDefaultValue);
			checkedCombos.put("sbacOidSbac_acceOidAcce_canaOidCana",sbacOidSbac_acceOidAcce_canaOidCanaDefaultValue);
			cascadeComboLoad(checkedCombos, "sbacOidSbac_acceOidAcce_canaOidCana");
		}						 
		MaeClienViewData clieOidClie = new MaeClienViewData();
		
						asignarComboResultados(BUSINESSID_CLIEOIDCLIE_QUERY,CLIEOIDCLIE_COMBO_CONNECTOR, 
			clieOidClie, clieOidClie.clone(), "maeClienView", "clieOidClie", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getClieOidClie() != null){
				checkCombo("clieOidClie" , belParamBelce.getClieOidClie().getId().toString());
			}
		SegSocieViewData sociOidSoci = new SegSocieViewData();
		
						asignarComboResultados(BUSINESSID_SOCIOIDSOCI_QUERY,SOCIOIDSOCI_COMBO_CONNECTOR, 
			sociOidSoci, sociOidSoci.clone(), "segSocieView", "sociOidSoci", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getSociOidSoci() != null){
				checkCombo("sociOidSoci" , belParamBelce.getSociOidSoci().getId().toString());
			}
		CccTipoTransViewData ttraOidTipoTran = new CccTipoTransViewData();
		
						asignarComboResultados(BUSINESSID_TTRAOIDTIPOTRAN_QUERY,TTRAOIDTIPOTRAN_COMBO_CONNECTOR, 
			ttraOidTipoTran, ttraOidTipoTran.clone(), "cccTipoTransView", "ttraOidTipoTran", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getTtraOidTipoTran() != null){
				checkCombo("ttraOidTipoTran" , belParamBelce.getTtraOidTipoTran().getId().toString());
			}
		SegSocieData ccbaOidCuenCorrBanc_sociOidSoci = new SegSocieData();
		CccCuentContaData ccbaOidCuenCorrBanc_cucoOidCcTeso = new CccCuentContaData();
		CccCuentContaData ccbaOidCuenCorrBanc_cucoOidCcPnte = new CccCuentContaData();
		CccBancoData ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc = new CccBancoData();
		
						asignarComboResultados(BUSINESSID_CCBAOIDCUENCORRBANC_SOCIOIDSOCI_QUERY,CCBAOIDCUENCORRBANC_SOCIOIDSOCI_COMBO_CONNECTOR, 
			ccbaOidCuenCorrBanc_sociOidSoci, ccbaOidCuenCorrBanc_sociOidSoci.clone(), "segSocie", "ccbaOidCuenCorrBanc_sociOidSoci", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getCcbaOidCuenCorrBanc().getSociOidSoci() != null){
				checkCombo("ccbaOidCuenCorrBanc_sociOidSoci" , belParamBelce.getCcbaOidCuenCorrBanc().getSociOidSoci().getId().toString());
			}
		
						asignarComboResultados(BUSINESSID_CCBAOIDCUENCORRBANC_CUCOOIDCCTESO_QUERY,CCBAOIDCUENCORRBANC_CUCOOIDCCTESO_COMBO_CONNECTOR, 
			ccbaOidCuenCorrBanc_cucoOidCcTeso, ccbaOidCuenCorrBanc_cucoOidCcTeso.clone(), "cccCuentConta", "ccbaOidCuenCorrBanc_cucoOidCcTeso", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getCcbaOidCuenCorrBanc().getCucoOidCcTeso() != null){
				checkCombo("ccbaOidCuenCorrBanc_cucoOidCcTeso" , belParamBelce.getCcbaOidCuenCorrBanc().getCucoOidCcTeso().getId().toString());
			}
		
						asignarComboResultados(BUSINESSID_CCBAOIDCUENCORRBANC_CUCOOIDCCPNTE_QUERY,CCBAOIDCUENCORRBANC_CUCOOIDCCPNTE_COMBO_CONNECTOR, 
			ccbaOidCuenCorrBanc_cucoOidCcPnte, ccbaOidCuenCorrBanc_cucoOidCcPnte.clone(), "cccCuentConta", "ccbaOidCuenCorrBanc_cucoOidCcPnte", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getCcbaOidCuenCorrBanc().getCucoOidCcPnte() != null){
				checkCombo("ccbaOidCuenCorrBanc_cucoOidCcPnte" , belParamBelce.getCcbaOidCuenCorrBanc().getCucoOidCcPnte().getId().toString());
			}
		
						asignarComboResultados(BUSINESSID_CCBAOIDCUENCORRBANC_SUCUOIDSUCU_CBANOIDBANC_QUERY,CCBAOIDCUENCORRBANC_SUCUOIDSUCU_CBANOIDBANC_COMBO_CONNECTOR, 
			ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc, ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc.clone(), "cccBanco", "ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getCcbaOidCuenCorrBanc().getSucuOidSucu().getCbanOidBanc() != null){
				checkCombo("ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc" , belParamBelce.getCcbaOidCuenCorrBanc().getSucuOidSucu().getCbanOidBanc().getId().toString());
			}
		String ccbaOidCuenCorrBanc_sociOidSociDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegSocie");
		if(ccbaOidCuenCorrBanc_sociOidSociDefaultValue != null && !ccbaOidCuenCorrBanc_sociOidSociDefaultValue.trim().equals("")){
			checkCombo("ccbaOidCuenCorrBanc_sociOidSoci", ccbaOidCuenCorrBanc_sociOidSociDefaultValue);
			checkedCombos.put("ccbaOidCuenCorrBanc_sociOidSoci",ccbaOidCuenCorrBanc_sociOidSociDefaultValue);
			cascadeComboLoad(checkedCombos, "ccbaOidCuenCorrBanc_sociOidSoci");
		}						 
		BelTipoMovimCajaData tmvcOidCobr = new BelTipoMovimCajaData();
		
						asignarComboResultados(BUSINESSID_TMVCOIDCOBR_QUERY,TMVCOIDCOBR_COMBO_CONNECTOR, 
			tmvcOidCobr, tmvcOidCobr.clone(), "belTipoMovimCaja", "tmvcOidCobr", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getTmvcOidCobr() != null){
				checkCombo("tmvcOidCobr" , belParamBelce.getTmvcOidCobr().getId().toString());
			}
		BelTipoMovimCajaData tmvcOidCier = new BelTipoMovimCajaData();
		
						asignarComboResultados(BUSINESSID_TMVCOIDCIER_QUERY,TMVCOIDCIER_COMBO_CONNECTOR, 
			tmvcOidCier, tmvcOidCier.clone(), "belTipoMovimCaja", "tmvcOidCier", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getTmvcOidCier() != null){
				checkCombo("tmvcOidCier" , belParamBelce.getTmvcOidCier().getId().toString());
			}
		BelTipoMovimAlmacViewData tmalOidConfStoc = new BelTipoMovimAlmacViewData();
		
						asignarComboResultados(BUSINESSID_TMALOIDCONFSTOC_QUERY,TMALOIDCONFSTOC_COMBO_CONNECTOR, 
			tmalOidConfStoc, tmalOidConfStoc.clone(), "belTipoMovimAlmacView", "tmalOidConfStoc", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getTmalOidConfStoc() != null){
				checkCombo("tmalOidConfStoc" , belParamBelce.getTmalOidConfStoc().getId().toString());
			}
		BelTipoMovimAlmacViewData tmalOidConfStocTran = new BelTipoMovimAlmacViewData();
		
						asignarComboResultados(BUSINESSID_TMALOIDCONFSTOCTRAN_QUERY,TMALOIDCONFSTOCTRAN_COMBO_CONNECTOR, 
			tmalOidConfStocTran, tmalOidConfStocTran.clone(), "belTipoMovimAlmacView", "tmalOidConfStocTran", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getTmalOidConfStocTran() != null){
				checkCombo("tmalOidConfStocTran" , belParamBelce.getTmalOidConfStocTran().getId().toString());
			}
		BelTipoMovimAlmacViewData tmalOidStocTran = new BelTipoMovimAlmacViewData();
		
						asignarComboResultados(BUSINESSID_TMALOIDSTOCTRAN_QUERY,TMALOIDSTOCTRAN_COMBO_CONNECTOR, 
			tmalOidStocTran, tmalOidStocTran.clone(), "belTipoMovimAlmacView", "tmalOidStocTran", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getTmalOidStocTran() != null){
				checkCombo("tmalOidStocTran" , belParamBelce.getTmalOidStocTran().getId().toString());
			}
		BelTipoMovimAlmacViewData tmalOidStocDevo = new BelTipoMovimAlmacViewData();
		
						asignarComboResultados(BUSINESSID_TMALOIDSTOCDEVO_QUERY,TMALOIDSTOCDEVO_COMBO_CONNECTOR, 
			tmalOidStocDevo, tmalOidStocDevo.clone(), "belTipoMovimAlmacView", "tmalOidStocDevo", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getTmalOidStocDevo() != null){
				checkCombo("tmalOidStocDevo" , belParamBelce.getTmalOidStocDevo().getId().toString());
			}
		BelTipoMovimAlmacViewData tmalOidRegu = new BelTipoMovimAlmacViewData();
		
						asignarComboResultados(BUSINESSID_TMALOIDREGU_QUERY,TMALOIDREGU_COMBO_CONNECTOR, 
			tmalOidRegu, tmalOidRegu.clone(), "belTipoMovimAlmacView", "tmalOidRegu", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getTmalOidRegu() != null){
				checkCombo("tmalOidRegu" , belParamBelce.getTmalOidRegu().getId().toString());
			}
		BelTipoMovimAlmacViewData tmalOidReguSap = new BelTipoMovimAlmacViewData();
		
						asignarComboResultados(BUSINESSID_TMALOIDREGUSAP_QUERY,TMALOIDREGUSAP_COMBO_CONNECTOR, 
			tmalOidReguSap, tmalOidReguSap.clone(), "belTipoMovimAlmacView", "tmalOidReguSap", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getTmalOidReguSap() != null){
				checkCombo("tmalOidReguSap" , belParamBelce.getTmalOidReguSap().getId().toString());
			}
		BelTipoMovimAlmacViewData tmalOidDevoStoc = new BelTipoMovimAlmacViewData();
		
						asignarComboResultados(BUSINESSID_TMALOIDDEVOSTOC_QUERY,TMALOIDDEVOSTOC_COMBO_CONNECTOR, 
			tmalOidDevoStoc, tmalOidDevoStoc.clone(), "belTipoMovimAlmacView", "tmalOidDevoStoc", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getTmalOidDevoStoc() != null){
				checkCombo("tmalOidDevoStoc" , belParamBelce.getTmalOidDevoStoc().getId().toString());
			}
		BelTipoMovimAlmacViewData tmalOidPetiExis = new BelTipoMovimAlmacViewData();
		
						asignarComboResultados(BUSINESSID_TMALOIDPETIEXIS_QUERY,TMALOIDPETIEXIS_COMBO_CONNECTOR, 
			tmalOidPetiExis, tmalOidPetiExis.clone(), "belTipoMovimAlmacView", "tmalOidPetiExis", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getTmalOidPetiExis() != null){
				checkCombo("tmalOidPetiExis" , belParamBelce.getTmalOidPetiExis().getId().toString());
			}
		SegPaisViewData paisOidPais = new SegPaisViewData();
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, 
			paisOidPais, paisOidPais.clone(), "segPaisView", "paisOidPais", "result_ROWSET" );
		if(belParamBelce != null && belParamBelce.getPaisOidPais() != null){
				checkCombo("paisOidPais" , belParamBelce.getPaisOidPais().getId().toString());
			}
		String paisOidPaisDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPaisView");
		if(paisOidPaisDefaultValue != null && !paisOidPaisDefaultValue.trim().equals("")){
			checkCombo("paisOidPais", paisOidPaisDefaultValue);
			checkedCombos.put("paisOidPais",paisOidPaisDefaultValue);
			cascadeComboLoad(checkedCombos, "paisOidPais");
		}						 
		
	}
	
	/**
	* Nos permite cargar en cascada jerarquía de combos dependientes por la selección de valor en uno de sus elementos
	*/
	public void cascadeComboLoad(HashMap checkedCombos, String comboName) throws Exception{
		
						if(comboName.trim().equals("sbacOidSbac_acceOidAcce_canaOidCana") ){
			String sbacOidSbac_acceOidAcce_canaOidCanaDefaultValue = (String)checkedCombos.get("sbacOidSbac_acceOidAcce_canaOidCana");
			if(sbacOidSbac_acceOidAcce_canaOidCanaDefaultValue != null){
				SegAccesData sbacOidSbac_acceOidAcce= new SegAccesData();
				es.indra.belcorp.mso.SegCanalViewData sbacOidSbac_acceOidAcceCanaOidCana = new es.indra.belcorp.mso.SegCanalViewData();
				sbacOidSbac_acceOidAcceCanaOidCana.setId(new Long(sbacOidSbac_acceOidAcce_canaOidCanaDefaultValue ));
				sbacOidSbac_acceOidAcce.setCanaOidCana(sbacOidSbac_acceOidAcceCanaOidCana);
				asignarComboResultados(BUSINESSID_SBACOIDSBAC_ACCEOIDACCE_QUERY,SBACOIDSBAC_ACCEOIDACCE_COMBO_CONNECTOR, 
					sbacOidSbac_acceOidAcce, sbacOidSbac_acceOidAcce.clone(), "segAcces", "sbacOidSbac_acceOidAcce", "result_ROWSET",true );
				String sbacOidSbac_acceOidAcceDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegAcces");
				if(sbacOidSbac_acceOidAcceDefaultValue != null && !sbacOidSbac_acceOidAcceDefaultValue.trim().equals("")){
					checkCombo("sbacOidSbac_acceOidAcce",sbacOidSbac_acceOidAcceDefaultValue);
					checkedCombos.put("sbacOidSbac_acceOidAcce",sbacOidSbac_acceOidAcceDefaultValue);
					cascadeComboLoad(checkedCombos, "sbacOidSbac_acceOidAcce");
				}
			}
		}

						if(comboName.trim().equals("sbacOidSbac_acceOidAcce") ){
			String sbacOidSbac_acceOidAcceDefaultValue = (String)checkedCombos.get("sbacOidSbac_acceOidAcce");
			if(sbacOidSbac_acceOidAcceDefaultValue != null){
				SegSubacData sbacOidSbac= new SegSubacData();
				es.indra.belcorp.mso.SegAccesData sbacOidSbacAcceOidAcce = new es.indra.belcorp.mso.SegAccesData();
				sbacOidSbacAcceOidAcce.setId(new Long(sbacOidSbac_acceOidAcceDefaultValue ));
				sbacOidSbac.setAcceOidAcce(sbacOidSbacAcceOidAcce);
				asignarComboResultados(BUSINESSID_SBACOIDSBAC_QUERY,SBACOIDSBAC_COMBO_CONNECTOR, 
					sbacOidSbac, sbacOidSbac.clone(), "segSubac", "sbacOidSbac", "result_ROWSET",true );
				String sbacOidSbacDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegSubac");
				if(sbacOidSbacDefaultValue != null && !sbacOidSbacDefaultValue.trim().equals("")){
					checkCombo("sbacOidSbac",sbacOidSbacDefaultValue);
					checkedCombos.put("sbacOidSbac",sbacOidSbacDefaultValue);
					cascadeComboLoad(checkedCombos, "sbacOidSbac");
				}
			}
		}

						if(comboName.trim().equals("ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc") ){
			String ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBancDefaultValue = (String)checkedCombos.get("ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc");
			if(ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBancDefaultValue != null){
				CccSucurData ccbaOidCuenCorrBanc_sucuOidSucu= new CccSucurData();
				es.indra.belcorp.mso.CccBancoData ccbaOidCuenCorrBanc_sucuOidSucuCbanOidBanc = new es.indra.belcorp.mso.CccBancoData();
				ccbaOidCuenCorrBanc_sucuOidSucuCbanOidBanc.setId(new Long(ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBancDefaultValue ));
				ccbaOidCuenCorrBanc_sucuOidSucu.setCbanOidBanc(ccbaOidCuenCorrBanc_sucuOidSucuCbanOidBanc);
				asignarComboResultados(BUSINESSID_CCBAOIDCUENCORRBANC_SUCUOIDSUCU_QUERY,CCBAOIDCUENCORRBANC_SUCUOIDSUCU_COMBO_CONNECTOR, 
					ccbaOidCuenCorrBanc_sucuOidSucu, ccbaOidCuenCorrBanc_sucuOidSucu.clone(), "cccSucur", "ccbaOidCuenCorrBanc_sucuOidSucu", "result_ROWSET",false );
			}
		}

						if(comboName.trim().equals("ccbaOidCuenCorrBanc_sociOidSoci")  || comboName.trim().equals("ccbaOidCuenCorrBanc_cucoOidCcTeso")  || comboName.trim().equals("ccbaOidCuenCorrBanc_cucoOidCcPnte")  || comboName.trim().equals("ccbaOidCuenCorrBanc_sucuOidSucu") ){
			String ccbaOidCuenCorrBanc_sociOidSociDefaultValue = (String)checkedCombos.get("ccbaOidCuenCorrBanc_sociOidSoci");
			String ccbaOidCuenCorrBanc_cucoOidCcTesoDefaultValue = (String)checkedCombos.get("ccbaOidCuenCorrBanc_cucoOidCcTeso");
			String ccbaOidCuenCorrBanc_cucoOidCcPnteDefaultValue = (String)checkedCombos.get("ccbaOidCuenCorrBanc_cucoOidCcPnte");
			String ccbaOidCuenCorrBanc_sucuOidSucuDefaultValue = (String)checkedCombos.get("ccbaOidCuenCorrBanc_sucuOidSucu");
			if(ccbaOidCuenCorrBanc_sociOidSociDefaultValue != null &&ccbaOidCuenCorrBanc_cucoOidCcTesoDefaultValue != null &&ccbaOidCuenCorrBanc_cucoOidCcPnteDefaultValue != null &&ccbaOidCuenCorrBanc_sucuOidSucuDefaultValue != null){
				CccCuentCorriBancaData ccbaOidCuenCorrBanc= new CccCuentCorriBancaData();
				es.indra.belcorp.mso.SegSocieData ccbaOidCuenCorrBancSociOidSoci = new es.indra.belcorp.mso.SegSocieData();
				ccbaOidCuenCorrBancSociOidSoci.setId(new Long(ccbaOidCuenCorrBanc_sociOidSociDefaultValue ));
				ccbaOidCuenCorrBanc.setSociOidSoci(ccbaOidCuenCorrBancSociOidSoci);
				es.indra.belcorp.mso.CccCuentContaData ccbaOidCuenCorrBancCucoOidCcTeso = new es.indra.belcorp.mso.CccCuentContaData();
				ccbaOidCuenCorrBancCucoOidCcTeso.setId(new Long(ccbaOidCuenCorrBanc_cucoOidCcTesoDefaultValue ));
				ccbaOidCuenCorrBanc.setCucoOidCcTeso(ccbaOidCuenCorrBancCucoOidCcTeso);
				es.indra.belcorp.mso.CccCuentContaData ccbaOidCuenCorrBancCucoOidCcPnte = new es.indra.belcorp.mso.CccCuentContaData();
				ccbaOidCuenCorrBancCucoOidCcPnte.setId(new Long(ccbaOidCuenCorrBanc_cucoOidCcPnteDefaultValue ));
				ccbaOidCuenCorrBanc.setCucoOidCcPnte(ccbaOidCuenCorrBancCucoOidCcPnte);
				es.indra.belcorp.mso.CccSucurData ccbaOidCuenCorrBancSucuOidSucu = new es.indra.belcorp.mso.CccSucurData();
				ccbaOidCuenCorrBancSucuOidSucu.setId(new Long(ccbaOidCuenCorrBanc_sucuOidSucuDefaultValue ));
				ccbaOidCuenCorrBanc.setSucuOidSucu(ccbaOidCuenCorrBancSucuOidSucu);
				asignarComboResultados(BUSINESSID_CCBAOIDCUENCORRBANC_QUERY,CCBAOIDCUENCORRBANC_COMBO_CONNECTOR, 
					ccbaOidCuenCorrBanc, ccbaOidCuenCorrBanc.clone(), "cccCuentCorriBanca", "ccbaOidCuenCorrBanc", "result_ROWSET",false );
			}
		}

	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param belParamBelce La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(BelParamBelceData belParamBelce) 
		throws Exception{
		
						if(belParamBelce.getSbacOidSbac() != null){
			
						SegSubacData sbacOidSbac = new SegSubacData();
			sbacOidSbac.setAcceOidAcce(belParamBelce.getSbacOidSbac().getAcceOidAcce());
			asignarComboResultados(BUSINESSID_SBACOIDSBAC_QUERY,SBACOIDSBAC_COMBO_CONNECTOR, sbacOidSbac, sbacOidSbac.clone(), "segSubac", "sbacOidSbac", "result_ROWSET");
			checkCombo("sbacOidSbac" , belParamBelce.getSbacOidSbac().getId().toString());
			
						SegAccesData sbacOidSbac_acceOidAcce = new SegAccesData();
			sbacOidSbac_acceOidAcce.setCanaOidCana(belParamBelce.getSbacOidSbac().getAcceOidAcce().getCanaOidCana());
			asignarComboResultados(BUSINESSID_SBACOIDSBAC_ACCEOIDACCE_QUERY,SBACOIDSBAC_ACCEOIDACCE_COMBO_CONNECTOR, sbacOidSbac_acceOidAcce, sbacOidSbac_acceOidAcce.clone(), "segAcces", "sbacOidSbac_acceOidAcce", "result_ROWSET");
			checkCombo("sbacOidSbac_acceOidAcce" , belParamBelce.getSbacOidSbac().getAcceOidAcce().getId().toString());
			
						}
		
						if(belParamBelce.getCcbaOidCuenCorrBanc() != null){
			
						CccCuentCorriBancaData ccbaOidCuenCorrBanc = new CccCuentCorriBancaData();
			ccbaOidCuenCorrBanc.setSociOidSoci(belParamBelce.getCcbaOidCuenCorrBanc().getSociOidSoci());
			ccbaOidCuenCorrBanc.setCucoOidCcTeso(belParamBelce.getCcbaOidCuenCorrBanc().getCucoOidCcTeso());
			ccbaOidCuenCorrBanc.setCucoOidCcPnte(belParamBelce.getCcbaOidCuenCorrBanc().getCucoOidCcPnte());
			ccbaOidCuenCorrBanc.setSucuOidSucu(belParamBelce.getCcbaOidCuenCorrBanc().getSucuOidSucu());
			asignarComboResultados(BUSINESSID_CCBAOIDCUENCORRBANC_QUERY,CCBAOIDCUENCORRBANC_COMBO_CONNECTOR, ccbaOidCuenCorrBanc, ccbaOidCuenCorrBanc.clone(), "cccCuentCorriBanca", "ccbaOidCuenCorrBanc", "result_ROWSET");
			checkCombo("ccbaOidCuenCorrBanc" , belParamBelce.getCcbaOidCuenCorrBanc().getId().toString());
			
						CccSucurData ccbaOidCuenCorrBanc_sucuOidSucu = new CccSucurData();
			ccbaOidCuenCorrBanc_sucuOidSucu.setCbanOidBanc(belParamBelce.getCcbaOidCuenCorrBanc().getSucuOidSucu().getCbanOidBanc());
			asignarComboResultados(BUSINESSID_CCBAOIDCUENCORRBANC_SUCUOIDSUCU_QUERY,CCBAOIDCUENCORRBANC_SUCUOIDSUCU_COMBO_CONNECTOR, ccbaOidCuenCorrBanc_sucuOidSucu, ccbaOidCuenCorrBanc_sucuOidSucu.clone(), "cccSucur", "ccbaOidCuenCorrBanc_sucuOidSucu", "result_ROWSET");
			checkCombo("ccbaOidCuenCorrBanc_sucuOidSucu" , belParamBelce.getCcbaOidCuenCorrBanc().getSucuOidSucu().getId().toString());
			
						}
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		BelParamBelceData belParamBelce = 
			(BelParamBelceData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(belParamBelce.getSbacOidSbac() != null){
			belParamBelce.setSbacOidSbac((es.indra.belcorp.mso.SegSubacData)
			getSingleObject(BUSINESSID_SBACOIDSBAC_QUERY, 
			belParamBelce.getSbacOidSbac(),
			belParamBelce.getSbacOidSbac().clone(),
			"segSubac"));
		}
		if(belParamBelce.getClieOidClie() != null){
			belParamBelce.setClieOidClie((es.indra.belcorp.mso.MaeClienViewData)
			getSingleObject(BUSINESSID_CLIEOIDCLIE_QUERY, 
			belParamBelce.getClieOidClie(),
			belParamBelce.getClieOidClie().clone(),
			"maeClienView"));
		}
		if(belParamBelce.getSociOidSoci() != null){
			belParamBelce.setSociOidSoci((es.indra.belcorp.mso.SegSocieViewData)
			getSingleObject(BUSINESSID_SOCIOIDSOCI_QUERY, 
			belParamBelce.getSociOidSoci(),
			belParamBelce.getSociOidSoci().clone(),
			"segSocieView"));
		}
		if(belParamBelce.getTtraOidTipoTran() != null){
			belParamBelce.setTtraOidTipoTran((es.indra.belcorp.mso.CccTipoTransViewData)
			getSingleObject(BUSINESSID_TTRAOIDTIPOTRAN_QUERY, 
			belParamBelce.getTtraOidTipoTran(),
			belParamBelce.getTtraOidTipoTran().clone(),
			"cccTipoTransView"));
		}
		if(belParamBelce.getCcbaOidCuenCorrBanc() != null){
			belParamBelce.setCcbaOidCuenCorrBanc((es.indra.belcorp.mso.CccCuentCorriBancaData)
			getSingleObject(BUSINESSID_CCBAOIDCUENCORRBANC_QUERY, 
			belParamBelce.getCcbaOidCuenCorrBanc(),
			belParamBelce.getCcbaOidCuenCorrBanc().clone(),
			"cccCuentCorriBanca"));
		}
		if(belParamBelce.getTmvcOidCobr() != null){
			belParamBelce.setTmvcOidCobr((es.indra.belcorp.mso.BelTipoMovimCajaData)
			getSingleObject(BUSINESSID_TMVCOIDCOBR_QUERY, 
			belParamBelce.getTmvcOidCobr(),
			belParamBelce.getTmvcOidCobr().clone(),
			"belTipoMovimCaja"));
		}
		if(belParamBelce.getTmvcOidCier() != null){
			belParamBelce.setTmvcOidCier((es.indra.belcorp.mso.BelTipoMovimCajaData)
			getSingleObject(BUSINESSID_TMVCOIDCIER_QUERY, 
			belParamBelce.getTmvcOidCier(),
			belParamBelce.getTmvcOidCier().clone(),
			"belTipoMovimCaja"));
		}
		if(belParamBelce.getTmalOidConfStoc() != null){
			belParamBelce.setTmalOidConfStoc((es.indra.belcorp.mso.BelTipoMovimAlmacViewData)
			getSingleObject(BUSINESSID_TMALOIDCONFSTOC_QUERY, 
			belParamBelce.getTmalOidConfStoc(),
			belParamBelce.getTmalOidConfStoc().clone(),
			"belTipoMovimAlmacView"));
		}
		if(belParamBelce.getTmalOidConfStocTran() != null){
			belParamBelce.setTmalOidConfStocTran((es.indra.belcorp.mso.BelTipoMovimAlmacViewData)
			getSingleObject(BUSINESSID_TMALOIDCONFSTOCTRAN_QUERY, 
			belParamBelce.getTmalOidConfStocTran(),
			belParamBelce.getTmalOidConfStocTran().clone(),
			"belTipoMovimAlmacView"));
		}
		if(belParamBelce.getTmalOidStocTran() != null){
			belParamBelce.setTmalOidStocTran((es.indra.belcorp.mso.BelTipoMovimAlmacViewData)
			getSingleObject(BUSINESSID_TMALOIDSTOCTRAN_QUERY, 
			belParamBelce.getTmalOidStocTran(),
			belParamBelce.getTmalOidStocTran().clone(),
			"belTipoMovimAlmacView"));
		}
		if(belParamBelce.getTmalOidStocDevo() != null){
			belParamBelce.setTmalOidStocDevo((es.indra.belcorp.mso.BelTipoMovimAlmacViewData)
			getSingleObject(BUSINESSID_TMALOIDSTOCDEVO_QUERY, 
			belParamBelce.getTmalOidStocDevo(),
			belParamBelce.getTmalOidStocDevo().clone(),
			"belTipoMovimAlmacView"));
		}
		if(belParamBelce.getTmalOidRegu() != null){
			belParamBelce.setTmalOidRegu((es.indra.belcorp.mso.BelTipoMovimAlmacViewData)
			getSingleObject(BUSINESSID_TMALOIDREGU_QUERY, 
			belParamBelce.getTmalOidRegu(),
			belParamBelce.getTmalOidRegu().clone(),
			"belTipoMovimAlmacView"));
		}
		if(belParamBelce.getTmalOidReguSap() != null){
			belParamBelce.setTmalOidReguSap((es.indra.belcorp.mso.BelTipoMovimAlmacViewData)
			getSingleObject(BUSINESSID_TMALOIDREGUSAP_QUERY, 
			belParamBelce.getTmalOidReguSap(),
			belParamBelce.getTmalOidReguSap().clone(),
			"belTipoMovimAlmacView"));
		}
		if(belParamBelce.getTmalOidDevoStoc() != null){
			belParamBelce.setTmalOidDevoStoc((es.indra.belcorp.mso.BelTipoMovimAlmacViewData)
			getSingleObject(BUSINESSID_TMALOIDDEVOSTOC_QUERY, 
			belParamBelce.getTmalOidDevoStoc(),
			belParamBelce.getTmalOidDevoStoc().clone(),
			"belTipoMovimAlmacView"));
		}
		if(belParamBelce.getTmalOidPetiExis() != null){
			belParamBelce.setTmalOidPetiExis((es.indra.belcorp.mso.BelTipoMovimAlmacViewData)
			getSingleObject(BUSINESSID_TMALOIDPETIEXIS_QUERY, 
			belParamBelce.getTmalOidPetiExis(),
			belParamBelce.getTmalOidPetiExis().clone(),
			"belTipoMovimAlmacView"));
		}
		if(belParamBelce.getPaisOidPais() != null){
			belParamBelce.setPaisOidPais((es.indra.belcorp.mso.SegPaisViewData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			belParamBelce.getPaisOidPais(),
			belParamBelce.getPaisOidPais().clone(),
			"segPaisView"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(belParamBelce);
		loadLeafDependenceCombos(belParamBelce);
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
			borrarNodo("TR","nombre","formTr27");
			borrarNodo("TR","nombre","formGapTr27");
			
		}else if(accion.equals(ACCION_VIEW) && origen.equals("preview")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			borrarNodo("TR","nombre","formTr27");
			borrarNodo("TR","nombre","formGapTr27");
			
		}else if(accion.equals(ACCION_CREATE)){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			borrarNodo("TR","nombre","formTr27");
			borrarNodo("TR","nombre","formGapTr27");
			
		}else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			borrarNodo("TR","nombre","formTr27");
			borrarNodo("TR","nombre","formGapTr27");
			
		}
	}
	
	
	
		
}





