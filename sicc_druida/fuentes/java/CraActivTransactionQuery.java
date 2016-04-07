

/*
    INDRA/CAR/mmg
    $Id: CraActivTransactionQuery.java,v 1.1 2009/12/03 18:35:25 pecbazalar Exp $
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
public class CraActivTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCraActivQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CraActivConectorQueryList";

	// Definicion del constructor
	public CraActivTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CraActiv");
			String codActi = (String)getEntrada("codActi");
			traza("MMG:: Valor de atributo codActi: " + codActi);
			String numDiasDesp = (String)getEntrada("numDiasDesp");
			traza("MMG:: Valor de atributo numDiasDesp: " + numDiasDesp);
			String numCampAnte = (String)getEntrada("numCampAnte");
			traza("MMG:: Valor de atributo numCampAnte: " + numCampAnte);
			String indEbel = (String)getEntrada("indEbel");
			traza("MMG:: Valor de atributo indEbel: " + indEbel);
			String indFest = (String)getEntrada("indFest");
			traza("MMG:: Valor de atributo indFest: " + indFest);
			String indLabo = (String)getEntrada("indLabo");
			traza("MMG:: Valor de atributo indLabo: " + indLabo);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CraActivData craActivFrom =new CraActivData();
			CraActivData craActivTo = new CraActivData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			craActivFrom.setCodActi(
				(java.lang.String)FormatUtils.parseObject(codActi, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			craActivFrom.setNumDiasDesp(
				(java.lang.Long)FormatUtils.parseObject(numDiasDesp, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			craActivFrom.setNumCampAnte(
				(java.lang.Long)FormatUtils.parseObject(numCampAnte, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			craActivFrom.setIndEbel(
				(java.lang.Long)FormatUtils.parseObject(indEbel, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			craActivFrom.setIndFest(
				(java.lang.Long)FormatUtils.parseObject(indFest, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			craActivFrom.setIndLabo(
				(java.lang.Long)FormatUtils.parseObject(indLabo, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			craActivTo = (CraActivData)craActivFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, craActivFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, craActivTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("craActivFrom", craActivFrom);
			dto.addProperty("craActivTo", craActivTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CraActiv");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CraActiv");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





