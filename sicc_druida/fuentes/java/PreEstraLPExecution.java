

/*
    INDRA/CAR/mmg
    $Id: PreEstraLPExecution.java,v 1.1 2009/12/03 18:37:50 pecbazalar Exp $
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

public class PreEstraLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGPreEstraCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGPreEstraUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGPreEstraRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGPreEstraQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "PreEstraConectorCreate";
	public static final String CONECTOR_UPDATE = "PreEstraConectorUpdate";
	public static final String CONECTOR_REMOVE = "PreEstraConectorRemove";

	public PreEstraLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("PreEstraPage");
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
  	correspondiente a la creación de un/a nuevo PreEstra*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando PreEstra");
		
		String codEstr = conectorParametro("codEstr").trim();
		traza("MMG:: Valor de atributo codEstr: " + codEstr);
		if(codEstr != null && !codEstr.trim().equals("")) codEstr = codEstr.toUpperCase();
		
		String tiesOidTipoEstr = conectorParametro("tiesOidTipoEstr").trim();
		traza("MMG:: Valor de atributo tiesOidTipoEstr: " + tiesOidTipoEstr);
		if(tiesOidTipoEstr != null && !tiesOidTipoEstr.trim().equals("")) tiesOidTipoEstr = tiesOidTipoEstr.toUpperCase();
		
		String numMaxiGrup = conectorParametro("numMaxiGrup").trim();
		traza("MMG:: Valor de atributo numMaxiGrup: " + numMaxiGrup);
		if(numMaxiGrup != null && !numMaxiGrup.trim().equals("")) numMaxiGrup = numMaxiGrup.toUpperCase();
		
		String numMaxiGrupCndt = conectorParametro("numMaxiGrupCndt").trim();
		traza("MMG:: Valor de atributo numMaxiGrupCndt: " + numMaxiGrupCndt);
		if(numMaxiGrupCndt != null && !numMaxiGrupCndt.trim().equals("")) numMaxiGrupCndt = numMaxiGrupCndt.toUpperCase();
		
		String numMaxiGrupCndo = conectorParametro("numMaxiGrupCndo").trim();
		traza("MMG:: Valor de atributo numMaxiGrupCndo: " + numMaxiGrupCndo);
		if(numMaxiGrupCndo != null && !numMaxiGrupCndo.trim().equals("")) numMaxiGrupCndo = numMaxiGrupCndo.toUpperCase();
		
		String indListRank = conectorParametro("indListRank").trim();
		traza("MMG:: Valor de atributo indListRank: " + indListRank);
		if(indListRank != null && !indListRank.trim().equals("")) indListRank = indListRank.toUpperCase();
		
		String indCuadGrup = conectorParametro("indCuadGrup").trim();
		traza("MMG:: Valor de atributo indCuadGrup: " + indCuadGrup);
		if(indCuadGrup != null && !indCuadGrup.trim().equals("")) indCuadGrup = indCuadGrup.toUpperCase();
		
		String tiprOidTipoProd = conectorParametro("tiprOidTipoProd").trim();
		traza("MMG:: Valor de atributo tiprOidTipoProd: " + tiprOidTipoProd);
		if(tiprOidTipoProd != null && !tiprOidTipoProd.trim().equals("")) tiprOidTipoProd = tiprOidTipoProd.toUpperCase();
		
		String indCvImpr = conectorParametro("indCvImpr").trim();
		traza("MMG:: Valor de atributo indCvImpr: " + indCvImpr);
		if(indCvImpr != null && !indCvImpr.trim().equals("")) indCvImpr = indCvImpr.toUpperCase();
		
		String indModiImpr = conectorParametro("indModiImpr").trim();
		traza("MMG:: Valor de atributo indModiImpr: " + indModiImpr);
		if(indModiImpr != null && !indModiImpr.trim().equals("")) indModiImpr = indModiImpr.toUpperCase();
		
		String indCvDespAuto = conectorParametro("indCvDespAuto").trim();
		traza("MMG:: Valor de atributo indCvDespAuto: " + indCvDespAuto);
		if(indCvDespAuto != null && !indCvDespAuto.trim().equals("")) indCvDespAuto = indCvDespAuto.toUpperCase();
		
		String indModiDesp = conectorParametro("indModiDesp").trim();
		traza("MMG:: Valor de atributo indModiDesp: " + indModiDesp);
		if(indModiDesp != null && !indModiDesp.trim().equals("")) indModiDesp = indModiDesp.toUpperCase();
		
		String indCvDigi = conectorParametro("indCvDigi").trim();
		traza("MMG:: Valor de atributo indCvDigi: " + indCvDigi);
		if(indCvDigi != null && !indCvDigi.trim().equals("")) indCvDigi = indCvDigi.toUpperCase();
		
		String indModiDigi = conectorParametro("indModiDigi").trim();
		traza("MMG:: Valor de atributo indModiDigi: " + indModiDigi);
		if(indModiDigi != null && !indModiDigi.trim().equals("")) indModiDigi = indModiDigi.toUpperCase();
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		PreEstraData preEstra= new PreEstraData();
		preEstra.setCodEstr(
			(java.lang.String)FormatUtils.parseObject(codEstr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.PreTipoEstraData tiesOidTipoEstrData = null;
		if(tiesOidTipoEstr != null && !tiesOidTipoEstr.trim().equals("")){
			tiesOidTipoEstrData = new es.indra.belcorp.mso.PreTipoEstraData();
			tiesOidTipoEstrData.setId(new Integer(tiesOidTipoEstr));
		}
		preEstra.setTiesOidTipoEstr(tiesOidTipoEstrData);
		preEstra.setNumMaxiGrup(
			(java.lang.Integer)FormatUtils.parseObject(numMaxiGrup, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setNumMaxiGrupCndt(
			(java.lang.Integer)FormatUtils.parseObject(numMaxiGrupCndt, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setNumMaxiGrupCndo(
			(java.lang.Integer)FormatUtils.parseObject(numMaxiGrupCndo, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setIndListRank(
			(java.lang.Boolean)FormatUtils.parseObject(indListRank.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setIndCuadGrup(
			(java.lang.Boolean)FormatUtils.parseObject(indCuadGrup.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.PreTipoProduData tiprOidTipoProdData = null;
		if(tiprOidTipoProd != null && !tiprOidTipoProd.trim().equals("")){
			tiprOidTipoProdData = new es.indra.belcorp.mso.PreTipoProduData();
			tiprOidTipoProdData.setId(new Integer(tiprOidTipoProd));
		}
		preEstra.setTiprOidTipoProd(tiprOidTipoProdData);
		preEstra.setIndCvImpr(
			(java.lang.Boolean)FormatUtils.parseObject(indCvImpr.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setIndModiImpr(
			(java.lang.Boolean)FormatUtils.parseObject(indModiImpr.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setIndCvDespAuto(
			(java.lang.Boolean)FormatUtils.parseObject(indCvDespAuto.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setIndModiDesp(
			(java.lang.Boolean)FormatUtils.parseObject(indModiDesp.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setIndCvDigi(
			(java.lang.Boolean)FormatUtils.parseObject(indCvDigi.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setIndModiDigi(
			(java.lang.Boolean)FormatUtils.parseObject(indModiDigi.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("preEstra", preEstra);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(preEstra);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad PreEstra");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad PreEstra");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(preEstra);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("PreEstraLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando PreEstra");
		
		String numMaxiGrup = conectorParametro("numMaxiGrup").trim();
		traza("MMG:: Valor de atributo numMaxiGrup: " + numMaxiGrup);
		if(numMaxiGrup != null && !numMaxiGrup.trim().equals("")) numMaxiGrup = numMaxiGrup.toUpperCase();
		
		String numMaxiGrupCndt = conectorParametro("numMaxiGrupCndt").trim();
		traza("MMG:: Valor de atributo numMaxiGrupCndt: " + numMaxiGrupCndt);
		if(numMaxiGrupCndt != null && !numMaxiGrupCndt.trim().equals("")) numMaxiGrupCndt = numMaxiGrupCndt.toUpperCase();
		
		String numMaxiGrupCndo = conectorParametro("numMaxiGrupCndo").trim();
		traza("MMG:: Valor de atributo numMaxiGrupCndo: " + numMaxiGrupCndo);
		if(numMaxiGrupCndo != null && !numMaxiGrupCndo.trim().equals("")) numMaxiGrupCndo = numMaxiGrupCndo.toUpperCase();
		
		String indListRank = conectorParametro("indListRank").trim();
		traza("MMG:: Valor de atributo indListRank: " + indListRank);
		if(indListRank != null && !indListRank.trim().equals("")) indListRank = indListRank.toUpperCase();
		
		String indCuadGrup = conectorParametro("indCuadGrup").trim();
		traza("MMG:: Valor de atributo indCuadGrup: " + indCuadGrup);
		if(indCuadGrup != null && !indCuadGrup.trim().equals("")) indCuadGrup = indCuadGrup.toUpperCase();
		
		String tiprOidTipoProd = conectorParametro("tiprOidTipoProd").trim();
		traza("MMG:: Valor de atributo tiprOidTipoProd: " + tiprOidTipoProd);
		if(tiprOidTipoProd != null && !tiprOidTipoProd.trim().equals("")) tiprOidTipoProd = tiprOidTipoProd.toUpperCase();
		
		String indCvImpr = conectorParametro("indCvImpr").trim();
		traza("MMG:: Valor de atributo indCvImpr: " + indCvImpr);
		if(indCvImpr != null && !indCvImpr.trim().equals("")) indCvImpr = indCvImpr.toUpperCase();
		
		String indModiImpr = conectorParametro("indModiImpr").trim();
		traza("MMG:: Valor de atributo indModiImpr: " + indModiImpr);
		if(indModiImpr != null && !indModiImpr.trim().equals("")) indModiImpr = indModiImpr.toUpperCase();
		
		String indCvDespAuto = conectorParametro("indCvDespAuto").trim();
		traza("MMG:: Valor de atributo indCvDespAuto: " + indCvDespAuto);
		if(indCvDespAuto != null && !indCvDespAuto.trim().equals("")) indCvDespAuto = indCvDespAuto.toUpperCase();
		
		String indModiDesp = conectorParametro("indModiDesp").trim();
		traza("MMG:: Valor de atributo indModiDesp: " + indModiDesp);
		if(indModiDesp != null && !indModiDesp.trim().equals("")) indModiDesp = indModiDesp.toUpperCase();
		
		String indCvDigi = conectorParametro("indCvDigi").trim();
		traza("MMG:: Valor de atributo indCvDigi: " + indCvDigi);
		if(indCvDigi != null && !indCvDigi.trim().equals("")) indCvDigi = indCvDigi.toUpperCase();
		
		String indModiDigi = conectorParametro("indModiDigi").trim();
		traza("MMG:: Valor de atributo indModiDigi: " + indModiDigi);
		if(indModiDigi != null && !indModiDigi.trim().equals("")) indModiDigi = indModiDigi.toUpperCase();
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		PreEstraData preEstra= new PreEstraData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			preEstra.setId(new Integer(id));
		}
		preEstra = (PreEstraData)getSingleObject(BUSINESSID_QUERY, preEstra, 
			preEstra.clone(), "preEstra");
		
		if(preEstra == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		preEstra.setNumMaxiGrup(
			(java.lang.Integer)FormatUtils.parseObject(numMaxiGrup, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setNumMaxiGrupCndt(
			(java.lang.Integer)FormatUtils.parseObject(numMaxiGrupCndt, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setNumMaxiGrupCndo(
			(java.lang.Integer)FormatUtils.parseObject(numMaxiGrupCndo, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setIndListRank(
			(java.lang.Boolean)FormatUtils.parseObject(indListRank.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setIndCuadGrup(
			(java.lang.Boolean)FormatUtils.parseObject(indCuadGrup.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.PreTipoProduData tiprOidTipoProdData = null;
		if(tiprOidTipoProd != null && !tiprOidTipoProd.trim().equals("")){
			tiprOidTipoProdData = new es.indra.belcorp.mso.PreTipoProduData();
			tiprOidTipoProdData.setId(new Integer(tiprOidTipoProd));
		}
		preEstra.setTiprOidTipoProd(tiprOidTipoProdData);
		preEstra.setIndCvImpr(
			(java.lang.Boolean)FormatUtils.parseObject(indCvImpr.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setIndModiImpr(
			(java.lang.Boolean)FormatUtils.parseObject(indModiImpr.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setIndCvDespAuto(
			(java.lang.Boolean)FormatUtils.parseObject(indCvDespAuto.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setIndModiDesp(
			(java.lang.Boolean)FormatUtils.parseObject(indModiDesp.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setIndCvDigi(
			(java.lang.Boolean)FormatUtils.parseObject(indCvDigi.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preEstra.setIndModiDigi(
			(java.lang.Boolean)FormatUtils.parseObject(indModiDigi.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//preEstra.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("preEstra", preEstra);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(preEstra);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad PreEstra");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad PreEstra");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(preEstra);
		
		
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
			PreEstraData preEstra = new PreEstraData();
			preEstra.setId(new Integer(claves.nextToken()));
			//preEstra.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(preEstra);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad PreEstra");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad PreEstra");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("PreEstraLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		for(int i=0; i < languages.size(); i++){
			Idioma languageTmp = (Idioma)languages.get(i);
			String value = conectorParametro("hi18NTraduccion_1_" + 
				languageTmp.getOid().intValue());
			if(value == null || value.trim().equals("")) continue;
			
			GenDetaSiccData label = new GenDetaSiccData();
			label.setAtri(new Integer(1));
			SegIdiomData language = new SegIdiomData();
			language.setId(new Integer(languageTmp.getOid().intValue()));
			label.setIdioOidIdio(language);
			label.setEnti("PRE_ESTRA");
			label.setDeta(value != null? value: "");
			localizationLabels.add(label);
		}
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(PreEstraData preEstra) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Integer(MMGDruidaHelper.getUserDefaultCountry(this)));preEstra.setPaisOidPais(paisOculto);
	}
	

	protected void cmdPreUpdate(PreEstraData preEstra) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Integer(MMGDruidaHelper.getUserDefaultCountry(this)));preEstra.setPaisOidPais(paisOculto);
	}
	
	
	

	protected void cmdPostCreate(PreEstraData preEstra) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Integer(MMGDruidaHelper.getUserDefaultCountry(this)));preEstra.setPaisOidPais(paisOculto);
	}
	

	protected void cmdPostUpdate(PreEstraData preEstra) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Integer(MMGDruidaHelper.getUserDefaultCountry(this)));preEstra.setPaisOidPais(paisOculto);
	}
	
	
	
	
}




