package com.atguigu.gulimall.order.web;

import com.atguigu.common.exception.NoStockException;
import com.atguigu.gulimall.order.service.OrderService;
import com.atguigu.gulimall.order.vo.OrderConfirmVo;
import com.atguigu.gulimall.order.vo.OrderSubmitVo;
import com.atguigu.gulimall.order.vo.SubmitOrderResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderWebController {
    @Autowired
    OrderService orderService;
    @GetMapping("/toTrade")
    public String toTrade(Model model){
       OrderConfirmVo confirmVo = orderService.confirmOrder();
        model.addAttribute("orderConfirmData",confirmVo);
        return "confirm";
    }

    @PostMapping("/submitOrder")
    public String submitOrder(OrderSubmitVo vo, Model model, RedirectAttributes redirectAttributes){
        try {
            SubmitOrderResponseVo responseVo= orderService.submitOrder(vo);
            if(responseVo.getCode()==0){
                //成功跳转到支付业
                model.addAttribute("submitOrderResp",responseVo);
                return "pay";
            }else {
                String msg = "下单失败";
                switch (responseVo.getCode()) {
                    case 1:  msg+="订单信息过期，请刷新再次提交"; break;
                    case 2:  msg+="订单商品价格发生变化，请确认后再次提交" ;break;
                    case 3:  msg+="库存锁定失败，商品库存不足" ;break;
                }
                redirectAttributes.addFlashAttribute("msg",msg);
                return "redirect:http://order.gulimall.com/toTrade";
            }
        }catch (NoStockException e){
            String message = e.getMessage();
            redirectAttributes.addFlashAttribute("msg",message);
            return "redirect:http://order.gulimall.com/toTrade";
        }

    }
}
