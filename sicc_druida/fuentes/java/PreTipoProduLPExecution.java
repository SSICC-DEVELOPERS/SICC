

/*
    INDRA/CAR/mmg
    $Id: PreTipoProduLPExecution.java,v 1.1 2009/12/03 18:43:42 pecbazalar Exp $
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

public class PreTipoProduLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGPreTipoProduCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGPreTipoProduUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGPreTipoProduRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGPreTipoProduQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "PreTipoProduConectorCreate";
	public static final String CONECTOR_UPDATE = "PreTipoProduConectorUpdate";
	public static final String CONECTOR_REMOVE = "PreTipoProduConectorRemove";

	public PreTipoProduLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("PreTipoProduPage");
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
  	correspondiente a la creación de un/a nuevo PreTipoProdu*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando PreTipoProdu");
		
		String codTipoProd = conectorParametro("codTipoProd").trim();
		traza("MMG:: Valor de atributo codTipoProd: " + codTipoProd);
		
		String desTipoProd = conectorParametro("desTipoProd").trim();
		traza("MMG:: Valor de atributo desTipoProd: " + desTipoProd);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		PreTipoProduData preTipoProdu= new PreTipoProduData();
		preTipoProdu.setCodTipoProd(
			(java.lang.Integer)FormatUtils.parseObject(codTipoProd, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preTipoProdu.setDesTipoProd(
			(java.lang.String)FormatUtils.parseObject(desTipoProd, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("preTipoProdu", preTipoProdu);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad PreTipoProdu");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad PreTipoProdu");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("PreTipoProduLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando PreTipoProdu");
		
		String codTipoProd = conectorParametro("codTipoProd").trim();
		traza("MMG:: Valor de atributo codTipoProd: " + codTipoProd);
		
		String desTipoProd = conectorParametro("desTipoProd").trim();
		traza("MMG:: Valor de atributo desTipoProd: " + desTipoProd);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		PreTipoProduData preTipoProdu= new PreTipoProduData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			preTipoProdu.setId(new Integer(id));
		}
		preTipoProdu = (PreTipoProduData)getSingleObject(BUSINESSID_QUERY, preTipoProdu, 
			preTipoProdu.clone(), "preTipoProdu");
		
		if(preTipoProdu == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		preTipoProdu.setCodTipoProd(
			(java.lang.Integer)FormatUtils.parseObject(codTipoProd, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		preTipoProdu.setDesTipoProd(
			(java.lang.String)FormatUtils.parseObject(desTipoProd, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//preTipoProdu.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("preTipoProdu", preTipoProdu);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad PreTipoProdu");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad PreTipoProdu");

		
		
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
			PreTipoProduData preTipoProdu = new PreTipoProduData();
			preTipoProdu.setId(new Integer(claves.nextToken()));
			//preTipoProdu.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(preTipoProdu);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad PreTipoProdu");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad PreTipoProdu");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("PreTipoProduLPStartUp");
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




