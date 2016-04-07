

/*
    INDRA/CAR/mmg
    $Id: MaeTipoClasiClienTransactionQuery.java,v 1.1 2009/12/03 18:40:28 pecbazalar Exp $
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
public class MaeTipoClasiClienTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	public static final String CHOICE_ATTRIBUTE = "Descripcion";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeTipoClasiClienQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaeTipoClasiClienConectorQueryList";

	// Definicion del constructor
	public MaeTipoClasiClienTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MaeTipoClasiClien");
			String sbtiOidSubtClie = (String)getEntrada("sbtiOidSubtClie");
			traza("MMG:: Valor de atributo sbtiOidSubtClie: " + sbtiOidSubtClie);
			String codTipoClas = (String)getEntrada("codTipoClas");
			traza("MMG:: Valor de atributo codTipoClas: " + codTipoClas);
			if(codTipoClas != null && !codTipoClas.trim().equals("")) codTipoClas = codTipoClas.toUpperCase();
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeTipoClasiClienData maeTipoClasiClienFrom =new MaeTipoClasiClienData();
			MaeTipoClasiClienData maeTipoClasiClienTo = new MaeTipoClasiClienData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.MaeSubtiClienData sbtiOidSubtClieData = null;
			if(sbtiOidSubtClie != null && !sbtiOidSubtClie.trim().equals("")){
				sbtiOidSubtClieData = new es.indra.belcorp.mso.MaeSubtiClienData();
				sbtiOidSubtClieData.setId(new Long(sbtiOidSubtClie));
			}
			maeTipoClasiClienFrom.setSbtiOidSubtClie(sbtiOidSubtClieData);
			maeTipoClasiClienFrom.setCodTipoClas(
				(java.lang.String)FormatUtils.parseObject(codTipoClas, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeTipoClasiClienFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			maeTipoClasiClienTo = (MaeTipoClasiClienData)maeTipoClasiClienFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maeTipoClasiClienFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maeTipoClasiClienTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeTipoClasiClienFrom", maeTipoClasiClienFrom);
			dto.addProperty("maeTipoClasiClienTo", maeTipoClasiClienTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeTipoClasiClien");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeTipoClasiClien");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





