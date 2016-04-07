

/*
    INDRA/CAR/mmg
    $Id: EduAptasCursoLPExecution.java,v 1.1 2009/12/03 18:36:22 pecbazalar Exp $
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

public class EduAptasCursoLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGEduAptasCursoCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGEduAptasCursoUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGEduAptasCursoRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGEduAptasCursoQueryFromToUserPage";	
	public static final String CONECTOR_CREATE = "EduAptasCursoConectorCreate";
	public static final String CONECTOR_UPDATE = "EduAptasCursoConectorUpdate";
	public static final String CONECTOR_REMOVE = "EduAptasCursoConectorRemove";

	public EduAptasCursoLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("EduAptasCursoPage");
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
  	correspondiente a la creación de un/a nuevo EduAptasCurso*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando EduAptasCurso");
		
		String ctsuOidClieTipoSubt = conectorParametro("ctsuOidClieTipoSubt").trim();
		traza("MMG:: Valor de atributo ctsuOidClieTipoSubt: " + ctsuOidClieTipoSubt);
		
		String mcurOidCurs = conectorParametro("mcurOidCurs").trim();
		traza("MMG:: Valor de atributo mcurOidCurs: " + mcurOidCurs);
		
		String fecAsis = conectorParametro("fecAsis").trim();
		traza("MMG:: Valor de atributo fecAsis: " + fecAsis);
		
		String indAcceDmrt = conectorParametro("indAcceDmrt").trim();
		traza("MMG:: Valor de atributo indAcceDmrt: " + indAcceDmrt);
		
		String indAptaCurs = conectorParametro("indAptaCurs").trim();
		traza("MMG:: Valor de atributo indAptaCurs: " + indAptaCurs);
		
		String indInvi = conectorParametro("indInvi").trim();
		traza("MMG:: Valor de atributo indInvi: " + indInvi);
		
		String indAsis = conectorParametro("indAsis").trim();
		traza("MMG:: Valor de atributo indAsis: " + indAsis);
		
		String indPrue = conectorParametro("indPrue").trim();
		traza("MMG:: Valor de atributo indPrue: " + indPrue);
		
	
		//Construimos el mso con los elementos de la búsqueda
		EduAptasCursoData eduAptasCurso= new EduAptasCursoData();
		
		
		es.indra.belcorp.mso.MaeClienTipoSubtiData ctsuOidClieTipoSubtData = null;
		if(ctsuOidClieTipoSubt != null && !ctsuOidClieTipoSubt.trim().equals("")){
			ctsuOidClieTipoSubtData = new es.indra.belcorp.mso.MaeClienTipoSubtiData();
			ctsuOidClieTipoSubtData.setId(new Integer(ctsuOidClieTipoSubt));
		}
		eduAptasCurso.setCtsuOidClieTipoSubt(ctsuOidClieTipoSubtData);
		
		es.indra.belcorp.mso.EduMatriCursoData mcurOidCursData = null;
		if(mcurOidCurs != null && !mcurOidCurs.trim().equals("")){
			mcurOidCursData = new es.indra.belcorp.mso.EduMatriCursoData();
			mcurOidCursData.setId(new Integer(mcurOidCurs));
		}
		eduAptasCurso.setMcurOidCurs(mcurOidCursData);
		eduAptasCurso.setFecAsis(
			(java.sql.Date)FormatUtils.parseObject(fecAsis, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduAptasCurso.setIndAcceDmrt(
			(java.lang.Integer)FormatUtils.parseObject(indAcceDmrt, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduAptasCurso.setIndAptaCurs(
			(java.lang.Integer)FormatUtils.parseObject(indAptaCurs, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduAptasCurso.setIndInvi(
			(java.lang.Integer)FormatUtils.parseObject(indInvi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduAptasCurso.setIndAsis(
			(java.lang.Integer)FormatUtils.parseObject(indAsis, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduAptasCurso.setIndPrue(
			(java.lang.Integer)FormatUtils.parseObject(indPrue, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("eduAptasCurso", eduAptasCurso);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad EduAptasCurso");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad EduAptasCurso");
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("EduAptasCursoLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando EduAptasCurso");
		
		String ctsuOidClieTipoSubt = conectorParametro("ctsuOidClieTipoSubt").trim();
		traza("MMG:: Valor de atributo ctsuOidClieTipoSubt: " + ctsuOidClieTipoSubt);
		
		String mcurOidCurs = conectorParametro("mcurOidCurs").trim();
		traza("MMG:: Valor de atributo mcurOidCurs: " + mcurOidCurs);
		
		String fecAsis = conectorParametro("fecAsis").trim();
		traza("MMG:: Valor de atributo fecAsis: " + fecAsis);
		
		String indAcceDmrt = conectorParametro("indAcceDmrt").trim();
		traza("MMG:: Valor de atributo indAcceDmrt: " + indAcceDmrt);
		
		String indAptaCurs = conectorParametro("indAptaCurs").trim();
		traza("MMG:: Valor de atributo indAptaCurs: " + indAptaCurs);
		
		String indInvi = conectorParametro("indInvi").trim();
		traza("MMG:: Valor de atributo indInvi: " + indInvi);
		
		String indAsis = conectorParametro("indAsis").trim();
		traza("MMG:: Valor de atributo indAsis: " + indAsis);
		
		String indPrue = conectorParametro("indPrue").trim();
		traza("MMG:: Valor de atributo indPrue: " + indPrue);
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		EduAptasCursoData eduAptasCurso= new EduAptasCursoData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			eduAptasCurso.setId(new Integer(id));
		}
		eduAptasCurso = (EduAptasCursoData)getSingleObject(BUSINESSID_QUERY, eduAptasCurso, 
			eduAptasCurso.clone(), "eduAptasCurso");
		if(eduAptasCurso == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.MaeClienTipoSubtiData ctsuOidClieTipoSubtData = null;
		if(ctsuOidClieTipoSubt != null && !ctsuOidClieTipoSubt.trim().equals("")){
			ctsuOidClieTipoSubtData = new es.indra.belcorp.mso.MaeClienTipoSubtiData();
			ctsuOidClieTipoSubtData.setId(new Integer(ctsuOidClieTipoSubt));
		}
		eduAptasCurso.setCtsuOidClieTipoSubt(ctsuOidClieTipoSubtData);
		es.indra.belcorp.mso.EduMatriCursoData mcurOidCursData = null;
		if(mcurOidCurs != null && !mcurOidCurs.trim().equals("")){
			mcurOidCursData = new es.indra.belcorp.mso.EduMatriCursoData();
			mcurOidCursData.setId(new Integer(mcurOidCurs));
		}
		eduAptasCurso.setMcurOidCurs(mcurOidCursData);
		eduAptasCurso.setFecAsis(
			(java.sql.Date)FormatUtils.parseObject(fecAsis, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduAptasCurso.setIndAcceDmrt(
			(java.lang.Integer)FormatUtils.parseObject(indAcceDmrt, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduAptasCurso.setIndAptaCurs(
			(java.lang.Integer)FormatUtils.parseObject(indAptaCurs, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduAptasCurso.setIndInvi(
			(java.lang.Integer)FormatUtils.parseObject(indInvi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduAptasCurso.setIndAsis(
			(java.lang.Integer)FormatUtils.parseObject(indAsis, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduAptasCurso.setIndPrue(
			(java.lang.Integer)FormatUtils.parseObject(indPrue, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en druida no hay bloqueos.....
		//eduAptasCurso.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("eduAptasCurso", eduAptasCurso);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad EduAptasCurso");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad EduAptasCurso");
		
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
			EduAptasCursoData eduAptasCurso = new EduAptasCursoData();
			eduAptasCurso.setId(new Integer(claves.nextToken()));
			//eduAptasCurso.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(eduAptasCurso);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad EduAptasCurso");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad EduAptasCurso");

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("EduAptasCursoLPStartUp");
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


