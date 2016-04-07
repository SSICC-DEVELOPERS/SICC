import LPSICCBase;

public class LPModificarRegistrosMAV extends LPSICCBase 
{
  
  public LPModificarRegistrosMAV()
  {

  }

  public void inicio() 
  {
    
  }

  public void ejecucion() throws Exception
  {
    
    this.setTrazaFichero();
    this.rastreo();

    traza("--- LPModificarRegistrosMAV, accion 'buscar' - casoUso 'modificar' ---");
    String accion = "buscar";
    String casoUso = "modificar";
    this.conectorAction("LPMantenimientoRegistrosMAV");
    this.conectorActionParametro("accion", accion);
    this.conectorActionParametro("casoUso", casoUso);

  }

}