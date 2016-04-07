

/*
    INDRA/CAR/mmg
    $Id: CarAsignEjecuCuentTransactionQuery.java,v 1.1 2009/12/03 18:35:08 pecbazalar Exp $
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
public class CarAsignEjecuCuentTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCarAsignEjecuCuentQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CarAsignEjecuCuentConectorQueryList";

	// Definicion del constructor
	public CarAsignEjecuCuentTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CarAsignEjecuCuent");
			
			String niriOidNiveRies = (String)getEntrada("niriOidNiveRies");
			traza("MMG:: Valor de atributo niriOidNiveRies: " + niriOidNiveRies);
			
			
			String zsgvOidSubgVent = (String)getEntrada("zsgvOidSubgVent");
			traza("MMG:: Valor de atributo zsgvOidSubgVent: " + zsgvOidSubgVent);
			
			
			String zorgOidRegi = (String)getEntrada("zorgOidRegi");
			traza("MMG:: Valor de atributo zorgOidRegi: " + zorgOidRegi);
			
			
			String zzonOidZona = (String)getEntrada("zzonOidZona");
			traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
			
			
			String ejcuOidEjecCuen = (String)getEntrada("ejcuOidEjecCuen");
			traza("MMG:: Valor de atributo ejcuOidEjecCuen: " + ejcuOidEjecCuen);
			
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CarAsignEjecuCuentData carAsignEjecuCuentFrom =new CarAsignEjecuCuentData();
			CarAsignEjecuCuentData carAsignEjecuCuentTo = new CarAsignEjecuCuentData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			
			es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesData = null;
			if(niriOidNiveRies != null && !niriOidNiveRies.trim().equals("")){
				niriOidNiveRiesData = new es.indra.belcorp.mso.CarNivelRiesgData();
				niriOidNiveRiesData.setId(new Integer(niriOidNiveRies));
			}
			carAsignEjecuCuentFrom.setNiriOidNiveRies(niriOidNiveRiesData);
			
			es.indra.belcorp.mso.ZonSubGerenVentaData zsgvOidSubgVentData = null;
			if(zsgvOidSubgVent != null && !zsgvOidSubgVent.trim().equals("")){
				zsgvOidSubgVentData = new es.indra.belcorp.mso.ZonSubGerenVentaData();
				zsgvOidSubgVentData.setId(new Integer(zsgvOidSubgVent));
			}
			carAsignEjecuCuentFrom.setZsgvOidSubgVent(zsgvOidSubgVentData);
			
			es.indra.belcorp.mso.ZonRegioData zorgOidRegiData = null;
			if(zorgOidRegi != null && !zorgOidRegi.trim().equals("")){
				zorgOidRegiData = new es.indra.belcorp.mso.ZonRegioData();
				zorgOidRegiData.setId(new Integer(zorgOidRegi));
			}
			carAsignEjecuCuentFrom.setZorgOidRegi(zorgOidRegiData);
			
			es.indra.belcorp.mso.ZonZonaData zzonOidZonaData = null;
			if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
				zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaData();
				zzonOidZonaData.setId(new Integer(zzonOidZona));
			}
			carAsignEjecuCuentFrom.setZzonOidZona(zzonOidZonaData);
			
			es.indra.belcorp.mso.CarEjecuCuentData ejcuOidEjecCuenData = null;
			if(ejcuOidEjecCuen != null && !ejcuOidEjecCuen.trim().equals("")){
				ejcuOidEjecCuenData = new es.indra.belcorp.mso.CarEjecuCuentData();
				ejcuOidEjecCuenData.setId(new Integer(ejcuOidEjecCuen));
			}
			carAsignEjecuCuentFrom.setEjcuOidEjecCuen(ejcuOidEjecCuenData);
			
			
			//Construimos el to
			carAsignEjecuCuentTo = (CarAsignEjecuCuentData)carAsignEjecuCuentFrom.clone();
			
			
			
			
			
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, carAsignEjecuCuentFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, carAsignEjecuCuentTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("carAsignEjecuCuentFrom", carAsignEjecuCuentFrom);
			dto.addProperty("carAsignEjecuCuentTo", carAsignEjecuCuentTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CarAsignEjecuCuent");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CarAsignEjecuCuent");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}





