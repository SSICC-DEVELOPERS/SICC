

/*
    INDRA/CAR/mmg
    $Id: PreTipoEstraLPExecution.java,v 1.1 2009/12/03 18:38:54 pecbazalar Exp $
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

public class PreTipoEstraLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGPreTipoEstraCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGPreTipoEstraUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGPreTipoEstraRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGPreTipoEstraQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "PreTipoEstraConectorCreate";
	public static final String CONECTOR_UPDATE = "PreTipoEstraConectorUpdate";
	public static final String CONECTOR_REMOVE = "PreTipoEstraConectorRemove";

	public PreTipoEstraLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("PreTipoEstraPage");
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
  	correspondiente a la creación de un/a nuevo PreTipoEstra*/  
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
		
		traza("MMG::Creando PreTipoEstra");
		
		String codTipoEstr = conectorParametro("codTipoEstr").trim();
		traza("MMG:: Valor de atributo codTipoEstr: " + codTipoEstr);
		
		String desTipoEstr = conectorParametro("desTipoEstr").trim();
		traza("MMG:: Valor de atributo desTipoEstr: " + desTipoEstr);
		
		String indEstrGrup = conectorParametro("indEstrGrup").trim();
		traza("MMG:: Valor de atributo indEstrGrup: " + indEstrGrup);
		
		String indEstrCond = conectorParametro("indEstrCond").trim();
		traza("MMG:: Valor de atributo indEstrCond: " + indEstrCond);
		
		String indEstrVs = conectorParametro("indEstrVs").trim();
		traza("MMG:: Valor de atributo indEstrVs: " + indEstrVs);
		
		String indEstrPaqu = conectorParametro("indEstrPaqu").trim();
		traza("MMG:: Valor de atributo indEstrPaqu: " + indEstrPaqu);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		PreTipoEstraData preTipoEstra= new PreTipoEstraData();
		preTipoEstra.setCodTipoEstr(
			(java.lang.String)FormatUtils.parseObject(codTipoEstr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		preTipoEstra.setDesTipoEstr(
			(java.lang.String)FormatUtils.parseObject(desTipoEstr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		preTipoEstra.setIndEstrGrup(
			(java.lang.Long)FormatUtils.parseObject(indEstrGrup, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		preTipoEstra.setIndEstrCond(
			(java.lang.Long)FormatUtils.parseObject(indEstrCond, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		preTipoEstra.setIndEstrVs(
			(java.lang.Long)FormatUtils.parseObject(indEstrVs, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		preTipoEstra.setIndEstrPaqu(
			(java.lang.Long)FormatUtils.parseObject(indEstrPaqu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("preTipoEstra", preTipoEstra);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad PreTipoEstra");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad PreTipoEstra");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("PreTipoEstraLPStartUp");
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
		traza("MMG::Creando PreTipoEstra");
		
		String codTipoEstr = conectorParametro("codTipoEstr").trim();
		traza("MMG:: Valor de atributo codTipoEstr: " + codTipoEstr);
		
		String desTipoEstr = conectorParametro("desTipoEstr").trim();
		traza("MMG:: Valor de atributo desTipoEstr: " + desTipoEstr);
		
		String indEstrGrup = conectorParametro("indEstrGrup").trim();
		traza("MMG:: Valor de atributo indEstrGrup: " + indEstrGrup);
		
		String indEstrCond = conectorParametro("indEstrCond").trim();
		traza("MMG:: Valor de atributo indEstrCond: " + indEstrCond);
		
		String indEstrVs = conectorParametro("indEstrVs").trim();
		traza("MMG:: Valor de atributo indEstrVs: " + indEstrVs);
		
		String indEstrPaqu = conectorParametro("indEstrPaqu").trim();
		traza("MMG:: Valor de atributo indEstrPaqu: " + indEstrPaqu);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		PreTipoEstraData preTipoEstra= new PreTipoEstraData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			preTipoEstra.setId(new Long(id));
		}
		preTipoEstra = (PreTipoEstraData)getSingleObject(BUSINESSID_QUERY, preTipoEstra, 
			preTipoEstra.clone(), "preTipoEstra");
		
		if(preTipoEstra == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		preTipoEstra.setCodTipoEstr(
			(java.lang.String)FormatUtils.parseObject(codTipoEstr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		preTipoEstra.setDesTipoEstr(
			(java.lang.String)FormatUtils.parseObject(desTipoEstr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		preTipoEstra.setIndEstrGrup(
			(java.lang.Long)FormatUtils.parseObject(indEstrGrup, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		preTipoEstra.setIndEstrCond(
			(java.lang.Long)FormatUtils.parseObject(indEstrCond, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		preTipoEstra.setIndEstrVs(
			(java.lang.Long)FormatUtils.parseObject(indEstrVs, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		preTipoEstra.setIndEstrPaqu(
			(java.lang.Long)FormatUtils.parseObject(indEstrPaqu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//preTipoEstra.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("preTipoEstra", preTipoEstra);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad PreTipoEstra");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad PreTipoEstra");

		
		
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
			PreTipoEstraData preTipoEstra = new PreTipoEstraData();
			preTipoEstra.setId(new Long(claves.nextToken()));
			//preTipoEstra.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(preTipoEstra);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad PreTipoEstra");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad PreTipoEstra");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("PreTipoEstraLPStartUp");
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




