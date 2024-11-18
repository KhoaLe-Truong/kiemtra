package service.impl;
import model.CategoryVideoCount_22162017;
import model.Category_22162017;
import model.Videos_22162017;

import java.util.List;

import dao.IVideoCategoryDao_22162017;
import dao.impl.VideoCategoryDaoImpl_22162017;
public class VideoCategoryServiceImpl_22162017 implements IVideoCategoryDao_22162017 {
	private VideoCategoryDaoImpl_22162017 videoDao;

	@Override
    public List<Videos_22162017> getVideosByCategory(int categoryId) {
        return videoDao.getVideosByCategory(categoryId);
    }

	public List<CategoryVideoCount_22162017> getVideoCountByCategory() {
		return videoDao.getVideoCountByCategory();
	}

	@Override
	public List<Category_22162017> getAllCategories() {
		return videoDao.getAllCategories();
	}
}
