

/*
    INDRA/CAR/mmg
    $Id: PreTipoEstraTransactionQuery.java,v 1.1 2009/12/03 18:40:11 pecbazalar Exp $
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
public class PreTipoEstraTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "desTipoEstr";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPreTipoEstraQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "PreTipoEstraConectorQueryList";

	// Definicion del constructor
	public PreTipoEstraTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad PreTipoEstra");
			String codTipoEstr = (String)getEntrada("codTipoEstr");
			traza("MMG:: Valor de atributo codTipoEstr: " + codTipoEstr);
			String desTipoEstr = (String)getEntrada("desTipoEstr");
			traza("MMG:: Valor de atributo desTipoEstr: " + desTipoEstr);
			String indEstrGrup = (String)getEntrada("indEstrGrup");
			traza("MMG:: Valor de atributo indEstrGrup: " + indEstrGrup);
			String indEstrCond = (String)getEntrada("indEstrCond");
			traza("MMG:: Valor de atributo indEstrCond: " + indEstrCond);
			String indEstrVs = (String)getEntrada("indEstrVs");
			traza("MMG:: Valor de atributo indEstrVs: " + indEstrVs);
			String indEstrPaqu = (String)getEntrada("indEstrPaqu");
			traza("MMG:: Valor de atributo indEstrPaqu: " + indEstrPaqu);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PreTipoEstraData preTipoEstraFrom =new PreTipoEstraData();
			PreTipoEstraData preTipoEstraTo = new PreTipoEstraData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			preTipoEstraFrom.setCodTipoEstr(
				(java.lang.String)FormatUtils.parseObject(codTipoEstr, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			preTipoEstraFrom.setDesTipoEstr(
				(java.lang.String)FormatUtils.parseObject(desTipoEstr, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			preTipoEstraFrom.setIndEstrGrup(
				(java.lang.Long)FormatUtils.parseObject(indEstrGrup, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			preTipoEstraFrom.setIndEstrCond(
				(java.lang.Long)FormatUtils.parseObject(indEstrCond, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			preTipoEstraFrom.setIndEstrVs(
				(java.lang.Long)FormatUtils.parseObject(indEstrVs, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			preTipoEstraFrom.setIndEstrPaqu(
				(java.lang.Long)FormatUtils.parseObject(indEstrPaqu, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			preTipoEstraTo = (PreTipoEstraData)preTipoEstraFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, preTipoEstraFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, preTipoEstraTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("preTipoEstraFrom", preTipoEstraFrom);
			dto.addProperty("preTipoEstraTo", preTipoEstraTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PreTipoEstra");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PreTipoEstra");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





