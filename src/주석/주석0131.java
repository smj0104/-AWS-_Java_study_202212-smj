package 주석;

public class 주석0131 {
/*	람다
 *  람다를 쓸때는 앞의 대상이 있어야한다
 *  람다를 쓸수있는 메소드는 추상메소드뿐 (람다를 사용하기위한 조건)
 *  추상 메소드를 하나만 가지고있는 인터페이스를 람다로 사용할 수 있다.(중요)
 *  
 *  interface Calculator {
    int sum(int a, int b);
}

public class Sample {
    public static void main(String[] args) {
        Calculator mc = (int a, int b) -> a +b;
        int result = mc.sum(3, 4);
        System.out.println(result);
    }
}

괄호 사이의 int a, int b는 Calculator 인터페이스의 sum 함수의 입력항목에 해당하고 -> 뒤의 a+b 가 리턴값에 해당한다.
 이렇게 람다함수를 사용하면 MyCalculator와 같은 실제 클래스 없이도 Calculator 객체를 생성할 수 있다.
 *  
 *  람다정리: https://bangu4.tistory.com/215
 *  
 *  map은 entry로 바꿔야 forEach문 사용가능
 *  Binary = 이진
 *  forEach는 break가 안걸린다
 *  
 *  Python?
 *  주소에get붙여서 엔터
 *  홈디렉터리 
 *  내가 로그인을 했을때 처음 보이는 디렉터리 (C - 사용자 - ITPS)
 *  new에 python3 클릭  
 *  코드셀에 코드를 입력
 *  print(type(a)) 데이터 타입 확인
 *  코드셀이 넘어가도 변수값은 사라지지않음
 *  List 타입 : 값을 집어넣는 통 데이터 타입이 제각각이어도 괜찮음 []로 출력됨
 *  Tuple 타입 : 안에 넣은 값을 수정할 수 없음  ()로 출력됨
 *  Set 타입 : 중복된 값을 출력되지않음 				{}로 출력됨
 *  Dictionary 타입 : Key Value 형태로 이루어진 데이터 형태 {}와 안에 ''dl 이 들어간 형태로 출력됨
 *  
 *  조건문 : a = 5
if a>5:
    print('greater than 10')
elif a == 5:
    print('is five.')
else:
    print('not greater than 10')   elif는 여러개 사용가능
 *  
 *  
 *  반복문 : for _ in range(4):  _사용으로 변수없이 순환가능
    print(i)
 *  
 *  a = range(0,4)  #start, stop 0에서 시작 4에서 stop
 *  
 *  
 *  #100에서 500미만 5의 배수 출력.
na = range(100,500,5)  #start, stop, step			step: 정해놓은 숫자만큼 올라감
print(na)
print(type(na))

for i in na:
    print(i)
      
      concatenation 이어붙이다
      help(list)로 도움말 불러오기
 *	  clear(self, /)사용시 괄호 안 비우기  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  javac 자바언어를 해석해서 작업을 한다
 */
}
