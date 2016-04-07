

/*
    INDRA/CAR/mmg
    $Id: MaeEncueAplicClienTransactionQuery.java,v 1.1 2009/12/03 18:35:38 pecbazalar Exp $
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
public class MaeEncueAplicClienTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeEncueAplicClienQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaeEncueAplicClienConectorQueryList";

	// Definicion del constructor
	public MaeEncueAplicClienTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MaeEncueAplicClien");
			String clieOidClie = (String)getEntrada("clieOidClie");
			traza("MMG:: Valor de atributo clieOidClie: " + clieOidClie);
			String reenOidResp = (String)getEntrada("reenOidResp");
			traza("MMG:: Valor de atributo reenOidResp: " + reenOidResp);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeEncueAplicClienData maeEncueAplicClienFrom =new MaeEncueAplicClienData();
			MaeEncueAplicClienData maeEncueAplicClienTo = new MaeEncueAplicClienData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.MaeClienData clieOidClieData = null;
			if(clieOidClie != null && !clieOidClie.trim().equals("")){
				clieOidClieData = new es.indra.belcorp.mso.MaeClienData();
				clieOidClieData.setId(new Long(clieOidClie));
			}
			maeEncueAplicClienFrom.setClieOidClie(clieOidClieData);
			es.indra.belcorp.mso.MaeRespuEncueData reenOidRespData = null;
			if(reenOidResp != null && !reenOidResp.trim().equals("")){
				reenOidRespData = new es.indra.belcorp.mso.MaeRespuEncueData();
				reenOidRespData.setId(new Long(reenOidResp));
			}
			maeEncueAplicClienFrom.setReenOidResp(reenOidRespData);
			
			
			//Construimos el to
			maeEncueAplicClienTo = (MaeEncueAplicClienData)maeEncueAplicClienFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maeEncueAplicClienFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maeEncueAplicClienTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeEncueAplicClienFrom", maeEncueAplicClienFrom);
			dto.addProperty("maeEncueAplicClienTo", maeEncueAplicClienTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeEncueAplicClien");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeEncueAplicClien");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





