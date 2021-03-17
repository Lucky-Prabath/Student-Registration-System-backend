package lk.ijse.dep.web.institute.dao.custom.impl;

import lk.ijse.dep.web.institute.dao.custom.QueryDAO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/

@Component
public class QueryDAOImpl implements QueryDAO {

    @Override
    public void setEntityManager(EntityManager em) {

    }
}
