package com.rohit.question_service.dto;

public class GetScoreResponseDTO {
	
	private Integer id;
	private String response;
	
	public GetScoreResponseDTO() {
		super();
	}

	public GetScoreResponseDTO(Integer id, String response) {
		super();
		this.id = id;
		this.response = response;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	
}
