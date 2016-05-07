package com.pigatron.shop.catalogue.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pigatron.shop.catalogue.entity.option.ProductOption;
import com.pigatron.shop.catalogue.entity.option.SelectProduct;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Document
public class Product {

    // General
    @Id private String id;
    private boolean enabled;
    @NotNull private String name;
    @Indexed(unique = true) private String sku;
    @Indexed(unique = true) private String urlKey;
    private String shortDescription;
    private String description;
    private String location;

    // Price
    private Float price;
    private ProductTaxClass taxClass; //determines how much VAT to add

    // Meta Info
    private String metaTitle;
    private String metaKeywords;
    private String metaDescription;

    // Images
    private List<ProductImage> images;

    // Inventory
    private Integer quantity;
    private Boolean useQuantityOnOptions;
    private Boolean allowBackorders;
    private Integer maxInCart;

    // Categories
    @JsonIgnoreProperties({"subcategories"}) @DBRef private List<ProductCategory> categories;

    // Reviews
    private List<ProductReview> reviews;

    // Options
    private boolean isOption;
    private List<ProductOption> options;
    @JsonIgnoreProperties({"options"}) @DBRef private Product parentProduct;

    // Supply
    private String supplierName;
    private String supplierItemCode;
    private String supplierItemLink;
    private String supplierPrice;
    private String supplierNotes;
    private String quantityOnOrder;

    public Product() {
        this.images = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public String getId() {
        return id;
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

    public boolean getIsOption() {
        return isOption;
    }

    public void setIsOption(boolean isOption) {
        this.isOption = isOption;
    }

    public Product getParentProduct() {
        return parentProduct;
    }

    public void setParentProduct(Product parentProduct) {
        this.parentProduct = parentProduct;
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

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
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
        if(useQuantityOnOptions != null && useQuantityOnOptions) {
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
        if(options != null && options.isEmpty()) {
            this.options = null;
        }
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


    @JsonIgnore
    public List<Product> getAllOptionProducts() {
        ArrayList<Product> optionProducts = new ArrayList<>();
        if(this.options != null) {
            for (ProductOption option : this.options) {
                if (option instanceof SelectProduct) {
                    optionProducts.addAll(((SelectProduct) option).getProducts());
                }
            }
        }
        return optionProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return id != null ? id.equals(product.id) : product.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    /**
     * Builder
     */
    public static final class ProductBuilder {
        // General
        private String id;
        private boolean enabled;
        private String name;
        private String sku;
        private String urlKey;
        private String shortDescription;
        private String description;
        private String location;
        // Price
        private Float price;
        private ProductTaxClass taxClass;
        // Meta Info
        private String metaTitle;
        private String metaKeywords;
        private String metaDescription;
        // Images
        private List<ProductImage> images;
        // Inventory
        private Integer quantity;
        private Boolean useQuantityOnOptions;
        private Boolean allowBackorders;
        private Integer maxInCart;
        // Categories
        private List<ProductCategory> categories;
        // Reviews
        private List<ProductReview> reviews;
        // Options
        private boolean isOption;
        private List<ProductOption> options;
        // Supply
        private String supplierName;
        private String supplierItemCode;
        private String supplierItemLink;
        private String supplierPrice;
        private String supplierNotes;
        private String quantityOnOrder;

        private ProductBuilder() {
        }

        public static ProductBuilder aProduct() {
            return new ProductBuilder();
        }

        public ProductBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ProductBuilder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder sku(String sku) {
            this.sku = sku;
            return this;
        }

        public ProductBuilder urlKey(String urlKey) {
            this.urlKey = urlKey;
            return this;
        }

        public ProductBuilder shortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
            return this;
        }

        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder location(String location) {
            this.location = location;
            return this;
        }

        public ProductBuilder price(Float price) {
            this.price = price;
            return this;
        }

        public ProductBuilder taxClass(ProductTaxClass taxClass) {
            this.taxClass = taxClass;
            return this;
        }

        public ProductBuilder metaTitle(String metaTitle) {
            this.metaTitle = metaTitle;
            return this;
        }

        public ProductBuilder metaKeywords(String metaKeywords) {
            this.metaKeywords = metaKeywords;
            return this;
        }

        public ProductBuilder metaDescription(String metaDescription) {
            this.metaDescription = metaDescription;
            return this;
        }

        public ProductBuilder images(List<ProductImage> images) {
            this.images = images;
            return this;
        }

        public ProductBuilder category(ProductImage image) {
            if(this.images == null) {
                this.images = new ArrayList<>();
            }
            this.images.add(image);
            return this;
        }

        public ProductBuilder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductBuilder useQuantityOnOptions(Boolean useQuantityOnOptions) {
            this.useQuantityOnOptions = useQuantityOnOptions;
            return this;
        }

        public ProductBuilder allowBackorders(Boolean allowBackorders) {
            this.allowBackorders = allowBackorders;
            return this;
        }

        public ProductBuilder maxInCart(Integer maxInCart) {
            this.maxInCart = maxInCart;
            return this;
        }

        public ProductBuilder categories(List<ProductCategory> categories) {
            this.categories = categories;
            return this;
        }

        public ProductBuilder category(ProductCategory category) {
            if(this.categories == null) {
                this.categories = new ArrayList<>();
            }
            this.categories.add(category);
            return this;
        }

        public ProductBuilder reviews(List<ProductReview> reviews) {
            this.reviews = reviews;
            return this;
        }

        public ProductBuilder isOption(boolean isOption) {
            this.isOption = isOption;
            return this;
        }

        public ProductBuilder options(List<ProductOption> options) {
            this.options = options;
            return this;
        }

        public ProductBuilder option(ProductOption option) {
            if(this.options == null) {
                this.options = new ArrayList<>();
            }
            this.options.add(option);
            return this;
        }

        public ProductBuilder supplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public ProductBuilder supplierItemCode(String supplierItemCode) {
            this.supplierItemCode = supplierItemCode;
            return this;
        }

        public ProductBuilder supplierItemLink(String supplierItemLink) {
            this.supplierItemLink = supplierItemLink;
            return this;
        }

        public ProductBuilder supplierPrice(String supplierPrice) {
            this.supplierPrice = supplierPrice;
            return this;
        }

        public ProductBuilder supplierNotes(String supplierNotes) {
            this.supplierNotes = supplierNotes;
            return this;
        }

        public ProductBuilder quantityOnOrder(String quantityOnOrder) {
            this.quantityOnOrder = quantityOnOrder;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.id = id;
            product.setEnabled(enabled);
            product.setName(name);
            product.setSku(sku);
            product.setUrlKey(urlKey);
            product.setShortDescription(shortDescription);
            product.setDescription(description);
            product.setLocation(location);
            product.setPrice(price);
            product.setTaxClass(taxClass);
            product.setMetaTitle(metaTitle);
            product.setMetaKeywords(metaKeywords);
            product.setMetaDescription(metaDescription);
            product.setImages(images);
            product.setQuantity(quantity);
            product.setUseQuantityOnOptions(useQuantityOnOptions);
            product.setAllowBackorders(allowBackorders);
            product.setMaxInCart(maxInCart);
            product.setCategories(categories);
            product.setReviews(reviews);
            product.setIsOption(isOption);
            product.setOptions(options);
            product.setSupplierName(supplierName);
            product.setSupplierItemCode(supplierItemCode);
            product.setSupplierItemLink(supplierItemLink);
            product.setSupplierPrice(supplierPrice);
            product.setSupplierNotes(supplierNotes);
            product.setQuantityOnOrder(quantityOnOrder);
            return product;
        }
    }
}
