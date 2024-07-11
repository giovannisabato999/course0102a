import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { RecipeService } from "../recipes/recipe.service";

@Injectable({providedIn: 'root'})
export class DataStoragaService {
  constructor( private http: HttpClient, private recipeService: RecipeService ) { }

  storeRecipes ( ){
    const recipes = this.recipeService.getRecipes();
    this.http.put('https://ngcourse-recipe-book-3c35f-default-rtdb.firebaseio.com/recipes.json', recipes).subscribe(response => {
    console.log(response);
    });
  }
}
