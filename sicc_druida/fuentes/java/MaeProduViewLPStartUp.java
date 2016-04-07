/*
    INDRA/CAR/mmg
    $Id: MaeProduViewLPStartUp.java,v 1.1 2009/12/03 18:42:41 pecbazalar Exp $
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
public class MaeProduViewLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 1281;
	public static final short CREATEFORM_SIZE = 1263;
	public static final short UPDATEFORM_SIZE = 1263;
	public static final short VIEWFORM_SIZE = 1263;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGMaeProduViewQueryFromToUserPage";
	
	
				public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisViewQueryFromToUser";
				public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisViewConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public MaeProduViewLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("MaeProduViewPage");
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
			buildJsPageSize("MaeProduView");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "MaeProduViewPage", "cod", "MaeProduView." + accion + ".label");
			
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
			limpiarBotoneraLista("maeProduView", accion);
			
			
			
			
			
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
		
		asignarAtributo("TEXT", "codSap", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		asignarAtributo("TEXT", "codiAnti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 18);");
		asignarAtributo("TEXT", "desCort", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
		asignarAtributo("TEXT", "valJera1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valJera2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valJera3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valAtri1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valAtri2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 4);");
		asignarAtributo("TEXT", "valAtri3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 10);");
		asignarAtributo("TEXT", "valDimeAlto", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valDimeLarg", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valDimeAnch", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valPeso", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valVolu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valCostEstd", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valCostEstd', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecPosi", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecPosi', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCata", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecCata', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCont", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecCont', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numUnidDentPedi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
		asignarAtributo("TEXT", "numUnidCaja", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
		asignarAtributo("TEXT", "codImpu", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "pctUnid", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "indLote", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indProdServ", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "codIndSitu", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		asignarAtributo("TEXT", "codIndDentCaja", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		asignarAtributo("TEXT", "indKit", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valGrupArti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 9);");
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "maeProduViewLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "MaeProduViewPage", "onblur", "window.focus();");
		
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
		conectorAction("MaeProduViewLPStartUp");
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
		MaeProduViewData maeProduViewQuery= new MaeProduViewData();
		maeProduViewQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		MaeProduViewData datosResult = (MaeProduViewData)getSingleObject(BUSINESSID_QUERY, maeProduViewQuery, 
			maeProduViewQuery.clone(), "maeProduView");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		MaeProduViewData maeProduView = datosResult;
		es.indra.belcorp.mso.SegPaisViewData paisOidPais = maeProduView.getPaisOidPais();
		if(paisOidPais != null && paisOidPais.getId() != null) checkCombo("paisOidPais" , paisOidPais.getId().toString());
		asignar("TEXT", "codSap", FormatUtils.formatObject(maeProduView.getCodSap(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codiAnti", FormatUtils.formatObject(maeProduView.getCodiAnti(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "desCort", FormatUtils.formatObject(maeProduView.getDesCort(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valJera1", FormatUtils.formatObject(maeProduView.getValJera1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valJera2", FormatUtils.formatObject(maeProduView.getValJera2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valJera3", FormatUtils.formatObject(maeProduView.getValJera3(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valAtri1", FormatUtils.formatObject(maeProduView.getValAtri1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valAtri2", FormatUtils.formatObject(maeProduView.getValAtri2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valAtri3", FormatUtils.formatObject(maeProduView.getValAtri3(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDimeAlto", FormatUtils.formatObject(maeProduView.getValDimeAlto(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDimeLarg", FormatUtils.formatObject(maeProduView.getValDimeLarg(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDimeAnch", FormatUtils.formatObject(maeProduView.getValDimeAnch(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPeso", FormatUtils.formatObject(maeProduView.getValPeso(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valVolu", FormatUtils.formatObject(maeProduView.getValVolu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valCostEstd", FormatUtils.formatObject(maeProduView.getValCostEstd(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPrecPosi", FormatUtils.formatObject(maeProduView.getValPrecPosi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPrecCata", FormatUtils.formatObject(maeProduView.getValPrecCata(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPrecCont", FormatUtils.formatObject(maeProduView.getValPrecCont(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numUnidDentPedi", FormatUtils.formatObject(maeProduView.getNumUnidDentPedi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numUnidCaja", FormatUtils.formatObject(maeProduView.getNumUnidCaja(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codImpu", FormatUtils.formatObject(maeProduView.getCodImpu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "pctUnid", FormatUtils.formatObject(maeProduView.getPctUnid(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indLote", FormatUtils.formatObject(maeProduView.getIndLote(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indProdServ", FormatUtils.formatObject(maeProduView.getIndProdServ(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codIndSitu", FormatUtils.formatObject(maeProduView.getCodIndSitu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codIndDentCaja", FormatUtils.formatObject(maeProduView.getCodIndDentCaja(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indKit", FormatUtils.formatObject(maeProduView.getIndKit(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valGrupArti", FormatUtils.formatObject(maeProduView.getValGrupArti(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		
					asignarAtributo("COMBO", "paisOidPais", "disabled", "S");asignarAtributo("TEXT", "codSap", "disabled", "S");
		asignarAtributo("TEXT", "codiAnti", "disabled", "S");
		asignarAtributo("TEXT", "desCort", "disabled", "S");
		asignarAtributo("TEXT", "valJera1", "disabled", "S");
		asignarAtributo("TEXT", "valJera2", "disabled", "S");
		asignarAtributo("TEXT", "valJera3", "disabled", "S");
		asignarAtributo("TEXT", "valAtri1", "disabled", "S");
		asignarAtributo("TEXT", "valAtri2", "disabled", "S");
		asignarAtributo("TEXT", "valAtri3", "disabled", "S");
		asignarAtributo("TEXT", "valDimeAlto", "disabled", "S");
		asignarAtributo("TEXT", "valDimeLarg", "disabled", "S");
		asignarAtributo("TEXT", "valDimeAnch", "disabled", "S");
		asignarAtributo("TEXT", "valPeso", "disabled", "S");
		asignarAtributo("TEXT", "valVolu", "disabled", "S");
		asignarAtributo("TEXT", "valCostEstd", "disabled", "S");
		asignarAtributo("TEXT", "valPrecPosi", "disabled", "S");
		asignarAtributo("TEXT", "valPrecCata", "disabled", "S");
		asignarAtributo("TEXT", "valPrecCont", "disabled", "S");
		asignarAtributo("TEXT", "numUnidDentPedi", "disabled", "S");
		asignarAtributo("TEXT", "numUnidCaja", "disabled", "S");
		asignarAtributo("TEXT", "codImpu", "disabled", "S");
		asignarAtributo("TEXT", "pctUnid", "disabled", "S");
		asignarAtributo("TEXT", "indLote", "disabled", "S");
		asignarAtributo("TEXT", "indProdServ", "disabled", "S");
		asignarAtributo("TEXT", "codIndSitu", "disabled", "S");
		asignarAtributo("TEXT", "codIndDentCaja", "disabled", "S");
		asignarAtributo("TEXT", "indKit", "disabled", "S");
		asignarAtributo("TEXT", "valGrupArti", "disabled", "S");
		
		
	
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
		asignarAtributo("COMBO", "paisOidPais", "req", "S");
		asignarAtributo("TEXT", "codSap", "req", "S");
		
		
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
		
		asignarAtributo("TEXT", "codSap", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		asignarAtributo("TEXT", "codiAnti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 18);");
		asignarAtributo("TEXT", "desCort", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
		asignarAtributo("TEXT", "valJera1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valJera2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valJera3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valAtri1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valAtri2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 4);");
		asignarAtributo("TEXT", "valAtri3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 10);");
		asignarAtributo("TEXT", "valDimeAlto", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valDimeLarg", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valDimeAnch", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valPeso", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valVolu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valCostEstd", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valCostEstd', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecPosi", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecPosi', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCata", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecCata', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCont", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecCont', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numUnidDentPedi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
		asignarAtributo("TEXT", "numUnidCaja", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
		asignarAtributo("TEXT", "codImpu", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "pctUnid", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "indLote", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indProdServ", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "codIndSitu", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		asignarAtributo("TEXT", "codIndDentCaja", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		asignarAtributo("TEXT", "indKit", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valGrupArti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 9);");
		
		
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
		
		asignarAtributo("TEXT", "codSap", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		asignarAtributo("TEXT", "codiAnti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 18);");
		asignarAtributo("TEXT", "desCort", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
		asignarAtributo("TEXT", "valJera1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valJera2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valJera3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valAtri1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valAtri2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 4);");
		asignarAtributo("TEXT", "valAtri3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 10);");
		asignarAtributo("TEXT", "valDimeAlto", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valDimeLarg", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valDimeAnch", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valPeso", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valVolu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valCostEstd", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valCostEstd', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecPosi", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecPosi', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCata", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecCata', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCont", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecCont', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numUnidDentPedi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
		asignarAtributo("TEXT", "numUnidCaja", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
		asignarAtributo("TEXT", "codImpu", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "pctUnid", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "indLote", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indProdServ", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "codIndSitu", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		asignarAtributo("TEXT", "codIndDentCaja", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		asignarAtributo("TEXT", "indKit", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valGrupArti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 9);");
		
		
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
		
		asignarAtributo("TEXT", "codSap", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		asignarAtributo("TEXT", "codiAnti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 18);");
		asignarAtributo("TEXT", "desCort", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
		asignarAtributo("TEXT", "valJera1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valJera2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valJera3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valAtri1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valAtri2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 4);");
		asignarAtributo("TEXT", "valAtri3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 10);");
		asignarAtributo("TEXT", "valDimeAlto", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valDimeLarg", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valDimeAnch", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valPeso", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valVolu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valCostEstd", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valCostEstd', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecPosi", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecPosi', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCata", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecCata', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCont", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecCont', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numUnidDentPedi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
		asignarAtributo("TEXT", "numUnidCaja", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
		asignarAtributo("TEXT", "codImpu", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "pctUnid", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "indLote", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indProdServ", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "codIndSitu", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		asignarAtributo("TEXT", "codIndDentCaja", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		asignarAtributo("TEXT", "indKit", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valGrupArti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 9);");
		
		
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
		
		asignarAtributo("TEXT", "codSap", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		asignarAtributo("TEXT", "codiAnti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 18);");
		asignarAtributo("TEXT", "desCort", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
		asignarAtributo("TEXT", "valJera1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valJera2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valJera3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valAtri1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
		asignarAtributo("TEXT", "valAtri2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 4);");
		asignarAtributo("TEXT", "valAtri3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 10);");
		asignarAtributo("TEXT", "valDimeAlto", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valDimeLarg", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valDimeAnch", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valPeso", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valVolu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
		asignarAtributo("TEXT", "valCostEstd", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valCostEstd', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecPosi", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecPosi', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCata", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecCata', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCont", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecCont', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numUnidDentPedi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
		asignarAtributo("TEXT", "numUnidCaja", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
		asignarAtributo("TEXT", "codImpu", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "pctUnid", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "indLote", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indProdServ", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "codIndSitu", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		asignarAtributo("TEXT", "codIndDentCaja", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		asignarAtributo("TEXT", "indKit", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valGrupArti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 9);");
		
		
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
		conectorAction("MaeProduViewLPStartUp");
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
		//asignarAtributo("FORMULARIO", "maeProduViewFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("COMBO", "paisOidPais", "req", "S");
				asignarAtributo("TEXT", "codSap", "req", "S");
		
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
		
			
			asignarAtributo("TEXT", "codSap", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
			asignarAtributo("TEXT", "codiAnti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 18);");
			asignarAtributo("TEXT", "desCort", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
			asignarAtributo("TEXT", "valJera1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
			asignarAtributo("TEXT", "valJera2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
			asignarAtributo("TEXT", "valJera3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
			asignarAtributo("TEXT", "valAtri1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 3);");
			asignarAtributo("TEXT", "valAtri2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 4);");
			asignarAtributo("TEXT", "valAtri3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 10);");
			asignarAtributo("TEXT", "valDimeAlto", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
			asignarAtributo("TEXT", "valDimeLarg", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
			asignarAtributo("TEXT", "valDimeAnch", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
			asignarAtributo("TEXT", "valPeso", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
			asignarAtributo("TEXT", "valVolu", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 6, 0, 999999);");
			asignarAtributo("TEXT", "valCostEstd", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valCostEstd', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
			asignarAtributo("TEXT", "valPrecPosi", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecPosi', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
			asignarAtributo("TEXT", "valPrecCata", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecCata', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
			asignarAtributo("TEXT", "valPrecCont", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProduView.valPrecCont', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
			asignarAtributo("TEXT", "numUnidDentPedi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
			asignarAtributo("TEXT", "numUnidCaja", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 5, 0, 99999);");
			asignarAtributo("TEXT", "codImpu", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
			asignarAtributo("TEXT", "pctUnid", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
			asignarAtributo("TEXT", "indLote", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indProdServ", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "codIndSitu", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
			asignarAtributo("TEXT", "codIndDentCaja", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
			asignarAtributo("TEXT", "indKit", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "valGrupArti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 9);");

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando MaeProduView");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		MaeProduViewData maeProduViewQuery= new MaeProduViewData();
		maeProduViewQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		MaeProduViewData  datosResult = (MaeProduViewData)getSingleObject(BUSINESSID_QUERY, maeProduViewQuery, 
			maeProduViewQuery.clone(), "maeProduView");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		MaeProduViewData maeProduView = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		es.indra.belcorp.mso.SegPaisViewData paisOidPais = maeProduView.getPaisOidPais();
		if(paisOidPais != null && paisOidPais.getId() != null) checkCombo("paisOidPais" , paisOidPais.getId().toString());
		asignar("TEXT", "codSap", FormatUtils.formatObject(maeProduView.getCodSap(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codiAnti", FormatUtils.formatObject(maeProduView.getCodiAnti(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "desCort", FormatUtils.formatObject(maeProduView.getDesCort(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valJera1", FormatUtils.formatObject(maeProduView.getValJera1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valJera2", FormatUtils.formatObject(maeProduView.getValJera2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valJera3", FormatUtils.formatObject(maeProduView.getValJera3(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valAtri1", FormatUtils.formatObject(maeProduView.getValAtri1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valAtri2", FormatUtils.formatObject(maeProduView.getValAtri2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valAtri3", FormatUtils.formatObject(maeProduView.getValAtri3(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDimeAlto", FormatUtils.formatObject(maeProduView.getValDimeAlto(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDimeLarg", FormatUtils.formatObject(maeProduView.getValDimeLarg(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDimeAnch", FormatUtils.formatObject(maeProduView.getValDimeAnch(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPeso", FormatUtils.formatObject(maeProduView.getValPeso(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valVolu", FormatUtils.formatObject(maeProduView.getValVolu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valCostEstd", FormatUtils.formatObject(maeProduView.getValCostEstd(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPrecPosi", FormatUtils.formatObject(maeProduView.getValPrecPosi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPrecCata", FormatUtils.formatObject(maeProduView.getValPrecCata(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPrecCont", FormatUtils.formatObject(maeProduView.getValPrecCont(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numUnidDentPedi", FormatUtils.formatObject(maeProduView.getNumUnidDentPedi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numUnidCaja", FormatUtils.formatObject(maeProduView.getNumUnidCaja(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codImpu", FormatUtils.formatObject(maeProduView.getCodImpu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "pctUnid", FormatUtils.formatObject(maeProduView.getPctUnid(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indLote", FormatUtils.formatObject(maeProduView.getIndLote(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indProdServ", FormatUtils.formatObject(maeProduView.getIndProdServ(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codIndSitu", FormatUtils.formatObject(maeProduView.getCodIndSitu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codIndDentCaja", FormatUtils.formatObject(maeProduView.getCodIndDentCaja(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indKit", FormatUtils.formatObject(maeProduView.getIndKit(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valGrupArti", FormatUtils.formatObject(maeProduView.getValGrupArti(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(maeProduView.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
					asignarAtributo("COMBO","paisOidPais", "ontab", "ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
					asignarAtributo("COMBO","paisOidPais", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "codSap", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "codSap", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "codiAnti", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "codiAnti", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "desCort", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "desCort", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valJera1", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valJera1", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valJera2", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valJera2", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valJera3", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valJera3", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valAtri1", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valAtri1", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valAtri2", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valAtri2", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valAtri3", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valAtri3", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valDimeAlto", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valDimeAlto", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valDimeLarg", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valDimeLarg", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valDimeAnch", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valDimeAnch", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valPeso", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valPeso", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valVolu", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valVolu", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valCostEstd", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valCostEstd", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valPrecPosi", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valPrecPosi", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valPrecCata", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valPrecCata", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valPrecCont", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valPrecCont", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "numUnidDentPedi", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "numUnidDentPedi", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "numUnidCaja", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "numUnidCaja", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "codImpu", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "codImpu", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "pctUnid", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "pctUnid", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "indLote", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "indLote", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "indProdServ", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "indProdServ", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "codIndSitu", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "codIndSitu", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "codIndDentCaja", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "codIndDentCaja", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "indKit", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "indKit", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valGrupArti", "ontab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valGrupArti", "onshtab","ejecutarAccionFocoModificacion(\"maeProduViewFrm\",0, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","maeProduViewTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","maeProduViewTrButtons");

		//Borramos los elementos no necesarios de la búsqueda para los campos con búsquda
		//por intervalo
	}
	
	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de view
	*/
	protected void removeNonViewElements() throws Exception{
		
						borrarCampo("id");
	}

	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario en el
	* modo de inserción
	*/
	protected void removeNonInsertElements() throws Exception{
		
						borrarCampo("id");
	}

	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario en el
	* modo de remove
	*/
	protected void removeNonSearchElements() throws Exception{
		borrarCampo("id");
		
	}
	
	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario 
	* de modificación
	*/
	protected void removeNonModifyFields() throws Exception{
		borrarCampo("id");
		
	}
	
	/**
	* Nos permite desactivar los campos del formulario que no deben aparecer en el formulario 
	* para modificación
	*/
	protected void desactivateNonModifyFields() throws Exception{
			traza("MMG: en desactivateNonModifyFields ");		
		
				traza("MMG: el atributo es id...");		
				
				traza("MMG: el atributo es paisOidPais...");		
				
				traza("MMG: el atributo es codSap...");		
				
				traza("MMG: el atributo es codiAnti...");		
				
				traza("MMG: el atributo es desCort...");		
				
				traza("MMG: el atributo es valJera1...");		
				
				traza("MMG: el atributo es valJera2...");		
				
				traza("MMG: el atributo es valJera3...");		
				
				traza("MMG: el atributo es valAtri1...");		
				
				traza("MMG: el atributo es valAtri2...");		
				
				traza("MMG: el atributo es valAtri3...");		
				
				traza("MMG: el atributo es valDimeAlto...");		
				
				traza("MMG: el atributo es valDimeLarg...");		
				
				traza("MMG: el atributo es valDimeAnch...");		
				
				traza("MMG: el atributo es valPeso...");		
				
				traza("MMG: el atributo es valVolu...");		
				
				traza("MMG: el atributo es valCostEstd...");		
				
				traza("MMG: el atributo es valPrecPosi...");		
				
				traza("MMG: el atributo es valPrecCata...");		
				
				traza("MMG: el atributo es valPrecCont...");		
				
				traza("MMG: el atributo es numUnidDentPedi...");		
				
				traza("MMG: el atributo es numUnidCaja...");		
				
				traza("MMG: el atributo es codImpu...");		
				
				traza("MMG: el atributo es pctUnid...");		
				
				traza("MMG: el atributo es indLote...");		
				
				traza("MMG: el atributo es indProdServ...");		
				
				traza("MMG: el atributo es codIndSitu...");		
				
				traza("MMG: el atributo es codIndDentCaja...");		
				
				traza("MMG: el atributo es indKit...");		
				
				traza("MMG: el atributo es valGrupArti...");		
				
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
		asignarAtributo("CAPA","maeProduViewFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","maeProduViewListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","maeProduViewListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(MaeProduViewData maeProduView) throws Exception{
		HashMap checkedCombos = new HashMap();
		SegPaisViewData paisOidPais = new SegPaisViewData();
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, 
			paisOidPais, paisOidPais.clone(), "segPaisView", "paisOidPais", "result_ROWSET" );
		if(maeProduView != null && maeProduView.getPaisOidPais() != null){
				checkCombo("paisOidPais" , maeProduView.getPaisOidPais().getId().toString());
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
		
	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param maeProduView La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(MaeProduViewData maeProduView) 
		throws Exception{
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		MaeProduViewData maeProduView = 
			(MaeProduViewData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(maeProduView.getPaisOidPais() != null){
			maeProduView.setPaisOidPais((es.indra.belcorp.mso.SegPaisViewData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			maeProduView.getPaisOidPais(),
			maeProduView.getPaisOidPais().clone(),
			"segPaisView"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(maeProduView);
		loadLeafDependenceCombos(maeProduView);
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





