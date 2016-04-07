package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import java.util.Hashtable;

public class SerializadorTextFacturaEcuador1 extends FixedDocument implements ISerializableDocument  {
       
    /**
     * CHANGELOG
     * ---------
     * dmorello, 09/06/2009 - Cambio 20090922 - Se modifican los tamaños de las secciones 1 y 2
     */
    public SerializadorTextFacturaEcuador1() {
        this.MSG = new ArrayList();
        this.numeroSecciones = 3;
        tamSecciones = new int[numeroSecciones];
        this.tamSecciones[0] = 20;
        this.tamSecciones[1] = 55;
        this.tamSecciones[2] = 10;
      	this.htDocumentFormat = new Hashtable();
        this.rellenarTabla(this.htDocumentFormat);
    }

    /**
     * CHANGELOG
     * ---------
     * dmorello, 09/06/2009 - Cambio 20090922 - Se agrega campo ICE (impuesto producto nacional)
     */
    public void rellenarTabla(Hashtable documento) {
        UtilidadesLog.debug("SerializadorTextFacturaEcuador1.rellenarTabla(Hashtable documento): Entrada");
        String sMensaje = "";
        Integer iKey;

        sMensaje = " ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 4);
        sMensaje += "                                                               PAG.<2|1> DE <2|1>";
        sMensaje = this.agregarSaltosLinea(sMensaje, 3);
        iKey = new Integer(0);
        documento.put(iKey, sMensaje);

        sMensaje = "                                                            QUITO         <2|2>   <2|2>  <2|2>";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(1);
        documento.put(iKey, sMensaje);

        sMensaje = " N.PEDIDO: <10>      CODIGO INTERNO: <13|1> ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 3);
        iKey = new Integer(2);
        documento.put(iKey, sMensaje);
        
        sMensaje = "                               <49|1> ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);        
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);        
        iKey = new Integer(3);
        documento.put(iKey, sMensaje);
        
        sMensaje = "         <15|1>                                <11|0|4>                  <15|0|4> ";        
        sMensaje = this.agregarSaltosLinea(sMensaje, 3);
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(6);
        documento.put(iKey, sMensaje);

        sMensaje = "             <40|0|4>                                                    <6|0|4> ";                
        sMensaje = this.agregarSaltosLinea(sMensaje, 2);
        iKey = new Integer(5);
        documento.put(iKey, sMensaje);

        sMensaje = "          <60|0|4> ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(7);
        documento.put(iKey, sMensaje);

        sMensaje=MSG_SEPARADOR;
        sMensaje=this.agregarSaltosLinea(sMensaje,1);
        iKey= new Integer(8);
        documento.put(iKey, sMensaje);

        sMensaje = this.agregarSaltosLinea("", 3);
        iKey= new Integer(10);
        documento.put(iKey, sMensaje);
        
        sMensaje = this.agregarSaltosLinea("", 2);
        iKey= new Integer(11);
        documento.put(iKey, sMensaje);
        
        sMensaje = "    <6|1>   <35>                                          <8|1>     <12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(9);
        documento.put(iKey, sMensaje);

        sMensaje = "Tot.<6|1>                              Total Productos             :<12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(20);
        documento.put(iKey, sMensaje);

        sMensaje = "                                       Descuentos                  :<12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 2);
        iKey = new Integer(21);
        documento.put(iKey, sMensaje);

        sMensaje = "                                       ICE                         :<12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += "                                       Base Imponible para IVA     :<12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje +="                                       IVA Tarifa <3|0|4>              :<12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje +="                                       Fletes y Serv. (<3|0|4> IVA)    :<12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje +="                                       Total Factura               :<12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += "    SON: <40|0|22>                                ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(22);
        documento.put(iKey, sMensaje);
        UtilidadesLog.debug("SerializadorTextFacturaEcuador1.rellenarTabla(Hashtable documento): Salida");
    }

    public void componerDocumento() {
        UtilidadesLog.debug("SerializadorTextFacturaPeru1.componerDocumento(): Entrada");
        StringBuffer cadena = new StringBuffer("");
        
        for (int i = 0; i < MSG.size(); i++){
            cadena.append(MSG.get(i).toString());
        }

        this.bufferOut = cadena.toString().getBytes();
        UtilidadesLog.debug("SerializadorTextFacturaPeru1.componerDocumento(): Salida");
    } 

}