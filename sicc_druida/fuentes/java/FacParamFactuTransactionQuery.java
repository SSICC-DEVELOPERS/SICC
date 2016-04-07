

/*
    INDRA/CAR/mmg
    $Id: FacParamFactuTransactionQuery.java,v 1.1 2009/12/03 18:43:12 pecbazalar Exp $
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
public class FacParamFactuTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGFacParamFactuQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "FacParamFactuConectorQueryList";

	// Definicion del constructor
	public FacParamFactuTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad FacParamFactu");
			String indDocuMonoPagi = (String)getEntrada("indDocuMonoPagi");
			traza("MMG:: Valor de atributo indDocuMonoPagi: " + indDocuMonoPagi);
			String valMontLimiUit = (String)getEntrada("valMontLimiUit");
			traza("MMG:: Valor de atributo valMontLimiUit: " + valMontLimiUit);
			String numMaxiCampPrd = (String)getEntrada("numMaxiCampPrd");
			traza("MMG:: Valor de atributo numMaxiCampPrd: " + numMaxiCampPrd);
			String indTipoProyRegi = (String)getEntrada("indTipoProyRegi");
			traza("MMG:: Valor de atributo indTipoProyRegi: " + indTipoProyRegi);
			String indMostVencCupo = (String)getEntrada("indMostVencCupo");
			traza("MMG:: Valor de atributo indMostVencCupo: " + indMostVencCupo);
			String numMaxiPediProy = (String)getEntrada("numMaxiPediProy");
			traza("MMG:: Valor de atributo numMaxiPediProy: " + numMaxiPediProy);
			String codModaDist = (String)getEntrada("codModaDist");
			traza("MMG:: Valor de atributo codModaDist: " + codModaDist);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			FacParamFactuData facParamFactuFrom =new FacParamFactuData();
			FacParamFactuData facParamFactuTo = new FacParamFactuData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			facParamFactuFrom.setIndDocuMonoPagi(
				(java.lang.Long)FormatUtils.parseObject(indDocuMonoPagi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			facParamFactuFrom.setValMontLimiUit(
				(java.lang.Long)FormatUtils.parseObject(valMontLimiUit, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			facParamFactuFrom.setNumMaxiCampPrd(
				(java.lang.Long)FormatUtils.parseObject(numMaxiCampPrd, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			facParamFactuFrom.setIndTipoProyRegi(
				(java.lang.Long)FormatUtils.parseObject(indTipoProyRegi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			facParamFactuFrom.setIndMostVencCupo(
				(java.lang.Long)FormatUtils.parseObject(indMostVencCupo, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			facParamFactuFrom.setNumMaxiPediProy(
				(java.lang.Long)FormatUtils.parseObject(numMaxiPediProy, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			facParamFactuFrom.setCodModaDist(
				(java.lang.String)FormatUtils.parseObject(codModaDist, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			facParamFactuTo = (FacParamFactuData)facParamFactuFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, facParamFactuFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, facParamFactuTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("facParamFactuFrom", facParamFactuFrom);
			dto.addProperty("facParamFactuTo", facParamFactuTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(facParamFactuFrom, facParamFactuTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad FacParamFactu");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad FacParamFactu");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(facParamFactuFrom, facParamFactuTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(FacParamFactuData facParamFactuFrom, FacParamFactuData facParamFactuTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				facParamFactuFrom.setPaisOidPais(paisOculto);
				facParamFactuTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(FacParamFactuData facParamFactuFrom, FacParamFactuData facParamFactuTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				facParamFactuFrom.setPaisOidPais(paisOculto);
				facParamFactuTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





