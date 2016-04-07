

/*
    INDRA/CAR/mmg
    $Id: ZonSecciTransactionQuery.java,v 1.1 2009/12/03 18:40:21 pecbazalar Exp $
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
public class ZonSecciTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGZonSecciQueryFromToUserPageStructuralSecurity";
	public static final String CONECTOR_QUERY_LIST = "ZonSecciConectorQueryList";

	// Definicion del constructor
	public ZonSecciTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad ZonSecci");
			String zzonOidZona = (String)getEntrada("zzonOidZona");
			traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
			String codSecc = (String)getEntrada("codSecc");
			traza("MMG:: Valor de atributo codSecc: " + codSecc);
			String indActi = (String)getEntrada("indActi");
			traza("MMG:: Valor de atributo indActi: " + indActi);
			String indBorr = (String)getEntrada("indBorr");
			traza("MMG:: Valor de atributo indBorr: " + indBorr);
			String clieOidClie = (String)getEntrada("clieOidClie");
			traza("MMG:: Valor de atributo clieOidClie: " + clieOidClie);
			String codNse1 = (String)getEntrada("codNse1");
			traza("MMG:: Valor de atributo codNse1: " + codNse1);
			String codNse2 = (String)getEntrada("codNse2");
			traza("MMG:: Valor de atributo codNse2: " + codNse2);
			String codNse3 = (String)getEntrada("codNse3");
			traza("MMG:: Valor de atributo codNse3: " + codNse3);
			String desSecci = (String)getEntrada("desSecci");
			traza("MMG:: Valor de atributo desSecci: " + desSecci);
			String fecRezo = (String)getEntrada("fecRezo");
			traza("MMG:: Valor de atributo fecRezo: " + fecRezo);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			ZonSecciData zonSecciFrom =new ZonSecciData();
			ZonSecciData zonSecciTo = new ZonSecciData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.ZonZonaData zzonOidZonaData = null;
			if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
				zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaData();
				zzonOidZonaData.setId(new Integer(zzonOidZona));
			}
			zonSecciFrom.setZzonOidZona(zzonOidZonaData);
			zonSecciFrom.setCodSecc(
				(java.lang.String)FormatUtils.parseObject(codSecc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSecciFrom.setIndActi(
				(java.lang.Integer)FormatUtils.parseObject(indActi, "java.lang.Integer", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSecciFrom.setIndBorr(
				(java.lang.Integer)FormatUtils.parseObject(indBorr, "java.lang.Integer", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.MaeClienData clieOidClieData = null;
			if(clieOidClie != null && !clieOidClie.trim().equals("")){
				clieOidClieData = new es.indra.belcorp.mso.MaeClienData();
				clieOidClieData.setId(new Integer(clieOidClie));
			}
			zonSecciFrom.setClieOidClie(clieOidClieData);
			zonSecciFrom.setCodNse1(
				(java.lang.String)FormatUtils.parseObject(codNse1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSecciFrom.setCodNse2(
				(java.lang.String)FormatUtils.parseObject(codNse2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSecciFrom.setCodNse3(
				(java.lang.String)FormatUtils.parseObject(codNse3, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSecciFrom.setDesSecci(
				(java.lang.String)FormatUtils.parseObject(desSecci, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSecciFrom.setFecRezo(
				(java.sql.Date)FormatUtils.parseObject(fecRezo, "java.sql.Date", 
			MMGDruidaHelper.getUserDatePattern(this, true)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			zonSecciTo = (ZonSecciData)zonSecciFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, zonSecciFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, zonSecciTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("zonSecciFrom", zonSecciFrom);
			dto.addProperty("zonSecciTo", zonSecciTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", new Boolean(false));
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad ZonSecci");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad ZonSecci");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





