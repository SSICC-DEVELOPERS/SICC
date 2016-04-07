

/*
    INDRA/CAR/mmg
    $Id: CobValorArgumTransactionQuery.java,v 1.1 2009/12/03 18:42:04 pecbazalar Exp $
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
public class CobValorArgumTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "valDescValoArgu";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCobValorArgumQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CobValorArgumConectorQueryList";

	// Definicion del constructor
	public CobValorArgumTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CobValorArgum");
			String valArgu = (String)getEntrada("valArgu");
			traza("MMG:: Valor de atributo valArgu: " + valArgu);
			if(valArgu != null && !valArgu.trim().equals("")) valArgu = valArgu.toUpperCase();
			String valDescValoArgu = (String)getEntrada("valDescValoArgu");
			traza("MMG:: Valor de atributo valDescValoArgu: " + valDescValoArgu);
			String arguOidArgu = (String)getEntrada("arguOidArgu");
			traza("MMG:: Valor de atributo arguOidArgu: " + arguOidArgu);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CobValorArgumData cobValorArgumFrom =new CobValorArgumData();
			CobValorArgumData cobValorArgumTo = new CobValorArgumData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			cobValorArgumFrom.setValArgu(
				(java.lang.String)FormatUtils.parseObject(valArgu, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobValorArgumFrom.setValDescValoArgu(
				(java.lang.String)FormatUtils.parseObject(valDescValoArgu, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.CobArgumData arguOidArguData = null;
			if(arguOidArgu != null && !arguOidArgu.trim().equals("")){
				arguOidArguData = new es.indra.belcorp.mso.CobArgumData();
				arguOidArguData.setId(new Long(arguOidArgu));
			}
			cobValorArgumFrom.setArguOidArgu(arguOidArguData);
			
			
			//Construimos el to
			cobValorArgumTo = (CobValorArgumData)cobValorArgumFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cobValorArgumFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cobValorArgumTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cobValorArgumFrom", cobValorArgumFrom);
			dto.addProperty("cobValorArgumTo", cobValorArgumTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CobValorArgum");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CobValorArgum");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





