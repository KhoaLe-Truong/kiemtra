package model;

public class CategoryVideoCount_22162017 {
    private String categoryName;
    private int videoCount;

    public void CategoryVideoCount(String categoryName, int videoCount) {
        this.categoryName = categoryName;
        this.videoCount = videoCount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

	public CategoryVideoCount_22162017(String categoryName, int videoCount) {
		super();
		this.categoryName = categoryName;
		this.videoCount = videoCount;
	}
}
