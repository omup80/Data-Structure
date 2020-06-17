package arrays.easy;

public class MoveZeros {

        public void moveZeroes(int[] nums) {

            int nonZeroIndex = 0;

            for(int num: nums){
                if(num==0)
                    continue;
                else{
                    nums[nonZeroIndex++] = num;
                }

            }

            while(nonZeroIndex < nums.length){
                nums[nonZeroIndex++] = 0;
            }





        }



}
