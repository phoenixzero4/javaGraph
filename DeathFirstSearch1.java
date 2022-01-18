import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DeathFirstSearch1 {

	public static List<Integer> bfs(int bob, List<Integer> nodelist, List<List<Integer>> edges, int target) {
		List<Integer> order = new ArrayList<>();
		int[] parent = new int[nodelist.size()];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
		LinkedList<Integer> queue = new LinkedList<>();
		boolean[] isVisited = new boolean[nodelist.size()];
		queue.offer(bob);
		isVisited[bob] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			order.add(u);
			for (Integer e : edges.get(u)) {
				if (e == target) {
					return order;
				}
				if (!isVisited[e]) {
					queue.offer(e);
					parent[e] = u;
					isVisited[e] = true;
				}
			}
		}
		return order;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int nodes = in.nextInt();
		int links = in.nextInt();
		int exits = in.nextInt();

		ArrayList<Integer> nodelist = new ArrayList<>();
		ArrayList<Integer> exitlist = new ArrayList<>();
		List<List<Integer>> linkarray = new ArrayList<>();

		for (int i = 0; i < nodes; i++) {
			nodelist.add(i);
			List<Integer> list = new ArrayList<>();
			linkarray.add(list);
		}

		for (int i = 0; i < links; i++) {
			int n1 = in.nextInt();
			int n2 = in.nextInt();
			List<Integer> l = linkarray.get(n1);
			l.add(n2);
			l = linkarray.get(n2);
			l.add(n1);
		}
		for (int i = 0; i < exits; i++) {
			int ei = in.nextInt();
			exitlist.add(ei);
		}

		int x = 0;
		int y = 0;

		while (true) {
			List<Integer> searchOrder = new ArrayList<>();
			int bob = in.nextInt();
			int closest = Integer.MAX_VALUE;
			for (int j = 0; j < exitlist.size(); j++) {
				int target = exitlist.get(j);
				searchOrder = bfs(bob, nodelist, linkarray, target);
				if (searchOrder.size() < closest) {
					closest = searchOrder.size();
					if (searchOrder.size() > 1) {
						y = searchOrder.get(searchOrder.size() - 1);
						x = target;
					} else {
						x = target;
						y = bob;
					}
				}
			}
			System.out.println(x + " " + y);
		}
	}
}
