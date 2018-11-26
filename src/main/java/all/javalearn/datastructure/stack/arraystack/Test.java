package all.javalearn.datastructure.stack.arraystack;

import all.javalearn.datastructure.queue.arrayqueue.ArrayQueue;

public class Test
{
    public static void main(String[] args) throws Exception {
        ArrayQueue arrayQueue = new ArrayQueue();

        for (int i = 0; i < 15 ; i++) {
            arrayQueue.insert(i);
        }

        for (int i = 0; i < 3 ; i++) {
            System.out.println(arrayQueue.delete());
        }
    }
}
