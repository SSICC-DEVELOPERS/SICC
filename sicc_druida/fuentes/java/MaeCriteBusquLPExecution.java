

/*
    INDRA/CAR/mmg
    $Id: MaeCriteBusquLPExecution.java,v 1.1 2009/12/03 18:35:48 pecbazalar Exp $
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

public class MaeCriteBusquLPExecution extends MMGDruidaBase{
	//Constantes de l�ogica de negocio
	public static final String BUSINESSID_CREATE= "MMGMaeCriteBusquCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGMaeCriteBusquUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGMaeCriteBusquRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGMaeCriteBusquQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "MaeCriteBusquConectorCreate";
	public static final String CONECTOR_UPDATE = "MaeCriteBusquConectorUpdate";
	public static final String CONECTOR_REMOVE = "MaeCriteBusquConectorRemove";

	public MaeCriteBusquLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("MaeCriteBusquPage");
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
  	correspondiente a la creaci�n de un/a nuevo MaeCriteBusqu*/  
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
		
		traza("MMG::Creando MaeCriteBusqu");
		
		String atreOidAtriEsp1 = conectorParametro("atreOidAtriEsp1").trim();
		traza("MMG:: Valor de atributo atreOidAtriEsp1: " + atreOidAtriEsp1);
		
		String atreOidAtriEsp2 = conectorParametro("atreOidAtriEsp2").trim();
		traza("MMG:: Valor de atributo atreOidAtriEsp2: " + atreOidAtriEsp2);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		MaeCriteBusquData maeCriteBusqu= new MaeCriteBusquData();
		es.indra.belcorp.mso.PedAtribEspecData atreOidAtriEsp1Data = null;
		if(atreOidAtriEsp1 != null && !atreOidAtriEsp1.trim().equals("")){
			atreOidAtriEsp1Data = new es.indra.belcorp.mso.PedAtribEspecData();
			atreOidAtriEsp1Data.setId(new Long(atreOidAtriEsp1));
		}
		maeCriteBusqu.setAtreOidAtriEsp1(atreOidAtriEsp1Data);
		es.indra.belcorp.mso.PedAtribEspecData atreOidAtriEsp2Data = null;
		if(atreOidAtriEsp2 != null && !atreOidAtriEsp2.trim().equals("")){
			atreOidAtriEsp2Data = new es.indra.belcorp.mso.PedAtribEspecData();
			atreOidAtriEsp2Data.setId(new Long(atreOidAtriEsp2));
		}
		maeCriteBusqu.setAtreOidAtriEsp2(atreOidAtriEsp2Data);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeCriteBusqu", maeCriteBusqu);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acci�n de precreate
		cmdPreCreate(maeCriteBusqu);
		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Create de entidad MaeCriteBusqu");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecuci�n Create de entidad MaeCriteBusqu");
		
		//Ejecutamos la acci�n de postcreate
		cmdPostCreate(maeCriteBusqu);
		
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp
		conectorAction("MaeCriteBusquLPStartUp");
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
		traza("MMG::Creando MaeCriteBusqu");
		
		String atreOidAtriEsp1 = conectorParametro("atreOidAtriEsp1").trim();
		traza("MMG:: Valor de atributo atreOidAtriEsp1: " + atreOidAtriEsp1);
		
		String atreOidAtriEsp2 = conectorParametro("atreOidAtriEsp2").trim();
		traza("MMG:: Valor de atributo atreOidAtriEsp2: " + atreOidAtriEsp2);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		MaeCriteBusquData maeCriteBusqu= new MaeCriteBusquData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			maeCriteBusqu.setId(new Long(id));
		}
		maeCriteBusqu = (MaeCriteBusquData)getSingleObject(BUSINESSID_QUERY, maeCriteBusqu, 
			maeCriteBusqu.clone(), "maeCriteBusqu");
		
		if(maeCriteBusqu == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.PedAtribEspecData atreOidAtriEsp1Data = null;
		if(atreOidAtriEsp1 != null && !atreOidAtriEsp1.trim().equals("")){
			atreOidAtriEsp1Data = new es.indra.belcorp.mso.PedAtribEspecData();
			atreOidAtriEsp1Data.setId(new Long(atreOidAtriEsp1));
		}
		maeCriteBusqu.setAtreOidAtriEsp1(atreOidAtriEsp1Data);
		es.indra.belcorp.mso.PedAtribEspecData atreOidAtriEsp2Data = null;
		if(atreOidAtriEsp2 != null && !atreOidAtriEsp2.trim().equals("")){
			atreOidAtriEsp2Data = new es.indra.belcorp.mso.PedAtribEspecData();
			atreOidAtriEsp2Data.setId(new Long(atreOidAtriEsp2));
		}
		maeCriteBusqu.setAtreOidAtriEsp2(atreOidAtriEsp2Data);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//maeCriteBusqu.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de realizar una modificaci�n
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeCriteBusqu", maeCriteBusqu);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acci�n de preupdate
		cmdPreUpdate(maeCriteBusqu);
		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Update de entidad MaeCriteBusqu");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecuci�n Update de entidad MaeCriteBusqu");

		//Ejecutamos la acci�n de postupdate
		cmdPostUpdate(maeCriteBusqu);
		
		
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
			MaeCriteBusquData maeCriteBusqu = new MaeCriteBusquData();
			maeCriteBusqu.setId(new Long(claves.nextToken()));
			//maeCriteBusqu.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(maeCriteBusqu);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Remove de entidad MaeCriteBusqu");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecuci�n Remove de entidad MaeCriteBusqu");
		
		

		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp y requery
		conectorAction("MaeCriteBusquLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(MaeCriteBusquData maeCriteBusqu) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeCriteBusqu.setPaisOidPais(paisOculto);
	}
	

	protected void cmdPreUpdate(MaeCriteBusquData maeCriteBusqu) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeCriteBusqu.setPaisOidPais(paisOculto);
	}
	
	
	

	protected void cmdPostCreate(MaeCriteBusquData maeCriteBusqu) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeCriteBusqu.setPaisOidPais(paisOculto);
	}
	

	protected void cmdPostUpdate(MaeCriteBusquData maeCriteBusqu) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeCriteBusqu.setPaisOidPais(paisOculto);
	}
	
	
	
	
}




