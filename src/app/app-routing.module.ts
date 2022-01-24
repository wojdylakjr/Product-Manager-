import { NgModule } from "@angular/core";
import {Routes, RouterModule} from "@angular/router";
import { ProductListComponent } from "./product-list/product-list.component";

const routes: Routes = [
    {path:'products', component: ProductListComponent},
    {path:'', redirectTo: 'products',pathMatch:'full'}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class ApiRoutingModule{ } 