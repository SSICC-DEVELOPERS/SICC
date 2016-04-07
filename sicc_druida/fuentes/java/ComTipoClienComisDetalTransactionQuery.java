

/*
    INDRA/CAR/mmg
    $Id: ComTipoClienComisDetalTransactionQuery.java,v 1.1 2009/12/03 18:36:22 pecbazalar Exp $
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
public class ComTipoClienComisDetalTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGComTipoClienComisDetalQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "ComTipoClienComisDetalConectorQueryList";

	// Definicion del constructor
	public ComTipoClienComisDetalTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad ComTipoClienComisDetal");
			String tcccOidTipoClieComiCabe = (String)getEntrada("tcccOidTipoClieComiCabe");
			traza("MMG:: Valor de atributo tcccOidTipoClieComiCabe: " + tcccOidTipoClieComiCabe);
			String clasOidClas = (String)getEntrada("clasOidClas");
			traza("MMG:: Valor de atributo clasOidClas: " + clasOidClas);
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			ComTipoClienComisDetalData comTipoClienComisDetalFrom =new ComTipoClienComisDetalData();
			ComTipoClienComisDetalData comTipoClienComisDetalTo = new ComTipoClienComisDetalData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.ComTipoClienComisCabecData tcccOidTipoClieComiCabeData = null;
			if(tcccOidTipoClieComiCabe != null && !tcccOidTipoClieComiCabe.trim().equals("")){
				tcccOidTipoClieComiCabeData = new es.indra.belcorp.mso.ComTipoClienComisCabecData();
				tcccOidTipoClieComiCabeData.setId(new Long(tcccOidTipoClieComiCabe));
			}
			comTipoClienComisDetalFrom.setTcccOidTipoClieComiCabe(tcccOidTipoClieComiCabeData);
			es.indra.belcorp.mso.MaeClasiData clasOidClasData = null;
			if(clasOidClas != null && !clasOidClas.trim().equals("")){
				clasOidClasData = new es.indra.belcorp.mso.MaeClasiData();
				clasOidClasData.setId(new Long(clasOidClas));
			}
			comTipoClienComisDetalFrom.setClasOidClas(clasOidClasData);
			comTipoClienComisDetalFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			comTipoClienComisDetalTo = (ComTipoClienComisDetalData)comTipoClienComisDetalFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, comTipoClienComisDetalFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, comTipoClienComisDetalTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("comTipoClienComisDetalFrom", comTipoClienComisDetalFrom);
			dto.addProperty("comTipoClienComisDetalTo", comTipoClienComisDetalTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad ComTipoClienComisDetal");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad ComTipoClienComisDetal");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





