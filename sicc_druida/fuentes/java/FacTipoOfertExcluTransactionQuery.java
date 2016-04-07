

/*
    INDRA/CAR/mmg
    $Id: FacTipoOfertExcluTransactionQuery.java,v 1.1 2009/12/03 18:34:00 pecbazalar Exp $
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
public class FacTipoOfertExcluTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGFacTipoOfertExcluQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "FacTipoOfertExcluConectorQueryList";

	// Definicion del constructor
	public FacTipoOfertExcluTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad FacTipoOfertExclu");
			String fecDesd = (String)getEntrada("fecDesd");
			traza("MMG:: Valor de atributo fecDesd: " + fecDesd);
			String fecHast = (String)getEntrada("fecHast");
			traza("MMG:: Valor de atributo fecHast: " + fecHast);
			String tofeOidTipoOfer = (String)getEntrada("tofeOidTipoOfer");
			traza("MMG:: Valor de atributo tofeOidTipoOfer: " + tofeOidTipoOfer);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			FacTipoOfertExcluData facTipoOfertExcluFrom =new FacTipoOfertExcluData();
			FacTipoOfertExcluData facTipoOfertExcluTo = new FacTipoOfertExcluData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			facTipoOfertExcluFrom.setFecDesd(
				(java.sql.Date)FormatUtils.parseObject(fecDesd, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			facTipoOfertExcluFrom.setFecHast(
				(java.sql.Date)FormatUtils.parseObject(fecHast, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.PreTipoOfertData tofeOidTipoOferData = null;
			if(tofeOidTipoOfer != null && !tofeOidTipoOfer.trim().equals("")){
				tofeOidTipoOferData = new es.indra.belcorp.mso.PreTipoOfertData();
				tofeOidTipoOferData.setId(new Long(tofeOidTipoOfer));
			}
			facTipoOfertExcluFrom.setTofeOidTipoOfer(tofeOidTipoOferData);
			
			
			//Construimos el to
			facTipoOfertExcluTo = (FacTipoOfertExcluData)facTipoOfertExcluFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, facTipoOfertExcluFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, facTipoOfertExcluTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("facTipoOfertExcluFrom", facTipoOfertExcluFrom);
			dto.addProperty("facTipoOfertExcluTo", facTipoOfertExcluTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(facTipoOfertExcluFrom, facTipoOfertExcluTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad FacTipoOfertExclu");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad FacTipoOfertExclu");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(facTipoOfertExcluFrom, facTipoOfertExcluTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(FacTipoOfertExcluData facTipoOfertExcluFrom, FacTipoOfertExcluData facTipoOfertExcluTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				facTipoOfertExcluFrom.setPaisOidPais(paisOculto);
				facTipoOfertExcluTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(FacTipoOfertExcluData facTipoOfertExcluFrom, FacTipoOfertExcluData facTipoOfertExcluTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				facTipoOfertExcluFrom.setPaisOidPais(paisOculto);
				facTipoOfertExcluTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





