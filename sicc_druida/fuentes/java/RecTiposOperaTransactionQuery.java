

/*
    INDRA/CAR/mmg
    $Id: RecTiposOperaTransactionQuery.java,v 1.1 2009/12/03 18:35:38 pecbazalar Exp $
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
public class RecTiposOperaTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGRecTiposOperaQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "RecTiposOperaConectorQueryList";

	// Definicion del constructor
	public RecTiposOperaTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad RecTiposOpera");
			String valTipoOper = (String)getEntrada("valTipoOper");
			traza("MMG:: Valor de atributo valTipoOper: " + valTipoOper);
			String indCampRefeUnic = (String)getEntrada("indCampRefeUnic");
			traza("MMG:: Valor de atributo indCampRefeUnic: " + indCampRefeUnic);
			String numDiasHaciAtra = (String)getEntrada("numDiasHaciAtra");
			traza("MMG:: Valor de atributo numDiasHaciAtra: " + numDiasHaciAtra);
			String valInfoEbelNoti = (String)getEntrada("valInfoEbelNoti");
			traza("MMG:: Valor de atributo valInfoEbelNoti: " + valInfoEbelNoti);
			String indDevuEstaFact = (String)getEntrada("indDevuEstaFact");
			traza("MMG:: Valor de atributo indDevuEstaFact: " + indDevuEstaFact);
			String indEnviEstaFact = (String)getEntrada("indEnviEstaFact");
			traza("MMG:: Valor de atributo indEnviEstaFact: " + indEnviEstaFact);
			String ropeOidOper = (String)getEntrada("ropeOidOper");
			traza("MMG:: Valor de atributo ropeOidOper: " + ropeOidOper);
			String mrdbOidMotiRechDesb = (String)getEntrada("mrdbOidMotiRechDesb");
			traza("MMG:: Valor de atributo mrdbOidMotiRechDesb: " + mrdbOidMotiRechDesb);
			String moblOidBloqDife = (String)getEntrada("moblOidBloqDife");
			traza("MMG:: Valor de atributo moblOidBloqDife: " + moblOidBloqDife);
			String moblOidReclAnte = (String)getEntrada("moblOidReclAnte");
			traza("MMG:: Valor de atributo moblOidReclAnte: " + moblOidReclAnte);
			String moblOidBloqImpo = (String)getEntrada("moblOidBloqImpo");
			traza("MMG:: Valor de atributo moblOidBloqImpo: " + moblOidBloqImpo);
			String moblOidBloqUnid = (String)getEntrada("moblOidBloqUnid");
			traza("MMG:: Valor de atributo moblOidBloqUnid: " + moblOidBloqUnid);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			RecTiposOperaData recTiposOperaFrom =new RecTiposOperaData();
			RecTiposOperaData recTiposOperaTo = new RecTiposOperaData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			recTiposOperaFrom.setValTipoOper(
				(java.lang.String)FormatUtils.parseObject(valTipoOper, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recTiposOperaFrom.setIndCampRefeUnic(
				(java.lang.Long)FormatUtils.parseObject(indCampRefeUnic, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recTiposOperaFrom.setNumDiasHaciAtra(
				(java.lang.Long)FormatUtils.parseObject(numDiasHaciAtra, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recTiposOperaFrom.setValInfoEbelNoti(
				(java.lang.Long)FormatUtils.parseObject(valInfoEbelNoti, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recTiposOperaFrom.setIndDevuEstaFact(
				(java.lang.Long)FormatUtils.parseObject(indDevuEstaFact, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recTiposOperaFrom.setIndEnviEstaFact(
				(java.lang.Long)FormatUtils.parseObject(indEnviEstaFact, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.RecOperaData ropeOidOperData = null;
			if(ropeOidOper != null && !ropeOidOper.trim().equals("")){
				ropeOidOperData = new es.indra.belcorp.mso.RecOperaData();
				ropeOidOperData.setId(new Long(ropeOidOper));
			}
			recTiposOperaFrom.setRopeOidOper(ropeOidOperData);
			es.indra.belcorp.mso.RecMotivRechaDesblData mrdbOidMotiRechDesbData = null;
			if(mrdbOidMotiRechDesb != null && !mrdbOidMotiRechDesb.trim().equals("")){
				mrdbOidMotiRechDesbData = new es.indra.belcorp.mso.RecMotivRechaDesblData();
				mrdbOidMotiRechDesbData.setId(new Long(mrdbOidMotiRechDesb));
			}
			recTiposOperaFrom.setMrdbOidMotiRechDesb(mrdbOidMotiRechDesbData);
			es.indra.belcorp.mso.RecMotivBloquData moblOidBloqDifeData = null;
			if(moblOidBloqDife != null && !moblOidBloqDife.trim().equals("")){
				moblOidBloqDifeData = new es.indra.belcorp.mso.RecMotivBloquData();
				moblOidBloqDifeData.setId(new Long(moblOidBloqDife));
			}
			recTiposOperaFrom.setMoblOidBloqDife(moblOidBloqDifeData);
			es.indra.belcorp.mso.RecMotivBloquData moblOidReclAnteData = null;
			if(moblOidReclAnte != null && !moblOidReclAnte.trim().equals("")){
				moblOidReclAnteData = new es.indra.belcorp.mso.RecMotivBloquData();
				moblOidReclAnteData.setId(new Long(moblOidReclAnte));
			}
			recTiposOperaFrom.setMoblOidReclAnte(moblOidReclAnteData);
			es.indra.belcorp.mso.RecMotivBloquData moblOidBloqImpoData = null;
			if(moblOidBloqImpo != null && !moblOidBloqImpo.trim().equals("")){
				moblOidBloqImpoData = new es.indra.belcorp.mso.RecMotivBloquData();
				moblOidBloqImpoData.setId(new Long(moblOidBloqImpo));
			}
			recTiposOperaFrom.setMoblOidBloqImpo(moblOidBloqImpoData);
			es.indra.belcorp.mso.RecMotivBloquData moblOidBloqUnidData = null;
			if(moblOidBloqUnid != null && !moblOidBloqUnid.trim().equals("")){
				moblOidBloqUnidData = new es.indra.belcorp.mso.RecMotivBloquData();
				moblOidBloqUnidData.setId(new Long(moblOidBloqUnid));
			}
			recTiposOperaFrom.setMoblOidBloqUnid(moblOidBloqUnidData);
			
			
			//Construimos el to
			recTiposOperaTo = (RecTiposOperaData)recTiposOperaFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, recTiposOperaFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, recTiposOperaTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("recTiposOperaFrom", recTiposOperaFrom);
			dto.addProperty("recTiposOperaTo", recTiposOperaTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad RecTiposOpera");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad RecTiposOpera");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





