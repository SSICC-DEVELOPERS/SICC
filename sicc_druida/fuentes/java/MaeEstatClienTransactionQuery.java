

/*
    INDRA/CAR/mmg
    $Id: MaeEstatClienTransactionQuery.java,v 1.1 2009/12/03 18:39:32 pecbazalar Exp $
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
public class MaeEstatClienTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "codEstaClie";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeEstatClienQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaeEstatClienConectorQueryList";

	// Definicion del constructor
	public MaeEstatClienTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MaeEstatClien");
			String tescOidTipoEsta = (String)getEntrada("tescOidTipoEsta");
			traza("MMG:: Valor de atributo tescOidTipoEsta: " + tescOidTipoEsta);
			String codEstaClie = (String)getEntrada("codEstaClie");
			traza("MMG:: Valor de atributo codEstaClie: " + codEstaClie);
			if(codEstaClie != null && !codEstaClie.trim().equals("")) codEstaClie = codEstaClie.toUpperCase();
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			String estaOidEstaClie = (String)getEntrada("estaOidEstaClie");
			traza("MMG:: Valor de atributo estaOidEstaClie: " + estaOidEstaClie);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeEstatClienData maeEstatClienFrom =new MaeEstatClienData();
			MaeEstatClienData maeEstatClienTo = new MaeEstatClienData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.MaeTipoEstatClienViewData tescOidTipoEstaData = null;
			if(tescOidTipoEsta != null && !tescOidTipoEsta.trim().equals("")){
				tescOidTipoEstaData = new es.indra.belcorp.mso.MaeTipoEstatClienViewData();
				tescOidTipoEstaData.setId(new Long(tescOidTipoEsta));
			}
			maeEstatClienFrom.setTescOidTipoEsta(tescOidTipoEstaData);
			maeEstatClienFrom.setCodEstaClie(
				(java.lang.String)FormatUtils.parseObject(codEstaClie, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeEstatClienFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.MaeEstatClienViewData estaOidEstaClieData = null;
			if(estaOidEstaClie != null && !estaOidEstaClie.trim().equals("")){
				estaOidEstaClieData = new es.indra.belcorp.mso.MaeEstatClienViewData();
				estaOidEstaClieData.setId(new Long(estaOidEstaClie));
			}
			maeEstatClienFrom.setEstaOidEstaClie(estaOidEstaClieData);
			
			
			//Construimos el to
			maeEstatClienTo = (MaeEstatClienData)maeEstatClienFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maeEstatClienFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maeEstatClienTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeEstatClienFrom", maeEstatClienFrom);
			dto.addProperty("maeEstatClienTo", maeEstatClienTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeEstatClien");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeEstatClien");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





