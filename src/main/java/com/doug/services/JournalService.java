package com.doug.services;


import com.doug.domain.JournalSql;

public interface JournalService {

    Iterable<JournalSql> listAllJournals();

    JournalSql getJournalById(Integer id);

    JournalSql saveJournal(JournalSql journal);
}
