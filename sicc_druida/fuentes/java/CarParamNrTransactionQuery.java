

/*
    INDRA/CAR/mmg
    $Id: CarParamNrTransactionQuery.java,v 1.1 2009/12/03 18:35:30 pecbazalar Exp $
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
public class CarParamNrTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCarParamNrQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CarParamNrConectorQueryList";

	// Definicion del constructor
	public CarParamNrTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CarParamNr");
			String niriOidNiveRies = (String)getEntrada("niriOidNiveRies");
			traza("MMG:: Valor de atributo niriOidNiveRies: " + niriOidNiveRies);
			String valMini = (String)getEntrada("valMini");
			traza("MMG:: Valor de atributo valMini: " + valMini);
			String valMaxi = (String)getEntrada("valMaxi");
			traza("MMG:: Valor de atributo valMaxi: " + valMaxi);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CarParamNrData carParamNrFrom =new CarParamNrData();
			CarParamNrData carParamNrTo = new CarParamNrData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesData = null;
			if(niriOidNiveRies != null && !niriOidNiveRies.trim().equals("")){
				niriOidNiveRiesData = new es.indra.belcorp.mso.CarNivelRiesgData();
				niriOidNiveRiesData.setId(new Long(niriOidNiveRies));
			}
			carParamNrFrom.setNiriOidNiveRies(niriOidNiveRiesData);
			carParamNrFrom.setValMini(
				(java.lang.Double)FormatUtils.parseObject(valMini, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carParamNrFrom.setValMaxi(
				(java.lang.Double)FormatUtils.parseObject(valMaxi, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			carParamNrTo = (CarParamNrData)carParamNrFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, carParamNrFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, carParamNrTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("carParamNrFrom", carParamNrFrom);
			dto.addProperty("carParamNrTo", carParamNrTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CarParamNr");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CarParamNr");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





