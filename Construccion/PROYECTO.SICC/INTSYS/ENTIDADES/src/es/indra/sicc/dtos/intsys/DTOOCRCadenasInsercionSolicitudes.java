package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOOCRCadenasInsercionSolicitudes extends DTOBelcorp  {

    private StringBuffer cadenaInsercionSolicitudCabecera;
    private StringBuffer cadenaInsercionValoresDefectoCabeceraYPosicion;
    private StringBuffer cadenaInsercionSolicitudPosicion;

  public DTOOCRCadenasInsercionSolicitudes() {
  }
  
  public StringBuffer getCadenaInsercionSolicitudCabecera()
  {
        return cadenaInsercionSolicitudCabecera;
  }

    public void setCadenaInsercionSolicitudCabecera(StringBuffer cadenaInsercionSolicitudCabecera)
    {
        this.cadenaInsercionSolicitudCabecera = cadenaInsercionSolicitudCabecera;
    }
    public StringBuffer getCadenaInsercionValoresDefectoCabeceraYPosicion()
    {
        return cadenaInsercionValoresDefectoCabeceraYPosicion;
    }

    public void setCadenaInsercionValoresDefectoCabeceraYPosicion(StringBuffer cadenaInsercionValoresDefectoCabeceraYPosicion)
    {
        this.cadenaInsercionValoresDefectoCabeceraYPosicion = cadenaInsercionValoresDefectoCabeceraYPosicion;
    }

    public StringBuffer getCadenaInsercionSolicitudPosicion()
    {
        return cadenaInsercionSolicitudPosicion;
    }

    public void setCadenaInsercionSolicitudPosicion(StringBuffer cadenaInsercionSolicitudPosicion)
    {
        this.cadenaInsercionSolicitudPosicion = cadenaInsercionSolicitudPosicion;
    }

}