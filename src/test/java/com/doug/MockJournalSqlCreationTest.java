package com.doug;

/**
 * Created by Doug on 9/4/16.
 */

import com.doug.domain.JournalSql;
import com.doug.services.JournalService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class MockJournalSqlCreationTest {
	private JournalService journalService;
	private JournalSql journalSql;


	@Before
	public void setupMock() {
		journalSql = mock(JournalSql.class);
		journalService = mock(JournalService.class);
	}
	@Test
	public void testMockCreation(){
		assertNotNull(journalSql);
		assertNotNull(journalService);
	}
}
