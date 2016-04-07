

/*
    INDRA/CAR/mmg
    $Id: PedTipoSolicPaisTransactionQuery.java,v 1.1 2009/12/03 18:42:26 pecbazalar Exp $
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
public class PedTipoSolicPaisTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPedTipoSolicPaisQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "PedTipoSolicPaisConectorQueryList";

	// Definicion del constructor
	public PedTipoSolicPaisTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad PedTipoSolicPais");
			String tsolOidTipoSoli = (String)getEntrada("tsolOidTipoSoli");
			traza("MMG:: Valor de atributo tsolOidTipoSoli: " + tsolOidTipoSoli);
			String numSoliLote = (String)getEntrada("numSoliLote");
			traza("MMG:: Valor de atributo numSoliLote: " + numSoliLote);
			String numUnidAlar = (String)getEntrada("numUnidAlar");
			traza("MMG:: Valor de atributo numUnidAlar: " + numUnidAlar);
			String fopaOidFormPago = (String)getEntrada("fopaOidFormPago");
			traza("MMG:: Valor de atributo fopaOidFormPago: " + fopaOidFormPago);
			String indSujeFlet = (String)getEntrada("indSujeFlet");
			traza("MMG:: Valor de atributo indSujeFlet: " + indSujeFlet);
			String indReseStoc = (String)getEntrada("indReseStoc");
			traza("MMG:: Valor de atributo indReseStoc: " + indReseStoc);
			String indPermReve = (String)getEntrada("indPermReve");
			traza("MMG:: Valor de atributo indPermReve: " + indPermReve);
			String indPediPrue = (String)getEntrada("indPediPrue");
			traza("MMG:: Valor de atributo indPediPrue: " + indPediPrue);
			String indComi = (String)getEntrada("indComi");
			traza("MMG:: Valor de atributo indComi: " + indComi);
			String indVentInteSab14 = (String)getEntrada("indVentInteSab14");
			traza("MMG:: Valor de atributo indVentInteSab14: " + indVentInteSab14);
			String cactOidActi = (String)getEntrada("cactOidActi");
			traza("MMG:: Valor de atributo cactOidActi: " + cactOidActi);
			String moneOidMone = (String)getEntrada("moneOidMone");
			traza("MMG:: Valor de atributo moneOidMone: " + moneOidMone);
			String tmalOidTipoMoviAsig = (String)getEntrada("tmalOidTipoMoviAsig");
			traza("MMG:: Valor de atributo tmalOidTipoMoviAsig: " + tmalOidTipoMoviAsig);
			String tmalOidTipoMoviRese = (String)getEntrada("tmalOidTipoMoviRese");
			traza("MMG:: Valor de atributo tmalOidTipoMoviRese: " + tmalOidTipoMoviRese);
			String tmalOidTipoMoviFact = (String)getEntrada("tmalOidTipoMoviFact");
			traza("MMG:: Valor de atributo tmalOidTipoMoviFact: " + tmalOidTipoMoviFact);
			String tidoOidTipoDocu = (String)getEntrada("tidoOidTipoDocu");
			traza("MMG:: Valor de atributo tidoOidTipoDocu: " + tidoOidTipoDocu);
			String indPermUnio = (String)getEntrada("indPermUnio");
			traza("MMG:: Valor de atributo indPermUnio: " + indPermUnio);
			String indPediGtZona = (String)getEntrada("indPediGtZona");
			traza("MMG:: Valor de atributo indPediGtZona: " + indPediGtZona);
			String indCambVentBel = (String)getEntrada("indCambVentBel");
			traza("MMG:: Valor de atributo indCambVentBel: " + indCambVentBel);
			String almcOidAlma = (String)getEntrada("almcOidAlma");
			traza("MMG:: Valor de atributo almcOidAlma: " + almcOidAlma);
			String sociOidSoci = (String)getEntrada("sociOidSoci");
			traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
			String valGlos = (String)getEntrada("valGlos");
			traza("MMG:: Valor de atributo valGlos: " + valGlos);
			String tsolOidTipoCons = (String)getEntrada("tsolOidTipoCons");
			traza("MMG:: Valor de atributo tsolOidTipoCons: " + tsolOidTipoCons);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PedTipoSolicPaisData pedTipoSolicPaisFrom =new PedTipoSolicPaisData();
			PedTipoSolicPaisData pedTipoSolicPaisTo = new PedTipoSolicPaisData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.PedTipoSolicViewData tsolOidTipoSoliData = null;
			if(tsolOidTipoSoli != null && !tsolOidTipoSoli.trim().equals("")){
				tsolOidTipoSoliData = new es.indra.belcorp.mso.PedTipoSolicViewData();
				tsolOidTipoSoliData.setId(new Long(tsolOidTipoSoli));
			}
			pedTipoSolicPaisFrom.setTsolOidTipoSoli(tsolOidTipoSoliData);
			pedTipoSolicPaisFrom.setNumSoliLote(
				(java.lang.Long)FormatUtils.parseObject(numSoliLote, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedTipoSolicPaisFrom.setNumUnidAlar(
				(java.lang.Long)FormatUtils.parseObject(numUnidAlar, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.BelFormaPagoData fopaOidFormPagoData = null;
			if(fopaOidFormPago != null && !fopaOidFormPago.trim().equals("")){
				fopaOidFormPagoData = new es.indra.belcorp.mso.BelFormaPagoData();
				fopaOidFormPagoData.setId(new Long(fopaOidFormPago));
			}
			pedTipoSolicPaisFrom.setFopaOidFormPago(fopaOidFormPagoData);
			pedTipoSolicPaisFrom.setIndSujeFlet(
				(java.lang.Long)FormatUtils.parseObject(indSujeFlet, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedTipoSolicPaisFrom.setIndReseStoc(
				(java.lang.Long)FormatUtils.parseObject(indReseStoc, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedTipoSolicPaisFrom.setIndPermReve(
				(java.lang.Long)FormatUtils.parseObject(indPermReve, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedTipoSolicPaisFrom.setIndPediPrue(
				(java.lang.Long)FormatUtils.parseObject(indPediPrue, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedTipoSolicPaisFrom.setIndComi(
				(java.lang.Long)FormatUtils.parseObject(indComi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedTipoSolicPaisFrom.setIndVentInteSab14(
				(java.lang.Long)FormatUtils.parseObject(indVentInteSab14, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.CraActivData cactOidActiData = null;
			if(cactOidActi != null && !cactOidActi.trim().equals("")){
				cactOidActiData = new es.indra.belcorp.mso.CraActivData();
				cactOidActiData.setId(new Long(cactOidActi));
			}
			pedTipoSolicPaisFrom.setCactOidActi(cactOidActiData);
			es.indra.belcorp.mso.SegMonedData moneOidMoneData = null;
			if(moneOidMone != null && !moneOidMone.trim().equals("")){
				moneOidMoneData = new es.indra.belcorp.mso.SegMonedData();
				moneOidMoneData.setId(new Long(moneOidMone));
			}
			pedTipoSolicPaisFrom.setMoneOidMone(moneOidMoneData);
			es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviAsigData = null;
			if(tmalOidTipoMoviAsig != null && !tmalOidTipoMoviAsig.trim().equals("")){
				tmalOidTipoMoviAsigData = new es.indra.belcorp.mso.BelTipoMovimAlmacData();
				tmalOidTipoMoviAsigData.setId(new Long(tmalOidTipoMoviAsig));
			}
			pedTipoSolicPaisFrom.setTmalOidTipoMoviAsig(tmalOidTipoMoviAsigData);
			es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviReseData = null;
			if(tmalOidTipoMoviRese != null && !tmalOidTipoMoviRese.trim().equals("")){
				tmalOidTipoMoviReseData = new es.indra.belcorp.mso.BelTipoMovimAlmacData();
				tmalOidTipoMoviReseData.setId(new Long(tmalOidTipoMoviRese));
			}
			pedTipoSolicPaisFrom.setTmalOidTipoMoviRese(tmalOidTipoMoviReseData);
			es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviFactData = null;
			if(tmalOidTipoMoviFact != null && !tmalOidTipoMoviFact.trim().equals("")){
				tmalOidTipoMoviFactData = new es.indra.belcorp.mso.BelTipoMovimAlmacData();
				tmalOidTipoMoviFactData.setId(new Long(tmalOidTipoMoviFact));
			}
			pedTipoSolicPaisFrom.setTmalOidTipoMoviFact(tmalOidTipoMoviFactData);
			es.indra.belcorp.mso.FacTipoDocumData tidoOidTipoDocuData = null;
			if(tidoOidTipoDocu != null && !tidoOidTipoDocu.trim().equals("")){
				tidoOidTipoDocuData = new es.indra.belcorp.mso.FacTipoDocumData();
				tidoOidTipoDocuData.setId(new Long(tidoOidTipoDocu));
			}
			pedTipoSolicPaisFrom.setTidoOidTipoDocu(tidoOidTipoDocuData);
			pedTipoSolicPaisFrom.setIndPermUnio(
				(java.lang.Long)FormatUtils.parseObject(indPermUnio, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedTipoSolicPaisFrom.setIndPediGtZona(
				(java.lang.Long)FormatUtils.parseObject(indPediGtZona, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedTipoSolicPaisFrom.setIndCambVentBel(
				(java.lang.Long)FormatUtils.parseObject(indCambVentBel, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.BelAlmacData almcOidAlmaData = null;
			if(almcOidAlma != null && !almcOidAlma.trim().equals("")){
				almcOidAlmaData = new es.indra.belcorp.mso.BelAlmacData();
				almcOidAlmaData.setId(new Long(almcOidAlma));
			}
			pedTipoSolicPaisFrom.setAlmcOidAlma(almcOidAlmaData);
			es.indra.belcorp.mso.SegSocieData sociOidSociData = null;
			if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
				sociOidSociData = new es.indra.belcorp.mso.SegSocieData();
				sociOidSociData.setId(new Long(sociOidSoci));
			}
			pedTipoSolicPaisFrom.setSociOidSoci(sociOidSociData);
			pedTipoSolicPaisFrom.setValGlos(
				(java.lang.String)FormatUtils.parseObject(valGlos, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.PedTipoSolicPaisViewData tsolOidTipoConsData = null;
			if(tsolOidTipoCons != null && !tsolOidTipoCons.trim().equals("")){
				tsolOidTipoConsData = new es.indra.belcorp.mso.PedTipoSolicPaisViewData();
				tsolOidTipoConsData.setId(new Long(tsolOidTipoCons));
			}
			pedTipoSolicPaisFrom.setTsolOidTipoCons(tsolOidTipoConsData);
			
			
			//Construimos el to
			pedTipoSolicPaisTo = (PedTipoSolicPaisData)pedTipoSolicPaisFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, pedTipoSolicPaisFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, pedTipoSolicPaisTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("pedTipoSolicPaisFrom", pedTipoSolicPaisFrom);
			dto.addProperty("pedTipoSolicPaisTo", pedTipoSolicPaisTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(pedTipoSolicPaisFrom, pedTipoSolicPaisTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PedTipoSolicPais");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PedTipoSolicPais");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(pedTipoSolicPaisFrom, pedTipoSolicPaisTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(PedTipoSolicPaisData pedTipoSolicPaisFrom, PedTipoSolicPaisData pedTipoSolicPaisTo) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                pedTipoSolicPaisFrom.setPaisOidPais(paisOculto);
                pedTipoSolicPaisTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
			
	}
	
	
	public void cmdPostQuery(PedTipoSolicPaisData pedTipoSolicPaisFrom, PedTipoSolicPaisData pedTipoSolicPaisTo, DruidaConector result) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                pedTipoSolicPaisFrom.setPaisOidPais(paisOculto);
                pedTipoSolicPaisTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
			
	}
	
	
}





