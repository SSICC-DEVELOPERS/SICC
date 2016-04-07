package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.CabeceraCuponesTramiteDepuracionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class CabeceraCuponesTramiteDepuracionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();

	public CabeceraCuponesTramiteDepuracionLocal create(Long subacceso, Integer numero, 
                    String anio, String periodoMes, Date fechaDocumento, Long pais) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_CTDE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CabeceraCuponesTramiteDepuracionLocal local = new CabeceraCuponesTramiteDepuracionLocal(oid, subacceso, numero, 
                                                anio, periodoMes, fechaDocumento, pais);
		em.persist(local);
		et.commit();
		return local;
	}

        public CabeceraCuponesTramiteDepuracionLocal create(Long subacceso, Integer numero, 
                        String anio, String periodoMes, Date fechaDocumento, Long pais, 
                        String referenciaExterna, String observaciones) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_CTDE_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                CabeceraCuponesTramiteDepuracionLocal local = new CabeceraCuponesTramiteDepuracionLocal(oid, subacceso, numero, 
                                                         anio, periodoMes, fechaDocumento, pais, 
                                                         referenciaExterna, observaciones);
                em.persist(local);
                et.commit();
                return local;
        }
    
	public void remove(CabeceraCuponesTramiteDepuracionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CabeceraCuponesTramiteDepuracionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CabeceraCuponesTramiteDepuracionLocal findByPrimaryKey(Long  oid) {
		CabeceraCuponesTramiteDepuracionLocal local = (CabeceraCuponesTramiteDepuracionLocal)em.find(CabeceraCuponesTramiteDepuracionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
