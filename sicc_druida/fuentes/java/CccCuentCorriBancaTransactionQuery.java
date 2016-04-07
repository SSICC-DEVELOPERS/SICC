

/*
    INDRA/CAR/mmg
    $Id: CccCuentCorriBancaTransactionQuery.java,v 1.1 2009/12/03 18:41:35 pecbazalar Exp $
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
public class CccCuentCorriBancaTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCccCuentCorriBancaQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CccCuentCorriBancaConectorQueryList";

	// Definicion del constructor
	public CccCuentCorriBancaTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CccCuentCorriBanca");
			String codCc = (String)getEntrada("codCc");
			traza("MMG:: Valor de atributo codCc: " + codCc);
			if(codCc != null && !codCc.trim().equals("")) codCc = codCc.toUpperCase();
			String sociOidSoci = (String)getEntrada("sociOidSoci");
			traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
			if(sociOidSoci != null && !sociOidSoci.trim().equals("")) sociOidSoci = sociOidSoci.toUpperCase();
			String desCc = (String)getEntrada("desCc");
			traza("MMG:: Valor de atributo desCc: " + desCc);
			if(desCc != null && !desCc.trim().equals("")) desCc = desCc.toUpperCase();
			String cucoOidCcTeso = (String)getEntrada("cucoOidCcTeso");
			traza("MMG:: Valor de atributo cucoOidCcTeso: " + cucoOidCcTeso);
			if(cucoOidCcTeso != null && !cucoOidCcTeso.trim().equals("")) cucoOidCcTeso = cucoOidCcTeso.toUpperCase();
			String cucoOidCcPnte = (String)getEntrada("cucoOidCcPnte");
			traza("MMG:: Valor de atributo cucoOidCcPnte: " + cucoOidCcPnte);
			if(cucoOidCcPnte != null && !cucoOidCcPnte.trim().equals("")) cucoOidCcPnte = cucoOidCcPnte.toUpperCase();
			String codCcBanc = (String)getEntrada("codCcBanc");
			traza("MMG:: Valor de atributo codCcBanc: " + codCcBanc);
			if(codCcBanc != null && !codCcBanc.trim().equals("")) codCcBanc = codCcBanc.toUpperCase();
			String sucuOidSucu = (String)getEntrada("sucuOidSucu");
			traza("MMG:: Valor de atributo sucuOidSucu: " + sucuOidSucu);
			if(sucuOidSucu != null && !sucuOidSucu.trim().equals("")) sucuOidSucu = sucuOidSucu.toUpperCase();
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CccCuentCorriBancaData cccCuentCorriBancaFrom =new CccCuentCorriBancaData();
			CccCuentCorriBancaData cccCuentCorriBancaTo = new CccCuentCorriBancaData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			cccCuentCorriBancaFrom.setCodCc(
				(java.lang.String)FormatUtils.parseObject(codCc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.SegSocieData sociOidSociData = null;
			if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
				sociOidSociData = new es.indra.belcorp.mso.SegSocieData();
				sociOidSociData.setId(new Long(sociOidSoci));
			}
			cccCuentCorriBancaFrom.setSociOidSoci(sociOidSociData);
			cccCuentCorriBancaFrom.setDesCc(
				(java.lang.String)FormatUtils.parseObject(desCc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.CccCuentContaData cucoOidCcTesoData = null;
			if(cucoOidCcTeso != null && !cucoOidCcTeso.trim().equals("")){
				cucoOidCcTesoData = new es.indra.belcorp.mso.CccCuentContaData();
				cucoOidCcTesoData.setId(new Long(cucoOidCcTeso));
			}
			cccCuentCorriBancaFrom.setCucoOidCcTeso(cucoOidCcTesoData);
			es.indra.belcorp.mso.CccCuentContaData cucoOidCcPnteData = null;
			if(cucoOidCcPnte != null && !cucoOidCcPnte.trim().equals("")){
				cucoOidCcPnteData = new es.indra.belcorp.mso.CccCuentContaData();
				cucoOidCcPnteData.setId(new Long(cucoOidCcPnte));
			}
			cccCuentCorriBancaFrom.setCucoOidCcPnte(cucoOidCcPnteData);
			cccCuentCorriBancaFrom.setCodCcBanc(
				(java.lang.String)FormatUtils.parseObject(codCcBanc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.CccSucurData sucuOidSucuData = null;
			if(sucuOidSucu != null && !sucuOidSucu.trim().equals("")){
				sucuOidSucuData = new es.indra.belcorp.mso.CccSucurData();
				sucuOidSucuData.setId(new Long(sucuOidSucu));
			}
			cccCuentCorriBancaFrom.setSucuOidSucu(sucuOidSucuData);
			
			
			//Construimos el to
			cccCuentCorriBancaTo = (CccCuentCorriBancaData)cccCuentCorriBancaFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cccCuentCorriBancaFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cccCuentCorriBancaTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cccCuentCorriBancaFrom", cccCuentCorriBancaFrom);
			dto.addProperty("cccCuentCorriBancaTo", cccCuentCorriBancaTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(cccCuentCorriBancaFrom, cccCuentCorriBancaTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CccCuentCorriBanca");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CccCuentCorriBanca");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(cccCuentCorriBancaFrom, cccCuentCorriBancaTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(CccCuentCorriBancaData cccCuentCorriBancaFrom, CccCuentCorriBancaData cccCuentCorriBancaTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccCuentCorriBancaFrom.setPaisOidPais(paisOculto);
				cccCuentCorriBancaTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(CccCuentCorriBancaData cccCuentCorriBancaFrom, CccCuentCorriBancaData cccCuentCorriBancaTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccCuentCorriBancaFrom.setPaisOidPais(paisOculto);
				cccCuentCorriBancaTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





