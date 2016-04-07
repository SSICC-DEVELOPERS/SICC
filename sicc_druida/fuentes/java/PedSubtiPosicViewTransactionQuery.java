

/*
    INDRA/CAR/mmg
    $Id: PedSubtiPosicViewTransactionQuery.java,v 1.1 2009/12/03 18:34:18 pecbazalar Exp $
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
public class PedSubtiPosicViewTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	public static final String CHOICE_ATTRIBUTE = "Descripcion";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPedSubtiPosicViewQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "PedSubtiPosicViewConectorQueryList";

	// Definicion del constructor
	public PedSubtiPosicViewTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad PedSubtiPosicView");
			String codSubtPosi = (String)getEntrada("codSubtPosi");
			traza("MMG:: Valor de atributo codSubtPosi: " + codSubtPosi);
			if(codSubtPosi != null && !codSubtPosi.trim().equals("")) codSubtPosi = codSubtPosi.toUpperCase();
			String tposOidTipoPosi = (String)getEntrada("tposOidTipoPosi");
			traza("MMG:: Valor de atributo tposOidTipoPosi: " + tposOidTipoPosi);
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PedSubtiPosicViewData pedSubtiPosicViewFrom =new PedSubtiPosicViewData();
			PedSubtiPosicViewData pedSubtiPosicViewTo = new PedSubtiPosicViewData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			pedSubtiPosicViewFrom.setCodSubtPosi(
				(java.lang.String)FormatUtils.parseObject(codSubtPosi, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.PedTipoPosicData tposOidTipoPosiData = null;
			if(tposOidTipoPosi != null && !tposOidTipoPosi.trim().equals("")){
				tposOidTipoPosiData = new es.indra.belcorp.mso.PedTipoPosicData();
				tposOidTipoPosiData.setId(new Long(tposOidTipoPosi));
			}
			pedSubtiPosicViewFrom.setTposOidTipoPosi(tposOidTipoPosiData);
			pedSubtiPosicViewFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			pedSubtiPosicViewTo = (PedSubtiPosicViewData)pedSubtiPosicViewFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, pedSubtiPosicViewFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, pedSubtiPosicViewTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("pedSubtiPosicViewFrom", pedSubtiPosicViewFrom);
			dto.addProperty("pedSubtiPosicViewTo", pedSubtiPosicViewTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PedSubtiPosicView");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PedSubtiPosicView");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





