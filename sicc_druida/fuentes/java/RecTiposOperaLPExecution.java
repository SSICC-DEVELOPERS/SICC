

/*
    INDRA/CAR/mmg
    $Id: RecTiposOperaLPExecution.java,v 1.1 2009/12/03 18:34:10 pecbazalar Exp $
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

public class RecTiposOperaLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGRecTiposOperaCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGRecTiposOperaUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGRecTiposOperaRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGRecTiposOperaQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "RecTiposOperaConectorCreate";
	public static final String CONECTOR_UPDATE = "RecTiposOperaConectorUpdate";
	public static final String CONECTOR_REMOVE = "RecTiposOperaConectorRemove";

	public RecTiposOperaLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("RecTiposOperaPage");
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
  	correspondiente a la creación de un/a nuevo RecTiposOpera*/  
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
		
		traza("MMG::Creando RecTiposOpera");
		
		String valTipoOper = conectorParametro("valTipoOper").trim();
		traza("MMG:: Valor de atributo valTipoOper: " + valTipoOper);
		
		String indCampRefeUnic = conectorParametro("indCampRefeUnic").trim();
		traza("MMG:: Valor de atributo indCampRefeUnic: " + indCampRefeUnic);
		
		String numDiasHaciAtra = conectorParametro("numDiasHaciAtra").trim();
		traza("MMG:: Valor de atributo numDiasHaciAtra: " + numDiasHaciAtra);
		
		String valInfoEbelNoti = conectorParametro("valInfoEbelNoti").trim();
		traza("MMG:: Valor de atributo valInfoEbelNoti: " + valInfoEbelNoti);
		
		String indDevuEstaFact = conectorParametro("indDevuEstaFact").trim();
		traza("MMG:: Valor de atributo indDevuEstaFact: " + indDevuEstaFact);
		
		String indEnviEstaFact = conectorParametro("indEnviEstaFact").trim();
		traza("MMG:: Valor de atributo indEnviEstaFact: " + indEnviEstaFact);
		
		String ropeOidOper = conectorParametro("ropeOidOper").trim();
		traza("MMG:: Valor de atributo ropeOidOper: " + ropeOidOper);
		
		String mrdbOidMotiRechDesb = conectorParametro("mrdbOidMotiRechDesb").trim();
		traza("MMG:: Valor de atributo mrdbOidMotiRechDesb: " + mrdbOidMotiRechDesb);
		
		String moblOidBloqDife = conectorParametro("moblOidBloqDife").trim();
		traza("MMG:: Valor de atributo moblOidBloqDife: " + moblOidBloqDife);
		
		String moblOidReclAnte = conectorParametro("moblOidReclAnte").trim();
		traza("MMG:: Valor de atributo moblOidReclAnte: " + moblOidReclAnte);
		
		String moblOidBloqImpo = conectorParametro("moblOidBloqImpo").trim();
		traza("MMG:: Valor de atributo moblOidBloqImpo: " + moblOidBloqImpo);
		
		String moblOidBloqUnid = conectorParametro("moblOidBloqUnid").trim();
		traza("MMG:: Valor de atributo moblOidBloqUnid: " + moblOidBloqUnid);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		RecTiposOperaData recTiposOpera= new RecTiposOperaData();
		recTiposOpera.setValTipoOper(
			(java.lang.String)FormatUtils.parseObject(valTipoOper, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recTiposOpera.setIndCampRefeUnic(
			(java.lang.Long)FormatUtils.parseObject(indCampRefeUnic, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recTiposOpera.setNumDiasHaciAtra(
			(java.lang.Long)FormatUtils.parseObject(numDiasHaciAtra, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recTiposOpera.setValInfoEbelNoti(
			(java.lang.Long)FormatUtils.parseObject(valInfoEbelNoti, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recTiposOpera.setIndDevuEstaFact(
			(java.lang.Long)FormatUtils.parseObject(indDevuEstaFact, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recTiposOpera.setIndEnviEstaFact(
			(java.lang.Long)FormatUtils.parseObject(indEnviEstaFact, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.RecOperaData ropeOidOperData = null;
		if(ropeOidOper != null && !ropeOidOper.trim().equals("")){
			ropeOidOperData = new es.indra.belcorp.mso.RecOperaData();
			ropeOidOperData.setId(new Long(ropeOidOper));
		}
		recTiposOpera.setRopeOidOper(ropeOidOperData);
		es.indra.belcorp.mso.RecMotivRechaDesblData mrdbOidMotiRechDesbData = null;
		if(mrdbOidMotiRechDesb != null && !mrdbOidMotiRechDesb.trim().equals("")){
			mrdbOidMotiRechDesbData = new es.indra.belcorp.mso.RecMotivRechaDesblData();
			mrdbOidMotiRechDesbData.setId(new Long(mrdbOidMotiRechDesb));
		}
		recTiposOpera.setMrdbOidMotiRechDesb(mrdbOidMotiRechDesbData);
		es.indra.belcorp.mso.RecMotivBloquData moblOidBloqDifeData = null;
		if(moblOidBloqDife != null && !moblOidBloqDife.trim().equals("")){
			moblOidBloqDifeData = new es.indra.belcorp.mso.RecMotivBloquData();
			moblOidBloqDifeData.setId(new Long(moblOidBloqDife));
		}
		recTiposOpera.setMoblOidBloqDife(moblOidBloqDifeData);
		es.indra.belcorp.mso.RecMotivBloquData moblOidReclAnteData = null;
		if(moblOidReclAnte != null && !moblOidReclAnte.trim().equals("")){
			moblOidReclAnteData = new es.indra.belcorp.mso.RecMotivBloquData();
			moblOidReclAnteData.setId(new Long(moblOidReclAnte));
		}
		recTiposOpera.setMoblOidReclAnte(moblOidReclAnteData);
		es.indra.belcorp.mso.RecMotivBloquData moblOidBloqImpoData = null;
		if(moblOidBloqImpo != null && !moblOidBloqImpo.trim().equals("")){
			moblOidBloqImpoData = new es.indra.belcorp.mso.RecMotivBloquData();
			moblOidBloqImpoData.setId(new Long(moblOidBloqImpo));
		}
		recTiposOpera.setMoblOidBloqImpo(moblOidBloqImpoData);
		es.indra.belcorp.mso.RecMotivBloquData moblOidBloqUnidData = null;
		if(moblOidBloqUnid != null && !moblOidBloqUnid.trim().equals("")){
			moblOidBloqUnidData = new es.indra.belcorp.mso.RecMotivBloquData();
			moblOidBloqUnidData.setId(new Long(moblOidBloqUnid));
		}
		recTiposOpera.setMoblOidBloqUnid(moblOidBloqUnidData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("recTiposOpera", recTiposOpera);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad RecTiposOpera");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad RecTiposOpera");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("RecTiposOperaLPStartUp");
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
		traza("MMG::Creando RecTiposOpera");
		
		String valTipoOper = conectorParametro("valTipoOper").trim();
		traza("MMG:: Valor de atributo valTipoOper: " + valTipoOper);
		
		String indCampRefeUnic = conectorParametro("indCampRefeUnic").trim();
		traza("MMG:: Valor de atributo indCampRefeUnic: " + indCampRefeUnic);
		
		String numDiasHaciAtra = conectorParametro("numDiasHaciAtra").trim();
		traza("MMG:: Valor de atributo numDiasHaciAtra: " + numDiasHaciAtra);
		
		String valInfoEbelNoti = conectorParametro("valInfoEbelNoti").trim();
		traza("MMG:: Valor de atributo valInfoEbelNoti: " + valInfoEbelNoti);
		
		String indDevuEstaFact = conectorParametro("indDevuEstaFact").trim();
		traza("MMG:: Valor de atributo indDevuEstaFact: " + indDevuEstaFact);
		
		String indEnviEstaFact = conectorParametro("indEnviEstaFact").trim();
		traza("MMG:: Valor de atributo indEnviEstaFact: " + indEnviEstaFact);
		
		String ropeOidOper = conectorParametro("ropeOidOper").trim();
		traza("MMG:: Valor de atributo ropeOidOper: " + ropeOidOper);
		
		String mrdbOidMotiRechDesb = conectorParametro("mrdbOidMotiRechDesb").trim();
		traza("MMG:: Valor de atributo mrdbOidMotiRechDesb: " + mrdbOidMotiRechDesb);
		
		String moblOidBloqDife = conectorParametro("moblOidBloqDife").trim();
		traza("MMG:: Valor de atributo moblOidBloqDife: " + moblOidBloqDife);
		
		String moblOidReclAnte = conectorParametro("moblOidReclAnte").trim();
		traza("MMG:: Valor de atributo moblOidReclAnte: " + moblOidReclAnte);
		
		String moblOidBloqImpo = conectorParametro("moblOidBloqImpo").trim();
		traza("MMG:: Valor de atributo moblOidBloqImpo: " + moblOidBloqImpo);
		
		String moblOidBloqUnid = conectorParametro("moblOidBloqUnid").trim();
		traza("MMG:: Valor de atributo moblOidBloqUnid: " + moblOidBloqUnid);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		RecTiposOperaData recTiposOpera= new RecTiposOperaData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			recTiposOpera.setId(new Long(id));
		}
		recTiposOpera = (RecTiposOperaData)getSingleObject(BUSINESSID_QUERY, recTiposOpera, 
			recTiposOpera.clone(), "recTiposOpera");
		
		if(recTiposOpera == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		recTiposOpera.setValTipoOper(
			(java.lang.String)FormatUtils.parseObject(valTipoOper, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recTiposOpera.setIndCampRefeUnic(
			(java.lang.Long)FormatUtils.parseObject(indCampRefeUnic, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recTiposOpera.setNumDiasHaciAtra(
			(java.lang.Long)FormatUtils.parseObject(numDiasHaciAtra, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recTiposOpera.setValInfoEbelNoti(
			(java.lang.Long)FormatUtils.parseObject(valInfoEbelNoti, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recTiposOpera.setIndDevuEstaFact(
			(java.lang.Long)FormatUtils.parseObject(indDevuEstaFact, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recTiposOpera.setIndEnviEstaFact(
			(java.lang.Long)FormatUtils.parseObject(indEnviEstaFact, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.RecOperaData ropeOidOperData = null;
		if(ropeOidOper != null && !ropeOidOper.trim().equals("")){
			ropeOidOperData = new es.indra.belcorp.mso.RecOperaData();
			ropeOidOperData.setId(new Long(ropeOidOper));
		}
		recTiposOpera.setRopeOidOper(ropeOidOperData);
		es.indra.belcorp.mso.RecMotivRechaDesblData mrdbOidMotiRechDesbData = null;
		if(mrdbOidMotiRechDesb != null && !mrdbOidMotiRechDesb.trim().equals("")){
			mrdbOidMotiRechDesbData = new es.indra.belcorp.mso.RecMotivRechaDesblData();
			mrdbOidMotiRechDesbData.setId(new Long(mrdbOidMotiRechDesb));
		}
		recTiposOpera.setMrdbOidMotiRechDesb(mrdbOidMotiRechDesbData);
		es.indra.belcorp.mso.RecMotivBloquData moblOidBloqDifeData = null;
		if(moblOidBloqDife != null && !moblOidBloqDife.trim().equals("")){
			moblOidBloqDifeData = new es.indra.belcorp.mso.RecMotivBloquData();
			moblOidBloqDifeData.setId(new Long(moblOidBloqDife));
		}
		recTiposOpera.setMoblOidBloqDife(moblOidBloqDifeData);
		es.indra.belcorp.mso.RecMotivBloquData moblOidReclAnteData = null;
		if(moblOidReclAnte != null && !moblOidReclAnte.trim().equals("")){
			moblOidReclAnteData = new es.indra.belcorp.mso.RecMotivBloquData();
			moblOidReclAnteData.setId(new Long(moblOidReclAnte));
		}
		recTiposOpera.setMoblOidReclAnte(moblOidReclAnteData);
		es.indra.belcorp.mso.RecMotivBloquData moblOidBloqImpoData = null;
		if(moblOidBloqImpo != null && !moblOidBloqImpo.trim().equals("")){
			moblOidBloqImpoData = new es.indra.belcorp.mso.RecMotivBloquData();
			moblOidBloqImpoData.setId(new Long(moblOidBloqImpo));
		}
		recTiposOpera.setMoblOidBloqImpo(moblOidBloqImpoData);
		es.indra.belcorp.mso.RecMotivBloquData moblOidBloqUnidData = null;
		if(moblOidBloqUnid != null && !moblOidBloqUnid.trim().equals("")){
			moblOidBloqUnidData = new es.indra.belcorp.mso.RecMotivBloquData();
			moblOidBloqUnidData.setId(new Long(moblOidBloqUnid));
		}
		recTiposOpera.setMoblOidBloqUnid(moblOidBloqUnidData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//recTiposOpera.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("recTiposOpera", recTiposOpera);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad RecTiposOpera");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad RecTiposOpera");

		
		
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
			RecTiposOperaData recTiposOpera = new RecTiposOperaData();
			recTiposOpera.setId(new Long(claves.nextToken()));
			//recTiposOpera.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(recTiposOpera);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad RecTiposOpera");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad RecTiposOpera");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("RecTiposOperaLPStartUp");
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




