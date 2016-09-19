package com.doug.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Doug on 8/19/16.
 */

@Document
public class Journal {
	@Id
	private String id;
	private Date myDate;
	private String machine;
	private String directory;
	private String project;
	private String comments;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}




	public Journal() {}

	public Journal(Date myDate, String machine, String directory, String project, String comments) {
		this.myDate = myDate;
		this.machine = machine;
		this.directory = directory;
		this.project = project;
		this.comments = comments;
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		return String.format(
				  "Journal[id=%s, date=dateFormat.format(myDate), machine='%s', directory='%s'], project='$s', comments='%s'",
				  id, machine, directory, project, comments);
	}

}
