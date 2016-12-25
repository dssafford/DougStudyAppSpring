package com.doug.repositories;

import com.doug.domain.JournalSql;
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
    private JournalSqlRepository journalSqlRepository;


    @Test
    public void testFindProjectByLike(){
        List<JournalSql> journalSqlList = journalSqlRepository.findByProjectLike("Spring%");
        assertEquals(2, journalSqlList.size());

    }


    @Test
    public void testFindMachineByLike(){
        List<JournalSql> journalSqlList = journalSqlRepository.findByMachineLike("mbp%");
        assertEquals(3, journalSqlList.size());

    }
}
