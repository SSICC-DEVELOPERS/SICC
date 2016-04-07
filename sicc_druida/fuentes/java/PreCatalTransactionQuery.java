

/*
    INDRA/CAR/mmg
    $Id: PreCatalTransactionQuery.java,v 1.1 2009/12/03 18:38:53 pecbazalar Exp $
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
public class PreCatalTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "desCata";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPreCatalQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "PreCatalConectorQueryList";

	// Definicion del constructor
	public PreCatalTransactionQuery(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
		
			//Metemos en la sesi�n la query de la busqueda en formato param1|param2|....|paramN(para el tema de volver a la 
			//pagina anterior y ,mantener los �ltimos resultados)
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, 
				conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY));
			
			traza("MMG:: LLegao a transaction Query de entidad PreCatal");
			String codCata = (String)getEntrada("codCata");
			traza("MMG:: Valor de atributo codCata: " + codCata);
			String desCata = (String)getEntrada("desCata");
			traza("MMG:: Valor de atributo desCata: " + desCata);
			if(desCata != null && !desCata.trim().equals("")) desCata = desCata.toUpperCase();
			
		
			//Construimos los MSOs (from y to) con los elementos de la b�squeda
			PreCatalData preCatalFrom =new PreCatalData();
			PreCatalData preCatalTo = new PreCatalData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			preCatalFrom.setCodCata(
				(java.lang.Long)FormatUtils.parseObject(codCata, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			preCatalFrom.setDesCata(
				(java.lang.String)FormatUtils.parseObject(desCata, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			preCatalTo = (PreCatalData)preCatalFrom.clone();
			
			
			//Metemos tanto el fromo como el to como �ltimos mso con par�metros de b�squeda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, preCatalFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, preCatalTo);
			
			//Sacamos los datos de paginaci�n
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acci�n de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("preCatalFrom", preCatalFrom);
			dto.addProperty("preCatalTo", preCatalTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acci�n de prequery
			cmdPreQuery(preCatalFrom, preCatalTo);
			
			
			//Invocamos la l�gica de negocio
			traza("MMG:: Iniciada ejecuci�n Query de entidad PreCatal");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecuci�n Query de entidad PreCatal");
			
			//Ejecutamos la acci�n de postquery
			cmdPostQuery(preCatalFrom, preCatalTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(PreCatalData preCatalFrom, PreCatalData preCatalTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));preCatalFrom.setPaisOidPais(paisOculto);preCatalTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(PreCatalData preCatalFrom, PreCatalData preCatalTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));preCatalFrom.setPaisOidPais(paisOculto);preCatalTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





