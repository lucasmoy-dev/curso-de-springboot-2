package academy.atl.customers.services;

import academy.atl.customers.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    private List<Customer> list = new ArrayList<>();

    public CustomerServiceImp() {
        Customer c = new Customer();
        c.setId(1);
        c.setFirstname("Lucas");
        c.setLastname("Moy");
        c.setEmail("lucasmoy@gmail.com");
        c.setAddress("Siempre viva 123");
        list.add(c);

        Customer c2 = new Customer();
        c2.setId(2);
        c2.setFirstname("Maria");
        c2.setLastname("Gonzales");
        c2.setEmail("mari1654@gmail.com");
        c2.setAddress("Roque 555");
        list.add(c2);
    }

    public Customer getCustomer(Integer id) {
        for (Customer customer: list) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return list;
    }

    public void removeCustomer(Integer id) {
        for (Customer customer: list) {
            if (customer.getId() == id) {
                list.remove(customer);
                break;
            }
        }
    }

    public void addCustomer(Customer customer) {
        list.add(customer);
    }

    public void updateCustomer(Integer id, Customer updateCustomer) {
        for (Customer customer: list) {
            if (customer.getId() == id) {
                list.remove(customer);
                updateCustomer.setId(id);
                list.add(updateCustomer);
                break;
            }
        }
    }


    public List<Customer> searchCustomer(String email, String address) {
        List<Customer> searchResult = new ArrayList<>();

        if (email != null) {
            for (Customer customer: list) {
                if (customer.getEmail().contains(email)) {
                    searchResult.add(customer);
                }
            }
        }

        if (address != null) {
            for (Customer customer: list) {
                if (customer.getAddress().contains(address)) {
                    searchResult.add(customer);
                }
            }
        }
        return searchResult;
    }
}
