import { RecipesStartComponent } from './recipes/recipes-start/recipes-start.component';
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { RecipesComponent } from "./recipes/recipes.component";
import { ShoppingListComponent } from "./shopping-list/shopping-list.component";
import { RecipeDetailComponent } from './recipes/recipe-detail/recipe-detail.component';
import { RecipeEditComponent } from './recipes/recipe-edit/recipe-edit.component';

const appRoutes: Routes=[
  { path: '', redirectTo: '/recipe', pathMatch: 'full' },
  { path: 'recipes', component: RecipesComponent, children: [
    { path:'', component: RecipesStartComponent },
    { path:'new', component: RecipeEditComponent },
    { path:':id', component: RecipeDetailComponent },
    { path:':id/edit', component: RecipeEditComponent }
  ] },
  { path: 'shopping-list', component: ShoppingListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]

})
export class AppRoutingModule {

}
