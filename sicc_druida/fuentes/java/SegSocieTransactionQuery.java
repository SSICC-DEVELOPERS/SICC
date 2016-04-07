

/*
    INDRA/CAR/mmg
    $Id: SegSocieTransactionQuery.java,v 1.1 2009/12/03 18:34:17 pecbazalar Exp $
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
public class SegSocieTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	public static final String CHOICE_ATTRIBUTE = "valDeno";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGSegSocieQueryFromToUserPageStructuralSecurity";
	public static final String CONECTOR_QUERY_LIST = "SegSocieConectorQueryList";

	// Definicion del constructor
	public SegSocieTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad SegSocie");
			String codSoci = (String)getEntrada("codSoci");
			traza("MMG:: Valor de atributo codSoci: " + codSoci);
			if(codSoci != null && !codSoci.trim().equals("")) codSoci = codSoci.toUpperCase();
			String valDeno = (String)getEntrada("valDeno");
			traza("MMG:: Valor de atributo valDeno: " + valDeno);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			SegSocieData segSocieFrom =new SegSocieData();
			SegSocieData segSocieTo = new SegSocieData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			segSocieFrom.setCodSoci(
				(java.lang.String)FormatUtils.parseObject(codSoci, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			segSocieFrom.setValDeno(
				(java.lang.String)FormatUtils.parseObject(valDeno, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			segSocieTo = (SegSocieData)segSocieFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, segSocieFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, segSocieTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("segSocieFrom", segSocieFrom);
			dto.addProperty("segSocieTo", segSocieTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", new Boolean(false));
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(segSocieFrom, segSocieTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad SegSocie");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad SegSocie");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(segSocieFrom, segSocieTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(SegSocieData segSocieFrom, SegSocieData segSocieTo) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                segSocieFrom.setPaisOidPais(paisOculto);
                segSocieTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
			
	}
	
	
	public void cmdPostQuery(SegSocieData segSocieFrom, SegSocieData segSocieTo, DruidaConector result) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                segSocieFrom.setPaisOidPais(paisOculto);
                segSocieTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
			
	}
	
	
}





