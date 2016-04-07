

/*
    INDRA/CAR/mmg
    $Id: MaeTipoDocumLPExecution.java,v 1.1 2009/12/03 18:41:31 pecbazalar Exp $
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

public class MaeTipoDocumLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGMaeTipoDocumCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGMaeTipoDocumUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGMaeTipoDocumRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGMaeTipoDocumQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "MaeTipoDocumConectorCreate";
	public static final String CONECTOR_UPDATE = "MaeTipoDocumConectorUpdate";
	public static final String CONECTOR_REMOVE = "MaeTipoDocumConectorRemove";

	public MaeTipoDocumLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("MaeTipoDocumPage");
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
  	correspondiente a la creación de un/a nuevo MaeTipoDocum*/  
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
		
		traza("MMG::Creando MaeTipoDocum");
		
		String codTipoDocu = conectorParametro("codTipoDocu").trim();
		traza("MMG:: Valor de atributo codTipoDocu: " + codTipoDocu);
		if(codTipoDocu != null && !codTipoDocu.trim().equals("")) codTipoDocu = codTipoDocu.toUpperCase();
		
		String indObli = conectorParametro("indObli").trim();
		traza("MMG:: Valor de atributo indObli: " + indObli);
		
		String valSigl = conectorParametro("valSigl").trim();
		traza("MMG:: Valor de atributo valSigl: " + valSigl);
		
		String valLong = conectorParametro("valLong").trim();
		traza("MMG:: Valor de atributo valLong: " + valLong);
		
		String indDni = conectorParametro("indDni").trim();
		traza("MMG:: Valor de atributo indDni: " + indDni);
		
		String indDocIdenFisc = conectorParametro("indDocIdenFisc").trim();
		traza("MMG:: Valor de atributo indDocIdenFisc: " + indDocIdenFisc);
		
		String tidoOidTipoDocu = conectorParametro("tidoOidTipoDocu").trim();
		traza("MMG:: Valor de atributo tidoOidTipoDocu: " + tidoOidTipoDocu);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		MaeTipoDocumData maeTipoDocum= new MaeTipoDocumData();
		maeTipoDocum.setCodTipoDocu(
			(java.lang.String)FormatUtils.parseObject(codTipoDocu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeTipoDocum.setIndObli(
			(java.lang.String)FormatUtils.parseObject(indObli, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeTipoDocum.setValSigl(
			(java.lang.String)FormatUtils.parseObject(valSigl, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeTipoDocum.setValLong(
			(java.lang.Long)FormatUtils.parseObject(valLong, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeTipoDocum.setIndDni(
			(java.lang.String)FormatUtils.parseObject(indDni, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeTipoDocum.setIndDocIdenFisc(
			(java.lang.String)FormatUtils.parseObject(indDocIdenFisc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.FacTipoDocumData tidoOidTipoDocuData = null;
		if(tidoOidTipoDocu != null && !tidoOidTipoDocu.trim().equals("")){
			tidoOidTipoDocuData = new es.indra.belcorp.mso.FacTipoDocumData();
			tidoOidTipoDocuData.setId(new Long(tidoOidTipoDocu));
		}
		maeTipoDocum.setTidoOidTipoDocu(tidoOidTipoDocuData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeTipoDocum", maeTipoDocum);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(maeTipoDocum);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad MaeTipoDocum");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad MaeTipoDocum");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(maeTipoDocum);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("MaeTipoDocumLPStartUp");
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
		traza("MMG::Creando MaeTipoDocum");
		
		String codTipoDocu = conectorParametro("codTipoDocu").trim();
		traza("MMG:: Valor de atributo codTipoDocu: " + codTipoDocu);
		if(codTipoDocu != null && !codTipoDocu.trim().equals("")) codTipoDocu = codTipoDocu.toUpperCase();
		
		String indObli = conectorParametro("indObli").trim();
		traza("MMG:: Valor de atributo indObli: " + indObli);
		
		String valSigl = conectorParametro("valSigl").trim();
		traza("MMG:: Valor de atributo valSigl: " + valSigl);
		
		String valLong = conectorParametro("valLong").trim();
		traza("MMG:: Valor de atributo valLong: " + valLong);
		
		String indDni = conectorParametro("indDni").trim();
		traza("MMG:: Valor de atributo indDni: " + indDni);
		
		String indDocIdenFisc = conectorParametro("indDocIdenFisc").trim();
		traza("MMG:: Valor de atributo indDocIdenFisc: " + indDocIdenFisc);
		
		String tidoOidTipoDocu = conectorParametro("tidoOidTipoDocu").trim();
		traza("MMG:: Valor de atributo tidoOidTipoDocu: " + tidoOidTipoDocu);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		MaeTipoDocumData maeTipoDocum= new MaeTipoDocumData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			maeTipoDocum.setId(new Long(id));
		}
		maeTipoDocum = (MaeTipoDocumData)getSingleObject(BUSINESSID_QUERY, maeTipoDocum, 
			maeTipoDocum.clone(), "maeTipoDocum");
		
		if(maeTipoDocum == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		maeTipoDocum.setCodTipoDocu(
			(java.lang.String)FormatUtils.parseObject(codTipoDocu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeTipoDocum.setIndObli(
			(java.lang.String)FormatUtils.parseObject(indObli, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeTipoDocum.setValSigl(
			(java.lang.String)FormatUtils.parseObject(valSigl, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeTipoDocum.setValLong(
			(java.lang.Long)FormatUtils.parseObject(valLong, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeTipoDocum.setIndDni(
			(java.lang.String)FormatUtils.parseObject(indDni, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeTipoDocum.setIndDocIdenFisc(
			(java.lang.String)FormatUtils.parseObject(indDocIdenFisc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.FacTipoDocumData tidoOidTipoDocuData = null;
		if(tidoOidTipoDocu != null && !tidoOidTipoDocu.trim().equals("")){
			tidoOidTipoDocuData = new es.indra.belcorp.mso.FacTipoDocumData();
			tidoOidTipoDocuData.setId(new Long(tidoOidTipoDocu));
		}
		maeTipoDocum.setTidoOidTipoDocu(tidoOidTipoDocuData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//maeTipoDocum.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeTipoDocum", maeTipoDocum);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(maeTipoDocum);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad MaeTipoDocum");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad MaeTipoDocum");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(maeTipoDocum);
		
		
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
			MaeTipoDocumData maeTipoDocum = new MaeTipoDocumData();
			maeTipoDocum.setId(new Long(claves.nextToken()));
			//maeTipoDocum.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(maeTipoDocum);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad MaeTipoDocum");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad MaeTipoDocum");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("MaeTipoDocumLPStartUp");
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
			label.setEnti("MAE_TIPO_DOCUM");
			label.setDeta(value != null? value: "");
			localizationLabels.add(label);
		}
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(MaeTipoDocumData maeTipoDocum) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeTipoDocum.setPaisOidPais(paisOculto);
	}
	

	protected void cmdPreUpdate(MaeTipoDocumData maeTipoDocum) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeTipoDocum.setPaisOidPais(paisOculto);
	}
	
	
	

	protected void cmdPostCreate(MaeTipoDocumData maeTipoDocum) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeTipoDocum.setPaisOidPais(paisOculto);
	}
	

	protected void cmdPostUpdate(MaeTipoDocumData maeTipoDocum) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeTipoDocum.setPaisOidPais(paisOculto);
	}
	
	
	
	
}




