

/*
    INDRA/CAR/mmg
    $Id: ZonTerriAdminLPExecution.java,v 1.1 2009/12/03 18:43:46 pecbazalar Exp $
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

public class ZonTerriAdminLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGZonTerriAdminCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGZonTerriAdminUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGZonTerriAdminRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGZonTerriAdminQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "ZonTerriAdminConectorCreate";
	public static final String CONECTOR_UPDATE = "ZonTerriAdminConectorUpdate";
	public static final String CONECTOR_REMOVE = "ZonTerriAdminConectorRemove";

	public ZonTerriAdminLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("ZonTerriAdminPage");
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
  	correspondiente a la creación de un/a nuevo ZonTerriAdmin*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando ZonTerriAdmin");
		
		String indBorr = conectorParametro("indBorr").trim();
		traza("MMG:: Valor de atributo indBorr: " + indBorr);
		
		String zsccOidSecc = conectorParametro("zsccOidSecc").trim();
		traza("MMG:: Valor de atributo zsccOidSecc: " + zsccOidSecc);
		
		String terrOidTerr = conectorParametro("terrOidTerr").trim();
		traza("MMG:: Valor de atributo terrOidTerr: " + terrOidTerr);
		
		String fecRtz = conectorParametro("fecRtz").trim();
		traza("MMG:: Valor de atributo fecRtz: " + fecRtz);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		ZonTerriAdminData zonTerriAdmin= new ZonTerriAdminData();
		zonTerriAdmin.setIndBorr(
			(java.lang.Integer)FormatUtils.parseObject(indBorr, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.ZonSecciData zsccOidSeccData = null;
		if(zsccOidSecc != null && !zsccOidSecc.trim().equals("")){
			zsccOidSeccData = new es.indra.belcorp.mso.ZonSecciData();
			zsccOidSeccData.setId(new Integer(zsccOidSecc));
		}
		zonTerriAdmin.setZsccOidSecc(zsccOidSeccData);
		es.indra.belcorp.mso.ZonTerriData terrOidTerrData = null;
		if(terrOidTerr != null && !terrOidTerr.trim().equals("")){
			terrOidTerrData = new es.indra.belcorp.mso.ZonTerriData();
			terrOidTerrData.setId(new Integer(terrOidTerr));
		}
		zonTerriAdmin.setTerrOidTerr(terrOidTerrData);
		zonTerriAdmin.setFecRtz(
			(java.sql.Date)FormatUtils.parseObject(fecRtz, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonTerriAdmin", zonTerriAdmin);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad ZonTerriAdmin");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad ZonTerriAdmin");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("ZonTerriAdminLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando ZonTerriAdmin");
		
		String indBorr = conectorParametro("indBorr").trim();
		traza("MMG:: Valor de atributo indBorr: " + indBorr);
		
		String zsccOidSecc = conectorParametro("zsccOidSecc").trim();
		traza("MMG:: Valor de atributo zsccOidSecc: " + zsccOidSecc);
		
		String terrOidTerr = conectorParametro("terrOidTerr").trim();
		traza("MMG:: Valor de atributo terrOidTerr: " + terrOidTerr);
		
		String fecRtz = conectorParametro("fecRtz").trim();
		traza("MMG:: Valor de atributo fecRtz: " + fecRtz);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		ZonTerriAdminData zonTerriAdmin= new ZonTerriAdminData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			zonTerriAdmin.setId(new Integer(id));
		}
		zonTerriAdmin = (ZonTerriAdminData)getSingleObject(BUSINESSID_QUERY, zonTerriAdmin, 
			zonTerriAdmin.clone(), "zonTerriAdmin");
		
		if(zonTerriAdmin == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		zonTerriAdmin.setIndBorr(
			(java.lang.Integer)FormatUtils.parseObject(indBorr, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.ZonSecciData zsccOidSeccData = null;
		if(zsccOidSecc != null && !zsccOidSecc.trim().equals("")){
			zsccOidSeccData = new es.indra.belcorp.mso.ZonSecciData();
			zsccOidSeccData.setId(new Integer(zsccOidSecc));
		}
		zonTerriAdmin.setZsccOidSecc(zsccOidSeccData);
		es.indra.belcorp.mso.ZonTerriData terrOidTerrData = null;
		if(terrOidTerr != null && !terrOidTerr.trim().equals("")){
			terrOidTerrData = new es.indra.belcorp.mso.ZonTerriData();
			terrOidTerrData.setId(new Integer(terrOidTerr));
		}
		zonTerriAdmin.setTerrOidTerr(terrOidTerrData);
		zonTerriAdmin.setFecRtz(
			(java.sql.Date)FormatUtils.parseObject(fecRtz, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//zonTerriAdmin.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonTerriAdmin", zonTerriAdmin);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad ZonTerriAdmin");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad ZonTerriAdmin");

		
		
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
			ZonTerriAdminData zonTerriAdmin = new ZonTerriAdminData();
			zonTerriAdmin.setId(new Integer(claves.nextToken()));
			//zonTerriAdmin.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(zonTerriAdmin);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad ZonTerriAdmin");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad ZonTerriAdmin");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("ZonTerriAdminLPStartUp");
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




