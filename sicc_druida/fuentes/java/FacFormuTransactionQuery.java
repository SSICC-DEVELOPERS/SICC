

/*
    INDRA/CAR/mmg
    $Id: FacFormuTransactionQuery.java,v 1.1 2009/12/03 18:35:16 pecbazalar Exp $
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
public class FacFormuTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	public static final String CHOICE_ATTRIBUTE = "codForm";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGFacFormuQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "FacFormuConectorQueryList";

	// Definicion del constructor
	public FacFormuTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad FacFormu");
			String codForm = (String)getEntrada("codForm");
			traza("MMG:: Valor de atributo codForm: " + codForm);
			if(codForm != null && !codForm.trim().equals("")) codForm = codForm.toUpperCase();
			String indImpr = (String)getEntrada("indImpr");
			traza("MMG:: Valor de atributo indImpr: " + indImpr);
			String valNombForm = (String)getEntrada("valNombForm");
			traza("MMG:: Valor de atributo valNombForm: " + valNombForm);
			String indActi = (String)getEntrada("indActi");
			traza("MMG:: Valor de atributo indActi: " + indActi);
			String tidoOidTipoDocu = (String)getEntrada("tidoOidTipoDocu");
			traza("MMG:: Valor de atributo tidoOidTipoDocu: " + tidoOidTipoDocu);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			FacFormuData facFormuFrom =new FacFormuData();
			FacFormuData facFormuTo = new FacFormuData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			facFormuFrom.setCodForm(
				(java.lang.String)FormatUtils.parseObject(codForm, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			facFormuFrom.setIndImpr(
				(java.lang.String)FormatUtils.parseObject(indImpr, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			facFormuFrom.setValNombForm(
				(java.lang.String)FormatUtils.parseObject(valNombForm, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			facFormuFrom.setIndActi(
				(java.lang.String)FormatUtils.parseObject(indActi, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.FacTipoDocumData tidoOidTipoDocuData = null;
			if(tidoOidTipoDocu != null && !tidoOidTipoDocu.trim().equals("")){
				tidoOidTipoDocuData = new es.indra.belcorp.mso.FacTipoDocumData();
				tidoOidTipoDocuData.setId(new Long(tidoOidTipoDocu));
			}
			facFormuFrom.setTidoOidTipoDocu(tidoOidTipoDocuData);
			
			
			//Construimos el to
			facFormuTo = (FacFormuData)facFormuFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, facFormuFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, facFormuTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("facFormuFrom", facFormuFrom);
			dto.addProperty("facFormuTo", facFormuTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad FacFormu");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad FacFormu");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





