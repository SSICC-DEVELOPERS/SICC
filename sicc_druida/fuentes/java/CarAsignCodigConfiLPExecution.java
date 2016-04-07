

/*
    INDRA/CAR/mmg
    $Id: CarAsignCodigConfiLPExecution.java,v 1.1 2009/12/03 18:39:28 pecbazalar Exp $
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

public class CarAsignCodigConfiLPExecution extends MMGDruidaBase{
	//Constantes de l�ogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCarAsignCodigConfiCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCarAsignCodigConfiUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCarAsignCodigConfiRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCarAsignCodigConfiQueryFromToUserPage";	
	public static final String CONECTOR_CREATE = "CarAsignCodigConfiConectorCreate";
	public static final String CONECTOR_UPDATE = "CarAsignCodigConfiConectorUpdate";
	public static final String CONECTOR_REMOVE = "CarAsignCodigConfiConectorRemove";

	public CarAsignCodigConfiLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CarAsignCodigConfiPage");
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
  	correspondiente a la creaci�n de un/a nuevo CarAsignCodigConfi*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando CarAsignCodigConfi");
		
		String zsgvOidSubgVent = conectorParametro("zsgvOidSubgVent").trim();
		traza("MMG:: Valor de atributo zsgvOidSubgVent: " + zsgvOidSubgVent);
		
		String zorgOidRegi = conectorParametro("zorgOidRegi").trim();
		traza("MMG:: Valor de atributo zorgOidRegi: " + zorgOidRegi);
		
		String zzonOidZona = conectorParametro("zzonOidZona").trim();
		traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
		
		String grsoOidGrupSoli = conectorParametro("grsoOidGrupSoli").trim();
		traza("MMG:: Valor de atributo grsoOidGrupSoli: " + grsoOidGrupSoli);
		
		String niriOidNiveRies = conectorParametro("niriOidNiveRies").trim();
		traza("MMG:: Valor de atributo niriOidNiveRies: " + niriOidNiveRies);
		
		String niriOidNiveRiesInici = conectorParametro("niriOidNiveRiesInici").trim();
		traza("MMG:: Valor de atributo niriOidNiveRiesInici: " + niriOidNiveRiesInici);
		
		String pacaOidParaCart = conectorParametro("pacaOidParaCart").trim();
		traza("MMG:: Valor de atributo pacaOidParaCart: " + pacaOidParaCart);
		
		String valLineCredInic = conectorParametro("valLineCredInic").trim();
		traza("MMG:: Valor de atributo valLineCredInic: " + valLineCredInic);
		
	
		//Construimos el mso con los elementos de la b�squeda
		CarAsignCodigConfiData carAsignCodigConfi= new CarAsignCodigConfiData();
		
		
		es.indra.belcorp.mso.ZonSubGerenVentaData zsgvOidSubgVentData = null;
		if(zsgvOidSubgVent != null && !zsgvOidSubgVent.trim().equals("")){
			zsgvOidSubgVentData = new es.indra.belcorp.mso.ZonSubGerenVentaData();
			zsgvOidSubgVentData.setId(new Integer(zsgvOidSubgVent));
		}
		carAsignCodigConfi.setZsgvOidSubgVent(zsgvOidSubgVentData);
		
		es.indra.belcorp.mso.ZonRegioData zorgOidRegiData = null;
		if(zorgOidRegi != null && !zorgOidRegi.trim().equals("")){
			zorgOidRegiData = new es.indra.belcorp.mso.ZonRegioData();
			zorgOidRegiData.setId(new Integer(zorgOidRegi));
		}
		carAsignCodigConfi.setZorgOidRegi(zorgOidRegiData);
		
		es.indra.belcorp.mso.ZonZonaData zzonOidZonaData = null;
		if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
			zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaData();
			zzonOidZonaData.setId(new Integer(zzonOidZona));
		}
		carAsignCodigConfi.setZzonOidZona(zzonOidZonaData);
		
		es.indra.belcorp.mso.CarGrupoSolicData grsoOidGrupSoliData = null;
		if(grsoOidGrupSoli != null && !grsoOidGrupSoli.trim().equals("")){
			grsoOidGrupSoliData = new es.indra.belcorp.mso.CarGrupoSolicData();
			grsoOidGrupSoliData.setId(new Integer(grsoOidGrupSoli));
		}
		carAsignCodigConfi.setGrsoOidGrupSoli(grsoOidGrupSoliData);
		
		es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesData = null;
		if(niriOidNiveRies != null && !niriOidNiveRies.trim().equals("")){
			niriOidNiveRiesData = new es.indra.belcorp.mso.CarNivelRiesgData();
			niriOidNiveRiesData.setId(new Integer(niriOidNiveRies));
		}
		carAsignCodigConfi.setNiriOidNiveRies(niriOidNiveRiesData);
		
		es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesIniciData = null;
		if(niriOidNiveRiesInici != null && !niriOidNiveRiesInici.trim().equals("")){
			niriOidNiveRiesIniciData = new es.indra.belcorp.mso.CarNivelRiesgData();
			niriOidNiveRiesIniciData.setId(new Integer(niriOidNiveRiesInici));
		}
		carAsignCodigConfi.setNiriOidNiveRiesInici(niriOidNiveRiesIniciData);
		
		es.indra.belcorp.mso.CarParamCarteData pacaOidParaCartData = null;
		if(pacaOidParaCart != null && !pacaOidParaCart.trim().equals("")){
			pacaOidParaCartData = new es.indra.belcorp.mso.CarParamCarteData();
			pacaOidParaCartData.setId(new Integer(pacaOidParaCart));
		}
		carAsignCodigConfi.setPacaOidParaCart(pacaOidParaCartData);
		carAsignCodigConfi.setValLineCredInic(
			(java.lang.Double)FormatUtils.parseObject(valLineCredInic, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("carAsignCodigConfi", carAsignCodigConfi);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Create de entidad CarAsignCodigConfi");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecuci�n Create de entidad CarAsignCodigConfi");
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp
		conectorAction("CarAsignCodigConfiLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operaci�n de modificaci�n sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando CarAsignCodigConfi");
		
		String zsgvOidSubgVent = conectorParametro("zsgvOidSubgVent").trim();
		traza("MMG:: Valor de atributo zsgvOidSubgVent: " + zsgvOidSubgVent);
		
		String zorgOidRegi = conectorParametro("zorgOidRegi").trim();
		traza("MMG:: Valor de atributo zorgOidRegi: " + zorgOidRegi);
		
		String zzonOidZona = conectorParametro("zzonOidZona").trim();
		traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
		
		String grsoOidGrupSoli = conectorParametro("grsoOidGrupSoli").trim();
		traza("MMG:: Valor de atributo grsoOidGrupSoli: " + grsoOidGrupSoli);
		
		String niriOidNiveRies = conectorParametro("niriOidNiveRies").trim();
		traza("MMG:: Valor de atributo niriOidNiveRies: " + niriOidNiveRies);
		
		String niriOidNiveRiesInici = conectorParametro("niriOidNiveRiesInici").trim();
		traza("MMG:: Valor de atributo niriOidNiveRiesInici: " + niriOidNiveRiesInici);
		
		String pacaOidParaCart = conectorParametro("pacaOidParaCart").trim();
		traza("MMG:: Valor de atributo pacaOidParaCart: " + pacaOidParaCart);
		
		String valLineCredInic = conectorParametro("valLineCredInic").trim();
		traza("MMG:: Valor de atributo valLineCredInic: " + valLineCredInic);
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CarAsignCodigConfiData carAsignCodigConfi= new CarAsignCodigConfiData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			carAsignCodigConfi.setId(new Integer(id));
		}
		carAsignCodigConfi = (CarAsignCodigConfiData)getSingleObject(BUSINESSID_QUERY, carAsignCodigConfi, 
			carAsignCodigConfi.clone(), "carAsignCodigConfi");
		if(carAsignCodigConfi == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.ZonSubGerenVentaData zsgvOidSubgVentData = null;
		if(zsgvOidSubgVent != null && !zsgvOidSubgVent.trim().equals("")){
			zsgvOidSubgVentData = new es.indra.belcorp.mso.ZonSubGerenVentaData();
			zsgvOidSubgVentData.setId(new Integer(zsgvOidSubgVent));
		}
		carAsignCodigConfi.setZsgvOidSubgVent(zsgvOidSubgVentData);
		es.indra.belcorp.mso.ZonRegioData zorgOidRegiData = null;
		if(zorgOidRegi != null && !zorgOidRegi.trim().equals("")){
			zorgOidRegiData = new es.indra.belcorp.mso.ZonRegioData();
			zorgOidRegiData.setId(new Integer(zorgOidRegi));
		}
		carAsignCodigConfi.setZorgOidRegi(zorgOidRegiData);
		es.indra.belcorp.mso.ZonZonaData zzonOidZonaData = null;
		if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
			zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaData();
			zzonOidZonaData.setId(new Integer(zzonOidZona));
		}
		carAsignCodigConfi.setZzonOidZona(zzonOidZonaData);
		es.indra.belcorp.mso.CarGrupoSolicData grsoOidGrupSoliData = null;
		if(grsoOidGrupSoli != null && !grsoOidGrupSoli.trim().equals("")){
			grsoOidGrupSoliData = new es.indra.belcorp.mso.CarGrupoSolicData();
			grsoOidGrupSoliData.setId(new Integer(grsoOidGrupSoli));
		}
		carAsignCodigConfi.setGrsoOidGrupSoli(grsoOidGrupSoliData);
		es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesData = null;
		if(niriOidNiveRies != null && !niriOidNiveRies.trim().equals("")){
			niriOidNiveRiesData = new es.indra.belcorp.mso.CarNivelRiesgData();
			niriOidNiveRiesData.setId(new Integer(niriOidNiveRies));
		}
		carAsignCodigConfi.setNiriOidNiveRies(niriOidNiveRiesData);
		es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesIniciData = null;
		if(niriOidNiveRiesInici != null && !niriOidNiveRiesInici.trim().equals("")){
			niriOidNiveRiesIniciData = new es.indra.belcorp.mso.CarNivelRiesgData();
			niriOidNiveRiesIniciData.setId(new Integer(niriOidNiveRiesInici));
		}
		carAsignCodigConfi.setNiriOidNiveRiesInici(niriOidNiveRiesIniciData);
		es.indra.belcorp.mso.CarParamCarteData pacaOidParaCartData = null;
		if(pacaOidParaCart != null && !pacaOidParaCart.trim().equals("")){
			pacaOidParaCartData = new es.indra.belcorp.mso.CarParamCarteData();
			pacaOidParaCartData.setId(new Integer(pacaOidParaCart));
		}
		carAsignCodigConfi.setPacaOidParaCart(pacaOidParaCartData);
		carAsignCodigConfi.setValLineCredInic(
			(java.lang.Double)FormatUtils.parseObject(valLineCredInic, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en druida no hay bloqueos.....
		//carAsignCodigConfi.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de realizar una modificaci�n
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("carAsignCodigConfi", carAsignCodigConfi);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Update de entidad CarAsignCodigConfi");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecuci�n Update de entidad CarAsignCodigConfi");
		
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
			CarAsignCodigConfiData carAsignCodigConfi = new CarAsignCodigConfiData();
			carAsignCodigConfi.setId(new Integer(claves.nextToken()));
			//carAsignCodigConfi.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(carAsignCodigConfi);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Remove de entidad CarAsignCodigConfi");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecuci�n Remove de entidad CarAsignCodigConfi");

		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp y requery
		conectorAction("CarAsignCodigConfiLPStartUp");
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


