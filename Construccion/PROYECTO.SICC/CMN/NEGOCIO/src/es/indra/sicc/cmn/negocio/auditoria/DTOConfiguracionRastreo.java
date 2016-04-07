package es.indra.sicc.cmn.negocio.auditoria;
import java.util.HashSet;
import es.indra.sicc.util.DTOBelcorp;
import java.util.HashMap;

public class DTOConfiguracionRastreo extends DTOBelcorp {
  private HashMap usuariosRastreados;
  private HashSet funcionesRastreadas;

  public DTOConfiguracionRastreo() {
  }

  public HashMap getUsuariosRastreados() {
    return usuariosRastreados;
  }

  public void setUsuariosRastreados(HashMap newUsuariosRastreados) {
    usuariosRastreados = newUsuariosRastreados;
  }

  public HashSet getFuncionesRastreadas() {
    return funcionesRastreadas;
  }

  public void setFuncionesRastreadas(HashSet newFuncionesRastreadas) {
    funcionesRastreadas = newFuncionesRastreadas;
  }
}