package com.doug.repositories;

import com.doug.domain.Journal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by doug on 12/25/16.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class RepositoryTests {


    @Autowired
    private JournalRepository JournalRepository;


    @Test
    public void testFindProjectByLike(){
        List<Journal> JournalList = JournalRepository.findByProjectLike("Spring%");
        assertEquals(2, JournalList.size());

    }


    @Test
    public void testFindMachineByLike(){
        List<Journal> JournalList = JournalRepository.findByMachineLike("mbp%");
        assertEquals(3, JournalList.size());

    }
}
