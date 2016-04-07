

/*
    INDRA/CAR/mmg
    $Id: IntAccesBuzonIvrrgTransactionQuery.java,v 1.1 2009/12/03 18:33:43 pecbazalar Exp $
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
public class IntAccesBuzonIvrrgTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGIntAccesBuzonIvrrgQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "IntAccesBuzonIvrrgConectorQueryList";

	// Definicion del constructor
	public IntAccesBuzonIvrrgTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad IntAccesBuzonIvrrg");
			String codAcceBuzoIvrr = (String)getEntrada("codAcceBuzoIvrr");
			traza("MMG:: Valor de atributo codAcceBuzoIvrr: " + codAcceBuzoIvrr);
			if(codAcceBuzoIvrr != null && !codAcceBuzoIvrr.trim().equals("")) codAcceBuzoIvrr = codAcceBuzoIvrr.toUpperCase();
			String zorgOidRegi = (String)getEntrada("zorgOidRegi");
			traza("MMG:: Valor de atributo zorgOidRegi: " + zorgOidRegi);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			IntAccesBuzonIvrrgData intAccesBuzonIvrrgFrom =new IntAccesBuzonIvrrgData();
			IntAccesBuzonIvrrgData intAccesBuzonIvrrgTo = new IntAccesBuzonIvrrgData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			intAccesBuzonIvrrgFrom.setCodAcceBuzoIvrr(
				(java.lang.String)FormatUtils.parseObject(codAcceBuzoIvrr, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.ZonRegioView2Data zorgOidRegiData = null;
			if(zorgOidRegi != null && !zorgOidRegi.trim().equals("")){
				zorgOidRegiData = new es.indra.belcorp.mso.ZonRegioView2Data();
				zorgOidRegiData.setId(new Long(zorgOidRegi));
			}
			intAccesBuzonIvrrgFrom.setZorgOidRegi(zorgOidRegiData);
			
			
			//Construimos el to
			intAccesBuzonIvrrgTo = (IntAccesBuzonIvrrgData)intAccesBuzonIvrrgFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, intAccesBuzonIvrrgFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, intAccesBuzonIvrrgTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("intAccesBuzonIvrrgFrom", intAccesBuzonIvrrgFrom);
			dto.addProperty("intAccesBuzonIvrrgTo", intAccesBuzonIvrrgTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad IntAccesBuzonIvrrg");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad IntAccesBuzonIvrrg");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





