package com.atguigu.gulimall.order.config;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.atguigu.gulimall.order.vo.PayVo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "alipay")
@Component
@Data
public class AlipayTemplate {

    //在支付宝创建的应用的id
    private   String app_id = "9021000139679986";

    // 商户私钥，您的PKCS8格式RSA2私钥
    private  String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCu3j234V2GwHoUY/zjqbt6uFT94IHRnCJ8TLnWN9m1O362/BIutCODMkmhPCRLevLVbAQMT2jasr+uPDpZEDC1HgizTYjeYqkMVTALw2JghEAm5SfRrLGmxa0h1rI2F9kKcJpq4IZhqH0ENrOX/JxU+J8ZV8PZ257mQwUeFB6zKXU0LvTMLXjJd8LA0nFecgJhtFofyheN04d2NzFpf4r1U3cC6DgPdEqfTGK5dHZD+kiYOW/lXSsYLFKh84DTEEnvXpppWUlNBvNgP3M4aTECJsFN75KqLV8PY8jHtCqrEriBgbDiuyCZSlp3qAx7oXlQmmey3K3hVAhYbfyJ6OdAgMBAAECggEAcLs6jx+mFXcqiOu0RyDu32BYV7Cppp5eMwUTkR0435KjeFup8v1tE+EAn7+pNnezyc4lGYFslntjeo196LQziA3xXok4sxR+siF75JFuifHnuW9vlH1BcjOQO7IwXdr/Pv8njzl+4YYQJ8dU9vsTtBfSyNQdSco2IkySdyBcvdZ5Zis7aCaNdUIBcOL+kTO/tdzB+swNh9V1i7wU8NYCjN7lhir9KwamqKL3dtVHN860aMbGUiCvXD46ZFyvFEjK4/t742sC5nbZLzX6i1L481QmMnRm1EU2aikJ0sd3V9djkVYRXltALVTxUxkVH767BKrIt2eU0nKMDZajb+lqwQKBgQC6SuXJTN7CynjUw+Gz80r3HAHTriZPyXpS/yIM8RAJcYOnCRs1LQYQlb1EDMI9I3dnsMcY/0kIfLL2ahwhicI6hzpE8nExevyTNGhiIhC+i3XxKkVjF4xTAP5YYRBqMd0PeIP+xoSq76yT3wkuZsYbbnMHqcKl7ah//JqU9TKUkQKBgQCzpmrPpaK+IPavQijuRFzmRkyr1CriRDpQN+ggSpqyckcFzFiEWhVJE1zs9F8RViC167s+bPq+6FtSuMdhU+/RMo5KJlYGfqv9mxtPHCuxA/0v3bK8km8cmdzYtVuH5sLeOBeyaoKT424mXlo/W61LHXw6v/ANSkMD3aVQ60u0TQKBgCXxQ0PwqB48ZsfO7ZVdJBOYXLbkbWEqxANLe3/vSTjjKdFHhYcbGHUgSmAlyRnys0snMiXhONrFqx2NFxWtnSWWjUOlrXBKgE7rCaeTEJ3+gZMQ7Pj1vtrZBPSzMEiwxzlzbk7h1/uIvTmQ36nXvNmxcTRKWx64fO00YbedCSRBAoGBAJVJ3QbzcRsoj3aytwrRepXNo5dC9+QRqJfS7a4v8QALYSPbXU+XAIs6cQVkScBBX2tuGqrUq0aMFp/Wd7FUrDyfE4lg9CnviAN2qqoCEfjHBNaLGCYGVhlhbxoTE54K0LMTz/Vu91XoMDfoPnzaNVbviLXVnKmepbQHs4JcFgwdAoGAdPnSs/F1uPXob6GOfjYsbbyObRBWXSV/SLt4iwG/jvgB1pQw34K/+yhiF2NT2abdgif0ZvZT4XuaJNLQJHPDkTjkvWUw61WPWpm3os3epDBGDGxMLOZnOju/sMyy9rvpsJJW99BDZ6digw4+pD6IFAqKKvmKHM0fvBtTUBo4HO8=";  // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    private  String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhmtbxRLGe629jtiXKWXP7Qu4pQmW9ueaGj1wO8M59yV4K1WUMQXyMCSqL27Pnpx6o//5NZ37orIvhZ245NXJxs8ajzE7kAveBLtIZh7JqW/iXeYZp43cIxOYhjnnelHY6hXGx/0mZA+5K+nnFZEtPovkP83T45GyRiKzJE2o4TrF7In2XZl8Gvj5hpSNTEUjoKl7woVmhIRhX4/rSitDMJou1NqamusjD9jPPyn1iWw7RQ9bfas5nGAFhPTjyUwJn6GJL3jubDHWG41o0suOysElNSDPeoMIdt29BkZTo5nqE/RHbR6DWhYZqYUMTfB2Y+r2L5VMU+zZPxIf4aCT1QIDAQAB";
    // 服务器[异步通知]页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 支付宝会悄悄的给我们发送一个请求，告诉我们支付成功的信息
    private  String notify_url = "http://hkc7mgzij.shenzhuo.vip:53521/payed/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //同步通知，支付成功，一般跳转到成功页
    private  String return_url = "http://member.gulimall.com/memberOrder.html";

    // 签名方式
    private  String sign_type = "RSA2";

    // 字符编码格式
    private  String charset = "utf-8";

    private  String timeout = "";

    // 支付宝网关； https://openapi.alipaydev.com/gateway.do
    private  String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";

    public  String pay(PayVo vo) throws AlipayApiException {

        //AlipayClient alipayClient = new DefaultAlipayClient(AlipayTemplate.gatewayUrl, AlipayTemplate.app_id, AlipayTemplate.merchant_private_key, "json", AlipayTemplate.charset, AlipayTemplate.alipay_public_key, AlipayTemplate.sign_type);
        //1、根据支付宝的配置生成一个支付客户端
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl,
                app_id, merchant_private_key, "json",
                charset, alipay_public_key, sign_type);

        //2、创建一个支付请求 //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
       alipayRequest.setNotifyUrl(notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = vo.getOut_trade_no();
        //付款金额，必填
        String total_amount = vo.getTotal_amount();
        //订单名称，必填
        String subject = vo.getSubject();
        //商品描述，可空
        String body = vo.getBody();

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+timeout+"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String result = alipayClient.pageExecute(alipayRequest).getBody();

        //会收到支付宝的响应，响应的是一个页面，只要浏览器显示这个页面，就会自动来到支付宝的收银台页面
        System.out.println("支付宝的响应："+result);

        return result;

    }
}
