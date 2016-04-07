

/*
    INDRA/CAR/mmg
    $Id: CarParamGenerCarteTransactionQuery.java,v 1.1 2009/12/03 18:37:16 pecbazalar Exp $
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
public class CarParamGenerCarteTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCarParamGenerCarteQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CarParamGenerCarteConectorQueryList";

	// Definicion del constructor
	public CarParamGenerCarteTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CarParamGenerCarte");
			String nireOidNiveRedo = (String)getEntrada("nireOidNiveRedo");
			traza("MMG:: Valor de atributo nireOidNiveRedo: " + nireOidNiveRedo);
			String numPeriNuev = (String)getEntrada("numPeriNuev");
			traza("MMG:: Valor de atributo numPeriNuev: " + numPeriNuev);
			String numPeriAnti = (String)getEntrada("numPeriAnti");
			traza("MMG:: Valor de atributo numPeriAnti: " + numPeriAnti);
			String inijOidIndiNiveJera = (String)getEntrada("inijOidIndiNiveJera");
			traza("MMG:: Valor de atributo inijOidIndiNiveJera: " + inijOidIndiNiveJera);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CarParamGenerCarteData carParamGenerCarteFrom =new CarParamGenerCarteData();
			CarParamGenerCarteData carParamGenerCarteTo = new CarParamGenerCarteData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.CarNivelRedonData nireOidNiveRedoData = null;
			if(nireOidNiveRedo != null && !nireOidNiveRedo.trim().equals("")){
				nireOidNiveRedoData = new es.indra.belcorp.mso.CarNivelRedonData();
				nireOidNiveRedoData.setId(new Long(nireOidNiveRedo));
			}
			carParamGenerCarteFrom.setNireOidNiveRedo(nireOidNiveRedoData);
			carParamGenerCarteFrom.setNumPeriNuev(
				(java.lang.Long)FormatUtils.parseObject(numPeriNuev, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carParamGenerCarteFrom.setNumPeriAnti(
				(java.lang.Long)FormatUtils.parseObject(numPeriAnti, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.CarIndicNivelJerarData inijOidIndiNiveJeraData = null;
			if(inijOidIndiNiveJera != null && !inijOidIndiNiveJera.trim().equals("")){
				inijOidIndiNiveJeraData = new es.indra.belcorp.mso.CarIndicNivelJerarData();
				inijOidIndiNiveJeraData.setId(new Long(inijOidIndiNiveJera));
			}
			carParamGenerCarteFrom.setInijOidIndiNiveJera(inijOidIndiNiveJeraData);
			
			
			//Construimos el to
			carParamGenerCarteTo = (CarParamGenerCarteData)carParamGenerCarteFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, carParamGenerCarteFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, carParamGenerCarteTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("carParamGenerCarteFrom", carParamGenerCarteFrom);
			dto.addProperty("carParamGenerCarteTo", carParamGenerCarteTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(carParamGenerCarteFrom, carParamGenerCarteTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CarParamGenerCarte");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CarParamGenerCarte");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(carParamGenerCarteFrom, carParamGenerCarteTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(CarParamGenerCarteData carParamGenerCarteFrom, CarParamGenerCarteData carParamGenerCarteTo) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));carParamGenerCarteFrom.setPaisOidPais(paisOculto);carParamGenerCarteTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
	public void cmdPostQuery(CarParamGenerCarteData carParamGenerCarteFrom, CarParamGenerCarteData carParamGenerCarteTo, DruidaConector result) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));carParamGenerCarteFrom.setPaisOidPais(paisOculto);carParamGenerCarteTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
}





