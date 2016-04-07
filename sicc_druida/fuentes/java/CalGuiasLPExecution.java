

/*
    INDRA/CAR/mmg
    $Id: CalGuiasLPExecution.java,v 1.1 2009/12/03 18:35:13 pecbazalar Exp $
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

public class CalGuiasLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCalGuiasCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCalGuiasUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCalGuiasRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCalGuiasQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CalGuiasConectorCreate";
	public static final String CONECTOR_UPDATE = "CalGuiasConectorUpdate";
	public static final String CONECTOR_REMOVE = "CalGuiasConectorRemove";

	public CalGuiasLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CalGuiasPage");
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
  	correspondiente a la creación de un/a nuevo CalGuias*/  
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
		
		traza("MMG::Creando CalGuias");
		
		String codGuia = conectorParametro("codGuia").trim();
		traza("MMG:: Valor de atributo codGuia: " + codGuia);
		if(codGuia != null && !codGuia.trim().equals("")) codGuia = codGuia.toUpperCase();
		
		String dpteOidDepa = conectorParametro("dpteOidDepa").trim();
		traza("MMG:: Valor de atributo dpteOidDepa: " + dpteOidDepa);
		
		String valTitu = conectorParametro("valTitu").trim();
		traza("MMG:: Valor de atributo valTitu: " + valTitu);
		
		String fecInicVali = conectorParametro("fecInicVali").trim();
		traza("MMG:: Valor de atributo fecInicVali: " + fecInicVali);
		
		String fecFinVali = conectorParametro("fecFinVali").trim();
		traza("MMG:: Valor de atributo fecFinVali: " + fecFinVali);
		
		String valDescGuia = conectorParametro("valDescGuia").trim();
		traza("MMG:: Valor de atributo valDescGuia: " + valDescGuia);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CalGuiasData calGuias= new CalGuiasData();
		calGuias.setCodGuia(
			(java.lang.String)FormatUtils.parseObject(codGuia, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegDeptoEmpreData dpteOidDepaData = null;
		if(dpteOidDepa != null && !dpteOidDepa.trim().equals("")){
			dpteOidDepaData = new es.indra.belcorp.mso.SegDeptoEmpreData();
			dpteOidDepaData.setId(new Long(dpteOidDepa));
		}
		calGuias.setDpteOidDepa(dpteOidDepaData);
		calGuias.setValTitu(
			(java.lang.String)FormatUtils.parseObject(valTitu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		calGuias.setFecInicVali(
			(java.sql.Date)FormatUtils.parseObject(fecInicVali, "java.sql.Date", 
			 datePattern, symbols));
		calGuias.setFecFinVali(
			(java.sql.Date)FormatUtils.parseObject(fecFinVali, "java.sql.Date", 
			 datePattern, symbols));
		calGuias.setValDescGuia(
			(java.lang.String)FormatUtils.parseObject(valDescGuia, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("calGuias", calGuias);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(calGuias);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CalGuias");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CalGuias");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(calGuias);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CalGuiasLPStartUp");
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
		traza("MMG::Creando CalGuias");
		
		String dpteOidDepa = conectorParametro("dpteOidDepa").trim();
		traza("MMG:: Valor de atributo dpteOidDepa: " + dpteOidDepa);
		
		String valTitu = conectorParametro("valTitu").trim();
		traza("MMG:: Valor de atributo valTitu: " + valTitu);
		
		String fecInicVali = conectorParametro("fecInicVali").trim();
		traza("MMG:: Valor de atributo fecInicVali: " + fecInicVali);
		
		String fecFinVali = conectorParametro("fecFinVali").trim();
		traza("MMG:: Valor de atributo fecFinVali: " + fecFinVali);
		
		String valDescGuia = conectorParametro("valDescGuia").trim();
		traza("MMG:: Valor de atributo valDescGuia: " + valDescGuia);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CalGuiasData calGuias= new CalGuiasData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			calGuias.setId(new Long(id));
		}
		calGuias = (CalGuiasData)getSingleObject(BUSINESSID_QUERY, calGuias, 
			calGuias.clone(), "calGuias");
		
		if(calGuias == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegDeptoEmpreData dpteOidDepaData = null;
		if(dpteOidDepa != null && !dpteOidDepa.trim().equals("")){
			dpteOidDepaData = new es.indra.belcorp.mso.SegDeptoEmpreData();
			dpteOidDepaData.setId(new Long(dpteOidDepa));
		}
		calGuias.setDpteOidDepa(dpteOidDepaData);
		calGuias.setValTitu(
			(java.lang.String)FormatUtils.parseObject(valTitu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		calGuias.setFecInicVali(
			(java.sql.Date)FormatUtils.parseObject(fecInicVali, "java.sql.Date", 
			 datePattern, symbols));
		calGuias.setFecFinVali(
			(java.sql.Date)FormatUtils.parseObject(fecFinVali, "java.sql.Date", 
			 datePattern, symbols));
		calGuias.setValDescGuia(
			(java.lang.String)FormatUtils.parseObject(valDescGuia, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//calGuias.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("calGuias", calGuias);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(calGuias);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CalGuias");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CalGuias");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(calGuias);
		
		
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
			CalGuiasData calGuias = new CalGuiasData();
			calGuias.setId(new Long(claves.nextToken()));
			//calGuias.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(calGuias);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CalGuias");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CalGuias");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CalGuiasLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(CalGuiasData calGuias) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));calGuias.setPaisOidPais(paisOculto);
	}
	

	protected void cmdPreUpdate(CalGuiasData calGuias) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));calGuias.setPaisOidPais(paisOculto);
	}
	
	
	

	protected void cmdPostCreate(CalGuiasData calGuias) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));calGuias.setPaisOidPais(paisOculto);
	}
	

	protected void cmdPostUpdate(CalGuiasData calGuias) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));calGuias.setPaisOidPais(paisOculto);
	}
	
	
	
	
}




