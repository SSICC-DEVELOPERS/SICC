/*
    INDRA/CAR/mmg
    $Id: RecOperaLPStartUp.java,v 1.1 2009/12/03 18:37:28 pecbazalar Exp $
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
public class RecOperaLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 987;
	public static final short CREATEFORM_SIZE = 977;
	public static final short UPDATEFORM_SIZE = 977;
	public static final short VIEWFORM_SIZE = 977;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGRecOperaQueryFromToUserPage";
	
	
				public static final String BUSINESSID_ALMCOIDALMA_QUERY ="MMGBelAlmacQueryFromToUser";
				public static final String ALMCOIDALMA_COMBO_CONNECTOR = "BelAlmacConectorCombo";
	
				public static final String BUSINESSID_PECIOIDPECI_QUERY ="MMGRecPreciQueryFromToUser";
				public static final String PECIOIDPECI_COMBO_CONNECTOR = "RecPreciConectorCombo";
	
				public static final String BUSINESSID_MENSOIDMENS_QUERY ="MMGMsgMensaQueryFromToUser";
				public static final String MENSOIDMENS_COMBO_CONNECTOR = "MsgMensaConectorCombo";
	
				public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisViewQueryFromToUser";
				public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisViewConectorCombo";
	
				public static final String BUSINESSID_TSPAOIDSOLIPAISPERD_QUERY ="MMGPedTipoSolicPaisQueryFromToUser";
				public static final String TSPAOIDSOLIPAISPERD_COMBO_CONNECTOR = "PedTipoSolicPaisConectorCombo";
	
				public static final String BUSINESSID_TMALOIDTIPOMOVIALMA_QUERY ="MMGBelTipoMovimAlmacQueryFromToUser";
				public static final String TMALOIDTIPOMOVIALMA_COMBO_CONNECTOR = "BelTipoMovimAlmacConectorCombo";
	
				public static final String BUSINESSID_MDEFOIDMODOABONDEFE_QUERY ="MMGRecModoAbonoDefecQueryFromToUser";
				public static final String MDEFOIDMODOABONDEFE_COMBO_CONNECTOR = "RecModoAbonoDefecConectorCombo";
	
				public static final String BUSINESSID_PENVOIDPRECIOENVIA_QUERY ="MMGRecPreciEnviaQueryFromToUser";
				public static final String PENVOIDPRECIOENVIA_COMBO_CONNECTOR = "RecPreciEnviaConectorCombo";
	
				public static final String BUSINESSID_TSPAOIDSOLIPAISGENE_QUERY ="MMGPedTipoSolicPaisQueryFromToUser";
				public static final String TSPAOIDSOLIPAISGENE_COMBO_CONNECTOR = "PedTipoSolicPaisConectorCombo";
	
				public static final String BUSINESSID_MOBLOIDMOTIBLOQ_QUERY ="MMGRecMotivBloquQueryFromToUser";
				public static final String MOBLOIDMOTIBLOQ_COMBO_CONNECTOR = "RecMotivBloquConectorCombo";
	
				public static final String BUSINESSID_TSPAOIDSOLISINSTOC_QUERY ="MMGPedTipoSolicPaisQueryFromToUser";
				public static final String TSPAOIDSOLISINSTOC_COMBO_CONNECTOR = "PedTipoSolicPaisConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public RecOperaLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("RecOperaPage");
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
			buildJsPageSize("RecOpera");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "RecOperaPage", "cod", "RecOpera." + accion + ".label");
			
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
			limpiarBotoneraLista("recOpera", accion);
			
			
			
			
			
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
		asignarAtributo("TEXT", "codOper", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "valDescLarg", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "indAnul", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indIngrEnvi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valIngrDevu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valPerd", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indEspeMercFisi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indDevuFisiFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "numCampHist", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "indEnviGeneDevu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indDevuGeneEnvi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "indFaltMerc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "recOperaLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "RecOperaPage", "onblur", "window.focus();");
		
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
		conectorAction("RecOperaLPStartUp");
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
		RecOperaData recOperaQuery= new RecOperaData();
		recOperaQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		RecOperaData datosResult = (RecOperaData)getSingleObject(BUSINESSID_QUERY, recOperaQuery, 
			recOperaQuery.clone(), "recOpera");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		RecOperaData recOpera = datosResult;
		asignar("TEXT", "codOper", FormatUtils.formatObject(recOpera.getCodOper(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDescLarg", FormatUtils.formatObject(recOpera.getValDescLarg(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indAnul", FormatUtils.formatObject(recOpera.getIndAnul(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indIngrEnvi", FormatUtils.formatObject(recOpera.getIndIngrEnvi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valIngrDevu", FormatUtils.formatObject(recOpera.getValIngrDevu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPerd", FormatUtils.formatObject(recOpera.getValPerd(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indEspeMercFisi", FormatUtils.formatObject(recOpera.getIndEspeMercFisi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indDevuFisiFact", FormatUtils.formatObject(recOpera.getIndDevuFisiFact(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numCampHist", FormatUtils.formatObject(recOpera.getNumCampHist(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indEnviGeneDevu", FormatUtils.formatObject(recOpera.getIndEnviGeneDevu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indDevuGeneEnvi", FormatUtils.formatObject(recOpera.getIndDevuGeneEnvi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.BelAlmacData almcOidAlma = recOpera.getAlmcOidAlma();
		if(almcOidAlma != null && almcOidAlma.getId() != null) checkCombo("almcOidAlma" , almcOidAlma.getId().toString());
		es.indra.belcorp.mso.RecPreciData peciOidPeci = recOpera.getPeciOidPeci();
		if(peciOidPeci != null && peciOidPeci.getId() != null) checkCombo("peciOidPeci" , peciOidPeci.getId().toString());
		es.indra.belcorp.mso.MsgMensaData mensOidMens = recOpera.getMensOidMens();
		if(mensOidMens != null && mensOidMens.getId() != null) checkCombo("mensOidMens" , mensOidMens.getId().toString());
		es.indra.belcorp.mso.PedTipoSolicPaisData tspaOidSoliPaisPerd = recOpera.getTspaOidSoliPaisPerd();
		if(tspaOidSoliPaisPerd != null && tspaOidSoliPaisPerd.getId() != null) checkCombo("tspaOidSoliPaisPerd" , tspaOidSoliPaisPerd.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviAlma = recOpera.getTmalOidTipoMoviAlma();
		if(tmalOidTipoMoviAlma != null && tmalOidTipoMoviAlma.getId() != null) checkCombo("tmalOidTipoMoviAlma" , tmalOidTipoMoviAlma.getId().toString());
		es.indra.belcorp.mso.RecModoAbonoDefecData mdefOidModoAbonDefe = recOpera.getMdefOidModoAbonDefe();
		if(mdefOidModoAbonDefe != null && mdefOidModoAbonDefe.getId() != null) checkCombo("mdefOidModoAbonDefe" , mdefOidModoAbonDefe.getId().toString());
		es.indra.belcorp.mso.RecPreciEnviaData penvOidPrecioEnvia = recOpera.getPenvOidPrecioEnvia();
		if(penvOidPrecioEnvia != null && penvOidPrecioEnvia.getId() != null) checkCombo("penvOidPrecioEnvia" , penvOidPrecioEnvia.getId().toString());
		es.indra.belcorp.mso.PedTipoSolicPaisData tspaOidSoliPaisGene = recOpera.getTspaOidSoliPaisGene();
		if(tspaOidSoliPaisGene != null && tspaOidSoliPaisGene.getId() != null) checkCombo("tspaOidSoliPaisGene" , tspaOidSoliPaisGene.getId().toString());
		es.indra.belcorp.mso.RecMotivBloquData moblOidMotiBloq = recOpera.getMoblOidMotiBloq();
		if(moblOidMotiBloq != null && moblOidMotiBloq.getId() != null) checkCombo("moblOidMotiBloq" , moblOidMotiBloq.getId().toString());
		asignar("TEXT", "indFaltMerc", FormatUtils.formatObject(recOpera.getIndFaltMerc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.PedTipoSolicPaisData tspaOidSoliSinStoc = recOpera.getTspaOidSoliSinStoc();
		if(tspaOidSoliSinStoc != null && tspaOidSoliSinStoc.getId() != null) checkCombo("tspaOidSoliSinStoc" , tspaOidSoliSinStoc.getId().toString());
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		asignarAtributo("TEXT", "codOper", "disabled", "S");
		asignarAtributo("TEXT", "valDescLarg", "disabled", "S");
		asignarAtributo("TEXT", "indAnul", "disabled", "S");
		asignarAtributo("TEXT", "indIngrEnvi", "disabled", "S");
		asignarAtributo("TEXT", "valIngrDevu", "disabled", "S");
		asignarAtributo("TEXT", "valPerd", "disabled", "S");
		asignarAtributo("TEXT", "indEspeMercFisi", "disabled", "S");
		asignarAtributo("TEXT", "indDevuFisiFact", "disabled", "S");
		asignarAtributo("TEXT", "numCampHist", "disabled", "S");
		asignarAtributo("TEXT", "indEnviGeneDevu", "disabled", "S");
		asignarAtributo("TEXT", "indDevuGeneEnvi", "disabled", "S");
		
					asignarAtributo("COMBO", "almcOidAlma", "disabled", "S");
					asignarAtributo("COMBO", "peciOidPeci", "disabled", "S");
					asignarAtributo("COMBO", "mensOidMens", "disabled", "S");
					asignarAtributo("COMBO", "tspaOidSoliPaisPerd", "disabled", "S");
					asignarAtributo("COMBO", "tmalOidTipoMoviAlma", "disabled", "S");
					asignarAtributo("COMBO", "mdefOidModoAbonDefe", "disabled", "S");
					asignarAtributo("COMBO", "penvOidPrecioEnvia", "disabled", "S");
					asignarAtributo("COMBO", "tspaOidSoliPaisGene", "disabled", "S");
					asignarAtributo("COMBO", "moblOidMotiBloq", "disabled", "S");asignarAtributo("TEXT", "indFaltMerc", "disabled", "S");
		
					asignarAtributo("COMBO", "tspaOidSoliSinStoc", "disabled", "S");
		
	
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
		asignarAtributo("TEXT", "codOper", "req", "S");
		asignarAtributo("TEXT", "valDescLarg", "req", "S");
		asignarAtributo("TEXT", "indAnul", "req", "S");
		asignarAtributo("COMBO", "peciOidPeci", "req", "S");
		
		
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
		asignarAtributo("TEXT", "codOper", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "valDescLarg", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "indAnul", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indIngrEnvi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valIngrDevu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valPerd", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indEspeMercFisi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indDevuFisiFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "numCampHist", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "indEnviGeneDevu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indDevuGeneEnvi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "indFaltMerc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
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
		asignarAtributo("TEXT", "codOper", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "valDescLarg", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "indAnul", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indIngrEnvi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valIngrDevu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valPerd", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indEspeMercFisi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indDevuFisiFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "numCampHist", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "indEnviGeneDevu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indDevuGeneEnvi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "indFaltMerc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
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
		asignarAtributo("TEXT", "codOper", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "valDescLarg", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "indAnul", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indIngrEnvi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valIngrDevu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valPerd", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indEspeMercFisi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indDevuFisiFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "numCampHist", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "indEnviGeneDevu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indDevuGeneEnvi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "indFaltMerc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
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
		asignarAtributo("TEXT", "codOper", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "valDescLarg", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "indAnul", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indIngrEnvi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valIngrDevu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valPerd", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indEspeMercFisi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indDevuFisiFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "numCampHist", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "indEnviGeneDevu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indDevuGeneEnvi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "indFaltMerc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
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
		conectorAction("RecOperaLPStartUp");
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
		//asignarAtributo("FORMULARIO", "recOperaFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("TEXT", "codOper", "req", "S");
				asignarAtributo("TEXT", "valDescLarg", "req", "S");
				asignarAtributo("TEXT", "indAnul", "req", "S");
				asignarAtributo("COMBO", "peciOidPeci", "req", "S");
		
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
		
			asignarAtributo("TEXT", "codOper", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
			asignarAtributo("TEXT", "valDescLarg", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
			asignarAtributo("TEXT", "indAnul", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indIngrEnvi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "valIngrDevu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "valPerd", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indEspeMercFisi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indDevuFisiFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "numCampHist", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
			asignarAtributo("TEXT", "indEnviGeneDevu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indDevuGeneEnvi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			
			
			
			
			
			
			
			
			
			asignarAtributo("TEXT", "indFaltMerc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando RecOpera");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		RecOperaData recOperaQuery= new RecOperaData();
		recOperaQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		RecOperaData  datosResult = (RecOperaData)getSingleObject(BUSINESSID_QUERY, recOperaQuery, 
			recOperaQuery.clone(), "recOpera");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		RecOperaData recOpera = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		asignar("TEXT", "codOper", FormatUtils.formatObject(recOpera.getCodOper(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDescLarg", FormatUtils.formatObject(recOpera.getValDescLarg(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indAnul", FormatUtils.formatObject(recOpera.getIndAnul(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indIngrEnvi", FormatUtils.formatObject(recOpera.getIndIngrEnvi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valIngrDevu", FormatUtils.formatObject(recOpera.getValIngrDevu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPerd", FormatUtils.formatObject(recOpera.getValPerd(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indEspeMercFisi", FormatUtils.formatObject(recOpera.getIndEspeMercFisi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indDevuFisiFact", FormatUtils.formatObject(recOpera.getIndDevuFisiFact(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numCampHist", FormatUtils.formatObject(recOpera.getNumCampHist(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indEnviGeneDevu", FormatUtils.formatObject(recOpera.getIndEnviGeneDevu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indDevuGeneEnvi", FormatUtils.formatObject(recOpera.getIndDevuGeneEnvi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.BelAlmacData almcOidAlma = recOpera.getAlmcOidAlma();
		if(almcOidAlma != null && almcOidAlma.getId() != null) checkCombo("almcOidAlma" , almcOidAlma.getId().toString());
		es.indra.belcorp.mso.RecPreciData peciOidPeci = recOpera.getPeciOidPeci();
		if(peciOidPeci != null && peciOidPeci.getId() != null) checkCombo("peciOidPeci" , peciOidPeci.getId().toString());
		es.indra.belcorp.mso.MsgMensaData mensOidMens = recOpera.getMensOidMens();
		if(mensOidMens != null && mensOidMens.getId() != null) checkCombo("mensOidMens" , mensOidMens.getId().toString());
		es.indra.belcorp.mso.PedTipoSolicPaisData tspaOidSoliPaisPerd = recOpera.getTspaOidSoliPaisPerd();
		if(tspaOidSoliPaisPerd != null && tspaOidSoliPaisPerd.getId() != null) checkCombo("tspaOidSoliPaisPerd" , tspaOidSoliPaisPerd.getId().toString());
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviAlma = recOpera.getTmalOidTipoMoviAlma();
		if(tmalOidTipoMoviAlma != null && tmalOidTipoMoviAlma.getId() != null) checkCombo("tmalOidTipoMoviAlma" , tmalOidTipoMoviAlma.getId().toString());
		es.indra.belcorp.mso.RecModoAbonoDefecData mdefOidModoAbonDefe = recOpera.getMdefOidModoAbonDefe();
		if(mdefOidModoAbonDefe != null && mdefOidModoAbonDefe.getId() != null) checkCombo("mdefOidModoAbonDefe" , mdefOidModoAbonDefe.getId().toString());
		es.indra.belcorp.mso.RecPreciEnviaData penvOidPrecioEnvia = recOpera.getPenvOidPrecioEnvia();
		if(penvOidPrecioEnvia != null && penvOidPrecioEnvia.getId() != null) checkCombo("penvOidPrecioEnvia" , penvOidPrecioEnvia.getId().toString());
		es.indra.belcorp.mso.PedTipoSolicPaisData tspaOidSoliPaisGene = recOpera.getTspaOidSoliPaisGene();
		if(tspaOidSoliPaisGene != null && tspaOidSoliPaisGene.getId() != null) checkCombo("tspaOidSoliPaisGene" , tspaOidSoliPaisGene.getId().toString());
		es.indra.belcorp.mso.RecMotivBloquData moblOidMotiBloq = recOpera.getMoblOidMotiBloq();
		if(moblOidMotiBloq != null && moblOidMotiBloq.getId() != null) checkCombo("moblOidMotiBloq" , moblOidMotiBloq.getId().toString());
		asignar("TEXT", "indFaltMerc", FormatUtils.formatObject(recOpera.getIndFaltMerc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.PedTipoSolicPaisData tspaOidSoliSinStoc = recOpera.getTspaOidSoliSinStoc();
		if(tspaOidSoliSinStoc != null && tspaOidSoliSinStoc.getId() != null) checkCombo("tspaOidSoliSinStoc" , tspaOidSoliSinStoc.getId().toString());
		

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(recOpera.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"recOperaFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"recOperaFrm\",1, false)");
				asignarAtributo("AREATEXTO", "codOper", "ontab","ejecutarAccionFocoModificacion(\"recOperaFrm\",2, true)");
				asignarAtributo("AREATEXTO", "codOper", "onshtab","ejecutarAccionFocoModificacion(\"recOperaFrm\",2, false)");
				asignarAtributo("AREATEXTO", "valDescLarg", "ontab","ejecutarAccionFocoModificacion(\"recOperaFrm\",3, true)");
				asignarAtributo("AREATEXTO", "valDescLarg", "onshtab","ejecutarAccionFocoModificacion(\"recOperaFrm\",3, false)");
				asignarAtributo("AREATEXTO", "indAnul", "ontab","ejecutarAccionFocoModificacion(\"recOperaFrm\",4, true)");
				asignarAtributo("AREATEXTO", "indAnul", "onshtab","ejecutarAccionFocoModificacion(\"recOperaFrm\",4, false)");
				asignarAtributo("AREATEXTO", "indIngrEnvi", "ontab","ejecutarAccionFocoModificacion(\"recOperaFrm\",5, true)");
				asignarAtributo("AREATEXTO", "indIngrEnvi", "onshtab","ejecutarAccionFocoModificacion(\"recOperaFrm\",5, false)");
				asignarAtributo("AREATEXTO", "valIngrDevu", "ontab","ejecutarAccionFocoModificacion(\"recOperaFrm\",6, true)");
				asignarAtributo("AREATEXTO", "valIngrDevu", "onshtab","ejecutarAccionFocoModificacion(\"recOperaFrm\",6, false)");
				asignarAtributo("AREATEXTO", "valPerd", "ontab","ejecutarAccionFocoModificacion(\"recOperaFrm\",7, true)");
				asignarAtributo("AREATEXTO", "valPerd", "onshtab","ejecutarAccionFocoModificacion(\"recOperaFrm\",7, false)");
				asignarAtributo("AREATEXTO", "indEspeMercFisi", "ontab","ejecutarAccionFocoModificacion(\"recOperaFrm\",8, true)");
				asignarAtributo("AREATEXTO", "indEspeMercFisi", "onshtab","ejecutarAccionFocoModificacion(\"recOperaFrm\",8, false)");
				asignarAtributo("AREATEXTO", "indDevuFisiFact", "ontab","ejecutarAccionFocoModificacion(\"recOperaFrm\",9, true)");
				asignarAtributo("AREATEXTO", "indDevuFisiFact", "onshtab","ejecutarAccionFocoModificacion(\"recOperaFrm\",9, false)");
				asignarAtributo("AREATEXTO", "numCampHist", "ontab","ejecutarAccionFocoModificacion(\"recOperaFrm\",10, true)");
				asignarAtributo("AREATEXTO", "numCampHist", "onshtab","ejecutarAccionFocoModificacion(\"recOperaFrm\",10, false)");
				asignarAtributo("AREATEXTO", "indEnviGeneDevu", "ontab","ejecutarAccionFocoModificacion(\"recOperaFrm\",11, true)");
				asignarAtributo("AREATEXTO", "indEnviGeneDevu", "onshtab","ejecutarAccionFocoModificacion(\"recOperaFrm\",11, false)");
				asignarAtributo("AREATEXTO", "indDevuGeneEnvi", "ontab","ejecutarAccionFocoModificacion(\"recOperaFrm\",12, true)");
				asignarAtributo("AREATEXTO", "indDevuGeneEnvi", "onshtab","ejecutarAccionFocoModificacion(\"recOperaFrm\",12, false)");
					asignarAtributo("COMBO","almcOidAlma", "ontab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",13, true)");
					asignarAtributo("COMBO","almcOidAlma", "onshtab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",13, false)");
					asignarAtributo("COMBO","peciOidPeci", "ontab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",14, true)");
					asignarAtributo("COMBO","peciOidPeci", "onshtab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",14, false)");
					asignarAtributo("COMBO","mensOidMens", "ontab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",15, true)");
					asignarAtributo("COMBO","mensOidMens", "onshtab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",15, false)");
					asignarAtributo("COMBO","paisOidPais", "ontab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",16, true)");
					asignarAtributo("COMBO","paisOidPais", "onshtab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",16, false)");
					asignarAtributo("COMBO","tspaOidSoliPaisPerd", "ontab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",17, true)");
					asignarAtributo("COMBO","tspaOidSoliPaisPerd", "onshtab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",17, false)");
					asignarAtributo("COMBO","tmalOidTipoMoviAlma", "ontab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",18, true)");
					asignarAtributo("COMBO","tmalOidTipoMoviAlma", "onshtab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",18, false)");
					asignarAtributo("COMBO","mdefOidModoAbonDefe", "ontab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",19, true)");
					asignarAtributo("COMBO","mdefOidModoAbonDefe", "onshtab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",19, false)");
					asignarAtributo("COMBO","penvOidPrecioEnvia", "ontab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",20, true)");
					asignarAtributo("COMBO","penvOidPrecioEnvia", "onshtab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",20, false)");
					asignarAtributo("COMBO","tspaOidSoliPaisGene", "ontab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",21, true)");
					asignarAtributo("COMBO","tspaOidSoliPaisGene", "onshtab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",21, false)");
					asignarAtributo("COMBO","moblOidMotiBloq", "ontab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",22, true)");
					asignarAtributo("COMBO","moblOidMotiBloq", "onshtab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",22, false)");
				asignarAtributo("AREATEXTO", "indFaltMerc", "ontab","ejecutarAccionFocoModificacion(\"recOperaFrm\",23, true)");
				asignarAtributo("AREATEXTO", "indFaltMerc", "onshtab","ejecutarAccionFocoModificacion(\"recOperaFrm\",23, false)");
					asignarAtributo("COMBO","tspaOidSoliSinStoc", "ontab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",24, true)");
					asignarAtributo("COMBO","tspaOidSoliSinStoc", "onshtab", "ejecutarAccionFocoModificacion(\"recOperaFrm\",24, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","recOperaTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","recOperaTrButtons");

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
				
				traza("MMG: el atributo es codOper...");		
				
				traza("MMG: el atributo es valDescLarg...");		
				
				traza("MMG: el atributo es indAnul...");		
				
				traza("MMG: el atributo es indIngrEnvi...");		
				
				traza("MMG: el atributo es valIngrDevu...");		
				
				traza("MMG: el atributo es valPerd...");		
				
				traza("MMG: el atributo es indEspeMercFisi...");		
				
				traza("MMG: el atributo es indDevuFisiFact...");		
				
				traza("MMG: el atributo es numCampHist...");		
				
				traza("MMG: el atributo es indEnviGeneDevu...");		
				
				traza("MMG: el atributo es indDevuGeneEnvi...");		
				
				traza("MMG: el atributo es almcOidAlma...");		
				
				traza("MMG: el atributo es peciOidPeci...");		
				
				traza("MMG: el atributo es mensOidMens...");		
				
				traza("MMG: el atributo es paisOidPais...");		
				
				traza("MMG: el atributo es tspaOidSoliPaisPerd...");		
				
				traza("MMG: el atributo es tmalOidTipoMoviAlma...");		
				
				traza("MMG: el atributo es mdefOidModoAbonDefe...");		
				
				traza("MMG: el atributo es penvOidPrecioEnvia...");		
				
				traza("MMG: el atributo es tspaOidSoliPaisGene...");		
				
				traza("MMG: el atributo es moblOidMotiBloq...");		
				
				traza("MMG: el atributo es indFaltMerc...");		
				
				traza("MMG: el atributo es tspaOidSoliSinStoc...");		
				
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
		asignarAtributo("CAPA","recOperaFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","recOperaListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","recOperaListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(RecOperaData recOpera) throws Exception{
		HashMap checkedCombos = new HashMap();
		BelAlmacData almcOidAlma = new BelAlmacData();
		
						asignarComboResultados(BUSINESSID_ALMCOIDALMA_QUERY,ALMCOIDALMA_COMBO_CONNECTOR, 
			almcOidAlma, almcOidAlma.clone(), "belAlmac", "almcOidAlma", "result_ROWSET" );
		if(recOpera != null && recOpera.getAlmcOidAlma() != null){
				checkCombo("almcOidAlma" , recOpera.getAlmcOidAlma().getId().toString());
			}
		RecPreciData peciOidPeci = new RecPreciData();
		
						asignarComboResultados(BUSINESSID_PECIOIDPECI_QUERY,PECIOIDPECI_COMBO_CONNECTOR, 
			peciOidPeci, peciOidPeci.clone(), "recPreci", "peciOidPeci", "result_ROWSET" );
		if(recOpera != null && recOpera.getPeciOidPeci() != null){
				checkCombo("peciOidPeci" , recOpera.getPeciOidPeci().getId().toString());
			}
		MsgMensaData mensOidMens = new MsgMensaData();
		
						asignarComboResultados(BUSINESSID_MENSOIDMENS_QUERY,MENSOIDMENS_COMBO_CONNECTOR, 
			mensOidMens, mensOidMens.clone(), "msgMensa", "mensOidMens", "result_ROWSET" );
		if(recOpera != null && recOpera.getMensOidMens() != null){
				checkCombo("mensOidMens" , recOpera.getMensOidMens().getId().toString());
			}
		SegPaisViewData paisOidPais = new SegPaisViewData();
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, 
			paisOidPais, paisOidPais.clone(), "segPaisView", "paisOidPais", "result_ROWSET" );
		if(recOpera != null && recOpera.getPaisOidPais() != null){
				checkCombo("paisOidPais" , recOpera.getPaisOidPais().getId().toString());
			}
		String paisOidPaisDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPaisView");
		if(paisOidPaisDefaultValue != null && !paisOidPaisDefaultValue.trim().equals("")){
			checkCombo("paisOidPais", paisOidPaisDefaultValue);
			checkedCombos.put("paisOidPais",paisOidPaisDefaultValue);
			cascadeComboLoad(checkedCombos, "paisOidPais");
		}						 
		PedTipoSolicPaisData tspaOidSoliPaisPerd = new PedTipoSolicPaisData();
		
						asignarComboResultados(BUSINESSID_TSPAOIDSOLIPAISPERD_QUERY,TSPAOIDSOLIPAISPERD_COMBO_CONNECTOR, 
			tspaOidSoliPaisPerd, tspaOidSoliPaisPerd.clone(), "pedTipoSolicPais", "tspaOidSoliPaisPerd", "result_ROWSET" );
		if(recOpera != null && recOpera.getTspaOidSoliPaisPerd() != null){
				checkCombo("tspaOidSoliPaisPerd" , recOpera.getTspaOidSoliPaisPerd().getId().toString());
			}
		BelTipoMovimAlmacData tmalOidTipoMoviAlma = new BelTipoMovimAlmacData();
		
						asignarComboResultados(BUSINESSID_TMALOIDTIPOMOVIALMA_QUERY,TMALOIDTIPOMOVIALMA_COMBO_CONNECTOR, 
			tmalOidTipoMoviAlma, tmalOidTipoMoviAlma.clone(), "belTipoMovimAlmac", "tmalOidTipoMoviAlma", "result_ROWSET" );
		if(recOpera != null && recOpera.getTmalOidTipoMoviAlma() != null){
				checkCombo("tmalOidTipoMoviAlma" , recOpera.getTmalOidTipoMoviAlma().getId().toString());
			}
		RecModoAbonoDefecData mdefOidModoAbonDefe = new RecModoAbonoDefecData();
		
						asignarComboResultados(BUSINESSID_MDEFOIDMODOABONDEFE_QUERY,MDEFOIDMODOABONDEFE_COMBO_CONNECTOR, 
			mdefOidModoAbonDefe, mdefOidModoAbonDefe.clone(), "recModoAbonoDefec", "mdefOidModoAbonDefe", "result_ROWSET" );
		if(recOpera != null && recOpera.getMdefOidModoAbonDefe() != null){
				checkCombo("mdefOidModoAbonDefe" , recOpera.getMdefOidModoAbonDefe().getId().toString());
			}
		RecPreciEnviaData penvOidPrecioEnvia = new RecPreciEnviaData();
		
						asignarComboResultados(BUSINESSID_PENVOIDPRECIOENVIA_QUERY,PENVOIDPRECIOENVIA_COMBO_CONNECTOR, 
			penvOidPrecioEnvia, penvOidPrecioEnvia.clone(), "recPreciEnvia", "penvOidPrecioEnvia", "result_ROWSET" );
		if(recOpera != null && recOpera.getPenvOidPrecioEnvia() != null){
				checkCombo("penvOidPrecioEnvia" , recOpera.getPenvOidPrecioEnvia().getId().toString());
			}
		PedTipoSolicPaisData tspaOidSoliPaisGene = new PedTipoSolicPaisData();
		
						asignarComboResultados(BUSINESSID_TSPAOIDSOLIPAISGENE_QUERY,TSPAOIDSOLIPAISGENE_COMBO_CONNECTOR, 
			tspaOidSoliPaisGene, tspaOidSoliPaisGene.clone(), "pedTipoSolicPais", "tspaOidSoliPaisGene", "result_ROWSET" );
		if(recOpera != null && recOpera.getTspaOidSoliPaisGene() != null){
				checkCombo("tspaOidSoliPaisGene" , recOpera.getTspaOidSoliPaisGene().getId().toString());
			}
		RecMotivBloquData moblOidMotiBloq = new RecMotivBloquData();
		
						asignarComboResultados(BUSINESSID_MOBLOIDMOTIBLOQ_QUERY,MOBLOIDMOTIBLOQ_COMBO_CONNECTOR, 
			moblOidMotiBloq, moblOidMotiBloq.clone(), "recMotivBloqu", "moblOidMotiBloq", "result_ROWSET" );
		if(recOpera != null && recOpera.getMoblOidMotiBloq() != null){
				checkCombo("moblOidMotiBloq" , recOpera.getMoblOidMotiBloq().getId().toString());
			}
		PedTipoSolicPaisData tspaOidSoliSinStoc = new PedTipoSolicPaisData();
		
						asignarComboResultados(BUSINESSID_TSPAOIDSOLISINSTOC_QUERY,TSPAOIDSOLISINSTOC_COMBO_CONNECTOR, 
			tspaOidSoliSinStoc, tspaOidSoliSinStoc.clone(), "pedTipoSolicPais", "tspaOidSoliSinStoc", "result_ROWSET" );
		if(recOpera != null && recOpera.getTspaOidSoliSinStoc() != null){
				checkCombo("tspaOidSoliSinStoc" , recOpera.getTspaOidSoliSinStoc().getId().toString());
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
	* @param recOpera La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(RecOperaData recOpera) 
		throws Exception{
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		RecOperaData recOpera = 
			(RecOperaData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(recOpera.getAlmcOidAlma() != null){
			recOpera.setAlmcOidAlma((es.indra.belcorp.mso.BelAlmacData)
			getSingleObject(BUSINESSID_ALMCOIDALMA_QUERY, 
			recOpera.getAlmcOidAlma(),
			recOpera.getAlmcOidAlma().clone(),
			"belAlmac"));
		}
		if(recOpera.getPeciOidPeci() != null){
			recOpera.setPeciOidPeci((es.indra.belcorp.mso.RecPreciData)
			getSingleObject(BUSINESSID_PECIOIDPECI_QUERY, 
			recOpera.getPeciOidPeci(),
			recOpera.getPeciOidPeci().clone(),
			"recPreci"));
		}
		if(recOpera.getMensOidMens() != null){
			recOpera.setMensOidMens((es.indra.belcorp.mso.MsgMensaData)
			getSingleObject(BUSINESSID_MENSOIDMENS_QUERY, 
			recOpera.getMensOidMens(),
			recOpera.getMensOidMens().clone(),
			"msgMensa"));
		}
		if(recOpera.getPaisOidPais() != null){
			recOpera.setPaisOidPais((es.indra.belcorp.mso.SegPaisViewData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			recOpera.getPaisOidPais(),
			recOpera.getPaisOidPais().clone(),
			"segPaisView"));
		}
		if(recOpera.getTspaOidSoliPaisPerd() != null){
			recOpera.setTspaOidSoliPaisPerd((es.indra.belcorp.mso.PedTipoSolicPaisData)
			getSingleObject(BUSINESSID_TSPAOIDSOLIPAISPERD_QUERY, 
			recOpera.getTspaOidSoliPaisPerd(),
			recOpera.getTspaOidSoliPaisPerd().clone(),
			"pedTipoSolicPais"));
		}
		if(recOpera.getTmalOidTipoMoviAlma() != null){
			recOpera.setTmalOidTipoMoviAlma((es.indra.belcorp.mso.BelTipoMovimAlmacData)
			getSingleObject(BUSINESSID_TMALOIDTIPOMOVIALMA_QUERY, 
			recOpera.getTmalOidTipoMoviAlma(),
			recOpera.getTmalOidTipoMoviAlma().clone(),
			"belTipoMovimAlmac"));
		}
		if(recOpera.getMdefOidModoAbonDefe() != null){
			recOpera.setMdefOidModoAbonDefe((es.indra.belcorp.mso.RecModoAbonoDefecData)
			getSingleObject(BUSINESSID_MDEFOIDMODOABONDEFE_QUERY, 
			recOpera.getMdefOidModoAbonDefe(),
			recOpera.getMdefOidModoAbonDefe().clone(),
			"recModoAbonoDefec"));
		}
		if(recOpera.getPenvOidPrecioEnvia() != null){
			recOpera.setPenvOidPrecioEnvia((es.indra.belcorp.mso.RecPreciEnviaData)
			getSingleObject(BUSINESSID_PENVOIDPRECIOENVIA_QUERY, 
			recOpera.getPenvOidPrecioEnvia(),
			recOpera.getPenvOidPrecioEnvia().clone(),
			"recPreciEnvia"));
		}
		if(recOpera.getTspaOidSoliPaisGene() != null){
			recOpera.setTspaOidSoliPaisGene((es.indra.belcorp.mso.PedTipoSolicPaisData)
			getSingleObject(BUSINESSID_TSPAOIDSOLIPAISGENE_QUERY, 
			recOpera.getTspaOidSoliPaisGene(),
			recOpera.getTspaOidSoliPaisGene().clone(),
			"pedTipoSolicPais"));
		}
		if(recOpera.getMoblOidMotiBloq() != null){
			recOpera.setMoblOidMotiBloq((es.indra.belcorp.mso.RecMotivBloquData)
			getSingleObject(BUSINESSID_MOBLOIDMOTIBLOQ_QUERY, 
			recOpera.getMoblOidMotiBloq(),
			recOpera.getMoblOidMotiBloq().clone(),
			"recMotivBloqu"));
		}
		if(recOpera.getTspaOidSoliSinStoc() != null){
			recOpera.setTspaOidSoliSinStoc((es.indra.belcorp.mso.PedTipoSolicPaisData)
			getSingleObject(BUSINESSID_TSPAOIDSOLISINSTOC_QUERY, 
			recOpera.getTspaOidSoliSinStoc(),
			recOpera.getTspaOidSoliSinStoc().clone(),
			"pedTipoSolicPais"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(recOpera);
		loadLeafDependenceCombos(recOpera);
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





