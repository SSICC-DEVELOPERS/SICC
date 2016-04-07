

/*
    INDRA/CAR/mmg
    $Id: CobUsuarEtapaCobraCabecTransactionQuery.java,v 1.1 2009/12/03 18:34:15 pecbazalar Exp $
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
public class CobUsuarEtapaCobraCabecTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	public static final String CHOICE_ATTRIBUTE = "uscoOidUsuaCobr";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCobUsuarEtapaCobraCabecQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CobUsuarEtapaCobraCabecConectorQueryList";

	// Definicion del constructor
	public CobUsuarEtapaCobraCabecTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CobUsuarEtapaCobraCabec");
			String uscoOidUsuaCobr = (String)getEntrada("uscoOidUsuaCobr");
			traza("MMG:: Valor de atributo uscoOidUsuaCobr: " + uscoOidUsuaCobr);
			String etdeOidEtapDeud = (String)getEntrada("etdeOidEtapDeud");
			traza("MMG:: Valor de atributo etdeOidEtapDeud: " + etdeOidEtapDeud);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecFrom =new CobUsuarEtapaCobraCabecData();
			CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecTo = new CobUsuarEtapaCobraCabecData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.CobUsuarCobraViewData uscoOidUsuaCobrData = null;
			if(uscoOidUsuaCobr != null && !uscoOidUsuaCobr.trim().equals("")){
				uscoOidUsuaCobrData = new es.indra.belcorp.mso.CobUsuarCobraViewData();
				uscoOidUsuaCobrData.setId(new Long(uscoOidUsuaCobr));
			}
			cobUsuarEtapaCobraCabecFrom.setUscoOidUsuaCobr(uscoOidUsuaCobrData);
			es.indra.belcorp.mso.CobEtapaDeudaData etdeOidEtapDeudData = null;
			if(etdeOidEtapDeud != null && !etdeOidEtapDeud.trim().equals("")){
				etdeOidEtapDeudData = new es.indra.belcorp.mso.CobEtapaDeudaData();
				etdeOidEtapDeudData.setId(new Long(etdeOidEtapDeud));
			}
			cobUsuarEtapaCobraCabecFrom.setEtdeOidEtapDeud(etdeOidEtapDeudData);
			
			
			//Construimos el to
			cobUsuarEtapaCobraCabecTo = (CobUsuarEtapaCobraCabecData)cobUsuarEtapaCobraCabecFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cobUsuarEtapaCobraCabecFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cobUsuarEtapaCobraCabecTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cobUsuarEtapaCobraCabecFrom", cobUsuarEtapaCobraCabecFrom);
			dto.addProperty("cobUsuarEtapaCobraCabecTo", cobUsuarEtapaCobraCabecTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CobUsuarEtapaCobraCabec");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CobUsuarEtapaCobraCabec");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





