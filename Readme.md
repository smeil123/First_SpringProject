<html>
<head>
<style>
p{text-index:30px;}
div{border:1px solid blue; text-index:10%;}
</style>
</head>
<body>
<h1> 최종 완성물 목표 </h1>
1. 게시글을 스크롤로 보여주기(인스타, 블라인드 처럼) <br>
2. 게시글에 댓글, 좋아요, 조회수 등 <br>
3. 로그인 기능 구현 <br>
4. + 만들면서 추가하기 <br>
    
<h1> 개발 일지 </h1>
- ~ 7/8 : 게시글 작성, 조회수 틀 만들어둠 <br>
- 7/8 : <a href="https://github.com/smeil123/Spring_Study/blob/master/Spring/%EB%A1%9C%EA%B9%85%EC%84%A4%EC%A0%95.md">로그를 볼 수 있는 환경 만들기</a> <br>
- 7/18 : <a href="https://github.com/smeil123/Spring_Study/blob/master/Spring/Mysql%20%EC%97%B0%EB%8F%99.md">mysql db연동 설정</a><br>
<p>
처음 spring boot 프로젝트를 시작했을땐 별도의 설치가 필요하지 않은 h2 DB를 사용했었는데, 인메모리형 RDB라서 <br>
프로젝트를 재시작할 때마다 다시 데이터를 넣어주고 테스트하는 과정이 필요했다. <br>
이 과정이 너무 번거롭게 느껴지기도 했고, db서버를 따로 두어 실제처럼 개발하는 구성을 만들어 연습해보기 위해 mysql연동으로 바꾼것이다.
</p>
- 7/18 : 스크롤로 게시글 보기


<h2> 오류해결 </h2>
1. 생성한 클래스 임포트가 안됨<br>
<p>아무리봐도 코드상 문제가 없었고, 인텔리제이 오류였다.
인텔리제이 캐시를 삭제하고 재시작하니까 됐음
* 해결방법
File > Invalidate Cache ~ 클릭 > 재시작
</p>
</body>
</html>