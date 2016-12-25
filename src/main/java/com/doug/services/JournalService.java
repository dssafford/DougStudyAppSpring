package com.doug.services;


import com.doug.domain.Journal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface JournalService {

    Iterable<Journal> listAllJournals();

    Journal getJournalById(Integer id);

    Journal saveOrUpdateJournal(Journal journal);

    void deleteJournal(Integer id);

    Page<Journal> listAllByPage(@PageableDefault(size = 10) Pageable pageable, String sortColumn, String sortDirection);

//    Iterable<Journal> findByProjectLike(String projectName);
}
