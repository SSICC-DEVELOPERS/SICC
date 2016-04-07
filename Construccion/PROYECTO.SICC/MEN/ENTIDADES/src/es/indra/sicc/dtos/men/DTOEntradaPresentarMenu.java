package es.indra.sicc.dtos.men;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOEntradaPresentarMenu extends DTOAuditableSICC   {
	private Long OID_FUNC;
	private String VAL_NOMB_PROG;
	private String FUNC_OID_FUNC;
	private Long IND_NIVE;
	private String IND_RAST;
    private Long idIdioma;
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

	public Long getOID_FUNC() {
		return OID_FUNC;
	}

	public void setOID_FUNC(Long newOID_FUNC) {
		OID_FUNC = newOID_FUNC;
	}

	public String getVAL_NOMB_PROG() {
		return VAL_NOMB_PROG;
	}

	public void setVAL_NOMB_PROG(String newVAL_NOMB_PROG) {
		VAL_NOMB_PROG = newVAL_NOMB_PROG;
	}

	public String getFUNC_OID_FUNC() {
		return FUNC_OID_FUNC;
	}

	public void setFUNC_OID_FUNC(String newFUNC_OID_FUNC) {
		FUNC_OID_FUNC = newFUNC_OID_FUNC;
	}

	public Long getIND_NIVE() {
		return IND_NIVE;
	}

	public void setIND_NIVE(Long newIND_NIVE) {
		IND_NIVE = newIND_NIVE;
	}

	public String getIND_RAST() {
		return IND_RAST;
	}

	public void setIND_RAST(String newIND_RAST) {
		IND_RAST = newIND_RAST;
	}

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long newIdIdioma) {
        idIdioma = newIdIdioma;
    }
}