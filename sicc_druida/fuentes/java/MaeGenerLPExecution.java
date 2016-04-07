

/*
    INDRA/CAR/mmg
    $Id: MaeGenerLPExecution.java,v 1.1 2009/12/03 18:33:14 pecbazalar Exp $
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

public class MaeGenerLPExecution extends MMGDruidaBase{
	//Constantes de l�ogica de negocio
	public static final String BUSINESSID_CREATE= "MMGMaeGenerCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGMaeGenerUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGMaeGenerRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGMaeGenerQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "MaeGenerConectorCreate";
	public static final String CONECTOR_UPDATE = "MaeGenerConectorUpdate";
	public static final String CONECTOR_REMOVE = "MaeGenerConectorRemove";

	public MaeGenerLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("MaeGenerPage");
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		//Activamos las trazas
		setTrazaFichero();
	
		try{
			//Sacamos la acci�n a realizar y ejecutamos la acci�n correspondiente
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			
			//Caragamos los elemetnos en la pagina
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
	
			//Ejecutamos la acci�n indicada
			if(accion.equals(ACCION_CREATE)) cmdCreate();
			if(accion.equals(ACCION_UPDATE)) cmdUpdate();
			if(accion.equals(ACCION_REMOVE)) cmdRemove();
		}catch(Exception e){
			handleException(e);
		}
  }
  
  /**Permite crear un nuevo elemento de la entidad. Invoca la l�gica de negocio
  	correspondiente a la creaci�n de un/a nuevo MaeGener*/  
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
		
		traza("MMG::Creando MaeGener");
		
		String codGene = conectorParametro("codGene").trim();
		traza("MMG:: Valor de atributo codGene: " + codGene);
		if(codGene != null && !codGene.trim().equals("")) codGene = codGene.toUpperCase();
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		MaeGenerData maeGener= new MaeGenerData();
		maeGener.setCodGene(
			(java.lang.String)FormatUtils.parseObject(codGene, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeGener", maeGener);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Create de entidad MaeGener");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecuci�n Create de entidad MaeGener");
		
		
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp
		conectorAction("MaeGenerLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operaci�n de modificaci�n sobre el elemento seleccionado*/  
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
		traza("MMG::Creando MaeGener");
		
		String codGene = conectorParametro("codGene").trim();
		traza("MMG:: Valor de atributo codGene: " + codGene);
		if(codGene != null && !codGene.trim().equals("")) codGene = codGene.toUpperCase();
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		MaeGenerData maeGener= new MaeGenerData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			maeGener.setId(new Long(id));
		}
		maeGener = (MaeGenerData)getSingleObject(BUSINESSID_QUERY, maeGener, 
			maeGener.clone(), "maeGener");
		
		if(maeGener == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		maeGener.setCodGene(
			(java.lang.String)FormatUtils.parseObject(codGene, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//maeGener.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de realizar una modificaci�n
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeGener", maeGener);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acci�n de preupdate
		cmdPreUpdate(maeGener);
		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Update de entidad MaeGener");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecuci�n Update de entidad MaeGener");

		//Ejecutamos la acci�n de postupdate
		cmdPostUpdate(maeGener);
		
		
		//Redirigimos a la LP que cierra el dialogo
		//Registramos que se recagen los datos en la venta en la cual se ha producido la operaci�n
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
			MaeGenerData maeGener = new MaeGenerData();
			maeGener.setId(new Long(claves.nextToken()));
			//maeGener.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(maeGener);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Remove de entidad MaeGener");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecuci�n Remove de entidad MaeGener");
		
		

		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp y requery
		conectorAction("MaeGenerLPStartUp");
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
			label.setEnti("MAE_GENER");
			label.setDeta(value != null? value: "");
			localizationLabels.add(label);
		}
		
		
		return localizationLabels;
	}
	
	

	protected void cmdPreUpdate(MaeGenerData maeGener) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeGener.setPaisOidPais(paisOculto);
	}
	
	
	

	

	protected void cmdPostUpdate(MaeGenerData maeGener) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeGener.setPaisOidPais(paisOculto);
	}
	
	
	
	
}



