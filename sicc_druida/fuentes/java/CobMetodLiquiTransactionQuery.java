

/*
    INDRA/CAR/mmg
    $Id: CobMetodLiquiTransactionQuery.java,v 1.1 2009/12/03 18:33:24 pecbazalar Exp $
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
public class CobMetodLiquiTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "valDescMetoLiqu";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCobMetodLiquiQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CobMetodLiquiConectorQueryList";

	// Definicion del constructor
	public CobMetodLiquiTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CobMetodLiqui");
			String codMetoLiqu = (String)getEntrada("codMetoLiqu");
			traza("MMG:: Valor de atributo codMetoLiqu: " + codMetoLiqu);
			if(codMetoLiqu != null && !codMetoLiqu.trim().equals("")) codMetoLiqu = codMetoLiqu.toUpperCase();
			String valDescMetoLiqu = (String)getEntrada("valDescMetoLiqu");
			traza("MMG:: Valor de atributo valDescMetoLiqu: " + valDescMetoLiqu);
			String indLiqu = (String)getEntrada("indLiqu");
			traza("MMG:: Valor de atributo indLiqu: " + indLiqu);
			String indLiquGrupUsua = (String)getEntrada("indLiquGrupUsua");
			traza("MMG:: Valor de atributo indLiquGrupUsua: " + indLiquGrupUsua);
			String valObse = (String)getEntrada("valObse");
			traza("MMG:: Valor de atributo valObse: " + valObse);
			String baesOidBaseEsca = (String)getEntrada("baesOidBaseEsca");
			traza("MMG:: Valor de atributo baesOidBaseEsca: " + baesOidBaseEsca);
			
		
			//Construimos los MSOs (from y to) con los elementos de la b�squeda
			CobMetodLiquiData cobMetodLiquiFrom =new CobMetodLiquiData();
			CobMetodLiquiData cobMetodLiquiTo = new CobMetodLiquiData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			cobMetodLiquiFrom.setCodMetoLiqu(
				(java.lang.String)FormatUtils.parseObject(codMetoLiqu, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobMetodLiquiFrom.setValDescMetoLiqu(
				(java.lang.String)FormatUtils.parseObject(valDescMetoLiqu, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobMetodLiquiFrom.setIndLiqu(
				(java.lang.Long)FormatUtils.parseObject(indLiqu, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobMetodLiquiFrom.setIndLiquGrupUsua(
				(java.lang.Long)FormatUtils.parseObject(indLiquGrupUsua, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobMetodLiquiFrom.setValObse(
				(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.CobBaseEscalData baesOidBaseEscaData = null;
			if(baesOidBaseEsca != null && !baesOidBaseEsca.trim().equals("")){
				baesOidBaseEscaData = new es.indra.belcorp.mso.CobBaseEscalData();
				baesOidBaseEscaData.setId(new Long(baesOidBaseEsca));
			}
			cobMetodLiquiFrom.setBaesOidBaseEsca(baesOidBaseEscaData);
			
			
			//Construimos el to
			cobMetodLiquiTo = (CobMetodLiquiData)cobMetodLiquiFrom.clone();
			
			
			//Metemos tanto el fromo como el to como �ltimos mso con par�metros de b�squeda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cobMetodLiquiFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cobMetodLiquiTo);
			
			//Sacamos los datos de paginaci�n
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acci�n de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cobMetodLiquiFrom", cobMetodLiquiFrom);
			dto.addProperty("cobMetodLiquiTo", cobMetodLiquiTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acci�n de prequery
			cmdPreQuery(cobMetodLiquiFrom, cobMetodLiquiTo);
			
			
			//Invocamos la l�gica de negocio
			traza("MMG:: Iniciada ejecuci�n Query de entidad CobMetodLiqui");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecuci�n Query de entidad CobMetodLiqui");
			
			//Ejecutamos la acci�n de postquery
			cmdPostQuery(cobMetodLiquiFrom, cobMetodLiquiTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(CobMetodLiquiData cobMetodLiquiFrom, CobMetodLiquiData cobMetodLiquiTo) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobMetodLiquiFrom.setPaisOidPais(paisOculto);
                cobMetodLiquiTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
	}
	
	
	public void cmdPostQuery(CobMetodLiquiData cobMetodLiquiFrom, CobMetodLiquiData cobMetodLiquiTo, DruidaConector result) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobMetodLiquiFrom.setPaisOidPais(paisOculto);
                cobMetodLiquiTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
	}
	
	
}





