package service.impl;

import model.CategoryVideoCount_22162017;
import model.Videos_22162017;
import service.IVideoService_22162017;

import java.util.List;

import dao.impl.VideoDao_22162017;

public class VideoServiceImpl_22162017 implements IVideoService_22162017 {
    private VideoDao_22162017 videoDao;

    public VideoServiceImpl_22162017() {
        this.videoDao = videoDao;
    }

    public Videos_22162017 getVideoById(String id) {
        return videoDao.findVideoById(id);
    }

	public Videos_22162017 findById(int videoId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
