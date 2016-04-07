

/*
    INDRA/CAR/mmg
    $Id: EduMatriCursoLPExecution.java,v 1.1 2009/12/03 18:35:58 pecbazalar Exp $
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

public class EduMatriCursoLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGEduMatriCursoCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGEduMatriCursoUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGEduMatriCursoRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGEduMatriCursoQueryFromToUserPage";	
	public static final String CONECTOR_CREATE = "EduMatriCursoConectorCreate";
	public static final String CONECTOR_UPDATE = "EduMatriCursoConectorUpdate";
	public static final String CONECTOR_REMOVE = "EduMatriCursoConectorRemove";

	public EduMatriCursoLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("EduMatriCursoPage");
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
  	correspondiente a la creación de un/a nuevo EduMatriCurso*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando EduMatriCurso");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String cplcOidCabePlanCurs = conectorParametro("cplcOidCabePlanCurs").trim();
		traza("MMG:: Valor de atributo cplcOidCabePlanCurs: " + cplcOidCabePlanCurs);
		
		String codCurs = conectorParametro("codCurs").trim();
		traza("MMG:: Valor de atributo codCurs: " + codCurs);
		
		String terrOidTerr = conectorParametro("terrOidTerr").trim();
		traza("MMG:: Valor de atributo terrOidTerr: " + terrOidTerr);
		
		String clasOidClas = conectorParametro("clasOidClas").trim();
		traza("MMG:: Valor de atributo clasOidClas: " + clasOidClas);
		
		String frcuOidFrec = conectorParametro("frcuOidFrec").trim();
		traza("MMG:: Valor de atributo frcuOidFrec: " + frcuOidFrec);
		
		String regaOidRega = conectorParametro("regaOidRega").trim();
		traza("MMG:: Valor de atributo regaOidRega: " + regaOidRega);
		
		String zsgvOidSubgVent = conectorParametro("zsgvOidSubgVent").trim();
		traza("MMG:: Valor de atributo zsgvOidSubgVent: " + zsgvOidSubgVent);
		
		String zorgOidRegi = conectorParametro("zorgOidRegi").trim();
		traza("MMG:: Valor de atributo zorgOidRegi: " + zorgOidRegi);
		
		String zzonOidZona = conectorParametro("zzonOidZona").trim();
		traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
		
		String zsccOidSecc = conectorParametro("zsccOidSecc").trim();
		traza("MMG:: Valor de atributo zsccOidSecc: " + zsccOidSecc);
		
		String ztadOidTerrAdmi = conectorParametro("ztadOidTerrAdmi").trim();
		traza("MMG:: Valor de atributo ztadOidTerrAdmi: " + ztadOidTerrAdmi);
		
		String perdOidPeriInicComp = conectorParametro("perdOidPeriInicComp").trim();
		traza("MMG:: Valor de atributo perdOidPeriInicComp: " + perdOidPeriInicComp);
		
		String perdOidPeriFinaComp = conectorParametro("perdOidPeriFinaComp").trim();
		traza("MMG:: Valor de atributo perdOidPeriFinaComp: " + perdOidPeriFinaComp);
		
		String perdOidPeriInicCons = conectorParametro("perdOidPeriInicCons").trim();
		traza("MMG:: Valor de atributo perdOidPeriInicCons: " + perdOidPeriInicCons);
		
		String perdOidPeriFinaCons = conectorParametro("perdOidPeriFinaCons").trim();
		traza("MMG:: Valor de atributo perdOidPeriFinaCons: " + perdOidPeriFinaCons);
		
		String perdOidPeriIngr = conectorParametro("perdOidPeriIngr").trim();
		traza("MMG:: Valor de atributo perdOidPeriIngr: " + perdOidPeriIngr);
		
		String ticuOidTipoCurs = conectorParametro("ticuOidTipoCurs").trim();
		traza("MMG:: Valor de atributo ticuOidTipoCurs: " + ticuOidTipoCurs);
		
		String valPathFich = conectorParametro("valPathFich").trim();
		traza("MMG:: Valor de atributo valPathFich: " + valPathFich);
		
		String valObjeCurs = conectorParametro("valObjeCurs").trim();
		traza("MMG:: Valor de atributo valObjeCurs: " + valObjeCurs);
		
		String valContCurs = conectorParametro("valContCurs").trim();
		traza("MMG:: Valor de atributo valContCurs: " + valContCurs);
		
		String valRelaMateCurs = conectorParametro("valRelaMateCurs").trim();
		traza("MMG:: Valor de atributo valRelaMateCurs: " + valRelaMateCurs);
		
		String valMontVent = conectorParametro("valMontVent").trim();
		traza("MMG:: Valor de atributo valMontVent: " + valMontVent);
		
		String fecDispCurs = conectorParametro("fecDispCurs").trim();
		traza("MMG:: Valor de atributo fecDispCurs: " + fecDispCurs);
		
		String fecLanz = conectorParametro("fecLanz").trim();
		traza("MMG:: Valor de atributo fecLanz: " + fecLanz);
		
		String fecFinCurs = conectorParametro("fecFinCurs").trim();
		traza("MMG:: Valor de atributo fecFinCurs: " + fecFinCurs);
		
		String fecUltiCurs = conectorParametro("fecUltiCurs").trim();
		traza("MMG:: Valor de atributo fecUltiCurs: " + fecUltiCurs);
		
		String fecConcCurs = conectorParametro("fecConcCurs").trim();
		traza("MMG:: Valor de atributo fecConcCurs: " + fecConcCurs);
		
		String fecIngr = conectorParametro("fecIngr").trim();
		traza("MMG:: Valor de atributo fecIngr: " + fecIngr);
		
		String numPart = conectorParametro("numPart").trim();
		traza("MMG:: Valor de atributo numPart: " + numPart);
		
		String numOrde = conectorParametro("numOrde").trim();
		traza("MMG:: Valor de atributo numOrde: " + numOrde);
		
		String numCampa = conectorParametro("numCampa").trim();
		traza("MMG:: Valor de atributo numCampa: " + numCampa);
		
		String numUnid = conectorParametro("numUnid").trim();
		traza("MMG:: Valor de atributo numUnid: " + numUnid);
		
		String desCurs = conectorParametro("desCurs").trim();
		traza("MMG:: Valor de atributo desCurs: " + desCurs);
		
		String indAcceDmrt = conectorParametro("indAcceDmrt").trim();
		traza("MMG:: Valor de atributo indAcceDmrt: " + indAcceDmrt);
		
		String indAcceInfo = conectorParametro("indAcceInfo").trim();
		traza("MMG:: Valor de atributo indAcceInfo: " + indAcceInfo);
		
		String indAlcaGeog = conectorParametro("indAlcaGeog").trim();
		traza("MMG:: Valor de atributo indAlcaGeog: " + indAlcaGeog);
		
		String indBloqExte = conectorParametro("indBloqExte").trim();
		traza("MMG:: Valor de atributo indBloqExte: " + indBloqExte);
		
		String indMomeEntr = conectorParametro("indMomeEntr").trim();
		traza("MMG:: Valor de atributo indMomeEntr: " + indMomeEntr);
		
		String indCondPedi = conectorParametro("indCondPedi").trim();
		traza("MMG:: Valor de atributo indCondPedi: " + indCondPedi);
		
		String indCtrlMoro = conectorParametro("indCtrlMoro").trim();
		traza("MMG:: Valor de atributo indCtrlMoro: " + indCtrlMoro);
		
		String indCtrlFunc = conectorParametro("indCtrlFunc").trim();
		traza("MMG:: Valor de atributo indCtrlFunc: " + indCtrlFunc);
		
		String clclOidClieClasCapa = conectorParametro("clclOidClieClasCapa").trim();
		traza("MMG:: Valor de atributo clclOidClieClasCapa: " + clclOidClieClasCapa);
		
	
		//Construimos el mso con los elementos de la búsqueda
		EduMatriCursoData eduMatriCurso= new EduMatriCursoData();
		
		
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		eduMatriCurso.setPaisOidPais(paisOidPaisData);
		
		es.indra.belcorp.mso.EduPlantCursoCabecData cplcOidCabePlanCursData = null;
		if(cplcOidCabePlanCurs != null && !cplcOidCabePlanCurs.trim().equals("")){
			cplcOidCabePlanCursData = new es.indra.belcorp.mso.EduPlantCursoCabecData();
			cplcOidCabePlanCursData.setId(new Integer(cplcOidCabePlanCurs));
		}
		eduMatriCurso.setCplcOidCabePlanCurs(cplcOidCabePlanCursData);
		eduMatriCurso.setCodCurs(
			(java.lang.Integer)FormatUtils.parseObject(codCurs, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		es.indra.belcorp.mso.ZonTerriData terrOidTerrData = null;
		if(terrOidTerr != null && !terrOidTerr.trim().equals("")){
			terrOidTerrData = new es.indra.belcorp.mso.ZonTerriData();
			terrOidTerrData.setId(new Integer(terrOidTerr));
		}
		eduMatriCurso.setTerrOidTerr(terrOidTerrData);
		
		es.indra.belcorp.mso.MaeClasiData clasOidClasData = null;
		if(clasOidClas != null && !clasOidClas.trim().equals("")){
			clasOidClasData = new es.indra.belcorp.mso.MaeClasiData();
			clasOidClasData.setId(new Integer(clasOidClas));
		}
		eduMatriCurso.setClasOidClas(clasOidClasData);
		
		es.indra.belcorp.mso.EduFrecuCursoData frcuOidFrecData = null;
		if(frcuOidFrec != null && !frcuOidFrec.trim().equals("")){
			frcuOidFrecData = new es.indra.belcorp.mso.EduFrecuCursoData();
			frcuOidFrecData.setId(new Integer(frcuOidFrec));
		}
		eduMatriCurso.setFrcuOidFrec(frcuOidFrecData);
		
		es.indra.belcorp.mso.EduRegalData regaOidRegaData = null;
		if(regaOidRega != null && !regaOidRega.trim().equals("")){
			regaOidRegaData = new es.indra.belcorp.mso.EduRegalData();
			regaOidRegaData.setId(new Integer(regaOidRega));
		}
		eduMatriCurso.setRegaOidRega(regaOidRegaData);
		
		es.indra.belcorp.mso.ZonSubGerenVentaData zsgvOidSubgVentData = null;
		if(zsgvOidSubgVent != null && !zsgvOidSubgVent.trim().equals("")){
			zsgvOidSubgVentData = new es.indra.belcorp.mso.ZonSubGerenVentaData();
			zsgvOidSubgVentData.setId(new Integer(zsgvOidSubgVent));
		}
		eduMatriCurso.setZsgvOidSubgVent(zsgvOidSubgVentData);
		
		es.indra.belcorp.mso.ZonRegioData zorgOidRegiData = null;
		if(zorgOidRegi != null && !zorgOidRegi.trim().equals("")){
			zorgOidRegiData = new es.indra.belcorp.mso.ZonRegioData();
			zorgOidRegiData.setId(new Integer(zorgOidRegi));
		}
		eduMatriCurso.setZorgOidRegi(zorgOidRegiData);
		
		es.indra.belcorp.mso.ZonZonaData zzonOidZonaData = null;
		if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
			zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaData();
			zzonOidZonaData.setId(new Integer(zzonOidZona));
		}
		eduMatriCurso.setZzonOidZona(zzonOidZonaData);
		
		es.indra.belcorp.mso.ZonSecciData zsccOidSeccData = null;
		if(zsccOidSecc != null && !zsccOidSecc.trim().equals("")){
			zsccOidSeccData = new es.indra.belcorp.mso.ZonSecciData();
			zsccOidSeccData.setId(new Integer(zsccOidSecc));
		}
		eduMatriCurso.setZsccOidSecc(zsccOidSeccData);
		
		es.indra.belcorp.mso.ZonTerriAdminData ztadOidTerrAdmiData = null;
		if(ztadOidTerrAdmi != null && !ztadOidTerrAdmi.trim().equals("")){
			ztadOidTerrAdmiData = new es.indra.belcorp.mso.ZonTerriAdminData();
			ztadOidTerrAdmiData.setId(new Integer(ztadOidTerrAdmi));
		}
		eduMatriCurso.setZtadOidTerrAdmi(ztadOidTerrAdmiData);
		
		es.indra.belcorp.mso.CraPerioData perdOidPeriInicCompData = null;
		if(perdOidPeriInicComp != null && !perdOidPeriInicComp.trim().equals("")){
			perdOidPeriInicCompData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriInicCompData.setId(new Integer(perdOidPeriInicComp));
		}
		eduMatriCurso.setPerdOidPeriInicComp(perdOidPeriInicCompData);
		
		es.indra.belcorp.mso.CraPerioData perdOidPeriFinaCompData = null;
		if(perdOidPeriFinaComp != null && !perdOidPeriFinaComp.trim().equals("")){
			perdOidPeriFinaCompData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriFinaCompData.setId(new Integer(perdOidPeriFinaComp));
		}
		eduMatriCurso.setPerdOidPeriFinaComp(perdOidPeriFinaCompData);
		
		es.indra.belcorp.mso.CraPerioData perdOidPeriInicConsData = null;
		if(perdOidPeriInicCons != null && !perdOidPeriInicCons.trim().equals("")){
			perdOidPeriInicConsData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriInicConsData.setId(new Integer(perdOidPeriInicCons));
		}
		eduMatriCurso.setPerdOidPeriInicCons(perdOidPeriInicConsData);
		
		es.indra.belcorp.mso.CraPerioData perdOidPeriFinaConsData = null;
		if(perdOidPeriFinaCons != null && !perdOidPeriFinaCons.trim().equals("")){
			perdOidPeriFinaConsData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriFinaConsData.setId(new Integer(perdOidPeriFinaCons));
		}
		eduMatriCurso.setPerdOidPeriFinaCons(perdOidPeriFinaConsData);
		
		es.indra.belcorp.mso.CraPerioData perdOidPeriIngrData = null;
		if(perdOidPeriIngr != null && !perdOidPeriIngr.trim().equals("")){
			perdOidPeriIngrData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriIngrData.setId(new Integer(perdOidPeriIngr));
		}
		eduMatriCurso.setPerdOidPeriIngr(perdOidPeriIngrData);
		
		es.indra.belcorp.mso.EduTipoCursoData ticuOidTipoCursData = null;
		if(ticuOidTipoCurs != null && !ticuOidTipoCurs.trim().equals("")){
			ticuOidTipoCursData = new es.indra.belcorp.mso.EduTipoCursoData();
			ticuOidTipoCursData.setId(new Integer(ticuOidTipoCurs));
		}
		eduMatriCurso.setTicuOidTipoCurs(ticuOidTipoCursData);
		eduMatriCurso.setValPathFich(
			(java.lang.String)FormatUtils.parseObject(valPathFich, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setValObjeCurs(
			(java.lang.String)FormatUtils.parseObject(valObjeCurs, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setValContCurs(
			(java.lang.String)FormatUtils.parseObject(valContCurs, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setValRelaMateCurs(
			(java.lang.String)FormatUtils.parseObject(valRelaMateCurs, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setValMontVent(
			(java.lang.Integer)FormatUtils.parseObject(valMontVent, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setFecDispCurs(
			(java.sql.Date)FormatUtils.parseObject(fecDispCurs, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setFecLanz(
			(java.sql.Date)FormatUtils.parseObject(fecLanz, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setFecFinCurs(
			(java.sql.Date)FormatUtils.parseObject(fecFinCurs, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setFecUltiCurs(
			(java.sql.Date)FormatUtils.parseObject(fecUltiCurs, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setFecConcCurs(
			(java.sql.Date)FormatUtils.parseObject(fecConcCurs, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setFecIngr(
			(java.sql.Date)FormatUtils.parseObject(fecIngr, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setNumPart(
			(java.lang.Integer)FormatUtils.parseObject(numPart, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setNumOrde(
			(java.lang.Integer)FormatUtils.parseObject(numOrde, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setNumCampa(
			(java.lang.Integer)FormatUtils.parseObject(numCampa, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setNumUnid(
			(java.lang.Integer)FormatUtils.parseObject(numUnid, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setDesCurs(
			(java.lang.String)FormatUtils.parseObject(desCurs, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndAcceDmrt(
			(java.lang.Integer)FormatUtils.parseObject(indAcceDmrt, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndAcceInfo(
			(java.lang.Integer)FormatUtils.parseObject(indAcceInfo, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndAlcaGeog(
			(java.lang.Integer)FormatUtils.parseObject(indAlcaGeog, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndBloqExte(
			(java.lang.Integer)FormatUtils.parseObject(indBloqExte, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndMomeEntr(
			(java.lang.Integer)FormatUtils.parseObject(indMomeEntr, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndCondPedi(
			(java.lang.Integer)FormatUtils.parseObject(indCondPedi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndCtrlMoro(
			(java.lang.Integer)FormatUtils.parseObject(indCtrlMoro, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndCtrlFunc(
			(java.lang.Integer)FormatUtils.parseObject(indCtrlFunc, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		es.indra.belcorp.mso.MaeClienClasiData clclOidClieClasCapaData = null;
		if(clclOidClieClasCapa != null && !clclOidClieClasCapa.trim().equals("")){
			clclOidClieClasCapaData = new es.indra.belcorp.mso.MaeClienClasiData();
			clclOidClieClasCapaData.setId(new Integer(clclOidClieClasCapa));
		}
		eduMatriCurso.setClclOidClieClasCapa(clclOidClieClasCapaData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("eduMatriCurso", eduMatriCurso);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad EduMatriCurso");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad EduMatriCurso");
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("EduMatriCursoLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando EduMatriCurso");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String cplcOidCabePlanCurs = conectorParametro("cplcOidCabePlanCurs").trim();
		traza("MMG:: Valor de atributo cplcOidCabePlanCurs: " + cplcOidCabePlanCurs);
		
		String codCurs = conectorParametro("codCurs").trim();
		traza("MMG:: Valor de atributo codCurs: " + codCurs);
		
		String terrOidTerr = conectorParametro("terrOidTerr").trim();
		traza("MMG:: Valor de atributo terrOidTerr: " + terrOidTerr);
		
		String clasOidClas = conectorParametro("clasOidClas").trim();
		traza("MMG:: Valor de atributo clasOidClas: " + clasOidClas);
		
		String frcuOidFrec = conectorParametro("frcuOidFrec").trim();
		traza("MMG:: Valor de atributo frcuOidFrec: " + frcuOidFrec);
		
		String regaOidRega = conectorParametro("regaOidRega").trim();
		traza("MMG:: Valor de atributo regaOidRega: " + regaOidRega);
		
		String zsgvOidSubgVent = conectorParametro("zsgvOidSubgVent").trim();
		traza("MMG:: Valor de atributo zsgvOidSubgVent: " + zsgvOidSubgVent);
		
		String zorgOidRegi = conectorParametro("zorgOidRegi").trim();
		traza("MMG:: Valor de atributo zorgOidRegi: " + zorgOidRegi);
		
		String zzonOidZona = conectorParametro("zzonOidZona").trim();
		traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
		
		String zsccOidSecc = conectorParametro("zsccOidSecc").trim();
		traza("MMG:: Valor de atributo zsccOidSecc: " + zsccOidSecc);
		
		String ztadOidTerrAdmi = conectorParametro("ztadOidTerrAdmi").trim();
		traza("MMG:: Valor de atributo ztadOidTerrAdmi: " + ztadOidTerrAdmi);
		
		String perdOidPeriInicComp = conectorParametro("perdOidPeriInicComp").trim();
		traza("MMG:: Valor de atributo perdOidPeriInicComp: " + perdOidPeriInicComp);
		
		String perdOidPeriFinaComp = conectorParametro("perdOidPeriFinaComp").trim();
		traza("MMG:: Valor de atributo perdOidPeriFinaComp: " + perdOidPeriFinaComp);
		
		String perdOidPeriInicCons = conectorParametro("perdOidPeriInicCons").trim();
		traza("MMG:: Valor de atributo perdOidPeriInicCons: " + perdOidPeriInicCons);
		
		String perdOidPeriFinaCons = conectorParametro("perdOidPeriFinaCons").trim();
		traza("MMG:: Valor de atributo perdOidPeriFinaCons: " + perdOidPeriFinaCons);
		
		String perdOidPeriIngr = conectorParametro("perdOidPeriIngr").trim();
		traza("MMG:: Valor de atributo perdOidPeriIngr: " + perdOidPeriIngr);
		
		String ticuOidTipoCurs = conectorParametro("ticuOidTipoCurs").trim();
		traza("MMG:: Valor de atributo ticuOidTipoCurs: " + ticuOidTipoCurs);
		
		String valPathFich = conectorParametro("valPathFich").trim();
		traza("MMG:: Valor de atributo valPathFich: " + valPathFich);
		
		String valObjeCurs = conectorParametro("valObjeCurs").trim();
		traza("MMG:: Valor de atributo valObjeCurs: " + valObjeCurs);
		
		String valContCurs = conectorParametro("valContCurs").trim();
		traza("MMG:: Valor de atributo valContCurs: " + valContCurs);
		
		String valRelaMateCurs = conectorParametro("valRelaMateCurs").trim();
		traza("MMG:: Valor de atributo valRelaMateCurs: " + valRelaMateCurs);
		
		String valMontVent = conectorParametro("valMontVent").trim();
		traza("MMG:: Valor de atributo valMontVent: " + valMontVent);
		
		String fecDispCurs = conectorParametro("fecDispCurs").trim();
		traza("MMG:: Valor de atributo fecDispCurs: " + fecDispCurs);
		
		String fecLanz = conectorParametro("fecLanz").trim();
		traza("MMG:: Valor de atributo fecLanz: " + fecLanz);
		
		String fecFinCurs = conectorParametro("fecFinCurs").trim();
		traza("MMG:: Valor de atributo fecFinCurs: " + fecFinCurs);
		
		String fecUltiCurs = conectorParametro("fecUltiCurs").trim();
		traza("MMG:: Valor de atributo fecUltiCurs: " + fecUltiCurs);
		
		String fecConcCurs = conectorParametro("fecConcCurs").trim();
		traza("MMG:: Valor de atributo fecConcCurs: " + fecConcCurs);
		
		String fecIngr = conectorParametro("fecIngr").trim();
		traza("MMG:: Valor de atributo fecIngr: " + fecIngr);
		
		String numPart = conectorParametro("numPart").trim();
		traza("MMG:: Valor de atributo numPart: " + numPart);
		
		String numOrde = conectorParametro("numOrde").trim();
		traza("MMG:: Valor de atributo numOrde: " + numOrde);
		
		String numCampa = conectorParametro("numCampa").trim();
		traza("MMG:: Valor de atributo numCampa: " + numCampa);
		
		String numUnid = conectorParametro("numUnid").trim();
		traza("MMG:: Valor de atributo numUnid: " + numUnid);
		
		String desCurs = conectorParametro("desCurs").trim();
		traza("MMG:: Valor de atributo desCurs: " + desCurs);
		
		String indAcceDmrt = conectorParametro("indAcceDmrt").trim();
		traza("MMG:: Valor de atributo indAcceDmrt: " + indAcceDmrt);
		
		String indAcceInfo = conectorParametro("indAcceInfo").trim();
		traza("MMG:: Valor de atributo indAcceInfo: " + indAcceInfo);
		
		String indAlcaGeog = conectorParametro("indAlcaGeog").trim();
		traza("MMG:: Valor de atributo indAlcaGeog: " + indAlcaGeog);
		
		String indBloqExte = conectorParametro("indBloqExte").trim();
		traza("MMG:: Valor de atributo indBloqExte: " + indBloqExte);
		
		String indMomeEntr = conectorParametro("indMomeEntr").trim();
		traza("MMG:: Valor de atributo indMomeEntr: " + indMomeEntr);
		
		String indCondPedi = conectorParametro("indCondPedi").trim();
		traza("MMG:: Valor de atributo indCondPedi: " + indCondPedi);
		
		String indCtrlMoro = conectorParametro("indCtrlMoro").trim();
		traza("MMG:: Valor de atributo indCtrlMoro: " + indCtrlMoro);
		
		String indCtrlFunc = conectorParametro("indCtrlFunc").trim();
		traza("MMG:: Valor de atributo indCtrlFunc: " + indCtrlFunc);
		
		String clclOidClieClasCapa = conectorParametro("clclOidClieClasCapa").trim();
		traza("MMG:: Valor de atributo clclOidClieClasCapa: " + clclOidClieClasCapa);
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		EduMatriCursoData eduMatriCurso= new EduMatriCursoData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			eduMatriCurso.setId(new Integer(id));
		}
		eduMatriCurso = (EduMatriCursoData)getSingleObject(BUSINESSID_QUERY, eduMatriCurso, 
			eduMatriCurso.clone(), "eduMatriCurso");
		if(eduMatriCurso == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		eduMatriCurso.setPaisOidPais(paisOidPaisData);
		es.indra.belcorp.mso.EduPlantCursoCabecData cplcOidCabePlanCursData = null;
		if(cplcOidCabePlanCurs != null && !cplcOidCabePlanCurs.trim().equals("")){
			cplcOidCabePlanCursData = new es.indra.belcorp.mso.EduPlantCursoCabecData();
			cplcOidCabePlanCursData.setId(new Integer(cplcOidCabePlanCurs));
		}
		eduMatriCurso.setCplcOidCabePlanCurs(cplcOidCabePlanCursData);
		eduMatriCurso.setCodCurs(
			(java.lang.Integer)FormatUtils.parseObject(codCurs, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.ZonTerriData terrOidTerrData = null;
		if(terrOidTerr != null && !terrOidTerr.trim().equals("")){
			terrOidTerrData = new es.indra.belcorp.mso.ZonTerriData();
			terrOidTerrData.setId(new Integer(terrOidTerr));
		}
		eduMatriCurso.setTerrOidTerr(terrOidTerrData);
		es.indra.belcorp.mso.MaeClasiData clasOidClasData = null;
		if(clasOidClas != null && !clasOidClas.trim().equals("")){
			clasOidClasData = new es.indra.belcorp.mso.MaeClasiData();
			clasOidClasData.setId(new Integer(clasOidClas));
		}
		eduMatriCurso.setClasOidClas(clasOidClasData);
		es.indra.belcorp.mso.EduFrecuCursoData frcuOidFrecData = null;
		if(frcuOidFrec != null && !frcuOidFrec.trim().equals("")){
			frcuOidFrecData = new es.indra.belcorp.mso.EduFrecuCursoData();
			frcuOidFrecData.setId(new Integer(frcuOidFrec));
		}
		eduMatriCurso.setFrcuOidFrec(frcuOidFrecData);
		es.indra.belcorp.mso.EduRegalData regaOidRegaData = null;
		if(regaOidRega != null && !regaOidRega.trim().equals("")){
			regaOidRegaData = new es.indra.belcorp.mso.EduRegalData();
			regaOidRegaData.setId(new Integer(regaOidRega));
		}
		eduMatriCurso.setRegaOidRega(regaOidRegaData);
		es.indra.belcorp.mso.ZonSubGerenVentaData zsgvOidSubgVentData = null;
		if(zsgvOidSubgVent != null && !zsgvOidSubgVent.trim().equals("")){
			zsgvOidSubgVentData = new es.indra.belcorp.mso.ZonSubGerenVentaData();
			zsgvOidSubgVentData.setId(new Integer(zsgvOidSubgVent));
		}
		eduMatriCurso.setZsgvOidSubgVent(zsgvOidSubgVentData);
		es.indra.belcorp.mso.ZonRegioData zorgOidRegiData = null;
		if(zorgOidRegi != null && !zorgOidRegi.trim().equals("")){
			zorgOidRegiData = new es.indra.belcorp.mso.ZonRegioData();
			zorgOidRegiData.setId(new Integer(zorgOidRegi));
		}
		eduMatriCurso.setZorgOidRegi(zorgOidRegiData);
		es.indra.belcorp.mso.ZonZonaData zzonOidZonaData = null;
		if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
			zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaData();
			zzonOidZonaData.setId(new Integer(zzonOidZona));
		}
		eduMatriCurso.setZzonOidZona(zzonOidZonaData);
		es.indra.belcorp.mso.ZonSecciData zsccOidSeccData = null;
		if(zsccOidSecc != null && !zsccOidSecc.trim().equals("")){
			zsccOidSeccData = new es.indra.belcorp.mso.ZonSecciData();
			zsccOidSeccData.setId(new Integer(zsccOidSecc));
		}
		eduMatriCurso.setZsccOidSecc(zsccOidSeccData);
		es.indra.belcorp.mso.ZonTerriAdminData ztadOidTerrAdmiData = null;
		if(ztadOidTerrAdmi != null && !ztadOidTerrAdmi.trim().equals("")){
			ztadOidTerrAdmiData = new es.indra.belcorp.mso.ZonTerriAdminData();
			ztadOidTerrAdmiData.setId(new Integer(ztadOidTerrAdmi));
		}
		eduMatriCurso.setZtadOidTerrAdmi(ztadOidTerrAdmiData);
		es.indra.belcorp.mso.CraPerioData perdOidPeriInicCompData = null;
		if(perdOidPeriInicComp != null && !perdOidPeriInicComp.trim().equals("")){
			perdOidPeriInicCompData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriInicCompData.setId(new Integer(perdOidPeriInicComp));
		}
		eduMatriCurso.setPerdOidPeriInicComp(perdOidPeriInicCompData);
		es.indra.belcorp.mso.CraPerioData perdOidPeriFinaCompData = null;
		if(perdOidPeriFinaComp != null && !perdOidPeriFinaComp.trim().equals("")){
			perdOidPeriFinaCompData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriFinaCompData.setId(new Integer(perdOidPeriFinaComp));
		}
		eduMatriCurso.setPerdOidPeriFinaComp(perdOidPeriFinaCompData);
		es.indra.belcorp.mso.CraPerioData perdOidPeriInicConsData = null;
		if(perdOidPeriInicCons != null && !perdOidPeriInicCons.trim().equals("")){
			perdOidPeriInicConsData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriInicConsData.setId(new Integer(perdOidPeriInicCons));
		}
		eduMatriCurso.setPerdOidPeriInicCons(perdOidPeriInicConsData);
		es.indra.belcorp.mso.CraPerioData perdOidPeriFinaConsData = null;
		if(perdOidPeriFinaCons != null && !perdOidPeriFinaCons.trim().equals("")){
			perdOidPeriFinaConsData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriFinaConsData.setId(new Integer(perdOidPeriFinaCons));
		}
		eduMatriCurso.setPerdOidPeriFinaCons(perdOidPeriFinaConsData);
		es.indra.belcorp.mso.CraPerioData perdOidPeriIngrData = null;
		if(perdOidPeriIngr != null && !perdOidPeriIngr.trim().equals("")){
			perdOidPeriIngrData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriIngrData.setId(new Integer(perdOidPeriIngr));
		}
		eduMatriCurso.setPerdOidPeriIngr(perdOidPeriIngrData);
		es.indra.belcorp.mso.EduTipoCursoData ticuOidTipoCursData = null;
		if(ticuOidTipoCurs != null && !ticuOidTipoCurs.trim().equals("")){
			ticuOidTipoCursData = new es.indra.belcorp.mso.EduTipoCursoData();
			ticuOidTipoCursData.setId(new Integer(ticuOidTipoCurs));
		}
		eduMatriCurso.setTicuOidTipoCurs(ticuOidTipoCursData);
		eduMatriCurso.setValPathFich(
			(java.lang.String)FormatUtils.parseObject(valPathFich, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setValObjeCurs(
			(java.lang.String)FormatUtils.parseObject(valObjeCurs, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setValContCurs(
			(java.lang.String)FormatUtils.parseObject(valContCurs, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setValRelaMateCurs(
			(java.lang.String)FormatUtils.parseObject(valRelaMateCurs, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setValMontVent(
			(java.lang.Integer)FormatUtils.parseObject(valMontVent, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setFecDispCurs(
			(java.sql.Date)FormatUtils.parseObject(fecDispCurs, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setFecLanz(
			(java.sql.Date)FormatUtils.parseObject(fecLanz, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setFecFinCurs(
			(java.sql.Date)FormatUtils.parseObject(fecFinCurs, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setFecUltiCurs(
			(java.sql.Date)FormatUtils.parseObject(fecUltiCurs, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setFecConcCurs(
			(java.sql.Date)FormatUtils.parseObject(fecConcCurs, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setFecIngr(
			(java.sql.Date)FormatUtils.parseObject(fecIngr, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setNumPart(
			(java.lang.Integer)FormatUtils.parseObject(numPart, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setNumOrde(
			(java.lang.Integer)FormatUtils.parseObject(numOrde, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setNumCampa(
			(java.lang.Integer)FormatUtils.parseObject(numCampa, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setNumUnid(
			(java.lang.Integer)FormatUtils.parseObject(numUnid, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setDesCurs(
			(java.lang.String)FormatUtils.parseObject(desCurs, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndAcceDmrt(
			(java.lang.Integer)FormatUtils.parseObject(indAcceDmrt, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndAcceInfo(
			(java.lang.Integer)FormatUtils.parseObject(indAcceInfo, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndAlcaGeog(
			(java.lang.Integer)FormatUtils.parseObject(indAlcaGeog, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndBloqExte(
			(java.lang.Integer)FormatUtils.parseObject(indBloqExte, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndMomeEntr(
			(java.lang.Integer)FormatUtils.parseObject(indMomeEntr, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndCondPedi(
			(java.lang.Integer)FormatUtils.parseObject(indCondPedi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndCtrlMoro(
			(java.lang.Integer)FormatUtils.parseObject(indCtrlMoro, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		eduMatriCurso.setIndCtrlFunc(
			(java.lang.Integer)FormatUtils.parseObject(indCtrlFunc, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.MaeClienClasiData clclOidClieClasCapaData = null;
		if(clclOidClieClasCapa != null && !clclOidClieClasCapa.trim().equals("")){
			clclOidClieClasCapaData = new es.indra.belcorp.mso.MaeClienClasiData();
			clclOidClieClasCapaData.setId(new Integer(clclOidClieClasCapa));
		}
		eduMatriCurso.setClclOidClieClasCapa(clclOidClieClasCapaData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en druida no hay bloqueos.....
		//eduMatriCurso.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("eduMatriCurso", eduMatriCurso);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad EduMatriCurso");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad EduMatriCurso");
		
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
			EduMatriCursoData eduMatriCurso = new EduMatriCursoData();
			eduMatriCurso.setId(new Integer(claves.nextToken()));
			//eduMatriCurso.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(eduMatriCurso);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad EduMatriCurso");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad EduMatriCurso");

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("EduMatriCursoLPStartUp");
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


