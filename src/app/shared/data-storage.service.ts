import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import { Recipe } from '../recipes/recipe.model';
import { RecipeService } from '../recipes/recipe.service';

@Injectable({ providedIn: 'root' })
export class DataStorageService {
  constructor(private http: HttpClient, private recipeService: RecipeService) {}

  storeRecipes() {
    const recipes = this.recipeService.getRecipes();
    this.http
      .put(
       // 'https://recipe-369e7-default-rtdb.firebaseio.com/recipes.json',
       'http://localhost:8080/ricette',
        recipes
      )
      .subscribe(response => {
        console.log(response);
      });
  }

  fetchRecipes() {
    this.http
      .get<Recipe[]>(
        //'https://recipe-369e7-default-rtdb.firebaseio.com//recipes.json'
        'http://localhost:8080/ricette'
      )
      .subscribe(recipes => {
        this.recipeService.setRecipes(recipes);
      });
  }
}
