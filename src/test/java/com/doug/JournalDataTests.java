package com.doug;

import com.doug.configuration.SpringMongoConfiguration;
import com.doug.domain.Journal;
import com.doug.repositories.JournalMongoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Doug on 8/19/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMongoConfiguration.class)
public class JournalDataTests {

	@Autowired
	JournalMongoRepository JournalMongoRepository;


	static final int QTY = 5;

	@Before
	public void init() {
		JournalMongoRepository.deleteAll();
		Date myDate = new Date();

		JournalMongoRepository.save(new Journal(myDate, "mbp13", "directory", "project", "comments"));
		JournalMongoRepository.save(new Journal(myDate, "machine", "directory", "project", "comments"));
		JournalMongoRepository.save(new Journal(myDate, "mbp13", "directory", "NodeMongo", "comments"));
		JournalMongoRepository.save(new Journal(myDate, "machine", "directory", "project", "comments"));
		JournalMongoRepository.save(new Journal(myDate, "mbp13", "directory", "project", "comments"));


	}

	@Test
	public void HappyTest() {
		List<Journal> list = JournalMongoRepository.findAll();
		assertEquals(QTY, list.size());
	}

	@Test
	public void findDocumentsForMachine() throws Exception {
		List<Journal> list = JournalMongoRepository.findByMachine("mbp13");
		assertEquals(3, list.size());

	}

	@Test
	public void findDocumentsForProject() throws Exception {
		List<Journal> list = JournalMongoRepository.findByProject("NodeMongo");
		assertEquals(1, list.size());

	}
}
