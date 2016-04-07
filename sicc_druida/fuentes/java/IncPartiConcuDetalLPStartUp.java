/*
    INDRA/CAR/mmg
    $Id: IncPartiConcuDetalLPStartUp.java,v 1.1 2009/12/03 18:38:11 pecbazalar Exp $
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
public class IncPartiConcuDetalLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 273;
	public static final short CREATEFORM_SIZE = 255;
	public static final short UPDATEFORM_SIZE = 255;
	public static final short VIEWFORM_SIZE = 255;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGIncPartiConcuDetalQueryFromToUserPage";
	
	
				public static final String BUSINESSID_PACIOIDPARTCONCCABE_DIRIOIDDIRI_QUERY ="MMGIncDirigQueryFromToUser";
				public static final String BUSINESSID_PACIOIDPARTCONCCABE_QUERY ="MMGIncPartiConcuCabecQueryFromToUser";
				public static final String PACIOIDPARTCONCCABE_DIRIOIDDIRI_COMBO_CONNECTOR = "IncDirigConectorCombo";
	
				public static final String PACIOIDPARTCONCCABE_COMBO_CONNECTOR = "IncPartiConcuCabecConectorCombo";
	
				public static final String BUSINESSID_TICLOIDTIPOCLIE_QUERY ="MMGMaeTipoClienQueryFromToUser";
				public static final String TICLOIDTIPOCLIE_COMBO_CONNECTOR = "MaeTipoClienConectorCombo";
	
				public static final String BUSINESSID_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_QUERY ="MMGMaeTipoClienQueryFromToUser";
				public static final String BUSINESSID_SBTIOIDSUBTCLIE_QUERY ="MMGMaeSubtiClienQueryFromToUser";
				public static final String SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_COMBO_CONNECTOR = "MaeTipoClienConectorCombo";
	
				public static final String SBTIOIDSUBTCLIE_COMBO_CONNECTOR = "MaeSubtiClienConectorCombo";
	
				public static final String BUSINESSID_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_QUERY ="MMGMaeTipoClienQueryFromToUser";
				public static final String BUSINESSID_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_QUERY ="MMGMaeSubtiClienQueryFromToUser";
				public static final String BUSINESSID_TCCLOIDTIPOCLAS_QUERY ="MMGMaeTipoClasiClienQueryFromToUser";
				public static final String TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_COMBO_CONNECTOR = "MaeTipoClienConectorCombo";
	
				public static final String TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_COMBO_CONNECTOR = "MaeSubtiClienConectorCombo";
	
				public static final String TCCLOIDTIPOCLAS_COMBO_CONNECTOR = "MaeTipoClasiClienConectorCombo";
	
				public static final String BUSINESSID_CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_QUERY ="MMGMaeTipoClienQueryFromToUser";
				public static final String BUSINESSID_CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_QUERY ="MMGMaeSubtiClienQueryFromToUser";
				public static final String BUSINESSID_CLASOIDCLAS_TCCLOIDTIPOCLAS_QUERY ="MMGMaeTipoClasiClienQueryFromToUser";
				public static final String BUSINESSID_CLASOIDCLAS_QUERY ="MMGMaeClasiQueryFromToUser";
				public static final String CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_COMBO_CONNECTOR = "MaeTipoClienConectorCombo";
	
				public static final String CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_COMBO_CONNECTOR = "MaeSubtiClienConectorCombo";
	
				public static final String CLASOIDCLAS_TCCLOIDTIPOCLAS_COMBO_CONNECTOR = "MaeTipoClasiClienConectorCombo";
	
				public static final String CLASOIDCLAS_COMBO_CONNECTOR = "MaeClasiConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public IncPartiConcuDetalLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("IncPartiConcuDetalPage");
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
			buildJsPageSize("IncPartiConcuDetal");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "IncPartiConcuDetalPage", "cod", "IncPartiConcuDetal." + accion + ".label");
			
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
			limpiarBotoneraLista("incPartiConcuDetal", accion);
			
			
			
			
			
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
		
		
		
		
		
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "incPartiConcuDetalLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "IncPartiConcuDetalPage", "onblur", "window.focus();");
		
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
		conectorAction("IncPartiConcuDetalLPStartUp");
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
		IncPartiConcuDetalData incPartiConcuDetalQuery= new IncPartiConcuDetalData();
		incPartiConcuDetalQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		IncPartiConcuDetalData datosResult = (IncPartiConcuDetalData)getSingleObject(BUSINESSID_QUERY, incPartiConcuDetalQuery, 
			incPartiConcuDetalQuery.clone(), "incPartiConcuDetal");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		IncPartiConcuDetalData incPartiConcuDetal = datosResult;
		es.indra.belcorp.mso.IncPartiConcuCabecData paciOidPartConcCabe = incPartiConcuDetal.getPaciOidPartConcCabe();
		if(paciOidPartConcCabe != null && paciOidPartConcCabe.getId() != null) checkCombo("paciOidPartConcCabe" , paciOidPartConcCabe.getId().toString());
		es.indra.belcorp.mso.MaeTipoClienData ticlOidTipoClie = incPartiConcuDetal.getTiclOidTipoClie();
		if(ticlOidTipoClie != null && ticlOidTipoClie.getId() != null) checkCombo("ticlOidTipoClie" , ticlOidTipoClie.getId().toString());
		es.indra.belcorp.mso.MaeSubtiClienData sbtiOidSubtClie = incPartiConcuDetal.getSbtiOidSubtClie();
		if(sbtiOidSubtClie != null && sbtiOidSubtClie.getId() != null) checkCombo("sbtiOidSubtClie" , sbtiOidSubtClie.getId().toString());
		es.indra.belcorp.mso.MaeTipoClasiClienData tcclOidTipoClas = incPartiConcuDetal.getTcclOidTipoClas();
		if(tcclOidTipoClas != null && tcclOidTipoClas.getId() != null) checkCombo("tcclOidTipoClas" , tcclOidTipoClas.getId().toString());
		es.indra.belcorp.mso.MaeClasiData clasOidClas = incPartiConcuDetal.getClasOidClas();
		if(clasOidClas != null && clasOidClas.getId() != null) checkCombo("clasOidClas" , clasOidClas.getId().toString());
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		
									asignarAtributo("COMBO", "paciOidPartConcCabe_diriOidDiri", "disabled", "S");

					asignarAtributo("COMBO", "paciOidPartConcCabe", "disabled", "S");
					asignarAtributo("COMBO", "ticlOidTipoClie", "disabled", "S");
									asignarAtributo("COMBO", "sbtiOidSubtClie_ticlOidTipoClie", "disabled", "S");

					asignarAtributo("COMBO", "sbtiOidSubtClie", "disabled", "S");
									asignarAtributo("COMBO", "tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "disabled", "S");

									asignarAtributo("COMBO", "tcclOidTipoClas_sbtiOidSubtClie", "disabled", "S");

					asignarAtributo("COMBO", "tcclOidTipoClas", "disabled", "S");
									asignarAtributo("COMBO", "clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "disabled", "S");

									asignarAtributo("COMBO", "clasOidClas_tcclOidTipoClas_sbtiOidSubtClie", "disabled", "S");

									asignarAtributo("COMBO", "clasOidClas_tcclOidTipoClas", "disabled", "S");

					asignarAtributo("COMBO", "clasOidClas", "disabled", "S");
		
	
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
		asignarAtributo("COMBO", "paciOidPartConcCabe", "req", "S");
		asignarAtributo("COMBO", "ticlOidTipoClie", "req", "S");
		
		
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
		conectorAction("IncPartiConcuDetalLPStartUp");
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
		//asignarAtributo("FORMULARIO", "incPartiConcuDetalFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("COMBO", "paciOidPartConcCabe", "req", "S");
				asignarAtributo("COMBO", "ticlOidTipoClie", "req", "S");
		
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
		
			
			
			
			
			

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando IncPartiConcuDetal");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		IncPartiConcuDetalData incPartiConcuDetalQuery= new IncPartiConcuDetalData();
		incPartiConcuDetalQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		IncPartiConcuDetalData  datosResult = (IncPartiConcuDetalData)getSingleObject(BUSINESSID_QUERY, incPartiConcuDetalQuery, 
			incPartiConcuDetalQuery.clone(), "incPartiConcuDetal");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		IncPartiConcuDetalData incPartiConcuDetal = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		es.indra.belcorp.mso.IncPartiConcuCabecData paciOidPartConcCabe = incPartiConcuDetal.getPaciOidPartConcCabe();
		if(paciOidPartConcCabe != null && paciOidPartConcCabe.getId() != null) checkCombo("paciOidPartConcCabe" , paciOidPartConcCabe.getId().toString());
		es.indra.belcorp.mso.MaeTipoClienData ticlOidTipoClie = incPartiConcuDetal.getTiclOidTipoClie();
		if(ticlOidTipoClie != null && ticlOidTipoClie.getId() != null) checkCombo("ticlOidTipoClie" , ticlOidTipoClie.getId().toString());
		es.indra.belcorp.mso.MaeSubtiClienData sbtiOidSubtClie = incPartiConcuDetal.getSbtiOidSubtClie();
		if(sbtiOidSubtClie != null && sbtiOidSubtClie.getId() != null) checkCombo("sbtiOidSubtClie" , sbtiOidSubtClie.getId().toString());
		es.indra.belcorp.mso.MaeTipoClasiClienData tcclOidTipoClas = incPartiConcuDetal.getTcclOidTipoClas();
		if(tcclOidTipoClas != null && tcclOidTipoClas.getId() != null) checkCombo("tcclOidTipoClas" , tcclOidTipoClas.getId().toString());
		es.indra.belcorp.mso.MaeClasiData clasOidClas = incPartiConcuDetal.getClasOidClas();
		if(clasOidClas != null && clasOidClas.getId() != null) checkCombo("clasOidClas" , clasOidClas.getId().toString());
		

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(incPartiConcuDetal.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",1, false)");
					asignarAtributo("COMBO","paciOidPartConcCabe_diriOidDiri", "ontab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",2, true)");
					asignarAtributo("COMBO","paciOidPartConcCabe_diriOidDiri", "onshtab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",2, false)");
					asignarAtributo("COMBO","paciOidPartConcCabe", "ontab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",2, true)");
					asignarAtributo("COMBO","paciOidPartConcCabe", "onshtab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",2, false)");
					asignarAtributo("COMBO","ticlOidTipoClie", "ontab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",3, true)");
					asignarAtributo("COMBO","ticlOidTipoClie", "onshtab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",3, false)");
					asignarAtributo("COMBO","sbtiOidSubtClie_ticlOidTipoClie", "ontab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",4, true)");
					asignarAtributo("COMBO","sbtiOidSubtClie_ticlOidTipoClie", "onshtab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",4, false)");
					asignarAtributo("COMBO","sbtiOidSubtClie", "ontab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",4, true)");
					asignarAtributo("COMBO","sbtiOidSubtClie", "onshtab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",4, false)");
					asignarAtributo("COMBO","tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "ontab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",5, true)");
					asignarAtributo("COMBO","tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "onshtab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",5, false)");
					asignarAtributo("COMBO","tcclOidTipoClas_sbtiOidSubtClie", "ontab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",5, true)");
					asignarAtributo("COMBO","tcclOidTipoClas_sbtiOidSubtClie", "onshtab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",5, false)");
					asignarAtributo("COMBO","tcclOidTipoClas", "ontab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",5, true)");
					asignarAtributo("COMBO","tcclOidTipoClas", "onshtab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",5, false)");
					asignarAtributo("COMBO","clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "ontab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",6, true)");
					asignarAtributo("COMBO","clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "onshtab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",6, false)");
					asignarAtributo("COMBO","clasOidClas_tcclOidTipoClas_sbtiOidSubtClie", "ontab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",6, true)");
					asignarAtributo("COMBO","clasOidClas_tcclOidTipoClas_sbtiOidSubtClie", "onshtab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",6, false)");
					asignarAtributo("COMBO","clasOidClas_tcclOidTipoClas", "ontab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",6, true)");
					asignarAtributo("COMBO","clasOidClas_tcclOidTipoClas", "onshtab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",6, false)");
					asignarAtributo("COMBO","clasOidClas", "ontab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",6, true)");
					asignarAtributo("COMBO","clasOidClas", "onshtab", "ejecutarAccionFocoModificacion(\"incPartiConcuDetalFrm\",6, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","incPartiConcuDetalTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","incPartiConcuDetalTrButtons");

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
				
				traza("MMG: el atributo es paciOidPartConcCabe...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
									asignarAtributo("COMBO", "paciOidPartConcCabe_diriOidDiri", "disabled", "S");

						asignarAtributo("COMBO", "paciOidPartConcCabe", "disabled", "S");
				traza("MMG: el atributo es ticlOidTipoClie...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						asignarAtributo("COMBO", "ticlOidTipoClie", "disabled", "S");
				traza("MMG: el atributo es sbtiOidSubtClie...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
									asignarAtributo("COMBO", "sbtiOidSubtClie_ticlOidTipoClie", "disabled", "S");

						asignarAtributo("COMBO", "sbtiOidSubtClie", "disabled", "S");
				traza("MMG: el atributo es tcclOidTipoClas...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
									asignarAtributo("COMBO", "tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "disabled", "S");

									asignarAtributo("COMBO", "tcclOidTipoClas_sbtiOidSubtClie", "disabled", "S");

						asignarAtributo("COMBO", "tcclOidTipoClas", "disabled", "S");
				traza("MMG: el atributo es clasOidClas...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
									asignarAtributo("COMBO", "clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "disabled", "S");

									asignarAtributo("COMBO", "clasOidClas_tcclOidTipoClas_sbtiOidSubtClie", "disabled", "S");

									asignarAtributo("COMBO", "clasOidClas_tcclOidTipoClas", "disabled", "S");

						asignarAtributo("COMBO", "clasOidClas", "disabled", "S");
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
		asignarAtributo("CAPA","incPartiConcuDetalFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","incPartiConcuDetalListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","incPartiConcuDetalListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(IncPartiConcuDetalData incPartiConcuDetal) throws Exception{
		HashMap checkedCombos = new HashMap();
		IncDirigData paciOidPartConcCabe_diriOidDiri = new IncDirigData();
		
						asignarComboResultados(BUSINESSID_PACIOIDPARTCONCCABE_DIRIOIDDIRI_QUERY,PACIOIDPARTCONCCABE_DIRIOIDDIRI_COMBO_CONNECTOR, 
			paciOidPartConcCabe_diriOidDiri, paciOidPartConcCabe_diriOidDiri.clone(), "incDirig", "paciOidPartConcCabe_diriOidDiri", "result_ROWSET" );
		if(incPartiConcuDetal != null && incPartiConcuDetal.getPaciOidPartConcCabe().getDiriOidDiri() != null){
				checkCombo("paciOidPartConcCabe_diriOidDiri" , incPartiConcuDetal.getPaciOidPartConcCabe().getDiriOidDiri().getId().toString());
			}
		MaeTipoClienData ticlOidTipoClie = new MaeTipoClienData();
		
						asignarComboResultados(BUSINESSID_TICLOIDTIPOCLIE_QUERY,TICLOIDTIPOCLIE_COMBO_CONNECTOR, 
			ticlOidTipoClie, ticlOidTipoClie.clone(), "maeTipoClien", "ticlOidTipoClie", "result_ROWSET" );
		if(incPartiConcuDetal != null && incPartiConcuDetal.getTiclOidTipoClie() != null){
				checkCombo("ticlOidTipoClie" , incPartiConcuDetal.getTiclOidTipoClie().getId().toString());
			}
		MaeTipoClienData sbtiOidSubtClie_ticlOidTipoClie = new MaeTipoClienData();
		
						asignarComboResultados(BUSINESSID_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_QUERY,SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_COMBO_CONNECTOR, 
			sbtiOidSubtClie_ticlOidTipoClie, sbtiOidSubtClie_ticlOidTipoClie.clone(), "maeTipoClien", "sbtiOidSubtClie_ticlOidTipoClie", "result_ROWSET" );
		if(incPartiConcuDetal != null && incPartiConcuDetal.getSbtiOidSubtClie().getTiclOidTipoClie() != null){
				checkCombo("sbtiOidSubtClie_ticlOidTipoClie" , incPartiConcuDetal.getSbtiOidSubtClie().getTiclOidTipoClie().getId().toString());
			}
		MaeTipoClienData tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie = new MaeTipoClienData();
		
						asignarComboResultados(BUSINESSID_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_QUERY,TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_COMBO_CONNECTOR, 
			tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie, tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie.clone(), "maeTipoClien", "tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "result_ROWSET" );
		if(incPartiConcuDetal != null && incPartiConcuDetal.getTcclOidTipoClas().getSbtiOidSubtClie().getTiclOidTipoClie() != null){
				checkCombo("tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie" , incPartiConcuDetal.getTcclOidTipoClas().getSbtiOidSubtClie().getTiclOidTipoClie().getId().toString());
			}
		MaeTipoClienData clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie = new MaeTipoClienData();
		
						asignarComboResultados(BUSINESSID_CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_QUERY,CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_COMBO_CONNECTOR, 
			clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie, clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie.clone(), "maeTipoClien", "clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie", "result_ROWSET" );
		if(incPartiConcuDetal != null && incPartiConcuDetal.getClasOidClas().getTcclOidTipoClas().getSbtiOidSubtClie().getTiclOidTipoClie() != null){
				checkCombo("clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie" , incPartiConcuDetal.getClasOidClas().getTcclOidTipoClas().getSbtiOidSubtClie().getTiclOidTipoClie().getId().toString());
			}
		
	}
	
	/**
	* Nos permite cargar en cascada jerarquía de combos dependientes por la selección de valor en uno de sus elementos
	*/
	public void cascadeComboLoad(HashMap checkedCombos, String comboName) throws Exception{
		
						if(comboName.trim().equals("paciOidPartConcCabe_diriOidDiri") ){
			String paciOidPartConcCabe_diriOidDiriDefaultValue = (String)checkedCombos.get("paciOidPartConcCabe_diriOidDiri");
			if(paciOidPartConcCabe_diriOidDiriDefaultValue != null){
				IncPartiConcuCabecData paciOidPartConcCabe= new IncPartiConcuCabecData();
				es.indra.belcorp.mso.IncDirigData paciOidPartConcCabeDiriOidDiri = new es.indra.belcorp.mso.IncDirigData();
				paciOidPartConcCabeDiriOidDiri.setId(new Long(paciOidPartConcCabe_diriOidDiriDefaultValue ));
				paciOidPartConcCabe.setDiriOidDiri(paciOidPartConcCabeDiriOidDiri);
				asignarComboResultados(BUSINESSID_PACIOIDPARTCONCCABE_QUERY,PACIOIDPARTCONCCABE_COMBO_CONNECTOR, 
					paciOidPartConcCabe, paciOidPartConcCabe.clone(), "incPartiConcuCabec", "paciOidPartConcCabe", "result_ROWSET",false );
			}
		}

						if(comboName.trim().equals("sbtiOidSubtClie_ticlOidTipoClie") ){
			String sbtiOidSubtClie_ticlOidTipoClieDefaultValue = (String)checkedCombos.get("sbtiOidSubtClie_ticlOidTipoClie");
			if(sbtiOidSubtClie_ticlOidTipoClieDefaultValue != null){
				MaeSubtiClienData sbtiOidSubtClie= new MaeSubtiClienData();
				es.indra.belcorp.mso.MaeTipoClienData sbtiOidSubtClieTiclOidTipoClie = new es.indra.belcorp.mso.MaeTipoClienData();
				sbtiOidSubtClieTiclOidTipoClie.setId(new Long(sbtiOidSubtClie_ticlOidTipoClieDefaultValue ));
				sbtiOidSubtClie.setTiclOidTipoClie(sbtiOidSubtClieTiclOidTipoClie);
				asignarComboResultados(BUSINESSID_SBTIOIDSUBTCLIE_QUERY,SBTIOIDSUBTCLIE_COMBO_CONNECTOR, 
					sbtiOidSubtClie, sbtiOidSubtClie.clone(), "maeSubtiClien", "sbtiOidSubtClie", "result_ROWSET",false );
			}
		}

						if(comboName.trim().equals("tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie") ){
			String tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClieDefaultValue = (String)checkedCombos.get("tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie");
			if(tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClieDefaultValue != null){
				MaeSubtiClienData tcclOidTipoClas_sbtiOidSubtClie= new MaeSubtiClienData();
				es.indra.belcorp.mso.MaeTipoClienData tcclOidTipoClas_sbtiOidSubtClieTiclOidTipoClie = new es.indra.belcorp.mso.MaeTipoClienData();
				tcclOidTipoClas_sbtiOidSubtClieTiclOidTipoClie.setId(new Long(tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClieDefaultValue ));
				tcclOidTipoClas_sbtiOidSubtClie.setTiclOidTipoClie(tcclOidTipoClas_sbtiOidSubtClieTiclOidTipoClie);
				asignarComboResultados(BUSINESSID_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_QUERY,TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_COMBO_CONNECTOR, 
					tcclOidTipoClas_sbtiOidSubtClie, tcclOidTipoClas_sbtiOidSubtClie.clone(), "maeSubtiClien", "tcclOidTipoClas_sbtiOidSubtClie", "result_ROWSET",false );
			}
		}

						if(comboName.trim().equals("tcclOidTipoClas_sbtiOidSubtClie") ){
			String tcclOidTipoClas_sbtiOidSubtClieDefaultValue = (String)checkedCombos.get("tcclOidTipoClas_sbtiOidSubtClie");
			if(tcclOidTipoClas_sbtiOidSubtClieDefaultValue != null){
				MaeTipoClasiClienData tcclOidTipoClas= new MaeTipoClasiClienData();
				es.indra.belcorp.mso.MaeSubtiClienData tcclOidTipoClasSbtiOidSubtClie = new es.indra.belcorp.mso.MaeSubtiClienData();
				tcclOidTipoClasSbtiOidSubtClie.setId(new Long(tcclOidTipoClas_sbtiOidSubtClieDefaultValue ));
				tcclOidTipoClas.setSbtiOidSubtClie(tcclOidTipoClasSbtiOidSubtClie);
				asignarComboResultados(BUSINESSID_TCCLOIDTIPOCLAS_QUERY,TCCLOIDTIPOCLAS_COMBO_CONNECTOR, 
					tcclOidTipoClas, tcclOidTipoClas.clone(), "maeTipoClasiClien", "tcclOidTipoClas", "result_ROWSET",false );
			}
		}

						if(comboName.trim().equals("clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie") ){
			String clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClieDefaultValue = (String)checkedCombos.get("clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie");
			if(clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClieDefaultValue != null){
				MaeSubtiClienData clasOidClas_tcclOidTipoClas_sbtiOidSubtClie= new MaeSubtiClienData();
				es.indra.belcorp.mso.MaeTipoClienData clasOidClas_tcclOidTipoClas_sbtiOidSubtClieTiclOidTipoClie = new es.indra.belcorp.mso.MaeTipoClienData();
				clasOidClas_tcclOidTipoClas_sbtiOidSubtClieTiclOidTipoClie.setId(new Long(clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClieDefaultValue ));
				clasOidClas_tcclOidTipoClas_sbtiOidSubtClie.setTiclOidTipoClie(clasOidClas_tcclOidTipoClas_sbtiOidSubtClieTiclOidTipoClie);
				asignarComboResultados(BUSINESSID_CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_QUERY,CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_COMBO_CONNECTOR, 
					clasOidClas_tcclOidTipoClas_sbtiOidSubtClie, clasOidClas_tcclOidTipoClas_sbtiOidSubtClie.clone(), "maeSubtiClien", "clasOidClas_tcclOidTipoClas_sbtiOidSubtClie", "result_ROWSET",false );
			}
		}

						if(comboName.trim().equals("clasOidClas_tcclOidTipoClas_sbtiOidSubtClie") ){
			String clasOidClas_tcclOidTipoClas_sbtiOidSubtClieDefaultValue = (String)checkedCombos.get("clasOidClas_tcclOidTipoClas_sbtiOidSubtClie");
			if(clasOidClas_tcclOidTipoClas_sbtiOidSubtClieDefaultValue != null){
				MaeTipoClasiClienData clasOidClas_tcclOidTipoClas= new MaeTipoClasiClienData();
				es.indra.belcorp.mso.MaeSubtiClienData clasOidClas_tcclOidTipoClasSbtiOidSubtClie = new es.indra.belcorp.mso.MaeSubtiClienData();
				clasOidClas_tcclOidTipoClasSbtiOidSubtClie.setId(new Long(clasOidClas_tcclOidTipoClas_sbtiOidSubtClieDefaultValue ));
				clasOidClas_tcclOidTipoClas.setSbtiOidSubtClie(clasOidClas_tcclOidTipoClasSbtiOidSubtClie);
				asignarComboResultados(BUSINESSID_CLASOIDCLAS_TCCLOIDTIPOCLAS_QUERY,CLASOIDCLAS_TCCLOIDTIPOCLAS_COMBO_CONNECTOR, 
					clasOidClas_tcclOidTipoClas, clasOidClas_tcclOidTipoClas.clone(), "maeTipoClasiClien", "clasOidClas_tcclOidTipoClas", "result_ROWSET",false );
			}
		}

						if(comboName.trim().equals("clasOidClas_tcclOidTipoClas") ){
			String clasOidClas_tcclOidTipoClasDefaultValue = (String)checkedCombos.get("clasOidClas_tcclOidTipoClas");
			if(clasOidClas_tcclOidTipoClasDefaultValue != null){
				MaeClasiData clasOidClas= new MaeClasiData();
				es.indra.belcorp.mso.MaeTipoClasiClienData clasOidClasTcclOidTipoClas = new es.indra.belcorp.mso.MaeTipoClasiClienData();
				clasOidClasTcclOidTipoClas.setId(new Long(clasOidClas_tcclOidTipoClasDefaultValue ));
				clasOidClas.setTcclOidTipoClas(clasOidClasTcclOidTipoClas);
				asignarComboResultados(BUSINESSID_CLASOIDCLAS_QUERY,CLASOIDCLAS_COMBO_CONNECTOR, 
					clasOidClas, clasOidClas.clone(), "maeClasi", "clasOidClas", "result_ROWSET",false );
			}
		}

	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param incPartiConcuDetal La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(IncPartiConcuDetalData incPartiConcuDetal) 
		throws Exception{
		
						if(incPartiConcuDetal.getPaciOidPartConcCabe() != null){
			
						IncPartiConcuCabecData paciOidPartConcCabe = new IncPartiConcuCabecData();
			paciOidPartConcCabe.setDiriOidDiri(incPartiConcuDetal.getPaciOidPartConcCabe().getDiriOidDiri());
			asignarComboResultados(BUSINESSID_PACIOIDPARTCONCCABE_QUERY,PACIOIDPARTCONCCABE_COMBO_CONNECTOR, paciOidPartConcCabe, paciOidPartConcCabe.clone(), "incPartiConcuCabec", "paciOidPartConcCabe", "result_ROWSET");
			checkCombo("paciOidPartConcCabe" , incPartiConcuDetal.getPaciOidPartConcCabe().getId().toString());
			
						}
		
						if(incPartiConcuDetal.getSbtiOidSubtClie() != null){
			
						MaeSubtiClienData sbtiOidSubtClie = new MaeSubtiClienData();
			sbtiOidSubtClie.setTiclOidTipoClie(incPartiConcuDetal.getSbtiOidSubtClie().getTiclOidTipoClie());
			asignarComboResultados(BUSINESSID_SBTIOIDSUBTCLIE_QUERY,SBTIOIDSUBTCLIE_COMBO_CONNECTOR, sbtiOidSubtClie, sbtiOidSubtClie.clone(), "maeSubtiClien", "sbtiOidSubtClie", "result_ROWSET");
			checkCombo("sbtiOidSubtClie" , incPartiConcuDetal.getSbtiOidSubtClie().getId().toString());
			
						}
		
						if(incPartiConcuDetal.getTcclOidTipoClas() != null){
			
						MaeTipoClasiClienData tcclOidTipoClas = new MaeTipoClasiClienData();
			tcclOidTipoClas.setSbtiOidSubtClie(incPartiConcuDetal.getTcclOidTipoClas().getSbtiOidSubtClie());
			asignarComboResultados(BUSINESSID_TCCLOIDTIPOCLAS_QUERY,TCCLOIDTIPOCLAS_COMBO_CONNECTOR, tcclOidTipoClas, tcclOidTipoClas.clone(), "maeTipoClasiClien", "tcclOidTipoClas", "result_ROWSET");
			checkCombo("tcclOidTipoClas" , incPartiConcuDetal.getTcclOidTipoClas().getId().toString());
			
						MaeSubtiClienData tcclOidTipoClas_sbtiOidSubtClie = new MaeSubtiClienData();
			tcclOidTipoClas_sbtiOidSubtClie.setTiclOidTipoClie(incPartiConcuDetal.getTcclOidTipoClas().getSbtiOidSubtClie().getTiclOidTipoClie());
			asignarComboResultados(BUSINESSID_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_QUERY,TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_COMBO_CONNECTOR, tcclOidTipoClas_sbtiOidSubtClie, tcclOidTipoClas_sbtiOidSubtClie.clone(), "maeSubtiClien", "tcclOidTipoClas_sbtiOidSubtClie", "result_ROWSET");
			checkCombo("tcclOidTipoClas_sbtiOidSubtClie" , incPartiConcuDetal.getTcclOidTipoClas().getSbtiOidSubtClie().getId().toString());
			
						}
		
						if(incPartiConcuDetal.getClasOidClas() != null){
			
						MaeClasiData clasOidClas = new MaeClasiData();
			clasOidClas.setTcclOidTipoClas(incPartiConcuDetal.getClasOidClas().getTcclOidTipoClas());
			asignarComboResultados(BUSINESSID_CLASOIDCLAS_QUERY,CLASOIDCLAS_COMBO_CONNECTOR, clasOidClas, clasOidClas.clone(), "maeClasi", "clasOidClas", "result_ROWSET");
			checkCombo("clasOidClas" , incPartiConcuDetal.getClasOidClas().getId().toString());
			
						MaeTipoClasiClienData clasOidClas_tcclOidTipoClas = new MaeTipoClasiClienData();
			clasOidClas_tcclOidTipoClas.setSbtiOidSubtClie(incPartiConcuDetal.getClasOidClas().getTcclOidTipoClas().getSbtiOidSubtClie());
			asignarComboResultados(BUSINESSID_CLASOIDCLAS_TCCLOIDTIPOCLAS_QUERY,CLASOIDCLAS_TCCLOIDTIPOCLAS_COMBO_CONNECTOR, clasOidClas_tcclOidTipoClas, clasOidClas_tcclOidTipoClas.clone(), "maeTipoClasiClien", "clasOidClas_tcclOidTipoClas", "result_ROWSET");
			checkCombo("clasOidClas_tcclOidTipoClas" , incPartiConcuDetal.getClasOidClas().getTcclOidTipoClas().getId().toString());
			
						MaeSubtiClienData clasOidClas_tcclOidTipoClas_sbtiOidSubtClie = new MaeSubtiClienData();
			clasOidClas_tcclOidTipoClas_sbtiOidSubtClie.setTiclOidTipoClie(incPartiConcuDetal.getClasOidClas().getTcclOidTipoClas().getSbtiOidSubtClie().getTiclOidTipoClie());
			asignarComboResultados(BUSINESSID_CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_QUERY,CLASOIDCLAS_TCCLOIDTIPOCLAS_SBTIOIDSUBTCLIE_COMBO_CONNECTOR, clasOidClas_tcclOidTipoClas_sbtiOidSubtClie, clasOidClas_tcclOidTipoClas_sbtiOidSubtClie.clone(), "maeSubtiClien", "clasOidClas_tcclOidTipoClas_sbtiOidSubtClie", "result_ROWSET");
			checkCombo("clasOidClas_tcclOidTipoClas_sbtiOidSubtClie" , incPartiConcuDetal.getClasOidClas().getTcclOidTipoClas().getSbtiOidSubtClie().getId().toString());
			
						}
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		IncPartiConcuDetalData incPartiConcuDetal = 
			(IncPartiConcuDetalData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(incPartiConcuDetal.getPaciOidPartConcCabe() != null){
			incPartiConcuDetal.setPaciOidPartConcCabe((es.indra.belcorp.mso.IncPartiConcuCabecData)
			getSingleObject(BUSINESSID_PACIOIDPARTCONCCABE_QUERY, 
			incPartiConcuDetal.getPaciOidPartConcCabe(),
			incPartiConcuDetal.getPaciOidPartConcCabe().clone(),
			"incPartiConcuCabec"));
		}
		if(incPartiConcuDetal.getTiclOidTipoClie() != null){
			incPartiConcuDetal.setTiclOidTipoClie((es.indra.belcorp.mso.MaeTipoClienData)
			getSingleObject(BUSINESSID_TICLOIDTIPOCLIE_QUERY, 
			incPartiConcuDetal.getTiclOidTipoClie(),
			incPartiConcuDetal.getTiclOidTipoClie().clone(),
			"maeTipoClien"));
		}
		if(incPartiConcuDetal.getSbtiOidSubtClie() != null){
			incPartiConcuDetal.setSbtiOidSubtClie((es.indra.belcorp.mso.MaeSubtiClienData)
			getSingleObject(BUSINESSID_SBTIOIDSUBTCLIE_QUERY, 
			incPartiConcuDetal.getSbtiOidSubtClie(),
			incPartiConcuDetal.getSbtiOidSubtClie().clone(),
			"maeSubtiClien"));
		}
		if(incPartiConcuDetal.getTcclOidTipoClas() != null){
			incPartiConcuDetal.setTcclOidTipoClas((es.indra.belcorp.mso.MaeTipoClasiClienData)
			getSingleObject(BUSINESSID_TCCLOIDTIPOCLAS_QUERY, 
			incPartiConcuDetal.getTcclOidTipoClas(),
			incPartiConcuDetal.getTcclOidTipoClas().clone(),
			"maeTipoClasiClien"));
		}
		if(incPartiConcuDetal.getClasOidClas() != null){
			incPartiConcuDetal.setClasOidClas((es.indra.belcorp.mso.MaeClasiData)
			getSingleObject(BUSINESSID_CLASOIDCLAS_QUERY, 
			incPartiConcuDetal.getClasOidClas(),
			incPartiConcuDetal.getClasOidClas().clone(),
			"maeClasi"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(incPartiConcuDetal);
		loadLeafDependenceCombos(incPartiConcuDetal);
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





