

/*
    INDRA/CAR/mmg
    $Id: CccTipoAbonoSubprLPExecution.java,v 1.1 2009/12/03 18:42:56 pecbazalar Exp $
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

public class CccTipoAbonoSubprLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCccTipoAbonoSubprCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCccTipoAbonoSubprUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCccTipoAbonoSubprRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCccTipoAbonoSubprQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CccTipoAbonoSubprConectorCreate";
	public static final String CONECTOR_UPDATE = "CccTipoAbonoSubprConectorUpdate";
	public static final String CONECTOR_REMOVE = "CccTipoAbonoSubprConectorRemove";

	public CccTipoAbonoSubprLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CccTipoAbonoSubprPage");
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
  	correspondiente a la creación de un/a nuevo CccTipoAbonoSubpr*/  
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
		
		traza("MMG::Creando CccTipoAbonoSubpr");
		
		String subpOidSubp = conectorParametro("subpOidSubp").trim();
		traza("MMG:: Valor de atributo subpOidSubp: " + subpOidSubp);
		
		String tcabOidTcab = conectorParametro("tcabOidTcab").trim();
		traza("MMG:: Valor de atributo tcabOidTcab: " + tcabOidTcab);
		
		String cucoOidCuenCont = conectorParametro("cucoOidCuenCont").trim();
		traza("MMG:: Valor de atributo cucoOidCuenCont: " + cucoOidCuenCont);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CccTipoAbonoSubprData cccTipoAbonoSubpr= new CccTipoAbonoSubprData();
		es.indra.belcorp.mso.CccSubprData subpOidSubpData = null;
		if(subpOidSubp != null && !subpOidSubp.trim().equals("")){
			subpOidSubpData = new es.indra.belcorp.mso.CccSubprData();
			subpOidSubpData.setId(new Long(subpOidSubp));
		}
		cccTipoAbonoSubpr.setSubpOidSubp(subpOidSubpData);
		es.indra.belcorp.mso.CccTipoCargoAbonoData tcabOidTcabData = null;
		if(tcabOidTcab != null && !tcabOidTcab.trim().equals("")){
			tcabOidTcabData = new es.indra.belcorp.mso.CccTipoCargoAbonoData();
			tcabOidTcabData.setId(new Long(tcabOidTcab));
		}
		cccTipoAbonoSubpr.setTcabOidTcab(tcabOidTcabData);
		es.indra.belcorp.mso.CccCuentContaData cucoOidCuenContData = null;
		if(cucoOidCuenCont != null && !cucoOidCuenCont.trim().equals("")){
			cucoOidCuenContData = new es.indra.belcorp.mso.CccCuentContaData();
			cucoOidCuenContData.setId(new Long(cucoOidCuenCont));
		}
		cccTipoAbonoSubpr.setCucoOidCuenCont(cucoOidCuenContData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cccTipoAbonoSubpr", cccTipoAbonoSubpr);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CccTipoAbonoSubpr");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CccTipoAbonoSubpr");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CccTipoAbonoSubprLPStartUp");
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
		traza("MMG::Creando CccTipoAbonoSubpr");
		
		String subpOidSubp = conectorParametro("subpOidSubp").trim();
		traza("MMG:: Valor de atributo subpOidSubp: " + subpOidSubp);
		
		String tcabOidTcab = conectorParametro("tcabOidTcab").trim();
		traza("MMG:: Valor de atributo tcabOidTcab: " + tcabOidTcab);
		
		String cucoOidCuenCont = conectorParametro("cucoOidCuenCont").trim();
		traza("MMG:: Valor de atributo cucoOidCuenCont: " + cucoOidCuenCont);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CccTipoAbonoSubprData cccTipoAbonoSubpr= new CccTipoAbonoSubprData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			cccTipoAbonoSubpr.setId(new Long(id));
		}
		cccTipoAbonoSubpr = (CccTipoAbonoSubprData)getSingleObject(BUSINESSID_QUERY, cccTipoAbonoSubpr, 
			cccTipoAbonoSubpr.clone(), "cccTipoAbonoSubpr");
		
		if(cccTipoAbonoSubpr == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.CccSubprData subpOidSubpData = null;
		if(subpOidSubp != null && !subpOidSubp.trim().equals("")){
			subpOidSubpData = new es.indra.belcorp.mso.CccSubprData();
			subpOidSubpData.setId(new Long(subpOidSubp));
		}
		cccTipoAbonoSubpr.setSubpOidSubp(subpOidSubpData);
		es.indra.belcorp.mso.CccTipoCargoAbonoData tcabOidTcabData = null;
		if(tcabOidTcab != null && !tcabOidTcab.trim().equals("")){
			tcabOidTcabData = new es.indra.belcorp.mso.CccTipoCargoAbonoData();
			tcabOidTcabData.setId(new Long(tcabOidTcab));
		}
		cccTipoAbonoSubpr.setTcabOidTcab(tcabOidTcabData);
		es.indra.belcorp.mso.CccCuentContaData cucoOidCuenContData = null;
		if(cucoOidCuenCont != null && !cucoOidCuenCont.trim().equals("")){
			cucoOidCuenContData = new es.indra.belcorp.mso.CccCuentContaData();
			cucoOidCuenContData.setId(new Long(cucoOidCuenCont));
		}
		cccTipoAbonoSubpr.setCucoOidCuenCont(cucoOidCuenContData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//cccTipoAbonoSubpr.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cccTipoAbonoSubpr", cccTipoAbonoSubpr);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CccTipoAbonoSubpr");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CccTipoAbonoSubpr");

		
		
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
			CccTipoAbonoSubprData cccTipoAbonoSubpr = new CccTipoAbonoSubprData();
			cccTipoAbonoSubpr.setId(new Long(claves.nextToken()));
			//cccTipoAbonoSubpr.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(cccTipoAbonoSubpr);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CccTipoAbonoSubpr");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CccTipoAbonoSubpr");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CccTipoAbonoSubprLPStartUp");
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




