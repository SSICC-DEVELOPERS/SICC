

/*
    INDRA/CAR/mmg
    $Id: CraPerioTransactionQuery.java,v 1.1 2009/12/03 18:42:03 pecbazalar Exp $
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
public class CraPerioTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCraPerioQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CraPerioConectorQueryList";

	// Definicion del constructor
	public CraPerioTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CraPerio");
			String marcOidMarc = (String)getEntrada("marcOidMarc");
			traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
			String canaOidCana = (String)getEntrada("canaOidCana");
			traza("MMG:: Valor de atributo canaOidCana: " + canaOidCana);
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			String acceOidAcce = (String)getEntrada("acceOidAcce");
			traza("MMG:: Valor de atributo acceOidAcce: " + acceOidAcce);
			String periOidPeri = (String)getEntrada("periOidPeri");
			traza("MMG:: Valor de atributo periOidPeri: " + periOidPeri);
			String fecInic = (String)getEntrada("fecInic");
			traza("MMG:: Valor de atributo fecInic: " + fecInic);
			String fecFina = (String)getEntrada("fecFina");
			traza("MMG:: Valor de atributo fecFina: " + fecFina);
			String valEsta = (String)getEntrada("valEsta");
			traza("MMG:: Valor de atributo valEsta: " + valEsta);
			String valNombPeri = (String)getEntrada("valNombPeri");
			traza("MMG:: Valor de atributo valNombPeri: " + valNombPeri);
			String indPeriCort = (String)getEntrada("indPeriCort");
			traza("MMG:: Valor de atributo indPeriCort: " + indPeriCort);
			String indPeriCruc = (String)getEntrada("indPeriCruc");
			traza("MMG:: Valor de atributo indPeriCruc: " + indPeriCruc);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CraPerioData craPerioFrom =new CraPerioData();
			CraPerioData craPerioTo = new CraPerioData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
			if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
				marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
				marcOidMarcData.setId(new Long(marcOidMarc));
			}
			craPerioFrom.setMarcOidMarc(marcOidMarcData);
			es.indra.belcorp.mso.SegCanalData canaOidCanaData = null;
			if(canaOidCana != null && !canaOidCana.trim().equals("")){
				canaOidCanaData = new es.indra.belcorp.mso.SegCanalData();
				canaOidCanaData.setId(new Long(canaOidCana));
			}
			craPerioFrom.setCanaOidCana(canaOidCanaData);
			es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
				paisOidPaisData.setId(new Long(paisOidPais));
			}
			craPerioFrom.setPaisOidPais(paisOidPaisData);
			es.indra.belcorp.mso.SegAccesData acceOidAcceData = null;
			if(acceOidAcce != null && !acceOidAcce.trim().equals("")){
				acceOidAcceData = new es.indra.belcorp.mso.SegAccesData();
				acceOidAcceData.setId(new Long(acceOidAcce));
			}
			craPerioFrom.setAcceOidAcce(acceOidAcceData);
			es.indra.belcorp.mso.SegPerioCorpoData periOidPeriData = null;
			if(periOidPeri != null && !periOidPeri.trim().equals("")){
				periOidPeriData = new es.indra.belcorp.mso.SegPerioCorpoData();
				periOidPeriData.setId(new Long(periOidPeri));
			}
			craPerioFrom.setPeriOidPeri(periOidPeriData);
			craPerioFrom.setFecInic(
				(java.sql.Date)FormatUtils.parseObject(fecInic, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			craPerioFrom.setFecFina(
				(java.sql.Date)FormatUtils.parseObject(fecFina, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			craPerioFrom.setValEsta(
				(java.lang.Long)FormatUtils.parseObject(valEsta, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			craPerioFrom.setValNombPeri(
				(java.lang.String)FormatUtils.parseObject(valNombPeri, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			craPerioFrom.setIndPeriCort(
				(java.lang.Long)FormatUtils.parseObject(indPeriCort, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			craPerioFrom.setIndPeriCruc(
				(java.lang.Long)FormatUtils.parseObject(indPeriCruc, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			craPerioTo = (CraPerioData)craPerioFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, craPerioFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, craPerioTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("craPerioFrom", craPerioFrom);
			dto.addProperty("craPerioTo", craPerioTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CraPerio");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CraPerio");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





