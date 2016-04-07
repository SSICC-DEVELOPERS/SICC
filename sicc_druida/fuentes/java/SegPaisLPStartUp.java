/*
    INDRA/CAR/mmg
    $Id: SegPaisLPStartUp.java,v 1.1 2009/12/03 18:36:15 pecbazalar Exp $
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
public class SegPaisLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios seg�n el modo
	public static final short QUERYFORM_SIZE = 105;
	public static final short CREATEFORM_SIZE = 425;
	public static final short UPDATEFORM_SIZE = 425;
	public static final short VIEWFORM_SIZE = 425;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGSegPaisQueryFromToUserPageStructuralSecurity";
	
	
				public static final String BUSINESSID_MONEOIDMONE_QUERY ="MMGSegMonedQueryFromToUserStructuralSecurity";
				public static final String MONEOIDMONE_COMBO_CONNECTOR = "SegMonedConectorCombo";
	
				public static final String BUSINESSID_MONEOIDMONEALT_QUERY ="MMGSegMonedQueryFromToUserStructuralSecurity";
				public static final String MONEOIDMONEALT_COMBO_CONNECTOR = "SegMonedConectorCombo";
	
				public static final String BUSINESSID_FOPAOIDFORMPAGO_QUERY ="MMGBelFormaPagoTaponQueryFromToUserStructuralSecurity";
				public static final String FOPAOIDFORMPAGO_COMBO_CONNECTOR = "BelFormaPagoTaponConectorCombo";
	
		
	//Hashtables con los valores est�ticos de radiobuttons y combos
	protected static Hashtable indInteGisValues = new Hashtable();
	static{
		indInteGisValues.put(new java.lang.String("I"), "GIS");
		indInteGisValues.put(new java.lang.String("G"), "Georreferenciador");
	}
	protected static Hashtable valIdenValues = new Hashtable();
	static{
		valIdenValues.put(new java.lang.String("B"), "Boleta");
		valIdenValues.put(new java.lang.String("F"), "Factura");
	}
	protected static Hashtable indSaldUnicValues = new Hashtable();
	static{
		indSaldUnicValues.put(new java.lang.String("1"), "Si");
		indSaldUnicValues.put(new java.lang.String("0"), "No");
	}
	protected static Hashtable indCompAutoValues = new Hashtable();
	static{
		indCompAutoValues.put(new java.lang.String("1"), "Si");
		indCompAutoValues.put(new java.lang.String("0"), "No");
	}
	protected static Hashtable indTratAcumDescValues = new Hashtable();
	static{
		indTratAcumDescValues.put(new java.lang.String("1"), "Si");
		indTratAcumDescValues.put(new java.lang.String("0"), "No");
	}
	protected static Hashtable valConfSecuCccValues = new Hashtable();
	static{

		valConfSecuCccValues.put(new java.lang.String("U"), "&Uacute;nico");
		valConfSecuCccValues.put(new java.lang.String("A"), "A&ntilde;o");
		valConfSecuCccValues.put(new java.lang.String("M"), "Mes y a&ntilde;o");
	}
	protected static Hashtable indEmisVencValues = new Hashtable();
	static{
		indEmisVencValues.put(new java.lang.String("1"), "Si");
		indEmisVencValues.put(new java.lang.String("0"), "No");
	}
	protected static Hashtable valFormFechValues = new Hashtable();
	static{
		valFormFechValues.put(new java.lang.String("dd/mm/yyyy"), "dd/mm/aaaa");
		valFormFechValues.put(new java.lang.String("mm/dd/yyyy"), "mm/dd/aaaa");
		valFormFechValues.put(new java.lang.String("dd-mm-yyyy"), "dd-mm-aaaa");
	}
	protected static Hashtable valSepaMileValues = new Hashtable();
	static{
		valSepaMileValues.put(new java.lang.String(","), ",");
		valSepaMileValues.put(new java.lang.String("."), ".");
	}
	protected static Hashtable valSepaDeciValues = new Hashtable();
	static{
		valSepaDeciValues.put(new java.lang.String(","), ",");
		valSepaDeciValues.put(new java.lang.String("."), ".");
	}
	protected static Hashtable indFletZonaUbigValues = new Hashtable();
	static{
		indFletZonaUbigValues.put(new java.lang.String("U"), "Ubigeo");
		indFletZonaUbigValues.put(new java.lang.String("Z"), "Zona");
	}
	protected static Hashtable valIndiSecuMoniValues = new Hashtable();
	static{
		valIndiSecuMoniValues.put(new java.lang.String("1"), "Si");
		valIndiSecuMoniValues.put(new java.lang.String("0"), "No");
	}
	protected static Hashtable indSecuValues = new Hashtable();
	static{
		indSecuValues.put(new java.lang.String("M"), "Monto");
		indSecuValues.put(new java.lang.String("T"), "Transporte");
		indSecuValues.put(new java.lang.String("I"), "Inicio");
		indSecuValues.put(new java.lang.String("F"), "Final");
	}
	protected static Hashtable indBalaAreaCheqValues = new Hashtable();
	static{
		indBalaAreaCheqValues.put(new java.lang.String("P"), "MODELO PERU");
		indBalaAreaCheqValues.put(new java.lang.String("C"), "MODELO COLOMBIA");
	}
	protected static Hashtable indImpuInclValues = new Hashtable();
	static{
		indImpuInclValues.put(new java.lang.Long(1), "Si");
		indImpuInclValues.put(new java.lang.Long(0), "No");
	}
	
	
	// Definicion del constructor
	public SegPaisLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("SegPaisPage");
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
			buildJsPageSize("SegPais");
			
			//Determinamos la acci�n y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el t�tulo i18nalizado
			//y para que funcione de forma correcta la configuraci�n del men� secundario
			asignarAtributo("PAGINA", "SegPaisPage", "cod", "SegPais." + accion + ".label");
			
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
			limpiarBotoneraLista("segPais", accion);
			
			
			
			
			//Indicamos que no hay que aplicar seguridad estructural ya que es un entidad structural
			asignar("VAR", VAR_APPLY_STRUCTURAL_ENTITY, "false");
			
			
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
		asignarAtributo("TEXT", "codPais", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 3);");
		asignarAtributo("COMBO", "moneOidMone", "validacion", "VerificaContenidoCmbs('segPaisFrm.moneOidMone','segPaisFrm.moneOidMoneAlt','SegPais','moneOidMone')");
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "segPaisLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "SegPaisPage", "onblur", "window.focus();");
		
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
		conectorAction("SegPaisLPStartUp");
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
		SegPaisData segPaisQuery= new SegPaisData();
		segPaisQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acci�n anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		SegPaisData datosResult = (SegPaisData)getSingleObject(BUSINESSID_QUERY, segPaisQuery, 
			segPaisQuery.clone(), "segPais", false);
		
		
		//Comprobamos que haya datos. Si no indicamos la situaci�n
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Creamos los campos ocultos para la internacionalizaci�n
		preservaHiddensI18n(new Integer(1), "SEG_PAIS", "segPaisFrm", "Descripcion", true);
		
		
		//Guardamos los valores de los radiobuttons
		if(datosResult.getIndSaldUnic() != null)
			asignar("VAR", "indSaldUnicCheckValue", datosResult.getIndSaldUnic().toString());
		if(datosResult.getIndCompAuto() != null)
			asignar("VAR", "indCompAutoCheckValue", datosResult.getIndCompAuto().toString());
		if(datosResult.getIndTratAcumDesc() != null)
			asignar("VAR", "indTratAcumDescCheckValue", datosResult.getIndTratAcumDesc().toString());
		if(datosResult.getIndEmisVenc() != null)
			asignar("VAR", "indEmisVencCheckValue", datosResult.getIndEmisVenc().toString());
		if(datosResult.getValIndiSecuMoni() != null)
			asignar("VAR", "valIndiSecuMoniCheckValue", datosResult.getValIndiSecuMoni().toString());
		if(datosResult.getIndImpuIncl() != null)
			asignar("VAR", "indImpuInclCheckValue", datosResult.getIndImpuIncl().toString());
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		SegPaisData segPais = datosResult;
		asignar("TEXT", "codPais", FormatUtils.formatObject(segPais.getCodPais(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.SegMonedData moneOidMone = segPais.getMoneOidMone();
		if(moneOidMone != null && moneOidMone.getId() != null) checkCombo("moneOidMone" , moneOidMone.getId().toString());
		es.indra.belcorp.mso.SegMonedData moneOidMoneAlt = segPais.getMoneOidMoneAlt();
		if(moneOidMoneAlt != null && moneOidMoneAlt.getId() != null) checkCombo("moneOidMoneAlt" , moneOidMoneAlt.getId().toString());
		asignar("TEXT", "Descripcion", FormatUtils.formatObject(segPais.getDescripcion(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(segPais.getIndInteGis() != null){	
			checkCombo("indInteGis", FormatUtils.formatObject(segPais.getIndInteGis(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		if(segPais.getValIden() != null){	
			checkCombo("valIden", FormatUtils.formatObject(segPais.getValIden(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignarAtributo("RADIOB", "indSaldUnic" , "valor", FormatUtils.formatObject(
			segPais.getIndSaldUnic(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valProgEjec", FormatUtils.formatObject(segPais.getValProgEjec(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPorcAlar", FormatUtils.formatObject(segPais.getValPorcAlar(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indCompAuto" , "valor", FormatUtils.formatObject(
			segPais.getIndCompAuto(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numDiasMora", FormatUtils.formatObject(segPais.getNumDiasMora(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indTratAcumDesc" , "valor", FormatUtils.formatObject(
			segPais.getIndTratAcumDesc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valTiemRezo", FormatUtils.formatObject(segPais.getValTiemRezo(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(segPais.getValConfSecuCcc() != null){	
			checkCombo("valConfSecuCcc", FormatUtils.formatObject(segPais.getValConfSecuCcc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignar("TEXT", "numDiasFact", FormatUtils.formatObject(segPais.getNumDiasFact(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numLimiDifePago", FormatUtils.formatObject(segPais.getNumLimiDifePago(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indEmisVenc" , "valor", FormatUtils.formatObject(
			segPais.getIndEmisVenc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valMaxiDifeAnlsComb", FormatUtils.formatObject(segPais.getValMaxiDifeAnlsComb(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numPosiNumeClie", FormatUtils.formatObject(segPais.getNumPosiNumeClie(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(segPais.getValFormFech() != null){	
			checkCombo("valFormFech", FormatUtils.formatObject(segPais.getValFormFech(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		if(segPais.getValSepaMile() != null){	
			checkCombo("valSepaMile", FormatUtils.formatObject(segPais.getValSepaMile(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		if(segPais.getValSepaDeci() != null){	
			checkCombo("valSepaDeci", FormatUtils.formatObject(segPais.getValSepaDeci(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignar("TEXT", "numPeriEgre", FormatUtils.formatObject(segPais.getNumPeriEgre(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numPeriReti", FormatUtils.formatObject(segPais.getNumPeriReti(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.BelFormaPagoTaponData fopaOidFormPago = segPais.getFopaOidFormPago();
		if(fopaOidFormPago != null && fopaOidFormPago.getId() != null) checkCombo("fopaOidFormPago" , fopaOidFormPago.getId().toString());
		asignar("TEXT", "valCompTele", FormatUtils.formatObject(segPais.getValCompTele(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(segPais.getIndFletZonaUbig() != null){	
			checkCombo("indFletZonaUbig", FormatUtils.formatObject(segPais.getIndFletZonaUbig(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignarAtributo("RADIOB", "valIndiSecuMoni" , "valor", FormatUtils.formatObject(
			segPais.getValIndiSecuMoni(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(segPais.getIndSecu() != null){	
			checkCombo("indSecu", FormatUtils.formatObject(segPais.getIndSecu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		if(segPais.getIndBalaAreaCheq() != null){	
			checkCombo("indBalaAreaCheq", FormatUtils.formatObject(segPais.getIndBalaAreaCheq(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignar("AREATEXTO", "valUrl", FormatUtils.formatObject(segPais.getValUrl(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indImpuIncl" , "valor", FormatUtils.formatObject(
			segPais.getIndImpuIncl(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		
			
		//Sacamos la informaci�n de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la b�squeda
		//	Creamos el dto y metemos la informaci�n necesaria para ejecutar la query
		//	Invocamos la l�gica de negocio
		loadLocalizationVars(segPais);
		
			
		//Deshabilitamos todos los campos para que no se editen
		asignarAtributo("TEXT", "codPais", "disabled", "S");
		
					asignarAtributo("COMBO", "moneOidMone", "disabled", "S");
					asignarAtributo("COMBO", "moneOidMoneAlt", "disabled", "S");asignarAtributo("TEXT", "Descripcion", "disabled", "S");
		
					asignarAtributo("COMBO", "indInteGis", "disabled", "S");
					asignarAtributo("COMBO", "valIden", "disabled", "S");
					asignarAtributo("RADIOB", "indSaldUnic", "disabled", "S");
		asignarAtributo("TEXT", "valProgEjec", "disabled", "S");
		asignarAtributo("TEXT", "valPorcAlar", "disabled", "S");
		
					asignarAtributo("RADIOB", "indCompAuto", "disabled", "S");
		asignarAtributo("TEXT", "numDiasMora", "disabled", "S");
		
					asignarAtributo("RADIOB", "indTratAcumDesc", "disabled", "S");
		asignarAtributo("TEXT", "valTiemRezo", "disabled", "S");
		
					asignarAtributo("COMBO", "valConfSecuCcc", "disabled", "S");asignarAtributo("TEXT", "numDiasFact", "disabled", "S");
		asignarAtributo("TEXT", "numLimiDifePago", "disabled", "S");
		
					asignarAtributo("RADIOB", "indEmisVenc", "disabled", "S");
		asignarAtributo("TEXT", "valMaxiDifeAnlsComb", "disabled", "S");
		asignarAtributo("TEXT", "numPosiNumeClie", "disabled", "S");
		
					asignarAtributo("COMBO", "valFormFech", "disabled", "S");
					asignarAtributo("COMBO", "valSepaMile", "disabled", "S");
					asignarAtributo("COMBO", "valSepaDeci", "disabled", "S");asignarAtributo("TEXT", "numPeriEgre", "disabled", "S");
		asignarAtributo("TEXT", "numPeriReti", "disabled", "S");
		
					asignarAtributo("COMBO", "fopaOidFormPago", "disabled", "S");asignarAtributo("TEXT", "valCompTele", "disabled", "S");
		
					asignarAtributo("COMBO", "indFletZonaUbig", "disabled", "S");
					asignarAtributo("RADIOB", "valIndiSecuMoni", "disabled", "S");
		
					asignarAtributo("COMBO", "indSecu", "disabled", "S");
					asignarAtributo("COMBO", "indBalaAreaCheq", "disabled", "S");asignarAtributo("AREATEXTO", "valUrl", "disabled", "S");
		
					asignarAtributo("RADIOB", "indImpuIncl", "disabled", "S");
		
		
	
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
		preservaHiddensI18n(new Integer(1), "SEG_PAIS", "segPaisFrm", "Descripcion", false);
		

		//Cargamos las combos finales de las jerarqu�as de herencia
		loadLeafDependenceCombos(null);
	
		//Ponemos los campos requeridos a true
		asignarAtributo("TEXT", "codPais", "req", "S");
		asignarAtributo("COMBO", "moneOidMone", "req", "S");
		asignarAtributo("TEXT", "Descripcion", "req", "S");
		asignarAtributo("COMBO", "indInteGis", "req", "S");
		asignarAtributo("COMBO", "valIden", "req", "S");
		asignarAtributo("RADIOB", "indSaldUnic", "req", "S");
		asignarAtributo("TEXT", "valProgEjec", "req", "S");
		asignarAtributo("TEXT", "valPorcAlar", "req", "S");
		asignarAtributo("RADIOB", "indCompAuto", "req", "S");
		asignarAtributo("TEXT", "numDiasMora", "req", "S");
		asignarAtributo("RADIOB", "indTratAcumDesc", "req", "S");
		asignarAtributo("TEXT", "valTiemRezo", "req", "S");
		asignarAtributo("COMBO", "valConfSecuCcc", "req", "S");
		asignarAtributo("TEXT", "numDiasFact", "req", "S");
		asignarAtributo("TEXT", "numLimiDifePago", "req", "S");
		asignarAtributo("RADIOB", "indEmisVenc", "req", "S");
		asignarAtributo("TEXT", "valMaxiDifeAnlsComb", "req", "S");
		asignarAtributo("TEXT", "numPosiNumeClie", "req", "S");
		asignarAtributo("COMBO", "valFormFech", "req", "S");
		asignarAtributo("COMBO", "valSepaMile", "req", "S");
		asignarAtributo("COMBO", "valSepaDeci", "req", "S");
		asignarAtributo("TEXT", "numPeriEgre", "req", "S");
		asignarAtributo("TEXT", "numPeriReti", "req", "S");
		asignarAtributo("COMBO", "indFletZonaUbig", "req", "S");
		asignarAtributo("RADIOB", "valIndiSecuMoni", "req", "S");
		asignarAtributo("AREATEXTO", "valUrl", "req", "S");
		asignarAtributo("RADIOB", "indImpuIncl", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la funci�n de onblur para actualizar el 
		//valor del idioma por defecto
		asignarAtributo("TEXT", "Descripcion", "onblur", "setDefaultLanguageValue('Descripcion', get('segPaisFrm.Descripcion'))");
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codPais", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 3);");
		asignarAtributo("COMBO", "moneOidMone", "validacion", "VerificaContenidoCmbs('segPaisFrm.moneOidMone','segPaisFrm.moneOidMoneAlt','SegPais','moneOidMone')");
		
		asignarAtributo("TEXT", "Descripcion", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
		
		
		
		asignarAtributo("TEXT", "valProgEjec", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 10);");
		asignarAtributo("TEXT", "valPorcAlar", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'SegPais.valPorcAlar', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		
		asignarAtributo("TEXT", "numDiasMora", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		
		asignarAtributo("TEXT", "valTiemRezo", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
		
		asignarAtributo("TEXT", "numDiasFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
		asignarAtributo("TEXT", "numLimiDifePago", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'SegPais.numLimiDifePago', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		
		asignarAtributo("TEXT", "valMaxiDifeAnlsComb", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'SegPais.valMaxiDifeAnlsComb', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "numPosiNumeClie", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
		
		asignarAtributo("COMBO", "valSepaMile", "validacion", "VerificaContenidoCmbs('segPaisFrm.valSepaMile','segPaisFrm.valSepaDeci','SegPais','valSepaMile')");
		
		asignarAtributo("TEXT", "numPeriEgre", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
		asignarAtributo("TEXT", "numPeriReti", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
		
		asignarAtributo("TEXT", "valCompTele", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
		
		
		
		
		asignarAtributo("AREATEXTO", "valUrl", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 1024)");
		
		
		
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
		asignarAtributo("TEXT", "codPais", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 3);");
		asignarAtributo("COMBO", "moneOidMone", "validacion", "VerificaContenidoCmbs('segPaisFrm.moneOidMone','segPaisFrm.moneOidMoneAlt','SegPais','moneOidMone')");
		
		
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
		asignarAtributo("TEXT", "codPais", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 3);");
		asignarAtributo("COMBO", "moneOidMone", "validacion", "VerificaContenidoCmbs('segPaisFrm.moneOidMone','segPaisFrm.moneOidMoneAlt','SegPais','moneOidMone')");
		
		
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
		asignarAtributo("TEXT", "codPais", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 3);");
		asignarAtributo("COMBO", "moneOidMone", "validacion", "VerificaContenidoCmbs('segPaisFrm.moneOidMone','segPaisFrm.moneOidMoneAlt','SegPais','moneOidMone')");
		
		
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
		conectorAction("SegPaisLPStartUp");
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
		//asignarAtributo("FORMULARIO", "segPaisFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("TEXT", "codPais", "req", "S");
				asignarAtributo("COMBO", "moneOidMone", "req", "S");
				asignarAtributo("TEXT", "Descripcion", "req", "S");
				asignarAtributo("COMBO", "indInteGis", "req", "S");
				asignarAtributo("COMBO", "valIden", "req", "S");
				asignarAtributo("RADIOB", "indSaldUnic", "req", "S");
				asignarAtributo("TEXT", "valProgEjec", "req", "S");
				asignarAtributo("TEXT", "valPorcAlar", "req", "S");
				asignarAtributo("RADIOB", "indCompAuto", "req", "S");
				asignarAtributo("TEXT", "numDiasMora", "req", "S");
				asignarAtributo("RADIOB", "indTratAcumDesc", "req", "S");
				asignarAtributo("TEXT", "valTiemRezo", "req", "S");
				asignarAtributo("COMBO", "valConfSecuCcc", "req", "S");
				asignarAtributo("TEXT", "numDiasFact", "req", "S");
				asignarAtributo("TEXT", "numLimiDifePago", "req", "S");
				asignarAtributo("RADIOB", "indEmisVenc", "req", "S");
				asignarAtributo("TEXT", "valMaxiDifeAnlsComb", "req", "S");
				asignarAtributo("TEXT", "numPosiNumeClie", "req", "S");
				asignarAtributo("COMBO", "valFormFech", "req", "S");
				asignarAtributo("COMBO", "valSepaMile", "req", "S");
				asignarAtributo("COMBO", "valSepaDeci", "req", "S");
				asignarAtributo("TEXT", "numPeriEgre", "req", "S");
				asignarAtributo("TEXT", "numPeriReti", "req", "S");
				asignarAtributo("COMBO", "indFletZonaUbig", "req", "S");
				asignarAtributo("RADIOB", "valIndiSecuMoni", "req", "S");
				asignarAtributo("AREATEXTO", "valUrl", "req", "S");
				asignarAtributo("RADIOB", "indImpuIncl", "req", "S");
		
		//Asignamos a los campos internacionalizables la funci�n de onblur para actualizar el valor
		//para el idioma por defecto
		asignarAtributo("TEXT", "Descripcion", "onblur", "setDefaultLanguageValue('Descripcion', get('segPaisFrm.Descripcion'))");
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		Long loidPais = UtilidadesSession.getPais(this);
		userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		
			asignarAtributo("TEXT", "codPais", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 3);");
			asignarAtributo("COMBO", "moneOidMone", "validacion", "VerificaContenidoCmbs('segPaisFrm.moneOidMone','segPaisFrm.moneOidMoneAlt','SegPais','moneOidMone')");
			
			asignarAtributo("TEXT", "Descripcion", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
			
			
			
			asignarAtributo("TEXT", "valProgEjec", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 10);");
			asignarAtributo("TEXT", "valPorcAlar", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'SegPais.valPorcAlar', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
			
			asignarAtributo("TEXT", "numDiasMora", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
			
			asignarAtributo("TEXT", "valTiemRezo", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
			
			asignarAtributo("TEXT", "numDiasFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
			asignarAtributo("TEXT", "numLimiDifePago", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'SegPais.numLimiDifePago', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
			
			asignarAtributo("TEXT", "valMaxiDifeAnlsComb", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'SegPais.valMaxiDifeAnlsComb', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
			asignarAtributo("TEXT", "numPosiNumeClie", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
			
			asignarAtributo("COMBO", "valSepaMile", "validacion", "VerificaContenidoCmbs('segPaisFrm.valSepaMile','segPaisFrm.valSepaDeci','SegPais','valSepaMile')");
			
			asignarAtributo("TEXT", "numPeriEgre", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
			asignarAtributo("TEXT", "numPeriReti", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
			
			asignarAtributo("TEXT", "valCompTele", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
			
			
			
			
			asignarAtributo("AREATEXTO", "valUrl", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 1024)");
			

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando SegPais");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la b�squeda
		SegPaisData segPaisQuery= new SegPaisData();
		segPaisQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		SegPaisData  datosResult = (SegPaisData)getSingleObject(BUSINESSID_QUERY, segPaisQuery, 
			segPaisQuery.clone(), "segPais", false);
		

		//Comprobamos que haya datos. Si no indicamos la situaci�pn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Creamos los campos ocultos para la internacionalizaci�n
		preservaHiddensI18n(new Integer(1), "SEG_PAIS", "segPaisFrm", "Descripcion", false);
		
		
		//Guardamos los valores de los radiobuttons
		if(datosResult.getIndSaldUnic() != null)
			asignar("VAR", "indSaldUnicCheckValue", datosResult.getIndSaldUnic().toString());
		if(datosResult.getIndCompAuto() != null)
			asignar("VAR", "indCompAutoCheckValue", datosResult.getIndCompAuto().toString());
		if(datosResult.getIndTratAcumDesc() != null)
			asignar("VAR", "indTratAcumDescCheckValue", datosResult.getIndTratAcumDesc().toString());
		if(datosResult.getIndEmisVenc() != null)
			asignar("VAR", "indEmisVencCheckValue", datosResult.getIndEmisVenc().toString());
		if(datosResult.getValIndiSecuMoni() != null)
			asignar("VAR", "valIndiSecuMoniCheckValue", datosResult.getValIndiSecuMoni().toString());
		if(datosResult.getIndImpuIncl() != null)
			asignar("VAR", "indImpuInclCheckValue", datosResult.getIndImpuIncl().toString());
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		SegPaisData segPais = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		asignar("TEXT", "codPais", FormatUtils.formatObject(segPais.getCodPais(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.SegMonedData moneOidMone = segPais.getMoneOidMone();
		if(moneOidMone != null && moneOidMone.getId() != null) checkCombo("moneOidMone" , moneOidMone.getId().toString());
		es.indra.belcorp.mso.SegMonedData moneOidMoneAlt = segPais.getMoneOidMoneAlt();
		if(moneOidMoneAlt != null && moneOidMoneAlt.getId() != null) checkCombo("moneOidMoneAlt" , moneOidMoneAlt.getId().toString());
		asignar("TEXT", "Descripcion", FormatUtils.formatObject(segPais.getDescripcion(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(segPais.getIndInteGis() != null){	
			checkCombo("indInteGis", FormatUtils.formatObject(segPais.getIndInteGis(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		if(segPais.getValIden() != null){	
			checkCombo("valIden", FormatUtils.formatObject(segPais.getValIden(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignarAtributo("RADIOB", "indSaldUnic" , "valor", FormatUtils.formatObject(
			segPais.getIndSaldUnic(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valProgEjec", FormatUtils.formatObject(segPais.getValProgEjec(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPorcAlar", FormatUtils.formatObject(segPais.getValPorcAlar(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indCompAuto" , "valor", FormatUtils.formatObject(
			segPais.getIndCompAuto(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numDiasMora", FormatUtils.formatObject(segPais.getNumDiasMora(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indTratAcumDesc" , "valor", FormatUtils.formatObject(
			segPais.getIndTratAcumDesc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valTiemRezo", FormatUtils.formatObject(segPais.getValTiemRezo(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(segPais.getValConfSecuCcc() != null){	
			checkCombo("valConfSecuCcc", FormatUtils.formatObject(segPais.getValConfSecuCcc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignar("TEXT", "numDiasFact", FormatUtils.formatObject(segPais.getNumDiasFact(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numLimiDifePago", FormatUtils.formatObject(segPais.getNumLimiDifePago(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indEmisVenc" , "valor", FormatUtils.formatObject(
			segPais.getIndEmisVenc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valMaxiDifeAnlsComb", FormatUtils.formatObject(segPais.getValMaxiDifeAnlsComb(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numPosiNumeClie", FormatUtils.formatObject(segPais.getNumPosiNumeClie(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(segPais.getValFormFech() != null){	
			checkCombo("valFormFech", FormatUtils.formatObject(segPais.getValFormFech(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		if(segPais.getValSepaMile() != null){	
			checkCombo("valSepaMile", FormatUtils.formatObject(segPais.getValSepaMile(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		if(segPais.getValSepaDeci() != null){	
			checkCombo("valSepaDeci", FormatUtils.formatObject(segPais.getValSepaDeci(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignar("TEXT", "numPeriEgre", FormatUtils.formatObject(segPais.getNumPeriEgre(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numPeriReti", FormatUtils.formatObject(segPais.getNumPeriReti(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.BelFormaPagoTaponData fopaOidFormPago = segPais.getFopaOidFormPago();
		if(fopaOidFormPago != null && fopaOidFormPago.getId() != null) checkCombo("fopaOidFormPago" , fopaOidFormPago.getId().toString());
		asignar("TEXT", "valCompTele", FormatUtils.formatObject(segPais.getValCompTele(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(segPais.getIndFletZonaUbig() != null){	
			checkCombo("indFletZonaUbig", FormatUtils.formatObject(segPais.getIndFletZonaUbig(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignarAtributo("RADIOB", "valIndiSecuMoni" , "valor", FormatUtils.formatObject(
			segPais.getValIndiSecuMoni(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(segPais.getIndSecu() != null){	
			checkCombo("indSecu", FormatUtils.formatObject(segPais.getIndSecu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		if(segPais.getIndBalaAreaCheq() != null){	
			checkCombo("indBalaAreaCheq", FormatUtils.formatObject(segPais.getIndBalaAreaCheq(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignar("AREATEXTO", "valUrl", FormatUtils.formatObject(segPais.getValUrl(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indImpuIncl" , "valor", FormatUtils.formatObject(
			segPais.getIndImpuIncl(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		

		//Sacamos la informaci�n de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la b�squeda
		//	Creamos el dto y metemos la informaci�n necesaria para ejecutar la query
		//	Invocamos la l�gica de negocio
		
				loadLocalizationVars(segPais);
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acci�n
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se est� modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(segPais.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",1, false)");
				asignarAtributo("AREATEXTO", "codPais", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",2, true)");
				asignarAtributo("AREATEXTO", "codPais", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",2, false)");
					asignarAtributo("COMBO","moneOidMone", "ontab", "ejecutarAccionFocoModificacion(\"segPaisFrm\",3, true)");
					asignarAtributo("COMBO","moneOidMone", "onshtab", "ejecutarAccionFocoModificacion(\"segPaisFrm\",3, false)");
					asignarAtributo("COMBO","moneOidMoneAlt", "ontab", "ejecutarAccionFocoModificacion(\"segPaisFrm\",4, true)");
					asignarAtributo("COMBO","moneOidMoneAlt", "onshtab", "ejecutarAccionFocoModificacion(\"segPaisFrm\",4, false)");
				asignarAtributo("AREATEXTO", "Descripcion", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",5, true)");
				asignarAtributo("AREATEXTO", "Descripcion", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",5, false)");
				asignarAtributo("TEXT", "indInteGis", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",6, true)");
				asignarAtributo("TEXT", "indInteGis", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",6, false)");
				asignarAtributo("TEXT", "valIden", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",7, true)");
				asignarAtributo("TEXT", "valIden", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",7, false)");
				asignarAtributo("TEXT", "indSaldUnic", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",8, true)");
				asignarAtributo("TEXT", "indSaldUnic", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",8, false)");
				asignarAtributo("AREATEXTO", "valProgEjec", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",9, true)");
				asignarAtributo("AREATEXTO", "valProgEjec", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",9, false)");
				asignarAtributo("AREATEXTO", "valPorcAlar", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",10, true)");
				asignarAtributo("AREATEXTO", "valPorcAlar", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",10, false)");
				asignarAtributo("TEXT", "indCompAuto", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",11, true)");
				asignarAtributo("TEXT", "indCompAuto", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",11, false)");
				asignarAtributo("AREATEXTO", "numDiasMora", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",12, true)");
				asignarAtributo("AREATEXTO", "numDiasMora", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",12, false)");
				asignarAtributo("TEXT", "indTratAcumDesc", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",13, true)");
				asignarAtributo("TEXT", "indTratAcumDesc", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",13, false)");
				asignarAtributo("AREATEXTO", "valTiemRezo", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",14, true)");
				asignarAtributo("AREATEXTO", "valTiemRezo", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",14, false)");
				asignarAtributo("TEXT", "valConfSecuCcc", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",15, true)");
				asignarAtributo("TEXT", "valConfSecuCcc", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",15, false)");
				asignarAtributo("AREATEXTO", "numDiasFact", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",16, true)");
				asignarAtributo("AREATEXTO", "numDiasFact", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",16, false)");
				asignarAtributo("AREATEXTO", "numLimiDifePago", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",17, true)");
				asignarAtributo("AREATEXTO", "numLimiDifePago", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",17, false)");
				asignarAtributo("TEXT", "indEmisVenc", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",18, true)");
				asignarAtributo("TEXT", "indEmisVenc", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",18, false)");
				asignarAtributo("AREATEXTO", "valMaxiDifeAnlsComb", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",19, true)");
				asignarAtributo("AREATEXTO", "valMaxiDifeAnlsComb", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",19, false)");
				asignarAtributo("AREATEXTO", "numPosiNumeClie", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",20, true)");
				asignarAtributo("AREATEXTO", "numPosiNumeClie", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",20, false)");
				asignarAtributo("TEXT", "valFormFech", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",21, true)");
				asignarAtributo("TEXT", "valFormFech", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",21, false)");
				asignarAtributo("TEXT", "valSepaMile", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",22, true)");
				asignarAtributo("TEXT", "valSepaMile", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",22, false)");
				asignarAtributo("TEXT", "valSepaDeci", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",23, true)");
				asignarAtributo("TEXT", "valSepaDeci", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",23, false)");
				asignarAtributo("AREATEXTO", "numPeriEgre", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",24, true)");
				asignarAtributo("AREATEXTO", "numPeriEgre", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",24, false)");
				asignarAtributo("AREATEXTO", "numPeriReti", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",25, true)");
				asignarAtributo("AREATEXTO", "numPeriReti", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",25, false)");
					asignarAtributo("COMBO","fopaOidFormPago", "ontab", "ejecutarAccionFocoModificacion(\"segPaisFrm\",26, true)");
					asignarAtributo("COMBO","fopaOidFormPago", "onshtab", "ejecutarAccionFocoModificacion(\"segPaisFrm\",26, false)");
				asignarAtributo("AREATEXTO", "valCompTele", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",27, true)");
				asignarAtributo("AREATEXTO", "valCompTele", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",27, false)");
				asignarAtributo("TEXT", "indFletZonaUbig", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",28, true)");
				asignarAtributo("TEXT", "indFletZonaUbig", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",28, false)");
				asignarAtributo("TEXT", "valIndiSecuMoni", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",29, true)");
				asignarAtributo("TEXT", "valIndiSecuMoni", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",29, false)");
				asignarAtributo("TEXT", "indSecu", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",30, true)");
				asignarAtributo("TEXT", "indSecu", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",30, false)");
				asignarAtributo("TEXT", "indBalaAreaCheq", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",31, true)");
				asignarAtributo("TEXT", "indBalaAreaCheq", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",31, false)");
				asignarAtributo("AREATEXTO", "valUrl", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",32, true)");
				asignarAtributo("AREATEXTO", "valUrl", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",32, false)");
				asignarAtributo("TEXT", "indImpuIncl", "ontab","ejecutarAccionFocoModificacion(\"segPaisFrm\",33, true)");
				asignarAtributo("TEXT", "indImpuIncl", "onshtab","ejecutarAccionFocoModificacion(\"segPaisFrm\",33, false)");
	}
	
	/**Nos permite eliminar de la p�gina todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
				borrarNodo("TD","nombre","DescripcionTdLocalizationButtonGap");
				borrarNodo("TD","nombre","DescripcionTdLocalizationButtonGapHeader");
				borrarNodo("TD","nombre","DescripcionTdLocalizationButton");
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","segPaisTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la b�suqeda
		borrarNodo("TR","nombre","segPaisTrButtons");

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
		borrarCampo("moneOidMoneAlt");
		borrarCampo("Descripcion");
		borrarCampo("indInteGis");
		borrarCampo("valIden");
		borrarCampo("indSaldUnic");
		borrarCampo("valProgEjec");
		borrarCampo("valPorcAlar");
		borrarCampo("indCompAuto");
		borrarCampo("numDiasMora");
		borrarCampo("indTratAcumDesc");
		borrarCampo("valTiemRezo");
		borrarCampo("valConfSecuCcc");
		borrarCampo("numDiasFact");
		borrarCampo("numLimiDifePago");
		borrarCampo("indEmisVenc");
		borrarCampo("valMaxiDifeAnlsComb");
		borrarCampo("numPosiNumeClie");
		borrarCampo("valFormFech");
		borrarCampo("valSepaMile");
		borrarCampo("valSepaDeci");
		borrarCampo("numPeriEgre");
		borrarCampo("numPeriReti");
		borrarCampo("fopaOidFormPago");
		borrarCampo("valCompTele");
		borrarCampo("indFletZonaUbig");
		borrarCampo("valIndiSecuMoni");
		borrarCampo("indSecu");
		borrarCampo("indBalaAreaCheq");
		borrarCampo("valUrl");
		borrarCampo("indImpuIncl");
		
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
				
				traza("MMG: el atributo es codPais...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						// borrarCampo("codPais");
						asignarAtributo ("TEXT", "codPais", "disabled", "S");
				traza("MMG: el atributo es moneOidMone...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						asignarAtributo("COMBO", "moneOidMone", "disabled", "S");
				traza("MMG: el atributo es moneOidMoneAlt...");		
				
				traza("MMG: el atributo es Descripcion...");		
				
				traza("MMG: el atributo es indInteGis...");		
				
				traza("MMG: el atributo es valIden...");		
				
				traza("MMG: el atributo es indSaldUnic...");		
				
				traza("MMG: el atributo es valProgEjec...");		
				
				traza("MMG: el atributo es valPorcAlar...");		
				
				traza("MMG: el atributo es indCompAuto...");		
				
				traza("MMG: el atributo es numDiasMora...");		
				
				traza("MMG: el atributo es indTratAcumDesc...");		
				
				traza("MMG: el atributo es valTiemRezo...");		
				
				traza("MMG: el atributo es valConfSecuCcc...");		
				
				traza("MMG: el atributo es numDiasFact...");		
				
				traza("MMG: el atributo es numLimiDifePago...");		
				
				traza("MMG: el atributo es indEmisVenc...");		
				
				traza("MMG: el atributo es valMaxiDifeAnlsComb...");		
				
				traza("MMG: el atributo es numPosiNumeClie...");		
				
				traza("MMG: el atributo es valFormFech...");		
				
				traza("MMG: el atributo es valSepaMile...");		
				
				traza("MMG: el atributo es valSepaDeci...");		
				
				traza("MMG: el atributo es numPeriEgre...");		
				
				traza("MMG: el atributo es numPeriReti...");		
				
				traza("MMG: el atributo es fopaOidFormPago...");		
				
				traza("MMG: el atributo es valCompTele...");		
				
				traza("MMG: el atributo es indFletZonaUbig...");		
				
				traza("MMG: el atributo es valIndiSecuMoni...");		
				
				traza("MMG: el atributo es indSecu...");		
				
				traza("MMG: el atributo es indBalaAreaCheq...");		
				
				traza("MMG: el atributo es valUrl...");		
				
				traza("MMG: el atributo es indImpuIncl...");		
				
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
		asignarAtributo("CAPA","segPaisFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","segPaisListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","segPaisListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarqu�as de dependencia
	*/
	protected void loadLeafDependenceCombos(SegPaisData segPais) throws Exception{
		HashMap checkedCombos = new HashMap();
		SegMonedData moneOidMone = new SegMonedData();
		
						asignarComboResultados(BUSINESSID_MONEOIDMONE_QUERY,MONEOIDMONE_COMBO_CONNECTOR, 
			moneOidMone, moneOidMone.clone(), "segMoned", "moneOidMone", "result_ROWSET",false );
		if(segPais != null && segPais.getMoneOidMone() != null){
				checkCombo("moneOidMone" , segPais.getMoneOidMone().getId().toString());
			}
		SegMonedData moneOidMoneAlt = new SegMonedData();
		
						asignarComboResultados(BUSINESSID_MONEOIDMONEALT_QUERY,MONEOIDMONEALT_COMBO_CONNECTOR, 
			moneOidMoneAlt, moneOidMoneAlt.clone(), "segMoned", "moneOidMoneAlt", "result_ROWSET",false );
		if(segPais != null && segPais.getMoneOidMoneAlt() != null){
				checkCombo("moneOidMoneAlt" , segPais.getMoneOidMoneAlt().getId().toString());
			}
		BelFormaPagoTaponData fopaOidFormPago = new BelFormaPagoTaponData();
		
						asignarComboResultados(BUSINESSID_FOPAOIDFORMPAGO_QUERY,FOPAOIDFORMPAGO_COMBO_CONNECTOR, 
			fopaOidFormPago, fopaOidFormPago.clone(), "belFormaPagoTapon", "fopaOidFormPago", "result_ROWSET",false );
		if(segPais != null && segPais.getFopaOidFormPago() != null){
				checkCombo("fopaOidFormPago" , segPais.getFopaOidFormPago().getId().toString());
			}
		
	}
	
	/**
	* Nos permite cargar en cascada jerarqu�a de combos dependientes por la selecci�n de valor en uno de sus elementos
	*/
	public void cascadeComboLoad(HashMap checkedCombos, String comboName) throws Exception{
		
	}
	
	/**
	* Este m�todo carga todos los combos de una jerarqu�a de dependencia. La carga se realiza c
	* se realiza en funci�n de los datos de un mso del mantenimiento. 
	* @param segPais La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(SegPaisData segPais) 
		throws Exception{
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la �ltima query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la b�squeda
		SegPaisData segPais = 
			(SegPaisData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarqu�a de combos dependientes
		if(segPais.getMoneOidMone() != null){
			segPais.setMoneOidMone((es.indra.belcorp.mso.SegMonedData)
			getSingleObject(BUSINESSID_MONEOIDMONE_QUERY, 
			segPais.getMoneOidMone(),
			segPais.getMoneOidMone().clone(),
			"segMoned"));
		}
		if(segPais.getMoneOidMoneAlt() != null){
			segPais.setMoneOidMoneAlt((es.indra.belcorp.mso.SegMonedData)
			getSingleObject(BUSINESSID_MONEOIDMONEALT_QUERY, 
			segPais.getMoneOidMoneAlt(),
			segPais.getMoneOidMoneAlt().clone(),
			"segMoned"));
		}
		if(segPais.getFopaOidFormPago() != null){
			segPais.setFopaOidFormPago((es.indra.belcorp.mso.BelFormaPagoTaponData)
			getSingleObject(BUSINESSID_FOPAOIDFORMPAGO_QUERY, 
			segPais.getFopaOidFormPago(),
			segPais.getFopaOidFormPago().clone(),
			"belFormaPagoTapon"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarqu�as de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(segPais);
		loadLeafDependenceCombos(segPais);
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
	
	
	protected void loadLocalizationVars(SegPaisData segPais) throws Exception{
		GenDetaSiccData mmgLocalizationQuery = null;
		Vector mmgLocalizationDatosResult = null;
		mmgLocalizationQuery = new GenDetaSiccData();
		mmgLocalizationQuery.setEnti("SEG_PAIS");
		mmgLocalizationQuery.setEntiPk(segPais.getId());
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





