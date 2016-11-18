package domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

	Student findByStudentName(String name);
	
	List<Student> findByAddress_state(String state);
}
