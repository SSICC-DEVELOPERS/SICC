

/*
    INDRA/CAR/mmg
    $Id: SegVincuJerarLPExecution.java,v 1.1 2009/12/03 18:32:22 pecbazalar Exp $
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

public class SegVincuJerarLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGSegVincuJerarCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGSegVincuJerarUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGSegVincuJerarRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGSegVincuJerarQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "SegVincuJerarConectorCreate";
	public static final String CONECTOR_UPDATE = "SegVincuJerarConectorUpdate";
	public static final String CONECTOR_REMOVE = "SegVincuJerarConectorRemove";

	public SegVincuJerarLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("SegVincuJerarPage");
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
  	correspondiente a la creación de un/a nuevo SegVincuJerar*/  
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
		
		traza("MMG::Creando SegVincuJerar");
		
		String marcOidMarc = conectorParametro("marcOidMarc").trim();
		traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
		if(marcOidMarc != null && !marcOidMarc.trim().equals("")) marcOidMarc = marcOidMarc.toUpperCase();
		
		String canaOidCana = conectorParametro("canaOidCana").trim();
		traza("MMG:: Valor de atributo canaOidCana: " + canaOidCana);
		if(canaOidCana != null && !canaOidCana.trim().equals("")) canaOidCana = canaOidCana.toUpperCase();
		
		String acceOidAcce = conectorParametro("acceOidAcce").trim();
		traza("MMG:: Valor de atributo acceOidAcce: " + acceOidAcce);
		if(acceOidAcce != null && !acceOidAcce.trim().equals("")) acceOidAcce = acceOidAcce.toUpperCase();
		
		String sbacOidSbac = conectorParametro("sbacOidSbac").trim();
		traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
		if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")) sbacOidSbac = sbacOidSbac.toUpperCase();
		
		String sociOidSoci = conectorParametro("sociOidSoci").trim();
		traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
		if(sociOidSoci != null && !sociOidSoci.trim().equals("")) sociOidSoci = sociOidSoci.toUpperCase();
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		SegVincuJerarData segVincuJerar= new SegVincuJerarData();
		es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
		if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
			marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
			marcOidMarcData.setId(new Long(marcOidMarc));
		}
		segVincuJerar.setMarcOidMarc(marcOidMarcData);
		es.indra.belcorp.mso.SegCanalData canaOidCanaData = null;
		if(canaOidCana != null && !canaOidCana.trim().equals("")){
			canaOidCanaData = new es.indra.belcorp.mso.SegCanalData();
			canaOidCanaData.setId(new Long(canaOidCana));
		}
		segVincuJerar.setCanaOidCana(canaOidCanaData);
		es.indra.belcorp.mso.SegAccesData acceOidAcceData = null;
		if(acceOidAcce != null && !acceOidAcce.trim().equals("")){
			acceOidAcceData = new es.indra.belcorp.mso.SegAccesData();
			acceOidAcceData.setId(new Long(acceOidAcce));
		}
		segVincuJerar.setAcceOidAcce(acceOidAcceData);
		es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
		if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
			sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
			sbacOidSbacData.setId(new Long(sbacOidSbac));
		}
		segVincuJerar.setSbacOidSbac(sbacOidSbacData);
		es.indra.belcorp.mso.SegSocieData sociOidSociData = null;
		if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
			sociOidSociData = new es.indra.belcorp.mso.SegSocieData();
			sociOidSociData.setId(new Long(sociOidSoci));
		}
		segVincuJerar.setSociOidSoci(sociOidSociData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("segVincuJerar", segVincuJerar);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(segVincuJerar);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad SegVincuJerar");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad SegVincuJerar");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(segVincuJerar);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("SegVincuJerarLPStartUp");
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
		traza("MMG::Creando SegVincuJerar");
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		SegVincuJerarData segVincuJerar= new SegVincuJerarData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			segVincuJerar.setId(new Long(id));
		}
		segVincuJerar = (SegVincuJerarData)getSingleObject(BUSINESSID_QUERY, segVincuJerar, 
			segVincuJerar.clone(), "segVincuJerar");
		
		if(segVincuJerar == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//segVincuJerar.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("segVincuJerar", segVincuJerar);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(segVincuJerar);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad SegVincuJerar");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad SegVincuJerar");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(segVincuJerar);
		
		
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
			SegVincuJerarData segVincuJerar = new SegVincuJerarData();
			segVincuJerar.setId(new Long(claves.nextToken()));
			//segVincuJerar.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(segVincuJerar);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad SegVincuJerar");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad SegVincuJerar");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("SegVincuJerarLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(SegVincuJerarData segVincuJerar) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));segVincuJerar.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPreUpdate(SegVincuJerarData segVincuJerar) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));segVincuJerar.setPaisOidPais(paisOculto);
			
	}
	
	
	

	protected void cmdPostCreate(SegVincuJerarData segVincuJerar) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));segVincuJerar.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPostUpdate(SegVincuJerarData segVincuJerar) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));segVincuJerar.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




