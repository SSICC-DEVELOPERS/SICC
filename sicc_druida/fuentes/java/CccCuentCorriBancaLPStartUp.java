/*
    INDRA/CAR/mmg
    $Id: CccCuentCorriBancaLPStartUp.java,v 1.1 2009/12/03 18:39:27 pecbazalar Exp $
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
public class CccCuentCorriBancaLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 273;
	public static final short CREATEFORM_SIZE = 417;
	public static final short UPDATEFORM_SIZE = 417;
	public static final short VIEWFORM_SIZE = 417;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGCccCuentCorriBancaQueryFromToUserPage";
	
	
				public static final String BUSINESSID_SOCIOIDSOCI_QUERY ="MMGSegSocieQueryFromToUser";
				public static final String SOCIOIDSOCI_COMBO_CONNECTOR = "SegSocieConectorCombo";
	
				public static final String BUSINESSID_CUCOOIDCCTESO_QUERY ="MMGCccCuentContaQueryFromToUser";
				public static final String CUCOOIDCCTESO_COMBO_CONNECTOR = "CccCuentContaConectorCombo";
	
				public static final String BUSINESSID_CUCOOIDCCPNTE_QUERY ="MMGCccCuentContaQueryFromToUser";
				public static final String CUCOOIDCCPNTE_COMBO_CONNECTOR = "CccCuentContaConectorCombo";
	
				public static final String BUSINESSID_SUCUOIDSUCU_CBANOIDBANC_QUERY ="MMGCccBancoQueryFromToUser";
				public static final String BUSINESSID_SUCUOIDSUCU_QUERY ="MMGCccSucurQueryFromToUser";
				public static final String SUCUOIDSUCU_CBANOIDBANC_COMBO_CONNECTOR = "CccBancoConectorCombo";
	
				public static final String SUCUOIDSUCU_COMBO_CONNECTOR = "CccSucurConectorCombo";
	
				public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisViewQueryFromToUser";
				public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisViewConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public CccCuentCorriBancaLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("CccCuentCorriBancaPage");
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
			buildJsPageSize("CccCuentCorriBanca");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "CccCuentCorriBancaPage", "cod", "CccCuentCorriBanca." + accion + ".label");
			
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
			limpiarBotoneraLista("cccCuentCorriBanca", accion);
			
			
			
			
			
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
		asignarAtributo("TEXT", "codCc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 7);");
		
		asignarAtributo("TEXT", "desCc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
		asignarAtributo("TEXT", "codCcBanc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "cccCuentCorriBancaLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "CccCuentCorriBancaPage", "onblur", "window.focus();");
		
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
		conectorAction("CccCuentCorriBancaLPStartUp");
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
		CccCuentCorriBancaData cccCuentCorriBancaQuery= new CccCuentCorriBancaData();
		cccCuentCorriBancaQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		CccCuentCorriBancaData datosResult = (CccCuentCorriBancaData)getSingleObject(BUSINESSID_QUERY, cccCuentCorriBancaQuery, 
			cccCuentCorriBancaQuery.clone(), "cccCuentCorriBanca");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		CccCuentCorriBancaData cccCuentCorriBanca = datosResult;
		asignar("TEXT", "codCc", FormatUtils.formatObject(cccCuentCorriBanca.getCodCc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.SegSocieData sociOidSoci = cccCuentCorriBanca.getSociOidSoci();
		if(sociOidSoci != null && sociOidSoci.getId() != null) checkCombo("sociOidSoci" , sociOidSoci.getId().toString());
		asignar("TEXT", "desCc", FormatUtils.formatObject(cccCuentCorriBanca.getDesCc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.CccCuentContaData cucoOidCcTeso = cccCuentCorriBanca.getCucoOidCcTeso();
		if(cucoOidCcTeso != null && cucoOidCcTeso.getId() != null) checkCombo("cucoOidCcTeso" , cucoOidCcTeso.getId().toString());
		es.indra.belcorp.mso.CccCuentContaData cucoOidCcPnte = cccCuentCorriBanca.getCucoOidCcPnte();
		if(cucoOidCcPnte != null && cucoOidCcPnte.getId() != null) checkCombo("cucoOidCcPnte" , cucoOidCcPnte.getId().toString());
		asignar("TEXT", "codCcBanc", FormatUtils.formatObject(cccCuentCorriBanca.getCodCcBanc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.CccSucurData sucuOidSucu = cccCuentCorriBanca.getSucuOidSucu();
		if(sucuOidSucu != null && sucuOidSucu.getId() != null) checkCombo("sucuOidSucu" , sucuOidSucu.getId().toString());
		asignar("TEXT", "valNumeSwif", FormatUtils.formatObject(cccCuentCorriBanca.getValNumeSwif(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDire", FormatUtils.formatObject(cccCuentCorriBanca.getValDire(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valCont", FormatUtils.formatObject(cccCuentCorriBanca.getValCont(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valTele", FormatUtils.formatObject(cccCuentCorriBanca.getValTele(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("AREATEXTO", "valObse", FormatUtils.formatObject(cccCuentCorriBanca.getValObse(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		asignarAtributo("TEXT", "codCc", "disabled", "S");
		
					asignarAtributo("COMBO", "sociOidSoci", "disabled", "S");asignarAtributo("TEXT", "desCc", "disabled", "S");
		
					asignarAtributo("COMBO", "cucoOidCcTeso", "disabled", "S");
					asignarAtributo("COMBO", "cucoOidCcPnte", "disabled", "S");asignarAtributo("TEXT", "codCcBanc", "disabled", "S");
		
									asignarAtributo("COMBO", "sucuOidSucu_cbanOidBanc", "disabled", "S");

					asignarAtributo("COMBO", "sucuOidSucu", "disabled", "S");asignarAtributo("TEXT", "valNumeSwif", "disabled", "S");
		asignarAtributo("TEXT", "valDire", "disabled", "S");
		asignarAtributo("TEXT", "valCont", "disabled", "S");
		asignarAtributo("TEXT", "valTele", "disabled", "S");
		asignarAtributo("AREATEXTO", "valObse", "disabled", "S");
		
		
	
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
		asignarAtributo("TEXT", "codCc", "req", "S");
		asignarAtributo("COMBO", "sociOidSoci", "req", "S");
		asignarAtributo("TEXT", "desCc", "req", "S");
		asignarAtributo("COMBO", "cucoOidCcTeso", "req", "S");
		asignarAtributo("COMBO", "cucoOidCcPnte", "req", "S");
		asignarAtributo("TEXT", "codCcBanc", "req", "S");
		asignarAtributo("COMBO", "sucuOidSucu", "req", "S");
		
		
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
		asignarAtributo("TEXT", "codCc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 7);");
		
		asignarAtributo("TEXT", "desCc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
		asignarAtributo("TEXT", "codCcBanc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		asignarAtributo("TEXT", "valNumeSwif", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
		asignarAtributo("TEXT", "valDire", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
		asignarAtributo("TEXT", "valCont", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
		asignarAtributo("TEXT", "valTele", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 30);");
		asignarAtributo("AREATEXTO", "valObse", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		
		
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
		asignarAtributo("TEXT", "codCc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 7);");
		
		asignarAtributo("TEXT", "desCc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
		asignarAtributo("TEXT", "codCcBanc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		
		
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
		asignarAtributo("TEXT", "codCc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 7);");
		
		asignarAtributo("TEXT", "desCc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
		asignarAtributo("TEXT", "codCcBanc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		
		
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
		asignarAtributo("TEXT", "codCc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 7);");
		
		asignarAtributo("TEXT", "desCc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
		asignarAtributo("TEXT", "codCcBanc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		
		
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
		conectorAction("CccCuentCorriBancaLPStartUp");
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
		//asignarAtributo("FORMULARIO", "cccCuentCorriBancaFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("TEXT", "codCc", "req", "S");
				asignarAtributo("COMBO", "sociOidSoci", "req", "S");
				asignarAtributo("TEXT", "desCc", "req", "S");
				asignarAtributo("COMBO", "cucoOidCcTeso", "req", "S");
				asignarAtributo("COMBO", "cucoOidCcPnte", "req", "S");
				asignarAtributo("TEXT", "codCcBanc", "req", "S");
				asignarAtributo("COMBO", "sucuOidSucu", "req", "S");
		
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
		
			asignarAtributo("TEXT", "codCc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 7);");
			
			asignarAtributo("TEXT", "desCc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
			
			
			asignarAtributo("TEXT", "codCcBanc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
			
			asignarAtributo("TEXT", "valNumeSwif", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
			asignarAtributo("TEXT", "valDire", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
			asignarAtributo("TEXT", "valCont", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
			asignarAtributo("TEXT", "valTele", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 30);");
			asignarAtributo("AREATEXTO", "valObse", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando CccCuentCorriBanca");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		CccCuentCorriBancaData cccCuentCorriBancaQuery= new CccCuentCorriBancaData();
		cccCuentCorriBancaQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		CccCuentCorriBancaData  datosResult = (CccCuentCorriBancaData)getSingleObject(BUSINESSID_QUERY, cccCuentCorriBancaQuery, 
			cccCuentCorriBancaQuery.clone(), "cccCuentCorriBanca");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		CccCuentCorriBancaData cccCuentCorriBanca = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		asignar("TEXT", "codCc", FormatUtils.formatObject(cccCuentCorriBanca.getCodCc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.SegSocieData sociOidSoci = cccCuentCorriBanca.getSociOidSoci();
		if(sociOidSoci != null && sociOidSoci.getId() != null) checkCombo("sociOidSoci" , sociOidSoci.getId().toString());
		asignar("TEXT", "desCc", FormatUtils.formatObject(cccCuentCorriBanca.getDesCc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.CccCuentContaData cucoOidCcTeso = cccCuentCorriBanca.getCucoOidCcTeso();
		if(cucoOidCcTeso != null && cucoOidCcTeso.getId() != null) checkCombo("cucoOidCcTeso" , cucoOidCcTeso.getId().toString());
		es.indra.belcorp.mso.CccCuentContaData cucoOidCcPnte = cccCuentCorriBanca.getCucoOidCcPnte();
		if(cucoOidCcPnte != null && cucoOidCcPnte.getId() != null) checkCombo("cucoOidCcPnte" , cucoOidCcPnte.getId().toString());
		asignar("TEXT", "codCcBanc", FormatUtils.formatObject(cccCuentCorriBanca.getCodCcBanc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.CccSucurData sucuOidSucu = cccCuentCorriBanca.getSucuOidSucu();
		if(sucuOidSucu != null && sucuOidSucu.getId() != null) checkCombo("sucuOidSucu" , sucuOidSucu.getId().toString());
		asignar("TEXT", "valNumeSwif", FormatUtils.formatObject(cccCuentCorriBanca.getValNumeSwif(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDire", FormatUtils.formatObject(cccCuentCorriBanca.getValDire(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valCont", FormatUtils.formatObject(cccCuentCorriBanca.getValCont(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valTele", FormatUtils.formatObject(cccCuentCorriBanca.getValTele(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("AREATEXTO", "valObse", FormatUtils.formatObject(cccCuentCorriBanca.getValObse(), 
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
		//asignar("VAR","timestamp",Long.toString(cccCuentCorriBanca.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",1, false)");
				asignarAtributo("AREATEXTO", "codCc", "ontab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",2, true)");
				asignarAtributo("AREATEXTO", "codCc", "onshtab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",2, false)");
					asignarAtributo("COMBO","sociOidSoci", "ontab", "ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",3, true)");
					asignarAtributo("COMBO","sociOidSoci", "onshtab", "ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",3, false)");
				asignarAtributo("AREATEXTO", "desCc", "ontab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",4, true)");
				asignarAtributo("AREATEXTO", "desCc", "onshtab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",4, false)");
					asignarAtributo("COMBO","cucoOidCcTeso", "ontab", "ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",5, true)");
					asignarAtributo("COMBO","cucoOidCcTeso", "onshtab", "ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",5, false)");
					asignarAtributo("COMBO","cucoOidCcPnte", "ontab", "ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",6, true)");
					asignarAtributo("COMBO","cucoOidCcPnte", "onshtab", "ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",6, false)");
				asignarAtributo("AREATEXTO", "codCcBanc", "ontab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",7, true)");
				asignarAtributo("AREATEXTO", "codCcBanc", "onshtab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",7, false)");
					asignarAtributo("COMBO","sucuOidSucu_cbanOidBanc", "ontab", "ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",8, true)");
					asignarAtributo("COMBO","sucuOidSucu_cbanOidBanc", "onshtab", "ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",8, false)");
					asignarAtributo("COMBO","sucuOidSucu", "ontab", "ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",8, true)");
					asignarAtributo("COMBO","sucuOidSucu", "onshtab", "ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",8, false)");
				asignarAtributo("AREATEXTO", "valNumeSwif", "ontab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",9, true)");
				asignarAtributo("AREATEXTO", "valNumeSwif", "onshtab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",9, false)");
				asignarAtributo("AREATEXTO", "valDire", "ontab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",10, true)");
				asignarAtributo("AREATEXTO", "valDire", "onshtab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",10, false)");
				asignarAtributo("AREATEXTO", "valCont", "ontab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",11, true)");
				asignarAtributo("AREATEXTO", "valCont", "onshtab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",11, false)");
				asignarAtributo("AREATEXTO", "valTele", "ontab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",12, true)");
				asignarAtributo("AREATEXTO", "valTele", "onshtab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",12, false)");
				asignarAtributo("AREATEXTO", "valObse", "ontab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",13, true)");
				asignarAtributo("AREATEXTO", "valObse", "onshtab","ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",13, false)");
					asignarAtributo("COMBO","paisOidPais", "ontab", "ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",14, true)");
					asignarAtributo("COMBO","paisOidPais", "onshtab", "ejecutarAccionFocoModificacion(\"cccCuentCorriBancaFrm\",14, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","cccCuentCorriBancaTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","cccCuentCorriBancaTrButtons");

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
		borrarCampo("valNumeSwif");
		borrarCampo("valDire");
		borrarCampo("valCont");
		borrarCampo("valTele");
		borrarCampo("valObse");
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
				
				traza("MMG: el atributo es codCc...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						// borrarCampo("codCc");
						asignarAtributo ("TEXT", "codCc", "disabled", "S");
				traza("MMG: el atributo es sociOidSoci...");		
				
				traza("MMG: el atributo es desCc...");		
				
				traza("MMG: el atributo es cucoOidCcTeso...");		
				
				traza("MMG: el atributo es cucoOidCcPnte...");		
				
				traza("MMG: el atributo es codCcBanc...");		
				
				traza("MMG: el atributo es sucuOidSucu...");		
				
				traza("MMG: el atributo es valNumeSwif...");		
				
				traza("MMG: el atributo es valDire...");		
				
				traza("MMG: el atributo es valCont...");		
				
				traza("MMG: el atributo es valTele...");		
				
				traza("MMG: el atributo es valObse...");		
				
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
		asignarAtributo("CAPA","cccCuentCorriBancaFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","cccCuentCorriBancaListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","cccCuentCorriBancaListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(CccCuentCorriBancaData cccCuentCorriBanca) throws Exception{
		HashMap checkedCombos = new HashMap();
		SegSocieData sociOidSoci = new SegSocieData();
		
						asignarComboResultados(BUSINESSID_SOCIOIDSOCI_QUERY,SOCIOIDSOCI_COMBO_CONNECTOR, 
			sociOidSoci, sociOidSoci.clone(), "segSocie", "sociOidSoci", "result_ROWSET" );
		if(cccCuentCorriBanca != null && cccCuentCorriBanca.getSociOidSoci() != null){
				checkCombo("sociOidSoci" , cccCuentCorriBanca.getSociOidSoci().getId().toString());
			}
		String sociOidSociDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegSocie");
		if(sociOidSociDefaultValue != null && !sociOidSociDefaultValue.trim().equals("")){
			checkCombo("sociOidSoci", sociOidSociDefaultValue);
			checkedCombos.put("sociOidSoci",sociOidSociDefaultValue);
			cascadeComboLoad(checkedCombos, "sociOidSoci");
		}						 
		CccCuentContaData cucoOidCcTeso = new CccCuentContaData();
		
						asignarComboResultados(BUSINESSID_CUCOOIDCCTESO_QUERY,CUCOOIDCCTESO_COMBO_CONNECTOR, 
			cucoOidCcTeso, cucoOidCcTeso.clone(), "cccCuentConta", "cucoOidCcTeso", "result_ROWSET" );
		if(cccCuentCorriBanca != null && cccCuentCorriBanca.getCucoOidCcTeso() != null){
				checkCombo("cucoOidCcTeso" , cccCuentCorriBanca.getCucoOidCcTeso().getId().toString());
			}
		CccCuentContaData cucoOidCcPnte = new CccCuentContaData();
		
						asignarComboResultados(BUSINESSID_CUCOOIDCCPNTE_QUERY,CUCOOIDCCPNTE_COMBO_CONNECTOR, 
			cucoOidCcPnte, cucoOidCcPnte.clone(), "cccCuentConta", "cucoOidCcPnte", "result_ROWSET" );
		if(cccCuentCorriBanca != null && cccCuentCorriBanca.getCucoOidCcPnte() != null){
				checkCombo("cucoOidCcPnte" , cccCuentCorriBanca.getCucoOidCcPnte().getId().toString());
			}
		CccBancoData sucuOidSucu_cbanOidBanc = new CccBancoData();
		
						asignarComboResultados(BUSINESSID_SUCUOIDSUCU_CBANOIDBANC_QUERY,SUCUOIDSUCU_CBANOIDBANC_COMBO_CONNECTOR, 
			sucuOidSucu_cbanOidBanc, sucuOidSucu_cbanOidBanc.clone(), "cccBanco", "sucuOidSucu_cbanOidBanc", "result_ROWSET" );
		
		
		//splatas - DBLG500000823 - 12/06/2006
        //if(cccCuentCorriBanca != null &&  cccCuentCorriBanca.getSucuOidSucu().getCbanOidBanc() != null){
        //    checkCombo("sucuOidSucu_cbanOidBanc" ,cccCuentCorriBanca.getSucuOidSucu().getCbanOidBanc().getId().toString()); }
        if(cccCuentCorriBanca != null && cccCuentCorriBanca.getSucuOidSucu() != null
                && cccCuentCorriBanca.getSucuOidSucu().getCbanOidBanc() != null){
            checkCombo("sucuOidSucu_cbanOidBanc" , 
                    cccCuentCorriBanca.getSucuOidSucu().getCbanOidBanc().getId().toString());
        }
		
		SegPaisViewData paisOidPais = new SegPaisViewData();
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, 
			paisOidPais, paisOidPais.clone(), "segPaisView", "paisOidPais", "result_ROWSET" );
		if(cccCuentCorriBanca != null && cccCuentCorriBanca.getPaisOidPais() != null){
				checkCombo("paisOidPais" , cccCuentCorriBanca.getPaisOidPais().getId().toString());
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
		
						if(comboName.trim().equals("sucuOidSucu_cbanOidBanc") ){
			String sucuOidSucu_cbanOidBancDefaultValue = (String)checkedCombos.get("sucuOidSucu_cbanOidBanc");
			if(sucuOidSucu_cbanOidBancDefaultValue != null){
				CccSucurData sucuOidSucu= new CccSucurData();
				es.indra.belcorp.mso.CccBancoData sucuOidSucuCbanOidBanc = new es.indra.belcorp.mso.CccBancoData();
				sucuOidSucuCbanOidBanc.setId(new Long(sucuOidSucu_cbanOidBancDefaultValue ));
				sucuOidSucu.setCbanOidBanc(sucuOidSucuCbanOidBanc);
				asignarComboResultados(BUSINESSID_SUCUOIDSUCU_QUERY,SUCUOIDSUCU_COMBO_CONNECTOR, 
					sucuOidSucu, sucuOidSucu.clone(), "cccSucur", "sucuOidSucu", "result_ROWSET",false );
			}
		}

	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param cccCuentCorriBanca La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(CccCuentCorriBancaData cccCuentCorriBanca) 
		throws Exception{
		
						if(cccCuentCorriBanca.getSucuOidSucu() != null){
			
						CccSucurData sucuOidSucu = new CccSucurData();
			sucuOidSucu.setCbanOidBanc(cccCuentCorriBanca.getSucuOidSucu().getCbanOidBanc());
			asignarComboResultados(BUSINESSID_SUCUOIDSUCU_QUERY,SUCUOIDSUCU_COMBO_CONNECTOR, sucuOidSucu, sucuOidSucu.clone(), "cccSucur", "sucuOidSucu", "result_ROWSET");
			checkCombo("sucuOidSucu" , cccCuentCorriBanca.getSucuOidSucu().getId().toString());
			
						}
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		CccCuentCorriBancaData cccCuentCorriBanca = 
			(CccCuentCorriBancaData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(cccCuentCorriBanca.getSociOidSoci() != null){
			cccCuentCorriBanca.setSociOidSoci((es.indra.belcorp.mso.SegSocieData)
			getSingleObject(BUSINESSID_SOCIOIDSOCI_QUERY, 
			cccCuentCorriBanca.getSociOidSoci(),
			cccCuentCorriBanca.getSociOidSoci().clone(),
			"segSocie"));
		}
		if(cccCuentCorriBanca.getCucoOidCcTeso() != null){
			cccCuentCorriBanca.setCucoOidCcTeso((es.indra.belcorp.mso.CccCuentContaData)
			getSingleObject(BUSINESSID_CUCOOIDCCTESO_QUERY, 
			cccCuentCorriBanca.getCucoOidCcTeso(),
			cccCuentCorriBanca.getCucoOidCcTeso().clone(),
			"cccCuentConta"));
		}
		if(cccCuentCorriBanca.getCucoOidCcPnte() != null){
			cccCuentCorriBanca.setCucoOidCcPnte((es.indra.belcorp.mso.CccCuentContaData)
			getSingleObject(BUSINESSID_CUCOOIDCCPNTE_QUERY, 
			cccCuentCorriBanca.getCucoOidCcPnte(),
			cccCuentCorriBanca.getCucoOidCcPnte().clone(),
			"cccCuentConta"));
		}
		if(cccCuentCorriBanca.getSucuOidSucu() != null){
			cccCuentCorriBanca.setSucuOidSucu((es.indra.belcorp.mso.CccSucurData)
			getSingleObject(BUSINESSID_SUCUOIDSUCU_QUERY, 
			cccCuentCorriBanca.getSucuOidSucu(),
			cccCuentCorriBanca.getSucuOidSucu().clone(),
			"cccSucur"));
		}
		if(cccCuentCorriBanca.getPaisOidPais() != null){
			cccCuentCorriBanca.setPaisOidPais((es.indra.belcorp.mso.SegPaisViewData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			cccCuentCorriBanca.getPaisOidPais(),
			cccCuentCorriBanca.getPaisOidPais().clone(),
			"segPaisView"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(cccCuentCorriBanca);
		loadLeafDependenceCombos(cccCuentCorriBanca);
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
			borrarNodo("TR","nombre","formTr6");
			borrarNodo("TR","nombre","formGapTr6");
			borrarNodo("TR","nombre","formTr7");
			borrarNodo("TR","nombre","formGapTr7");
			borrarNodo("TR","nombre","formTr8");
			borrarNodo("TR","nombre","formGapTr8");
			borrarNodo("TR","nombre","formTr9");
			borrarNodo("TR","nombre","formGapTr9");
			
		}else if(accion.equals(ACCION_VIEW) && origen.equals("preview")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			borrarNodo("TR","nombre","formTr9");
			borrarNodo("TR","nombre","formGapTr9");
			
		}else if(accion.equals(ACCION_CREATE)){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			borrarNodo("TR","nombre","formTr9");
			borrarNodo("TR","nombre","formGapTr9");
			
		}else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			borrarNodo("TR","nombre","formTr9");
			borrarNodo("TR","nombre","formGapTr9");
			
		}
	}
	
	
	
		
}





