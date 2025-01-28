package boj;

import java.util.Scanner;

public class Boj_13300_방배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int total = sc.nextInt();
		int perRoom = sc.nextInt();
		
		int[][] studentInfo = new int[6][2];
		// {1학년 여,1학년 남}, {2학년 여,2학년 남}...{6학년 여,6학년 남}
		for(int i=0; i<total; i++) {
			int sex = sc.nextInt();
			int grade = sc.nextInt();
			
			studentInfo[grade-1][sex]++;
		}
		
		// 각 학년 성별마다 (학생수 / 방 최대인원) + 학생수를 방 최대인원으로 나눈 나머지가 있는 경우 + 1 
		int roomCnt = 0;
		for(int i=0; i<studentInfo.length; i++) {
			for(int j=0; j<studentInfo[i].length; j++) {
				int tmp = studentInfo[i][j];
				roomCnt += tmp/perRoom;
				if(tmp%perRoom != 0) {
					roomCnt++;
				}
			}
		}
		System.out.println(roomCnt);
	}
}
