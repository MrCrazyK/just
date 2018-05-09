package com.just.controller;

import com.just.Util.FastJson_All;
import com.just.entity.*;
import com.just.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private PriceService priceService;
    @Autowired
    private StockService stockService;

    @RequestMapping("/findProForCate")
    public void prodcut(int categoryId, HttpServletResponse response) {

        Map maps = new HashMap();
        response.setContentType("text/html;charset=UTF-8");
        List<Product> products = productService.findsProducts(categoryId);

        if (products.size() == 0) {
            maps.put("error",products);
        } else {
            maps.put("success",products);
        }

        FastJson_All.toJson(maps,response);

    }
    @RequestMapping("/addNew")
    public void newProduct(Product product,Integer[] specs, Integer[] units,HttpServletResponse response){
        System.out.println(specs);
        System.out.println(units);
        Date time = new Date();
        product.setpTime(time);
        productService.addNewProduct(product);
        List<Price> prices = new ArrayList<Price>();
        int num1 = 0;
        int num2 = 0;
        for (int specId:specs) {
            Spec spec = new Spec();
            System.out.println(specId+"ssssssssssssssss");
            spec.setSpecId(specId);
            for (int unitId:units){
                num2++;
                Unit unit = new Unit();
                Price price = new Price();
                price.setUnit(unit);
                price.setSpec(spec);
                price.setProduct(product);
                System.out.println(unitId+"uuuuuuuuuuuuuuuuuu");
                unit.setUnitId(unitId);
                if (num1 < units.length){
                    priceService.addUnitToProduct(price);
                    num1 ++;
                }
                if (num2 == units.length){
                    priceService.addSpecToProduct(price);
                    num2 = 0;
                }

                priceService.addTagsToPrice(price);
                System.out.println(price.getPriceId());
                prices.add(price);
            }
        }
        FastJson_All.toJson(prices,response);
    }
    @RequestMapping(value = "/updatePro",method = RequestMethod.GET)
    public void updateProduct(Product product,HttpServletResponse response){
        FastJson_All.toJson(productService.updateProductDetail(product),response);
    }

//    @RequestMapping("addTag.do")
//    public void addTagsToProduct(Integer[] specs, Integer[] units,int pId,HttpServletResponse response){
//        List<Price> prices = new ArrayList<Price>();
//        Price price = new Price();
//        price.setP_id(pId);
//        int num = 0;
//        for (int specId:specs) {
//            Spec spec = new Spec();
//            spec.setSpec_id(specId);
//            price.setSpec(spec);
//            priceService.addSpecToProduct(price);
//            for (int unitId:units){
//                Unit unit = new Unit();
//                unit.setUnit_id(unitId);
//                price.setUnit(unit);
//                if (num < units.length){
//                    priceService.addUnitToProduct(price);
//                    num ++;
//                }
//                priceService.addTagsToPrice(price);
//                System.out.println(price.getPrice_id());
//                prices.add(price);
//            }
//        }
//        FastJson_All.toJson(prices,response);
//    }
//    @RequestMapping("ggg.do")
//    public void addTagsToProduct(Details details,int pId,HttpServletResponse response){
//        System.out.println(details.getSpec());
//        System.out.println(details.getStock());
//        System.out.println(pId);
//        FastJson_All.toJson("男男女女女",response);
//    }
//    @RequestMapping("HHH.do")
//    public void addTagsToProductDDDDD(@Param("specs")IDS specs, @Param("units") IDS units, int pId, HttpServletResponse response){
//        System.out.println(specs);
//        System.out.println(units);
//        System.out.println(pId);
//        FastJson_All.toJson("男男女女女",response);
//    }

    @RequestMapping("/addStockToPrice")
    public void addPriceAndStock( String[]stockNames, Integer[] stockNums, int price_Id, HttpServletResponse response){
        System.out.println(price_Id);
        for (int i = 0;i < stockNames.length;i ++){
            Stock stock = new Stock();
            stock.setStockNum(stockNums[i]);
            stock.setStockName(stockNames[i]);
            stock.setStockId(price_Id);

        }FastJson_All.toJson("success",response);
    }
    @RequestMapping("/init")
    public void findAllTags(HttpServletResponse response){
        FastJson_All.toJson(productService.findAllTags(),response);
    }
    @RequestMapping("/addSpec")
    public void addSpec(HttpServletResponse response,String specName){
        Spec spec = new Spec();
        spec.setSpecName(specName);
        productService.addNewSpec(spec);
        FastJson_All.toJson(spec,response);

    }
    @RequestMapping("/addUnit")
    public void addUnit(HttpServletResponse response,String unitName){

        Unit unit  = new Unit();
        unit.setUnitName(unitName);
        productService.addNewUnit(unit);
        FastJson_All.toJson(unit,response);

    }
    @RequestMapping("/addPriceNameAndStock")
    public void addPrice(HttpServletResponse response,Integer[]priceId,double[]priceName,String[]stockName,Integer[]stockNum){
        for (int i = 0;i <priceId.length;i++){
            Price price = new Price();
            price.setPriceId(priceId[i]);
            price.setPriceName(priceName[i]);
            priceService.addPriceName(price);
            Stock stock = new Stock();
            stock.setStockId(priceId[i]);
            stock.setStockNum(stockNum[i]);
            stock.setStockName(stockName[i]);
            stockService.addStockByPriceId(stock);
        }
        FastJson_All.toJson("success",response);

    }

    @RequestMapping(value = "/selectProduct")
    public void findTeachers(Integer pId, HttpServletResponse response){
        System.out.println("date1:");
        FastJson_All.toJson(productService.selectProduct(pId),response);
    }
    //    需要商品的id 规格的id 单位的id
    @RequestMapping(value = "/selectPrice")
    public void selectPrice(int pId,int specId,int unitId,HttpServletResponse response){
        Price price = new Price(new Product(pId),new Spec(specId),new Unit(unitId));
        System.out.println(price);
        price = priceService.findPriceLimited(price);
        System.out.println(price);
        FastJson_All.toJson(price,response);
    }

}
