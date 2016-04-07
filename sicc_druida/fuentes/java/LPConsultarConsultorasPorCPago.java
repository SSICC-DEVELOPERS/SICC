
import es.indra.sicc.util.UtilidadesSession;/*
 *      LPConsultarConsultorasPorCPago.java
 */
 
 /**
  *   author: splatas
  */

public class LPConsultarConsultorasPorCPago extends LPSICCBase {

  private String accion = null; 
  private Long aPais = null; 
  private Long aIdioma = null; 
    
    
  public  LPConsultarConsultorasPorCPago() {
        super();
  }


 /* 
  * -> Asignar p�gina "contenido_consultoras_compromisopago_consultar" 
  */
  public void inicio() throws Exception {       
        pagina("contenido_consultoras_compromisopago_consultar");
  }


 /*
  *  Si (accion == "") entonces 
  *     -> Mostrar P�gina 
  *  Si no Si (accion == "clienteSeleccionado") entonces 
  *     -> Tomar de sesi�n el par�metro "codigoCliente" y mapearlo 
  *       en el campo "codigoCliente" de la pantalla 
  *     -> Deshabilitar el campo "codigoCliente" y el bot�n de b�squeda de 
  *       clientes para que el usuario no pueda cambiarlo 
  *     -> Mostrar P�gina 
  *  Fin Si
  * 
  */
  public void ejecucion() throws Exception {        
        try {
          getFormatosValidaciones();
          setTrazaFichero();
          
          accion = conectorParametroLimpia("accion","",true);
          
          aPais = UtilidadesSession.getPais(this);
          aIdioma = UtilidadesSession.getIdioma(this);
		  traza("accion: "  + accion);
          
          if( accion.equals("")) {
            cargarPagina();
          
          } else  if( accion.equals("clienteSeleccionado") ) {
			clienteSeleccionado();
          }
          
          getConfiguracionMenu();
        }
        catch (Exception e) {
          System.out.println("Entr� en catch por...");
          e.printStackTrace();
        }        
  } 
     
     
 /*
  *  -> Mostrar p�gina
  */
  private void cargarPagina() throws Exception  {
        pagina("contenido_consultoras_compromisopago_consultar");  
        asignarAtributo("VAR","hLongitudCodCliente", 
                        "valor", this.obtenerLongitudCodigoCliente().toString());                    
        asignarAtributo("VAR","hOidPais","valor",aPais.toString());
        asignarAtributo("VAR","hOidIdioma","valor",aIdioma.toString());
  }


 /*
  *  -> Tomar de sesi�n el par�metro "codigoCliente" y mapearlo en el campo 
  *     "codigoCliente" de la pantalla 
  *  -> Deshabilitar el campo "codigoCliente" y el bot�n de b�squeda de 
  *     clientes para que el usuario no pueda cambiarlo 
  *  -> Mostrar p�gina
  */
  private void clienteSeleccionado() throws Exception {  
	traza("Entro a clienteSeleccionado() ");
    String codigoCliente = (String) conectorParametro("codigoCliente");
    cargarPagina();
	traza("Antes de asignar variables");
	traza("codigoCliente: " + codigoCliente);
	asignarAtributo("VAR", "hCodigoCliente", "valor", codigoCliente);    
    asignarAtributo("VAR", "accion", "valor", "clienteSeleccionado");   
	traza("Salio de clienteSeleccionado() ");
  }


}
  
  
     
