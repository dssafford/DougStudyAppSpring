package com.doug.services;

import com.doug.domain.Journal;
import com.doug.repositories.JournalRepository;
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
    private JournalRepository JournalRepository;

    @Autowired
    public void setJournalRepository(JournalRepository JournalRepository) {
        this.JournalRepository = JournalRepository;
    }


    private Pageable createPageRequest(Integer pageNumber, Integer pageSize, Sort sort) {
        return new PageRequest(pageNumber, pageSize , sort);
    }

//    @Override
//    public Iterable<Journal> findByProjectLike(String projectName) {
//        return JournalRepository.findByProjectLike(projectName);
//    }

    @Override
    public Page<Journal> listAllByPage(Pageable pageable, String sortColumn, String sortDirection) {



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


       return JournalRepository.findAll(createPageRequest(pageNumber, pageSize, sort));
    }


    @Override
    public Iterable<Journal> listAllJournals() {
        return JournalRepository.findAll();
    }

    @Override
    public Journal getJournalById(Integer id) {
        return JournalRepository.findOne(id);
    }

//    @Override
//    public JournalCommand

    @Override
    public Journal saveOrUpdateJournal(Journal journal) {

        if(journal.getId()==null) {
            return JournalRepository.save(journal);
        }

        Journal updatedEntry = this.getJournalById(journal.getId());
        updatedEntry.setId(journal.getId());
        updatedEntry.setMachine(journal.getMachine());
        updatedEntry.setDirectory(journal.getDirectory());
        updatedEntry.setProject(journal.getProject());
        updatedEntry.setComments(journal.getComments());

        return JournalRepository.save(updatedEntry);

    }

    @Override
    public void deleteJournal(Integer id) {
        Journal Journal = JournalRepository.findOne(id);
        JournalRepository.delete(id);
    }


//    @Override
//    public Iterable<Journal> listAllJournals() {
//        return JournalRepository.findAll();
//    }
//
//    @Override
//    public Journal getJournalById(Integer id) {
//        return JournalRepository.findOne(id);
//    }
//
//    @Override
//    public Journal saveJournal(Journal journal) {
//        return JournalRepository.save(journal);
//    }
}
