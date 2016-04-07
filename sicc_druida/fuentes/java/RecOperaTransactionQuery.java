

/*
    INDRA/CAR/mmg
    $Id: RecOperaTransactionQuery.java,v 1.1 2009/12/03 18:40:10 pecbazalar Exp $
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
public class RecOperaTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGRecOperaQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "RecOperaConectorQueryList";

	// Definicion del constructor
	public RecOperaTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad RecOpera");
			String codOper = (String)getEntrada("codOper");
			traza("MMG:: Valor de atributo codOper: " + codOper);
			if(codOper != null && !codOper.trim().equals("")) codOper = codOper.toUpperCase();
			String valDescLarg = (String)getEntrada("valDescLarg");
			traza("MMG:: Valor de atributo valDescLarg: " + valDescLarg);
			String indAnul = (String)getEntrada("indAnul");
			traza("MMG:: Valor de atributo indAnul: " + indAnul);
			String indIngrEnvi = (String)getEntrada("indIngrEnvi");
			traza("MMG:: Valor de atributo indIngrEnvi: " + indIngrEnvi);
			String valIngrDevu = (String)getEntrada("valIngrDevu");
			traza("MMG:: Valor de atributo valIngrDevu: " + valIngrDevu);
			String valPerd = (String)getEntrada("valPerd");
			traza("MMG:: Valor de atributo valPerd: " + valPerd);
			String indEspeMercFisi = (String)getEntrada("indEspeMercFisi");
			traza("MMG:: Valor de atributo indEspeMercFisi: " + indEspeMercFisi);
			String indDevuFisiFact = (String)getEntrada("indDevuFisiFact");
			traza("MMG:: Valor de atributo indDevuFisiFact: " + indDevuFisiFact);
			String numCampHist = (String)getEntrada("numCampHist");
			traza("MMG:: Valor de atributo numCampHist: " + numCampHist);
			String indEnviGeneDevu = (String)getEntrada("indEnviGeneDevu");
			traza("MMG:: Valor de atributo indEnviGeneDevu: " + indEnviGeneDevu);
			String indDevuGeneEnvi = (String)getEntrada("indDevuGeneEnvi");
			traza("MMG:: Valor de atributo indDevuGeneEnvi: " + indDevuGeneEnvi);
			String almcOidAlma = (String)getEntrada("almcOidAlma");
			traza("MMG:: Valor de atributo almcOidAlma: " + almcOidAlma);
			String peciOidPeci = (String)getEntrada("peciOidPeci");
			traza("MMG:: Valor de atributo peciOidPeci: " + peciOidPeci);
			String mensOidMens = (String)getEntrada("mensOidMens");
			traza("MMG:: Valor de atributo mensOidMens: " + mensOidMens);
			String tspaOidSoliPaisPerd = (String)getEntrada("tspaOidSoliPaisPerd");
			traza("MMG:: Valor de atributo tspaOidSoliPaisPerd: " + tspaOidSoliPaisPerd);
			String tmalOidTipoMoviAlma = (String)getEntrada("tmalOidTipoMoviAlma");
			traza("MMG:: Valor de atributo tmalOidTipoMoviAlma: " + tmalOidTipoMoviAlma);
			String mdefOidModoAbonDefe = (String)getEntrada("mdefOidModoAbonDefe");
			traza("MMG:: Valor de atributo mdefOidModoAbonDefe: " + mdefOidModoAbonDefe);
			String penvOidPrecioEnvia = (String)getEntrada("penvOidPrecioEnvia");
			traza("MMG:: Valor de atributo penvOidPrecioEnvia: " + penvOidPrecioEnvia);
			String tspaOidSoliPaisGene = (String)getEntrada("tspaOidSoliPaisGene");
			traza("MMG:: Valor de atributo tspaOidSoliPaisGene: " + tspaOidSoliPaisGene);
			String moblOidMotiBloq = (String)getEntrada("moblOidMotiBloq");
			traza("MMG:: Valor de atributo moblOidMotiBloq: " + moblOidMotiBloq);
			String indFaltMerc = (String)getEntrada("indFaltMerc");
			traza("MMG:: Valor de atributo indFaltMerc: " + indFaltMerc);
			String tspaOidSoliSinStoc = (String)getEntrada("tspaOidSoliSinStoc");
			traza("MMG:: Valor de atributo tspaOidSoliSinStoc: " + tspaOidSoliSinStoc);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			RecOperaData recOperaFrom =new RecOperaData();
			RecOperaData recOperaTo = new RecOperaData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			recOperaFrom.setCodOper(
				(java.lang.String)FormatUtils.parseObject(codOper, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaFrom.setValDescLarg(
				(java.lang.String)FormatUtils.parseObject(valDescLarg, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaFrom.setIndAnul(
				(java.lang.Long)FormatUtils.parseObject(indAnul, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaFrom.setIndIngrEnvi(
				(java.lang.Long)FormatUtils.parseObject(indIngrEnvi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaFrom.setValIngrDevu(
				(java.lang.Long)FormatUtils.parseObject(valIngrDevu, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaFrom.setValPerd(
				(java.lang.Long)FormatUtils.parseObject(valPerd, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaFrom.setIndEspeMercFisi(
				(java.lang.Long)FormatUtils.parseObject(indEspeMercFisi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaFrom.setIndDevuFisiFact(
				(java.lang.Long)FormatUtils.parseObject(indDevuFisiFact, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaFrom.setNumCampHist(
				(java.lang.Long)FormatUtils.parseObject(numCampHist, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaFrom.setIndEnviGeneDevu(
				(java.lang.Long)FormatUtils.parseObject(indEnviGeneDevu, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaFrom.setIndDevuGeneEnvi(
				(java.lang.Long)FormatUtils.parseObject(indDevuGeneEnvi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.BelAlmacData almcOidAlmaData = null;
			if(almcOidAlma != null && !almcOidAlma.trim().equals("")){
				almcOidAlmaData = new es.indra.belcorp.mso.BelAlmacData();
				almcOidAlmaData.setId(new Long(almcOidAlma));
			}
			recOperaFrom.setAlmcOidAlma(almcOidAlmaData);
			es.indra.belcorp.mso.RecPreciData peciOidPeciData = null;
			if(peciOidPeci != null && !peciOidPeci.trim().equals("")){
				peciOidPeciData = new es.indra.belcorp.mso.RecPreciData();
				peciOidPeciData.setId(new Long(peciOidPeci));
			}
			recOperaFrom.setPeciOidPeci(peciOidPeciData);
			es.indra.belcorp.mso.MsgMensaData mensOidMensData = null;
			if(mensOidMens != null && !mensOidMens.trim().equals("")){
				mensOidMensData = new es.indra.belcorp.mso.MsgMensaData();
				mensOidMensData.setId(new Long(mensOidMens));
			}
			recOperaFrom.setMensOidMens(mensOidMensData);
			es.indra.belcorp.mso.PedTipoSolicPaisData tspaOidSoliPaisPerdData = null;
			if(tspaOidSoliPaisPerd != null && !tspaOidSoliPaisPerd.trim().equals("")){
				tspaOidSoliPaisPerdData = new es.indra.belcorp.mso.PedTipoSolicPaisData();
				tspaOidSoliPaisPerdData.setId(new Long(tspaOidSoliPaisPerd));
			}
			recOperaFrom.setTspaOidSoliPaisPerd(tspaOidSoliPaisPerdData);
			es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviAlmaData = null;
			if(tmalOidTipoMoviAlma != null && !tmalOidTipoMoviAlma.trim().equals("")){
				tmalOidTipoMoviAlmaData = new es.indra.belcorp.mso.BelTipoMovimAlmacData();
				tmalOidTipoMoviAlmaData.setId(new Long(tmalOidTipoMoviAlma));
			}
			recOperaFrom.setTmalOidTipoMoviAlma(tmalOidTipoMoviAlmaData);
			es.indra.belcorp.mso.RecModoAbonoDefecData mdefOidModoAbonDefeData = null;
			if(mdefOidModoAbonDefe != null && !mdefOidModoAbonDefe.trim().equals("")){
				mdefOidModoAbonDefeData = new es.indra.belcorp.mso.RecModoAbonoDefecData();
				mdefOidModoAbonDefeData.setId(new Long(mdefOidModoAbonDefe));
			}
			recOperaFrom.setMdefOidModoAbonDefe(mdefOidModoAbonDefeData);
			es.indra.belcorp.mso.RecPreciEnviaData penvOidPrecioEnviaData = null;
			if(penvOidPrecioEnvia != null && !penvOidPrecioEnvia.trim().equals("")){
				penvOidPrecioEnviaData = new es.indra.belcorp.mso.RecPreciEnviaData();
				penvOidPrecioEnviaData.setId(new Long(penvOidPrecioEnvia));
			}
			recOperaFrom.setPenvOidPrecioEnvia(penvOidPrecioEnviaData);
			es.indra.belcorp.mso.PedTipoSolicPaisData tspaOidSoliPaisGeneData = null;
			if(tspaOidSoliPaisGene != null && !tspaOidSoliPaisGene.trim().equals("")){
				tspaOidSoliPaisGeneData = new es.indra.belcorp.mso.PedTipoSolicPaisData();
				tspaOidSoliPaisGeneData.setId(new Long(tspaOidSoliPaisGene));
			}
			recOperaFrom.setTspaOidSoliPaisGene(tspaOidSoliPaisGeneData);
			es.indra.belcorp.mso.RecMotivBloquData moblOidMotiBloqData = null;
			if(moblOidMotiBloq != null && !moblOidMotiBloq.trim().equals("")){
				moblOidMotiBloqData = new es.indra.belcorp.mso.RecMotivBloquData();
				moblOidMotiBloqData.setId(new Long(moblOidMotiBloq));
			}
			recOperaFrom.setMoblOidMotiBloq(moblOidMotiBloqData);
			recOperaFrom.setIndFaltMerc(
				(java.lang.Long)FormatUtils.parseObject(indFaltMerc, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.PedTipoSolicPaisData tspaOidSoliSinStocData = null;
			if(tspaOidSoliSinStoc != null && !tspaOidSoliSinStoc.trim().equals("")){
				tspaOidSoliSinStocData = new es.indra.belcorp.mso.PedTipoSolicPaisData();
				tspaOidSoliSinStocData.setId(new Long(tspaOidSoliSinStoc));
			}
			recOperaFrom.setTspaOidSoliSinStoc(tspaOidSoliSinStocData);
			
			
			//Construimos el to
			recOperaTo = (RecOperaData)recOperaFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, recOperaFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, recOperaTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("recOperaFrom", recOperaFrom);
			dto.addProperty("recOperaTo", recOperaTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(recOperaFrom, recOperaTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad RecOpera");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad RecOpera");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(recOperaFrom, recOperaTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(RecOperaData recOperaFrom, RecOperaData recOperaTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recOperaFrom.setPaisOidPais(paisOculto); recOperaTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(RecOperaData recOperaFrom, RecOperaData recOperaTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recOperaFrom.setPaisOidPais(paisOculto); recOperaTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





