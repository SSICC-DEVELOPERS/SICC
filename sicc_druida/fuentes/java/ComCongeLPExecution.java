

/*
    INDRA/CAR/mmg
    $Id: ComCongeLPExecution.java,v 1.1 2009/12/03 18:39:09 pecbazalar Exp $
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

public class ComCongeLPExecution extends MMGDruidaBase{
	//Constantes de l�ogica de negocio
	public static final String BUSINESSID_CREATE= "MMGComCongeCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGComCongeUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGComCongeRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGComCongeQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "ComCongeConectorCreate";
	public static final String CONECTOR_UPDATE = "ComCongeConectorUpdate";
	public static final String CONECTOR_REMOVE = "ComCongeConectorRemove";

	public ComCongeLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("ComCongePage");
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		//Activamos las trazas
		setTrazaFichero();
	
		try{
			//Sacamos la acci�n a realizar y ejecutamos la acci�n correspondiente
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			
			//Caragamos los elemetnos en la pagina
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
	
			//Ejecutamos la acci�n indicada
			if(accion.equals(ACCION_CREATE)) cmdCreate();
			if(accion.equals(ACCION_UPDATE)) cmdUpdate();
			if(accion.equals(ACCION_REMOVE)) cmdRemove();
		}catch(Exception e){
			handleException(e);
		}
  }
  
  /**Permite crear un nuevo elemento de la entidad. Invoca la l�gica de negocio
  	correspondiente a la creaci�n de un/a nuevo ComConge*/  
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
		
		traza("MMG::Creando ComConge");
		
		String fecDesd = conectorParametro("fecDesd").trim();
		traza("MMG:: Valor de atributo fecDesd: " + fecDesd);
		
		String fecHast = conectorParametro("fecHast").trim();
		traza("MMG:: Valor de atributo fecHast: " + fecHast);
		
		String impCong = conectorParametro("impCong").trim();
		traza("MMG:: Valor de atributo impCong: " + impCong);
		
		String indDescAuto = conectorParametro("indDescAuto").trim();
		traza("MMG:: Valor de atributo indDescAuto: " + indDescAuto);
		
		String clieOidClie = conectorParametro("clieOidClie").trim();
		traza("MMG:: Valor de atributo clieOidClie: " + clieOidClie);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		ComCongeData comConge= new ComCongeData();
		comConge.setFecDesd(
			(java.sql.Date)FormatUtils.parseObject(fecDesd, "java.sql.Date", 
			 datePattern, symbols));
		comConge.setFecHast(
			(java.sql.Date)FormatUtils.parseObject(fecHast, "java.sql.Date", 
			 datePattern, symbols));
		comConge.setImpCong(
			(java.lang.Double)FormatUtils.parseObject(impCong, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		comConge.setIndDescAuto(
			(java.lang.Long)FormatUtils.parseObject(indDescAuto, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.MaeClienViewData clieOidClieData = null;
		if(clieOidClie != null && !clieOidClie.trim().equals("")){
			clieOidClieData = new es.indra.belcorp.mso.MaeClienViewData();
			clieOidClieData.setId(new Long(clieOidClie));
		}
		comConge.setClieOidClie(clieOidClieData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("comConge", comConge);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acci�n de precreate
		cmdPreCreate(comConge);
		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Create de entidad ComConge");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecuci�n Create de entidad ComConge");
		
		
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp
		conectorAction("ComCongeLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operaci�n de modificaci�n sobre el elemento seleccionado*/  
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
		traza("MMG::Creando ComConge");
		
		String fecDesd = conectorParametro("fecDesd").trim();
		traza("MMG:: Valor de atributo fecDesd: " + fecDesd);
		
		String fecHast = conectorParametro("fecHast").trim();
		traza("MMG:: Valor de atributo fecHast: " + fecHast);
		
		String impCong = conectorParametro("impCong").trim();
		traza("MMG:: Valor de atributo impCong: " + impCong);
		
		String indDescAuto = conectorParametro("indDescAuto").trim();
		traza("MMG:: Valor de atributo indDescAuto: " + indDescAuto);
		
		String clieOidClie = conectorParametro("clieOidClie").trim();
		traza("MMG:: Valor de atributo clieOidClie: " + clieOidClie);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		ComCongeData comConge= new ComCongeData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			comConge.setId(new Long(id));
		}
		comConge = (ComCongeData)getSingleObject(BUSINESSID_QUERY, comConge, 
			comConge.clone(), "comConge");
		
		if(comConge == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		comConge.setFecDesd(
			(java.sql.Date)FormatUtils.parseObject(fecDesd, "java.sql.Date", 
			 datePattern, symbols));
		comConge.setFecHast(
			(java.sql.Date)FormatUtils.parseObject(fecHast, "java.sql.Date", 
			 datePattern, symbols));
		comConge.setImpCong(
			(java.lang.Double)FormatUtils.parseObject(impCong, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		comConge.setIndDescAuto(
			(java.lang.Long)FormatUtils.parseObject(indDescAuto, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.MaeClienViewData clieOidClieData = null;
		if(clieOidClie != null && !clieOidClie.trim().equals("")){
			clieOidClieData = new es.indra.belcorp.mso.MaeClienViewData();
			clieOidClieData.setId(new Long(clieOidClie));
		}
		comConge.setClieOidClie(clieOidClieData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//comConge.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de realizar una modificaci�n
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("comConge", comConge);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Update de entidad ComConge");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecuci�n Update de entidad ComConge");

		
		
		//Redirigimos a la LP que cierra el dialogo
		//Registramos que se recagen los datos en la venta en la cual se ha producido la operaci�n
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
			ComCongeData comConge = new ComCongeData();
			comConge.setId(new Long(claves.nextToken()));
			//comConge.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(comConge);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Remove de entidad ComConge");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecuci�n Remove de entidad ComConge");
		
		

		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp y requery
		conectorAction("ComCongeLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(ComCongeData comConge) throws Exception{
		
				
         		comConge.setCodCong(new Long((int)((System.currentTimeMillis()/1000)%1000000)));
                
	}
	

	
	
	

	

	
	
	
	
}




