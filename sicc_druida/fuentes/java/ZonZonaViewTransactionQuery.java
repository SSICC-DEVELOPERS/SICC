

/*
    INDRA/CAR/mmg
    $Id: ZonZonaViewTransactionQuery.java,v 1.1 2009/12/03 18:42:52 pecbazalar Exp $
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
public class ZonZonaViewTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	public static final String CHOICE_ATTRIBUTE = "codZona";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGZonZonaViewQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "ZonZonaViewConectorQueryList";

	// Definicion del constructor
	public ZonZonaViewTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad ZonZonaView");
			String codZona = (String)getEntrada("codZona");
			traza("MMG:: Valor de atributo codZona: " + codZona);
			String indActi = (String)getEntrada("indActi");
			traza("MMG:: Valor de atributo indActi: " + indActi);
			String indRezo = (String)getEntrada("indRezo");
			traza("MMG:: Valor de atributo indRezo: " + indRezo);
			String codNse1 = (String)getEntrada("codNse1");
			traza("MMG:: Valor de atributo codNse1: " + codNse1);
			String codNse2 = (String)getEntrada("codNse2");
			traza("MMG:: Valor de atributo codNse2: " + codNse2);
			String codNse3 = (String)getEntrada("codNse3");
			traza("MMG:: Valor de atributo codNse3: " + codNse3);
			String indBorr = (String)getEntrada("indBorr");
			traza("MMG:: Valor de atributo indBorr: " + indBorr);
			String desZona = (String)getEntrada("desZona");
			traza("MMG:: Valor de atributo desZona: " + desZona);
			String fecCambEsta = (String)getEntrada("fecCambEsta");
			traza("MMG:: Valor de atributo fecCambEsta: " + fecCambEsta);
			String fecRezo = (String)getEntrada("fecRezo");
			traza("MMG:: Valor de atributo fecRezo: " + fecRezo);
			String marcOidMarc = (String)getEntrada("marcOidMarc");
			traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
			String canaOidCana = (String)getEntrada("canaOidCana");
			traza("MMG:: Valor de atributo canaOidCana: " + canaOidCana);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			ZonZonaViewData zonZonaViewFrom =new ZonZonaViewData();
			ZonZonaViewData zonZonaViewTo = new ZonZonaViewData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			zonZonaViewFrom.setCodZona(
				(java.lang.String)FormatUtils.parseObject(codZona, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonZonaViewFrom.setIndActi(
				(java.lang.Long)FormatUtils.parseObject(indActi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonZonaViewFrom.setIndRezo(
				(java.lang.Long)FormatUtils.parseObject(indRezo, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonZonaViewFrom.setCodNse1(
				(java.lang.String)FormatUtils.parseObject(codNse1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonZonaViewFrom.setCodNse2(
				(java.lang.String)FormatUtils.parseObject(codNse2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonZonaViewFrom.setCodNse3(
				(java.lang.String)FormatUtils.parseObject(codNse3, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonZonaViewFrom.setIndBorr(
				(java.lang.Long)FormatUtils.parseObject(indBorr, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonZonaViewFrom.setDesZona(
				(java.lang.String)FormatUtils.parseObject(desZona, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonZonaViewFrom.setFecCambEsta(
				(java.sql.Date)FormatUtils.parseObject(fecCambEsta, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonZonaViewFrom.setFecRezo(
				(java.sql.Date)FormatUtils.parseObject(fecRezo, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
			if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
				marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
				marcOidMarcData.setId(new Long(marcOidMarc));
			}
			zonZonaViewFrom.setMarcOidMarc(marcOidMarcData);
			es.indra.belcorp.mso.SegCanalViewData canaOidCanaData = null;
			if(canaOidCana != null && !canaOidCana.trim().equals("")){
				canaOidCanaData = new es.indra.belcorp.mso.SegCanalViewData();
				canaOidCanaData.setId(new Long(canaOidCana));
			}
			zonZonaViewFrom.setCanaOidCana(canaOidCanaData);
			
			
			//Construimos el to
			zonZonaViewTo = (ZonZonaViewData)zonZonaViewFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, zonZonaViewFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, zonZonaViewTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("zonZonaViewFrom", zonZonaViewFrom);
			dto.addProperty("zonZonaViewTo", zonZonaViewTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad ZonZonaView");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad ZonZonaView");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





