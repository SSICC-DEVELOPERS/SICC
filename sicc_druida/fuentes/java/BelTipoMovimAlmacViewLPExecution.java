

/*
    INDRA/CAR/mmg
    $Id: BelTipoMovimAlmacViewLPExecution.java,v 1.1 2009/12/03 18:42:12 pecbazalar Exp $
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

public class BelTipoMovimAlmacViewLPExecution extends MMGDruidaBase{
	//Constantes de l�ogica de negocio
	public static final String BUSINESSID_CREATE= "MMGBelTipoMovimAlmacViewCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGBelTipoMovimAlmacViewUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGBelTipoMovimAlmacViewRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGBelTipoMovimAlmacViewQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "BelTipoMovimAlmacViewConectorCreate";
	public static final String CONECTOR_UPDATE = "BelTipoMovimAlmacViewConectorUpdate";
	public static final String CONECTOR_REMOVE = "BelTipoMovimAlmacViewConectorRemove";

	public BelTipoMovimAlmacViewLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("BelTipoMovimAlmacViewPage");
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
  	correspondiente a la creaci�n de un/a nuevo BelTipoMovimAlmacView*/  
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
		
		traza("MMG::Creando BelTipoMovimAlmacView");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String codTipoMovi = conectorParametro("codTipoMovi").trim();
		traza("MMG:: Valor de atributo codTipoMovi: " + codTipoMovi);
		
		String codMoviSap = conectorParametro("codMoviSap").trim();
		traza("MMG:: Valor de atributo codMoviSap: " + codMoviSap);
		
		String indMoviEntrAlma = conectorParametro("indMoviEntrAlma").trim();
		traza("MMG:: Valor de atributo indMoviEntrAlma: " + indMoviEntrAlma);
		
		String indMantMovi = conectorParametro("indMantMovi").trim();
		traza("MMG:: Valor de atributo indMantMovi: " + indMantMovi);
		
		String indSap = conectorParametro("indSap").trim();
		traza("MMG:: Valor de atributo indSap: " + indSap);
		
		String codOper1 = conectorParametro("codOper1").trim();
		traza("MMG:: Valor de atributo codOper1: " + codOper1);
		
		String codOper2 = conectorParametro("codOper2").trim();
		traza("MMG:: Valor de atributo codOper2: " + codOper2);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		BelTipoMovimAlmacViewData belTipoMovimAlmacView= new BelTipoMovimAlmacViewData();
		es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		belTipoMovimAlmacView.setPaisOidPais(paisOidPaisData);
		belTipoMovimAlmacView.setCodTipoMovi(
			(java.lang.String)FormatUtils.parseObject(codTipoMovi, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmacView.setCodMoviSap(
			(java.lang.String)FormatUtils.parseObject(codMoviSap, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmacView.setIndMoviEntrAlma(
			(java.lang.Long)FormatUtils.parseObject(indMoviEntrAlma, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmacView.setIndMantMovi(
			(java.lang.Long)FormatUtils.parseObject(indMantMovi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmacView.setIndSap(
			(java.lang.Long)FormatUtils.parseObject(indSap, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmacView.setCodOper1(
			(java.lang.String)FormatUtils.parseObject(codOper1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmacView.setCodOper2(
			(java.lang.String)FormatUtils.parseObject(codOper2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("belTipoMovimAlmacView", belTipoMovimAlmacView);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Create de entidad BelTipoMovimAlmacView");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecuci�n Create de entidad BelTipoMovimAlmacView");
		
		
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp
		conectorAction("BelTipoMovimAlmacViewLPStartUp");
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
		traza("MMG::Creando BelTipoMovimAlmacView");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String codTipoMovi = conectorParametro("codTipoMovi").trim();
		traza("MMG:: Valor de atributo codTipoMovi: " + codTipoMovi);
		
		String codMoviSap = conectorParametro("codMoviSap").trim();
		traza("MMG:: Valor de atributo codMoviSap: " + codMoviSap);
		
		String indMoviEntrAlma = conectorParametro("indMoviEntrAlma").trim();
		traza("MMG:: Valor de atributo indMoviEntrAlma: " + indMoviEntrAlma);
		
		String indMantMovi = conectorParametro("indMantMovi").trim();
		traza("MMG:: Valor de atributo indMantMovi: " + indMantMovi);
		
		String indSap = conectorParametro("indSap").trim();
		traza("MMG:: Valor de atributo indSap: " + indSap);
		
		String codOper1 = conectorParametro("codOper1").trim();
		traza("MMG:: Valor de atributo codOper1: " + codOper1);
		
		String codOper2 = conectorParametro("codOper2").trim();
		traza("MMG:: Valor de atributo codOper2: " + codOper2);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		BelTipoMovimAlmacViewData belTipoMovimAlmacView= new BelTipoMovimAlmacViewData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			belTipoMovimAlmacView.setId(new Long(id));
		}
		belTipoMovimAlmacView = (BelTipoMovimAlmacViewData)getSingleObject(BUSINESSID_QUERY, belTipoMovimAlmacView, 
			belTipoMovimAlmacView.clone(), "belTipoMovimAlmacView");
		
		if(belTipoMovimAlmacView == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		belTipoMovimAlmacView.setPaisOidPais(paisOidPaisData);
		belTipoMovimAlmacView.setCodTipoMovi(
			(java.lang.String)FormatUtils.parseObject(codTipoMovi, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmacView.setCodMoviSap(
			(java.lang.String)FormatUtils.parseObject(codMoviSap, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmacView.setIndMoviEntrAlma(
			(java.lang.Long)FormatUtils.parseObject(indMoviEntrAlma, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmacView.setIndMantMovi(
			(java.lang.Long)FormatUtils.parseObject(indMantMovi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmacView.setIndSap(
			(java.lang.Long)FormatUtils.parseObject(indSap, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmacView.setCodOper1(
			(java.lang.String)FormatUtils.parseObject(codOper1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belTipoMovimAlmacView.setCodOper2(
			(java.lang.String)FormatUtils.parseObject(codOper2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//belTipoMovimAlmacView.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de realizar una modificaci�n
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("belTipoMovimAlmacView", belTipoMovimAlmacView);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Update de entidad BelTipoMovimAlmacView");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecuci�n Update de entidad BelTipoMovimAlmacView");

		
		
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
			BelTipoMovimAlmacViewData belTipoMovimAlmacView = new BelTipoMovimAlmacViewData();
			belTipoMovimAlmacView.setId(new Long(claves.nextToken()));
			//belTipoMovimAlmacView.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(belTipoMovimAlmacView);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Remove de entidad BelTipoMovimAlmacView");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecuci�n Remove de entidad BelTipoMovimAlmacView");
		
		

		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp y requery
		conectorAction("BelTipoMovimAlmacViewLPStartUp");
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




