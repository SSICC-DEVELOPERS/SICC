import LPSICCBase;

public class LPConsultarRegistrosMAV extends LPSICCBase 
{
  
  public LPConsultarRegistrosMAV()
  {

  }

  public void inicio() 
  {
    
  }

  public void ejecucion() throws Exception
  {
    
    this.setTrazaFichero();
    this.rastreo();

    traza("--- LPConsultarRegistrosMAV, accion 'buscar' - casoUso 'consultar'");
    String accion = "buscar";
    String casoUso = "consultar";
    this.conectorAction("LPMantenimientoRegistrosMAV");
    this.conectorActionParametro("accion", accion);
    this.conectorActionParametro("casoUso", casoUso);

  }

}