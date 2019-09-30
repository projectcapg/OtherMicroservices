package com.cg.pcm.entity;

import org.springframework.stereotype.Component;

import com.cg.pcm.exception.ExceptionBody;

@Component
public class Response {
	private boolean success;
	private Project project;
	private ExceptionBody exception;

	public Response(boolean success, Project project, ExceptionBody exception) {
		super();
		this.success = success;
		this.project = project;
		this.exception = exception;
	}

	public Response() {
		super();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ExceptionBody getException() {
		return exception;
	}

	public void setException(ExceptionBody exception) {
		this.exception = exception;
	}
}
