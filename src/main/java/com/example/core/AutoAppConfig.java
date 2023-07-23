package com.example.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//@Configuration안에 @Component가 있음
@Configuration
//@Component 애노테이션이 붙은 클래스를 찾아 자동으로 스프링 빈으로 등록해줌
@ComponentScan(
        //AppConfig.class 파일을 제외하고 스프링 빈으로 등록
        //똑같은 빈이 생성되어 스프링 빈 충돌이 일어날수도
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
        //basePackages = "com.example.core.member" 패키지 하나 스캔
        basePackages = { "com.example.core.member", "com.example.core.discount" },
        basePackageClasses = AutoAppConfig.class
)
public class AutoAppConfig {
}
