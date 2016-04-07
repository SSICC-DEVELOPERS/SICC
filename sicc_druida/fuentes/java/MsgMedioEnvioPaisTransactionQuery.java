

/*
    INDRA/CAR/mmg
    $Id: MsgMedioEnvioPaisTransactionQuery.java,v 1.1 2009/12/03 18:35:24 pecbazalar Exp $
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
public class MsgMedioEnvioPaisTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMsgMedioEnvioPaisQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MsgMedioEnvioPaisConectorQueryList";

	// Definicion del constructor
	public MsgMedioEnvioPaisTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MsgMedioEnvioPais");
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			String meenOidMediEnvi = (String)getEntrada("meenOidMediEnvi");
			traza("MMG:: Valor de atributo meenOidMediEnvi: " + meenOidMediEnvi);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MsgMedioEnvioPaisData msgMedioEnvioPaisFrom =new MsgMedioEnvioPaisData();
			MsgMedioEnvioPaisData msgMedioEnvioPaisTo = new MsgMedioEnvioPaisData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
				paisOidPaisData.setId(new Long(paisOidPais));
			}
			msgMedioEnvioPaisFrom.setPaisOidPais(paisOidPaisData);
			es.indra.belcorp.mso.MsgMedioEnvioData meenOidMediEnviData = null;
			if(meenOidMediEnvi != null && !meenOidMediEnvi.trim().equals("")){
				meenOidMediEnviData = new es.indra.belcorp.mso.MsgMedioEnvioData();
				meenOidMediEnviData.setId(new Long(meenOidMediEnvi));
			}
			msgMedioEnvioPaisFrom.setMeenOidMediEnvi(meenOidMediEnviData);
			
			
			//Construimos el to
			msgMedioEnvioPaisTo = (MsgMedioEnvioPaisData)msgMedioEnvioPaisFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, msgMedioEnvioPaisFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, msgMedioEnvioPaisTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("msgMedioEnvioPaisFrom", msgMedioEnvioPaisFrom);
			dto.addProperty("msgMedioEnvioPaisTo", msgMedioEnvioPaisTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(msgMedioEnvioPaisFrom, msgMedioEnvioPaisTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MsgMedioEnvioPais");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MsgMedioEnvioPais");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(msgMedioEnvioPaisFrom, msgMedioEnvioPaisTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(MsgMedioEnvioPaisData msgMedioEnvioPaisFrom, MsgMedioEnvioPaisData msgMedioEnvioPaisTo) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));msgMedioEnvioPaisFrom.setPaisOidPais(paisOculto);msgMedioEnvioPaisTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
	public void cmdPostQuery(MsgMedioEnvioPaisData msgMedioEnvioPaisFrom, MsgMedioEnvioPaisData msgMedioEnvioPaisTo, DruidaConector result) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));msgMedioEnvioPaisFrom.setPaisOidPais(paisOculto);msgMedioEnvioPaisTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
}





