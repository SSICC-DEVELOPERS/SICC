

/*
    INDRA/CAR/mmg
    $Id: CarEjecuCuentTransactionQuery.java,v 1.1 2009/12/03 18:41:37 pecbazalar Exp $
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
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class CarEjecuCuentTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCarEjecuCuentQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CarEjecuCuentConectorQueryList";

	// Definicion del constructor
	public CarEjecuCuentTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CarEjecuCuent");
			
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			
			
			String codEjecCuen = (String)getEntrada("codEjecCuen");
			traza("MMG:: Valor de atributo codEjecCuen: " + codEjecCuen);
			
			
			String jeraOidJera = (String)getEntrada("jeraOidJera");
			traza("MMG:: Valor de atributo jeraOidJera: " + jeraOidJera);
			
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CarEjecuCuentData carEjecuCuentFrom =new CarEjecuCuentData();
			CarEjecuCuentData carEjecuCuentTo = new CarEjecuCuentData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			
			es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
				paisOidPaisData.setId(new Integer(paisOidPais));
			}
			carEjecuCuentFrom.setPaisOidPais(paisOidPaisData);
			carEjecuCuentFrom.setCodEjecCuen(
				(java.lang.String)FormatUtils.parseObject(codEjecCuen, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			es.indra.belcorp.mso.CarJerarData jeraOidJeraData = null;
			if(jeraOidJera != null && !jeraOidJera.trim().equals("")){
				jeraOidJeraData = new es.indra.belcorp.mso.CarJerarData();
				jeraOidJeraData.setId(new Integer(jeraOidJera));
			}
			carEjecuCuentFrom.setJeraOidJera(jeraOidJeraData);
			
			
			//Construimos el to
			carEjecuCuentTo = (CarEjecuCuentData)carEjecuCuentFrom.clone();
			
			
			
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, carEjecuCuentFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, carEjecuCuentTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("carEjecuCuentFrom", carEjecuCuentFrom);
			dto.addProperty("carEjecuCuentTo", carEjecuCuentTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CarEjecuCuent");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CarEjecuCuent");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}





