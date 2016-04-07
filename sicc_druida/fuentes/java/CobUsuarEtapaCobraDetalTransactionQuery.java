

/*
    INDRA/CAR/mmg
    $Id: CobUsuarEtapaCobraDetalTransactionQuery.java,v 1.1 2009/12/03 18:35:49 pecbazalar Exp $
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
public class CobUsuarEtapaCobraDetalTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCobUsuarEtapaCobraDetalQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CobUsuarEtapaCobraDetalConectorQueryList";

	// Definicion del constructor
	public CobUsuarEtapaCobraDetalTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CobUsuarEtapaCobraDetal");
			String ueccOidUsuaEtapCobr = (String)getEntrada("ueccOidUsuaEtapCobr");
			traza("MMG:: Valor de atributo ueccOidUsuaEtapCobr: " + ueccOidUsuaEtapCobr);
			String edtcOidEtapDeudTipoCarg = (String)getEntrada("edtcOidEtapDeudTipoCarg");
			traza("MMG:: Valor de atributo edtcOidEtapDeudTipoCarg: " + edtcOidEtapDeudTipoCarg);
			String zsgvOidSubgVent = (String)getEntrada("zsgvOidSubgVent");
			traza("MMG:: Valor de atributo zsgvOidSubgVent: " + zsgvOidSubgVent);
			String zorgOidRegi = (String)getEntrada("zorgOidRegi");
			traza("MMG:: Valor de atributo zorgOidRegi: " + zorgOidRegi);
			String zzonOidZona = (String)getEntrada("zzonOidZona");
			traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
			String zsccOidSecc = (String)getEntrada("zsccOidSecc");
			traza("MMG:: Valor de atributo zsccOidSecc: " + zsccOidSecc);
			String terrOidTerr = (String)getEntrada("terrOidTerr");
			traza("MMG:: Valor de atributo terrOidTerr: " + terrOidTerr);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CobUsuarEtapaCobraDetalData cobUsuarEtapaCobraDetalFrom =new CobUsuarEtapaCobraDetalData();
			CobUsuarEtapaCobraDetalData cobUsuarEtapaCobraDetalTo = new CobUsuarEtapaCobraDetalData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.CobUsuarEtapaCobraCabecData ueccOidUsuaEtapCobrData = null;
			if(ueccOidUsuaEtapCobr != null && !ueccOidUsuaEtapCobr.trim().equals("")){
				ueccOidUsuaEtapCobrData = new es.indra.belcorp.mso.CobUsuarEtapaCobraCabecData();
				ueccOidUsuaEtapCobrData.setId(new Long(ueccOidUsuaEtapCobr));
			}
			cobUsuarEtapaCobraDetalFrom.setUeccOidUsuaEtapCobr(ueccOidUsuaEtapCobrData);
			es.indra.belcorp.mso.CobEtapaDeudaTipoCargoData edtcOidEtapDeudTipoCargData = null;
			if(edtcOidEtapDeudTipoCarg != null && !edtcOidEtapDeudTipoCarg.trim().equals("")){
				edtcOidEtapDeudTipoCargData = new es.indra.belcorp.mso.CobEtapaDeudaTipoCargoData();
				edtcOidEtapDeudTipoCargData.setId(new Long(edtcOidEtapDeudTipoCarg));
			}
			cobUsuarEtapaCobraDetalFrom.setEdtcOidEtapDeudTipoCarg(edtcOidEtapDeudTipoCargData);
			es.indra.belcorp.mso.ZonSubGerenVentaViewData zsgvOidSubgVentData = null;
			if(zsgvOidSubgVent != null && !zsgvOidSubgVent.trim().equals("")){
				zsgvOidSubgVentData = new es.indra.belcorp.mso.ZonSubGerenVentaViewData();
				zsgvOidSubgVentData.setId(new Long(zsgvOidSubgVent));
			}
			cobUsuarEtapaCobraDetalFrom.setZsgvOidSubgVent(zsgvOidSubgVentData);
			es.indra.belcorp.mso.ZonRegioViewData zorgOidRegiData = null;
			if(zorgOidRegi != null && !zorgOidRegi.trim().equals("")){
				zorgOidRegiData = new es.indra.belcorp.mso.ZonRegioViewData();
				zorgOidRegiData.setId(new Long(zorgOidRegi));
			}
			cobUsuarEtapaCobraDetalFrom.setZorgOidRegi(zorgOidRegiData);
			es.indra.belcorp.mso.ZonZonaViewData zzonOidZonaData = null;
			if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
				zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaViewData();
				zzonOidZonaData.setId(new Long(zzonOidZona));
			}
			cobUsuarEtapaCobraDetalFrom.setZzonOidZona(zzonOidZonaData);
			es.indra.belcorp.mso.ZonSecciViewData zsccOidSeccData = null;
			if(zsccOidSecc != null && !zsccOidSecc.trim().equals("")){
				zsccOidSeccData = new es.indra.belcorp.mso.ZonSecciViewData();
				zsccOidSeccData.setId(new Long(zsccOidSecc));
			}
			cobUsuarEtapaCobraDetalFrom.setZsccOidSecc(zsccOidSeccData);
			es.indra.belcorp.mso.ZonTerriViewData terrOidTerrData = null;
			if(terrOidTerr != null && !terrOidTerr.trim().equals("")){
				terrOidTerrData = new es.indra.belcorp.mso.ZonTerriViewData();
				terrOidTerrData.setId(new Long(terrOidTerr));
			}
			cobUsuarEtapaCobraDetalFrom.setTerrOidTerr(terrOidTerrData);
			
			
			//Construimos el to
			cobUsuarEtapaCobraDetalTo = (CobUsuarEtapaCobraDetalData)cobUsuarEtapaCobraDetalFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cobUsuarEtapaCobraDetalFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cobUsuarEtapaCobraDetalTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cobUsuarEtapaCobraDetalFrom", cobUsuarEtapaCobraDetalFrom);
			dto.addProperty("cobUsuarEtapaCobraDetalTo", cobUsuarEtapaCobraDetalTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CobUsuarEtapaCobraDetal");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CobUsuarEtapaCobraDetal");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





