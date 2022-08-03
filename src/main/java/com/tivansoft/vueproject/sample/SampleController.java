package com.tivansoft.vueproject.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SampleController {
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView sample() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "tivansoft!!!");
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> data(@RequestParam(name="msg") String msg) {
        logger.debug("Message : {}", msg);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "Server message with " + msg);
        return map;
    }
}