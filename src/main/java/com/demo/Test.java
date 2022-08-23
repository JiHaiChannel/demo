package com.demo;

import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @Author:jihai
 * @Date:2022/8/4
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        OrderDO orderDO = new OrderDO();
        orderDO.setTags(Arrays.asList("tag1", "tag2"));
        OrderDTO orderDTO = new OrderDTO();
        // 0 1 2
//        orderDTO.setTags(orderDO.getTags());
        BeanUtils.copyProperties(orderDO, orderDTO);
        System.out.println(orderDTO.getTags());
        System.out.println(orderDTO.getTags().get(0));
        System.out.println(orderDTO.getTags().get(0).equals(1));

    }
}

class OrderDO {
    private List<String> tags;
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
class OrderDTO {
    private List<Integer> tags;
    public List<Integer> getTags() {
        return tags;
    }
    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }
}
