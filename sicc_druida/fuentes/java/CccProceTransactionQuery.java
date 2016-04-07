

/*
    INDRA/CAR/mmg
    $Id: CccProceTransactionQuery.java,v 1.1 2009/12/03 18:39:12 pecbazalar Exp $
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
public class CccProceTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	public static final String CHOICE_ATTRIBUTE = "desProc";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCccProceQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CccProceConectorQueryList";

	// Definicion del constructor
	public CccProceTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CccProce");
			String codProc = (String)getEntrada("codProc");
			traza("MMG:: Valor de atributo codProc: " + codProc);
			if(codProc != null && !codProc.trim().equals("")) codProc = codProc.toUpperCase();
			String desProc = (String)getEntrada("desProc");
			traza("MMG:: Valor de atributo desProc: " + desProc);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CccProceData cccProceFrom =new CccProceData();
			CccProceData cccProceTo = new CccProceData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			cccProceFrom.setCodProc(
				(java.lang.String)FormatUtils.parseObject(codProc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccProceFrom.setDesProc(
				(java.lang.String)FormatUtils.parseObject(desProc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			cccProceTo = (CccProceData)cccProceFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cccProceFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cccProceTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cccProceFrom", cccProceFrom);
			dto.addProperty("cccProceTo", cccProceTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(cccProceFrom, cccProceTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CccProce");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CccProce");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(cccProceFrom, cccProceTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(CccProceData cccProceFrom, CccProceData cccProceTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
			
	}
	
	
	public void cmdPostQuery(CccProceData cccProceFrom, CccProceData cccProceTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
			
	}
	
	
}





