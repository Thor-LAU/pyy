//package com.pyyexclusivenew.pyy.control;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//public class Test {
//    @Autowired
//    RedisTemplate redisTemplate;
//
//    @GetMapping("/login")
//    public ModelAndView login(@RequestParam("openid") String openid,   //ModelAndView
//                              HttpServletResponse httpServletResponse,
//                              Map<String,Object> map, HttpSession session){
//        // 数据库匹配
//        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenId(openid);  //通过关键字 查询用户
//        if (sellerInfo == null){   // 判断用户是否存在
//            map.put("msg",ResultEnum.LOGIN_FAIL.getMessage());
//            map.put("url","你的页面地址");
//            return new ModelAndView("/common/error");
//        }
////        String token = UUID.randomUUID().toString();
//        String token = session.getId();   //获取登录 token
//        Integer expire = Redisconstant.EXPIRE;  //设置时间
//        //设置 token 至 redis
//        redisTemplate.opsForValue().set(
//                //String TOKEN_PREFIX = "token_%s";
//                String.format(Redisconstant.TOKEN_PREFIX,token) // key
//                ,openid  //关键字  value
//                ,expire,  // 时间
//                TimeUnit.SECONDS);  //格式
//
//        //设置 token 至 cookie
//        CookieUtil.writeLoginToken(httpServletResponse,token);
//        return new ModelAndView("你的页面地址 如 http://login");
//    }
//}
