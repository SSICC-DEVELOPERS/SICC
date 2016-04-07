

/*
    INDRA/CAR/mmg
    $Id: CraPerioLPExecution.java,v 1.1 2009/12/03 18:42:00 pecbazalar Exp $
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

public class CraPerioLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCraPerioCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCraPerioUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCraPerioRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCraPerioQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CraPerioConectorCreate";
	public static final String CONECTOR_UPDATE = "CraPerioConectorUpdate";
	public static final String CONECTOR_REMOVE = "CraPerioConectorRemove";

	public CraPerioLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CraPerioPage");
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
  	correspondiente a la creación de un/a nuevo CraPerio*/  
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
		
		traza("MMG::Creando CraPerio");
		
		String marcOidMarc = conectorParametro("marcOidMarc").trim();
		traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
		
		String canaOidCana = conectorParametro("canaOidCana").trim();
		traza("MMG:: Valor de atributo canaOidCana: " + canaOidCana);
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String acceOidAcce = conectorParametro("acceOidAcce").trim();
		traza("MMG:: Valor de atributo acceOidAcce: " + acceOidAcce);
		
		String periOidPeri = conectorParametro("periOidPeri").trim();
		traza("MMG:: Valor de atributo periOidPeri: " + periOidPeri);
		
		String fecInic = conectorParametro("fecInic").trim();
		traza("MMG:: Valor de atributo fecInic: " + fecInic);
		
		String fecFina = conectorParametro("fecFina").trim();
		traza("MMG:: Valor de atributo fecFina: " + fecFina);
		
		String valEsta = conectorParametro("valEsta").trim();
		traza("MMG:: Valor de atributo valEsta: " + valEsta);
		
		String valNombPeri = conectorParametro("valNombPeri").trim();
		traza("MMG:: Valor de atributo valNombPeri: " + valNombPeri);
		
		String indPeriCort = conectorParametro("indPeriCort").trim();
		traza("MMG:: Valor de atributo indPeriCort: " + indPeriCort);
		
		String indPeriCruc = conectorParametro("indPeriCruc").trim();
		traza("MMG:: Valor de atributo indPeriCruc: " + indPeriCruc);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CraPerioData craPerio= new CraPerioData();
		es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
		if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
			marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
			marcOidMarcData.setId(new Long(marcOidMarc));
		}
		craPerio.setMarcOidMarc(marcOidMarcData);
		es.indra.belcorp.mso.SegCanalData canaOidCanaData = null;
		if(canaOidCana != null && !canaOidCana.trim().equals("")){
			canaOidCanaData = new es.indra.belcorp.mso.SegCanalData();
			canaOidCanaData.setId(new Long(canaOidCana));
		}
		craPerio.setCanaOidCana(canaOidCanaData);
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		craPerio.setPaisOidPais(paisOidPaisData);
		es.indra.belcorp.mso.SegAccesData acceOidAcceData = null;
		if(acceOidAcce != null && !acceOidAcce.trim().equals("")){
			acceOidAcceData = new es.indra.belcorp.mso.SegAccesData();
			acceOidAcceData.setId(new Long(acceOidAcce));
		}
		craPerio.setAcceOidAcce(acceOidAcceData);
		es.indra.belcorp.mso.SegPerioCorpoData periOidPeriData = null;
		if(periOidPeri != null && !periOidPeri.trim().equals("")){
			periOidPeriData = new es.indra.belcorp.mso.SegPerioCorpoData();
			periOidPeriData.setId(new Long(periOidPeri));
		}
		craPerio.setPeriOidPeri(periOidPeriData);
		craPerio.setFecInic(
			(java.sql.Date)FormatUtils.parseObject(fecInic, "java.sql.Date", 
			 datePattern, symbols));
		craPerio.setFecFina(
			(java.sql.Date)FormatUtils.parseObject(fecFina, "java.sql.Date", 
			 datePattern, symbols));
		craPerio.setValEsta(
			(java.lang.Long)FormatUtils.parseObject(valEsta, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		craPerio.setValNombPeri(
			(java.lang.String)FormatUtils.parseObject(valNombPeri, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		craPerio.setIndPeriCort(
			(java.lang.Long)FormatUtils.parseObject(indPeriCort, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		craPerio.setIndPeriCruc(
			(java.lang.Long)FormatUtils.parseObject(indPeriCruc, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("craPerio", craPerio);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CraPerio");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CraPerio");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CraPerioLPStartUp");
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
		traza("MMG::Creando CraPerio");
		
		String marcOidMarc = conectorParametro("marcOidMarc").trim();
		traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
		
		String canaOidCana = conectorParametro("canaOidCana").trim();
		traza("MMG:: Valor de atributo canaOidCana: " + canaOidCana);
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String acceOidAcce = conectorParametro("acceOidAcce").trim();
		traza("MMG:: Valor de atributo acceOidAcce: " + acceOidAcce);
		
		String periOidPeri = conectorParametro("periOidPeri").trim();
		traza("MMG:: Valor de atributo periOidPeri: " + periOidPeri);
		
		String fecInic = conectorParametro("fecInic").trim();
		traza("MMG:: Valor de atributo fecInic: " + fecInic);
		
		String fecFina = conectorParametro("fecFina").trim();
		traza("MMG:: Valor de atributo fecFina: " + fecFina);
		
		String valEsta = conectorParametro("valEsta").trim();
		traza("MMG:: Valor de atributo valEsta: " + valEsta);
		
		String valNombPeri = conectorParametro("valNombPeri").trim();
		traza("MMG:: Valor de atributo valNombPeri: " + valNombPeri);
		
		String indPeriCort = conectorParametro("indPeriCort").trim();
		traza("MMG:: Valor de atributo indPeriCort: " + indPeriCort);
		
		String indPeriCruc = conectorParametro("indPeriCruc").trim();
		traza("MMG:: Valor de atributo indPeriCruc: " + indPeriCruc);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CraPerioData craPerio= new CraPerioData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			craPerio.setId(new Long(id));
		}
		craPerio = (CraPerioData)getSingleObject(BUSINESSID_QUERY, craPerio, 
			craPerio.clone(), "craPerio");
		
		if(craPerio == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
		if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
			marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
			marcOidMarcData.setId(new Long(marcOidMarc));
		}
		craPerio.setMarcOidMarc(marcOidMarcData);
		es.indra.belcorp.mso.SegCanalData canaOidCanaData = null;
		if(canaOidCana != null && !canaOidCana.trim().equals("")){
			canaOidCanaData = new es.indra.belcorp.mso.SegCanalData();
			canaOidCanaData.setId(new Long(canaOidCana));
		}
		craPerio.setCanaOidCana(canaOidCanaData);
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		craPerio.setPaisOidPais(paisOidPaisData);
		es.indra.belcorp.mso.SegAccesData acceOidAcceData = null;
		if(acceOidAcce != null && !acceOidAcce.trim().equals("")){
			acceOidAcceData = new es.indra.belcorp.mso.SegAccesData();
			acceOidAcceData.setId(new Long(acceOidAcce));
		}
		craPerio.setAcceOidAcce(acceOidAcceData);
		es.indra.belcorp.mso.SegPerioCorpoData periOidPeriData = null;
		if(periOidPeri != null && !periOidPeri.trim().equals("")){
			periOidPeriData = new es.indra.belcorp.mso.SegPerioCorpoData();
			periOidPeriData.setId(new Long(periOidPeri));
		}
		craPerio.setPeriOidPeri(periOidPeriData);
		craPerio.setFecInic(
			(java.sql.Date)FormatUtils.parseObject(fecInic, "java.sql.Date", 
			 datePattern, symbols));
		craPerio.setFecFina(
			(java.sql.Date)FormatUtils.parseObject(fecFina, "java.sql.Date", 
			 datePattern, symbols));
		craPerio.setValEsta(
			(java.lang.Long)FormatUtils.parseObject(valEsta, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		craPerio.setValNombPeri(
			(java.lang.String)FormatUtils.parseObject(valNombPeri, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		craPerio.setIndPeriCort(
			(java.lang.Long)FormatUtils.parseObject(indPeriCort, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		craPerio.setIndPeriCruc(
			(java.lang.Long)FormatUtils.parseObject(indPeriCruc, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//craPerio.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("craPerio", craPerio);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CraPerio");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CraPerio");

		
		
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
			CraPerioData craPerio = new CraPerioData();
			craPerio.setId(new Long(claves.nextToken()));
			//craPerio.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(craPerio);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CraPerio");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CraPerio");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CraPerioLPStartUp");
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




