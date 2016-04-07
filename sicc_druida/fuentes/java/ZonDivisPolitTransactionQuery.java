

/*
    INDRA/CAR/mmg
    $Id: ZonDivisPolitTransactionQuery.java,v 1.1 2009/12/03 18:39:26 pecbazalar Exp $
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
public class ZonDivisPolitTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGZonDivisPolitQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "ZonDivisPolitConectorQueryList";

	// Definicion del constructor
	public ZonDivisPolitTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad ZonDivisPolit");
			
			String codDiviPoli = (String)getEntrada("codDiviPoli");
			traza("MMG:: Valor de atributo codDiviPoli: " + codDiviPoli);
			
			
			String orde = (String)getEntrada("orde");
			traza("MMG:: Valor de atributo orde: " + orde);
			
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			ZonDivisPolitData zonDivisPolitFrom =new ZonDivisPolitData();
			ZonDivisPolitData zonDivisPolitTo = new ZonDivisPolitData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			zonDivisPolitFrom.setCodDiviPoli(
				(java.lang.String)FormatUtils.parseObject(codDiviPoli, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonDivisPolitFrom.setOrde(
				(java.lang.String)FormatUtils.parseObject(orde, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			zonDivisPolitTo = (ZonDivisPolitData)zonDivisPolitFrom.clone();
			
			
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, zonDivisPolitFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, zonDivisPolitTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("zonDivisPolitFrom", zonDivisPolitFrom);
			dto.addProperty("zonDivisPolitTo", zonDivisPolitTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad ZonDivisPolit");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad ZonDivisPolit");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}





