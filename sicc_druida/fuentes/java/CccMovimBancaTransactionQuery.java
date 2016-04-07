

/*
    INDRA/CAR/mmg
    $Id: CccMovimBancaTransactionQuery.java,v 1.1 2009/12/03 18:42:55 pecbazalar Exp $
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
public class CccMovimBancaTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCccMovimBancaQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CccMovimBancaConectorQueryList";

	// Definicion del constructor
	public CccMovimBancaTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CccMovimBanca");
			
			String sociOidSoci = (String)getEntrada("sociOidSoci");
			traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
			
			
			String subpOidMarcUlti = (String)getEntrada("subpOidMarcUlti");
			traza("MMG:: Valor de atributo subpOidMarcUlti: " + subpOidMarcUlti);
			
			
			String subpOidMarcCrea = (String)getEntrada("subpOidMarcCrea");
			traza("MMG:: Valor de atributo subpOidMarcCrea: " + subpOidMarcCrea);
			
			
			String tcabOidAbonUlti = (String)getEntrada("tcabOidAbonUlti");
			traza("MMG:: Valor de atributo tcabOidAbonUlti: " + tcabOidAbonUlti);
			
			
			String tcabOidAbonCrea = (String)getEntrada("tcabOidAbonCrea");
			traza("MMG:: Valor de atributo tcabOidAbonCrea: " + tcabOidAbonCrea);
			
			
			String ttraOidTipoTrans = (String)getEntrada("ttraOidTipoTrans");
			traza("MMG:: Valor de atributo ttraOidTipoTrans: " + ttraOidTipoTrans);
			
			
			String ccbaOidCcBanc = (String)getEntrada("ccbaOidCcBanc");
			traza("MMG:: Valor de atributo ccbaOidCcBanc: " + ccbaOidCcBanc);
			
			
			String numConsTran = (String)getEntrada("numConsTran");
			traza("MMG:: Valor de atributo numConsTran: " + numConsTran);
			
			
			String numLote = (String)getEntrada("numLote");
			traza("MMG:: Valor de atributo numLote: " + numLote);
			
			
			String codCons = (String)getEntrada("codCons");
			traza("MMG:: Valor de atributo codCons: " + codCons);
			
			
			String codConsReal = (String)getEntrada("codConsReal");
			traza("MMG:: Valor de atributo codConsReal: " + codConsReal);
			
			
			String codErro = (String)getEntrada("codErro");
			traza("MMG:: Valor de atributo codErro: " + codErro);
			
			
			String valDigiCheqFact = (String)getEntrada("valDigiCheqFact");
			traza("MMG:: Valor de atributo valDigiCheqFact: " + valDigiCheqFact);
			
			
			String valDocuApliAnio = (String)getEntrada("valDocuApliAnio");
			traza("MMG:: Valor de atributo valDocuApliAnio: " + valDocuApliAnio);
			
			
			String valDocuApliMesSeri = (String)getEntrada("valDocuApliMesSeri");
			traza("MMG:: Valor de atributo valDocuApliMesSeri: " + valDocuApliMesSeri);
			
			
			String valDocuApliNume = (String)getEntrada("valDocuApliNume");
			traza("MMG:: Valor de atributo valDocuApliNume: " + valDocuApliNume);
			
			
			String valDocuCreaAnio = (String)getEntrada("valDocuCreaAnio");
			traza("MMG:: Valor de atributo valDocuCreaAnio: " + valDocuCreaAnio);
			
			
			String valDocuCreaMesSeri = (String)getEntrada("valDocuCreaMesSeri");
			traza("MMG:: Valor de atributo valDocuCreaMesSeri: " + valDocuCreaMesSeri);
			
			
			String valDocuCreaNume = (String)getEntrada("valDocuCreaNume");
			traza("MMG:: Valor de atributo valDocuCreaNume: " + valDocuCreaNume);
			
			
			String valEstaMoviPend = (String)getEntrada("valEstaMoviPend");
			traza("MMG:: Valor de atributo valEstaMoviPend: " + valEstaMoviPend);
			
			
			String fecCont = (String)getEntrada("fecCont");
			traza("MMG:: Valor de atributo fecCont: " + fecCont);
			
			
			String fecPago = (String)getEntrada("fecPago");
			traza("MMG:: Valor de atributo fecPago: " + fecPago);
			
			
			String fecProc = (String)getEntrada("fecProc");
			traza("MMG:: Valor de atributo fecProc: " + fecProc);
			
			
			String valHoraProc = (String)getEntrada("valHoraProc");
			traza("MMG:: Valor de atributo valHoraProc: " + valHoraProc);
			
			
			String valHoraNormAdic = (String)getEntrada("valHoraNormAdic");
			traza("MMG:: Valor de atributo valHoraNormAdic: " + valHoraNormAdic);
			
			
			String codIdenProc = (String)getEntrada("codIdenProc");
			traza("MMG:: Valor de atributo codIdenProc: " + codIdenProc);
			
			
			String impPago = (String)getEntrada("impPago");
			traza("MMG:: Valor de atributo impPago: " + impPago);
			
			
			String valNombOfic = (String)getEntrada("valNombOfic");
			traza("MMG:: Valor de atributo valNombOfic: " + valNombOfic);
			
			
			String numCupo = (String)getEntrada("numCupo");
			traza("MMG:: Valor de atributo numCupo: " + numCupo);
			
			
			String valNumeDocu = (String)getEntrada("valNumeDocu");
			traza("MMG:: Valor de atributo valNumeDocu: " + valNumeDocu);
			
			
			String numFactBole = (String)getEntrada("numFactBole");
			traza("MMG:: Valor de atributo numFactBole: " + numFactBole);
			
			
			String valNumeLoteCont = (String)getEntrada("valNumeLoteCont");
			traza("MMG:: Valor de atributo valNumeLoteCont: " + valNumeLoteCont);
			
			
			String valObse = (String)getEntrada("valObse");
			traza("MMG:: Valor de atributo valObse: " + valObse);
			
			
			String codOficReca = (String)getEntrada("codOficReca");
			traza("MMG:: Valor de atributo codOficReca: " + codOficReca);
			
			
			String valUsuaProc = (String)getEntrada("valUsuaProc");
			traza("MMG:: Valor de atributo valUsuaProc: " + valUsuaProc);
			
			
			String fecMoviApli = (String)getEntrada("fecMoviApli");
			traza("MMG:: Valor de atributo fecMoviApli: " + fecMoviApli);
			
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CccMovimBancaData cccMovimBancaFrom =new CccMovimBancaData();
			CccMovimBancaData cccMovimBancaTo = new CccMovimBancaData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			
			es.indra.belcorp.mso.SegSocieData sociOidSociData = null;
			if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
				sociOidSociData = new es.indra.belcorp.mso.SegSocieData();
				sociOidSociData.setId(new Integer(sociOidSoci));
			}
			cccMovimBancaFrom.setSociOidSoci(sociOidSociData);
			
			es.indra.belcorp.mso.CccSubprData subpOidMarcUltiData = null;
			if(subpOidMarcUlti != null && !subpOidMarcUlti.trim().equals("")){
				subpOidMarcUltiData = new es.indra.belcorp.mso.CccSubprData();
				subpOidMarcUltiData.setId(new Integer(subpOidMarcUlti));
			}
			cccMovimBancaFrom.setSubpOidMarcUlti(subpOidMarcUltiData);
			
			es.indra.belcorp.mso.CccSubprData subpOidMarcCreaData = null;
			if(subpOidMarcCrea != null && !subpOidMarcCrea.trim().equals("")){
				subpOidMarcCreaData = new es.indra.belcorp.mso.CccSubprData();
				subpOidMarcCreaData.setId(new Integer(subpOidMarcCrea));
			}
			cccMovimBancaFrom.setSubpOidMarcCrea(subpOidMarcCreaData);
			
			es.indra.belcorp.mso.CccTipoCargoAbonoData tcabOidAbonUltiData = null;
			if(tcabOidAbonUlti != null && !tcabOidAbonUlti.trim().equals("")){
				tcabOidAbonUltiData = new es.indra.belcorp.mso.CccTipoCargoAbonoData();
				tcabOidAbonUltiData.setId(new Integer(tcabOidAbonUlti));
			}
			cccMovimBancaFrom.setTcabOidAbonUlti(tcabOidAbonUltiData);
			
			es.indra.belcorp.mso.CccTipoCargoAbonoData tcabOidAbonCreaData = null;
			if(tcabOidAbonCrea != null && !tcabOidAbonCrea.trim().equals("")){
				tcabOidAbonCreaData = new es.indra.belcorp.mso.CccTipoCargoAbonoData();
				tcabOidAbonCreaData.setId(new Integer(tcabOidAbonCrea));
			}
			cccMovimBancaFrom.setTcabOidAbonCrea(tcabOidAbonCreaData);
			
			es.indra.belcorp.mso.CccTipoTransData ttraOidTipoTransData = null;
			if(ttraOidTipoTrans != null && !ttraOidTipoTrans.trim().equals("")){
				ttraOidTipoTransData = new es.indra.belcorp.mso.CccTipoTransData();
				ttraOidTipoTransData.setId(new Integer(ttraOidTipoTrans));
			}
			cccMovimBancaFrom.setTtraOidTipoTrans(ttraOidTipoTransData);
			
			es.indra.belcorp.mso.CccCuentCorriBancaData ccbaOidCcBancData = null;
			if(ccbaOidCcBanc != null && !ccbaOidCcBanc.trim().equals("")){
				ccbaOidCcBancData = new es.indra.belcorp.mso.CccCuentCorriBancaData();
				ccbaOidCcBancData.setId(new Integer(ccbaOidCcBanc));
			}
			cccMovimBancaFrom.setCcbaOidCcBanc(ccbaOidCcBancData);
			cccMovimBancaFrom.setNumConsTran(
				(java.lang.Integer)FormatUtils.parseObject(numConsTran, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setNumLote(
				(java.lang.Integer)FormatUtils.parseObject(numLote, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setCodCons(
				(java.lang.String)FormatUtils.parseObject(codCons, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setCodConsReal(
				(java.lang.String)FormatUtils.parseObject(codConsReal, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setCodErro(
				(java.lang.String)FormatUtils.parseObject(codErro, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setValDigiCheqFact(
				(java.lang.Integer)FormatUtils.parseObject(valDigiCheqFact, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setValDocuApliAnio(
				(java.lang.String)FormatUtils.parseObject(valDocuApliAnio, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setValDocuApliMesSeri(
				(java.lang.String)FormatUtils.parseObject(valDocuApliMesSeri, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setValDocuApliNume(
				(java.lang.Integer)FormatUtils.parseObject(valDocuApliNume, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setValDocuCreaAnio(
				(java.lang.String)FormatUtils.parseObject(valDocuCreaAnio, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setValDocuCreaMesSeri(
				(java.lang.String)FormatUtils.parseObject(valDocuCreaMesSeri, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setValDocuCreaNume(
				(java.lang.Integer)FormatUtils.parseObject(valDocuCreaNume, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setValEstaMoviPend(
				(java.lang.String)FormatUtils.parseObject(valEstaMoviPend, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setFecCont(
				(java.sql.Date)FormatUtils.parseObject(fecCont, "java.sql.Date", 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setFecPago(
				(java.sql.Date)FormatUtils.parseObject(fecPago, "java.sql.Date", 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setFecProc(
				(java.lang.String)FormatUtils.parseObject(fecProc, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setValHoraProc(
				(java.lang.String)FormatUtils.parseObject(valHoraProc, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setValHoraNormAdic(
				(java.lang.String)FormatUtils.parseObject(valHoraNormAdic, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setCodIdenProc(
				(java.lang.String)FormatUtils.parseObject(codIdenProc, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setImpPago(
				(java.lang.Double)FormatUtils.parseObject(impPago, "java.lang.Double", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setValNombOfic(
				(java.lang.String)FormatUtils.parseObject(valNombOfic, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setNumCupo(
				(java.lang.Integer)FormatUtils.parseObject(numCupo, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setValNumeDocu(
				(java.lang.String)FormatUtils.parseObject(valNumeDocu, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setNumFactBole(
				(java.lang.Integer)FormatUtils.parseObject(numFactBole, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setValNumeLoteCont(
				(java.lang.String)FormatUtils.parseObject(valNumeLoteCont, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setValObse(
				(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setCodOficReca(
				(java.lang.Integer)FormatUtils.parseObject(codOficReca, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setValUsuaProc(
				(java.lang.String)FormatUtils.parseObject(valUsuaProc, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccMovimBancaFrom.setFecMoviApli(
				(java.sql.Date)FormatUtils.parseObject(fecMoviApli, "java.sql.Date", 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			cccMovimBancaTo = (CccMovimBancaData)cccMovimBancaFrom.clone();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cccMovimBancaFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cccMovimBancaTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cccMovimBancaFrom", cccMovimBancaFrom);
			dto.addProperty("cccMovimBancaTo", cccMovimBancaTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CccMovimBanca");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CccMovimBanca");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}





