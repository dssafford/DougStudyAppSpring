package com.doug.services;

import com.doug.domain.JournalSql;
import com.doug.repositories.JournalSqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalServiceImpl implements JournalService {
    private JournalSqlRepository journalSqlRepository;

    @Autowired
    public void setJournalRepository(JournalSqlRepository journalSqlRepository) {
        this.journalSqlRepository = journalSqlRepository;
    }

    @Override
    public Iterable<JournalSql> listAllJournals() {
        return journalSqlRepository.findAll();
    }

    @Override
    public JournalSql getJournalById(Integer id) {
        return journalSqlRepository.findOne(id);
    }

    @Override
    public JournalSql saveJournal(JournalSql journal) {
        return journalSqlRepository.save(journal);
    }

    @Override
    public void deleteJournal(Integer id) {
        journalSqlRepository.delete(id);
    }


//    @Override
//    public Iterable<Journal> listAllJournals() {
//        return journalSqlRepository.findAll();
//    }
//
//    @Override
//    public Journal getJournalById(Integer id) {
//        return journalSqlRepository.findOne(id);
//    }
//
//    @Override
//    public Journal saveJournal(Journal journal) {
//        return journalSqlRepository.save(journal);
//    }
}
