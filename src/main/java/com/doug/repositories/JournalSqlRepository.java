package com.doug.repositories;

import com.doug.domain.JournalSql;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JournalSqlRepository extends PagingAndSortingRepository<JournalSql, Integer> {
}
