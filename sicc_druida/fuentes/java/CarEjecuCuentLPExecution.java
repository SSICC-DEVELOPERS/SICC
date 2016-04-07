

/*
    INDRA/CAR/mmg
    $Id: CarEjecuCuentLPExecution.java,v 1.1 2009/12/03 18:42:49 pecbazalar Exp $
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

public class CarEjecuCuentLPExecution extends MMGDruidaBase{
	//Constantes de l�ogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCarEjecuCuentCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCarEjecuCuentUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCarEjecuCuentRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCarEjecuCuentQueryFromToUserPage";	
	public static final String CONECTOR_CREATE = "CarEjecuCuentConectorCreate";
	public static final String CONECTOR_UPDATE = "CarEjecuCuentConectorUpdate";
	public static final String CONECTOR_REMOVE = "CarEjecuCuentConectorRemove";

	public CarEjecuCuentLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CarEjecuCuentPage");
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
  	correspondiente a la creaci�n de un/a nuevo CarEjecuCuent*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando CarEjecuCuent");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String codEjecCuen = conectorParametro("codEjecCuen").trim();
		traza("MMG:: Valor de atributo codEjecCuen: " + codEjecCuen);
		
		String jeraOidJera = conectorParametro("jeraOidJera").trim();
		traza("MMG:: Valor de atributo jeraOidJera: " + jeraOidJera);
		
	
		//Construimos el mso con los elementos de la b�squeda
		CarEjecuCuentData carEjecuCuent= new CarEjecuCuentData();
		
		
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		carEjecuCuent.setPaisOidPais(paisOidPaisData);
		carEjecuCuent.setCodEjecCuen(
			(java.lang.String)FormatUtils.parseObject(codEjecCuen, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		es.indra.belcorp.mso.CarJerarData jeraOidJeraData = null;
		if(jeraOidJera != null && !jeraOidJera.trim().equals("")){
			jeraOidJeraData = new es.indra.belcorp.mso.CarJerarData();
			jeraOidJeraData.setId(new Integer(jeraOidJera));
		}
		carEjecuCuent.setJeraOidJera(jeraOidJeraData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("carEjecuCuent", carEjecuCuent);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Create de entidad CarEjecuCuent");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecuci�n Create de entidad CarEjecuCuent");
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp
		conectorAction("CarEjecuCuentLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operaci�n de modificaci�n sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando CarEjecuCuent");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String codEjecCuen = conectorParametro("codEjecCuen").trim();
		traza("MMG:: Valor de atributo codEjecCuen: " + codEjecCuen);
		
		String jeraOidJera = conectorParametro("jeraOidJera").trim();
		traza("MMG:: Valor de atributo jeraOidJera: " + jeraOidJera);
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CarEjecuCuentData carEjecuCuent= new CarEjecuCuentData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			carEjecuCuent.setId(new Integer(id));
		}
		carEjecuCuent = (CarEjecuCuentData)getSingleObject(BUSINESSID_QUERY, carEjecuCuent, 
			carEjecuCuent.clone(), "carEjecuCuent");
		if(carEjecuCuent == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		carEjecuCuent.setPaisOidPais(paisOidPaisData);
		carEjecuCuent.setCodEjecCuen(
			(java.lang.String)FormatUtils.parseObject(codEjecCuen, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.CarJerarData jeraOidJeraData = null;
		if(jeraOidJera != null && !jeraOidJera.trim().equals("")){
			jeraOidJeraData = new es.indra.belcorp.mso.CarJerarData();
			jeraOidJeraData.setId(new Integer(jeraOidJera));
		}
		carEjecuCuent.setJeraOidJera(jeraOidJeraData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en druida no hay bloqueos.....
		//carEjecuCuent.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de realizar una modificaci�n
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("carEjecuCuent", carEjecuCuent);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Update de entidad CarEjecuCuent");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecuci�n Update de entidad CarEjecuCuent");
		
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
			CarEjecuCuentData carEjecuCuent = new CarEjecuCuentData();
			carEjecuCuent.setId(new Integer(claves.nextToken()));
			//carEjecuCuent.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(carEjecuCuent);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Remove de entidad CarEjecuCuent");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecuci�n Remove de entidad CarEjecuCuent");

		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp y requery
		conectorAction("CarEjecuCuentLPStartUp");
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


