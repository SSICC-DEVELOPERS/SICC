/*
    INDRA/CAR/mmg
    $Id: EduMatriCursoLPStartUp.java,v 1.1 2009/12/03 18:38:15 pecbazalar Exp $
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
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class EduMatriCursoLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 1588;
	public static final short CREATEFORM_SIZE = 1588;
	public static final short UPDATEFORM_SIZE = 1588;
	public static final short VIEWFORM_SIZE = 1588;

	//Cosntantes que definene elementos de la lçogica de negocio de las entidada
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGEduMatriCursoQueryFromToUserPage";
	public static final String BUSINESSID_PAISOIDPAIS_MONEOIDMONEALT_QUERY ="MMGSegMonedQueryFromToUser";public static final String BUSINESSID_PAISOIDPAIS_FOPAOIDFORMPAGO_QUERY ="MMGBelFormaPagoTaponQueryFromToUser";public static final String BUSINESSID_PAISOIDPAIS_MONEOIDMONE_QUERY ="MMGSegMonedQueryFromToUser";public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisQueryFromToUser";public static final String PAISOIDPAIS_MONEOIDMONEALT_COMBO_CONNECTOR = "SegMonedConectorCombo";
	public static final String PAISOIDPAIS_FOPAOIDFORMPAGO_COMBO_CONNECTOR = "BelFormaPagoTaponConectorCombo";
	public static final String PAISOIDPAIS_MONEOIDMONE_COMBO_CONNECTOR = "SegMonedConectorCombo";
	public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisConectorCombo";
	public static final String BUSINESSID_CPLCOIDCABEPLANCURS_QUERY ="MMGEduPlantCursoCabecQueryFromToUser";public static final String CPLCOIDCABEPLANCURS_COMBO_CONNECTOR = "EduPlantCursoCabecConectorCombo";
	public static final String BUSINESSID_TERROIDTERR_QUERY ="MMGZonTerriQueryFromToUser";public static final String TERROIDTERR_COMBO_CONNECTOR = "ZonTerriConectorCombo";
	public static final String BUSINESSID_CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_QUERY ="MMGMaeTipoClienViewQueryFromToUser";public static final String BUSINESSID_CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_QUERY ="MMGMaeSubtiClienQueryFromToUser";public static final String BUSINESSID_CLASOIDCLAS_TCCLOIDTIPOCLAS_QUERY ="MMGMaeTipoClasiClienQueryFromToUser";public static final String BUSINESSID_CLASOIDCLAS_QUERY ="MMGMaeClasiQueryFromToUser";public static final String CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_COMBO_CONNECTOR = "MaeTipoClienViewConectorCombo";
	public static final String CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_COMBO_CONNECTOR = "MaeSubtiClienConectorCombo";
	public static final String CLASOIDCLAS_TCCLOIDTIPOCLAS_COMBO_CONNECTOR = "MaeTipoClasiClienConectorCombo";
	public static final String CLASOIDCLAS_COMBO_CONNECTOR = "MaeClasiConectorCombo";
	public static final String BUSINESSID_FRCUOIDFREC_QUERY ="MMGEduFrecuCursoQueryFromToUser";public static final String FRCUOIDFREC_COMBO_CONNECTOR = "EduFrecuCursoConectorCombo";
	public static final String BUSINESSID_REGAOIDREGA_PRODOIDPROD_QUERY ="MMGMaeProduQueryFromToUser";public static final String BUSINESSID_REGAOIDREGA_QUERY ="MMGEduRegalQueryFromToUser";public static final String REGAOIDREGA_PRODOIDPROD_COMBO_CONNECTOR = "MaeProduConectorCombo";
	public static final String REGAOIDREGA_COMBO_CONNECTOR = "EduRegalConectorCombo";
	public static final String BUSINESSID_ZSGVOIDSUBGVENT_QUERY ="MMGZonSubGerenVentaQueryFromToUser";public static final String ZSGVOIDSUBGVENT_COMBO_CONNECTOR = "ZonSubGerenVentaConectorCombo";
	public static final String BUSINESSID_ZORGOIDREGI_QUERY ="MMGZonRegioQueryFromToUser";public static final String ZORGOIDREGI_COMBO_CONNECTOR = "ZonRegioConectorCombo";
	public static final String BUSINESSID_ZZONOIDZONA_QUERY ="MMGZonZonaQueryFromToUser";public static final String ZZONOIDZONA_COMBO_CONNECTOR = "ZonZonaConectorCombo";
	public static final String BUSINESSID_ZSCCOIDSECC_QUERY ="MMGZonSecciQueryFromToUser";public static final String ZSCCOIDSECC_COMBO_CONNECTOR = "ZonSecciConectorCombo";
	public static final String BUSINESSID_ZTADOIDTERRADMI_QUERY ="MMGZonTerriAdminQueryFromToUser";public static final String ZTADOIDTERRADMI_COMBO_CONNECTOR = "ZonTerriAdminConectorCombo";
	public static final String BUSINESSID_PERDOIDPERIINICCOMP_QUERY ="MMGCraPerioQueryFromToUser";public static final String PERDOIDPERIINICCOMP_COMBO_CONNECTOR = "CraPerioConectorCombo";
	public static final String BUSINESSID_PERDOIDPERIFINACOMP_QUERY ="MMGCraPerioQueryFromToUser";public static final String PERDOIDPERIFINACOMP_COMBO_CONNECTOR = "CraPerioConectorCombo";
	public static final String BUSINESSID_PERDOIDPERIINICCONS_QUERY ="MMGCraPerioQueryFromToUser";public static final String PERDOIDPERIINICCONS_COMBO_CONNECTOR = "CraPerioConectorCombo";
	public static final String BUSINESSID_PERDOIDPERIFINACONS_QUERY ="MMGCraPerioQueryFromToUser";public static final String PERDOIDPERIFINACONS_COMBO_CONNECTOR = "CraPerioConectorCombo";
	public static final String BUSINESSID_PERDOIDPERIINGR_QUERY ="MMGCraPerioQueryFromToUser";public static final String PERDOIDPERIINGR_COMBO_CONNECTOR = "CraPerioConectorCombo";
	public static final String BUSINESSID_TICUOIDTIPOCURS_MARCOIDMARC_QUERY ="MMGSegMarcaQueryFromToUser";public static final String BUSINESSID_TICUOIDTIPOCURS_QUERY ="MMGEduTipoCursoQueryFromToUser";public static final String TICUOIDTIPOCURS_MARCOIDMARC_COMBO_CONNECTOR = "SegMarcaConectorCombo";
	public static final String TICUOIDTIPOCURS_COMBO_CONNECTOR = "EduTipoCursoConectorCombo";
	public static final String BUSINESSID_CLCLOIDCLIECLASCAPA_QUERY ="MMGMaeClienClasiQueryFromToUser";public static final String CLCLOIDCLIECLASCAPA_COMBO_CONNECTOR = "MaeClienClasiConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public EduMatriCursoLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("EduMatriCursoPage");
	}

	public void ejecucion() throws Exception {
		try{
			//Llamamos al metodo sobresctrito de la clase padre para ejecutar las acciones comunes:
			//obtener configuración del mantenimiento
			super.ejecucion();
		
			//Activamos las trazas
			setTrazaFichero();
			
			//Establecemos el tamaño de la página
			buildJsPageSize("EduMatriCurso");
			
			
		
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "EduMatriCursoPage", "cod", "EduMatriCurso." + accion + ".label");
			
			//Ponemos en la página el idioma de usuario, el idioma de la pagina para mostrar los errores, 
			//y el codigo del idioma por defecto
			asignar("VAR", VAR_IDIOMA, MMGDruidaHelper.getUserDefaultLanguage(this));
			asignar("VAR", VAR_IDIOMA_XML, MMGDruidaHelper.getIdioma(this));
			asignar("VAR", VAR_DEFAULT_LANGUAGE_CODE, MMGDruidaHelper.getUserDefaultLanguage(this));
			
			//Establecemos los tamaños y posiciones de la capas de la pantalla
			establecerSizeCapas(accion, origen);
			
			//Limpiamos la botonera
			limpiarBotoneraLista("eduMatriCurso", accion);
			
			
			
			//Ejecutanos la acción solicitada		
			if(accion.equals(ACCION_LOV)) cmdLov();
			else if(accion.equals(ACCION_QUERY)) cmdQuery();
			else if(accion.equals(ACCION_CREATE)) cmdCreate();
			else if(accion.equals(ACCION_REMOVE)) cmdRemove();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("menu")) cmdUpdate();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("pagina")) cmdPreUpdateForm();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")) cmdUpdateForm();
			else if(accion.equals(ACCION_VIEW) && origen.equals("pagina")) cmdPreView();
			else if(accion.equals(ACCION_VIEW) && origen.equals("preview")) cmdView();
			
			//Eliminamos los labels del modo view si no estamos en dicho modo. 
			//Si lo estamos, eliminamos los widgets
			if(!accion.equals(ACCION_VIEW)) removeViewLabels();
			else removeWidgets();
			
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
		loadLeafDependenceCombos();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		asignarAtributo("TEXT", "codCurs", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "valPathFich", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 240)");
		asignarAtributo("TEXT", "valObjeCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valContCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valRelaMateCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valMontVent", "validacion", "ValidaInt(cdos_trim(valor), 6, 0, 999999)");
		asignarAtributo("TEXT", "fecDispCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecLanz", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecFinCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecUltiCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecConcCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecIngr", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "numPart", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numOrde", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numCampa", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numUnid", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "desCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		asignarAtributo("TEXT", "indAcceDmrt", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indAcceInfo", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indAlcaGeog", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indBloqExte", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indMomeEntr", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCondPedi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCtrlMoro", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCtrlFunc", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		
		

		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "eduMatriCursoLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "EduMatriCursoPage", "onblur", "window.focus();");
		
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
		conectorAction("EduMatriCursoLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro(PARAMETRO_GENERICO_ACCION)!= null?  
			conectorParametro(PARAMETRO_GENERICO_ACCION): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preview");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
	}
	
	/**Acciones que se realizan cunado la pantalla se arranca en modo view*/
	protected void cmdView() throws Exception{
		//Construimos el mso con los elementos de la búsqueda a partir del id que
		//lo sacamos de la request
		EduMatriCursoData eduMatriCursoQuery= new EduMatriCursoData();
		eduMatriCursoQuery.setId(new Integer(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		EduMatriCursoData datosResult = (EduMatriCursoData)getSingleObject(BUSINESSID_QUERY, eduMatriCursoQuery, 
			eduMatriCursoQuery.clone(), "eduMatriCurso");
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		setDependenceComboLabels(datosResult);
		
		//Damos los valores a los labels del modo view
		EduMatriCursoData eduMatriCurso = datosResult;
	
	
		asignarAtributo("LABELC", "lblViewCodCurs", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getCodCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		asignarAtributo("LABELC", "lblViewValPathFich", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getValPathFich(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValObjeCurs", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getValObjeCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValContCurs", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getValContCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValRelaMateCurs", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getValRelaMateCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValMontVent", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getValMontVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewFecDispCurs", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getFecDispCurs(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewFecLanz", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getFecLanz(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewFecFinCurs", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getFecFinCurs(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewFecUltiCurs", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getFecUltiCurs(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewFecConcCurs", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getFecConcCurs(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewFecIngr", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getFecIngr(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewNumPart", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getNumPart(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewNumOrde", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getNumOrde(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewNumCampa", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getNumCampa(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewNumUnid", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getNumUnid(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewDesCurs", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getDesCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndAcceDmrt", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getIndAcceDmrt(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndAcceInfo", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getIndAcceInfo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndAlcaGeog", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getIndAlcaGeog(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndBloqExte", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getIndBloqExte(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndMomeEntr", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getIndMomeEntr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndCondPedi", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getIndCondPedi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndCtrlMoro", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getIndCtrlMoro(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndCtrlFunc", "valor", 
				FormatUtils.formatObject(eduMatriCurso.getIndCtrlFunc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
	
	
	
		//Ponemos la pagina en modo view: Eliminamos el botón de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando sólo el campo simple
		//Eliminamos los elementos correspondientes a la internacionalizacion
		removeLovElements();
		removeQueryElements();
		removeLocalizationElements();
		removeNonViewElements();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	/**Acciones que se realizan cuando la pantalla se arranca en modo create*/
	protected void cmdCreate() throws Exception{
		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos();
	
		//Ponemos los campos requeridos a true
		asignarAtributo("COMBO", "paisOidPais", "req", "S");
		asignarAtributo("COMBO", "cplcOidCabePlanCurs", "req", "S");
		asignarAtributo("TEXT", "codCurs", "req", "S");
		asignarAtributo("COMBO", "clclOidClieClasCapa", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el 
		//valor del idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		asignarAtributo("TEXT", "codCurs", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "valPathFich", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 240)");
		asignarAtributo("TEXT", "valObjeCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valContCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valRelaMateCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valMontVent", "validacion", "ValidaInt(cdos_trim(valor), 6, 0, 999999)");
		asignarAtributo("TEXT", "fecDispCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecLanz", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecFinCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecUltiCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecConcCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecIngr", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "numPart", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numOrde", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numCampa", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numUnid", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "desCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		asignarAtributo("TEXT", "indAcceDmrt", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indAcceInfo", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indAlcaGeog", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indBloqExte", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indMomeEntr", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCondPedi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCtrlMoro", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCtrlFunc", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		
		
		
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

		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		asignarAtributo("TEXT", "codCurs", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "valPathFich", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 240)");
		asignarAtributo("TEXT", "valObjeCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valContCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valRelaMateCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valMontVent", "validacion", "ValidaInt(cdos_trim(valor), 6, 0, 999999)");
		asignarAtributo("TEXT", "fecDispCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecLanz", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecFinCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecUltiCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecConcCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecIngr", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "numPart", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numOrde", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numCampa", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numUnid", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "desCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		asignarAtributo("TEXT", "indAcceDmrt", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indAcceInfo", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indAlcaGeog", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indBloqExte", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indMomeEntr", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCondPedi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCtrlMoro", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCtrlFunc", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Eliminamos los elementos correspondientes a la internacionalizacion y lov
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
		
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}
	}

	/**Acciones a ejecutar cuando la ventana se abre en modo query*/
	protected void cmdQuery() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();
		
		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		asignarAtributo("TEXT", "codCurs", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "valPathFich", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 240)");
		asignarAtributo("TEXT", "valObjeCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valContCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valRelaMateCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valMontVent", "validacion", "ValidaInt(cdos_trim(valor), 6, 0, 999999)");
		asignarAtributo("TEXT", "fecDispCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecLanz", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecFinCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecUltiCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecConcCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecIngr", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "numPart", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numOrde", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numCampa", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numUnid", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "desCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		asignarAtributo("TEXT", "indAcceDmrt", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indAcceInfo", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indAlcaGeog", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indBloqExte", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indMomeEntr", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCondPedi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCtrlMoro", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCtrlFunc", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Eliminamos los elementos correspondientes a la internacionalizacion
		//elimnamos el botón lov de null selection
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
		
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}
			
	}
	
	/**Acciones a ejecutar cuando la ventana se abre en modo update*/
	protected void cmdUpdate() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();

		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		asignarAtributo("TEXT", "codCurs", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "valPathFich", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 240)");
		asignarAtributo("TEXT", "valObjeCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valContCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valRelaMateCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valMontVent", "validacion", "ValidaInt(cdos_trim(valor), 6, 0, 999999)");
		asignarAtributo("TEXT", "fecDispCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecLanz", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecFinCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecUltiCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecConcCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecIngr", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "numPart", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numOrde", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numCampa", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numUnid", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "desCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		asignarAtributo("TEXT", "indAcceDmrt", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indAcceInfo", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indAlcaGeog", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indBloqExte", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indMomeEntr", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCondPedi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCtrlMoro", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCtrlFunc", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Simplemente elimnamos el botón lov de null selection y la internacionalización
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
		
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}
	}

	
	/**Acción previa para poder permitir la carga de datos en el formulario 
	de updatecon ventana oculta. Para ello simplemente redireccionamos al método*/
	protected void cmdPreUpdateForm() throws Exception{
		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION) != null?
			conectorParametro(VAR_LAST_QUERY_TO_SESSION): "");

		//Redirigimos al update form
		conectorAction("EduMatriCursoLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro("accion") != null?
			conectorParametro("accion"): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preupdate");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
	}
	
	/**Prepara el formualrio para mostrar los datos de un elemento de la entidad
	y estos puedan ser modificados*/  
	protected void cmdUpdateForm() throws Exception{
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));

		//Actualizamos el valor de enviar de forma oculta el formulario. 
		//asignarAtributo("FORMULARIO", "eduMatriCursoFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		asignarAtributo("COMBO", "paisOidPais", "req", "S");
		asignarAtributo("COMBO", "cplcOidCabePlanCurs", "req", "S");
		asignarAtributo("TEXT", "codCurs", "req", "S");
		asignarAtributo("COMBO", "clclOidClieClasCapa", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el valor
		//para el idioma por defecto
		
		

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		
		
		asignarAtributo("TEXT", "codCurs", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "valPathFich", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 240)");
		asignarAtributo("TEXT", "valObjeCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valContCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valRelaMateCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "valMontVent", "validacion", "ValidaInt(cdos_trim(valor), 6, 0, 999999)");
		asignarAtributo("TEXT", "fecDispCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecLanz", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecFinCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecUltiCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecConcCurs", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecIngr", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "numPart", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numOrde", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numCampa", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numUnid", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "desCurs", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		asignarAtributo("TEXT", "indAcceDmrt", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indAcceInfo", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indAlcaGeog", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indBloqExte", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indMomeEntr", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCondPedi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCtrlMoro", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indCtrlFunc", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		
		

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando EduMatriCurso");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		EduMatriCursoData eduMatriCursoQuery= new EduMatriCursoData();
		eduMatriCursoQuery.setId(new Integer(id));

		//Sacamos de la base de datos la entidad a modificar
		EduMatriCursoData  datosResult = (EduMatriCursoData)getSingleObject(BUSINESSID_QUERY, eduMatriCursoQuery, 
			eduMatriCursoQuery.clone(), "eduMatriCurso");

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos();
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		EduMatriCursoData eduMatriCurso = datosResult;
		asignar("VAR", "idSelection", id);
		es.indra.belcorp.mso.SegPaisData paisOidPais = eduMatriCurso.getPaisOidPais();
		if(paisOidPais != null && paisOidPais.getId() != null) checkCombo("paisOidPais" , paisOidPais.getId().toString());
	
		es.indra.belcorp.mso.EduPlantCursoCabecData cplcOidCabePlanCurs = eduMatriCurso.getCplcOidCabePlanCurs();
		if(cplcOidCabePlanCurs != null && cplcOidCabePlanCurs.getId() != null) checkCombo("cplcOidCabePlanCurs" , cplcOidCabePlanCurs.getId().toString());
	
		asignar("TEXT", "codCurs", FormatUtils.formatObject(eduMatriCurso.getCodCurs(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		es.indra.belcorp.mso.ZonTerriData terrOidTerr = eduMatriCurso.getTerrOidTerr();
		if(terrOidTerr != null && terrOidTerr.getId() != null) checkCombo("terrOidTerr" , terrOidTerr.getId().toString());
	
		es.indra.belcorp.mso.MaeClasiData clasOidClas = eduMatriCurso.getClasOidClas();
		if(clasOidClas != null && clasOidClas.getId() != null) checkCombo("clasOidClas" , clasOidClas.getId().toString());
	
		es.indra.belcorp.mso.EduFrecuCursoData frcuOidFrec = eduMatriCurso.getFrcuOidFrec();
		if(frcuOidFrec != null && frcuOidFrec.getId() != null) checkCombo("frcuOidFrec" , frcuOidFrec.getId().toString());
	
		es.indra.belcorp.mso.EduRegalData regaOidRega = eduMatriCurso.getRegaOidRega();
		if(regaOidRega != null && regaOidRega.getId() != null) checkCombo("regaOidRega" , regaOidRega.getId().toString());
	
		es.indra.belcorp.mso.ZonSubGerenVentaData zsgvOidSubgVent = eduMatriCurso.getZsgvOidSubgVent();
		if(zsgvOidSubgVent != null && zsgvOidSubgVent.getId() != null) checkCombo("zsgvOidSubgVent" , zsgvOidSubgVent.getId().toString());
	
		es.indra.belcorp.mso.ZonRegioData zorgOidRegi = eduMatriCurso.getZorgOidRegi();
		if(zorgOidRegi != null && zorgOidRegi.getId() != null) checkCombo("zorgOidRegi" , zorgOidRegi.getId().toString());
	
		es.indra.belcorp.mso.ZonZonaData zzonOidZona = eduMatriCurso.getZzonOidZona();
		if(zzonOidZona != null && zzonOidZona.getId() != null) checkCombo("zzonOidZona" , zzonOidZona.getId().toString());
	
		es.indra.belcorp.mso.ZonSecciData zsccOidSecc = eduMatriCurso.getZsccOidSecc();
		if(zsccOidSecc != null && zsccOidSecc.getId() != null) checkCombo("zsccOidSecc" , zsccOidSecc.getId().toString());
	
		es.indra.belcorp.mso.ZonTerriAdminData ztadOidTerrAdmi = eduMatriCurso.getZtadOidTerrAdmi();
		if(ztadOidTerrAdmi != null && ztadOidTerrAdmi.getId() != null) checkCombo("ztadOidTerrAdmi" , ztadOidTerrAdmi.getId().toString());
	
		es.indra.belcorp.mso.CraPerioData perdOidPeriInicComp = eduMatriCurso.getPerdOidPeriInicComp();
		if(perdOidPeriInicComp != null && perdOidPeriInicComp.getId() != null) checkCombo("perdOidPeriInicComp" , perdOidPeriInicComp.getId().toString());
	
		es.indra.belcorp.mso.CraPerioData perdOidPeriFinaComp = eduMatriCurso.getPerdOidPeriFinaComp();
		if(perdOidPeriFinaComp != null && perdOidPeriFinaComp.getId() != null) checkCombo("perdOidPeriFinaComp" , perdOidPeriFinaComp.getId().toString());
	
		es.indra.belcorp.mso.CraPerioData perdOidPeriInicCons = eduMatriCurso.getPerdOidPeriInicCons();
		if(perdOidPeriInicCons != null && perdOidPeriInicCons.getId() != null) checkCombo("perdOidPeriInicCons" , perdOidPeriInicCons.getId().toString());
	
		es.indra.belcorp.mso.CraPerioData perdOidPeriFinaCons = eduMatriCurso.getPerdOidPeriFinaCons();
		if(perdOidPeriFinaCons != null && perdOidPeriFinaCons.getId() != null) checkCombo("perdOidPeriFinaCons" , perdOidPeriFinaCons.getId().toString());
	
		es.indra.belcorp.mso.CraPerioData perdOidPeriIngr = eduMatriCurso.getPerdOidPeriIngr();
		if(perdOidPeriIngr != null && perdOidPeriIngr.getId() != null) checkCombo("perdOidPeriIngr" , perdOidPeriIngr.getId().toString());
	
		es.indra.belcorp.mso.EduTipoCursoData ticuOidTipoCurs = eduMatriCurso.getTicuOidTipoCurs();
		if(ticuOidTipoCurs != null && ticuOidTipoCurs.getId() != null) checkCombo("ticuOidTipoCurs" , ticuOidTipoCurs.getId().toString());
	
		asignar("TEXT", "valPathFich", FormatUtils.formatObject(eduMatriCurso.getValPathFich(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valObjeCurs", FormatUtils.formatObject(eduMatriCurso.getValObjeCurs(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valContCurs", FormatUtils.formatObject(eduMatriCurso.getValContCurs(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valRelaMateCurs", FormatUtils.formatObject(eduMatriCurso.getValRelaMateCurs(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valMontVent", FormatUtils.formatObject(eduMatriCurso.getValMontVent(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "fecDispCurs", FormatUtils.formatObject(eduMatriCurso.getFecDispCurs(), 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "fecLanz", FormatUtils.formatObject(eduMatriCurso.getFecLanz(), 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "fecFinCurs", FormatUtils.formatObject(eduMatriCurso.getFecFinCurs(), 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "fecUltiCurs", FormatUtils.formatObject(eduMatriCurso.getFecUltiCurs(), 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "fecConcCurs", FormatUtils.formatObject(eduMatriCurso.getFecConcCurs(), 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "fecIngr", FormatUtils.formatObject(eduMatriCurso.getFecIngr(), 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "numPart", FormatUtils.formatObject(eduMatriCurso.getNumPart(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "numOrde", FormatUtils.formatObject(eduMatriCurso.getNumOrde(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "numCampa", FormatUtils.formatObject(eduMatriCurso.getNumCampa(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "numUnid", FormatUtils.formatObject(eduMatriCurso.getNumUnid(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "desCurs", FormatUtils.formatObject(eduMatriCurso.getDesCurs(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indAcceDmrt", FormatUtils.formatObject(eduMatriCurso.getIndAcceDmrt(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indAcceInfo", FormatUtils.formatObject(eduMatriCurso.getIndAcceInfo(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indAlcaGeog", FormatUtils.formatObject(eduMatriCurso.getIndAlcaGeog(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indBloqExte", FormatUtils.formatObject(eduMatriCurso.getIndBloqExte(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indMomeEntr", FormatUtils.formatObject(eduMatriCurso.getIndMomeEntr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indCondPedi", FormatUtils.formatObject(eduMatriCurso.getIndCondPedi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indCtrlMoro", FormatUtils.formatObject(eduMatriCurso.getIndCtrlMoro(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indCtrlFunc", FormatUtils.formatObject(eduMatriCurso.getIndCtrlFunc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		es.indra.belcorp.mso.MaeClienClasiData clclOidClieClasCapa = eduMatriCurso.getClclOidClieClasCapa();
		if(clclOidClieClasCapa != null && clclOidClieClasCapa.getId() != null) checkCombo("clclOidClieClasCapa" , clclOidClieClasCapa.getId().toString());
	
	

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(eduMatriCurso.jdoGetTimeStamp()));
		
		//Ponemos la pagina en modo view: Eliminamos el botón de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando sólo el campo simple
		//Borramos los elementos correspondientes a la internacionalización
		removeLovElements();
		removeQueryElements();
		removeNonModifyFields();
	}
	
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
		
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","eduMatriCursoTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","eduMatriCursoTrButtons");

		//Borramos los elementos no necesarios de la búsqueda para los campos con búsquda
		//por intervalo
		
	}
	
	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de remove
	*/
	protected void removeNonViewElements() throws Exception{
		borrarCampo("id");
		
	}

	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de inserción
	*/
	protected void removeNonInsertElements() throws Exception{
		borrarCampo("id");
		
	}

	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de remove
	*/
	protected void removeNonSearchElements() throws Exception{
		borrarCampo("id");
		
	}
	
	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario 
	* de modificación
	*/
	protected void removeNonModifyFields() throws Exception{
		borrarCampo("id");
		
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
		asignarAtributo("CAPA","eduMatriCursoFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","eduMatriCursoPreListLayer", "y", String.valueOf(sizeForm + 24));
		asignarAtributo("CAPA","eduMatriCursoListLayer", "y", String.valueOf(sizeForm + 46));		
		asignarAtributo("CAPA","eduMatriCursoListButtonsLayer", "y", String.valueOf(sizeForm + 299));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos() throws Exception{
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_MONEOIDMONEALT_QUERY,PAISOIDPAIS_MONEOIDMONEALT_COMBO_CONNECTOR, new SegMonedData(), new SegMonedData(), "segMoned", "paisOidPais_moneOidMoneAlt", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_FOPAOIDFORMPAGO_QUERY,PAISOIDPAIS_FOPAOIDFORMPAGO_COMBO_CONNECTOR, new BelFormaPagoTaponData(), new BelFormaPagoTaponData(), "belFormaPagoTapon", "paisOidPais_fopaOidFormPago", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_MONEOIDMONE_QUERY,PAISOIDPAIS_MONEOIDMONE_COMBO_CONNECTOR, new SegMonedData(), new SegMonedData(), "segMoned", "paisOidPais_moneOidMone", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_CPLCOIDCABEPLANCURS_QUERY,CPLCOIDCABEPLANCURS_COMBO_CONNECTOR, new EduPlantCursoCabecData(), new EduPlantCursoCabecData(), "eduPlantCursoCabec", "cplcOidCabePlanCurs", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_TERROIDTERR_QUERY,TERROIDTERR_COMBO_CONNECTOR, new ZonTerriData(), new ZonTerriData(), "zonTerri", "terrOidTerr", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_QUERY,CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_COMBO_CONNECTOR, new MaeTipoClienViewData(), new MaeTipoClienViewData(), "maeTipoClienView", "clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_FRCUOIDFREC_QUERY,FRCUOIDFREC_COMBO_CONNECTOR, new EduFrecuCursoData(), new EduFrecuCursoData(), "eduFrecuCurso", "frcuOidFrec", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_REGAOIDREGA_PRODOIDPROD_QUERY,REGAOIDREGA_PRODOIDPROD_COMBO_CONNECTOR, new MaeProduData(), new MaeProduData(), "maeProdu", "regaOidRega_prodOidProd", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_ZSGVOIDSUBGVENT_QUERY,ZSGVOIDSUBGVENT_COMBO_CONNECTOR, new ZonSubGerenVentaData(), new ZonSubGerenVentaData(), "zonSubGerenVenta", "zsgvOidSubgVent", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_ZORGOIDREGI_QUERY,ZORGOIDREGI_COMBO_CONNECTOR, new ZonRegioData(), new ZonRegioData(), "zonRegio", "zorgOidRegi", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_ZZONOIDZONA_QUERY,ZZONOIDZONA_COMBO_CONNECTOR, new ZonZonaData(), new ZonZonaData(), "zonZona", "zzonOidZona", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_ZSCCOIDSECC_QUERY,ZSCCOIDSECC_COMBO_CONNECTOR, new ZonSecciData(), new ZonSecciData(), "zonSecci", "zsccOidSecc", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_ZTADOIDTERRADMI_QUERY,ZTADOIDTERRADMI_COMBO_CONNECTOR, new ZonTerriAdminData(), new ZonTerriAdminData(), "zonTerriAdmin", "ztadOidTerrAdmi", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_PERDOIDPERIINICCOMP_QUERY,PERDOIDPERIINICCOMP_COMBO_CONNECTOR, new CraPerioData(), new CraPerioData(), "craPerio", "perdOidPeriInicComp", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_PERDOIDPERIFINACOMP_QUERY,PERDOIDPERIFINACOMP_COMBO_CONNECTOR, new CraPerioData(), new CraPerioData(), "craPerio", "perdOidPeriFinaComp", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_PERDOIDPERIINICCONS_QUERY,PERDOIDPERIINICCONS_COMBO_CONNECTOR, new CraPerioData(), new CraPerioData(), "craPerio", "perdOidPeriInicCons", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_PERDOIDPERIFINACONS_QUERY,PERDOIDPERIFINACONS_COMBO_CONNECTOR, new CraPerioData(), new CraPerioData(), "craPerio", "perdOidPeriFinaCons", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_PERDOIDPERIINGR_QUERY,PERDOIDPERIINGR_COMBO_CONNECTOR, new CraPerioData(), new CraPerioData(), "craPerio", "perdOidPeriIngr", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_TICUOIDTIPOCURS_MARCOIDMARC_QUERY,TICUOIDTIPOCURS_MARCOIDMARC_COMBO_CONNECTOR, new SegMarcaData(), new SegMarcaData(), "segMarca", "ticuOidTipoCurs_marcOidMarc", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_CLCLOIDCLIECLASCAPA_QUERY,CLCLOIDCLIECLASCAPA_COMBO_CONNECTOR, new MaeClienClasiData(), new MaeClienClasiData(), "maeClienClasi", "clclOidClieClasCapa", "result_ROWSET" );
		
			
		//Seleccionamos en los combos de enitdades estructurales el valor asociado al usuario
		/*String paisOidPais = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPais");
		if(paisOidPais != null && !paisOidPais.trim().equals("")) checkCombo("paisOidPais", paisOidPais);
		String terrOidTerr = MMGDruidaHelper.gerUserStructuralEntityValue(this, "ZonTerri");
		if(terrOidTerr != null && !terrOidTerr.trim().equals("")) checkCombo("terrOidTerr", terrOidTerr);
		String zorgOidRegi = MMGDruidaHelper.gerUserStructuralEntityValue(this, "ZonRegio");
		if(zorgOidRegi != null && !zorgOidRegi.trim().equals("")) checkCombo("zorgOidRegi", zorgOidRegi);
		String zzonOidZona = MMGDruidaHelper.gerUserStructuralEntityValue(this, "ZonZona");
		if(zzonOidZona != null && !zzonOidZona.trim().equals("")) checkCombo("zzonOidZona", zzonOidZona);
		String zsccOidSecc = MMGDruidaHelper.gerUserStructuralEntityValue(this, "ZonSecci");
		if(zsccOidSecc != null && !zsccOidSecc.trim().equals("")) checkCombo("zsccOidSecc", zsccOidSecc);
		
		*/
	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param eduMatriCurso La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(EduMatriCursoData eduMatriCurso) 
		throws Exception{
		if(eduMatriCurso.getPaisOidPais() != null){
			SegPaisData paisOidPais = new SegPaisData();
			paisOidPais.setMoneOidMoneAlt(eduMatriCurso.getPaisOidPais().getMoneOidMoneAlt());
			paisOidPais.setFopaOidFormPago(eduMatriCurso.getPaisOidPais().getFopaOidFormPago());
			paisOidPais.setMoneOidMone(eduMatriCurso.getPaisOidPais().getMoneOidMone());
			asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, paisOidPais, paisOidPais.clone(), "segPais", "paisOidPais", "result_ROWSET");
			checkCombo("paisOidPais" , eduMatriCurso.getPaisOidPais().getId().toString());
			checkCombo("paisOidPais_moneOidMoneAlt" , eduMatriCurso.getPaisOidPais().getMoneOidMoneAlt().getId().toString());
			checkCombo("paisOidPais_fopaOidFormPago" , eduMatriCurso.getPaisOidPais().getFopaOidFormPago().getId().toString());
			checkCombo("paisOidPais_moneOidMone" , eduMatriCurso.getPaisOidPais().getMoneOidMone().getId().toString());
			}
		if(eduMatriCurso.getCplcOidCabePlanCurs() != null){
			checkCombo("cplcOidCabePlanCurs" , eduMatriCurso.getCplcOidCabePlanCurs().getId().toString());
			}
		if(eduMatriCurso.getTerrOidTerr() != null){
			checkCombo("terrOidTerr" , eduMatriCurso.getTerrOidTerr().getId().toString());
			}
		if(eduMatriCurso.getClasOidClas() != null){
			MaeClasiData clasOidClas = new MaeClasiData();
			clasOidClas.setTcclOidTipoClas(eduMatriCurso.getClasOidClas().getTcclOidTipoClas());
			asignarComboResultados(BUSINESSID_CLASOIDCLAS_QUERY,CLASOIDCLAS_COMBO_CONNECTOR, clasOidClas, clasOidClas.clone(), "maeClasi", "clasOidClas", "result_ROWSET");
			checkCombo("clasOidClas" , eduMatriCurso.getClasOidClas().getId().toString());
			MaeTipoClasiClienData clasOidClas_tcclOidTipoClas = new MaeTipoClasiClienData();
			clasOidClas_tcclOidTipoClas.setSbtiOidSubtClie(eduMatriCurso.getClasOidClas().getTcclOidTipoClas().getSbtiOidSubtClie());
			asignarComboResultados(BUSINESSID_CLASOIDCLAS_TCCLOIDTIPOCLAS_QUERY,CLASOIDCLAS_TCCLOIDTIPOCLAS_COMBO_CONNECTOR, clasOidClas_tcclOidTipoClas, clasOidClas_tcclOidTipoClas.clone(), "maeTipoClasiClien", "clasOidClas_tcclOidTipoClas", "result_ROWSET");
			checkCombo("clasOidClas_tcclOidTipoClas" , eduMatriCurso.getClasOidClas().getTcclOidTipoClas().getId().toString());
			MaeSubtiClienData clasOidClas_tcclOidTipoClas_sbtiOidSubtClie = new MaeSubtiClienData();
			clasOidClas_tcclOidTipoClas_sbtiOidSubtClie.setTiclOidTipoClie(eduMatriCurso.getClasOidClas().getTcclOidTipoClas().getSbtiOidSubtClie().getTiclOidTipoClie());
			asignarComboResultados(BUSINESSID_CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_QUERY,CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_COMBO_CONNECTOR, clasOidClas_tcclOidTipoClas_sbtiOidSubtClie, clasOidClas_tcclOidTipoClas_sbtiOidSubtClie.clone(), "maeSubtiClien", "clasOidClas_tcclOidTipoClas_sbtiOidSubtClie", "result_ROWSET");
			checkCombo("clasOidClas_tcclOidTipoClas_sbtiOidSubtClie" , eduMatriCurso.getClasOidClas().getTcclOidTipoClas().getSbtiOidSubtClie().getId().toString());
			checkCombo("clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie" , eduMatriCurso.getClasOidClas().getTcclOidTipoClas().getSbtiOidSubtClie().getTiclOidTipoClie().getId().toString());
			}
		if(eduMatriCurso.getFrcuOidFrec() != null){
			checkCombo("frcuOidFrec" , eduMatriCurso.getFrcuOidFrec().getId().toString());
			}
		if(eduMatriCurso.getRegaOidRega() != null){
			EduRegalData regaOidRega = new EduRegalData();
			regaOidRega.setProdOidProd(eduMatriCurso.getRegaOidRega().getProdOidProd());
			asignarComboResultados(BUSINESSID_REGAOIDREGA_QUERY,REGAOIDREGA_COMBO_CONNECTOR, regaOidRega, regaOidRega.clone(), "eduRegal", "regaOidRega", "result_ROWSET");
			checkCombo("regaOidRega" , eduMatriCurso.getRegaOidRega().getId().toString());
			checkCombo("regaOidRega_prodOidProd" , eduMatriCurso.getRegaOidRega().getProdOidProd().getId().toString());
			}
		if(eduMatriCurso.getZsgvOidSubgVent() != null){
			checkCombo("zsgvOidSubgVent" , eduMatriCurso.getZsgvOidSubgVent().getId().toString());
			}
		if(eduMatriCurso.getZorgOidRegi() != null){
			checkCombo("zorgOidRegi" , eduMatriCurso.getZorgOidRegi().getId().toString());
			}
		if(eduMatriCurso.getZzonOidZona() != null){
			checkCombo("zzonOidZona" , eduMatriCurso.getZzonOidZona().getId().toString());
			}
		if(eduMatriCurso.getZsccOidSecc() != null){
			checkCombo("zsccOidSecc" , eduMatriCurso.getZsccOidSecc().getId().toString());
			}
		if(eduMatriCurso.getZtadOidTerrAdmi() != null){
			checkCombo("ztadOidTerrAdmi" , eduMatriCurso.getZtadOidTerrAdmi().getId().toString());
			}
		if(eduMatriCurso.getPerdOidPeriInicComp() != null){
			checkCombo("perdOidPeriInicComp" , eduMatriCurso.getPerdOidPeriInicComp().getId().toString());
			}
		if(eduMatriCurso.getPerdOidPeriFinaComp() != null){
			checkCombo("perdOidPeriFinaComp" , eduMatriCurso.getPerdOidPeriFinaComp().getId().toString());
			}
		if(eduMatriCurso.getPerdOidPeriInicCons() != null){
			checkCombo("perdOidPeriInicCons" , eduMatriCurso.getPerdOidPeriInicCons().getId().toString());
			}
		if(eduMatriCurso.getPerdOidPeriFinaCons() != null){
			checkCombo("perdOidPeriFinaCons" , eduMatriCurso.getPerdOidPeriFinaCons().getId().toString());
			}
		if(eduMatriCurso.getPerdOidPeriIngr() != null){
			checkCombo("perdOidPeriIngr" , eduMatriCurso.getPerdOidPeriIngr().getId().toString());
			}
		if(eduMatriCurso.getTicuOidTipoCurs() != null){
			EduTipoCursoData ticuOidTipoCurs = new EduTipoCursoData();
			ticuOidTipoCurs.setMarcOidMarc(eduMatriCurso.getTicuOidTipoCurs().getMarcOidMarc());
			asignarComboResultados(BUSINESSID_TICUOIDTIPOCURS_QUERY,TICUOIDTIPOCURS_COMBO_CONNECTOR, ticuOidTipoCurs, ticuOidTipoCurs.clone(), "eduTipoCurso", "ticuOidTipoCurs", "result_ROWSET");
			checkCombo("ticuOidTipoCurs" , eduMatriCurso.getTicuOidTipoCurs().getId().toString());
			checkCombo("ticuOidTipoCurs_marcOidMarc" , eduMatriCurso.getTicuOidTipoCurs().getMarcOidMarc().getId().toString());
			}
		if(eduMatriCurso.getClclOidClieClasCapa() != null){
			checkCombo("clclOidClieClasCapa" , eduMatriCurso.getClclOidClieClasCapa().getId().toString());
			}
		
	}
	
	/**
	* Este método nos permite establecer el valor de los labels de una jerarquái de dependencia
	*/
	protected void setDependenceComboLabels(EduMatriCursoData eduMatriCurso) 
		throws Exception{
		asignarAtributo("LABELC", "lblViewPaisOidPais_moneOidMoneAlt", "valor",FormatUtils.formatObject(eduMatriCurso.getPaisOidPais().getMoneOidMoneAlt()));
		asignarAtributo("LABELC", "lblViewPaisOidPais_fopaOidFormPago", "valor",FormatUtils.formatObject(eduMatriCurso.getPaisOidPais().getFopaOidFormPago()));
		asignarAtributo("LABELC", "lblViewPaisOidPais_moneOidMone", "valor",FormatUtils.formatObject(eduMatriCurso.getPaisOidPais().getMoneOidMone()));
		asignarAtributo("LABELC", "lblViewPaisOidPais", "valor",FormatUtils.formatObject(eduMatriCurso.getPaisOidPais()));
		asignarAtributo("LABELC", "lblViewCplcOidCabePlanCurs", "valor",FormatUtils.formatObject(eduMatriCurso.getCplcOidCabePlanCurs()));
		asignarAtributo("LABELC", "lblViewTerrOidTerr", "valor",FormatUtils.formatObject(eduMatriCurso.getTerrOidTerr()));
		asignarAtributo("LABELC", "lblViewClasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "valor",FormatUtils.formatObject(eduMatriCurso.getClasOidClas().getTcclOidTipoClas().getSbtiOidSubtClie().getTiclOidTipoClie()));
		asignarAtributo("LABELC", "lblViewClasOidClas_tcclOidTipoClas_sbtiOidSubtClie", "valor",FormatUtils.formatObject(eduMatriCurso.getClasOidClas().getTcclOidTipoClas().getSbtiOidSubtClie()));
		asignarAtributo("LABELC", "lblViewClasOidClas_tcclOidTipoClas", "valor",FormatUtils.formatObject(eduMatriCurso.getClasOidClas().getTcclOidTipoClas()));
		asignarAtributo("LABELC", "lblViewClasOidClas", "valor",FormatUtils.formatObject(eduMatriCurso.getClasOidClas()));
		asignarAtributo("LABELC", "lblViewFrcuOidFrec", "valor",FormatUtils.formatObject(eduMatriCurso.getFrcuOidFrec()));
		asignarAtributo("LABELC", "lblViewRegaOidRega_prodOidProd", "valor",FormatUtils.formatObject(eduMatriCurso.getRegaOidRega().getProdOidProd()));
		asignarAtributo("LABELC", "lblViewRegaOidRega", "valor",FormatUtils.formatObject(eduMatriCurso.getRegaOidRega()));
		asignarAtributo("LABELC", "lblViewZsgvOidSubgVent", "valor",FormatUtils.formatObject(eduMatriCurso.getZsgvOidSubgVent()));
		asignarAtributo("LABELC", "lblViewZorgOidRegi", "valor",FormatUtils.formatObject(eduMatriCurso.getZorgOidRegi()));
		asignarAtributo("LABELC", "lblViewZzonOidZona", "valor",FormatUtils.formatObject(eduMatriCurso.getZzonOidZona()));
		asignarAtributo("LABELC", "lblViewZsccOidSecc", "valor",FormatUtils.formatObject(eduMatriCurso.getZsccOidSecc()));
		asignarAtributo("LABELC", "lblViewZtadOidTerrAdmi", "valor",FormatUtils.formatObject(eduMatriCurso.getZtadOidTerrAdmi()));
		asignarAtributo("LABELC", "lblViewPerdOidPeriInicComp", "valor",FormatUtils.formatObject(eduMatriCurso.getPerdOidPeriInicComp()));
		asignarAtributo("LABELC", "lblViewPerdOidPeriFinaComp", "valor",FormatUtils.formatObject(eduMatriCurso.getPerdOidPeriFinaComp()));
		asignarAtributo("LABELC", "lblViewPerdOidPeriInicCons", "valor",FormatUtils.formatObject(eduMatriCurso.getPerdOidPeriInicCons()));
		asignarAtributo("LABELC", "lblViewPerdOidPeriFinaCons", "valor",FormatUtils.formatObject(eduMatriCurso.getPerdOidPeriFinaCons()));
		asignarAtributo("LABELC", "lblViewPerdOidPeriIngr", "valor",FormatUtils.formatObject(eduMatriCurso.getPerdOidPeriIngr()));
		asignarAtributo("LABELC", "lblViewTicuOidTipoCurs_marcOidMarc", "valor",FormatUtils.formatObject(eduMatriCurso.getTicuOidTipoCurs().getMarcOidMarc()));
		asignarAtributo("LABELC", "lblViewTicuOidTipoCurs", "valor",FormatUtils.formatObject(eduMatriCurso.getTicuOidTipoCurs()));
		asignarAtributo("LABELC", "lblViewClclOidClieClasCapa", "valor",FormatUtils.formatObject(eduMatriCurso.getClclOidClieClasCapa()));
		
			
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		EduMatriCursoData eduMatriCurso = 
			(EduMatriCursoData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(eduMatriCurso.getPaisOidPais() != null){
			eduMatriCurso.setPaisOidPais((es.indra.belcorp.mso.SegPaisData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			eduMatriCurso.getPaisOidPais(),
			eduMatriCurso.getPaisOidPais().clone(),
			"segPais"));
		}
		if(eduMatriCurso.getCplcOidCabePlanCurs() != null){
			eduMatriCurso.setCplcOidCabePlanCurs((es.indra.belcorp.mso.EduPlantCursoCabecData)
			getSingleObject(BUSINESSID_CPLCOIDCABEPLANCURS_QUERY, 
			eduMatriCurso.getCplcOidCabePlanCurs(),
			eduMatriCurso.getCplcOidCabePlanCurs().clone(),
			"eduPlantCursoCabec"));
		}
		if(eduMatriCurso.getTerrOidTerr() != null){
			eduMatriCurso.setTerrOidTerr((es.indra.belcorp.mso.ZonTerriData)
			getSingleObject(BUSINESSID_TERROIDTERR_QUERY, 
			eduMatriCurso.getTerrOidTerr(),
			eduMatriCurso.getTerrOidTerr().clone(),
			"zonTerri"));
		}
		if(eduMatriCurso.getClasOidClas() != null){
			eduMatriCurso.setClasOidClas((es.indra.belcorp.mso.MaeClasiData)
			getSingleObject(BUSINESSID_CLASOIDCLAS_QUERY, 
			eduMatriCurso.getClasOidClas(),
			eduMatriCurso.getClasOidClas().clone(),
			"maeClasi"));
		}
		if(eduMatriCurso.getFrcuOidFrec() != null){
			eduMatriCurso.setFrcuOidFrec((es.indra.belcorp.mso.EduFrecuCursoData)
			getSingleObject(BUSINESSID_FRCUOIDFREC_QUERY, 
			eduMatriCurso.getFrcuOidFrec(),
			eduMatriCurso.getFrcuOidFrec().clone(),
			"eduFrecuCurso"));
		}
		if(eduMatriCurso.getRegaOidRega() != null){
			eduMatriCurso.setRegaOidRega((es.indra.belcorp.mso.EduRegalData)
			getSingleObject(BUSINESSID_REGAOIDREGA_QUERY, 
			eduMatriCurso.getRegaOidRega(),
			eduMatriCurso.getRegaOidRega().clone(),
			"eduRegal"));
		}
		if(eduMatriCurso.getZsgvOidSubgVent() != null){
			eduMatriCurso.setZsgvOidSubgVent((es.indra.belcorp.mso.ZonSubGerenVentaData)
			getSingleObject(BUSINESSID_ZSGVOIDSUBGVENT_QUERY, 
			eduMatriCurso.getZsgvOidSubgVent(),
			eduMatriCurso.getZsgvOidSubgVent().clone(),
			"zonSubGerenVenta"));
		}
		if(eduMatriCurso.getZorgOidRegi() != null){
			eduMatriCurso.setZorgOidRegi((es.indra.belcorp.mso.ZonRegioData)
			getSingleObject(BUSINESSID_ZORGOIDREGI_QUERY, 
			eduMatriCurso.getZorgOidRegi(),
			eduMatriCurso.getZorgOidRegi().clone(),
			"zonRegio"));
		}
		if(eduMatriCurso.getZzonOidZona() != null){
			eduMatriCurso.setZzonOidZona((es.indra.belcorp.mso.ZonZonaData)
			getSingleObject(BUSINESSID_ZZONOIDZONA_QUERY, 
			eduMatriCurso.getZzonOidZona(),
			eduMatriCurso.getZzonOidZona().clone(),
			"zonZona"));
		}
		if(eduMatriCurso.getZsccOidSecc() != null){
			eduMatriCurso.setZsccOidSecc((es.indra.belcorp.mso.ZonSecciData)
			getSingleObject(BUSINESSID_ZSCCOIDSECC_QUERY, 
			eduMatriCurso.getZsccOidSecc(),
			eduMatriCurso.getZsccOidSecc().clone(),
			"zonSecci"));
		}
		if(eduMatriCurso.getZtadOidTerrAdmi() != null){
			eduMatriCurso.setZtadOidTerrAdmi((es.indra.belcorp.mso.ZonTerriAdminData)
			getSingleObject(BUSINESSID_ZTADOIDTERRADMI_QUERY, 
			eduMatriCurso.getZtadOidTerrAdmi(),
			eduMatriCurso.getZtadOidTerrAdmi().clone(),
			"zonTerriAdmin"));
		}
		if(eduMatriCurso.getPerdOidPeriInicComp() != null){
			eduMatriCurso.setPerdOidPeriInicComp((es.indra.belcorp.mso.CraPerioData)
			getSingleObject(BUSINESSID_PERDOIDPERIINICCOMP_QUERY, 
			eduMatriCurso.getPerdOidPeriInicComp(),
			eduMatriCurso.getPerdOidPeriInicComp().clone(),
			"craPerio"));
		}
		if(eduMatriCurso.getPerdOidPeriFinaComp() != null){
			eduMatriCurso.setPerdOidPeriFinaComp((es.indra.belcorp.mso.CraPerioData)
			getSingleObject(BUSINESSID_PERDOIDPERIFINACOMP_QUERY, 
			eduMatriCurso.getPerdOidPeriFinaComp(),
			eduMatriCurso.getPerdOidPeriFinaComp().clone(),
			"craPerio"));
		}
		if(eduMatriCurso.getPerdOidPeriInicCons() != null){
			eduMatriCurso.setPerdOidPeriInicCons((es.indra.belcorp.mso.CraPerioData)
			getSingleObject(BUSINESSID_PERDOIDPERIINICCONS_QUERY, 
			eduMatriCurso.getPerdOidPeriInicCons(),
			eduMatriCurso.getPerdOidPeriInicCons().clone(),
			"craPerio"));
		}
		if(eduMatriCurso.getPerdOidPeriFinaCons() != null){
			eduMatriCurso.setPerdOidPeriFinaCons((es.indra.belcorp.mso.CraPerioData)
			getSingleObject(BUSINESSID_PERDOIDPERIFINACONS_QUERY, 
			eduMatriCurso.getPerdOidPeriFinaCons(),
			eduMatriCurso.getPerdOidPeriFinaCons().clone(),
			"craPerio"));
		}
		if(eduMatriCurso.getPerdOidPeriIngr() != null){
			eduMatriCurso.setPerdOidPeriIngr((es.indra.belcorp.mso.CraPerioData)
			getSingleObject(BUSINESSID_PERDOIDPERIINGR_QUERY, 
			eduMatriCurso.getPerdOidPeriIngr(),
			eduMatriCurso.getPerdOidPeriIngr().clone(),
			"craPerio"));
		}
		if(eduMatriCurso.getTicuOidTipoCurs() != null){
			eduMatriCurso.setTicuOidTipoCurs((es.indra.belcorp.mso.EduTipoCursoData)
			getSingleObject(BUSINESSID_TICUOIDTIPOCURS_QUERY, 
			eduMatriCurso.getTicuOidTipoCurs(),
			eduMatriCurso.getTicuOidTipoCurs().clone(),
			"eduTipoCurso"));
		}
		if(eduMatriCurso.getClclOidClieClasCapa() != null){
			eduMatriCurso.setClclOidClieClasCapa((es.indra.belcorp.mso.MaeClienClasiData)
			getSingleObject(BUSINESSID_CLCLOIDCLIECLASCAPA_QUERY, 
			eduMatriCurso.getClclOidClieClasCapa(),
			eduMatriCurso.getClclOidClieClasCapa().clone(),
			"maeClienClasi"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(eduMatriCurso);
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
	
	/**
	*	Este método nos permite eliminar los labels del modo view de la pantalla
	*/
	protected void removeViewLabels() throws Exception{
		borrarNodo("TR", "nombre", "idViewLabelTrId");
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneAltViewLabelTrId");
		borrarNodo("TR", "nombre", "paisOidPais_fopaOidFormPagoViewLabelTrId");
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneViewLabelTrId");
		borrarNodo("TR", "nombre", "paisOidPaisViewLabelTrId");
		borrarNodo("TR", "nombre", "cplcOidCabePlanCursViewLabelTrId");
		borrarNodo("TR", "nombre", "codCursViewLabelTrId");
		borrarNodo("TR", "nombre", "terrOidTerrViewLabelTrId");
		borrarNodo("TR", "nombre", "clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClieViewLabelTrId");
		borrarNodo("TR", "nombre", "clasOidClas_tcclOidTipoClas_sbtiOidSubtClieViewLabelTrId");
		borrarNodo("TR", "nombre", "clasOidClas_tcclOidTipoClasViewLabelTrId");
		borrarNodo("TR", "nombre", "clasOidClasViewLabelTrId");
		borrarNodo("TR", "nombre", "frcuOidFrecViewLabelTrId");
		borrarNodo("TR", "nombre", "regaOidRega_prodOidProdViewLabelTrId");
		borrarNodo("TR", "nombre", "regaOidRegaViewLabelTrId");
		borrarNodo("TR", "nombre", "zsgvOidSubgVentViewLabelTrId");
		borrarNodo("TR", "nombre", "zorgOidRegiViewLabelTrId");
		borrarNodo("TR", "nombre", "zzonOidZonaViewLabelTrId");
		borrarNodo("TR", "nombre", "zsccOidSeccViewLabelTrId");
		borrarNodo("TR", "nombre", "ztadOidTerrAdmiViewLabelTrId");
		borrarNodo("TR", "nombre", "perdOidPeriInicCompViewLabelTrId");
		borrarNodo("TR", "nombre", "perdOidPeriFinaCompViewLabelTrId");
		borrarNodo("TR", "nombre", "perdOidPeriInicConsViewLabelTrId");
		borrarNodo("TR", "nombre", "perdOidPeriFinaConsViewLabelTrId");
		borrarNodo("TR", "nombre", "perdOidPeriIngrViewLabelTrId");
		borrarNodo("TR", "nombre", "ticuOidTipoCurs_marcOidMarcViewLabelTrId");
		borrarNodo("TR", "nombre", "ticuOidTipoCursViewLabelTrId");
		borrarNodo("TR", "nombre", "valPathFichViewLabelTrId");
		borrarNodo("TR", "nombre", "valObjeCursViewLabelTrId");
		borrarNodo("TR", "nombre", "valContCursViewLabelTrId");
		borrarNodo("TR", "nombre", "valRelaMateCursViewLabelTrId");
		borrarNodo("TR", "nombre", "valMontVentViewLabelTrId");
		borrarNodo("TR", "nombre", "fecDispCursViewLabelTrId");
		borrarNodo("TR", "nombre", "fecLanzViewLabelTrId");
		borrarNodo("TR", "nombre", "fecFinCursViewLabelTrId");
		borrarNodo("TR", "nombre", "fecUltiCursViewLabelTrId");
		borrarNodo("TR", "nombre", "fecConcCursViewLabelTrId");
		borrarNodo("TR", "nombre", "fecIngrViewLabelTrId");
		borrarNodo("TR", "nombre", "numPartViewLabelTrId");
		borrarNodo("TR", "nombre", "numOrdeViewLabelTrId");
		borrarNodo("TR", "nombre", "numCampaViewLabelTrId");
		borrarNodo("TR", "nombre", "numUnidViewLabelTrId");
		borrarNodo("TR", "nombre", "desCursViewLabelTrId");
		borrarNodo("TR", "nombre", "indAcceDmrtViewLabelTrId");
		borrarNodo("TR", "nombre", "indAcceInfoViewLabelTrId");
		borrarNodo("TR", "nombre", "indAlcaGeogViewLabelTrId");
		borrarNodo("TR", "nombre", "indBloqExteViewLabelTrId");
		borrarNodo("TR", "nombre", "indMomeEntrViewLabelTrId");
		borrarNodo("TR", "nombre", "indCondPediViewLabelTrId");
		borrarNodo("TR", "nombre", "indCtrlMoroViewLabelTrId");
		borrarNodo("TR", "nombre", "indCtrlFuncViewLabelTrId");
		borrarNodo("TR", "nombre", "clclOidClieClasCapaViewLabelTrId");
		
	}

	/**
	*	Nos permite borrar los TR que contienen los widgets de los campos
	*/
	protected void removeWidgets() throws Exception{
		borrarNodo("TR", "nombre", "idWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneAltWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPais_fopaOidFormPagoWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPaisWidgetTrId");
		borrarNodo("TR", "nombre", "cplcOidCabePlanCursWidgetTrId");
		borrarNodo("TR", "nombre", "codCursWidgetTrId");
		borrarNodo("TR", "nombre", "terrOidTerrWidgetTrId");
		borrarNodo("TR", "nombre", "clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClieWidgetTrId");
		borrarNodo("TR", "nombre", "clasOidClas_tcclOidTipoClas_sbtiOidSubtClieWidgetTrId");
		borrarNodo("TR", "nombre", "clasOidClas_tcclOidTipoClasWidgetTrId");
		borrarNodo("TR", "nombre", "clasOidClasWidgetTrId");
		borrarNodo("TR", "nombre", "frcuOidFrecWidgetTrId");
		borrarNodo("TR", "nombre", "regaOidRega_prodOidProdWidgetTrId");
		borrarNodo("TR", "nombre", "regaOidRegaWidgetTrId");
		borrarNodo("TR", "nombre", "zsgvOidSubgVentWidgetTrId");
		borrarNodo("TR", "nombre", "zorgOidRegiWidgetTrId");
		borrarNodo("TR", "nombre", "zzonOidZonaWidgetTrId");
		borrarNodo("TR", "nombre", "zsccOidSeccWidgetTrId");
		borrarNodo("TR", "nombre", "ztadOidTerrAdmiWidgetTrId");
		borrarNodo("TR", "nombre", "perdOidPeriInicCompWidgetTrId");
		borrarNodo("TR", "nombre", "perdOidPeriFinaCompWidgetTrId");
		borrarNodo("TR", "nombre", "perdOidPeriInicConsWidgetTrId");
		borrarNodo("TR", "nombre", "perdOidPeriFinaConsWidgetTrId");
		borrarNodo("TR", "nombre", "perdOidPeriIngrWidgetTrId");
		borrarNodo("TR", "nombre", "ticuOidTipoCurs_marcOidMarcWidgetTrId");
		borrarNodo("TR", "nombre", "ticuOidTipoCursWidgetTrId");
		borrarNodo("TR", "nombre", "valPathFichWidgetTrId");
		borrarNodo("TR", "nombre", "valObjeCursWidgetTrId");
		borrarNodo("TR", "nombre", "valContCursWidgetTrId");
		borrarNodo("TR", "nombre", "valRelaMateCursWidgetTrId");
		borrarNodo("TR", "nombre", "valMontVentWidgetTrId");
		borrarNodo("TR", "nombre", "fecDispCursWidgetTrId");
		borrarNodo("TR", "nombre", "fecLanzWidgetTrId");
		borrarNodo("TR", "nombre", "fecFinCursWidgetTrId");
		borrarNodo("TR", "nombre", "fecUltiCursWidgetTrId");
		borrarNodo("TR", "nombre", "fecConcCursWidgetTrId");
		borrarNodo("TR", "nombre", "fecIngrWidgetTrId");
		borrarNodo("TR", "nombre", "numPartWidgetTrId");
		borrarNodo("TR", "nombre", "numOrdeWidgetTrId");
		borrarNodo("TR", "nombre", "numCampaWidgetTrId");
		borrarNodo("TR", "nombre", "numUnidWidgetTrId");
		borrarNodo("TR", "nombre", "desCursWidgetTrId");
		borrarNodo("TR", "nombre", "indAcceDmrtWidgetTrId");
		borrarNodo("TR", "nombre", "indAcceInfoWidgetTrId");
		borrarNodo("TR", "nombre", "indAlcaGeogWidgetTrId");
		borrarNodo("TR", "nombre", "indBloqExteWidgetTrId");
		borrarNodo("TR", "nombre", "indMomeEntrWidgetTrId");
		borrarNodo("TR", "nombre", "indCondPediWidgetTrId");
		borrarNodo("TR", "nombre", "indCtrlMoroWidgetTrId");
		borrarNodo("TR", "nombre", "indCtrlFuncWidgetTrId");
		borrarNodo("TR", "nombre", "clclOidClieClasCapaWidgetTrId");
		
	}
}







