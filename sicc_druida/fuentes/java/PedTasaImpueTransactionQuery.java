

/*
    INDRA/CAR/mmg
    $Id: PedTasaImpueTransactionQuery.java,v 1.1 2009/12/03 18:33:59 pecbazalar Exp $
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
public class PedTasaImpueTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "Descripcion";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPedTasaImpueQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "PedTasaImpueConectorQueryList";

	// Definicion del constructor
	public PedTasaImpueTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad PedTasaImpue");
			String valIndiImpu = (String)getEntrada("valIndiImpu");
			traza("MMG:: Valor de atributo valIndiImpu: " + valIndiImpu);
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			String valTasaImpu = (String)getEntrada("valTasaImpu");
			traza("MMG:: Valor de atributo valTasaImpu: " + valTasaImpu);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PedTasaImpueData pedTasaImpueFrom =new PedTasaImpueData();
			PedTasaImpueData pedTasaImpueTo = new PedTasaImpueData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			pedTasaImpueFrom.setValIndiImpu(
				(java.lang.String)FormatUtils.parseObject(valIndiImpu, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedTasaImpueFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedTasaImpueFrom.setValTasaImpu(
				(java.lang.Double)FormatUtils.parseObject(valTasaImpu, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			pedTasaImpueTo = (PedTasaImpueData)pedTasaImpueFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, pedTasaImpueFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, pedTasaImpueTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("pedTasaImpueFrom", pedTasaImpueFrom);
			dto.addProperty("pedTasaImpueTo", pedTasaImpueTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(pedTasaImpueFrom, pedTasaImpueTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PedTasaImpue");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PedTasaImpue");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(pedTasaImpueFrom, pedTasaImpueTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(PedTasaImpueData pedTasaImpueFrom, PedTasaImpueData pedTasaImpueTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedTasaImpueFrom.setPaisOidPais(paisOculto);pedTasaImpueTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(PedTasaImpueData pedTasaImpueFrom, PedTasaImpueData pedTasaImpueTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedTasaImpueFrom.setPaisOidPais(paisOculto);pedTasaImpueTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





