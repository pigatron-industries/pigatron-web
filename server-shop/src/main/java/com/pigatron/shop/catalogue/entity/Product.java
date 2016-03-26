package com.pigatron.shop.catalogue.entity;

import javax.validation.constraints.NotNull;

import com.pigatron.shop.catalogue.entity.option.ProductOption;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;


public class Product {

    // General
    @Id private String id;
    @NotNull private String name;
    @NotNull @Indexed(unique = true) private String sku;
    private String shortDescription;
    private String description;
    private String location;
    private boolean enabled;
    private boolean visibleInCategory;
    private String urlKey;

    // Price
    private int price;
    private String taxClass; //determines how much VAT to add

    // Meta Info
    private String metaTitle;
    private String metaKeywords;
    private String metaDescription;

    // Images
    @DBRef private ProductImage thumbnailImage;
    @DBRef private List<ProductImage> productImages;

    // Supply


    // Inventory
    private int quantity;
    private boolean allowBackorders;
    private int maxInCart;

    // Categories
    @DBRef private List<ProductCategory> categories;

    // Reviews
    private List<ProductReview> reviews;

    // Options
    private List<ProductOption> options;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isVisibleInCategory() {
        return visibleInCategory;
    }

    public void setVisibleInCategory(boolean visibleInCategory) {
        this.visibleInCategory = visibleInCategory;
    }

    public String getUrlKey() {
        return urlKey;
    }

    public void setUrlKey(String urlKey) {
        this.urlKey = urlKey;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public ProductImage getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(ProductImage thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAllowBackorders() {
        return allowBackorders;
    }

    public void setAllowBackorders(boolean allowBackorders) {
        this.allowBackorders = allowBackorders;
    }

    public int getMaxInCart() {
        return maxInCart;
    }

    public void setMaxInCart(int maxInCart) {
        this.maxInCart = maxInCart;
    }

    public List<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ProductCategory> categories) {
        this.categories = categories;
    }

    public List<ProductReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReview> reviews) {
        this.reviews = reviews;
    }

    public List<ProductOption> getOptions() {
        return options;
    }

    public void setOptions(List<ProductOption> options) {
        this.options = options;
    }
}
