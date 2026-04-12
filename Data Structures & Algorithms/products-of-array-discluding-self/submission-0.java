class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;

        int [] leftProduct = new int[size];
        int [] rightProduct = new int[size];

        int left = 1, right = 1;

        for (int index = 0; index < size; index++) {
            left *= nums[index];
            right *= nums[size-1-index];
            leftProduct[index] = left;
            rightProduct[size-1-index] = right;
        }

        //   // DEBUG — print arrays
        // System.out.println("leftProduct:  " + Arrays.toString(leftProduct));
        // System.out.println("rightProduct: " + Arrays.toString(rightProduct));

        int[] result = new int[size];

        for (int index = 0; index < size; index++) {
           int leftProductExcludingSelf = (index - 1) >= 0 ? leftProduct[index-1] : 1;
           int rightProductExcludingSelf = (index + 1) < size ? rightProduct[index+1] : 1;
           result[index] = leftProductExcludingSelf * rightProductExcludingSelf;
        } 

        return result;
        
    }
}  
