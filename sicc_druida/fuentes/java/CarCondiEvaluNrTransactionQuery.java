

/*
    INDRA/CAR/mmg
    $Id: CarCondiEvaluNrTransactionQuery.java,v 1.1 2009/12/03 18:35:28 pecbazalar Exp $
    DESC
*/

import java.util.*;
import es.indra.utils.*;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.druida.belcorp.MMGDruidaTransaction;
import es.indra.druida.belcorp.MMGException;
import es.indra.druida.belcorp.MMGNoSessionException;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class CarCondiEvaluNrTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCarCondiEvaluNrQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CarCondiEvaluNrConectorQueryList";

	// Definicion del constructor
	public CarCondiEvaluNrTransactionQuery(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
		
			//Metemos en la sesión la query de la busqueda en formato param1|param2|....|paramN(para el tema de volver a la 
			//pagina anterior y ,mantener los últimos resultados)
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, 
				conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY));
			
			traza("MMG:: LLegao a transaction Query de entidad CarCondiEvaluNr");
			String penrOidParaEvalNr = (String)getEntrada("penrOidParaEvalNr");
			traza("MMG:: Valor de atributo penrOidParaEvalNr: " + penrOidParaEvalNr);
			if(penrOidParaEvalNr != null && !penrOidParaEvalNr.trim().equals("")) penrOidParaEvalNr = penrOidParaEvalNr.toUpperCase();
			String valMini = (String)getEntrada("valMini");
			traza("MMG:: Valor de atributo valMini: " + valMini);
			if(valMini != null && !valMini.trim().equals("")) valMini = valMini.toUpperCase();
			String valMaxi = (String)getEntrada("valMaxi");
			traza("MMG:: Valor de atributo valMaxi: " + valMaxi);
			if(valMaxi != null && !valMaxi.trim().equals("")) valMaxi = valMaxi.toUpperCase();
			String valEscaMini = (String)getEntrada("valEscaMini");
			traza("MMG:: Valor de atributo valEscaMini: " + valEscaMini);
			if(valEscaMini != null && !valEscaMini.trim().equals("")) valEscaMini = valEscaMini.toUpperCase();
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CarCondiEvaluNrData carCondiEvaluNrFrom =new CarCondiEvaluNrData();
			CarCondiEvaluNrData carCondiEvaluNrTo = new CarCondiEvaluNrData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.CarParamEvaluNrData penrOidParaEvalNrData = null;
			if(penrOidParaEvalNr != null && !penrOidParaEvalNr.trim().equals("")){
				penrOidParaEvalNrData = new es.indra.belcorp.mso.CarParamEvaluNrData();
				penrOidParaEvalNrData.setId(new Long(penrOidParaEvalNr));
			}
			carCondiEvaluNrFrom.setPenrOidParaEvalNr(penrOidParaEvalNrData);
			carCondiEvaluNrFrom.setValMini(
				(java.lang.Double)FormatUtils.parseObject(valMini, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carCondiEvaluNrFrom.setValMaxi(
				(java.lang.Double)FormatUtils.parseObject(valMaxi, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carCondiEvaluNrFrom.setValEscaMini(
				(java.lang.Double)FormatUtils.parseObject(valEscaMini, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			carCondiEvaluNrTo = (CarCondiEvaluNrData)carCondiEvaluNrFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, carCondiEvaluNrFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, carCondiEvaluNrTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("carCondiEvaluNrFrom", carCondiEvaluNrFrom);
			dto.addProperty("carCondiEvaluNrTo", carCondiEvaluNrTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CarCondiEvaluNr");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CarCondiEvaluNr");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





