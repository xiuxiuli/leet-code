package array;

public class ArrayUtil {

    public static int[] insert_element(int[] data, int index, int element){
        int old_size = data.length;
        if (index > old_size || index < 0){
            throw new IllegalArgumentException("Index out of bounds");
        }

        int[] newArr = new int[old_size + 1];

        //index = 2
        for (int i = 0; i < index; i++){
            newArr[i] = data[i];
        }

        newArr[index] = element;

        for (int j = index; j < old_size; j++){
            newArr[j+1] = data[j];
        }

        return newArr;

    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5};

        ArrayUtil util = new ArrayUtil();

        nums = util.insert_element(nums, 2, 67);
        
        // System.out.println("数组长度: " + nums.length);
        // System.out.println("第一个元素: " + nums[0]);
        // System.out.println("最后一个元素: " + nums[nums.length - 1]);
    }
    
}
