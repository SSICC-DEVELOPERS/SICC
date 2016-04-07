

/*
    INDRA/CAR/mmg
    $Id: CobGuionArgumCabecTransactionQuery.java,v 1.1 2009/12/03 18:40:49 pecbazalar Exp $
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
public class CobGuionArgumCabecTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "Descripcion";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCobGuionArgumCabecQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CobGuionArgumCabecConectorQueryList";

	// Definicion del constructor
	public CobGuionArgumCabecTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CobGuionArgumCabec");
			String codGuiaArgu = (String)getEntrada("codGuiaArgu");
			traza("MMG:: Valor de atributo codGuiaArgu: " + codGuiaArgu);
			if(codGuiaArgu != null && !codGuiaArgu.trim().equals("")) codGuiaArgu = codGuiaArgu.toUpperCase();
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			
		
			//Construimos los MSOs (from y to) con los elementos de la b�squeda
			CobGuionArgumCabecData cobGuionArgumCabecFrom =new CobGuionArgumCabecData();
			CobGuionArgumCabecData cobGuionArgumCabecTo = new CobGuionArgumCabecData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			cobGuionArgumCabecFrom.setCodGuiaArgu(
				(java.lang.String)FormatUtils.parseObject(codGuiaArgu, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobGuionArgumCabecFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			cobGuionArgumCabecTo = (CobGuionArgumCabecData)cobGuionArgumCabecFrom.clone();
			
			
			//Metemos tanto el fromo como el to como �ltimos mso con par�metros de b�squeda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cobGuionArgumCabecFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cobGuionArgumCabecTo);
			
			//Sacamos los datos de paginaci�n
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acci�n de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cobGuionArgumCabecFrom", cobGuionArgumCabecFrom);
			dto.addProperty("cobGuionArgumCabecTo", cobGuionArgumCabecTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acci�n de prequery
			cmdPreQuery(cobGuionArgumCabecFrom, cobGuionArgumCabecTo);
			
			
			//Invocamos la l�gica de negocio
			traza("MMG:: Iniciada ejecuci�n Query de entidad CobGuionArgumCabec");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecuci�n Query de entidad CobGuionArgumCabec");
			
			//Ejecutamos la acci�n de postquery
			cmdPostQuery(cobGuionArgumCabecFrom, cobGuionArgumCabecTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(CobGuionArgumCabecData cobGuionArgumCabecFrom, CobGuionArgumCabecData cobGuionArgumCabecTo) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobGuionArgumCabecFrom.setPaisOidPais(paisOculto);
                cobGuionArgumCabecTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
			
	}
	
	
	public void cmdPostQuery(CobGuionArgumCabecData cobGuionArgumCabecFrom, CobGuionArgumCabecData cobGuionArgumCabecTo, DruidaConector result) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                cobGuionArgumCabecFrom.setPaisOidPais(paisOculto);
                cobGuionArgumCabecTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
			
	}
	
	
}





