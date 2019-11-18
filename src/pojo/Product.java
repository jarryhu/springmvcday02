package pojo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Product {

    private Integer id;
    private String name;
    private Float price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creatTime;
    private String detail;


    public Product(Integer id, String name, Float price, Date creatTime, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.creatTime = creatTime;
        this.detail = detail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", creatTime=" + creatTime +
                ", detail='" + detail + '\'' +
                '}';
    }
}
