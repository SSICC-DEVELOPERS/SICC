

/*
    INDRA/CAR/mmg
    $Id: RecAutorTransactionQuery.java,v 1.1 2009/12/03 18:34:34 pecbazalar Exp $
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
public class RecAutorTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGRecAutorQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "RecAutorConectorQueryList";

	// Definicion del constructor
	public RecAutorTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad RecAutor");
			String codUsua = (String)getEntrada("codUsua");
			traza("MMG:: Valor de atributo codUsua: " + codUsua);
			String tiopOidTipoOper = (String)getEntrada("tiopOidTipoOper");
			traza("MMG:: Valor de atributo tiopOidTipoOper: " + tiopOidTipoOper);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			RecAutorData recAutorFrom =new RecAutorData();
			RecAutorData recAutorTo = new RecAutorData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.GenUsersData codUsuaData = null;
			if(codUsua != null && !codUsua.trim().equals("")){
				codUsuaData = new es.indra.belcorp.mso.GenUsersData();
				codUsuaData.setId(new Long(codUsua));
			}
			recAutorFrom.setCodUsua(codUsuaData);
			es.indra.belcorp.mso.RecTiposOperaViewData tiopOidTipoOperData = null;
			if(tiopOidTipoOper != null && !tiopOidTipoOper.trim().equals("")){
				tiopOidTipoOperData = new es.indra.belcorp.mso.RecTiposOperaViewData();
				tiopOidTipoOperData.setId(new Long(tiopOidTipoOper));
			}
			recAutorFrom.setTiopOidTipoOper(tiopOidTipoOperData);
			
			
			//Construimos el to
			recAutorTo = (RecAutorData)recAutorFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, recAutorFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, recAutorTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("recAutorFrom", recAutorFrom);
			dto.addProperty("recAutorTo", recAutorTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(recAutorFrom, recAutorTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad RecAutor");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad RecAutor");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(recAutorFrom, recAutorTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(RecAutorData recAutorFrom, RecAutorData recAutorTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); 
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recAutorFrom.setPaisOidPais(paisOculto); 
				recAutorTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(RecAutorData recAutorFrom, RecAutorData recAutorTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recAutorFrom.setPaisOidPais(paisOculto); 
				recAutorTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





