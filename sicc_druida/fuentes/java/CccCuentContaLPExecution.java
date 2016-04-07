

/*
    INDRA/CAR/mmg
    $Id: CccCuentContaLPExecution.java,v 1.1 2009/12/03 18:37:39 pecbazalar Exp $
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

public class CccCuentContaLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCccCuentContaCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCccCuentContaUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCccCuentContaRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCccCuentContaQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CccCuentContaConectorCreate";
	public static final String CONECTOR_UPDATE = "CccCuentContaConectorUpdate";
	public static final String CONECTOR_REMOVE = "CccCuentContaConectorRemove";

	public CccCuentContaLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CccCuentContaPage");
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
  	correspondiente a la creación de un/a nuevo CccCuentConta*/  
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
		
		traza("MMG::Creando CccCuentConta");
		
		String codCuenCont = conectorParametro("codCuenCont").trim();
		traza("MMG:: Valor de atributo codCuenCont: " + codCuenCont);
		if(codCuenCont != null && !codCuenCont.trim().equals("")) codCuenCont = codCuenCont.toUpperCase();
		
		String codCuenSap = conectorParametro("codCuenSap").trim();
		traza("MMG:: Valor de atributo codCuenSap: " + codCuenSap);
		if(codCuenSap != null && !codCuenSap.trim().equals("")) codCuenSap = codCuenSap.toUpperCase();
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CccCuentContaData cccCuentConta= new CccCuentContaData();
		cccCuentConta.setCodCuenCont(
			(java.lang.String)FormatUtils.parseObject(codCuenCont, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccCuentConta.setCodCuenSap(
			(java.lang.String)FormatUtils.parseObject(codCuenSap, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccCuentConta.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cccCuentConta", cccCuentConta);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(cccCuentConta);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CccCuentConta");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CccCuentConta");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(cccCuentConta);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CccCuentContaLPStartUp");
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
		traza("MMG::Creando CccCuentConta");
		
		String codCuenCont = conectorParametro("codCuenCont").trim();
		traza("MMG:: Valor de atributo codCuenCont: " + codCuenCont);
		if(codCuenCont != null && !codCuenCont.trim().equals("")) codCuenCont = codCuenCont.toUpperCase();
		
		String codCuenSap = conectorParametro("codCuenSap").trim();
		traza("MMG:: Valor de atributo codCuenSap: " + codCuenSap);
		if(codCuenSap != null && !codCuenSap.trim().equals("")) codCuenSap = codCuenSap.toUpperCase();
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CccCuentContaData cccCuentConta= new CccCuentContaData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			cccCuentConta.setId(new Long(id));
		}
		cccCuentConta = (CccCuentContaData)getSingleObject(BUSINESSID_QUERY, cccCuentConta, 
			cccCuentConta.clone(), "cccCuentConta");
		
		if(cccCuentConta == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		cccCuentConta.setCodCuenCont(
			(java.lang.String)FormatUtils.parseObject(codCuenCont, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccCuentConta.setCodCuenSap(
			(java.lang.String)FormatUtils.parseObject(codCuenSap, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccCuentConta.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//cccCuentConta.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cccCuentConta", cccCuentConta);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(cccCuentConta);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CccCuentConta");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CccCuentConta");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(cccCuentConta);
		
		
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
			CccCuentContaData cccCuentConta = new CccCuentContaData();
			cccCuentConta.setId(new Long(claves.nextToken()));
			//cccCuentConta.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(cccCuentConta);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CccCuentConta");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CccCuentConta");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CccCuentContaLPStartUp");
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
			label.setEnti("CCC_CUENT_CONTA");
			label.setDeta(value != null? value: "");
			localizationLabels.add(label);
		}
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(CccCuentContaData cccCuentConta) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccCuentConta.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPreUpdate(CccCuentContaData cccCuentConta) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccCuentConta.setPaisOidPais(paisOculto);
			
	}
	
	
	

	protected void cmdPostCreate(CccCuentContaData cccCuentConta) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccCuentConta.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPostUpdate(CccCuentContaData cccCuentConta) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccCuentConta.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




