

/*
    INDRA/CAR/mmg
    $Id: CobUsuarEtapaCobraDetalLPExecution.java,v 1.1 2009/12/03 18:32:38 pecbazalar Exp $
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

public class CobUsuarEtapaCobraDetalLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCobUsuarEtapaCobraDetalCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCobUsuarEtapaCobraDetalUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCobUsuarEtapaCobraDetalRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCobUsuarEtapaCobraDetalQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CobUsuarEtapaCobraDetalConectorCreate";
	public static final String CONECTOR_UPDATE = "CobUsuarEtapaCobraDetalConectorUpdate";
	public static final String CONECTOR_REMOVE = "CobUsuarEtapaCobraDetalConectorRemove";

	public CobUsuarEtapaCobraDetalLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CobUsuarEtapaCobraDetalPage");
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
  	correspondiente a la creación de un/a nuevo CobUsuarEtapaCobraDetal*/  
	protected void cmdCreate() throws Exception{
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = UtilidadesSession.getFormatoFecha(this);
		traza("datePattern" + datePattern);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator.charAt(0));
		symbols.setGroupingSeparator(separadorMiles.charAt(0));	
		
		traza("MMG::Creando CobUsuarEtapaCobraDetal");
		
		String ueccOidUsuaEtapCobr = conectorParametro("ueccOidUsuaEtapCobr").trim();
		traza("MMG:: Valor de atributo ueccOidUsuaEtapCobr: " + ueccOidUsuaEtapCobr);
		
		String edtcOidEtapDeudTipoCarg = conectorParametro("edtcOidEtapDeudTipoCarg").trim();
		traza("MMG:: Valor de atributo edtcOidEtapDeudTipoCarg: " + edtcOidEtapDeudTipoCarg);
		
		String zsgvOidSubgVent = conectorParametro("zsgvOidSubgVent").trim();
		traza("MMG:: Valor de atributo zsgvOidSubgVent: " + zsgvOidSubgVent);
		
		String zorgOidRegi = conectorParametro("zorgOidRegi").trim();
		traza("MMG:: Valor de atributo zorgOidRegi: " + zorgOidRegi);
		
		String zzonOidZona = conectorParametro("zzonOidZona").trim();
		traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
		
		String zsccOidSecc = conectorParametro("zsccOidSecc").trim();
		traza("MMG:: Valor de atributo zsccOidSecc: " + zsccOidSecc);
		
		String terrOidTerr = conectorParametro("terrOidTerr").trim();
		traza("MMG:: Valor de atributo terrOidTerr: " + terrOidTerr);
		
		String melcOidMetoLiquCobr = conectorParametro("melcOidMetoLiquCobr").trim();
		traza("MMG:: Valor de atributo melcOidMetoLiquCobr: " + melcOidMetoLiquCobr);
		
		String eucoOidEstaUsuaEtapCobr = conectorParametro("eucoOidEstaUsuaEtapCobr").trim();
		traza("MMG:: Valor de atributo eucoOidEstaUsuaEtapCobr: " + eucoOidEstaUsuaEtapCobr);
		
		String gacaOidGuioArguCabe = conectorParametro("gacaOidGuioArguCabe").trim();
		traza("MMG:: Valor de atributo gacaOidGuioArguCabe: " + gacaOidGuioArguCabe);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CobUsuarEtapaCobraDetalData cobUsuarEtapaCobraDetal= new CobUsuarEtapaCobraDetalData();
		es.indra.belcorp.mso.CobUsuarEtapaCobraCabecData ueccOidUsuaEtapCobrData = null;
		if(ueccOidUsuaEtapCobr != null && !ueccOidUsuaEtapCobr.trim().equals("")){
			ueccOidUsuaEtapCobrData = new es.indra.belcorp.mso.CobUsuarEtapaCobraCabecData();
			ueccOidUsuaEtapCobrData.setId(new Long(ueccOidUsuaEtapCobr));
		}
		cobUsuarEtapaCobraDetal.setUeccOidUsuaEtapCobr(ueccOidUsuaEtapCobrData);
		es.indra.belcorp.mso.CobEtapaDeudaTipoCargoData edtcOidEtapDeudTipoCargData = null;
		if(edtcOidEtapDeudTipoCarg != null && !edtcOidEtapDeudTipoCarg.trim().equals("")){
			edtcOidEtapDeudTipoCargData = new es.indra.belcorp.mso.CobEtapaDeudaTipoCargoData();
			edtcOidEtapDeudTipoCargData.setId(new Long(edtcOidEtapDeudTipoCarg));
		}
		cobUsuarEtapaCobraDetal.setEdtcOidEtapDeudTipoCarg(edtcOidEtapDeudTipoCargData);
		es.indra.belcorp.mso.ZonSubGerenVentaViewData zsgvOidSubgVentData = null;
		if(zsgvOidSubgVent != null && !zsgvOidSubgVent.trim().equals("")){
			zsgvOidSubgVentData = new es.indra.belcorp.mso.ZonSubGerenVentaViewData();
			zsgvOidSubgVentData.setId(new Long(zsgvOidSubgVent));
		}
		cobUsuarEtapaCobraDetal.setZsgvOidSubgVent(zsgvOidSubgVentData);
		es.indra.belcorp.mso.ZonRegioViewData zorgOidRegiData = null;
		if(zorgOidRegi != null && !zorgOidRegi.trim().equals("")){
			zorgOidRegiData = new es.indra.belcorp.mso.ZonRegioViewData();
			zorgOidRegiData.setId(new Long(zorgOidRegi));
		}
		cobUsuarEtapaCobraDetal.setZorgOidRegi(zorgOidRegiData);
		es.indra.belcorp.mso.ZonZonaViewData zzonOidZonaData = null;
		if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
			zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaViewData();
			zzonOidZonaData.setId(new Long(zzonOidZona));
		}
		cobUsuarEtapaCobraDetal.setZzonOidZona(zzonOidZonaData);
		es.indra.belcorp.mso.ZonSecciViewData zsccOidSeccData = null;
		if(zsccOidSecc != null && !zsccOidSecc.trim().equals("")){
			zsccOidSeccData = new es.indra.belcorp.mso.ZonSecciViewData();
			zsccOidSeccData.setId(new Long(zsccOidSecc));
		}
		cobUsuarEtapaCobraDetal.setZsccOidSecc(zsccOidSeccData);
		es.indra.belcorp.mso.ZonTerriViewData terrOidTerrData = null;
		if(terrOidTerr != null && !terrOidTerr.trim().equals("")){
			terrOidTerrData = new es.indra.belcorp.mso.ZonTerriViewData();
			terrOidTerrData.setId(new Long(terrOidTerr));
		}
		cobUsuarEtapaCobraDetal.setTerrOidTerr(terrOidTerrData);
		es.indra.belcorp.mso.CobMetodLiquiViewData melcOidMetoLiquCobrData = null;
		if(melcOidMetoLiquCobr != null && !melcOidMetoLiquCobr.trim().equals("")){
			melcOidMetoLiquCobrData = new es.indra.belcorp.mso.CobMetodLiquiViewData();
			melcOidMetoLiquCobrData.setId(new Long(melcOidMetoLiquCobr));
		}
		cobUsuarEtapaCobraDetal.setMelcOidMetoLiquCobr(melcOidMetoLiquCobrData);
		es.indra.belcorp.mso.CobEstadUsuarEtapaCobraData eucoOidEstaUsuaEtapCobrData = null;
		if(eucoOidEstaUsuaEtapCobr != null && !eucoOidEstaUsuaEtapCobr.trim().equals("")){
			eucoOidEstaUsuaEtapCobrData = new es.indra.belcorp.mso.CobEstadUsuarEtapaCobraData();
			eucoOidEstaUsuaEtapCobrData.setId(new Long(eucoOidEstaUsuaEtapCobr));
		}
		cobUsuarEtapaCobraDetal.setEucoOidEstaUsuaEtapCobr(eucoOidEstaUsuaEtapCobrData);
		es.indra.belcorp.mso.CobGuionArgumCabecViewData gacaOidGuioArguCabeData = null;
		if(gacaOidGuioArguCabe != null && !gacaOidGuioArguCabe.trim().equals("")){
			gacaOidGuioArguCabeData = new es.indra.belcorp.mso.CobGuionArgumCabecViewData();
			gacaOidGuioArguCabeData.setId(new Long(gacaOidGuioArguCabe));
		}
		cobUsuarEtapaCobraDetal.setGacaOidGuioArguCabe(gacaOidGuioArguCabeData);
		cobUsuarEtapaCobraDetal.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobUsuarEtapaCobraDetal", cobUsuarEtapaCobraDetal);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CobUsuarEtapaCobraDetal");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CobUsuarEtapaCobraDetal");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CobUsuarEtapaCobraDetalLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = UtilidadesSession.getFormatoFecha(this);
		traza("datePattern" + datePattern);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator.charAt(0));
		symbols.setGroupingSeparator(separadorMiles.charAt(0));	
		traza("MMG::Creando CobUsuarEtapaCobraDetal");
		
		String ueccOidUsuaEtapCobr = conectorParametro("ueccOidUsuaEtapCobr").trim();
		traza("MMG:: Valor de atributo ueccOidUsuaEtapCobr: " + ueccOidUsuaEtapCobr);
		
		String edtcOidEtapDeudTipoCarg = conectorParametro("edtcOidEtapDeudTipoCarg").trim();
		traza("MMG:: Valor de atributo edtcOidEtapDeudTipoCarg: " + edtcOidEtapDeudTipoCarg);
		
		String zsgvOidSubgVent = conectorParametro("zsgvOidSubgVent").trim();
		traza("MMG:: Valor de atributo zsgvOidSubgVent: " + zsgvOidSubgVent);
		
		String zorgOidRegi = conectorParametro("zorgOidRegi").trim();
		traza("MMG:: Valor de atributo zorgOidRegi: " + zorgOidRegi);
		
		String zzonOidZona = conectorParametro("zzonOidZona").trim();
		traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
		
		String zsccOidSecc = conectorParametro("zsccOidSecc").trim();
		traza("MMG:: Valor de atributo zsccOidSecc: " + zsccOidSecc);
		
		String terrOidTerr = conectorParametro("terrOidTerr").trim();
		traza("MMG:: Valor de atributo terrOidTerr: " + terrOidTerr);
		
		String melcOidMetoLiquCobr = conectorParametro("melcOidMetoLiquCobr").trim();
		traza("MMG:: Valor de atributo melcOidMetoLiquCobr: " + melcOidMetoLiquCobr);
		
		String eucoOidEstaUsuaEtapCobr = conectorParametro("eucoOidEstaUsuaEtapCobr").trim();
		traza("MMG:: Valor de atributo eucoOidEstaUsuaEtapCobr: " + eucoOidEstaUsuaEtapCobr);
		
		String gacaOidGuioArguCabe = conectorParametro("gacaOidGuioArguCabe").trim();
		traza("MMG:: Valor de atributo gacaOidGuioArguCabe: " + gacaOidGuioArguCabe);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CobUsuarEtapaCobraDetalData cobUsuarEtapaCobraDetal= new CobUsuarEtapaCobraDetalData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			cobUsuarEtapaCobraDetal.setId(new Long(id));
		}
		cobUsuarEtapaCobraDetal = (CobUsuarEtapaCobraDetalData)getSingleObject(BUSINESSID_QUERY, cobUsuarEtapaCobraDetal, 
			cobUsuarEtapaCobraDetal.clone(), "cobUsuarEtapaCobraDetal");
		
		if(cobUsuarEtapaCobraDetal == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.CobUsuarEtapaCobraCabecData ueccOidUsuaEtapCobrData = null;
		if(ueccOidUsuaEtapCobr != null && !ueccOidUsuaEtapCobr.trim().equals("")){
			ueccOidUsuaEtapCobrData = new es.indra.belcorp.mso.CobUsuarEtapaCobraCabecData();
			ueccOidUsuaEtapCobrData.setId(new Long(ueccOidUsuaEtapCobr));
		}
		cobUsuarEtapaCobraDetal.setUeccOidUsuaEtapCobr(ueccOidUsuaEtapCobrData);
		es.indra.belcorp.mso.CobEtapaDeudaTipoCargoData edtcOidEtapDeudTipoCargData = null;
		if(edtcOidEtapDeudTipoCarg != null && !edtcOidEtapDeudTipoCarg.trim().equals("")){
			edtcOidEtapDeudTipoCargData = new es.indra.belcorp.mso.CobEtapaDeudaTipoCargoData();
			edtcOidEtapDeudTipoCargData.setId(new Long(edtcOidEtapDeudTipoCarg));
		}
		cobUsuarEtapaCobraDetal.setEdtcOidEtapDeudTipoCarg(edtcOidEtapDeudTipoCargData);
		es.indra.belcorp.mso.ZonSubGerenVentaViewData zsgvOidSubgVentData = null;
		if(zsgvOidSubgVent != null && !zsgvOidSubgVent.trim().equals("")){
			zsgvOidSubgVentData = new es.indra.belcorp.mso.ZonSubGerenVentaViewData();
			zsgvOidSubgVentData.setId(new Long(zsgvOidSubgVent));
		}
		cobUsuarEtapaCobraDetal.setZsgvOidSubgVent(zsgvOidSubgVentData);
		es.indra.belcorp.mso.ZonRegioViewData zorgOidRegiData = null;
		if(zorgOidRegi != null && !zorgOidRegi.trim().equals("")){
			zorgOidRegiData = new es.indra.belcorp.mso.ZonRegioViewData();
			zorgOidRegiData.setId(new Long(zorgOidRegi));
		}
		cobUsuarEtapaCobraDetal.setZorgOidRegi(zorgOidRegiData);
		es.indra.belcorp.mso.ZonZonaViewData zzonOidZonaData = null;
		if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
			zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaViewData();
			zzonOidZonaData.setId(new Long(zzonOidZona));
		}
		cobUsuarEtapaCobraDetal.setZzonOidZona(zzonOidZonaData);
		es.indra.belcorp.mso.ZonSecciViewData zsccOidSeccData = null;
		if(zsccOidSecc != null && !zsccOidSecc.trim().equals("")){
			zsccOidSeccData = new es.indra.belcorp.mso.ZonSecciViewData();
			zsccOidSeccData.setId(new Long(zsccOidSecc));
		}
		cobUsuarEtapaCobraDetal.setZsccOidSecc(zsccOidSeccData);
		es.indra.belcorp.mso.ZonTerriViewData terrOidTerrData = null;
		if(terrOidTerr != null && !terrOidTerr.trim().equals("")){
			terrOidTerrData = new es.indra.belcorp.mso.ZonTerriViewData();
			terrOidTerrData.setId(new Long(terrOidTerr));
		}
		cobUsuarEtapaCobraDetal.setTerrOidTerr(terrOidTerrData);
		es.indra.belcorp.mso.CobMetodLiquiViewData melcOidMetoLiquCobrData = null;
		if(melcOidMetoLiquCobr != null && !melcOidMetoLiquCobr.trim().equals("")){
			melcOidMetoLiquCobrData = new es.indra.belcorp.mso.CobMetodLiquiViewData();
			melcOidMetoLiquCobrData.setId(new Long(melcOidMetoLiquCobr));
		}
		cobUsuarEtapaCobraDetal.setMelcOidMetoLiquCobr(melcOidMetoLiquCobrData);
		es.indra.belcorp.mso.CobEstadUsuarEtapaCobraData eucoOidEstaUsuaEtapCobrData = null;
		if(eucoOidEstaUsuaEtapCobr != null && !eucoOidEstaUsuaEtapCobr.trim().equals("")){
			eucoOidEstaUsuaEtapCobrData = new es.indra.belcorp.mso.CobEstadUsuarEtapaCobraData();
			eucoOidEstaUsuaEtapCobrData.setId(new Long(eucoOidEstaUsuaEtapCobr));
		}
		cobUsuarEtapaCobraDetal.setEucoOidEstaUsuaEtapCobr(eucoOidEstaUsuaEtapCobrData);
		es.indra.belcorp.mso.CobGuionArgumCabecViewData gacaOidGuioArguCabeData = null;
		if(gacaOidGuioArguCabe != null && !gacaOidGuioArguCabe.trim().equals("")){
			gacaOidGuioArguCabeData = new es.indra.belcorp.mso.CobGuionArgumCabecViewData();
			gacaOidGuioArguCabeData.setId(new Long(gacaOidGuioArguCabe));
		}
		cobUsuarEtapaCobraDetal.setGacaOidGuioArguCabe(gacaOidGuioArguCabeData);
		cobUsuarEtapaCobraDetal.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//cobUsuarEtapaCobraDetal.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobUsuarEtapaCobraDetal", cobUsuarEtapaCobraDetal);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CobUsuarEtapaCobraDetal");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CobUsuarEtapaCobraDetal");

		
		
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
			CobUsuarEtapaCobraDetalData cobUsuarEtapaCobraDetal = new CobUsuarEtapaCobraDetalData();
			cobUsuarEtapaCobraDetal.setId(new Long(claves.nextToken()));
			//cobUsuarEtapaCobraDetal.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(cobUsuarEtapaCobraDetal);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CobUsuarEtapaCobraDetal");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CobUsuarEtapaCobraDetal");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CobUsuarEtapaCobraDetalLPStartUp");
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




