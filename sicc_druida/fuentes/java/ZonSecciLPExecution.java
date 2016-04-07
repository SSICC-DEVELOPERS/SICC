

/*
    INDRA/CAR/mmg
    $Id: ZonSecciLPExecution.java,v 1.1 2009/12/03 18:34:02 pecbazalar Exp $
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

public class ZonSecciLPExecution extends MMGDruidaBase{
	//Constantes de l�ogica de negocio
	public static final String BUSINESSID_CREATE= "MMGZonSecciCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGZonSecciUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGZonSecciRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGZonSecciQueryFromToUserPageStructuralSecurity";	
	
	
	public static final String CONECTOR_CREATE = "ZonSecciConectorCreate";
	public static final String CONECTOR_UPDATE = "ZonSecciConectorUpdate";
	public static final String CONECTOR_REMOVE = "ZonSecciConectorRemove";

	public ZonSecciLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("ZonSecciPage");
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
  	correspondiente a la creaci�n de un/a nuevo ZonSecci*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando ZonSecci");
		
		String zzonOidZona = conectorParametro("zzonOidZona").trim();
		traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
		
		String codSecc = conectorParametro("codSecc").trim();
		traza("MMG:: Valor de atributo codSecc: " + codSecc);
		
		String indActi = conectorParametro("indActi").trim();
		traza("MMG:: Valor de atributo indActi: " + indActi);
		
		String indBorr = conectorParametro("indBorr").trim();
		traza("MMG:: Valor de atributo indBorr: " + indBorr);
		
		String clieOidClie = conectorParametro("clieOidClie").trim();
		traza("MMG:: Valor de atributo clieOidClie: " + clieOidClie);
		
		String codNse1 = conectorParametro("codNse1").trim();
		traza("MMG:: Valor de atributo codNse1: " + codNse1);
		
		String codNse2 = conectorParametro("codNse2").trim();
		traza("MMG:: Valor de atributo codNse2: " + codNse2);
		
		String codNse3 = conectorParametro("codNse3").trim();
		traza("MMG:: Valor de atributo codNse3: " + codNse3);
		
		String desSecci = conectorParametro("desSecci").trim();
		traza("MMG:: Valor de atributo desSecci: " + desSecci);
		
		String fecRezo = conectorParametro("fecRezo").trim();
		traza("MMG:: Valor de atributo fecRezo: " + fecRezo);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		ZonSecciData zonSecci= new ZonSecciData();
		es.indra.belcorp.mso.ZonZonaData zzonOidZonaData = null;
		if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
			zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaData();
			zzonOidZonaData.setId(new Integer(zzonOidZona));
		}
		zonSecci.setZzonOidZona(zzonOidZonaData);
		zonSecci.setCodSecc(
			(java.lang.String)FormatUtils.parseObject(codSecc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSecci.setIndActi(
			(java.lang.Integer)FormatUtils.parseObject(indActi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSecci.setIndBorr(
			(java.lang.Integer)FormatUtils.parseObject(indBorr, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.MaeClienData clieOidClieData = null;
		if(clieOidClie != null && !clieOidClie.trim().equals("")){
			clieOidClieData = new es.indra.belcorp.mso.MaeClienData();
			clieOidClieData.setId(new Integer(clieOidClie));
		}
		zonSecci.setClieOidClie(clieOidClieData);
		zonSecci.setCodNse1(
			(java.lang.String)FormatUtils.parseObject(codNse1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSecci.setCodNse2(
			(java.lang.String)FormatUtils.parseObject(codNse2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSecci.setCodNse3(
			(java.lang.String)FormatUtils.parseObject(codNse3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSecci.setDesSecci(
			(java.lang.String)FormatUtils.parseObject(desSecci, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSecci.setFecRezo(
			(java.sql.Date)FormatUtils.parseObject(fecRezo, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonSecci", zonSecci);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Create de entidad ZonSecci");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecuci�n Create de entidad ZonSecci");
		
		
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp
		conectorAction("ZonSecciLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operaci�n de modificaci�n sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando ZonSecci");
		
		String zzonOidZona = conectorParametro("zzonOidZona").trim();
		traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
		
		String codSecc = conectorParametro("codSecc").trim();
		traza("MMG:: Valor de atributo codSecc: " + codSecc);
		
		String indActi = conectorParametro("indActi").trim();
		traza("MMG:: Valor de atributo indActi: " + indActi);
		
		String indBorr = conectorParametro("indBorr").trim();
		traza("MMG:: Valor de atributo indBorr: " + indBorr);
		
		String clieOidClie = conectorParametro("clieOidClie").trim();
		traza("MMG:: Valor de atributo clieOidClie: " + clieOidClie);
		
		String codNse1 = conectorParametro("codNse1").trim();
		traza("MMG:: Valor de atributo codNse1: " + codNse1);
		
		String codNse2 = conectorParametro("codNse2").trim();
		traza("MMG:: Valor de atributo codNse2: " + codNse2);
		
		String codNse3 = conectorParametro("codNse3").trim();
		traza("MMG:: Valor de atributo codNse3: " + codNse3);
		
		String desSecci = conectorParametro("desSecci").trim();
		traza("MMG:: Valor de atributo desSecci: " + desSecci);
		
		String fecRezo = conectorParametro("fecRezo").trim();
		traza("MMG:: Valor de atributo fecRezo: " + fecRezo);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		ZonSecciData zonSecci= new ZonSecciData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			zonSecci.setId(new Integer(id));
		}
		zonSecci = (ZonSecciData)getSingleObject(BUSINESSID_QUERY, zonSecci, 
			zonSecci.clone(), "zonSecci", false);
		
		if(zonSecci == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.ZonZonaData zzonOidZonaData = null;
		if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
			zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaData();
			zzonOidZonaData.setId(new Integer(zzonOidZona));
		}
		zonSecci.setZzonOidZona(zzonOidZonaData);
		zonSecci.setCodSecc(
			(java.lang.String)FormatUtils.parseObject(codSecc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSecci.setIndActi(
			(java.lang.Integer)FormatUtils.parseObject(indActi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSecci.setIndBorr(
			(java.lang.Integer)FormatUtils.parseObject(indBorr, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.MaeClienData clieOidClieData = null;
		if(clieOidClie != null && !clieOidClie.trim().equals("")){
			clieOidClieData = new es.indra.belcorp.mso.MaeClienData();
			clieOidClieData.setId(new Integer(clieOidClie));
		}
		zonSecci.setClieOidClie(clieOidClieData);
		zonSecci.setCodNse1(
			(java.lang.String)FormatUtils.parseObject(codNse1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSecci.setCodNse2(
			(java.lang.String)FormatUtils.parseObject(codNse2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSecci.setCodNse3(
			(java.lang.String)FormatUtils.parseObject(codNse3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSecci.setDesSecci(
			(java.lang.String)FormatUtils.parseObject(desSecci, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonSecci.setFecRezo(
			(java.sql.Date)FormatUtils.parseObject(fecRezo, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//zonSecci.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de realizar una modificaci�n
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonSecci", zonSecci);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Update de entidad ZonSecci");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecuci�n Update de entidad ZonSecci");

		
		
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
			ZonSecciData zonSecci = new ZonSecciData();
			zonSecci.setId(new Integer(claves.nextToken()));
			//zonSecci.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(zonSecci);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Remove de entidad ZonSecci");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecuci�n Remove de entidad ZonSecci");
		
		

		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp y requery
		conectorAction("ZonSecciLPStartUp");
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




