/*
    INDRA/CAR/mmg
    $Id: CccMovimBancaLPStartUp.java,v 1.1 2009/12/03 18:42:16 pecbazalar Exp $
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
public class CccMovimBancaLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 1343;
	public static final short CREATEFORM_SIZE = 1343;
	public static final short UPDATEFORM_SIZE = 1343;
	public static final short VIEWFORM_SIZE = 1343;

	//Cosntantes que definene elementos de la lçogica de negocio de las entidada
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGCccMovimBancaQueryFromToUserPage";
	public static final String BUSINESSID_SOCIOIDSOCI_QUERY ="MMGSegSocieQueryFromToUser";public static final String SOCIOIDSOCI_COMBO_CONNECTOR = "SegSocieConectorCombo";
	public static final String BUSINESSID_SUBPOIDMARCULTI_CCPROIDPROC_QUERY ="MMGCccProceQueryFromToUser";public static final String BUSINESSID_SUBPOIDMARCULTI_QUERY ="MMGCccSubprQueryFromToUser";public static final String SUBPOIDMARCULTI_CCPROIDPROC_COMBO_CONNECTOR = "CccProceConectorCombo";
	public static final String SUBPOIDMARCULTI_COMBO_CONNECTOR = "CccSubprConectorCombo";
	public static final String BUSINESSID_SUBPOIDMARCCREA_CCPROIDPROC_QUERY ="MMGCccProceQueryFromToUser";public static final String BUSINESSID_SUBPOIDMARCCREA_QUERY ="MMGCccSubprQueryFromToUser";public static final String SUBPOIDMARCCREA_CCPROIDPROC_COMBO_CONNECTOR = "CccProceConectorCombo";
	public static final String SUBPOIDMARCCREA_COMBO_CONNECTOR = "CccSubprConectorCombo";
	public static final String BUSINESSID_TCABOIDABONULTI_QUERY ="MMGCccTipoCargoAbonoQueryFromToUser";public static final String TCABOIDABONULTI_COMBO_CONNECTOR = "CccTipoCargoAbonoConectorCombo";
	public static final String BUSINESSID_TCABOIDABONCREA_QUERY ="MMGCccTipoCargoAbonoQueryFromToUser";public static final String TCABOIDABONCREA_COMBO_CONNECTOR = "CccTipoCargoAbonoConectorCombo";
	public static final String BUSINESSID_TTRAOIDTIPOTRANS_QUERY ="MMGCccTipoTransQueryFromToUser";public static final String TTRAOIDTIPOTRANS_COMBO_CONNECTOR = "CccTipoTransConectorCombo";
	public static final String BUSINESSID_CCBAOIDCCBANC_CUCOOIDCCPNTE_QUERY ="MMGCccCuentContaQueryFromToUser";public static final String BUSINESSID_CCBAOIDCCBANC_CUCOOIDCCTESO_QUERY ="MMGCccCuentContaQueryFromToUser";public static final String BUSINESSID_CCBAOIDCCBANC_SUCUOIDSUCU_CBANOIDBANC_QUERY ="MMGCccBancoQueryFromToUser";public static final String BUSINESSID_CCBAOIDCCBANC_SUCUOIDSUCU_QUERY ="MMGCccSucurQueryFromToUser";public static final String BUSINESSID_CCBAOIDCCBANC_SOCIOIDSOCI_QUERY ="MMGSegSocieQueryFromToUser";public static final String BUSINESSID_CCBAOIDCCBANC_QUERY ="MMGCccCuentCorriBancaQueryFromToUser";public static final String CCBAOIDCCBANC_CUCOOIDCCPNTE_COMBO_CONNECTOR = "CccCuentContaConectorCombo";
	public static final String CCBAOIDCCBANC_CUCOOIDCCTESO_COMBO_CONNECTOR = "CccCuentContaConectorCombo";
	public static final String CCBAOIDCCBANC_SUCUOIDSUCU_CBANOIDBANC_COMBO_CONNECTOR = "CccBancoConectorCombo";
	public static final String CCBAOIDCCBANC_SUCUOIDSUCU_COMBO_CONNECTOR = "CccSucurConectorCombo";
	public static final String CCBAOIDCCBANC_SOCIOIDSOCI_COMBO_CONNECTOR = "SegSocieConectorCombo";
	public static final String CCBAOIDCCBANC_COMBO_CONNECTOR = "CccCuentCorriBancaConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public CccMovimBancaLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("CccMovimBancaPage");
	}

	public void ejecucion() throws Exception {
		try{
			//Llamamos al metodo sobresctrito de la clase padre para ejecutar las acciones comunes:
			//obtener configuración del mantenimiento
			super.ejecucion();
		
			//Activamos las trazas
			setTrazaFichero();
			
			//Establecemos el tamaño de la página
			buildJsPageSize("CccMovimBanca");
			
			
		
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "CccMovimBancaPage", "cod", "CccMovimBanca." + accion + ".label");
			
			//Ponemos en la página el idioma de usuario, el idioma de la pagina para mostrar los errores, 
			//y el codigo del idioma por defecto
			asignar("VAR", VAR_IDIOMA, MMGDruidaHelper.getUserDefaultLanguage(this));
			asignar("VAR", VAR_IDIOMA_XML, MMGDruidaHelper.getIdioma(this));
			asignar("VAR", VAR_DEFAULT_LANGUAGE_CODE, MMGDruidaHelper.getUserDefaultLanguage(this));
			
			//Establecemos los tamaños y posiciones de la capas de la pantalla
			establecerSizeCapas(accion, origen);
			
			//Limpiamos la botonera
			limpiarBotoneraLista("cccMovimBanca", accion);
			
			
			
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
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "numConsTran", "validacion", "ValidaInt(cdos_trim(valor), 10, 0, 9999999999)");
		asignarAtributo("TEXT", "numLote", "validacion", "ValidaInt(cdos_trim(valor), 5, 0, 99999)");
		asignarAtributo("TEXT", "codCons", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "codConsReal", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "codErro", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDigiCheqFact", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "valDocuApliAnio", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuApliMesSeri", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuApliNume", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valDocuCreaAnio", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuCreaMesSeri", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuCreaNume", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valEstaMoviPend", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "fecCont", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecPago", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valHoraProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valHoraNormAdic", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "codIdenProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "impPago", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(15 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((15 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "valNombOfic", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "numCupo", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valNumeDocu", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "numFactBole", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valNumeLoteCont", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 20)");
		asignarAtributo("TEXT", "valObse", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		asignarAtributo("TEXT", "codOficReca", "validacion", "ValidaInt(cdos_trim(valor), 5, 0, 99999)");
		asignarAtributo("TEXT", "valUsuaProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 10)");
		asignarAtributo("TEXT", "fecMoviApli", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		

		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "cccMovimBancaLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "CccMovimBancaPage", "onblur", "window.focus();");
		
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
		conectorAction("CccMovimBancaLPStartUp");
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
		CccMovimBancaData cccMovimBancaQuery= new CccMovimBancaData();
		cccMovimBancaQuery.setId(new Integer(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		CccMovimBancaData datosResult = (CccMovimBancaData)getSingleObject(BUSINESSID_QUERY, cccMovimBancaQuery, 
			cccMovimBancaQuery.clone(), "cccMovimBanca");
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		setDependenceComboLabels(datosResult);
		
		//Damos los valores a los labels del modo view
		CccMovimBancaData cccMovimBanca = datosResult;
	
	
	
	
	
	
	
		asignarAtributo("LABELC", "lblViewNumConsTran", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getNumConsTran(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewNumLote", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getNumLote(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewCodCons", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getCodCons(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewCodConsReal", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getCodConsReal(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewCodErro", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getCodErro(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValDigiCheqFact", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getValDigiCheqFact(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValDocuApliAnio", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getValDocuApliAnio(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValDocuApliMesSeri", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getValDocuApliMesSeri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValDocuApliNume", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getValDocuApliNume(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValDocuCreaAnio", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getValDocuCreaAnio(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValDocuCreaMesSeri", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getValDocuCreaMesSeri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValDocuCreaNume", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getValDocuCreaNume(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValEstaMoviPend", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getValEstaMoviPend(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewFecCont", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getFecCont(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewFecPago", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getFecPago(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewFecProc", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getFecProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValHoraProc", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getValHoraProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValHoraNormAdic", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getValHoraNormAdic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewCodIdenProc", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getCodIdenProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewImpPago", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getImpPago(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValNombOfic", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getValNombOfic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewNumCupo", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getNumCupo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValNumeDocu", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getValNumeDocu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewNumFactBole", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getNumFactBole(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValNumeLoteCont", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getValNumeLoteCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValObse", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewCodOficReca", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getCodOficReca(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValUsuaProc", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getValUsuaProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewFecMoviApli", "valor", 
				FormatUtils.formatObject(cccMovimBanca.getFecMoviApli(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
	
	
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
		asignarAtributo("COMBO", "sociOidSoci", "req", "S");
		asignarAtributo("COMBO", "ttraOidTipoTrans", "req", "S");
		asignarAtributo("COMBO", "ccbaOidCcBanc", "req", "S");
		asignarAtributo("TEXT", "numConsTran", "req", "S");
		asignarAtributo("TEXT", "numLote", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el 
		//valor del idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "numConsTran", "validacion", "ValidaInt(cdos_trim(valor), 10, 0, 9999999999)");
		asignarAtributo("TEXT", "numLote", "validacion", "ValidaInt(cdos_trim(valor), 5, 0, 99999)");
		asignarAtributo("TEXT", "codCons", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "codConsReal", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "codErro", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDigiCheqFact", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "valDocuApliAnio", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuApliMesSeri", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuApliNume", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valDocuCreaAnio", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuCreaMesSeri", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuCreaNume", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valEstaMoviPend", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "fecCont", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecPago", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valHoraProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valHoraNormAdic", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "codIdenProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "impPago", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(15 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((15 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "valNombOfic", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "numCupo", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valNumeDocu", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "numFactBole", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valNumeLoteCont", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 20)");
		asignarAtributo("TEXT", "valObse", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		asignarAtributo("TEXT", "codOficReca", "validacion", "ValidaInt(cdos_trim(valor), 5, 0, 99999)");
		asignarAtributo("TEXT", "valUsuaProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 10)");
		asignarAtributo("TEXT", "fecMoviApli", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		
		
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
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "numConsTran", "validacion", "ValidaInt(cdos_trim(valor), 10, 0, 9999999999)");
		asignarAtributo("TEXT", "numLote", "validacion", "ValidaInt(cdos_trim(valor), 5, 0, 99999)");
		asignarAtributo("TEXT", "codCons", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "codConsReal", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "codErro", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDigiCheqFact", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "valDocuApliAnio", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuApliMesSeri", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuApliNume", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valDocuCreaAnio", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuCreaMesSeri", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuCreaNume", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valEstaMoviPend", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "fecCont", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecPago", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valHoraProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valHoraNormAdic", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "codIdenProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "impPago", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(15 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((15 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "valNombOfic", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "numCupo", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valNumeDocu", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "numFactBole", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valNumeLoteCont", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 20)");
		asignarAtributo("TEXT", "valObse", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		asignarAtributo("TEXT", "codOficReca", "validacion", "ValidaInt(cdos_trim(valor), 5, 0, 99999)");
		asignarAtributo("TEXT", "valUsuaProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 10)");
		asignarAtributo("TEXT", "fecMoviApli", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		
		
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
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "numConsTran", "validacion", "ValidaInt(cdos_trim(valor), 10, 0, 9999999999)");
		asignarAtributo("TEXT", "numLote", "validacion", "ValidaInt(cdos_trim(valor), 5, 0, 99999)");
		asignarAtributo("TEXT", "codCons", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "codConsReal", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "codErro", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDigiCheqFact", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "valDocuApliAnio", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuApliMesSeri", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuApliNume", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valDocuCreaAnio", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuCreaMesSeri", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuCreaNume", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valEstaMoviPend", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "fecCont", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecPago", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valHoraProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valHoraNormAdic", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "codIdenProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "impPago", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(15 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((15 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "valNombOfic", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "numCupo", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valNumeDocu", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "numFactBole", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valNumeLoteCont", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 20)");
		asignarAtributo("TEXT", "valObse", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		asignarAtributo("TEXT", "codOficReca", "validacion", "ValidaInt(cdos_trim(valor), 5, 0, 99999)");
		asignarAtributo("TEXT", "valUsuaProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 10)");
		asignarAtributo("TEXT", "fecMoviApli", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		
		
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
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "numConsTran", "validacion", "ValidaInt(cdos_trim(valor), 10, 0, 9999999999)");
		asignarAtributo("TEXT", "numLote", "validacion", "ValidaInt(cdos_trim(valor), 5, 0, 99999)");
		asignarAtributo("TEXT", "codCons", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "codConsReal", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "codErro", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDigiCheqFact", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "valDocuApliAnio", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuApliMesSeri", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuApliNume", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valDocuCreaAnio", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuCreaMesSeri", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuCreaNume", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valEstaMoviPend", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "fecCont", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecPago", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valHoraProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valHoraNormAdic", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "codIdenProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "impPago", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(15 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((15 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "valNombOfic", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "numCupo", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valNumeDocu", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "numFactBole", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valNumeLoteCont", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 20)");
		asignarAtributo("TEXT", "valObse", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		asignarAtributo("TEXT", "codOficReca", "validacion", "ValidaInt(cdos_trim(valor), 5, 0, 99999)");
		asignarAtributo("TEXT", "valUsuaProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 10)");
		asignarAtributo("TEXT", "fecMoviApli", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		
		
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
		conectorAction("CccMovimBancaLPStartUp");
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
		//asignarAtributo("FORMULARIO", "cccMovimBancaFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		asignarAtributo("COMBO", "sociOidSoci", "req", "S");
		asignarAtributo("COMBO", "ttraOidTipoTrans", "req", "S");
		asignarAtributo("COMBO", "ccbaOidCcBanc", "req", "S");
		asignarAtributo("TEXT", "numConsTran", "req", "S");
		asignarAtributo("TEXT", "numLote", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el valor
		//para el idioma por defecto
		
		

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "numConsTran", "validacion", "ValidaInt(cdos_trim(valor), 10, 0, 9999999999)");
		asignarAtributo("TEXT", "numLote", "validacion", "ValidaInt(cdos_trim(valor), 5, 0, 99999)");
		asignarAtributo("TEXT", "codCons", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "codConsReal", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "codErro", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDigiCheqFact", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "valDocuApliAnio", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuApliMesSeri", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuApliNume", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valDocuCreaAnio", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuCreaMesSeri", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valDocuCreaNume", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valEstaMoviPend", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "fecCont", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecPago", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valHoraProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "valHoraNormAdic", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "codIdenProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "impPago", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(15 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((15 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "valNombOfic", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 30)");
		asignarAtributo("TEXT", "numCupo", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valNumeDocu", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 15)");
		asignarAtributo("TEXT", "numFactBole", "validacion", "ValidaInt(cdos_trim(valor), 8, 0, 99999999)");
		asignarAtributo("TEXT", "valNumeLoteCont", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 20)");
		asignarAtributo("TEXT", "valObse", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		asignarAtributo("TEXT", "codOficReca", "validacion", "ValidaInt(cdos_trim(valor), 5, 0, 99999)");
		asignarAtributo("TEXT", "valUsuaProc", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 10)");
		asignarAtributo("TEXT", "fecMoviApli", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando CccMovimBanca");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		CccMovimBancaData cccMovimBancaQuery= new CccMovimBancaData();
		cccMovimBancaQuery.setId(new Integer(id));

		//Sacamos de la base de datos la entidad a modificar
		CccMovimBancaData  datosResult = (CccMovimBancaData)getSingleObject(BUSINESSID_QUERY, cccMovimBancaQuery, 
			cccMovimBancaQuery.clone(), "cccMovimBanca");

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos();
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		CccMovimBancaData cccMovimBanca = datosResult;
		asignar("VAR", "idSelection", id);
		es.indra.belcorp.mso.SegSocieData sociOidSoci = cccMovimBanca.getSociOidSoci();
		if(sociOidSoci != null && sociOidSoci.getId() != null) checkCombo("sociOidSoci" , sociOidSoci.getId().toString());
	
		es.indra.belcorp.mso.CccSubprData subpOidMarcUlti = cccMovimBanca.getSubpOidMarcUlti();
		if(subpOidMarcUlti != null && subpOidMarcUlti.getId() != null) checkCombo("subpOidMarcUlti" , subpOidMarcUlti.getId().toString());
	
		es.indra.belcorp.mso.CccSubprData subpOidMarcCrea = cccMovimBanca.getSubpOidMarcCrea();
		if(subpOidMarcCrea != null && subpOidMarcCrea.getId() != null) checkCombo("subpOidMarcCrea" , subpOidMarcCrea.getId().toString());
	
		es.indra.belcorp.mso.CccTipoCargoAbonoData tcabOidAbonUlti = cccMovimBanca.getTcabOidAbonUlti();
		if(tcabOidAbonUlti != null && tcabOidAbonUlti.getId() != null) checkCombo("tcabOidAbonUlti" , tcabOidAbonUlti.getId().toString());
	
		es.indra.belcorp.mso.CccTipoCargoAbonoData tcabOidAbonCrea = cccMovimBanca.getTcabOidAbonCrea();
		if(tcabOidAbonCrea != null && tcabOidAbonCrea.getId() != null) checkCombo("tcabOidAbonCrea" , tcabOidAbonCrea.getId().toString());
	
		es.indra.belcorp.mso.CccTipoTransData ttraOidTipoTrans = cccMovimBanca.getTtraOidTipoTrans();
		if(ttraOidTipoTrans != null && ttraOidTipoTrans.getId() != null) checkCombo("ttraOidTipoTrans" , ttraOidTipoTrans.getId().toString());
	
		es.indra.belcorp.mso.CccCuentCorriBancaData ccbaOidCcBanc = cccMovimBanca.getCcbaOidCcBanc();
		if(ccbaOidCcBanc != null && ccbaOidCcBanc.getId() != null) checkCombo("ccbaOidCcBanc" , ccbaOidCcBanc.getId().toString());
	
		asignar("TEXT", "numConsTran", FormatUtils.formatObject(cccMovimBanca.getNumConsTran(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "numLote", FormatUtils.formatObject(cccMovimBanca.getNumLote(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "codCons", FormatUtils.formatObject(cccMovimBanca.getCodCons(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "codConsReal", FormatUtils.formatObject(cccMovimBanca.getCodConsReal(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "codErro", FormatUtils.formatObject(cccMovimBanca.getCodErro(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valDigiCheqFact", FormatUtils.formatObject(cccMovimBanca.getValDigiCheqFact(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valDocuApliAnio", FormatUtils.formatObject(cccMovimBanca.getValDocuApliAnio(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valDocuApliMesSeri", FormatUtils.formatObject(cccMovimBanca.getValDocuApliMesSeri(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valDocuApliNume", FormatUtils.formatObject(cccMovimBanca.getValDocuApliNume(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valDocuCreaAnio", FormatUtils.formatObject(cccMovimBanca.getValDocuCreaAnio(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valDocuCreaMesSeri", FormatUtils.formatObject(cccMovimBanca.getValDocuCreaMesSeri(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valDocuCreaNume", FormatUtils.formatObject(cccMovimBanca.getValDocuCreaNume(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valEstaMoviPend", FormatUtils.formatObject(cccMovimBanca.getValEstaMoviPend(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "fecCont", FormatUtils.formatObject(cccMovimBanca.getFecCont(), 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "fecPago", FormatUtils.formatObject(cccMovimBanca.getFecPago(), 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "fecProc", FormatUtils.formatObject(cccMovimBanca.getFecProc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valHoraProc", FormatUtils.formatObject(cccMovimBanca.getValHoraProc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valHoraNormAdic", FormatUtils.formatObject(cccMovimBanca.getValHoraNormAdic(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "codIdenProc", FormatUtils.formatObject(cccMovimBanca.getCodIdenProc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "impPago", FormatUtils.formatObject(cccMovimBanca.getImpPago(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valNombOfic", FormatUtils.formatObject(cccMovimBanca.getValNombOfic(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "numCupo", FormatUtils.formatObject(cccMovimBanca.getNumCupo(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valNumeDocu", FormatUtils.formatObject(cccMovimBanca.getValNumeDocu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "numFactBole", FormatUtils.formatObject(cccMovimBanca.getNumFactBole(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valNumeLoteCont", FormatUtils.formatObject(cccMovimBanca.getValNumeLoteCont(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valObse", FormatUtils.formatObject(cccMovimBanca.getValObse(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "codOficReca", FormatUtils.formatObject(cccMovimBanca.getCodOficReca(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valUsuaProc", FormatUtils.formatObject(cccMovimBanca.getValUsuaProc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "fecMoviApli", FormatUtils.formatObject(cccMovimBanca.getFecMoviApli(), 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
	

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(cccMovimBanca.jdoGetTimeStamp()));
		
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
		borrarNodo("TD","nombre","cccMovimBancaTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","cccMovimBancaTrButtons");

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
		asignarAtributo("CAPA","cccMovimBancaFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","cccMovimBancaPreListLayer", "y", String.valueOf(sizeForm + 24));
		asignarAtributo("CAPA","cccMovimBancaListLayer", "y", String.valueOf(sizeForm + 46));		
		asignarAtributo("CAPA","cccMovimBancaListButtonsLayer", "y", String.valueOf(sizeForm + 299));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos() throws Exception{
		asignarComboResultados(BUSINESSID_SOCIOIDSOCI_QUERY,SOCIOIDSOCI_COMBO_CONNECTOR, new SegSocieData(), new SegSocieData(), "segSocie", "sociOidSoci", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_SUBPOIDMARCULTI_CCPROIDPROC_QUERY,SUBPOIDMARCULTI_CCPROIDPROC_COMBO_CONNECTOR, new CccProceData(), new CccProceData(), "cccProce", "subpOidMarcUlti_ccprOidProc", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_SUBPOIDMARCCREA_CCPROIDPROC_QUERY,SUBPOIDMARCCREA_CCPROIDPROC_COMBO_CONNECTOR, new CccProceData(), new CccProceData(), "cccProce", "subpOidMarcCrea_ccprOidProc", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_TCABOIDABONULTI_QUERY,TCABOIDABONULTI_COMBO_CONNECTOR, new CccTipoCargoAbonoData(), new CccTipoCargoAbonoData(), "cccTipoCargoAbono", "tcabOidAbonUlti", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_TCABOIDABONCREA_QUERY,TCABOIDABONCREA_COMBO_CONNECTOR, new CccTipoCargoAbonoData(), new CccTipoCargoAbonoData(), "cccTipoCargoAbono", "tcabOidAbonCrea", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_TTRAOIDTIPOTRANS_QUERY,TTRAOIDTIPOTRANS_COMBO_CONNECTOR, new CccTipoTransData(), new CccTipoTransData(), "cccTipoTrans", "ttraOidTipoTrans", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_CCBAOIDCCBANC_CUCOOIDCCPNTE_QUERY,CCBAOIDCCBANC_CUCOOIDCCPNTE_COMBO_CONNECTOR, new CccCuentContaData(), new CccCuentContaData(), "cccCuentConta", "ccbaOidCcBanc_cucoOidCcPnte", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_CCBAOIDCCBANC_CUCOOIDCCTESO_QUERY,CCBAOIDCCBANC_CUCOOIDCCTESO_COMBO_CONNECTOR, new CccCuentContaData(), new CccCuentContaData(), "cccCuentConta", "ccbaOidCcBanc_cucoOidCcTeso", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_CCBAOIDCCBANC_SUCUOIDSUCU_CBANOIDBANC_QUERY,CCBAOIDCCBANC_SUCUOIDSUCU_CBANOIDBANC_COMBO_CONNECTOR, new CccBancoData(), new CccBancoData(), "cccBanco", "ccbaOidCcBanc_sucuOidSucu_cbanOidBanc", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_CCBAOIDCCBANC_SOCIOIDSOCI_QUERY,CCBAOIDCCBANC_SOCIOIDSOCI_COMBO_CONNECTOR, new SegSocieData(), new SegSocieData(), "segSocie", "ccbaOidCcBanc_sociOidSoci", "result_ROWSET" );
		
			
		//Seleccionamos en los combos de enitdades estructurales el valor asociado al usuario
		/*String sociOidSoci = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegSocie");
		if(sociOidSoci != null && !sociOidSoci.trim().equals("")) checkCombo("sociOidSoci", sociOidSoci);
		
		*/
	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param cccMovimBanca La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(CccMovimBancaData cccMovimBanca) 
		throws Exception{
		if(cccMovimBanca.getSociOidSoci() != null){
			checkCombo("sociOidSoci" , cccMovimBanca.getSociOidSoci().getId().toString());
			}
		if(cccMovimBanca.getSubpOidMarcUlti() != null){
			CccSubprData subpOidMarcUlti = new CccSubprData();
			subpOidMarcUlti.setCcprOidProc(cccMovimBanca.getSubpOidMarcUlti().getCcprOidProc());
			asignarComboResultados(BUSINESSID_SUBPOIDMARCULTI_QUERY,SUBPOIDMARCULTI_COMBO_CONNECTOR, subpOidMarcUlti, subpOidMarcUlti.clone(), "cccSubpr", "subpOidMarcUlti", "result_ROWSET");
			checkCombo("subpOidMarcUlti" , cccMovimBanca.getSubpOidMarcUlti().getId().toString());
			checkCombo("subpOidMarcUlti_ccprOidProc" , cccMovimBanca.getSubpOidMarcUlti().getCcprOidProc().getId().toString());
			}
		if(cccMovimBanca.getSubpOidMarcCrea() != null){
			CccSubprData subpOidMarcCrea = new CccSubprData();
			subpOidMarcCrea.setCcprOidProc(cccMovimBanca.getSubpOidMarcCrea().getCcprOidProc());
			asignarComboResultados(BUSINESSID_SUBPOIDMARCCREA_QUERY,SUBPOIDMARCCREA_COMBO_CONNECTOR, subpOidMarcCrea, subpOidMarcCrea.clone(), "cccSubpr", "subpOidMarcCrea", "result_ROWSET");
			checkCombo("subpOidMarcCrea" , cccMovimBanca.getSubpOidMarcCrea().getId().toString());
			checkCombo("subpOidMarcCrea_ccprOidProc" , cccMovimBanca.getSubpOidMarcCrea().getCcprOidProc().getId().toString());
			}
		if(cccMovimBanca.getTcabOidAbonUlti() != null){
			checkCombo("tcabOidAbonUlti" , cccMovimBanca.getTcabOidAbonUlti().getId().toString());
			}
		if(cccMovimBanca.getTcabOidAbonCrea() != null){
			checkCombo("tcabOidAbonCrea" , cccMovimBanca.getTcabOidAbonCrea().getId().toString());
			}
		if(cccMovimBanca.getTtraOidTipoTrans() != null){
			checkCombo("ttraOidTipoTrans" , cccMovimBanca.getTtraOidTipoTrans().getId().toString());
			}
		if(cccMovimBanca.getCcbaOidCcBanc() != null){
			CccCuentCorriBancaData ccbaOidCcBanc = new CccCuentCorriBancaData();
			ccbaOidCcBanc.setCucoOidCcPnte(cccMovimBanca.getCcbaOidCcBanc().getCucoOidCcPnte());
			ccbaOidCcBanc.setCucoOidCcTeso(cccMovimBanca.getCcbaOidCcBanc().getCucoOidCcTeso());
			ccbaOidCcBanc.setSucuOidSucu(cccMovimBanca.getCcbaOidCcBanc().getSucuOidSucu());
			ccbaOidCcBanc.setSociOidSoci(cccMovimBanca.getCcbaOidCcBanc().getSociOidSoci());
			asignarComboResultados(BUSINESSID_CCBAOIDCCBANC_QUERY,CCBAOIDCCBANC_COMBO_CONNECTOR, ccbaOidCcBanc, ccbaOidCcBanc.clone(), "cccCuentCorriBanca", "ccbaOidCcBanc", "result_ROWSET");
			checkCombo("ccbaOidCcBanc" , cccMovimBanca.getCcbaOidCcBanc().getId().toString());
			checkCombo("ccbaOidCcBanc_cucoOidCcPnte" , cccMovimBanca.getCcbaOidCcBanc().getCucoOidCcPnte().getId().toString());
			checkCombo("ccbaOidCcBanc_cucoOidCcTeso" , cccMovimBanca.getCcbaOidCcBanc().getCucoOidCcTeso().getId().toString());
			CccSucurData ccbaOidCcBanc_sucuOidSucu = new CccSucurData();
			ccbaOidCcBanc_sucuOidSucu.setCbanOidBanc(cccMovimBanca.getCcbaOidCcBanc().getSucuOidSucu().getCbanOidBanc());
			asignarComboResultados(BUSINESSID_CCBAOIDCCBANC_SUCUOIDSUCU_QUERY,CCBAOIDCCBANC_SUCUOIDSUCU_COMBO_CONNECTOR, ccbaOidCcBanc_sucuOidSucu, ccbaOidCcBanc_sucuOidSucu.clone(), "cccSucur", "ccbaOidCcBanc_sucuOidSucu", "result_ROWSET");
			checkCombo("ccbaOidCcBanc_sucuOidSucu" , cccMovimBanca.getCcbaOidCcBanc().getSucuOidSucu().getId().toString());
			checkCombo("ccbaOidCcBanc_sucuOidSucu_cbanOidBanc" , cccMovimBanca.getCcbaOidCcBanc().getSucuOidSucu().getCbanOidBanc().getId().toString());
			checkCombo("ccbaOidCcBanc_sociOidSoci" , cccMovimBanca.getCcbaOidCcBanc().getSociOidSoci().getId().toString());
			}
		
	}
	
	/**
	* Este método nos permite establecer el valor de los labels de una jerarquái de dependencia
	*/
	protected void setDependenceComboLabels(CccMovimBancaData cccMovimBanca) 
		throws Exception{
		asignarAtributo("LABELC", "lblViewSociOidSoci", "valor",FormatUtils.formatObject(cccMovimBanca.getSociOidSoci()));
		asignarAtributo("LABELC", "lblViewSubpOidMarcUlti_ccprOidProc", "valor",FormatUtils.formatObject(cccMovimBanca.getSubpOidMarcUlti().getCcprOidProc()));
		asignarAtributo("LABELC", "lblViewSubpOidMarcUlti", "valor",FormatUtils.formatObject(cccMovimBanca.getSubpOidMarcUlti()));
		asignarAtributo("LABELC", "lblViewSubpOidMarcCrea_ccprOidProc", "valor",FormatUtils.formatObject(cccMovimBanca.getSubpOidMarcCrea().getCcprOidProc()));
		asignarAtributo("LABELC", "lblViewSubpOidMarcCrea", "valor",FormatUtils.formatObject(cccMovimBanca.getSubpOidMarcCrea()));
		asignarAtributo("LABELC", "lblViewTcabOidAbonUlti", "valor",FormatUtils.formatObject(cccMovimBanca.getTcabOidAbonUlti()));
		asignarAtributo("LABELC", "lblViewTcabOidAbonCrea", "valor",FormatUtils.formatObject(cccMovimBanca.getTcabOidAbonCrea()));
		asignarAtributo("LABELC", "lblViewTtraOidTipoTrans", "valor",FormatUtils.formatObject(cccMovimBanca.getTtraOidTipoTrans()));
		asignarAtributo("LABELC", "lblViewCcbaOidCcBanc_cucoOidCcPnte", "valor",FormatUtils.formatObject(cccMovimBanca.getCcbaOidCcBanc().getCucoOidCcPnte()));
		asignarAtributo("LABELC", "lblViewCcbaOidCcBanc_cucoOidCcTeso", "valor",FormatUtils.formatObject(cccMovimBanca.getCcbaOidCcBanc().getCucoOidCcTeso()));
		asignarAtributo("LABELC", "lblViewCcbaOidCcBanc_sucuOidSucu_cbanOidBanc", "valor",FormatUtils.formatObject(cccMovimBanca.getCcbaOidCcBanc().getSucuOidSucu().getCbanOidBanc()));
		asignarAtributo("LABELC", "lblViewCcbaOidCcBanc_sucuOidSucu", "valor",FormatUtils.formatObject(cccMovimBanca.getCcbaOidCcBanc().getSucuOidSucu()));
		asignarAtributo("LABELC", "lblViewCcbaOidCcBanc_sociOidSoci", "valor",FormatUtils.formatObject(cccMovimBanca.getCcbaOidCcBanc().getSociOidSoci()));
		asignarAtributo("LABELC", "lblViewCcbaOidCcBanc", "valor",FormatUtils.formatObject(cccMovimBanca.getCcbaOidCcBanc()));
		
			
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		CccMovimBancaData cccMovimBanca = 
			(CccMovimBancaData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(cccMovimBanca.getSociOidSoci() != null){
			cccMovimBanca.setSociOidSoci((es.indra.belcorp.mso.SegSocieData)
			getSingleObject(BUSINESSID_SOCIOIDSOCI_QUERY, 
			cccMovimBanca.getSociOidSoci(),
			cccMovimBanca.getSociOidSoci().clone(),
			"segSocie"));
		}
		if(cccMovimBanca.getSubpOidMarcUlti() != null){
			cccMovimBanca.setSubpOidMarcUlti((es.indra.belcorp.mso.CccSubprData)
			getSingleObject(BUSINESSID_SUBPOIDMARCULTI_QUERY, 
			cccMovimBanca.getSubpOidMarcUlti(),
			cccMovimBanca.getSubpOidMarcUlti().clone(),
			"cccSubpr"));
		}
		if(cccMovimBanca.getSubpOidMarcCrea() != null){
			cccMovimBanca.setSubpOidMarcCrea((es.indra.belcorp.mso.CccSubprData)
			getSingleObject(BUSINESSID_SUBPOIDMARCCREA_QUERY, 
			cccMovimBanca.getSubpOidMarcCrea(),
			cccMovimBanca.getSubpOidMarcCrea().clone(),
			"cccSubpr"));
		}
		if(cccMovimBanca.getTcabOidAbonUlti() != null){
			cccMovimBanca.setTcabOidAbonUlti((es.indra.belcorp.mso.CccTipoCargoAbonoData)
			getSingleObject(BUSINESSID_TCABOIDABONULTI_QUERY, 
			cccMovimBanca.getTcabOidAbonUlti(),
			cccMovimBanca.getTcabOidAbonUlti().clone(),
			"cccTipoCargoAbono"));
		}
		if(cccMovimBanca.getTcabOidAbonCrea() != null){
			cccMovimBanca.setTcabOidAbonCrea((es.indra.belcorp.mso.CccTipoCargoAbonoData)
			getSingleObject(BUSINESSID_TCABOIDABONCREA_QUERY, 
			cccMovimBanca.getTcabOidAbonCrea(),
			cccMovimBanca.getTcabOidAbonCrea().clone(),
			"cccTipoCargoAbono"));
		}
		if(cccMovimBanca.getTtraOidTipoTrans() != null){
			cccMovimBanca.setTtraOidTipoTrans((es.indra.belcorp.mso.CccTipoTransData)
			getSingleObject(BUSINESSID_TTRAOIDTIPOTRANS_QUERY, 
			cccMovimBanca.getTtraOidTipoTrans(),
			cccMovimBanca.getTtraOidTipoTrans().clone(),
			"cccTipoTrans"));
		}
		if(cccMovimBanca.getCcbaOidCcBanc() != null){
			cccMovimBanca.setCcbaOidCcBanc((es.indra.belcorp.mso.CccCuentCorriBancaData)
			getSingleObject(BUSINESSID_CCBAOIDCCBANC_QUERY, 
			cccMovimBanca.getCcbaOidCcBanc(),
			cccMovimBanca.getCcbaOidCcBanc().clone(),
			"cccCuentCorriBanca"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(cccMovimBanca);
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
		borrarNodo("TR", "nombre", "sociOidSociViewLabelTrId");
		borrarNodo("TR", "nombre", "subpOidMarcUlti_ccprOidProcViewLabelTrId");
		borrarNodo("TR", "nombre", "subpOidMarcUltiViewLabelTrId");
		borrarNodo("TR", "nombre", "subpOidMarcCrea_ccprOidProcViewLabelTrId");
		borrarNodo("TR", "nombre", "subpOidMarcCreaViewLabelTrId");
		borrarNodo("TR", "nombre", "tcabOidAbonUltiViewLabelTrId");
		borrarNodo("TR", "nombre", "tcabOidAbonCreaViewLabelTrId");
		borrarNodo("TR", "nombre", "ttraOidTipoTransViewLabelTrId");
		borrarNodo("TR", "nombre", "ccbaOidCcBanc_cucoOidCcPnteViewLabelTrId");
		borrarNodo("TR", "nombre", "ccbaOidCcBanc_cucoOidCcTesoViewLabelTrId");
		borrarNodo("TR", "nombre", "ccbaOidCcBanc_sucuOidSucu_cbanOidBancViewLabelTrId");
		borrarNodo("TR", "nombre", "ccbaOidCcBanc_sucuOidSucuViewLabelTrId");
		borrarNodo("TR", "nombre", "ccbaOidCcBanc_sociOidSociViewLabelTrId");
		borrarNodo("TR", "nombre", "ccbaOidCcBancViewLabelTrId");
		borrarNodo("TR", "nombre", "numConsTranViewLabelTrId");
		borrarNodo("TR", "nombre", "numLoteViewLabelTrId");
		borrarNodo("TR", "nombre", "codConsViewLabelTrId");
		borrarNodo("TR", "nombre", "codConsRealViewLabelTrId");
		borrarNodo("TR", "nombre", "codErroViewLabelTrId");
		borrarNodo("TR", "nombre", "valDigiCheqFactViewLabelTrId");
		borrarNodo("TR", "nombre", "valDocuApliAnioViewLabelTrId");
		borrarNodo("TR", "nombre", "valDocuApliMesSeriViewLabelTrId");
		borrarNodo("TR", "nombre", "valDocuApliNumeViewLabelTrId");
		borrarNodo("TR", "nombre", "valDocuCreaAnioViewLabelTrId");
		borrarNodo("TR", "nombre", "valDocuCreaMesSeriViewLabelTrId");
		borrarNodo("TR", "nombre", "valDocuCreaNumeViewLabelTrId");
		borrarNodo("TR", "nombre", "valEstaMoviPendViewLabelTrId");
		borrarNodo("TR", "nombre", "fecContViewLabelTrId");
		borrarNodo("TR", "nombre", "fecPagoViewLabelTrId");
		borrarNodo("TR", "nombre", "fecProcViewLabelTrId");
		borrarNodo("TR", "nombre", "valHoraProcViewLabelTrId");
		borrarNodo("TR", "nombre", "valHoraNormAdicViewLabelTrId");
		borrarNodo("TR", "nombre", "codIdenProcViewLabelTrId");
		borrarNodo("TR", "nombre", "impPagoViewLabelTrId");
		borrarNodo("TR", "nombre", "valNombOficViewLabelTrId");
		borrarNodo("TR", "nombre", "numCupoViewLabelTrId");
		borrarNodo("TR", "nombre", "valNumeDocuViewLabelTrId");
		borrarNodo("TR", "nombre", "numFactBoleViewLabelTrId");
		borrarNodo("TR", "nombre", "valNumeLoteContViewLabelTrId");
		borrarNodo("TR", "nombre", "valObseViewLabelTrId");
		borrarNodo("TR", "nombre", "codOficRecaViewLabelTrId");
		borrarNodo("TR", "nombre", "valUsuaProcViewLabelTrId");
		borrarNodo("TR", "nombre", "fecMoviApliViewLabelTrId");
		
	}

	/**
	*	Nos permite borrar los TR que contienen los widgets de los campos
	*/
	protected void removeWidgets() throws Exception{
		borrarNodo("TR", "nombre", "idWidgetTrId");
		borrarNodo("TR", "nombre", "sociOidSociWidgetTrId");
		borrarNodo("TR", "nombre", "subpOidMarcUlti_ccprOidProcWidgetTrId");
		borrarNodo("TR", "nombre", "subpOidMarcUltiWidgetTrId");
		borrarNodo("TR", "nombre", "subpOidMarcCrea_ccprOidProcWidgetTrId");
		borrarNodo("TR", "nombre", "subpOidMarcCreaWidgetTrId");
		borrarNodo("TR", "nombre", "tcabOidAbonUltiWidgetTrId");
		borrarNodo("TR", "nombre", "tcabOidAbonCreaWidgetTrId");
		borrarNodo("TR", "nombre", "ttraOidTipoTransWidgetTrId");
		borrarNodo("TR", "nombre", "ccbaOidCcBanc_cucoOidCcPnteWidgetTrId");
		borrarNodo("TR", "nombre", "ccbaOidCcBanc_cucoOidCcTesoWidgetTrId");
		borrarNodo("TR", "nombre", "ccbaOidCcBanc_sucuOidSucu_cbanOidBancWidgetTrId");
		borrarNodo("TR", "nombre", "ccbaOidCcBanc_sucuOidSucuWidgetTrId");
		borrarNodo("TR", "nombre", "ccbaOidCcBanc_sociOidSociWidgetTrId");
		borrarNodo("TR", "nombre", "ccbaOidCcBancWidgetTrId");
		borrarNodo("TR", "nombre", "numConsTranWidgetTrId");
		borrarNodo("TR", "nombre", "numLoteWidgetTrId");
		borrarNodo("TR", "nombre", "codConsWidgetTrId");
		borrarNodo("TR", "nombre", "codConsRealWidgetTrId");
		borrarNodo("TR", "nombre", "codErroWidgetTrId");
		borrarNodo("TR", "nombre", "valDigiCheqFactWidgetTrId");
		borrarNodo("TR", "nombre", "valDocuApliAnioWidgetTrId");
		borrarNodo("TR", "nombre", "valDocuApliMesSeriWidgetTrId");
		borrarNodo("TR", "nombre", "valDocuApliNumeWidgetTrId");
		borrarNodo("TR", "nombre", "valDocuCreaAnioWidgetTrId");
		borrarNodo("TR", "nombre", "valDocuCreaMesSeriWidgetTrId");
		borrarNodo("TR", "nombre", "valDocuCreaNumeWidgetTrId");
		borrarNodo("TR", "nombre", "valEstaMoviPendWidgetTrId");
		borrarNodo("TR", "nombre", "fecContWidgetTrId");
		borrarNodo("TR", "nombre", "fecPagoWidgetTrId");
		borrarNodo("TR", "nombre", "fecProcWidgetTrId");
		borrarNodo("TR", "nombre", "valHoraProcWidgetTrId");
		borrarNodo("TR", "nombre", "valHoraNormAdicWidgetTrId");
		borrarNodo("TR", "nombre", "codIdenProcWidgetTrId");
		borrarNodo("TR", "nombre", "impPagoWidgetTrId");
		borrarNodo("TR", "nombre", "valNombOficWidgetTrId");
		borrarNodo("TR", "nombre", "numCupoWidgetTrId");
		borrarNodo("TR", "nombre", "valNumeDocuWidgetTrId");
		borrarNodo("TR", "nombre", "numFactBoleWidgetTrId");
		borrarNodo("TR", "nombre", "valNumeLoteContWidgetTrId");
		borrarNodo("TR", "nombre", "valObseWidgetTrId");
		borrarNodo("TR", "nombre", "codOficRecaWidgetTrId");
		borrarNodo("TR", "nombre", "valUsuaProcWidgetTrId");
		borrarNodo("TR", "nombre", "fecMoviApliWidgetTrId");
		
	}
}







