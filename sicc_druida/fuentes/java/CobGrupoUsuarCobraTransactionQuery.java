

/*
    INDRA/CAR/mmg
    $Id: CobGrupoUsuarCobraTransactionQuery.java,v 1.1 2009/12/03 18:40:57 pecbazalar Exp $
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
public class CobGrupoUsuarCobraTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "valDesc";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCobGrupoUsuarCobraQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CobGrupoUsuarCobraConectorQueryList";

	// Definicion del constructor
	public CobGrupoUsuarCobraTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CobGrupoUsuarCobra");
			String codGrupUsua = (String)getEntrada("codGrupUsua");
			traza("MMG:: Valor de atributo codGrupUsua: " + codGrupUsua);
			String valDesc = (String)getEntrada("valDesc");
			traza("MMG:: Valor de atributo valDesc: " + valDesc);
			String esgrOidEstaGrupUsua = (String)getEntrada("esgrOidEstaGrupUsua");
			traza("MMG:: Valor de atributo esgrOidEstaGrupUsua: " + esgrOidEstaGrupUsua);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom =new CobGrupoUsuarCobraData();
			CobGrupoUsuarCobraData cobGrupoUsuarCobraTo = new CobGrupoUsuarCobraData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			cobGrupoUsuarCobraFrom.setCodGrupUsua(
				(java.lang.Long)FormatUtils.parseObject(codGrupUsua, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobGrupoUsuarCobraFrom.setValDesc(
				(java.lang.String)FormatUtils.parseObject(valDesc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.CobEstadGrupoUsuarData esgrOidEstaGrupUsuaData = null;
			if(esgrOidEstaGrupUsua != null && !esgrOidEstaGrupUsua.trim().equals("")){
				esgrOidEstaGrupUsuaData = new es.indra.belcorp.mso.CobEstadGrupoUsuarData();
				esgrOidEstaGrupUsuaData.setId(new Long(esgrOidEstaGrupUsua));
			}
			cobGrupoUsuarCobraFrom.setEsgrOidEstaGrupUsua(esgrOidEstaGrupUsuaData);
			
			
			//Construimos el to
			cobGrupoUsuarCobraTo = (CobGrupoUsuarCobraData)cobGrupoUsuarCobraFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cobGrupoUsuarCobraFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cobGrupoUsuarCobraTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cobGrupoUsuarCobraFrom", cobGrupoUsuarCobraFrom);
			dto.addProperty("cobGrupoUsuarCobraTo", cobGrupoUsuarCobraTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(cobGrupoUsuarCobraFrom, cobGrupoUsuarCobraTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CobGrupoUsuarCobra");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CobGrupoUsuarCobra");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(cobGrupoUsuarCobraFrom, cobGrupoUsuarCobraTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, CobGrupoUsuarCobraData cobGrupoUsuarCobraTo) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobGrupoUsuarCobraFrom.setPaisOidPais(paisOculto);
                cobGrupoUsuarCobraTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
            
	}
	
	
	public void cmdPostQuery(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, CobGrupoUsuarCobraData cobGrupoUsuarCobraTo, DruidaConector result) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobGrupoUsuarCobraFrom.setPaisOidPais(paisOculto);
                cobGrupoUsuarCobraTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
            
	}
	
	
}





