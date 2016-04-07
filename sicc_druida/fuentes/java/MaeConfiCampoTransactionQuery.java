

/*
    INDRA/CAR/mmg
    $Id: MaeConfiCampoTransactionQuery.java,v 1.1 2009/12/03 18:41:37 pecbazalar Exp $
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
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class MaeConfiCampoTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeConfiCampoQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaeConfiCampoConectorQueryList";

	// Definicion del constructor
	public MaeConfiCampoTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MaeConfiCampo");
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			String sbtiOidSubtClie = (String)getEntrada("sbtiOidSubtClie");
			traza("MMG:: Valor de atributo sbtiOidSubtClie: " + sbtiOidSubtClie);
			String atreOidAtriEspe = (String)getEntrada("atreOidAtriEspe");
			traza("MMG:: Valor de atributo atreOidAtriEspe: " + atreOidAtriEspe);
			String valDefe = (String)getEntrada("valDefe");
			traza("MMG:: Valor de atributo valDefe: " + valDefe);
			String indObli = (String)getEntrada("indObli");
			traza("MMG:: Valor de atributo indObli: " + indObli);
			String indModi = (String)getEntrada("indModi");
			traza("MMG:: Valor de atributo indModi: " + indModi);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeConfiCampoData maeConfiCampoFrom =new MaeConfiCampoData();
			MaeConfiCampoData maeConfiCampoTo = new MaeConfiCampoData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
				paisOidPaisData.setId(new Integer(paisOidPais));
			}
			maeConfiCampoFrom.setPaisOidPais(paisOidPaisData);
			es.indra.belcorp.mso.MaeSubtiClienData sbtiOidSubtClieData = null;
			if(sbtiOidSubtClie != null && !sbtiOidSubtClie.trim().equals("")){
				sbtiOidSubtClieData = new es.indra.belcorp.mso.MaeSubtiClienData();
				sbtiOidSubtClieData.setId(new Integer(sbtiOidSubtClie));
			}
			maeConfiCampoFrom.setSbtiOidSubtClie(sbtiOidSubtClieData);
			es.indra.belcorp.mso.PedAtribEspecData atreOidAtriEspeData = null;
			if(atreOidAtriEspe != null && !atreOidAtriEspe.trim().equals("")){
				atreOidAtriEspeData = new es.indra.belcorp.mso.PedAtribEspecData();
				atreOidAtriEspeData.setId(new Integer(atreOidAtriEspe));
			}
			maeConfiCampoFrom.setAtreOidAtriEspe(atreOidAtriEspeData);
			maeConfiCampoFrom.setValDefe(
				(java.lang.String)FormatUtils.parseObject(valDefe, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeConfiCampoFrom.setIndObli(
				(java.lang.Integer)FormatUtils.parseObject(indObli, "java.lang.Integer", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeConfiCampoFrom.setIndModi(
				(java.lang.Integer)FormatUtils.parseObject(indModi, "java.lang.Integer", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			maeConfiCampoTo = (MaeConfiCampoData)maeConfiCampoFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maeConfiCampoFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maeConfiCampoTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeConfiCampoFrom", maeConfiCampoFrom);
			dto.addProperty("maeConfiCampoTo", maeConfiCampoTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeConfiCampo");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeConfiCampo");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





