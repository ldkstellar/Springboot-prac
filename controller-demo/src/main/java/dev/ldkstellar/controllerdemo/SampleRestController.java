package dev.ldkstellar.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController// Controller + Responsebody
@RequestMapping("/rest")
public class SampleRestController {

    private static  final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @PostMapping(value = "/Sample-multipart",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT) //오류 처리를 포함한 다양한 시나리오에서 HTTP 응답 코드를 설정 하는 방법
    public void sampleMultipartPost(
            @RequestParam("name") String name, //요청받는 prameter명의 값 그리고 사용할 변수명
            @RequestParam("age") Integer age,
            @RequestParam("occupation") String occupation,
            @RequestParam("file")MultipartFile multipartFile
    )
    {
        logger.info("name " + name);
        logger.info("age " + age);
        logger.info("occupation "+ occupation);
        logger.info("file " + multipartFile.getOriginalFilename());
    }

    @PostMapping("/Sample-payload")// POST 요청
    //@ResponseStatus(HttpStatus.NO_CONTENT)// 200 요청이 나타낸다.
    public void SamplePayloadPost(@RequestBody SamplePayload samplePayload){// Spring이 알아서 요청body를 메소드의 파라미터에 맞게 변환 시켜준다.
        logger.info(samplePayload.toString());
    }
    @GetMapping("/Sample-payload")
    public  SamplePayload SamplePayloadGet(){
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
