package com.doug;

/**
 * Created by Doug on 9/4/16.
 */

import com.doug.domain.Journal;
import com.doug.services.JournalService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class MockJournalCreationTest {
	private JournalService journalService;
	private Journal Journal;


	@Before
	public void setupMock() {
		Journal = mock(Journal.class);
		journalService = mock(JournalService.class);
	}
	@Test
	public void testMockCreation(){
		assertNotNull(Journal);
		assertNotNull(journalService);
	}
}
