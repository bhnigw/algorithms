package Medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		int startIndex = 0;

		helper(nums, startIndex, subset, res);

		return res;
	}

	private void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> res) {
		res.add(new ArrayList<>(subset));

		// if (startIndex >= nums.length) return;

		for (int i = startIndex; i < nums.length; i++) {
			subset.add(nums[i]);
			helper(nums, i + 1, subset, res);
			subset.remove(subset.size() - 1);
		}
	}

	public static void main(String[] args) {
		Subsets generateAll = new Subsets();
		System.out.println(generateAll.subsets(new int[] { 1, 2, 3, 4 }));

	}

}
