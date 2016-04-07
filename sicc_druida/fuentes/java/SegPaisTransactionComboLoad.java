

/*
    INDRA/CAR/mmg
    $Id: SegPaisTransactionComboLoad.java,v 1.1 2009/12/03 18:38:37 pecbazalar Exp $
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
public class SegPaisTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGSegPaisQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "SegPaisConectorCombo";

	// Definicion del constructor
	public SegPaisTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad SegPais");
			
			String moneOidMone = (String)getEntrada("moneOidMone");
			traza("MMG:: Valor de atributo moneOidMone: " + moneOidMone);
			
			String moneOidMoneAlt = (String)getEntrada("moneOidMoneAlt");
			traza("MMG:: Valor de atributo moneOidMoneAlt: " + moneOidMoneAlt);
			
			String fopaOidFormPago = (String)getEntrada("fopaOidFormPago");
			traza("MMG:: Valor de atributo fopaOidFormPago: " + fopaOidFormPago);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			SegPaisData segPais =new SegPaisData();
			es.indra.belcorp.mso.SegMonedData moneOidMoneData = null;
			if(moneOidMone != null && !moneOidMone.trim().equals("")){
				moneOidMoneData = new es.indra.belcorp.mso.SegMonedData();
				moneOidMoneData.setId(new Long(moneOidMone));
			}
			segPais.setMoneOidMone(moneOidMoneData);
			es.indra.belcorp.mso.SegMonedData moneOidMoneAltData = null;
			if(moneOidMoneAlt != null && !moneOidMoneAlt.trim().equals("")){
				moneOidMoneAltData = new es.indra.belcorp.mso.SegMonedData();
				moneOidMoneAltData.setId(new Long(moneOidMoneAlt));
			}
			segPais.setMoneOidMoneAlt(moneOidMoneAltData);
			es.indra.belcorp.mso.BelFormaPagoTaponData fopaOidFormPagoData = null;
			if(fopaOidFormPago != null && !fopaOidFormPago.trim().equals("")){
				fopaOidFormPagoData = new es.indra.belcorp.mso.BelFormaPagoTaponData();
				fopaOidFormPagoData.setId(new Long(fopaOidFormPago));
			}
			segPais.setFopaOidFormPago(fopaOidFormPagoData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("segPaisFrom", segPais);
			dto.addProperty("segPaisTo", segPais.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad SegPais");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad SegPais");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


