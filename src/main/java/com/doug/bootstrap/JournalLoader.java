package com.doug.bootstrap;

/**
 * Created by Doug on 9/18/16.
 */

import com.doug.domain.Journal;
import com.doug.repositories.JournalRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
@Profile("bootstrap")
public class JournalLoader implements ApplicationListener<ContextRefreshedEvent> {

	private JournalRepository JournalRepository;

	private Logger log = Logger.getLogger(JournalLoader.class);
	private Journal journal;

	@Autowired
	public void setJournalRepository(JournalRepository JournalRepository) {
		this.JournalRepository = JournalRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		journal = getJournal();
		journal.setMachine("mbp13");
		journal.setDirectory("directory");
		journal.setProject("SpringBootLearning");
		journal.setComments("this is the root of my spring boot learning, lots of great stuff here");
		JournalRepository.save(journal);

		log.info("Saved record - id: " + journal.getId());

		journal = getJournal();
		journal.setMachine("mbp13");
		journal.setDirectory("/workspace/springbootlearning/springmvc");
		journal.setProject("Spring - Java");
		journal.setComments("good mvc example from spring guru");
		JournalRepository.save(journal);


		log.info("Saved record - id:" + journal.getId());

		journal = getJournal();
		journal.setMachine("imac");
		journal.setDirectory("/nodework/DougStudyApp");
		journal.setProject("node");
		journal.setComments("Study app in node/mongo, deployed to CF");
		JournalRepository.save(journal);


		log.info("Saved record - id:" + journal.getId());

		journal = getJournal();
		journal.setMachine("imac");
		journal.setDirectory("/gitwork/git-exampleDoug");
		journal.setProject("node");
		journal.setComments("simple git example of basic operations");
		JournalRepository.save(journal);


		log.info("Saved record - id:" + journal.getId());

		journal = getJournal();
		journal.setMachine("mbp13");
		journal.setDirectory("~/workspace/springbootlearning/sfgthymeleaf");
		journal.setProject("SfgthymeleafDoug");
		journal.setComments("good example of using thymeleaf");
		JournalRepository.save(journal);


		log.info("Saved record - id:" + journal.getId());
	}

	private Journal getJournal() {
		return new Journal();
	}
}
