package com.example.recipeapp.controllers;

import com.example.recipeapp.domain.Category;
import com.example.recipeapp.domain.UnitOfMeasure;
import com.example.recipeapp.repositories.CategoryRepository;
import com.example.recipeapp.repositories.UnitOfMeasureRepository;
import com.example.recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model)
    {
        log.debug("getting index page here");

        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
