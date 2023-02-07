package j26_쓰레드;

public class ThreadTest {

		public static void main(String[] args) {  //우선순위를 잘못정할경우 교착상태에 빠진다
			
			
			LoopThread loopThread1 = new LoopThread("김상현");
			LoopThread loopThread2 = new LoopThread("김상현1");
			LoopThread loopThread3 = new LoopThread("김상현2");
			LoopThread loopThread4 = new LoopThread("김상현3");
			
			loopThread1.setPriority(6);
			loopThread4.setPriority(7);//우선순위 설정
			
			System.out.println(loopThread1.getPriority());  //thread는 숫자가 클수록 우선순위가 높다
			System.out.println(loopThread2.getPriority());
			System.out.println(loopThread3.getPriority());
			System.out.println(loopThread4.getPriority());
			
			loopThread1.start();  //start 호출 = run 실행
			loopThread2.start();
			loopThread3.start();
			loopThread4.start();
		}
}
