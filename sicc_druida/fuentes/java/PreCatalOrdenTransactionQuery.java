

/*
    INDRA/CAR/mmg
    $Id: PreCatalOrdenTransactionQuery.java,v 1.1 2009/12/03 18:33:15 pecbazalar Exp $
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
public class PreCatalOrdenTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPreCatalOrdenQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "PreCatalOrdenConectorQueryList";

	// Definicion del constructor
	public PreCatalOrdenTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad PreCatalOrden");
			String marcOidMarc = (String)getEntrada("marcOidMarc");
			traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
			String canaOidCana = (String)getEntrada("canaOidCana");
			traza("MMG:: Valor de atributo canaOidCana: " + canaOidCana);
			String ocatOidCata = (String)getEntrada("ocatOidCata");
			traza("MMG:: Valor de atributo ocatOidCata: " + ocatOidCata);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PreCatalOrdenData preCatalOrdenFrom =new PreCatalOrdenData();
			PreCatalOrdenData preCatalOrdenTo = new PreCatalOrdenData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
			if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
				marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
				marcOidMarcData.setId(new Long(marcOidMarc));
			}
			preCatalOrdenFrom.setMarcOidMarc(marcOidMarcData);
			es.indra.belcorp.mso.SegCanalViewData canaOidCanaData = null;
			if(canaOidCana != null && !canaOidCana.trim().equals("")){
				canaOidCanaData = new es.indra.belcorp.mso.SegCanalViewData();
				canaOidCanaData.setId(new Long(canaOidCana));
			}
			preCatalOrdenFrom.setCanaOidCana(canaOidCanaData);
			es.indra.belcorp.mso.PreCatalData ocatOidCataData = null;
			if(ocatOidCata != null && !ocatOidCata.trim().equals("")){
				ocatOidCataData = new es.indra.belcorp.mso.PreCatalData();
				ocatOidCataData.setId(new Long(ocatOidCata));
			}
			preCatalOrdenFrom.setOcatOidCata(ocatOidCataData);
			
			
			//Construimos el to
			preCatalOrdenTo = (PreCatalOrdenData)preCatalOrdenFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, preCatalOrdenFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, preCatalOrdenTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("preCatalOrdenFrom", preCatalOrdenFrom);
			dto.addProperty("preCatalOrdenTo", preCatalOrdenTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PreCatalOrden");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PreCatalOrden");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





