

/*
    INDRA/CAR/mmg
    $Id: CccMarcaTipoAbonoLPExecution.java,v 1.1 2009/12/03 18:43:48 pecbazalar Exp $
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
import es.indra.belcorp.mso.*;

public class CccMarcaTipoAbonoLPExecution extends MMGDruidaBase{
	//Constantes de l�ogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCccMarcaTipoAbonoCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCccMarcaTipoAbonoUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCccMarcaTipoAbonoRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCccMarcaTipoAbonoQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CccMarcaTipoAbonoConectorCreate";
	public static final String CONECTOR_UPDATE = "CccMarcaTipoAbonoConectorUpdate";
	public static final String CONECTOR_REMOVE = "CccMarcaTipoAbonoConectorRemove";

	public CccMarcaTipoAbonoLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CccMarcaTipoAbonoPage");
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		//Activamos las trazas
		setTrazaFichero();
	
		try{
			//Sacamos la acci�n a realizar y ejecutamos la acci�n correspondiente
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			
			//Caragamos los elemetnos en la pagina
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
	
			//Ejecutamos la acci�n indicada
			if(accion.equals(ACCION_CREATE)) cmdCreate();
			if(accion.equals(ACCION_UPDATE)) cmdUpdate();
			if(accion.equals(ACCION_REMOVE)) cmdRemove();
		}catch(Exception e){
			handleException(e);
		}
  }
  
  /**Permite crear un nuevo elemento de la entidad. Invoca la l�gica de negocio
  	correspondiente a la creaci�n de un/a nuevo CccMarcaTipoAbono*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando CccMarcaTipoAbono");
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		String masiOidMarcSali = conectorParametro("masiOidMarcSali").trim();
		traza("MMG:: Valor de atributo masiOidMarcSali: " + masiOidMarcSali);
		
		String taspOidTipoAbonSubp = conectorParametro("taspOidTipoAbonSubp").trim();
		traza("MMG:: Valor de atributo taspOidTipoAbonSubp: " + taspOidTipoAbonSubp);
		
		String indEntrSali = conectorParametro("indEntrSali").trim();
		traza("MMG:: Valor de atributo indEntrSali: " + indEntrSali);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CccMarcaTipoAbonoData cccMarcaTipoAbono= new CccMarcaTipoAbonoData();
		cccMarcaTipoAbono.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.CccMarcaSituaData masiOidMarcSaliData = null;
		if(masiOidMarcSali != null && !masiOidMarcSali.trim().equals("")){
			masiOidMarcSaliData = new es.indra.belcorp.mso.CccMarcaSituaData();
			masiOidMarcSaliData.setId(new Integer(masiOidMarcSali));
		}
		cccMarcaTipoAbono.setMasiOidMarcSali(masiOidMarcSaliData);
		es.indra.belcorp.mso.CccTipoAbonoSubprData taspOidTipoAbonSubpData = null;
		if(taspOidTipoAbonSubp != null && !taspOidTipoAbonSubp.trim().equals("")){
			taspOidTipoAbonSubpData = new es.indra.belcorp.mso.CccTipoAbonoSubprData();
			taspOidTipoAbonSubpData.setId(new Integer(taspOidTipoAbonSubp));
		}
		cccMarcaTipoAbono.setTaspOidTipoAbonSubp(taspOidTipoAbonSubpData);
		cccMarcaTipoAbono.setIndEntrSali(
			(java.lang.String)FormatUtils.parseObject(indEntrSali, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cccMarcaTipoAbono", cccMarcaTipoAbono);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Create de entidad CccMarcaTipoAbono");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecuci�n Create de entidad CccMarcaTipoAbono");
		
		
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp
		conectorAction("CccMarcaTipoAbonoLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operaci�n de modificaci�n sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando CccMarcaTipoAbono");
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		String masiOidMarcSali = conectorParametro("masiOidMarcSali").trim();
		traza("MMG:: Valor de atributo masiOidMarcSali: " + masiOidMarcSali);
		
		String taspOidTipoAbonSubp = conectorParametro("taspOidTipoAbonSubp").trim();
		traza("MMG:: Valor de atributo taspOidTipoAbonSubp: " + taspOidTipoAbonSubp);
		
		String indEntrSali = conectorParametro("indEntrSali").trim();
		traza("MMG:: Valor de atributo indEntrSali: " + indEntrSali);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CccMarcaTipoAbonoData cccMarcaTipoAbono= new CccMarcaTipoAbonoData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			cccMarcaTipoAbono.setId(new Integer(id));
		}
		cccMarcaTipoAbono = (CccMarcaTipoAbonoData)getSingleObject(BUSINESSID_QUERY, cccMarcaTipoAbono, 
			cccMarcaTipoAbono.clone(), "cccMarcaTipoAbono");
		
		if(cccMarcaTipoAbono == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		cccMarcaTipoAbono.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.CccMarcaSituaData masiOidMarcSaliData = null;
		if(masiOidMarcSali != null && !masiOidMarcSali.trim().equals("")){
			masiOidMarcSaliData = new es.indra.belcorp.mso.CccMarcaSituaData();
			masiOidMarcSaliData.setId(new Integer(masiOidMarcSali));
		}
		cccMarcaTipoAbono.setMasiOidMarcSali(masiOidMarcSaliData);
		es.indra.belcorp.mso.CccTipoAbonoSubprData taspOidTipoAbonSubpData = null;
		if(taspOidTipoAbonSubp != null && !taspOidTipoAbonSubp.trim().equals("")){
			taspOidTipoAbonSubpData = new es.indra.belcorp.mso.CccTipoAbonoSubprData();
			taspOidTipoAbonSubpData.setId(new Integer(taspOidTipoAbonSubp));
		}
		cccMarcaTipoAbono.setTaspOidTipoAbonSubp(taspOidTipoAbonSubpData);
		cccMarcaTipoAbono.setIndEntrSali(
			(java.lang.String)FormatUtils.parseObject(indEntrSali, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//cccMarcaTipoAbono.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de realizar una modificaci�n
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cccMarcaTipoAbono", cccMarcaTipoAbono);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Update de entidad CccMarcaTipoAbono");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecuci�n Update de entidad CccMarcaTipoAbono");

		
		
		//Redirigimos a la LP que cierra el dialogo
		//Registramos que se recagen los datos en la venta en la cual se ha producido la operaci�n
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
			CccMarcaTipoAbonoData cccMarcaTipoAbono = new CccMarcaTipoAbonoData();
			cccMarcaTipoAbono.setId(new Integer(claves.nextToken()));
			//cccMarcaTipoAbono.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(cccMarcaTipoAbono);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Remove de entidad CccMarcaTipoAbono");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecuci�n Remove de entidad CccMarcaTipoAbono");
		
		

		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp y requery
		conectorAction("CccMarcaTipoAbonoLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	

	
	
	

	

	
	
	
	
}




