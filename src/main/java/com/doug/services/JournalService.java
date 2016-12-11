package com.doug.services;


import com.doug.domain.JournalSql;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

public interface JournalService {

    Iterable<JournalSql> listAllJournals();

    JournalSql getJournalById(Integer id);

    JournalSql saveOrUpdateJournal(JournalSql journal);

    void deleteJournal(Integer id);

    Page<JournalSql> listAllByPage(@PageableDefault(size = 10) Pageable pageable, String sortColumn, String sortDirection);

}
