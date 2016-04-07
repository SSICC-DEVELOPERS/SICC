

/*
    INDRA/CAR/mmg
    $Id: BelParamBelceTransactionQuery.java,v 1.1 2009/12/03 18:36:26 pecbazalar Exp $
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
public class BelParamBelceTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGBelParamBelceQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "BelParamBelceConectorQueryList";

	// Definicion del constructor
	public BelParamBelceTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad BelParamBelce");
			String sbacOidSbac = (String)getEntrada("sbacOidSbac");
			traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
			String valDire = (String)getEntrada("valDire");
			traza("MMG:: Valor de atributo valDire: " + valDire);
			String valTfno = (String)getEntrada("valTfno");
			traza("MMG:: Valor de atributo valTfno: " + valTfno);
			String valMontMaxiDife = (String)getEntrada("valMontMaxiDife");
			traza("MMG:: Valor de atributo valMontMaxiDife: " + valMontMaxiDife);
			String valLimiEfecCaja = (String)getEntrada("valLimiEfecCaja");
			traza("MMG:: Valor de atributo valLimiEfecCaja: " + valLimiEfecCaja);
			String numCaja = (String)getEntrada("numCaja");
			traza("MMG:: Valor de atributo numCaja: " + numCaja);
			String valNombLoca = (String)getEntrada("valNombLoca");
			traza("MMG:: Valor de atributo valNombLoca: " + valNombLoca);
			String valTiempRepo = (String)getEntrada("valTiempRepo");
			traza("MMG:: Valor de atributo valTiempRepo: " + valTiempRepo);
			String valFactLoca = (String)getEntrada("valFactLoca");
			traza("MMG:: Valor de atributo valFactLoca: " + valFactLoca);
			String numMaxiProd = (String)getEntrada("numMaxiProd");
			traza("MMG:: Valor de atributo numMaxiProd: " + numMaxiProd);
			String valAlerStoc = (String)getEntrada("valAlerStoc");
			traza("MMG:: Valor de atributo valAlerStoc: " + valAlerStoc);
			String valUsua = (String)getEntrada("valUsua");
			traza("MMG:: Valor de atributo valUsua: " + valUsua);
			String clieOidClie = (String)getEntrada("clieOidClie");
			traza("MMG:: Valor de atributo clieOidClie: " + clieOidClie);
			String sociOidSoci = (String)getEntrada("sociOidSoci");
			traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
			String ttraOidTipoTran = (String)getEntrada("ttraOidTipoTran");
			traza("MMG:: Valor de atributo ttraOidTipoTran: " + ttraOidTipoTran);
			String ccbaOidCuenCorrBanc = (String)getEntrada("ccbaOidCuenCorrBanc");
			traza("MMG:: Valor de atributo ccbaOidCuenCorrBanc: " + ccbaOidCuenCorrBanc);
			String tmvcOidCobr = (String)getEntrada("tmvcOidCobr");
			traza("MMG:: Valor de atributo tmvcOidCobr: " + tmvcOidCobr);
			String tmvcOidCier = (String)getEntrada("tmvcOidCier");
			traza("MMG:: Valor de atributo tmvcOidCier: " + tmvcOidCier);
			String tmalOidConfStoc = (String)getEntrada("tmalOidConfStoc");
			traza("MMG:: Valor de atributo tmalOidConfStoc: " + tmalOidConfStoc);
			String tmalOidConfStocTran = (String)getEntrada("tmalOidConfStocTran");
			traza("MMG:: Valor de atributo tmalOidConfStocTran: " + tmalOidConfStocTran);
			String tmalOidStocTran = (String)getEntrada("tmalOidStocTran");
			traza("MMG:: Valor de atributo tmalOidStocTran: " + tmalOidStocTran);
			String tmalOidStocDevo = (String)getEntrada("tmalOidStocDevo");
			traza("MMG:: Valor de atributo tmalOidStocDevo: " + tmalOidStocDevo);
			String tmalOidRegu = (String)getEntrada("tmalOidRegu");
			traza("MMG:: Valor de atributo tmalOidRegu: " + tmalOidRegu);
			String tmalOidReguSap = (String)getEntrada("tmalOidReguSap");
			traza("MMG:: Valor de atributo tmalOidReguSap: " + tmalOidReguSap);
			String tmalOidDevoStoc = (String)getEntrada("tmalOidDevoStoc");
			traza("MMG:: Valor de atributo tmalOidDevoStoc: " + tmalOidDevoStoc);
			String tmalOidPetiExis = (String)getEntrada("tmalOidPetiExis");
			traza("MMG:: Valor de atributo tmalOidPetiExis: " + tmalOidPetiExis);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			BelParamBelceData belParamBelceFrom =new BelParamBelceData();
			BelParamBelceData belParamBelceTo = new BelParamBelceData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
			if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
				sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
				sbacOidSbacData.setId(new Long(sbacOidSbac));
			}
			belParamBelceFrom.setSbacOidSbac(sbacOidSbacData);
			belParamBelceFrom.setValDire(
				(java.lang.String)FormatUtils.parseObject(valDire, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belParamBelceFrom.setValTfno(
				(java.lang.String)FormatUtils.parseObject(valTfno, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belParamBelceFrom.setValMontMaxiDife(
				(java.lang.Double)FormatUtils.parseObject(valMontMaxiDife, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belParamBelceFrom.setValLimiEfecCaja(
				(java.lang.Double)FormatUtils.parseObject(valLimiEfecCaja, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belParamBelceFrom.setNumCaja(
				(java.lang.Long)FormatUtils.parseObject(numCaja, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belParamBelceFrom.setValNombLoca(
				(java.lang.String)FormatUtils.parseObject(valNombLoca, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belParamBelceFrom.setValTiempRepo(
				(java.lang.Long)FormatUtils.parseObject(valTiempRepo, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belParamBelceFrom.setValFactLoca(
				(java.lang.Double)FormatUtils.parseObject(valFactLoca, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belParamBelceFrom.setNumMaxiProd(
				(java.lang.Long)FormatUtils.parseObject(numMaxiProd, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belParamBelceFrom.setValAlerStoc(
				(java.lang.Long)FormatUtils.parseObject(valAlerStoc, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belParamBelceFrom.setValUsua(
				(java.lang.String)FormatUtils.parseObject(valUsua, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.MaeClienViewData clieOidClieData = null;
			if(clieOidClie != null && !clieOidClie.trim().equals("")){
				clieOidClieData = new es.indra.belcorp.mso.MaeClienViewData();
				clieOidClieData.setId(new Long(clieOidClie));
			}
			belParamBelceFrom.setClieOidClie(clieOidClieData);
			es.indra.belcorp.mso.SegSocieViewData sociOidSociData = null;
			if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
				sociOidSociData = new es.indra.belcorp.mso.SegSocieViewData();
				sociOidSociData.setId(new Long(sociOidSoci));
			}
			belParamBelceFrom.setSociOidSoci(sociOidSociData);
			es.indra.belcorp.mso.CccTipoTransViewData ttraOidTipoTranData = null;
			if(ttraOidTipoTran != null && !ttraOidTipoTran.trim().equals("")){
				ttraOidTipoTranData = new es.indra.belcorp.mso.CccTipoTransViewData();
				ttraOidTipoTranData.setId(new Long(ttraOidTipoTran));
			}
			belParamBelceFrom.setTtraOidTipoTran(ttraOidTipoTranData);
			es.indra.belcorp.mso.CccCuentCorriBancaData ccbaOidCuenCorrBancData = null;
			if(ccbaOidCuenCorrBanc != null && !ccbaOidCuenCorrBanc.trim().equals("")){
				ccbaOidCuenCorrBancData = new es.indra.belcorp.mso.CccCuentCorriBancaData();
				ccbaOidCuenCorrBancData.setId(new Long(ccbaOidCuenCorrBanc));
			}
			belParamBelceFrom.setCcbaOidCuenCorrBanc(ccbaOidCuenCorrBancData);
			es.indra.belcorp.mso.BelTipoMovimCajaData tmvcOidCobrData = null;
			if(tmvcOidCobr != null && !tmvcOidCobr.trim().equals("")){
				tmvcOidCobrData = new es.indra.belcorp.mso.BelTipoMovimCajaData();
				tmvcOidCobrData.setId(new Long(tmvcOidCobr));
			}
			belParamBelceFrom.setTmvcOidCobr(tmvcOidCobrData);
			es.indra.belcorp.mso.BelTipoMovimCajaData tmvcOidCierData = null;
			if(tmvcOidCier != null && !tmvcOidCier.trim().equals("")){
				tmvcOidCierData = new es.indra.belcorp.mso.BelTipoMovimCajaData();
				tmvcOidCierData.setId(new Long(tmvcOidCier));
			}
			belParamBelceFrom.setTmvcOidCier(tmvcOidCierData);
			es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidConfStocData = null;
			if(tmalOidConfStoc != null && !tmalOidConfStoc.trim().equals("")){
				tmalOidConfStocData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
				tmalOidConfStocData.setId(new Long(tmalOidConfStoc));
			}
			belParamBelceFrom.setTmalOidConfStoc(tmalOidConfStocData);
			es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidConfStocTranData = null;
			if(tmalOidConfStocTran != null && !tmalOidConfStocTran.trim().equals("")){
				tmalOidConfStocTranData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
				tmalOidConfStocTranData.setId(new Long(tmalOidConfStocTran));
			}
			belParamBelceFrom.setTmalOidConfStocTran(tmalOidConfStocTranData);
			es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidStocTranData = null;
			if(tmalOidStocTran != null && !tmalOidStocTran.trim().equals("")){
				tmalOidStocTranData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
				tmalOidStocTranData.setId(new Long(tmalOidStocTran));
			}
			belParamBelceFrom.setTmalOidStocTran(tmalOidStocTranData);
			es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidStocDevoData = null;
			if(tmalOidStocDevo != null && !tmalOidStocDevo.trim().equals("")){
				tmalOidStocDevoData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
				tmalOidStocDevoData.setId(new Long(tmalOidStocDevo));
			}
			belParamBelceFrom.setTmalOidStocDevo(tmalOidStocDevoData);
			es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidReguData = null;
			if(tmalOidRegu != null && !tmalOidRegu.trim().equals("")){
				tmalOidReguData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
				tmalOidReguData.setId(new Long(tmalOidRegu));
			}
			belParamBelceFrom.setTmalOidRegu(tmalOidReguData);
			es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidReguSapData = null;
			if(tmalOidReguSap != null && !tmalOidReguSap.trim().equals("")){
				tmalOidReguSapData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
				tmalOidReguSapData.setId(new Long(tmalOidReguSap));
			}
			belParamBelceFrom.setTmalOidReguSap(tmalOidReguSapData);
			es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidDevoStocData = null;
			if(tmalOidDevoStoc != null && !tmalOidDevoStoc.trim().equals("")){
				tmalOidDevoStocData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
				tmalOidDevoStocData.setId(new Long(tmalOidDevoStoc));
			}
			belParamBelceFrom.setTmalOidDevoStoc(tmalOidDevoStocData);
			es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidPetiExisData = null;
			if(tmalOidPetiExis != null && !tmalOidPetiExis.trim().equals("")){
				tmalOidPetiExisData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
				tmalOidPetiExisData.setId(new Long(tmalOidPetiExis));
			}
			belParamBelceFrom.setTmalOidPetiExis(tmalOidPetiExisData);
			
			
			//Construimos el to
			belParamBelceTo = (BelParamBelceData)belParamBelceFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, belParamBelceFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, belParamBelceTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("belParamBelceFrom", belParamBelceFrom);
			dto.addProperty("belParamBelceTo", belParamBelceTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(belParamBelceFrom, belParamBelceTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad BelParamBelce");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad BelParamBelce");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(belParamBelceFrom, belParamBelceTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(BelParamBelceData belParamBelceFrom, BelParamBelceData belParamBelceTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				belParamBelceFrom.setPaisOidPais(paisOculto);
				belParamBelceTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(BelParamBelceData belParamBelceFrom, BelParamBelceData belParamBelceTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				belParamBelceFrom.setPaisOidPais(paisOculto);
				belParamBelceTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





