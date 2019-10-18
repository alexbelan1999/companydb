package dao.fake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import dao.CustomersDao;
import company.Customers;

public class CustomersDaoFakeImpl implements CustomersDao {
    
    private static Map<Long, Customers> customers = new ConcurrentHashMap<>();
    
    static {
        Customers customer = new Customers();
        customer.setId(1L);
        customer.setName("Lacit");
        customer.setAddress("ул. Лазо 149");
        customer.setTotal_pnumber(0);
        customer.setComplet_pnumber(0);
        customers.put(customer.getId(), customer);
        customer = new Customers();
        customer.setId(2L);
        customer.setName("EPAM");
        customer.setAddress("проспект Строителей 11A");
        customer.setTotal_pnumber(0);
        customer.setComplet_pnumber(0);
        customers.put(customer.getId(), customer);
        customer.setId(3L);
        customer.setName("iTechArt");
        customer.setAddress("Коммунистическая ул. 16");
        customer.setTotal_pnumber(0);
        customer.setComplet_pnumber(0);
        customers.put(customer.getId(), customer);
    }

    @Override
    public Long create(Customers customer) {
        Long id = 0L;
        if(!customers.isEmpty()) {
            id = Collections.max(customers.keySet());
        }
        customer.setId(++id);
        customers.put(id, customer);
        return id;
    }

    @Override
    public Customers read(Long id) {
        return customers.get(id);
    }

    @Override
    public void update(Customers customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public void delete(Long id) {
        customers.remove(id);
    }

    @Override
    public List<Customers> readAll() {
        return new ArrayList<>(customers.values());
    }
    
    @Override
    public List<Customers> readByCustomer(Long customer_id) {
        List<Customers> result = new ArrayList<>();
        for(Customers customer : customers.values()) {
            if(customer.getId() == customer_id) {
                result.add(customer);
            }
        }
        return result;
    }
}