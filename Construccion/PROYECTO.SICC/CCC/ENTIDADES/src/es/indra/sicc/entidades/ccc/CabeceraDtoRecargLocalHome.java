package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.CabeceraDtoRecargLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

import java.sql.Date;

public class CabeceraDtoRecargLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();
    
	public CabeceraDtoRecargLocal create(Integer diasCadencia, Integer diasCorte,
                                BigDecimal tipoInteres, Integer numero, String anio, 
                                String periodoMes, Date fechaDocumento, String situacion,
                                Long pais, Long empresa, Long subProceso, Long tipoAbono) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_CDRF_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CabeceraDtoRecargLocal local = new CabeceraDtoRecargLocal(oid, diasCadencia, diasCorte,
                                                             tipoInteres, numero, anio, 
                                                             periodoMes, fechaDocumento, situacion,
                                                             pais, empresa, subProceso, tipoAbono);
		em.persist(local);
		et.commit();
		return local;
	}

        public CabeceraDtoRecargLocal create(Long producto, Long cc, Integer diasCadencia,
                                Integer diasCorte, BigDecimal tipoInteres, Integer numero, 
                                String anio, String periodoMes, Date fechaDocumento, String situacion, 
                                Long pais, Long empresa, Long subProceso, Long tipoAbono, Long marca) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_CDRF_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                CabeceraDtoRecargLocal local = new CabeceraDtoRecargLocal(oid, producto, cc, diasCadencia,
                                                         diasCorte, tipoInteres, numero, 
                                                         anio, periodoMes, fechaDocumento, situacion, 
                                                         pais, empresa, subProceso, tipoAbono, marca);
                em.persist(local);
                et.commit();
                return local;
        }
    
	public void remove(CabeceraDtoRecargLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CabeceraDtoRecargLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CabeceraDtoRecargLocal findByPrimaryKey(Long  oid) {
		CabeceraDtoRecargLocal local = (CabeceraDtoRecargLocal)em.find(CabeceraDtoRecargLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
