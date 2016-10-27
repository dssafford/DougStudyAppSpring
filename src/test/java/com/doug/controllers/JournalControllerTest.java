package com.doug.controllers;

import com.doug.domain.JournalSql;
import com.doug.services.JournalService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Doug on 10/14/16.
 */
public class JournalControllerTest {

	@Mock //Mockito Mock object
	private JournalService journalService;

	@InjectMocks //setups up controller, and injects mock objects into it.
	private JournalController journalController;

	private MockMvc mockMvc;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this); //initilizes controller and mocks

		mockMvc = MockMvcBuilders.standaloneSetup(journalController).build();
	}

	@Test
	public void testList() throws Exception{

		List<JournalSql> journalSqls = new ArrayList<>();
		journalSqls.add(new JournalSql());
		journalSqls.add(new JournalSql());

		//specific Mockito interaction, tell stub to return list of Journals
		when(journalService.listAllJournals()).thenReturn((List) journalSqls); //need to strip generics to keep Mockito happy.

		mockMvc.perform(get("/journal/list"))
				  .andExpect(status().isOk())
				  .andExpect(view().name("journals"))
				  .andExpect(model().attribute("journals", hasSize(2)));
	}

	@Test
	public void testShow() throws Exception{
		Integer id = 1;

		//Tell Mockito stub to return new Journal for ID 1
		when(journalService.getJournalById(id)).thenReturn(new JournalSql());

		mockMvc.perform(get("/journal/1"))
				  .andExpect(status().isOk())
				  .andExpect(view().name("journalshow"))
				  .andExpect(model().attribute("journal", instanceOf(JournalSql.class)));
	}

	@Test
	public void testEdit() throws Exception{
		Integer id = 1;

		//Tell Mockito stub to return new Journal for ID 1
		when(journalService.getJournalById(id)).thenReturn(new JournalSql());

		mockMvc.perform(get("/journal/edit/1"))
				  .andExpect(status().isOk())
				  .andExpect(view().name("journaledit"))
				  .andExpect(model().attribute("journal", instanceOf(JournalSql.class)));
	}

	@Test
	public void testNewJournal() throws Exception {
		Integer id = 1;

		//should not call service
		verifyZeroInteractions(journalService);

		mockMvc.perform(get("/journal/new"))
				  .andExpect(status().isOk())
				  .andExpect(view().name("journalformnew"))
				  .andExpect(model().attribute("journal", instanceOf(JournalSql.class)));
	}

	@Test
	public void testSaveJournal() throws Exception {
		Integer id = 1;
		String machine = "Test Machine";
		String directory = "Test Directory";
		String project = "Test Project";
		String comments = "My Comments";

		JournalSql returnJournal = new JournalSql();
		returnJournal.setId(id);
		returnJournal.setMachine(machine);
		returnJournal.setProject(project);
		returnJournal.setDirectory(directory);
		returnJournal.setComments(comments);

		when(journalService.saveOrUpdateJournal(Matchers.<JournalSql>any())).thenReturn(returnJournal);

		mockMvc.perform(post("/dojournal")
				  .param("id", "1")
				  .param("machine", machine)
				  .param("directory", directory)
				  .param("project", project)
				  .param("comments", comments))
				  .andExpect(status().is3xxRedirection())
				  .andExpect(view().name("redirect:/journal/1"))
				  .andExpect(model().attribute("journalSql", instanceOf(JournalSql.class)))
				  .andExpect(model().attribute("journalSql", hasProperty("id", is(id))))
				  .andExpect(model().attribute("journalSql", hasProperty("machine", is(machine))))
				  .andExpect(model().attribute("journalSql", hasProperty("project", is(project))))
				  .andExpect(model().attribute("journalSql", hasProperty("comments", is(comments))))
				  .andExpect(model().attribute("journalSql", hasProperty("directory", is(directory))));

		//verify properties of bound object
		ArgumentCaptor<JournalSql> boundJournal = ArgumentCaptor.forClass(JournalSql.class);
		verify(journalService).saveOrUpdateJournal(boundJournal.capture());

		assertEquals(id, boundJournal.getValue().getId());
		assertEquals(machine, boundJournal.getValue().getMachine());
		assertEquals(directory, boundJournal.getValue().getDirectory());
		assertEquals(project, boundJournal.getValue().getProject());
		assertEquals(comments, boundJournal.getValue().getComments());
	}

	@Test
	public void testDelete() throws Exception{
		Integer id = 1;

		mockMvc.perform(get("/journal/delete/1"))
				  .andExpect(status().is3xxRedirection())
				  .andExpect(view().name("redirect:/journal/list"));

		verify(journalService, times(1)).deleteJournal(id);
	}
	
}
