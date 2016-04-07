

/*
    INDRA/CAR/mmg
    $Id: EduPlantCursoEstatLPExecution.java,v 1.1 2009/12/03 18:41:52 pecbazalar Exp $
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

public class EduPlantCursoEstatLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGEduPlantCursoEstatCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGEduPlantCursoEstatUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGEduPlantCursoEstatRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGEduPlantCursoEstatQueryFromToUserPage";	
	public static final String CONECTOR_CREATE = "EduPlantCursoEstatConectorCreate";
	public static final String CONECTOR_UPDATE = "EduPlantCursoEstatConectorUpdate";
	public static final String CONECTOR_REMOVE = "EduPlantCursoEstatConectorRemove";

	public EduPlantCursoEstatLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("EduPlantCursoEstatPage");
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
  	correspondiente a la creación de un/a nuevo EduPlantCursoEstat*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando EduPlantCursoEstat");
		
		String mcurOidCurs = conectorParametro("mcurOidCurs").trim();
		traza("MMG:: Valor de atributo mcurOidCurs: " + mcurOidCurs);
		
		String dpcuOidDetaPlanCurs = conectorParametro("dpcuOidDetaPlanCurs").trim();
		traza("MMG:: Valor de atributo dpcuOidDetaPlanCurs: " + dpcuOidDetaPlanCurs);
		
	
		//Construimos el mso con los elementos de la búsqueda
		EduPlantCursoEstatData eduPlantCursoEstat= new EduPlantCursoEstatData();
		
		
		es.indra.belcorp.mso.EduMatriCursoData mcurOidCursData = null;
		if(mcurOidCurs != null && !mcurOidCurs.trim().equals("")){
			mcurOidCursData = new es.indra.belcorp.mso.EduMatriCursoData();
			mcurOidCursData.setId(new Integer(mcurOidCurs));
		}
		eduPlantCursoEstat.setMcurOidCurs(mcurOidCursData);
		
		es.indra.belcorp.mso.EduPlantCursoDetalData dpcuOidDetaPlanCursData = null;
		if(dpcuOidDetaPlanCurs != null && !dpcuOidDetaPlanCurs.trim().equals("")){
			dpcuOidDetaPlanCursData = new es.indra.belcorp.mso.EduPlantCursoDetalData();
			dpcuOidDetaPlanCursData.setId(new Integer(dpcuOidDetaPlanCurs));
		}
		eduPlantCursoEstat.setDpcuOidDetaPlanCurs(dpcuOidDetaPlanCursData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("eduPlantCursoEstat", eduPlantCursoEstat);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad EduPlantCursoEstat");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad EduPlantCursoEstat");
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("EduPlantCursoEstatLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando EduPlantCursoEstat");
		
		String mcurOidCurs = conectorParametro("mcurOidCurs").trim();
		traza("MMG:: Valor de atributo mcurOidCurs: " + mcurOidCurs);
		
		String dpcuOidDetaPlanCurs = conectorParametro("dpcuOidDetaPlanCurs").trim();
		traza("MMG:: Valor de atributo dpcuOidDetaPlanCurs: " + dpcuOidDetaPlanCurs);
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		EduPlantCursoEstatData eduPlantCursoEstat= new EduPlantCursoEstatData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			eduPlantCursoEstat.setId(new Integer(id));
		}
		eduPlantCursoEstat = (EduPlantCursoEstatData)getSingleObject(BUSINESSID_QUERY, eduPlantCursoEstat, 
			eduPlantCursoEstat.clone(), "eduPlantCursoEstat");
		if(eduPlantCursoEstat == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.EduMatriCursoData mcurOidCursData = null;
		if(mcurOidCurs != null && !mcurOidCurs.trim().equals("")){
			mcurOidCursData = new es.indra.belcorp.mso.EduMatriCursoData();
			mcurOidCursData.setId(new Integer(mcurOidCurs));
		}
		eduPlantCursoEstat.setMcurOidCurs(mcurOidCursData);
		es.indra.belcorp.mso.EduPlantCursoDetalData dpcuOidDetaPlanCursData = null;
		if(dpcuOidDetaPlanCurs != null && !dpcuOidDetaPlanCurs.trim().equals("")){
			dpcuOidDetaPlanCursData = new es.indra.belcorp.mso.EduPlantCursoDetalData();
			dpcuOidDetaPlanCursData.setId(new Integer(dpcuOidDetaPlanCurs));
		}
		eduPlantCursoEstat.setDpcuOidDetaPlanCurs(dpcuOidDetaPlanCursData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en druida no hay bloqueos.....
		//eduPlantCursoEstat.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("eduPlantCursoEstat", eduPlantCursoEstat);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad EduPlantCursoEstat");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad EduPlantCursoEstat");
		
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
			EduPlantCursoEstatData eduPlantCursoEstat = new EduPlantCursoEstatData();
			eduPlantCursoEstat.setId(new Integer(claves.nextToken()));
			//eduPlantCursoEstat.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(eduPlantCursoEstat);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad EduPlantCursoEstat");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad EduPlantCursoEstat");

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("EduPlantCursoEstatLPStartUp");
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


