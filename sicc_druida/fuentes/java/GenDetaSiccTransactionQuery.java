

/*
    INDRA/CAR/mmg
    $Id: GenDetaSiccTransactionQuery.java,v 1.1 2009/12/03 18:34:49 pecbazalar Exp $
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
public class GenDetaSiccTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGGenDetaSiccQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "GenDetaSiccConectorQueryList";

	// Definicion del constructor
	public GenDetaSiccTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad GenDetaSicc");
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
			GenDetaSiccData genDetaSiccFrom =new GenDetaSiccData();
			GenDetaSiccData genDetaSiccTo = new GenDetaSiccData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			genDetaSiccFrom.setEnti(
				(java.lang.String)FormatUtils.parseObject(enti, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			genDetaSiccFrom.setEntiPk(
				(java.lang.Long)FormatUtils.parseObject(entiPk, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			genDetaSiccFrom.setAtri(
				(java.lang.Long)FormatUtils.parseObject(atri, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			genDetaSiccFrom.setDeta(
				(java.lang.String)FormatUtils.parseObject(deta, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.SegIdiomData idioOidIdioData = null;
			if(idioOidIdio != null && !idioOidIdio.trim().equals("")){
				idioOidIdioData = new es.indra.belcorp.mso.SegIdiomData();
				idioOidIdioData.setId(new Long(idioOidIdio));
			}
			genDetaSiccFrom.setIdioOidIdio(idioOidIdioData);
			
			
			//Construimos el to
			genDetaSiccTo = (GenDetaSiccData)genDetaSiccFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, genDetaSiccFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, genDetaSiccTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("genDetaSiccFrom", genDetaSiccFrom);
			dto.addProperty("genDetaSiccTo", genDetaSiccTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad GenDetaSicc");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad GenDetaSicc");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





