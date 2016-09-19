package com.doug.repositories;

import com.doug.domain.JournalSql;
import org.springframework.data.repository.CrudRepository;

public interface JournalSqlRepository extends CrudRepository<JournalSql, Integer> {
}
