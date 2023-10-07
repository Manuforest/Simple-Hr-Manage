package com.dhu.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author cwq
 * @since 2023-09-26
 */
@TableName("x_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String itemname;

    private Integer price;

    private String type;

    private Integer number;

    private String itemdesc;
    public void setId(Integer id){this.id = id;}
    public Integer getId() { return id;}

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }

    @Override
    public String toString() {
        return "Item{" +
            "itemname = " + itemname +
            ", price = " + price +
            ", type = " + type +
            ", number = " + number +
            ", itemdesc = " + itemdesc +
        "}";
    }


    @TableField(exist = false)
    private Integer postId;
    public Integer getPostId() { return postId;
    }
}
