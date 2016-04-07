

/*
    INDRA/CAR/mmg
    $Id: CobUsuarCobraViewTransactionQuery.java,v 1.1 2009/12/03 18:42:16 pecbazalar Exp $
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
public class CobUsuarCobraViewTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	public static final String CHOICE_ATTRIBUTE = "userOidUsuaCobr";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCobUsuarCobraViewQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CobUsuarCobraViewConectorQueryList";

	// Definicion del constructor
	public CobUsuarCobraViewTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CobUsuarCobraView");
			String fecUltiEsta = (String)getEntrada("fecUltiEsta");
			traza("MMG:: Valor de atributo fecUltiEsta: " + fecUltiEsta);
			String indJefeCobr = (String)getEntrada("indJefeCobr");
			traza("MMG:: Valor de atributo indJefeCobr: " + indJefeCobr);
			String indUsuaSupe = (String)getEntrada("indUsuaSupe");
			traza("MMG:: Valor de atributo indUsuaSupe: " + indUsuaSupe);
			String indUsuaExte = (String)getEntrada("indUsuaExte");
			traza("MMG:: Valor de atributo indUsuaExte: " + indUsuaExte);
			String valTurnHoraEntr = (String)getEntrada("valTurnHoraEntr");
			traza("MMG:: Valor de atributo valTurnHoraEntr: " + valTurnHoraEntr);
			String valTurnHoraSali = (String)getEntrada("valTurnHoraSali");
			traza("MMG:: Valor de atributo valTurnHoraSali: " + valTurnHoraSali);
			String valObse = (String)getEntrada("valObse");
			traza("MMG:: Valor de atributo valObse: " + valObse);
			String userOidUsuaCobr = (String)getEntrada("userOidUsuaCobr");
			traza("MMG:: Valor de atributo userOidUsuaCobr: " + userOidUsuaCobr);
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CobUsuarCobraViewData cobUsuarCobraViewFrom =new CobUsuarCobraViewData();
			CobUsuarCobraViewData cobUsuarCobraViewTo = new CobUsuarCobraViewData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			cobUsuarCobraViewFrom.setFecUltiEsta(
				(java.sql.Date)FormatUtils.parseObject(fecUltiEsta, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobUsuarCobraViewFrom.setIndJefeCobr(
				(java.lang.Long)FormatUtils.parseObject(indJefeCobr, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobUsuarCobraViewFrom.setIndUsuaSupe(
				(java.lang.Long)FormatUtils.parseObject(indUsuaSupe, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobUsuarCobraViewFrom.setIndUsuaExte(
				(java.lang.Long)FormatUtils.parseObject(indUsuaExte, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobUsuarCobraViewFrom.setValTurnHoraEntr(
				(java.lang.String)FormatUtils.parseObject(valTurnHoraEntr, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobUsuarCobraViewFrom.setValTurnHoraSali(
				(java.lang.String)FormatUtils.parseObject(valTurnHoraSali, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobUsuarCobraViewFrom.setValObse(
				(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.GenUsersData userOidUsuaCobrData = null;
			if(userOidUsuaCobr != null && !userOidUsuaCobr.trim().equals("")){
				userOidUsuaCobrData = new es.indra.belcorp.mso.GenUsersData();
				userOidUsuaCobrData.setId(new Long(userOidUsuaCobr));
			}
			cobUsuarCobraViewFrom.setUserOidUsuaCobr(userOidUsuaCobrData);
			es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
				paisOidPaisData.setId(new Long(paisOidPais));
			}
			cobUsuarCobraViewFrom.setPaisOidPais(paisOidPaisData);
			
			
			//Construimos el to
			cobUsuarCobraViewTo = (CobUsuarCobraViewData)cobUsuarCobraViewFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cobUsuarCobraViewFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cobUsuarCobraViewTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cobUsuarCobraViewFrom", cobUsuarCobraViewFrom);
			dto.addProperty("cobUsuarCobraViewTo", cobUsuarCobraViewTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CobUsuarCobraView");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CobUsuarCobraView");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





