package com.lambdaschool.javazoo.repository;

import com.lambdaschool.javazoo.model.Animal;
import com.lambdaschool.javazoo.model.Zoo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepository extends CrudRepository<Zoo, Long>
{
	Zoo findByZooname(String name);

	@Modifying
	@Query(value = "DELETE FROM zooanimal WHERE zooid = :zooid", nativeQuery = true)
	void deleteZooFromZooAnimals(long zooid);

	@Modifying
	@Query(value = "DELETE FROM zooanimal WHERE zooid = :zooid AND animalid = :animalid", nativeQuery = true)
	void deleteAnimalFromZoo(long zooid, long animalid);

}
