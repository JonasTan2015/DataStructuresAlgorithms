/**
 * Created by 310288079 on 7/9/2017.
 */
public class WiggleSortII {
    public static void main(String[] args){
        WiggleSortII wiggleSortII = new WiggleSortII();
        wiggleSortII.wiggleSort(new int[]{1, 5, 1, 1, 6, 4, 1});
    }

    public int[] wiggleSort(int[] nums) {
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i ++){
            temp[i] = nums[i];
        }

        partition(temp, 0, temp.length - 1, temp.length / 2);
        for(int num: temp){
            System.out.print(num + ", ");
        }

        int[] ans = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for(int i = 0; i < nums.length; i ++){
            if(i % 2 == 0){
                ans[i] = temp[left];
                left ++;
            }else{
                ans[i] = temp[right];
                right --;
            }
        }

        return ans;
    }


    private void partition(int[] nums, int start, int end, int k){
        if(start == end)
            return;
        for(int num : nums){
            System.out.print(num + ", ");
        }
        System.out.println();
        System.out.println("start: " + start + ", end:" + end + ", K:" + k);
        int pivot = nums[start];
        int left = start;
        int right = start + 1;
        while(right <= end){
            if(nums[right] < pivot){
                swap(nums, left + 1, right);
                left ++;
            }
            right ++;
        }
        swap(nums, start, left);
        if(left - start + 1 == k)
            return;
        else if(left - start + 1 < k){
            partition(nums, left + 1, end, k - (left - start + 1));
        }else{
            partition(nums, start, left, k);
        }
    }

    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
