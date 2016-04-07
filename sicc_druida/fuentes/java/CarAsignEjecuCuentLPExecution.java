

/*
    INDRA/CAR/mmg
    $Id: CarAsignEjecuCuentLPExecution.java,v 1.1 2009/12/03 18:38:51 pecbazalar Exp $
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

public class CarAsignEjecuCuentLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCarAsignEjecuCuentCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCarAsignEjecuCuentUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCarAsignEjecuCuentRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCarAsignEjecuCuentQueryFromToUserPage";	
	public static final String CONECTOR_CREATE = "CarAsignEjecuCuentConectorCreate";
	public static final String CONECTOR_UPDATE = "CarAsignEjecuCuentConectorUpdate";
	public static final String CONECTOR_REMOVE = "CarAsignEjecuCuentConectorRemove";

	public CarAsignEjecuCuentLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CarAsignEjecuCuentPage");
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
  	correspondiente a la creación de un/a nuevo CarAsignEjecuCuent*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando CarAsignEjecuCuent");
		
		String niriOidNiveRies = conectorParametro("niriOidNiveRies").trim();
		traza("MMG:: Valor de atributo niriOidNiveRies: " + niriOidNiveRies);
		
		String zsgvOidSubgVent = conectorParametro("zsgvOidSubgVent").trim();
		traza("MMG:: Valor de atributo zsgvOidSubgVent: " + zsgvOidSubgVent);
		
		String zorgOidRegi = conectorParametro("zorgOidRegi").trim();
		traza("MMG:: Valor de atributo zorgOidRegi: " + zorgOidRegi);
		
		String zzonOidZona = conectorParametro("zzonOidZona").trim();
		traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
		
		String ejcuOidEjecCuen = conectorParametro("ejcuOidEjecCuen").trim();
		traza("MMG:: Valor de atributo ejcuOidEjecCuen: " + ejcuOidEjecCuen);
		
	
		//Construimos el mso con los elementos de la búsqueda
		CarAsignEjecuCuentData carAsignEjecuCuent= new CarAsignEjecuCuentData();
		
		
		es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesData = null;
		if(niriOidNiveRies != null && !niriOidNiveRies.trim().equals("")){
			niriOidNiveRiesData = new es.indra.belcorp.mso.CarNivelRiesgData();
			niriOidNiveRiesData.setId(new Integer(niriOidNiveRies));
		}
		carAsignEjecuCuent.setNiriOidNiveRies(niriOidNiveRiesData);
		
		es.indra.belcorp.mso.ZonSubGerenVentaData zsgvOidSubgVentData = null;
		if(zsgvOidSubgVent != null && !zsgvOidSubgVent.trim().equals("")){
			zsgvOidSubgVentData = new es.indra.belcorp.mso.ZonSubGerenVentaData();
			zsgvOidSubgVentData.setId(new Integer(zsgvOidSubgVent));
		}
		carAsignEjecuCuent.setZsgvOidSubgVent(zsgvOidSubgVentData);
		
		es.indra.belcorp.mso.ZonRegioData zorgOidRegiData = null;
		if(zorgOidRegi != null && !zorgOidRegi.trim().equals("")){
			zorgOidRegiData = new es.indra.belcorp.mso.ZonRegioData();
			zorgOidRegiData.setId(new Integer(zorgOidRegi));
		}
		carAsignEjecuCuent.setZorgOidRegi(zorgOidRegiData);
		
		es.indra.belcorp.mso.ZonZonaData zzonOidZonaData = null;
		if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
			zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaData();
			zzonOidZonaData.setId(new Integer(zzonOidZona));
		}
		carAsignEjecuCuent.setZzonOidZona(zzonOidZonaData);
		
		es.indra.belcorp.mso.CarEjecuCuentData ejcuOidEjecCuenData = null;
		if(ejcuOidEjecCuen != null && !ejcuOidEjecCuen.trim().equals("")){
			ejcuOidEjecCuenData = new es.indra.belcorp.mso.CarEjecuCuentData();
			ejcuOidEjecCuenData.setId(new Integer(ejcuOidEjecCuen));
		}
		carAsignEjecuCuent.setEjcuOidEjecCuen(ejcuOidEjecCuenData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("carAsignEjecuCuent", carAsignEjecuCuent);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CarAsignEjecuCuent");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CarAsignEjecuCuent");
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CarAsignEjecuCuentLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando CarAsignEjecuCuent");
		
		String niriOidNiveRies = conectorParametro("niriOidNiveRies").trim();
		traza("MMG:: Valor de atributo niriOidNiveRies: " + niriOidNiveRies);
		
		String zsgvOidSubgVent = conectorParametro("zsgvOidSubgVent").trim();
		traza("MMG:: Valor de atributo zsgvOidSubgVent: " + zsgvOidSubgVent);
		
		String zorgOidRegi = conectorParametro("zorgOidRegi").trim();
		traza("MMG:: Valor de atributo zorgOidRegi: " + zorgOidRegi);
		
		String zzonOidZona = conectorParametro("zzonOidZona").trim();
		traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
		
		String ejcuOidEjecCuen = conectorParametro("ejcuOidEjecCuen").trim();
		traza("MMG:: Valor de atributo ejcuOidEjecCuen: " + ejcuOidEjecCuen);
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CarAsignEjecuCuentData carAsignEjecuCuent= new CarAsignEjecuCuentData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			carAsignEjecuCuent.setId(new Integer(id));
		}
		carAsignEjecuCuent = (CarAsignEjecuCuentData)getSingleObject(BUSINESSID_QUERY, carAsignEjecuCuent, 
			carAsignEjecuCuent.clone(), "carAsignEjecuCuent");
		if(carAsignEjecuCuent == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesData = null;
		if(niriOidNiveRies != null && !niriOidNiveRies.trim().equals("")){
			niriOidNiveRiesData = new es.indra.belcorp.mso.CarNivelRiesgData();
			niriOidNiveRiesData.setId(new Integer(niriOidNiveRies));
		}
		carAsignEjecuCuent.setNiriOidNiveRies(niriOidNiveRiesData);
		es.indra.belcorp.mso.ZonSubGerenVentaData zsgvOidSubgVentData = null;
		if(zsgvOidSubgVent != null && !zsgvOidSubgVent.trim().equals("")){
			zsgvOidSubgVentData = new es.indra.belcorp.mso.ZonSubGerenVentaData();
			zsgvOidSubgVentData.setId(new Integer(zsgvOidSubgVent));
		}
		carAsignEjecuCuent.setZsgvOidSubgVent(zsgvOidSubgVentData);
		es.indra.belcorp.mso.ZonRegioData zorgOidRegiData = null;
		if(zorgOidRegi != null && !zorgOidRegi.trim().equals("")){
			zorgOidRegiData = new es.indra.belcorp.mso.ZonRegioData();
			zorgOidRegiData.setId(new Integer(zorgOidRegi));
		}
		carAsignEjecuCuent.setZorgOidRegi(zorgOidRegiData);
		es.indra.belcorp.mso.ZonZonaData zzonOidZonaData = null;
		if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
			zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaData();
			zzonOidZonaData.setId(new Integer(zzonOidZona));
		}
		carAsignEjecuCuent.setZzonOidZona(zzonOidZonaData);
		es.indra.belcorp.mso.CarEjecuCuentData ejcuOidEjecCuenData = null;
		if(ejcuOidEjecCuen != null && !ejcuOidEjecCuen.trim().equals("")){
			ejcuOidEjecCuenData = new es.indra.belcorp.mso.CarEjecuCuentData();
			ejcuOidEjecCuenData.setId(new Integer(ejcuOidEjecCuen));
		}
		carAsignEjecuCuent.setEjcuOidEjecCuen(ejcuOidEjecCuenData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en druida no hay bloqueos.....
		//carAsignEjecuCuent.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("carAsignEjecuCuent", carAsignEjecuCuent);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CarAsignEjecuCuent");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CarAsignEjecuCuent");
		
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
			CarAsignEjecuCuentData carAsignEjecuCuent = new CarAsignEjecuCuentData();
			carAsignEjecuCuent.setId(new Integer(claves.nextToken()));
			//carAsignEjecuCuent.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(carAsignEjecuCuent);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CarAsignEjecuCuent");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CarAsignEjecuCuent");

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CarAsignEjecuCuentLPStartUp");
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


