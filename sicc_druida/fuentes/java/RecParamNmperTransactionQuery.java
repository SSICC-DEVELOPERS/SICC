

/*
    INDRA/CAR/mmg
    $Id: RecParamNmperTransactionQuery.java,v 1.1 2009/12/03 18:39:43 pecbazalar Exp $
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
public class RecParamNmperTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGRecParamNmperQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "RecParamNmperConectorQueryList";

	// Definicion del constructor
	public RecParamNmperTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad RecParamNmper");
			String ticlOidTipoClie = (String)getEntrada("ticlOidTipoClie");
			traza("MMG:: Valor de atributo ticlOidTipoClie: " + ticlOidTipoClie);
			String pperOidPrecPerd = (String)getEntrada("pperOidPrecPerd");
			traza("MMG:: Valor de atributo pperOidPrecPerd: " + pperOidPrecPerd);
			String valPorcReca = (String)getEntrada("valPorcReca");
			traza("MMG:: Valor de atributo valPorcReca: " + valPorcReca);
			String indParaModi = (String)getEntrada("indParaModi");
			traza("MMG:: Valor de atributo indParaModi: " + indParaModi);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			RecParamNmperData recParamNmperFrom =new RecParamNmperData();
			RecParamNmperData recParamNmperTo = new RecParamNmperData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.MaeTipoClienData ticlOidTipoClieData = null;
			if(ticlOidTipoClie != null && !ticlOidTipoClie.trim().equals("")){
				ticlOidTipoClieData = new es.indra.belcorp.mso.MaeTipoClienData();
				ticlOidTipoClieData.setId(new Long(ticlOidTipoClie));
			}
			recParamNmperFrom.setTiclOidTipoClie(ticlOidTipoClieData);
			es.indra.belcorp.mso.RecPreciPerdiData pperOidPrecPerdData = null;
			if(pperOidPrecPerd != null && !pperOidPrecPerd.trim().equals("")){
				pperOidPrecPerdData = new es.indra.belcorp.mso.RecPreciPerdiData();
				pperOidPrecPerdData.setId(new Long(pperOidPrecPerd));
			}
			recParamNmperFrom.setPperOidPrecPerd(pperOidPrecPerdData);
			recParamNmperFrom.setValPorcReca(
				(java.lang.Double)FormatUtils.parseObject(valPorcReca, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recParamNmperFrom.setIndParaModi(
				(java.lang.Long)FormatUtils.parseObject(indParaModi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			recParamNmperTo = (RecParamNmperData)recParamNmperFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, recParamNmperFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, recParamNmperTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("recParamNmperFrom", recParamNmperFrom);
			dto.addProperty("recParamNmperTo", recParamNmperTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(recParamNmperFrom, recParamNmperTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad RecParamNmper");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad RecParamNmper");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(recParamNmperFrom, recParamNmperTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(RecParamNmperData recParamNmperFrom, RecParamNmperData recParamNmperTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recParamNmperFrom.setPaisOidPais(paisOculto); recParamNmperTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(RecParamNmperData recParamNmperFrom, RecParamNmperData recParamNmperTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recParamNmperFrom.setPaisOidPais(paisOculto); recParamNmperTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





