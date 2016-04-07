

/*
    INDRA/CAR/mmg
    $Id: CccMovimBancaLPExecution.java,v 1.1 2009/12/03 18:33:55 pecbazalar Exp $
    DESC
*/

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.druida.belcorp.MMGDruidaBase;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.druida.belcorp.MMGException;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.i18n.Idioma;
import es.indra.utils.FormatUtils;
import es.indra.belcorp.mso.*;

public class CccMovimBancaLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCccMovimBancaCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCccMovimBancaUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCccMovimBancaRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCccMovimBancaQueryFromToUserPage";	
	public static final String CONECTOR_CREATE = "CccMovimBancaConectorCreate";
	public static final String CONECTOR_UPDATE = "CccMovimBancaConectorUpdate";
	public static final String CONECTOR_REMOVE = "CccMovimBancaConectorRemove";

	public CccMovimBancaLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CccMovimBancaPage");
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		//Activamos las trazas
		setTrazaFichero();
	
		try{
			//Sacamos la acción a realizar y ejecutamos la acción correspondiente
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			
			//Caragamos los elemetnos en la pagina
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
	
			//Ejecutamos la acción indicada
			if(accion.equals(ACCION_CREATE)) cmdCreate();
			if(accion.equals(ACCION_UPDATE)) cmdUpdate();
			if(accion.equals(ACCION_REMOVE)) cmdRemove();
		}catch(Exception e){
			handleException(e);
		}
  }
  
  /**Permite crear un nuevo elemento de la entidad. Invoca la lógica de negocio
  	correspondiente a la creación de un/a nuevo CccMovimBanca*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando CccMovimBanca");
		
		String sociOidSoci = conectorParametro("sociOidSoci").trim();
		traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
		
		String subpOidMarcUlti = conectorParametro("subpOidMarcUlti").trim();
		traza("MMG:: Valor de atributo subpOidMarcUlti: " + subpOidMarcUlti);
		
		String subpOidMarcCrea = conectorParametro("subpOidMarcCrea").trim();
		traza("MMG:: Valor de atributo subpOidMarcCrea: " + subpOidMarcCrea);
		
		String tcabOidAbonUlti = conectorParametro("tcabOidAbonUlti").trim();
		traza("MMG:: Valor de atributo tcabOidAbonUlti: " + tcabOidAbonUlti);
		
		String tcabOidAbonCrea = conectorParametro("tcabOidAbonCrea").trim();
		traza("MMG:: Valor de atributo tcabOidAbonCrea: " + tcabOidAbonCrea);
		
		String ttraOidTipoTrans = conectorParametro("ttraOidTipoTrans").trim();
		traza("MMG:: Valor de atributo ttraOidTipoTrans: " + ttraOidTipoTrans);
		
		String ccbaOidCcBanc = conectorParametro("ccbaOidCcBanc").trim();
		traza("MMG:: Valor de atributo ccbaOidCcBanc: " + ccbaOidCcBanc);
		
		String numConsTran = conectorParametro("numConsTran").trim();
		traza("MMG:: Valor de atributo numConsTran: " + numConsTran);
		
		String numLote = conectorParametro("numLote").trim();
		traza("MMG:: Valor de atributo numLote: " + numLote);
		
		String codCons = conectorParametro("codCons").trim();
		traza("MMG:: Valor de atributo codCons: " + codCons);
		
		String codConsReal = conectorParametro("codConsReal").trim();
		traza("MMG:: Valor de atributo codConsReal: " + codConsReal);
		
		String codErro = conectorParametro("codErro").trim();
		traza("MMG:: Valor de atributo codErro: " + codErro);
		
		String valDigiCheqFact = conectorParametro("valDigiCheqFact").trim();
		traza("MMG:: Valor de atributo valDigiCheqFact: " + valDigiCheqFact);
		
		String valDocuApliAnio = conectorParametro("valDocuApliAnio").trim();
		traza("MMG:: Valor de atributo valDocuApliAnio: " + valDocuApliAnio);
		
		String valDocuApliMesSeri = conectorParametro("valDocuApliMesSeri").trim();
		traza("MMG:: Valor de atributo valDocuApliMesSeri: " + valDocuApliMesSeri);
		
		String valDocuApliNume = conectorParametro("valDocuApliNume").trim();
		traza("MMG:: Valor de atributo valDocuApliNume: " + valDocuApliNume);
		
		String valDocuCreaAnio = conectorParametro("valDocuCreaAnio").trim();
		traza("MMG:: Valor de atributo valDocuCreaAnio: " + valDocuCreaAnio);
		
		String valDocuCreaMesSeri = conectorParametro("valDocuCreaMesSeri").trim();
		traza("MMG:: Valor de atributo valDocuCreaMesSeri: " + valDocuCreaMesSeri);
		
		String valDocuCreaNume = conectorParametro("valDocuCreaNume").trim();
		traza("MMG:: Valor de atributo valDocuCreaNume: " + valDocuCreaNume);
		
		String valEstaMoviPend = conectorParametro("valEstaMoviPend").trim();
		traza("MMG:: Valor de atributo valEstaMoviPend: " + valEstaMoviPend);
		
		String fecCont = conectorParametro("fecCont").trim();
		traza("MMG:: Valor de atributo fecCont: " + fecCont);
		
		String fecPago = conectorParametro("fecPago").trim();
		traza("MMG:: Valor de atributo fecPago: " + fecPago);
		
		String fecProc = conectorParametro("fecProc").trim();
		traza("MMG:: Valor de atributo fecProc: " + fecProc);
		
		String valHoraProc = conectorParametro("valHoraProc").trim();
		traza("MMG:: Valor de atributo valHoraProc: " + valHoraProc);
		
		String valHoraNormAdic = conectorParametro("valHoraNormAdic").trim();
		traza("MMG:: Valor de atributo valHoraNormAdic: " + valHoraNormAdic);
		
		String codIdenProc = conectorParametro("codIdenProc").trim();
		traza("MMG:: Valor de atributo codIdenProc: " + codIdenProc);
		
		String impPago = conectorParametro("impPago").trim();
		traza("MMG:: Valor de atributo impPago: " + impPago);
		
		String valNombOfic = conectorParametro("valNombOfic").trim();
		traza("MMG:: Valor de atributo valNombOfic: " + valNombOfic);
		
		String numCupo = conectorParametro("numCupo").trim();
		traza("MMG:: Valor de atributo numCupo: " + numCupo);
		
		String valNumeDocu = conectorParametro("valNumeDocu").trim();
		traza("MMG:: Valor de atributo valNumeDocu: " + valNumeDocu);
		
		String numFactBole = conectorParametro("numFactBole").trim();
		traza("MMG:: Valor de atributo numFactBole: " + numFactBole);
		
		String valNumeLoteCont = conectorParametro("valNumeLoteCont").trim();
		traza("MMG:: Valor de atributo valNumeLoteCont: " + valNumeLoteCont);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		String codOficReca = conectorParametro("codOficReca").trim();
		traza("MMG:: Valor de atributo codOficReca: " + codOficReca);
		
		String valUsuaProc = conectorParametro("valUsuaProc").trim();
		traza("MMG:: Valor de atributo valUsuaProc: " + valUsuaProc);
		
		String fecMoviApli = conectorParametro("fecMoviApli").trim();
		traza("MMG:: Valor de atributo fecMoviApli: " + fecMoviApli);
		
	
		//Construimos el mso con los elementos de la búsqueda
		CccMovimBancaData cccMovimBanca= new CccMovimBancaData();
		
		
		es.indra.belcorp.mso.SegSocieData sociOidSociData = null;
		if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
			sociOidSociData = new es.indra.belcorp.mso.SegSocieData();
			sociOidSociData.setId(new Integer(sociOidSoci));
		}
		cccMovimBanca.setSociOidSoci(sociOidSociData);
		
		es.indra.belcorp.mso.CccSubprData subpOidMarcUltiData = null;
		if(subpOidMarcUlti != null && !subpOidMarcUlti.trim().equals("")){
			subpOidMarcUltiData = new es.indra.belcorp.mso.CccSubprData();
			subpOidMarcUltiData.setId(new Integer(subpOidMarcUlti));
		}
		cccMovimBanca.setSubpOidMarcUlti(subpOidMarcUltiData);
		
		es.indra.belcorp.mso.CccSubprData subpOidMarcCreaData = null;
		if(subpOidMarcCrea != null && !subpOidMarcCrea.trim().equals("")){
			subpOidMarcCreaData = new es.indra.belcorp.mso.CccSubprData();
			subpOidMarcCreaData.setId(new Integer(subpOidMarcCrea));
		}
		cccMovimBanca.setSubpOidMarcCrea(subpOidMarcCreaData);
		
		es.indra.belcorp.mso.CccTipoCargoAbonoData tcabOidAbonUltiData = null;
		if(tcabOidAbonUlti != null && !tcabOidAbonUlti.trim().equals("")){
			tcabOidAbonUltiData = new es.indra.belcorp.mso.CccTipoCargoAbonoData();
			tcabOidAbonUltiData.setId(new Integer(tcabOidAbonUlti));
		}
		cccMovimBanca.setTcabOidAbonUlti(tcabOidAbonUltiData);
		
		es.indra.belcorp.mso.CccTipoCargoAbonoData tcabOidAbonCreaData = null;
		if(tcabOidAbonCrea != null && !tcabOidAbonCrea.trim().equals("")){
			tcabOidAbonCreaData = new es.indra.belcorp.mso.CccTipoCargoAbonoData();
			tcabOidAbonCreaData.setId(new Integer(tcabOidAbonCrea));
		}
		cccMovimBanca.setTcabOidAbonCrea(tcabOidAbonCreaData);
		
		es.indra.belcorp.mso.CccTipoTransData ttraOidTipoTransData = null;
		if(ttraOidTipoTrans != null && !ttraOidTipoTrans.trim().equals("")){
			ttraOidTipoTransData = new es.indra.belcorp.mso.CccTipoTransData();
			ttraOidTipoTransData.setId(new Integer(ttraOidTipoTrans));
		}
		cccMovimBanca.setTtraOidTipoTrans(ttraOidTipoTransData);
		
		es.indra.belcorp.mso.CccCuentCorriBancaData ccbaOidCcBancData = null;
		if(ccbaOidCcBanc != null && !ccbaOidCcBanc.trim().equals("")){
			ccbaOidCcBancData = new es.indra.belcorp.mso.CccCuentCorriBancaData();
			ccbaOidCcBancData.setId(new Integer(ccbaOidCcBanc));
		}
		cccMovimBanca.setCcbaOidCcBanc(ccbaOidCcBancData);
		cccMovimBanca.setNumConsTran(
			(java.lang.Integer)FormatUtils.parseObject(numConsTran, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setNumLote(
			(java.lang.Integer)FormatUtils.parseObject(numLote, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setCodCons(
			(java.lang.String)FormatUtils.parseObject(codCons, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setCodConsReal(
			(java.lang.String)FormatUtils.parseObject(codConsReal, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setCodErro(
			(java.lang.String)FormatUtils.parseObject(codErro, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValDigiCheqFact(
			(java.lang.Integer)FormatUtils.parseObject(valDigiCheqFact, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValDocuApliAnio(
			(java.lang.String)FormatUtils.parseObject(valDocuApliAnio, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValDocuApliMesSeri(
			(java.lang.String)FormatUtils.parseObject(valDocuApliMesSeri, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValDocuApliNume(
			(java.lang.Integer)FormatUtils.parseObject(valDocuApliNume, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValDocuCreaAnio(
			(java.lang.String)FormatUtils.parseObject(valDocuCreaAnio, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValDocuCreaMesSeri(
			(java.lang.String)FormatUtils.parseObject(valDocuCreaMesSeri, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValDocuCreaNume(
			(java.lang.Integer)FormatUtils.parseObject(valDocuCreaNume, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValEstaMoviPend(
			(java.lang.String)FormatUtils.parseObject(valEstaMoviPend, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setFecCont(
			(java.sql.Date)FormatUtils.parseObject(fecCont, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setFecPago(
			(java.sql.Date)FormatUtils.parseObject(fecPago, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setFecProc(
			(java.lang.String)FormatUtils.parseObject(fecProc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValHoraProc(
			(java.lang.String)FormatUtils.parseObject(valHoraProc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValHoraNormAdic(
			(java.lang.String)FormatUtils.parseObject(valHoraNormAdic, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setCodIdenProc(
			(java.lang.String)FormatUtils.parseObject(codIdenProc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setImpPago(
			(java.lang.Double)FormatUtils.parseObject(impPago, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValNombOfic(
			(java.lang.String)FormatUtils.parseObject(valNombOfic, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setNumCupo(
			(java.lang.Integer)FormatUtils.parseObject(numCupo, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValNumeDocu(
			(java.lang.String)FormatUtils.parseObject(valNumeDocu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setNumFactBole(
			(java.lang.Integer)FormatUtils.parseObject(numFactBole, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValNumeLoteCont(
			(java.lang.String)FormatUtils.parseObject(valNumeLoteCont, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setCodOficReca(
			(java.lang.Integer)FormatUtils.parseObject(codOficReca, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValUsuaProc(
			(java.lang.String)FormatUtils.parseObject(valUsuaProc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setFecMoviApli(
			(java.sql.Date)FormatUtils.parseObject(fecMoviApli, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cccMovimBanca", cccMovimBanca);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CccMovimBanca");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CccMovimBanca");
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CccMovimBancaLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando CccMovimBanca");
		
		String sociOidSoci = conectorParametro("sociOidSoci").trim();
		traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
		
		String subpOidMarcUlti = conectorParametro("subpOidMarcUlti").trim();
		traza("MMG:: Valor de atributo subpOidMarcUlti: " + subpOidMarcUlti);
		
		String subpOidMarcCrea = conectorParametro("subpOidMarcCrea").trim();
		traza("MMG:: Valor de atributo subpOidMarcCrea: " + subpOidMarcCrea);
		
		String tcabOidAbonUlti = conectorParametro("tcabOidAbonUlti").trim();
		traza("MMG:: Valor de atributo tcabOidAbonUlti: " + tcabOidAbonUlti);
		
		String tcabOidAbonCrea = conectorParametro("tcabOidAbonCrea").trim();
		traza("MMG:: Valor de atributo tcabOidAbonCrea: " + tcabOidAbonCrea);
		
		String ttraOidTipoTrans = conectorParametro("ttraOidTipoTrans").trim();
		traza("MMG:: Valor de atributo ttraOidTipoTrans: " + ttraOidTipoTrans);
		
		String ccbaOidCcBanc = conectorParametro("ccbaOidCcBanc").trim();
		traza("MMG:: Valor de atributo ccbaOidCcBanc: " + ccbaOidCcBanc);
		
		String numConsTran = conectorParametro("numConsTran").trim();
		traza("MMG:: Valor de atributo numConsTran: " + numConsTran);
		
		String numLote = conectorParametro("numLote").trim();
		traza("MMG:: Valor de atributo numLote: " + numLote);
		
		String codCons = conectorParametro("codCons").trim();
		traza("MMG:: Valor de atributo codCons: " + codCons);
		
		String codConsReal = conectorParametro("codConsReal").trim();
		traza("MMG:: Valor de atributo codConsReal: " + codConsReal);
		
		String codErro = conectorParametro("codErro").trim();
		traza("MMG:: Valor de atributo codErro: " + codErro);
		
		String valDigiCheqFact = conectorParametro("valDigiCheqFact").trim();
		traza("MMG:: Valor de atributo valDigiCheqFact: " + valDigiCheqFact);
		
		String valDocuApliAnio = conectorParametro("valDocuApliAnio").trim();
		traza("MMG:: Valor de atributo valDocuApliAnio: " + valDocuApliAnio);
		
		String valDocuApliMesSeri = conectorParametro("valDocuApliMesSeri").trim();
		traza("MMG:: Valor de atributo valDocuApliMesSeri: " + valDocuApliMesSeri);
		
		String valDocuApliNume = conectorParametro("valDocuApliNume").trim();
		traza("MMG:: Valor de atributo valDocuApliNume: " + valDocuApliNume);
		
		String valDocuCreaAnio = conectorParametro("valDocuCreaAnio").trim();
		traza("MMG:: Valor de atributo valDocuCreaAnio: " + valDocuCreaAnio);
		
		String valDocuCreaMesSeri = conectorParametro("valDocuCreaMesSeri").trim();
		traza("MMG:: Valor de atributo valDocuCreaMesSeri: " + valDocuCreaMesSeri);
		
		String valDocuCreaNume = conectorParametro("valDocuCreaNume").trim();
		traza("MMG:: Valor de atributo valDocuCreaNume: " + valDocuCreaNume);
		
		String valEstaMoviPend = conectorParametro("valEstaMoviPend").trim();
		traza("MMG:: Valor de atributo valEstaMoviPend: " + valEstaMoviPend);
		
		String fecCont = conectorParametro("fecCont").trim();
		traza("MMG:: Valor de atributo fecCont: " + fecCont);
		
		String fecPago = conectorParametro("fecPago").trim();
		traza("MMG:: Valor de atributo fecPago: " + fecPago);
		
		String fecProc = conectorParametro("fecProc").trim();
		traza("MMG:: Valor de atributo fecProc: " + fecProc);
		
		String valHoraProc = conectorParametro("valHoraProc").trim();
		traza("MMG:: Valor de atributo valHoraProc: " + valHoraProc);
		
		String valHoraNormAdic = conectorParametro("valHoraNormAdic").trim();
		traza("MMG:: Valor de atributo valHoraNormAdic: " + valHoraNormAdic);
		
		String codIdenProc = conectorParametro("codIdenProc").trim();
		traza("MMG:: Valor de atributo codIdenProc: " + codIdenProc);
		
		String impPago = conectorParametro("impPago").trim();
		traza("MMG:: Valor de atributo impPago: " + impPago);
		
		String valNombOfic = conectorParametro("valNombOfic").trim();
		traza("MMG:: Valor de atributo valNombOfic: " + valNombOfic);
		
		String numCupo = conectorParametro("numCupo").trim();
		traza("MMG:: Valor de atributo numCupo: " + numCupo);
		
		String valNumeDocu = conectorParametro("valNumeDocu").trim();
		traza("MMG:: Valor de atributo valNumeDocu: " + valNumeDocu);
		
		String numFactBole = conectorParametro("numFactBole").trim();
		traza("MMG:: Valor de atributo numFactBole: " + numFactBole);
		
		String valNumeLoteCont = conectorParametro("valNumeLoteCont").trim();
		traza("MMG:: Valor de atributo valNumeLoteCont: " + valNumeLoteCont);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		String codOficReca = conectorParametro("codOficReca").trim();
		traza("MMG:: Valor de atributo codOficReca: " + codOficReca);
		
		String valUsuaProc = conectorParametro("valUsuaProc").trim();
		traza("MMG:: Valor de atributo valUsuaProc: " + valUsuaProc);
		
		String fecMoviApli = conectorParametro("fecMoviApli").trim();
		traza("MMG:: Valor de atributo fecMoviApli: " + fecMoviApli);
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CccMovimBancaData cccMovimBanca= new CccMovimBancaData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			cccMovimBanca.setId(new Integer(id));
		}
		cccMovimBanca = (CccMovimBancaData)getSingleObject(BUSINESSID_QUERY, cccMovimBanca, 
			cccMovimBanca.clone(), "cccMovimBanca");
		if(cccMovimBanca == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegSocieData sociOidSociData = null;
		if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
			sociOidSociData = new es.indra.belcorp.mso.SegSocieData();
			sociOidSociData.setId(new Integer(sociOidSoci));
		}
		cccMovimBanca.setSociOidSoci(sociOidSociData);
		es.indra.belcorp.mso.CccSubprData subpOidMarcUltiData = null;
		if(subpOidMarcUlti != null && !subpOidMarcUlti.trim().equals("")){
			subpOidMarcUltiData = new es.indra.belcorp.mso.CccSubprData();
			subpOidMarcUltiData.setId(new Integer(subpOidMarcUlti));
		}
		cccMovimBanca.setSubpOidMarcUlti(subpOidMarcUltiData);
		es.indra.belcorp.mso.CccSubprData subpOidMarcCreaData = null;
		if(subpOidMarcCrea != null && !subpOidMarcCrea.trim().equals("")){
			subpOidMarcCreaData = new es.indra.belcorp.mso.CccSubprData();
			subpOidMarcCreaData.setId(new Integer(subpOidMarcCrea));
		}
		cccMovimBanca.setSubpOidMarcCrea(subpOidMarcCreaData);
		es.indra.belcorp.mso.CccTipoCargoAbonoData tcabOidAbonUltiData = null;
		if(tcabOidAbonUlti != null && !tcabOidAbonUlti.trim().equals("")){
			tcabOidAbonUltiData = new es.indra.belcorp.mso.CccTipoCargoAbonoData();
			tcabOidAbonUltiData.setId(new Integer(tcabOidAbonUlti));
		}
		cccMovimBanca.setTcabOidAbonUlti(tcabOidAbonUltiData);
		es.indra.belcorp.mso.CccTipoCargoAbonoData tcabOidAbonCreaData = null;
		if(tcabOidAbonCrea != null && !tcabOidAbonCrea.trim().equals("")){
			tcabOidAbonCreaData = new es.indra.belcorp.mso.CccTipoCargoAbonoData();
			tcabOidAbonCreaData.setId(new Integer(tcabOidAbonCrea));
		}
		cccMovimBanca.setTcabOidAbonCrea(tcabOidAbonCreaData);
		es.indra.belcorp.mso.CccTipoTransData ttraOidTipoTransData = null;
		if(ttraOidTipoTrans != null && !ttraOidTipoTrans.trim().equals("")){
			ttraOidTipoTransData = new es.indra.belcorp.mso.CccTipoTransData();
			ttraOidTipoTransData.setId(new Integer(ttraOidTipoTrans));
		}
		cccMovimBanca.setTtraOidTipoTrans(ttraOidTipoTransData);
		es.indra.belcorp.mso.CccCuentCorriBancaData ccbaOidCcBancData = null;
		if(ccbaOidCcBanc != null && !ccbaOidCcBanc.trim().equals("")){
			ccbaOidCcBancData = new es.indra.belcorp.mso.CccCuentCorriBancaData();
			ccbaOidCcBancData.setId(new Integer(ccbaOidCcBanc));
		}
		cccMovimBanca.setCcbaOidCcBanc(ccbaOidCcBancData);
		cccMovimBanca.setNumConsTran(
			(java.lang.Integer)FormatUtils.parseObject(numConsTran, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setNumLote(
			(java.lang.Integer)FormatUtils.parseObject(numLote, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setCodCons(
			(java.lang.String)FormatUtils.parseObject(codCons, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setCodConsReal(
			(java.lang.String)FormatUtils.parseObject(codConsReal, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setCodErro(
			(java.lang.String)FormatUtils.parseObject(codErro, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValDigiCheqFact(
			(java.lang.Integer)FormatUtils.parseObject(valDigiCheqFact, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValDocuApliAnio(
			(java.lang.String)FormatUtils.parseObject(valDocuApliAnio, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValDocuApliMesSeri(
			(java.lang.String)FormatUtils.parseObject(valDocuApliMesSeri, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValDocuApliNume(
			(java.lang.Integer)FormatUtils.parseObject(valDocuApliNume, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValDocuCreaAnio(
			(java.lang.String)FormatUtils.parseObject(valDocuCreaAnio, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValDocuCreaMesSeri(
			(java.lang.String)FormatUtils.parseObject(valDocuCreaMesSeri, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValDocuCreaNume(
			(java.lang.Integer)FormatUtils.parseObject(valDocuCreaNume, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValEstaMoviPend(
			(java.lang.String)FormatUtils.parseObject(valEstaMoviPend, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setFecCont(
			(java.sql.Date)FormatUtils.parseObject(fecCont, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setFecPago(
			(java.sql.Date)FormatUtils.parseObject(fecPago, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setFecProc(
			(java.lang.String)FormatUtils.parseObject(fecProc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValHoraProc(
			(java.lang.String)FormatUtils.parseObject(valHoraProc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValHoraNormAdic(
			(java.lang.String)FormatUtils.parseObject(valHoraNormAdic, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setCodIdenProc(
			(java.lang.String)FormatUtils.parseObject(codIdenProc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setImpPago(
			(java.lang.Double)FormatUtils.parseObject(impPago, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValNombOfic(
			(java.lang.String)FormatUtils.parseObject(valNombOfic, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setNumCupo(
			(java.lang.Integer)FormatUtils.parseObject(numCupo, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValNumeDocu(
			(java.lang.String)FormatUtils.parseObject(valNumeDocu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setNumFactBole(
			(java.lang.Integer)FormatUtils.parseObject(numFactBole, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValNumeLoteCont(
			(java.lang.String)FormatUtils.parseObject(valNumeLoteCont, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setCodOficReca(
			(java.lang.Integer)FormatUtils.parseObject(codOficReca, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setValUsuaProc(
			(java.lang.String)FormatUtils.parseObject(valUsuaProc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		cccMovimBanca.setFecMoviApli(
			(java.sql.Date)FormatUtils.parseObject(fecMoviApli, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en druida no hay bloqueos.....
		//cccMovimBanca.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cccMovimBanca", cccMovimBanca);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CccMovimBanca");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CccMovimBanca");
		
		//Redirigimos a la LP que cierra el dialogo
		//Registramos que se recagen los datos en la venta en la cual se ha producido la operación
		conectorAction(LP_CLOSE_DIALOG);
		conectorActionOpener(false);
	}
	
	/**Nos permite borrar los elementos de la entidad seleccionados*/
	protected void cmdRemove() throws Exception{
		//Determinamos los elementos a eliminar. De cada uno sacamos el id y el timestamp
		Vector entities = new Vector();
		StringTokenizer claves = new StringTokenizer(conectorParametro("idSelection"), "|");
		StringTokenizer timestamps = new StringTokenizer(conectorParametro("timestamp"), "|");
		traza("MMG::Se van a borrar " + claves.countTokens() + " y son " + conectorParametro("idSelection"));
		while(claves.hasMoreTokens() && timestamps.hasMoreTokens()){
			CccMovimBancaData cccMovimBanca = new CccMovimBancaData();
			cccMovimBanca.setId(new Integer(claves.nextToken()));
			//cccMovimBanca.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(cccMovimBanca);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CccMovimBanca");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CccMovimBanca");

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CccMovimBancaLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
}


