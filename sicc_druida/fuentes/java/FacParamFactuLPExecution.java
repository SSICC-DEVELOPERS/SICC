

/*
    INDRA/CAR/mmg
    $Id: FacParamFactuLPExecution.java,v 1.1 2009/12/03 18:36:22 pecbazalar Exp $
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

public class FacParamFactuLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGFacParamFactuCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGFacParamFactuUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGFacParamFactuRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGFacParamFactuQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "FacParamFactuConectorCreate";
	public static final String CONECTOR_UPDATE = "FacParamFactuConectorUpdate";
	public static final String CONECTOR_REMOVE = "FacParamFactuConectorRemove";

	public FacParamFactuLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("FacParamFactuPage");
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
  	correspondiente a la creación de un/a nuevo FacParamFactu*/  
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
		
		traza("MMG::Creando FacParamFactu");
		
		String indDocuMonoPagi = conectorParametro("indDocuMonoPagi").trim();
		traza("MMG:: Valor de atributo indDocuMonoPagi: " + indDocuMonoPagi);
		
		String valMontLimiUit = conectorParametro("valMontLimiUit").trim();
		traza("MMG:: Valor de atributo valMontLimiUit: " + valMontLimiUit);
		
		String numMaxiCampPrd = conectorParametro("numMaxiCampPrd").trim();
		traza("MMG:: Valor de atributo numMaxiCampPrd: " + numMaxiCampPrd);
		
		String indTipoProyRegi = conectorParametro("indTipoProyRegi").trim();
		traza("MMG:: Valor de atributo indTipoProyRegi: " + indTipoProyRegi);
		
		String indMostVencCupo = conectorParametro("indMostVencCupo").trim();
		traza("MMG:: Valor de atributo indMostVencCupo: " + indMostVencCupo);
		
		String numMaxiPediProy = conectorParametro("numMaxiPediProy").trim();
		traza("MMG:: Valor de atributo numMaxiPediProy: " + numMaxiPediProy);
		
		String codModaDist = conectorParametro("codModaDist").trim();
		traza("MMG:: Valor de atributo codModaDist: " + codModaDist);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		FacParamFactuData facParamFactu= new FacParamFactuData();
		facParamFactu.setIndDocuMonoPagi(
			(java.lang.Long)FormatUtils.parseObject(indDocuMonoPagi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facParamFactu.setValMontLimiUit(
			(java.lang.Long)FormatUtils.parseObject(valMontLimiUit, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facParamFactu.setNumMaxiCampPrd(
			(java.lang.Long)FormatUtils.parseObject(numMaxiCampPrd, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facParamFactu.setIndTipoProyRegi(
			(java.lang.Long)FormatUtils.parseObject(indTipoProyRegi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facParamFactu.setIndMostVencCupo(
			(java.lang.Long)FormatUtils.parseObject(indMostVencCupo, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facParamFactu.setNumMaxiPediProy(
			(java.lang.Long)FormatUtils.parseObject(numMaxiPediProy, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facParamFactu.setCodModaDist(
			(java.lang.String)FormatUtils.parseObject(codModaDist, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("facParamFactu", facParamFactu);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(facParamFactu);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad FacParamFactu");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad FacParamFactu");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(facParamFactu);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("FacParamFactuLPStartUp");
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
		traza("MMG::Creando FacParamFactu");
		
		String indDocuMonoPagi = conectorParametro("indDocuMonoPagi").trim();
		traza("MMG:: Valor de atributo indDocuMonoPagi: " + indDocuMonoPagi);
		
		String valMontLimiUit = conectorParametro("valMontLimiUit").trim();
		traza("MMG:: Valor de atributo valMontLimiUit: " + valMontLimiUit);
		
		String numMaxiCampPrd = conectorParametro("numMaxiCampPrd").trim();
		traza("MMG:: Valor de atributo numMaxiCampPrd: " + numMaxiCampPrd);
		
		String indTipoProyRegi = conectorParametro("indTipoProyRegi").trim();
		traza("MMG:: Valor de atributo indTipoProyRegi: " + indTipoProyRegi);
		
		String indMostVencCupo = conectorParametro("indMostVencCupo").trim();
		traza("MMG:: Valor de atributo indMostVencCupo: " + indMostVencCupo);
		
		String numMaxiPediProy = conectorParametro("numMaxiPediProy").trim();
		traza("MMG:: Valor de atributo numMaxiPediProy: " + numMaxiPediProy);
		
		String codModaDist = conectorParametro("codModaDist").trim();
		traza("MMG:: Valor de atributo codModaDist: " + codModaDist);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		FacParamFactuData facParamFactu= new FacParamFactuData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			facParamFactu.setId(new Long(id));
		}
		facParamFactu = (FacParamFactuData)getSingleObject(BUSINESSID_QUERY, facParamFactu, 
			facParamFactu.clone(), "facParamFactu");
		
		if(facParamFactu == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		facParamFactu.setIndDocuMonoPagi(
			(java.lang.Long)FormatUtils.parseObject(indDocuMonoPagi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facParamFactu.setValMontLimiUit(
			(java.lang.Long)FormatUtils.parseObject(valMontLimiUit, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facParamFactu.setNumMaxiCampPrd(
			(java.lang.Long)FormatUtils.parseObject(numMaxiCampPrd, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facParamFactu.setIndTipoProyRegi(
			(java.lang.Long)FormatUtils.parseObject(indTipoProyRegi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facParamFactu.setIndMostVencCupo(
			(java.lang.Long)FormatUtils.parseObject(indMostVencCupo, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facParamFactu.setNumMaxiPediProy(
			(java.lang.Long)FormatUtils.parseObject(numMaxiPediProy, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		facParamFactu.setCodModaDist(
			(java.lang.String)FormatUtils.parseObject(codModaDist, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//facParamFactu.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("facParamFactu", facParamFactu);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(facParamFactu);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad FacParamFactu");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad FacParamFactu");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(facParamFactu);
		
		
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
			FacParamFactuData facParamFactu = new FacParamFactuData();
			facParamFactu.setId(new Long(claves.nextToken()));
			//facParamFactu.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(facParamFactu);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad FacParamFactu");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad FacParamFactu");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("FacParamFactuLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(FacParamFactuData facParamFactu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				facParamFactu.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPreUpdate(FacParamFactuData facParamFactu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				facParamFactu.setPaisOidPais(paisOculto);
			
	}
	
	
	

	protected void cmdPostCreate(FacParamFactuData facParamFactu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				facParamFactu.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPostUpdate(FacParamFactuData facParamFactu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				facParamFactu.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




