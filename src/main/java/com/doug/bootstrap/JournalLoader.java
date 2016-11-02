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

	private Logger log = Logger.getLogger(JournalLoader.class);
	private JournalSql journal;

	@Autowired
	public void setJournalSqlRepository(JournalSqlRepository journalSqlRepository) {
		this.journalSqlRepository = journalSqlRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

//		journal = getJournal();
//		journal.setMachine("mbp13");
//		journal.setDirectory("directory");
//		journal.setProject("SpringBootLearning");
//		journal.setComments("this is the root of my spring boot learning, lots of great stuff here");
//		journalSqlRepository.save(journal);
//
//		log.info("Saved record - id: " + journal.getId());
//
//		journal = getJournal();
//		journal.setMachine("mbp13");
//		journal.setDirectory("/workspace/springbootlearning/springmvc");
//		journal.setProject("Spring - Java");
//		journal.setComments("good mvc example from spring guru");
//		journalSqlRepository.save(journal);
//
//
//		log.info("Saved record - id:" + journal.getId());
//
//		journal = getJournal();
//		journal.setMachine("imac");
//		journal.setDirectory("/nodework/DougStudyApp");
//		journal.setProject("node");
//		journal.setComments("Study app in node/mongo, deployed to CF");
//		journalSqlRepository.save(journal);
//
//
//		log.info("Saved record - id:" + journal.getId());
//
//		journal = getJournal();
//		journal.setMachine("imac");
//		journal.setDirectory("/gitwork/git-exampleDoug");
//		journal.setProject("node");
//		journal.setComments("simple git example of basic operations");
//		journalSqlRepository.save(journal);
//
//
//		log.info("Saved record - id:" + journal.getId());
//
//		journal = getJournal();
//		journal.setMachine("mbp13");
//		journal.setDirectory("~/workspace/springbootlearning/sfgthymeleaf");
//		journal.setProject("SfgthymeleafDoug");
//		journal.setComments("good example of using thymeleaf");
//		journalSqlRepository.save(journal);
//
//
//		log.info("Saved record - id:" + journal.getId());
	}

	private JournalSql getJournal() {
		return new JournalSql();
	}
}
