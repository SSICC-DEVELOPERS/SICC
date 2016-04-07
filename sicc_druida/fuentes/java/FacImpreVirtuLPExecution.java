

/*
    INDRA/CAR/mmg
    $Id: FacImpreVirtuLPExecution.java,v 1.1 2009/12/03 18:32:14 pecbazalar Exp $
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

public class FacImpreVirtuLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGFacImpreVirtuCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGFacImpreVirtuUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGFacImpreVirtuRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGFacImpreVirtuQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "FacImpreVirtuConectorCreate";
	public static final String CONECTOR_UPDATE = "FacImpreVirtuConectorUpdate";
	public static final String CONECTOR_REMOVE = "FacImpreVirtuConectorRemove";

	public FacImpreVirtuLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("FacImpreVirtuPage");
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
  	correspondiente a la creación de un/a nuevo FacImpreVirtu*/  
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
		
		traza("MMG::Creando FacImpreVirtu");
		
		String codImpr = conectorParametro("codImpr").trim();
		traza("MMG:: Valor de atributo codImpr: " + codImpr);
		if(codImpr != null && !codImpr.trim().equals("")) codImpr = codImpr.toUpperCase();
		
		String desImpr = conectorParametro("desImpr").trim();
		traza("MMG:: Valor de atributo desImpr: " + desImpr);
		
		String tiimOidTipo = conectorParametro("tiimOidTipo").trim();
		traza("MMG:: Valor de atributo tiimOidTipo: " + tiimOidTipo);
		
		String indEstaActi = conectorParametro("indEstaActi").trim();
		traza("MMG:: Valor de atributo indEstaActi: " + indEstaActi);
		
		String valAtr1 = conectorParametro("valAtr1").trim();
		traza("MMG:: Valor de atributo valAtr1: " + valAtr1);
		
		String valAtr2 = conectorParametro("valAtr2").trim();
		traza("MMG:: Valor de atributo valAtr2: " + valAtr2);
		
		String valAtr3 = conectorParametro("valAtr3").trim();
		traza("MMG:: Valor de atributo valAtr3: " + valAtr3);
		
		String valAtr4 = conectorParametro("valAtr4").trim();
		traza("MMG:: Valor de atributo valAtr4: " + valAtr4);
		
		String valTamaBuff = conectorParametro("valTamaBuff").trim();
		traza("MMG:: Valor de atributo valTamaBuff: " + valTamaBuff);
		
		String numSecu = conectorParametro("numSecu").trim();
		traza("MMG:: Valor de atributo numSecu: " + numSecu);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		FacImpreVirtuData facImpreVirtu= new FacImpreVirtuData();
		facImpreVirtu.setCodImpr(
			(java.lang.String)FormatUtils.parseObject(codImpr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facImpreVirtu.setDesImpr(
			(java.lang.String)FormatUtils.parseObject(desImpr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.FacTipoImpreData tiimOidTipoData = null;
		if(tiimOidTipo != null && !tiimOidTipo.trim().equals("")){
			tiimOidTipoData = new es.indra.belcorp.mso.FacTipoImpreData();
			tiimOidTipoData.setId(new Long(tiimOidTipo));
		}
		facImpreVirtu.setTiimOidTipo(tiimOidTipoData);
		facImpreVirtu.setIndEstaActi(
			(java.lang.Long)FormatUtils.parseObject(indEstaActi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facImpreVirtu.setValAtr1(
			(java.lang.String)FormatUtils.parseObject(valAtr1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facImpreVirtu.setValAtr2(
			(java.lang.String)FormatUtils.parseObject(valAtr2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facImpreVirtu.setValAtr3(
			(java.lang.String)FormatUtils.parseObject(valAtr3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facImpreVirtu.setValAtr4(
			(java.lang.String)FormatUtils.parseObject(valAtr4, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facImpreVirtu.setValTamaBuff(
			(java.lang.Long)FormatUtils.parseObject(valTamaBuff, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facImpreVirtu.setNumSecu(
			(java.lang.Long)FormatUtils.parseObject(numSecu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("facImpreVirtu", facImpreVirtu);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad FacImpreVirtu");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad FacImpreVirtu");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("FacImpreVirtuLPStartUp");
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
		traza("MMG::Creando FacImpreVirtu");
		
		String codImpr = conectorParametro("codImpr").trim();
		traza("MMG:: Valor de atributo codImpr: " + codImpr);
		if(codImpr != null && !codImpr.trim().equals("")) codImpr = codImpr.toUpperCase();
		
		String desImpr = conectorParametro("desImpr").trim();
		traza("MMG:: Valor de atributo desImpr: " + desImpr);
		
		String tiimOidTipo = conectorParametro("tiimOidTipo").trim();
		traza("MMG:: Valor de atributo tiimOidTipo: " + tiimOidTipo);
		
		String indEstaActi = conectorParametro("indEstaActi").trim();
		traza("MMG:: Valor de atributo indEstaActi: " + indEstaActi);
		
		String valAtr1 = conectorParametro("valAtr1").trim();
		traza("MMG:: Valor de atributo valAtr1: " + valAtr1);
		
		String valAtr2 = conectorParametro("valAtr2").trim();
		traza("MMG:: Valor de atributo valAtr2: " + valAtr2);
		
		String valAtr3 = conectorParametro("valAtr3").trim();
		traza("MMG:: Valor de atributo valAtr3: " + valAtr3);
		
		String valAtr4 = conectorParametro("valAtr4").trim();
		traza("MMG:: Valor de atributo valAtr4: " + valAtr4);
		
		String valTamaBuff = conectorParametro("valTamaBuff").trim();
		traza("MMG:: Valor de atributo valTamaBuff: " + valTamaBuff);
		
		String numSecu = conectorParametro("numSecu").trim();
		traza("MMG:: Valor de atributo numSecu: " + numSecu);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		FacImpreVirtuData facImpreVirtu= new FacImpreVirtuData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			facImpreVirtu.setId(new Long(id));
		}
		facImpreVirtu = (FacImpreVirtuData)getSingleObject(BUSINESSID_QUERY, facImpreVirtu, 
			facImpreVirtu.clone(), "facImpreVirtu");
		
		if(facImpreVirtu == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		facImpreVirtu.setCodImpr(
			(java.lang.String)FormatUtils.parseObject(codImpr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facImpreVirtu.setDesImpr(
			(java.lang.String)FormatUtils.parseObject(desImpr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.FacTipoImpreData tiimOidTipoData = null;
		if(tiimOidTipo != null && !tiimOidTipo.trim().equals("")){
			tiimOidTipoData = new es.indra.belcorp.mso.FacTipoImpreData();
			tiimOidTipoData.setId(new Long(tiimOidTipo));
		}
		facImpreVirtu.setTiimOidTipo(tiimOidTipoData);
		facImpreVirtu.setIndEstaActi(
			(java.lang.Long)FormatUtils.parseObject(indEstaActi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facImpreVirtu.setValAtr1(
			(java.lang.String)FormatUtils.parseObject(valAtr1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facImpreVirtu.setValAtr2(
			(java.lang.String)FormatUtils.parseObject(valAtr2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facImpreVirtu.setValAtr3(
			(java.lang.String)FormatUtils.parseObject(valAtr3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facImpreVirtu.setValAtr4(
			(java.lang.String)FormatUtils.parseObject(valAtr4, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facImpreVirtu.setValTamaBuff(
			(java.lang.Long)FormatUtils.parseObject(valTamaBuff, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facImpreVirtu.setNumSecu(
			(java.lang.Long)FormatUtils.parseObject(numSecu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//facImpreVirtu.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("facImpreVirtu", facImpreVirtu);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad FacImpreVirtu");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad FacImpreVirtu");

		
		
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
			FacImpreVirtuData facImpreVirtu = new FacImpreVirtuData();
			facImpreVirtu.setId(new Long(claves.nextToken()));
			//facImpreVirtu.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(facImpreVirtu);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad FacImpreVirtu");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad FacImpreVirtu");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("FacImpreVirtuLPStartUp");
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




