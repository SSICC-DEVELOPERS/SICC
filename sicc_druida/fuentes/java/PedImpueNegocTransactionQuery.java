

/*
    INDRA/CAR/mmg
    $Id: PedImpueNegocTransactionQuery.java,v 1.1 2009/12/03 18:38:42 pecbazalar Exp $
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
public class PedImpueNegocTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPedImpueNegocQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "PedImpueNegocConectorQueryList";

	// Definicion del constructor
	public PedImpueNegocTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad PedImpueNegoc");
			String sbacOidSbac = (String)getEntrada("sbacOidSbac");
			traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
			String negoOidNego = (String)getEntrada("negoOidNego");
			traza("MMG:: Valor de atributo negoOidNego: " + negoOidNego);
			String taimOidTasaImpu = (String)getEntrada("taimOidTasaImpu");
			traza("MMG:: Valor de atributo taimOidTasaImpu: " + taimOidTasaImpu);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PedImpueNegocData pedImpueNegocFrom =new PedImpueNegocData();
			PedImpueNegocData pedImpueNegocTo = new PedImpueNegocData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
			if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
				sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
				sbacOidSbacData.setId(new Long(sbacOidSbac));
			}
			pedImpueNegocFrom.setSbacOidSbac(sbacOidSbacData);
			es.indra.belcorp.mso.MaeNegocData negoOidNegoData = null;
			if(negoOidNego != null && !negoOidNego.trim().equals("")){
				negoOidNegoData = new es.indra.belcorp.mso.MaeNegocData();
				negoOidNegoData.setId(new Long(negoOidNego));
			}
			pedImpueNegocFrom.setNegoOidNego(negoOidNegoData);
			es.indra.belcorp.mso.PedTasaImpueData taimOidTasaImpuData = null;
			if(taimOidTasaImpu != null && !taimOidTasaImpu.trim().equals("")){
				taimOidTasaImpuData = new es.indra.belcorp.mso.PedTasaImpueData();
				taimOidTasaImpuData.setId(new Long(taimOidTasaImpu));
			}
			pedImpueNegocFrom.setTaimOidTasaImpu(taimOidTasaImpuData);
			
			
			//Construimos el to
			pedImpueNegocTo = (PedImpueNegocData)pedImpueNegocFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, pedImpueNegocFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, pedImpueNegocTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("pedImpueNegocFrom", pedImpueNegocFrom);
			dto.addProperty("pedImpueNegocTo", pedImpueNegocTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(pedImpueNegocFrom, pedImpueNegocTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PedImpueNegoc");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PedImpueNegoc");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(pedImpueNegocFrom, pedImpueNegocTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(PedImpueNegocData pedImpueNegocFrom, PedImpueNegocData pedImpueNegocTo) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                pedImpueNegocFrom.setPaisOidPais(paisOculto);
                pedImpueNegocTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
			
	}
	
	
	public void cmdPostQuery(PedImpueNegocData pedImpueNegocFrom, PedImpueNegocData pedImpueNegocTo, DruidaConector result) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                pedImpueNegocFrom.setPaisOidPais(paisOculto);
                pedImpueNegocTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
			
	}
	
	
}





