

/*
    INDRA/CAR/mmg
    $Id: CccCuentCorriBancaTransactionComboLoad.java,v 1.1 2009/12/03 18:39:08 pecbazalar Exp $
    DESC
*/

import java.util.*;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.druida.belcorp.MMGDruidaTransaction;
import es.indra.druida.belcorp.MMGException;
import es.indra.druida.belcorp.MMGNoSessionException;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class CccCuentCorriBancaTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCccCuentCorriBancaQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "CccCuentCorriBancaConectorCombo";

	// Definicion del constructor
	public CccCuentCorriBancaTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad CccCuentCorriBanca");
			
			String sociOidSoci = (String)getEntrada("sociOidSoci");
			traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
			
			String cucoOidCcTeso = (String)getEntrada("cucoOidCcTeso");
			traza("MMG:: Valor de atributo cucoOidCcTeso: " + cucoOidCcTeso);
			
			String cucoOidCcPnte = (String)getEntrada("cucoOidCcPnte");
			traza("MMG:: Valor de atributo cucoOidCcPnte: " + cucoOidCcPnte);
			
			String sucuOidSucu = (String)getEntrada("sucuOidSucu");
			traza("MMG:: Valor de atributo sucuOidSucu: " + sucuOidSucu);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CccCuentCorriBancaData cccCuentCorriBanca =new CccCuentCorriBancaData();
			es.indra.belcorp.mso.SegSocieData sociOidSociData = null;
			if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
				sociOidSociData = new es.indra.belcorp.mso.SegSocieData();
				sociOidSociData.setId(new Long(sociOidSoci));
			}
			cccCuentCorriBanca.setSociOidSoci(sociOidSociData);
			es.indra.belcorp.mso.CccCuentContaData cucoOidCcTesoData = null;
			if(cucoOidCcTeso != null && !cucoOidCcTeso.trim().equals("")){
				cucoOidCcTesoData = new es.indra.belcorp.mso.CccCuentContaData();
				cucoOidCcTesoData.setId(new Long(cucoOidCcTeso));
			}
			cccCuentCorriBanca.setCucoOidCcTeso(cucoOidCcTesoData);
			es.indra.belcorp.mso.CccCuentContaData cucoOidCcPnteData = null;
			if(cucoOidCcPnte != null && !cucoOidCcPnte.trim().equals("")){
				cucoOidCcPnteData = new es.indra.belcorp.mso.CccCuentContaData();
				cucoOidCcPnteData.setId(new Long(cucoOidCcPnte));
			}
			cccCuentCorriBanca.setCucoOidCcPnte(cucoOidCcPnteData);
			es.indra.belcorp.mso.CccSucurData sucuOidSucuData = null;
			if(sucuOidSucu != null && !sucuOidSucu.trim().equals("")){
				sucuOidSucuData = new es.indra.belcorp.mso.CccSucurData();
				sucuOidSucuData.setId(new Long(sucuOidSucu));
			}
			cccCuentCorriBanca.setSucuOidSucu(sucuOidSucuData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cccCuentCorriBancaFrom", cccCuentCorriBanca);
			dto.addProperty("cccCuentCorriBancaTo", cccCuentCorriBanca.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CccCuentCorriBanca");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CccCuentCorriBanca");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


