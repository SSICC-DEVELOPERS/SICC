

/*
    INDRA/CAR/mmg
    $Id: MaeConfiCampoLPExecution.java,v 1.1 2009/12/03 18:32:20 pecbazalar Exp $
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
import es.indra.belcorp.mso.*;

public class MaeConfiCampoLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGMaeConfiCampoCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGMaeConfiCampoUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGMaeConfiCampoRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGMaeConfiCampoQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "MaeConfiCampoConectorCreate";
	public static final String CONECTOR_UPDATE = "MaeConfiCampoConectorUpdate";
	public static final String CONECTOR_REMOVE = "MaeConfiCampoConectorRemove";

	public MaeConfiCampoLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("MaeConfiCampoPage");
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
  	correspondiente a la creación de un/a nuevo MaeConfiCampo*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando MaeConfiCampo");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String sbtiOidSubtClie = conectorParametro("sbtiOidSubtClie").trim();
		traza("MMG:: Valor de atributo sbtiOidSubtClie: " + sbtiOidSubtClie);
		
		String atreOidAtriEspe = conectorParametro("atreOidAtriEspe").trim();
		traza("MMG:: Valor de atributo atreOidAtriEspe: " + atreOidAtriEspe);
		
		String valDefe = conectorParametro("valDefe").trim();
		traza("MMG:: Valor de atributo valDefe: " + valDefe);
		
		String indObli = conectorParametro("indObli").trim();
		traza("MMG:: Valor de atributo indObli: " + indObli);
		
		String indModi = conectorParametro("indModi").trim();
		traza("MMG:: Valor de atributo indModi: " + indModi);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		MaeConfiCampoData maeConfiCampo= new MaeConfiCampoData();
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		maeConfiCampo.setPaisOidPais(paisOidPaisData);
		es.indra.belcorp.mso.MaeSubtiClienData sbtiOidSubtClieData = null;
		if(sbtiOidSubtClie != null && !sbtiOidSubtClie.trim().equals("")){
			sbtiOidSubtClieData = new es.indra.belcorp.mso.MaeSubtiClienData();
			sbtiOidSubtClieData.setId(new Integer(sbtiOidSubtClie));
		}
		maeConfiCampo.setSbtiOidSubtClie(sbtiOidSubtClieData);
		es.indra.belcorp.mso.PedAtribEspecData atreOidAtriEspeData = null;
		if(atreOidAtriEspe != null && !atreOidAtriEspe.trim().equals("")){
			atreOidAtriEspeData = new es.indra.belcorp.mso.PedAtribEspecData();
			atreOidAtriEspeData.setId(new Integer(atreOidAtriEspe));
		}
		maeConfiCampo.setAtreOidAtriEspe(atreOidAtriEspeData);
		maeConfiCampo.setValDefe(
			(java.lang.String)FormatUtils.parseObject(valDefe, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		maeConfiCampo.setIndObli(
			(java.lang.Integer)FormatUtils.parseObject(indObli, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		maeConfiCampo.setIndModi(
			(java.lang.Integer)FormatUtils.parseObject(indModi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeConfiCampo", maeConfiCampo);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad MaeConfiCampo");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad MaeConfiCampo");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("MaeConfiCampoLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando MaeConfiCampo");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String sbtiOidSubtClie = conectorParametro("sbtiOidSubtClie").trim();
		traza("MMG:: Valor de atributo sbtiOidSubtClie: " + sbtiOidSubtClie);
		
		String atreOidAtriEspe = conectorParametro("atreOidAtriEspe").trim();
		traza("MMG:: Valor de atributo atreOidAtriEspe: " + atreOidAtriEspe);
		
		String valDefe = conectorParametro("valDefe").trim();
		traza("MMG:: Valor de atributo valDefe: " + valDefe);
		
		String indObli = conectorParametro("indObli").trim();
		traza("MMG:: Valor de atributo indObli: " + indObli);
		
		String indModi = conectorParametro("indModi").trim();
		traza("MMG:: Valor de atributo indModi: " + indModi);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		MaeConfiCampoData maeConfiCampo= new MaeConfiCampoData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			maeConfiCampo.setId(new Integer(id));
		}
		maeConfiCampo = (MaeConfiCampoData)getSingleObject(BUSINESSID_QUERY, maeConfiCampo, 
			maeConfiCampo.clone(), "maeConfiCampo");
		
		if(maeConfiCampo == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		maeConfiCampo.setPaisOidPais(paisOidPaisData);
		es.indra.belcorp.mso.MaeSubtiClienData sbtiOidSubtClieData = null;
		if(sbtiOidSubtClie != null && !sbtiOidSubtClie.trim().equals("")){
			sbtiOidSubtClieData = new es.indra.belcorp.mso.MaeSubtiClienData();
			sbtiOidSubtClieData.setId(new Integer(sbtiOidSubtClie));
		}
		maeConfiCampo.setSbtiOidSubtClie(sbtiOidSubtClieData);
		es.indra.belcorp.mso.PedAtribEspecData atreOidAtriEspeData = null;
		if(atreOidAtriEspe != null && !atreOidAtriEspe.trim().equals("")){
			atreOidAtriEspeData = new es.indra.belcorp.mso.PedAtribEspecData();
			atreOidAtriEspeData.setId(new Integer(atreOidAtriEspe));
		}
		maeConfiCampo.setAtreOidAtriEspe(atreOidAtriEspeData);
		maeConfiCampo.setValDefe(
			(java.lang.String)FormatUtils.parseObject(valDefe, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		maeConfiCampo.setIndObli(
			(java.lang.Integer)FormatUtils.parseObject(indObli, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		maeConfiCampo.setIndModi(
			(java.lang.Integer)FormatUtils.parseObject(indModi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//maeConfiCampo.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeConfiCampo", maeConfiCampo);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad MaeConfiCampo");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad MaeConfiCampo");

		
		
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
			MaeConfiCampoData maeConfiCampo = new MaeConfiCampoData();
			maeConfiCampo.setId(new Integer(claves.nextToken()));
			//maeConfiCampo.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(maeConfiCampo);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad MaeConfiCampo");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad MaeConfiCampo");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("MaeConfiCampoLPStartUp");
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




