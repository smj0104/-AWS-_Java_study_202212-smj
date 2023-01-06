package j06_조건;

import java.util.Scanner;

public class Conditional3 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int score = 0;
		String grade = null;
		
		System.out.println("성적 점수 입력: ");
		score = scanner.nextInt();
		
		if(score < 0 || score > 100) {System.out.println("계산불가");
		}else 
		  {if(score > 95) {grade = "A+";}
		 else
		  {if(score > 89) {grade = "A";}
		 else
		  {if(score > 84) {grade = "B+";}
		 else
		  {if(score > 79) {grade = "B";}
		 else
		  {if(score > 74) {grade = "C+";}
		 else
		  {if(score > 69) {grade = "C";}
		 else
		  {if(score > 64) {grade = "D+";}
		 else
		  {if(score > 59) {grade = "D";}
		  else {grade = "F";}
		} 
		  	}
		  		}
		  			}
		  				}
		  					}
		  						}
	
		
		System.out.println("점수(" + score + "): " + grade + "학점");
			}
	}
}





		
		//0보다 작거나 100보단 큰 경우
		// *조건
		//*score가 0점보다 작거나 100점보다 크면 계산불가를 출력 (학점 나오지않게)
		// *score가 90 ~ 100점이면 A학점
		// *score가 80 ~ 89점이면 B학점
		//*score가 70 ~ 79점이면 C학점
		// *score가 60 ~ 69점이면 D학점
		//*score가 0 ~ 59점이면 F학점
		// +학점 추가
		//*/
	


