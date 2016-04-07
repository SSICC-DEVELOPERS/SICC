import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.druida.DruidaConectorException;
import es.indra.druida.DruidaTransaction;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOGenerico;
import es.indra.sicc.util.UtilidadesBelcorp;
//import es.indra.sicc.util.DTOOID;


/** 
 * <p>Title: SICC</p>
 * <p>Description: Esta clase se utilizará de forma genérica para todas las
 * operaciones de recarga de combos mediante Druida Transaction</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Indra</p>
 * @author Gonzalo Herreros González
 * @version 1.0
 */
public class DruidaTransactionQuery extends DruidaTransactionComun {
	private static final String CONECTOR_DRUIDA_TRANSACTION = "ConectorDruidaTransactionMare";

  	/**
	 * Definicion del metodo abstracto ejecucion
	 * @see es.indra.druida.base.ObjetoNegocio#ejecucion()
	 */
  	public void ejecucion() throws Exception {                    
         setTrazaFichero();
         //String XMLout = null;
   		try {
    		Vector vParametros = new Vector();
    
    		//Obtengo los parámetros
    		String idBusiness = (String) getEntrada("idBusiness");
  			String nombreDTO  = (String) getEntrada("dto");
  			String parametros = (String) getEntrada("parametros");
        
			//Almaceno el dto en el vector de parametros
        	DTOGenerico dtoGenerico = new DTOGenerico(nombreDTO, parametros);        	

			traza("dtoGenerico "  + dtoGenerico);
	         vParametros.add(dtoGenerico.toDTO());
         
			//Añado el idNegocio al vector de parametros
			vParametros.add(new MareBusinessID(idBusiness));

        	//Invocamos al conector generico
        	DruidaConector conector = conectar(CONECTOR_DRUIDA_TRANSACTION, vParametros);
         traza("conector:"+conector.getXML());
         //UtilidadesLog.info(conector.getXML().toString());        
        	//Definimos el resultado del conector transaccional
         //Provocamos error en tiempo de ejecucion para mandar XMLout en exception
         /*String str = new String();
         str.charAt(0);*/
        	setConector(conector);       
   		}catch (Exception e) {
               throw new DruidaConectorException(obtenerMensajeError(e));
   		}
  }
   
}

