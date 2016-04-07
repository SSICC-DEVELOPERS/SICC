

/*
    INDRA/CAR/mmg
    $Id: SegTipoCambiLPExecution.java,v 1.1 2009/12/03 18:35:36 pecbazalar Exp $
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

public class SegTipoCambiLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGSegTipoCambiCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGSegTipoCambiUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGSegTipoCambiRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGSegTipoCambiQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "SegTipoCambiConectorCreate";
	public static final String CONECTOR_UPDATE = "SegTipoCambiConectorUpdate";
	public static final String CONECTOR_REMOVE = "SegTipoCambiConectorRemove";

	public SegTipoCambiLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("SegTipoCambiPage");
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
  	correspondiente a la creación de un/a nuevo SegTipoCambi*/  
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
		
		traza("MMG::Creando SegTipoCambi");
		
		String moneOidMon1 = conectorParametro("moneOidMon1").trim();
		traza("MMG:: Valor de atributo moneOidMon1: " + moneOidMon1);
		
		String moneOidMon2 = conectorParametro("moneOidMon2").trim();
		traza("MMG:: Valor de atributo moneOidMon2: " + moneOidMon2);
		
		String fecDesd = conectorParametro("fecDesd").trim();
		traza("MMG:: Valor de atributo fecDesd: " + fecDesd);
		
		String valTipoCamb = conectorParametro("valTipoCamb").trim();
		traza("MMG:: Valor de atributo valTipoCamb: " + valTipoCamb);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		SegTipoCambiData segTipoCambi= new SegTipoCambiData();
		es.indra.belcorp.mso.SegMonedData moneOidMon1Data = null;
		if(moneOidMon1 != null && !moneOidMon1.trim().equals("")){
			moneOidMon1Data = new es.indra.belcorp.mso.SegMonedData();
			moneOidMon1Data.setId(new Long(moneOidMon1));
		}
		segTipoCambi.setMoneOidMon1(moneOidMon1Data);
		es.indra.belcorp.mso.SegMonedData moneOidMon2Data = null;
		if(moneOidMon2 != null && !moneOidMon2.trim().equals("")){
			moneOidMon2Data = new es.indra.belcorp.mso.SegMonedData();
			moneOidMon2Data.setId(new Long(moneOidMon2));
		}
		segTipoCambi.setMoneOidMon2(moneOidMon2Data);
		segTipoCambi.setFecDesd(
			(java.sql.Date)FormatUtils.parseObject(fecDesd, "java.sql.Date", 
			 datePattern, symbols));
		segTipoCambi.setValTipoCamb(
			(java.lang.Double)FormatUtils.parseObject(valTipoCamb, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("segTipoCambi", segTipoCambi);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(segTipoCambi);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad SegTipoCambi");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad SegTipoCambi");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("SegTipoCambiLPStartUp");
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
		traza("MMG::Creando SegTipoCambi");
		
		String moneOidMon1 = conectorParametro("moneOidMon1").trim();
		traza("MMG:: Valor de atributo moneOidMon1: " + moneOidMon1);
		
		String moneOidMon2 = conectorParametro("moneOidMon2").trim();
		traza("MMG:: Valor de atributo moneOidMon2: " + moneOidMon2);
		
		String valTipoCamb = conectorParametro("valTipoCamb").trim();
		traza("MMG:: Valor de atributo valTipoCamb: " + valTipoCamb);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		SegTipoCambiData segTipoCambi= new SegTipoCambiData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			segTipoCambi.setId(new Long(id));
		}
		segTipoCambi = (SegTipoCambiData)getSingleObject(BUSINESSID_QUERY, segTipoCambi, 
			segTipoCambi.clone(), "segTipoCambi");
		
		if(segTipoCambi == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegMonedData moneOidMon1Data = null;
		if(moneOidMon1 != null && !moneOidMon1.trim().equals("")){
			moneOidMon1Data = new es.indra.belcorp.mso.SegMonedData();
			moneOidMon1Data.setId(new Long(moneOidMon1));
		}
		segTipoCambi.setMoneOidMon1(moneOidMon1Data);
		es.indra.belcorp.mso.SegMonedData moneOidMon2Data = null;
		if(moneOidMon2 != null && !moneOidMon2.trim().equals("")){
			moneOidMon2Data = new es.indra.belcorp.mso.SegMonedData();
			moneOidMon2Data.setId(new Long(moneOidMon2));
		}
		segTipoCambi.setMoneOidMon2(moneOidMon2Data);
		segTipoCambi.setValTipoCamb(
			(java.lang.Double)FormatUtils.parseObject(valTipoCamb, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//segTipoCambi.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("segTipoCambi", segTipoCambi);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(segTipoCambi);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad SegTipoCambi");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad SegTipoCambi");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(segTipoCambi);
		
		
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
			SegTipoCambiData segTipoCambi = new SegTipoCambiData();
			segTipoCambi.setId(new Long(claves.nextToken()));
			//segTipoCambi.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(segTipoCambi);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad SegTipoCambi");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad SegTipoCambi");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("SegTipoCambiLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(SegTipoCambiData segTipoCambi) throws Exception{
		
				java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd/MM/yyyy"); java.sql.Date fecha = new
				java.sql.Date(format.parse("01/01/3000").getTime()); segTipoCambi.setFecHast(fecha);
			
	}
	

	protected void cmdPreUpdate(SegTipoCambiData segTipoCambi) throws Exception{
		
				java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd/MM/yyyy"); java.sql.Date fecha = new
				java.sql.Date(format.parse("01/01/3000").getTime()); segTipoCambi.setFecHast(fecha);
			
	}
	
	
	

	

	protected void cmdPostUpdate(SegTipoCambiData segTipoCambi) throws Exception{
		
				java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd/MM/yyyy"); java.sql.Date fecha = new
				java.sql.Date(format.parse("01/01/3000").getTime()); segTipoCambi.setFecHast(fecha);
			
	}
	
	
	
	
}




