

/*
    INDRA/CAR/mmg
    $Id: CarAsignCodigConfiTransactionQuery.java,v 1.1 2009/12/03 18:36:04 pecbazalar Exp $
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
public class CarAsignCodigConfiTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCarAsignCodigConfiQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CarAsignCodigConfiConectorQueryList";

	// Definicion del constructor
	public CarAsignCodigConfiTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CarAsignCodigConfi");
			
			String zsgvOidSubgVent = (String)getEntrada("zsgvOidSubgVent");
			traza("MMG:: Valor de atributo zsgvOidSubgVent: " + zsgvOidSubgVent);
			
			
			String zorgOidRegi = (String)getEntrada("zorgOidRegi");
			traza("MMG:: Valor de atributo zorgOidRegi: " + zorgOidRegi);
			
			
			String zzonOidZona = (String)getEntrada("zzonOidZona");
			traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
			
			
			String grsoOidGrupSoli = (String)getEntrada("grsoOidGrupSoli");
			traza("MMG:: Valor de atributo grsoOidGrupSoli: " + grsoOidGrupSoli);
			
			
			String niriOidNiveRies = (String)getEntrada("niriOidNiveRies");
			traza("MMG:: Valor de atributo niriOidNiveRies: " + niriOidNiveRies);
			
			
			String niriOidNiveRiesInici = (String)getEntrada("niriOidNiveRiesInici");
			traza("MMG:: Valor de atributo niriOidNiveRiesInici: " + niriOidNiveRiesInici);
			
			
			String pacaOidParaCart = (String)getEntrada("pacaOidParaCart");
			traza("MMG:: Valor de atributo pacaOidParaCart: " + pacaOidParaCart);
			
			
			String valLineCredInic = (String)getEntrada("valLineCredInic");
			traza("MMG:: Valor de atributo valLineCredInic: " + valLineCredInic);
			
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CarAsignCodigConfiData carAsignCodigConfiFrom =new CarAsignCodigConfiData();
			CarAsignCodigConfiData carAsignCodigConfiTo = new CarAsignCodigConfiData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			
			es.indra.belcorp.mso.ZonSubGerenVentaData zsgvOidSubgVentData = null;
			if(zsgvOidSubgVent != null && !zsgvOidSubgVent.trim().equals("")){
				zsgvOidSubgVentData = new es.indra.belcorp.mso.ZonSubGerenVentaData();
				zsgvOidSubgVentData.setId(new Integer(zsgvOidSubgVent));
			}
			carAsignCodigConfiFrom.setZsgvOidSubgVent(zsgvOidSubgVentData);
			
			es.indra.belcorp.mso.ZonRegioData zorgOidRegiData = null;
			if(zorgOidRegi != null && !zorgOidRegi.trim().equals("")){
				zorgOidRegiData = new es.indra.belcorp.mso.ZonRegioData();
				zorgOidRegiData.setId(new Integer(zorgOidRegi));
			}
			carAsignCodigConfiFrom.setZorgOidRegi(zorgOidRegiData);
			
			es.indra.belcorp.mso.ZonZonaData zzonOidZonaData = null;
			if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
				zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaData();
				zzonOidZonaData.setId(new Integer(zzonOidZona));
			}
			carAsignCodigConfiFrom.setZzonOidZona(zzonOidZonaData);
			
			es.indra.belcorp.mso.CarGrupoSolicData grsoOidGrupSoliData = null;
			if(grsoOidGrupSoli != null && !grsoOidGrupSoli.trim().equals("")){
				grsoOidGrupSoliData = new es.indra.belcorp.mso.CarGrupoSolicData();
				grsoOidGrupSoliData.setId(new Integer(grsoOidGrupSoli));
			}
			carAsignCodigConfiFrom.setGrsoOidGrupSoli(grsoOidGrupSoliData);
			
			es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesData = null;
			if(niriOidNiveRies != null && !niriOidNiveRies.trim().equals("")){
				niriOidNiveRiesData = new es.indra.belcorp.mso.CarNivelRiesgData();
				niriOidNiveRiesData.setId(new Integer(niriOidNiveRies));
			}
			carAsignCodigConfiFrom.setNiriOidNiveRies(niriOidNiveRiesData);
			
			es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesIniciData = null;
			if(niriOidNiveRiesInici != null && !niriOidNiveRiesInici.trim().equals("")){
				niriOidNiveRiesIniciData = new es.indra.belcorp.mso.CarNivelRiesgData();
				niriOidNiveRiesIniciData.setId(new Integer(niriOidNiveRiesInici));
			}
			carAsignCodigConfiFrom.setNiriOidNiveRiesInici(niriOidNiveRiesIniciData);
			
			es.indra.belcorp.mso.CarParamCarteData pacaOidParaCartData = null;
			if(pacaOidParaCart != null && !pacaOidParaCart.trim().equals("")){
				pacaOidParaCartData = new es.indra.belcorp.mso.CarParamCarteData();
				pacaOidParaCartData.setId(new Integer(pacaOidParaCart));
			}
			carAsignCodigConfiFrom.setPacaOidParaCart(pacaOidParaCartData);
			carAsignCodigConfiFrom.setValLineCredInic(
				(java.lang.Double)FormatUtils.parseObject(valLineCredInic, "java.lang.Double", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			carAsignCodigConfiTo = (CarAsignCodigConfiData)carAsignCodigConfiFrom.clone();
			
			
			
			
			
			
			
			
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, carAsignCodigConfiFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, carAsignCodigConfiTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("carAsignCodigConfiFrom", carAsignCodigConfiFrom);
			dto.addProperty("carAsignCodigConfiTo", carAsignCodigConfiTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CarAsignCodigConfi");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CarAsignCodigConfi");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}





