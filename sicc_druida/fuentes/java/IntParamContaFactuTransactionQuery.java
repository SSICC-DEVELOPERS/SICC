

/*
    INDRA/CAR/mmg
    $Id: IntParamContaFactuTransactionQuery.java,v 1.1 2009/12/03 18:37:29 pecbazalar Exp $
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
public class IntParamContaFactuTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGIntParamContaFactuQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "IntParamContaFactuConectorQueryList";

	// Definicion del constructor
	public IntParamContaFactuTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad IntParamContaFactu");
			String codApun = (String)getEntrada("codApun");
			traza("MMG:: Valor de atributo codApun: " + codApun);
			if(codApun != null && !codApun.trim().equals("")) codApun = codApun.toUpperCase();
			String valTipoAsie = (String)getEntrada("valTipoAsie");
			traza("MMG:: Valor de atributo valTipoAsie: " + valTipoAsie);
			String valIdenCabeDeta = (String)getEntrada("valIdenCabeDeta");
			traza("MMG:: Valor de atributo valIdenCabeDeta: " + valIdenCabeDeta);
			String valDesc = (String)getEntrada("valDesc");
			traza("MMG:: Valor de atributo valDesc: " + valDesc);
			String valGrupArti = (String)getEntrada("valGrupArti");
			traza("MMG:: Valor de atributo valGrupArti: " + valGrupArti);
			String maprOidMarcProd = (String)getEntrada("maprOidMarcProd");
			traza("MMG:: Valor de atributo maprOidMarcProd: " + maprOidMarcProd);
			String negoOidNego = (String)getEntrada("negoOidNego");
			traza("MMG:: Valor de atributo negoOidNego: " + negoOidNego);
			String prodOidProd = (String)getEntrada("prodOidProd");
			traza("MMG:: Valor de atributo prodOidProd: " + prodOidProd);
			String cucoOidCuenCont = (String)getEntrada("cucoOidCuenCont");
			traza("MMG:: Valor de atributo cucoOidCuenCont: " + cucoOidCuenCont);
			String valIndiDebeHabe = (String)getEntrada("valIndiDebeHabe");
			traza("MMG:: Valor de atributo valIndiDebeHabe: " + valIndiDebeHabe);
			String imcfOidImpoContFact = (String)getEntrada("imcfOidImpoContFact");
			traza("MMG:: Valor de atributo imcfOidImpoContFact: " + imcfOidImpoContFact);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			IntParamContaFactuData intParamContaFactuFrom =new IntParamContaFactuData();
			IntParamContaFactuData intParamContaFactuTo = new IntParamContaFactuData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			intParamContaFactuFrom.setCodApun(
				(java.lang.String)FormatUtils.parseObject(codApun, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			intParamContaFactuFrom.setValTipoAsie(
				(java.lang.String)FormatUtils.parseObject(valTipoAsie, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			intParamContaFactuFrom.setValIdenCabeDeta(
				(java.lang.String)FormatUtils.parseObject(valIdenCabeDeta, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			intParamContaFactuFrom.setValDesc(
				(java.lang.String)FormatUtils.parseObject(valDesc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			intParamContaFactuFrom.setValGrupArti(
				(java.lang.String)FormatUtils.parseObject(valGrupArti, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.SegMarcaProduData maprOidMarcProdData = null;
			if(maprOidMarcProd != null && !maprOidMarcProd.trim().equals("")){
				maprOidMarcProdData = new es.indra.belcorp.mso.SegMarcaProduData();
				maprOidMarcProdData.setId(new Long(maprOidMarcProd));
			}
			intParamContaFactuFrom.setMaprOidMarcProd(maprOidMarcProdData);
			es.indra.belcorp.mso.MaeNegocViewData negoOidNegoData = null;
			if(negoOidNego != null && !negoOidNego.trim().equals("")){
				negoOidNegoData = new es.indra.belcorp.mso.MaeNegocViewData();
				negoOidNegoData.setId(new Long(negoOidNego));
			}
			intParamContaFactuFrom.setNegoOidNego(negoOidNegoData);
			intParamContaFactuFrom.setProdOidProd(
				(java.lang.String)FormatUtils.parseObject(prodOidProd, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.CccCuentContaViewData cucoOidCuenContData = null;
			if(cucoOidCuenCont != null && !cucoOidCuenCont.trim().equals("")){
				cucoOidCuenContData = new es.indra.belcorp.mso.CccCuentContaViewData();
				cucoOidCuenContData.setId(new Long(cucoOidCuenCont));
			}
			intParamContaFactuFrom.setCucoOidCuenCont(cucoOidCuenContData);
			intParamContaFactuFrom.setValIndiDebeHabe(
				(java.lang.String)FormatUtils.parseObject(valIndiDebeHabe, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.IntImporContaFactuData imcfOidImpoContFactData = null;
			if(imcfOidImpoContFact != null && !imcfOidImpoContFact.trim().equals("")){
				imcfOidImpoContFactData = new es.indra.belcorp.mso.IntImporContaFactuData();
				imcfOidImpoContFactData.setId(new Long(imcfOidImpoContFact));
			}
			intParamContaFactuFrom.setImcfOidImpoContFact(imcfOidImpoContFactData);
			
			
			//Construimos el to
			intParamContaFactuTo = (IntParamContaFactuData)intParamContaFactuFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, intParamContaFactuFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, intParamContaFactuTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("intParamContaFactuFrom", intParamContaFactuFrom);
			dto.addProperty("intParamContaFactuTo", intParamContaFactuTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(intParamContaFactuFrom, intParamContaFactuTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad IntParamContaFactu");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad IntParamContaFactu");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(intParamContaFactuFrom, intParamContaFactuTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(IntParamContaFactuData intParamContaFactuFrom, IntParamContaFactuData intParamContaFactuTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				intParamContaFactuFrom.setPaisOidPais(paisOculto);
				intParamContaFactuTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(IntParamContaFactuData intParamContaFactuFrom, IntParamContaFactuData intParamContaFactuTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				intParamContaFactuFrom.setPaisOidPais(paisOculto); 
				intParamContaFactuTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





