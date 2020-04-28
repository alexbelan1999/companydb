import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storage {
    private static Map<Integer, MyObject> objects = new HashMap<>();
    static {
        MyObject object;
        object = new MyObject();
        object.setFieldA("���");
        object.setFieldB(12.3);
        object.setFieldC(true);
        create(object);
        object = new MyObject();
        object.setFieldA("���");
        object.setFieldB(4.56);
        object.setFieldC(false);
        create(object);
        object = new MyObject();
        object.setFieldA("���");
        object.setFieldB(78.9);
        object.setFieldC(true);
        create(object);
    }

    public static Collection<MyObject> readAll() {
        return objects.values();
    }

    public static MyObject readById(Integer id) {
        return objects.get(id);
    }

    public static void create(MyObject object) {
        /* ����������� �������� �������������� */
        Integer id = 1;
        /* ��������� ��������������� ���� �������� � ������ */
        Set<Integer> ids = objects.keySet();
        if(!ids.isEmpty()) {
            /* ���������� ��������������, �� 1 ��������
             * ������������� �� ������������� */
            id += Collections.max(ids);
        }
        object.setId(id);
        objects.put(id, object);
    }

    public static void update(MyObject object) {
        objects.put(object.getId(), object);
    }

    public static void delete(Integer id) {
        objects.remove(id);
    }
}