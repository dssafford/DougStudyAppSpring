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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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

    private Date ParseDate(String dateInString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("M-dd-yyyy");

        return sdf.parse(dateInString);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            LoadJournalData();
        } catch (ParseException e) {

        }
    }

    private Journal getJournal() {
        return new Journal();
    }

    private void LoadJournalData() throws ParseException {
//1
        journal = getJournal();
        journal.setDate_added(ParseDate("01-01-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("SpringBootInAction/ReadingList");
        journal.setProject("ReadingList");
        journal.setTechnology("spring");
        journal.setComments("from SpringBootInAction book, has a lot of good examples");
        journal.setActive(true);
        JournalRepository.save(journal);

        log.info("Saved record - id: " + journal.getId());
//2
        journal = getJournal();
        journal.setDate_added(ParseDate("01-10-2016"));
        journal.setMachine("mbp15");
        journal.setDirectory("RabbitMQWork");
        journal.setProject("ServerStart");
        journal.setTechnology("RabbitMQ");
        journal.setComments("RabbitMQ example, starting server");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//3
        journal = getJournal();
        journal.setDate_added(ParseDate("10-08-2016"));
        journal.setMachine("mbp15");
        journal.setDirectory("seleniumautomation");
        journal.setProject("selenium");
        journal.setTechnology("selenium");
        journal.setComments("testing example");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());
//4
        journal = getJournal();
        journal.setDate_added(ParseDate("7-23-2016"));
        journal.setMachine("mbp15");
        journal.setDirectory("pwswork");
        journal.setProject("DonationWeb");
        journal.setTechnology("spring");
        journal.setComments("simple pcf client, hits DonationWebService");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//5
        journal = getJournal();
        journal.setDate_added(ParseDate("01-01-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("pwswork/DonationWebService");
        journal.setProject("DonationWebService");
        journal.setTechnology("spring");
        journal.setComments("cf api services");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//6
        journal = getJournal();
        journal.setDate_added(ParseDate("07-23-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("pwswork/DougWeb");
        journal.setProject("DougWeb");
        journal.setTechnology("node");
        journal.setComments("node example");
        journal.setActive(true);
        JournalRepository.save(journal);

        log.info("Saved record - id: " + journal.getId());

//7
        journal = getJournal();
        journal.setDate_added(ParseDate("11-16-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/microservices/gs-guitar-db");
        journal.setProject("Microservices");
        journal.setTechnology("spring microservices");
        journal.setComments("good microservices example");
        journal.setActive(true);
        JournalRepository.save(journal);

        log.info("Saved record - id:" + journal.getId());

//8
        journal = getJournal();
        journal.setDate_added(ParseDate("1-22-2016"));
        journal.setMachine("imac");
        journal.setDirectory("nodework/cardrandomizer");
        journal.setProject("cardrandomizer");
        journal.setTechnology("spring");
        journal.setComments("memorize deck of cards");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//9
        journal = getJournal();
        journal.setDate_added(ParseDate("01-01-2016"));
        journal.setMachine("imac");
        journal.setDirectory("gitwork/git-exampleDoug");
        journal.setProject("node");
        journal.setTechnology("mpde");
        journal.setComments("simple git example of basic operations");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        10
        journal = getJournal();
        journal.setDate_added(ParseDate("12-31-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/springcore/springcorelearning");
        journal.setProject("SfgSpringCoreDoug");
        journal.setTechnology("spring");
        journal.setComments("spring core learning");
        journal.setActive(true);
        JournalRepository.save(journal);
        log.info("Saved record - id:" + journal.getId());


//        11
        journal = getJournal();
        journal.setDate_added(ParseDate("01-11-2016"));
        journal.setMachine("mbp15");
        journal.setDirectory("workspace/springbootlearning/hey");
        journal.setProject("SpringBootLearning");
        journal.setTechnology("spring");
        journal.setComments("this is the root of my spring boot learning, lots of great stuff here");
        journal.setActive(true);
        JournalRepository.save(journal);

        log.info("Saved record - id: " + journal.getId());


//        12
        journal = getJournal();
        journal.setDate_added(ParseDate("01-10-2016"));
        journal.setMachine("mbp15");
        journal.setDirectory("LearnSpringBoot");
        journal.setProject("LearnSpringBoot");
        journal.setTechnology("spring");
        journal.setComments("learning spring boot example");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//         13
        journal = getJournal();
        journal.setDate_added(ParseDate("10-08-2016"));
        journal.setMachine("mbp15");
        journal.setDirectory("my-git-repo");
        journal.setProject("my-git-repo");
        journal.setTechnology("git");
        journal.setComments("from kindle pdf book on git");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        14
        journal = getJournal();
        journal.setDate_added(ParseDate("7-23-2016"));
        journal.setMachine("imac");
        journal.setDirectory("gitwork/git-exampleDoug");
        journal.setProject("node");
        journal.setTechnology("node");
        journal.setComments("simple git example of basic operations");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        15
        journal = getJournal();
        journal.setDate_added(ParseDate("01-01-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("gowork");
        journal.setProject("helloGo");
        journal.setTechnology("go");
        journal.setComments("simplest example");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        16
        journal = getJournal();
        journal.setDate_added(ParseDate("07-23-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("gowork");
        journal.setProject("palindrome");
        journal.setTechnology("go");
        journal.setComments("go example");
        journal.setActive(true);
        JournalRepository.save(journal);

        log.info("Saved record - id: " + journal.getId());

//        17
        journal = getJournal();
        journal.setDate_added(ParseDate("11-16-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("nodework");
        journal.setProject("bearsapi");
        journal.setTechnology("node");
        journal.setComments("simple node api");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());


//        18
        journal = getJournal();
        journal.setDate_added(ParseDate("1-22-2016"));
        journal.setMachine("imac");
        journal.setDirectory("nodework/cardrandomizer");
        journal.setProject("cardrandomizer");
        journal.setTechnology("spring");
        journal.setComments("memorize deck of cards");
        journal.setActive(false);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());


//        19
        journal = getJournal();
        journal.setDate_added(ParseDate("01-01-2016"));
        journal.setMachine("mbp15");
        journal.setDirectory("nodework");
        journal.setProject("MeditationTracker");
        journal.setTechnology("node");
        journal.setComments("tracks meditation times");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        20
        journal = getJournal();
        journal.setDate_added(ParseDate("12-31-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("NodeWork");
        journal.setProject("mongo-node-crud");
        journal.setTechnology("node");
        journal.setComments("node and mongo learning");
        journal.setActive(true);
        JournalRepository.save(journal);

        log.info("Saved record - id:" + journal.getId());


    //	21
        journal = getJournal();
        journal.setDate_added(ParseDate("01-01-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning");
        journal.setProject("SpringBootLearning");
        journal.setTechnology("spring");
        journal.setComments("this is the root of my spring boot learning, lots of great stuff here");
        journal.setActive(false);
        JournalRepository.save(journal);

        log.info("Saved record - id: " + journal.getId());

//        22
        journal = getJournal();
        journal.setDate_added(ParseDate("01-10-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("NodeWork");
        journal.setProject("gulpwork");
        journal.setTechnology("gulp");
        journal.setComments("simple gulp example");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//23
        journal = getJournal();
        journal.setDate_added(ParseDate("10-08-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("nodework");
        journal.setProject("node-express-mongo-demo");
        journal.setTechnology("node");
        journal.setComments("mean stack demo, works well");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        24
        journal = getJournal();
        journal.setDate_added(ParseDate("7-23-2016"));
        journal.setMachine("imac");
        journal.setDirectory("NodeWork");
        journal.setProject("node-api");
        journal.setTechnology("git");
        journal.setComments("simple git example of basic operations");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        25
        journal = getJournal();
        journal.setDate_added(ParseDate("01-01-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/sfgthymeleaf");
        journal.setProject("node_jade_stylus_demo");
        journal.setTechnology("spring");
        journal.setComments("node and jade demo");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());



//          26
        journal = getJournal();
        journal.setDate_added(ParseDate("07-23-2016"));
        journal.setMachine("mbp15");
        journal.setDirectory("NodeWork");
        journal.setProject("pong_matcher_sails");
        journal.setTechnology("node");
        journal.setComments("supposedly 12 factor example for cf");
        journal.setActive(true);
        JournalRepository.save(journal);

        log.info("Saved record - id: " + journal.getId());

//        27
        journal = getJournal();
        journal.setDate_added(ParseDate("11-16-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("NodeWork");
        journal.setProject("passport");
        journal.setTechnology("node");
        journal.setComments("node passport example");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        28
        journal = getJournal();
        journal.setDate_added(ParseDate("1-22-2016"));
        journal.setMachine("imac");
        journal.setDirectory("NodeWork");
        journal.setProject("practicalnodebook");
        journal.setTechnology("node");
        journal.setComments("Practical Node Book examples");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());


//        29
        journal = getJournal();
        journal.setDate_added(ParseDate("01-01-2016"));
        journal.setMachine("imac");
        journal.setDirectory("NodeWork");
        journal.setProject("simple_todo");
        journal.setTechnology("node");
        journal.setComments("node to do example");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());


//        30
        journal = getJournal();
        journal.setDate_added(ParseDate("12-31-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("NodeWork");
        journal.setProject("todoApp");
        journal.setTechnology("node");
        journal.setComments("to do example");
        journal.setActive(true);
        JournalRepository.save(journal);
        log.info("Saved record - id:" + journal.getId());


//31
        journal = getJournal();
        journal.setDate_added(ParseDate("01-11-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("SpringWork");
        journal.setProject("AJLesson1");
        journal.setTechnology("spring");
        journal.setComments("this is the root of my spring boot learning, lots of great stuff here");
        journal.setActive(true);
        JournalRepository.save(journal);

        log.info("Saved record - id: " + journal.getId());

//        32
        journal = getJournal();
        journal.setDate_added(ParseDate("01-10-2016"));
        journal.setMachine("mbp15");
        journal.setDirectory("SpringWork");
        journal.setProject("AJLesson2");
        journal.setTechnology("spring");
        journal.setComments("I have no idea what this is");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//33
        journal = getJournal();
        journal.setDate_added(ParseDate("10-08-2016"));
        journal.setMachine("imac");
        journal.setDirectory("nodework/DougStudyApp");
        journal.setProject("node");
        journal.setTechnology("node");
        journal.setComments("Study app in node/mongo, deployed to CF");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//    34
        journal = getJournal();
        journal.setDate_added(ParseDate("7-23-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("gitwork/git-exampleDoug");
        journal.setProject("git");
        journal.setTechnology("git");
        journal.setComments("simple git example of basic operations");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        35
        journal = getJournal();
        journal.setDate_added(ParseDate("01-01-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/sfgthymeleaf");
        journal.setProject("SfgthymeleafDoug");
        journal.setTechnology("spring");
        journal.setComments("good example of using thymeleaf");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());


//        36
        journal = getJournal();
        journal.setDate_added(ParseDate("07-23-2016"));
        journal.setMachine("imac");
        journal.setDirectory("workspace/springbootlearning/cardrancomizerweb");
        journal.setProject("cardrandomizerweb");
        journal.setTechnology("spring");
        journal.setComments("app to memorize a deck of cards");
        journal.setActive(true);
        JournalRepository.save(journal);

        log.info("Saved record - id: " + journal.getId());

//        37
        journal = getJournal();
        journal.setDate_added(ParseDate("11-16-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/microservices/gs-guitar-db");
        journal.setProject("Microservices");
        journal.setTechnology("spring");
        journal.setComments("good microservices example");
        journal.setActive(false);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        38
        journal = getJournal();
        journal.setDate_added(ParseDate("1-22-2016"));
        journal.setMachine("mbp15");
        journal.setDirectory("nodework/cardrandomizer");
        journal.setProject("cardrandomizer");
        journal.setTechnology("spring");
        journal.setComments("memorize deck of cards");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());


//        39
        journal = getJournal();
        journal.setDate_added(ParseDate("01-01-2016"));
        journal.setMachine("imac");
        journal.setDirectory("gitwork/git-exampleDoug");
        journal.setProject("git");
        journal.setTechnology("spring");
        journal.setComments("simple git example of basic operations");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        40
        journal = getJournal();
        journal.setDate_added(ParseDate("12-31-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/springcore/springcorelearning");
        journal.setProject("SfgSpringCoreDoug");
        journal.setTechnology("spring");
        journal.setComments("spring core learning");
        journal.setActive(false);
        JournalRepository.save(journal);

        log.info("Saved record - id:" + journal.getId());

//41
        journal = getJournal();
        journal.setDate_added(ParseDate("01-01-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("directory");
        journal.setProject("SpringBootLearning");
        journal.setTechnology("spring");
        journal.setComments("this is the root of my spring boot learning, lots of great stuff here");
        journal.setActive(true);
        JournalRepository.save(journal);

        log.info("Saved record - id: " + journal.getId());

//    42
        journal = getJournal();
        journal.setDate_added(ParseDate("01-10-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/springmvc");
        journal.setProject("Spring - Java");
        journal.setTechnology("spring");
        journal.setComments("good mvc example from spring guru");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());


//        43
        journal = getJournal();
        journal.setDate_added(ParseDate("10-08-2016"));
        journal.setMachine("imac");
        journal.setDirectory("nodework/DougStudyApp");
        journal.setProject("node");
        journal.setTechnology("spring");
        journal.setComments("Study app in node/mongo, deployed to CF");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());


//        44
        journal = getJournal();
        journal.setDate_added(ParseDate("7-23-2016"));
        journal.setMachine("imac");
        journal.setDirectory("gitwork/git-exampleDoug");
        journal.setProject("node");
        journal.setTechnology("spring");
        journal.setComments("simple git example of basic operations");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());


//        45
        journal = getJournal();
        journal.setDate_added(ParseDate("01-01-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/sfgthymeleaf");
        journal.setProject("SfgthymeleafDoug");
        journal.setTechnology("spring");
        journal.setComments("good example of using thymeleaf");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());



//46
        journal = getJournal();
        journal.setDate_added(ParseDate("07-23-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/cardrancomizerweb");
        journal.setProject("cardrandomizerweb");
        journal.setTechnology("spring");
        journal.setComments("app to memorize a deck of cards");
        journal.setActive(true);
        JournalRepository.save(journal);

        log.info("Saved record - id: " + journal.getId());

//    47
        journal = getJournal();
        journal.setDate_added(ParseDate("11-16-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/microservices/gs-guitar-db");
        journal.setProject("Microservices");
        journal.setTechnology("spring");
        journal.setComments("good microservices example");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());


//        48
        journal = getJournal();
        journal.setDate_added(ParseDate("1-22-2016"));
        journal.setMachine("imac");
        journal.setDirectory("nodework/cardrandomizer");
        journal.setProject("cardrandomizer");
        journal.setTechnology("spring");
        journal.setComments("memorize deck of cards");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());


//        49
        journal = getJournal();
        journal.setDate_added(ParseDate("01-01-2016"));
        journal.setMachine("imac");
        journal.setDirectory("gitwork/git-exampleDoug");
        journal.setProject("node");
        journal.setTechnology("spring");
        journal.setComments("simple git example of basic operations");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        50
        journal = getJournal();
        journal.setDate_added(ParseDate("12-31-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/springcore/springcorelearning");
        journal.setProject("SfgSpringCoreDoug");
        journal.setTechnology("spring");
        journal.setComments("spring core learning");
        journal.setActive(true);
        JournalRepository.save(journal);
        log.info("Saved record - id:" + journal.getId());


//51
        journal = getJournal();
        journal.setDate_added(ParseDate("01-11-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/hey");
        journal.setProject("SpringBootLearning");
        journal.setTechnology("spring");
        journal.setComments("this is the root of my spring boot learning, lots of great stuff here");
        journal.setActive(true);
        JournalRepository.save(journal);

        log.info("Saved record - id: " + journal.getId());

//52
        journal = getJournal();
        journal.setDate_added(ParseDate("01-10-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/springmvc");
        journal.setProject("Spring - Java");
        journal.setTechnology("spring");
        journal.setComments("good mvc example from spring guru");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//53
        journal = getJournal();
        journal.setDate_added(ParseDate("10-08-2016"));
        journal.setMachine("imac");
        journal.setDirectory("nodework/DougStudyApp");
        journal.setProject("node");
        journal.setTechnology("node");
        journal.setComments("Study app in node/mongo, deployed to CF");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//    54
        journal = getJournal();
        journal.setDate_added(ParseDate("7-23-2016"));
        journal.setMachine("imac");
        journal.setDirectory("gitwork/git-exampleDoug");
        journal.setProject("node");
        journal.setTechnology("git");
        journal.setComments("simple git example of basic operations");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        55
        journal = getJournal();
        journal.setDate_added(ParseDate("01-01-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/sfgthymeleaf");
        journal.setProject("SfgthymeleafDoug");
        journal.setTechnology("spring");
        journal.setComments("good example of using thymeleaf");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());


//        56
        journal = getJournal();
        journal.setDate_added(ParseDate("07-23-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/cardrancomizerweb");
        journal.setProject("cardrandomizerweb");
        journal.setTechnology("spring");
        journal.setComments("app to memorize a deck of cards");
        journal.setActive(true);
        JournalRepository.save(journal);

        log.info("Saved record - id: " + journal.getId());

//        57
        journal = getJournal();
        journal.setDate_added(ParseDate("11-16-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springbootlearning/microservices/gs-guitar-db");
        journal.setProject("Microservices");
        journal.setTechnology("spring");
        journal.setComments("good microservices example");
        journal.setActive(false);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        58
        journal = getJournal();
        journal.setDate_added(ParseDate("1-22-2016"));
        journal.setMachine("imac");
        journal.setDirectory("nodework/cardrandomizer");
        journal.setProject("cardrandomizer");
        journal.setTechnology("spring");
        journal.setComments("memorize deck of cards");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        59
        journal = getJournal();
        journal.setDate_added(ParseDate("01-01-2016"));
        journal.setMachine("imac");
        journal.setDirectory("gitwork/git-exampleDoug");
        journal.setProject("git");
        journal.setTechnology("spring");
        journal.setComments("simple git example of basic operations");
        journal.setActive(true);
        JournalRepository.save(journal);


        log.info("Saved record - id:" + journal.getId());

//        60
        journal = getJournal();
        journal.setDate_added(ParseDate("12-31-2016"));
        journal.setMachine("mbp13");
        journal.setDirectory("workspace/springcore/springcorelearning");
        journal.setProject("SfgSpringCoreDoug");
        journal.setTechnology("spring");
        journal.setComments("spring core learning");
        journal.setActive(false);
        JournalRepository.save(journal);

        log.info("Saved record - id:" + journal.getId());

    }
}
