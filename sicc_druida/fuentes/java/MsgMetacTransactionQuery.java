

/*
    INDRA/CAR/mmg
    $Id: MsgMetacTransactionQuery.java,v 1.1 2009/12/03 18:38:22 pecbazalar Exp $
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
public class MsgMetacTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "Descripcion";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMsgMetacQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MsgMetacConectorQueryList";

	// Definicion del constructor
	public MsgMetacTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MsgMetac");
			String codMeta = (String)getEntrada("codMeta");
			traza("MMG:: Valor de atributo codMeta: " + codMeta);
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			String timeOidTipo = (String)getEntrada("timeOidTipo");
			traza("MMG:: Valor de atributo timeOidTipo: " + timeOidTipo);
			String valEsta = (String)getEntrada("valEsta");
			traza("MMG:: Valor de atributo valEsta: " + valEsta);
			String valLiteIden = (String)getEntrada("valLiteIden");
			traza("MMG:: Valor de atributo valLiteIden: " + valLiteIden);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MsgMetacData msgMetacFrom =new MsgMetacData();
			MsgMetacData msgMetacTo = new MsgMetacData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			msgMetacFrom.setCodMeta(
				(java.lang.Long)FormatUtils.parseObject(codMeta, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			msgMetacFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.MsgTipoMetacData timeOidTipoData = null;
			if(timeOidTipo != null && !timeOidTipo.trim().equals("")){
				timeOidTipoData = new es.indra.belcorp.mso.MsgTipoMetacData();
				timeOidTipoData.setId(new Long(timeOidTipo));
			}
			msgMetacFrom.setTimeOidTipo(timeOidTipoData);
			msgMetacFrom.setValEsta(
				(java.lang.String)FormatUtils.parseObject(valEsta, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			msgMetacFrom.setValLiteIden(
				(java.lang.String)FormatUtils.parseObject(valLiteIden, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			msgMetacTo = (MsgMetacData)msgMetacFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, msgMetacFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, msgMetacTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("msgMetacFrom", msgMetacFrom);
			dto.addProperty("msgMetacTo", msgMetacTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MsgMetac");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MsgMetac");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





