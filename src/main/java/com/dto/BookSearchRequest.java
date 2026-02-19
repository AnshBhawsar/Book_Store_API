package com.dto;

import lombok.Data;

@Data
public class BookSearchRequest {
private String title;
private String author;
private String category;
private double minPrice;
private double maxPrice;
private String  sortBy;
private int page=0;
private int size=5;

}
