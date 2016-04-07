

/*
    INDRA/CAR/mmg
    $Id: CccTipoAbonoSubprTransactionComboLoad.java,v 1.1 2009/12/03 18:41:12 pecbazalar Exp $
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
public class CccTipoAbonoSubprTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCccTipoAbonoSubprQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "CccTipoAbonoSubprConectorCombo";

	// Definicion del constructor
	public CccTipoAbonoSubprTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad CccTipoAbonoSubpr");
			
			String subpOidSubp = (String)getEntrada("subpOidSubp");
			traza("MMG:: Valor de atributo subpOidSubp: " + subpOidSubp);
			
			String tcabOidTcab = (String)getEntrada("tcabOidTcab");
			traza("MMG:: Valor de atributo tcabOidTcab: " + tcabOidTcab);
			
			String cucoOidCuenCont = (String)getEntrada("cucoOidCuenCont");
			traza("MMG:: Valor de atributo cucoOidCuenCont: " + cucoOidCuenCont);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CccTipoAbonoSubprData cccTipoAbonoSubpr =new CccTipoAbonoSubprData();
			es.indra.belcorp.mso.CccSubprData subpOidSubpData = null;
			if(subpOidSubp != null && !subpOidSubp.trim().equals("")){
				subpOidSubpData = new es.indra.belcorp.mso.CccSubprData();
				subpOidSubpData.setId(new Long(subpOidSubp));
			}
			cccTipoAbonoSubpr.setSubpOidSubp(subpOidSubpData);
			es.indra.belcorp.mso.CccTipoCargoAbonoData tcabOidTcabData = null;
			if(tcabOidTcab != null && !tcabOidTcab.trim().equals("")){
				tcabOidTcabData = new es.indra.belcorp.mso.CccTipoCargoAbonoData();
				tcabOidTcabData.setId(new Long(tcabOidTcab));
			}
			cccTipoAbonoSubpr.setTcabOidTcab(tcabOidTcabData);
			es.indra.belcorp.mso.CccCuentContaData cucoOidCuenContData = null;
			if(cucoOidCuenCont != null && !cucoOidCuenCont.trim().equals("")){
				cucoOidCuenContData = new es.indra.belcorp.mso.CccCuentContaData();
				cucoOidCuenContData.setId(new Long(cucoOidCuenCont));
			}
			cccTipoAbonoSubpr.setCucoOidCuenCont(cucoOidCuenContData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cccTipoAbonoSubprFrom", cccTipoAbonoSubpr);
			dto.addProperty("cccTipoAbonoSubprTo", cccTipoAbonoSubpr.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CccTipoAbonoSubpr");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CccTipoAbonoSubpr");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


