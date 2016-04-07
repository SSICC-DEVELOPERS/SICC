package es.indra.sicc.dtos.rec;
import es.indra.sicc.util.DTOBelcorp;

public class DTOGeneraOperacionREC extends DTOBelcorp  {
    public DTOGeneraOperacionREC() {
    }
    
    private Boolean enviaGeneraDevuelve;
    private Boolean devuelveGeneraEnvia; 

    public Boolean getDevuelveGeneraEnvia() {
        return devuelveGeneraEnvia;
    }

    public void setDevuelveGeneraEnvia(Boolean devuelveGeneraEnvia) {
        this.devuelveGeneraEnvia = devuelveGeneraEnvia;
    }

    public Boolean getEnviaGeneraDevuelve() {
        return enviaGeneraDevuelve;
    }

    public void setEnviaGeneraDevuelve(Boolean enviaGeneraDevuelve) {
        this.enviaGeneraDevuelve = enviaGeneraDevuelve;
    }
}