package com.just.entity;

import java.util.List;

/**
 价格属性 由产品 规格和单位一同决定
 SKU
 最小单元格
 */
public class Price {
    //主键 价格id
    private Integer priceId;
    //商品规格
    private Spec spec;
    //商品容量
    private Unit unit;
    //对应商品
    private Product product;
    //private DetailsProduct detailsProduct;
    //商品对应多个库存
    private List<Stock> stocks;

    //价格实际属性数字
    private Double priceName;
//    private Integer pId;
//    private Integer specId ;
//    private Integer unitId;


    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }



    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public Double getPriceName() {
        return priceName;
    }

    public void setPriceName(Double priceName) {
        this.priceName = priceName;
    }

    public Price() {
        super();
    }

    @Override
    public String toString() {
        return "Price{" +
                "priceId=" + priceId +
                ", spec=" + spec +
                ", unit=" + unit +
                ", product=" + product +
                ", stocks=" + stocks +
                ", priceName=" + priceName +
                '}';
    }

    public Price(Product product,Spec spec, Unit unit) {
        this.spec = spec;
        this.unit = unit;
        this.product = product;
    }
    //    public DetailsProduct getDetailsProduct() {
//        return detailsProduct;
//    }
//
//    public void setDetailsProduct(DetailsProduct detailsProduct) {
//        this.detailsProduct = detailsProduct;
//    }



}

