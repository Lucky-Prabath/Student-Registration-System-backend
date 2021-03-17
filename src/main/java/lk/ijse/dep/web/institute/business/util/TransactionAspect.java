package lk.ijse.dep.web.institute.business.util;

import lk.ijse.dep.web.institute.business.SuperBO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-03-17
 **/

@Configuration
@Aspect
public class TransactionAspect {

    @Before("@annotation(lk.ijse.dep.web.institute.business.util.DEPTransaction)")
    public void beforeServiceMethod(JoinPoint jp){
        EntityManager em = ((SuperBO) (jp.getThis())).getEntityManger();
        em.getTransaction().begin();
    }

    @After("@annotation(lk.ijse.dep.web.institute.business.util.DEPTransaction)")
    public void afterServiceMethod(JoinPoint jp){
        EntityManager em = ((SuperBO) (jp.getThis())).getEntityManger();
        em.getTransaction().commit();
    }

    @AfterThrowing("@annotation(lk.ijse.dep.web.institute.business.util.DEPTransaction)")
    public void afterServiceMethodWithExp(JoinPoint jp){
        EntityManager em = ((SuperBO) (jp.getThis())).getEntityManger();
        em.getTransaction().rollback();
    }
}
