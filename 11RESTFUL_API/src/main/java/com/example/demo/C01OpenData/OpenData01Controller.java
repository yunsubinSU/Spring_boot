package com.example.demo.C01OpenData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/openData")
public class OpenData01Controller {
    //대구광역시_돌발 교통정보 조회 서비스(신)
    String url = "https://apis.data.go.kr/6270000/service/rest/dgincident";
    String serviceKey = "xYZ80mMcU8S57mCCY/q8sRsk7o7G8NtnfnK7mVEuVxdtozrl0skuhvNf34epviHrru/jiRQ41FokE9H4lK0Hhg==";
    String pageNo = "1";
    String numOfRows = "10";

    @GetMapping("/unexpected")
    public void unexpected(Model model){
        //01 서버요청정보 확인(URL /KEY / etc Parameter)
        url+="?serviceKey=" + serviceKey;
        url+="&pageNo=" + pageNo;
        url+="&numOfRows="+numOfRows;

        //02 요청 헤더 설정(x)

        //03 요청 바디 설정(x)

        //04 요청 작업 이후 결과 확인
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Root> response =
                restTemplate.exchange(url, HttpMethod.GET,null,Root.class);
        System.out.println(response);
        //05 기타 가공처리
//        if(response.get)

        //뷰 전달
        Root root =  response.getBody();
        Body body =  root.getBody();
        Items items = body.getItems();
        List<Item> list = items.getItem();
        list.stream().forEach(System.out::println);

        model.addAttribute("list" , list);

    }

    //-----------------------------------
    //밑에는 response.getBody() 해주시면 뜨는 코드를 복사 해서 json to java라는 곳에 들어가서 코드를 바꿔주는 것 아래에 붙여주면 된다.
    //@Data 를 추가 해주고 private static class로 변경해주면 된다.
    @Data
    private static class Body{
        public Items items;
        public String numOfRows;
        public String pageNo;
        public String totalCount;
    }
    @Data
    private static class Header{
        public String resultCode;
        public String resultMsg;
    }
    @Data
    private static class Item{
        @JsonProperty( value ="LOCATION" ,required = false)
        public String LOCATION;
        @JsonProperty(value ="INCIDENTTITLE")
        public String INCIDENTTITLE;
        @JsonProperty(value ="LOGDATE")
        public String LOGDATE;
        @JsonProperty(value ="TROUBLEGRADE")
        public String TROUBLEGRADE;
        @JsonProperty(value ="STARTDATE")
        public String STARTDATE;
        @JsonProperty(value ="INCIDENTSUBCODE")
        public String INCIDENTSUBCODE;
        @JsonProperty(value ="LINKID")
        public String LINKID;
        @JsonProperty(value ="REPORTDATE")
        public String REPORTDATE;
        @JsonProperty(value ="ENDDATE")
        public String ENDDATE;
        @JsonProperty(value ="COORDX")
        public double COORDX;
        @JsonProperty(value ="INCIDENTCODE")
        public String INCIDENTCODE;
        @JsonProperty(value ="INCIDENTID")
        public String INCIDENTID;
        @JsonProperty(value ="COORDY")
        public double COORDY;
        @JsonProperty("TRAFFICGRADE")
        public String TRAFFICGRADE;
    }
    @Data
    private static class Items{
        public ArrayList<Item> item;
    }
    @Data
    private static class Root{
        public Body body;
        public Header header;
    }
    //-----------------------------------

}
