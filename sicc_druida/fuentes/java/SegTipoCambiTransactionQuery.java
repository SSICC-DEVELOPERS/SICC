

/*
    INDRA/CAR/mmg
    $Id: SegTipoCambiTransactionQuery.java,v 1.1 2009/12/03 18:39:25 pecbazalar Exp $
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
public class SegTipoCambiTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGSegTipoCambiQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "SegTipoCambiConectorQueryList";

	// Definicion del constructor
	public SegTipoCambiTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad SegTipoCambi");
			String moneOidMon1 = (String)getEntrada("moneOidMon1");
			traza("MMG:: Valor de atributo moneOidMon1: " + moneOidMon1);
			String moneOidMon2 = (String)getEntrada("moneOidMon2");
			traza("MMG:: Valor de atributo moneOidMon2: " + moneOidMon2);
			String fecDesd = (String)getEntrada("fecDesd");
			traza("MMG:: Valor de atributo fecDesd: " + fecDesd);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			SegTipoCambiData segTipoCambiFrom =new SegTipoCambiData();
			SegTipoCambiData segTipoCambiTo = new SegTipoCambiData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegMonedData moneOidMon1Data = null;
			if(moneOidMon1 != null && !moneOidMon1.trim().equals("")){
				moneOidMon1Data = new es.indra.belcorp.mso.SegMonedData();
				moneOidMon1Data.setId(new Long(moneOidMon1));
			}
			segTipoCambiFrom.setMoneOidMon1(moneOidMon1Data);
			es.indra.belcorp.mso.SegMonedData moneOidMon2Data = null;
			if(moneOidMon2 != null && !moneOidMon2.trim().equals("")){
				moneOidMon2Data = new es.indra.belcorp.mso.SegMonedData();
				moneOidMon2Data.setId(new Long(moneOidMon2));
			}
			segTipoCambiFrom.setMoneOidMon2(moneOidMon2Data);
			segTipoCambiFrom.setFecDesd(
				(java.sql.Date)FormatUtils.parseObject(fecDesd, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			segTipoCambiTo = (SegTipoCambiData)segTipoCambiFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, segTipoCambiFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, segTipoCambiTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("segTipoCambiFrom", segTipoCambiFrom);
			dto.addProperty("segTipoCambiTo", segTipoCambiTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad SegTipoCambi");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad SegTipoCambi");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





