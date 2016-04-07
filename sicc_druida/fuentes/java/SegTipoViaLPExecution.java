

/*
    INDRA/CAR/mmg
    $Id: SegTipoViaLPExecution.java,v 1.1 2009/12/03 18:34:36 pecbazalar Exp $
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

public class SegTipoViaLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGSegTipoViaCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGSegTipoViaUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGSegTipoViaRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGSegTipoViaQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "SegTipoViaConectorCreate";
	public static final String CONECTOR_UPDATE = "SegTipoViaConectorUpdate";
	public static final String CONECTOR_REMOVE = "SegTipoViaConectorRemove";

	public SegTipoViaLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("SegTipoViaPage");
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
  	correspondiente a la creación de un/a nuevo SegTipoVia*/  
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
		
		traza("MMG::Creando SegTipoVia");
		
		String codTipoVia = conectorParametro("codTipoVia").trim();
		traza("MMG:: Valor de atributo codTipoVia: " + codTipoVia);
		if(codTipoVia != null && !codTipoVia.trim().equals("")) codTipoVia = codTipoVia.toUpperCase();
		
		String desAbrvTipoVia = conectorParametro("desAbrvTipoVia").trim();
		traza("MMG:: Valor de atributo desAbrvTipoVia: " + desAbrvTipoVia);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		SegTipoViaData segTipoVia= new SegTipoViaData();
		segTipoVia.setCodTipoVia(
			(java.lang.String)FormatUtils.parseObject(codTipoVia, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segTipoVia.setDesAbrvTipoVia(
			(java.lang.String)FormatUtils.parseObject(desAbrvTipoVia, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("segTipoVia", segTipoVia);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad SegTipoVia");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad SegTipoVia");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("SegTipoViaLPStartUp");
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
		traza("MMG::Creando SegTipoVia");
		
		String codTipoVia = conectorParametro("codTipoVia").trim();
		traza("MMG:: Valor de atributo codTipoVia: " + codTipoVia);
		if(codTipoVia != null && !codTipoVia.trim().equals("")) codTipoVia = codTipoVia.toUpperCase();
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		SegTipoViaData segTipoVia= new SegTipoViaData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			segTipoVia.setId(new Long(id));
		}
		segTipoVia = (SegTipoViaData)getSingleObject(BUSINESSID_QUERY, segTipoVia, 
			segTipoVia.clone(), "segTipoVia");
		
		if(segTipoVia == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		segTipoVia.setCodTipoVia(
			(java.lang.String)FormatUtils.parseObject(codTipoVia, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//segTipoVia.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("segTipoVia", segTipoVia);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad SegTipoVia");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad SegTipoVia");

		
		
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
			SegTipoViaData segTipoVia = new SegTipoViaData();
			segTipoVia.setId(new Long(claves.nextToken()));
			//segTipoVia.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(segTipoVia);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad SegTipoVia");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad SegTipoVia");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("SegTipoViaLPStartUp");
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
			label.setEnti("SEG_TIPO_VIA");
			label.setDeta(value != null? value: "");
			localizationLabels.add(label);
		}
		
		
		return localizationLabels;
	}
	
	

	
	
	

	

	
	
	
	
}




