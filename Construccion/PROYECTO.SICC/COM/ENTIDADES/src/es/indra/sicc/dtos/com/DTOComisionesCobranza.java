/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DTOComisionesCobranza
 * Fecha:             15/03/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-201-334-N033-1
 * Descripcion:       DTOComisionesCobranza
 * @version           1.0
 * @autor             Carlos Leal
 */


package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

public class DTOComisionesCobranza extends DTOAuditableSICC 
{
  private Long oid;
  private Long oidComisiones;
  private Integer diasTrasFacturacion;
  private Long oidTipoParticipante;
  private ArrayList comisionesCobranzasTipoParticipante;
  
  // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
  private ArrayList comisionesEscalonada;

  public DTOComisionesCobranza()
  {
    this.comisionesEscalonada = new ArrayList();
    this.comisionesCobranzasTipoParticipante = new ArrayList();
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidComisiones()
  {
    return oidComisiones;
  }

  public void setOidComisiones(Long oidComisiones)
  {
    this.oidComisiones = oidComisiones;
  }

  public Integer getDiasTrasFacturacion()
  {
    return diasTrasFacturacion;
  }

  public void setDiasTrasFacturacion(Integer diasTrasFacturacion)
  {
    this.diasTrasFacturacion = diasTrasFacturacion;
  }

  public Long getOidTipoParticipante()
  {
    return oidTipoParticipante;
  }

  public void setOidTipoParticipante(Long oidTipoParticipante)
  {
    this.oidTipoParticipante = oidTipoParticipante;
  }

  public ArrayList getComisionesCobranzasTipoParticipante()
  {
    return comisionesCobranzasTipoParticipante;
  }

  public void setComisionesCobranzasTipoParticipante(ArrayList comisionesCobranzasTipoParticipante)
  {
    this.comisionesCobranzasTipoParticipante = comisionesCobranzasTipoParticipante;
  }

    public void setComisionesEscalonada(ArrayList comisionesEscalonada) {
        this.comisionesEscalonada = comisionesEscalonada;
    }

    public ArrayList getComisionesEscalonada() {
        return comisionesEscalonada;
    }
}
