

/*
    INDRA/CAR/mmg
    $Id: FacImpreVirtuViewTransactionQuery.java,v 1.1 2009/12/03 18:36:07 pecbazalar Exp $
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
public class FacImpreVirtuViewTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "desImpr";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGFacImpreVirtuViewQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "FacImpreVirtuViewConectorQueryList";

	// Definicion del constructor
	public FacImpreVirtuViewTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad FacImpreVirtuView");
			String codImpr = (String)getEntrada("codImpr");
			traza("MMG:: Valor de atributo codImpr: " + codImpr);
			if(codImpr != null && !codImpr.trim().equals("")) codImpr = codImpr.toUpperCase();
			String desImpr = (String)getEntrada("desImpr");
			traza("MMG:: Valor de atributo desImpr: " + desImpr);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			FacImpreVirtuViewData facImpreVirtuViewFrom =new FacImpreVirtuViewData();
			FacImpreVirtuViewData facImpreVirtuViewTo = new FacImpreVirtuViewData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			facImpreVirtuViewFrom.setCodImpr(
				(java.lang.String)FormatUtils.parseObject(codImpr, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			facImpreVirtuViewFrom.setDesImpr(
				(java.lang.String)FormatUtils.parseObject(desImpr, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			facImpreVirtuViewTo = (FacImpreVirtuViewData)facImpreVirtuViewFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, facImpreVirtuViewFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, facImpreVirtuViewTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("facImpreVirtuViewFrom", facImpreVirtuViewFrom);
			dto.addProperty("facImpreVirtuViewTo", facImpreVirtuViewTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad FacImpreVirtuView");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad FacImpreVirtuView");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





