package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;


public class DTODatosPallets extends DTOBelcorp {
    private ArrayList listaPallets;

    public DTODatosPallets() {
    }

    public ArrayList getListaPallets() {
        return listaPallets;
    }

    public void setListaPallets(ArrayList listaPallets) {
        this.listaPallets = listaPallets;
    }
}