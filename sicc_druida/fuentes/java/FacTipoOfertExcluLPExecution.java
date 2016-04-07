

/*
    INDRA/CAR/mmg
    $Id: FacTipoOfertExcluLPExecution.java,v 1.1 2009/12/03 18:36:34 pecbazalar Exp $
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

public class FacTipoOfertExcluLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGFacTipoOfertExcluCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGFacTipoOfertExcluUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGFacTipoOfertExcluRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGFacTipoOfertExcluQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "FacTipoOfertExcluConectorCreate";
	public static final String CONECTOR_UPDATE = "FacTipoOfertExcluConectorUpdate";
	public static final String CONECTOR_REMOVE = "FacTipoOfertExcluConectorRemove";

	public FacTipoOfertExcluLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("FacTipoOfertExcluPage");
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
  	correspondiente a la creación de un/a nuevo FacTipoOfertExclu*/  
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
		
		traza("MMG::Creando FacTipoOfertExclu");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String fecDesd = conectorParametro("fecDesd").trim();
		traza("MMG:: Valor de atributo fecDesd: " + fecDesd);
		
		String fecHast = conectorParametro("fecHast").trim();
		traza("MMG:: Valor de atributo fecHast: " + fecHast);
		
		String tofeOidTipoOfer = conectorParametro("tofeOidTipoOfer").trim();
		traza("MMG:: Valor de atributo tofeOidTipoOfer: " + tofeOidTipoOfer);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		FacTipoOfertExcluData facTipoOfertExclu= new FacTipoOfertExcluData();
		es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		facTipoOfertExclu.setPaisOidPais(paisOidPaisData);
		facTipoOfertExclu.setFecDesd(
			(java.sql.Date)FormatUtils.parseObject(fecDesd, "java.sql.Date", 
			 datePattern, symbols));
		facTipoOfertExclu.setFecHast(
			(java.sql.Date)FormatUtils.parseObject(fecHast, "java.sql.Date", 
			 datePattern, symbols));
		es.indra.belcorp.mso.PreTipoOfertData tofeOidTipoOferData = null;
		if(tofeOidTipoOfer != null && !tofeOidTipoOfer.trim().equals("")){
			tofeOidTipoOferData = new es.indra.belcorp.mso.PreTipoOfertData();
			tofeOidTipoOferData.setId(new Long(tofeOidTipoOfer));
		}
		facTipoOfertExclu.setTofeOidTipoOfer(tofeOidTipoOferData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("facTipoOfertExclu", facTipoOfertExclu);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(facTipoOfertExclu);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad FacTipoOfertExclu");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad FacTipoOfertExclu");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(facTipoOfertExclu);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("FacTipoOfertExcluLPStartUp");
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
		traza("MMG::Creando FacTipoOfertExclu");
		
		String fecDesd = conectorParametro("fecDesd").trim();
		traza("MMG:: Valor de atributo fecDesd: " + fecDesd);
		
		String fecHast = conectorParametro("fecHast").trim();
		traza("MMG:: Valor de atributo fecHast: " + fecHast);
		
		String tofeOidTipoOfer = conectorParametro("tofeOidTipoOfer").trim();
		traza("MMG:: Valor de atributo tofeOidTipoOfer: " + tofeOidTipoOfer);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		FacTipoOfertExcluData facTipoOfertExclu= new FacTipoOfertExcluData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			facTipoOfertExclu.setId(new Long(id));
		}
		facTipoOfertExclu = (FacTipoOfertExcluData)getSingleObject(BUSINESSID_QUERY, facTipoOfertExclu, 
			facTipoOfertExclu.clone(), "facTipoOfertExclu");
		
		if(facTipoOfertExclu == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		facTipoOfertExclu.setFecDesd(
			(java.sql.Date)FormatUtils.parseObject(fecDesd, "java.sql.Date", 
			 datePattern, symbols));
		facTipoOfertExclu.setFecHast(
			(java.sql.Date)FormatUtils.parseObject(fecHast, "java.sql.Date", 
			 datePattern, symbols));
		es.indra.belcorp.mso.PreTipoOfertData tofeOidTipoOferData = null;
		if(tofeOidTipoOfer != null && !tofeOidTipoOfer.trim().equals("")){
			tofeOidTipoOferData = new es.indra.belcorp.mso.PreTipoOfertData();
			tofeOidTipoOferData.setId(new Long(tofeOidTipoOfer));
		}
		facTipoOfertExclu.setTofeOidTipoOfer(tofeOidTipoOferData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//facTipoOfertExclu.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("facTipoOfertExclu", facTipoOfertExclu);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(facTipoOfertExclu);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad FacTipoOfertExclu");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad FacTipoOfertExclu");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(facTipoOfertExclu);
		
		
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
			FacTipoOfertExcluData facTipoOfertExclu = new FacTipoOfertExcluData();
			facTipoOfertExclu.setId(new Long(claves.nextToken()));
			//facTipoOfertExclu.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(facTipoOfertExclu);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad FacTipoOfertExclu");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad FacTipoOfertExclu");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("FacTipoOfertExcluLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(FacTipoOfertExcluData facTipoOfertExclu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				facTipoOfertExclu.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPreUpdate(FacTipoOfertExcluData facTipoOfertExclu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				facTipoOfertExclu.setPaisOidPais(paisOculto);
			
	}
	
	
	

	protected void cmdPostCreate(FacTipoOfertExcluData facTipoOfertExclu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				facTipoOfertExclu.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPostUpdate(FacTipoOfertExcluData facTipoOfertExclu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				facTipoOfertExclu.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




