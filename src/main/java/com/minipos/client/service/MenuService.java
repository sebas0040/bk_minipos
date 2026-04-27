package com.minipos.client.service;

import com.minipos.client.dto.MenuItem;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    public List<MenuItem> getMenuByRole(String role) {
        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("departments", "Departments"));
        menu.add(new MenuItem("tmo", "TMO"));
        menu.add(new MenuItem("aboutUs", "About Us"));

        if ("admin".equalsIgnoreCase(role)) {
            menu.add(new MenuItem("customers", "Customers"));
        }

        return menu;
    }
}