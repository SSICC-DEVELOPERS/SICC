

/*
    INDRA/CAR/mmg
    $Id: MaeExencFleteTransactionComboLoad.java,v 1.1 2009/12/03 18:43:51 pecbazalar Exp $
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
public class MaeExencFleteTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeExencFleteQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "MaeExencFleteConectorCombo";

	// Definicion del constructor
	public MaeExencFleteTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad MaeExencFlete");
			
			String ticlOidTipoClie = (String)getEntrada("ticlOidTipoClie");
			traza("MMG:: Valor de atributo ticlOidTipoClie: " + ticlOidTipoClie);
			
			String sbtiOidSubtClie = (String)getEntrada("sbtiOidSubtClie");
			traza("MMG:: Valor de atributo sbtiOidSubtClie: " + sbtiOidSubtClie);
			
			String tcclOidTipoClas = (String)getEntrada("tcclOidTipoClas");
			traza("MMG:: Valor de atributo tcclOidTipoClas: " + tcclOidTipoClas);
			
			String clasOidClas = (String)getEntrada("clasOidClas");
			traza("MMG:: Valor de atributo clasOidClas: " + clasOidClas);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeExencFleteData maeExencFlete =new MaeExencFleteData();
			es.indra.belcorp.mso.MaeTipoClienData ticlOidTipoClieData = null;
			if(ticlOidTipoClie != null && !ticlOidTipoClie.trim().equals("")){
				ticlOidTipoClieData = new es.indra.belcorp.mso.MaeTipoClienData();
				ticlOidTipoClieData.setId(new Long(ticlOidTipoClie));
			}
			maeExencFlete.setTiclOidTipoClie(ticlOidTipoClieData);
			es.indra.belcorp.mso.MaeSubtiClienViewData sbtiOidSubtClieData = null;
			if(sbtiOidSubtClie != null && !sbtiOidSubtClie.trim().equals("")){
				sbtiOidSubtClieData = new es.indra.belcorp.mso.MaeSubtiClienViewData();
				sbtiOidSubtClieData.setId(new Long(sbtiOidSubtClie));
			}
			maeExencFlete.setSbtiOidSubtClie(sbtiOidSubtClieData);
			es.indra.belcorp.mso.MaeTipoClasiClienViewData tcclOidTipoClasData = null;
			if(tcclOidTipoClas != null && !tcclOidTipoClas.trim().equals("")){
				tcclOidTipoClasData = new es.indra.belcorp.mso.MaeTipoClasiClienViewData();
				tcclOidTipoClasData.setId(new Long(tcclOidTipoClas));
			}
			maeExencFlete.setTcclOidTipoClas(tcclOidTipoClasData);
			es.indra.belcorp.mso.MaeClasiViewData clasOidClasData = null;
			if(clasOidClas != null && !clasOidClas.trim().equals("")){
				clasOidClasData = new es.indra.belcorp.mso.MaeClasiViewData();
				clasOidClasData.setId(new Long(clasOidClas));
			}
			maeExencFlete.setClasOidClas(clasOidClasData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeExencFleteFrom", maeExencFlete);
			dto.addProperty("maeExencFleteTo", maeExencFlete.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeExencFlete");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeExencFlete");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


