

/*
    INDRA/CAR/mmg
    $Id: MaeExencFleteLPExecution.java,v 1.1 2009/12/03 18:32:28 pecbazalar Exp $
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

public class MaeExencFleteLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGMaeExencFleteCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGMaeExencFleteUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGMaeExencFleteRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGMaeExencFleteQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "MaeExencFleteConectorCreate";
	public static final String CONECTOR_UPDATE = "MaeExencFleteConectorUpdate";
	public static final String CONECTOR_REMOVE = "MaeExencFleteConectorRemove";

	public MaeExencFleteLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("MaeExencFletePage");
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
  	correspondiente a la creación de un/a nuevo MaeExencFlete*/  
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
		
		traza("MMG::Creando MaeExencFlete");
		
		String ticlOidTipoClie = conectorParametro("ticlOidTipoClie").trim();
		traza("MMG:: Valor de atributo ticlOidTipoClie: " + ticlOidTipoClie);
		
		String sbtiOidSubtClie = conectorParametro("sbtiOidSubtClie").trim();
		traza("MMG:: Valor de atributo sbtiOidSubtClie: " + sbtiOidSubtClie);
		
		String tcclOidTipoClas = conectorParametro("tcclOidTipoClas").trim();
		traza("MMG:: Valor de atributo tcclOidTipoClas: " + tcclOidTipoClas);
		
		String clasOidClas = conectorParametro("clasOidClas").trim();
		traza("MMG:: Valor de atributo clasOidClas: " + clasOidClas);
		
		String indExenFlet = conectorParametro("indExenFlet").trim();
		traza("MMG:: Valor de atributo indExenFlet: " + indExenFlet);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		MaeExencFleteData maeExencFlete= new MaeExencFleteData();
		es.indra.belcorp.mso.MaeTipoClienData ticlOidTipoClieData = null;
		if(ticlOidTipoClie != null && !ticlOidTipoClie.trim().equals("")){
			ticlOidTipoClieData = new es.indra.belcorp.mso.MaeTipoClienData();
			ticlOidTipoClieData.setId(new Long(ticlOidTipoClie));
		}
		maeExencFlete.setTiclOidTipoClie(ticlOidTipoClieData);
		es.indra.belcorp.mso.MaeSubtiClienViewData sbtiOidSubtClieData = null;
		if(sbtiOidSubtClie != null && !sbtiOidSubtClie.trim().equals("")){
			sbtiOidSubtClieData = new es.indra.belcorp.mso.MaeSubtiClienViewData();
			sbtiOidSubtClieData.setId(new Long(sbtiOidSubtClie));
		}
		maeExencFlete.setSbtiOidSubtClie(sbtiOidSubtClieData);
		es.indra.belcorp.mso.MaeTipoClasiClienViewData tcclOidTipoClasData = null;
		if(tcclOidTipoClas != null && !tcclOidTipoClas.trim().equals("")){
			tcclOidTipoClasData = new es.indra.belcorp.mso.MaeTipoClasiClienViewData();
			tcclOidTipoClasData.setId(new Long(tcclOidTipoClas));
		}
		maeExencFlete.setTcclOidTipoClas(tcclOidTipoClasData);
		es.indra.belcorp.mso.MaeClasiViewData clasOidClasData = null;
		if(clasOidClas != null && !clasOidClas.trim().equals("")){
			clasOidClasData = new es.indra.belcorp.mso.MaeClasiViewData();
			clasOidClasData.setId(new Long(clasOidClas));
		}
		maeExencFlete.setClasOidClas(clasOidClasData);
		maeExencFlete.setIndExenFlet(
			(java.lang.String)FormatUtils.parseObject(indExenFlet, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeExencFlete", maeExencFlete);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(maeExencFlete);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad MaeExencFlete");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad MaeExencFlete");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(maeExencFlete);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("MaeExencFleteLPStartUp");
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
		traza("MMG::Creando MaeExencFlete");
		
		String ticlOidTipoClie = conectorParametro("ticlOidTipoClie").trim();
		traza("MMG:: Valor de atributo ticlOidTipoClie: " + ticlOidTipoClie);
		
		String sbtiOidSubtClie = conectorParametro("sbtiOidSubtClie").trim();
		traza("MMG:: Valor de atributo sbtiOidSubtClie: " + sbtiOidSubtClie);
		
		String tcclOidTipoClas = conectorParametro("tcclOidTipoClas").trim();
		traza("MMG:: Valor de atributo tcclOidTipoClas: " + tcclOidTipoClas);
		
		String clasOidClas = conectorParametro("clasOidClas").trim();
		traza("MMG:: Valor de atributo clasOidClas: " + clasOidClas);
		
		String indExenFlet = conectorParametro("indExenFlet").trim();
		traza("MMG:: Valor de atributo indExenFlet: " + indExenFlet);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		MaeExencFleteData maeExencFlete= new MaeExencFleteData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			maeExencFlete.setId(new Long(id));
		}
		maeExencFlete = (MaeExencFleteData)getSingleObject(BUSINESSID_QUERY, maeExencFlete, 
			maeExencFlete.clone(), "maeExencFlete");
		
		if(maeExencFlete == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.MaeTipoClienData ticlOidTipoClieData = null;
		if(ticlOidTipoClie != null && !ticlOidTipoClie.trim().equals("")){
			ticlOidTipoClieData = new es.indra.belcorp.mso.MaeTipoClienData();
			ticlOidTipoClieData.setId(new Long(ticlOidTipoClie));
		}
		maeExencFlete.setTiclOidTipoClie(ticlOidTipoClieData);
		es.indra.belcorp.mso.MaeSubtiClienViewData sbtiOidSubtClieData = null;
		if(sbtiOidSubtClie != null && !sbtiOidSubtClie.trim().equals("")){
			sbtiOidSubtClieData = new es.indra.belcorp.mso.MaeSubtiClienViewData();
			sbtiOidSubtClieData.setId(new Long(sbtiOidSubtClie));
		}
		maeExencFlete.setSbtiOidSubtClie(sbtiOidSubtClieData);
		es.indra.belcorp.mso.MaeTipoClasiClienViewData tcclOidTipoClasData = null;
		if(tcclOidTipoClas != null && !tcclOidTipoClas.trim().equals("")){
			tcclOidTipoClasData = new es.indra.belcorp.mso.MaeTipoClasiClienViewData();
			tcclOidTipoClasData.setId(new Long(tcclOidTipoClas));
		}
		maeExencFlete.setTcclOidTipoClas(tcclOidTipoClasData);
		es.indra.belcorp.mso.MaeClasiViewData clasOidClasData = null;
		if(clasOidClas != null && !clasOidClas.trim().equals("")){
			clasOidClasData = new es.indra.belcorp.mso.MaeClasiViewData();
			clasOidClasData.setId(new Long(clasOidClas));
		}
		maeExencFlete.setClasOidClas(clasOidClasData);
		maeExencFlete.setIndExenFlet(
			(java.lang.String)FormatUtils.parseObject(indExenFlet, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//maeExencFlete.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeExencFlete", maeExencFlete);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(maeExencFlete);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad MaeExencFlete");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad MaeExencFlete");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(maeExencFlete);
		
		
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
			MaeExencFleteData maeExencFlete = new MaeExencFleteData();
			maeExencFlete.setId(new Long(claves.nextToken()));
			//maeExencFlete.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(maeExencFlete);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad MaeExencFlete");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad MaeExencFlete");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("MaeExencFleteLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(MaeExencFleteData maeExencFlete) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeExencFlete.setPaisOidPais(paisOculto);
	}
	

	protected void cmdPreUpdate(MaeExencFleteData maeExencFlete) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeExencFlete.setPaisOidPais(paisOculto);
	}
	
	
	

	protected void cmdPostCreate(MaeExencFleteData maeExencFlete) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeExencFlete.setPaisOidPais(paisOculto);
	}
	

	protected void cmdPostUpdate(MaeExencFleteData maeExencFlete) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeExencFlete.setPaisOidPais(paisOculto);
	}
	
	
	
	
}




