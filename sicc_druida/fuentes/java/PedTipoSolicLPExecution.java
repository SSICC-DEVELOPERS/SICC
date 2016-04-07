

/*
    INDRA/CAR/mmg
    $Id: PedTipoSolicLPExecution.java,v 1.1 2009/12/03 18:34:12 pecbazalar Exp $
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

public class PedTipoSolicLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGPedTipoSolicCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGPedTipoSolicUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGPedTipoSolicRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGPedTipoSolicQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "PedTipoSolicConectorCreate";
	public static final String CONECTOR_UPDATE = "PedTipoSolicConectorUpdate";
	public static final String CONECTOR_REMOVE = "PedTipoSolicConectorRemove";

	public PedTipoSolicLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("PedTipoSolicPage");
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
  	correspondiente a la creación de un/a nuevo PedTipoSolic*/  
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
		
		traza("MMG::Creando PedTipoSolic");
		
		String codTipoSoli = conectorParametro("codTipoSoli").trim();
		traza("MMG:: Valor de atributo codTipoSoli: " + codTipoSoli);
		
		String ticlOidTipoClie = conectorParametro("ticlOidTipoClie").trim();
		traza("MMG:: Valor de atributo ticlOidTipoClie: " + ticlOidTipoClie);
		
		String marcOidMarc = conectorParametro("marcOidMarc").trim();
		traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
		
		String acceOidAcce = conectorParametro("acceOidAcce").trim();
		traza("MMG:: Valor de atributo acceOidAcce: " + acceOidAcce);
		
		String clsoOidClasSoli = conectorParametro("clsoOidClasSoli").trim();
		traza("MMG:: Valor de atributo clsoOidClasSoli: " + clsoOidClasSoli);
		
		String indCons = conectorParametro("indCons").trim();
		traza("MMG:: Valor de atributo indCons: " + indCons);
		
		String indSoliNega = conectorParametro("indSoliNega").trim();
		traza("MMG:: Valor de atributo indSoliNega: " + indSoliNega);
		
		String grsoOidGrupSoli = conectorParametro("grsoOidGrupSoli").trim();
		traza("MMG:: Valor de atributo grsoOidGrupSoli: " + grsoOidGrupSoli);
		
		String indDevo = conectorParametro("indDevo").trim();
		traza("MMG:: Valor de atributo indDevo: " + indDevo);
		
		String indAnul = conectorParametro("indAnul").trim();
		traza("MMG:: Valor de atributo indAnul: " + indAnul);
		
		String sbacOidSbac = conectorParametro("sbacOidSbac").trim();
		traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
		
		String codGrupSoli = conectorParametro("codGrupSoli").trim();
		traza("MMG:: Valor de atributo codGrupSoli: " + codGrupSoli);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		PedTipoSolicData pedTipoSolic= new PedTipoSolicData();
		pedTipoSolic.setCodTipoSoli(
			(java.lang.String)FormatUtils.parseObject(codTipoSoli, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.MaeTipoClienData ticlOidTipoClieData = null;
		if(ticlOidTipoClie != null && !ticlOidTipoClie.trim().equals("")){
			ticlOidTipoClieData = new es.indra.belcorp.mso.MaeTipoClienData();
			ticlOidTipoClieData.setId(new Long(ticlOidTipoClie));
		}
		pedTipoSolic.setTiclOidTipoClie(ticlOidTipoClieData);
		es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
		if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
			marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
			marcOidMarcData.setId(new Long(marcOidMarc));
		}
		pedTipoSolic.setMarcOidMarc(marcOidMarcData);
		es.indra.belcorp.mso.SegAccesData acceOidAcceData = null;
		if(acceOidAcce != null && !acceOidAcce.trim().equals("")){
			acceOidAcceData = new es.indra.belcorp.mso.SegAccesData();
			acceOidAcceData.setId(new Long(acceOidAcce));
		}
		pedTipoSolic.setAcceOidAcce(acceOidAcceData);
		es.indra.belcorp.mso.PedClaseSolicData clsoOidClasSoliData = null;
		if(clsoOidClasSoli != null && !clsoOidClasSoli.trim().equals("")){
			clsoOidClasSoliData = new es.indra.belcorp.mso.PedClaseSolicData();
			clsoOidClasSoliData.setId(new Long(clsoOidClasSoli));
		}
		pedTipoSolic.setClsoOidClasSoli(clsoOidClasSoliData);
		pedTipoSolic.setIndCons(
			(java.lang.Long)FormatUtils.parseObject(indCons, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolic.setIndSoliNega(
			(java.lang.Long)FormatUtils.parseObject(indSoliNega, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CarGrupoSolicData grsoOidGrupSoliData = null;
		if(grsoOidGrupSoli != null && !grsoOidGrupSoli.trim().equals("")){
			grsoOidGrupSoliData = new es.indra.belcorp.mso.CarGrupoSolicData();
			grsoOidGrupSoliData.setId(new Long(grsoOidGrupSoli));
		}
		pedTipoSolic.setGrsoOidGrupSoli(grsoOidGrupSoliData);
		pedTipoSolic.setIndDevo(
			(java.lang.Long)FormatUtils.parseObject(indDevo, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolic.setIndAnul(
			(java.lang.Long)FormatUtils.parseObject(indAnul, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
		if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
			sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
			sbacOidSbacData.setId(new Long(sbacOidSbac));
		}
		pedTipoSolic.setSbacOidSbac(sbacOidSbacData);
		pedTipoSolic.setCodGrupSoli(
			(java.lang.String)FormatUtils.parseObject(codGrupSoli, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("pedTipoSolic", pedTipoSolic);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad PedTipoSolic");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad PedTipoSolic");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("PedTipoSolicLPStartUp");
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
		traza("MMG::Creando PedTipoSolic");
		
		String codTipoSoli = conectorParametro("codTipoSoli").trim();
		traza("MMG:: Valor de atributo codTipoSoli: " + codTipoSoli);
		
		String ticlOidTipoClie = conectorParametro("ticlOidTipoClie").trim();
		traza("MMG:: Valor de atributo ticlOidTipoClie: " + ticlOidTipoClie);
		
		String marcOidMarc = conectorParametro("marcOidMarc").trim();
		traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
		
		String acceOidAcce = conectorParametro("acceOidAcce").trim();
		traza("MMG:: Valor de atributo acceOidAcce: " + acceOidAcce);
		
		String clsoOidClasSoli = conectorParametro("clsoOidClasSoli").trim();
		traza("MMG:: Valor de atributo clsoOidClasSoli: " + clsoOidClasSoli);
		
		String indCons = conectorParametro("indCons").trim();
		traza("MMG:: Valor de atributo indCons: " + indCons);
		
		String indSoliNega = conectorParametro("indSoliNega").trim();
		traza("MMG:: Valor de atributo indSoliNega: " + indSoliNega);
		
		String grsoOidGrupSoli = conectorParametro("grsoOidGrupSoli").trim();
		traza("MMG:: Valor de atributo grsoOidGrupSoli: " + grsoOidGrupSoli);
		
		String indDevo = conectorParametro("indDevo").trim();
		traza("MMG:: Valor de atributo indDevo: " + indDevo);
		
		String indAnul = conectorParametro("indAnul").trim();
		traza("MMG:: Valor de atributo indAnul: " + indAnul);
		
		String sbacOidSbac = conectorParametro("sbacOidSbac").trim();
		traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
		
		String codGrupSoli = conectorParametro("codGrupSoli").trim();
		traza("MMG:: Valor de atributo codGrupSoli: " + codGrupSoli);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		PedTipoSolicData pedTipoSolic= new PedTipoSolicData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			pedTipoSolic.setId(new Long(id));
		}
		pedTipoSolic = (PedTipoSolicData)getSingleObject(BUSINESSID_QUERY, pedTipoSolic, 
			pedTipoSolic.clone(), "pedTipoSolic");
		
		if(pedTipoSolic == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		pedTipoSolic.setCodTipoSoli(
			(java.lang.String)FormatUtils.parseObject(codTipoSoli, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.MaeTipoClienData ticlOidTipoClieData = null;
		if(ticlOidTipoClie != null && !ticlOidTipoClie.trim().equals("")){
			ticlOidTipoClieData = new es.indra.belcorp.mso.MaeTipoClienData();
			ticlOidTipoClieData.setId(new Long(ticlOidTipoClie));
		}
		pedTipoSolic.setTiclOidTipoClie(ticlOidTipoClieData);
		es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
		if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
			marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
			marcOidMarcData.setId(new Long(marcOidMarc));
		}
		pedTipoSolic.setMarcOidMarc(marcOidMarcData);
		es.indra.belcorp.mso.SegAccesData acceOidAcceData = null;
		if(acceOidAcce != null && !acceOidAcce.trim().equals("")){
			acceOidAcceData = new es.indra.belcorp.mso.SegAccesData();
			acceOidAcceData.setId(new Long(acceOidAcce));
		}
		pedTipoSolic.setAcceOidAcce(acceOidAcceData);
		es.indra.belcorp.mso.PedClaseSolicData clsoOidClasSoliData = null;
		if(clsoOidClasSoli != null && !clsoOidClasSoli.trim().equals("")){
			clsoOidClasSoliData = new es.indra.belcorp.mso.PedClaseSolicData();
			clsoOidClasSoliData.setId(new Long(clsoOidClasSoli));
		}
		pedTipoSolic.setClsoOidClasSoli(clsoOidClasSoliData);
		pedTipoSolic.setIndCons(
			(java.lang.Long)FormatUtils.parseObject(indCons, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolic.setIndSoliNega(
			(java.lang.Long)FormatUtils.parseObject(indSoliNega, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CarGrupoSolicData grsoOidGrupSoliData = null;
		if(grsoOidGrupSoli != null && !grsoOidGrupSoli.trim().equals("")){
			grsoOidGrupSoliData = new es.indra.belcorp.mso.CarGrupoSolicData();
			grsoOidGrupSoliData.setId(new Long(grsoOidGrupSoli));
		}
		pedTipoSolic.setGrsoOidGrupSoli(grsoOidGrupSoliData);
		pedTipoSolic.setIndDevo(
			(java.lang.Long)FormatUtils.parseObject(indDevo, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolic.setIndAnul(
			(java.lang.Long)FormatUtils.parseObject(indAnul, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
		if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
			sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
			sbacOidSbacData.setId(new Long(sbacOidSbac));
		}
		pedTipoSolic.setSbacOidSbac(sbacOidSbacData);
		pedTipoSolic.setCodGrupSoli(
			(java.lang.String)FormatUtils.parseObject(codGrupSoli, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//pedTipoSolic.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("pedTipoSolic", pedTipoSolic);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad PedTipoSolic");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad PedTipoSolic");

		
		
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
			PedTipoSolicData pedTipoSolic = new PedTipoSolicData();
			pedTipoSolic.setId(new Long(claves.nextToken()));
			//pedTipoSolic.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(pedTipoSolic);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad PedTipoSolic");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad PedTipoSolic");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("PedTipoSolicLPStartUp");
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
			label.setEnti("PED_TIPO_SOLIC");
			label.setDeta(value != null? value: "");
			localizationLabels.add(label);
		}
		
		
		return localizationLabels;
	}
	
	

	
	
	

	

	
	
	
	
}




