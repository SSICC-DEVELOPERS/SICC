

/*
    INDRA/CAR/mmg
    $Id: EduHistoCursoTransactionQuery.java,v 1.1 2009/12/03 18:37:14 pecbazalar Exp $
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
public class EduHistoCursoTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGEduHistoCursoQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "EduHistoCursoConectorQueryList";

	// Definicion del constructor
	public EduHistoCursoTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad EduHistoCurso");
			
			String ctsuOidClieTipoSubt = (String)getEntrada("ctsuOidClieTipoSubt");
			traza("MMG:: Valor de atributo ctsuOidClieTipoSubt: " + ctsuOidClieTipoSubt);
			
			
			String mcurOidCurs = (String)getEntrada("mcurOidCurs");
			traza("MMG:: Valor de atributo mcurOidCurs: " + mcurOidCurs);
			
			
			String indApta = (String)getEntrada("indApta");
			traza("MMG:: Valor de atributo indApta: " + indApta);
			
			
			String indInvit = (String)getEntrada("indInvit");
			traza("MMG:: Valor de atributo indInvit: " + indInvit);
			
			
			String indAsis = (String)getEntrada("indAsis");
			traza("MMG:: Valor de atributo indAsis: " + indAsis);
			
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			EduHistoCursoData eduHistoCursoFrom =new EduHistoCursoData();
			EduHistoCursoData eduHistoCursoTo = new EduHistoCursoData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			
			es.indra.belcorp.mso.MaeClienTipoSubtiData ctsuOidClieTipoSubtData = null;
			if(ctsuOidClieTipoSubt != null && !ctsuOidClieTipoSubt.trim().equals("")){
				ctsuOidClieTipoSubtData = new es.indra.belcorp.mso.MaeClienTipoSubtiData();
				ctsuOidClieTipoSubtData.setId(new Integer(ctsuOidClieTipoSubt));
			}
			eduHistoCursoFrom.setCtsuOidClieTipoSubt(ctsuOidClieTipoSubtData);
			
			es.indra.belcorp.mso.EduMatriCursoData mcurOidCursData = null;
			if(mcurOidCurs != null && !mcurOidCurs.trim().equals("")){
				mcurOidCursData = new es.indra.belcorp.mso.EduMatriCursoData();
				mcurOidCursData.setId(new Integer(mcurOidCurs));
			}
			eduHistoCursoFrom.setMcurOidCurs(mcurOidCursData);
			eduHistoCursoFrom.setIndApta(
				(java.lang.Integer)FormatUtils.parseObject(indApta, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduHistoCursoFrom.setIndInvit(
				(java.lang.Integer)FormatUtils.parseObject(indInvit, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduHistoCursoFrom.setIndAsis(
				(java.lang.Integer)FormatUtils.parseObject(indAsis, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			eduHistoCursoTo = (EduHistoCursoData)eduHistoCursoFrom.clone();
			
			
			
			
			
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, eduHistoCursoFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, eduHistoCursoTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("eduHistoCursoFrom", eduHistoCursoFrom);
			dto.addProperty("eduHistoCursoTo", eduHistoCursoTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad EduHistoCurso");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad EduHistoCurso");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}





