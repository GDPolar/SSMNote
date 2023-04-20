package com.xd.pl.controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    // SpringMVC 在 request 域共享数据的几种方式在本质上都是使用 ModelAndView
    // 本质是执行 DispatcherServlet 类的 doDispatch() 方法中的 mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
    // public class BindingAwareModelMap extends ExtendedModelMap {...}
    // public class ExtendedModelMap extends ModelMap implements Model {...}
    // ModelAndView 有俩成员变量： private Object view; private ModelMap model;

    @RequestMapping("/mavtest/mav")
    // 返回值不是 String
    public ModelAndView testMAV() {
        ModelAndView mav = new ModelAndView();
        // 向共享域中添加数据
        mav.addObject("attribute1", "你好");
        // 设置跳转视图
        mav.setViewName("hello");
        return mav;
    }

    @RequestMapping("/mavtest/model")
    // 传入 Model 向共享域中添加数据
    public String testModel(Model model) {
        model.addAttribute("attributeFromModel", "哈哈");
        return "hello";
    }

    @RequestMapping("/mavtest/modelMap")
    // 传入 ModelMap 向共享域中添加数据
    public String testModel(ModelMap modelMap) {
        modelMap.addAttribute("attributeFromModelMap", "ModelMap");
        return "hello";
    }

    @RequestMapping("/mavtest/map")
    // 传入 ModelMap 向共享域中添加数据
    public String testModel(Map<String, Object> map) {
        map.put("attributeFromMap", "map");
        return "hello";
    }

    // session 域和 application 域名
    @RequestMapping("/mavtest/sa")
    // 传入 ModelMap 向共享域中添加数据
    public String testSessionAndApplication(HttpSession httpSession) {
        httpSession.setAttribute("he", "h");
        httpSession.getServletContext().setAttribute("1", "a");
        return "hello";
    }
}
