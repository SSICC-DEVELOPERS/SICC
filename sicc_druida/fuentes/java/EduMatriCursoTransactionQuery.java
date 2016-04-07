

/*
    INDRA/CAR/mmg
    $Id: EduMatriCursoTransactionQuery.java,v 1.1 2009/12/03 18:37:36 pecbazalar Exp $
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
public class EduMatriCursoTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGEduMatriCursoQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "EduMatriCursoConectorQueryList";

	// Definicion del constructor
	public EduMatriCursoTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad EduMatriCurso");
			
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			
			
			String cplcOidCabePlanCurs = (String)getEntrada("cplcOidCabePlanCurs");
			traza("MMG:: Valor de atributo cplcOidCabePlanCurs: " + cplcOidCabePlanCurs);
			
			
			String codCurs = (String)getEntrada("codCurs");
			traza("MMG:: Valor de atributo codCurs: " + codCurs);
			
			
			String terrOidTerr = (String)getEntrada("terrOidTerr");
			traza("MMG:: Valor de atributo terrOidTerr: " + terrOidTerr);
			
			
			String clasOidClas = (String)getEntrada("clasOidClas");
			traza("MMG:: Valor de atributo clasOidClas: " + clasOidClas);
			
			
			String frcuOidFrec = (String)getEntrada("frcuOidFrec");
			traza("MMG:: Valor de atributo frcuOidFrec: " + frcuOidFrec);
			
			
			String regaOidRega = (String)getEntrada("regaOidRega");
			traza("MMG:: Valor de atributo regaOidRega: " + regaOidRega);
			
			
			String zsgvOidSubgVent = (String)getEntrada("zsgvOidSubgVent");
			traza("MMG:: Valor de atributo zsgvOidSubgVent: " + zsgvOidSubgVent);
			
			
			String zorgOidRegi = (String)getEntrada("zorgOidRegi");
			traza("MMG:: Valor de atributo zorgOidRegi: " + zorgOidRegi);
			
			
			String zzonOidZona = (String)getEntrada("zzonOidZona");
			traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
			
			
			String zsccOidSecc = (String)getEntrada("zsccOidSecc");
			traza("MMG:: Valor de atributo zsccOidSecc: " + zsccOidSecc);
			
			
			String ztadOidTerrAdmi = (String)getEntrada("ztadOidTerrAdmi");
			traza("MMG:: Valor de atributo ztadOidTerrAdmi: " + ztadOidTerrAdmi);
			
			
			String perdOidPeriInicComp = (String)getEntrada("perdOidPeriInicComp");
			traza("MMG:: Valor de atributo perdOidPeriInicComp: " + perdOidPeriInicComp);
			
			
			String perdOidPeriFinaComp = (String)getEntrada("perdOidPeriFinaComp");
			traza("MMG:: Valor de atributo perdOidPeriFinaComp: " + perdOidPeriFinaComp);
			
			
			String perdOidPeriInicCons = (String)getEntrada("perdOidPeriInicCons");
			traza("MMG:: Valor de atributo perdOidPeriInicCons: " + perdOidPeriInicCons);
			
			
			String perdOidPeriFinaCons = (String)getEntrada("perdOidPeriFinaCons");
			traza("MMG:: Valor de atributo perdOidPeriFinaCons: " + perdOidPeriFinaCons);
			
			
			String perdOidPeriIngr = (String)getEntrada("perdOidPeriIngr");
			traza("MMG:: Valor de atributo perdOidPeriIngr: " + perdOidPeriIngr);
			
			
			String ticuOidTipoCurs = (String)getEntrada("ticuOidTipoCurs");
			traza("MMG:: Valor de atributo ticuOidTipoCurs: " + ticuOidTipoCurs);
			
			
			String valPathFich = (String)getEntrada("valPathFich");
			traza("MMG:: Valor de atributo valPathFich: " + valPathFich);
			
			
			String valObjeCurs = (String)getEntrada("valObjeCurs");
			traza("MMG:: Valor de atributo valObjeCurs: " + valObjeCurs);
			
			
			String valContCurs = (String)getEntrada("valContCurs");
			traza("MMG:: Valor de atributo valContCurs: " + valContCurs);
			
			
			String valRelaMateCurs = (String)getEntrada("valRelaMateCurs");
			traza("MMG:: Valor de atributo valRelaMateCurs: " + valRelaMateCurs);
			
			
			String valMontVent = (String)getEntrada("valMontVent");
			traza("MMG:: Valor de atributo valMontVent: " + valMontVent);
			
			
			String fecDispCurs = (String)getEntrada("fecDispCurs");
			traza("MMG:: Valor de atributo fecDispCurs: " + fecDispCurs);
			
			
			String fecLanz = (String)getEntrada("fecLanz");
			traza("MMG:: Valor de atributo fecLanz: " + fecLanz);
			
			
			String fecFinCurs = (String)getEntrada("fecFinCurs");
			traza("MMG:: Valor de atributo fecFinCurs: " + fecFinCurs);
			
			
			String fecUltiCurs = (String)getEntrada("fecUltiCurs");
			traza("MMG:: Valor de atributo fecUltiCurs: " + fecUltiCurs);
			
			
			String fecConcCurs = (String)getEntrada("fecConcCurs");
			traza("MMG:: Valor de atributo fecConcCurs: " + fecConcCurs);
			
			
			String fecIngr = (String)getEntrada("fecIngr");
			traza("MMG:: Valor de atributo fecIngr: " + fecIngr);
			
			
			String numPart = (String)getEntrada("numPart");
			traza("MMG:: Valor de atributo numPart: " + numPart);
			
			
			String numOrde = (String)getEntrada("numOrde");
			traza("MMG:: Valor de atributo numOrde: " + numOrde);
			
			
			String numCampa = (String)getEntrada("numCampa");
			traza("MMG:: Valor de atributo numCampa: " + numCampa);
			
			
			String numUnid = (String)getEntrada("numUnid");
			traza("MMG:: Valor de atributo numUnid: " + numUnid);
			
			
			String desCurs = (String)getEntrada("desCurs");
			traza("MMG:: Valor de atributo desCurs: " + desCurs);
			
			
			String indAcceDmrt = (String)getEntrada("indAcceDmrt");
			traza("MMG:: Valor de atributo indAcceDmrt: " + indAcceDmrt);
			
			
			String indAcceInfo = (String)getEntrada("indAcceInfo");
			traza("MMG:: Valor de atributo indAcceInfo: " + indAcceInfo);
			
			
			String indAlcaGeog = (String)getEntrada("indAlcaGeog");
			traza("MMG:: Valor de atributo indAlcaGeog: " + indAlcaGeog);
			
			
			String indBloqExte = (String)getEntrada("indBloqExte");
			traza("MMG:: Valor de atributo indBloqExte: " + indBloqExte);
			
			
			String indMomeEntr = (String)getEntrada("indMomeEntr");
			traza("MMG:: Valor de atributo indMomeEntr: " + indMomeEntr);
			
			
			String indCondPedi = (String)getEntrada("indCondPedi");
			traza("MMG:: Valor de atributo indCondPedi: " + indCondPedi);
			
			
			String indCtrlMoro = (String)getEntrada("indCtrlMoro");
			traza("MMG:: Valor de atributo indCtrlMoro: " + indCtrlMoro);
			
			
			String indCtrlFunc = (String)getEntrada("indCtrlFunc");
			traza("MMG:: Valor de atributo indCtrlFunc: " + indCtrlFunc);
			
			
			String clclOidClieClasCapa = (String)getEntrada("clclOidClieClasCapa");
			traza("MMG:: Valor de atributo clclOidClieClasCapa: " + clclOidClieClasCapa);
			
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			EduMatriCursoData eduMatriCursoFrom =new EduMatriCursoData();
			EduMatriCursoData eduMatriCursoTo = new EduMatriCursoData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			
			es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
				paisOidPaisData.setId(new Integer(paisOidPais));
			}
			eduMatriCursoFrom.setPaisOidPais(paisOidPaisData);
			
			es.indra.belcorp.mso.EduPlantCursoCabecData cplcOidCabePlanCursData = null;
			if(cplcOidCabePlanCurs != null && !cplcOidCabePlanCurs.trim().equals("")){
				cplcOidCabePlanCursData = new es.indra.belcorp.mso.EduPlantCursoCabecData();
				cplcOidCabePlanCursData.setId(new Integer(cplcOidCabePlanCurs));
			}
			eduMatriCursoFrom.setCplcOidCabePlanCurs(cplcOidCabePlanCursData);
			eduMatriCursoFrom.setCodCurs(
				(java.lang.Integer)FormatUtils.parseObject(codCurs, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			es.indra.belcorp.mso.ZonTerriData terrOidTerrData = null;
			if(terrOidTerr != null && !terrOidTerr.trim().equals("")){
				terrOidTerrData = new es.indra.belcorp.mso.ZonTerriData();
				terrOidTerrData.setId(new Integer(terrOidTerr));
			}
			eduMatriCursoFrom.setTerrOidTerr(terrOidTerrData);
			
			es.indra.belcorp.mso.MaeClasiData clasOidClasData = null;
			if(clasOidClas != null && !clasOidClas.trim().equals("")){
				clasOidClasData = new es.indra.belcorp.mso.MaeClasiData();
				clasOidClasData.setId(new Integer(clasOidClas));
			}
			eduMatriCursoFrom.setClasOidClas(clasOidClasData);
			
			es.indra.belcorp.mso.EduFrecuCursoData frcuOidFrecData = null;
			if(frcuOidFrec != null && !frcuOidFrec.trim().equals("")){
				frcuOidFrecData = new es.indra.belcorp.mso.EduFrecuCursoData();
				frcuOidFrecData.setId(new Integer(frcuOidFrec));
			}
			eduMatriCursoFrom.setFrcuOidFrec(frcuOidFrecData);
			
			es.indra.belcorp.mso.EduRegalData regaOidRegaData = null;
			if(regaOidRega != null && !regaOidRega.trim().equals("")){
				regaOidRegaData = new es.indra.belcorp.mso.EduRegalData();
				regaOidRegaData.setId(new Integer(regaOidRega));
			}
			eduMatriCursoFrom.setRegaOidRega(regaOidRegaData);
			
			es.indra.belcorp.mso.ZonSubGerenVentaData zsgvOidSubgVentData = null;
			if(zsgvOidSubgVent != null && !zsgvOidSubgVent.trim().equals("")){
				zsgvOidSubgVentData = new es.indra.belcorp.mso.ZonSubGerenVentaData();
				zsgvOidSubgVentData.setId(new Integer(zsgvOidSubgVent));
			}
			eduMatriCursoFrom.setZsgvOidSubgVent(zsgvOidSubgVentData);
			
			es.indra.belcorp.mso.ZonRegioData zorgOidRegiData = null;
			if(zorgOidRegi != null && !zorgOidRegi.trim().equals("")){
				zorgOidRegiData = new es.indra.belcorp.mso.ZonRegioData();
				zorgOidRegiData.setId(new Integer(zorgOidRegi));
			}
			eduMatriCursoFrom.setZorgOidRegi(zorgOidRegiData);
			
			es.indra.belcorp.mso.ZonZonaData zzonOidZonaData = null;
			if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
				zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaData();
				zzonOidZonaData.setId(new Integer(zzonOidZona));
			}
			eduMatriCursoFrom.setZzonOidZona(zzonOidZonaData);
			
			es.indra.belcorp.mso.ZonSecciData zsccOidSeccData = null;
			if(zsccOidSecc != null && !zsccOidSecc.trim().equals("")){
				zsccOidSeccData = new es.indra.belcorp.mso.ZonSecciData();
				zsccOidSeccData.setId(new Integer(zsccOidSecc));
			}
			eduMatriCursoFrom.setZsccOidSecc(zsccOidSeccData);
			
			es.indra.belcorp.mso.ZonTerriAdminData ztadOidTerrAdmiData = null;
			if(ztadOidTerrAdmi != null && !ztadOidTerrAdmi.trim().equals("")){
				ztadOidTerrAdmiData = new es.indra.belcorp.mso.ZonTerriAdminData();
				ztadOidTerrAdmiData.setId(new Integer(ztadOidTerrAdmi));
			}
			eduMatriCursoFrom.setZtadOidTerrAdmi(ztadOidTerrAdmiData);
			
			es.indra.belcorp.mso.CraPerioData perdOidPeriInicCompData = null;
			if(perdOidPeriInicComp != null && !perdOidPeriInicComp.trim().equals("")){
				perdOidPeriInicCompData = new es.indra.belcorp.mso.CraPerioData();
				perdOidPeriInicCompData.setId(new Integer(perdOidPeriInicComp));
			}
			eduMatriCursoFrom.setPerdOidPeriInicComp(perdOidPeriInicCompData);
			
			es.indra.belcorp.mso.CraPerioData perdOidPeriFinaCompData = null;
			if(perdOidPeriFinaComp != null && !perdOidPeriFinaComp.trim().equals("")){
				perdOidPeriFinaCompData = new es.indra.belcorp.mso.CraPerioData();
				perdOidPeriFinaCompData.setId(new Integer(perdOidPeriFinaComp));
			}
			eduMatriCursoFrom.setPerdOidPeriFinaComp(perdOidPeriFinaCompData);
			
			es.indra.belcorp.mso.CraPerioData perdOidPeriInicConsData = null;
			if(perdOidPeriInicCons != null && !perdOidPeriInicCons.trim().equals("")){
				perdOidPeriInicConsData = new es.indra.belcorp.mso.CraPerioData();
				perdOidPeriInicConsData.setId(new Integer(perdOidPeriInicCons));
			}
			eduMatriCursoFrom.setPerdOidPeriInicCons(perdOidPeriInicConsData);
			
			es.indra.belcorp.mso.CraPerioData perdOidPeriFinaConsData = null;
			if(perdOidPeriFinaCons != null && !perdOidPeriFinaCons.trim().equals("")){
				perdOidPeriFinaConsData = new es.indra.belcorp.mso.CraPerioData();
				perdOidPeriFinaConsData.setId(new Integer(perdOidPeriFinaCons));
			}
			eduMatriCursoFrom.setPerdOidPeriFinaCons(perdOidPeriFinaConsData);
			
			es.indra.belcorp.mso.CraPerioData perdOidPeriIngrData = null;
			if(perdOidPeriIngr != null && !perdOidPeriIngr.trim().equals("")){
				perdOidPeriIngrData = new es.indra.belcorp.mso.CraPerioData();
				perdOidPeriIngrData.setId(new Integer(perdOidPeriIngr));
			}
			eduMatriCursoFrom.setPerdOidPeriIngr(perdOidPeriIngrData);
			
			es.indra.belcorp.mso.EduTipoCursoData ticuOidTipoCursData = null;
			if(ticuOidTipoCurs != null && !ticuOidTipoCurs.trim().equals("")){
				ticuOidTipoCursData = new es.indra.belcorp.mso.EduTipoCursoData();
				ticuOidTipoCursData.setId(new Integer(ticuOidTipoCurs));
			}
			eduMatriCursoFrom.setTicuOidTipoCurs(ticuOidTipoCursData);
			eduMatriCursoFrom.setValPathFich(
				(java.lang.String)FormatUtils.parseObject(valPathFich, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setValObjeCurs(
				(java.lang.String)FormatUtils.parseObject(valObjeCurs, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setValContCurs(
				(java.lang.String)FormatUtils.parseObject(valContCurs, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setValRelaMateCurs(
				(java.lang.String)FormatUtils.parseObject(valRelaMateCurs, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setValMontVent(
				(java.lang.Integer)FormatUtils.parseObject(valMontVent, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setFecDispCurs(
				(java.sql.Date)FormatUtils.parseObject(fecDispCurs, "java.sql.Date", 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setFecLanz(
				(java.sql.Date)FormatUtils.parseObject(fecLanz, "java.sql.Date", 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setFecFinCurs(
				(java.sql.Date)FormatUtils.parseObject(fecFinCurs, "java.sql.Date", 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setFecUltiCurs(
				(java.sql.Date)FormatUtils.parseObject(fecUltiCurs, "java.sql.Date", 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setFecConcCurs(
				(java.sql.Date)FormatUtils.parseObject(fecConcCurs, "java.sql.Date", 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setFecIngr(
				(java.sql.Date)FormatUtils.parseObject(fecIngr, "java.sql.Date", 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setNumPart(
				(java.lang.Integer)FormatUtils.parseObject(numPart, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setNumOrde(
				(java.lang.Integer)FormatUtils.parseObject(numOrde, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setNumCampa(
				(java.lang.Integer)FormatUtils.parseObject(numCampa, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setNumUnid(
				(java.lang.Integer)FormatUtils.parseObject(numUnid, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setDesCurs(
				(java.lang.String)FormatUtils.parseObject(desCurs, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setIndAcceDmrt(
				(java.lang.Integer)FormatUtils.parseObject(indAcceDmrt, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setIndAcceInfo(
				(java.lang.Integer)FormatUtils.parseObject(indAcceInfo, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setIndAlcaGeog(
				(java.lang.Integer)FormatUtils.parseObject(indAlcaGeog, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setIndBloqExte(
				(java.lang.Integer)FormatUtils.parseObject(indBloqExte, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setIndMomeEntr(
				(java.lang.Integer)FormatUtils.parseObject(indMomeEntr, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setIndCondPedi(
				(java.lang.Integer)FormatUtils.parseObject(indCondPedi, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setIndCtrlMoro(
				(java.lang.Integer)FormatUtils.parseObject(indCtrlMoro, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			eduMatriCursoFrom.setIndCtrlFunc(
				(java.lang.Integer)FormatUtils.parseObject(indCtrlFunc, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			es.indra.belcorp.mso.MaeClienClasiData clclOidClieClasCapaData = null;
			if(clclOidClieClasCapa != null && !clclOidClieClasCapa.trim().equals("")){
				clclOidClieClasCapaData = new es.indra.belcorp.mso.MaeClienClasiData();
				clclOidClieClasCapaData.setId(new Integer(clclOidClieClasCapa));
			}
			eduMatriCursoFrom.setClclOidClieClasCapa(clclOidClieClasCapaData);
			
			
			//Construimos el to
			eduMatriCursoTo = (EduMatriCursoData)eduMatriCursoFrom.clone();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, eduMatriCursoFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, eduMatriCursoTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("eduMatriCursoFrom", eduMatriCursoFrom);
			dto.addProperty("eduMatriCursoTo", eduMatriCursoTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad EduMatriCurso");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad EduMatriCurso");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}





