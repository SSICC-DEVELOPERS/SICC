

/*
    INDRA/CAR/mmg
    $Id: MaeProduTransactionQuery.java,v 1.1 2009/12/03 18:38:36 pecbazalar Exp $
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
public class MaeProduTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeProduQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaeProduConectorQueryList";

	// Definicion del constructor
	public MaeProduTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MaeProdu");
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			String codSap = (String)getEntrada("codSap");
			traza("MMG:: Valor de atributo codSap: " + codSap);
			String codiAnti = (String)getEntrada("codiAnti");
			traza("MMG:: Valor de atributo codiAnti: " + codiAnti);
			String desCort = (String)getEntrada("desCort");
			traza("MMG:: Valor de atributo desCort: " + desCort);
			String valJera1 = (String)getEntrada("valJera1");
			traza("MMG:: Valor de atributo valJera1: " + valJera1);
			String valJera2 = (String)getEntrada("valJera2");
			traza("MMG:: Valor de atributo valJera2: " + valJera2);
			String valJera3 = (String)getEntrada("valJera3");
			traza("MMG:: Valor de atributo valJera3: " + valJera3);
			String valAtri1 = (String)getEntrada("valAtri1");
			traza("MMG:: Valor de atributo valAtri1: " + valAtri1);
			String valAtri2 = (String)getEntrada("valAtri2");
			traza("MMG:: Valor de atributo valAtri2: " + valAtri2);
			String valAtri3 = (String)getEntrada("valAtri3");
			traza("MMG:: Valor de atributo valAtri3: " + valAtri3);
			String valDimeAlto = (String)getEntrada("valDimeAlto");
			traza("MMG:: Valor de atributo valDimeAlto: " + valDimeAlto);
			String valDimeLarg = (String)getEntrada("valDimeLarg");
			traza("MMG:: Valor de atributo valDimeLarg: " + valDimeLarg);
			String valDimeAnch = (String)getEntrada("valDimeAnch");
			traza("MMG:: Valor de atributo valDimeAnch: " + valDimeAnch);
			String valPeso = (String)getEntrada("valPeso");
			traza("MMG:: Valor de atributo valPeso: " + valPeso);
			String valVolu = (String)getEntrada("valVolu");
			traza("MMG:: Valor de atributo valVolu: " + valVolu);
			String valCostEstd = (String)getEntrada("valCostEstd");
			traza("MMG:: Valor de atributo valCostEstd: " + valCostEstd);
			String valPrecPosi = (String)getEntrada("valPrecPosi");
			traza("MMG:: Valor de atributo valPrecPosi: " + valPrecPosi);
			String valPrecCata = (String)getEntrada("valPrecCata");
			traza("MMG:: Valor de atributo valPrecCata: " + valPrecCata);
			String valPrecCont = (String)getEntrada("valPrecCont");
			traza("MMG:: Valor de atributo valPrecCont: " + valPrecCont);
			String numUnidDentPedi = (String)getEntrada("numUnidDentPedi");
			traza("MMG:: Valor de atributo numUnidDentPedi: " + numUnidDentPedi);
			String numUnidCaja = (String)getEntrada("numUnidCaja");
			traza("MMG:: Valor de atributo numUnidCaja: " + numUnidCaja);
			String codImpu = (String)getEntrada("codImpu");
			traza("MMG:: Valor de atributo codImpu: " + codImpu);
			String pctUnid = (String)getEntrada("pctUnid");
			traza("MMG:: Valor de atributo pctUnid: " + pctUnid);
			String geneOidGene = (String)getEntrada("geneOidGene");
			traza("MMG:: Valor de atributo geneOidGene: " + geneOidGene);
			String sgenOidSupeGene = (String)getEntrada("sgenOidSupeGene");
			traza("MMG:: Valor de atributo sgenOidSupeGene: " + sgenOidSupeGene);
			String unmdOidUnidMedi = (String)getEntrada("unmdOidUnidMedi");
			traza("MMG:: Valor de atributo unmdOidUnidMedi: " + unmdOidUnidMedi);
			String unmdOidUnidMediPeso = (String)getEntrada("unmdOidUnidMediPeso");
			traza("MMG:: Valor de atributo unmdOidUnidMediPeso: " + unmdOidUnidMediPeso);
			String unmdOidUnidMediDime = (String)getEntrada("unmdOidUnidMediDime");
			traza("MMG:: Valor de atributo unmdOidUnidMediDime: " + unmdOidUnidMediDime);
			String negoOidNego = (String)getEntrada("negoOidNego");
			traza("MMG:: Valor de atributo negoOidNego: " + negoOidNego);
			String meudOidEstaProd = (String)getEntrada("meudOidEstaProd");
			traza("MMG:: Valor de atributo meudOidEstaProd: " + meudOidEstaProd);
			String liprOidLineProd = (String)getEntrada("liprOidLineProd");
			traza("MMG:: Valor de atributo liprOidLineProd: " + liprOidLineProd);
			String unegOidUnidNego = (String)getEntrada("unegOidUnidNego");
			traza("MMG:: Valor de atributo unegOidUnidNego: " + unegOidUnidNego);
			String perdOidPeriInic = (String)getEntrada("perdOidPeriInic");
			traza("MMG:: Valor de atributo perdOidPeriInic: " + perdOidPeriInic);
			String perdOidPeriFin = (String)getEntrada("perdOidPeriFin");
			traza("MMG:: Valor de atributo perdOidPeriFin: " + perdOidPeriFin);
			String indLote = (String)getEntrada("indLote");
			traza("MMG:: Valor de atributo indLote: " + indLote);
			String indProdServ = (String)getEntrada("indProdServ");
			traza("MMG:: Valor de atributo indProdServ: " + indProdServ);
			String codIndSitu = (String)getEntrada("codIndSitu");
			traza("MMG:: Valor de atributo codIndSitu: " + codIndSitu);
			String codIndDentCaja = (String)getEntrada("codIndDentCaja");
			traza("MMG:: Valor de atributo codIndDentCaja: " + codIndDentCaja);
			String indKit = (String)getEntrada("indKit");
			traza("MMG:: Valor de atributo indKit: " + indKit);
			String fopaOidFormPago = (String)getEntrada("fopaOidFormPago");
			traza("MMG:: Valor de atributo fopaOidFormPago: " + fopaOidFormPago);
			String maprOidMarcProd = (String)getEntrada("maprOidMarcProd");
			traza("MMG:: Valor de atributo maprOidMarcProd: " + maprOidMarcProd);
			String valGrupArti = (String)getEntrada("valGrupArti");
			traza("MMG:: Valor de atributo valGrupArti: " + valGrupArti);
			String codUnicVent = (String)getEntrada("codUnicVent");
			traza("MMG:: Valor de atributo codUnicVent: " + codUnicVent);
			String prfiOidProgFide = (String)getEntrada("prfiOidProgFide");
			traza("MMG:: Valor de atributo prfiOidProgFide: " + prfiOidProgFide);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeProduData maeProduFrom =new MaeProduData();
			MaeProduData maeProduTo = new MaeProduData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
				paisOidPaisData.setId(new Long(paisOidPais));
			}
			maeProduFrom.setPaisOidPais(paisOidPaisData);
			maeProduFrom.setCodSap(
				(java.lang.String)FormatUtils.parseObject(codSap, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setCodiAnti(
				(java.lang.String)FormatUtils.parseObject(codiAnti, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setDesCort(
				(java.lang.String)FormatUtils.parseObject(desCort, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setValJera1(
				(java.lang.String)FormatUtils.parseObject(valJera1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setValJera2(
				(java.lang.String)FormatUtils.parseObject(valJera2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setValJera3(
				(java.lang.String)FormatUtils.parseObject(valJera3, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setValAtri1(
				(java.lang.String)FormatUtils.parseObject(valAtri1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setValAtri2(
				(java.lang.String)FormatUtils.parseObject(valAtri2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setValAtri3(
				(java.lang.String)FormatUtils.parseObject(valAtri3, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setValDimeAlto(
				(java.lang.Long)FormatUtils.parseObject(valDimeAlto, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setValDimeLarg(
				(java.lang.Long)FormatUtils.parseObject(valDimeLarg, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setValDimeAnch(
				(java.lang.Long)FormatUtils.parseObject(valDimeAnch, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setValPeso(
				(java.lang.Long)FormatUtils.parseObject(valPeso, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setValVolu(
				(java.lang.Long)FormatUtils.parseObject(valVolu, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setValCostEstd(
				(java.lang.Double)FormatUtils.parseObject(valCostEstd, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setValPrecPosi(
				(java.lang.Double)FormatUtils.parseObject(valPrecPosi, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setValPrecCata(
				(java.lang.Double)FormatUtils.parseObject(valPrecCata, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setValPrecCont(
				(java.lang.Double)FormatUtils.parseObject(valPrecCont, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setNumUnidDentPedi(
				(java.lang.Long)FormatUtils.parseObject(numUnidDentPedi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setNumUnidCaja(
				(java.lang.Long)FormatUtils.parseObject(numUnidCaja, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setCodImpu(
				(java.lang.String)FormatUtils.parseObject(codImpu, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setPctUnid(
				(java.lang.Long)FormatUtils.parseObject(pctUnid, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.MaeGenerData geneOidGeneData = null;
			if(geneOidGene != null && !geneOidGene.trim().equals("")){
				geneOidGeneData = new es.indra.belcorp.mso.MaeGenerData();
				geneOidGeneData.setId(new Long(geneOidGene));
			}
			maeProduFrom.setGeneOidGene(geneOidGeneData);
			es.indra.belcorp.mso.MaeSuperGenerData sgenOidSupeGeneData = null;
			if(sgenOidSupeGene != null && !sgenOidSupeGene.trim().equals("")){
				sgenOidSupeGeneData = new es.indra.belcorp.mso.MaeSuperGenerData();
				sgenOidSupeGeneData.setId(new Long(sgenOidSupeGene));
			}
			maeProduFrom.setSgenOidSupeGene(sgenOidSupeGeneData);
			es.indra.belcorp.mso.MaeUnidaMedidData unmdOidUnidMediData = null;
			if(unmdOidUnidMedi != null && !unmdOidUnidMedi.trim().equals("")){
				unmdOidUnidMediData = new es.indra.belcorp.mso.MaeUnidaMedidData();
				unmdOidUnidMediData.setId(new Long(unmdOidUnidMedi));
			}
			maeProduFrom.setUnmdOidUnidMedi(unmdOidUnidMediData);
			es.indra.belcorp.mso.MaeUnidaMedidData unmdOidUnidMediPesoData = null;
			if(unmdOidUnidMediPeso != null && !unmdOidUnidMediPeso.trim().equals("")){
				unmdOidUnidMediPesoData = new es.indra.belcorp.mso.MaeUnidaMedidData();
				unmdOidUnidMediPesoData.setId(new Long(unmdOidUnidMediPeso));
			}
			maeProduFrom.setUnmdOidUnidMediPeso(unmdOidUnidMediPesoData);
			es.indra.belcorp.mso.MaeUnidaMedidData unmdOidUnidMediDimeData = null;
			if(unmdOidUnidMediDime != null && !unmdOidUnidMediDime.trim().equals("")){
				unmdOidUnidMediDimeData = new es.indra.belcorp.mso.MaeUnidaMedidData();
				unmdOidUnidMediDimeData.setId(new Long(unmdOidUnidMediDime));
			}
			maeProduFrom.setUnmdOidUnidMediDime(unmdOidUnidMediDimeData);
			es.indra.belcorp.mso.MaeNegocData negoOidNegoData = null;
			if(negoOidNego != null && !negoOidNego.trim().equals("")){
				negoOidNegoData = new es.indra.belcorp.mso.MaeNegocData();
				negoOidNegoData.setId(new Long(negoOidNego));
			}
			maeProduFrom.setNegoOidNego(negoOidNegoData);
			es.indra.belcorp.mso.MaeEstatProduData meudOidEstaProdData = null;
			if(meudOidEstaProd != null && !meudOidEstaProd.trim().equals("")){
				meudOidEstaProdData = new es.indra.belcorp.mso.MaeEstatProduData();
				meudOidEstaProdData.setId(new Long(meudOidEstaProd));
			}
			maeProduFrom.setMeudOidEstaProd(meudOidEstaProdData);
			es.indra.belcorp.mso.MaeLineaProduData liprOidLineProdData = null;
			if(liprOidLineProd != null && !liprOidLineProd.trim().equals("")){
				liprOidLineProdData = new es.indra.belcorp.mso.MaeLineaProduData();
				liprOidLineProdData.setId(new Long(liprOidLineProd));
			}
			maeProduFrom.setLiprOidLineProd(liprOidLineProdData);
			es.indra.belcorp.mso.MaeUnidaNegocData unegOidUnidNegoData = null;
			if(unegOidUnidNego != null && !unegOidUnidNego.trim().equals("")){
				unegOidUnidNegoData = new es.indra.belcorp.mso.MaeUnidaNegocData();
				unegOidUnidNegoData.setId(new Long(unegOidUnidNego));
			}
			maeProduFrom.setUnegOidUnidNego(unegOidUnidNegoData);
			es.indra.belcorp.mso.CraPerioData perdOidPeriInicData = null;
			if(perdOidPeriInic != null && !perdOidPeriInic.trim().equals("")){
				perdOidPeriInicData = new es.indra.belcorp.mso.CraPerioData();
				perdOidPeriInicData.setId(new Long(perdOidPeriInic));
			}
			maeProduFrom.setPerdOidPeriInic(perdOidPeriInicData);
			es.indra.belcorp.mso.CraPerioData perdOidPeriFinData = null;
			if(perdOidPeriFin != null && !perdOidPeriFin.trim().equals("")){
				perdOidPeriFinData = new es.indra.belcorp.mso.CraPerioData();
				perdOidPeriFinData.setId(new Long(perdOidPeriFin));
			}
			maeProduFrom.setPerdOidPeriFin(perdOidPeriFinData);
			maeProduFrom.setIndLote(
				(java.lang.Long)FormatUtils.parseObject(indLote, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setIndProdServ(
				(java.lang.Long)FormatUtils.parseObject(indProdServ, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setCodIndSitu(
				(java.lang.String)FormatUtils.parseObject(codIndSitu, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setCodIndDentCaja(
				(java.lang.String)FormatUtils.parseObject(codIndDentCaja, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setIndKit(
				(java.lang.Long)FormatUtils.parseObject(indKit, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.BelFormaPagoData fopaOidFormPagoData = null;
			if(fopaOidFormPago != null && !fopaOidFormPago.trim().equals("")){
				fopaOidFormPagoData = new es.indra.belcorp.mso.BelFormaPagoData();
				fopaOidFormPagoData.setId(new Long(fopaOidFormPago));
			}
			maeProduFrom.setFopaOidFormPago(fopaOidFormPagoData);
			es.indra.belcorp.mso.SegMarcaProduData maprOidMarcProdData = null;
			if(maprOidMarcProd != null && !maprOidMarcProd.trim().equals("")){
				maprOidMarcProdData = new es.indra.belcorp.mso.SegMarcaProduData();
				maprOidMarcProdData.setId(new Long(maprOidMarcProd));
			}
			maeProduFrom.setMaprOidMarcProd(maprOidMarcProdData);
			maeProduFrom.setValGrupArti(
				(java.lang.String)FormatUtils.parseObject(valGrupArti, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduFrom.setCodUnicVent(
				(java.lang.String)FormatUtils.parseObject(codUnicVent, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.MaeProgrFidelData prfiOidProgFideData = null;
			if(prfiOidProgFide != null && !prfiOidProgFide.trim().equals("")){
				prfiOidProgFideData = new es.indra.belcorp.mso.MaeProgrFidelData();
				prfiOidProgFideData.setId(new Long(prfiOidProgFide));
			}
			maeProduFrom.setPrfiOidProgFide(prfiOidProgFideData);
			
			
			//Construimos el to
			maeProduTo = (MaeProduData)maeProduFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maeProduFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maeProduTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeProduFrom", maeProduFrom);
			dto.addProperty("maeProduTo", maeProduTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(maeProduFrom, maeProduTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeProdu");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeProdu");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(maeProduFrom, maeProduTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(MaeProduData maeProduFrom, MaeProduData maeProduTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				maeProduFrom.setPaisOidPais(paisOculto);
				maeProduTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(MaeProduData maeProduFrom, MaeProduData maeProduTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				maeProduFrom.setPaisOidPais(paisOculto);
				maeProduTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





