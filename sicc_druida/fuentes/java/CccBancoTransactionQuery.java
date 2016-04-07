

/*
    INDRA/CAR/mmg
    $Id: CccBancoTransactionQuery.java,v 1.1 2009/12/03 18:34:55 pecbazalar Exp $
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
public class CccBancoTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	public static final String CHOICE_ATTRIBUTE = "desBanc";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCccBancoQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CccBancoConectorQueryList";

	// Definicion del constructor
	public CccBancoTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CccBanco");
			String codBanc = (String)getEntrada("codBanc");
			traza("MMG:: Valor de atributo codBanc: " + codBanc);
			if(codBanc != null && !codBanc.trim().equals("")) codBanc = codBanc.toUpperCase();
			String desBanc = (String)getEntrada("desBanc");
			traza("MMG:: Valor de atributo desBanc: " + desBanc);
			String codBrio = (String)getEntrada("codBrio");
			traza("MMG:: Valor de atributo codBrio: " + codBrio);
			if(codBrio != null && !codBrio.trim().equals("")) codBrio = codBrio.toUpperCase();
			String codSwifInfo = (String)getEntrada("codSwifInfo");
			traza("MMG:: Valor de atributo codSwifInfo: " + codSwifInfo);
			if(codSwifInfo != null && !codSwifInfo.trim().equals("")) codSwifInfo = codSwifInfo.toUpperCase();
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CccBancoData cccBancoFrom =new CccBancoData();
			CccBancoData cccBancoTo = new CccBancoData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			cccBancoFrom.setCodBanc(
				(java.lang.String)FormatUtils.parseObject(codBanc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccBancoFrom.setDesBanc(
				(java.lang.String)FormatUtils.parseObject(desBanc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccBancoFrom.setCodBrio(
				(java.lang.String)FormatUtils.parseObject(codBrio, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccBancoFrom.setCodSwifInfo(
				(java.lang.String)FormatUtils.parseObject(codSwifInfo, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			cccBancoTo = (CccBancoData)cccBancoFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cccBancoFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cccBancoTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cccBancoFrom", cccBancoFrom);
			dto.addProperty("cccBancoTo", cccBancoTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(cccBancoFrom, cccBancoTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CccBanco");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CccBanco");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(cccBancoFrom, cccBancoTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(CccBancoData cccBancoFrom, CccBancoData cccBancoTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccBancoFrom.setPaisOidPais(paisOculto);
				cccBancoTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(CccBancoData cccBancoFrom, CccBancoData cccBancoTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccBancoFrom.setPaisOidPais(paisOculto);
				cccBancoTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





