package es.indra.sicc.dtos.ccc;

//import es .indra.sicc.dtos.ccc.
import java.util.Date;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarRegistroVentas extends DTOSiccPaginacion {
	public DTOBuscarRegistroVentas() {
	}

	Date  fechaEmisionDesde;  
	Date fechaEmisionHasta;     
	String codigoClienteDesde;     
	String codigoClienteHasta;  
	Long  oidImpuestos;  
	Date  fechaCierre;
        private Long oidSubacceso;
        private Long oidTipoDocLegal;
        private String serieDocuLegal;
        private String numeroDocLegalDesde;
        private String numeroDocLegalHasta;
        private String exportar;
       // vbongiov -- Cambio 20070451 --14/11/2008
        private String fichero;

        //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
        private String oid;         

	public String getCodigoClienteDesde() {
		return codigoClienteDesde;
	}

	public void setCodigoClienteDesde(String newCodigoClienteDesde) {
		codigoClienteDesde = newCodigoClienteDesde;
	}

	public String getCodigoClienteHasta() {
		return codigoClienteHasta;
	}

	public void setCodigoClienteHasta(String newCodigoClienteHasta) {
		codigoClienteHasta = newCodigoClienteHasta;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date newFechaCierre) {
		fechaCierre = newFechaCierre;
	}

	public Date getFechaEmisionDesde() {
		return fechaEmisionDesde;
	}

	public void setFechaEmisionDesde(Date newFechaEmisionDesde) {
		fechaEmisionDesde = newFechaEmisionDesde;
	}

	public Date getFechaEmisionHasta() {
		return fechaEmisionHasta;
	}

	public void setFechaEmisionHasta(Date newFechaEmisionHasta) {
		fechaEmisionHasta = newFechaEmisionHasta;
	}

	public Long getOidImpuestos() {
		return oidImpuestos;
	}

	public void setOidImpuestos(Long newOidImpuestos) {
		oidImpuestos = newOidImpuestos;
	}
    public Long getOidSubacceso()
     {
       return oidSubacceso;
     }

     public void setOidSubacceso(Long oidSubacceso)
     {
       this.oidSubacceso = oidSubacceso;
     }

     public Long getOidTipoDocLegal()
     {
       return oidTipoDocLegal;
     }

     public void setOidTipoDocLegal(Long oidTipoDocLegal)
     {
       this.oidTipoDocLegal = oidTipoDocLegal;
     }

     public String getSerieDocuLegal()
     {
       return serieDocuLegal;
     }

     public void setSerieDocuLegal(String serieDocuLegal)
     {
       this.serieDocuLegal = serieDocuLegal;
     }

     public String getNumeroDocLegalDesde()
     {
       return numeroDocLegalDesde;
     }

     public void setNumeroDocLegalDesde(String numeroDocLegalDesde)
     {
       this.numeroDocLegalDesde = numeroDocLegalDesde;
     }

     public String getNumeroDocLegalHasta()
     {
       return numeroDocLegalHasta;
     }

     public void setNumeroDocLegalHasta(String numeroDocLegalHasta)
     {
       this.numeroDocLegalHasta = numeroDocLegalHasta;
     }

     public String getExportar()
     {
       return exportar;
     }

     public void setExportar(String exportar)
     {
       this.exportar = exportar;
     }

       public String getFichero()
       {
           return fichero;
       }

       public void setFichero(String fichero)
       {
           this.fichero = fichero;
       }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }
}
