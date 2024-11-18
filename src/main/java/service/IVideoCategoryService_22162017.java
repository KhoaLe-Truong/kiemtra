package service;


import java.util.List;

import model.CategoryVideoCount_22162017;
import model.Category_22162017;
import model.Videos_22162017;

public interface IVideoCategoryService_22162017 {
	public List<Videos_22162017> getVideosByCategory(int categoryId);
	List<CategoryVideoCount_22162017> getVideoCountByCategory();
	public List<Category_22162017> getAllCategories();
	
}
