

/*
    INDRA/CAR/mmg
    $Id: MaeClienViewLPExecution.java,v 1.1 2009/12/03 18:40:01 pecbazalar Exp $
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

public class MaeClienViewLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGMaeClienViewCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGMaeClienViewUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGMaeClienViewRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGMaeClienViewQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "MaeClienViewConectorCreate";
	public static final String CONECTOR_UPDATE = "MaeClienViewConectorUpdate";
	public static final String CONECTOR_REMOVE = "MaeClienViewConectorRemove";

	public MaeClienViewLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("MaeClienViewPage");
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
  	correspondiente a la creación de un/a nuevo MaeClienView*/  
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
		
		traza("MMG::Creando MaeClienView");
		
		String codClie = conectorParametro("codClie").trim();
		traza("MMG:: Valor de atributo codClie: " + codClie);
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String indFichInsc = conectorParametro("indFichInsc").trim();
		traza("MMG:: Valor de atributo indFichInsc: " + indFichInsc);
		
		String codDigiCtrl = conectorParametro("codDigiCtrl").trim();
		traza("MMG:: Valor de atributo codDigiCtrl: " + codDigiCtrl);
		
		String valApe1 = conectorParametro("valApe1").trim();
		traza("MMG:: Valor de atributo valApe1: " + valApe1);
		
		String valApe2 = conectorParametro("valApe2").trim();
		traza("MMG:: Valor de atributo valApe2: " + valApe2);
		
		String valNom1 = conectorParametro("valNom1").trim();
		traza("MMG:: Valor de atributo valNom1: " + valNom1);
		
		String valNom2 = conectorParametro("valNom2").trim();
		traza("MMG:: Valor de atributo valNom2: " + valNom2);
		
		String valTrat = conectorParametro("valTrat").trim();
		traza("MMG:: Valor de atributo valTrat: " + valTrat);
		
		String valCritBus1 = conectorParametro("valCritBus1").trim();
		traza("MMG:: Valor de atributo valCritBus1: " + valCritBus1);
		
		String valCritBus2 = conectorParametro("valCritBus2").trim();
		traza("MMG:: Valor de atributo valCritBus2: " + valCritBus2);
		
		String codSexo = conectorParametro("codSexo").trim();
		traza("MMG:: Valor de atributo codSexo: " + codSexo);
		
		String fecIngr = conectorParametro("fecIngr").trim();
		traza("MMG:: Valor de atributo fecIngr: " + fecIngr);
		
		String valApelCasa = conectorParametro("valApelCasa").trim();
		traza("MMG:: Valor de atributo valApelCasa: " + valApelCasa);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		MaeClienViewData maeClienView= new MaeClienViewData();
		maeClienView.setCodClie(
			(java.lang.String)FormatUtils.parseObject(codClie, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		maeClienView.setPaisOidPais(paisOidPaisData);
		maeClienView.setIndFichInsc(
			(java.lang.Long)FormatUtils.parseObject(indFichInsc, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setCodDigiCtrl(
			(java.lang.String)FormatUtils.parseObject(codDigiCtrl, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setValApe1(
			(java.lang.String)FormatUtils.parseObject(valApe1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setValApe2(
			(java.lang.String)FormatUtils.parseObject(valApe2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setValNom1(
			(java.lang.String)FormatUtils.parseObject(valNom1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setValNom2(
			(java.lang.String)FormatUtils.parseObject(valNom2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setValTrat(
			(java.lang.String)FormatUtils.parseObject(valTrat, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setValCritBus1(
			(java.lang.String)FormatUtils.parseObject(valCritBus1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setValCritBus2(
			(java.lang.String)FormatUtils.parseObject(valCritBus2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setCodSexo(
			(java.lang.String)FormatUtils.parseObject(codSexo, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setFecIngr(
			(java.sql.Date)FormatUtils.parseObject(fecIngr, "java.sql.Date", 
			 datePattern, symbols));
		maeClienView.setValApelCasa(
			(java.lang.String)FormatUtils.parseObject(valApelCasa, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeClienView", maeClienView);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad MaeClienView");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad MaeClienView");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("MaeClienViewLPStartUp");
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
		traza("MMG::Creando MaeClienView");
		
		String codClie = conectorParametro("codClie").trim();
		traza("MMG:: Valor de atributo codClie: " + codClie);
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String indFichInsc = conectorParametro("indFichInsc").trim();
		traza("MMG:: Valor de atributo indFichInsc: " + indFichInsc);
		
		String codDigiCtrl = conectorParametro("codDigiCtrl").trim();
		traza("MMG:: Valor de atributo codDigiCtrl: " + codDigiCtrl);
		
		String valApe1 = conectorParametro("valApe1").trim();
		traza("MMG:: Valor de atributo valApe1: " + valApe1);
		
		String valApe2 = conectorParametro("valApe2").trim();
		traza("MMG:: Valor de atributo valApe2: " + valApe2);
		
		String valNom1 = conectorParametro("valNom1").trim();
		traza("MMG:: Valor de atributo valNom1: " + valNom1);
		
		String valNom2 = conectorParametro("valNom2").trim();
		traza("MMG:: Valor de atributo valNom2: " + valNom2);
		
		String valTrat = conectorParametro("valTrat").trim();
		traza("MMG:: Valor de atributo valTrat: " + valTrat);
		
		String valCritBus1 = conectorParametro("valCritBus1").trim();
		traza("MMG:: Valor de atributo valCritBus1: " + valCritBus1);
		
		String valCritBus2 = conectorParametro("valCritBus2").trim();
		traza("MMG:: Valor de atributo valCritBus2: " + valCritBus2);
		
		String codSexo = conectorParametro("codSexo").trim();
		traza("MMG:: Valor de atributo codSexo: " + codSexo);
		
		String fecIngr = conectorParametro("fecIngr").trim();
		traza("MMG:: Valor de atributo fecIngr: " + fecIngr);
		
		String valApelCasa = conectorParametro("valApelCasa").trim();
		traza("MMG:: Valor de atributo valApelCasa: " + valApelCasa);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		MaeClienViewData maeClienView= new MaeClienViewData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			maeClienView.setId(new Long(id));
		}
		maeClienView = (MaeClienViewData)getSingleObject(BUSINESSID_QUERY, maeClienView, 
			maeClienView.clone(), "maeClienView");
		
		if(maeClienView == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		maeClienView.setCodClie(
			(java.lang.String)FormatUtils.parseObject(codClie, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		maeClienView.setPaisOidPais(paisOidPaisData);
		maeClienView.setIndFichInsc(
			(java.lang.Long)FormatUtils.parseObject(indFichInsc, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setCodDigiCtrl(
			(java.lang.String)FormatUtils.parseObject(codDigiCtrl, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setValApe1(
			(java.lang.String)FormatUtils.parseObject(valApe1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setValApe2(
			(java.lang.String)FormatUtils.parseObject(valApe2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setValNom1(
			(java.lang.String)FormatUtils.parseObject(valNom1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setValNom2(
			(java.lang.String)FormatUtils.parseObject(valNom2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setValTrat(
			(java.lang.String)FormatUtils.parseObject(valTrat, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setValCritBus1(
			(java.lang.String)FormatUtils.parseObject(valCritBus1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setValCritBus2(
			(java.lang.String)FormatUtils.parseObject(valCritBus2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setCodSexo(
			(java.lang.String)FormatUtils.parseObject(codSexo, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeClienView.setFecIngr(
			(java.sql.Date)FormatUtils.parseObject(fecIngr, "java.sql.Date", 
			 datePattern, symbols));
		maeClienView.setValApelCasa(
			(java.lang.String)FormatUtils.parseObject(valApelCasa, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//maeClienView.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeClienView", maeClienView);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad MaeClienView");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad MaeClienView");

		
		
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
			MaeClienViewData maeClienView = new MaeClienViewData();
			maeClienView.setId(new Long(claves.nextToken()));
			//maeClienView.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(maeClienView);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad MaeClienView");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad MaeClienView");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("MaeClienViewLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	

	
	
	

	

	
	
	
	
}




