package com.microboot.bookstore.bookcatalog.model;


public class BooksResponse {

    private Long id;
    private String title;
    private String authorName;
    private String description;
    private Double price;
    private Double rating;
    private String genre;
    
    private BooksResponse(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.authorName = builder.authorName;
        this.description = builder.description;
        this.price = builder.price;
        this.rating = builder.rating;
        this.genre = builder.genre;
    }

    
    public static class Builder {
        private Long id;
        private String title;
        private String authorName;
        private String description;
        private Double price;
        private Double rating;
        private String genre;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder authorName(String authorName) {
            this.authorName = authorName;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Builder rating(Double rating) {
            this.rating = rating;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public BooksResponse build() {
            return new BooksResponse(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Double getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

}
