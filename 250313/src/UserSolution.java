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
			while(back.size() != 1) {
				char tmp = back.pop();
				bCnt[tmp-'a']--;
				fCnt[tmp-'a']++;
				front.add(tmp);
			}
			cursor = target-1;
			return back.peek();
		} else {
			if(fSize >= target) {
				while(front.size()>target-1) {
					char tmp = front.pop();
					bCnt[tmp-'a']++;
					fCnt[tmp-'a']--;
					back.add(tmp);
				}
			} else {
				while(front.size()<target-1) {
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

/*
import java.util.ArrayList;
import java.util.List;

class UserSolution {
	
	static List<Character> memo;
	static int len;
	static int cursor;
	static int h;
	static int w;
	static int count;
	void init(int H, int W, char mStr[]) {
		h = H;
		w = W;
		memo = new ArrayList<>(H*W);
		len = mStr.length;
		for(int i=0; i<len; i++) {
			if(mStr[i] != '\0') {
				memo.add(mStr[i]);
			} else {
				len = i;
				break;
			}
		}
		cursor = 0;
	}
	
	void insert(char mChar) {
		memo.add(cursor++, mChar);
		len++;
	}

	char moveCursor(int mRow, int mCol) {
		int target = ((mRow-1) * w) + mCol;
		if(len >= target) {
			cursor = target-1;
			return memo.get(cursor);
		} else {
			cursor = len;
			return '$';
		}
	}

	int countCharacter(char mChar) {
		count = 0;
		for(int i=cursor; i<len; i++) {
			if(memo.get(i) == mChar) {
				count++;
			}
		}
		return count;
	}
}
*/