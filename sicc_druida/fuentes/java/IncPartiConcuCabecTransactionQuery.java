

/*
    INDRA/CAR/mmg
    $Id: IncPartiConcuCabecTransactionQuery.java,v 1.1 2009/12/03 18:42:19 pecbazalar Exp $
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
public class IncPartiConcuCabecTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGIncPartiConcuCabecQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "IncPartiConcuCabecConectorQueryList";

	// Definicion del constructor
	public IncPartiConcuCabecTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad IncPartiConcuCabec");
			String valGrupClie = (String)getEntrada("valGrupClie");
			traza("MMG:: Valor de atributo valGrupClie: " + valGrupClie);
			String diriOidDiri = (String)getEntrada("diriOidDiri");
			traza("MMG:: Valor de atributo diriOidDiri: " + diriOidDiri);
			String desDesc = (String)getEntrada("desDesc");
			traza("MMG:: Valor de atributo desDesc: " + desDesc);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			IncPartiConcuCabecData incPartiConcuCabecFrom =new IncPartiConcuCabecData();
			IncPartiConcuCabecData incPartiConcuCabecTo = new IncPartiConcuCabecData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			incPartiConcuCabecFrom.setValGrupClie(
				(java.lang.Long)FormatUtils.parseObject(valGrupClie, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.IncDirigData diriOidDiriData = null;
			if(diriOidDiri != null && !diriOidDiri.trim().equals("")){
				diriOidDiriData = new es.indra.belcorp.mso.IncDirigData();
				diriOidDiriData.setId(new Long(diriOidDiri));
			}
			incPartiConcuCabecFrom.setDiriOidDiri(diriOidDiriData);
			incPartiConcuCabecFrom.setDesDesc(
				(java.lang.String)FormatUtils.parseObject(desDesc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			incPartiConcuCabecTo = (IncPartiConcuCabecData)incPartiConcuCabecFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, incPartiConcuCabecFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, incPartiConcuCabecTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("incPartiConcuCabecFrom", incPartiConcuCabecFrom);
			dto.addProperty("incPartiConcuCabecTo", incPartiConcuCabecTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(incPartiConcuCabecFrom, incPartiConcuCabecTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad IncPartiConcuCabec");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad IncPartiConcuCabec");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(incPartiConcuCabecFrom, incPartiConcuCabecTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(IncPartiConcuCabecData incPartiConcuCabecFrom, IncPartiConcuCabecData incPartiConcuCabecTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); 
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				incPartiConcuCabecFrom.setPaisOidPais(paisOculto); 
				incPartiConcuCabecTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(IncPartiConcuCabecData incPartiConcuCabecFrom, IncPartiConcuCabecData incPartiConcuCabecTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); 
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				incPartiConcuCabecFrom.setPaisOidPais(paisOculto); 
				incPartiConcuCabecTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





