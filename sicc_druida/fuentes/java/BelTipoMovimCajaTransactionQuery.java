

/*
    INDRA/CAR/mmg
    $Id: BelTipoMovimCajaTransactionQuery.java,v 1.1 2009/12/03 18:43:02 pecbazalar Exp $
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
public class BelTipoMovimCajaTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "desTipoMoviCaja";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGBelTipoMovimCajaQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "BelTipoMovimCajaConectorQueryList";

	// Definicion del constructor
	public BelTipoMovimCajaTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad BelTipoMovimCaja");
			String codCaja = (String)getEntrada("codCaja");
			traza("MMG:: Valor de atributo codCaja: " + codCaja);
			if(codCaja != null && !codCaja.trim().equals("")) codCaja = codCaja.toUpperCase();
			String desTipoMoviCaja = (String)getEntrada("desTipoMoviCaja");
			traza("MMG:: Valor de atributo desTipoMoviCaja: " + desTipoMoviCaja);
			String valSign = (String)getEntrada("valSign");
			traza("MMG:: Valor de atributo valSign: " + valSign);
			String indAuto = (String)getEntrada("indAuto");
			traza("MMG:: Valor de atributo indAuto: " + indAuto);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			BelTipoMovimCajaData belTipoMovimCajaFrom =new BelTipoMovimCajaData();
			BelTipoMovimCajaData belTipoMovimCajaTo = new BelTipoMovimCajaData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			belTipoMovimCajaFrom.setCodCaja(
				(java.lang.String)FormatUtils.parseObject(codCaja, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belTipoMovimCajaFrom.setDesTipoMoviCaja(
				(java.lang.String)FormatUtils.parseObject(desTipoMoviCaja, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belTipoMovimCajaFrom.setValSign(
				(java.lang.String)FormatUtils.parseObject(valSign, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belTipoMovimCajaFrom.setIndAuto(
				(java.lang.String)FormatUtils.parseObject(indAuto, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			belTipoMovimCajaTo = (BelTipoMovimCajaData)belTipoMovimCajaFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, belTipoMovimCajaFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, belTipoMovimCajaTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("belTipoMovimCajaFrom", belTipoMovimCajaFrom);
			dto.addProperty("belTipoMovimCajaTo", belTipoMovimCajaTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad BelTipoMovimCaja");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad BelTipoMovimCaja");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





