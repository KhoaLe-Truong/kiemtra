package dao;

import java.util.List;

import model.CategoryVideoCount_22162017;
import model.Category_22162017;
import model.Videos_22162017;


public interface IVideoCategoryDao_22162017 {


	List<Videos_22162017> getVideosByCategory(int categoryId);
	List<CategoryVideoCount_22162017> getVideoCountByCategory()  ;
	List<Category_22162017> getAllCategories();
}
