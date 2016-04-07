

/*
    INDRA/CAR/mmg
    $Id: BelAlmacTransactionQuery.java,v 1.1 2009/12/03 18:34:49 pecbazalar Exp $
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
public class BelAlmacTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	public static final String CHOICE_ATTRIBUTE = "Descripcion";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGBelAlmacQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "BelAlmacConectorQueryList";

	// Definicion del constructor
	public BelAlmacTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad BelAlmac");
			String codAlma = (String)getEntrada("codAlma");
			traza("MMG:: Valor de atributo codAlma: " + codAlma);
			if(codAlma != null && !codAlma.trim().equals("")) codAlma = codAlma.toUpperCase();
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			String indInfoSap = (String)getEntrada("indInfoSap");
			traza("MMG:: Valor de atributo indInfoSap: " + indInfoSap);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			BelAlmacData belAlmacFrom =new BelAlmacData();
			BelAlmacData belAlmacTo = new BelAlmacData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			belAlmacFrom.setCodAlma(
				(java.lang.String)FormatUtils.parseObject(codAlma, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belAlmacFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belAlmacFrom.setIndInfoSap(
				(java.lang.Boolean)FormatUtils.parseObject(indInfoSap, "java.lang.Boolean", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			belAlmacTo = (BelAlmacData)belAlmacFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, belAlmacFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, belAlmacTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("belAlmacFrom", belAlmacFrom);
			dto.addProperty("belAlmacTo", belAlmacTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(belAlmacFrom, belAlmacTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad BelAlmac");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad BelAlmac");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(belAlmacFrom, belAlmacTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(BelAlmacData belAlmacFrom, BelAlmacData belAlmacTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				belAlmacFrom.setPaisOidPais(paisOculto);
				belAlmacTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
				
	}
	
	
	public void cmdPostQuery(BelAlmacData belAlmacFrom, BelAlmacData belAlmacTo, DruidaConector result) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				belAlmacFrom.setPaisOidPais(paisOculto);
				belAlmacTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
				
	}
	
	
}





