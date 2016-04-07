

/*
    INDRA/CAR/mmg
    $Id: EduHistoCursoLPExecution.java,v 1.1 2009/12/03 18:41:45 pecbazalar Exp $
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

public class EduHistoCursoLPExecution extends MMGDruidaBase{
	//Constantes de l�ogica de negocio
	public static final String BUSINESSID_CREATE= "MMGEduHistoCursoCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGEduHistoCursoUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGEduHistoCursoRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGEduHistoCursoQueryFromToUserPage";	
	public static final String CONECTOR_CREATE = "EduHistoCursoConectorCreate";
	public static final String CONECTOR_UPDATE = "EduHistoCursoConectorUpdate";
	public static final String CONECTOR_REMOVE = "EduHistoCursoConectorRemove";

	public EduHistoCursoLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("EduHistoCursoPage");
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
  	correspondiente a la creaci�n de un/a nuevo EduHistoCurso*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando EduHistoCurso");
		
		String ctsuOidClieTipoSubt = conectorParametro("ctsuOidClieTipoSubt").trim();
		traza("MMG:: Valor de atributo ctsuOidClieTipoSubt: " + ctsuOidClieTipoSubt);
		
		String mcurOidCurs = conectorParametro("mcurOidCurs").trim();
		traza("MMG:: Valor de atributo mcurOidCurs: " + mcurOidCurs);
		
		String indApta = conectorParametro("indApta").trim();
		traza("MMG:: Valor de atributo indApta: " + indApta);
		
		String indInvit = conectorParametro("indInvit").trim();
		traza("MMG:: Valor de atributo indInvit: " + indInvit);
		
		String indAsis = conectorParametro("indAsis").trim();
		traza("MMG:: Valor de atributo indAsis: " + indAsis);
		
	
		//Construimos el mso con los elementos de la b�squeda
		EduHistoCursoData eduHistoCurso= new EduHistoCursoData();
		
		
		es.indra.belcorp.mso.MaeClienTipoSubtiData ctsuOidClieTipoSubtData = null;
		if(ctsuOidClieTipoSubt != null && !ctsuOidClieTipoSubt.trim().equals("")){
			ctsuOidClieTipoSubtData = new es.indra.belcorp.mso.MaeClienTipoSubtiData();
			ctsuOidClieTipoSubtData.setId(new Integer(ctsuOidClieTipoSubt));
		}
		eduHistoCurso.setCtsuOidClieTipoSubt(ctsuOidClieTipoSubtData);
		
		es.indra.belcorp.mso.EduMatriCursoData mcurOidCursData = null;
		if(mcurOidCurs != null && !mcurOidCurs.trim().equals("")){
			mcurOidCursData = new es.indra.belcorp.mso.EduMatriCursoData();
			mcurOidCursData.setId(new Integer(mcurOidCurs));
		}
		eduHistoCurso.setMcurOidCurs(mcurOidCursData);
		eduHistoCurso.setIndApta(
			(java.lang.Integer)FormatUtils.parseObject(indApta, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduHistoCurso.setIndInvit(
			(java.lang.Integer)FormatUtils.parseObject(indInvit, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduHistoCurso.setIndAsis(
			(java.lang.Integer)FormatUtils.parseObject(indAsis, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("eduHistoCurso", eduHistoCurso);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Create de entidad EduHistoCurso");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecuci�n Create de entidad EduHistoCurso");
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp
		conectorAction("EduHistoCursoLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operaci�n de modificaci�n sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando EduHistoCurso");
		
		String ctsuOidClieTipoSubt = conectorParametro("ctsuOidClieTipoSubt").trim();
		traza("MMG:: Valor de atributo ctsuOidClieTipoSubt: " + ctsuOidClieTipoSubt);
		
		String mcurOidCurs = conectorParametro("mcurOidCurs").trim();
		traza("MMG:: Valor de atributo mcurOidCurs: " + mcurOidCurs);
		
		String indApta = conectorParametro("indApta").trim();
		traza("MMG:: Valor de atributo indApta: " + indApta);
		
		String indInvit = conectorParametro("indInvit").trim();
		traza("MMG:: Valor de atributo indInvit: " + indInvit);
		
		String indAsis = conectorParametro("indAsis").trim();
		traza("MMG:: Valor de atributo indAsis: " + indAsis);
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		EduHistoCursoData eduHistoCurso= new EduHistoCursoData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			eduHistoCurso.setId(new Integer(id));
		}
		eduHistoCurso = (EduHistoCursoData)getSingleObject(BUSINESSID_QUERY, eduHistoCurso, 
			eduHistoCurso.clone(), "eduHistoCurso");
		if(eduHistoCurso == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.MaeClienTipoSubtiData ctsuOidClieTipoSubtData = null;
		if(ctsuOidClieTipoSubt != null && !ctsuOidClieTipoSubt.trim().equals("")){
			ctsuOidClieTipoSubtData = new es.indra.belcorp.mso.MaeClienTipoSubtiData();
			ctsuOidClieTipoSubtData.setId(new Integer(ctsuOidClieTipoSubt));
		}
		eduHistoCurso.setCtsuOidClieTipoSubt(ctsuOidClieTipoSubtData);
		es.indra.belcorp.mso.EduMatriCursoData mcurOidCursData = null;
		if(mcurOidCurs != null && !mcurOidCurs.trim().equals("")){
			mcurOidCursData = new es.indra.belcorp.mso.EduMatriCursoData();
			mcurOidCursData.setId(new Integer(mcurOidCurs));
		}
		eduHistoCurso.setMcurOidCurs(mcurOidCursData);
		eduHistoCurso.setIndApta(
			(java.lang.Integer)FormatUtils.parseObject(indApta, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduHistoCurso.setIndInvit(
			(java.lang.Integer)FormatUtils.parseObject(indInvit, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduHistoCurso.setIndAsis(
			(java.lang.Integer)FormatUtils.parseObject(indAsis, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en druida no hay bloqueos.....
		//eduHistoCurso.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de realizar una modificaci�n
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("eduHistoCurso", eduHistoCurso);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Update de entidad EduHistoCurso");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecuci�n Update de entidad EduHistoCurso");
		
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
			EduHistoCursoData eduHistoCurso = new EduHistoCursoData();
			eduHistoCurso.setId(new Integer(claves.nextToken()));
			//eduHistoCurso.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(eduHistoCurso);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Remove de entidad EduHistoCurso");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecuci�n Remove de entidad EduHistoCurso");

		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp y requery
		conectorAction("EduHistoCursoLPStartUp");
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


