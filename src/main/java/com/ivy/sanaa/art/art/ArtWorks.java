package com.ivy.sanaa.art.art;

public class ArtWorks {
        private int id;
        public ArtWorks(int id2, String title, String description, String category, String label, int price, int i, String imgUrl, int j) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.category = category;
            this.label = label;
            this.price = price;
            this.likes = likes;
            this.imgUrl = imgUrl;
            this.owner_id = owner_id;
        }

        private String title;
        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getOwner_id() {
            return owner_id;
        }

        public void setOwner_id(int owner_id) {
            this.owner_id = owner_id;
        }

        private String description;
        private String category;
        private String label;
        private int price;
        private int likes;
        private String imgUrl;
        private int owner_id;
        // private List<Integer> linkToComments;
    
        // Constructors, Getters, and Setters (as provided in the question)
        // ...
    
        public ArtWorks() {
        }
    
         public void setTitle(String parameter) {
    }

    public <User> void save(ArtWorks artwork, User user) {
    }

    public String getId() {
        return null;
    }
    }
    
        

