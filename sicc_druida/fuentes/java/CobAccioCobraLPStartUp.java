/*
    INDRA/CAR/mmg
    $Id: CobAccioCobraLPStartUp.java,v 1.1 2009/12/03 18:38:06 pecbazalar Exp $
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
public class CobAccioCobraLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 105;
	public static final short CREATEFORM_SIZE = 755;
	public static final short UPDATEFORM_SIZE = 755;
	public static final short VIEWFORM_SIZE = 755;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGCobAccioCobraQueryFromToUserPage";
	
	
				public static final String BUSINESSID_SACCOIDSUBTACCI_QUERY ="MMGCobSubtiAccioQueryFromToUser";
				public static final String SACCOIDSUBTACCI_COMBO_CONNECTOR = "CobSubtiAccioConectorCombo";
	
				public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisViewQueryFromToUser";
				public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisViewConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	protected static Hashtable indFechHoraSeguValues = new Hashtable();
	static{
		indFechHoraSeguValues.put(new java.lang.Long(1), "Si");
		indFechHoraSeguValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indFechImpoCompValues = new Hashtable();
	static{
		indFechImpoCompValues.put(new java.lang.Long(1), "Si");
		indFechImpoCompValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indFechHoraNuevSeguValues = new Hashtable();
	static{
		indFechHoraNuevSeguValues.put(new java.lang.Long(1), "Si");
		indFechHoraNuevSeguValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indAporPrueValues = new Hashtable();
	static{
		indAporPrueValues.put(new java.lang.Long(1), "Si");
		indAporPrueValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indDescPrueValues = new Hashtable();
	static{
		indDescPrueValues.put(new java.lang.Long(1), "Si");
		indDescPrueValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indNumeDocuSopoValues = new Hashtable();
	static{
		indNumeDocuSopoValues.put(new java.lang.Long(1), "Si");
		indNumeDocuSopoValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indTipoDocuPagoValues = new Hashtable();
	static{
		indTipoDocuPagoValues.put(new java.lang.Long(1), "Si");
		indTipoDocuPagoValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indBancSucuValues = new Hashtable();
	static{
		indBancSucuValues.put(new java.lang.Long(1), "Si");
		indBancSucuValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indNuevDireValues = new Hashtable();
	static{
		indNuevDireValues.put(new java.lang.Long(1), "Si");
		indNuevDireValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indNuevTelfValues = new Hashtable();
	static{
		indNuevTelfValues.put(new java.lang.Long(1), "Si");
		indNuevTelfValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indPasaAdmiValues = new Hashtable();
	static{
		indPasaAdmiValues.put(new java.lang.Long(1), "Si");
		indPasaAdmiValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indPetiBloqAdmiValues = new Hashtable();
	static{
		indPetiBloqAdmiValues.put(new java.lang.Long(1), "Si");
		indPetiBloqAdmiValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indPetiDesbAdmiValues = new Hashtable();
	static{
		indPetiDesbAdmiValues.put(new java.lang.Long(1), "Si");
		indPetiDesbAdmiValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indAcciMensRecoValues = new Hashtable();
	static{
		indAcciMensRecoValues.put(new java.lang.Long(1), "Si");
		indAcciMensRecoValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indObseValues = new Hashtable();
	static{
		indObseValues.put(new java.lang.Long(1), "Si");
		indObseValues.put(new java.lang.Long(0), "No");
	}
	
	
	// Definicion del constructor
	public CobAccioCobraLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("CobAccioCobraPage");
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
			buildJsPageSize("CobAccioCobra");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "CobAccioCobraPage", "cod", "CobAccioCobra." + accion + ".label");
			
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
			limpiarBotoneraLista("cobAccioCobra", accion);
			
			
			
			
			
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
		asignarAtributo("TEXT", "codAcciCobr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "cobAccioCobraLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "CobAccioCobraPage", "onblur", "window.focus();");
		
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
		conectorAction("CobAccioCobraLPStartUp");
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
		CobAccioCobraData cobAccioCobraQuery= new CobAccioCobraData();
		cobAccioCobraQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		CobAccioCobraData datosResult = (CobAccioCobraData)getSingleObject(BUSINESSID_QUERY, cobAccioCobraQuery, 
			cobAccioCobraQuery.clone(), "cobAccioCobra");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		//Guardamos los valores de los radiobuttons
		if(datosResult.getIndFechHoraSegu() != null)
			asignar("VAR", "indFechHoraSeguCheckValue", datosResult.getIndFechHoraSegu().toString());
		if(datosResult.getIndFechImpoComp() != null)
			asignar("VAR", "indFechImpoCompCheckValue", datosResult.getIndFechImpoComp().toString());
		if(datosResult.getIndFechHoraNuevSegu() != null)
			asignar("VAR", "indFechHoraNuevSeguCheckValue", datosResult.getIndFechHoraNuevSegu().toString());
		if(datosResult.getIndAporPrue() != null)
			asignar("VAR", "indAporPrueCheckValue", datosResult.getIndAporPrue().toString());
		if(datosResult.getIndDescPrue() != null)
			asignar("VAR", "indDescPrueCheckValue", datosResult.getIndDescPrue().toString());
		if(datosResult.getIndNumeDocuSopo() != null)
			asignar("VAR", "indNumeDocuSopoCheckValue", datosResult.getIndNumeDocuSopo().toString());
		if(datosResult.getIndTipoDocuPago() != null)
			asignar("VAR", "indTipoDocuPagoCheckValue", datosResult.getIndTipoDocuPago().toString());
		if(datosResult.getIndBancSucu() != null)
			asignar("VAR", "indBancSucuCheckValue", datosResult.getIndBancSucu().toString());
		if(datosResult.getIndNuevDire() != null)
			asignar("VAR", "indNuevDireCheckValue", datosResult.getIndNuevDire().toString());
		if(datosResult.getIndNuevTelf() != null)
			asignar("VAR", "indNuevTelfCheckValue", datosResult.getIndNuevTelf().toString());
		if(datosResult.getIndPasaAdmi() != null)
			asignar("VAR", "indPasaAdmiCheckValue", datosResult.getIndPasaAdmi().toString());
		if(datosResult.getIndPetiBloqAdmi() != null)
			asignar("VAR", "indPetiBloqAdmiCheckValue", datosResult.getIndPetiBloqAdmi().toString());
		if(datosResult.getIndPetiDesbAdmi() != null)
			asignar("VAR", "indPetiDesbAdmiCheckValue", datosResult.getIndPetiDesbAdmi().toString());
		if(datosResult.getIndAcciMensReco() != null)
			asignar("VAR", "indAcciMensRecoCheckValue", datosResult.getIndAcciMensReco().toString());
		if(datosResult.getIndObse() != null)
			asignar("VAR", "indObseCheckValue", datosResult.getIndObse().toString());
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		CobAccioCobraData cobAccioCobra = datosResult;
		asignar("TEXT", "codAcciCobr", FormatUtils.formatObject(cobAccioCobra.getCodAcciCobr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDesc", FormatUtils.formatObject(cobAccioCobra.getValDesc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.CobSubtiAccioData saccOidSubtAcci = cobAccioCobra.getSaccOidSubtAcci();
		if(saccOidSubtAcci != null && saccOidSubtAcci.getId() != null) checkCombo("saccOidSubtAcci" , saccOidSubtAcci.getId().toString());
		asignarAtributo("RADIOB", "indFechHoraSegu" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndFechHoraSegu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indFechImpoComp" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndFechImpoComp(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indFechHoraNuevSegu" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndFechHoraNuevSegu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indAporPrue" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndAporPrue(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indDescPrue" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndDescPrue(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indNumeDocuSopo" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndNumeDocuSopo(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indTipoDocuPago" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndTipoDocuPago(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indBancSucu" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndBancSucu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indNuevDire" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndNuevDire(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indNuevTelf" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndNuevTelf(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indPasaAdmi" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndPasaAdmi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indPetiBloqAdmi" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndPetiBloqAdmi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indPetiDesbAdmi" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndPetiDesbAdmi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indAcciMensReco" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndAcciMensReco(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indObse" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndObse(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valObse", FormatUtils.formatObject(cobAccioCobra.getValObse(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		asignarAtributo("TEXT", "codAcciCobr", "disabled", "S");
		asignarAtributo("TEXT", "valDesc", "disabled", "S");
		
					asignarAtributo("COMBO", "saccOidSubtAcci", "disabled", "S");
					asignarAtributo("RADIOB", "indFechHoraSegu", "disabled", "S");
		
					asignarAtributo("RADIOB", "indFechImpoComp", "disabled", "S");
		
					asignarAtributo("RADIOB", "indFechHoraNuevSegu", "disabled", "S");
		
					asignarAtributo("RADIOB", "indAporPrue", "disabled", "S");
		
					asignarAtributo("RADIOB", "indDescPrue", "disabled", "S");
		
					asignarAtributo("RADIOB", "indNumeDocuSopo", "disabled", "S");
		
					asignarAtributo("RADIOB", "indTipoDocuPago", "disabled", "S");
		
					asignarAtributo("RADIOB", "indBancSucu", "disabled", "S");
		
					asignarAtributo("RADIOB", "indNuevDire", "disabled", "S");
		
					asignarAtributo("RADIOB", "indNuevTelf", "disabled", "S");
		
					asignarAtributo("RADIOB", "indPasaAdmi", "disabled", "S");
		
					asignarAtributo("RADIOB", "indPetiBloqAdmi", "disabled", "S");
		
					asignarAtributo("RADIOB", "indPetiDesbAdmi", "disabled", "S");
		
					asignarAtributo("RADIOB", "indAcciMensReco", "disabled", "S");
		
					asignarAtributo("RADIOB", "indObse", "disabled", "S");
		asignarAtributo("TEXT", "valObse", "disabled", "S");
		
		
	
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
		asignarAtributo("TEXT", "codAcciCobr", "req", "S");
		asignarAtributo("TEXT", "valDesc", "req", "S");
		asignarAtributo("COMBO", "saccOidSubtAcci", "req", "S");
		
		
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
		asignarAtributo("TEXT", "codAcciCobr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "valObse", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 100);");
		
		
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
		asignarAtributo("TEXT", "codAcciCobr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
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
		asignarAtributo("TEXT", "codAcciCobr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
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
		asignarAtributo("TEXT", "codAcciCobr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
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
		conectorAction("CobAccioCobraLPStartUp");
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
		//asignarAtributo("FORMULARIO", "cobAccioCobraFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("TEXT", "codAcciCobr", "req", "S");
				asignarAtributo("TEXT", "valDesc", "req", "S");
				asignarAtributo("COMBO", "saccOidSubtAcci", "req", "S");
		
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
		
			asignarAtributo("TEXT", "codAcciCobr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
			asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			asignarAtributo("TEXT", "valObse", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 100);");

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando CobAccioCobra");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		CobAccioCobraData cobAccioCobraQuery= new CobAccioCobraData();
		cobAccioCobraQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		CobAccioCobraData  datosResult = (CobAccioCobraData)getSingleObject(BUSINESSID_QUERY, cobAccioCobraQuery, 
			cobAccioCobraQuery.clone(), "cobAccioCobra");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		//Guardamos los valores de los radiobuttons
		if(datosResult.getIndFechHoraSegu() != null)
			asignar("VAR", "indFechHoraSeguCheckValue", datosResult.getIndFechHoraSegu().toString());
		if(datosResult.getIndFechImpoComp() != null)
			asignar("VAR", "indFechImpoCompCheckValue", datosResult.getIndFechImpoComp().toString());
		if(datosResult.getIndFechHoraNuevSegu() != null)
			asignar("VAR", "indFechHoraNuevSeguCheckValue", datosResult.getIndFechHoraNuevSegu().toString());
		if(datosResult.getIndAporPrue() != null)
			asignar("VAR", "indAporPrueCheckValue", datosResult.getIndAporPrue().toString());
		if(datosResult.getIndDescPrue() != null)
			asignar("VAR", "indDescPrueCheckValue", datosResult.getIndDescPrue().toString());
		if(datosResult.getIndNumeDocuSopo() != null)
			asignar("VAR", "indNumeDocuSopoCheckValue", datosResult.getIndNumeDocuSopo().toString());
		if(datosResult.getIndTipoDocuPago() != null)
			asignar("VAR", "indTipoDocuPagoCheckValue", datosResult.getIndTipoDocuPago().toString());
		if(datosResult.getIndBancSucu() != null)
			asignar("VAR", "indBancSucuCheckValue", datosResult.getIndBancSucu().toString());
		if(datosResult.getIndNuevDire() != null)
			asignar("VAR", "indNuevDireCheckValue", datosResult.getIndNuevDire().toString());
		if(datosResult.getIndNuevTelf() != null)
			asignar("VAR", "indNuevTelfCheckValue", datosResult.getIndNuevTelf().toString());
		if(datosResult.getIndPasaAdmi() != null)
			asignar("VAR", "indPasaAdmiCheckValue", datosResult.getIndPasaAdmi().toString());
		if(datosResult.getIndPetiBloqAdmi() != null)
			asignar("VAR", "indPetiBloqAdmiCheckValue", datosResult.getIndPetiBloqAdmi().toString());
		if(datosResult.getIndPetiDesbAdmi() != null)
			asignar("VAR", "indPetiDesbAdmiCheckValue", datosResult.getIndPetiDesbAdmi().toString());
		if(datosResult.getIndAcciMensReco() != null)
			asignar("VAR", "indAcciMensRecoCheckValue", datosResult.getIndAcciMensReco().toString());
		if(datosResult.getIndObse() != null)
			asignar("VAR", "indObseCheckValue", datosResult.getIndObse().toString());
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		CobAccioCobraData cobAccioCobra = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		asignar("TEXT", "codAcciCobr", FormatUtils.formatObject(cobAccioCobra.getCodAcciCobr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDesc", FormatUtils.formatObject(cobAccioCobra.getValDesc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.CobSubtiAccioData saccOidSubtAcci = cobAccioCobra.getSaccOidSubtAcci();
		if(saccOidSubtAcci != null && saccOidSubtAcci.getId() != null) checkCombo("saccOidSubtAcci" , saccOidSubtAcci.getId().toString());
		asignarAtributo("RADIOB", "indFechHoraSegu" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndFechHoraSegu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indFechImpoComp" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndFechImpoComp(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indFechHoraNuevSegu" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndFechHoraNuevSegu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indAporPrue" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndAporPrue(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indDescPrue" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndDescPrue(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indNumeDocuSopo" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndNumeDocuSopo(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indTipoDocuPago" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndTipoDocuPago(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indBancSucu" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndBancSucu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indNuevDire" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndNuevDire(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indNuevTelf" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndNuevTelf(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indPasaAdmi" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndPasaAdmi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indPetiBloqAdmi" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndPetiBloqAdmi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indPetiDesbAdmi" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndPetiDesbAdmi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indAcciMensReco" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndAcciMensReco(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indObse" , "valor", FormatUtils.formatObject(
			cobAccioCobra.getIndObse(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valObse", FormatUtils.formatObject(cobAccioCobra.getValObse(), 
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
		//asignar("VAR","timestamp",Long.toString(cobAccioCobra.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",1, false)");
				asignarAtributo("AREATEXTO", "codAcciCobr", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",2, true)");
				asignarAtributo("AREATEXTO", "codAcciCobr", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",2, false)");
				asignarAtributo("AREATEXTO", "valDesc", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",3, true)");
				asignarAtributo("AREATEXTO", "valDesc", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",3, false)");
					asignarAtributo("COMBO","saccOidSubtAcci", "ontab", "ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",4, true)");
					asignarAtributo("COMBO","saccOidSubtAcci", "onshtab", "ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",4, false)");
				asignarAtributo("TEXT", "indFechHoraSegu", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",5, true)");
				asignarAtributo("TEXT", "indFechHoraSegu", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",5, false)");
				asignarAtributo("TEXT", "indFechImpoComp", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",6, true)");
				asignarAtributo("TEXT", "indFechImpoComp", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",6, false)");
				asignarAtributo("TEXT", "indFechHoraNuevSegu", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",7, true)");
				asignarAtributo("TEXT", "indFechHoraNuevSegu", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",7, false)");
				asignarAtributo("TEXT", "indAporPrue", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",8, true)");
				asignarAtributo("TEXT", "indAporPrue", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",8, false)");
				asignarAtributo("TEXT", "indDescPrue", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",9, true)");
				asignarAtributo("TEXT", "indDescPrue", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",9, false)");
				asignarAtributo("TEXT", "indNumeDocuSopo", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",10, true)");
				asignarAtributo("TEXT", "indNumeDocuSopo", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",10, false)");
				asignarAtributo("TEXT", "indTipoDocuPago", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",11, true)");
				asignarAtributo("TEXT", "indTipoDocuPago", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",11, false)");
				asignarAtributo("TEXT", "indBancSucu", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",12, true)");
				asignarAtributo("TEXT", "indBancSucu", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",12, false)");
				asignarAtributo("TEXT", "indNuevDire", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",13, true)");
				asignarAtributo("TEXT", "indNuevDire", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",13, false)");
				asignarAtributo("TEXT", "indNuevTelf", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",14, true)");
				asignarAtributo("TEXT", "indNuevTelf", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",14, false)");
				asignarAtributo("TEXT", "indPasaAdmi", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",15, true)");
				asignarAtributo("TEXT", "indPasaAdmi", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",15, false)");
				asignarAtributo("TEXT", "indPetiBloqAdmi", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",16, true)");
				asignarAtributo("TEXT", "indPetiBloqAdmi", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",16, false)");
				asignarAtributo("TEXT", "indPetiDesbAdmi", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",17, true)");
				asignarAtributo("TEXT", "indPetiDesbAdmi", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",17, false)");
				asignarAtributo("TEXT", "indAcciMensReco", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",18, true)");
				asignarAtributo("TEXT", "indAcciMensReco", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",18, false)");
				asignarAtributo("TEXT", "indObse", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",19, true)");
				asignarAtributo("TEXT", "indObse", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",19, false)");
				asignarAtributo("AREATEXTO", "valObse", "ontab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",20, true)");
				asignarAtributo("AREATEXTO", "valObse", "onshtab","ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",20, false)");
					asignarAtributo("COMBO","paisOidPais", "ontab", "ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",21, true)");
					asignarAtributo("COMBO","paisOidPais", "onshtab", "ejecutarAccionFocoModificacion(\"cobAccioCobraFrm\",21, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","cobAccioCobraTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","cobAccioCobraTrButtons");

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
		borrarCampo("saccOidSubtAcci");
		borrarCampo("indFechHoraSegu");
		borrarCampo("indFechImpoComp");
		borrarCampo("indFechHoraNuevSegu");
		borrarCampo("indAporPrue");
		borrarCampo("indDescPrue");
		borrarCampo("indNumeDocuSopo");
		borrarCampo("indTipoDocuPago");
		borrarCampo("indBancSucu");
		borrarCampo("indNuevDire");
		borrarCampo("indNuevTelf");
		borrarCampo("indPasaAdmi");
		borrarCampo("indPetiBloqAdmi");
		borrarCampo("indPetiDesbAdmi");
		borrarCampo("indAcciMensReco");
		borrarCampo("indObse");
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
				
				traza("MMG: el atributo es codAcciCobr...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						// borrarCampo("codAcciCobr");
						asignarAtributo ("TEXT", "codAcciCobr", "disabled", "S");
				traza("MMG: el atributo es valDesc...");		
				
				traza("MMG: el atributo es saccOidSubtAcci...");		
				
				traza("MMG: el atributo es indFechHoraSegu...");		
				
				traza("MMG: el atributo es indFechImpoComp...");		
				
				traza("MMG: el atributo es indFechHoraNuevSegu...");		
				
				traza("MMG: el atributo es indAporPrue...");		
				
				traza("MMG: el atributo es indDescPrue...");		
				
				traza("MMG: el atributo es indNumeDocuSopo...");		
				
				traza("MMG: el atributo es indTipoDocuPago...");		
				
				traza("MMG: el atributo es indBancSucu...");		
				
				traza("MMG: el atributo es indNuevDire...");		
				
				traza("MMG: el atributo es indNuevTelf...");		
				
				traza("MMG: el atributo es indPasaAdmi...");		
				
				traza("MMG: el atributo es indPetiBloqAdmi...");		
				
				traza("MMG: el atributo es indPetiDesbAdmi...");		
				
				traza("MMG: el atributo es indAcciMensReco...");		
				
				traza("MMG: el atributo es indObse...");		
				
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
		asignarAtributo("CAPA","cobAccioCobraFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","cobAccioCobraListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","cobAccioCobraListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(CobAccioCobraData cobAccioCobra) throws Exception{
		HashMap checkedCombos = new HashMap();
		CobSubtiAccioData saccOidSubtAcci = new CobSubtiAccioData();
		
						asignarComboResultados(BUSINESSID_SACCOIDSUBTACCI_QUERY,SACCOIDSUBTACCI_COMBO_CONNECTOR, 
			saccOidSubtAcci, saccOidSubtAcci.clone(), "cobSubtiAccio", "saccOidSubtAcci", "result_ROWSET" );
		if(cobAccioCobra != null && cobAccioCobra.getSaccOidSubtAcci() != null){
				checkCombo("saccOidSubtAcci" , cobAccioCobra.getSaccOidSubtAcci().getId().toString());
			}
		SegPaisViewData paisOidPais = new SegPaisViewData();
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, 
			paisOidPais, paisOidPais.clone(), "segPaisView", "paisOidPais", "result_ROWSET" );
		if(cobAccioCobra != null && cobAccioCobra.getPaisOidPais() != null){
				checkCombo("paisOidPais" , cobAccioCobra.getPaisOidPais().getId().toString());
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
	* @param cobAccioCobra La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(CobAccioCobraData cobAccioCobra) 
		throws Exception{
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		CobAccioCobraData cobAccioCobra = 
			(CobAccioCobraData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(cobAccioCobra.getSaccOidSubtAcci() != null){
			cobAccioCobra.setSaccOidSubtAcci((es.indra.belcorp.mso.CobSubtiAccioData)
			getSingleObject(BUSINESSID_SACCOIDSUBTACCI_QUERY, 
			cobAccioCobra.getSaccOidSubtAcci(),
			cobAccioCobra.getSaccOidSubtAcci().clone(),
			"cobSubtiAccio"));
		}
		if(cobAccioCobra.getPaisOidPais() != null){
			cobAccioCobra.setPaisOidPais((es.indra.belcorp.mso.SegPaisViewData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			cobAccioCobra.getPaisOidPais(),
			cobAccioCobra.getPaisOidPais().clone(),
			"segPaisView"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(cobAccioCobra);
		loadLeafDependenceCombos(cobAccioCobra);
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
			borrarNodo("TR","nombre","formTr4");
			borrarNodo("TR","nombre","formGapTr4");
			borrarNodo("TR","nombre","formTr5");
			borrarNodo("TR","nombre","formGapTr5");
			borrarNodo("TR","nombre","formTr6");
			borrarNodo("TR","nombre","formGapTr6");
			borrarNodo("TR","nombre","formTr7");
			borrarNodo("TR","nombre","formGapTr7");
			borrarNodo("TR","nombre","formTr8");
			borrarNodo("TR","nombre","formGapTr8");
			borrarNodo("TR","nombre","formTr9");
			borrarNodo("TR","nombre","formGapTr9");
			borrarNodo("TR","nombre","formTr10");
			borrarNodo("TR","nombre","formGapTr10");
			borrarNodo("TR","nombre","formTr11");
			borrarNodo("TR","nombre","formGapTr11");
			borrarNodo("TR","nombre","formTr12");
			borrarNodo("TR","nombre","formGapTr12");
			borrarNodo("TR","nombre","formTr13");
			borrarNodo("TR","nombre","formGapTr13");
			borrarNodo("TR","nombre","formTr14");
			borrarNodo("TR","nombre","formGapTr14");
			borrarNodo("TR","nombre","formTr15");
			borrarNodo("TR","nombre","formGapTr15");
			borrarNodo("TR","nombre","formTr16");
			borrarNodo("TR","nombre","formGapTr16");
			borrarNodo("TR","nombre","formTr17");
			borrarNodo("TR","nombre","formGapTr17");
			borrarNodo("TR","nombre","formTr18");
			borrarNodo("TR","nombre","formGapTr18");
			
		}else if(accion.equals(ACCION_VIEW) && origen.equals("preview")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			borrarNodo("TR","nombre","formTr18");
			borrarNodo("TR","nombre","formGapTr18");
			
		}else if(accion.equals(ACCION_CREATE)){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			borrarNodo("TR","nombre","formTr18");
			borrarNodo("TR","nombre","formGapTr18");
			
		}else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			borrarNodo("TR","nombre","formTr18");
			borrarNodo("TR","nombre","formGapTr18");
			
		}
	}
	
	
	
		
}





