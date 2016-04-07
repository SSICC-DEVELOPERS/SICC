

/*
    INDRA/CAR/mmg
    $Id: MaeExencFleteTransactionQuery.java,v 1.1 2009/12/03 18:39:42 pecbazalar Exp $
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
public class MaeExencFleteTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeExencFleteQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaeExencFleteConectorQueryList";

	// Definicion del constructor
	public MaeExencFleteTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MaeExencFlete");
			String ticlOidTipoClie = (String)getEntrada("ticlOidTipoClie");
			traza("MMG:: Valor de atributo ticlOidTipoClie: " + ticlOidTipoClie);
			String sbtiOidSubtClie = (String)getEntrada("sbtiOidSubtClie");
			traza("MMG:: Valor de atributo sbtiOidSubtClie: " + sbtiOidSubtClie);
			String tcclOidTipoClas = (String)getEntrada("tcclOidTipoClas");
			traza("MMG:: Valor de atributo tcclOidTipoClas: " + tcclOidTipoClas);
			String clasOidClas = (String)getEntrada("clasOidClas");
			traza("MMG:: Valor de atributo clasOidClas: " + clasOidClas);
			String indExenFlet = (String)getEntrada("indExenFlet");
			traza("MMG:: Valor de atributo indExenFlet: " + indExenFlet);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeExencFleteData maeExencFleteFrom =new MaeExencFleteData();
			MaeExencFleteData maeExencFleteTo = new MaeExencFleteData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.MaeTipoClienData ticlOidTipoClieData = null;
			if(ticlOidTipoClie != null && !ticlOidTipoClie.trim().equals("")){
				ticlOidTipoClieData = new es.indra.belcorp.mso.MaeTipoClienData();
				ticlOidTipoClieData.setId(new Long(ticlOidTipoClie));
			}
			maeExencFleteFrom.setTiclOidTipoClie(ticlOidTipoClieData);
			es.indra.belcorp.mso.MaeSubtiClienViewData sbtiOidSubtClieData = null;
			if(sbtiOidSubtClie != null && !sbtiOidSubtClie.trim().equals("")){
				sbtiOidSubtClieData = new es.indra.belcorp.mso.MaeSubtiClienViewData();
				sbtiOidSubtClieData.setId(new Long(sbtiOidSubtClie));
			}
			maeExencFleteFrom.setSbtiOidSubtClie(sbtiOidSubtClieData);
			es.indra.belcorp.mso.MaeTipoClasiClienViewData tcclOidTipoClasData = null;
			if(tcclOidTipoClas != null && !tcclOidTipoClas.trim().equals("")){
				tcclOidTipoClasData = new es.indra.belcorp.mso.MaeTipoClasiClienViewData();
				tcclOidTipoClasData.setId(new Long(tcclOidTipoClas));
			}
			maeExencFleteFrom.setTcclOidTipoClas(tcclOidTipoClasData);
			es.indra.belcorp.mso.MaeClasiViewData clasOidClasData = null;
			if(clasOidClas != null && !clasOidClas.trim().equals("")){
				clasOidClasData = new es.indra.belcorp.mso.MaeClasiViewData();
				clasOidClasData.setId(new Long(clasOidClas));
			}
			maeExencFleteFrom.setClasOidClas(clasOidClasData);
			maeExencFleteFrom.setIndExenFlet(
				(java.lang.String)FormatUtils.parseObject(indExenFlet, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			maeExencFleteTo = (MaeExencFleteData)maeExencFleteFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maeExencFleteFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maeExencFleteTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeExencFleteFrom", maeExencFleteFrom);
			dto.addProperty("maeExencFleteTo", maeExencFleteTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(maeExencFleteFrom, maeExencFleteTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeExencFlete");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeExencFlete");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(maeExencFleteFrom, maeExencFleteTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(MaeExencFleteData maeExencFleteFrom, MaeExencFleteData maeExencFleteTo) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeExencFleteFrom.setPaisOidPais(paisOculto);maeExencFleteTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
	public void cmdPostQuery(MaeExencFleteData maeExencFleteFrom, MaeExencFleteData maeExencFleteTo, DruidaConector result) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeExencFleteFrom.setPaisOidPais(paisOculto);maeExencFleteTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
}





