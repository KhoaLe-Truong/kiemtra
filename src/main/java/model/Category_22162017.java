package model;

import lombok.Data;

@Data
public class Category_22162017 {
    private int categoryId;
    private String categoryName;
    private String categorycode;
    private String images;
    private boolean status;

    // Constructors
    public Category_22162017() {}

    public Category_22162017(int categoryId, String categoryname, String categorycode, String images, boolean status) {
        this.categoryId = categoryId;
        this.categoryName = categoryname;
        this.categorycode = categorycode;
        this.images = images;
        this.status = status;
    }

  
}
