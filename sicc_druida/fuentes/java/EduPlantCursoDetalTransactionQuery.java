

/*
    INDRA/CAR/mmg
    $Id: EduPlantCursoDetalTransactionQuery.java,v 1.1 2009/12/03 18:36:32 pecbazalar Exp $
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
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class EduPlantCursoDetalTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGEduPlantCursoDetalQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "EduPlantCursoDetalConectorQueryList";

	// Definicion del constructor
	public EduPlantCursoDetalTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad EduPlantCursoDetal");
			
			String cplcOidCabe = (String)getEntrada("cplcOidCabe");
			traza("MMG:: Valor de atributo cplcOidCabe: " + cplcOidCabe);
			
			
			String valDeta = (String)getEntrada("valDeta");
			traza("MMG:: Valor de atributo valDeta: " + valDeta);
			
			
			String indVisi = (String)getEntrada("indVisi");
			traza("MMG:: Valor de atributo indVisi: " + indVisi);
			
			
			String indModi = (String)getEntrada("indModi");
			traza("MMG:: Valor de atributo indModi: " + indModi);
			
			
			String indObli = (String)getEntrada("indObli");
			traza("MMG:: Valor de atributo indObli: " + indObli);
			
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			EduPlantCursoDetalData eduPlantCursoDetalFrom =new EduPlantCursoDetalData();
			EduPlantCursoDetalData eduPlantCursoDetalTo = new EduPlantCursoDetalData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			
			es.indra.belcorp.mso.EduPlantCursoCabecData cplcOidCabeData = null;
			if(cplcOidCabe != null && !cplcOidCabe.trim().equals("")){
				cplcOidCabeData = new es.indra.belcorp.mso.EduPlantCursoCabecData();
				cplcOidCabeData.setId(new Integer(cplcOidCabe));
			}
			eduPlantCursoDetalFrom.setCplcOidCabe(cplcOidCabeData);
			eduPlantCursoDetalFrom.setValDeta(
				(java.lang.String)FormatUtils.parseObject(valDeta, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduPlantCursoDetalFrom.setIndVisi(
				(java.lang.Integer)FormatUtils.parseObject(indVisi, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduPlantCursoDetalFrom.setIndModi(
				(java.lang.Integer)FormatUtils.parseObject(indModi, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduPlantCursoDetalFrom.setIndObli(
				(java.lang.Integer)FormatUtils.parseObject(indObli, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			eduPlantCursoDetalTo = (EduPlantCursoDetalData)eduPlantCursoDetalFrom.clone();
			
			
			
			
			
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, eduPlantCursoDetalFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, eduPlantCursoDetalTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("eduPlantCursoDetalFrom", eduPlantCursoDetalFrom);
			dto.addProperty("eduPlantCursoDetalTo", eduPlantCursoDetalTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad EduPlantCursoDetal");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad EduPlantCursoDetal");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}





