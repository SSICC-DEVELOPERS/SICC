/*
    INDRA/CAR/mmg
    $Id: MaeClasiLPStartUp.java,v 1.1 2009/12/03 18:41:00 pecbazalar Exp $
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
public class MaeClasiLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios seg�n el modo
	public static final short QUERYFORM_SIZE = 147;
	public static final short CREATEFORM_SIZE = 129;
	public static final short UPDATEFORM_SIZE = 129;
	public static final short VIEWFORM_SIZE = 129;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGMaeClasiQueryFromToUserPage";
	
	
				public static final String BUSINESSID_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_QUERY ="MMGMaeTipoClienQueryFromToUser";
				public static final String BUSINESSID_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_QUERY ="MMGMaeSubtiClienQueryFromToUser";
				public static final String BUSINESSID_TCCLOIDTIPOCLAS_QUERY ="MMGMaeTipoClasiClienQueryFromToUser";
				public static final String TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_COMBO_CONNECTOR = "MaeTipoClienConectorCombo";	
				public static final String TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_COMBO_CONNECTOR = "MaeSubtiClienConectorCombo";	
				public static final String TCCLOIDTIPOCLAS_COMBO_CONNECTOR = "MaeTipoClasiClienConectorCombo";	
		
	//Hashtables con los valores est�ticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public MaeClasiLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("MaeClasiPage");
	}

	public void ejecucion() throws Exception {
		try{
			//Llamamos al metodo sobresctrito de la clase padre para ejecutar las acciones comunes:
			//obtener configuraci�n del mantenimiento
			super.ejecucion();
		
			this.getFormatosValidaciones();

			//Activamos las trazas
			setTrazaFichero();
			
			//Establecemos el tama�o de la p�gina
			buildJsPageSize("MaeClasi");
			
			//Determinamos la acci�n y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el t�tulo i18nalizado
			//y para que funcione de forma correcta la configuraci�n del men� secundario
			asignarAtributo("PAGINA", "MaeClasiPage", "cod", "MaeClasi." + accion + ".label");
			
			//Ponemos en la p�gina el idioma de usuario, el idioma de la pagina para mostrar los errores, 
			//y el codigo del idioma por defecto
			asignar("VAR", VAR_IDIOMA, MMGDruidaHelper.getUserDefaultLanguage(this));
			asignar("VAR", VAR_IDIOMA_XML, MMGDruidaHelper.getIdioma(this));
			asignar("VAR", VAR_DEFAULT_LANGUAGE_CODE, MMGDruidaHelper.getUserDefaultLanguage(this));
			
			//Establecemos los tama�os y posiciones de la capas de la pantalla
			establecerSizeCapas(accion, origen);
			
			//Establecemos los valores por defecto de la entidades estructurales
			setDefaultStructuralValues();
			
			//Limpiamos la botonera
			limpiarBotoneraLista("maeClasi", accion);
			
			
			
			
			
			//Ejecutanos la acci�n solicitada		
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
		//Establecemos los codigos de internacionalizaci�n para las etiquetas de los campos con b�squeda por intervalo
		setIntervalSearchFromLavels();
	
		//Cargamos las combos finales de las jerarqu�as de herencia
		loadLeafDependenceCombos(null);
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		
		asignarAtributo("TEXT", "codClas", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "Descripcion", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "maeClasiLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "MaeClasiPage", "onblur", "window.focus();");
		
		//Borramos los elementos de internacionalizaci�n()
		removeLocalizationElements();
		removeNonSearchElements();
	}

	/**Acci�n previa para poder permitir la carga de datos en el formulario 
	de view con ventana oculta. Para ello simplemente redireccionamos al m�todo*/
	protected void cmdPreView() throws Exception{
		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION) != null?
			conectorParametro(VAR_LAST_QUERY_TO_SESSION): "");

		//Redirigimos a la acci�n de view pasando la accion, y la acci�n anterior y actulizando el origen
		conectorAction("MaeClasiLPStartUp");
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
		//Construimos el mso con los elementos de la b�squeda a partir del id que
		//lo sacamos de la request
		MaeClasiData maeClasiQuery= new MaeClasiData();
		maeClasiQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acci�n anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		MaeClasiData datosResult = (MaeClasiData)getSingleObject(BUSINESSID_QUERY, maeClasiQuery, 
			maeClasiQuery.clone(), "maeClasi");
		
		
		//Comprobamos que haya datos. Si no indicamos la situaci�n
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Creamos los campos ocultos para la internacionalizaci�n
		preservaHiddensI18n(new Integer(1), "MAE_CLASI", "maeClasiFrm", "Descripcion", true);
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		MaeClasiData maeClasi = datosResult;
		es.indra.belcorp.mso.MaeTipoClasiClienData tcclOidTipoClas = maeClasi.getTcclOidTipoClas();
		if(tcclOidTipoClas != null && tcclOidTipoClas.getId() != null) checkCombo("tcclOidTipoClas" , tcclOidTipoClas.getId().toString());
		asignar("TEXT", "codClas", FormatUtils.formatObject(maeClasi.getCodClas(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		
			
		//Sacamos la informaci�n de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la b�squeda
		//	Creamos el dto y metemos la informaci�n necesaria para ejecutar la query
		//	Invocamos la l�gica de negocio
		loadLocalizationVars(maeClasi);
		
			
		//Deshabilitamos todos los campos para que no se editen
		
									asignarAtributo("COMBO", "tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "disabled", "S");
									asignarAtributo("COMBO", "tcclOidTipoClas_sbtiOidSubtClie", "disabled", "S");
					asignarAtributo("COMBO", "tcclOidTipoClas", "disabled", "S");asignarAtributo("TEXT", "codClas", "disabled", "S");
		asignarAtributo("TEXT", "Descripcion", "disabled", "S");
		
		
	
		//Ponemos la pagina en modo view: Eliminamos el bot�n de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando s�lo el campo simple
		//Eliminamos los elementos correspondientes a la internacionalizacion
		removeLovElements();
		removeQueryElements();
		removeNonViewElements();
		
	}
	
	/**Acciones que se realizan cuando la pantalla se arranca en modo create*/
	protected void cmdCreate() throws Exception{
		//Creamos los campos ocultos para la internacionalizaci�n
		preservaHiddensI18n(new Integer(1), "MAE_CLASI", "maeClasiFrm", "Descripcion", false);
		

		//Cargamos las combos finales de las jerarqu�as de herencia
		loadLeafDependenceCombos(null);
	
		//Ponemos los campos requeridos a true
		asignarAtributo("COMBO", "tcclOidTipoClas", "req", "S");
		asignarAtributo("TEXT", "codClas", "req", "S");
		asignarAtributo("TEXT", "Descripcion", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la funci�n de onblur para actualizar el 
		//valor del idioma por defecto
		asignarAtributo("TEXT", "Descripcion", "onblur", "setDefaultLanguageValue('Descripcion', get('maeClasiFrm.Descripcion'))");
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		
		asignarAtributo("TEXT", "codClas", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "Descripcion", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
		//Ponemos la pagina en modo view: 
		//Eliminamos el bot�n de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando s�lo el campo simple
		removeLovElements();
		removeQueryElements();
		removeNonInsertElements();
	}
	
	/**Acciones a ejecutar cuando la ventana se abre en modo remove*/
	protected void cmdRemove() throws Exception{
		//Establecemos los codigos de internacionalizaci�n para las etiquetas de los campos con b�squeda por intervalo
		setIntervalSearchFromLavels();

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
		userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		
		asignarAtributo("TEXT", "codClas", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "Descripcion", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
		//Actualizamos el legend del formulario para indicar criterios de b�squeda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la p�gina
		//Cargamos las combos finales de las jerarqu�as de herencia
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
		//Establecemos los codigos de internacionalizaci�n para las etiquetas de los campos con b�squeda por intervalo
		setIntervalSearchFromLavels();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
		userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		
		asignarAtributo("TEXT", "codClas", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "Descripcion", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
		//Actualizamos el legend del formulario para indicar criterios de b�squeda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Cargamos las combos finales de las jerarqu�as de herencia
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la p�gina
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}loadLeafDependenceCombos(null);

		//Eliminamos los elementos correspondientes a la internacionalizacion
		//elimnamos el bot�n lov de null selection
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
	}
	
	/**Acciones a ejecutar cuando la ventana se abre en modo update*/
	protected void cmdUpdate() throws Exception{
		//Establecemos los codigos de internacionalizaci�n para las etiquetas de los campos con b�squeda por intervalo
		setIntervalSearchFromLavels();

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		
		asignarAtributo("TEXT", "codClas", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "Descripcion", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
		//Actualizamos el legend del formulario para indicar criterios de b�squeda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Cargamos las combos finales de las jerarqu�as de herencia
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la p�gina
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}loadLeafDependenceCombos(null);

		//Simplemente elimnamos el bot�n lov de null selection y la internacionalizaci�n
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
	}

	
	/**Acci�n previa para poder permitir la carga de datos en el formulario 
	de updatecon ventana oculta. Para ello simplemente redireccionamos al m�todo*/
	protected void cmdPreUpdateForm() throws Exception{
		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION) != null?
			conectorParametro(VAR_LAST_QUERY_TO_SESSION): "");

		//Redirigimos al update form
		conectorAction("MaeClasiLPStartUp");
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
		//Asiganmos el valor a la variable de acci�n anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));

		//Actualizamos el valor de enviar de forma oculta el formulario. 
		//asignarAtributo("FORMULARIO", "maeClasiFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("COMBO", "tcclOidTipoClas", "req", "S");
				asignarAtributo("TEXT", "codClas", "req", "S");
				asignarAtributo("TEXT", "Descripcion", "req", "S");
		
		//Asignamos a los campos internacionalizables la funci�n de onblur para actualizar el valor
		//para el idioma por defecto
		asignarAtributo("TEXT", "Descripcion", "onblur", "setDefaultLanguageValue('Descripcion', get('maeClasiFrm.Descripcion'))");
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		Long loidPais = UtilidadesSession.getPais(this);
		userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		
			
			asignarAtributo("TEXT", "codClas", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
			asignarAtributo("TEXT", "Descripcion", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando MaeClasi");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la b�squeda
		MaeClasiData maeClasiQuery= new MaeClasiData();
		maeClasiQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		MaeClasiData  datosResult = (MaeClasiData)getSingleObject(BUSINESSID_QUERY, maeClasiQuery, 
			maeClasiQuery.clone(), "maeClasi");
		

		//Comprobamos que haya datos. Si no indicamos la situaci�pn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Creamos los campos ocultos para la internacionalizaci�n
		preservaHiddensI18n(new Integer(1), "MAE_CLASI", "maeClasiFrm", "Descripcion", false);
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		MaeClasiData maeClasi = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		es.indra.belcorp.mso.MaeTipoClasiClienData tcclOidTipoClas = maeClasi.getTcclOidTipoClas();
		if(tcclOidTipoClas != null && tcclOidTipoClas.getId() != null) checkCombo("tcclOidTipoClas" , tcclOidTipoClas.getId().toString());
		asignar("TEXT", "codClas", FormatUtils.formatObject(maeClasi.getCodClas(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		

		//Sacamos la informaci�n de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la b�squeda
		//	Creamos el dto y metemos la informaci�n necesaria para ejecutar la query
		//	Invocamos la l�gica de negocio
		
				loadLocalizationVars(maeClasi);
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acci�n
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se est� modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(maeClasi.jdoGetTimeStamp()));
		
		//Ponemos la pagina en modo view: Eliminamos el bot�n de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando s�lo el campo simple
		//Borramos los elementos correspondientes a la internacionalizaci�n
		removeLovElements();
		removeQueryElements();
		removeNonModifyFields();
		/** por eloy mier p�rez para agregar funcionalidad de desactivacion de campos */
		traza("MMG: antes de llamar a desactivateNonModifyFields .....");
		desactivateNonModifyFields();
		traza("MMG: despues de llamar a desactivateNonModifyFields ......");
		/** 
			por eloy mier p�rez para agregar funcionalidad de desactivacion de campos
			para reescribir funciones ontab y onshtab.
		 */
		cambiarAcciones();
	}

	/**
		Por EMP.
		Nos permite cambiar el evento ontab y onshtab de los objetos druida necesarios en el modo
		de modificaci�n.
	*/
	protected void cambiarAcciones() throws Exception{
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"maeClasiFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"maeClasiFrm\",1, false)");
					asignarAtributo("COMBO","tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "ontab", "ejecutarAccionFocoModificacion(\"maeClasiFrm\",2, true)");
					asignarAtributo("COMBO","tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "onshtab", "ejecutarAccionFocoModificacion(\"maeClasiFrm\",2, false)");
					asignarAtributo("COMBO","tcclOidTipoClas_sbtiOidSubtClie", "ontab", "ejecutarAccionFocoModificacion(\"maeClasiFrm\",2, true)");
					asignarAtributo("COMBO","tcclOidTipoClas_sbtiOidSubtClie", "onshtab", "ejecutarAccionFocoModificacion(\"maeClasiFrm\",2, false)");
					asignarAtributo("COMBO","tcclOidTipoClas", "ontab", "ejecutarAccionFocoModificacion(\"maeClasiFrm\",2, true)");
					asignarAtributo("COMBO","tcclOidTipoClas", "onshtab", "ejecutarAccionFocoModificacion(\"maeClasiFrm\",2, false)");
				asignarAtributo("AREATEXTO", "codClas", "ontab","ejecutarAccionFocoModificacion(\"maeClasiFrm\",3, true)");
				asignarAtributo("AREATEXTO", "codClas", "onshtab","ejecutarAccionFocoModificacion(\"maeClasiFrm\",3, false)");
				asignarAtributo("AREATEXTO", "Descripcion", "ontab","ejecutarAccionFocoModificacion(\"maeClasiFrm\",4, true)");
				asignarAtributo("AREATEXTO", "Descripcion", "onshtab","ejecutarAccionFocoModificacion(\"maeClasiFrm\",4, false)");
	}
	
	/**Nos permite eliminar de la p�gina todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
				borrarNodo("TD","nombre","DescripcionTdLocalizationButtonGap");
				borrarNodo("TD","nombre","DescripcionTdLocalizationButtonGapHeader");
				borrarNodo("TD","nombre","DescripcionTdLocalizationButton");
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","maeClasiTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la b�suqeda
		borrarNodo("TR","nombre","maeClasiTrButtons");

		//Borramos los elementos no necesarios de la b�squeda para los campos con b�squda
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
	* modo de inserci�n
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
	* de modificaci�n
	*/
	protected void removeNonModifyFields() throws Exception{
		borrarCampo("id");
		
	}
	
	/**
	* Nos permite desactivar los campos del formulario que no deben aparecer en el formulario 
	* para modificaci�n
	*/
	protected void desactivateNonModifyFields() throws Exception{
			traza("MMG: en desactivateNonModifyFields ");		
		
				traza("MMG: el atributo es id...");		
				
				traza("MMG: el atributo es tcclOidTipoClas...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
									asignarAtributo("COMBO", "tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "disabled", "S");
									asignarAtributo("COMBO", "tcclOidTipoClas_sbtiOidSubtClie", "disabled", "S");
						asignarAtributo("COMBO", "tcclOidTipoClas", "disabled", "S");
				traza("MMG: el atributo es codClas...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						// borrarCampo("codClas");
						asignarAtributo ("TEXT", "codClas", "disabled", "S");
				traza("MMG: el atributo es Descripcion...");		
				
		}

	/**
	* Nos permite establecer el tama�o de las capas de la pantalla seg�n el modo
	* Esto se debe a que dependiendo del modo aparecen unos campos u otros 
	*/
	protected void establecerSizeCapas(String accion, String origen) throws Exception{
		//Dependiendo del modo el tama�o del formualrio ser� uno u otro
		int sizeForm = 0;
		if(accion.equals(ACCION_LOV)) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_VIEW)) sizeForm = VIEWFORM_SIZE;
		else if(accion.equals(ACCION_CREATE)) sizeForm = CREATEFORM_SIZE;
		else if(accion.equals(ACCION_REMOVE)) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_QUERY)) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_UPDATE) && origen.equals("menu")) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_UPDATE) && origen.equals("pagina")) sizeForm = UPDATEFORM_SIZE;
		else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")) sizeForm = UPDATEFORM_SIZE;
		
		//Establecemos el tama�o de la capa del formulario
		asignarAtributo("CAPA","maeClasiFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","maeClasiListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","maeClasiListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarqu�as de dependencia
	*/
	protected void loadLeafDependenceCombos(MaeClasiData maeClasi) throws Exception{
		
		HashMap checkedCombos = new HashMap();
		MaeTipoClienData tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie = 
            new MaeTipoClienData();
		
		asignarComboResultados(BUSINESSID_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_QUERY,
                TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_COMBO_CONNECTOR, 
                tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie, 
                tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie.clone(), 
                "maeTipoClien", "tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", 
                "result_ROWSET" );
        
        // SPLATAS - 12/12/2006 - Bloqueante
		if( maeClasi != null && maeClasi.getTcclOidTipoClas() != null &&
                maeClasi.getTcclOidTipoClas().getSbtiOidSubtClie() != null &&
                maeClasi.getTcclOidTipoClas().getSbtiOidSubtClie().getTiclOidTipoClie() != null){		   
		    
			checkCombo("tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie" ,
                    maeClasi.getTcclOidTipoClas().getSbtiOidSubtClie().getTiclOidTipoClie().getId().toString());
		}		
	}
	
	/**
	* Nos permite cargar en cascada jerarqu�a de combos dependientes por la selecci�n de valor en uno de sus elementos
	*/
	public void cascadeComboLoad(HashMap checkedCombos, String comboName) throws Exception{
		
						if(comboName.trim().equals("tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie") ){			String tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClieDefaultValue = (String)checkedCombos.get("tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie");			if(tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClieDefaultValue != null){				MaeSubtiClienData tcclOidTipoClas_sbtiOidSubtClie= new MaeSubtiClienData();				es.indra.belcorp.mso.MaeTipoClienData tcclOidTipoClas_sbtiOidSubtClieTiclOidTipoClie = new es.indra.belcorp.mso.MaeTipoClienData();				tcclOidTipoClas_sbtiOidSubtClieTiclOidTipoClie.setId(new Long(tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClieDefaultValue ));				tcclOidTipoClas_sbtiOidSubtClie.setTiclOidTipoClie(tcclOidTipoClas_sbtiOidSubtClieTiclOidTipoClie);				asignarComboResultados(BUSINESSID_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_QUERY,TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_COMBO_CONNECTOR, 					tcclOidTipoClas_sbtiOidSubtClie, tcclOidTipoClas_sbtiOidSubtClie.clone(), "maeSubtiClien", "tcclOidTipoClas_sbtiOidSubtClie", "result_ROWSET",false );			}		}
						if(comboName.trim().equals("tcclOidTipoClas_sbtiOidSubtClie") ){			String tcclOidTipoClas_sbtiOidSubtClieDefaultValue = (String)checkedCombos.get("tcclOidTipoClas_sbtiOidSubtClie");			if(tcclOidTipoClas_sbtiOidSubtClieDefaultValue != null){				MaeTipoClasiClienData tcclOidTipoClas= new MaeTipoClasiClienData();				es.indra.belcorp.mso.MaeSubtiClienData tcclOidTipoClasSbtiOidSubtClie = new es.indra.belcorp.mso.MaeSubtiClienData();				tcclOidTipoClasSbtiOidSubtClie.setId(new Long(tcclOidTipoClas_sbtiOidSubtClieDefaultValue ));				tcclOidTipoClas.setSbtiOidSubtClie(tcclOidTipoClasSbtiOidSubtClie);				asignarComboResultados(BUSINESSID_TCCLOIDTIPOCLAS_QUERY,TCCLOIDTIPOCLAS_COMBO_CONNECTOR, 					tcclOidTipoClas, tcclOidTipoClas.clone(), "maeTipoClasiClien", "tcclOidTipoClas", "result_ROWSET",false );			}		}
	}
	
	/**
	* Este m�todo carga todos los combos de una jerarqu�a de dependencia. La carga se realiza c
	* se realiza en funci�n de los datos de un mso del mantenimiento. 
	* @param maeClasi La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(MaeClasiData maeClasi) 
		throws Exception{
		
						if(maeClasi.getTcclOidTipoClas() != null){			
						MaeTipoClasiClienData tcclOidTipoClas = new MaeTipoClasiClienData();			tcclOidTipoClas.setSbtiOidSubtClie(maeClasi.getTcclOidTipoClas().getSbtiOidSubtClie());			asignarComboResultados(BUSINESSID_TCCLOIDTIPOCLAS_QUERY,TCCLOIDTIPOCLAS_COMBO_CONNECTOR, tcclOidTipoClas, tcclOidTipoClas.clone(), "maeTipoClasiClien", "tcclOidTipoClas", "result_ROWSET");			checkCombo("tcclOidTipoClas" , maeClasi.getTcclOidTipoClas().getId().toString());			
						MaeSubtiClienData tcclOidTipoClas_sbtiOidSubtClie = new MaeSubtiClienData();			tcclOidTipoClas_sbtiOidSubtClie.setTiclOidTipoClie(maeClasi.getTcclOidTipoClas().getSbtiOidSubtClie().getTiclOidTipoClie());			asignarComboResultados(BUSINESSID_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_QUERY,TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_COMBO_CONNECTOR, tcclOidTipoClas_sbtiOidSubtClie, tcclOidTipoClas_sbtiOidSubtClie.clone(), "maeSubtiClien", "tcclOidTipoClas_sbtiOidSubtClie", "result_ROWSET");			checkCombo("tcclOidTipoClas_sbtiOidSubtClie" , maeClasi.getTcclOidTipoClas().getSbtiOidSubtClie().getId().toString());			
						}		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la �ltima query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la b�squeda
		MaeClasiData maeClasi = 
			(MaeClasiData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarqu�a de combos dependientes
		if(maeClasi.getTcclOidTipoClas() != null){
			maeClasi.setTcclOidTipoClas((es.indra.belcorp.mso.MaeTipoClasiClienData)
			getSingleObject(BUSINESSID_TCCLOIDTIPOCLAS_QUERY, 
			maeClasi.getTcclOidTipoClas(),
			maeClasi.getTcclOidTipoClas().clone(),
			"maeTipoClasiClien"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarqu�as de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(maeClasi);
		loadLeafDependenceCombos(maeClasi);
	}
	
	/**
	*	Por defecto en los campos que tienen la b�squeda por intervalo el label del campo es el label
	*	correspondiente a campos normal (como si no fuera un campo con intervalor). En los modos de busqueda 
	*	(search, update search y remove search) tendremos que poner el label a la b�squeda "desde"
	*/
	protected void setIntervalSearchFromLavels() throws Exception{
	}
	
	/**
	*	Metodo que nos elimina los trs que quedan vac�os por no aparecer sus campos por el modo
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
	
	
	protected void loadLocalizationVars(MaeClasiData maeClasi) throws Exception{
		GenDetaSiccData mmgLocalizationQuery = null;
		Vector mmgLocalizationDatosResult = null;
		mmgLocalizationQuery = new GenDetaSiccData();
		mmgLocalizationQuery.setEnti("MAE_CLASI");
		mmgLocalizationQuery.setEntiPk(maeClasi.getId());
		mmgLocalizationQuery.setAtri(new Long(1));
		mmgLocalizationDatosResult = getCollectionObjects(BUSINESID_GENDETASICC, mmgLocalizationQuery, 
			mmgLocalizationQuery.clone(), "genDetaSicc");		
		for(Iterator it = mmgLocalizationDatosResult.iterator(); it.hasNext();){
			GenDetaSiccData description = (GenDetaSiccData)it.next();
			if(description.getDeta() != null && !description.getDeta().trim().equals("")){
				asignar("VAR", "hi18NTraduccion_1_" + 
					description.getIdioOidIdio().getId().toString() , description.getDeta());
			}
		}
		
	}
	
	
		
}





