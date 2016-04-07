

/*
    INDRA/CAR/mmg
    $Id: ZonZonaView2LPExecution.java,v 1.1 2009/12/03 18:35:24 pecbazalar Exp $
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

public class ZonZonaView2LPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGZonZonaView2CreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGZonZonaView2UpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGZonZonaView2RemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGZonZonaView2QueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "ZonZonaView2ConectorCreate";
	public static final String CONECTOR_UPDATE = "ZonZonaView2ConectorUpdate";
	public static final String CONECTOR_REMOVE = "ZonZonaView2ConectorRemove";

	public ZonZonaView2LPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("ZonZonaView2Page");
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
  	correspondiente a la creación de un/a nuevo ZonZonaView2*/  
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
		
		traza("MMG::Creando ZonZonaView2");
		
		String marcOidMarc = conectorParametro("marcOidMarc").trim();
		traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
		
		String canaOidCana = conectorParametro("canaOidCana").trim();
		traza("MMG:: Valor de atributo canaOidCana: " + canaOidCana);
		
		String codZona = conectorParametro("codZona").trim();
		traza("MMG:: Valor de atributo codZona: " + codZona);
		
		String indActi = conectorParametro("indActi").trim();
		traza("MMG:: Valor de atributo indActi: " + indActi);
		
		String indBorr = conectorParametro("indBorr").trim();
		traza("MMG:: Valor de atributo indBorr: " + indBorr);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		ZonZonaView2Data zonZonaView2= new ZonZonaView2Data();
		es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
		if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
			marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
			marcOidMarcData.setId(new Long(marcOidMarc));
		}
		zonZonaView2.setMarcOidMarc(marcOidMarcData);
		es.indra.belcorp.mso.SegCanalViewData canaOidCanaData = null;
		if(canaOidCana != null && !canaOidCana.trim().equals("")){
			canaOidCanaData = new es.indra.belcorp.mso.SegCanalViewData();
			canaOidCanaData.setId(new Long(canaOidCana));
		}
		zonZonaView2.setCanaOidCana(canaOidCanaData);
		zonZonaView2.setCodZona(
			(java.lang.String)FormatUtils.parseObject(codZona, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		zonZonaView2.setIndActi(
			(java.lang.Long)FormatUtils.parseObject(indActi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		zonZonaView2.setIndBorr(
			(java.lang.Long)FormatUtils.parseObject(indBorr, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonZonaView2", zonZonaView2);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(zonZonaView2);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad ZonZonaView2");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad ZonZonaView2");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(zonZonaView2);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("ZonZonaView2LPStartUp");
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
		traza("MMG::Creando ZonZonaView2");
		
		String marcOidMarc = conectorParametro("marcOidMarc").trim();
		traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
		
		String canaOidCana = conectorParametro("canaOidCana").trim();
		traza("MMG:: Valor de atributo canaOidCana: " + canaOidCana);
		
		String codZona = conectorParametro("codZona").trim();
		traza("MMG:: Valor de atributo codZona: " + codZona);
		
		String indActi = conectorParametro("indActi").trim();
		traza("MMG:: Valor de atributo indActi: " + indActi);
		
		String indBorr = conectorParametro("indBorr").trim();
		traza("MMG:: Valor de atributo indBorr: " + indBorr);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		ZonZonaView2Data zonZonaView2= new ZonZonaView2Data();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			zonZonaView2.setId(new Long(id));
		}
		zonZonaView2 = (ZonZonaView2Data)getSingleObject(BUSINESSID_QUERY, zonZonaView2, 
			zonZonaView2.clone(), "zonZonaView2");
		
		if(zonZonaView2 == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
		if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
			marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
			marcOidMarcData.setId(new Long(marcOidMarc));
		}
		zonZonaView2.setMarcOidMarc(marcOidMarcData);
		es.indra.belcorp.mso.SegCanalViewData canaOidCanaData = null;
		if(canaOidCana != null && !canaOidCana.trim().equals("")){
			canaOidCanaData = new es.indra.belcorp.mso.SegCanalViewData();
			canaOidCanaData.setId(new Long(canaOidCana));
		}
		zonZonaView2.setCanaOidCana(canaOidCanaData);
		zonZonaView2.setCodZona(
			(java.lang.String)FormatUtils.parseObject(codZona, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		zonZonaView2.setIndActi(
			(java.lang.Long)FormatUtils.parseObject(indActi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		zonZonaView2.setIndBorr(
			(java.lang.Long)FormatUtils.parseObject(indBorr, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//zonZonaView2.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonZonaView2", zonZonaView2);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(zonZonaView2);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad ZonZonaView2");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad ZonZonaView2");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(zonZonaView2);
		
		
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
			ZonZonaView2Data zonZonaView2 = new ZonZonaView2Data();
			zonZonaView2.setId(new Long(claves.nextToken()));
			//zonZonaView2.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(zonZonaView2);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad ZonZonaView2");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad ZonZonaView2");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("ZonZonaView2LPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(ZonZonaView2Data zonZonaView2) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); 
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				zonZonaView2.setPaisOidPais(paisOculto); 
			
	}
	

	protected void cmdPreUpdate(ZonZonaView2Data zonZonaView2) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				zonZonaView2.setPaisOidPais(paisOculto);
			
	}
	
	
	

	protected void cmdPostCreate(ZonZonaView2Data zonZonaView2) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				zonZonaView2.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPostUpdate(ZonZonaView2Data zonZonaView2) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				zonZonaView2.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




