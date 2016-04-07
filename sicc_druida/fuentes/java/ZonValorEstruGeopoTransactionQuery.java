

/*
    INDRA/CAR/mmg
    $Id: ZonValorEstruGeopoTransactionQuery.java,v 1.1 2009/12/03 18:32:29 pecbazalar Exp $
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
public class ZonValorEstruGeopoTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGZonValorEstruGeopoQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "ZonValorEstruGeopoConectorQueryList";

	// Definicion del constructor
	public ZonValorEstruGeopoTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad ZonValorEstruGeopo");
			String codUnidGeog = (String)getEntrada("codUnidGeog");
			traza("MMG:: Valor de atributo codUnidGeog: " + codUnidGeog);
			String desGeog = (String)getEntrada("desGeog");
			traza("MMG:: Valor de atributo desGeog: " + desGeog);
			String codNse1 = (String)getEntrada("codNse1");
			traza("MMG:: Valor de atributo codNse1: " + codNse1);
			String codNse2 = (String)getEntrada("codNse2");
			traza("MMG:: Valor de atributo codNse2: " + codNse2);
			String codNse3 = (String)getEntrada("codNse3");
			traza("MMG:: Valor de atributo codNse3: " + codNse3);
			String codPost = (String)getEntrada("codPost");
			traza("MMG:: Valor de atributo codPost: " + codPost);
			String indActi = (String)getEntrada("indActi");
			traza("MMG:: Valor de atributo indActi: " + indActi);
			String indAsig = (String)getEntrada("indAsig");
			traza("MMG:: Valor de atributo indAsig: " + indAsig);
			String indBorr = (String)getEntrada("indBorr");
			traza("MMG:: Valor de atributo indBorr: " + indBorr);
			String orde1 = (String)getEntrada("orde1");
			traza("MMG:: Valor de atributo orde1: " + orde1);
			String orde2 = (String)getEntrada("orde2");
			traza("MMG:: Valor de atributo orde2: " + orde2);
			String orde3 = (String)getEntrada("orde3");
			traza("MMG:: Valor de atributo orde3: " + orde3);
			String orde4 = (String)getEntrada("orde4");
			traza("MMG:: Valor de atributo orde4: " + orde4);
			String orde5 = (String)getEntrada("orde5");
			traza("MMG:: Valor de atributo orde5: " + orde5);
			String orde6 = (String)getEntrada("orde6");
			traza("MMG:: Valor de atributo orde6: " + orde6);
			String orde7 = (String)getEntrada("orde7");
			traza("MMG:: Valor de atributo orde7: " + orde7);
			String orde8 = (String)getEntrada("orde8");
			traza("MMG:: Valor de atributo orde8: " + orde8);
			String orde9 = (String)getEntrada("orde9");
			traza("MMG:: Valor de atributo orde9: " + orde9);
			String egeoOidEstrGeop = (String)getEntrada("egeoOidEstrGeop");
			traza("MMG:: Valor de atributo egeoOidEstrGeop: " + egeoOidEstrGeop);
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			String fecActu = (String)getEntrada("fecActu");
			traza("MMG:: Valor de atributo fecActu: " + fecActu);
			String sgeoOidSubeGeop = (String)getEntrada("sgeoOidSubeGeop");
			traza("MMG:: Valor de atributo sgeoOidSubeGeop: " + sgeoOidSubeGeop);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			ZonValorEstruGeopoData zonValorEstruGeopoFrom =new ZonValorEstruGeopoData();
			ZonValorEstruGeopoData zonValorEstruGeopoTo = new ZonValorEstruGeopoData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			zonValorEstruGeopoFrom.setCodUnidGeog(
				(java.lang.Integer)FormatUtils.parseObject(codUnidGeog, "java.lang.Integer", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setDesGeog(
				(java.lang.String)FormatUtils.parseObject(desGeog, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setCodNse1(
				(java.lang.String)FormatUtils.parseObject(codNse1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setCodNse2(
				(java.lang.String)FormatUtils.parseObject(codNse2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setCodNse3(
				(java.lang.String)FormatUtils.parseObject(codNse3, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setCodPost(
				(java.lang.String)FormatUtils.parseObject(codPost, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setIndActi(
				(java.lang.Integer)FormatUtils.parseObject(indActi, "java.lang.Integer", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setIndAsig(
				(java.lang.Integer)FormatUtils.parseObject(indAsig, "java.lang.Integer", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setIndBorr(
				(java.lang.Integer)FormatUtils.parseObject(indBorr, "java.lang.Integer", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setOrde1(
				(java.lang.String)FormatUtils.parseObject(orde1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setOrde2(
				(java.lang.String)FormatUtils.parseObject(orde2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setOrde3(
				(java.lang.String)FormatUtils.parseObject(orde3, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setOrde4(
				(java.lang.String)FormatUtils.parseObject(orde4, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setOrde5(
				(java.lang.String)FormatUtils.parseObject(orde5, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setOrde6(
				(java.lang.String)FormatUtils.parseObject(orde6, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setOrde7(
				(java.lang.String)FormatUtils.parseObject(orde7, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setOrde8(
				(java.lang.String)FormatUtils.parseObject(orde8, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonValorEstruGeopoFrom.setOrde9(
				(java.lang.String)FormatUtils.parseObject(orde9, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.ZonEstruGeopoData egeoOidEstrGeopData = null;
			if(egeoOidEstrGeop != null && !egeoOidEstrGeop.trim().equals("")){
				egeoOidEstrGeopData = new es.indra.belcorp.mso.ZonEstruGeopoData();
				egeoOidEstrGeopData.setId(new Integer(egeoOidEstrGeop));
			}
			zonValorEstruGeopoFrom.setEgeoOidEstrGeop(egeoOidEstrGeopData);
			es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
				paisOidPaisData.setId(new Integer(paisOidPais));
			}
			zonValorEstruGeopoFrom.setPaisOidPais(paisOidPaisData);
			zonValorEstruGeopoFrom.setFecActu(
				(java.sql.Date)FormatUtils.parseObject(fecActu, "java.sql.Date", 
			MMGDruidaHelper.getUserDatePattern(this, true)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.ZonSubesGeopoData sgeoOidSubeGeopData = null;
			if(sgeoOidSubeGeop != null && !sgeoOidSubeGeop.trim().equals("")){
				sgeoOidSubeGeopData = new es.indra.belcorp.mso.ZonSubesGeopoData();
				sgeoOidSubeGeopData.setId(new Integer(sgeoOidSubeGeop));
			}
			zonValorEstruGeopoFrom.setSgeoOidSubeGeop(sgeoOidSubeGeopData);
			
			
			//Construimos el to
			zonValorEstruGeopoTo = (ZonValorEstruGeopoData)zonValorEstruGeopoFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, zonValorEstruGeopoFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, zonValorEstruGeopoTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("zonValorEstruGeopoFrom", zonValorEstruGeopoFrom);
			dto.addProperty("zonValorEstruGeopoTo", zonValorEstruGeopoTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad ZonValorEstruGeopo");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad ZonValorEstruGeopo");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





