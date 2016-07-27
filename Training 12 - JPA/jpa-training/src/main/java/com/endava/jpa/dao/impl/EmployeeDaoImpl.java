package com.endava.jpa.dao.impl;

import com.endava.jpa.criteria.EmployeeCriteria;
import com.endava.jpa.dao.AbstractDao;
import com.endava.jpa.dao.EmployeeDao;
import com.endava.jpa.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee> implements EmployeeDao {
    private final String QUERY_FIND_ALL = "SELECT e FROM Employee e";
    private final String QUERY_DELETE_ALL = "DELETE FROM Employee e";

    public List<Employee> findAll() {
        return entityManager.createQuery(QUERY_FIND_ALL).getResultList();
    }

    public void deleteAll() {
        entityManager.createQuery(QUERY_DELETE_ALL);
    }

    public List<Employee> findByCriteria(EmployeeCriteria criteria) {
        String queryString = "SELECT e FROM Employee e JOIN e.department d WHERE d.id = :dept AND e.city LIKE :city";
        return entityManager.createQuery(queryString, Employee.class)
                .setParameter("city", criteria.getCity())
                .setParameter("dept", criteria.getDepartment().getId())
                .getResultList();
    }
}
