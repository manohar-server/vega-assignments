package rest.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rest.example.entity.StudentBO;

@Repository
public interface StudentRepository extends JpaRepository<StudentBO, Long>{

}
