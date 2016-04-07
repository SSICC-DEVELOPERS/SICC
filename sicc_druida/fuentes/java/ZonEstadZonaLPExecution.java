

/*
    INDRA/CAR/mmg
    $Id: ZonEstadZonaLPExecution.java,v 1.1 2009/12/03 18:42:13 pecbazalar Exp $
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

public class ZonEstadZonaLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGZonEstadZonaCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGZonEstadZonaUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGZonEstadZonaRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGZonEstadZonaQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "ZonEstadZonaConectorCreate";
	public static final String CONECTOR_UPDATE = "ZonEstadZonaConectorUpdate";
	public static final String CONECTOR_REMOVE = "ZonEstadZonaConectorRemove";

	public ZonEstadZonaLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("ZonEstadZonaPage");
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
  	correspondiente a la creación de un/a nuevo ZonEstadZona*/  
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
		
		traza("MMG::Creando ZonEstadZona");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String codEstaZona = conectorParametro("codEstaZona").trim();
		traza("MMG:: Valor de atributo codEstaZona: " + codEstaZona);
		if(codEstaZona != null && !codEstaZona.trim().equals("")) codEstaZona = codEstaZona.toUpperCase();
		
		String marcOidMarc = conectorParametro("marcOidMarc").trim();
		traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
		
		String indInic = conectorParametro("indInic").trim();
		traza("MMG:: Valor de atributo indInic: " + indInic);
		
		String impoVentMini = conectorParametro("impoVentMini").trim();
		traza("MMG:: Valor de atributo impoVentMini: " + impoVentMini);
		
		String numConsMin = conectorParametro("numConsMin").trim();
		traza("MMG:: Valor de atributo numConsMin: " + numConsMin);
		
		String numPediZona = conectorParametro("numPediZona").trim();
		traza("MMG:: Valor de atributo numPediZona: " + numPediZona);
		
		String valoTiemMini = conectorParametro("valoTiemMini").trim();
		traza("MMG:: Valor de atributo valoTiemMini: " + valoTiemMini);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		ZonEstadZonaData zonEstadZona= new ZonEstadZonaData();
		es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		zonEstadZona.setPaisOidPais(paisOidPaisData);
		zonEstadZona.setCodEstaZona(
			(java.lang.String)FormatUtils.parseObject(codEstaZona, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
		if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
			marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
			marcOidMarcData.setId(new Long(marcOidMarc));
		}
		zonEstadZona.setMarcOidMarc(marcOidMarcData);
		zonEstadZona.setIndInic(
			(java.lang.String)FormatUtils.parseObject(indInic, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		zonEstadZona.setImpoVentMini(
			(java.lang.Double)FormatUtils.parseObject(impoVentMini, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		zonEstadZona.setNumConsMin(
			(java.lang.Long)FormatUtils.parseObject(numConsMin, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		zonEstadZona.setNumPediZona(
			(java.lang.Long)FormatUtils.parseObject(numPediZona, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		zonEstadZona.setValoTiemMini(
			(java.lang.Double)FormatUtils.parseObject(valoTiemMini, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonEstadZona", zonEstadZona);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad ZonEstadZona");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad ZonEstadZona");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("ZonEstadZonaLPStartUp");
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
		traza("MMG::Creando ZonEstadZona");
		
		String codEstaZona = conectorParametro("codEstaZona").trim();
		traza("MMG:: Valor de atributo codEstaZona: " + codEstaZona);
		if(codEstaZona != null && !codEstaZona.trim().equals("")) codEstaZona = codEstaZona.toUpperCase();
		
		String marcOidMarc = conectorParametro("marcOidMarc").trim();
		traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
		
		String indInic = conectorParametro("indInic").trim();
		traza("MMG:: Valor de atributo indInic: " + indInic);
		
		String impoVentMini = conectorParametro("impoVentMini").trim();
		traza("MMG:: Valor de atributo impoVentMini: " + impoVentMini);
		
		String numConsMin = conectorParametro("numConsMin").trim();
		traza("MMG:: Valor de atributo numConsMin: " + numConsMin);
		
		String numPediZona = conectorParametro("numPediZona").trim();
		traza("MMG:: Valor de atributo numPediZona: " + numPediZona);
		
		String valoTiemMini = conectorParametro("valoTiemMini").trim();
		traza("MMG:: Valor de atributo valoTiemMini: " + valoTiemMini);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		ZonEstadZonaData zonEstadZona= new ZonEstadZonaData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			zonEstadZona.setId(new Long(id));
		}
		zonEstadZona = (ZonEstadZonaData)getSingleObject(BUSINESSID_QUERY, zonEstadZona, 
			zonEstadZona.clone(), "zonEstadZona");
		
		if(zonEstadZona == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		zonEstadZona.setCodEstaZona(
			(java.lang.String)FormatUtils.parseObject(codEstaZona, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
		if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
			marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
			marcOidMarcData.setId(new Long(marcOidMarc));
		}
		zonEstadZona.setMarcOidMarc(marcOidMarcData);
		zonEstadZona.setIndInic(
			(java.lang.String)FormatUtils.parseObject(indInic, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		zonEstadZona.setImpoVentMini(
			(java.lang.Double)FormatUtils.parseObject(impoVentMini, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		zonEstadZona.setNumConsMin(
			(java.lang.Long)FormatUtils.parseObject(numConsMin, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		zonEstadZona.setNumPediZona(
			(java.lang.Long)FormatUtils.parseObject(numPediZona, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		zonEstadZona.setValoTiemMini(
			(java.lang.Double)FormatUtils.parseObject(valoTiemMini, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//zonEstadZona.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonEstadZona", zonEstadZona);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(zonEstadZona);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad ZonEstadZona");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad ZonEstadZona");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(zonEstadZona);
		
		
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
			ZonEstadZonaData zonEstadZona = new ZonEstadZonaData();
			zonEstadZona.setId(new Long(claves.nextToken()));
			//zonEstadZona.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(zonEstadZona);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad ZonEstadZona");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad ZonEstadZona");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("ZonEstadZonaLPStartUp");
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
			label.setEnti("ZON_ESTAD_ZONA");
			label.setDeta(value != null? value: "");
			localizationLabels.add(label);
		}
		
		
		return localizationLabels;
	}
	
	

	protected void cmdPreUpdate(ZonEstadZonaData zonEstadZona) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));zonEstadZona.setPaisOidPais(paisOculto);
			
	}
	
	
	

	

	protected void cmdPostUpdate(ZonEstadZonaData zonEstadZona) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));zonEstadZona.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




