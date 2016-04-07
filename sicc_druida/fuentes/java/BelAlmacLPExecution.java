

/*
    INDRA/CAR/mmg
    $Id: BelAlmacLPExecution.java,v 1.1 2009/12/03 18:39:39 pecbazalar Exp $
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

public class BelAlmacLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGBelAlmacCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGBelAlmacUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGBelAlmacRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGBelAlmacQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "BelAlmacConectorCreate";
	public static final String CONECTOR_UPDATE = "BelAlmacConectorUpdate";
	public static final String CONECTOR_REMOVE = "BelAlmacConectorRemove";

	public BelAlmacLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("BelAlmacPage");
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
  	correspondiente a la creación de un/a nuevo BelAlmac*/  
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
		
		traza("MMG::Creando BelAlmac");
		
		String codAlma = conectorParametro("codAlma").trim();
		traza("MMG:: Valor de atributo codAlma: " + codAlma);
		if(codAlma != null && !codAlma.trim().equals("")) codAlma = codAlma.toUpperCase();
		
		String indInfoSap = conectorParametro("indInfoSap").trim();
		traza("MMG:: Valor de atributo indInfoSap: " + indInfoSap);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		BelAlmacData belAlmac= new BelAlmacData();
		belAlmac.setCodAlma(
			(java.lang.String)FormatUtils.parseObject(codAlma, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belAlmac.setIndInfoSap(
			(java.lang.Boolean)FormatUtils.parseObject(indInfoSap.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("belAlmac", belAlmac);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(belAlmac);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad BelAlmac");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad BelAlmac");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(belAlmac);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("BelAlmacLPStartUp");
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
		traza("MMG::Creando BelAlmac");
		
		String codAlma = conectorParametro("codAlma").trim();
		traza("MMG:: Valor de atributo codAlma: " + codAlma);
		if(codAlma != null && !codAlma.trim().equals("")) codAlma = codAlma.toUpperCase();
		
		String indInfoSap = conectorParametro("indInfoSap").trim();
		traza("MMG:: Valor de atributo indInfoSap: " + indInfoSap);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		BelAlmacData belAlmac= new BelAlmacData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			belAlmac.setId(new Long(id));
		}
		belAlmac = (BelAlmacData)getSingleObject(BUSINESSID_QUERY, belAlmac, 
			belAlmac.clone(), "belAlmac");
		
		if(belAlmac == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		belAlmac.setCodAlma(
			(java.lang.String)FormatUtils.parseObject(codAlma, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belAlmac.setIndInfoSap(
			(java.lang.Boolean)FormatUtils.parseObject(indInfoSap.equals("S")? "true": "false", "java.lang.Boolean", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//belAlmac.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("belAlmac", belAlmac);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(belAlmac);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad BelAlmac");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad BelAlmac");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(belAlmac);
		
		
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
			BelAlmacData belAlmac = new BelAlmacData();
			belAlmac.setId(new Long(claves.nextToken()));
			//belAlmac.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(belAlmac);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad BelAlmac");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad BelAlmac");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("BelAlmacLPStartUp");
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
			label.setEnti("BEL_ALMAC");
			label.setDeta(value != null? value: "");
			localizationLabels.add(label);
		}
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(BelAlmacData belAlmac) throws Exception{
						
			SegPaisViewData paisOculto = new SegPaisViewData();
			paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
			belAlmac.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPreUpdate(BelAlmacData belAlmac) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				belAlmac.setPaisOidPais(paisOculto);
				
	}
	
	
	

	protected void cmdPostCreate(BelAlmacData belAlmac) throws Exception{
		
			SegPaisViewData paisOculto = new SegPaisViewData();
			paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
			belAlmac.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPostUpdate(BelAlmacData belAlmac) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				belAlmac.setPaisOidPais(paisOculto);
				
	}
	
	
	
	
}




