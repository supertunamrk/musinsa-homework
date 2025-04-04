# [MUSINSA] Java(Kotlin) Backend Engineer - 과제 / 지원자 - 강동원

## 사용 기술
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 데이터베이스 (mem)

## 실행 방법
### Intellij
HomeworkApplication 실행 후, http://localhost:8080 으로 확인 가능합니다.
### gradlew
```
// 아래 커맨드 실행 후, http://localhost:8080 으로 확인 가능합니다.
./gradlew bootRun

//빌드는 아래 커맨드 참고 바랍니다.
./gradlew clean build
```
## 테스트 방법
### Intellij
test/java/com/musinsa/homework 내의 클래스 직접 실행으로 테스트 가능합니다. 
### gradlew
```
./gradlew test --tests "com.musinsa.homework.service.BrandServiceTests"
./gradlew test --tests "com.musinsa.homework.service.ProductServiceTests"
```
## 구현 범위
### 공통
- 각 구현문제는 아래 방법으로 확인이 가능합니다.
    ```
  GET   /api/answer1                  //구현 1
  GET   /api/answer2                  //구현 2
  GET   /api/answer3/{categoryTitle}  //구현 3
  
  //구현 4 는 /api/brands 와 /api/products 에서 기능을 제공합니다.
    ```
- response 는 아래 모델을 따릅니다.
    ```
  //성공시
  {
      "header": {"isSuccessful": true, "errorCode": null, "errorMessage": null},
      "body": {/* data */}
  }
  
  //실패시
  {
      "header": {"isSuccessful": false, "errorCode": "code", "errorMessage": "message"},
      "body": {/* data */}
  }
    ```
- 동일조건 (예: 상품의 최저가가 동일) 에 대해서는 ID 값이 더 큰 데이터가 선택되도록 조치했습니다.
  - PDF 3페이지의 결과값 샘플에서 '스티커즈 | A-9000/G-9000' 경우에 G-9000 이 선택된 것을 참고했습니다.
- 주로 백오피스를 통해 브랜드와 상품의 생성, 수정, 삭제 등의 변경이 발생하기에 최초생성자/마지막수정자 의 정보를 저장하도록 했습니다.
- 에러코드는 enum 으로 생성, 관리 합니다.
- UI 는 지원하지 않습니다.

### 카테고리 (Category)
- 카테고리명은 국문, 영문 으로 구성했습니다.
- 커머스 특성상 카테고리의 ON/OFF 를 고려해서 open Y/N 컬럼으로 존재합니다.
  - 초기 데이터는 모두 Y 값을 가집니다.
- 카테고리의 조회, 생성, 수정, 삭제 는 지원하지 않습니다.

### 브랜드 (Brand)
- 브랜드명은 국문, 영문 으로 구성했습니다.
- 초기 데이터는 PDF 2 페이지를 그대로 적용했습니다.
- 브랜드의 조회, 생성, 수정, 삭제 를 지원합니다.
    ```
  GET     /api/brands             //전체 브랜드 조회
  GET     /api/brands/{brandId}   //특정 브랜드 조회
  POST    /api/brands             //브랜드 생성
  PUT     /api/brands/{brandId}   //브랜드 수정
  DELETE  /api/brands/{brandId}   //브랜드 삭제
    ```

### 상품 (Product)
- 상품명은 국문, 영문 으로 구성했습니다.
- 상품가격은 원화, 달러 두가지로 구성했습니다.
- 초기 데이터는 PDF 2 페이지를 그대로 적용했습니다.
- 상품의 조회, 생성, 수정, 삭제 를 지원합니다.
    ```
  GET     /api/products               //전체 상품 조회
  GET     /api/products/{productId}   //특정 상품 조회
  POST    /api/products               //상품 생성
  PUT     /api/products/{productId}   //상품 수정
  DELETE  /api/products/{productId}   //상품 삭제
    ```
  
## 추후 개선 방향 
- 브랜드, 상품의 삭제는 soft delete 로 변경
- 브랜드와 상품의 생성, 수정, 삭제 등의 변경 발생 시, entity 를 JSON String 으로 저장, diff 로 이력 확인 가능
- 카테고리 OPEN Y/N 을 제어하고 이를 반영하는 기능 개발