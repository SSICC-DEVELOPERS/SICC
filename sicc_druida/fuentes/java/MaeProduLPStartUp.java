/*
    INDRA/CAR/mmg
    $Id: MaeProduLPStartUp.java,v 1.1 2009/12/03 18:38:15 pecbazalar Exp $
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
public class MaeProduLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 1911;
	public static final short CREATEFORM_SIZE = 1893;
	public static final short UPDATEFORM_SIZE = 1893;
	public static final short VIEWFORM_SIZE = 1893;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGMaeProduQueryFromToUserPage";
	
	
				public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisViewQueryFromToUser";
				public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisViewConectorCombo";
	
				public static final String BUSINESSID_GENEOIDGENE_QUERY ="MMGMaeGenerQueryFromToUser";
				public static final String GENEOIDGENE_COMBO_CONNECTOR = "MaeGenerConectorCombo";
	
				public static final String BUSINESSID_SGENOIDSUPEGENE_QUERY ="MMGMaeSuperGenerQueryFromToUser";
				public static final String SGENOIDSUPEGENE_COMBO_CONNECTOR = "MaeSuperGenerConectorCombo";
	
				public static final String BUSINESSID_UNMDOIDUNIDMEDI_MAGNOIDMAGN_QUERY ="MMGMaeMagniQueryFromToUser";
				public static final String BUSINESSID_UNMDOIDUNIDMEDI_QUERY ="MMGMaeUnidaMedidQueryFromToUser";
				public static final String UNMDOIDUNIDMEDI_MAGNOIDMAGN_COMBO_CONNECTOR = "MaeMagniConectorCombo";
	
				public static final String UNMDOIDUNIDMEDI_COMBO_CONNECTOR = "MaeUnidaMedidConectorCombo";
	
				public static final String BUSINESSID_UNMDOIDUNIDMEDIPESO_MAGNOIDMAGN_QUERY ="MMGMaeMagniQueryFromToUser";
				public static final String BUSINESSID_UNMDOIDUNIDMEDIPESO_QUERY ="MMGMaeUnidaMedidQueryFromToUser";
				public static final String UNMDOIDUNIDMEDIPESO_MAGNOIDMAGN_COMBO_CONNECTOR = "MaeMagniConectorCombo";
	
				public static final String UNMDOIDUNIDMEDIPESO_COMBO_CONNECTOR = "MaeUnidaMedidConectorCombo";
	
				public static final String BUSINESSID_UNMDOIDUNIDMEDIDIME_MAGNOIDMAGN_QUERY ="MMGMaeMagniQueryFromToUser";
				public static final String BUSINESSID_UNMDOIDUNIDMEDIDIME_QUERY ="MMGMaeUnidaMedidQueryFromToUser";
				public static final String UNMDOIDUNIDMEDIDIME_MAGNOIDMAGN_COMBO_CONNECTOR = "MaeMagniConectorCombo";
	
				public static final String UNMDOIDUNIDMEDIDIME_COMBO_CONNECTOR = "MaeUnidaMedidConectorCombo";
	
				public static final String BUSINESSID_NEGOOIDNEGO_QUERY ="MMGMaeNegocQueryFromToUser";
				public static final String NEGOOIDNEGO_COMBO_CONNECTOR = "MaeNegocConectorCombo";
	
				public static final String BUSINESSID_MEUDOIDESTAPROD_QUERY ="MMGMaeEstatProduQueryFromToUser";
				public static final String MEUDOIDESTAPROD_COMBO_CONNECTOR = "MaeEstatProduConectorCombo";
	
				public static final String BUSINESSID_LIPROIDLINEPROD_QUERY ="MMGMaeLineaProduQueryFromToUser";
				public static final String LIPROIDLINEPROD_COMBO_CONNECTOR = "MaeLineaProduConectorCombo";
	
				public static final String BUSINESSID_UNEGOIDUNIDNEGO_QUERY ="MMGMaeUnidaNegocQueryFromToUser";
				public static final String UNEGOIDUNIDNEGO_COMBO_CONNECTOR = "MaeUnidaNegocConectorCombo";
	
				public static final String BUSINESSID_PERDOIDPERIINIC_QUERY ="MMGCraPerioQueryFromToUser";
				public static final String PERDOIDPERIINIC_COMBO_CONNECTOR = "CraPerioConectorCombo";
	
				public static final String BUSINESSID_PERDOIDPERIFIN_QUERY ="MMGCraPerioQueryFromToUser";
				public static final String PERDOIDPERIFIN_COMBO_CONNECTOR = "CraPerioConectorCombo";
	
				public static final String BUSINESSID_FOPAOIDFORMPAGO_QUERY ="MMGBelFormaPagoQueryFromToUser";
				public static final String FOPAOIDFORMPAGO_COMBO_CONNECTOR = "BelFormaPagoConectorCombo";
	
				public static final String BUSINESSID_MAPROIDMARCPROD_QUERY ="MMGSegMarcaProduQueryFromToUser";
				public static final String MAPROIDMARCPROD_COMBO_CONNECTOR = "SegMarcaProduConectorCombo";
	
				public static final String BUSINESSID_PRFIOIDPROGFIDE_QUERY ="MMGMaeProgrFidelQueryFromToUser";
				public static final String PRFIOIDPROGFIDE_COMBO_CONNECTOR = "MaeProgrFidelConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public MaeProduLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("MaeProduPage");
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
			buildJsPageSize("MaeProdu");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "MaeProduPage", "cod", "MaeProdu." + accion + ".label");
			
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
			limpiarBotoneraLista("maeProdu", accion);
			
			
			
			
			
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
		asignarAtributo("TEXT", "valCostEstd", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valCostEstd', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecPosi", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecPosi', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCata", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecCata', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCont", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecCont', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
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
		asignarAtributo("TEXT", "codUnicVent", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 6);");
		
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "maeProduLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "MaeProduPage", "onblur", "window.focus();");
		
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
		conectorAction("MaeProduLPStartUp");
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
		MaeProduData maeProduQuery= new MaeProduData();
		maeProduQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		MaeProduData datosResult = (MaeProduData)getSingleObject(BUSINESSID_QUERY, maeProduQuery, 
			maeProduQuery.clone(), "maeProdu");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		MaeProduData maeProdu = datosResult;
		es.indra.belcorp.mso.SegPaisViewData paisOidPais = maeProdu.getPaisOidPais();
		if(paisOidPais != null && paisOidPais.getId() != null) checkCombo("paisOidPais" , paisOidPais.getId().toString());
		asignar("TEXT", "codSap", FormatUtils.formatObject(maeProdu.getCodSap(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codiAnti", FormatUtils.formatObject(maeProdu.getCodiAnti(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "desCort", FormatUtils.formatObject(maeProdu.getDesCort(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valJera1", FormatUtils.formatObject(maeProdu.getValJera1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valJera2", FormatUtils.formatObject(maeProdu.getValJera2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valJera3", FormatUtils.formatObject(maeProdu.getValJera3(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valAtri1", FormatUtils.formatObject(maeProdu.getValAtri1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valAtri2", FormatUtils.formatObject(maeProdu.getValAtri2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valAtri3", FormatUtils.formatObject(maeProdu.getValAtri3(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDimeAlto", FormatUtils.formatObject(maeProdu.getValDimeAlto(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDimeLarg", FormatUtils.formatObject(maeProdu.getValDimeLarg(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDimeAnch", FormatUtils.formatObject(maeProdu.getValDimeAnch(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPeso", FormatUtils.formatObject(maeProdu.getValPeso(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valVolu", FormatUtils.formatObject(maeProdu.getValVolu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valCostEstd", FormatUtils.formatObject(maeProdu.getValCostEstd(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPrecPosi", FormatUtils.formatObject(maeProdu.getValPrecPosi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPrecCata", FormatUtils.formatObject(maeProdu.getValPrecCata(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPrecCont", FormatUtils.formatObject(maeProdu.getValPrecCont(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numUnidDentPedi", FormatUtils.formatObject(maeProdu.getNumUnidDentPedi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numUnidCaja", FormatUtils.formatObject(maeProdu.getNumUnidCaja(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codImpu", FormatUtils.formatObject(maeProdu.getCodImpu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "pctUnid", FormatUtils.formatObject(maeProdu.getPctUnid(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.MaeGenerData geneOidGene = maeProdu.getGeneOidGene();
		if(geneOidGene != null && geneOidGene.getId() != null) checkCombo("geneOidGene" , geneOidGene.getId().toString());
		es.indra.belcorp.mso.MaeSuperGenerData sgenOidSupeGene = maeProdu.getSgenOidSupeGene();
		if(sgenOidSupeGene != null && sgenOidSupeGene.getId() != null) checkCombo("sgenOidSupeGene" , sgenOidSupeGene.getId().toString());
		es.indra.belcorp.mso.MaeUnidaMedidData unmdOidUnidMedi = maeProdu.getUnmdOidUnidMedi();
		if(unmdOidUnidMedi != null && unmdOidUnidMedi.getId() != null) checkCombo("unmdOidUnidMedi" , unmdOidUnidMedi.getId().toString());
		es.indra.belcorp.mso.MaeUnidaMedidData unmdOidUnidMediPeso = maeProdu.getUnmdOidUnidMediPeso();
		if(unmdOidUnidMediPeso != null && unmdOidUnidMediPeso.getId() != null) checkCombo("unmdOidUnidMediPeso" , unmdOidUnidMediPeso.getId().toString());
		es.indra.belcorp.mso.MaeUnidaMedidData unmdOidUnidMediDime = maeProdu.getUnmdOidUnidMediDime();
		if(unmdOidUnidMediDime != null && unmdOidUnidMediDime.getId() != null) checkCombo("unmdOidUnidMediDime" , unmdOidUnidMediDime.getId().toString());
		es.indra.belcorp.mso.MaeNegocData negoOidNego = maeProdu.getNegoOidNego();
		if(negoOidNego != null && negoOidNego.getId() != null) checkCombo("negoOidNego" , negoOidNego.getId().toString());
		es.indra.belcorp.mso.MaeEstatProduData meudOidEstaProd = maeProdu.getMeudOidEstaProd();
		if(meudOidEstaProd != null && meudOidEstaProd.getId() != null) checkCombo("meudOidEstaProd" , meudOidEstaProd.getId().toString());
		es.indra.belcorp.mso.MaeLineaProduData liprOidLineProd = maeProdu.getLiprOidLineProd();
		if(liprOidLineProd != null && liprOidLineProd.getId() != null) checkCombo("liprOidLineProd" , liprOidLineProd.getId().toString());
		es.indra.belcorp.mso.MaeUnidaNegocData unegOidUnidNego = maeProdu.getUnegOidUnidNego();
		if(unegOidUnidNego != null && unegOidUnidNego.getId() != null) checkCombo("unegOidUnidNego" , unegOidUnidNego.getId().toString());
		es.indra.belcorp.mso.CraPerioData perdOidPeriInic = maeProdu.getPerdOidPeriInic();
		if(perdOidPeriInic != null && perdOidPeriInic.getId() != null) checkCombo("perdOidPeriInic" , perdOidPeriInic.getId().toString());
		es.indra.belcorp.mso.CraPerioData perdOidPeriFin = maeProdu.getPerdOidPeriFin();
		if(perdOidPeriFin != null && perdOidPeriFin.getId() != null) checkCombo("perdOidPeriFin" , perdOidPeriFin.getId().toString());
		asignar("TEXT", "indLote", FormatUtils.formatObject(maeProdu.getIndLote(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indProdServ", FormatUtils.formatObject(maeProdu.getIndProdServ(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codIndSitu", FormatUtils.formatObject(maeProdu.getCodIndSitu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codIndDentCaja", FormatUtils.formatObject(maeProdu.getCodIndDentCaja(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indKit", FormatUtils.formatObject(maeProdu.getIndKit(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.BelFormaPagoData fopaOidFormPago = maeProdu.getFopaOidFormPago();
		if(fopaOidFormPago != null && fopaOidFormPago.getId() != null) checkCombo("fopaOidFormPago" , fopaOidFormPago.getId().toString());
		es.indra.belcorp.mso.SegMarcaProduData maprOidMarcProd = maeProdu.getMaprOidMarcProd();
		if(maprOidMarcProd != null && maprOidMarcProd.getId() != null) checkCombo("maprOidMarcProd" , maprOidMarcProd.getId().toString());
		asignar("TEXT", "valGrupArti", FormatUtils.formatObject(maeProdu.getValGrupArti(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codUnicVent", FormatUtils.formatObject(maeProdu.getCodUnicVent(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.MaeProgrFidelData prfiOidProgFide = maeProdu.getPrfiOidProgFide();
		if(prfiOidProgFide != null && prfiOidProgFide.getId() != null) checkCombo("prfiOidProgFide" , prfiOidProgFide.getId().toString());
		
			
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
		
					asignarAtributo("COMBO", "geneOidGene", "disabled", "S");
					asignarAtributo("COMBO", "sgenOidSupeGene", "disabled", "S");
									asignarAtributo("COMBO", "unmdOidUnidMedi_magnOidMagn", "disabled", "S");

					asignarAtributo("COMBO", "unmdOidUnidMedi", "disabled", "S");
									asignarAtributo("COMBO", "unmdOidUnidMediPeso_magnOidMagn", "disabled", "S");

					asignarAtributo("COMBO", "unmdOidUnidMediPeso", "disabled", "S");
									asignarAtributo("COMBO", "unmdOidUnidMediDime_magnOidMagn", "disabled", "S");

					asignarAtributo("COMBO", "unmdOidUnidMediDime", "disabled", "S");
					asignarAtributo("COMBO", "negoOidNego", "disabled", "S");
					asignarAtributo("COMBO", "meudOidEstaProd", "disabled", "S");
					asignarAtributo("COMBO", "liprOidLineProd", "disabled", "S");
					asignarAtributo("COMBO", "unegOidUnidNego", "disabled", "S");
					asignarAtributo("COMBO", "perdOidPeriInic", "disabled", "S");
					asignarAtributo("COMBO", "perdOidPeriFin", "disabled", "S");asignarAtributo("TEXT", "indLote", "disabled", "S");
		asignarAtributo("TEXT", "indProdServ", "disabled", "S");
		asignarAtributo("TEXT", "codIndSitu", "disabled", "S");
		asignarAtributo("TEXT", "codIndDentCaja", "disabled", "S");
		asignarAtributo("TEXT", "indKit", "disabled", "S");
		
					asignarAtributo("COMBO", "fopaOidFormPago", "disabled", "S");
					asignarAtributo("COMBO", "maprOidMarcProd", "disabled", "S");asignarAtributo("TEXT", "valGrupArti", "disabled", "S");
		asignarAtributo("TEXT", "codUnicVent", "disabled", "S");
		
					asignarAtributo("COMBO", "prfiOidProgFide", "disabled", "S");
		
	
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
		asignarAtributo("TEXT", "valCostEstd", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valCostEstd', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecPosi", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecPosi', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCata", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecCata', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCont", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecCont', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
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
		asignarAtributo("TEXT", "codUnicVent", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 6);");
		
		
		
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
		asignarAtributo("TEXT", "valCostEstd", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valCostEstd', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecPosi", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecPosi', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCata", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecCata', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCont", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecCont', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
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
		asignarAtributo("TEXT", "codUnicVent", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 6);");
		
		
		
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
		asignarAtributo("TEXT", "valCostEstd", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valCostEstd', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecPosi", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecPosi', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCata", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecCata', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCont", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecCont', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
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
		asignarAtributo("TEXT", "codUnicVent", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 6);");
		
		
		
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
		asignarAtributo("TEXT", "valCostEstd", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valCostEstd', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecPosi", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecPosi', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCata", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecCata', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
		asignarAtributo("TEXT", "valPrecCont", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecCont', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
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
		asignarAtributo("TEXT", "codUnicVent", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 6);");
		
		
		
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
		conectorAction("MaeProduLPStartUp");
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
		//asignarAtributo("FORMULARIO", "maeProduFrm", "oculto", "N");

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
			asignarAtributo("TEXT", "valCostEstd", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valCostEstd', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
			asignarAtributo("TEXT", "valPrecPosi", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecPosi', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
			asignarAtributo("TEXT", "valPrecCata", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecCata', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
			asignarAtributo("TEXT", "valPrecCont", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'MaeProdu.valPrecCont', 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
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
			asignarAtributo("TEXT", "codUnicVent", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 6);");
			

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando MaeProdu");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		MaeProduData maeProduQuery= new MaeProduData();
		maeProduQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		MaeProduData  datosResult = (MaeProduData)getSingleObject(BUSINESSID_QUERY, maeProduQuery, 
			maeProduQuery.clone(), "maeProdu");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		MaeProduData maeProdu = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		es.indra.belcorp.mso.SegPaisViewData paisOidPais = maeProdu.getPaisOidPais();
		if(paisOidPais != null && paisOidPais.getId() != null) checkCombo("paisOidPais" , paisOidPais.getId().toString());
		asignar("TEXT", "codSap", FormatUtils.formatObject(maeProdu.getCodSap(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codiAnti", FormatUtils.formatObject(maeProdu.getCodiAnti(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "desCort", FormatUtils.formatObject(maeProdu.getDesCort(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valJera1", FormatUtils.formatObject(maeProdu.getValJera1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valJera2", FormatUtils.formatObject(maeProdu.getValJera2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valJera3", FormatUtils.formatObject(maeProdu.getValJera3(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valAtri1", FormatUtils.formatObject(maeProdu.getValAtri1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valAtri2", FormatUtils.formatObject(maeProdu.getValAtri2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valAtri3", FormatUtils.formatObject(maeProdu.getValAtri3(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDimeAlto", FormatUtils.formatObject(maeProdu.getValDimeAlto(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDimeLarg", FormatUtils.formatObject(maeProdu.getValDimeLarg(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDimeAnch", FormatUtils.formatObject(maeProdu.getValDimeAnch(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPeso", FormatUtils.formatObject(maeProdu.getValPeso(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valVolu", FormatUtils.formatObject(maeProdu.getValVolu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valCostEstd", FormatUtils.formatObject(maeProdu.getValCostEstd(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPrecPosi", FormatUtils.formatObject(maeProdu.getValPrecPosi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPrecCata", FormatUtils.formatObject(maeProdu.getValPrecCata(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPrecCont", FormatUtils.formatObject(maeProdu.getValPrecCont(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numUnidDentPedi", FormatUtils.formatObject(maeProdu.getNumUnidDentPedi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numUnidCaja", FormatUtils.formatObject(maeProdu.getNumUnidCaja(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codImpu", FormatUtils.formatObject(maeProdu.getCodImpu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "pctUnid", FormatUtils.formatObject(maeProdu.getPctUnid(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.MaeGenerData geneOidGene = maeProdu.getGeneOidGene();
		if(geneOidGene != null && geneOidGene.getId() != null) checkCombo("geneOidGene" , geneOidGene.getId().toString());
		es.indra.belcorp.mso.MaeSuperGenerData sgenOidSupeGene = maeProdu.getSgenOidSupeGene();
		if(sgenOidSupeGene != null && sgenOidSupeGene.getId() != null) checkCombo("sgenOidSupeGene" , sgenOidSupeGene.getId().toString());
		es.indra.belcorp.mso.MaeUnidaMedidData unmdOidUnidMedi = maeProdu.getUnmdOidUnidMedi();
		if(unmdOidUnidMedi != null && unmdOidUnidMedi.getId() != null) checkCombo("unmdOidUnidMedi" , unmdOidUnidMedi.getId().toString());
		es.indra.belcorp.mso.MaeUnidaMedidData unmdOidUnidMediPeso = maeProdu.getUnmdOidUnidMediPeso();
		if(unmdOidUnidMediPeso != null && unmdOidUnidMediPeso.getId() != null) checkCombo("unmdOidUnidMediPeso" , unmdOidUnidMediPeso.getId().toString());
		es.indra.belcorp.mso.MaeUnidaMedidData unmdOidUnidMediDime = maeProdu.getUnmdOidUnidMediDime();
		if(unmdOidUnidMediDime != null && unmdOidUnidMediDime.getId() != null) checkCombo("unmdOidUnidMediDime" , unmdOidUnidMediDime.getId().toString());
		es.indra.belcorp.mso.MaeNegocData negoOidNego = maeProdu.getNegoOidNego();
		if(negoOidNego != null && negoOidNego.getId() != null) checkCombo("negoOidNego" , negoOidNego.getId().toString());
		es.indra.belcorp.mso.MaeEstatProduData meudOidEstaProd = maeProdu.getMeudOidEstaProd();
		if(meudOidEstaProd != null && meudOidEstaProd.getId() != null) checkCombo("meudOidEstaProd" , meudOidEstaProd.getId().toString());
		es.indra.belcorp.mso.MaeLineaProduData liprOidLineProd = maeProdu.getLiprOidLineProd();
		if(liprOidLineProd != null && liprOidLineProd.getId() != null) checkCombo("liprOidLineProd" , liprOidLineProd.getId().toString());
		es.indra.belcorp.mso.MaeUnidaNegocData unegOidUnidNego = maeProdu.getUnegOidUnidNego();
		if(unegOidUnidNego != null && unegOidUnidNego.getId() != null) checkCombo("unegOidUnidNego" , unegOidUnidNego.getId().toString());
		es.indra.belcorp.mso.CraPerioData perdOidPeriInic = maeProdu.getPerdOidPeriInic();
		if(perdOidPeriInic != null && perdOidPeriInic.getId() != null) checkCombo("perdOidPeriInic" , perdOidPeriInic.getId().toString());
		es.indra.belcorp.mso.CraPerioData perdOidPeriFin = maeProdu.getPerdOidPeriFin();
		if(perdOidPeriFin != null && perdOidPeriFin.getId() != null) checkCombo("perdOidPeriFin" , perdOidPeriFin.getId().toString());
		asignar("TEXT", "indLote", FormatUtils.formatObject(maeProdu.getIndLote(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indProdServ", FormatUtils.formatObject(maeProdu.getIndProdServ(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codIndSitu", FormatUtils.formatObject(maeProdu.getCodIndSitu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codIndDentCaja", FormatUtils.formatObject(maeProdu.getCodIndDentCaja(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indKit", FormatUtils.formatObject(maeProdu.getIndKit(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.BelFormaPagoData fopaOidFormPago = maeProdu.getFopaOidFormPago();
		if(fopaOidFormPago != null && fopaOidFormPago.getId() != null) checkCombo("fopaOidFormPago" , fopaOidFormPago.getId().toString());
		es.indra.belcorp.mso.SegMarcaProduData maprOidMarcProd = maeProdu.getMaprOidMarcProd();
		if(maprOidMarcProd != null && maprOidMarcProd.getId() != null) checkCombo("maprOidMarcProd" , maprOidMarcProd.getId().toString());
		asignar("TEXT", "valGrupArti", FormatUtils.formatObject(maeProdu.getValGrupArti(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codUnicVent", FormatUtils.formatObject(maeProdu.getCodUnicVent(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.MaeProgrFidelData prfiOidProgFide = maeProdu.getPrfiOidProgFide();
		if(prfiOidProgFide != null && prfiOidProgFide.getId() != null) checkCombo("prfiOidProgFide" , prfiOidProgFide.getId().toString());
		

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(maeProdu.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","paisOidPais", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","paisOidPais", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "codSap", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "codSap", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "codiAnti", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "codiAnti", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "desCort", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "desCort", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valJera1", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valJera1", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valJera2", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valJera2", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valJera3", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valJera3", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valAtri1", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valAtri1", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valAtri2", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valAtri2", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valAtri3", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valAtri3", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valDimeAlto", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valDimeAlto", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valDimeLarg", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valDimeLarg", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valDimeAnch", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valDimeAnch", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valPeso", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valPeso", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valVolu", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valVolu", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valCostEstd", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valCostEstd", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valPrecPosi", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valPrecPosi", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valPrecCata", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valPrecCata", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valPrecCont", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valPrecCont", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "numUnidDentPedi", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "numUnidDentPedi", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "numUnidCaja", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "numUnidCaja", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "codImpu", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "codImpu", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "pctUnid", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "pctUnid", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","geneOidGene", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","geneOidGene", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","sgenOidSupeGene", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","sgenOidSupeGene", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","unmdOidUnidMedi_magnOidMagn", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","unmdOidUnidMedi_magnOidMagn", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","unmdOidUnidMedi", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","unmdOidUnidMedi", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","unmdOidUnidMediPeso_magnOidMagn", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","unmdOidUnidMediPeso_magnOidMagn", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","unmdOidUnidMediPeso", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","unmdOidUnidMediPeso", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","unmdOidUnidMediDime_magnOidMagn", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","unmdOidUnidMediDime_magnOidMagn", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","unmdOidUnidMediDime", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","unmdOidUnidMediDime", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","negoOidNego", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","negoOidNego", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","meudOidEstaProd", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","meudOidEstaProd", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","liprOidLineProd", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","liprOidLineProd", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","unegOidUnidNego", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","unegOidUnidNego", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","perdOidPeriInic", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","perdOidPeriInic", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","perdOidPeriFin", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","perdOidPeriFin", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "indLote", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "indLote", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "indProdServ", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "indProdServ", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "codIndSitu", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "codIndSitu", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "codIndDentCaja", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "codIndDentCaja", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "indKit", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "indKit", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","fopaOidFormPago", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","fopaOidFormPago", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","maprOidMarcProd", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","maprOidMarcProd", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valGrupArti", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valGrupArti", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
				asignarAtributo("AREATEXTO", "codUnicVent", "ontab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
				asignarAtributo("AREATEXTO", "codUnicVent", "onshtab","ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
					asignarAtributo("COMBO","prfiOidProgFide", "ontab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, true)");
					asignarAtributo("COMBO","prfiOidProgFide", "onshtab", "ejecutarAccionFocoModificacion(\"maeProduFrm\",0, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","maeProduTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","maeProduTrButtons");

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
				
				traza("MMG: el atributo es geneOidGene...");		
				
				traza("MMG: el atributo es sgenOidSupeGene...");		
				
				traza("MMG: el atributo es unmdOidUnidMedi...");		
				
				traza("MMG: el atributo es unmdOidUnidMediPeso...");		
				
				traza("MMG: el atributo es unmdOidUnidMediDime...");		
				
				traza("MMG: el atributo es negoOidNego...");		
				
				traza("MMG: el atributo es meudOidEstaProd...");		
				
				traza("MMG: el atributo es liprOidLineProd...");		
				
				traza("MMG: el atributo es unegOidUnidNego...");		
				
				traza("MMG: el atributo es perdOidPeriInic...");		
				
				traza("MMG: el atributo es perdOidPeriFin...");		
				
				traza("MMG: el atributo es indLote...");		
				
				traza("MMG: el atributo es indProdServ...");		
				
				traza("MMG: el atributo es codIndSitu...");		
				
				traza("MMG: el atributo es codIndDentCaja...");		
				
				traza("MMG: el atributo es indKit...");		
				
				traza("MMG: el atributo es fopaOidFormPago...");		
				
				traza("MMG: el atributo es maprOidMarcProd...");		
				
				traza("MMG: el atributo es valGrupArti...");		
				
				traza("MMG: el atributo es codUnicVent...");		
				
				traza("MMG: el atributo es prfiOidProgFide...");		
				
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
		asignarAtributo("CAPA","maeProduFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","maeProduListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","maeProduListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(MaeProduData maeProdu) throws Exception{
		HashMap checkedCombos = new HashMap();
		SegPaisViewData paisOidPais = new SegPaisViewData();
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, 
			paisOidPais, paisOidPais.clone(), "segPaisView", "paisOidPais", "result_ROWSET" );
		if(maeProdu != null && maeProdu.getPaisOidPais() != null){
				checkCombo("paisOidPais" , maeProdu.getPaisOidPais().getId().toString());
			}
		String paisOidPaisDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPaisView");
		if(paisOidPaisDefaultValue != null && !paisOidPaisDefaultValue.trim().equals("")){
			checkCombo("paisOidPais", paisOidPaisDefaultValue);
			checkedCombos.put("paisOidPais",paisOidPaisDefaultValue);
			cascadeComboLoad(checkedCombos, "paisOidPais");
		}						 
		MaeGenerData geneOidGene = new MaeGenerData();
		
						asignarComboResultados(BUSINESSID_GENEOIDGENE_QUERY,GENEOIDGENE_COMBO_CONNECTOR, 
			geneOidGene, geneOidGene.clone(), "maeGener", "geneOidGene", "result_ROWSET" );
		if(maeProdu != null && maeProdu.getGeneOidGene() != null){
				checkCombo("geneOidGene" , maeProdu.getGeneOidGene().getId().toString());
			}
		MaeSuperGenerData sgenOidSupeGene = new MaeSuperGenerData();
		
						asignarComboResultados(BUSINESSID_SGENOIDSUPEGENE_QUERY,SGENOIDSUPEGENE_COMBO_CONNECTOR, 
			sgenOidSupeGene, sgenOidSupeGene.clone(), "maeSuperGener", "sgenOidSupeGene", "result_ROWSET" );
		if(maeProdu != null && maeProdu.getSgenOidSupeGene() != null){
				checkCombo("sgenOidSupeGene" , maeProdu.getSgenOidSupeGene().getId().toString());
			}
		MaeMagniData unmdOidUnidMedi_magnOidMagn = new MaeMagniData();
		
						asignarComboResultados(BUSINESSID_UNMDOIDUNIDMEDI_MAGNOIDMAGN_QUERY,UNMDOIDUNIDMEDI_MAGNOIDMAGN_COMBO_CONNECTOR, 
			unmdOidUnidMedi_magnOidMagn, unmdOidUnidMedi_magnOidMagn.clone(), "maeMagni", "unmdOidUnidMedi_magnOidMagn", "result_ROWSET" );
		if(maeProdu != null && maeProdu.getUnmdOidUnidMedi().getMagnOidMagn() != null){
				checkCombo("unmdOidUnidMedi_magnOidMagn" , maeProdu.getUnmdOidUnidMedi().getMagnOidMagn().getId().toString());
			}
		MaeMagniData unmdOidUnidMediPeso_magnOidMagn = new MaeMagniData();
		
						asignarComboResultados(BUSINESSID_UNMDOIDUNIDMEDIPESO_MAGNOIDMAGN_QUERY,UNMDOIDUNIDMEDIPESO_MAGNOIDMAGN_COMBO_CONNECTOR, 
			unmdOidUnidMediPeso_magnOidMagn, unmdOidUnidMediPeso_magnOidMagn.clone(), "maeMagni", "unmdOidUnidMediPeso_magnOidMagn", "result_ROWSET" );
		if(maeProdu != null && maeProdu.getUnmdOidUnidMediPeso().getMagnOidMagn() != null){
				checkCombo("unmdOidUnidMediPeso_magnOidMagn" , maeProdu.getUnmdOidUnidMediPeso().getMagnOidMagn().getId().toString());
			}
		MaeMagniData unmdOidUnidMediDime_magnOidMagn = new MaeMagniData();
		
						asignarComboResultados(BUSINESSID_UNMDOIDUNIDMEDIDIME_MAGNOIDMAGN_QUERY,UNMDOIDUNIDMEDIDIME_MAGNOIDMAGN_COMBO_CONNECTOR, 
			unmdOidUnidMediDime_magnOidMagn, unmdOidUnidMediDime_magnOidMagn.clone(), "maeMagni", "unmdOidUnidMediDime_magnOidMagn", "result_ROWSET" );
		if(maeProdu != null && maeProdu.getUnmdOidUnidMediDime().getMagnOidMagn() != null){
				checkCombo("unmdOidUnidMediDime_magnOidMagn" , maeProdu.getUnmdOidUnidMediDime().getMagnOidMagn().getId().toString());
			}
		MaeNegocData negoOidNego = new MaeNegocData();
		
						asignarComboResultados(BUSINESSID_NEGOOIDNEGO_QUERY,NEGOOIDNEGO_COMBO_CONNECTOR, 
			negoOidNego, negoOidNego.clone(), "maeNegoc", "negoOidNego", "result_ROWSET" );
		if(maeProdu != null && maeProdu.getNegoOidNego() != null){
				checkCombo("negoOidNego" , maeProdu.getNegoOidNego().getId().toString());
			}
		MaeEstatProduData meudOidEstaProd = new MaeEstatProduData();
		
						asignarComboResultados(BUSINESSID_MEUDOIDESTAPROD_QUERY,MEUDOIDESTAPROD_COMBO_CONNECTOR, 
			meudOidEstaProd, meudOidEstaProd.clone(), "maeEstatProdu", "meudOidEstaProd", "result_ROWSET" );
		if(maeProdu != null && maeProdu.getMeudOidEstaProd() != null){
				checkCombo("meudOidEstaProd" , maeProdu.getMeudOidEstaProd().getId().toString());
			}
		MaeLineaProduData liprOidLineProd = new MaeLineaProduData();
		
						asignarComboResultados(BUSINESSID_LIPROIDLINEPROD_QUERY,LIPROIDLINEPROD_COMBO_CONNECTOR, 
			liprOidLineProd, liprOidLineProd.clone(), "maeLineaProdu", "liprOidLineProd", "result_ROWSET" );
		if(maeProdu != null && maeProdu.getLiprOidLineProd() != null){
				checkCombo("liprOidLineProd" , maeProdu.getLiprOidLineProd().getId().toString());
			}
		MaeUnidaNegocData unegOidUnidNego = new MaeUnidaNegocData();
		
						asignarComboResultados(BUSINESSID_UNEGOIDUNIDNEGO_QUERY,UNEGOIDUNIDNEGO_COMBO_CONNECTOR, 
			unegOidUnidNego, unegOidUnidNego.clone(), "maeUnidaNegoc", "unegOidUnidNego", "result_ROWSET" );
		if(maeProdu != null && maeProdu.getUnegOidUnidNego() != null){
				checkCombo("unegOidUnidNego" , maeProdu.getUnegOidUnidNego().getId().toString());
			}
		CraPerioData perdOidPeriInic = new CraPerioData();
		
						asignarComboResultados(BUSINESSID_PERDOIDPERIINIC_QUERY,PERDOIDPERIINIC_COMBO_CONNECTOR, 
			perdOidPeriInic, perdOidPeriInic.clone(), "craPerio", "perdOidPeriInic", "result_ROWSET" );
		if(maeProdu != null && maeProdu.getPerdOidPeriInic() != null){
				checkCombo("perdOidPeriInic" , maeProdu.getPerdOidPeriInic().getId().toString());
			}
		CraPerioData perdOidPeriFin = new CraPerioData();
		
						asignarComboResultados(BUSINESSID_PERDOIDPERIFIN_QUERY,PERDOIDPERIFIN_COMBO_CONNECTOR, 
			perdOidPeriFin, perdOidPeriFin.clone(), "craPerio", "perdOidPeriFin", "result_ROWSET" );
		if(maeProdu != null && maeProdu.getPerdOidPeriFin() != null){
				checkCombo("perdOidPeriFin" , maeProdu.getPerdOidPeriFin().getId().toString());
			}
		BelFormaPagoData fopaOidFormPago = new BelFormaPagoData();
		
						asignarComboResultados(BUSINESSID_FOPAOIDFORMPAGO_QUERY,FOPAOIDFORMPAGO_COMBO_CONNECTOR, 
			fopaOidFormPago, fopaOidFormPago.clone(), "belFormaPago", "fopaOidFormPago", "result_ROWSET" );
		if(maeProdu != null && maeProdu.getFopaOidFormPago() != null){
				checkCombo("fopaOidFormPago" , maeProdu.getFopaOidFormPago().getId().toString());
			}
		SegMarcaProduData maprOidMarcProd = new SegMarcaProduData();
		
						asignarComboResultados(BUSINESSID_MAPROIDMARCPROD_QUERY,MAPROIDMARCPROD_COMBO_CONNECTOR, 
			maprOidMarcProd, maprOidMarcProd.clone(), "segMarcaProdu", "maprOidMarcProd", "result_ROWSET" );
		if(maeProdu != null && maeProdu.getMaprOidMarcProd() != null){
				checkCombo("maprOidMarcProd" , maeProdu.getMaprOidMarcProd().getId().toString());
			}
		MaeProgrFidelData prfiOidProgFide = new MaeProgrFidelData();
		
						asignarComboResultados(BUSINESSID_PRFIOIDPROGFIDE_QUERY,PRFIOIDPROGFIDE_COMBO_CONNECTOR, 
			prfiOidProgFide, prfiOidProgFide.clone(), "maeProgrFidel", "prfiOidProgFide", "result_ROWSET" );
		if(maeProdu != null && maeProdu.getPrfiOidProgFide() != null){
				checkCombo("prfiOidProgFide" , maeProdu.getPrfiOidProgFide().getId().toString());
			}
		
	}
	
	/**
	* Nos permite cargar en cascada jerarquía de combos dependientes por la selección de valor en uno de sus elementos
	*/
	public void cascadeComboLoad(HashMap checkedCombos, String comboName) throws Exception{
		
						if(comboName.trim().equals("unmdOidUnidMedi_magnOidMagn") ){
			String unmdOidUnidMedi_magnOidMagnDefaultValue = (String)checkedCombos.get("unmdOidUnidMedi_magnOidMagn");
			if(unmdOidUnidMedi_magnOidMagnDefaultValue != null){
				MaeUnidaMedidData unmdOidUnidMedi= new MaeUnidaMedidData();
				es.indra.belcorp.mso.MaeMagniData unmdOidUnidMediMagnOidMagn = new es.indra.belcorp.mso.MaeMagniData();
				unmdOidUnidMediMagnOidMagn.setId(new Long(unmdOidUnidMedi_magnOidMagnDefaultValue ));
				unmdOidUnidMedi.setMagnOidMagn(unmdOidUnidMediMagnOidMagn);
				asignarComboResultados(BUSINESSID_UNMDOIDUNIDMEDI_QUERY,UNMDOIDUNIDMEDI_COMBO_CONNECTOR, 
					unmdOidUnidMedi, unmdOidUnidMedi.clone(), "maeUnidaMedid", "unmdOidUnidMedi", "result_ROWSET",false );
			}
		}

						if(comboName.trim().equals("unmdOidUnidMediPeso_magnOidMagn") ){
			String unmdOidUnidMediPeso_magnOidMagnDefaultValue = (String)checkedCombos.get("unmdOidUnidMediPeso_magnOidMagn");
			if(unmdOidUnidMediPeso_magnOidMagnDefaultValue != null){
				MaeUnidaMedidData unmdOidUnidMediPeso= new MaeUnidaMedidData();
				es.indra.belcorp.mso.MaeMagniData unmdOidUnidMediPesoMagnOidMagn = new es.indra.belcorp.mso.MaeMagniData();
				unmdOidUnidMediPesoMagnOidMagn.setId(new Long(unmdOidUnidMediPeso_magnOidMagnDefaultValue ));
				unmdOidUnidMediPeso.setMagnOidMagn(unmdOidUnidMediPesoMagnOidMagn);
				asignarComboResultados(BUSINESSID_UNMDOIDUNIDMEDIPESO_QUERY,UNMDOIDUNIDMEDIPESO_COMBO_CONNECTOR, 
					unmdOidUnidMediPeso, unmdOidUnidMediPeso.clone(), "maeUnidaMedid", "unmdOidUnidMediPeso", "result_ROWSET",false );
			}
		}

						if(comboName.trim().equals("unmdOidUnidMediDime_magnOidMagn") ){
			String unmdOidUnidMediDime_magnOidMagnDefaultValue = (String)checkedCombos.get("unmdOidUnidMediDime_magnOidMagn");
			if(unmdOidUnidMediDime_magnOidMagnDefaultValue != null){
				MaeUnidaMedidData unmdOidUnidMediDime= new MaeUnidaMedidData();
				es.indra.belcorp.mso.MaeMagniData unmdOidUnidMediDimeMagnOidMagn = new es.indra.belcorp.mso.MaeMagniData();
				unmdOidUnidMediDimeMagnOidMagn.setId(new Long(unmdOidUnidMediDime_magnOidMagnDefaultValue ));
				unmdOidUnidMediDime.setMagnOidMagn(unmdOidUnidMediDimeMagnOidMagn);
				asignarComboResultados(BUSINESSID_UNMDOIDUNIDMEDIDIME_QUERY,UNMDOIDUNIDMEDIDIME_COMBO_CONNECTOR, 
					unmdOidUnidMediDime, unmdOidUnidMediDime.clone(), "maeUnidaMedid", "unmdOidUnidMediDime", "result_ROWSET",false );
			}
		}

	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param maeProdu La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(MaeProduData maeProdu) 
		throws Exception{
		
						if(maeProdu.getUnmdOidUnidMedi() != null){
			
						MaeUnidaMedidData unmdOidUnidMedi = new MaeUnidaMedidData();
			unmdOidUnidMedi.setMagnOidMagn(maeProdu.getUnmdOidUnidMedi().getMagnOidMagn());
			asignarComboResultados(BUSINESSID_UNMDOIDUNIDMEDI_QUERY,UNMDOIDUNIDMEDI_COMBO_CONNECTOR, unmdOidUnidMedi, unmdOidUnidMedi.clone(), "maeUnidaMedid", "unmdOidUnidMedi", "result_ROWSET");
			checkCombo("unmdOidUnidMedi" , maeProdu.getUnmdOidUnidMedi().getId().toString());
			
						}
		
						if(maeProdu.getUnmdOidUnidMediPeso() != null){
			
						MaeUnidaMedidData unmdOidUnidMediPeso = new MaeUnidaMedidData();
			unmdOidUnidMediPeso.setMagnOidMagn(maeProdu.getUnmdOidUnidMediPeso().getMagnOidMagn());
			asignarComboResultados(BUSINESSID_UNMDOIDUNIDMEDIPESO_QUERY,UNMDOIDUNIDMEDIPESO_COMBO_CONNECTOR, unmdOidUnidMediPeso, unmdOidUnidMediPeso.clone(), "maeUnidaMedid", "unmdOidUnidMediPeso", "result_ROWSET");
			checkCombo("unmdOidUnidMediPeso" , maeProdu.getUnmdOidUnidMediPeso().getId().toString());
			
						}
		
						if(maeProdu.getUnmdOidUnidMediDime() != null){
			
						MaeUnidaMedidData unmdOidUnidMediDime = new MaeUnidaMedidData();
			unmdOidUnidMediDime.setMagnOidMagn(maeProdu.getUnmdOidUnidMediDime().getMagnOidMagn());
			asignarComboResultados(BUSINESSID_UNMDOIDUNIDMEDIDIME_QUERY,UNMDOIDUNIDMEDIDIME_COMBO_CONNECTOR, unmdOidUnidMediDime, unmdOidUnidMediDime.clone(), "maeUnidaMedid", "unmdOidUnidMediDime", "result_ROWSET");
			checkCombo("unmdOidUnidMediDime" , maeProdu.getUnmdOidUnidMediDime().getId().toString());
			
						}
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		MaeProduData maeProdu = 
			(MaeProduData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(maeProdu.getPaisOidPais() != null){
			maeProdu.setPaisOidPais((es.indra.belcorp.mso.SegPaisViewData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			maeProdu.getPaisOidPais(),
			maeProdu.getPaisOidPais().clone(),
			"segPaisView"));
		}
		if(maeProdu.getGeneOidGene() != null){
			maeProdu.setGeneOidGene((es.indra.belcorp.mso.MaeGenerData)
			getSingleObject(BUSINESSID_GENEOIDGENE_QUERY, 
			maeProdu.getGeneOidGene(),
			maeProdu.getGeneOidGene().clone(),
			"maeGener"));
		}
		if(maeProdu.getSgenOidSupeGene() != null){
			maeProdu.setSgenOidSupeGene((es.indra.belcorp.mso.MaeSuperGenerData)
			getSingleObject(BUSINESSID_SGENOIDSUPEGENE_QUERY, 
			maeProdu.getSgenOidSupeGene(),
			maeProdu.getSgenOidSupeGene().clone(),
			"maeSuperGener"));
		}
		if(maeProdu.getUnmdOidUnidMedi() != null){
			maeProdu.setUnmdOidUnidMedi((es.indra.belcorp.mso.MaeUnidaMedidData)
			getSingleObject(BUSINESSID_UNMDOIDUNIDMEDI_QUERY, 
			maeProdu.getUnmdOidUnidMedi(),
			maeProdu.getUnmdOidUnidMedi().clone(),
			"maeUnidaMedid"));
		}
		if(maeProdu.getUnmdOidUnidMediPeso() != null){
			maeProdu.setUnmdOidUnidMediPeso((es.indra.belcorp.mso.MaeUnidaMedidData)
			getSingleObject(BUSINESSID_UNMDOIDUNIDMEDIPESO_QUERY, 
			maeProdu.getUnmdOidUnidMediPeso(),
			maeProdu.getUnmdOidUnidMediPeso().clone(),
			"maeUnidaMedid"));
		}
		if(maeProdu.getUnmdOidUnidMediDime() != null){
			maeProdu.setUnmdOidUnidMediDime((es.indra.belcorp.mso.MaeUnidaMedidData)
			getSingleObject(BUSINESSID_UNMDOIDUNIDMEDIDIME_QUERY, 
			maeProdu.getUnmdOidUnidMediDime(),
			maeProdu.getUnmdOidUnidMediDime().clone(),
			"maeUnidaMedid"));
		}
		if(maeProdu.getNegoOidNego() != null){
			maeProdu.setNegoOidNego((es.indra.belcorp.mso.MaeNegocData)
			getSingleObject(BUSINESSID_NEGOOIDNEGO_QUERY, 
			maeProdu.getNegoOidNego(),
			maeProdu.getNegoOidNego().clone(),
			"maeNegoc"));
		}
		if(maeProdu.getMeudOidEstaProd() != null){
			maeProdu.setMeudOidEstaProd((es.indra.belcorp.mso.MaeEstatProduData)
			getSingleObject(BUSINESSID_MEUDOIDESTAPROD_QUERY, 
			maeProdu.getMeudOidEstaProd(),
			maeProdu.getMeudOidEstaProd().clone(),
			"maeEstatProdu"));
		}
		if(maeProdu.getLiprOidLineProd() != null){
			maeProdu.setLiprOidLineProd((es.indra.belcorp.mso.MaeLineaProduData)
			getSingleObject(BUSINESSID_LIPROIDLINEPROD_QUERY, 
			maeProdu.getLiprOidLineProd(),
			maeProdu.getLiprOidLineProd().clone(),
			"maeLineaProdu"));
		}
		if(maeProdu.getUnegOidUnidNego() != null){
			maeProdu.setUnegOidUnidNego((es.indra.belcorp.mso.MaeUnidaNegocData)
			getSingleObject(BUSINESSID_UNEGOIDUNIDNEGO_QUERY, 
			maeProdu.getUnegOidUnidNego(),
			maeProdu.getUnegOidUnidNego().clone(),
			"maeUnidaNegoc"));
		}
		if(maeProdu.getPerdOidPeriInic() != null){
			maeProdu.setPerdOidPeriInic((es.indra.belcorp.mso.CraPerioData)
			getSingleObject(BUSINESSID_PERDOIDPERIINIC_QUERY, 
			maeProdu.getPerdOidPeriInic(),
			maeProdu.getPerdOidPeriInic().clone(),
			"craPerio"));
		}
		if(maeProdu.getPerdOidPeriFin() != null){
			maeProdu.setPerdOidPeriFin((es.indra.belcorp.mso.CraPerioData)
			getSingleObject(BUSINESSID_PERDOIDPERIFIN_QUERY, 
			maeProdu.getPerdOidPeriFin(),
			maeProdu.getPerdOidPeriFin().clone(),
			"craPerio"));
		}
		if(maeProdu.getFopaOidFormPago() != null){
			maeProdu.setFopaOidFormPago((es.indra.belcorp.mso.BelFormaPagoData)
			getSingleObject(BUSINESSID_FOPAOIDFORMPAGO_QUERY, 
			maeProdu.getFopaOidFormPago(),
			maeProdu.getFopaOidFormPago().clone(),
			"belFormaPago"));
		}
		if(maeProdu.getMaprOidMarcProd() != null){
			maeProdu.setMaprOidMarcProd((es.indra.belcorp.mso.SegMarcaProduData)
			getSingleObject(BUSINESSID_MAPROIDMARCPROD_QUERY, 
			maeProdu.getMaprOidMarcProd(),
			maeProdu.getMaprOidMarcProd().clone(),
			"segMarcaProdu"));
		}
		if(maeProdu.getPrfiOidProgFide() != null){
			maeProdu.setPrfiOidProgFide((es.indra.belcorp.mso.MaeProgrFidelData)
			getSingleObject(BUSINESSID_PRFIOIDPROGFIDE_QUERY, 
			maeProdu.getPrfiOidProgFide(),
			maeProdu.getPrfiOidProgFide().clone(),
			"maeProgrFidel"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(maeProdu);
		loadLeafDependenceCombos(maeProdu);
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





