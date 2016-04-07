//import LPSICCBase;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.pre.DTODetalleOferta;
import es.indra.sicc.dtos.pre.DTOOferta;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Vector;

public class LPEvaluarRankingPorDemanda extends LPSICCBase {

    private String accion = null;
    private Integer primerNRanking = null;
    private Integer ultimoNRanking = null;
    private DTOOferta dtoOferta = null;

    public void inicio() throws Exception {
        pagina ("contenido_ranking_demanda_evaluar");
    }

    public void ejecucion() throws Exception {
        try{
            this.setTrazaFichero();
            this.rastreo();
			getFormatosValidaciones();
            dtoOferta = (DTOOferta) conectorParametroSesion("DTOOferta");
            traza("DTOOferta de sesion: "+dtoOferta);
            accion = conectorParametro("accion")==null?"":conectorParametro("accion");
            primerNRanking = (conectorParametro("txtUltimo")==null||conectorParametro("txtPrimer").equals(""))?null:Integer.valueOf(conectorParametro("txtPrimer"));
            ultimoNRanking = (conectorParametro("txtUltimo")==null||conectorParametro("txtUltimo").equals(""))?null:Integer.valueOf(conectorParametro("txtUltimo"));
            getConfiguracionMenu("LPEvaluarRankingPorDemanda","");
            if (accion.equals("")){
                primerNRanking = new Integer(1);
                ultimoNRanking = new Integer(dtoOferta.getDetalleOferta().size());
                asignarAtributo( "CTEXTO", "txtPrimer", "valor", primerNRanking==null?"":primerNRanking.toString());
                asignarAtributo( "CTEXTO", "txtUltimo", "valor", ultimoNRanking==null?"":ultimoNRanking.toString());
            }else if (accion.equals("Finalizar")){
                finalizar();
            }
        }catch (Exception e){
            logStackTrace(e);
            this.lanzarPaginaError(e);
            asignarAtributo( "CTEXTO", "txtPrimer", "valor", primerNRanking==null?"":primerNRanking.toString());
            asignarAtributo( "CTEXTO", "txtUltimo", "valor", ultimoNRanking==null?"":ultimoNRanking.toString());
        }
    }

    private void finalizar() throws Exception {
        if (comprobarNumerosRanking()){
            dtoOferta.setPrimeraPosicionRanking(primerNRanking);
            dtoOferta.setUltimaPosicionRanking(ultimoNRanking);
            ordenarProductosPorDemanda();
            conectorAction("LPDefinirOferta");
            conectorActionParametro("accion","Comprobar restricciones");
        }
    }

    private boolean comprobarNumerosRanking() throws Exception {
        int size = dtoOferta.getDetalleOferta().size();
        traza("Numero Maximo: "+size);
        if (ultimoNRanking.intValue()<1 || ultimoNRanking.intValue() > size
            || primerNRanking.intValue() < 1 || primerNRanking.intValue() > size
            || primerNRanking.intValue()>ultimoNRanking.intValue()){
            traza("Numeros Invalidos para Ranking");
            throw new MareException(new Exception(),50028); //PRE-0028
        }
        return true;
    }

    private void ordenarProductosPorDemanda() throws Exception {
        Vector vec = dtoOferta.getDetalleOferta();
        Comparador comp = new Comparador();
        Collections.sort(vec, comp);
        int ranking = 1;
        Enumeration enum = vec.elements();
        while(enum.hasMoreElements()){
            DTODetalleOferta dto = (DTODetalleOferta)enum.nextElement();
            dto.setPosicionRanking(new Integer(ranking));
            ranking++;
        }
        conectorParametroSesion("DTOOferta",dtoOferta);
    }
    
    private class Comparador implements Comparator {
        public int compare(Object o1, Object o2){
            DTODetalleOferta dto1 = (DTODetalleOferta)o1;
            DTODetalleOferta dto2 = (DTODetalleOferta)o2;
            if (dto1.getUnidadesEstimadas()!=null){
              if (dto2.getUnidadesEstimadas()!=null){
                if (dto1.getUnidadesEstimadas().intValue()<=dto2.getUnidadesEstimadas().intValue())
                    return -1;
                else
                    return 1;
              } else return 1;
            } else return -1;          
        }
    }

     private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
    }
}
