/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
 
package es.indra.sicc.logicanegocio.zon;

import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;

public class UnidadAdministrativa  implements Cloneable{
    private Long oid;
    private String codigo;
    private int tipo;
    private ArrayList unidades; //HACER GETTER Y SETTER?
    private ArrayList clientes; //HACER GETTER Y SETTER?
    private String codigoUAPadre;
    private Long oidPadre;
    private String nse1;
    private String nse2;
    private Long oidTerritorio; //HACER GETTER Y SETTER?
    private Long oidTerritorioAdm; //Aparece nuevo en el diseño N028-1
    private Long oidUnidadGeografica; //Aparece nuevo en el diseño N028-1

    public static int SUBGERENCIA = 1;
    public static int REGION = 2;
    public static int ZONA = 3;
    public static int SECCION = 4;
    public static int TERRITORIO = 5;
    // INC 21886 - dmorello, 16/12/2005
    // Se agrega el siguiente campo
    private String descripcion;
    
    /**
     * Incidencia 21886 - dmorello, 06/04/2006
     * Se modifica la firma del constructor agregando el parámetro descripción.
     * 
     * @param descripcion
     * @param codPadre
     * @param cod
     * @param oidUnidad
     * @param tipoUnidad
     */
    public UnidadAdministrativa(int tipoUnidad, Long oidUnidad, String cod, String codPadre, String descripcion) {
        UtilidadesLog.info("UnidadAdministrativa(int tipoUnidad, Long oidUnidad, String cod, String codPadre): Entrada");
        this.tipo = tipoUnidad;
        this.oid = oidUnidad;
        this.codigo= cod;
        this.codigoUAPadre=codPadre; 
        // 21886 - dmorello, 06/04/2006: Se setea la descripcion
        this.descripcion = descripcion;
        
        // Incidencia BELC300018541 
        this.clientes = new ArrayList();
        this.unidades = new ArrayList();
        
        UtilidadesLog.info("UnidadAdministrativa(int tipoUnidad, Long oidUnidad, String cod, String codPadre): Salida");
    }

    /**
     * Incidencia 21886 - dmorello, 06/04/2006
     * Se modifica la firma del constructor agregando el parámetro descripción.
     * 
     * @param descripcion
     * @param cod
     * @param oidUnidad
     * @param tipoUnidad
     */
    public UnidadAdministrativa(int tipoUnidad, Long oidUnidad, String cod, String descripcion) {
        UtilidadesLog.info("UnidadAdministrativa(int tipoUnidad, Long oidUnidad, String cod): Entrada");
        
        this.tipo = tipoUnidad;
        this.oid = oidUnidad;
        this.codigo= cod;
        this.codigoUAPadre="";
        // 21886 - dmorello, 06/04/2006: Se setea la descripción
        this.descripcion = descripcion;

        // Incidencia BELC300018541 
        this.clientes = new ArrayList();
        this.unidades = new ArrayList();
        
        UtilidadesLog.info("UnidadAdministrativa(int tipoUnidad, Long oidUnidad, String cod): Salida");
    }
    
    private void addUnidad(UnidadAdministrativa unidad) {
        UtilidadesLog.info("addUnidad(UnidadAdministrativa unidad): Entrada");
        
        UnidadAdministrativa unidadBuscada = null;
        boolean encontrada = false;
        
        for(int i=0; i<this.unidades.size(); i++) {
            unidadBuscada = (UnidadAdministrativa)this.unidades.get(i);
            if(unidadBuscada.obtenerCodigoUnidad().equals(unidad.obtenerCodigoUnidad())) {
                encontrada = true;
                break;
            }
        }
        
        if(encontrada) {
            for(int i=0; i<unidad.unidades.size(); i++) {
                unidadBuscada.addUnidad((UnidadAdministrativa)unidad.unidades.get(i));
            }
        } else {
            this.unidades.add(unidad);
        }
        
        UtilidadesLog.info("UnidadAdministrativa.addUnidad(UnidadAdministrativa unidad): Salida");
    }

    public String obtenerCodigoUnidad() {
        return this.codigo;
    }

    public String obtenerCodigoCompleto() {
        return this.codigoUAPadre+this.codigo;
    }

    public UnidadAdministrativa fusion(UnidadAdministrativa unidad2, String codigoNuevo) {
        UtilidadesLog.info("UnidadAdministrativa.fusion(UnidadAdministrativa unidad2, String codigoNuevo): Entrada");
        UtilidadesLog.debug("codigoNuevo:" + codigoNuevo);
        
        UnidadAdministrativa nuevaUA = null;
        
        try {
            nuevaUA = this.clonarUA();
        } catch (CloneNotSupportedException e) { }
        
        if (unidad2.unidades != null) {
            try {
                for (int i = 0; i < unidad2.unidades.size(); i++) {
                    UnidadAdministrativa unidadTemporal = (UnidadAdministrativa)unidad2.unidades.get(i);
                    nuevaUA.addUnidad(unidadTemporal.clonarUA());
                }
            } catch (CloneNotSupportedException e) { }

        } 

        if (unidad2.clientes != null && unidad2.clientes.size() > 0) {
                for(int i = 0; i < unidad2.clientes.size(); i++)
                    nuevaUA.getClientes().add(unidad2.getClientes().get(i));
        }
        nuevaUA.codigo = codigoNuevo;
        nuevaUA.actualizarCodigo();
        
        UtilidadesLog.debug("this.unidades:" + this.unidades);
        
        UtilidadesLog.info("UnidadAdministrativa.fusion(UnidadAdministrativa unidad2, String codigoNuevo): Salida");
        return nuevaUA;
    }

    public UnidadAdministrativa clonarUA() throws CloneNotSupportedException {
        UtilidadesLog.info("UnidadAdministrativa.clonarUA(): Entrada");
        
        UnidadAdministrativa unidadAux = null;
        UnidadAdministrativa unidadAux2 = null;
        UnidadAdministrativa unidadNueva = null;
        if (this.tipo == this.TERRITORIO) {
            return (UnidadAdministrativa)this.clone();
        } else {
           unidadNueva = (UnidadAdministrativa)this.clone();
           unidadNueva.setUnidades(new ArrayList());
            for ( int i = 0; i < this.unidades.size(); i++) {
                unidadAux = (UnidadAdministrativa)this.unidades.get(i);

                unidadAux2 = unidadAux.clonarUA();
                if(unidadAux2 != null) {
                     unidadNueva.unidades.add(unidadAux2);
                }
            }
        }
        
        UtilidadesLog.info("UnidadAdministrativa.clonarUA(): Salida");
        return unidadNueva;
    }
    

    public UnidadAdministrativa particion(Long cliente, String nuevoCodigo) {
        UtilidadesLog.info("UnidadAdministrativa.particion(Long cliente, String nuevoCodigo): Entrada");
        UtilidadesLog.info("*** paramet entrada (" + cliente + ", "+nuevoCodigo+" )" );
        
        UnidadAdministrativa nuevaUA = this.buscarCliente(cliente);
        if (nuevaUA!=null){
            nuevaUA.codigoUAPadre = this.codigoUAPadre;
            nuevaUA.codigo = nuevoCodigo;
            nuevaUA.actualizarCodigo();

        }else{
            UtilidadesLog.debug("Error de parametrizacion al particionar RTZ");
        }
        
        UtilidadesLog.info("UnidadAdministrativa.particion(Long cliente, String nuevoCodigo): Salida");
        return nuevaUA;
    }
    
    public UnidadAdministrativa buscarCliente(Long cliente) {
        UtilidadesLog.info("UnidadAdministrativa.buscarCliente(Long cliente): Entrada");
        UtilidadesLog.info("*** paramet entrada (" + cliente + ")" );    
        
        UnidadAdministrativa unidadAux = null;
        UnidadAdministrativa unidadAux2 = null;
        UnidadAdministrativa unidadNueva = null;
        
        UtilidadesLog.info("*** clientes: "+this.clientes.size()+ " ["+ this.getClientes() + " ]"); 
        UtilidadesLog.info("*** unidades: "+this.getUnidades().size()+" ["+ this.getUnidades()+" ]" );
        if(this.tipo == this.TERRITORIO) {
                
            for(int i=0; i<this.clientes.size(); i++) {
                if(cliente.longValue()==((Long)this.clientes.get(i)).longValue()) {
                    unidadAux = new UnidadAdministrativa(this.tipo, this.oid, this.codigo, "");
                    unidadAux.clientes.add(cliente);
                    unidadAux.setOidTerritorio(this.getOidTerritorio());
                    return unidadAux;
                }
            }
            // Si llegamos aquí, es que no lo hemos encontrado
            return null;
        } else {
            for( int i=0; i<this.unidades.size(); i++) {
                unidadAux = (UnidadAdministrativa)this.unidades.get(i);
                
                unidadAux2 = unidadAux.buscarCliente(cliente);
                UtilidadesLog.info("*** UnidadAux2: "+unidadAux2);       
                if(unidadAux2!=null) {
                    unidadNueva = new UnidadAdministrativa(this.getTipo(), this.getOid(), this.codigo, "");
                    unidadNueva.unidades.add(unidadAux2);
                }
            }
        }
        
        UtilidadesLog.info("UnidadAdministrativa.buscarCliente(Long cliente): Salida");
        return unidadNueva;
    }
    /* ELIMINA 20/04/2006 BELC300021813
     public UnidadAdministrativa trasvase(UnidadAdministrativa unidadOrigen) {*/
    
    public void trasvase(UnidadAdministrativa unidadOrigen) { 
    UtilidadesLog.info("UnidadAdministrativa.trasvase(UnidadAdministrativa unidadOrigen): Entrada");
    // Mueve a la UA la unidad recibida
    
        /*ELIMINA 20/04/2006 BELC300021813
        UnidadAdministrativa nuevaUA = null; 
        try{
            nuevaUA = unidadOrigen.clonarUA();
        }
        catch (CloneNotSupportedException e){
        }
        nuevaUA.codigoUAPadre = this.obtenerCodigoCompleto();
        nuevaUA.actualizarCodigo();
        nuevaUA.oidPadre = this.oid;
        this.addUnidad(nuevaUA);
        return nuevaUA; */
        
        //AGREGA
        unidadOrigen.setCodigoUAPadre(this.obtenerCodigoCompleto());
        unidadOrigen.actualizarCodigo();
        this.addUnidad(unidadOrigen);      // Añado la unidad
       //FIN AGREGA
        
    UtilidadesLog.info("UnidadAdministrativa.trasvase(UnidadAdministrativa unidadOrigen): Salida");
    }
    
    public void actualizarCodigo() {
        UtilidadesLog.info("UnidadAdministrativa.actualizarCodigo(): Entrada");
        
        UnidadAdministrativa unidad = null;
        for(int posicion = 0; posicion<this.unidades.size(); posicion++) {
            unidad = (UnidadAdministrativa)this.unidades.get(posicion);
            
            unidad.codigoUAPadre = this.obtenerCodigoCompleto();
            // Se elimina por la BELC300018541
            // unidad.codigoCompleto = this.codigoCompleto + unidad.codigo

            unidad.actualizarCodigo();
            this.unidades.set(posicion, unidad);
        }
        
        UtilidadesLog.info("UnidadAdministrativa.actualizarCodigo(): Salida");
    }

    public Long getOidTerritorio()
    {
        return oidTerritorio;
    }

    public void setOidTerritorio(Long oidTerritorio)
    {
        this.oidTerritorio = oidTerritorio;
    }

    public ArrayList getClientes()
    {
        return clientes;
    }

    public void setClientes(ArrayList clientes)
    {
        this.clientes = clientes;
    }

    public ArrayList getUnidades()
    {
        return unidades;
    }

    public void setUnidades(ArrayList unidades)
    {
        this.unidades = unidades;
    }

    public Long getOid()
    {
        return oid;
    }

    public void setOid(Long oid)
    {
        this.oid = oid;
    }

    public Long getOidPadre()
    {
        return oidPadre;
    }

    public void setOidPadre(Long oidPadre)
    {
        this.oidPadre = oidPadre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNse1() {
        return nse1;
    }

    public void setNse1(String nse1) {
        this.nse1 = nse1;
    }

    public String getNse2() {
        return nse2;
    }

    public void setNse2(String nse2) {
        this.nse2 = nse2;
    }

    public Long getOidTerritorioAdm() {
        return oidTerritorioAdm;
    }

    public void setOidTerritorioAdm(Long oidTerritorioAdm) {
        this.oidTerritorioAdm = oidTerritorioAdm;
    }

    public Long getOidUnidadGeografica() {
        return oidUnidadGeografica;
    }

    public void setOidUnidadGeografica(Long oidUnidadGeografica) {
        this.oidUnidadGeografica = oidUnidadGeografica;
    }

    // INC 21886 - dmorello, 16/12/2005
    public String getDescripcion()
    {
      return descripcion;
    }
  
    // INC 21886 - dmorello, 16/12/2005
    public void setDescripcion(String descripcion)
    {
      this.descripcion = descripcion;
    }
   
    public void setCodigoUAPadre(String codigoUAPadre) 
    {
        this.codigoUAPadre = codigoUAPadre;
    }

    public String getCodigoUAPadre() 
    {
        return codigoUAPadre;
    }
    public String toString() 
    {
        final String NULL = "null";
        
        StringBuffer sb = new StringBuffer();
        sb.append("UnidadAdministrativa:");
        sb.append("\noid:").append(oid != null? oid.toString() : NULL);
        sb.append("\ncodigo:").append(codigo != null? codigo : NULL);
        sb.append("\ntipo:").append(tipo);
        sb.append("\nunidades:").append(unidades != null? unidades.toString() : NULL);
        sb.append("\nclientes:").append(clientes != null? clientes.toString() : NULL);
        sb.append("\ncodigoUAPadre:").append(codigoUAPadre != null? codigoUAPadre : NULL);
        sb.append("\noidPadre:").append(oidPadre != null? oidPadre.toString() : NULL);
        sb.append("\nnse1:").append(nse1 != null? nse1 : NULL);
        sb.append("\nnse2:").append(nse2 != null? nse2 : NULL);
        sb.append("\noidTerritorio:").append(oidTerritorio != null? oidTerritorio.toString() : NULL);
        sb.append("\noidTerritorioAdm:").append(oidTerritorioAdm != null? oidTerritorioAdm.toString() : NULL);
        sb.append("\noidUnidadGeografica:").append(oidUnidadGeografica != null? oidUnidadGeografica.toString() : NULL);
        sb.append("\ndescripcion:").append(descripcion != null? descripcion : NULL);
        return sb.toString();

    }

}