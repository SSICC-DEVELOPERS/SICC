/*
 *      LPConsultarHistoricoDeuda.java
 */
 
 /**
  *   author: splatas
  */

public class LPConsultarHistoricoDeuda extends LPSICCBase {

  private String accion = null; 
    
    
  public  LPConsultarHistoricoDeuda() {
        super();
  }


 /* 
  * -> Asignar "contenido_historico_deuda_consultar" 
  */
  public void inicio() throws Exception {       

      //[1]  pagina("contenido_historico_deuda_consultar");
  }


 /*
  *   Si (acción == "") entonces 
  *       -> ejecutar método privado "cargarPagina()" 
  *   Si no Si (accion == "clienteSeleccionado") entonces 
  *       -> ejecutar método privado "clienteSeleccionado()" 
  *   Si no Si (accion == "buscar") entonces 
  *       -> ejecutar método privado "buscar()" 
  *   Fin Si
  */
  public void ejecucion() throws Exception {
        
        try {
			setTrazaFichero();
			//traza("Ejecucion LP Consultar Historico Deuda");
          
          accion = conectorParametroLimpia("accion","",true);

          
          if( accion.equals("")) {
            cargarPagina();
          } else  if( accion.equals("clienteSeleccionado") ) {
            clienteSeleccionado();        
          } else  if( accion.equals("buscar") ) {
            buscar();
          }
          
          getConfiguracionMenu();
        }
        catch (Exception e) {
          //System.out.println("Entró en catch por...");
          e.printStackTrace();
        }        
  } 
     
     
 /*
  *  -> Mostrar página
  */
  private void cargarPagina() throws Exception  {
      
      pagina("contenido_historico_deuda_consultar");  
      asignarAtributo("VAR","hLongitudCodCliente", "valor",
                this.obtenerLongitudCodigoCliente().toString());
  
  }


 /*
  *  -> Tomar de sesión el parámetro "codigoCliente" y mapearlo en el campo 
  *     "codigoCliente" de la pantalla 
  *  -> Deshabilitar el campo "codigoCliente" y el botón de búsqueda de 
  *     clientes para que el usuario no pueda cambiarlo 
  *  -> Mostrar página
  */
  private void clienteSeleccionado() throws Exception {
  
    String codigoCliente = (String) conectorParametro("codigoCliente");
	cargarPagina();
    asignarAtributo("VAR", "accion", "valor", "clienteSeleccionado");   
	asignarAtributo("CTEXTO", "txtCodigoCliente", "valor", codigoCliente);   //[1] asignarAtributo("VAR", "codigoCliente", "valor", codigoCliente);
  }


 /*
  * -> Llamar a la lp "COBConsultaCobranza" pasando como parámetro el campo 
  *     "codigoCliente" con el valor de pantalla
  */
  private void buscar() throws Exception {  
    
    String codigoCliente = conectorParametroLimpia("txtCodigoCliente", "", true);
    
    conectorAction("COBConsultaCobranza");
    conectorActionParametro("accion", "generar"); 
    conectorActionParametro("codigoCliente", codigoCliente); 
	conectorActionParametro("camposBusqueda", "1");
    
    /*
     * ref.:  LPConsultarResumen.java ->  conectorAction("LPResumen");
     */
  }

}

