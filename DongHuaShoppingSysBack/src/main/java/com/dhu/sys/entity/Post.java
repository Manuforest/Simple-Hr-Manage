package com.dhu.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author cwq
 * @since 2023-09-26
 */
@TableName("x_post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer postId;

    private Integer number;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @Override
    public String toString() {
        return "Post{" +
            "postId = " + postId +
            "id = " + id +
            ", number = " + number +
        "}";
    }
}
