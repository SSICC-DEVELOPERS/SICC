

/*
    INDRA/CAR/mmg
    $Id: MaeCodigClienAnterTransactionQuery.java,v 1.1 2009/12/03 18:34:47 pecbazalar Exp $
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
public class MaeCodigClienAnterTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeCodigClienAnterQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaeCodigClienAnterConectorQueryList";

	// Definicion del constructor
	public MaeCodigClienAnterTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MaeCodigClienAnter");
			String clieOidClieNuev = (String)getEntrada("clieOidClieNuev");
			traza("MMG:: Valor de atributo clieOidClieNuev: " + clieOidClieNuev);
			String codClieAnti = (String)getEntrada("codClieAnti");
			traza("MMG:: Valor de atributo codClieAnti: " + codClieAnti);
			if(codClieAnti != null && !codClieAnti.trim().equals("")) codClieAnti = codClieAnti.toUpperCase();
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			String valSistProc = (String)getEntrada("valSistProc");
			traza("MMG:: Valor de atributo valSistProc: " + valSistProc);
			if(valSistProc != null && !valSistProc.trim().equals("")) valSistProc = valSistProc.toUpperCase();
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeCodigClienAnterData maeCodigClienAnterFrom =new MaeCodigClienAnterData();
			MaeCodigClienAnterData maeCodigClienAnterTo = new MaeCodigClienAnterData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.MaeClienData clieOidClieNuevData = null;
			if(clieOidClieNuev != null && !clieOidClieNuev.trim().equals("")){
				clieOidClieNuevData = new es.indra.belcorp.mso.MaeClienData();
				clieOidClieNuevData.setId(new Long(clieOidClieNuev));
			}
			maeCodigClienAnterFrom.setClieOidClieNuev(clieOidClieNuevData);
			maeCodigClienAnterFrom.setCodClieAnti(
				(java.lang.String)FormatUtils.parseObject(codClieAnti, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
				paisOidPaisData.setId(new Long(paisOidPais));
			}
			maeCodigClienAnterFrom.setPaisOidPais(paisOidPaisData);
			maeCodigClienAnterFrom.setValSistProc(
				(java.lang.String)FormatUtils.parseObject(valSistProc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			maeCodigClienAnterTo = (MaeCodigClienAnterData)maeCodigClienAnterFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maeCodigClienAnterFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maeCodigClienAnterTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeCodigClienAnterFrom", maeCodigClienAnterFrom);
			dto.addProperty("maeCodigClienAnterTo", maeCodigClienAnterTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeCodigClienAnter");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeCodigClienAnter");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





