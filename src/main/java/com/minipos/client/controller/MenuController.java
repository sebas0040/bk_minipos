package com.minipos.client.controller;

import com.minipos.client.dto.MenuItem;
import com.minipos.client.service.MenuService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/{rol}")
    public List<MenuItem> getMenu(@PathVariable String rol) {
        return menuService.getMenuByRole(rol);
    }
}