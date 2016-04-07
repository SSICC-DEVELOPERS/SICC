

/*
    INDRA/CAR/mmg
    $Id: CobGrupoUsuarCobraLPExecution.java,v 1.1 2009/12/03 18:34:13 pecbazalar Exp $
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

public class CobGrupoUsuarCobraLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCobGrupoUsuarCobraCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCobGrupoUsuarCobraUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCobGrupoUsuarCobraRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCobGrupoUsuarCobraQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CobGrupoUsuarCobraConectorCreate";
	public static final String CONECTOR_UPDATE = "CobGrupoUsuarCobraConectorUpdate";
	public static final String CONECTOR_REMOVE = "CobGrupoUsuarCobraConectorRemove";

	public CobGrupoUsuarCobraLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CobGrupoUsuarCobraPage");
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
  	correspondiente a la creación de un/a nuevo CobGrupoUsuarCobra*/  
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
		
		traza("MMG::Creando CobGrupoUsuarCobra");
		
		String codGrupUsua = conectorParametro("codGrupUsua").trim();
		traza("MMG:: Valor de atributo codGrupUsua: " + codGrupUsua);
		
		String valDesc = conectorParametro("valDesc").trim();
		traza("MMG:: Valor de atributo valDesc: " + valDesc);
		
		String fecUltiEsta = conectorParametro("fecUltiEsta").trim();
		traza("MMG:: Valor de atributo fecUltiEsta: " + fecUltiEsta);
		
		String indUsuaExte = conectorParametro("indUsuaExte").trim();
		traza("MMG:: Valor de atributo indUsuaExte: " + indUsuaExte);
		
		String valTurnHoraEntr = conectorParametro("valTurnHoraEntr").trim();
		traza("MMG:: Valor de atributo valTurnHoraEntr: " + valTurnHoraEntr);
		
		String valTurnHoraSali = conectorParametro("valTurnHoraSali").trim();
		traza("MMG:: Valor de atributo valTurnHoraSali: " + valTurnHoraSali);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		String esgrOidEstaGrupUsua = conectorParametro("esgrOidEstaGrupUsua").trim();
		traza("MMG:: Valor de atributo esgrOidEstaGrupUsua: " + esgrOidEstaGrupUsua);
		
		String codUsua = conectorParametro("codUsua").trim();
		traza("MMG:: Valor de atributo codUsua: " + codUsua);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CobGrupoUsuarCobraData cobGrupoUsuarCobra= new CobGrupoUsuarCobraData();
		cobGrupoUsuarCobra.setCodGrupUsua(
			(java.lang.Long)FormatUtils.parseObject(codGrupUsua, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobGrupoUsuarCobra.setValDesc(
			(java.lang.String)FormatUtils.parseObject(valDesc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobGrupoUsuarCobra.setFecUltiEsta(
			(java.sql.Date)FormatUtils.parseObject(fecUltiEsta, "java.sql.Date", 
			 datePattern, symbols));
		cobGrupoUsuarCobra.setIndUsuaExte(
			(java.lang.Long)FormatUtils.parseObject(indUsuaExte, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobGrupoUsuarCobra.setValTurnHoraEntr(
			(java.lang.String)FormatUtils.parseObject(valTurnHoraEntr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobGrupoUsuarCobra.setValTurnHoraSali(
			(java.lang.String)FormatUtils.parseObject(valTurnHoraSali, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobGrupoUsuarCobra.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CobEstadGrupoUsuarData esgrOidEstaGrupUsuaData = null;
		if(esgrOidEstaGrupUsua != null && !esgrOidEstaGrupUsua.trim().equals("")){
			esgrOidEstaGrupUsuaData = new es.indra.belcorp.mso.CobEstadGrupoUsuarData();
			esgrOidEstaGrupUsuaData.setId(new Long(esgrOidEstaGrupUsua));
		}
		cobGrupoUsuarCobra.setEsgrOidEstaGrupUsua(esgrOidEstaGrupUsuaData);
		cobGrupoUsuarCobra.setCodUsua(
			(java.lang.String)FormatUtils.parseObject(codUsua, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobGrupoUsuarCobra", cobGrupoUsuarCobra);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(cobGrupoUsuarCobra);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CobGrupoUsuarCobra");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CobGrupoUsuarCobra");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(cobGrupoUsuarCobra);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CobGrupoUsuarCobraLPStartUp");
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
		traza("MMG::Creando CobGrupoUsuarCobra");
		
		String valDesc = conectorParametro("valDesc").trim();
		traza("MMG:: Valor de atributo valDesc: " + valDesc);
		
		String fecUltiEsta = conectorParametro("fecUltiEsta").trim();
		traza("MMG:: Valor de atributo fecUltiEsta: " + fecUltiEsta);
		
		String indUsuaExte = conectorParametro("indUsuaExte").trim();
		traza("MMG:: Valor de atributo indUsuaExte: " + indUsuaExte);
		
		String valTurnHoraEntr = conectorParametro("valTurnHoraEntr").trim();
		traza("MMG:: Valor de atributo valTurnHoraEntr: " + valTurnHoraEntr);
		
		String valTurnHoraSali = conectorParametro("valTurnHoraSali").trim();
		traza("MMG:: Valor de atributo valTurnHoraSali: " + valTurnHoraSali);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		String esgrOidEstaGrupUsua = conectorParametro("esgrOidEstaGrupUsua").trim();
		traza("MMG:: Valor de atributo esgrOidEstaGrupUsua: " + esgrOidEstaGrupUsua);
		
		String codUsua = conectorParametro("codUsua").trim();
		traza("MMG:: Valor de atributo codUsua: " + codUsua);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CobGrupoUsuarCobraData cobGrupoUsuarCobra= new CobGrupoUsuarCobraData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			cobGrupoUsuarCobra.setId(new Long(id));
		}
		cobGrupoUsuarCobra = (CobGrupoUsuarCobraData)getSingleObject(BUSINESSID_QUERY, cobGrupoUsuarCobra, 
			cobGrupoUsuarCobra.clone(), "cobGrupoUsuarCobra");
		
		if(cobGrupoUsuarCobra == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		cobGrupoUsuarCobra.setValDesc(
			(java.lang.String)FormatUtils.parseObject(valDesc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobGrupoUsuarCobra.setFecUltiEsta(
			(java.sql.Date)FormatUtils.parseObject(fecUltiEsta, "java.sql.Date", 
			 datePattern, symbols));
		cobGrupoUsuarCobra.setIndUsuaExte(
			(java.lang.Long)FormatUtils.parseObject(indUsuaExte, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobGrupoUsuarCobra.setValTurnHoraEntr(
			(java.lang.String)FormatUtils.parseObject(valTurnHoraEntr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobGrupoUsuarCobra.setValTurnHoraSali(
			(java.lang.String)FormatUtils.parseObject(valTurnHoraSali, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobGrupoUsuarCobra.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CobEstadGrupoUsuarData esgrOidEstaGrupUsuaData = null;
		if(esgrOidEstaGrupUsua != null && !esgrOidEstaGrupUsua.trim().equals("")){
			esgrOidEstaGrupUsuaData = new es.indra.belcorp.mso.CobEstadGrupoUsuarData();
			esgrOidEstaGrupUsuaData.setId(new Long(esgrOidEstaGrupUsua));
		}
		cobGrupoUsuarCobra.setEsgrOidEstaGrupUsua(esgrOidEstaGrupUsuaData);
		cobGrupoUsuarCobra.setCodUsua(
			(java.lang.String)FormatUtils.parseObject(codUsua, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//cobGrupoUsuarCobra.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobGrupoUsuarCobra", cobGrupoUsuarCobra);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(cobGrupoUsuarCobra);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CobGrupoUsuarCobra");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CobGrupoUsuarCobra");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(cobGrupoUsuarCobra);
		
		
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
			CobGrupoUsuarCobraData cobGrupoUsuarCobra = new CobGrupoUsuarCobraData();
			cobGrupoUsuarCobra.setId(new Long(claves.nextToken()));
			//cobGrupoUsuarCobra.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(cobGrupoUsuarCobra);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CobGrupoUsuarCobra");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CobGrupoUsuarCobra");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CobGrupoUsuarCobraLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(CobGrupoUsuarCobraData cobGrupoUsuarCobra) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobGrupoUsuarCobra.setPaisOidPais(paisOculto);
                /* comentado porque se ejecuta antes de guardar  y no antes de que se carge la pantalla
                java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date fecha = new java.sql.Date(format.parse("01/01/3000").getTime());
                cobGrupoUsuarCobra.setFecUltiEsta(fecha);
                cobGrupoUsuarCobra.setIndUsuaExte(new Long (0)); //segun Decu default 0*/
                
            
	}
	

	protected void cmdPreUpdate(CobGrupoUsuarCobraData cobGrupoUsuarCobra) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobGrupoUsuarCobra.setPaisOidPais(paisOculto);
                
            
	}
	
	
	

	protected void cmdPostCreate(CobGrupoUsuarCobraData cobGrupoUsuarCobra) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobGrupoUsuarCobra.setPaisOidPais(paisOculto);
                
            
	}
	

	protected void cmdPostUpdate(CobGrupoUsuarCobraData cobGrupoUsuarCobra) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobGrupoUsuarCobra.setPaisOidPais(paisOculto);
                
            
	}
	
	
	
	
}




