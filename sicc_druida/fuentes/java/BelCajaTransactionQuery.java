

/*
    INDRA/CAR/mmg
    $Id: BelCajaTransactionQuery.java,v 1.1 2009/12/03 18:41:16 pecbazalar Exp $
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
public class BelCajaTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGBelCajaQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "BelCajaConectorQueryList";

	// Definicion del constructor
	public BelCajaTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad BelCaja");
			String sbacOidSbac = (String)getEntrada("sbacOidSbac");
			traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
			String codCaja = (String)getEntrada("codCaja");
			traza("MMG:: Valor de atributo codCaja: " + codCaja);
			if(codCaja != null && !codCaja.trim().equals("")) codCaja = codCaja.toUpperCase();
			String userOidUser = (String)getEntrada("userOidUser");
			traza("MMG:: Valor de atributo userOidUser: " + userOidUser);
			String ticjOidTipoCaja = (String)getEntrada("ticjOidTipoCaja");
			traza("MMG:: Valor de atributo ticjOidTipoCaja: " + ticjOidTipoCaja);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			BelCajaData belCajaFrom =new BelCajaData();
			BelCajaData belCajaTo = new BelCajaData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
			if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
				sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
				sbacOidSbacData.setId(new Long(sbacOidSbac));
			}
			belCajaFrom.setSbacOidSbac(sbacOidSbacData);
			belCajaFrom.setCodCaja(
				(java.lang.String)FormatUtils.parseObject(codCaja, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.GenUsersData userOidUserData = null;
			if(userOidUser != null && !userOidUser.trim().equals("")){
				userOidUserData = new es.indra.belcorp.mso.GenUsersData();
				userOidUserData.setId(new Long(userOidUser));
			}
			belCajaFrom.setUserOidUser(userOidUserData);
			es.indra.belcorp.mso.BelTipoCajaData ticjOidTipoCajaData = null;
			if(ticjOidTipoCaja != null && !ticjOidTipoCaja.trim().equals("")){
				ticjOidTipoCajaData = new es.indra.belcorp.mso.BelTipoCajaData();
				ticjOidTipoCajaData.setId(new Long(ticjOidTipoCaja));
			}
			belCajaFrom.setTicjOidTipoCaja(ticjOidTipoCajaData);
			
			
			//Construimos el to
			belCajaTo = (BelCajaData)belCajaFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, belCajaFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, belCajaTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("belCajaFrom", belCajaFrom);
			dto.addProperty("belCajaTo", belCajaTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(belCajaFrom, belCajaTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad BelCaja");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad BelCaja");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(belCajaFrom, belCajaTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(BelCajaData belCajaFrom, BelCajaData belCajaTo) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                belCajaFrom.setPaisOidPais(paisOculto);
                belCajaTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
			
	}
	
	
	public void cmdPostQuery(BelCajaData belCajaFrom, BelCajaData belCajaTo, DruidaConector result) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                belCajaFrom.setPaisOidPais(paisOculto);
                belCajaTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
			
	}
	
	
}





