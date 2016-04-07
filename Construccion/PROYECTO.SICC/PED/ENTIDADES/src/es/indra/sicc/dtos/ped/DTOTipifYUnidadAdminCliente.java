package es.indra.sicc.dtos.ped;

import es.indra.sicc.util.DTOBelcorp;

import java.util.ArrayList;

public class DTOTipifYUnidadAdminCliente extends DTOBelcorp {

    private ArrayList tipificaciones;
    private ArrayList unidadesAdmin;

    public DTOTipifYUnidadAdminCliente() {
    }

    public void setTipificaciones(ArrayList tipificaciones) {
        this.tipificaciones = tipificaciones;
    }

    public ArrayList getTipificaciones() {
        return tipificaciones;
    }

    public void setUnidadesAdmin(ArrayList unidadesAdmin) {
        this.unidadesAdmin = unidadesAdmin;
    }

    public ArrayList getUnidadesAdmin() {
        return unidadesAdmin;
    }
}
