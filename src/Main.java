
import java.time.ZonedDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {3, 2, 4};
//        int target = 6;
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                int[] arr = {map.get(nums[i]), i};
//                System.out.println(Arrays.toString(arr));
//            }
//            map.put(target - nums[i], i);
//        }

//        String[] strs = {"flower","flow","floight"};
//        String[] strs1 = {"ab","a"};
//        System.out.println(func(strs));
//        System.out.println(func(strs1));

//        int[] nums = {1,3,5,6};
//        int target = 5;
//        System.out.println(searchInsert(nums, target));
//        int[] nums1 = {1,3,5,6};
//        int target1 = 2;
//        System.out.println(searchInsert(nums1, target1));
//        int[] nums2 = {1,3,5,6};
//        int target2 = 7;
//        System.out.println(searchInsert(nums2, target2));
//        int[] nums8 = {1,3,5,6};
//        int target8 = 0;
//        System.out.println(searchInsert(nums8, target8));
//        int[] nums11 = {1,3};
//        int target11 = 4;
//        System.out.println(searchInsert(nums11, target11));
//        int[] nums58 = {1,3,5};
//        int target58 = 4;
//        System.out.println(searchInsert(nums58, target58)); // 2

//        String s1 = "Hello World";
//        System.out.println(lengthOfLastWord(s1));
//
//        String s2 = "   fly me   to   the moon  ";
//        System.out.println(lengthOfLastWord(s2));
//
//        String s3 = "luffy is still joyboy";
//        System.out.println(lengthOfLastWord(s3));

//        System.out.println(addBinary("11", "1"));
//        System.out.println(addBinary("1010", "1011"));

        Date date = new Date();
        System.out.println(date.getTime());

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime.toInstant().toEpochMilli());
    }

//    public class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }

//    public static String addBinary(String a, String b) {
//        int maxLength = Math.max(a.length(), b.length());
//        int inMemory = 0;
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = maxLength - 1; i >= 0; i--) {
//            char charA = a.charAt(i) != null ? a.charAt(i) : '0';
//            if (a.charAt(i) == b.charAt(i)) {
//                if (a.charAt(i) == 1) {
//                    inMemory = 1;
//                }
//                stringBuilder.append("0");
//            } else {
//                stringBuilder.append("1");
//            }
//        }
//        return stringBuilder.reverse().toString();
//    }

//    public static int lengthOfLastWord(String s) {
//        int count = 0;
//        for (int i = s.length() - 1; i >= 0 ; i--) {
//            if (s.charAt(i) == ' ' && count != 0) return count;
//            if (s.charAt(i) == ' ' && count == 0) continue;
//            count++;
//        }
//        return count;
//    }

//        public static int lengthOfLastWord(String s) {
//            int count = 0;
//            for (int i = s.length() - 1; i >= 0 ; i--) {
//                if (s.charAt(i) != ' ') count++;
//                else if (count > 0) return count;
//            }
//            return count;
//    }

//        public static int lengthOfLastWord(String s) {
//            s = s.trim();
//            int count = 0;
//            for (int i = s.length() - 1; i >= 0 ; i--) {
//                if (s.charAt(i) == ' ') return count;
//                count++;
//            }
//            return count;
//    }

//        public static int lengthOfLastWord(String s) {
//            s = s.trim();
//            int lastIndex = s.lastIndexOf(' ');
//            return s.length() - lastIndex - 1;
//    }

//    public static int lengthOfLastWord(String s) {
//        String[] arr = s.trim().split(" ");
//        return arr[arr.length - 1].length();
//    }

//    public static int searchInsert(int[] nums, int target) {
//        int result = 0;
//        int i;
//        for (i = nums.length / 2; nums.length != 0;) {
//            if (nums[i] == target) {
//                return i;
//            } else {
//                if (nums.length == 1) {
//                    return target > nums[i] ? i + 1 : i;
//                }
//                if (nums[i] > target) {
//                    int[] newNums = new int[nums.length / 2];
//                    System.arraycopy(nums, 0, newNums, 0, nums.length / 2);
//                    result = searchInsert(newNums, target);
//                } else {
//                    int start = nums.length - nums.length / 2;
//                    int[] newNums = new int[nums.length - start];
//                    System.arraycopy(nums, start, newNums, 0,nums.length - start);
//                    result = searchInsert(newNums, target);
//                    result += start;
//                }
//                return result;
//            }
//        }
//        return result;
//    }

//    private static String func(String[] strs) {
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < strs[0].length(); i++) {
//            for (int j = 1; j < strs.length; j++) {
//                if (strs[j].length() <= i || strs[0].charAt(i) != strs[j].charAt(i)) {
//                    return result.toString();
//                }
//            }
//            result = result.append(strs[0].charAt(i));
//        }
//        return result.toString();
//    }
}
