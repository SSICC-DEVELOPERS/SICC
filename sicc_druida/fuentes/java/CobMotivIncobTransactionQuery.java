

/*
    INDRA/CAR/mmg
    $Id: CobMotivIncobTransactionQuery.java,v 1.1 2009/12/03 18:43:00 pecbazalar Exp $
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
public class CobMotivIncobTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCobMotivIncobQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CobMotivIncobConectorQueryList";

	// Definicion del constructor
	public CobMotivIncobTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CobMotivIncob");
			String codMotiCobr = (String)getEntrada("codMotiCobr");
			traza("MMG:: Valor de atributo codMotiCobr: " + codMotiCobr);
			if(codMotiCobr != null && !codMotiCobr.trim().equals("")) codMotiCobr = codMotiCobr.toUpperCase();
			String valDescMotiCobr = (String)getEntrada("valDescMotiCobr");
			traza("MMG:: Valor de atributo valDescMotiCobr: " + valDescMotiCobr);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CobMotivIncobData cobMotivIncobFrom =new CobMotivIncobData();
			CobMotivIncobData cobMotivIncobTo = new CobMotivIncobData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			cobMotivIncobFrom.setCodMotiCobr(
				(java.lang.String)FormatUtils.parseObject(codMotiCobr, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobMotivIncobFrom.setValDescMotiCobr(
				(java.lang.String)FormatUtils.parseObject(valDescMotiCobr, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			cobMotivIncobTo = (CobMotivIncobData)cobMotivIncobFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cobMotivIncobFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cobMotivIncobTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cobMotivIncobFrom", cobMotivIncobFrom);
			dto.addProperty("cobMotivIncobTo", cobMotivIncobTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(cobMotivIncobFrom, cobMotivIncobTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CobMotivIncob");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CobMotivIncob");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(cobMotivIncobFrom, cobMotivIncobTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(CobMotivIncobData cobMotivIncobFrom, CobMotivIncobData cobMotivIncobTo) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobMotivIncobFrom.setPaisOidPais(paisOculto);
                cobMotivIncobTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
	}
	
	
	public void cmdPostQuery(CobMotivIncobData cobMotivIncobFrom, CobMotivIncobData cobMotivIncobTo, DruidaConector result) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobMotivIncobFrom.setPaisOidPais(paisOculto);
                cobMotivIncobTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
	}
	
	
}





