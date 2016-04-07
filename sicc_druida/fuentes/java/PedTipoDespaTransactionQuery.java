

/*
    INDRA/CAR/mmg
    $Id: PedTipoDespaTransactionQuery.java,v 1.1 2009/12/03 18:39:53 pecbazalar Exp $
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
public class PedTipoDespaTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	public static final String CHOICE_ATTRIBUTE = "Descripcion";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPedTipoDespaQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "PedTipoDespaConectorQueryList";

	// Definicion del constructor
	public PedTipoDespaTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad PedTipoDespa");
			String codTipoDesp = (String)getEntrada("codTipoDesp");
			traza("MMG:: Valor de atributo codTipoDesp: " + codTipoDesp);
			if(codTipoDesp != null && !codTipoDesp.trim().equals("")) codTipoDesp = codTipoDesp.toUpperCase();
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			String indCron = (String)getEntrada("indCron");
			traza("MMG:: Valor de atributo indCron: " + indCron);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PedTipoDespaData pedTipoDespaFrom =new PedTipoDespaData();
			PedTipoDespaData pedTipoDespaTo = new PedTipoDespaData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			pedTipoDespaFrom.setCodTipoDesp(
				(java.lang.String)FormatUtils.parseObject(codTipoDesp, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedTipoDespaFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedTipoDespaFrom.setIndCron(
				(java.lang.Boolean)FormatUtils.parseObject(indCron, "java.lang.Boolean", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			pedTipoDespaTo = (PedTipoDespaData)pedTipoDespaFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, pedTipoDespaFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, pedTipoDespaTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("pedTipoDespaFrom", pedTipoDespaFrom);
			dto.addProperty("pedTipoDespaTo", pedTipoDespaTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(pedTipoDespaFrom, pedTipoDespaTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PedTipoDespa");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PedTipoDespa");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(pedTipoDespaFrom, pedTipoDespaTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(PedTipoDespaData pedTipoDespaFrom, PedTipoDespaData pedTipoDespaTo) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedTipoDespaFrom.setPaisOidPais(paisOculto);pedTipoDespaTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
	public void cmdPostQuery(PedTipoDespaData pedTipoDespaFrom, PedTipoDespaData pedTipoDespaTo, DruidaConector result) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedTipoDespaFrom.setPaisOidPais(paisOculto);pedTipoDespaTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
}





