

/*
    INDRA/CAR/mmg
    $Id: CccSubprLPExecution.java,v 1.1 2009/12/03 18:34:42 pecbazalar Exp $
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

public class CccSubprLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCccSubprCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCccSubprUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCccSubprRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCccSubprQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CccSubprConectorCreate";
	public static final String CONECTOR_UPDATE = "CccSubprConectorUpdate";
	public static final String CONECTOR_REMOVE = "CccSubprConectorRemove";

	public CccSubprLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CccSubprPage");
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
  	correspondiente a la creación de un/a nuevo CccSubpr*/  
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
		
		traza("MMG::Creando CccSubpr");
		
		String ccprOidProc = conectorParametro("ccprOidProc").trim();
		traza("MMG:: Valor de atributo ccprOidProc: " + ccprOidProc);
		
		String codSubp = conectorParametro("codSubp").trim();
		traza("MMG:: Valor de atributo codSubp: " + codSubp);
		
		String desSubp = conectorParametro("desSubp").trim();
		traza("MMG:: Valor de atributo desSubp: " + desSubp);
		
		String valIndiGestMarc = conectorParametro("valIndiGestMarc").trim();
		traza("MMG:: Valor de atributo valIndiGestMarc: " + valIndiGestMarc);
		
		String valIndiActuCuot = conectorParametro("valIndiActuCuot").trim();
		traza("MMG:: Valor de atributo valIndiActuCuot: " + valIndiActuCuot);
		
		String valIndiTipoAbon = conectorParametro("valIndiTipoAbon").trim();
		traza("MMG:: Valor de atributo valIndiTipoAbon: " + valIndiTipoAbon);
		
		String valIndiCons = conectorParametro("valIndiCons").trim();
		traza("MMG:: Valor de atributo valIndiCons: " + valIndiCons);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CccSubprData cccSubpr= new CccSubprData();
		es.indra.belcorp.mso.CccProceData ccprOidProcData = null;
		if(ccprOidProc != null && !ccprOidProc.trim().equals("")){
			ccprOidProcData = new es.indra.belcorp.mso.CccProceData();
			ccprOidProcData.setId(new Long(ccprOidProc));
		}
		cccSubpr.setCcprOidProc(ccprOidProcData);
		cccSubpr.setCodSubp(
			(java.lang.Long)FormatUtils.parseObject(codSubp, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSubpr.setDesSubp(
			(java.lang.String)FormatUtils.parseObject(desSubp, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSubpr.setValIndiGestMarc(
			(java.lang.Boolean)FormatUtils.parseObject(valIndiGestMarc.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSubpr.setValIndiActuCuot(
			(java.lang.Boolean)FormatUtils.parseObject(valIndiActuCuot.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSubpr.setValIndiTipoAbon(
			(java.lang.Boolean)FormatUtils.parseObject(valIndiTipoAbon.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSubpr.setValIndiCons(
			(java.lang.String)FormatUtils.parseObject(valIndiCons, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSubpr.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cccSubpr", cccSubpr);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CccSubpr");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CccSubpr");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CccSubprLPStartUp");
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
		traza("MMG::Creando CccSubpr");
		
		String ccprOidProc = conectorParametro("ccprOidProc").trim();
		traza("MMG:: Valor de atributo ccprOidProc: " + ccprOidProc);
		
		String codSubp = conectorParametro("codSubp").trim();
		traza("MMG:: Valor de atributo codSubp: " + codSubp);
		
		String valIndiGestMarc = conectorParametro("valIndiGestMarc").trim();
		traza("MMG:: Valor de atributo valIndiGestMarc: " + valIndiGestMarc);
		
		String valIndiActuCuot = conectorParametro("valIndiActuCuot").trim();
		traza("MMG:: Valor de atributo valIndiActuCuot: " + valIndiActuCuot);
		
		String valIndiTipoAbon = conectorParametro("valIndiTipoAbon").trim();
		traza("MMG:: Valor de atributo valIndiTipoAbon: " + valIndiTipoAbon);
		
		String valIndiCons = conectorParametro("valIndiCons").trim();
		traza("MMG:: Valor de atributo valIndiCons: " + valIndiCons);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CccSubprData cccSubpr= new CccSubprData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			cccSubpr.setId(new Long(id));
		}
		cccSubpr = (CccSubprData)getSingleObject(BUSINESSID_QUERY, cccSubpr, 
			cccSubpr.clone(), "cccSubpr");
		
		if(cccSubpr == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.CccProceData ccprOidProcData = null;
		if(ccprOidProc != null && !ccprOidProc.trim().equals("")){
			ccprOidProcData = new es.indra.belcorp.mso.CccProceData();
			ccprOidProcData.setId(new Long(ccprOidProc));
		}
		cccSubpr.setCcprOidProc(ccprOidProcData);
		cccSubpr.setCodSubp(
			(java.lang.Long)FormatUtils.parseObject(codSubp, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSubpr.setValIndiGestMarc(
			(java.lang.Boolean)FormatUtils.parseObject(valIndiGestMarc.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSubpr.setValIndiActuCuot(
			(java.lang.Boolean)FormatUtils.parseObject(valIndiActuCuot.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSubpr.setValIndiTipoAbon(
			(java.lang.Boolean)FormatUtils.parseObject(valIndiTipoAbon.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSubpr.setValIndiCons(
			(java.lang.String)FormatUtils.parseObject(valIndiCons, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSubpr.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//cccSubpr.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cccSubpr", cccSubpr);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CccSubpr");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CccSubpr");

		
		
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
			CccSubprData cccSubpr = new CccSubprData();
			cccSubpr.setId(new Long(claves.nextToken()));
			//cccSubpr.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(cccSubpr);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CccSubpr");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CccSubpr");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CccSubprLPStartUp");
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




