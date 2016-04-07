import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;

public class LPInsertarMensaje extends LPSICCBase {

  public LPInsertarMensaje(){
    super();
  }

  public void inicio() throws Exception {}

  public void ejecucion() throws Exception {

    try{
      this.setTrazaFichero();

      traza( "TIRO INSERCION DE MENSAJE....." );
      this.conectorAction( "LPMantenimientoMensajes" );

      this.conectorActionParametro( "opcionMenu", "Insertar mensaje" );
      this.conectorActionParametro( "casoDeUso", "Insertar mensaje" );
      this.conectorActionParametro( "accion", "" );
    } catch( Exception e ){
      traza( "Tiro exception en LPInsertarMensaje" );
    }
    
  }
}
