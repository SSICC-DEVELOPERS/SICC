

/*
    INDRA/CAR/mmg
    $Id: SegSocieLPExecution.java,v 1.1 2009/12/03 18:41:48 pecbazalar Exp $
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

public class SegSocieLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGSegSocieCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGSegSocieUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGSegSocieRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGSegSocieQueryFromToUserPageStructuralSecurity";	
	
	
	public static final String CONECTOR_CREATE = "SegSocieConectorCreate";
	public static final String CONECTOR_UPDATE = "SegSocieConectorUpdate";
	public static final String CONECTOR_REMOVE = "SegSocieConectorRemove";

	public SegSocieLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("SegSociePage");
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
  	correspondiente a la creación de un/a nuevo SegSocie*/  
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
		
		traza("MMG::Creando SegSocie");
		
		String codSoci = conectorParametro("codSoci").trim();
		traza("MMG:: Valor de atributo codSoci: " + codSoci);
		if(codSoci != null && !codSoci.trim().equals("")) codSoci = codSoci.toUpperCase();
		
		String valDeno = conectorParametro("valDeno").trim();
		traza("MMG:: Valor de atributo valDeno: " + valDeno);
		
		String valDire = conectorParametro("valDire").trim();
		traza("MMG:: Valor de atributo valDire: " + valDire);
		
		String valTlfn = conectorParametro("valTlfn").trim();
		traza("MMG:: Valor de atributo valTlfn: " + valTlfn);
		
		String valFax = conectorParametro("valFax").trim();
		traza("MMG:: Valor de atributo valFax: " + valFax);
		
		String valIdenFisc = conectorParametro("valIdenFisc").trim();
		traza("MMG:: Valor de atributo valIdenFisc: " + valIdenFisc);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		SegSocieData segSocie= new SegSocieData();
		segSocie.setCodSoci(
			(java.lang.String)FormatUtils.parseObject(codSoci, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segSocie.setValDeno(
			(java.lang.String)FormatUtils.parseObject(valDeno, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segSocie.setValDire(
			(java.lang.String)FormatUtils.parseObject(valDire, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segSocie.setValTlfn(
			(java.lang.String)FormatUtils.parseObject(valTlfn, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segSocie.setValFax(
			(java.lang.String)FormatUtils.parseObject(valFax, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segSocie.setValIdenFisc(
			(java.lang.String)FormatUtils.parseObject(valIdenFisc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("segSocie", segSocie);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(segSocie);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad SegSocie");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad SegSocie");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(segSocie);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("SegSocieLPStartUp");
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
		traza("MMG::Creando SegSocie");
		
		String codSoci = conectorParametro("codSoci").trim();
		traza("MMG:: Valor de atributo codSoci: " + codSoci);
		if(codSoci != null && !codSoci.trim().equals("")) codSoci = codSoci.toUpperCase();
		
		String valDeno = conectorParametro("valDeno").trim();
		traza("MMG:: Valor de atributo valDeno: " + valDeno);
		
		String valDire = conectorParametro("valDire").trim();
		traza("MMG:: Valor de atributo valDire: " + valDire);
		
		String valTlfn = conectorParametro("valTlfn").trim();
		traza("MMG:: Valor de atributo valTlfn: " + valTlfn);
		
		String valFax = conectorParametro("valFax").trim();
		traza("MMG:: Valor de atributo valFax: " + valFax);
		
		String valIdenFisc = conectorParametro("valIdenFisc").trim();
		traza("MMG:: Valor de atributo valIdenFisc: " + valIdenFisc);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		SegSocieData segSocie= new SegSocieData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			segSocie.setId(new Long(id));
		}
		segSocie = (SegSocieData)getSingleObject(BUSINESSID_QUERY, segSocie, 
			segSocie.clone(), "segSocie", false);
		
		if(segSocie == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		segSocie.setCodSoci(
			(java.lang.String)FormatUtils.parseObject(codSoci, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segSocie.setValDeno(
			(java.lang.String)FormatUtils.parseObject(valDeno, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segSocie.setValDire(
			(java.lang.String)FormatUtils.parseObject(valDire, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segSocie.setValTlfn(
			(java.lang.String)FormatUtils.parseObject(valTlfn, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segSocie.setValFax(
			(java.lang.String)FormatUtils.parseObject(valFax, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segSocie.setValIdenFisc(
			(java.lang.String)FormatUtils.parseObject(valIdenFisc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//segSocie.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("segSocie", segSocie);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(segSocie);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad SegSocie");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad SegSocie");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(segSocie);
		
		
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
			SegSocieData segSocie = new SegSocieData();
			segSocie.setId(new Long(claves.nextToken()));
			//segSocie.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(segSocie);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad SegSocie");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad SegSocie");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("SegSocieLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(SegSocieData segSocie) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                segSocie.setPaisOidPais(paisOculto);
                
			
	}
	

	protected void cmdPreUpdate(SegSocieData segSocie) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                segSocie.setPaisOidPais(paisOculto);
                
			
	}
	
	
	

	protected void cmdPostCreate(SegSocieData segSocie) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                segSocie.setPaisOidPais(paisOculto);
                
			
	}
	

	protected void cmdPostUpdate(SegSocieData segSocie) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                segSocie.setPaisOidPais(paisOculto);
                
			
	}
	
	
	
	
}




