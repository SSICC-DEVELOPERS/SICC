

/*
    INDRA/CAR/mmg
    $Id: CobUsuarCobraViewLPExecution.java,v 1.1 2009/12/03 18:41:19 pecbazalar Exp $
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

public class CobUsuarCobraViewLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCobUsuarCobraViewCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCobUsuarCobraViewUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCobUsuarCobraViewRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCobUsuarCobraViewQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CobUsuarCobraViewConectorCreate";
	public static final String CONECTOR_UPDATE = "CobUsuarCobraViewConectorUpdate";
	public static final String CONECTOR_REMOVE = "CobUsuarCobraViewConectorRemove";

	public CobUsuarCobraViewLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CobUsuarCobraViewPage");
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
  	correspondiente a la creación de un/a nuevo CobUsuarCobraView*/  
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
		
		traza("MMG::Creando CobUsuarCobraView");
		
		String fecUltiEsta = conectorParametro("fecUltiEsta").trim();
		traza("MMG:: Valor de atributo fecUltiEsta: " + fecUltiEsta);
		
		String indJefeCobr = conectorParametro("indJefeCobr").trim();
		traza("MMG:: Valor de atributo indJefeCobr: " + indJefeCobr);
		
		String indUsuaSupe = conectorParametro("indUsuaSupe").trim();
		traza("MMG:: Valor de atributo indUsuaSupe: " + indUsuaSupe);
		
		String indUsuaExte = conectorParametro("indUsuaExte").trim();
		traza("MMG:: Valor de atributo indUsuaExte: " + indUsuaExte);
		
		String valTurnHoraEntr = conectorParametro("valTurnHoraEntr").trim();
		traza("MMG:: Valor de atributo valTurnHoraEntr: " + valTurnHoraEntr);
		
		String valTurnHoraSali = conectorParametro("valTurnHoraSali").trim();
		traza("MMG:: Valor de atributo valTurnHoraSali: " + valTurnHoraSali);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		String userOidUsuaCobr = conectorParametro("userOidUsuaCobr").trim();
		traza("MMG:: Valor de atributo userOidUsuaCobr: " + userOidUsuaCobr);
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CobUsuarCobraViewData cobUsuarCobraView= new CobUsuarCobraViewData();
		cobUsuarCobraView.setFecUltiEsta(
			(java.sql.Date)FormatUtils.parseObject(fecUltiEsta, "java.sql.Date", 
			 datePattern, symbols));
		cobUsuarCobraView.setIndJefeCobr(
			(java.lang.Long)FormatUtils.parseObject(indJefeCobr, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobUsuarCobraView.setIndUsuaSupe(
			(java.lang.Long)FormatUtils.parseObject(indUsuaSupe, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobUsuarCobraView.setIndUsuaExte(
			(java.lang.Long)FormatUtils.parseObject(indUsuaExte, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobUsuarCobraView.setValTurnHoraEntr(
			(java.lang.String)FormatUtils.parseObject(valTurnHoraEntr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobUsuarCobraView.setValTurnHoraSali(
			(java.lang.String)FormatUtils.parseObject(valTurnHoraSali, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobUsuarCobraView.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.GenUsersData userOidUsuaCobrData = null;
		if(userOidUsuaCobr != null && !userOidUsuaCobr.trim().equals("")){
			userOidUsuaCobrData = new es.indra.belcorp.mso.GenUsersData();
			userOidUsuaCobrData.setId(new Long(userOidUsuaCobr));
		}
		cobUsuarCobraView.setUserOidUsuaCobr(userOidUsuaCobrData);
		es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		cobUsuarCobraView.setPaisOidPais(paisOidPaisData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobUsuarCobraView", cobUsuarCobraView);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CobUsuarCobraView");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CobUsuarCobraView");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CobUsuarCobraViewLPStartUp");
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
		traza("MMG::Creando CobUsuarCobraView");
		
		String fecUltiEsta = conectorParametro("fecUltiEsta").trim();
		traza("MMG:: Valor de atributo fecUltiEsta: " + fecUltiEsta);
		
		String indJefeCobr = conectorParametro("indJefeCobr").trim();
		traza("MMG:: Valor de atributo indJefeCobr: " + indJefeCobr);
		
		String indUsuaSupe = conectorParametro("indUsuaSupe").trim();
		traza("MMG:: Valor de atributo indUsuaSupe: " + indUsuaSupe);
		
		String indUsuaExte = conectorParametro("indUsuaExte").trim();
		traza("MMG:: Valor de atributo indUsuaExte: " + indUsuaExte);
		
		String valTurnHoraEntr = conectorParametro("valTurnHoraEntr").trim();
		traza("MMG:: Valor de atributo valTurnHoraEntr: " + valTurnHoraEntr);
		
		String valTurnHoraSali = conectorParametro("valTurnHoraSali").trim();
		traza("MMG:: Valor de atributo valTurnHoraSali: " + valTurnHoraSali);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		String userOidUsuaCobr = conectorParametro("userOidUsuaCobr").trim();
		traza("MMG:: Valor de atributo userOidUsuaCobr: " + userOidUsuaCobr);
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CobUsuarCobraViewData cobUsuarCobraView= new CobUsuarCobraViewData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			cobUsuarCobraView.setId(new Long(id));
		}
		cobUsuarCobraView = (CobUsuarCobraViewData)getSingleObject(BUSINESSID_QUERY, cobUsuarCobraView, 
			cobUsuarCobraView.clone(), "cobUsuarCobraView");
		
		if(cobUsuarCobraView == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		cobUsuarCobraView.setFecUltiEsta(
			(java.sql.Date)FormatUtils.parseObject(fecUltiEsta, "java.sql.Date", 
			 datePattern, symbols));
		cobUsuarCobraView.setIndJefeCobr(
			(java.lang.Long)FormatUtils.parseObject(indJefeCobr, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobUsuarCobraView.setIndUsuaSupe(
			(java.lang.Long)FormatUtils.parseObject(indUsuaSupe, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobUsuarCobraView.setIndUsuaExte(
			(java.lang.Long)FormatUtils.parseObject(indUsuaExte, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobUsuarCobraView.setValTurnHoraEntr(
			(java.lang.String)FormatUtils.parseObject(valTurnHoraEntr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobUsuarCobraView.setValTurnHoraSali(
			(java.lang.String)FormatUtils.parseObject(valTurnHoraSali, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobUsuarCobraView.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.GenUsersData userOidUsuaCobrData = null;
		if(userOidUsuaCobr != null && !userOidUsuaCobr.trim().equals("")){
			userOidUsuaCobrData = new es.indra.belcorp.mso.GenUsersData();
			userOidUsuaCobrData.setId(new Long(userOidUsuaCobr));
		}
		cobUsuarCobraView.setUserOidUsuaCobr(userOidUsuaCobrData);
		es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		cobUsuarCobraView.setPaisOidPais(paisOidPaisData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//cobUsuarCobraView.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobUsuarCobraView", cobUsuarCobraView);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CobUsuarCobraView");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CobUsuarCobraView");

		
		
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
			CobUsuarCobraViewData cobUsuarCobraView = new CobUsuarCobraViewData();
			cobUsuarCobraView.setId(new Long(claves.nextToken()));
			//cobUsuarCobraView.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(cobUsuarCobraView);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CobUsuarCobraView");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CobUsuarCobraView");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CobUsuarCobraViewLPStartUp");
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




