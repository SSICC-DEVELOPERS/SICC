

/*
    INDRA/CAR/mmg
    $Id: EduAptasCursoTransactionQuery.java,v 1.1 2009/12/03 18:35:55 pecbazalar Exp $
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
public class EduAptasCursoTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGEduAptasCursoQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "EduAptasCursoConectorQueryList";

	// Definicion del constructor
	public EduAptasCursoTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad EduAptasCurso");
			
			String ctsuOidClieTipoSubt = (String)getEntrada("ctsuOidClieTipoSubt");
			traza("MMG:: Valor de atributo ctsuOidClieTipoSubt: " + ctsuOidClieTipoSubt);
			
			
			String mcurOidCurs = (String)getEntrada("mcurOidCurs");
			traza("MMG:: Valor de atributo mcurOidCurs: " + mcurOidCurs);
			
			
			String fecAsis = (String)getEntrada("fecAsis");
			traza("MMG:: Valor de atributo fecAsis: " + fecAsis);
			
			
			String indAcceDmrt = (String)getEntrada("indAcceDmrt");
			traza("MMG:: Valor de atributo indAcceDmrt: " + indAcceDmrt);
			
			
			String indAptaCurs = (String)getEntrada("indAptaCurs");
			traza("MMG:: Valor de atributo indAptaCurs: " + indAptaCurs);
			
			
			String indInvi = (String)getEntrada("indInvi");
			traza("MMG:: Valor de atributo indInvi: " + indInvi);
			
			
			String indAsis = (String)getEntrada("indAsis");
			traza("MMG:: Valor de atributo indAsis: " + indAsis);
			
			
			String indPrue = (String)getEntrada("indPrue");
			traza("MMG:: Valor de atributo indPrue: " + indPrue);
			
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			EduAptasCursoData eduAptasCursoFrom =new EduAptasCursoData();
			EduAptasCursoData eduAptasCursoTo = new EduAptasCursoData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			
			es.indra.belcorp.mso.MaeClienTipoSubtiData ctsuOidClieTipoSubtData = null;
			if(ctsuOidClieTipoSubt != null && !ctsuOidClieTipoSubt.trim().equals("")){
				ctsuOidClieTipoSubtData = new es.indra.belcorp.mso.MaeClienTipoSubtiData();
				ctsuOidClieTipoSubtData.setId(new Integer(ctsuOidClieTipoSubt));
			}
			eduAptasCursoFrom.setCtsuOidClieTipoSubt(ctsuOidClieTipoSubtData);
			
			es.indra.belcorp.mso.EduMatriCursoData mcurOidCursData = null;
			if(mcurOidCurs != null && !mcurOidCurs.trim().equals("")){
				mcurOidCursData = new es.indra.belcorp.mso.EduMatriCursoData();
				mcurOidCursData.setId(new Integer(mcurOidCurs));
			}
			eduAptasCursoFrom.setMcurOidCurs(mcurOidCursData);
			eduAptasCursoFrom.setFecAsis(
				(java.sql.Date)FormatUtils.parseObject(fecAsis, "java.sql.Date", 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduAptasCursoFrom.setIndAcceDmrt(
				(java.lang.Integer)FormatUtils.parseObject(indAcceDmrt, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduAptasCursoFrom.setIndAptaCurs(
				(java.lang.Integer)FormatUtils.parseObject(indAptaCurs, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduAptasCursoFrom.setIndInvi(
				(java.lang.Integer)FormatUtils.parseObject(indInvi, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduAptasCursoFrom.setIndAsis(
				(java.lang.Integer)FormatUtils.parseObject(indAsis, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduAptasCursoFrom.setIndPrue(
				(java.lang.Integer)FormatUtils.parseObject(indPrue, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			eduAptasCursoTo = (EduAptasCursoData)eduAptasCursoFrom.clone();
			
			
			
			
			
			
			
			
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, eduAptasCursoFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, eduAptasCursoTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("eduAptasCursoFrom", eduAptasCursoFrom);
			dto.addProperty("eduAptasCursoTo", eduAptasCursoTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad EduAptasCurso");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad EduAptasCurso");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}





