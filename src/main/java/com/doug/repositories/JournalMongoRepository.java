package com.doug.repositories;

import com.doug.domain.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JournalMongoRepository extends MongoRepository<Journal, String> {
//public interface JournalMongoRepository extends CrudRepository<Journal, String> {
	public List<Journal> findByMachine(String machine);
	public List<Journal> findByDirectory(String directory);
	public List<Journal>  findByProject(String project);


}
