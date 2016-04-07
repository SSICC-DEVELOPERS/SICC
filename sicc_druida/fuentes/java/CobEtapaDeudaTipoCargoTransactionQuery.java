

/*
    INDRA/CAR/mmg
    $Id: CobEtapaDeudaTipoCargoTransactionQuery.java,v 1.1 2009/12/03 18:32:42 pecbazalar Exp $
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
public class CobEtapaDeudaTipoCargoTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "tcabOidTipoCargAbon";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCobEtapaDeudaTipoCargoQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CobEtapaDeudaTipoCargoConectorQueryList";

	// Definicion del constructor
	public CobEtapaDeudaTipoCargoTransactionQuery(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
		
			//Metemos en la sesi�n la query de la busqueda en formato param1|param2|....|paramN(para el tema de volver a la 
			//pagina anterior y ,mantener los �ltimos resultados)
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, 
				conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY));
			
			traza("MMG:: LLegao a transaction Query de entidad CobEtapaDeudaTipoCargo");
			String etdeOidEtapDeud = (String)getEntrada("etdeOidEtapDeud");
			traza("MMG:: Valor de atributo etdeOidEtapDeud: " + etdeOidEtapDeud);
			String tcabOidTipoCargAbon = (String)getEntrada("tcabOidTipoCargAbon");
			traza("MMG:: Valor de atributo tcabOidTipoCargAbon: " + tcabOidTipoCargAbon);
			
		
			//Construimos los MSOs (from y to) con los elementos de la b�squeda
			CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoFrom =new CobEtapaDeudaTipoCargoData();
			CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoTo = new CobEtapaDeudaTipoCargoData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.CobEtapaDeudaData etdeOidEtapDeudData = null;
			if(etdeOidEtapDeud != null && !etdeOidEtapDeud.trim().equals("")){
				etdeOidEtapDeudData = new es.indra.belcorp.mso.CobEtapaDeudaData();
				etdeOidEtapDeudData.setId(new Long(etdeOidEtapDeud));
			}
			cobEtapaDeudaTipoCargoFrom.setEtdeOidEtapDeud(etdeOidEtapDeudData);
			es.indra.belcorp.mso.CccTipoCargoAbonoData tcabOidTipoCargAbonData = null;
			if(tcabOidTipoCargAbon != null && !tcabOidTipoCargAbon.trim().equals("")){
				tcabOidTipoCargAbonData = new es.indra.belcorp.mso.CccTipoCargoAbonoData();
				tcabOidTipoCargAbonData.setId(new Long(tcabOidTipoCargAbon));
			}
			cobEtapaDeudaTipoCargoFrom.setTcabOidTipoCargAbon(tcabOidTipoCargAbonData);
			
			
			//Construimos el to
			cobEtapaDeudaTipoCargoTo = (CobEtapaDeudaTipoCargoData)cobEtapaDeudaTipoCargoFrom.clone();
			
			
			//Metemos tanto el fromo como el to como �ltimos mso con par�metros de b�squeda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cobEtapaDeudaTipoCargoFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cobEtapaDeudaTipoCargoTo);
			
			//Sacamos los datos de paginaci�n
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acci�n de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cobEtapaDeudaTipoCargoFrom", cobEtapaDeudaTipoCargoFrom);
			dto.addProperty("cobEtapaDeudaTipoCargoTo", cobEtapaDeudaTipoCargoTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acci�n de prequery
			cmdPreQuery(cobEtapaDeudaTipoCargoFrom, cobEtapaDeudaTipoCargoTo);
			
			
			//Invocamos la l�gica de negocio
			traza("MMG:: Iniciada ejecuci�n Query de entidad CobEtapaDeudaTipoCargo");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecuci�n Query de entidad CobEtapaDeudaTipoCargo");
			
			//Ejecutamos la acci�n de postquery
			cmdPostQuery(cobEtapaDeudaTipoCargoFrom, cobEtapaDeudaTipoCargoTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoFrom, CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				CobEtapaDeudaData cobE = new CobEtapaDeudaData();
				cobE.setPaisOidPais(paisOculto);
			
	}
	
	
	public void cmdPostQuery(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoFrom, CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				CobEtapaDeudaData cobE = new CobEtapaDeudaData();
				cobE.setPaisOidPais(paisOculto);
			
	}
	
	
}





