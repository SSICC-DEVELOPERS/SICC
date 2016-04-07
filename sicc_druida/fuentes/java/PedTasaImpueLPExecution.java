

/*
    INDRA/CAR/mmg
    $Id: PedTasaImpueLPExecution.java,v 1.1 2009/12/03 18:40:19 pecbazalar Exp $
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

public class PedTasaImpueLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGPedTasaImpueCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGPedTasaImpueUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGPedTasaImpueRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGPedTasaImpueQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "PedTasaImpueConectorCreate";
	public static final String CONECTOR_UPDATE = "PedTasaImpueConectorUpdate";
	public static final String CONECTOR_REMOVE = "PedTasaImpueConectorRemove";

	public PedTasaImpueLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("PedTasaImpuePage");
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
  	correspondiente a la creación de un/a nuevo PedTasaImpue*/  
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
		
		traza("MMG::Creando PedTasaImpue");
		
		String valIndiImpu = conectorParametro("valIndiImpu").trim();
		traza("MMG:: Valor de atributo valIndiImpu: " + valIndiImpu);
		
		String valTasaImpu = conectorParametro("valTasaImpu").trim();
		traza("MMG:: Valor de atributo valTasaImpu: " + valTasaImpu);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		PedTasaImpueData pedTasaImpue= new PedTasaImpueData();
		pedTasaImpue.setValIndiImpu(
			(java.lang.String)FormatUtils.parseObject(valIndiImpu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTasaImpue.setValTasaImpu(
			(java.lang.Double)FormatUtils.parseObject(valTasaImpu, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("pedTasaImpue", pedTasaImpue);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(pedTasaImpue);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad PedTasaImpue");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad PedTasaImpue");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("PedTasaImpueLPStartUp");
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
		traza("MMG::Creando PedTasaImpue");
		
		String valIndiImpu = conectorParametro("valIndiImpu").trim();
		traza("MMG:: Valor de atributo valIndiImpu: " + valIndiImpu);
		
		String valTasaImpu = conectorParametro("valTasaImpu").trim();
		traza("MMG:: Valor de atributo valTasaImpu: " + valTasaImpu);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		PedTasaImpueData pedTasaImpue= new PedTasaImpueData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			pedTasaImpue.setId(new Long(id));
		}
		pedTasaImpue = (PedTasaImpueData)getSingleObject(BUSINESSID_QUERY, pedTasaImpue, 
			pedTasaImpue.clone(), "pedTasaImpue");
		
		if(pedTasaImpue == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		pedTasaImpue.setValIndiImpu(
			(java.lang.String)FormatUtils.parseObject(valIndiImpu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTasaImpue.setValTasaImpu(
			(java.lang.Double)FormatUtils.parseObject(valTasaImpu, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//pedTasaImpue.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("pedTasaImpue", pedTasaImpue);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(pedTasaImpue);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad PedTasaImpue");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad PedTasaImpue");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(pedTasaImpue);
		
		
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
			PedTasaImpueData pedTasaImpue = new PedTasaImpueData();
			pedTasaImpue.setId(new Long(claves.nextToken()));
			//pedTasaImpue.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(pedTasaImpue);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad PedTasaImpue");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad PedTasaImpue");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("PedTasaImpueLPStartUp");
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
			label.setEnti("PED_TASA_IMPUE");
			label.setDeta(value != null? value: "");
			localizationLabels.add(label);
		}
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(PedTasaImpueData pedTasaImpue) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedTasaImpue.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPreUpdate(PedTasaImpueData pedTasaImpue) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedTasaImpue.setPaisOidPais(paisOculto);
			
	}
	
	
	

	

	protected void cmdPostUpdate(PedTasaImpueData pedTasaImpue) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedTasaImpue.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




