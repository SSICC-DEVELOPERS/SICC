

/*
    INDRA/CAR/mmg
    $Id: RecOperaViewLPExecution.java,v 1.1 2009/12/03 18:37:21 pecbazalar Exp $
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

public class RecOperaViewLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGRecOperaViewCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGRecOperaViewUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGRecOperaViewRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGRecOperaViewQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "RecOperaViewConectorCreate";
	public static final String CONECTOR_UPDATE = "RecOperaViewConectorUpdate";
	public static final String CONECTOR_REMOVE = "RecOperaViewConectorRemove";

	public RecOperaViewLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("RecOperaViewPage");
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
  	correspondiente a la creación de un/a nuevo RecOperaView*/  
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
		
		traza("MMG::Creando RecOperaView");
		
		String codOper = conectorParametro("codOper").trim();
		traza("MMG:: Valor de atributo codOper: " + codOper);
		if(codOper != null && !codOper.trim().equals("")) codOper = codOper.toUpperCase();
		
		String valDescLarg = conectorParametro("valDescLarg").trim();
		traza("MMG:: Valor de atributo valDescLarg: " + valDescLarg);
		
		String indAnul = conectorParametro("indAnul").trim();
		traza("MMG:: Valor de atributo indAnul: " + indAnul);
		
		String indIngrEnvi = conectorParametro("indIngrEnvi").trim();
		traza("MMG:: Valor de atributo indIngrEnvi: " + indIngrEnvi);
		
		String valIngrDevu = conectorParametro("valIngrDevu").trim();
		traza("MMG:: Valor de atributo valIngrDevu: " + valIngrDevu);
		
		String valPerd = conectorParametro("valPerd").trim();
		traza("MMG:: Valor de atributo valPerd: " + valPerd);
		
		String indEspeMercFisi = conectorParametro("indEspeMercFisi").trim();
		traza("MMG:: Valor de atributo indEspeMercFisi: " + indEspeMercFisi);
		
		String indDevuFisiFact = conectorParametro("indDevuFisiFact").trim();
		traza("MMG:: Valor de atributo indDevuFisiFact: " + indDevuFisiFact);
		
		String numCampHist = conectorParametro("numCampHist").trim();
		traza("MMG:: Valor de atributo numCampHist: " + numCampHist);
		
		String indEnviGeneDevu = conectorParametro("indEnviGeneDevu").trim();
		traza("MMG:: Valor de atributo indEnviGeneDevu: " + indEnviGeneDevu);
		
		String indDevuGeneEnvi = conectorParametro("indDevuGeneEnvi").trim();
		traza("MMG:: Valor de atributo indDevuGeneEnvi: " + indDevuGeneEnvi);
		
		String indFaltMerc = conectorParametro("indFaltMerc").trim();
		traza("MMG:: Valor de atributo indFaltMerc: " + indFaltMerc);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		RecOperaViewData recOperaView= new RecOperaViewData();
		recOperaView.setCodOper(
			(java.lang.String)FormatUtils.parseObject(codOper, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setValDescLarg(
			(java.lang.String)FormatUtils.parseObject(valDescLarg, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setIndAnul(
			(java.lang.Long)FormatUtils.parseObject(indAnul, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setIndIngrEnvi(
			(java.lang.Long)FormatUtils.parseObject(indIngrEnvi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setValIngrDevu(
			(java.lang.Long)FormatUtils.parseObject(valIngrDevu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setValPerd(
			(java.lang.Long)FormatUtils.parseObject(valPerd, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setIndEspeMercFisi(
			(java.lang.Long)FormatUtils.parseObject(indEspeMercFisi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setIndDevuFisiFact(
			(java.lang.Long)FormatUtils.parseObject(indDevuFisiFact, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setNumCampHist(
			(java.lang.Long)FormatUtils.parseObject(numCampHist, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setIndEnviGeneDevu(
			(java.lang.Long)FormatUtils.parseObject(indEnviGeneDevu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setIndDevuGeneEnvi(
			(java.lang.Long)FormatUtils.parseObject(indDevuGeneEnvi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setIndFaltMerc(
			(java.lang.Long)FormatUtils.parseObject(indFaltMerc, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("recOperaView", recOperaView);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(recOperaView);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad RecOperaView");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad RecOperaView");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(recOperaView);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("RecOperaViewLPStartUp");
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
		traza("MMG::Creando RecOperaView");
		
		String codOper = conectorParametro("codOper").trim();
		traza("MMG:: Valor de atributo codOper: " + codOper);
		if(codOper != null && !codOper.trim().equals("")) codOper = codOper.toUpperCase();
		
		String valDescLarg = conectorParametro("valDescLarg").trim();
		traza("MMG:: Valor de atributo valDescLarg: " + valDescLarg);
		
		String indAnul = conectorParametro("indAnul").trim();
		traza("MMG:: Valor de atributo indAnul: " + indAnul);
		
		String indIngrEnvi = conectorParametro("indIngrEnvi").trim();
		traza("MMG:: Valor de atributo indIngrEnvi: " + indIngrEnvi);
		
		String valIngrDevu = conectorParametro("valIngrDevu").trim();
		traza("MMG:: Valor de atributo valIngrDevu: " + valIngrDevu);
		
		String valPerd = conectorParametro("valPerd").trim();
		traza("MMG:: Valor de atributo valPerd: " + valPerd);
		
		String indEspeMercFisi = conectorParametro("indEspeMercFisi").trim();
		traza("MMG:: Valor de atributo indEspeMercFisi: " + indEspeMercFisi);
		
		String indDevuFisiFact = conectorParametro("indDevuFisiFact").trim();
		traza("MMG:: Valor de atributo indDevuFisiFact: " + indDevuFisiFact);
		
		String numCampHist = conectorParametro("numCampHist").trim();
		traza("MMG:: Valor de atributo numCampHist: " + numCampHist);
		
		String indEnviGeneDevu = conectorParametro("indEnviGeneDevu").trim();
		traza("MMG:: Valor de atributo indEnviGeneDevu: " + indEnviGeneDevu);
		
		String indDevuGeneEnvi = conectorParametro("indDevuGeneEnvi").trim();
		traza("MMG:: Valor de atributo indDevuGeneEnvi: " + indDevuGeneEnvi);
		
		String indFaltMerc = conectorParametro("indFaltMerc").trim();
		traza("MMG:: Valor de atributo indFaltMerc: " + indFaltMerc);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		RecOperaViewData recOperaView= new RecOperaViewData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			recOperaView.setId(new Long(id));
		}
		recOperaView = (RecOperaViewData)getSingleObject(BUSINESSID_QUERY, recOperaView, 
			recOperaView.clone(), "recOperaView");
		
		if(recOperaView == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		recOperaView.setCodOper(
			(java.lang.String)FormatUtils.parseObject(codOper, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setValDescLarg(
			(java.lang.String)FormatUtils.parseObject(valDescLarg, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setIndAnul(
			(java.lang.Long)FormatUtils.parseObject(indAnul, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setIndIngrEnvi(
			(java.lang.Long)FormatUtils.parseObject(indIngrEnvi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setValIngrDevu(
			(java.lang.Long)FormatUtils.parseObject(valIngrDevu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setValPerd(
			(java.lang.Long)FormatUtils.parseObject(valPerd, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setIndEspeMercFisi(
			(java.lang.Long)FormatUtils.parseObject(indEspeMercFisi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setIndDevuFisiFact(
			(java.lang.Long)FormatUtils.parseObject(indDevuFisiFact, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setNumCampHist(
			(java.lang.Long)FormatUtils.parseObject(numCampHist, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setIndEnviGeneDevu(
			(java.lang.Long)FormatUtils.parseObject(indEnviGeneDevu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setIndDevuGeneEnvi(
			(java.lang.Long)FormatUtils.parseObject(indDevuGeneEnvi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOperaView.setIndFaltMerc(
			(java.lang.Long)FormatUtils.parseObject(indFaltMerc, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//recOperaView.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("recOperaView", recOperaView);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(recOperaView);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad RecOperaView");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad RecOperaView");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(recOperaView);
		
		
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
			RecOperaViewData recOperaView = new RecOperaViewData();
			recOperaView.setId(new Long(claves.nextToken()));
			//recOperaView.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(recOperaView);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad RecOperaView");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad RecOperaView");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("RecOperaViewLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(RecOperaViewData recOperaView) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); 
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recOperaView.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPreUpdate(RecOperaViewData recOperaView) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recOperaView.setPaisOidPais(paisOculto);
			
	}
	
	
	

	protected void cmdPostCreate(RecOperaViewData recOperaView) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recOperaView.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPostUpdate(RecOperaViewData recOperaView) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); 
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recOperaView.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




