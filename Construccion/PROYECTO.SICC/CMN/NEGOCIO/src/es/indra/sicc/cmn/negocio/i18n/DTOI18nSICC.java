package es.indra.sicc.cmn.negocio.i18n;
import es.indra.sicc.util.DTOBelcorp;

public class DTOI18nSICC extends DTOBelcorp  {
    private Long oidAtriuto;
    private String valorI18n;

    public DTOI18nSICC() {
    }

    public Long getOidAtriuto() {
        return oidAtriuto;
    }

    public void setOidAtriuto(Long newOidAtriuto) {
        oidAtriuto = newOidAtriuto;
    }

    public String getValorI18n() {
        return valorI18n;
    }

    public void setValorI18n(String newValorI18n) {
        valorI18n = newValorI18n;
    }

    
}