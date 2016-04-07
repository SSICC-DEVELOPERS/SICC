

/*
    INDRA/CAR/mmg
    $Id: BelCajaLPExecution.java,v 1.1 2009/12/03 18:34:41 pecbazalar Exp $
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

public class BelCajaLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGBelCajaCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGBelCajaUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGBelCajaRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGBelCajaQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "BelCajaConectorCreate";
	public static final String CONECTOR_UPDATE = "BelCajaConectorUpdate";
	public static final String CONECTOR_REMOVE = "BelCajaConectorRemove";

	public BelCajaLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("BelCajaPage");
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
  	correspondiente a la creación de un/a nuevo BelCaja*/  
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
		
		traza("MMG::Creando BelCaja");
		
		String sbacOidSbac = conectorParametro("sbacOidSbac").trim();
		traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
		
		String codCaja = conectorParametro("codCaja").trim();
		traza("MMG:: Valor de atributo codCaja: " + codCaja);
		if(codCaja != null && !codCaja.trim().equals("")) codCaja = codCaja.toUpperCase();
		
		String userOidUser = conectorParametro("userOidUser").trim();
		traza("MMG:: Valor de atributo userOidUser: " + userOidUser);
		
		String ticjOidTipoCaja = conectorParametro("ticjOidTipoCaja").trim();
		traza("MMG:: Valor de atributo ticjOidTipoCaja: " + ticjOidTipoCaja);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		BelCajaData belCaja= new BelCajaData();
		es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
		if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
			sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
			sbacOidSbacData.setId(new Long(sbacOidSbac));
		}
		belCaja.setSbacOidSbac(sbacOidSbacData);
		belCaja.setCodCaja(
			(java.lang.String)FormatUtils.parseObject(codCaja, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.GenUsersData userOidUserData = null;
		if(userOidUser != null && !userOidUser.trim().equals("")){
			userOidUserData = new es.indra.belcorp.mso.GenUsersData();
			userOidUserData.setId(new Long(userOidUser));
		}
		belCaja.setUserOidUser(userOidUserData);
		es.indra.belcorp.mso.BelTipoCajaData ticjOidTipoCajaData = null;
		if(ticjOidTipoCaja != null && !ticjOidTipoCaja.trim().equals("")){
			ticjOidTipoCajaData = new es.indra.belcorp.mso.BelTipoCajaData();
			ticjOidTipoCajaData.setId(new Long(ticjOidTipoCaja));
		}
		belCaja.setTicjOidTipoCaja(ticjOidTipoCajaData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("belCaja", belCaja);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(belCaja);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad BelCaja");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad BelCaja");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(belCaja);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("BelCajaLPStartUp");
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
		traza("MMG::Creando BelCaja");
		
		String sbacOidSbac = conectorParametro("sbacOidSbac").trim();
		traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
		
		String codCaja = conectorParametro("codCaja").trim();
		traza("MMG:: Valor de atributo codCaja: " + codCaja);
		if(codCaja != null && !codCaja.trim().equals("")) codCaja = codCaja.toUpperCase();
		
		String userOidUser = conectorParametro("userOidUser").trim();
		traza("MMG:: Valor de atributo userOidUser: " + userOidUser);
		
		String ticjOidTipoCaja = conectorParametro("ticjOidTipoCaja").trim();
		traza("MMG:: Valor de atributo ticjOidTipoCaja: " + ticjOidTipoCaja);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		BelCajaData belCaja= new BelCajaData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			belCaja.setId(new Long(id));
		}
		belCaja = (BelCajaData)getSingleObject(BUSINESSID_QUERY, belCaja, 
			belCaja.clone(), "belCaja");
		
		if(belCaja == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
		if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
			sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
			sbacOidSbacData.setId(new Long(sbacOidSbac));
		}
		belCaja.setSbacOidSbac(sbacOidSbacData);
		belCaja.setCodCaja(
			(java.lang.String)FormatUtils.parseObject(codCaja, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.GenUsersData userOidUserData = null;
		if(userOidUser != null && !userOidUser.trim().equals("")){
			userOidUserData = new es.indra.belcorp.mso.GenUsersData();
			userOidUserData.setId(new Long(userOidUser));
		}
		belCaja.setUserOidUser(userOidUserData);
		es.indra.belcorp.mso.BelTipoCajaData ticjOidTipoCajaData = null;
		if(ticjOidTipoCaja != null && !ticjOidTipoCaja.trim().equals("")){
			ticjOidTipoCajaData = new es.indra.belcorp.mso.BelTipoCajaData();
			ticjOidTipoCajaData.setId(new Long(ticjOidTipoCaja));
		}
		belCaja.setTicjOidTipoCaja(ticjOidTipoCajaData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//belCaja.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("belCaja", belCaja);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(belCaja);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad BelCaja");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad BelCaja");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(belCaja);
		
		
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
			BelCajaData belCaja = new BelCajaData();
			belCaja.setId(new Long(claves.nextToken()));
			//belCaja.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(belCaja);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad BelCaja");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad BelCaja");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("BelCajaLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(BelCajaData belCaja) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                belCaja.setPaisOidPais(paisOculto);
                belCaja.setValEstaCaja("C");
                
			
	}
	

	protected void cmdPreUpdate(BelCajaData belCaja) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                belCaja.setPaisOidPais(paisOculto);
                
			
	}
	
	
	

	protected void cmdPostCreate(BelCajaData belCaja) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                belCaja.setPaisOidPais(paisOculto);
                belCaja.setValEstaCaja("C");
                
			
	}
	

	protected void cmdPostUpdate(BelCajaData belCaja) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                belCaja.setPaisOidPais(paisOculto);
                
			
	}
	
	
	
	
}




