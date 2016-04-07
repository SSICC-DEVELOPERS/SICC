

/*
    INDRA/CAR/mmg
    $Id: SegTipoCambiTransactionComboLoad.java,v 1.1 2009/12/03 18:39:40 pecbazalar Exp $
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
public class SegTipoCambiTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGSegTipoCambiQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "SegTipoCambiConectorCombo";

	// Definicion del constructor
	public SegTipoCambiTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad SegTipoCambi");
			
			String moneOidMon1 = (String)getEntrada("moneOidMon1");
			traza("MMG:: Valor de atributo moneOidMon1: " + moneOidMon1);
			
			String moneOidMon2 = (String)getEntrada("moneOidMon2");
			traza("MMG:: Valor de atributo moneOidMon2: " + moneOidMon2);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			SegTipoCambiData segTipoCambi =new SegTipoCambiData();
			es.indra.belcorp.mso.SegMonedData moneOidMon1Data = null;
			if(moneOidMon1 != null && !moneOidMon1.trim().equals("")){
				moneOidMon1Data = new es.indra.belcorp.mso.SegMonedData();
				moneOidMon1Data.setId(new Long(moneOidMon1));
			}
			segTipoCambi.setMoneOidMon1(moneOidMon1Data);
			es.indra.belcorp.mso.SegMonedData moneOidMon2Data = null;
			if(moneOidMon2 != null && !moneOidMon2.trim().equals("")){
				moneOidMon2Data = new es.indra.belcorp.mso.SegMonedData();
				moneOidMon2Data.setId(new Long(moneOidMon2));
			}
			segTipoCambi.setMoneOidMon2(moneOidMon2Data);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("segTipoCambiFrom", segTipoCambi);
			dto.addProperty("segTipoCambiTo", segTipoCambi.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad SegTipoCambi");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad SegTipoCambi");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


