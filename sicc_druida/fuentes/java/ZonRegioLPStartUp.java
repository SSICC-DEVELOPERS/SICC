/*
    INDRA/CAR/mmg
    $Id: ZonRegioLPStartUp.java,v 1.1 2009/12/03 18:40:16 pecbazalar Exp $
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
public class ZonRegioLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 483;
	public static final short CREATEFORM_SIZE = 469;
	public static final short UPDATEFORM_SIZE = 469;
	public static final short VIEWFORM_SIZE = 469;

	//Cosntantes que definene elementos de la lçogica de negocio de las entidada
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGZonRegioQueryFromToUserPageStructuralSecurity";
	
	public static final String BUSINESSID_ZSGVOIDSUBGVENT_QUERY ="MMGZonSubGerenVentaQueryFromToUserStructuralSecurity";
	public static final String ZSGVOIDSUBGVENT_COMBO_CONNECTOR = "ZonSubGerenVentaConectorCombo";
	public static final String BUSINESSID_CLIEOIDCLIE_QUERY ="MMGMaeClienQueryFromToUserStructuralSecurity";
	public static final String CLIEOIDCLIE_COMBO_CONNECTOR = "MaeClienConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public ZonRegioLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("ZonRegioPage");
	}

	public void ejecucion() throws Exception {
		try{
			//Llamamos al metodo sobresctrito de la clase padre para ejecutar las acciones comunes:
			//obtener configuración del mantenimiento
			super.ejecucion();
		
			//Activamos las trazas
			setTrazaFichero();
			
			//Establecemos el tamaño de la página
			buildJsPageSize("ZonRegio");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "ZonRegioPage", "cod", "ZonRegio." + accion + ".label");
			
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
			limpiarBotoneraLista("zonRegio", accion);
			
			
			
			
			//Indicamos que no hay que aplicar seguridad estructural ya que es un entidad structural
			asignar("VAR", VAR_APPLY_STRUCTURAL_ENTITY, "false");
			
			
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
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		asignarAtributo("TEXT", "codRegi", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 2)");
		asignarAtributo("TEXT", "indActi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indBorr", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "codNse1", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "codNse2", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "codNse3", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		
		asignarAtributo("TEXT", "desRegi", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 40)");
		
		asignarAtributo("TEXT", "fecRezo", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		

		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "zonRegioLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "ZonRegioPage", "onblur", "window.focus();");
		
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
		conectorAction("ZonRegioLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro(PARAMETRO_GENERICO_ACCION)!= null?  
			conectorParametro(PARAMETRO_GENERICO_ACCION): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preview");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
		conectorActionParametro(VAR_APPLY_STRUCTURAL_ENTITY, conectorParametro(VAR_APPLY_STRUCTURAL_ENTITY));
			
	}
	
	/**Acciones que se realizan cunado la pantalla se arranca en modo view*/
	protected void cmdView() throws Exception{
		//Construimos el mso con los elementos de la búsqueda a partir del id que
		//lo sacamos de la request
		ZonRegioData zonRegioQuery= new ZonRegioData();
		zonRegioQuery.setId(new Integer(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		ZonRegioData datosResult = (ZonRegioData)getSingleObject(BUSINESSID_QUERY, zonRegioQuery, 
			zonRegioQuery.clone(), "zonRegio", false);
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		ZonRegioData zonRegio = datosResult;
		asignar("TEXT", "codRegi", FormatUtils.formatObject(zonRegio.getCodRegi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "indActi", FormatUtils.formatObject(zonRegio.getIndActi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "indBorr", FormatUtils.formatObject(zonRegio.getIndBorr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "codNse1", FormatUtils.formatObject(zonRegio.getCodNse1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "codNse2", FormatUtils.formatObject(zonRegio.getCodNse2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "codNse3", FormatUtils.formatObject(zonRegio.getCodNse3(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.ZonSubGerenVentaData zsgvOidSubgVent = zonRegio.getZsgvOidSubgVent();
		if(zsgvOidSubgVent != null && zsgvOidSubgVent.getId() != null) checkCombo("zsgvOidSubgVent" , zsgvOidSubgVent.getId().toString());
		asignar("TEXT", "desRegi", FormatUtils.formatObject(zonRegio.getDesRegi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.MaeClienData clieOidClie = zonRegio.getClieOidClie();
		if(clieOidClie != null && clieOidClie.getId() != null) checkCombo("clieOidClie" , clieOidClie.getId().toString());
		asignar("TEXT", "fecRezo", FormatUtils.formatObject(zonRegio.getFecRezo(), 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		asignarAtributo("TEXT", "codRegi", "disabled", "S");
		asignarAtributo("TEXT", "indActi", "disabled", "S");
		asignarAtributo("TEXT", "indBorr", "disabled", "S");
		asignarAtributo("TEXT", "codNse1", "disabled", "S");
		asignarAtributo("TEXT", "codNse2", "disabled", "S");
		asignarAtributo("TEXT", "codNse3", "disabled", "S");
		asignarAtributo("COMBO", "zsgvOidSubgVent", "disabled", "S");
		asignarAtributo("TEXT", "desRegi", "disabled", "S");
		asignarAtributo("COMBO", "clieOidClie", "disabled", "S");
		asignarAtributo("TEXT", "fecRezo", "disabled", "S");
		
		
	
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
		asignarAtributo("TEXT", "codRegi", "req", "S");
		asignarAtributo("COMBO", "zsgvOidSubgVent", "req", "S");
		asignarAtributo("TEXT", "fecRezo", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el 
		//valor del idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		asignarAtributo("TEXT", "codRegi", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 2)");
		asignarAtributo("TEXT", "indActi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indBorr", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "codNse1", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "codNse2", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "codNse3", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		
		asignarAtributo("TEXT", "desRegi", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 40)");
		
		asignarAtributo("TEXT", "fecRezo", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		
		
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
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		asignarAtributo("TEXT", "codRegi", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 2)");
		asignarAtributo("TEXT", "indActi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indBorr", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "codNse1", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "codNse2", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "codNse3", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		
		asignarAtributo("TEXT", "desRegi", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 40)");
		
		asignarAtributo("TEXT", "fecRezo", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		
		
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
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		asignarAtributo("TEXT", "codRegi", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 2)");
		asignarAtributo("TEXT", "indActi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indBorr", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "codNse1", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "codNse2", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "codNse3", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		
		asignarAtributo("TEXT", "desRegi", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 40)");
		
		asignarAtributo("TEXT", "fecRezo", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		
		
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
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		asignarAtributo("TEXT", "codRegi", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 2)");
		asignarAtributo("TEXT", "indActi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indBorr", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "codNse1", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "codNse2", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "codNse3", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		
		asignarAtributo("TEXT", "desRegi", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 40)");
		
		asignarAtributo("TEXT", "fecRezo", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		
		
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
		conectorAction("ZonRegioLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro("accion") != null?
			conectorParametro("accion"): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preupdate");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
		conectorActionParametro(VAR_APPLY_STRUCTURAL_ENTITY, conectorParametro(VAR_APPLY_STRUCTURAL_ENTITY));
			
	}
	
	/**Prepara el formualrio para mostrar los datos de un elemento de la entidad
	y estos puedan ser modificados*/  
	protected void cmdUpdateForm() throws Exception{
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));

		//Actualizamos el valor de enviar de forma oculta el formulario. 
		//asignarAtributo("FORMULARIO", "zonRegioFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		asignarAtributo("TEXT", "codRegi", "req", "S");
		asignarAtributo("COMBO", "zsgvOidSubgVent", "req", "S");
		asignarAtributo("TEXT", "fecRezo", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el valor
		//para el idioma por defecto
		
		

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		asignarAtributo("TEXT", "codRegi", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 2)");
		asignarAtributo("TEXT", "indActi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indBorr", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "codNse1", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "codNse2", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		asignarAtributo("TEXT", "codNse3", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 2)");
		
		asignarAtributo("TEXT", "desRegi", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 40)");
		
		asignarAtributo("TEXT", "fecRezo", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando ZonRegio");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		ZonRegioData zonRegioQuery= new ZonRegioData();
		zonRegioQuery.setId(new Integer(id));

		//Sacamos de la base de datos la entidad a modificar
		ZonRegioData  datosResult = (ZonRegioData)getSingleObject(BUSINESSID_QUERY, zonRegioQuery, 
			zonRegioQuery.clone(), "zonRegio", false);
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		ZonRegioData zonRegio = datosResult;
		asignar("VAR", "idSelection", id);
		asignar("TEXT", "codRegi", FormatUtils.formatObject(zonRegio.getCodRegi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "indActi", FormatUtils.formatObject(zonRegio.getIndActi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "indBorr", FormatUtils.formatObject(zonRegio.getIndBorr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "codNse1", FormatUtils.formatObject(zonRegio.getCodNse1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "codNse2", FormatUtils.formatObject(zonRegio.getCodNse2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "codNse3", FormatUtils.formatObject(zonRegio.getCodNse3(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.ZonSubGerenVentaData zsgvOidSubgVent = zonRegio.getZsgvOidSubgVent();
		if(zsgvOidSubgVent != null && zsgvOidSubgVent.getId() != null) checkCombo("zsgvOidSubgVent" , zsgvOidSubgVent.getId().toString());
		asignar("TEXT", "desRegi", FormatUtils.formatObject(zonRegio.getDesRegi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.MaeClienData clieOidClie = zonRegio.getClieOidClie();
		if(clieOidClie != null && clieOidClie.getId() != null) checkCombo("clieOidClie" , clieOidClie.getId().toString());
		asignar("TEXT", "fecRezo", FormatUtils.formatObject(zonRegio.getFecRezo(), 
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
		//asignar("VAR","timestamp",Long.toString(zonRegio.jdoGetTimeStamp()));
		
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
		borrarNodo("TD","nombre","zonRegioTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","zonRegioTrButtons");

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
		asignarAtributo("CAPA","zonRegioFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","zonRegioListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","zonRegioListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(ZonRegioData zonRegio) throws Exception{
		HashMap checkedCombos = new HashMap();
		ZonSubGerenVentaData zsgvOidSubgVent = new ZonSubGerenVentaData();
		asignarComboResultados(BUSINESSID_ZSGVOIDSUBGVENT_QUERY,ZSGVOIDSUBGVENT_COMBO_CONNECTOR, 
			zsgvOidSubgVent, zsgvOidSubgVent.clone(), "zonSubGerenVenta", "zsgvOidSubgVent", "result_ROWSET",false );
		if(zonRegio != null && zonRegio.getZsgvOidSubgVent() != null){
				checkCombo("zsgvOidSubgVent" , zonRegio.getZsgvOidSubgVent().getId().toString());
			}
		MaeClienData clieOidClie = new MaeClienData();
		asignarComboResultados(BUSINESSID_CLIEOIDCLIE_QUERY,CLIEOIDCLIE_COMBO_CONNECTOR, 
			clieOidClie, clieOidClie.clone(), "maeClien", "clieOidClie", "result_ROWSET",false );
		if(zonRegio != null && zonRegio.getClieOidClie() != null){
				checkCombo("clieOidClie" , zonRegio.getClieOidClie().getId().toString());
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
	* @param zonRegio La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(ZonRegioData zonRegio) 
		throws Exception{
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		ZonRegioData zonRegio = 
			(ZonRegioData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(zonRegio.getZsgvOidSubgVent() != null){
			zonRegio.setZsgvOidSubgVent((es.indra.belcorp.mso.ZonSubGerenVentaData)
			getSingleObject(BUSINESSID_ZSGVOIDSUBGVENT_QUERY, 
			zonRegio.getZsgvOidSubgVent(),
			zonRegio.getZsgvOidSubgVent().clone(),
			"zonSubGerenVenta"));
		}
		if(zonRegio.getClieOidClie() != null){
			zonRegio.setClieOidClie((es.indra.belcorp.mso.MaeClienData)
			getSingleObject(BUSINESSID_CLIEOIDCLIE_QUERY, 
			zonRegio.getClieOidClie(),
			zonRegio.getClieOidClie().clone(),
			"maeClien"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(zonRegio);
		loadLeafDependenceCombos(zonRegio);
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







