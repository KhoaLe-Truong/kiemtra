package model;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import model.Videos_22162017;
@Data
public class Favorites_22162017 {
    private int favoriteId;
    private Date likedDate;
    private Videos_22162017 video;
    private Users_22162017 user;
}