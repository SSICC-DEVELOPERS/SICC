

/*
    INDRA/CAR/mmg
    $Id: CarJerarTransactionQuery.java,v 1.1 2009/12/03 18:39:28 pecbazalar Exp $
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
public class CarJerarTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCarJerarQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CarJerarConectorQueryList";

	// Definicion del constructor
	public CarJerarTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CarJerar");
			String codJera = (String)getEntrada("codJera");
			traza("MMG:: Valor de atributo codJera: " + codJera);
			if(codJera != null && !codJera.trim().equals("")) codJera = codJera.toUpperCase();
			String numDias = (String)getEntrada("numDias");
			traza("MMG:: Valor de atributo numDias: " + numDias);
			String valPorcLineCred = (String)getEntrada("valPorcLineCred");
			traza("MMG:: Valor de atributo valPorcLineCred: " + valPorcLineCred);
			String valPorcMontMaxi = (String)getEntrada("valPorcMontMaxi");
			traza("MMG:: Valor de atributo valPorcMontMaxi: " + valPorcMontMaxi);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CarJerarData carJerarFrom =new CarJerarData();
			CarJerarData carJerarTo = new CarJerarData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			carJerarFrom.setCodJera(
				(java.lang.String)FormatUtils.parseObject(codJera, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carJerarFrom.setNumDias(
				(java.lang.Long)FormatUtils.parseObject(numDias, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carJerarFrom.setValPorcLineCred(
				(java.lang.Double)FormatUtils.parseObject(valPorcLineCred, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carJerarFrom.setValPorcMontMaxi(
				(java.lang.Double)FormatUtils.parseObject(valPorcMontMaxi, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			carJerarTo = (CarJerarData)carJerarFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, carJerarFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, carJerarTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("carJerarFrom", carJerarFrom);
			dto.addProperty("carJerarTo", carJerarTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CarJerar");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CarJerar");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





