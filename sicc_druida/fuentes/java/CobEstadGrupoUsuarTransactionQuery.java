

/*
    INDRA/CAR/mmg
    $Id: CobEstadGrupoUsuarTransactionQuery.java,v 1.1 2009/12/03 18:39:40 pecbazalar Exp $
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
public class CobEstadGrupoUsuarTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCobEstadGrupoUsuarQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CobEstadGrupoUsuarConectorQueryList";

	// Definicion del constructor
	public CobEstadGrupoUsuarTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CobEstadGrupoUsuar");
			String codEstaGrupUsua = (String)getEntrada("codEstaGrupUsua");
			traza("MMG:: Valor de atributo codEstaGrupUsua: " + codEstaGrupUsua);
			if(codEstaGrupUsua != null && !codEstaGrupUsua.trim().equals("")) codEstaGrupUsua = codEstaGrupUsua.toUpperCase();
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CobEstadGrupoUsuarData cobEstadGrupoUsuarFrom =new CobEstadGrupoUsuarData();
			CobEstadGrupoUsuarData cobEstadGrupoUsuarTo = new CobEstadGrupoUsuarData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			cobEstadGrupoUsuarFrom.setCodEstaGrupUsua(
				(java.lang.String)FormatUtils.parseObject(codEstaGrupUsua, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			cobEstadGrupoUsuarTo = (CobEstadGrupoUsuarData)cobEstadGrupoUsuarFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cobEstadGrupoUsuarFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cobEstadGrupoUsuarTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cobEstadGrupoUsuarFrom", cobEstadGrupoUsuarFrom);
			dto.addProperty("cobEstadGrupoUsuarTo", cobEstadGrupoUsuarTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CobEstadGrupoUsuar");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CobEstadGrupoUsuar");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





