package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.text.SimpleDateFormat;

public class DTOEstructuraVialCabecera extends DTOAuditableSICC  {

    private String pais;
    private String tipoFichero;
    private Timestamp fecha;

    public DTOEstructuraVialCabecera() {
    }

    public String getTipoFichero() {
        return tipoFichero;
    }

    public void setTipoFichero(String newTipoFichero) {
        tipoFichero = newTipoFichero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String newPais) {
        pais = newPais;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp newFecha) {
        fecha = newFecha;
    }

    /**
     * @return retorna los nombres de los atributos = valor :
     *
     */
    public String dumpToString() {
        StringBuffer result = new StringBuffer();
        Iterator it = getKeys();

        for (; it.hasNext();) {
            Object o = it.next();            
            if (getProperty(o) instanceof java.util.Date) {
                Date date = (Date)getProperty(o);
                SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
                String dateString = format.format(date);
                result.append(o + "=" +  dateString.substring(0,4)+dateString.substring(5,7)+ dateString.substring(8,10) + " : ");
            } else {
                result.append(o + "=" + getProperty(o) + " : ");
            }
        }

        return result.toString().substring(0, result.toString().length()-3);
    }
	
}