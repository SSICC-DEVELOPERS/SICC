

/*
    INDRA/CAR/mmg
    $Id: FacAsignImpreTransactionQuery.java,v 1.1 2009/12/03 18:40:47 pecbazalar Exp $
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
public class FacAsignImpreTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGFacAsignImpreQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "FacAsignImpreConectorQueryList";

	// Definicion del constructor
	public FacAsignImpreTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad FacAsignImpre");
			String imviOidImpr = (String)getEntrada("imviOidImpr");
			traza("MMG:: Valor de atributo imviOidImpr: " + imviOidImpr);
			String sbacOidSbac = (String)getEntrada("sbacOidSbac");
			traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
			String forsOidForm = (String)getEntrada("forsOidForm");
			traza("MMG:: Valor de atributo forsOidForm: " + forsOidForm);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			FacAsignImpreData facAsignImpreFrom =new FacAsignImpreData();
			FacAsignImpreData facAsignImpreTo = new FacAsignImpreData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.FacImpreVirtuViewData imviOidImprData = null;
			if(imviOidImpr != null && !imviOidImpr.trim().equals("")){
				imviOidImprData = new es.indra.belcorp.mso.FacImpreVirtuViewData();
				imviOidImprData.setId(new Long(imviOidImpr));
			}
			facAsignImpreFrom.setImviOidImpr(imviOidImprData);
			es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
			if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
				sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
				sbacOidSbacData.setId(new Long(sbacOidSbac));
			}
			facAsignImpreFrom.setSbacOidSbac(sbacOidSbacData);
			es.indra.belcorp.mso.FacFormuData forsOidFormData = null;
			if(forsOidForm != null && !forsOidForm.trim().equals("")){
				forsOidFormData = new es.indra.belcorp.mso.FacFormuData();
				forsOidFormData.setId(new Long(forsOidForm));
			}
			facAsignImpreFrom.setForsOidForm(forsOidFormData);
			
			
			//Construimos el to
			facAsignImpreTo = (FacAsignImpreData)facAsignImpreFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, facAsignImpreFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, facAsignImpreTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("facAsignImpreFrom", facAsignImpreFrom);
			dto.addProperty("facAsignImpreTo", facAsignImpreTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad FacAsignImpre");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad FacAsignImpre");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





