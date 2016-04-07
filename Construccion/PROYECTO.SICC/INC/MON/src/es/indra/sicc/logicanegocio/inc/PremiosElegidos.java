package es.indra.sicc.logicanegocio.inc;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

//jrivas 2/12/2008 20080783
public class PremiosElegidos {
    private HashMap niveles = null;
    
    public PremiosElegidos() {
        niveles = new HashMap();
    }
    
    public Premio obtenerPremioNivel(Long oidNivel) {
        UtilidadesLog.debug("***PremiosElegidos.obtenerPremioNivel ENTRADA " + oidNivel);
        if (this.niveles.containsKey(oidNivel)) {
            ArrayList premios = (ArrayList)this.niveles.get(oidNivel);
            if (premios != null) {
                Iterator it = premios.iterator();
                while (it.hasNext()) {
                    Premio premioAux = (Premio)it.next();
                    
                    // sapaza -- COL-SiCC-2013-0031 -- 02/04/2014
                    if (premioAux.getIndPendiente() && (premioAux.getCodMotivoInvalido()==null)) {
                        UtilidadesLog.debug("***PremiosElegidos.obtenerPremioNivel SALIDA Numero_premio: " + premioAux.getNumeroPremio());
                        premioAux.setIndPendiente(false);
                        return premioAux;
                    }
                }
            } 
        } else {
            UtilidadesLog.debug("***PremiosElegidos.obtenerPremioNivel SALIDA NULL 1");
            return null;
        }
        UtilidadesLog.debug("***PremiosElegidos.obtenerPremioNivel SALIDA NULL 2");
        return null;
    }
    
    public void almacenarPremioElegido(Premio premio) {
        Long nivel = premio.getNivel().getOidNivel();
        if (this.niveles.containsKey(nivel)) {
            ArrayList premios = (ArrayList)this.niveles.get(nivel);
            if (premios != null) {
                premios.add(premio);
            } else {
                premios = new ArrayList();
                premios.add(premio);
                this.niveles.put(nivel, premios);
            }
        } else {
            ArrayList premios = new ArrayList();
            premios.add(premio);
            this.niveles.put(nivel, premios);
        }
    }
    
    public ArrayList obtenerPremiosNoPendientes() {
        UtilidadesLog.debug("***PremiosElegidos.obtenerPremiosNoPendientes ENTRADA ");
        Iterator it = this.niveles.values().iterator();
        ArrayList salida = new ArrayList();
        while (it.hasNext()) {
            ArrayList aux = (ArrayList)it.next();
            if (aux != null) {
                Iterator it2 = aux.iterator();
                while (it2.hasNext()) {
                    Premio auxPremio =  (Premio)it2.next();
                    if (!auxPremio.getIndPendiente()) {
                        salida.add(auxPremio.getOidPremioElegido());
                    }
                }
            }
        }
        UtilidadesLog.debug("***PremiosElegidos.obtenerPremiosNoPendientes SALIDA " + salida);
        return salida;
    }    
    
    // sapaza -- COL-SiCC-2013-0031 -- 02/04/2014
    public ArrayList obtenerPremiosRechazados(int codMotivoInvalido) {
        UtilidadesLog.debug("***PremiosElegidos.obtenerPremiosRechazados ENTRADA ");
        Iterator it = this.niveles.values().iterator();
        ArrayList salida = new ArrayList();
        while (it.hasNext()) {
            ArrayList aux = (ArrayList)it.next();
            if (aux != null) {
                Iterator it2 = aux.iterator();
                while (it2.hasNext()) {
                    Premio auxPremio =  (Premio)it2.next();
                    if (auxPremio.getCodMotivoInvalido()!=null && auxPremio.getCodMotivoInvalido().intValue()==codMotivoInvalido) {
                        salida.add(auxPremio.getOidPremioElegido());
                    }
                }
            }
        }
        UtilidadesLog.debug("***PremiosElegidos.obtenerPremiosRechazados SALIDA " + salida);
        return salida;
    }
 
    // sapaza -- COL-SiCC-2013-0031 -- 02/04/2014   
    public ArrayList obtenerPremiosRechazadosPuntaje() {
        UtilidadesLog.debug("***PremiosElegidos.obtenerPremiosRechazadosPuntaje ENTRADA ");
        Iterator it = this.niveles.values().iterator();
        ArrayList salida = new ArrayList();
        while (it.hasNext()) {
            ArrayList aux = (ArrayList)it.next();
            if (aux != null) {
                Iterator it2 = aux.iterator();
                while (it2.hasNext()) {
                    Premio auxPremio =  (Premio)it2.next();
                    if (auxPremio.getCodMotivoInvalido()==null && auxPremio.getIndPendiente()) {
                        salida.add(auxPremio.getOidPremioElegido());
                    }
                }
            }
        }
        UtilidadesLog.debug("***PremiosElegidos.obtenerPremiosRechazadosPuntaje SALIDA " + salida);
        return salida;
    }
    
}