

/*
    INDRA/CAR/mmg
    $Id: CobMetodLiquiLPExecution.java,v 1.1 2009/12/03 18:38:45 pecbazalar Exp $
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
import java.util.HashMap;
import java.text.DecimalFormatSymbols;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.belcorp.mso.*;

public class CobMetodLiquiLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCobMetodLiquiCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCobMetodLiquiUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCobMetodLiquiRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCobMetodLiquiQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CobMetodLiquiConectorCreate";
	public static final String CONECTOR_UPDATE = "CobMetodLiquiConectorUpdate";
	public static final String CONECTOR_REMOVE = "CobMetodLiquiConectorRemove";

	public CobMetodLiquiLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CobMetodLiquiPage");
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
  	correspondiente a la creación de un/a nuevo CobMetodLiqui*/  
	protected void cmdCreate() throws Exception{
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		traza("datePattern" + datePattern);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator.charAt(0));
		symbols.setGroupingSeparator(separadorMiles.charAt(0));	
		
		traza("MMG::Creando CobMetodLiqui");
		
		String codMetoLiqu = conectorParametro("codMetoLiqu").trim();
		traza("MMG:: Valor de atributo codMetoLiqu: " + codMetoLiqu);
		if(codMetoLiqu != null && !codMetoLiqu.trim().equals("")) codMetoLiqu = codMetoLiqu.toUpperCase();
		
		String valDescMetoLiqu = conectorParametro("valDescMetoLiqu").trim();
		traza("MMG:: Valor de atributo valDescMetoLiqu: " + valDescMetoLiqu);
		
		String indLiqu = conectorParametro("indLiqu").trim();
		traza("MMG:: Valor de atributo indLiqu: " + indLiqu);
		
		String indLiquGrupUsua = conectorParametro("indLiquGrupUsua").trim();
		traza("MMG:: Valor de atributo indLiquGrupUsua: " + indLiquGrupUsua);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		String baesOidBaseEsca = conectorParametro("baesOidBaseEsca").trim();
		traza("MMG:: Valor de atributo baesOidBaseEsca: " + baesOidBaseEsca);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CobMetodLiquiData cobMetodLiqui= new CobMetodLiquiData();
		cobMetodLiqui.setCodMetoLiqu(
			(java.lang.String)FormatUtils.parseObject(codMetoLiqu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobMetodLiqui.setValDescMetoLiqu(
			(java.lang.String)FormatUtils.parseObject(valDescMetoLiqu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobMetodLiqui.setIndLiqu(
			(java.lang.Long)FormatUtils.parseObject(indLiqu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobMetodLiqui.setIndLiquGrupUsua(
			(java.lang.Long)FormatUtils.parseObject(indLiquGrupUsua, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobMetodLiqui.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CobBaseEscalData baesOidBaseEscaData = null;
		if(baesOidBaseEsca != null && !baesOidBaseEsca.trim().equals("")){
			baesOidBaseEscaData = new es.indra.belcorp.mso.CobBaseEscalData();
			baesOidBaseEscaData.setId(new Long(baesOidBaseEsca));
		}
		cobMetodLiqui.setBaesOidBaseEsca(baesOidBaseEscaData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobMetodLiqui", cobMetodLiqui);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(cobMetodLiqui);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CobMetodLiqui");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CobMetodLiqui");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(cobMetodLiqui);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CobMetodLiquiLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		traza("datePattern" + datePattern);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator.charAt(0));
		symbols.setGroupingSeparator(separadorMiles.charAt(0));	
		traza("MMG::Creando CobMetodLiqui");
		
		String codMetoLiqu = conectorParametro("codMetoLiqu").trim();
		traza("MMG:: Valor de atributo codMetoLiqu: " + codMetoLiqu);
		if(codMetoLiqu != null && !codMetoLiqu.trim().equals("")) codMetoLiqu = codMetoLiqu.toUpperCase();
		
		String valDescMetoLiqu = conectorParametro("valDescMetoLiqu").trim();
		traza("MMG:: Valor de atributo valDescMetoLiqu: " + valDescMetoLiqu);
		
		String indLiqu = conectorParametro("indLiqu").trim();
		traza("MMG:: Valor de atributo indLiqu: " + indLiqu);
		
		String indLiquGrupUsua = conectorParametro("indLiquGrupUsua").trim();
		traza("MMG:: Valor de atributo indLiquGrupUsua: " + indLiquGrupUsua);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		String baesOidBaseEsca = conectorParametro("baesOidBaseEsca").trim();
		traza("MMG:: Valor de atributo baesOidBaseEsca: " + baesOidBaseEsca);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CobMetodLiquiData cobMetodLiqui= new CobMetodLiquiData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			cobMetodLiqui.setId(new Long(id));
		}
		cobMetodLiqui = (CobMetodLiquiData)getSingleObject(BUSINESSID_QUERY, cobMetodLiqui, 
			cobMetodLiqui.clone(), "cobMetodLiqui");
		
		if(cobMetodLiqui == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		cobMetodLiqui.setCodMetoLiqu(
			(java.lang.String)FormatUtils.parseObject(codMetoLiqu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobMetodLiqui.setValDescMetoLiqu(
			(java.lang.String)FormatUtils.parseObject(valDescMetoLiqu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobMetodLiqui.setIndLiqu(
			(java.lang.Long)FormatUtils.parseObject(indLiqu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobMetodLiqui.setIndLiquGrupUsua(
			(java.lang.Long)FormatUtils.parseObject(indLiquGrupUsua, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobMetodLiqui.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CobBaseEscalData baesOidBaseEscaData = null;
		if(baesOidBaseEsca != null && !baesOidBaseEsca.trim().equals("")){
			baesOidBaseEscaData = new es.indra.belcorp.mso.CobBaseEscalData();
			baesOidBaseEscaData.setId(new Long(baesOidBaseEsca));
		}
		cobMetodLiqui.setBaesOidBaseEsca(baesOidBaseEscaData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//cobMetodLiqui.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobMetodLiqui", cobMetodLiqui);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(cobMetodLiqui);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CobMetodLiqui");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CobMetodLiqui");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(cobMetodLiqui);
		
		
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
			CobMetodLiquiData cobMetodLiqui = new CobMetodLiquiData();
			cobMetodLiqui.setId(new Long(claves.nextToken()));
			//cobMetodLiqui.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(cobMetodLiqui);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CobMetodLiqui");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CobMetodLiqui");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CobMetodLiquiLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(CobMetodLiquiData cobMetodLiqui) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobMetodLiqui.setPaisOidPais(paisOculto);
                
	}
	

	protected void cmdPreUpdate(CobMetodLiquiData cobMetodLiqui) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobMetodLiqui.setPaisOidPais(paisOculto);
                
	}
	
	
	

	protected void cmdPostCreate(CobMetodLiquiData cobMetodLiqui) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobMetodLiqui.setPaisOidPais(paisOculto);
                
	}
	

	protected void cmdPostUpdate(CobMetodLiquiData cobMetodLiqui) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobMetodLiqui.setPaisOidPais(paisOculto);
                
	}
	
	
	
	
}




