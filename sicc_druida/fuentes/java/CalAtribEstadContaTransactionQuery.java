

/*
    INDRA/CAR/mmg
    $Id: CalAtribEstadContaTransactionQuery.java,v 1.1 2009/12/03 18:33:19 pecbazalar Exp $
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
public class CalAtribEstadContaTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	public static final String CHOICE_ATTRIBUTE = "Descripcion";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCalAtribEstadContaQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CalAtribEstadContaConectorQueryList";

	// Definicion del constructor
	public CalAtribEstadContaTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CalAtribEstadConta");
			String tecoOidTipoEstaCont = (String)getEntrada("tecoOidTipoEstaCont");
			traza("MMG:: Valor de atributo tecoOidTipoEstaCont: " + tecoOidTipoEstaCont);
			String codAtri = (String)getEntrada("codAtri");
			traza("MMG:: Valor de atributo codAtri: " + codAtri);
			if(codAtri != null && !codAtri.trim().equals("")) codAtri = codAtri.toUpperCase();
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CalAtribEstadContaData calAtribEstadContaFrom =new CalAtribEstadContaData();
			CalAtribEstadContaData calAtribEstadContaTo = new CalAtribEstadContaData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.CalTipoEstadContaData tecoOidTipoEstaContData = null;
			if(tecoOidTipoEstaCont != null && !tecoOidTipoEstaCont.trim().equals("")){
				tecoOidTipoEstaContData = new es.indra.belcorp.mso.CalTipoEstadContaData();
				tecoOidTipoEstaContData.setId(new Long(tecoOidTipoEstaCont));
			}
			calAtribEstadContaFrom.setTecoOidTipoEstaCont(tecoOidTipoEstaContData);
			calAtribEstadContaFrom.setCodAtri(
				(java.lang.String)FormatUtils.parseObject(codAtri, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			calAtribEstadContaFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			calAtribEstadContaTo = (CalAtribEstadContaData)calAtribEstadContaFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, calAtribEstadContaFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, calAtribEstadContaTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("calAtribEstadContaFrom", calAtribEstadContaFrom);
			dto.addProperty("calAtribEstadContaTo", calAtribEstadContaTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CalAtribEstadConta");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CalAtribEstadConta");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





