

/*
    INDRA/CAR/mmg
    $Id: CarParamGenerCarteLPExecution.java,v 1.1 2009/12/03 18:36:45 pecbazalar Exp $
    DESC
*/

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.druida.belcorp.MMGDruidaBase;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.druida.belcorp.MMGException;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.i18n.Idioma;
import es.indra.utils.FormatUtils;
import java.util.HashMap;
import java.text.DecimalFormatSymbols;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.belcorp.mso.*;

public class CarParamGenerCarteLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCarParamGenerCarteCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCarParamGenerCarteUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCarParamGenerCarteRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCarParamGenerCarteQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CarParamGenerCarteConectorCreate";
	public static final String CONECTOR_UPDATE = "CarParamGenerCarteConectorUpdate";
	public static final String CONECTOR_REMOVE = "CarParamGenerCarteConectorRemove";

	public CarParamGenerCarteLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CarParamGenerCartePage");
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		//Activamos las trazas
		setTrazaFichero();
	
		try{
			//Sacamos la acción a realizar y ejecutamos la acción correspondiente
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			
			//Caragamos los elemetnos en la pagina
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
	
			//Ejecutamos la acción indicada
			if(accion.equals(ACCION_CREATE)) cmdCreate();
			if(accion.equals(ACCION_UPDATE)) cmdUpdate();
			if(accion.equals(ACCION_REMOVE)) cmdRemove();
		}catch(Exception e){
			handleException(e);
		}
  }
  
  /**Permite crear un nuevo elemento de la entidad. Invoca la lógica de negocio
  	correspondiente a la creación de un/a nuevo CarParamGenerCarte*/  
	protected void cmdCreate() throws Exception{
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		traza("datePattern" + datePattern);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator.charAt(0));
		symbols.setGroupingSeparator(separadorMiles.charAt(0));	
		
		traza("MMG::Creando CarParamGenerCarte");
		
		String nireOidNiveRedo = conectorParametro("nireOidNiveRedo").trim();
		traza("MMG:: Valor de atributo nireOidNiveRedo: " + nireOidNiveRedo);
		
		String numPeriNuev = conectorParametro("numPeriNuev").trim();
		traza("MMG:: Valor de atributo numPeriNuev: " + numPeriNuev);
		
		String numPeriAnti = conectorParametro("numPeriAnti").trim();
		traza("MMG:: Valor de atributo numPeriAnti: " + numPeriAnti);
		
		String inijOidIndiNiveJera = conectorParametro("inijOidIndiNiveJera").trim();
		traza("MMG:: Valor de atributo inijOidIndiNiveJera: " + inijOidIndiNiveJera);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CarParamGenerCarteData carParamGenerCarte= new CarParamGenerCarteData();
		es.indra.belcorp.mso.CarNivelRedonData nireOidNiveRedoData = null;
		if(nireOidNiveRedo != null && !nireOidNiveRedo.trim().equals("")){
			nireOidNiveRedoData = new es.indra.belcorp.mso.CarNivelRedonData();
			nireOidNiveRedoData.setId(new Long(nireOidNiveRedo));
		}
		carParamGenerCarte.setNireOidNiveRedo(nireOidNiveRedoData);
		carParamGenerCarte.setNumPeriNuev(
			(java.lang.Long)FormatUtils.parseObject(numPeriNuev, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		carParamGenerCarte.setNumPeriAnti(
			(java.lang.Long)FormatUtils.parseObject(numPeriAnti, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CarIndicNivelJerarData inijOidIndiNiveJeraData = null;
		if(inijOidIndiNiveJera != null && !inijOidIndiNiveJera.trim().equals("")){
			inijOidIndiNiveJeraData = new es.indra.belcorp.mso.CarIndicNivelJerarData();
			inijOidIndiNiveJeraData.setId(new Long(inijOidIndiNiveJera));
		}
		carParamGenerCarte.setInijOidIndiNiveJera(inijOidIndiNiveJeraData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("carParamGenerCarte", carParamGenerCarte);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(carParamGenerCarte);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CarParamGenerCarte");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CarParamGenerCarte");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(carParamGenerCarte);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CarParamGenerCarteLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		traza("datePattern" + datePattern);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator.charAt(0));
		symbols.setGroupingSeparator(separadorMiles.charAt(0));	
		traza("MMG::Creando CarParamGenerCarte");
		
		String nireOidNiveRedo = conectorParametro("nireOidNiveRedo").trim();
		traza("MMG:: Valor de atributo nireOidNiveRedo: " + nireOidNiveRedo);
		
		String numPeriNuev = conectorParametro("numPeriNuev").trim();
		traza("MMG:: Valor de atributo numPeriNuev: " + numPeriNuev);
		
		String numPeriAnti = conectorParametro("numPeriAnti").trim();
		traza("MMG:: Valor de atributo numPeriAnti: " + numPeriAnti);
		
		String inijOidIndiNiveJera = conectorParametro("inijOidIndiNiveJera").trim();
		traza("MMG:: Valor de atributo inijOidIndiNiveJera: " + inijOidIndiNiveJera);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CarParamGenerCarteData carParamGenerCarte= new CarParamGenerCarteData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			carParamGenerCarte.setId(new Long(id));
		}
		carParamGenerCarte = (CarParamGenerCarteData)getSingleObject(BUSINESSID_QUERY, carParamGenerCarte, 
			carParamGenerCarte.clone(), "carParamGenerCarte");
		
		if(carParamGenerCarte == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.CarNivelRedonData nireOidNiveRedoData = null;
		if(nireOidNiveRedo != null && !nireOidNiveRedo.trim().equals("")){
			nireOidNiveRedoData = new es.indra.belcorp.mso.CarNivelRedonData();
			nireOidNiveRedoData.setId(new Long(nireOidNiveRedo));
		}
		carParamGenerCarte.setNireOidNiveRedo(nireOidNiveRedoData);
		carParamGenerCarte.setNumPeriNuev(
			(java.lang.Long)FormatUtils.parseObject(numPeriNuev, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		carParamGenerCarte.setNumPeriAnti(
			(java.lang.Long)FormatUtils.parseObject(numPeriAnti, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CarIndicNivelJerarData inijOidIndiNiveJeraData = null;
		if(inijOidIndiNiveJera != null && !inijOidIndiNiveJera.trim().equals("")){
			inijOidIndiNiveJeraData = new es.indra.belcorp.mso.CarIndicNivelJerarData();
			inijOidIndiNiveJeraData.setId(new Long(inijOidIndiNiveJera));
		}
		carParamGenerCarte.setInijOidIndiNiveJera(inijOidIndiNiveJeraData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//carParamGenerCarte.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("carParamGenerCarte", carParamGenerCarte);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(carParamGenerCarte);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CarParamGenerCarte");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CarParamGenerCarte");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(carParamGenerCarte);
		
		
		//Redirigimos a la LP que cierra el dialogo
		//Registramos que se recagen los datos en la venta en la cual se ha producido la operación
		conectorAction(LP_CLOSE_DIALOG);
		conectorActionOpener(false);
	}
	
	/**Nos permite borrar los elementos de la entidad seleccionados*/
	protected void cmdRemove() throws Exception{
		//Determinamos los elementos a eliminar. De cada uno sacamos el id y el timestamp
		Vector entities = new Vector();
		StringTokenizer claves = new StringTokenizer(conectorParametro("idSelection"), "|");
		StringTokenizer timestamps = new StringTokenizer(conectorParametro("timestamp"), "|");
		traza("MMG::Se van a borrar " + claves.countTokens() + " y son " + conectorParametro("idSelection"));
		while(claves.hasMoreTokens() && timestamps.hasMoreTokens()){
			CarParamGenerCarteData carParamGenerCarte = new CarParamGenerCarteData();
			carParamGenerCarte.setId(new Long(claves.nextToken()));
			//carParamGenerCarte.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(carParamGenerCarte);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CarParamGenerCarte");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CarParamGenerCarte");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CarParamGenerCarteLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(CarParamGenerCarteData carParamGenerCarte) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));carParamGenerCarte.setPaisOidPais(paisOculto);
	}
	

	protected void cmdPreUpdate(CarParamGenerCarteData carParamGenerCarte) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));carParamGenerCarte.setPaisOidPais(paisOculto);
	}
	
	
	

	protected void cmdPostCreate(CarParamGenerCarteData carParamGenerCarte) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));carParamGenerCarte.setPaisOidPais(paisOculto);
	}
	

	protected void cmdPostUpdate(CarParamGenerCarteData carParamGenerCarte) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));carParamGenerCarte.setPaisOidPais(paisOculto);
	}
	
	
	
	
}




