

/*
    INDRA/CAR/mmg
    $Id: ZonDivisPolitLPExecution.java,v 1.1 2009/12/03 18:39:04 pecbazalar Exp $
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

public class ZonDivisPolitLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGZonDivisPolitCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGZonDivisPolitUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGZonDivisPolitRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGZonDivisPolitQueryFromToUserPage";	
	public static final String CONECTOR_CREATE = "ZonDivisPolitConectorCreate";
	public static final String CONECTOR_UPDATE = "ZonDivisPolitConectorUpdate";
	public static final String CONECTOR_REMOVE = "ZonDivisPolitConectorRemove";

	public ZonDivisPolitLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("ZonDivisPolitPage");
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
  	correspondiente a la creación de un/a nuevo ZonDivisPolit*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando ZonDivisPolit");
		
		String codDiviPoli = conectorParametro("codDiviPoli").trim();
		traza("MMG:: Valor de atributo codDiviPoli: " + codDiviPoli);
		
		String orde = conectorParametro("orde").trim();
		traza("MMG:: Valor de atributo orde: " + orde);
		
	
		//Construimos el mso con los elementos de la búsqueda
		ZonDivisPolitData zonDivisPolit= new ZonDivisPolitData();
		
		zonDivisPolit.setCodDiviPoli(
			(java.lang.String)FormatUtils.parseObject(codDiviPoli, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonDivisPolit.setOrde(
			(java.lang.String)FormatUtils.parseObject(orde, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonDivisPolit", zonDivisPolit);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad ZonDivisPolit");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad ZonDivisPolit");
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("ZonDivisPolitLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando ZonDivisPolit");
		
		String codDiviPoli = conectorParametro("codDiviPoli").trim();
		traza("MMG:: Valor de atributo codDiviPoli: " + codDiviPoli);
		
		String orde = conectorParametro("orde").trim();
		traza("MMG:: Valor de atributo orde: " + orde);
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		ZonDivisPolitData zonDivisPolit= new ZonDivisPolitData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			zonDivisPolit.setId(new Integer(id));
		}
		zonDivisPolit = (ZonDivisPolitData)getSingleObject(BUSINESSID_QUERY, zonDivisPolit, 
			zonDivisPolit.clone(), "zonDivisPolit");
		if(zonDivisPolit == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		zonDivisPolit.setCodDiviPoli(
			(java.lang.String)FormatUtils.parseObject(codDiviPoli, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonDivisPolit.setOrde(
			(java.lang.String)FormatUtils.parseObject(orde, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en druida no hay bloqueos.....
		//zonDivisPolit.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonDivisPolit", zonDivisPolit);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad ZonDivisPolit");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad ZonDivisPolit");
		
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
			ZonDivisPolitData zonDivisPolit = new ZonDivisPolitData();
			zonDivisPolit.setId(new Integer(claves.nextToken()));
			//zonDivisPolit.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(zonDivisPolit);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad ZonDivisPolit");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad ZonDivisPolit");

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("ZonDivisPolitLPStartUp");
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


