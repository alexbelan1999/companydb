package task1;

import java.util.LinkedList;

public class Queue {
	LinkedList _items = new LinkedList<Character>();

    public void add(char c)
    {
        _items.addLast(c);
    }

    public Object remove()
    {
        Object last = _items.getFirst();

        _items.removeFirst();

        return last;
    }

    public Object peek()
    {
        return _items.getLast();
    }

    public int count()
    {
        return _items.size();
    }

    public void print()
    {
/*        for (int i = 0; i < count(); i++)
            System.out.println();*/
        System.out.print("[");
        for (int i = 0; i < count() - 1; i++)
            System.out.print(_items.get(i) + ", ");
        System.out.print(_items.get(count()-1)+"]");
    }
}

