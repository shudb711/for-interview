package all.javalearn.datastructure.stack.arraystack;

public class ArrayStack<Integer>
{
    int[] arr;
    int index;
    int size;

    public ArrayStack()
    {
        this(8);
    }

    public ArrayStack(int size)
    {
        this.arr = new int[size];
        this.size = size;
        index = 0;
    }

    public void push(int node)
    {
        if (index < size)
        {
            arr[index] = node;
            index++;
        }
        else
        {
            int[] temp = new int[size * 2];
            size = size * 2;
            for (int i = 0; i < arr.length ; i++)
            {
                temp[i] = arr[i];
            }
            temp[index] = node;
            arr = temp;
            index++;
        }
    }

    public int pop() throws Exception {
        if (index == 0)
            throw new Exception("没有元素啦，不要再弹啦！！！");
        return arr[--index];
    }
}