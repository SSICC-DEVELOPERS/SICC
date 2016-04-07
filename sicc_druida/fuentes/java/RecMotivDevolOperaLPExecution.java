

/*
    INDRA/CAR/mmg
    $Id: RecMotivDevolOperaLPExecution.java,v 1.1 2009/12/03 18:40:31 pecbazalar Exp $
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

public class RecMotivDevolOperaLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGRecMotivDevolOperaCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGRecMotivDevolOperaUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGRecMotivDevolOperaRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGRecMotivDevolOperaQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "RecMotivDevolOperaConectorCreate";
	public static final String CONECTOR_UPDATE = "RecMotivDevolOperaConectorUpdate";
	public static final String CONECTOR_REMOVE = "RecMotivDevolOperaConectorRemove";

	public RecMotivDevolOperaLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("RecMotivDevolOperaPage");
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
  	correspondiente a la creación de un/a nuevo RecMotivDevolOpera*/  
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
		
		traza("MMG::Creando RecMotivDevolOpera");
		
		String ropeOidOper = conectorParametro("ropeOidOper").trim();
		traza("MMG:: Valor de atributo ropeOidOper: " + ropeOidOper);
		
		String modvOidMotiDevo = conectorParametro("modvOidMotiDevo").trim();
		traza("MMG:: Valor de atributo modvOidMotiDevo: " + modvOidMotiDevo);
		
		String valMarcDefe = conectorParametro("valMarcDefe").trim();
		traza("MMG:: Valor de atributo valMarcDefe: " + valMarcDefe);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		RecMotivDevolOperaData recMotivDevolOpera= new RecMotivDevolOperaData();
		es.indra.belcorp.mso.RecOperaViewData ropeOidOperData = null;
		if(ropeOidOper != null && !ropeOidOper.trim().equals("")){
			ropeOidOperData = new es.indra.belcorp.mso.RecOperaViewData();
			ropeOidOperData.setId(new Long(ropeOidOper));
		}
		recMotivDevolOpera.setRopeOidOper(ropeOidOperData);
		es.indra.belcorp.mso.RecMotivDevolData modvOidMotiDevoData = null;
		if(modvOidMotiDevo != null && !modvOidMotiDevo.trim().equals("")){
			modvOidMotiDevoData = new es.indra.belcorp.mso.RecMotivDevolData();
			modvOidMotiDevoData.setId(new Long(modvOidMotiDevo));
		}
		recMotivDevolOpera.setModvOidMotiDevo(modvOidMotiDevoData);
		recMotivDevolOpera.setValMarcDefe(
			(java.lang.Boolean)FormatUtils.parseObject(valMarcDefe.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("recMotivDevolOpera", recMotivDevolOpera);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(recMotivDevolOpera);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad RecMotivDevolOpera");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad RecMotivDevolOpera");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(recMotivDevolOpera);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("RecMotivDevolOperaLPStartUp");
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
		traza("MMG::Creando RecMotivDevolOpera");
		
		String ropeOidOper = conectorParametro("ropeOidOper").trim();
		traza("MMG:: Valor de atributo ropeOidOper: " + ropeOidOper);
		
		String modvOidMotiDevo = conectorParametro("modvOidMotiDevo").trim();
		traza("MMG:: Valor de atributo modvOidMotiDevo: " + modvOidMotiDevo);
		
		String valMarcDefe = conectorParametro("valMarcDefe").trim();
		traza("MMG:: Valor de atributo valMarcDefe: " + valMarcDefe);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		RecMotivDevolOperaData recMotivDevolOpera= new RecMotivDevolOperaData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			recMotivDevolOpera.setId(new Long(id));
		}
		recMotivDevolOpera = (RecMotivDevolOperaData)getSingleObject(BUSINESSID_QUERY, recMotivDevolOpera, 
			recMotivDevolOpera.clone(), "recMotivDevolOpera");
		
		if(recMotivDevolOpera == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.RecOperaViewData ropeOidOperData = null;
		if(ropeOidOper != null && !ropeOidOper.trim().equals("")){
			ropeOidOperData = new es.indra.belcorp.mso.RecOperaViewData();
			ropeOidOperData.setId(new Long(ropeOidOper));
		}
		recMotivDevolOpera.setRopeOidOper(ropeOidOperData);
		es.indra.belcorp.mso.RecMotivDevolData modvOidMotiDevoData = null;
		if(modvOidMotiDevo != null && !modvOidMotiDevo.trim().equals("")){
			modvOidMotiDevoData = new es.indra.belcorp.mso.RecMotivDevolData();
			modvOidMotiDevoData.setId(new Long(modvOidMotiDevo));
		}
		recMotivDevolOpera.setModvOidMotiDevo(modvOidMotiDevoData);
		recMotivDevolOpera.setValMarcDefe(
			(java.lang.Boolean)FormatUtils.parseObject(valMarcDefe.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//recMotivDevolOpera.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("recMotivDevolOpera", recMotivDevolOpera);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(recMotivDevolOpera);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad RecMotivDevolOpera");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad RecMotivDevolOpera");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(recMotivDevolOpera);
		
		
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
			RecMotivDevolOperaData recMotivDevolOpera = new RecMotivDevolOperaData();
			recMotivDevolOpera.setId(new Long(claves.nextToken()));
			//recMotivDevolOpera.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(recMotivDevolOpera);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad RecMotivDevolOpera");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad RecMotivDevolOpera");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("RecMotivDevolOperaLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(RecMotivDevolOperaData recMotivDevolOpera) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recMotivDevolOpera.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPreUpdate(RecMotivDevolOperaData recMotivDevolOpera) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recMotivDevolOpera.setPaisOidPais(paisOculto);
			
	}
	
	
	

	protected void cmdPostCreate(RecMotivDevolOperaData recMotivDevolOpera) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recMotivDevolOpera.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPostUpdate(RecMotivDevolOperaData recMotivDevolOpera) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recMotivDevolOpera.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




