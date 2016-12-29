package com.doug.repositories;

import com.doug.domain.Journal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by doug on 12/25/16.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class RepositoryTests {


    @Autowired
    private JournalRepository journalRepository;


    @Test
    public void testFindProjectByLike(){
        List<Journal> journalList = journalRepository.findByProjectLike("Spring%");
        assertNotNull(journalList);
        assertEquals(6, journalList.size());

    }


    @Test
    public void testFindMachineByLike(){
        List<Journal> journalList = journalRepository.findByMachineLike("mbp%");
        assertNotNull(journalList);
        assertEquals(42, journalList.size());

    }

    @Test
    public void testCountByMachineName(){
        assertNotNull(journalRepository.countByMachine("iMAC"));

        assertEquals(new Long(18), journalRepository.countByMachine("iMAC"));
    }

//    final Page<Something> page = new PageImpl<>(theListOfSomething);

    @Test
    public void testPageByMachineName(){
        assertNotNull(journalRepository.findByMachineLike("iMAC"));

        //PageImpl page = new PageImpl(journalRepository.findByMachineLike("iMac"));

        assertEquals(18, journalRepository.findByMachineLike("iMac").size());

        //System.out.println("Hey Doug, anything show up?:" + journalRepository.findByMachineLike("iMac"));
    }
}
