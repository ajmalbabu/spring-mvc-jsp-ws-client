package org.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FetchController {

    @Autowired
    private FetchService fetchService;

    @RequestMapping("/fetch")
    public ModelAndView fetch(@RequestParam("count") int count, @RequestParam("starttime") long startTime) {

        // TODO Use Google Guava to calculate time taken

        System.out.println("Inside fetch and start time is: " + startTime);

        long backEndStartTime = System.currentTimeMillis();
        System.out.println("Back-end, start time: " + backEndStartTime);


        Map<String, Object> model = new HashMap<String, Object>();
        model.put("result", fetchService.fetchCountry("Spain", count));
        model.put("starttime", startTime);
        model.put("count", count);

        long backEndCallEndtime = System.currentTimeMillis();
        System.out.println("Back-end, end time: " + backEndCallEndtime);

        long diff = (long)(backEndCallEndtime - backEndStartTime);

        System.out.println("Diff: " + diff);

        double backendTime = (double)(diff / (double) 1000);

        System.out.println("Back-end, time is : " + backendTime);

        model.put("backEndTime", backendTime);

        return new ModelAndView("fetchresult", "model", model);

    }

    @RequestMapping("/main")
    public ModelAndView goMain() {

        System.out.println("Inside go main.....");
        return new ModelAndView("main");
    }


}
