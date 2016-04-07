

/*
    INDRA/CAR/mmg
    $Id: CccSucurTransactionComboLoad.java,v 1.1 2009/12/03 18:35:42 pecbazalar Exp $
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
public class CccSucurTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCccSucurQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "CccSucurConectorCombo";

	// Definicion del constructor
	public CccSucurTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad CccSucur");
			
			String cbanOidBanc = (String)getEntrada("cbanOidBanc");
			traza("MMG:: Valor de atributo cbanOidBanc: " + cbanOidBanc);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CccSucurData cccSucur =new CccSucurData();
			es.indra.belcorp.mso.CccBancoData cbanOidBancData = null;
			if(cbanOidBanc != null && !cbanOidBanc.trim().equals("")){
				cbanOidBancData = new es.indra.belcorp.mso.CccBancoData();
				cbanOidBancData.setId(new Long(cbanOidBanc));
			}
			cccSucur.setCbanOidBanc(cbanOidBancData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cccSucurFrom", cccSucur);
			dto.addProperty("cccSucurTo", cccSucur.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CccSucur");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CccSucur");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


