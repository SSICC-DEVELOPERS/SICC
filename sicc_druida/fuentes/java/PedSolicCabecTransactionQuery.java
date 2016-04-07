

/*
    INDRA/CAR/mmg
    $Id: PedSolicCabecTransactionQuery.java,v 1.1 2009/12/03 18:38:19 pecbazalar Exp $
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
public class PedSolicCabecTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPedSolicCabecQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "PedSolicCabecConectorQueryList";

	// Definicion del constructor
	public PedSolicCabecTransactionQuery(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
		
			//Metemos en la sesi�n la query de la busqueda en formato param1|param2|....|paramN(para el tema de volver a la 
			//pagina anterior y ,mantener los �ltimos resultados)
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, 
				conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY));
			
			traza("MMG:: LLegao a transaction Query de entidad PedSolicCabec");
			
		
			//Construimos los MSOs (from y to) con los elementos de la b�squeda
			PedSolicCabecData pedSolicCabecFrom =new PedSolicCabecData();
			PedSolicCabecData pedSolicCabecTo = new PedSolicCabecData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			
			
			//Construimos el to
			pedSolicCabecTo = (PedSolicCabecData)pedSolicCabecFrom.clone();
			
			
			//Metemos tanto el fromo como el to como �ltimos mso con par�metros de b�squeda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, pedSolicCabecFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, pedSolicCabecTo);
			
			//Sacamos los datos de paginaci�n
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acci�n de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("pedSolicCabecFrom", pedSolicCabecFrom);
			dto.addProperty("pedSolicCabecTo", pedSolicCabecTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la l�gica de negocio
			traza("MMG:: Iniciada ejecuci�n Query de entidad PedSolicCabec");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecuci�n Query de entidad PedSolicCabec");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}





