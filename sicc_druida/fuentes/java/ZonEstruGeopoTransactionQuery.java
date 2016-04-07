

/*
    INDRA/CAR/mmg
    $Id: ZonEstruGeopoTransactionQuery.java,v 1.1 2009/12/03 18:40:15 pecbazalar Exp $
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
public class ZonEstruGeopoTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	public static final String CHOICE_ATTRIBUTE = "codOrde";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGZonEstruGeopoQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "ZonEstruGeopoConectorQueryList";

	// Definicion del constructor
	public ZonEstruGeopoTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad ZonEstruGeopo");
			String codOrde = (String)getEntrada("codOrde");
			traza("MMG:: Valor de atributo codOrde: " + codOrde);
			if(codOrde != null && !codOrde.trim().equals("")) codOrde = codOrde.toUpperCase();
			String indBorr = (String)getEntrada("indBorr");
			traza("MMG:: Valor de atributo indBorr: " + indBorr);
			if(indBorr != null && !indBorr.trim().equals("")) indBorr = indBorr.toUpperCase();
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			if(paisOidPais != null && !paisOidPais.trim().equals("")) paisOidPais = paisOidPais.toUpperCase();
			String dipoOidDiviPoli = (String)getEntrada("dipoOidDiviPoli");
			traza("MMG:: Valor de atributo dipoOidDiviPoli: " + dipoOidDiviPoli);
			if(dipoOidDiviPoli != null && !dipoOidDiviPoli.trim().equals("")) dipoOidDiviPoli = dipoOidDiviPoli.toUpperCase();
			String fecActu = (String)getEntrada("fecActu");
			traza("MMG:: Valor de atributo fecActu: " + fecActu);
			if(fecActu != null && !fecActu.trim().equals("")) fecActu = fecActu.toUpperCase();
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			ZonEstruGeopoData zonEstruGeopoFrom =new ZonEstruGeopoData();
			ZonEstruGeopoData zonEstruGeopoTo = new ZonEstruGeopoData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			zonEstruGeopoFrom.setCodOrde(
				(java.lang.Long)FormatUtils.parseObject(codOrde, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonEstruGeopoFrom.setIndBorr(
				(java.lang.Long)FormatUtils.parseObject(indBorr, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
				paisOidPaisData.setId(new Long(paisOidPais));
			}
			zonEstruGeopoFrom.setPaisOidPais(paisOidPaisData);
			es.indra.belcorp.mso.ZonNivelGeogrData dipoOidDiviPoliData = null;
			if(dipoOidDiviPoli != null && !dipoOidDiviPoli.trim().equals("")){
				dipoOidDiviPoliData = new es.indra.belcorp.mso.ZonNivelGeogrData();
				dipoOidDiviPoliData.setId(new Long(dipoOidDiviPoli));
			}
			zonEstruGeopoFrom.setDipoOidDiviPoli(dipoOidDiviPoliData);
			zonEstruGeopoFrom.setFecActu(
				(java.sql.Date)FormatUtils.parseObject(fecActu, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			zonEstruGeopoTo = (ZonEstruGeopoData)zonEstruGeopoFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, zonEstruGeopoFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, zonEstruGeopoTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("zonEstruGeopoFrom", zonEstruGeopoFrom);
			dto.addProperty("zonEstruGeopoTo", zonEstruGeopoTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(zonEstruGeopoFrom, zonEstruGeopoTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad ZonEstruGeopo");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad ZonEstruGeopo");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(zonEstruGeopoFrom, zonEstruGeopoTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(ZonEstruGeopoData zonEstruGeopoFrom, ZonEstruGeopoData zonEstruGeopoTo) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
                Long(MMGDruidaHelper.getUserDefaultCountry(this)));zonEstruGeopoFrom.setPaisOidPais(paisOculto);zonEstruGeopoTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
	public void cmdPostQuery(ZonEstruGeopoData zonEstruGeopoFrom, ZonEstruGeopoData zonEstruGeopoTo, DruidaConector result) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
                Long(MMGDruidaHelper.getUserDefaultCountry(this)));zonEstruGeopoFrom.setPaisOidPais(paisOculto);zonEstruGeopoTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
}





