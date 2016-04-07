

/*
    INDRA/CAR/mmg
    $Id: BelTipoMovimAlmacLPExecution.java,v 1.1 2009/12/03 18:39:58 pecbazalar Exp $
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

public class BelTipoMovimAlmacLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGBelTipoMovimAlmacCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGBelTipoMovimAlmacUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGBelTipoMovimAlmacRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGBelTipoMovimAlmacQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "BelTipoMovimAlmacConectorCreate";
	public static final String CONECTOR_UPDATE = "BelTipoMovimAlmacConectorUpdate";
	public static final String CONECTOR_REMOVE = "BelTipoMovimAlmacConectorRemove";

	public BelTipoMovimAlmacLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("BelTipoMovimAlmacPage");
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
  	correspondiente a la creación de un/a nuevo BelTipoMovimAlmac*/  
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
		
		traza("MMG::Creando BelTipoMovimAlmac");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String codTipoMovi = conectorParametro("codTipoMovi").trim();
		traza("MMG:: Valor de atributo codTipoMovi: " + codTipoMovi);
		
		String codMoviSap = conectorParametro("codMoviSap").trim();
		traza("MMG:: Valor de atributo codMoviSap: " + codMoviSap);
		
		String indMoviEntrAlma = conectorParametro("indMoviEntrAlma").trim();
		traza("MMG:: Valor de atributo indMoviEntrAlma: " + indMoviEntrAlma);
		
		String indMantMovi = conectorParametro("indMantMovi").trim();
		traza("MMG:: Valor de atributo indMantMovi: " + indMantMovi);
		
		String indSap = conectorParametro("indSap").trim();
		traza("MMG:: Valor de atributo indSap: " + indSap);
		
		String esmeOidEstaMerc1 = conectorParametro("esmeOidEstaMerc1").trim();
		traza("MMG:: Valor de atributo esmeOidEstaMerc1: " + esmeOidEstaMerc1);
		
		String esmeOidEstaMerc2 = conectorParametro("esmeOidEstaMerc2").trim();
		traza("MMG:: Valor de atributo esmeOidEstaMerc2: " + esmeOidEstaMerc2);
		
		String codOper1 = conectorParametro("codOper1").trim();
		traza("MMG:: Valor de atributo codOper1: " + codOper1);
		
		String codOper2 = conectorParametro("codOper2").trim();
		traza("MMG:: Valor de atributo codOper2: " + codOper2);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		BelTipoMovimAlmacData belTipoMovimAlmac= new BelTipoMovimAlmacData();
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		belTipoMovimAlmac.setPaisOidPais(paisOidPaisData);
		belTipoMovimAlmac.setCodTipoMovi(
			(java.lang.String)FormatUtils.parseObject(codTipoMovi, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmac.setCodMoviSap(
			(java.lang.String)FormatUtils.parseObject(codMoviSap, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmac.setIndMoviEntrAlma(
			(java.lang.Long)FormatUtils.parseObject(indMoviEntrAlma, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmac.setIndMantMovi(
			(java.lang.Long)FormatUtils.parseObject(indMantMovi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmac.setIndSap(
			(java.lang.Long)FormatUtils.parseObject(indSap, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.BelEstadMercaData esmeOidEstaMerc1Data = null;
		if(esmeOidEstaMerc1 != null && !esmeOidEstaMerc1.trim().equals("")){
			esmeOidEstaMerc1Data = new es.indra.belcorp.mso.BelEstadMercaData();
			esmeOidEstaMerc1Data.setId(new Long(esmeOidEstaMerc1));
		}
		belTipoMovimAlmac.setEsmeOidEstaMerc1(esmeOidEstaMerc1Data);
		es.indra.belcorp.mso.BelEstadMercaData esmeOidEstaMerc2Data = null;
		if(esmeOidEstaMerc2 != null && !esmeOidEstaMerc2.trim().equals("")){
			esmeOidEstaMerc2Data = new es.indra.belcorp.mso.BelEstadMercaData();
			esmeOidEstaMerc2Data.setId(new Long(esmeOidEstaMerc2));
		}
		belTipoMovimAlmac.setEsmeOidEstaMerc2(esmeOidEstaMerc2Data);
		belTipoMovimAlmac.setCodOper1(
			(java.lang.String)FormatUtils.parseObject(codOper1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmac.setCodOper2(
			(java.lang.String)FormatUtils.parseObject(codOper2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("belTipoMovimAlmac", belTipoMovimAlmac);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad BelTipoMovimAlmac");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad BelTipoMovimAlmac");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("BelTipoMovimAlmacLPStartUp");
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
		traza("MMG::Creando BelTipoMovimAlmac");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String codTipoMovi = conectorParametro("codTipoMovi").trim();
		traza("MMG:: Valor de atributo codTipoMovi: " + codTipoMovi);
		
		String codMoviSap = conectorParametro("codMoviSap").trim();
		traza("MMG:: Valor de atributo codMoviSap: " + codMoviSap);
		
		String indMoviEntrAlma = conectorParametro("indMoviEntrAlma").trim();
		traza("MMG:: Valor de atributo indMoviEntrAlma: " + indMoviEntrAlma);
		
		String indMantMovi = conectorParametro("indMantMovi").trim();
		traza("MMG:: Valor de atributo indMantMovi: " + indMantMovi);
		
		String indSap = conectorParametro("indSap").trim();
		traza("MMG:: Valor de atributo indSap: " + indSap);
		
		String esmeOidEstaMerc1 = conectorParametro("esmeOidEstaMerc1").trim();
		traza("MMG:: Valor de atributo esmeOidEstaMerc1: " + esmeOidEstaMerc1);
		
		String esmeOidEstaMerc2 = conectorParametro("esmeOidEstaMerc2").trim();
		traza("MMG:: Valor de atributo esmeOidEstaMerc2: " + esmeOidEstaMerc2);
		
		String codOper1 = conectorParametro("codOper1").trim();
		traza("MMG:: Valor de atributo codOper1: " + codOper1);
		
		String codOper2 = conectorParametro("codOper2").trim();
		traza("MMG:: Valor de atributo codOper2: " + codOper2);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		BelTipoMovimAlmacData belTipoMovimAlmac= new BelTipoMovimAlmacData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			belTipoMovimAlmac.setId(new Long(id));
		}
		belTipoMovimAlmac = (BelTipoMovimAlmacData)getSingleObject(BUSINESSID_QUERY, belTipoMovimAlmac, 
			belTipoMovimAlmac.clone(), "belTipoMovimAlmac");
		
		if(belTipoMovimAlmac == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		belTipoMovimAlmac.setPaisOidPais(paisOidPaisData);
		belTipoMovimAlmac.setCodTipoMovi(
			(java.lang.String)FormatUtils.parseObject(codTipoMovi, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmac.setCodMoviSap(
			(java.lang.String)FormatUtils.parseObject(codMoviSap, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmac.setIndMoviEntrAlma(
			(java.lang.Long)FormatUtils.parseObject(indMoviEntrAlma, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmac.setIndMantMovi(
			(java.lang.Long)FormatUtils.parseObject(indMantMovi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmac.setIndSap(
			(java.lang.Long)FormatUtils.parseObject(indSap, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.BelEstadMercaData esmeOidEstaMerc1Data = null;
		if(esmeOidEstaMerc1 != null && !esmeOidEstaMerc1.trim().equals("")){
			esmeOidEstaMerc1Data = new es.indra.belcorp.mso.BelEstadMercaData();
			esmeOidEstaMerc1Data.setId(new Long(esmeOidEstaMerc1));
		}
		belTipoMovimAlmac.setEsmeOidEstaMerc1(esmeOidEstaMerc1Data);
		es.indra.belcorp.mso.BelEstadMercaData esmeOidEstaMerc2Data = null;
		if(esmeOidEstaMerc2 != null && !esmeOidEstaMerc2.trim().equals("")){
			esmeOidEstaMerc2Data = new es.indra.belcorp.mso.BelEstadMercaData();
			esmeOidEstaMerc2Data.setId(new Long(esmeOidEstaMerc2));
		}
		belTipoMovimAlmac.setEsmeOidEstaMerc2(esmeOidEstaMerc2Data);
		belTipoMovimAlmac.setCodOper1(
			(java.lang.String)FormatUtils.parseObject(codOper1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmac.setCodOper2(
			(java.lang.String)FormatUtils.parseObject(codOper2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//belTipoMovimAlmac.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("belTipoMovimAlmac", belTipoMovimAlmac);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad BelTipoMovimAlmac");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad BelTipoMovimAlmac");

		
		
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
			BelTipoMovimAlmacData belTipoMovimAlmac = new BelTipoMovimAlmacData();
			belTipoMovimAlmac.setId(new Long(claves.nextToken()));
			//belTipoMovimAlmac.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(belTipoMovimAlmac);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad BelTipoMovimAlmac");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad BelTipoMovimAlmac");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("BelTipoMovimAlmacLPStartUp");
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




