package dev.ldkstellar.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //요청 경로를 설정하기 위해 Controller Annotation을 사용한다
public class SampleController {
    private static  final Logger logger = LoggerFactory.getLogger(SampleController.class);
    @RequestMapping("/profile")//RequestMapping을 이용해 경로에 따라 실행될 함수를 지정 할 수 있다.
    public String profile(){
        logger.info("in profile");
        return "/hello.html";
    }

    @RequestMapping(value = "/hello"// 경로의 값 Request Mapping을 이용해 경로에 따라 실행될 함수를 지정 할 수 있다.
    ,method = RequestMethod.GET
    )
    public String hello(@RequestParam(name = "id",required = false,defaultValue = "")String name){
        logger.info("Path : hello");
        logger.info("Query Param id:" + name);
        return "/hello.html";
    }
    @GetMapping(value = "/hello/{id}")//
    public String helloPath(@PathVariable("id") String id){
        logger.info("Path Variable is " + id);
        return "/hello.html";
    }
    @GetMapping(
            "/get-profile"
    )
    public @ResponseBody SamplePayload getProfile(){// HTML 외에 데이터 전송을 위해 Body와 Media Type을 설정할 수 있다.
        return  new SamplePayload("ldkstellar",26,"Developer");
    }

}
