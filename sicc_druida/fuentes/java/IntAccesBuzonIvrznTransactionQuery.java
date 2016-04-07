

/*
    INDRA/CAR/mmg
    $Id: IntAccesBuzonIvrznTransactionQuery.java,v 1.1 2009/12/03 18:35:24 pecbazalar Exp $
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
public class IntAccesBuzonIvrznTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGIntAccesBuzonIvrznQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "IntAccesBuzonIvrznConectorQueryList";

	// Definicion del constructor
	public IntAccesBuzonIvrznTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad IntAccesBuzonIvrzn");
			String codAcceBuzoIvrz = (String)getEntrada("codAcceBuzoIvrz");
			traza("MMG:: Valor de atributo codAcceBuzoIvrz: " + codAcceBuzoIvrz);
			if(codAcceBuzoIvrz != null && !codAcceBuzoIvrz.trim().equals("")) codAcceBuzoIvrz = codAcceBuzoIvrz.toUpperCase();
			String zzonOidZona = (String)getEntrada("zzonOidZona");
			traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			IntAccesBuzonIvrznData intAccesBuzonIvrznFrom =new IntAccesBuzonIvrznData();
			IntAccesBuzonIvrznData intAccesBuzonIvrznTo = new IntAccesBuzonIvrznData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			intAccesBuzonIvrznFrom.setCodAcceBuzoIvrz(
				(java.lang.String)FormatUtils.parseObject(codAcceBuzoIvrz, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.ZonZonaView2Data zzonOidZonaData = null;
			if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
				zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaView2Data();
				zzonOidZonaData.setId(new Long(zzonOidZona));
			}
			intAccesBuzonIvrznFrom.setZzonOidZona(zzonOidZonaData);
			
			
			//Construimos el to
			intAccesBuzonIvrznTo = (IntAccesBuzonIvrznData)intAccesBuzonIvrznFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, intAccesBuzonIvrznFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, intAccesBuzonIvrznTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("intAccesBuzonIvrznFrom", intAccesBuzonIvrznFrom);
			dto.addProperty("intAccesBuzonIvrznTo", intAccesBuzonIvrznTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad IntAccesBuzonIvrzn");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad IntAccesBuzonIvrzn");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





