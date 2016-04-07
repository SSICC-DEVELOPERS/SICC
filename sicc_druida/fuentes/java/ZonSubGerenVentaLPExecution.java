

/*
    INDRA/CAR/mmg
    $Id: ZonSubGerenVentaLPExecution.java,v 1.1 2009/12/03 18:36:57 pecbazalar Exp $
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

public class ZonSubGerenVentaLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGZonSubGerenVentaCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGZonSubGerenVentaUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGZonSubGerenVentaRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGZonSubGerenVentaQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "ZonSubGerenVentaConectorCreate";
	public static final String CONECTOR_UPDATE = "ZonSubGerenVentaConectorUpdate";
	public static final String CONECTOR_REMOVE = "ZonSubGerenVentaConectorRemove";

	public ZonSubGerenVentaLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("ZonSubGerenVentaPage");
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
  	correspondiente a la creación de un/a nuevo ZonSubGerenVenta*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando ZonSubGerenVenta");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String marcOidMarc = conectorParametro("marcOidMarc").trim();
		traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
		
		String canaOidCana = conectorParametro("canaOidCana").trim();
		traza("MMG:: Valor de atributo canaOidCana: " + canaOidCana);
		
		String codSubgVent = conectorParametro("codSubgVent").trim();
		traza("MMG:: Valor de atributo codSubgVent: " + codSubgVent);
		
		String indBorr = conectorParametro("indBorr").trim();
		traza("MMG:: Valor de atributo indBorr: " + indBorr);
		
		String indActi = conectorParametro("indActi").trim();
		traza("MMG:: Valor de atributo indActi: " + indActi);
		
		String codNse1 = conectorParametro("codNse1").trim();
		traza("MMG:: Valor de atributo codNse1: " + codNse1);
		
		String codNse2 = conectorParametro("codNse2").trim();
		traza("MMG:: Valor de atributo codNse2: " + codNse2);
		
		String codNse3 = conectorParametro("codNse3").trim();
		traza("MMG:: Valor de atributo codNse3: " + codNse3);
		
		String desSubgVent = conectorParametro("desSubgVent").trim();
		traza("MMG:: Valor de atributo desSubgVent: " + desSubgVent);
		
		String clieOidClie = conectorParametro("clieOidClie").trim();
		traza("MMG:: Valor de atributo clieOidClie: " + clieOidClie);
		
		String fecRezo = conectorParametro("fecRezo").trim();
		traza("MMG:: Valor de atributo fecRezo: " + fecRezo);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		ZonSubGerenVentaData zonSubGerenVenta= new ZonSubGerenVentaData();
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		zonSubGerenVenta.setPaisOidPais(paisOidPaisData);
		es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
		if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
			marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
			marcOidMarcData.setId(new Integer(marcOidMarc));
		}
		zonSubGerenVenta.setMarcOidMarc(marcOidMarcData);
		es.indra.belcorp.mso.SegCanalData canaOidCanaData = null;
		if(canaOidCana != null && !canaOidCana.trim().equals("")){
			canaOidCanaData = new es.indra.belcorp.mso.SegCanalData();
			canaOidCanaData.setId(new Integer(canaOidCana));
		}
		zonSubGerenVenta.setCanaOidCana(canaOidCanaData);
		zonSubGerenVenta.setCodSubgVent(
			(java.lang.String)FormatUtils.parseObject(codSubgVent, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSubGerenVenta.setIndBorr(
			(java.lang.Integer)FormatUtils.parseObject(indBorr, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSubGerenVenta.setIndActi(
			(java.lang.Integer)FormatUtils.parseObject(indActi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSubGerenVenta.setCodNse1(
			(java.lang.String)FormatUtils.parseObject(codNse1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSubGerenVenta.setCodNse2(
			(java.lang.String)FormatUtils.parseObject(codNse2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSubGerenVenta.setCodNse3(
			(java.lang.String)FormatUtils.parseObject(codNse3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSubGerenVenta.setDesSubgVent(
			(java.lang.String)FormatUtils.parseObject(desSubgVent, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.MaeClienData clieOidClieData = null;
		if(clieOidClie != null && !clieOidClie.trim().equals("")){
			clieOidClieData = new es.indra.belcorp.mso.MaeClienData();
			clieOidClieData.setId(new Integer(clieOidClie));
		}
		zonSubGerenVenta.setClieOidClie(clieOidClieData);
		zonSubGerenVenta.setFecRezo(
			(java.sql.Date)FormatUtils.parseObject(fecRezo, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonSubGerenVenta", zonSubGerenVenta);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad ZonSubGerenVenta");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad ZonSubGerenVenta");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("ZonSubGerenVentaLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando ZonSubGerenVenta");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String marcOidMarc = conectorParametro("marcOidMarc").trim();
		traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
		
		String canaOidCana = conectorParametro("canaOidCana").trim();
		traza("MMG:: Valor de atributo canaOidCana: " + canaOidCana);
		
		String codSubgVent = conectorParametro("codSubgVent").trim();
		traza("MMG:: Valor de atributo codSubgVent: " + codSubgVent);
		
		String indBorr = conectorParametro("indBorr").trim();
		traza("MMG:: Valor de atributo indBorr: " + indBorr);
		
		String indActi = conectorParametro("indActi").trim();
		traza("MMG:: Valor de atributo indActi: " + indActi);
		
		String codNse1 = conectorParametro("codNse1").trim();
		traza("MMG:: Valor de atributo codNse1: " + codNse1);
		
		String codNse2 = conectorParametro("codNse2").trim();
		traza("MMG:: Valor de atributo codNse2: " + codNse2);
		
		String codNse3 = conectorParametro("codNse3").trim();
		traza("MMG:: Valor de atributo codNse3: " + codNse3);
		
		String desSubgVent = conectorParametro("desSubgVent").trim();
		traza("MMG:: Valor de atributo desSubgVent: " + desSubgVent);
		
		String clieOidClie = conectorParametro("clieOidClie").trim();
		traza("MMG:: Valor de atributo clieOidClie: " + clieOidClie);
		
		String fecRezo = conectorParametro("fecRezo").trim();
		traza("MMG:: Valor de atributo fecRezo: " + fecRezo);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		ZonSubGerenVentaData zonSubGerenVenta= new ZonSubGerenVentaData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			zonSubGerenVenta.setId(new Integer(id));
		}
		zonSubGerenVenta = (ZonSubGerenVentaData)getSingleObject(BUSINESSID_QUERY, zonSubGerenVenta, 
			zonSubGerenVenta.clone(), "zonSubGerenVenta");
		
		if(zonSubGerenVenta == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		zonSubGerenVenta.setPaisOidPais(paisOidPaisData);
		es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
		if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
			marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
			marcOidMarcData.setId(new Integer(marcOidMarc));
		}
		zonSubGerenVenta.setMarcOidMarc(marcOidMarcData);
		es.indra.belcorp.mso.SegCanalData canaOidCanaData = null;
		if(canaOidCana != null && !canaOidCana.trim().equals("")){
			canaOidCanaData = new es.indra.belcorp.mso.SegCanalData();
			canaOidCanaData.setId(new Integer(canaOidCana));
		}
		zonSubGerenVenta.setCanaOidCana(canaOidCanaData);
		zonSubGerenVenta.setCodSubgVent(
			(java.lang.String)FormatUtils.parseObject(codSubgVent, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSubGerenVenta.setIndBorr(
			(java.lang.Integer)FormatUtils.parseObject(indBorr, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSubGerenVenta.setIndActi(
			(java.lang.Integer)FormatUtils.parseObject(indActi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSubGerenVenta.setCodNse1(
			(java.lang.String)FormatUtils.parseObject(codNse1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSubGerenVenta.setCodNse2(
			(java.lang.String)FormatUtils.parseObject(codNse2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSubGerenVenta.setCodNse3(
			(java.lang.String)FormatUtils.parseObject(codNse3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSubGerenVenta.setDesSubgVent(
			(java.lang.String)FormatUtils.parseObject(desSubgVent, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.MaeClienData clieOidClieData = null;
		if(clieOidClie != null && !clieOidClie.trim().equals("")){
			clieOidClieData = new es.indra.belcorp.mso.MaeClienData();
			clieOidClieData.setId(new Integer(clieOidClie));
		}
		zonSubGerenVenta.setClieOidClie(clieOidClieData);
		zonSubGerenVenta.setFecRezo(
			(java.sql.Date)FormatUtils.parseObject(fecRezo, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//zonSubGerenVenta.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonSubGerenVenta", zonSubGerenVenta);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad ZonSubGerenVenta");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad ZonSubGerenVenta");

		
		
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
			ZonSubGerenVentaData zonSubGerenVenta = new ZonSubGerenVentaData();
			zonSubGerenVenta.setId(new Integer(claves.nextToken()));
			//zonSubGerenVenta.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(zonSubGerenVenta);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad ZonSubGerenVenta");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad ZonSubGerenVenta");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("ZonSubGerenVentaLPStartUp");
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




