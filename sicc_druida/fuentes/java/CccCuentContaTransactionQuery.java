

/*
    INDRA/CAR/mmg
    $Id: CccCuentContaTransactionQuery.java,v 1.1 2009/12/03 18:37:49 pecbazalar Exp $
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
public class CccCuentContaTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	public static final String CHOICE_ATTRIBUTE = "Descripcion";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCccCuentContaQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CccCuentContaConectorQueryList";

	// Definicion del constructor
	public CccCuentContaTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CccCuentConta");
			String codCuenCont = (String)getEntrada("codCuenCont");
			traza("MMG:: Valor de atributo codCuenCont: " + codCuenCont);
			if(codCuenCont != null && !codCuenCont.trim().equals("")) codCuenCont = codCuenCont.toUpperCase();
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			String codCuenSap = (String)getEntrada("codCuenSap");
			traza("MMG:: Valor de atributo codCuenSap: " + codCuenSap);
			if(codCuenSap != null && !codCuenSap.trim().equals("")) codCuenSap = codCuenSap.toUpperCase();
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CccCuentContaData cccCuentContaFrom =new CccCuentContaData();
			CccCuentContaData cccCuentContaTo = new CccCuentContaData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			cccCuentContaFrom.setCodCuenCont(
				(java.lang.String)FormatUtils.parseObject(codCuenCont, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccCuentContaFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccCuentContaFrom.setCodCuenSap(
				(java.lang.String)FormatUtils.parseObject(codCuenSap, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			cccCuentContaTo = (CccCuentContaData)cccCuentContaFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cccCuentContaFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cccCuentContaTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cccCuentContaFrom", cccCuentContaFrom);
			dto.addProperty("cccCuentContaTo", cccCuentContaTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(cccCuentContaFrom, cccCuentContaTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CccCuentConta");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CccCuentConta");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(cccCuentContaFrom, cccCuentContaTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(CccCuentContaData cccCuentContaFrom, CccCuentContaData cccCuentContaTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccCuentContaFrom.setPaisOidPais(paisOculto);
				cccCuentContaTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(CccCuentContaData cccCuentContaFrom, CccCuentContaData cccCuentContaTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccCuentContaFrom.setPaisOidPais(paisOculto);
				cccCuentContaTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





