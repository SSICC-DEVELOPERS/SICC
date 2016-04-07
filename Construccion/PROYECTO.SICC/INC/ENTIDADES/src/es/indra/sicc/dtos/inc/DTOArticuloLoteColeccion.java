package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;

import java.util.ArrayList;

public class DTOArticuloLoteColeccion extends DTOBelcorp{
    public DTOArticuloLoteColeccion() {
    }
    private ArrayList lista;
    private ArrayList registrosEliminados;
   
    public ArrayList getLista(){
        return this.lista;
    }
    public void setLista(ArrayList lista){
         this.lista = lista;
    }
    public ArrayList getRegistrosEliminados(){
        return this.registrosEliminados;
    }
    public void setRegistrosEliminados(ArrayList registrosEliminados){
        this.registrosEliminados = registrosEliminados;
    }
}
