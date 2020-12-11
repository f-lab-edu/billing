package com.pay.billing.common.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)                              // Swagger 설정의 핵심이 되는 Bean, API 자체에 대한 스펙은 컨트롤러에서 작성
                .select()                                                           // ApiSelectorBuilder를 생성
                .apis(RequestHandlerSelectors.any())                                // GetMapping, PostMapping ... 이 선언된 API를 문서화
                .paths(Predicates.not(PathSelectors.regex("/error")))      // apis()로 선택되어진 API중 특정 path 조건에 맞는 API들을 다시 필터링하여 문서화
                .build()
                .apiInfo(swaggerInfo())                                             // 제목, 설명 등 문서에 대한 정보들을 보여주기 위해 호출
                .useDefaultResponseMessages(false)                                  // false로 설정하면, swagger에서 제공해주는 응답코드 ( 200,401,403,404 )에 대한 기본 메시지를 제거
                .securitySchemes(Collections.singletonList(apiKey()))               // securitySchemesAPI가 지원하는 모든 보안 체계를 정의 하는 데 사용 security하고 전체 API 또는 개별 작업에 특정 체계를 적용
                .securityContexts(Collections.singletonList(securityContext()))     // SecurityScheme 및 SecurityContext 지원을 사용하여 보안 API에 액세스하도록 Swagger를 구성
                .tags(new Tag("users", "Operations about users"))    // 여러 개의 태그를 정의할 수도 있습니다.
                .genericModelSubstitutes(Optional.class);                           // 각 제네릭 클래스를 직접 매개 변수화 된 유형으로 대체합니다.
    }

    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder().title("빌링 시스템 개발")
                .description("카드결제 / 결제취소 / 결제정보 조회 REST API 개발 문서입니다").build();
    }

    // 보안 체계(Authorization)를 jwt를 header에 삽입하여 사용
    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }

    // 보안 컨텍스트를 API에 적용
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    // 인증 범위 및 참조 이름 설정
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
    }
}