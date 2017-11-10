package de.aboutyou.holders;

/**
 * Product Holder
 * Class that help contain data about product on page
 * @author Michael Rudyy
 * @version 1.0
 */

public class ProductHolder {
    private String name;
    private String brand;
    private String color;
    private String price;
    private String initialPrice;
    private String description;
    private String articleID;
    private String shippingCosts;

    @Override
    public String toString() {
        return "ProductHolder{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", initialPrice='" + initialPrice + '\'' +
                ", description='" + description + '\'' +
                ", articleID='" + articleID + '\'' +
                ", shippingCosts='" + shippingCosts + '\'' +
                '}';
    }

    public ProductHolder(String name, String brand, String color, String price, String initialPrice, String description, String articleID, String shippingCosts) {
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.initialPrice = initialPrice;
        this.description = description;
        this.articleID = articleID;
        this.shippingCosts = shippingCosts;
    }

    public ProductHolder() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(String initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public String getShippingCosts() {
        return shippingCosts;
    }

    public void setShippingCosts(String shippingCosts) {
        this.shippingCosts = shippingCosts;
    }
}
