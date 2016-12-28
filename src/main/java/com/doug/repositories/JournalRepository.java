package com.doug.repositories;

import com.doug.domain.Journal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface JournalRepository extends PagingAndSortingRepository<Journal, Integer> {
    List<Journal> findByProjectLike(String projectName);

    List<Journal> findByMachineLike(String machineName);

    Long countByMachine(String machineName);//

    Page<Journal> findByMachineLike(String machineName, Pageable pageable);

}
