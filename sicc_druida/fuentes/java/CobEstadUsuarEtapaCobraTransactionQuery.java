

/*
    INDRA/CAR/mmg
    $Id: CobEstadUsuarEtapaCobraTransactionQuery.java,v 1.1 2009/12/03 18:36:12 pecbazalar Exp $
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
public class CobEstadUsuarEtapaCobraTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	public static final String CHOICE_ATTRIBUTE = "codEstaUsuaEtapCobr";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCobEstadUsuarEtapaCobraQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CobEstadUsuarEtapaCobraConectorQueryList";

	// Definicion del constructor
	public CobEstadUsuarEtapaCobraTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CobEstadUsuarEtapaCobra");
			String codEstaUsuaEtapCobr = (String)getEntrada("codEstaUsuaEtapCobr");
			traza("MMG:: Valor de atributo codEstaUsuaEtapCobr: " + codEstaUsuaEtapCobr);
			if(codEstaUsuaEtapCobr != null && !codEstaUsuaEtapCobr.trim().equals("")) codEstaUsuaEtapCobr = codEstaUsuaEtapCobr.toUpperCase();
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CobEstadUsuarEtapaCobraData cobEstadUsuarEtapaCobraFrom =new CobEstadUsuarEtapaCobraData();
			CobEstadUsuarEtapaCobraData cobEstadUsuarEtapaCobraTo = new CobEstadUsuarEtapaCobraData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			cobEstadUsuarEtapaCobraFrom.setCodEstaUsuaEtapCobr(
				(java.lang.String)FormatUtils.parseObject(codEstaUsuaEtapCobr, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			cobEstadUsuarEtapaCobraTo = (CobEstadUsuarEtapaCobraData)cobEstadUsuarEtapaCobraFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cobEstadUsuarEtapaCobraFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cobEstadUsuarEtapaCobraTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cobEstadUsuarEtapaCobraFrom", cobEstadUsuarEtapaCobraFrom);
			dto.addProperty("cobEstadUsuarEtapaCobraTo", cobEstadUsuarEtapaCobraTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CobEstadUsuarEtapaCobra");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CobEstadUsuarEtapaCobra");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





