

/*
    INDRA/CAR/mmg
    $Id: CccMarcaTipoAbonoTransactionQuery.java,v 1.1 2009/12/03 18:40:48 pecbazalar Exp $
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
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class CccMarcaTipoAbonoTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCccMarcaTipoAbonoQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CccMarcaTipoAbonoConectorQueryList";

	// Definicion del constructor
	public CccMarcaTipoAbonoTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CccMarcaTipoAbono");
			String valObse = (String)getEntrada("valObse");
			traza("MMG:: Valor de atributo valObse: " + valObse);
			String masiOidMarcSali = (String)getEntrada("masiOidMarcSali");
			traza("MMG:: Valor de atributo masiOidMarcSali: " + masiOidMarcSali);
			String taspOidTipoAbonSubp = (String)getEntrada("taspOidTipoAbonSubp");
			traza("MMG:: Valor de atributo taspOidTipoAbonSubp: " + taspOidTipoAbonSubp);
			String indEntrSali = (String)getEntrada("indEntrSali");
			traza("MMG:: Valor de atributo indEntrSali: " + indEntrSali);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CccMarcaTipoAbonoData cccMarcaTipoAbonoFrom =new CccMarcaTipoAbonoData();
			CccMarcaTipoAbonoData cccMarcaTipoAbonoTo = new CccMarcaTipoAbonoData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			cccMarcaTipoAbonoFrom.setValObse(
				(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.CccMarcaSituaData masiOidMarcSaliData = null;
			if(masiOidMarcSali != null && !masiOidMarcSali.trim().equals("")){
				masiOidMarcSaliData = new es.indra.belcorp.mso.CccMarcaSituaData();
				masiOidMarcSaliData.setId(new Integer(masiOidMarcSali));
			}
			cccMarcaTipoAbonoFrom.setMasiOidMarcSali(masiOidMarcSaliData);
			es.indra.belcorp.mso.CccTipoAbonoSubprData taspOidTipoAbonSubpData = null;
			if(taspOidTipoAbonSubp != null && !taspOidTipoAbonSubp.trim().equals("")){
				taspOidTipoAbonSubpData = new es.indra.belcorp.mso.CccTipoAbonoSubprData();
				taspOidTipoAbonSubpData.setId(new Integer(taspOidTipoAbonSubp));
			}
			cccMarcaTipoAbonoFrom.setTaspOidTipoAbonSubp(taspOidTipoAbonSubpData);
			cccMarcaTipoAbonoFrom.setIndEntrSali(
				(java.lang.String)FormatUtils.parseObject(indEntrSali, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			cccMarcaTipoAbonoTo = (CccMarcaTipoAbonoData)cccMarcaTipoAbonoFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cccMarcaTipoAbonoFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cccMarcaTipoAbonoTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cccMarcaTipoAbonoFrom", cccMarcaTipoAbonoFrom);
			dto.addProperty("cccMarcaTipoAbonoTo", cccMarcaTipoAbonoTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CccMarcaTipoAbono");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CccMarcaTipoAbono");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





