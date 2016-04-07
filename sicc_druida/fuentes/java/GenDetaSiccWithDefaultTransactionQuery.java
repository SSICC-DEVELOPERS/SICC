

/*
    INDRA/CAR/mmg
    $Id: GenDetaSiccWithDefaultTransactionQuery.java,v 1.1 2009/12/03 18:34:57 pecbazalar Exp $
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
public class GenDetaSiccWithDefaultTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGGenDetaSiccWithDefaultQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "GenDetaSiccWithDefaultConectorQueryList";

	// Definicion del constructor
	public GenDetaSiccWithDefaultTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad GenDetaSiccWithDefault");
			String enti = (String)getEntrada("enti");
			traza("MMG:: Valor de atributo enti: " + enti);
			String entiPk = (String)getEntrada("entiPk");
			traza("MMG:: Valor de atributo entiPk: " + entiPk);
			String atri = (String)getEntrada("atri");
			traza("MMG:: Valor de atributo atri: " + atri);
			String deta = (String)getEntrada("deta");
			traza("MMG:: Valor de atributo deta: " + deta);
			String idioOidIdio = (String)getEntrada("idioOidIdio");
			traza("MMG:: Valor de atributo idioOidIdio: " + idioOidIdio);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			GenDetaSiccWithDefaultData genDetaSiccWithDefaultFrom =new GenDetaSiccWithDefaultData();
			GenDetaSiccWithDefaultData genDetaSiccWithDefaultTo = new GenDetaSiccWithDefaultData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			genDetaSiccWithDefaultFrom.setEnti(
				(java.lang.String)FormatUtils.parseObject(enti, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			genDetaSiccWithDefaultFrom.setEntiPk(
				(java.lang.Long)FormatUtils.parseObject(entiPk, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			genDetaSiccWithDefaultFrom.setAtri(
				(java.lang.Long)FormatUtils.parseObject(atri, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			genDetaSiccWithDefaultFrom.setDeta(
				(java.lang.String)FormatUtils.parseObject(deta, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.SegIdiomData idioOidIdioData = null;
			if(idioOidIdio != null && !idioOidIdio.trim().equals("")){
				idioOidIdioData = new es.indra.belcorp.mso.SegIdiomData();
				idioOidIdioData.setId(new Long(idioOidIdio));
			}
			genDetaSiccWithDefaultFrom.setIdioOidIdio(idioOidIdioData);
			
			
			//Construimos el to
			genDetaSiccWithDefaultTo = (GenDetaSiccWithDefaultData)genDetaSiccWithDefaultFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, genDetaSiccWithDefaultFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, genDetaSiccWithDefaultTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("genDetaSiccWithDefaultFrom", genDetaSiccWithDefaultFrom);
			dto.addProperty("genDetaSiccWithDefaultTo", genDetaSiccWithDefaultTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad GenDetaSiccWithDefault");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad GenDetaSiccWithDefault");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





