package model;

import java.util.Date;

import lombok.Data;
@SuppressWarnings("unused")
@Data
public class Videos_22162017 {
    private String videoId;
    private String title;
    private String poster;
    private int views;
    private String description;
    private boolean active;
    private Category_22162017 category;
	public Videos_22162017(String videoId, String title, String poster, int views, String description, boolean active,
			Category_22162017 category) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.poster = poster;
		this.views = views;
		this.description = description;
		this.active = active;
		this.category = category;
	}
	public Videos_22162017() {
		
		// TODO Auto-generated constructor stub
	}
	
 

}
