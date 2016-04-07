package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Date;
import java.util.Iterator;
import java.text.SimpleDateFormat;

public class DTOUnidadGeoCabecera extends DTOAuditableSICC  {
    private String pais;
    private String marca;
    private String canal;
    private String tipoPeriodo;
    private String periodoInicio;
    private Date fechaActualizacion;
    private Date fechasCreacionGIS;

    public DTOUnidadGeoCabecera() {
        super();
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String newPais) {
        pais = newPais;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String newMarca) {
        marca = newMarca;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String newCanal) {
        canal = newCanal;
    }

    public String getTipoPeriodo() {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(String newTipoPeriodo) {
        tipoPeriodo = newTipoPeriodo;
    }

    public String getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(String newPeriodoInicio) {
        periodoInicio = newPeriodoInicio;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date newFechaActualizacion) {
        fechaActualizacion = newFechaActualizacion;
    }

    public Date getFechasCreacionGIS() {
        return fechasCreacionGIS;
    }

    public void setFechasCreacionGIS(Date newFechasCreacionGIS) {
        fechasCreacionGIS = newFechasCreacionGIS;
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