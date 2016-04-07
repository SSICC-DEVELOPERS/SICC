

/*
    INDRA/CAR/mmg
    $Id: FacFormuLPExecution.java,v 1.1 2009/12/03 18:33:46 pecbazalar Exp $
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

public class FacFormuLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGFacFormuCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGFacFormuUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGFacFormuRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGFacFormuQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "FacFormuConectorCreate";
	public static final String CONECTOR_UPDATE = "FacFormuConectorUpdate";
	public static final String CONECTOR_REMOVE = "FacFormuConectorRemove";

	public FacFormuLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("FacFormuPage");
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
  	correspondiente a la creación de un/a nuevo FacFormu*/  
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
		
		traza("MMG::Creando FacFormu");
		
		String codForm = conectorParametro("codForm").trim();
		traza("MMG:: Valor de atributo codForm: " + codForm);
		if(codForm != null && !codForm.trim().equals("")) codForm = codForm.toUpperCase();
		
		String numLine = conectorParametro("numLine").trim();
		traza("MMG:: Valor de atributo numLine: " + numLine);
		
		String valTamaForm = conectorParametro("valTamaForm").trim();
		traza("MMG:: Valor de atributo valTamaForm: " + valTamaForm);
		
		String valRutiDiseForm = conectorParametro("valRutiDiseForm").trim();
		traza("MMG:: Valor de atributo valRutiDiseForm: " + valRutiDiseForm);
		
		String indImpr = conectorParametro("indImpr").trim();
		traza("MMG:: Valor de atributo indImpr: " + indImpr);
		
		String indPrei = conectorParametro("indPrei").trim();
		traza("MMG:: Valor de atributo indPrei: " + indPrei);
		
		String indSpooIndi = conectorParametro("indSpooIndi").trim();
		traza("MMG:: Valor de atributo indSpooIndi: " + indSpooIndi);
		
		String teimOidTecn = conectorParametro("teimOidTecn").trim();
		traza("MMG:: Valor de atributo teimOidTecn: " + teimOidTecn);
		
		String valNombForm = conectorParametro("valNombForm").trim();
		traza("MMG:: Valor de atributo valNombForm: " + valNombForm);
		
		String indActi = conectorParametro("indActi").trim();
		traza("MMG:: Valor de atributo indActi: " + indActi);
		
		String indNumOfic = conectorParametro("indNumOfic").trim();
		traza("MMG:: Valor de atributo indNumOfic: " + indNumOfic);
		
		String numLineSaltPagi = conectorParametro("numLineSaltPagi").trim();
		traza("MMG:: Valor de atributo numLineSaltPagi: " + numLineSaltPagi);
		
		String tidoOidTipoDocu = conectorParametro("tidoOidTipoDocu").trim();
		traza("MMG:: Valor de atributo tidoOidTipoDocu: " + tidoOidTipoDocu);
		
		String deimOidDestImpr = conectorParametro("deimOidDestImpr").trim();
		traza("MMG:: Valor de atributo deimOidDestImpr: " + deimOidDestImpr);
		
		String tifoOidTipoForm = conectorParametro("tifoOidTipoForm").trim();
		traza("MMG:: Valor de atributo tifoOidTipoForm: " + tifoOidTipoForm);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		FacFormuData facFormu= new FacFormuData();
		facFormu.setCodForm(
			(java.lang.String)FormatUtils.parseObject(codForm, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setNumLine(
			(java.lang.Long)FormatUtils.parseObject(numLine, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setValTamaForm(
			(java.lang.String)FormatUtils.parseObject(valTamaForm, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setValRutiDiseForm(
			(java.lang.String)FormatUtils.parseObject(valRutiDiseForm, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setIndImpr(
			(java.lang.String)FormatUtils.parseObject(indImpr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setIndPrei(
			(java.lang.Long)FormatUtils.parseObject(indPrei, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setIndSpooIndi(
			(java.lang.Long)FormatUtils.parseObject(indSpooIndi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.FacTecnoImpreData teimOidTecnData = null;
		if(teimOidTecn != null && !teimOidTecn.trim().equals("")){
			teimOidTecnData = new es.indra.belcorp.mso.FacTecnoImpreData();
			teimOidTecnData.setId(new Long(teimOidTecn));
		}
		facFormu.setTeimOidTecn(teimOidTecnData);
		facFormu.setValNombForm(
			(java.lang.String)FormatUtils.parseObject(valNombForm, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setIndActi(
			(java.lang.String)FormatUtils.parseObject(indActi, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setIndNumOfic(
			(java.lang.String)FormatUtils.parseObject(indNumOfic, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setNumLineSaltPagi(
			(java.lang.Long)FormatUtils.parseObject(numLineSaltPagi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.FacTipoDocumData tidoOidTipoDocuData = null;
		if(tidoOidTipoDocu != null && !tidoOidTipoDocu.trim().equals("")){
			tidoOidTipoDocuData = new es.indra.belcorp.mso.FacTipoDocumData();
			tidoOidTipoDocuData.setId(new Long(tidoOidTipoDocu));
		}
		facFormu.setTidoOidTipoDocu(tidoOidTipoDocuData);
		es.indra.belcorp.mso.FacDestiImpreData deimOidDestImprData = null;
		if(deimOidDestImpr != null && !deimOidDestImpr.trim().equals("")){
			deimOidDestImprData = new es.indra.belcorp.mso.FacDestiImpreData();
			deimOidDestImprData.setId(new Long(deimOidDestImpr));
		}
		facFormu.setDeimOidDestImpr(deimOidDestImprData);
		es.indra.belcorp.mso.FacTipoFormuData tifoOidTipoFormData = null;
		if(tifoOidTipoForm != null && !tifoOidTipoForm.trim().equals("")){
			tifoOidTipoFormData = new es.indra.belcorp.mso.FacTipoFormuData();
			tifoOidTipoFormData.setId(new Long(tifoOidTipoForm));
		}
		facFormu.setTifoOidTipoForm(tifoOidTipoFormData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("facFormu", facFormu);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad FacFormu");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad FacFormu");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("FacFormuLPStartUp");
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
		traza("MMG::Creando FacFormu");
		
		String codForm = conectorParametro("codForm").trim();
		traza("MMG:: Valor de atributo codForm: " + codForm);
		if(codForm != null && !codForm.trim().equals("")) codForm = codForm.toUpperCase();
		
		String numLine = conectorParametro("numLine").trim();
		traza("MMG:: Valor de atributo numLine: " + numLine);
		
		String valTamaForm = conectorParametro("valTamaForm").trim();
		traza("MMG:: Valor de atributo valTamaForm: " + valTamaForm);
		
		String valRutiDiseForm = conectorParametro("valRutiDiseForm").trim();
		traza("MMG:: Valor de atributo valRutiDiseForm: " + valRutiDiseForm);
		
		String indImpr = conectorParametro("indImpr").trim();
		traza("MMG:: Valor de atributo indImpr: " + indImpr);
		
		String indPrei = conectorParametro("indPrei").trim();
		traza("MMG:: Valor de atributo indPrei: " + indPrei);
		
		String indSpooIndi = conectorParametro("indSpooIndi").trim();
		traza("MMG:: Valor de atributo indSpooIndi: " + indSpooIndi);
		
		String teimOidTecn = conectorParametro("teimOidTecn").trim();
		traza("MMG:: Valor de atributo teimOidTecn: " + teimOidTecn);
		
		String valNombForm = conectorParametro("valNombForm").trim();
		traza("MMG:: Valor de atributo valNombForm: " + valNombForm);
		
		String indActi = conectorParametro("indActi").trim();
		traza("MMG:: Valor de atributo indActi: " + indActi);
		
		String indNumOfic = conectorParametro("indNumOfic").trim();
		traza("MMG:: Valor de atributo indNumOfic: " + indNumOfic);
		
		String numLineSaltPagi = conectorParametro("numLineSaltPagi").trim();
		traza("MMG:: Valor de atributo numLineSaltPagi: " + numLineSaltPagi);
		
		String tidoOidTipoDocu = conectorParametro("tidoOidTipoDocu").trim();
		traza("MMG:: Valor de atributo tidoOidTipoDocu: " + tidoOidTipoDocu);
		
		String deimOidDestImpr = conectorParametro("deimOidDestImpr").trim();
		traza("MMG:: Valor de atributo deimOidDestImpr: " + deimOidDestImpr);
		
		String tifoOidTipoForm = conectorParametro("tifoOidTipoForm").trim();
		traza("MMG:: Valor de atributo tifoOidTipoForm: " + tifoOidTipoForm);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		FacFormuData facFormu= new FacFormuData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			facFormu.setId(new Long(id));
		}
		facFormu = (FacFormuData)getSingleObject(BUSINESSID_QUERY, facFormu, 
			facFormu.clone(), "facFormu");
		
		if(facFormu == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		facFormu.setCodForm(
			(java.lang.String)FormatUtils.parseObject(codForm, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setNumLine(
			(java.lang.Long)FormatUtils.parseObject(numLine, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setValTamaForm(
			(java.lang.String)FormatUtils.parseObject(valTamaForm, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setValRutiDiseForm(
			(java.lang.String)FormatUtils.parseObject(valRutiDiseForm, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setIndImpr(
			(java.lang.String)FormatUtils.parseObject(indImpr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setIndPrei(
			(java.lang.Long)FormatUtils.parseObject(indPrei, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setIndSpooIndi(
			(java.lang.Long)FormatUtils.parseObject(indSpooIndi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.FacTecnoImpreData teimOidTecnData = null;
		if(teimOidTecn != null && !teimOidTecn.trim().equals("")){
			teimOidTecnData = new es.indra.belcorp.mso.FacTecnoImpreData();
			teimOidTecnData.setId(new Long(teimOidTecn));
		}
		facFormu.setTeimOidTecn(teimOidTecnData);
		facFormu.setValNombForm(
			(java.lang.String)FormatUtils.parseObject(valNombForm, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setIndActi(
			(java.lang.String)FormatUtils.parseObject(indActi, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setIndNumOfic(
			(java.lang.String)FormatUtils.parseObject(indNumOfic, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facFormu.setNumLineSaltPagi(
			(java.lang.Long)FormatUtils.parseObject(numLineSaltPagi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.FacTipoDocumData tidoOidTipoDocuData = null;
		if(tidoOidTipoDocu != null && !tidoOidTipoDocu.trim().equals("")){
			tidoOidTipoDocuData = new es.indra.belcorp.mso.FacTipoDocumData();
			tidoOidTipoDocuData.setId(new Long(tidoOidTipoDocu));
		}
		facFormu.setTidoOidTipoDocu(tidoOidTipoDocuData);
		es.indra.belcorp.mso.FacDestiImpreData deimOidDestImprData = null;
		if(deimOidDestImpr != null && !deimOidDestImpr.trim().equals("")){
			deimOidDestImprData = new es.indra.belcorp.mso.FacDestiImpreData();
			deimOidDestImprData.setId(new Long(deimOidDestImpr));
		}
		facFormu.setDeimOidDestImpr(deimOidDestImprData);
		es.indra.belcorp.mso.FacTipoFormuData tifoOidTipoFormData = null;
		if(tifoOidTipoForm != null && !tifoOidTipoForm.trim().equals("")){
			tifoOidTipoFormData = new es.indra.belcorp.mso.FacTipoFormuData();
			tifoOidTipoFormData.setId(new Long(tifoOidTipoForm));
		}
		facFormu.setTifoOidTipoForm(tifoOidTipoFormData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//facFormu.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("facFormu", facFormu);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad FacFormu");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad FacFormu");

		
		
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
			FacFormuData facFormu = new FacFormuData();
			facFormu.setId(new Long(claves.nextToken()));
			//facFormu.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(facFormu);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad FacFormu");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad FacFormu");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("FacFormuLPStartUp");
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




