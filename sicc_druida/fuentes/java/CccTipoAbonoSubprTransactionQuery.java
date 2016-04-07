

/*
    INDRA/CAR/mmg
    $Id: CccTipoAbonoSubprTransactionQuery.java,v 1.1 2009/12/03 18:32:22 pecbazalar Exp $
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
public class CccTipoAbonoSubprTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCccTipoAbonoSubprQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CccTipoAbonoSubprConectorQueryList";

	// Definicion del constructor
	public CccTipoAbonoSubprTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CccTipoAbonoSubpr");
			String subpOidSubp = (String)getEntrada("subpOidSubp");
			traza("MMG:: Valor de atributo subpOidSubp: " + subpOidSubp);
			String tcabOidTcab = (String)getEntrada("tcabOidTcab");
			traza("MMG:: Valor de atributo tcabOidTcab: " + tcabOidTcab);
			String cucoOidCuenCont = (String)getEntrada("cucoOidCuenCont");
			traza("MMG:: Valor de atributo cucoOidCuenCont: " + cucoOidCuenCont);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CccTipoAbonoSubprData cccTipoAbonoSubprFrom =new CccTipoAbonoSubprData();
			CccTipoAbonoSubprData cccTipoAbonoSubprTo = new CccTipoAbonoSubprData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.CccSubprData subpOidSubpData = null;
			if(subpOidSubp != null && !subpOidSubp.trim().equals("")){
				subpOidSubpData = new es.indra.belcorp.mso.CccSubprData();
				subpOidSubpData.setId(new Long(subpOidSubp));
			}
			cccTipoAbonoSubprFrom.setSubpOidSubp(subpOidSubpData);
			es.indra.belcorp.mso.CccTipoCargoAbonoData tcabOidTcabData = null;
			if(tcabOidTcab != null && !tcabOidTcab.trim().equals("")){
				tcabOidTcabData = new es.indra.belcorp.mso.CccTipoCargoAbonoData();
				tcabOidTcabData.setId(new Long(tcabOidTcab));
			}
			cccTipoAbonoSubprFrom.setTcabOidTcab(tcabOidTcabData);
			es.indra.belcorp.mso.CccCuentContaData cucoOidCuenContData = null;
			if(cucoOidCuenCont != null && !cucoOidCuenCont.trim().equals("")){
				cucoOidCuenContData = new es.indra.belcorp.mso.CccCuentContaData();
				cucoOidCuenContData.setId(new Long(cucoOidCuenCont));
			}
			cccTipoAbonoSubprFrom.setCucoOidCuenCont(cucoOidCuenContData);
			
			
			//Construimos el to
			cccTipoAbonoSubprTo = (CccTipoAbonoSubprData)cccTipoAbonoSubprFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cccTipoAbonoSubprFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cccTipoAbonoSubprTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cccTipoAbonoSubprFrom", cccTipoAbonoSubprFrom);
			dto.addProperty("cccTipoAbonoSubprTo", cccTipoAbonoSubprTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CccTipoAbonoSubpr");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CccTipoAbonoSubpr");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





