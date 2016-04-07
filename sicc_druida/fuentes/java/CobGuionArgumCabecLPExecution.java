

/*
    INDRA/CAR/mmg
    $Id: CobGuionArgumCabecLPExecution.java,v 1.1 2009/12/03 18:42:47 pecbazalar Exp $
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

public class CobGuionArgumCabecLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCobGuionArgumCabecCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCobGuionArgumCabecUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCobGuionArgumCabecRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCobGuionArgumCabecQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CobGuionArgumCabecConectorCreate";
	public static final String CONECTOR_UPDATE = "CobGuionArgumCabecConectorUpdate";
	public static final String CONECTOR_REMOVE = "CobGuionArgumCabecConectorRemove";

	public CobGuionArgumCabecLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CobGuionArgumCabecPage");
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
  	correspondiente a la creación de un/a nuevo CobGuionArgumCabec*/  
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
		
		traza("MMG::Creando CobGuionArgumCabec");
		
		String codGuiaArgu = conectorParametro("codGuiaArgu").trim();
		traza("MMG:: Valor de atributo codGuiaArgu: " + codGuiaArgu);
		if(codGuiaArgu != null && !codGuiaArgu.trim().equals("")) codGuiaArgu = codGuiaArgu.toUpperCase();
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CobGuionArgumCabecData cobGuionArgumCabec= new CobGuionArgumCabecData();
		cobGuionArgumCabec.setCodGuiaArgu(
			(java.lang.String)FormatUtils.parseObject(codGuiaArgu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobGuionArgumCabec.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobGuionArgumCabec", cobGuionArgumCabec);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(cobGuionArgumCabec);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CobGuionArgumCabec");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CobGuionArgumCabec");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(cobGuionArgumCabec);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CobGuionArgumCabecLPStartUp");
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
		traza("MMG::Creando CobGuionArgumCabec");
		
		String codGuiaArgu = conectorParametro("codGuiaArgu").trim();
		traza("MMG:: Valor de atributo codGuiaArgu: " + codGuiaArgu);
		if(codGuiaArgu != null && !codGuiaArgu.trim().equals("")) codGuiaArgu = codGuiaArgu.toUpperCase();
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CobGuionArgumCabecData cobGuionArgumCabec= new CobGuionArgumCabecData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			cobGuionArgumCabec.setId(new Long(id));
		}
		cobGuionArgumCabec = (CobGuionArgumCabecData)getSingleObject(BUSINESSID_QUERY, cobGuionArgumCabec, 
			cobGuionArgumCabec.clone(), "cobGuionArgumCabec");
		
		if(cobGuionArgumCabec == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		cobGuionArgumCabec.setCodGuiaArgu(
			(java.lang.String)FormatUtils.parseObject(codGuiaArgu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobGuionArgumCabec.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//cobGuionArgumCabec.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobGuionArgumCabec", cobGuionArgumCabec);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(cobGuionArgumCabec);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CobGuionArgumCabec");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CobGuionArgumCabec");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(cobGuionArgumCabec);
		
		
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
			CobGuionArgumCabecData cobGuionArgumCabec = new CobGuionArgumCabecData();
			cobGuionArgumCabec.setId(new Long(claves.nextToken()));
			//cobGuionArgumCabec.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(cobGuionArgumCabec);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CobGuionArgumCabec");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CobGuionArgumCabec");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CobGuionArgumCabecLPStartUp");
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
			label.setEnti("COB_GUION_ARGUM_CABEC");
			label.setDeta(value != null? value: "");
			localizationLabels.add(label);
		}
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(CobGuionArgumCabecData cobGuionArgumCabec) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobGuionArgumCabec.setPaisOidPais(paisOculto);
                
			
	}
	

	protected void cmdPreUpdate(CobGuionArgumCabecData cobGuionArgumCabec) throws Exception{
		
				
                    SegPaisViewData paisOculto = new SegPaisViewData();
                    paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                    cobGuionArgumCabec.setPaisOidPais(paisOculto);
                
			
	}
	
	
	

	protected void cmdPostCreate(CobGuionArgumCabecData cobGuionArgumCabec) throws Exception{
		
				
                    SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobGuionArgumCabec.setPaisOidPais(paisOculto);
                
			
	}
	

	protected void cmdPostUpdate(CobGuionArgumCabecData cobGuionArgumCabec) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobGuionArgumCabec.setPaisOidPais(paisOculto);
                
			
	}
	
	
	
	
}




