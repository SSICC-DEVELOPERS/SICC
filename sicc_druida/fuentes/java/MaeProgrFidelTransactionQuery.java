

/*
    INDRA/CAR/mmg
    $Id: MaeProgrFidelTransactionQuery.java,v 1.1 2009/12/03 18:42:17 pecbazalar Exp $
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
public class MaeProgrFidelTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeProgrFidelQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaeProgrFidelConectorQueryList";

	// Definicion del constructor
	public MaeProgrFidelTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MaeProgrFidel");
			String codProgFide = (String)getEntrada("codProgFide");
			traza("MMG:: Valor de atributo codProgFide: " + codProgFide);
			String desProgFide = (String)getEntrada("desProgFide");
			traza("MMG:: Valor de atributo desProgFide: " + desProgFide);
			String factConv = (String)getEntrada("factConv");
			traza("MMG:: Valor de atributo factConv: " + factConv);
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeProgrFidelData maeProgrFidelFrom =new MaeProgrFidelData();
			MaeProgrFidelData maeProgrFidelTo = new MaeProgrFidelData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			maeProgrFidelFrom.setCodProgFide(
				(java.lang.String)FormatUtils.parseObject(codProgFide, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProgrFidelFrom.setDesProgFide(
				(java.lang.String)FormatUtils.parseObject(desProgFide, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProgrFidelFrom.setFactConv(
				(java.lang.Double)FormatUtils.parseObject(factConv, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
				paisOidPaisData.setId(new Long(paisOidPais));
			}
			maeProgrFidelFrom.setPaisOidPais(paisOidPaisData);
			
			
			//Construimos el to
			maeProgrFidelTo = (MaeProgrFidelData)maeProgrFidelFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maeProgrFidelFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maeProgrFidelTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeProgrFidelFrom", maeProgrFidelFrom);
			dto.addProperty("maeProgrFidelTo", maeProgrFidelTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(maeProgrFidelFrom, maeProgrFidelTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeProgrFidel");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeProgrFidel");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(maeProgrFidelFrom, maeProgrFidelTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(MaeProgrFidelData maeProgrFidelFrom, MaeProgrFidelData maeProgrFidelTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				maeProgrFidelFrom.setPaisOidPais(paisOculto);
				maeProgrFidelTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(MaeProgrFidelData maeProgrFidelFrom, MaeProgrFidelData maeProgrFidelTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				maeProgrFidelFrom.setPaisOidPais(paisOculto);
				maeProgrFidelTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





