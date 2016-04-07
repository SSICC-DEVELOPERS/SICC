

/*
    INDRA/CAR/mmg
    $Id: CalMotivTipoClienTransactionQuery.java,v 1.1 2009/12/03 18:34:51 pecbazalar Exp $
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
public class CalMotivTipoClienTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCalMotivTipoClienQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CalMotivTipoClienConectorQueryList";

	// Definicion del constructor
	public CalMotivTipoClienTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CalMotivTipoClien");
			String mocoOidMotiCont = (String)getEntrada("mocoOidMotiCont");
			traza("MMG:: Valor de atributo mocoOidMotiCont: " + mocoOidMotiCont);
			String ticlOidTipoClie = (String)getEntrada("ticlOidTipoClie");
			traza("MMG:: Valor de atributo ticlOidTipoClie: " + ticlOidTipoClie);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CalMotivTipoClienData calMotivTipoClienFrom =new CalMotivTipoClienData();
			CalMotivTipoClienData calMotivTipoClienTo = new CalMotivTipoClienData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.CalMotivContaData mocoOidMotiContData = null;
			if(mocoOidMotiCont != null && !mocoOidMotiCont.trim().equals("")){
				mocoOidMotiContData = new es.indra.belcorp.mso.CalMotivContaData();
				mocoOidMotiContData.setId(new Long(mocoOidMotiCont));
			}
			calMotivTipoClienFrom.setMocoOidMotiCont(mocoOidMotiContData);
			es.indra.belcorp.mso.MaeTipoClienData ticlOidTipoClieData = null;
			if(ticlOidTipoClie != null && !ticlOidTipoClie.trim().equals("")){
				ticlOidTipoClieData = new es.indra.belcorp.mso.MaeTipoClienData();
				ticlOidTipoClieData.setId(new Long(ticlOidTipoClie));
			}
			calMotivTipoClienFrom.setTiclOidTipoClie(ticlOidTipoClieData);
			
			
			//Construimos el to
			calMotivTipoClienTo = (CalMotivTipoClienData)calMotivTipoClienFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, calMotivTipoClienFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, calMotivTipoClienTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("calMotivTipoClienFrom", calMotivTipoClienFrom);
			dto.addProperty("calMotivTipoClienTo", calMotivTipoClienTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(calMotivTipoClienFrom, calMotivTipoClienTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CalMotivTipoClien");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CalMotivTipoClien");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(calMotivTipoClienFrom, calMotivTipoClienTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(CalMotivTipoClienData calMotivTipoClienFrom, CalMotivTipoClienData calMotivTipoClienTo) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));calMotivTipoClienFrom.setPaisOidPais(paisOculto);calMotivTipoClienTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
	public void cmdPostQuery(CalMotivTipoClienData calMotivTipoClienFrom, CalMotivTipoClienData calMotivTipoClienTo, DruidaConector result) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));calMotivTipoClienFrom.setPaisOidPais(paisOculto);calMotivTipoClienTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
}





