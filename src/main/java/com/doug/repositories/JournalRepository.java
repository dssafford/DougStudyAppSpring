package com.doug;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JournalRepository extends MongoRepository<Journal, String> {

	public List<Journal> findByMachine(String machine);
	public List<Journal> findByDirectory(String directory);
	public List<Journal>  findByProject(String project);


}
