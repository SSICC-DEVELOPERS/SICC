

/*
    INDRA/CAR/mmg
    $Id: CalGuiasTransactionQuery.java,v 1.1 2009/12/03 18:37:18 pecbazalar Exp $
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
public class CalGuiasTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCalGuiasQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CalGuiasConectorQueryList";

	// Definicion del constructor
	public CalGuiasTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CalGuias");
			String codGuia = (String)getEntrada("codGuia");
			traza("MMG:: Valor de atributo codGuia: " + codGuia);
			if(codGuia != null && !codGuia.trim().equals("")) codGuia = codGuia.toUpperCase();
			String dpteOidDepa = (String)getEntrada("dpteOidDepa");
			traza("MMG:: Valor de atributo dpteOidDepa: " + dpteOidDepa);
			String valTitu = (String)getEntrada("valTitu");
			traza("MMG:: Valor de atributo valTitu: " + valTitu);
			String fecInicVali = (String)getEntrada("fecInicVali");
			traza("MMG:: Valor de atributo fecInicVali: " + fecInicVali);
			String fecFinVali = (String)getEntrada("fecFinVali");
			traza("MMG:: Valor de atributo fecFinVali: " + fecFinVali);
			String valDescGuia = (String)getEntrada("valDescGuia");
			traza("MMG:: Valor de atributo valDescGuia: " + valDescGuia);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CalGuiasData calGuiasFrom =new CalGuiasData();
			CalGuiasData calGuiasTo = new CalGuiasData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			calGuiasFrom.setCodGuia(
				(java.lang.String)FormatUtils.parseObject(codGuia, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.SegDeptoEmpreData dpteOidDepaData = null;
			if(dpteOidDepa != null && !dpteOidDepa.trim().equals("")){
				dpteOidDepaData = new es.indra.belcorp.mso.SegDeptoEmpreData();
				dpteOidDepaData.setId(new Long(dpteOidDepa));
			}
			calGuiasFrom.setDpteOidDepa(dpteOidDepaData);
			calGuiasFrom.setValTitu(
				(java.lang.String)FormatUtils.parseObject(valTitu, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			calGuiasFrom.setFecInicVali(
				(java.sql.Date)FormatUtils.parseObject(fecInicVali, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			calGuiasFrom.setFecFinVali(
				(java.sql.Date)FormatUtils.parseObject(fecFinVali, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			calGuiasFrom.setValDescGuia(
				(java.lang.String)FormatUtils.parseObject(valDescGuia, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			calGuiasTo = (CalGuiasData)calGuiasFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, calGuiasFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, calGuiasTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("calGuiasFrom", calGuiasFrom);
			dto.addProperty("calGuiasTo", calGuiasTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(calGuiasFrom, calGuiasTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CalGuias");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CalGuias");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(calGuiasFrom, calGuiasTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(CalGuiasData calGuiasFrom, CalGuiasData calGuiasTo) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));calGuiasFrom.setPaisOidPais(paisOculto);calGuiasTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
	public void cmdPostQuery(CalGuiasData calGuiasFrom, CalGuiasData calGuiasTo, DruidaConector result) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));calGuiasFrom.setPaisOidPais(paisOculto);calGuiasTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
}





