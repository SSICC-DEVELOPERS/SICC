

/*
    INDRA/CAR/mmg
    $Id: ZonSubGerenVentaViewTransactionQuery.java,v 1.1 2009/12/03 18:42:33 pecbazalar Exp $
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
public class ZonSubGerenVentaViewTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "codSubgVent";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGZonSubGerenVentaViewQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "ZonSubGerenVentaViewConectorQueryList";

	// Definicion del constructor
	public ZonSubGerenVentaViewTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad ZonSubGerenVentaView");
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
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
			String marcOidMarc = (String)getEntrada("marcOidMarc");
			traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
			String canaOidCana = (String)getEntrada("canaOidCana");
			traza("MMG:: Valor de atributo canaOidCana: " + canaOidCana);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			ZonSubGerenVentaViewData zonSubGerenVentaViewFrom =new ZonSubGerenVentaViewData();
			ZonSubGerenVentaViewData zonSubGerenVentaViewTo = new ZonSubGerenVentaViewData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
				paisOidPaisData.setId(new Long(paisOidPais));
			}
			zonSubGerenVentaViewFrom.setPaisOidPais(paisOidPaisData);
			zonSubGerenVentaViewFrom.setCodSubgVent(
				(java.lang.String)FormatUtils.parseObject(codSubgVent, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSubGerenVentaViewFrom.setIndBorr(
				(java.lang.Long)FormatUtils.parseObject(indBorr, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSubGerenVentaViewFrom.setIndActi(
				(java.lang.Long)FormatUtils.parseObject(indActi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSubGerenVentaViewFrom.setCodNse1(
				(java.lang.String)FormatUtils.parseObject(codNse1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSubGerenVentaViewFrom.setCodNse2(
				(java.lang.String)FormatUtils.parseObject(codNse2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSubGerenVentaViewFrom.setCodNse3(
				(java.lang.String)FormatUtils.parseObject(codNse3, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonSubGerenVentaViewFrom.setDesSubgVent(
				(java.lang.String)FormatUtils.parseObject(desSubgVent, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
			if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
				marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
				marcOidMarcData.setId(new Long(marcOidMarc));
			}
			zonSubGerenVentaViewFrom.setMarcOidMarc(marcOidMarcData);
			es.indra.belcorp.mso.SegCanalViewData canaOidCanaData = null;
			if(canaOidCana != null && !canaOidCana.trim().equals("")){
				canaOidCanaData = new es.indra.belcorp.mso.SegCanalViewData();
				canaOidCanaData.setId(new Long(canaOidCana));
			}
			zonSubGerenVentaViewFrom.setCanaOidCana(canaOidCanaData);
			
			
			//Construimos el to
			zonSubGerenVentaViewTo = (ZonSubGerenVentaViewData)zonSubGerenVentaViewFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, zonSubGerenVentaViewFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, zonSubGerenVentaViewTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("zonSubGerenVentaViewFrom", zonSubGerenVentaViewFrom);
			dto.addProperty("zonSubGerenVentaViewTo", zonSubGerenVentaViewTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad ZonSubGerenVentaView");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad ZonSubGerenVentaView");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





