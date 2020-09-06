package com.restfulservices.respository;

import com.restfulservices.beans.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Long> findByEmpId(String id);
    boolean deleteByEmpId(Long id);
}
