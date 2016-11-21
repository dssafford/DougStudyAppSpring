package com.doug.services;

import com.doug.domain.JournalSql;
import com.doug.repositories.JournalSqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class JournalServiceImpl implements JournalService {
    private JournalSqlRepository journalSqlRepository;

    @Autowired
    public void setJournalRepository(JournalSqlRepository journalSqlRepository) {
        this.journalSqlRepository = journalSqlRepository;
    }

    @Override
    public Page<JournalSql> listAllByPage(Pageable pageable) {
       return journalSqlRepository.findAll(pageable);
    }

    @Override
    public Iterable<JournalSql> listAllJournals() {
        return journalSqlRepository.findAll();
    }

    @Override
    public JournalSql getJournalById(Integer id) {
        return journalSqlRepository.findOne(id);
    }

//    @Override
//    public JournalCommand

    @Override
    public JournalSql saveOrUpdateJournal(JournalSql journal) {

        if(journal.getId()==null) {
            return journalSqlRepository.save(journal);
        }

        JournalSql updatedEntry = this.getJournalById(journal.getId());
        updatedEntry.setId(journal.getId());
        updatedEntry.setMachine(journal.getMachine());
        updatedEntry.setDirectory(journal.getDirectory());
        updatedEntry.setProject(journal.getProject());
        updatedEntry.setComments(journal.getComments());

        return journalSqlRepository.save(updatedEntry);

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
