package dev.ldkstellar.controllerdemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController// Controller + Responsebody
@RequestMapping("/rest")
public class SampleRestController {
    private static  final Logger logger = LoggerFactory.getLogger(SampleController.class);
    @GetMapping("/Sample-payload")
    public  SamplePayload SamplePayload(){
        logger.info("SamplePayload complete!");
        return  new SamplePayload("ldkstellar",26,"Developer");
    }
     @GetMapping(value = "/sample-image",// HTML 외에 데이터 전송을 위해 Body와 Media Type을 설정할 수 있다.
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public byte[] SampleImage() throws IOException{
        InputStream inputStream =getClass().getResourceAsStream("/static/k.PNG");

        return  inputStream.readAllBytes();
    }


}
