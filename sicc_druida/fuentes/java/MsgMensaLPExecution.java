

/*
    INDRA/CAR/mmg
    $Id: MsgMensaLPExecution.java,v 1.1 2009/12/03 18:39:37 pecbazalar Exp $
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

public class MsgMensaLPExecution extends MMGDruidaBase{
	//Constantes de l�ogica de negocio
	public static final String BUSINESSID_CREATE= "MMGMsgMensaCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGMsgMensaUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGMsgMensaRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGMsgMensaQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "MsgMensaConectorCreate";
	public static final String CONECTOR_UPDATE = "MsgMensaConectorUpdate";
	public static final String CONECTOR_REMOVE = "MsgMensaConectorRemove";

	public MsgMensaLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("MsgMensaPage");
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
  	correspondiente a la creaci�n de un/a nuevo MsgMensa*/  
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
		
		traza("MMG::Creando MsgMensa");
		
		String codMens = conectorParametro("codMens").trim();
		traza("MMG:: Valor de atributo codMens: " + codMens);
		if(codMens != null && !codMens.trim().equals("")) codMens = codMens.toUpperCase();
		
		String desMens = conectorParametro("desMens").trim();
		traza("MMG:: Valor de atributo desMens: " + desMens);
		
		String valBloqGrupPerm = conectorParametro("valBloqGrupPerm").trim();
		traza("MMG:: Valor de atributo valBloqGrupPerm: " + valBloqGrupPerm);
		
		String fecPermDesd = conectorParametro("fecPermDesd").trim();
		traza("MMG:: Valor de atributo fecPermDesd: " + fecPermDesd);
		
		String fecPermHast = conectorParametro("fecPermHast").trim();
		traza("MMG:: Valor de atributo fecPermHast: " + fecPermHast);
		
		String valText = conectorParametro("valText").trim();
		traza("MMG:: Valor de atributo valText: " + valText);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		MsgMensaData msgMensa= new MsgMensaData();
		msgMensa.setCodMens(
			(java.lang.String)FormatUtils.parseObject(codMens, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		msgMensa.setDesMens(
			(java.lang.String)FormatUtils.parseObject(desMens, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		msgMensa.setValBloqGrupPerm(
			(java.lang.String)FormatUtils.parseObject(valBloqGrupPerm, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		msgMensa.setFecPermDesd(
			(java.sql.Date)FormatUtils.parseObject(fecPermDesd, "java.sql.Date", 
			 datePattern, symbols));
		msgMensa.setFecPermHast(
			(java.sql.Date)FormatUtils.parseObject(fecPermHast, "java.sql.Date", 
			 datePattern, symbols));
		msgMensa.setValText(
			(java.lang.String)FormatUtils.parseObject(valText, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("msgMensa", msgMensa);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Create de entidad MsgMensa");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecuci�n Create de entidad MsgMensa");
		
		
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp
		conectorAction("MsgMensaLPStartUp");
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
		traza("MMG::Creando MsgMensa");
		
		String codMens = conectorParametro("codMens").trim();
		traza("MMG:: Valor de atributo codMens: " + codMens);
		if(codMens != null && !codMens.trim().equals("")) codMens = codMens.toUpperCase();
		
		String desMens = conectorParametro("desMens").trim();
		traza("MMG:: Valor de atributo desMens: " + desMens);
		
		String valBloqGrupPerm = conectorParametro("valBloqGrupPerm").trim();
		traza("MMG:: Valor de atributo valBloqGrupPerm: " + valBloqGrupPerm);
		
		String fecPermDesd = conectorParametro("fecPermDesd").trim();
		traza("MMG:: Valor de atributo fecPermDesd: " + fecPermDesd);
		
		String fecPermHast = conectorParametro("fecPermHast").trim();
		traza("MMG:: Valor de atributo fecPermHast: " + fecPermHast);
		
		String valText = conectorParametro("valText").trim();
		traza("MMG:: Valor de atributo valText: " + valText);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		MsgMensaData msgMensa= new MsgMensaData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			msgMensa.setId(new Long(id));
		}
		msgMensa = (MsgMensaData)getSingleObject(BUSINESSID_QUERY, msgMensa, 
			msgMensa.clone(), "msgMensa");
		
		if(msgMensa == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		msgMensa.setCodMens(
			(java.lang.String)FormatUtils.parseObject(codMens, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		msgMensa.setDesMens(
			(java.lang.String)FormatUtils.parseObject(desMens, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		msgMensa.setValBloqGrupPerm(
			(java.lang.String)FormatUtils.parseObject(valBloqGrupPerm, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		msgMensa.setFecPermDesd(
			(java.sql.Date)FormatUtils.parseObject(fecPermDesd, "java.sql.Date", 
			 datePattern, symbols));
		msgMensa.setFecPermHast(
			(java.sql.Date)FormatUtils.parseObject(fecPermHast, "java.sql.Date", 
			 datePattern, symbols));
		msgMensa.setValText(
			(java.lang.String)FormatUtils.parseObject(valText, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//msgMensa.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de realizar una modificaci�n
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("msgMensa", msgMensa);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Update de entidad MsgMensa");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecuci�n Update de entidad MsgMensa");

		
		
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
			MsgMensaData msgMensa = new MsgMensaData();
			msgMensa.setId(new Long(claves.nextToken()));
			//msgMensa.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(msgMensa);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Remove de entidad MsgMensa");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecuci�n Remove de entidad MsgMensa");
		
		

		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp y requery
		conectorAction("MsgMensaLPStartUp");
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




