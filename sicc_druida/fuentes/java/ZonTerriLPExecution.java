

/*
    INDRA/CAR/mmg
    $Id: ZonTerriLPExecution.java,v 1.1 2009/12/03 18:41:01 pecbazalar Exp $
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

public class ZonTerriLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGZonTerriCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGZonTerriUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGZonTerriRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGZonTerriQueryFromToUserPageStructuralSecurity";	
	
	
	public static final String CONECTOR_CREATE = "ZonTerriConectorCreate";
	public static final String CONECTOR_UPDATE = "ZonTerriConectorUpdate";
	public static final String CONECTOR_REMOVE = "ZonTerriConectorRemove";

	public ZonTerriLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("ZonTerriPage");
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
  	correspondiente a la creación de un/a nuevo ZonTerri*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando ZonTerri");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String codTerr = conectorParametro("codTerr").trim();
		traza("MMG:: Valor de atributo codTerr: " + codTerr);
		
		String codNse1 = conectorParametro("codNse1").trim();
		traza("MMG:: Valor de atributo codNse1: " + codNse1);
		
		String codNse2 = conectorParametro("codNse2").trim();
		traza("MMG:: Valor de atributo codNse2: " + codNse2);
		
		String codNse3 = conectorParametro("codNse3").trim();
		traza("MMG:: Valor de atributo codNse3: " + codNse3);
		
		String indBorr = conectorParametro("indBorr").trim();
		traza("MMG:: Valor de atributo indBorr: " + indBorr);
		
		String vepoOidValoEstrGeop = conectorParametro("vepoOidValoEstrGeop").trim();
		traza("MMG:: Valor de atributo vepoOidValoEstrGeop: " + vepoOidValoEstrGeop);
		
		String fecRtz = conectorParametro("fecRtz").trim();
		traza("MMG:: Valor de atributo fecRtz: " + fecRtz);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		ZonTerriData zonTerri= new ZonTerriData();
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		zonTerri.setPaisOidPais(paisOidPaisData);
		zonTerri.setCodTerr(
			(java.lang.String)FormatUtils.parseObject(codTerr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonTerri.setCodNse1(
			(java.lang.String)FormatUtils.parseObject(codNse1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonTerri.setCodNse2(
			(java.lang.String)FormatUtils.parseObject(codNse2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonTerri.setCodNse3(
			(java.lang.String)FormatUtils.parseObject(codNse3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonTerri.setIndBorr(
			(java.lang.Integer)FormatUtils.parseObject(indBorr, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.ZonValorEstruGeopoData vepoOidValoEstrGeopData = null;
		if(vepoOidValoEstrGeop != null && !vepoOidValoEstrGeop.trim().equals("")){
			vepoOidValoEstrGeopData = new es.indra.belcorp.mso.ZonValorEstruGeopoData();
			vepoOidValoEstrGeopData.setId(new Integer(vepoOidValoEstrGeop));
		}
		zonTerri.setVepoOidValoEstrGeop(vepoOidValoEstrGeopData);
		zonTerri.setFecRtz(
			(java.sql.Date)FormatUtils.parseObject(fecRtz, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonTerri", zonTerri);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad ZonTerri");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad ZonTerri");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("ZonTerriLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando ZonTerri");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String codTerr = conectorParametro("codTerr").trim();
		traza("MMG:: Valor de atributo codTerr: " + codTerr);
		
		String codNse1 = conectorParametro("codNse1").trim();
		traza("MMG:: Valor de atributo codNse1: " + codNse1);
		
		String codNse2 = conectorParametro("codNse2").trim();
		traza("MMG:: Valor de atributo codNse2: " + codNse2);
		
		String codNse3 = conectorParametro("codNse3").trim();
		traza("MMG:: Valor de atributo codNse3: " + codNse3);
		
		String indBorr = conectorParametro("indBorr").trim();
		traza("MMG:: Valor de atributo indBorr: " + indBorr);
		
		String vepoOidValoEstrGeop = conectorParametro("vepoOidValoEstrGeop").trim();
		traza("MMG:: Valor de atributo vepoOidValoEstrGeop: " + vepoOidValoEstrGeop);
		
		String fecRtz = conectorParametro("fecRtz").trim();
		traza("MMG:: Valor de atributo fecRtz: " + fecRtz);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		ZonTerriData zonTerri= new ZonTerriData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			zonTerri.setId(new Integer(id));
		}
		zonTerri = (ZonTerriData)getSingleObject(BUSINESSID_QUERY, zonTerri, 
			zonTerri.clone(), "zonTerri", false);
		
		if(zonTerri == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		zonTerri.setPaisOidPais(paisOidPaisData);
		zonTerri.setCodTerr(
			(java.lang.String)FormatUtils.parseObject(codTerr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonTerri.setCodNse1(
			(java.lang.String)FormatUtils.parseObject(codNse1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonTerri.setCodNse2(
			(java.lang.String)FormatUtils.parseObject(codNse2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonTerri.setCodNse3(
			(java.lang.String)FormatUtils.parseObject(codNse3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonTerri.setIndBorr(
			(java.lang.Integer)FormatUtils.parseObject(indBorr, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.ZonValorEstruGeopoData vepoOidValoEstrGeopData = null;
		if(vepoOidValoEstrGeop != null && !vepoOidValoEstrGeop.trim().equals("")){
			vepoOidValoEstrGeopData = new es.indra.belcorp.mso.ZonValorEstruGeopoData();
			vepoOidValoEstrGeopData.setId(new Integer(vepoOidValoEstrGeop));
		}
		zonTerri.setVepoOidValoEstrGeop(vepoOidValoEstrGeopData);
		zonTerri.setFecRtz(
			(java.sql.Date)FormatUtils.parseObject(fecRtz, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//zonTerri.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonTerri", zonTerri);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad ZonTerri");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad ZonTerri");

		
		
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
			ZonTerriData zonTerri = new ZonTerriData();
			zonTerri.setId(new Integer(claves.nextToken()));
			//zonTerri.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(zonTerri);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad ZonTerri");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad ZonTerri");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("ZonTerriLPStartUp");
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




