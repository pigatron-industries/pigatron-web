package com.pigatron.shop.catalogue.entity;

import javax.validation.constraints.NotNull;

import com.pigatron.shop.catalogue.entity.option.ProductOption;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Product {

    // General
    @Id private String id;
    private boolean enabled;
    private boolean option;
    @NotNull private String name;
    @NotNull @Indexed(unique = true) private String sku;
    @NotNull @Indexed(unique = true) private String urlKey;
    private String shortDescription;
    private String description;
    private String location;

    // Shipping
    //private float weight;

    // Price
    private Float price;
    private Boolean usePriceOnOptions;
    private ProductTaxClass taxClass; //determines how much VAT to add

    // Meta Info
    private String metaTitle;
    private String metaKeywords;
    private String metaDescription;

    // Images
    @DBRef private ProductImage thumbnailImage;
    @DBRef private List<ProductImage> productImages;

    // Inventory
    private Integer quantity;
    private Boolean useQuantityOnOptions;
    private Boolean allowBackorders;
    private Integer maxInCart;

    // Categories
    @DBRef private List<ProductCategory> categories;

    // Reviews
    private List<ProductReview> reviews;

    // Options
    private List<ProductOption> options;

    // Supply
    private String supplierName;
    private String supplierItemCode;
    private String supplierItemLink;
    private String supplierPrice;
    private String supplierNotes;
    private String quantityOnOrder;


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

    public boolean isOption() {
        return option;
    }

    public void setOption(boolean option) {
        this.option = option;
    }

    public String getUrlKey() {
        return urlKey;
    }

    public void setUrlKey(String urlKey) {
        this.urlKey = urlKey;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public ProductTaxClass getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(ProductTaxClass taxClass) {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getUseQuantityOnOptions() {
        return useQuantityOnOptions;
    }

    public void setUseQuantityOnOptions(Boolean useQuantityOnOptions) {
        this.useQuantityOnOptions = useQuantityOnOptions;
        if(useQuantityOnOptions) {
            quantity = null;
        }
    }

    public Boolean getAllowBackorders() {
        return allowBackorders;
    }

    public void setAllowBackorders(Boolean allowBackorders) {
        this.allowBackorders = allowBackorders;
    }

    public Integer getMaxInCart() {
        return maxInCart;
    }

    public void setMaxInCart(Integer maxInCart) {
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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierItemCode() {
        return supplierItemCode;
    }

    public void setSupplierItemCode(String supplierItemCode) {
        this.supplierItemCode = supplierItemCode;
    }

    public String getSupplierItemLink() {
        return supplierItemLink;
    }

    public void setSupplierItemLink(String supplierItemLink) {
        this.supplierItemLink = supplierItemLink;
    }

    public String getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(String supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public String getSupplierNotes() {
        return supplierNotes;
    }

    public void setSupplierNotes(String supplierNotes) {
        this.supplierNotes = supplierNotes;
    }

    public String getQuantityOnOrder() {
        return quantityOnOrder;
    }

    public void setQuantityOnOrder(String quantityOnOrder) {
        this.quantityOnOrder = quantityOnOrder;
    }
}
