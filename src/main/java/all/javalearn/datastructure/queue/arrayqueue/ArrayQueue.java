package all.javalearn.datastructure.queue.arrayqueue;

public class ArrayQueue<Integer>
{
    int[] arr;
    int index;
    int size;
    int tail;

    public ArrayQueue()
    {
        this(8);
    }

    public ArrayQueue(int size)
    {
        this.arr = new int[size];
        this.size = size;
        index = size - 1;
        tail = size - 1;
    }

    public void insert(int node)
    {
        if (index > -1)
        {
            arr[index] = node;
            index--;
        }
        else
        {
//            size = size * 2;
            int[] temp = new int[size * 2];
            index = temp.length - size -1;
            for (int i = 0; i < arr.length ; i++)
            {
                temp[temp.length - i - 1] = arr[arr.length - i -1];
            }
            temp[index] = node;
            arr = temp;
            index--;
            size = size * 2;
            tail = size - 1;
        }
    }

    public int delete() throws Exception {
        if (tail == -1)
            throw new Exception("没有元素啦，不要再弹啦！！！");
        int node = arr[tail];
        tail--;
        return node;
    }
}