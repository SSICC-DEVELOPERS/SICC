

/*
    INDRA/CAR/mmg
    $Id: ZonEstruGeopoLPExecution.java,v 1.1 2009/12/03 18:32:45 pecbazalar Exp $
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

public class ZonEstruGeopoLPExecution extends MMGDruidaBase{
	//Constantes de l�ogica de negocio
	public static final String BUSINESSID_CREATE= "MMGZonEstruGeopoCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGZonEstruGeopoUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGZonEstruGeopoRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGZonEstruGeopoQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "ZonEstruGeopoConectorCreate";
	public static final String CONECTOR_UPDATE = "ZonEstruGeopoConectorUpdate";
	public static final String CONECTOR_REMOVE = "ZonEstruGeopoConectorRemove";

	public ZonEstruGeopoLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("ZonEstruGeopoPage");
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
  	correspondiente a la creaci�n de un/a nuevo ZonEstruGeopo*/  
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
		
		traza("MMG::Creando ZonEstruGeopo");
		
		String codOrde = conectorParametro("codOrde").trim();
		traza("MMG:: Valor de atributo codOrde: " + codOrde);
		if(codOrde != null && !codOrde.trim().equals("")) codOrde = codOrde.toUpperCase();
		
		String indBorr = conectorParametro("indBorr").trim();
		traza("MMG:: Valor de atributo indBorr: " + indBorr);
		if(indBorr != null && !indBorr.trim().equals("")) indBorr = indBorr.toUpperCase();
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		if(paisOidPais != null && !paisOidPais.trim().equals("")) paisOidPais = paisOidPais.toUpperCase();
		
		String dipoOidDiviPoli = conectorParametro("dipoOidDiviPoli").trim();
		traza("MMG:: Valor de atributo dipoOidDiviPoli: " + dipoOidDiviPoli);
		if(dipoOidDiviPoli != null && !dipoOidDiviPoli.trim().equals("")) dipoOidDiviPoli = dipoOidDiviPoli.toUpperCase();
		
		String fecActu = conectorParametro("fecActu").trim();
		traza("MMG:: Valor de atributo fecActu: " + fecActu);
		if(fecActu != null && !fecActu.trim().equals("")) fecActu = fecActu.toUpperCase();
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		ZonEstruGeopoData zonEstruGeopo= new ZonEstruGeopoData();
		zonEstruGeopo.setCodOrde(
			(java.lang.Long)FormatUtils.parseObject(codOrde, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		zonEstruGeopo.setIndBorr(
			(java.lang.Long)FormatUtils.parseObject(indBorr, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		zonEstruGeopo.setPaisOidPais(paisOidPaisData);
		es.indra.belcorp.mso.ZonNivelGeogrData dipoOidDiviPoliData = null;
		if(dipoOidDiviPoli != null && !dipoOidDiviPoli.trim().equals("")){
			dipoOidDiviPoliData = new es.indra.belcorp.mso.ZonNivelGeogrData();
			dipoOidDiviPoliData.setId(new Long(dipoOidDiviPoli));
		}
		zonEstruGeopo.setDipoOidDiviPoli(dipoOidDiviPoliData);
		zonEstruGeopo.setFecActu(
			(java.sql.Date)FormatUtils.parseObject(fecActu, "java.sql.Date", 
			 datePattern, symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonEstruGeopo", zonEstruGeopo);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acci�n de precreate
		cmdPreCreate(zonEstruGeopo);
		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Create de entidad ZonEstruGeopo");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecuci�n Create de entidad ZonEstruGeopo");
		
		//Ejecutamos la acci�n de postcreate
		cmdPostCreate(zonEstruGeopo);
		
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp
		conectorAction("ZonEstruGeopoLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operaci�n de modificaci�n sobre el elemento seleccionado*/  
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
		traza("MMG::Creando ZonEstruGeopo");
		
		String codOrde = conectorParametro("codOrde").trim();
		traza("MMG:: Valor de atributo codOrde: " + codOrde);
		if(codOrde != null && !codOrde.trim().equals("")) codOrde = codOrde.toUpperCase();
		
		String indBorr = conectorParametro("indBorr").trim();
		traza("MMG:: Valor de atributo indBorr: " + indBorr);
		if(indBorr != null && !indBorr.trim().equals("")) indBorr = indBorr.toUpperCase();
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		if(paisOidPais != null && !paisOidPais.trim().equals("")) paisOidPais = paisOidPais.toUpperCase();
		
		String dipoOidDiviPoli = conectorParametro("dipoOidDiviPoli").trim();
		traza("MMG:: Valor de atributo dipoOidDiviPoli: " + dipoOidDiviPoli);
		if(dipoOidDiviPoli != null && !dipoOidDiviPoli.trim().equals("")) dipoOidDiviPoli = dipoOidDiviPoli.toUpperCase();
		
		String fecActu = conectorParametro("fecActu").trim();
		traza("MMG:: Valor de atributo fecActu: " + fecActu);
		if(fecActu != null && !fecActu.trim().equals("")) fecActu = fecActu.toUpperCase();
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		ZonEstruGeopoData zonEstruGeopo= new ZonEstruGeopoData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			zonEstruGeopo.setId(new Long(id));
		}
		zonEstruGeopo = (ZonEstruGeopoData)getSingleObject(BUSINESSID_QUERY, zonEstruGeopo, 
			zonEstruGeopo.clone(), "zonEstruGeopo");
		
		if(zonEstruGeopo == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		zonEstruGeopo.setCodOrde(
			(java.lang.Long)FormatUtils.parseObject(codOrde, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		zonEstruGeopo.setIndBorr(
			(java.lang.Long)FormatUtils.parseObject(indBorr, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		zonEstruGeopo.setPaisOidPais(paisOidPaisData);
		es.indra.belcorp.mso.ZonNivelGeogrData dipoOidDiviPoliData = null;
		if(dipoOidDiviPoli != null && !dipoOidDiviPoli.trim().equals("")){
			dipoOidDiviPoliData = new es.indra.belcorp.mso.ZonNivelGeogrData();
			dipoOidDiviPoliData.setId(new Long(dipoOidDiviPoli));
		}
		zonEstruGeopo.setDipoOidDiviPoli(dipoOidDiviPoliData);
		zonEstruGeopo.setFecActu(
			(java.sql.Date)FormatUtils.parseObject(fecActu, "java.sql.Date", 
			 datePattern, symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//zonEstruGeopo.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de realizar una modificaci�n
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonEstruGeopo", zonEstruGeopo);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acci�n de preupdate
		cmdPreUpdate(zonEstruGeopo);
		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Update de entidad ZonEstruGeopo");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecuci�n Update de entidad ZonEstruGeopo");

		
		
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
			ZonEstruGeopoData zonEstruGeopo = new ZonEstruGeopoData();
			zonEstruGeopo.setId(new Long(claves.nextToken()));
			//zonEstruGeopo.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(zonEstruGeopo);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Remove de entidad ZonEstruGeopo");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecuci�n Remove de entidad ZonEstruGeopo");
		
		

		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp y requery
		conectorAction("ZonEstruGeopoLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(ZonEstruGeopoData zonEstruGeopo) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
                Long(MMGDruidaHelper.getUserDefaultCountry(this)));zonEstruGeopo.setPaisOidPais(paisOculto);
	}
	

	protected void cmdPreUpdate(ZonEstruGeopoData zonEstruGeopo) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
                Long(MMGDruidaHelper.getUserDefaultCountry(this)));zonEstruGeopo.setPaisOidPais(paisOculto);
	}
	
	
	

	protected void cmdPostCreate(ZonEstruGeopoData zonEstruGeopo) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
                Long(MMGDruidaHelper.getUserDefaultCountry(this)));zonEstruGeopo.setPaisOidPais(paisOculto);
	}
	

	
	
	
	
}




