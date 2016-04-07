package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;
import java.sql.Date;
import es.indra.sicc.entidades.cob.UsuariosCobranzasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class UsuariosCobranzasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public UsuariosCobranzasLocal create(Date fechaUltimoEstado,
                        Boolean indJefeCobranza,
                        Boolean indUsuarioSupervisor,
                        Boolean indUsuarioExterno,
                        String turnoHorarioEntrada,
                        String turnoHorarioSalida,
                        String observaciones,
                        Long paisOidPais, 
                        Long esusOidEstaUsua,
                        Long userOidUsuaSupe,
                        Long userOidUsuaCobr,                                
                        Long userOidUsuaResp) throws MareException {
		
	    Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_USCO_SEQ"); 
                final EntityTransaction et = em.getTransaction();
		et.begin();
		UsuariosCobranzasLocal local = new UsuariosCobranzasLocal(oid, fechaUltimoEstado,
                         indJefeCobranza,
                         indUsuarioSupervisor,
                         indUsuarioExterno,
                         turnoHorarioEntrada,
                         turnoHorarioSalida,
                         observaciones,
                         paisOidPais, 
                         esusOidEstaUsua,
                         userOidUsuaSupe,
                         userOidUsuaCobr,                                
                         userOidUsuaResp);
                         
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(UsuariosCobranzasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(UsuariosCobranzasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public UsuariosCobranzasLocal findByPrimaryKey(Long  oid) {
		UsuariosCobranzasLocal local = (UsuariosCobranzasLocal)em.find(UsuariosCobranzasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("UsuariosCobranzasLocal.FindAll");          
            return query.getResultList();
        }


	public Collection findByIndUsuarioSupervisor(Boolean indUsuarioSupervisor) {
		Query query=em.createNamedQuery("UsuariosCobranzasLocal.FindByIndUsuarioSupervisor");
		
		query.setParameter(1, indUsuarioSupervisor);

                return query.getResultList();
	}

	public UsuariosCobranzasLocal findByUK(Long oidPais, Long oidUser) {
		Query query=em.createNamedQuery("UsuariosCobranzasLocal.FindByUK");
		
		query.setParameter(1, oidPais);

		query.setParameter(2, oidUser);

		return (UsuariosCobranzasLocal)(query.getSingleResult());
	}

}
