package es.indra.sicc.dtos.zon;
import java.sql.Date;
import es.indra.sicc.util.DTOBelcorp;


public class DTOUnidadAdmRegistro extends DTOBelcorp {
    private String tipoOP;
    private String Dato1;
    private String Cliente;
    private String Dato2;
    private String Dato3;
    private String Dato4;
    private  String Dato5;
	private String Dato6;
	private String Dato7;

    public DTOUnidadAdmRegistro() {
    }

    public String getTipoOP() {
        return tipoOP;
    }

    public void setTipoOP(String newTipoOP) {
        tipoOP = newTipoOP;
    }

    public String getDato1() {
        return Dato1;
    }

    public void setDato1(String newDato1) {
        Dato1 = newDato1;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String newCliente) {
        Cliente = newCliente;
    }

    public String getDato2() {
        return Dato2;
    }

    public void setDato2(String newDato2) {
        Dato2 = newDato2;
    }

    public String getDato3() {
        return Dato3;
    }

    public void setDato3(String newDato3) {
        Dato3 = newDato3;
    }

    public String getDato4() {
        return Dato4;
    }

    public void setDato4(String newDato4)  {
        Dato4 = newDato4;
    }

    public String getDato5() {
        return Dato5;
    }

    public void setDato5(String newDato5) {
        Dato5 = newDato5;
    }

    public String getDato6() {
		return Dato6;
    }

    public void setDato6(String newDato6) {
		Dato6 = newDato6;
    }

    public String getDato7() {
		return Dato7;
    }

    public void setDato7(String newDato7) {
		Dato7 = newDato7;
    }

}