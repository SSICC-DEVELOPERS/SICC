

/*
    INDRA/CAR/mmg
    $Id: MaeProduViewTransactionQuery.java,v 1.1 2009/12/03 18:32:36 pecbazalar Exp $
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
public class MaeProduViewTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "codSap";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeProduViewQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaeProduViewConectorQueryList";

	// Definicion del constructor
	public MaeProduViewTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MaeProduView");
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
			String valGrupArti = (String)getEntrada("valGrupArti");
			traza("MMG:: Valor de atributo valGrupArti: " + valGrupArti);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeProduViewData maeProduViewFrom =new MaeProduViewData();
			MaeProduViewData maeProduViewTo = new MaeProduViewData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
				paisOidPaisData.setId(new Long(paisOidPais));
			}
			maeProduViewFrom.setPaisOidPais(paisOidPaisData);
			maeProduViewFrom.setCodSap(
				(java.lang.String)FormatUtils.parseObject(codSap, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setCodiAnti(
				(java.lang.String)FormatUtils.parseObject(codiAnti, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setDesCort(
				(java.lang.String)FormatUtils.parseObject(desCort, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValJera1(
				(java.lang.String)FormatUtils.parseObject(valJera1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValJera2(
				(java.lang.String)FormatUtils.parseObject(valJera2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValJera3(
				(java.lang.String)FormatUtils.parseObject(valJera3, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValAtri1(
				(java.lang.String)FormatUtils.parseObject(valAtri1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValAtri2(
				(java.lang.String)FormatUtils.parseObject(valAtri2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValAtri3(
				(java.lang.String)FormatUtils.parseObject(valAtri3, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValDimeAlto(
				(java.lang.Long)FormatUtils.parseObject(valDimeAlto, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValDimeLarg(
				(java.lang.Long)FormatUtils.parseObject(valDimeLarg, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValDimeAnch(
				(java.lang.Long)FormatUtils.parseObject(valDimeAnch, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValPeso(
				(java.lang.Long)FormatUtils.parseObject(valPeso, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValVolu(
				(java.lang.Long)FormatUtils.parseObject(valVolu, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValCostEstd(
				(java.lang.Double)FormatUtils.parseObject(valCostEstd, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValPrecPosi(
				(java.lang.Double)FormatUtils.parseObject(valPrecPosi, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValPrecCata(
				(java.lang.Double)FormatUtils.parseObject(valPrecCata, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValPrecCont(
				(java.lang.Double)FormatUtils.parseObject(valPrecCont, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setNumUnidDentPedi(
				(java.lang.Long)FormatUtils.parseObject(numUnidDentPedi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setNumUnidCaja(
				(java.lang.Long)FormatUtils.parseObject(numUnidCaja, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setCodImpu(
				(java.lang.String)FormatUtils.parseObject(codImpu, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setPctUnid(
				(java.lang.Long)FormatUtils.parseObject(pctUnid, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setIndLote(
				(java.lang.Long)FormatUtils.parseObject(indLote, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setIndProdServ(
				(java.lang.Long)FormatUtils.parseObject(indProdServ, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setCodIndSitu(
				(java.lang.String)FormatUtils.parseObject(codIndSitu, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setCodIndDentCaja(
				(java.lang.String)FormatUtils.parseObject(codIndDentCaja, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setIndKit(
				(java.lang.Long)FormatUtils.parseObject(indKit, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeProduViewFrom.setValGrupArti(
				(java.lang.String)FormatUtils.parseObject(valGrupArti, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			maeProduViewTo = (MaeProduViewData)maeProduViewFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maeProduViewFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maeProduViewTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeProduViewFrom", maeProduViewFrom);
			dto.addProperty("maeProduViewTo", maeProduViewTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeProduView");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeProduView");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





