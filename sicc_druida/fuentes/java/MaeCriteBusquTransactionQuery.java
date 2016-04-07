

/*
    INDRA/CAR/mmg
    $Id: MaeCriteBusquTransactionQuery.java,v 1.1 2009/12/03 18:33:32 pecbazalar Exp $
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
public class MaeCriteBusquTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeCriteBusquQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaeCriteBusquConectorQueryList";

	// Definicion del constructor
	public MaeCriteBusquTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MaeCriteBusqu");
			String atreOidAtriEsp1 = (String)getEntrada("atreOidAtriEsp1");
			traza("MMG:: Valor de atributo atreOidAtriEsp1: " + atreOidAtriEsp1);
			String atreOidAtriEsp2 = (String)getEntrada("atreOidAtriEsp2");
			traza("MMG:: Valor de atributo atreOidAtriEsp2: " + atreOidAtriEsp2);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeCriteBusquData maeCriteBusquFrom =new MaeCriteBusquData();
			MaeCriteBusquData maeCriteBusquTo = new MaeCriteBusquData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.PedAtribEspecData atreOidAtriEsp1Data = null;
			if(atreOidAtriEsp1 != null && !atreOidAtriEsp1.trim().equals("")){
				atreOidAtriEsp1Data = new es.indra.belcorp.mso.PedAtribEspecData();
				atreOidAtriEsp1Data.setId(new Long(atreOidAtriEsp1));
			}
			maeCriteBusquFrom.setAtreOidAtriEsp1(atreOidAtriEsp1Data);
			es.indra.belcorp.mso.PedAtribEspecData atreOidAtriEsp2Data = null;
			if(atreOidAtriEsp2 != null && !atreOidAtriEsp2.trim().equals("")){
				atreOidAtriEsp2Data = new es.indra.belcorp.mso.PedAtribEspecData();
				atreOidAtriEsp2Data.setId(new Long(atreOidAtriEsp2));
			}
			maeCriteBusquFrom.setAtreOidAtriEsp2(atreOidAtriEsp2Data);
			
			
			//Construimos el to
			maeCriteBusquTo = (MaeCriteBusquData)maeCriteBusquFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maeCriteBusquFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maeCriteBusquTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeCriteBusquFrom", maeCriteBusquFrom);
			dto.addProperty("maeCriteBusquTo", maeCriteBusquTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(maeCriteBusquFrom, maeCriteBusquTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeCriteBusqu");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeCriteBusqu");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(maeCriteBusquFrom, maeCriteBusquTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(MaeCriteBusquData maeCriteBusquFrom, MaeCriteBusquData maeCriteBusquTo) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeCriteBusquFrom.setPaisOidPais(paisOculto);maeCriteBusquTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
	public void cmdPostQuery(MaeCriteBusquData maeCriteBusquFrom, MaeCriteBusquData maeCriteBusquTo, DruidaConector result) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeCriteBusquFrom.setPaisOidPais(paisOculto);maeCriteBusquTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
}





