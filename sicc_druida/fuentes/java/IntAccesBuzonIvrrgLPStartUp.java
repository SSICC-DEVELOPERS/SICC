/*
    INDRA/CAR/mmg
    $Id: IntAccesBuzonIvrrgLPStartUp.java,v 1.1 2009/12/03 18:39:29 pecbazalar Exp $
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
public class IntAccesBuzonIvrrgLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios seg�n el modo
	public static final short QUERYFORM_SIZE = 147;
	public static final short CREATEFORM_SIZE = 129;
	public static final short UPDATEFORM_SIZE = 129;
	public static final short VIEWFORM_SIZE = 129;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGIntAccesBuzonIvrrgQueryFromToUserPage";
	
	
				public static final String BUSINESSID_ZORGOIDREGI_MARCOIDMARC_QUERY ="MMGSegMarcaQueryFromToUser";
				public static final String BUSINESSID_ZORGOIDREGI_CANAOIDCANA_QUERY ="MMGSegCanalViewQueryFromToUser";
				public static final String BUSINESSID_ZORGOIDREGI_QUERY ="MMGZonRegioView2QueryFromToUser";
				public static final String ZORGOIDREGI_MARCOIDMARC_COMBO_CONNECTOR = "SegMarcaConectorCombo";
	
				public static final String ZORGOIDREGI_CANAOIDCANA_COMBO_CONNECTOR = "SegCanalViewConectorCombo";
	
				public static final String ZORGOIDREGI_COMBO_CONNECTOR = "ZonRegioView2ConectorCombo";
	
		
	//Hashtables con los valores est�ticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public IntAccesBuzonIvrrgLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("IntAccesBuzonIvrrgPage");
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
			buildJsPageSize("IntAccesBuzonIvrrg");
			
			//Determinamos la acci�n y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el t�tulo i18nalizado
			//y para que funcione de forma correcta la configuraci�n del men� secundario
			asignarAtributo("PAGINA", "IntAccesBuzonIvrrgPage", "cod", "IntAccesBuzonIvrrg." + accion + ".label");
			
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
			limpiarBotoneraLista("intAccesBuzonIvrrg", accion);
			
			
			
			
			
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
		asignarAtributo("TEXT", "codAcceBuzoIvrr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "intAccesBuzonIvrrgLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "IntAccesBuzonIvrrgPage", "onblur", "window.focus();");
		
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
		conectorAction("IntAccesBuzonIvrrgLPStartUp");
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
		IntAccesBuzonIvrrgData intAccesBuzonIvrrgQuery= new IntAccesBuzonIvrrgData();
		intAccesBuzonIvrrgQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acci�n anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		IntAccesBuzonIvrrgData datosResult = (IntAccesBuzonIvrrgData)getSingleObject(BUSINESSID_QUERY, intAccesBuzonIvrrgQuery, 
			intAccesBuzonIvrrgQuery.clone(), "intAccesBuzonIvrrg");
		
		
		//Comprobamos que haya datos. Si no indicamos la situaci�n
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		IntAccesBuzonIvrrgData intAccesBuzonIvrrg = datosResult;
		asignar("TEXT", "codAcceBuzoIvrr", FormatUtils.formatObject(intAccesBuzonIvrrg.getCodAcceBuzoIvrr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.ZonRegioView2Data zorgOidRegi = intAccesBuzonIvrrg.getZorgOidRegi();
		if(zorgOidRegi != null && zorgOidRegi.getId() != null) checkCombo("zorgOidRegi" , zorgOidRegi.getId().toString());
		
			
		//Sacamos la informaci�n de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la b�squeda
		//	Creamos el dto y metemos la informaci�n necesaria para ejecutar la query
		//	Invocamos la l�gica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		asignarAtributo("TEXT", "codAcceBuzoIvrr", "disabled", "S");
		
									asignarAtributo("COMBO", "zorgOidRegi_marcOidMarc", "disabled", "S");

									asignarAtributo("COMBO", "zorgOidRegi_canaOidCana", "disabled", "S");

					asignarAtributo("COMBO", "zorgOidRegi", "disabled", "S");
		
	
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
		

		//Cargamos las combos finales de las jerarqu�as de herencia
		loadLeafDependenceCombos(null);
	
		//Ponemos los campos requeridos a true
		asignarAtributo("TEXT", "codAcceBuzoIvrr", "req", "S");
		asignarAtributo("COMBO", "zorgOidRegi", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la funci�n de onblur para actualizar el 
		//valor del idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codAcceBuzoIvrr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		
		
		
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
		asignarAtributo("TEXT", "codAcceBuzoIvrr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		
		
		
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
		asignarAtributo("TEXT", "codAcceBuzoIvrr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		
		
		
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
		asignarAtributo("TEXT", "codAcceBuzoIvrr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		
		
		
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
		conectorAction("IntAccesBuzonIvrrgLPStartUp");
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
		//asignarAtributo("FORMULARIO", "intAccesBuzonIvrrgFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("TEXT", "codAcceBuzoIvrr", "req", "S");
				asignarAtributo("COMBO", "zorgOidRegi", "req", "S");
		
		//Asignamos a los campos internacionalizables la funci�n de onblur para actualizar el valor
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
		
			asignarAtributo("TEXT", "codAcceBuzoIvrr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
			

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando IntAccesBuzonIvrrg");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la b�squeda
		IntAccesBuzonIvrrgData intAccesBuzonIvrrgQuery= new IntAccesBuzonIvrrgData();
		intAccesBuzonIvrrgQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		IntAccesBuzonIvrrgData  datosResult = (IntAccesBuzonIvrrgData)getSingleObject(BUSINESSID_QUERY, intAccesBuzonIvrrgQuery, 
			intAccesBuzonIvrrgQuery.clone(), "intAccesBuzonIvrrg");
		

		//Comprobamos que haya datos. Si no indicamos la situaci�pn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		IntAccesBuzonIvrrgData intAccesBuzonIvrrg = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		asignar("TEXT", "codAcceBuzoIvrr", FormatUtils.formatObject(intAccesBuzonIvrrg.getCodAcceBuzoIvrr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.ZonRegioView2Data zorgOidRegi = intAccesBuzonIvrrg.getZorgOidRegi();
		if(zorgOidRegi != null && zorgOidRegi.getId() != null) checkCombo("zorgOidRegi" , zorgOidRegi.getId().toString());
		

		//Sacamos la informaci�n de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la b�squeda
		//	Creamos el dto y metemos la informaci�n necesaria para ejecutar la query
		//	Invocamos la l�gica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acci�n
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se est� modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(intAccesBuzonIvrrg.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"intAccesBuzonIvrrgFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"intAccesBuzonIvrrgFrm\",1, false)");
				asignarAtributo("AREATEXTO", "codAcceBuzoIvrr", "ontab","ejecutarAccionFocoModificacion(\"intAccesBuzonIvrrgFrm\",2, true)");
				asignarAtributo("AREATEXTO", "codAcceBuzoIvrr", "onshtab","ejecutarAccionFocoModificacion(\"intAccesBuzonIvrrgFrm\",2, false)");
					asignarAtributo("COMBO","zorgOidRegi_marcOidMarc", "ontab", "ejecutarAccionFocoModificacion(\"intAccesBuzonIvrrgFrm\",3, true)");
					asignarAtributo("COMBO","zorgOidRegi_marcOidMarc", "onshtab", "ejecutarAccionFocoModificacion(\"intAccesBuzonIvrrgFrm\",3, false)");
					asignarAtributo("COMBO","zorgOidRegi_canaOidCana", "ontab", "ejecutarAccionFocoModificacion(\"intAccesBuzonIvrrgFrm\",3, true)");
					asignarAtributo("COMBO","zorgOidRegi_canaOidCana", "onshtab", "ejecutarAccionFocoModificacion(\"intAccesBuzonIvrrgFrm\",3, false)");
					asignarAtributo("COMBO","zorgOidRegi", "ontab", "ejecutarAccionFocoModificacion(\"intAccesBuzonIvrrgFrm\",3, true)");
					asignarAtributo("COMBO","zorgOidRegi", "onshtab", "ejecutarAccionFocoModificacion(\"intAccesBuzonIvrrgFrm\",3, false)");
	}
	
	/**Nos permite eliminar de la p�gina todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","intAccesBuzonIvrrgTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la b�suqeda
		borrarNodo("TR","nombre","intAccesBuzonIvrrgTrButtons");

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
				
				traza("MMG: el atributo es codAcceBuzoIvrr...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						// borrarCampo("codAcceBuzoIvrr");
						asignarAtributo ("TEXT", "codAcceBuzoIvrr", "disabled", "S");
				traza("MMG: el atributo es zorgOidRegi...");		
				
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
		asignarAtributo("CAPA","intAccesBuzonIvrrgFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","intAccesBuzonIvrrgListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","intAccesBuzonIvrrgListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarqu�as de dependencia
	*/
	protected void loadLeafDependenceCombos(IntAccesBuzonIvrrgData intAccesBuzonIvrrg) throws Exception{
		HashMap checkedCombos = new HashMap();
		SegMarcaData zorgOidRegi_marcOidMarc = new SegMarcaData();
		SegCanalViewData zorgOidRegi_canaOidCana = new SegCanalViewData();
		
		asignarComboResultados(BUSINESSID_ZORGOIDREGI_MARCOIDMARC_QUERY,ZORGOIDREGI_MARCOIDMARC_COMBO_CONNECTOR, 
			zorgOidRegi_marcOidMarc, zorgOidRegi_marcOidMarc.clone(), "segMarca", "zorgOidRegi_marcOidMarc", 
            "result_ROWSET" );
        
		// SPLATAS - 07/02/06
        // if(intAccesBuzonIvrrg != null && intAccesBuzonIvrrg.getZorgOidRegi().getMarcOidMarc() != null){
		if(intAccesBuzonIvrrg != null && intAccesBuzonIvrrg.getZorgOidRegi() != null
                && intAccesBuzonIvrrg.getZorgOidRegi().getMarcOidMarc() != null){
			checkCombo("zorgOidRegi_marcOidMarc" , 
                    intAccesBuzonIvrrg.getZorgOidRegi().getMarcOidMarc().getId().toString());
		}
		
		asignarComboResultados(BUSINESSID_ZORGOIDREGI_CANAOIDCANA_QUERY,ZORGOIDREGI_CANAOIDCANA_COMBO_CONNECTOR, 
			zorgOidRegi_canaOidCana, zorgOidRegi_canaOidCana.clone(), "segCanalView", "zorgOidRegi_canaOidCana", 
            "result_ROWSET" );
        
		// SPLATAS - 07/02/06
        // if(intAccesBuzonIvrrg != null && intAccesBuzonIvrrg.getZorgOidRegi().getCanaOidCana() != null){
		if(intAccesBuzonIvrrg != null && intAccesBuzonIvrrg.getZorgOidRegi() != null
                && intAccesBuzonIvrrg.getZorgOidRegi().getCanaOidCana() != null){
			checkCombo("zorgOidRegi_canaOidCana" , 
                    intAccesBuzonIvrrg.getZorgOidRegi().getCanaOidCana().getId().toString());
		}
        
		String zorgOidRegi_marcOidMarcDefaultValue = 
            MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegMarca");
        
		if(zorgOidRegi_marcOidMarcDefaultValue != null && !zorgOidRegi_marcOidMarcDefaultValue.trim().equals("")){
			checkCombo("zorgOidRegi_marcOidMarc", zorgOidRegi_marcOidMarcDefaultValue);
			checkedCombos.put("zorgOidRegi_marcOidMarc",zorgOidRegi_marcOidMarcDefaultValue);
			cascadeComboLoad(checkedCombos, "zorgOidRegi_marcOidMarc");
		}
        
		String zorgOidRegi_canaOidCanaDefaultValue = 
            MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegCanalView");
        
		if(zorgOidRegi_canaOidCanaDefaultValue != null && !zorgOidRegi_canaOidCanaDefaultValue.trim().equals("")){
			checkCombo("zorgOidRegi_canaOidCana", zorgOidRegi_canaOidCanaDefaultValue);
			checkedCombos.put("zorgOidRegi_canaOidCana",zorgOidRegi_canaOidCanaDefaultValue);
			cascadeComboLoad(checkedCombos, "zorgOidRegi_canaOidCana");
		}						 
		
	}
	
	/**
	* Nos permite cargar en cascada jerarqu�a de combos dependientes por la selecci�n de valor en uno de sus elementos
	*/
	public void cascadeComboLoad(HashMap checkedCombos, String comboName) throws Exception{
		
						if(comboName.trim().equals("zorgOidRegi_marcOidMarc")  || comboName.trim().equals("zorgOidRegi_canaOidCana") ){
			String zorgOidRegi_marcOidMarcDefaultValue = (String)checkedCombos.get("zorgOidRegi_marcOidMarc");
			String zorgOidRegi_canaOidCanaDefaultValue = (String)checkedCombos.get("zorgOidRegi_canaOidCana");
			if(zorgOidRegi_marcOidMarcDefaultValue != null &&zorgOidRegi_canaOidCanaDefaultValue != null){
				ZonRegioView2Data zorgOidRegi= new ZonRegioView2Data();
				es.indra.belcorp.mso.SegMarcaData zorgOidRegiMarcOidMarc = new es.indra.belcorp.mso.SegMarcaData();
				zorgOidRegiMarcOidMarc.setId(new Long(zorgOidRegi_marcOidMarcDefaultValue ));
				zorgOidRegi.setMarcOidMarc(zorgOidRegiMarcOidMarc);
				es.indra.belcorp.mso.SegCanalViewData zorgOidRegiCanaOidCana = new es.indra.belcorp.mso.SegCanalViewData();
				zorgOidRegiCanaOidCana.setId(new Long(zorgOidRegi_canaOidCanaDefaultValue ));
				zorgOidRegi.setCanaOidCana(zorgOidRegiCanaOidCana);
				asignarComboResultados(BUSINESSID_ZORGOIDREGI_QUERY,ZORGOIDREGI_COMBO_CONNECTOR, 
					zorgOidRegi, zorgOidRegi.clone(), "zonRegioView2", "zorgOidRegi", "result_ROWSET",false );
			}
		}

	}
	
	/**
	* Este m�todo carga todos los combos de una jerarqu�a de dependencia. La carga se realiza c
	* se realiza en funci�n de los datos de un mso del mantenimiento. 
	* @param intAccesBuzonIvrrg La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(IntAccesBuzonIvrrgData intAccesBuzonIvrrg) 
		throws Exception{
		
						if(intAccesBuzonIvrrg.getZorgOidRegi() != null){
			
						ZonRegioView2Data zorgOidRegi = new ZonRegioView2Data();
			zorgOidRegi.setMarcOidMarc(intAccesBuzonIvrrg.getZorgOidRegi().getMarcOidMarc());
			zorgOidRegi.setCanaOidCana(intAccesBuzonIvrrg.getZorgOidRegi().getCanaOidCana());
			asignarComboResultados(BUSINESSID_ZORGOIDREGI_QUERY,ZORGOIDREGI_COMBO_CONNECTOR, zorgOidRegi, zorgOidRegi.clone(), "zonRegioView2", "zorgOidRegi", "result_ROWSET");
			checkCombo("zorgOidRegi" , intAccesBuzonIvrrg.getZorgOidRegi().getId().toString());
			
						}
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la �ltima query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la b�squeda
		IntAccesBuzonIvrrgData intAccesBuzonIvrrg = 
			(IntAccesBuzonIvrrgData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarqu�a de combos dependientes
		if(intAccesBuzonIvrrg.getZorgOidRegi() != null){
			intAccesBuzonIvrrg.setZorgOidRegi((es.indra.belcorp.mso.ZonRegioView2Data)
			getSingleObject(BUSINESSID_ZORGOIDREGI_QUERY, 
			intAccesBuzonIvrrg.getZorgOidRegi(),
			intAccesBuzonIvrrg.getZorgOidRegi().clone(),
			"zonRegioView2"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarqu�as de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(intAccesBuzonIvrrg);
		loadLeafDependenceCombos(intAccesBuzonIvrrg);
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
	
	
	
		
}





