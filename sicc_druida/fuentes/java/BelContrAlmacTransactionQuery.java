

/*
    INDRA/CAR/mmg
    $Id: BelContrAlmacTransactionQuery.java,v 1.1 2009/12/03 18:39:39 pecbazalar Exp $
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
public class BelContrAlmacTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGBelContrAlmacQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "BelContrAlmacConectorQueryList";

	// Definicion del constructor
	public BelContrAlmacTransactionQuery(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
		
			//Metemos en la sesi�n la query de la busqueda en formato param1|param2|....|paramN(para el tema de volver a la 
			//pagina anterior y ,mantener los �ltimos resultados)
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, 
				conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY));
			
			traza("MMG:: LLegao a transaction Query de entidad BelContrAlmac");
			String sbacOidSbac = (String)getEntrada("sbacOidSbac");
			traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
			String prodOidProd = (String)getEntrada("prodOidProd");
			traza("MMG:: Valor de atributo prodOidProd: " + prodOidProd);
			String almcOidAlma = (String)getEntrada("almcOidAlma");
			traza("MMG:: Valor de atributo almcOidAlma: " + almcOidAlma);
			String valStocMini = (String)getEntrada("valStocMini");
			traza("MMG:: Valor de atributo valStocMini: " + valStocMini);
			String valStocMaxi = (String)getEntrada("valStocMaxi");
			traza("MMG:: Valor de atributo valStocMaxi: " + valStocMaxi);
			String valStocRepo = (String)getEntrada("valStocRepo");
			traza("MMG:: Valor de atributo valStocRepo: " + valStocRepo);
			
		
			//Construimos los MSOs (from y to) con los elementos de la b�squeda
			BelContrAlmacData belContrAlmacFrom =new BelContrAlmacData();
			BelContrAlmacData belContrAlmacTo = new BelContrAlmacData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
			if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
				sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
				sbacOidSbacData.setId(new Long(sbacOidSbac));
			}
			belContrAlmacFrom.setSbacOidSbac(sbacOidSbacData);
			es.indra.belcorp.mso.MaeProduViewData prodOidProdData = null;
			if(prodOidProd != null && !prodOidProd.trim().equals("")){
				prodOidProdData = new es.indra.belcorp.mso.MaeProduViewData();
				prodOidProdData.setId(new Long(prodOidProd));
			}
			belContrAlmacFrom.setProdOidProd(prodOidProdData);
			es.indra.belcorp.mso.BelAlmacData almcOidAlmaData = null;
			if(almcOidAlma != null && !almcOidAlma.trim().equals("")){
				almcOidAlmaData = new es.indra.belcorp.mso.BelAlmacData();
				almcOidAlmaData.setId(new Long(almcOidAlma));
			}
			belContrAlmacFrom.setAlmcOidAlma(almcOidAlmaData);
			belContrAlmacFrom.setValStocMini(
				(java.lang.Long)FormatUtils.parseObject(valStocMini, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belContrAlmacFrom.setValStocMaxi(
				(java.lang.Long)FormatUtils.parseObject(valStocMaxi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belContrAlmacFrom.setValStocRepo(
				(java.lang.Long)FormatUtils.parseObject(valStocRepo, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			belContrAlmacTo = (BelContrAlmacData)belContrAlmacFrom.clone();
			
			
			//Metemos tanto el fromo como el to como �ltimos mso con par�metros de b�squeda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, belContrAlmacFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, belContrAlmacTo);
			
			//Sacamos los datos de paginaci�n
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acci�n de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("belContrAlmacFrom", belContrAlmacFrom);
			dto.addProperty("belContrAlmacTo", belContrAlmacTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la l�gica de negocio
			traza("MMG:: Iniciada ejecuci�n Query de entidad BelContrAlmac");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecuci�n Query de entidad BelContrAlmac");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





