/*
    INDRA/CAR/mmg
    $Id: FacFormuLPStartUp.java,v 1.1 2009/12/03 18:41:39 pecbazalar Exp $
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
public class FacFormuLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 189;
	public static final short CREATEFORM_SIZE = 309;
	public static final short UPDATEFORM_SIZE = 309;
	public static final short VIEWFORM_SIZE = 309;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGFacFormuQueryFromToUserPage";
	
	
				public static final String BUSINESSID_TEIMOIDTECN_QUERY ="MMGFacTecnoImpreQueryFromToUser";
				public static final String TEIMOIDTECN_COMBO_CONNECTOR = "FacTecnoImpreConectorCombo";
	
				public static final String BUSINESSID_TIDOOIDTIPODOCU_QUERY ="MMGFacTipoDocumQueryFromToUser";
				public static final String TIDOOIDTIPODOCU_COMBO_CONNECTOR = "FacTipoDocumConectorCombo";
	
				public static final String BUSINESSID_DEIMOIDDESTIMPR_QUERY ="MMGFacDestiImpreQueryFromToUser";
				public static final String DEIMOIDDESTIMPR_COMBO_CONNECTOR = "FacDestiImpreConectorCombo";
	
				public static final String BUSINESSID_TIFOOIDTIPOFORM_QUERY ="MMGFacTipoFormuQueryFromToUser";
				public static final String TIFOOIDTIPOFORM_COMBO_CONNECTOR = "FacTipoFormuConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	protected static Hashtable indImprValues = new Hashtable();
	static{
		indImprValues.put(new java.lang.String("1"), "Si");
		indImprValues.put(new java.lang.String("0"), "No");
	}
	protected static Hashtable indPreiValues = new Hashtable();
	static{
		indPreiValues.put(new java.lang.Long(1), "Si");
		indPreiValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indSpooIndiValues = new Hashtable();
	static{
		indSpooIndiValues.put(new java.lang.Long(1), "Si");
		indSpooIndiValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indActiValues = new Hashtable();
	static{
		indActiValues.put(new java.lang.String("1"), "Activo");
		indActiValues.put(new java.lang.String("0"), "Baja");
	}
	protected static Hashtable indNumOficValues = new Hashtable();
	static{
		indNumOficValues.put(new java.lang.String("1"), "Oficial");
		indNumOficValues.put(new java.lang.String("0"), "Libre");
	}
	
	
	// Definicion del constructor
	public FacFormuLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("FacFormuPage");
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
			buildJsPageSize("FacFormu");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "FacFormuPage", "cod", "FacFormu." + accion + ".label");
			
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
			limpiarBotoneraLista("facFormu", accion);
			
			
			
			
			
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
		asignarAtributo("TEXT", "codForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		
		asignarAtributo("TEXT", "valNombForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 15);");
		
		
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "facFormuLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "FacFormuPage", "onblur", "window.focus();");
		
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
		conectorAction("FacFormuLPStartUp");
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
		FacFormuData facFormuQuery= new FacFormuData();
		facFormuQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		FacFormuData datosResult = (FacFormuData)getSingleObject(BUSINESSID_QUERY, facFormuQuery, 
			facFormuQuery.clone(), "facFormu");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		//Guardamos los valores de los radiobuttons
		if(datosResult.getIndImpr() != null)
			asignar("VAR", "indImprCheckValue", datosResult.getIndImpr().toString());
		if(datosResult.getIndPrei() != null)
			asignar("VAR", "indPreiCheckValue", datosResult.getIndPrei().toString());
		if(datosResult.getIndSpooIndi() != null)
			asignar("VAR", "indSpooIndiCheckValue", datosResult.getIndSpooIndi().toString());
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		FacFormuData facFormu = datosResult;
		asignar("TEXT", "codForm", FormatUtils.formatObject(facFormu.getCodForm(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numLine", FormatUtils.formatObject(facFormu.getNumLine(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valTamaForm", FormatUtils.formatObject(facFormu.getValTamaForm(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valRutiDiseForm", FormatUtils.formatObject(facFormu.getValRutiDiseForm(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indImpr" , "valor", FormatUtils.formatObject(
			facFormu.getIndImpr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indPrei" , "valor", FormatUtils.formatObject(
			facFormu.getIndPrei(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indSpooIndi" , "valor", FormatUtils.formatObject(
			facFormu.getIndSpooIndi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.FacTecnoImpreData teimOidTecn = facFormu.getTeimOidTecn();
		if(teimOidTecn != null && teimOidTecn.getId() != null) checkCombo("teimOidTecn" , teimOidTecn.getId().toString());
		asignar("TEXT", "valNombForm", FormatUtils.formatObject(facFormu.getValNombForm(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(facFormu.getIndActi() != null){	
			checkCombo("indActi", FormatUtils.formatObject(facFormu.getIndActi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		if(facFormu.getIndNumOfic() != null){	
			checkCombo("indNumOfic", FormatUtils.formatObject(facFormu.getIndNumOfic(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignar("TEXT", "numLineSaltPagi", FormatUtils.formatObject(facFormu.getNumLineSaltPagi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.FacTipoDocumData tidoOidTipoDocu = facFormu.getTidoOidTipoDocu();
		if(tidoOidTipoDocu != null && tidoOidTipoDocu.getId() != null) checkCombo("tidoOidTipoDocu" , tidoOidTipoDocu.getId().toString());
		es.indra.belcorp.mso.FacDestiImpreData deimOidDestImpr = facFormu.getDeimOidDestImpr();
		if(deimOidDestImpr != null && deimOidDestImpr.getId() != null) checkCombo("deimOidDestImpr" , deimOidDestImpr.getId().toString());
		es.indra.belcorp.mso.FacTipoFormuData tifoOidTipoForm = facFormu.getTifoOidTipoForm();
		if(tifoOidTipoForm != null && tifoOidTipoForm.getId() != null) checkCombo("tifoOidTipoForm" , tifoOidTipoForm.getId().toString());
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		asignarAtributo("TEXT", "codForm", "disabled", "S");
		asignarAtributo("TEXT", "numLine", "disabled", "S");
		asignarAtributo("TEXT", "valTamaForm", "disabled", "S");
		asignarAtributo("TEXT", "valRutiDiseForm", "disabled", "S");
		
					asignarAtributo("RADIOB", "indImpr", "disabled", "S");
		
					asignarAtributo("RADIOB", "indPrei", "disabled", "S");
		
					asignarAtributo("RADIOB", "indSpooIndi", "disabled", "S");
		
					asignarAtributo("COMBO", "teimOidTecn", "disabled", "S");asignarAtributo("TEXT", "valNombForm", "disabled", "S");
		
					asignarAtributo("COMBO", "indActi", "disabled", "S");
					asignarAtributo("COMBO", "indNumOfic", "disabled", "S");asignarAtributo("TEXT", "numLineSaltPagi", "disabled", "S");
		
					asignarAtributo("COMBO", "tidoOidTipoDocu", "disabled", "S");
					asignarAtributo("COMBO", "deimOidDestImpr", "disabled", "S");
					asignarAtributo("COMBO", "tifoOidTipoForm", "disabled", "S");
		
	
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
		asignarAtributo("TEXT", "codForm", "req", "S");
		asignarAtributo("TEXT", "numLine", "req", "S");
		asignarAtributo("TEXT", "valTamaForm", "req", "S");
		asignarAtributo("TEXT", "valRutiDiseForm", "req", "S");
		asignarAtributo("RADIOB", "indImpr", "req", "S");
		asignarAtributo("RADIOB", "indPrei", "req", "S");
		asignarAtributo("RADIOB", "indSpooIndi", "req", "S");
		asignarAtributo("COMBO", "teimOidTecn", "req", "S");
		asignarAtributo("TEXT", "valNombForm", "req", "S");
		asignarAtributo("COMBO", "indActi", "req", "S");
		asignarAtributo("COMBO", "indNumOfic", "req", "S");
		asignarAtributo("TEXT", "numLineSaltPagi", "req", "S");
		asignarAtributo("COMBO", "deimOidDestImpr", "req", "S");
		
		
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
		asignarAtributo("TEXT", "codForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		asignarAtributo("TEXT", "numLine", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "valTamaForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "valRutiDiseForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
		
		
		
		
		asignarAtributo("TEXT", "valNombForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 15);");
		
		
		asignarAtributo("TEXT", "numLineSaltPagi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		
		
		
		
		
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
		asignarAtributo("TEXT", "codForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		
		asignarAtributo("TEXT", "valNombForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 15);");
		
		
		
		
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
		asignarAtributo("TEXT", "codForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		
		asignarAtributo("TEXT", "valNombForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 15);");
		
		
		
		
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
		asignarAtributo("TEXT", "codForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		
		asignarAtributo("TEXT", "valNombForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 15);");
		
		
		
		
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
		conectorAction("FacFormuLPStartUp");
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
		//asignarAtributo("FORMULARIO", "facFormuFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("TEXT", "codForm", "req", "S");
				asignarAtributo("TEXT", "numLine", "req", "S");
				asignarAtributo("TEXT", "valTamaForm", "req", "S");
				asignarAtributo("TEXT", "valRutiDiseForm", "req", "S");
				asignarAtributo("RADIOB", "indImpr", "req", "S");
				asignarAtributo("RADIOB", "indPrei", "req", "S");
				asignarAtributo("RADIOB", "indSpooIndi", "req", "S");
				asignarAtributo("COMBO", "teimOidTecn", "req", "S");
				asignarAtributo("TEXT", "valNombForm", "req", "S");
				asignarAtributo("COMBO", "indActi", "req", "S");
				asignarAtributo("COMBO", "indNumOfic", "req", "S");
				asignarAtributo("TEXT", "numLineSaltPagi", "req", "S");
				asignarAtributo("COMBO", "deimOidDestImpr", "req", "S");
		
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
		
			asignarAtributo("TEXT", "codForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
			asignarAtributo("TEXT", "numLine", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
			asignarAtributo("TEXT", "valTamaForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
			asignarAtributo("TEXT", "valRutiDiseForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
			
			
			
			
			asignarAtributo("TEXT", "valNombForm", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 15);");
			
			
			asignarAtributo("TEXT", "numLineSaltPagi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
			
			
			

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando FacFormu");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		FacFormuData facFormuQuery= new FacFormuData();
		facFormuQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		FacFormuData  datosResult = (FacFormuData)getSingleObject(BUSINESSID_QUERY, facFormuQuery, 
			facFormuQuery.clone(), "facFormu");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		//Guardamos los valores de los radiobuttons
		if(datosResult.getIndImpr() != null)
			asignar("VAR", "indImprCheckValue", datosResult.getIndImpr().toString());
		if(datosResult.getIndPrei() != null)
			asignar("VAR", "indPreiCheckValue", datosResult.getIndPrei().toString());
		if(datosResult.getIndSpooIndi() != null)
			asignar("VAR", "indSpooIndiCheckValue", datosResult.getIndSpooIndi().toString());
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		FacFormuData facFormu = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		asignar("TEXT", "codForm", FormatUtils.formatObject(facFormu.getCodForm(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numLine", FormatUtils.formatObject(facFormu.getNumLine(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valTamaForm", FormatUtils.formatObject(facFormu.getValTamaForm(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valRutiDiseForm", FormatUtils.formatObject(facFormu.getValRutiDiseForm(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indImpr" , "valor", FormatUtils.formatObject(
			facFormu.getIndImpr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indPrei" , "valor", FormatUtils.formatObject(
			facFormu.getIndPrei(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indSpooIndi" , "valor", FormatUtils.formatObject(
			facFormu.getIndSpooIndi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.FacTecnoImpreData teimOidTecn = facFormu.getTeimOidTecn();
		if(teimOidTecn != null && teimOidTecn.getId() != null) checkCombo("teimOidTecn" , teimOidTecn.getId().toString());
		asignar("TEXT", "valNombForm", FormatUtils.formatObject(facFormu.getValNombForm(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(facFormu.getIndActi() != null){	
			checkCombo("indActi", FormatUtils.formatObject(facFormu.getIndActi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		if(facFormu.getIndNumOfic() != null){	
			checkCombo("indNumOfic", FormatUtils.formatObject(facFormu.getIndNumOfic(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignar("TEXT", "numLineSaltPagi", FormatUtils.formatObject(facFormu.getNumLineSaltPagi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.FacTipoDocumData tidoOidTipoDocu = facFormu.getTidoOidTipoDocu();
		if(tidoOidTipoDocu != null && tidoOidTipoDocu.getId() != null) checkCombo("tidoOidTipoDocu" , tidoOidTipoDocu.getId().toString());
		es.indra.belcorp.mso.FacDestiImpreData deimOidDestImpr = facFormu.getDeimOidDestImpr();
		if(deimOidDestImpr != null && deimOidDestImpr.getId() != null) checkCombo("deimOidDestImpr" , deimOidDestImpr.getId().toString());
		es.indra.belcorp.mso.FacTipoFormuData tifoOidTipoForm = facFormu.getTifoOidTipoForm();
		if(tifoOidTipoForm != null && tifoOidTipoForm.getId() != null) checkCombo("tifoOidTipoForm" , tifoOidTipoForm.getId().toString());
		

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(facFormu.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"facFormuFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"facFormuFrm\",1, false)");
				asignarAtributo("AREATEXTO", "codForm", "ontab","ejecutarAccionFocoModificacion(\"facFormuFrm\",2, true)");
				asignarAtributo("AREATEXTO", "codForm", "onshtab","ejecutarAccionFocoModificacion(\"facFormuFrm\",2, false)");
				asignarAtributo("AREATEXTO", "numLine", "ontab","ejecutarAccionFocoModificacion(\"facFormuFrm\",3, true)");
				asignarAtributo("AREATEXTO", "numLine", "onshtab","ejecutarAccionFocoModificacion(\"facFormuFrm\",3, false)");
				asignarAtributo("AREATEXTO", "valTamaForm", "ontab","ejecutarAccionFocoModificacion(\"facFormuFrm\",4, true)");
				asignarAtributo("AREATEXTO", "valTamaForm", "onshtab","ejecutarAccionFocoModificacion(\"facFormuFrm\",4, false)");
				asignarAtributo("AREATEXTO", "valRutiDiseForm", "ontab","ejecutarAccionFocoModificacion(\"facFormuFrm\",5, true)");
				asignarAtributo("AREATEXTO", "valRutiDiseForm", "onshtab","ejecutarAccionFocoModificacion(\"facFormuFrm\",5, false)");
				asignarAtributo("TEXT", "indImpr", "ontab","ejecutarAccionFocoModificacion(\"facFormuFrm\",6, true)");
				asignarAtributo("TEXT", "indImpr", "onshtab","ejecutarAccionFocoModificacion(\"facFormuFrm\",6, false)");
				asignarAtributo("TEXT", "indPrei", "ontab","ejecutarAccionFocoModificacion(\"facFormuFrm\",7, true)");
				asignarAtributo("TEXT", "indPrei", "onshtab","ejecutarAccionFocoModificacion(\"facFormuFrm\",7, false)");
				asignarAtributo("TEXT", "indSpooIndi", "ontab","ejecutarAccionFocoModificacion(\"facFormuFrm\",8, true)");
				asignarAtributo("TEXT", "indSpooIndi", "onshtab","ejecutarAccionFocoModificacion(\"facFormuFrm\",8, false)");
					asignarAtributo("COMBO","teimOidTecn", "ontab", "ejecutarAccionFocoModificacion(\"facFormuFrm\",9, true)");
					asignarAtributo("COMBO","teimOidTecn", "onshtab", "ejecutarAccionFocoModificacion(\"facFormuFrm\",9, false)");
				asignarAtributo("AREATEXTO", "valNombForm", "ontab","ejecutarAccionFocoModificacion(\"facFormuFrm\",10, true)");
				asignarAtributo("AREATEXTO", "valNombForm", "onshtab","ejecutarAccionFocoModificacion(\"facFormuFrm\",10, false)");
				asignarAtributo("TEXT", "indActi", "ontab","ejecutarAccionFocoModificacion(\"facFormuFrm\",11, true)");
				asignarAtributo("TEXT", "indActi", "onshtab","ejecutarAccionFocoModificacion(\"facFormuFrm\",11, false)");
				asignarAtributo("TEXT", "indNumOfic", "ontab","ejecutarAccionFocoModificacion(\"facFormuFrm\",12, true)");
				asignarAtributo("TEXT", "indNumOfic", "onshtab","ejecutarAccionFocoModificacion(\"facFormuFrm\",12, false)");
				asignarAtributo("AREATEXTO", "numLineSaltPagi", "ontab","ejecutarAccionFocoModificacion(\"facFormuFrm\",13, true)");
				asignarAtributo("AREATEXTO", "numLineSaltPagi", "onshtab","ejecutarAccionFocoModificacion(\"facFormuFrm\",13, false)");
					asignarAtributo("COMBO","tidoOidTipoDocu", "ontab", "ejecutarAccionFocoModificacion(\"facFormuFrm\",14, true)");
					asignarAtributo("COMBO","tidoOidTipoDocu", "onshtab", "ejecutarAccionFocoModificacion(\"facFormuFrm\",14, false)");
					asignarAtributo("COMBO","deimOidDestImpr", "ontab", "ejecutarAccionFocoModificacion(\"facFormuFrm\",15, true)");
					asignarAtributo("COMBO","deimOidDestImpr", "onshtab", "ejecutarAccionFocoModificacion(\"facFormuFrm\",15, false)");
					asignarAtributo("COMBO","tifoOidTipoForm", "ontab", "ejecutarAccionFocoModificacion(\"facFormuFrm\",16, true)");
					asignarAtributo("COMBO","tifoOidTipoForm", "onshtab", "ejecutarAccionFocoModificacion(\"facFormuFrm\",16, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","facFormuTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","facFormuTrButtons");

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
		borrarCampo("numLine");
		borrarCampo("valTamaForm");
		borrarCampo("valRutiDiseForm");
		borrarCampo("indPrei");
		borrarCampo("indSpooIndi");
		borrarCampo("teimOidTecn");
		borrarCampo("indNumOfic");
		borrarCampo("numLineSaltPagi");
		borrarCampo("deimOidDestImpr");
		borrarCampo("tifoOidTipoForm");
		
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
				
				traza("MMG: el atributo es codForm...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						// borrarCampo("codForm");
						asignarAtributo ("TEXT", "codForm", "disabled", "S");
				traza("MMG: el atributo es numLine...");		
				
				traza("MMG: el atributo es valTamaForm...");		
				
				traza("MMG: el atributo es valRutiDiseForm...");		
				
				traza("MMG: el atributo es indImpr...");		
				
				traza("MMG: el atributo es indPrei...");		
				
				traza("MMG: el atributo es indSpooIndi...");		
				
				traza("MMG: el atributo es teimOidTecn...");		
				
				traza("MMG: el atributo es valNombForm...");		
				
				traza("MMG: el atributo es indActi...");		
				
				traza("MMG: el atributo es indNumOfic...");		
				
				traza("MMG: el atributo es numLineSaltPagi...");		
				
				traza("MMG: el atributo es tidoOidTipoDocu...");		
				
				traza("MMG: el atributo es deimOidDestImpr...");		
				
				traza("MMG: el atributo es tifoOidTipoForm...");		
				
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
		asignarAtributo("CAPA","facFormuFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","facFormuListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","facFormuListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(FacFormuData facFormu) throws Exception{
		HashMap checkedCombos = new HashMap();
		FacTecnoImpreData teimOidTecn = new FacTecnoImpreData();
		
						asignarComboResultados(BUSINESSID_TEIMOIDTECN_QUERY,TEIMOIDTECN_COMBO_CONNECTOR, 
			teimOidTecn, teimOidTecn.clone(), "facTecnoImpre", "teimOidTecn", "result_ROWSET" );
		if(facFormu != null && facFormu.getTeimOidTecn() != null){
				checkCombo("teimOidTecn" , facFormu.getTeimOidTecn().getId().toString());
			}
		FacTipoDocumData tidoOidTipoDocu = new FacTipoDocumData();
		
						asignarComboResultados(BUSINESSID_TIDOOIDTIPODOCU_QUERY,TIDOOIDTIPODOCU_COMBO_CONNECTOR, 
			tidoOidTipoDocu, tidoOidTipoDocu.clone(), "facTipoDocum", "tidoOidTipoDocu", "result_ROWSET" );
		if(facFormu != null && facFormu.getTidoOidTipoDocu() != null){
				checkCombo("tidoOidTipoDocu" , facFormu.getTidoOidTipoDocu().getId().toString());
			}
		FacDestiImpreData deimOidDestImpr = new FacDestiImpreData();
		
						asignarComboResultados(BUSINESSID_DEIMOIDDESTIMPR_QUERY,DEIMOIDDESTIMPR_COMBO_CONNECTOR, 
			deimOidDestImpr, deimOidDestImpr.clone(), "facDestiImpre", "deimOidDestImpr", "result_ROWSET" );
		if(facFormu != null && facFormu.getDeimOidDestImpr() != null){
				checkCombo("deimOidDestImpr" , facFormu.getDeimOidDestImpr().getId().toString());
			}
		FacTipoFormuData tifoOidTipoForm = new FacTipoFormuData();
		
						asignarComboResultados(BUSINESSID_TIFOOIDTIPOFORM_QUERY,TIFOOIDTIPOFORM_COMBO_CONNECTOR, 
			tifoOidTipoForm, tifoOidTipoForm.clone(), "facTipoFormu", "tifoOidTipoForm", "result_ROWSET" );
		if(facFormu != null && facFormu.getTifoOidTipoForm() != null){
				checkCombo("tifoOidTipoForm" , facFormu.getTifoOidTipoForm().getId().toString());
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
	* @param facFormu La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(FacFormuData facFormu) 
		throws Exception{
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		FacFormuData facFormu = 
			(FacFormuData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(facFormu.getTeimOidTecn() != null){
			facFormu.setTeimOidTecn((es.indra.belcorp.mso.FacTecnoImpreData)
			getSingleObject(BUSINESSID_TEIMOIDTECN_QUERY, 
			facFormu.getTeimOidTecn(),
			facFormu.getTeimOidTecn().clone(),
			"facTecnoImpre"));
		}
		if(facFormu.getTidoOidTipoDocu() != null){
			facFormu.setTidoOidTipoDocu((es.indra.belcorp.mso.FacTipoDocumData)
			getSingleObject(BUSINESSID_TIDOOIDTIPODOCU_QUERY, 
			facFormu.getTidoOidTipoDocu(),
			facFormu.getTidoOidTipoDocu().clone(),
			"facTipoDocum"));
		}
		if(facFormu.getDeimOidDestImpr() != null){
			facFormu.setDeimOidDestImpr((es.indra.belcorp.mso.FacDestiImpreData)
			getSingleObject(BUSINESSID_DEIMOIDDESTIMPR_QUERY, 
			facFormu.getDeimOidDestImpr(),
			facFormu.getDeimOidDestImpr().clone(),
			"facDestiImpre"));
		}
		if(facFormu.getTifoOidTipoForm() != null){
			facFormu.setTifoOidTipoForm((es.indra.belcorp.mso.FacTipoFormuData)
			getSingleObject(BUSINESSID_TIFOOIDTIPOFORM_QUERY, 
			facFormu.getTifoOidTipoForm(),
			facFormu.getTifoOidTipoForm().clone(),
			"facTipoFormu"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(facFormu);
		loadLeafDependenceCombos(facFormu);
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
			borrarNodo("TR","nombre","formTr2");
			borrarNodo("TR","nombre","formGapTr2");
			borrarNodo("TR","nombre","formTr3");
			borrarNodo("TR","nombre","formGapTr3");
			borrarNodo("TR","nombre","formTr6");
			borrarNodo("TR","nombre","formGapTr6");
			
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





