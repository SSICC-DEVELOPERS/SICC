

/*
    INDRA/CAR/mmg
    $Id: CobMetodLiquiViewLPExecution.java,v 1.1 2009/12/03 18:41:40 pecbazalar Exp $
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

public class CobMetodLiquiViewLPExecution extends MMGDruidaBase{
	//Constantes de l�ogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCobMetodLiquiViewCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCobMetodLiquiViewUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCobMetodLiquiViewRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCobMetodLiquiViewQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CobMetodLiquiViewConectorCreate";
	public static final String CONECTOR_UPDATE = "CobMetodLiquiViewConectorUpdate";
	public static final String CONECTOR_REMOVE = "CobMetodLiquiViewConectorRemove";

	public CobMetodLiquiViewLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CobMetodLiquiViewPage");
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
  	correspondiente a la creaci�n de un/a nuevo CobMetodLiquiView*/  
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
		
		traza("MMG::Creando CobMetodLiquiView");
		
		String codMetoLiqu = conectorParametro("codMetoLiqu").trim();
		traza("MMG:: Valor de atributo codMetoLiqu: " + codMetoLiqu);
		if(codMetoLiqu != null && !codMetoLiqu.trim().equals("")) codMetoLiqu = codMetoLiqu.toUpperCase();
		
		String valDescMetoLiqu = conectorParametro("valDescMetoLiqu").trim();
		traza("MMG:: Valor de atributo valDescMetoLiqu: " + valDescMetoLiqu);
		
		String indLiqu = conectorParametro("indLiqu").trim();
		traza("MMG:: Valor de atributo indLiqu: " + indLiqu);
		
		String indLiquGrupUsua = conectorParametro("indLiquGrupUsua").trim();
		traza("MMG:: Valor de atributo indLiquGrupUsua: " + indLiquGrupUsua);
		
		String baesOidBaseEsca = conectorParametro("baesOidBaseEsca").trim();
		traza("MMG:: Valor de atributo baesOidBaseEsca: " + baesOidBaseEsca);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CobMetodLiquiViewData cobMetodLiquiView= new CobMetodLiquiViewData();
		cobMetodLiquiView.setCodMetoLiqu(
			(java.lang.String)FormatUtils.parseObject(codMetoLiqu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobMetodLiquiView.setValDescMetoLiqu(
			(java.lang.String)FormatUtils.parseObject(valDescMetoLiqu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobMetodLiquiView.setIndLiqu(
			(java.lang.Long)FormatUtils.parseObject(indLiqu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobMetodLiquiView.setIndLiquGrupUsua(
			(java.lang.Long)FormatUtils.parseObject(indLiquGrupUsua, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CobBaseEscalData baesOidBaseEscaData = null;
		if(baesOidBaseEsca != null && !baesOidBaseEsca.trim().equals("")){
			baesOidBaseEscaData = new es.indra.belcorp.mso.CobBaseEscalData();
			baesOidBaseEscaData.setId(new Long(baesOidBaseEsca));
		}
		cobMetodLiquiView.setBaesOidBaseEsca(baesOidBaseEscaData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobMetodLiquiView", cobMetodLiquiView);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acci�n de precreate
		cmdPreCreate(cobMetodLiquiView);
		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Create de entidad CobMetodLiquiView");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecuci�n Create de entidad CobMetodLiquiView");
		
		//Ejecutamos la acci�n de postcreate
		cmdPostCreate(cobMetodLiquiView);
		
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp
		conectorAction("CobMetodLiquiViewLPStartUp");
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
		traza("MMG::Creando CobMetodLiquiView");
		
		String codMetoLiqu = conectorParametro("codMetoLiqu").trim();
		traza("MMG:: Valor de atributo codMetoLiqu: " + codMetoLiqu);
		if(codMetoLiqu != null && !codMetoLiqu.trim().equals("")) codMetoLiqu = codMetoLiqu.toUpperCase();
		
		String valDescMetoLiqu = conectorParametro("valDescMetoLiqu").trim();
		traza("MMG:: Valor de atributo valDescMetoLiqu: " + valDescMetoLiqu);
		
		String indLiqu = conectorParametro("indLiqu").trim();
		traza("MMG:: Valor de atributo indLiqu: " + indLiqu);
		
		String indLiquGrupUsua = conectorParametro("indLiquGrupUsua").trim();
		traza("MMG:: Valor de atributo indLiquGrupUsua: " + indLiquGrupUsua);
		
		String baesOidBaseEsca = conectorParametro("baesOidBaseEsca").trim();
		traza("MMG:: Valor de atributo baesOidBaseEsca: " + baesOidBaseEsca);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CobMetodLiquiViewData cobMetodLiquiView= new CobMetodLiquiViewData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			cobMetodLiquiView.setId(new Long(id));
		}
		cobMetodLiquiView = (CobMetodLiquiViewData)getSingleObject(BUSINESSID_QUERY, cobMetodLiquiView, 
			cobMetodLiquiView.clone(), "cobMetodLiquiView");
		
		if(cobMetodLiquiView == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		cobMetodLiquiView.setCodMetoLiqu(
			(java.lang.String)FormatUtils.parseObject(codMetoLiqu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobMetodLiquiView.setValDescMetoLiqu(
			(java.lang.String)FormatUtils.parseObject(valDescMetoLiqu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobMetodLiquiView.setIndLiqu(
			(java.lang.Long)FormatUtils.parseObject(indLiqu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobMetodLiquiView.setIndLiquGrupUsua(
			(java.lang.Long)FormatUtils.parseObject(indLiquGrupUsua, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CobBaseEscalData baesOidBaseEscaData = null;
		if(baesOidBaseEsca != null && !baesOidBaseEsca.trim().equals("")){
			baesOidBaseEscaData = new es.indra.belcorp.mso.CobBaseEscalData();
			baesOidBaseEscaData.setId(new Long(baesOidBaseEsca));
		}
		cobMetodLiquiView.setBaesOidBaseEsca(baesOidBaseEscaData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//cobMetodLiquiView.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de realizar una modificaci�n
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobMetodLiquiView", cobMetodLiquiView);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acci�n de preupdate
		cmdPreUpdate(cobMetodLiquiView);
		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Update de entidad CobMetodLiquiView");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecuci�n Update de entidad CobMetodLiquiView");

		//Ejecutamos la acci�n de postupdate
		cmdPostUpdate(cobMetodLiquiView);
		
		
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
			CobMetodLiquiViewData cobMetodLiquiView = new CobMetodLiquiViewData();
			cobMetodLiquiView.setId(new Long(claves.nextToken()));
			//cobMetodLiquiView.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(cobMetodLiquiView);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Remove de entidad CobMetodLiquiView");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecuci�n Remove de entidad CobMetodLiquiView");
		
		

		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp y requery
		conectorAction("CobMetodLiquiViewLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(CobMetodLiquiViewData cobMetodLiquiView) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobMetodLiquiView.setPaisOidPais(paisOculto);
                
	}
	

	protected void cmdPreUpdate(CobMetodLiquiViewData cobMetodLiquiView) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobMetodLiquiView.setPaisOidPais(paisOculto);
                
	}
	
	
	

	protected void cmdPostCreate(CobMetodLiquiViewData cobMetodLiquiView) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobMetodLiquiView.setPaisOidPais(paisOculto);
                
	}
	

	protected void cmdPostUpdate(CobMetodLiquiViewData cobMetodLiquiView) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobMetodLiquiView.setPaisOidPais(paisOculto);
                
	}
	
	
	
	
}




