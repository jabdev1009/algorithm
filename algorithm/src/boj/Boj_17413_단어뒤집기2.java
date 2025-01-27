import java.util.Scanner;
import java.util.Stack;

public class Boj_17413_단어뒤집기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		Stack<Character> chars = new Stack<Character>();
		boolean inTag = false;
		
		// 태그가 열리고 닫히는 구역에서는 그냥 출력
		// 태그 내부가 아니라면 stack에 담아두고 다음 글자로
		// 띄어쓰기, 태그가 열릴 때 stack에 담긴 것이 있다면 stack이 빌 때까지 pop
		// 입력 받은 문자열 전체 순회 후에 stack에 남아있는 것이 있으면 stack이 빌 때까지 pop
		for(int i=0; i<str.length(); i++) {
			char tmp = str.charAt(i);
			if(tmp == '<') {
				inTag = true;
			} else if(tmp == '>') {
				inTag = false;
				System.out.print(tmp);
				continue;
			}
			
			if(inTag) {
				if(chars.size() > 0) {
					while(!chars.isEmpty()) {
						System.out.print(chars.pop());
					}
				}
				System.out.print(tmp);
			} else {
				if(Character.isSpaceChar(tmp)) {
					while(!chars.isEmpty()) {
						System.out.print(chars.pop());
					}
					System.out.print(tmp);
				} else {
					chars.push(tmp);
				}
			}
		}
		while(!chars.isEmpty()) {
			System.out.print(chars.pop());
		}
	}
}
