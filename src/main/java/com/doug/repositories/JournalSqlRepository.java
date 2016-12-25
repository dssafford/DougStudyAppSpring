package com.doug.repositories;

import com.doug.domain.JournalSql;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface JournalSqlRepository extends PagingAndSortingRepository<JournalSql, Integer> {
    List<JournalSql> findByProjectLike(String projectName);

    List<JournalSql> findByMachineLike(String machineName);


}
