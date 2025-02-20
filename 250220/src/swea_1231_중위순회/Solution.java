package swea_1231_중위순회;

import java.util.Scanner;

public class Solution {
	
	static class Node {
		String alphabet;
		int left;
		int right;
		
		public Node() {
		}
		public Node(String alphabet, int left, int right) {
			this.alphabet = alphabet;
			this.left = left;
			this.right = right;
		}
		@Override
		public String toString() {
			return "Node [alphabet=" + alphabet + ", left=" + left + ", right=" + right + "]";
		}
	}
	static Node[] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			sc.nextLine();
			tree = new Node[N+1];
			for(int i=1; i<tree.length; i++) {
				tree[i] = new Node();
			}
			
			for(int i=1; i<=N; i++) {
				String[] info = sc.nextLine().split(" ");
				tree[i].alphabet = info[1];
				tree[i].left = info.length>=3 ? Integer.parseInt(info[2]):0;
				tree[i].right = info.length>=4 ? Integer.parseInt(info[3]):0;
			}
			
			System.out.print("#"+tc+" ");
			inorder(1,N);
			System.out.println();
		}
	}
	static void inorder(int i, int n) {
		if(i <= n && i > 0) {
			Node node = tree[i];
			inorder(node.left,n);
			System.out.print(node.alphabet);
			inorder(node.right, n);
		}
	}
}
