

/*
    INDRA/CAR/mmg
    $Id: PedProceTransactionComboLoad.java,v 1.1 2009/12/03 18:41:37 pecbazalar Exp $
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
public class PedProceTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPedProceQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "PedProceConectorCombo";

	// Definicion del constructor
	public PedProceTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad PedProce");
			
			String grprOidGrupProc = (String)getEntrada("grprOidGrupProc");
			traza("MMG:: Valor de atributo grprOidGrupProc: " + grprOidGrupProc);
			
			String progOidProg = (String)getEntrada("progOidProg");
			traza("MMG:: Valor de atributo progOidProg: " + progOidProg);
			
			String procOidProc = (String)getEntrada("procOidProc");
			traza("MMG:: Valor de atributo procOidProc: " + procOidProc);
			
			String tposOidTipoPosi = (String)getEntrada("tposOidTipoPosi");
			traza("MMG:: Valor de atributo tposOidTipoPosi: " + tposOidTipoPosi);
			
			String stpoOidSubtPosi = (String)getEntrada("stpoOidSubtPosi");
			traza("MMG:: Valor de atributo stpoOidSubtPosi: " + stpoOidSubtPosi);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PedProceData pedProce =new PedProceData();
			es.indra.belcorp.mso.PedGrupoProceData grprOidGrupProcData = null;
			if(grprOidGrupProc != null && !grprOidGrupProc.trim().equals("")){
				grprOidGrupProcData = new es.indra.belcorp.mso.PedGrupoProceData();
				grprOidGrupProcData.setId(new Long(grprOidGrupProc));
			}
			pedProce.setGrprOidGrupProc(grprOidGrupProcData);
			es.indra.belcorp.mso.PedProgrData progOidProgData = null;
			if(progOidProg != null && !progOidProg.trim().equals("")){
				progOidProgData = new es.indra.belcorp.mso.PedProgrData();
				progOidProgData.setId(new Long(progOidProg));
			}
			pedProce.setProgOidProg(progOidProgData);
			es.indra.belcorp.mso.PedProceViewData procOidProcData = null;
			if(procOidProc != null && !procOidProc.trim().equals("")){
				procOidProcData = new es.indra.belcorp.mso.PedProceViewData();
				procOidProcData.setId(new Long(procOidProc));
			}
			pedProce.setProcOidProc(procOidProcData);
			es.indra.belcorp.mso.PedTipoPosicData tposOidTipoPosiData = null;
			if(tposOidTipoPosi != null && !tposOidTipoPosi.trim().equals("")){
				tposOidTipoPosiData = new es.indra.belcorp.mso.PedTipoPosicData();
				tposOidTipoPosiData.setId(new Long(tposOidTipoPosi));
			}
			pedProce.setTposOidTipoPosi(tposOidTipoPosiData);
			es.indra.belcorp.mso.PedSubtiPosicViewData stpoOidSubtPosiData = null;
			if(stpoOidSubtPosi != null && !stpoOidSubtPosi.trim().equals("")){
				stpoOidSubtPosiData = new es.indra.belcorp.mso.PedSubtiPosicViewData();
				stpoOidSubtPosiData.setId(new Long(stpoOidSubtPosi));
			}
			pedProce.setStpoOidSubtPosi(stpoOidSubtPosiData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("pedProceFrom", pedProce);
			dto.addProperty("pedProceTo", pedProce.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PedProce");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PedProce");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


