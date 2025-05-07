package com.example.demo.domain.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@ToString
@Data
@AllArgsConstructor //모든 파라미터를 받는 생성자
@NoArgsConstructor //디폴트 생성자
@Component
@Builder
public class PersonDto {
	private String username;
	private int age;
	private String addr;
	
}

