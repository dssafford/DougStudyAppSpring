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

import java.util.Date;


@Service
@Transactional
public class JournalServiceImpl implements JournalService {
    private JournalRepository journalRepository;

    @Autowired
    public void setJournalRepository(JournalRepository JournalRepository) {
        this.journalRepository = JournalRepository;
    }


    private Pageable createPageRequest(Integer pageNumber, Integer pageSize, Sort sort) {
        return new PageRequest(pageNumber, pageSize, sort);
    }

    private Pageable createPageRequest(Integer pageNumber, Integer pageSize) {
        return new PageRequest(pageNumber, pageSize);
    }


    @Override
    public Page<Journal> listAllByPage(Pageable pageable) {

        Integer pageNumber = pageable.getPageNumber();
        Integer pageSize = pageable.getPageSize();

        return journalRepository.findAll(pageable);


    }

    @Override
    public Page<Journal> listAllByPage(Pageable pageable, String sortColumn, String sortDirection) {


        Sort sort;

        if (sortColumn == null) {
            sortColumn = "id";
        }

        if (sortDirection == null) {
            sort = new Sort(Sort.Direction.ASC, sortColumn);
        } else if (sortDirection.equals("desc")) {
            sort = new Sort(Sort.Direction.DESC, sortColumn);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortColumn);
        }

        Integer pageNumber = pageable.getPageNumber();
        Integer pageSize = pageable.getPageSize();

//        Sort newSort = new Sort(sort, sortProperty);


        return journalRepository.findAll(createPageRequest(pageNumber, pageSize, sort));
    }


    @Override
    public Iterable<Journal> listAllJournals() {
        return journalRepository.findAll();
    }

    @Override
    public Journal getJournalById(Integer id) {
        return journalRepository.findOne(id);
    }

//    @Override
//    public JournalCommand

    @Override
    public Journal saveOrUpdateJournal(Journal journal) {

        if (journal.getId() == null) {
            return journalRepository.save(journal);
        }

        Journal updatedEntry = this.getJournalById(journal.getId());
        updatedEntry.setId(journal.getId());
        updatedEntry.setDate_added(new Date());
        updatedEntry.setMachine(journal.getMachine());
        updatedEntry.setDirectory(journal.getDirectory());
        updatedEntry.setProject(journal.getProject());
        updatedEntry.setComments(journal.getComments());

        return journalRepository.save(updatedEntry);

    }

    @Override
    public void deleteJournal(Integer id) {
        Journal Journal = journalRepository.findOne(id);
        journalRepository.delete(id);
    }
}