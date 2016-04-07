package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import java.util.Hashtable;

public class SerializadorTextFacturaPanama1 extends FixedDocument implements ISerializableDocument  {
       
    public SerializadorTextFacturaPanama1() {
        this.MSG = new ArrayList();
        this.numeroSecciones = 3;
        tamSecciones = new int[numeroSecciones];
        this.tamSecciones[0] = 20;
        this.tamSecciones[1] = 56;
        this.tamSecciones[2] = 9;
      	this.htDocumentFormat = new Hashtable();
        this.rellenarTabla(this.htDocumentFormat);
    }

    public void rellenarTabla(Hashtable documento) {
        UtilidadesLog.debug("SerializadorTextFacturaPanama1.rellenarTabla(Hashtable documento): Entrada");
        String sMensaje = "";
        Integer iKey;

        sMensaje = " ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 4);
        sMensaje += "          N.PED.: <10>      COD. INT.: <13|1>                 PAG.<2|1> DE <2|1>";
        sMensaje = this.agregarSaltosLinea(sMensaje, 3);
        iKey = new Integer(0);
        documento.put(iKey, sMensaje);

        sMensaje = "                                                            PANAMA        <2|2>   <2|2>  <2|2>";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(1);
        documento.put(iKey, sMensaje);

        sMensaje = "        <10>                                  ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(2);
        documento.put(iKey, sMensaje);
        
        sMensaje = "                               <49|1> ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);        
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);        
        iKey = new Integer(3);
        documento.put(iKey, sMensaje);
        
        sMensaje = "         <15|1>                                <11|0|4>                  <10|0|4> ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
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
        sMensaje = this.agregarSaltosLinea(sMensaje, 3);
        iKey = new Integer(21);
        documento.put(iKey, sMensaje);

        sMensaje = "                                     Base Imponible para ITBMS     :<12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje +="                                     ITBMS Tarifa <3|0|4>              :<12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje +="                                     Fletes y Serv. (<3|0|4> ITBMS)    :<12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje +="                                     Total Factura                 :<12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += "    SON: <40|0|22>                                ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(22);
        documento.put(iKey, sMensaje);
        UtilidadesLog.debug("SerializadorTextFacturaPanama1.rellenarTabla(Hashtable documento): Salida");
    }

    public void componerDocumento() {
        UtilidadesLog.debug("SerializadorTextFacturaPanama1.componerDocumento(): Entrada");
        StringBuffer cadena = new StringBuffer("");
        
        for (int i = 0; i < MSG.size(); i++){
            cadena.append(MSG.get(i).toString());
        }

        this.bufferOut = cadena.toString().getBytes();
        UtilidadesLog.debug("SerializadorTextFacturaPanama1.componerDocumento(): Salida");
    } 
}