package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOUnidadGeoRegistro extends DTOAuditableSICC  {
    private String tipoOP;
    private String cliente;
    private String dato1;
    private String dato2;
    private String dato3;
    private String dato4;
    private String dato5;
    private String dato6;
    private String dato7;

    public DTOUnidadGeoRegistro() {
        super();
    }

    public String getTipoOP() {
        return tipoOP;
    }

    public void setTipoOP(String newTipoOP) {
        tipoOP = newTipoOP;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String newCliente) {
        cliente = newCliente;
    }

    public String getDato1() {
        return dato1;
    }

    public void setDato1(String newDato1) {
        dato1 = newDato1;
    }

    public String getDato2() {
        return dato2;
    }

    public void setDato2(String newDato2) {
        dato2 = newDato2;
    }

    public String getDato3() {
        return dato3;
    }

    public void setDato3(String newDato3) {
        dato3 = newDato3;
    }

    public String getDato4() {
        return dato4;
    }

    public void setDato4(String newDato4) {
        dato4 = newDato4;
    }

    public String getDato5() {
        return dato5;
    }

    public void setDato5(String newDato5) {
        dato5 = newDato5;
    }

    public String getDato6() {
        return dato6;
    }

    public void setDato6(String newDato6) {
        dato6 = newDato6;
    }

    public String getDato7() {
        return dato7;
    }

    public void setDato7(String newDato7) {
        dato7 = newDato7;
    }
}