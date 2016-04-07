

/*
    INDRA/CAR/mmg
    $Id: ZonSubGerenVentaTransactionQuery.java,v 1.1 2009/12/03 18:38:33 pecbazalar Exp $
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
public class ZonSubGerenVentaTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGZonSubGerenVentaQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "ZonSubGerenVentaConectorQueryList";

	// Definicion del constructor
	public ZonSubGerenVentaTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad ZonSubGerenVenta");
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			String marcOidMarc = (String)getEntrada("marcOidMarc");
			traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
			String canaOidCana = (String)getEntrada("canaOidCana");
			traza("MMG:: Valor de atributo canaOidCana: " + canaOidCana);
			String codSubgVent = (String)getEntrada("codSubgVent");
			traza("MMG:: Valor de atributo codSubgVent: " + codSubgVent);
			String indBorr = (String)getEntrada("indBorr");
			traza("MMG:: Valor de atributo indBorr: " + indBorr);
			String indActi = (String)getEntrada("indActi");
			traza("MMG:: Valor de atributo indActi: " + indActi);
			String codNse1 = (String)getEntrada("codNse1");
			traza("MMG:: Valor de atributo codNse1: " + codNse1);
			String codNse2 = (String)getEntrada("codNse2");
			traza("MMG:: Valor de atributo codNse2: " + codNse2);
			String codNse3 = (String)getEntrada("codNse3");
			traza("MMG:: Valor de atributo codNse3: " + codNse3);
			String desSubgVent = (String)getEntrada("desSubgVent");
			traza("MMG:: Valor de atributo desSubgVent: " + desSubgVent);
			String clieOidClie = (String)getEntrada("clieOidClie");
			traza("MMG:: Valor de atributo clieOidClie: " + clieOidClie);
			String fecRezo = (String)getEntrada("fecRezo");
			traza("MMG:: Valor de atributo fecRezo: " + fecRezo);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			ZonSubGerenVentaData zonSubGerenVentaFrom =new ZonSubGerenVentaData();
			ZonSubGerenVentaData zonSubGerenVentaTo = new ZonSubGerenVentaData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
				paisOidPaisData.setId(new Integer(paisOidPais));
			}
			zonSubGerenVentaFrom.setPaisOidPais(paisOidPaisData);
			es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
			if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
				marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
				marcOidMarcData.setId(new Integer(marcOidMarc));
			}
			zonSubGerenVentaFrom.setMarcOidMarc(marcOidMarcData);
			es.indra.belcorp.mso.SegCanalData canaOidCanaData = null;
			if(canaOidCana != null && !canaOidCana.trim().equals("")){
				canaOidCanaData = new es.indra.belcorp.mso.SegCanalData();
				canaOidCanaData.setId(new Integer(canaOidCana));
			}
			zonSubGerenVentaFrom.setCanaOidCana(canaOidCanaData);
			zonSubGerenVentaFrom.setCodSubgVent(
				(java.lang.String)FormatUtils.parseObject(codSubgVent, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSubGerenVentaFrom.setIndBorr(
				(java.lang.Integer)FormatUtils.parseObject(indBorr, "java.lang.Integer", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSubGerenVentaFrom.setIndActi(
				(java.lang.Integer)FormatUtils.parseObject(indActi, "java.lang.Integer", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSubGerenVentaFrom.setCodNse1(
				(java.lang.String)FormatUtils.parseObject(codNse1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSubGerenVentaFrom.setCodNse2(
				(java.lang.String)FormatUtils.parseObject(codNse2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSubGerenVentaFrom.setCodNse3(
				(java.lang.String)FormatUtils.parseObject(codNse3, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSubGerenVentaFrom.setDesSubgVent(
				(java.lang.String)FormatUtils.parseObject(desSubgVent, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.MaeClienData clieOidClieData = null;
			if(clieOidClie != null && !clieOidClie.trim().equals("")){
				clieOidClieData = new es.indra.belcorp.mso.MaeClienData();
				clieOidClieData.setId(new Integer(clieOidClie));
			}
			zonSubGerenVentaFrom.setClieOidClie(clieOidClieData);
			zonSubGerenVentaFrom.setFecRezo(
				(java.sql.Date)FormatUtils.parseObject(fecRezo, "java.sql.Date", 
			MMGDruidaHelper.getUserDatePattern(this, true)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			zonSubGerenVentaTo = (ZonSubGerenVentaData)zonSubGerenVentaFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, zonSubGerenVentaFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, zonSubGerenVentaTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("zonSubGerenVentaFrom", zonSubGerenVentaFrom);
			dto.addProperty("zonSubGerenVentaTo", zonSubGerenVentaTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad ZonSubGerenVenta");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad ZonSubGerenVenta");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





