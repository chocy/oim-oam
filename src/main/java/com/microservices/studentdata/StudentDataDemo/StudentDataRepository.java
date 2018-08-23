package com.microservices.studentdata.StudentDataDemo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDataRepository extends MongoRepository<StudentData, Long> {

	/*StudentData save(StudentData studentData);

	void deleteById(Long id);

	Optional<StudentData> findById(Long id);

	List<StudentData> findAll();*/

}
