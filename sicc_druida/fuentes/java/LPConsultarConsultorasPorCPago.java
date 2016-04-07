
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
  * -> Asignar página "contenido_consultoras_compromisopago_consultar" 
  */
  public void inicio() throws Exception {       
        pagina("contenido_consultoras_compromisopago_consultar");
  }


 /*
  *  Si (accion == "") entonces 
  *     -> Mostrar Página 
  *  Si no Si (accion == "clienteSeleccionado") entonces 
  *     -> Tomar de sesión el parámetro "codigoCliente" y mapearlo 
  *       en el campo "codigoCliente" de la pantalla 
  *     -> Deshabilitar el campo "codigoCliente" y el botón de búsqueda de 
  *       clientes para que el usuario no pueda cambiarlo 
  *     -> Mostrar Página 
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
          System.out.println("Entró en catch por...");
          e.printStackTrace();
        }        
  } 
     
     
 /*
  *  -> Mostrar página
  */
  private void cargarPagina() throws Exception  {
        pagina("contenido_consultoras_compromisopago_consultar");  
        asignarAtributo("VAR","hLongitudCodCliente", 
                        "valor", this.obtenerLongitudCodigoCliente().toString());                    
        asignarAtributo("VAR","hOidPais","valor",aPais.toString());
        asignarAtributo("VAR","hOidIdioma","valor",aIdioma.toString());
  }


 /*
  *  -> Tomar de sesión el parámetro "codigoCliente" y mapearlo en el campo 
  *     "codigoCliente" de la pantalla 
  *  -> Deshabilitar el campo "codigoCliente" y el botón de búsqueda de 
  *     clientes para que el usuario no pueda cambiarlo 
  *  -> Mostrar página
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
  
  
     
