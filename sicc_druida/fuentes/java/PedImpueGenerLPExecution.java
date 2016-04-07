

/*
    INDRA/CAR/mmg
    $Id: PedImpueGenerLPExecution.java,v 1.1 2009/12/03 18:34:55 pecbazalar Exp $
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

public class PedImpueGenerLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGPedImpueGenerCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGPedImpueGenerUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGPedImpueGenerRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGPedImpueGenerQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "PedImpueGenerConectorCreate";
	public static final String CONECTOR_UPDATE = "PedImpueGenerConectorUpdate";
	public static final String CONECTOR_REMOVE = "PedImpueGenerConectorRemove";

	public PedImpueGenerLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("PedImpueGenerPage");
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
  	correspondiente a la creación de un/a nuevo PedImpueGener*/  
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
		
		traza("MMG::Creando PedImpueGener");
		
		String sbacOidSbac = conectorParametro("sbacOidSbac").trim();
		traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
		
		String taimOidTasaImpu = conectorParametro("taimOidTasaImpu").trim();
		traza("MMG:: Valor de atributo taimOidTasaImpu: " + taimOidTasaImpu);
		
		String taimOidTasaImpuFlet = conectorParametro("taimOidTasaImpuFlet").trim();
		traza("MMG:: Valor de atributo taimOidTasaImpuFlet: " + taimOidTasaImpuFlet);
		
		String indTasaUnic = conectorParametro("indTasaUnic").trim();
		traza("MMG:: Valor de atributo indTasaUnic: " + indTasaUnic);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		PedImpueGenerData pedImpueGener= new PedImpueGenerData();
		es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
		if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
			sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
			sbacOidSbacData.setId(new Long(sbacOidSbac));
		}
		pedImpueGener.setSbacOidSbac(sbacOidSbacData);
		es.indra.belcorp.mso.PedTasaImpueData taimOidTasaImpuData = null;
		if(taimOidTasaImpu != null && !taimOidTasaImpu.trim().equals("")){
			taimOidTasaImpuData = new es.indra.belcorp.mso.PedTasaImpueData();
			taimOidTasaImpuData.setId(new Long(taimOidTasaImpu));
		}
		pedImpueGener.setTaimOidTasaImpu(taimOidTasaImpuData);
		es.indra.belcorp.mso.PedTasaImpueData taimOidTasaImpuFletData = null;
		if(taimOidTasaImpuFlet != null && !taimOidTasaImpuFlet.trim().equals("")){
			taimOidTasaImpuFletData = new es.indra.belcorp.mso.PedTasaImpueData();
			taimOidTasaImpuFletData.setId(new Long(taimOidTasaImpuFlet));
		}
		pedImpueGener.setTaimOidTasaImpuFlet(taimOidTasaImpuFletData);
		pedImpueGener.setIndTasaUnic(
			(java.lang.Boolean)FormatUtils.parseObject(indTasaUnic.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("pedImpueGener", pedImpueGener);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(pedImpueGener);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad PedImpueGener");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad PedImpueGener");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(pedImpueGener);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("PedImpueGenerLPStartUp");
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
		traza("MMG::Creando PedImpueGener");
		
		String sbacOidSbac = conectorParametro("sbacOidSbac").trim();
		traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
		
		String taimOidTasaImpu = conectorParametro("taimOidTasaImpu").trim();
		traza("MMG:: Valor de atributo taimOidTasaImpu: " + taimOidTasaImpu);
		
		String taimOidTasaImpuFlet = conectorParametro("taimOidTasaImpuFlet").trim();
		traza("MMG:: Valor de atributo taimOidTasaImpuFlet: " + taimOidTasaImpuFlet);
		
		String indTasaUnic = conectorParametro("indTasaUnic").trim();
		traza("MMG:: Valor de atributo indTasaUnic: " + indTasaUnic);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		PedImpueGenerData pedImpueGener= new PedImpueGenerData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			pedImpueGener.setId(new Long(id));
		}
		pedImpueGener = (PedImpueGenerData)getSingleObject(BUSINESSID_QUERY, pedImpueGener, 
			pedImpueGener.clone(), "pedImpueGener");
		
		if(pedImpueGener == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
		if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
			sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
			sbacOidSbacData.setId(new Long(sbacOidSbac));
		}
		pedImpueGener.setSbacOidSbac(sbacOidSbacData);
		es.indra.belcorp.mso.PedTasaImpueData taimOidTasaImpuData = null;
		if(taimOidTasaImpu != null && !taimOidTasaImpu.trim().equals("")){
			taimOidTasaImpuData = new es.indra.belcorp.mso.PedTasaImpueData();
			taimOidTasaImpuData.setId(new Long(taimOidTasaImpu));
		}
		pedImpueGener.setTaimOidTasaImpu(taimOidTasaImpuData);
		es.indra.belcorp.mso.PedTasaImpueData taimOidTasaImpuFletData = null;
		if(taimOidTasaImpuFlet != null && !taimOidTasaImpuFlet.trim().equals("")){
			taimOidTasaImpuFletData = new es.indra.belcorp.mso.PedTasaImpueData();
			taimOidTasaImpuFletData.setId(new Long(taimOidTasaImpuFlet));
		}
		pedImpueGener.setTaimOidTasaImpuFlet(taimOidTasaImpuFletData);
		pedImpueGener.setIndTasaUnic(
			(java.lang.Boolean)FormatUtils.parseObject(indTasaUnic.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//pedImpueGener.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("pedImpueGener", pedImpueGener);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(pedImpueGener);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad PedImpueGener");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad PedImpueGener");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(pedImpueGener);
		
		
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
			PedImpueGenerData pedImpueGener = new PedImpueGenerData();
			pedImpueGener.setId(new Long(claves.nextToken()));
			//pedImpueGener.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(pedImpueGener);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad PedImpueGener");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad PedImpueGener");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("PedImpueGenerLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(PedImpueGenerData pedImpueGener) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedImpueGener.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPreUpdate(PedImpueGenerData pedImpueGener) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedImpueGener.setPaisOidPais(paisOculto);
			
	}
	
	
	

	protected void cmdPostCreate(PedImpueGenerData pedImpueGener) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedImpueGener.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPostUpdate(PedImpueGenerData pedImpueGener) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedImpueGener.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




