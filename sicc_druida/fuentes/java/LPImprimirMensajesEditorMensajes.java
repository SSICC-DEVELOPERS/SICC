

public class LPImprimirMensajesEditorMensajes extends LPSICCBase {

  public LPImprimirMensajesEditorMensajes() {
    super();
  }
    
  public void inicio() throws Exception {
     // pagina("contenido_consultora_enviar");
     // this.getConfiguracionMenu();
  }

  public void ejecucion() throws Exception {
      setTrazaFichero();
      traza("LPImprimirMensajesEditorMensajes");
       conectorAction("LPImprimirMensajesEditor");
       conectorActionParametro("accion","");
  }
}
