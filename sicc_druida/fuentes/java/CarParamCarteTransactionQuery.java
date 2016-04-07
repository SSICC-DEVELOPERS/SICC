

/*
    INDRA/CAR/mmg
    $Id: CarParamCarteTransactionQuery.java,v 1.1 2009/12/03 18:32:45 pecbazalar Exp $
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
public class CarParamCarteTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCarParamCarteQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CarParamCarteConectorQueryList";

	// Definicion del constructor
	public CarParamCarteTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CarParamCarte");
			
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			
			
			String grsoOidGrupSoli = (String)getEntrada("grsoOidGrupSoli");
			traza("MMG:: Valor de atributo grsoOidGrupSoli: " + grsoOidGrupSoli);
			
			
			String niriOidNiveRies = (String)getEntrada("niriOidNiveRies");
			traza("MMG:: Valor de atributo niriOidNiveRies: " + niriOidNiveRies);
			
			
			String codConf = (String)getEntrada("codConf");
			traza("MMG:: Valor de atributo codConf: " + codConf);
			
			
			String indDeudVenc = (String)getEntrada("indDeudVenc");
			traza("MMG:: Valor de atributo indDeudVenc: " + indDeudVenc);
			
			
			String numDiasDeudVenc = (String)getEntrada("numDiasDeudVenc");
			traza("MMG:: Valor de atributo numDiasDeudVenc: " + numDiasDeudVenc);
			
			
			String indLineCred = (String)getEntrada("indLineCred");
			traza("MMG:: Valor de atributo indLineCred: " + indLineCred);
			
			
			String fecVigeDesd = (String)getEntrada("fecVigeDesd");
			traza("MMG:: Valor de atributo fecVigeDesd: " + fecVigeDesd);
			
			
			String fecVigeHast = (String)getEntrada("fecVigeHast");
			traza("MMG:: Valor de atributo fecVigeHast: " + fecVigeHast);
			
			
			String valPorcVali = (String)getEntrada("valPorcVali");
			traza("MMG:: Valor de atributo valPorcVali: " + valPorcVali);
			
			
			String indVali = (String)getEntrada("indVali");
			traza("MMG:: Valor de atributo indVali: " + indVali);
			
			
			String indMontMaxi = (String)getEntrada("indMontMaxi");
			traza("MMG:: Valor de atributo indMontMaxi: " + indMontMaxi);
			
			
			String valMontMaxiPerm = (String)getEntrada("valMontMaxiPerm");
			traza("MMG:: Valor de atributo valMontMaxiPerm: " + valMontMaxiPerm);
			
			
			String indPorcMaxi = (String)getEntrada("indPorcMaxi");
			traza("MMG:: Valor de atributo indPorcMaxi: " + indPorcMaxi);
			
			
			String valPorc = (String)getEntrada("valPorc");
			traza("MMG:: Valor de atributo valPorc: " + valPorc);
			
			
			String numDiasAdic = (String)getEntrada("numDiasAdic");
			traza("MMG:: Valor de atributo numDiasAdic: " + numDiasAdic);
			
			
			String invaOidIndiVali = (String)getEntrada("invaOidIndiVali");
			traza("MMG:: Valor de atributo invaOidIndiVali: " + invaOidIndiVali);
			
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CarParamCarteData carParamCarteFrom =new CarParamCarteData();
			CarParamCarteData carParamCarteTo = new CarParamCarteData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			
			es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
				paisOidPaisData.setId(new Integer(paisOidPais));
			}
			carParamCarteFrom.setPaisOidPais(paisOidPaisData);
			
			es.indra.belcorp.mso.CarGrupoSolicData grsoOidGrupSoliData = null;
			if(grsoOidGrupSoli != null && !grsoOidGrupSoli.trim().equals("")){
				grsoOidGrupSoliData = new es.indra.belcorp.mso.CarGrupoSolicData();
				grsoOidGrupSoliData.setId(new Integer(grsoOidGrupSoli));
			}
			carParamCarteFrom.setGrsoOidGrupSoli(grsoOidGrupSoliData);
			
			es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesData = null;
			if(niriOidNiveRies != null && !niriOidNiveRies.trim().equals("")){
				niriOidNiveRiesData = new es.indra.belcorp.mso.CarNivelRiesgData();
				niriOidNiveRiesData.setId(new Integer(niriOidNiveRies));
			}
			carParamCarteFrom.setNiriOidNiveRies(niriOidNiveRiesData);
			carParamCarteFrom.setCodConf(
				(java.lang.String)FormatUtils.parseObject(codConf, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carParamCarteFrom.setIndDeudVenc(
				(java.lang.Integer)FormatUtils.parseObject(indDeudVenc, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carParamCarteFrom.setNumDiasDeudVenc(
				(java.lang.Integer)FormatUtils.parseObject(numDiasDeudVenc, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carParamCarteFrom.setIndLineCred(
				(java.lang.Integer)FormatUtils.parseObject(indLineCred, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carParamCarteFrom.setFecVigeDesd(
				(java.sql.Date)FormatUtils.parseObject(fecVigeDesd, "java.sql.Date", 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carParamCarteFrom.setFecVigeHast(
				(java.sql.Date)FormatUtils.parseObject(fecVigeHast, "java.sql.Date", 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carParamCarteFrom.setValPorcVali(
				(java.lang.Double)FormatUtils.parseObject(valPorcVali, "java.lang.Double", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
				 /*
			carParamCarteFrom.setIndVali(
				(java.lang.String)FormatUtils.parseObject(indVali, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
				 */
			carParamCarteFrom.setIndMontMaxi(
				(java.lang.Integer)FormatUtils.parseObject(indMontMaxi, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carParamCarteFrom.setValMontMaxiPerm(
				(java.lang.Double)FormatUtils.parseObject(valMontMaxiPerm, "java.lang.Double", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carParamCarteFrom.setIndPorcMaxi(
				(java.lang.Integer)FormatUtils.parseObject(indPorcMaxi, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carParamCarteFrom.setValPorc(
				(java.lang.Double)FormatUtils.parseObject(valPorc, "java.lang.Double", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carParamCarteFrom.setNumDiasAdic(
				(java.lang.Integer)FormatUtils.parseObject(numDiasAdic, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			es.indra.belcorp.mso.CarIndicValidData invaOidIndiValiData = null;
			if(invaOidIndiVali != null && !invaOidIndiVali.trim().equals("")){
				invaOidIndiValiData = new es.indra.belcorp.mso.CarIndicValidData();
				invaOidIndiValiData.setId(new Integer(invaOidIndiVali));
			}
			carParamCarteFrom.setInvaOidIndiVali(invaOidIndiValiData);
			
			
			//Construimos el to
			carParamCarteTo = (CarParamCarteData)carParamCarteFrom.clone();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, carParamCarteFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, carParamCarteTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("carParamCarteFrom", carParamCarteFrom);
			dto.addProperty("carParamCarteTo", carParamCarteTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CarParamCarte");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CarParamCarte");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}





