package com.doug.bootstrap;

/**
 * Created by Doug on 9/18/16.
 */

import com.doug.domain.JournalSql;
import com.doug.repositories.JournalSqlRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class JournalLoader implements ApplicationListener<ContextRefreshedEvent> {

	private JournalSqlRepository journalSqlRepository;

	private Logger log = Logger.getLogger(ProductLoader.class);
	private JournalSql journal;

	@Autowired
	public void setJournalSqlRepository(JournalSqlRepository journalSqlRepository) {
		this.journalSqlRepository = journalSqlRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		journal = getJournal();
		journal.setMachine("mbp13");
		journal.setDirectory("directory");
		journal.setProject("SpringBootLearning");
		journal.setComments("my comments here");
		journalSqlRepository.save(journal);

		log.info("Saved journal - id: " + journal.getId());

		journal = getJournal();
		journal.setMachine("imac");
		journal.setDirectory("directory");
		journal.setProject("node");
		journal.setComments("my second comments here");
		journalSqlRepository.save(journal);


		log.info("Saved Mug - id:" + journal.getId());
	}

	private JournalSql getJournal() {
		return new JournalSql();
	}
}
