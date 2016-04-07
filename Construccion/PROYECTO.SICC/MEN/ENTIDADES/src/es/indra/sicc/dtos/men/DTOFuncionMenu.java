package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.util.Collection;

public class DTOFuncionMenu  extends DTOAuditableSICC {
	private Long padre;
	private Boolean rastreo;
	private Boolean nivel;
	private Long oid;
	private Collection attriTraducible;
  private String programaEjecutable;
    private String usuario;
    private String password;
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

  public String getProgramaEjecutable() {
    return this.programaEjecutable;
  }

  public void setProgramaEjecutable(String newProgramaEjecutable) {
    this.programaEjecutable = newProgramaEjecutable;
  }

	public Long getPadre() {
		return padre;
	}

	public void setPadre(Long newPadre) {
		padre = newPadre;
	}

	public Boolean getRastreo() {
		return rastreo;
	}

	public void setRastreo(Boolean newRastreo) {
		rastreo = newRastreo;
	}

	public Boolean getNivel() {
		return nivel;
	}

	public void setNivel(Boolean newNivel) {
		nivel = newNivel;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public Collection getAttriTraducible() {
		return attriTraducible;
	}

	public void setAttriTraducible(Collection newAttriTraducible) {
		attriTraducible = newAttriTraducible;
	}


	
}