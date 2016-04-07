

/*
    INDRA/CAR/mmg
    $Id: IncPartiConcuDetalLPExecution.java,v 1.1 2009/12/03 18:36:23 pecbazalar Exp $
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

public class IncPartiConcuDetalLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGIncPartiConcuDetalCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGIncPartiConcuDetalUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGIncPartiConcuDetalRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGIncPartiConcuDetalQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "IncPartiConcuDetalConectorCreate";
	public static final String CONECTOR_UPDATE = "IncPartiConcuDetalConectorUpdate";
	public static final String CONECTOR_REMOVE = "IncPartiConcuDetalConectorRemove";

	public IncPartiConcuDetalLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("IncPartiConcuDetalPage");
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
  	correspondiente a la creación de un/a nuevo IncPartiConcuDetal*/  
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
		
		traza("MMG::Creando IncPartiConcuDetal");
		
		String paciOidPartConcCabe = conectorParametro("paciOidPartConcCabe").trim();
		traza("MMG:: Valor de atributo paciOidPartConcCabe: " + paciOidPartConcCabe);
		
		String ticlOidTipoClie = conectorParametro("ticlOidTipoClie").trim();
		traza("MMG:: Valor de atributo ticlOidTipoClie: " + ticlOidTipoClie);
		
		String sbtiOidSubtClie = conectorParametro("sbtiOidSubtClie").trim();
		traza("MMG:: Valor de atributo sbtiOidSubtClie: " + sbtiOidSubtClie);
		
		String tcclOidTipoClas = conectorParametro("tcclOidTipoClas").trim();
		traza("MMG:: Valor de atributo tcclOidTipoClas: " + tcclOidTipoClas);
		
		String clasOidClas = conectorParametro("clasOidClas").trim();
		traza("MMG:: Valor de atributo clasOidClas: " + clasOidClas);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		IncPartiConcuDetalData incPartiConcuDetal= new IncPartiConcuDetalData();
		es.indra.belcorp.mso.IncPartiConcuCabecData paciOidPartConcCabeData = null;
		if(paciOidPartConcCabe != null && !paciOidPartConcCabe.trim().equals("")){
			paciOidPartConcCabeData = new es.indra.belcorp.mso.IncPartiConcuCabecData();
			paciOidPartConcCabeData.setId(new Long(paciOidPartConcCabe));
		}
		incPartiConcuDetal.setPaciOidPartConcCabe(paciOidPartConcCabeData);
		es.indra.belcorp.mso.MaeTipoClienData ticlOidTipoClieData = null;
		if(ticlOidTipoClie != null && !ticlOidTipoClie.trim().equals("")){
			ticlOidTipoClieData = new es.indra.belcorp.mso.MaeTipoClienData();
			ticlOidTipoClieData.setId(new Long(ticlOidTipoClie));
		}
		incPartiConcuDetal.setTiclOidTipoClie(ticlOidTipoClieData);
		es.indra.belcorp.mso.MaeSubtiClienData sbtiOidSubtClieData = null;
		if(sbtiOidSubtClie != null && !sbtiOidSubtClie.trim().equals("")){
			sbtiOidSubtClieData = new es.indra.belcorp.mso.MaeSubtiClienData();
			sbtiOidSubtClieData.setId(new Long(sbtiOidSubtClie));
		}
		incPartiConcuDetal.setSbtiOidSubtClie(sbtiOidSubtClieData);
		es.indra.belcorp.mso.MaeTipoClasiClienData tcclOidTipoClasData = null;
		if(tcclOidTipoClas != null && !tcclOidTipoClas.trim().equals("")){
			tcclOidTipoClasData = new es.indra.belcorp.mso.MaeTipoClasiClienData();
			tcclOidTipoClasData.setId(new Long(tcclOidTipoClas));
		}
		incPartiConcuDetal.setTcclOidTipoClas(tcclOidTipoClasData);
		es.indra.belcorp.mso.MaeClasiData clasOidClasData = null;
		if(clasOidClas != null && !clasOidClas.trim().equals("")){
			clasOidClasData = new es.indra.belcorp.mso.MaeClasiData();
			clasOidClasData.setId(new Long(clasOidClas));
		}
		incPartiConcuDetal.setClasOidClas(clasOidClasData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("incPartiConcuDetal", incPartiConcuDetal);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad IncPartiConcuDetal");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad IncPartiConcuDetal");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("IncPartiConcuDetalLPStartUp");
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
		traza("MMG::Creando IncPartiConcuDetal");
		
		String paciOidPartConcCabe = conectorParametro("paciOidPartConcCabe").trim();
		traza("MMG:: Valor de atributo paciOidPartConcCabe: " + paciOidPartConcCabe);
		
		String ticlOidTipoClie = conectorParametro("ticlOidTipoClie").trim();
		traza("MMG:: Valor de atributo ticlOidTipoClie: " + ticlOidTipoClie);
		
		String sbtiOidSubtClie = conectorParametro("sbtiOidSubtClie").trim();
		traza("MMG:: Valor de atributo sbtiOidSubtClie: " + sbtiOidSubtClie);
		
		String tcclOidTipoClas = conectorParametro("tcclOidTipoClas").trim();
		traza("MMG:: Valor de atributo tcclOidTipoClas: " + tcclOidTipoClas);
		
		String clasOidClas = conectorParametro("clasOidClas").trim();
		traza("MMG:: Valor de atributo clasOidClas: " + clasOidClas);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		IncPartiConcuDetalData incPartiConcuDetal= new IncPartiConcuDetalData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			incPartiConcuDetal.setId(new Long(id));
		}
		incPartiConcuDetal = (IncPartiConcuDetalData)getSingleObject(BUSINESSID_QUERY, incPartiConcuDetal, 
			incPartiConcuDetal.clone(), "incPartiConcuDetal");
		
		if(incPartiConcuDetal == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.IncPartiConcuCabecData paciOidPartConcCabeData = null;
		if(paciOidPartConcCabe != null && !paciOidPartConcCabe.trim().equals("")){
			paciOidPartConcCabeData = new es.indra.belcorp.mso.IncPartiConcuCabecData();
			paciOidPartConcCabeData.setId(new Long(paciOidPartConcCabe));
		}
		incPartiConcuDetal.setPaciOidPartConcCabe(paciOidPartConcCabeData);
		es.indra.belcorp.mso.MaeTipoClienData ticlOidTipoClieData = null;
		if(ticlOidTipoClie != null && !ticlOidTipoClie.trim().equals("")){
			ticlOidTipoClieData = new es.indra.belcorp.mso.MaeTipoClienData();
			ticlOidTipoClieData.setId(new Long(ticlOidTipoClie));
		}
		incPartiConcuDetal.setTiclOidTipoClie(ticlOidTipoClieData);
		es.indra.belcorp.mso.MaeSubtiClienData sbtiOidSubtClieData = null;
		if(sbtiOidSubtClie != null && !sbtiOidSubtClie.trim().equals("")){
			sbtiOidSubtClieData = new es.indra.belcorp.mso.MaeSubtiClienData();
			sbtiOidSubtClieData.setId(new Long(sbtiOidSubtClie));
		}
		incPartiConcuDetal.setSbtiOidSubtClie(sbtiOidSubtClieData);
		es.indra.belcorp.mso.MaeTipoClasiClienData tcclOidTipoClasData = null;
		if(tcclOidTipoClas != null && !tcclOidTipoClas.trim().equals("")){
			tcclOidTipoClasData = new es.indra.belcorp.mso.MaeTipoClasiClienData();
			tcclOidTipoClasData.setId(new Long(tcclOidTipoClas));
		}
		incPartiConcuDetal.setTcclOidTipoClas(tcclOidTipoClasData);
		es.indra.belcorp.mso.MaeClasiData clasOidClasData = null;
		if(clasOidClas != null && !clasOidClas.trim().equals("")){
			clasOidClasData = new es.indra.belcorp.mso.MaeClasiData();
			clasOidClasData.setId(new Long(clasOidClas));
		}
		incPartiConcuDetal.setClasOidClas(clasOidClasData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//incPartiConcuDetal.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("incPartiConcuDetal", incPartiConcuDetal);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad IncPartiConcuDetal");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad IncPartiConcuDetal");

		
		
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
			IncPartiConcuDetalData incPartiConcuDetal = new IncPartiConcuDetalData();
			incPartiConcuDetal.setId(new Long(claves.nextToken()));
			//incPartiConcuDetal.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(incPartiConcuDetal);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad IncPartiConcuDetal");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad IncPartiConcuDetal");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("IncPartiConcuDetalLPStartUp");
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




