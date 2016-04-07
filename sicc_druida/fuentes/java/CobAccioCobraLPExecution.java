

/*
    INDRA/CAR/mmg
    $Id: CobAccioCobraLPExecution.java,v 1.1 2009/12/03 18:40:39 pecbazalar Exp $
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

public class CobAccioCobraLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCobAccioCobraCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCobAccioCobraUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCobAccioCobraRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCobAccioCobraQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CobAccioCobraConectorCreate";
	public static final String CONECTOR_UPDATE = "CobAccioCobraConectorUpdate";
	public static final String CONECTOR_REMOVE = "CobAccioCobraConectorRemove";

	public CobAccioCobraLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CobAccioCobraPage");
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
  	correspondiente a la creación de un/a nuevo CobAccioCobra*/  
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
		
		traza("MMG::Creando CobAccioCobra");
		
		String codAcciCobr = conectorParametro("codAcciCobr").trim();
		traza("MMG:: Valor de atributo codAcciCobr: " + codAcciCobr);
		if(codAcciCobr != null && !codAcciCobr.trim().equals("")) codAcciCobr = codAcciCobr.toUpperCase();
		
		String valDesc = conectorParametro("valDesc").trim();
		traza("MMG:: Valor de atributo valDesc: " + valDesc);
		
		String saccOidSubtAcci = conectorParametro("saccOidSubtAcci").trim();
		traza("MMG:: Valor de atributo saccOidSubtAcci: " + saccOidSubtAcci);
		
		String indFechHoraSegu = conectorParametro("indFechHoraSegu").trim();
		traza("MMG:: Valor de atributo indFechHoraSegu: " + indFechHoraSegu);
		
		String indFechImpoComp = conectorParametro("indFechImpoComp").trim();
		traza("MMG:: Valor de atributo indFechImpoComp: " + indFechImpoComp);
		
		String indFechHoraNuevSegu = conectorParametro("indFechHoraNuevSegu").trim();
		traza("MMG:: Valor de atributo indFechHoraNuevSegu: " + indFechHoraNuevSegu);
		
		String indAporPrue = conectorParametro("indAporPrue").trim();
		traza("MMG:: Valor de atributo indAporPrue: " + indAporPrue);
		
		String indDescPrue = conectorParametro("indDescPrue").trim();
		traza("MMG:: Valor de atributo indDescPrue: " + indDescPrue);
		
		String indNumeDocuSopo = conectorParametro("indNumeDocuSopo").trim();
		traza("MMG:: Valor de atributo indNumeDocuSopo: " + indNumeDocuSopo);
		
		String indTipoDocuPago = conectorParametro("indTipoDocuPago").trim();
		traza("MMG:: Valor de atributo indTipoDocuPago: " + indTipoDocuPago);
		
		String indBancSucu = conectorParametro("indBancSucu").trim();
		traza("MMG:: Valor de atributo indBancSucu: " + indBancSucu);
		
		String indNuevDire = conectorParametro("indNuevDire").trim();
		traza("MMG:: Valor de atributo indNuevDire: " + indNuevDire);
		
		String indNuevTelf = conectorParametro("indNuevTelf").trim();
		traza("MMG:: Valor de atributo indNuevTelf: " + indNuevTelf);
		
		String indPasaAdmi = conectorParametro("indPasaAdmi").trim();
		traza("MMG:: Valor de atributo indPasaAdmi: " + indPasaAdmi);
		
		String indPetiBloqAdmi = conectorParametro("indPetiBloqAdmi").trim();
		traza("MMG:: Valor de atributo indPetiBloqAdmi: " + indPetiBloqAdmi);
		
		String indPetiDesbAdmi = conectorParametro("indPetiDesbAdmi").trim();
		traza("MMG:: Valor de atributo indPetiDesbAdmi: " + indPetiDesbAdmi);
		
		String indAcciMensReco = conectorParametro("indAcciMensReco").trim();
		traza("MMG:: Valor de atributo indAcciMensReco: " + indAcciMensReco);
		
		String indObse = conectorParametro("indObse").trim();
		traza("MMG:: Valor de atributo indObse: " + indObse);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CobAccioCobraData cobAccioCobra= new CobAccioCobraData();
		cobAccioCobra.setCodAcciCobr(
			(java.lang.String)FormatUtils.parseObject(codAcciCobr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setValDesc(
			(java.lang.String)FormatUtils.parseObject(valDesc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CobSubtiAccioData saccOidSubtAcciData = null;
		if(saccOidSubtAcci != null && !saccOidSubtAcci.trim().equals("")){
			saccOidSubtAcciData = new es.indra.belcorp.mso.CobSubtiAccioData();
			saccOidSubtAcciData.setId(new Long(saccOidSubtAcci));
		}
		cobAccioCobra.setSaccOidSubtAcci(saccOidSubtAcciData);
		cobAccioCobra.setIndFechHoraSegu(
			(java.lang.Long)FormatUtils.parseObject(indFechHoraSegu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndFechImpoComp(
			(java.lang.Long)FormatUtils.parseObject(indFechImpoComp, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndFechHoraNuevSegu(
			(java.lang.Long)FormatUtils.parseObject(indFechHoraNuevSegu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndAporPrue(
			(java.lang.Long)FormatUtils.parseObject(indAporPrue, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndDescPrue(
			(java.lang.Long)FormatUtils.parseObject(indDescPrue, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndNumeDocuSopo(
			(java.lang.Long)FormatUtils.parseObject(indNumeDocuSopo, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndTipoDocuPago(
			(java.lang.Long)FormatUtils.parseObject(indTipoDocuPago, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndBancSucu(
			(java.lang.Long)FormatUtils.parseObject(indBancSucu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndNuevDire(
			(java.lang.Long)FormatUtils.parseObject(indNuevDire, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndNuevTelf(
			(java.lang.Long)FormatUtils.parseObject(indNuevTelf, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndPasaAdmi(
			(java.lang.Long)FormatUtils.parseObject(indPasaAdmi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndPetiBloqAdmi(
			(java.lang.Long)FormatUtils.parseObject(indPetiBloqAdmi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndPetiDesbAdmi(
			(java.lang.Long)FormatUtils.parseObject(indPetiDesbAdmi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndAcciMensReco(
			(java.lang.Long)FormatUtils.parseObject(indAcciMensReco, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndObse(
			(java.lang.Long)FormatUtils.parseObject(indObse, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobAccioCobra", cobAccioCobra);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(cobAccioCobra);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CobAccioCobra");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CobAccioCobra");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(cobAccioCobra);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CobAccioCobraLPStartUp");
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
		traza("MMG::Creando CobAccioCobra");
		
		String codAcciCobr = conectorParametro("codAcciCobr").trim();
		traza("MMG:: Valor de atributo codAcciCobr: " + codAcciCobr);
		if(codAcciCobr != null && !codAcciCobr.trim().equals("")) codAcciCobr = codAcciCobr.toUpperCase();
		
		String valDesc = conectorParametro("valDesc").trim();
		traza("MMG:: Valor de atributo valDesc: " + valDesc);
		
		String saccOidSubtAcci = conectorParametro("saccOidSubtAcci").trim();
		traza("MMG:: Valor de atributo saccOidSubtAcci: " + saccOidSubtAcci);
		
		String indFechHoraSegu = conectorParametro("indFechHoraSegu").trim();
		traza("MMG:: Valor de atributo indFechHoraSegu: " + indFechHoraSegu);
		
		String indFechImpoComp = conectorParametro("indFechImpoComp").trim();
		traza("MMG:: Valor de atributo indFechImpoComp: " + indFechImpoComp);
		
		String indFechHoraNuevSegu = conectorParametro("indFechHoraNuevSegu").trim();
		traza("MMG:: Valor de atributo indFechHoraNuevSegu: " + indFechHoraNuevSegu);
		
		String indAporPrue = conectorParametro("indAporPrue").trim();
		traza("MMG:: Valor de atributo indAporPrue: " + indAporPrue);
		
		String indDescPrue = conectorParametro("indDescPrue").trim();
		traza("MMG:: Valor de atributo indDescPrue: " + indDescPrue);
		
		String indNumeDocuSopo = conectorParametro("indNumeDocuSopo").trim();
		traza("MMG:: Valor de atributo indNumeDocuSopo: " + indNumeDocuSopo);
		
		String indTipoDocuPago = conectorParametro("indTipoDocuPago").trim();
		traza("MMG:: Valor de atributo indTipoDocuPago: " + indTipoDocuPago);
		
		String indBancSucu = conectorParametro("indBancSucu").trim();
		traza("MMG:: Valor de atributo indBancSucu: " + indBancSucu);
		
		String indNuevDire = conectorParametro("indNuevDire").trim();
		traza("MMG:: Valor de atributo indNuevDire: " + indNuevDire);
		
		String indNuevTelf = conectorParametro("indNuevTelf").trim();
		traza("MMG:: Valor de atributo indNuevTelf: " + indNuevTelf);
		
		String indPasaAdmi = conectorParametro("indPasaAdmi").trim();
		traza("MMG:: Valor de atributo indPasaAdmi: " + indPasaAdmi);
		
		String indPetiBloqAdmi = conectorParametro("indPetiBloqAdmi").trim();
		traza("MMG:: Valor de atributo indPetiBloqAdmi: " + indPetiBloqAdmi);
		
		String indPetiDesbAdmi = conectorParametro("indPetiDesbAdmi").trim();
		traza("MMG:: Valor de atributo indPetiDesbAdmi: " + indPetiDesbAdmi);
		
		String indAcciMensReco = conectorParametro("indAcciMensReco").trim();
		traza("MMG:: Valor de atributo indAcciMensReco: " + indAcciMensReco);
		
		String indObse = conectorParametro("indObse").trim();
		traza("MMG:: Valor de atributo indObse: " + indObse);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CobAccioCobraData cobAccioCobra= new CobAccioCobraData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			cobAccioCobra.setId(new Long(id));
		}
		cobAccioCobra = (CobAccioCobraData)getSingleObject(BUSINESSID_QUERY, cobAccioCobra, 
			cobAccioCobra.clone(), "cobAccioCobra");
		
		if(cobAccioCobra == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		cobAccioCobra.setCodAcciCobr(
			(java.lang.String)FormatUtils.parseObject(codAcciCobr, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setValDesc(
			(java.lang.String)FormatUtils.parseObject(valDesc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CobSubtiAccioData saccOidSubtAcciData = null;
		if(saccOidSubtAcci != null && !saccOidSubtAcci.trim().equals("")){
			saccOidSubtAcciData = new es.indra.belcorp.mso.CobSubtiAccioData();
			saccOidSubtAcciData.setId(new Long(saccOidSubtAcci));
		}
		cobAccioCobra.setSaccOidSubtAcci(saccOidSubtAcciData);
		cobAccioCobra.setIndFechHoraSegu(
			(java.lang.Long)FormatUtils.parseObject(indFechHoraSegu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndFechImpoComp(
			(java.lang.Long)FormatUtils.parseObject(indFechImpoComp, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndFechHoraNuevSegu(
			(java.lang.Long)FormatUtils.parseObject(indFechHoraNuevSegu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndAporPrue(
			(java.lang.Long)FormatUtils.parseObject(indAporPrue, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndDescPrue(
			(java.lang.Long)FormatUtils.parseObject(indDescPrue, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndNumeDocuSopo(
			(java.lang.Long)FormatUtils.parseObject(indNumeDocuSopo, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndTipoDocuPago(
			(java.lang.Long)FormatUtils.parseObject(indTipoDocuPago, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndBancSucu(
			(java.lang.Long)FormatUtils.parseObject(indBancSucu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndNuevDire(
			(java.lang.Long)FormatUtils.parseObject(indNuevDire, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndNuevTelf(
			(java.lang.Long)FormatUtils.parseObject(indNuevTelf, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndPasaAdmi(
			(java.lang.Long)FormatUtils.parseObject(indPasaAdmi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndPetiBloqAdmi(
			(java.lang.Long)FormatUtils.parseObject(indPetiBloqAdmi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndPetiDesbAdmi(
			(java.lang.Long)FormatUtils.parseObject(indPetiDesbAdmi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndAcciMensReco(
			(java.lang.Long)FormatUtils.parseObject(indAcciMensReco, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setIndObse(
			(java.lang.Long)FormatUtils.parseObject(indObse, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobAccioCobra.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//cobAccioCobra.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobAccioCobra", cobAccioCobra);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(cobAccioCobra);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CobAccioCobra");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CobAccioCobra");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(cobAccioCobra);
		
		
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
			CobAccioCobraData cobAccioCobra = new CobAccioCobraData();
			cobAccioCobra.setId(new Long(claves.nextToken()));
			//cobAccioCobra.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(cobAccioCobra);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CobAccioCobra");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CobAccioCobra");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CobAccioCobraLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(CobAccioCobraData cobAccioCobra) throws Exception{
		
                
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobAccioCobra.setPaisOidPais(paisOculto);
               
            
	}
	

	protected void cmdPreUpdate(CobAccioCobraData cobAccioCobra) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobAccioCobra.setPaisOidPais(paisOculto);
                
            
	}
	
	
	

	protected void cmdPostCreate(CobAccioCobraData cobAccioCobra) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobAccioCobra.setPaisOidPais(paisOculto);
                
            
	}
	

	protected void cmdPostUpdate(CobAccioCobraData cobAccioCobra) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobAccioCobra.setPaisOidPais(paisOculto);
                
	}
	
	
	
	
}




