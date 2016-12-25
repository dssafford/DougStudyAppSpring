package com.doug.repositories;

import com.doug.domain.Journal;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface JournalRepository extends PagingAndSortingRepository<Journal, Integer> {
    List<Journal> findByProjectLike(String projectName);

    List<Journal> findByMachineLike(String machineName);


}
