

/*
    INDRA/CAR/mmg
    $Id: GenDetaSiccWithDefaultLPExecution.java,v 1.1 2009/12/03 18:38:46 pecbazalar Exp $
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

public class GenDetaSiccWithDefaultLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGGenDetaSiccWithDefaultCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGGenDetaSiccWithDefaultUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGGenDetaSiccWithDefaultRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGGenDetaSiccWithDefaultQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "GenDetaSiccWithDefaultConectorCreate";
	public static final String CONECTOR_UPDATE = "GenDetaSiccWithDefaultConectorUpdate";
	public static final String CONECTOR_REMOVE = "GenDetaSiccWithDefaultConectorRemove";

	public GenDetaSiccWithDefaultLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("GenDetaSiccWithDefaultPage");
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
  	correspondiente a la creación de un/a nuevo GenDetaSiccWithDefault*/  
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
		
		traza("MMG::Creando GenDetaSiccWithDefault");
		
		String enti = conectorParametro("enti").trim();
		traza("MMG:: Valor de atributo enti: " + enti);
		
		String entiPk = conectorParametro("entiPk").trim();
		traza("MMG:: Valor de atributo entiPk: " + entiPk);
		
		String atri = conectorParametro("atri").trim();
		traza("MMG:: Valor de atributo atri: " + atri);
		
		String deta = conectorParametro("deta").trim();
		traza("MMG:: Valor de atributo deta: " + deta);
		
		String idioOidIdio = conectorParametro("idioOidIdio").trim();
		traza("MMG:: Valor de atributo idioOidIdio: " + idioOidIdio);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		GenDetaSiccWithDefaultData genDetaSiccWithDefault= new GenDetaSiccWithDefaultData();
		genDetaSiccWithDefault.setEnti(
			(java.lang.String)FormatUtils.parseObject(enti, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		genDetaSiccWithDefault.setEntiPk(
			(java.lang.Long)FormatUtils.parseObject(entiPk, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		genDetaSiccWithDefault.setAtri(
			(java.lang.Long)FormatUtils.parseObject(atri, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		genDetaSiccWithDefault.setDeta(
			(java.lang.String)FormatUtils.parseObject(deta, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegIdiomData idioOidIdioData = null;
		if(idioOidIdio != null && !idioOidIdio.trim().equals("")){
			idioOidIdioData = new es.indra.belcorp.mso.SegIdiomData();
			idioOidIdioData.setId(new Long(idioOidIdio));
		}
		genDetaSiccWithDefault.setIdioOidIdio(idioOidIdioData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("genDetaSiccWithDefault", genDetaSiccWithDefault);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad GenDetaSiccWithDefault");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad GenDetaSiccWithDefault");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("GenDetaSiccWithDefaultLPStartUp");
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
		traza("MMG::Creando GenDetaSiccWithDefault");
		
		String enti = conectorParametro("enti").trim();
		traza("MMG:: Valor de atributo enti: " + enti);
		
		String entiPk = conectorParametro("entiPk").trim();
		traza("MMG:: Valor de atributo entiPk: " + entiPk);
		
		String atri = conectorParametro("atri").trim();
		traza("MMG:: Valor de atributo atri: " + atri);
		
		String deta = conectorParametro("deta").trim();
		traza("MMG:: Valor de atributo deta: " + deta);
		
		String idioOidIdio = conectorParametro("idioOidIdio").trim();
		traza("MMG:: Valor de atributo idioOidIdio: " + idioOidIdio);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		GenDetaSiccWithDefaultData genDetaSiccWithDefault= new GenDetaSiccWithDefaultData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			genDetaSiccWithDefault.setId(new Long(id));
		}
		genDetaSiccWithDefault = (GenDetaSiccWithDefaultData)getSingleObject(BUSINESSID_QUERY, genDetaSiccWithDefault, 
			genDetaSiccWithDefault.clone(), "genDetaSiccWithDefault");
		
		if(genDetaSiccWithDefault == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		genDetaSiccWithDefault.setEnti(
			(java.lang.String)FormatUtils.parseObject(enti, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		genDetaSiccWithDefault.setEntiPk(
			(java.lang.Long)FormatUtils.parseObject(entiPk, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		genDetaSiccWithDefault.setAtri(
			(java.lang.Long)FormatUtils.parseObject(atri, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		genDetaSiccWithDefault.setDeta(
			(java.lang.String)FormatUtils.parseObject(deta, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegIdiomData idioOidIdioData = null;
		if(idioOidIdio != null && !idioOidIdio.trim().equals("")){
			idioOidIdioData = new es.indra.belcorp.mso.SegIdiomData();
			idioOidIdioData.setId(new Long(idioOidIdio));
		}
		genDetaSiccWithDefault.setIdioOidIdio(idioOidIdioData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//genDetaSiccWithDefault.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("genDetaSiccWithDefault", genDetaSiccWithDefault);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad GenDetaSiccWithDefault");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad GenDetaSiccWithDefault");

		
		
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
			GenDetaSiccWithDefaultData genDetaSiccWithDefault = new GenDetaSiccWithDefaultData();
			genDetaSiccWithDefault.setId(new Long(claves.nextToken()));
			//genDetaSiccWithDefault.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(genDetaSiccWithDefault);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad GenDetaSiccWithDefault");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad GenDetaSiccWithDefault");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("GenDetaSiccWithDefaultLPStartUp");
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




