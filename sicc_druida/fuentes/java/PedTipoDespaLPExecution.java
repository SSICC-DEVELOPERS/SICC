

/*
    INDRA/CAR/mmg
    $Id: PedTipoDespaLPExecution.java,v 1.1 2009/12/03 18:35:06 pecbazalar Exp $
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

public class PedTipoDespaLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGPedTipoDespaCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGPedTipoDespaUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGPedTipoDespaRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGPedTipoDespaQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "PedTipoDespaConectorCreate";
	public static final String CONECTOR_UPDATE = "PedTipoDespaConectorUpdate";
	public static final String CONECTOR_REMOVE = "PedTipoDespaConectorRemove";

	public PedTipoDespaLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("PedTipoDespaPage");
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
  	correspondiente a la creación de un/a nuevo PedTipoDespa*/  
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
		
		traza("MMG::Creando PedTipoDespa");
		
		String codTipoDesp = conectorParametro("codTipoDesp").trim();
		traza("MMG:: Valor de atributo codTipoDesp: " + codTipoDesp);
		if(codTipoDesp != null && !codTipoDesp.trim().equals("")) codTipoDesp = codTipoDesp.toUpperCase();
		
		String indCron = conectorParametro("indCron").trim();
		traza("MMG:: Valor de atributo indCron: " + indCron);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		PedTipoDespaData pedTipoDespa= new PedTipoDespaData();
		pedTipoDespa.setCodTipoDesp(
			(java.lang.String)FormatUtils.parseObject(codTipoDesp, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoDespa.setIndCron(
			(java.lang.Boolean)FormatUtils.parseObject(indCron.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("pedTipoDespa", pedTipoDespa);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(pedTipoDespa);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad PedTipoDespa");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad PedTipoDespa");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(pedTipoDespa);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("PedTipoDespaLPStartUp");
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
		traza("MMG::Creando PedTipoDespa");
		
		String codTipoDesp = conectorParametro("codTipoDesp").trim();
		traza("MMG:: Valor de atributo codTipoDesp: " + codTipoDesp);
		if(codTipoDesp != null && !codTipoDesp.trim().equals("")) codTipoDesp = codTipoDesp.toUpperCase();
		
		String indCron = conectorParametro("indCron").trim();
		traza("MMG:: Valor de atributo indCron: " + indCron);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		PedTipoDespaData pedTipoDespa= new PedTipoDespaData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			pedTipoDespa.setId(new Long(id));
		}
		pedTipoDespa = (PedTipoDespaData)getSingleObject(BUSINESSID_QUERY, pedTipoDespa, 
			pedTipoDespa.clone(), "pedTipoDespa");
		
		if(pedTipoDespa == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		pedTipoDespa.setCodTipoDesp(
			(java.lang.String)FormatUtils.parseObject(codTipoDesp, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoDespa.setIndCron(
			(java.lang.Boolean)FormatUtils.parseObject(indCron.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//pedTipoDespa.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("pedTipoDespa", pedTipoDespa);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(pedTipoDespa);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad PedTipoDespa");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad PedTipoDespa");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(pedTipoDespa);
		
		
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
			PedTipoDespaData pedTipoDespa = new PedTipoDespaData();
			pedTipoDespa.setId(new Long(claves.nextToken()));
			//pedTipoDespa.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(pedTipoDespa);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad PedTipoDespa");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad PedTipoDespa");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("PedTipoDespaLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		for(int i=0; i < languages.size(); i++){
			Idioma languageTmp = (Idioma)languages.get(i);
			String value = conectorParametro("hi18NTraduccion_1_" + 
				languageTmp.getOid().longValue());
			if(value == null || value.trim().equals("")) continue;
			
			GenDetaSiccData label = new GenDetaSiccData();
			label.setAtri(new Long(1));
			SegIdiomData language = new SegIdiomData();
			language.setId(new Long(languageTmp.getOid().longValue()));
			label.setIdioOidIdio(language);
			label.setEnti("PED_TIPO_DESPA");
			label.setDeta(value != null? value: "");
			localizationLabels.add(label);
		}
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(PedTipoDespaData pedTipoDespa) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedTipoDespa.setPaisOidPais(paisOculto);
	}
	

	protected void cmdPreUpdate(PedTipoDespaData pedTipoDespa) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedTipoDespa.setPaisOidPais(paisOculto);
	}
	
	
	

	protected void cmdPostCreate(PedTipoDespaData pedTipoDespa) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedTipoDespa.setPaisOidPais(paisOculto);
	}
	

	protected void cmdPostUpdate(PedTipoDespaData pedTipoDespa) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedTipoDespa.setPaisOidPais(paisOculto);
	}
	
	
	
	
}




