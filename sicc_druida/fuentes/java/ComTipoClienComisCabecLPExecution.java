

/*
    INDRA/CAR/mmg
    $Id: ComTipoClienComisCabecLPExecution.java,v 1.1 2009/12/03 18:43:32 pecbazalar Exp $
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

public class ComTipoClienComisCabecLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGComTipoClienComisCabecCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGComTipoClienComisCabecUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGComTipoClienComisCabecRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGComTipoClienComisCabecQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "ComTipoClienComisCabecConectorCreate";
	public static final String CONECTOR_UPDATE = "ComTipoClienComisCabecConectorUpdate";
	public static final String CONECTOR_REMOVE = "ComTipoClienComisCabecConectorRemove";

	public ComTipoClienComisCabecLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("ComTipoClienComisCabecPage");
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
  	correspondiente a la creación de un/a nuevo ComTipoClienComisCabec*/  
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
		
		traza("MMG::Creando ComTipoClienComisCabec");
		
		String codClas = conectorParametro("codClas").trim();
		traza("MMG:: Valor de atributo codClas: " + codClas);
		if(codClas != null && !codClas.trim().equals("")) codClas = codClas.toUpperCase();
		
		String codSubc = conectorParametro("codSubc").trim();
		traza("MMG:: Valor de atributo codSubc: " + codSubc);
		if(codSubc != null && !codSubc.trim().equals("")) codSubc = codSubc.toUpperCase();
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		ComTipoClienComisCabecData comTipoClienComisCabec= new ComTipoClienComisCabecData();
		comTipoClienComisCabec.setCodClas(
			(java.lang.String)FormatUtils.parseObject(codClas, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		comTipoClienComisCabec.setCodSubc(
			(java.lang.Long)FormatUtils.parseObject(codSubc, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("comTipoClienComisCabec", comTipoClienComisCabec);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(comTipoClienComisCabec);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad ComTipoClienComisCabec");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad ComTipoClienComisCabec");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(comTipoClienComisCabec);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("ComTipoClienComisCabecLPStartUp");
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
		traza("MMG::Creando ComTipoClienComisCabec");
		
		String codClas = conectorParametro("codClas").trim();
		traza("MMG:: Valor de atributo codClas: " + codClas);
		if(codClas != null && !codClas.trim().equals("")) codClas = codClas.toUpperCase();
		
		String codSubc = conectorParametro("codSubc").trim();
		traza("MMG:: Valor de atributo codSubc: " + codSubc);
		if(codSubc != null && !codSubc.trim().equals("")) codSubc = codSubc.toUpperCase();
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		ComTipoClienComisCabecData comTipoClienComisCabec= new ComTipoClienComisCabecData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			comTipoClienComisCabec.setId(new Long(id));
		}
		comTipoClienComisCabec = (ComTipoClienComisCabecData)getSingleObject(BUSINESSID_QUERY, comTipoClienComisCabec, 
			comTipoClienComisCabec.clone(), "comTipoClienComisCabec");
		
		if(comTipoClienComisCabec == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		comTipoClienComisCabec.setCodClas(
			(java.lang.String)FormatUtils.parseObject(codClas, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		comTipoClienComisCabec.setCodSubc(
			(java.lang.Long)FormatUtils.parseObject(codSubc, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//comTipoClienComisCabec.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("comTipoClienComisCabec", comTipoClienComisCabec);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(comTipoClienComisCabec);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad ComTipoClienComisCabec");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad ComTipoClienComisCabec");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(comTipoClienComisCabec);
		
		
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
			ComTipoClienComisCabecData comTipoClienComisCabec = new ComTipoClienComisCabecData();
			comTipoClienComisCabec.setId(new Long(claves.nextToken()));
			//comTipoClienComisCabec.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(comTipoClienComisCabec);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad ComTipoClienComisCabec");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad ComTipoClienComisCabec");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("ComTipoClienComisCabecLPStartUp");
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
			label.setEnti("COM_TIPO_CLIEN_COMIS_CABEC");
			label.setDeta(value != null? value: "");
			localizationLabels.add(label);
		}
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(ComTipoClienComisCabecData comTipoClienComisCabec) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                comTipoClienComisCabec.setPaisOidPais(paisOculto);
                
	}
	

	protected void cmdPreUpdate(ComTipoClienComisCabecData comTipoClienComisCabec) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                comTipoClienComisCabec.setPaisOidPais(paisOculto);
                
	}
	
	
	

	protected void cmdPostCreate(ComTipoClienComisCabecData comTipoClienComisCabec) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                comTipoClienComisCabec.setPaisOidPais(paisOculto);
                
	}
	

	protected void cmdPostUpdate(ComTipoClienComisCabecData comTipoClienComisCabec) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                comTipoClienComisCabec.setPaisOidPais(paisOculto);
                
	}
	
	
	
	
}




