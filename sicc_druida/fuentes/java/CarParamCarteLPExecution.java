

/*
    INDRA/CAR/mmg
    $Id: CarParamCarteLPExecution.java,v 1.1 2009/12/03 18:39:51 pecbazalar Exp $
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

public class CarParamCarteLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCarParamCarteCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCarParamCarteUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCarParamCarteRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCarParamCarteQueryFromToUserPage";	
	public static final String CONECTOR_CREATE = "CarParamCarteConectorCreate";
	public static final String CONECTOR_UPDATE = "CarParamCarteConectorUpdate";
	public static final String CONECTOR_REMOVE = "CarParamCarteConectorRemove";

	public CarParamCarteLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CarParamCartePage");
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
  	correspondiente a la creación de un/a nuevo CarParamCarte*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando CarParamCarte");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String grsoOidGrupSoli = conectorParametro("grsoOidGrupSoli").trim();
		traza("MMG:: Valor de atributo grsoOidGrupSoli: " + grsoOidGrupSoli);
		
		String niriOidNiveRies = conectorParametro("niriOidNiveRies").trim();
		traza("MMG:: Valor de atributo niriOidNiveRies: " + niriOidNiveRies);
		
		String codConf = conectorParametro("codConf").trim();
		traza("MMG:: Valor de atributo codConf: " + codConf);
		
		String indDeudVenc = conectorParametro("indDeudVenc").trim();
		traza("MMG:: Valor de atributo indDeudVenc: " + indDeudVenc);
		
		String numDiasDeudVenc = conectorParametro("numDiasDeudVenc").trim();
		traza("MMG:: Valor de atributo numDiasDeudVenc: " + numDiasDeudVenc);
		
		String indLineCred = conectorParametro("indLineCred").trim();
		traza("MMG:: Valor de atributo indLineCred: " + indLineCred);
		
		String fecVigeDesd = conectorParametro("fecVigeDesd").trim();
		traza("MMG:: Valor de atributo fecVigeDesd: " + fecVigeDesd);
		
		String fecVigeHast = conectorParametro("fecVigeHast").trim();
		traza("MMG:: Valor de atributo fecVigeHast: " + fecVigeHast);
		
		String valPorcVali = conectorParametro("valPorcVali").trim();
		traza("MMG:: Valor de atributo valPorcVali: " + valPorcVali);
		
		String indVali = conectorParametro("indVali").trim();
		traza("MMG:: Valor de atributo indVali: " + indVali);
		
		String indMontMaxi = conectorParametro("indMontMaxi").trim();
		traza("MMG:: Valor de atributo indMontMaxi: " + indMontMaxi);
		
		String valMontMaxiPerm = conectorParametro("valMontMaxiPerm").trim();
		traza("MMG:: Valor de atributo valMontMaxiPerm: " + valMontMaxiPerm);
		
		String indPorcMaxi = conectorParametro("indPorcMaxi").trim();
		traza("MMG:: Valor de atributo indPorcMaxi: " + indPorcMaxi);
		
		String valPorc = conectorParametro("valPorc").trim();
		traza("MMG:: Valor de atributo valPorc: " + valPorc);
		
		String numDiasAdic = conectorParametro("numDiasAdic").trim();
		traza("MMG:: Valor de atributo numDiasAdic: " + numDiasAdic);
		
		String invaOidIndiVali = conectorParametro("invaOidIndiVali").trim();
		traza("MMG:: Valor de atributo invaOidIndiVali: " + invaOidIndiVali);
		
	
		//Construimos el mso con los elementos de la búsqueda
		CarParamCarteData carParamCarte= new CarParamCarteData();
		
		
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		carParamCarte.setPaisOidPais(paisOidPaisData);
		
		es.indra.belcorp.mso.CarGrupoSolicData grsoOidGrupSoliData = null;
		if(grsoOidGrupSoli != null && !grsoOidGrupSoli.trim().equals("")){
			grsoOidGrupSoliData = new es.indra.belcorp.mso.CarGrupoSolicData();
			grsoOidGrupSoliData.setId(new Integer(grsoOidGrupSoli));
		}
		carParamCarte.setGrsoOidGrupSoli(grsoOidGrupSoliData);
		
		es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesData = null;
		if(niriOidNiveRies != null && !niriOidNiveRies.trim().equals("")){
			niriOidNiveRiesData = new es.indra.belcorp.mso.CarNivelRiesgData();
			niriOidNiveRiesData.setId(new Integer(niriOidNiveRies));
		}
		carParamCarte.setNiriOidNiveRies(niriOidNiveRiesData);
		carParamCarte.setCodConf(
			(java.lang.String)FormatUtils.parseObject(codConf, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setIndDeudVenc(
			(java.lang.Integer)FormatUtils.parseObject(indDeudVenc, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setNumDiasDeudVenc(
			(java.lang.Integer)FormatUtils.parseObject(numDiasDeudVenc, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setIndLineCred(
			(java.lang.Integer)FormatUtils.parseObject(indLineCred, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setFecVigeDesd(
			(java.sql.Date)FormatUtils.parseObject(fecVigeDesd, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setFecVigeHast(
			(java.sql.Date)FormatUtils.parseObject(fecVigeHast, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setValPorcVali(
			(java.lang.Double)FormatUtils.parseObject(valPorcVali, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			 /*
		carParamCarte.setIndVali(
			(java.lang.String)FormatUtils.parseObject(indVali, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			 */
			 
		carParamCarte.setIndMontMaxi(
			(java.lang.Integer)FormatUtils.parseObject(indMontMaxi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setValMontMaxiPerm(
			(java.lang.Double)FormatUtils.parseObject(valMontMaxiPerm, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setIndPorcMaxi(
			(java.lang.Integer)FormatUtils.parseObject(indPorcMaxi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setValPorc(
			(java.lang.Double)FormatUtils.parseObject(valPorc, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setNumDiasAdic(
			(java.lang.Integer)FormatUtils.parseObject(numDiasAdic, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		es.indra.belcorp.mso.CarIndicValidData invaOidIndiValiData = null;
		if(invaOidIndiVali != null && !invaOidIndiVali.trim().equals("")){
			invaOidIndiValiData = new es.indra.belcorp.mso.CarIndicValidData();
			invaOidIndiValiData.setId(new Integer(invaOidIndiVali));
		}
		carParamCarte.setInvaOidIndiVali(invaOidIndiValiData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("carParamCarte", carParamCarte);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CarParamCarte");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CarParamCarte");
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CarParamCarteLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando CarParamCarte");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String grsoOidGrupSoli = conectorParametro("grsoOidGrupSoli").trim();
		traza("MMG:: Valor de atributo grsoOidGrupSoli: " + grsoOidGrupSoli);
		
		String niriOidNiveRies = conectorParametro("niriOidNiveRies").trim();
		traza("MMG:: Valor de atributo niriOidNiveRies: " + niriOidNiveRies);
		
		String codConf = conectorParametro("codConf").trim();
		traza("MMG:: Valor de atributo codConf: " + codConf);
		
		String indDeudVenc = conectorParametro("indDeudVenc").trim();
		traza("MMG:: Valor de atributo indDeudVenc: " + indDeudVenc);
		
		String numDiasDeudVenc = conectorParametro("numDiasDeudVenc").trim();
		traza("MMG:: Valor de atributo numDiasDeudVenc: " + numDiasDeudVenc);
		
		String indLineCred = conectorParametro("indLineCred").trim();
		traza("MMG:: Valor de atributo indLineCred: " + indLineCred);
		
		String fecVigeDesd = conectorParametro("fecVigeDesd").trim();
		traza("MMG:: Valor de atributo fecVigeDesd: " + fecVigeDesd);
		
		String fecVigeHast = conectorParametro("fecVigeHast").trim();
		traza("MMG:: Valor de atributo fecVigeHast: " + fecVigeHast);
		
		String valPorcVali = conectorParametro("valPorcVali").trim();
		traza("MMG:: Valor de atributo valPorcVali: " + valPorcVali);
		
		String indVali = conectorParametro("indVali").trim();
		traza("MMG:: Valor de atributo indVali: " + indVali);
		
		String indMontMaxi = conectorParametro("indMontMaxi").trim();
		traza("MMG:: Valor de atributo indMontMaxi: " + indMontMaxi);
		
		String valMontMaxiPerm = conectorParametro("valMontMaxiPerm").trim();
		traza("MMG:: Valor de atributo valMontMaxiPerm: " + valMontMaxiPerm);
		
		String indPorcMaxi = conectorParametro("indPorcMaxi").trim();
		traza("MMG:: Valor de atributo indPorcMaxi: " + indPorcMaxi);
		
		String valPorc = conectorParametro("valPorc").trim();
		traza("MMG:: Valor de atributo valPorc: " + valPorc);
		
		String numDiasAdic = conectorParametro("numDiasAdic").trim();
		traza("MMG:: Valor de atributo numDiasAdic: " + numDiasAdic);
		
		String invaOidIndiVali = conectorParametro("invaOidIndiVali").trim();
		traza("MMG:: Valor de atributo invaOidIndiVali: " + invaOidIndiVali);
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CarParamCarteData carParamCarte= new CarParamCarteData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			carParamCarte.setId(new Integer(id));
		}
		carParamCarte = (CarParamCarteData)getSingleObject(BUSINESSID_QUERY, carParamCarte, 
			carParamCarte.clone(), "carParamCarte");
		if(carParamCarte == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		carParamCarte.setPaisOidPais(paisOidPaisData);
		es.indra.belcorp.mso.CarGrupoSolicData grsoOidGrupSoliData = null;
		if(grsoOidGrupSoli != null && !grsoOidGrupSoli.trim().equals("")){
			grsoOidGrupSoliData = new es.indra.belcorp.mso.CarGrupoSolicData();
			grsoOidGrupSoliData.setId(new Integer(grsoOidGrupSoli));
		}
		carParamCarte.setGrsoOidGrupSoli(grsoOidGrupSoliData);
		es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesData = null;
		if(niriOidNiveRies != null && !niriOidNiveRies.trim().equals("")){
			niriOidNiveRiesData = new es.indra.belcorp.mso.CarNivelRiesgData();
			niriOidNiveRiesData.setId(new Integer(niriOidNiveRies));
		}
		carParamCarte.setNiriOidNiveRies(niriOidNiveRiesData);
		carParamCarte.setCodConf(
			(java.lang.String)FormatUtils.parseObject(codConf, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setIndDeudVenc(
			(java.lang.Integer)FormatUtils.parseObject(indDeudVenc, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setNumDiasDeudVenc(
			(java.lang.Integer)FormatUtils.parseObject(numDiasDeudVenc, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setIndLineCred(
			(java.lang.Integer)FormatUtils.parseObject(indLineCred, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setFecVigeDesd(
			(java.sql.Date)FormatUtils.parseObject(fecVigeDesd, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setFecVigeHast(
			(java.sql.Date)FormatUtils.parseObject(fecVigeHast, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setValPorcVali(
			(java.lang.Double)FormatUtils.parseObject(valPorcVali, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			 
			 /*
		carParamCarte.setIndVali(
			(java.lang.String)FormatUtils.parseObject(indVali, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			 */
			 
		carParamCarte.setIndMontMaxi(
			(java.lang.Integer)FormatUtils.parseObject(indMontMaxi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setValMontMaxiPerm(
			(java.lang.Double)FormatUtils.parseObject(valMontMaxiPerm, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setIndPorcMaxi(
			(java.lang.Integer)FormatUtils.parseObject(indPorcMaxi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setValPorc(
			(java.lang.Double)FormatUtils.parseObject(valPorc, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carParamCarte.setNumDiasAdic(
			(java.lang.Integer)FormatUtils.parseObject(numDiasAdic, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.CarIndicValidData invaOidIndiValiData = null;
		if(invaOidIndiVali != null && !invaOidIndiVali.trim().equals("")){
			invaOidIndiValiData = new es.indra.belcorp.mso.CarIndicValidData();
			invaOidIndiValiData.setId(new Integer(invaOidIndiVali));
		}
		carParamCarte.setInvaOidIndiVali(invaOidIndiValiData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en druida no hay bloqueos.....
		//carParamCarte.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("carParamCarte", carParamCarte);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CarParamCarte");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CarParamCarte");
		
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
			CarParamCarteData carParamCarte = new CarParamCarteData();
			carParamCarte.setId(new Integer(claves.nextToken()));
			//carParamCarte.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(carParamCarte);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CarParamCarte");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CarParamCarte");

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CarParamCarteLPStartUp");
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


