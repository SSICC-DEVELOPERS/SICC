

/*
    INDRA/CAR/mmg
    $Id: GenUsersTransactionQuery.java,v 1.1 2009/12/03 18:43:13 pecbazalar Exp $
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
public class GenUsersTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	public static final String CHOICE_ATTRIBUTE = "myid";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGGenUsersQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "GenUsersConectorQueryList";

	// Definicion del constructor
	public GenUsersTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad GenUsers");
			String myid = (String)getEntrada("myid");
			traza("MMG:: Valor de atributo myid: " + myid);
			String credential = (String)getEntrada("credential");
			traza("MMG:: Valor de atributo credential: " + credential);
			String setdate = (String)getEntrada("setdate");
			traza("MMG:: Valor de atributo setdate: " + setdate);
			String retries = (String)getEntrada("retries");
			traza("MMG:: Valor de atributo retries: " + retries);
			String blocked = (String)getEntrada("blocked");
			traza("MMG:: Valor de atributo blocked: " + blocked);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			GenUsersData genUsersFrom =new GenUsersData();
			GenUsersData genUsersTo = new GenUsersData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.GenPrincipalsData myidData = null;
			if(myid != null && !myid.trim().equals("")){
				myidData = new es.indra.belcorp.mso.GenPrincipalsData();
				myidData.setId(new Long(myid));
			}
			genUsersFrom.setMyid(myidData);
			genUsersFrom.setCredential(
				(java.lang.String)FormatUtils.parseObject(credential, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			genUsersFrom.setSetdate(
				(java.sql.Date)FormatUtils.parseObject(setdate, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			genUsersFrom.setRetries(
				(java.lang.Long)FormatUtils.parseObject(retries, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			genUsersFrom.setBlocked(
				(java.lang.Long)FormatUtils.parseObject(blocked, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			genUsersTo = (GenUsersData)genUsersFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, genUsersFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, genUsersTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("genUsersFrom", genUsersFrom);
			dto.addProperty("genUsersTo", genUsersTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad GenUsers");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad GenUsers");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





