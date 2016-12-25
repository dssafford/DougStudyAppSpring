package com.doug.services;

import com.doug.domain.JournalSql;
import com.doug.repositories.JournalSqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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


    private Pageable createPageRequest(Integer pageNumber, Integer pageSize, Sort sort) {
        return new PageRequest(pageNumber, pageSize , sort);
    }

//    @Override
//    public Iterable<JournalSql> findByProjectLike(String projectName) {
//        return journalSqlRepository.findByProjectLike(projectName);
//    }

    @Override
    public Page<JournalSql> listAllByPage(Pageable pageable, String sortColumn, String sortDirection) {



        Sort sort;

        if(sortColumn==null) {
            sortColumn="id";
        }

        if(sortDirection==null) {
            sort = new Sort(Sort.Direction.ASC, sortColumn);
        } else if(sortDirection.equals("DESC")) {
            sort = new Sort(Sort.Direction.DESC, sortColumn);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortColumn);
        }

        Integer pageNumber = pageable.getPageNumber();
        Integer pageSize = pageable.getPageSize();

//        Sort newSort = new Sort(sort, sortProperty);


       return journalSqlRepository.findAll(createPageRequest(pageNumber, pageSize, sort));
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
        JournalSql journalSql = journalSqlRepository.findOne(id);
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
