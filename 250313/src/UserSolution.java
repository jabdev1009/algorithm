import java.util.Stack;

class UserSolution {
	
	static Stack<Character> front;
	static Stack<Character> back;
	
	static int[] fCnt;
	static int[] bCnt;
	
	static int cursor;
	static int w;
	
	static int target;
	static int fSize;
	static int bSize;
	void init(int H, int W, char mStr[]) {
		w = W;
		front = new Stack<Character>();
		back = new Stack<Character>();
		fCnt = new int[26];
		bCnt = new int[26];
		
		for(int i=0; i<H*W; i++) {
			if(mStr[i] != '\0') {
				front.add(mStr[i]);
				bCnt[mStr[i]-'a']++;
			} else {
				break;
			}
		}
		while(!front.isEmpty()) {
			back.add(front.pop());
		}
		System.out.println(front);
		System.out.println(back);
		cursor = 0;
	}
	
	void insert(char mChar) {
		front.add(mChar);
		fCnt[mChar-'a']++;
		cursor++;
	}

	char moveCursor(int mRow, int mCol) {
		fSize = front.size();
		bSize = back.size();
		target = (mRow-1)*w + mCol;
		
		if(target > fSize + bSize) {
			while(!back.isEmpty()) {
				char tmp = back.pop();
				bCnt[tmp-'a']--;
				fCnt[tmp-'a']++;
				front.add(tmp);
			}
			cursor = target;
			return '$';
		} else if(target == fSize + bSize) {
			while() {
				
			}
		} else {
			if(fSize > target) {
				while(front.size()>target-1) {
					char tmp = front.pop();
					bCnt[tmp-'a']++;
					fCnt[tmp-'a']--;
					back.add(tmp);
				}
			} else if(fSize < target) {
				while(front.size()>target-1) {
					char tmp = back.pop();
					bCnt[tmp-'a']--;
					fCnt[tmp-'a']++;
					front.add(tmp);
				}
			}
			cursor = target-1;
			return back.peek();
		}
	}

	int countCharacter(char mChar) {
		return bCnt[mChar-'a'];
	}
}