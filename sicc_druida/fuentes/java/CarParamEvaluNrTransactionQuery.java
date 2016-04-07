

/*
    INDRA/CAR/mmg
    $Id: CarParamEvaluNrTransactionQuery.java,v 1.1 2009/12/03 18:42:54 pecbazalar Exp $
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
public class CarParamEvaluNrTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "desPara";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCarParamEvaluNrQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CarParamEvaluNrConectorQueryList";

	// Definicion del constructor
	public CarParamEvaluNrTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CarParamEvaluNr");
			String codPara = (String)getEntrada("codPara");
			traza("MMG:: Valor de atributo codPara: " + codPara);
			if(codPara != null && !codPara.trim().equals("")) codPara = codPara.toUpperCase();
			String desPara = (String)getEntrada("desPara");
			traza("MMG:: Valor de atributo desPara: " + desPara);
			String valPeso = (String)getEntrada("valPeso");
			traza("MMG:: Valor de atributo valPeso: " + valPeso);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CarParamEvaluNrData carParamEvaluNrFrom =new CarParamEvaluNrData();
			CarParamEvaluNrData carParamEvaluNrTo = new CarParamEvaluNrData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			carParamEvaluNrFrom.setCodPara(
				(java.lang.String)FormatUtils.parseObject(codPara, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carParamEvaluNrFrom.setDesPara(
				(java.lang.String)FormatUtils.parseObject(desPara, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carParamEvaluNrFrom.setValPeso(
				(java.lang.Double)FormatUtils.parseObject(valPeso, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			carParamEvaluNrTo = (CarParamEvaluNrData)carParamEvaluNrFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, carParamEvaluNrFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, carParamEvaluNrTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("carParamEvaluNrFrom", carParamEvaluNrFrom);
			dto.addProperty("carParamEvaluNrTo", carParamEvaluNrTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CarParamEvaluNr");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CarParamEvaluNr");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





