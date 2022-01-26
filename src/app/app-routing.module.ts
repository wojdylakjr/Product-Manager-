import { NgModule } from "@angular/core";
import {Routes, RouterModule} from "@angular/router";
import { CampaignListComponent } from "./campaign-list/campaign-list.component";
import { CreateCampaignComponent } from "./create-campaign/create-campaign.component";
import { CreateProductComponent } from "./create-product/create-product.component";
import { ListAllCampaignsComponent } from "./list-all-campaigns/list-all-campaigns.component";
import { ProductListComponent } from "./product-list/product-list.component";
import { UpdateProductComponent } from "./update-product/update-product.component";
import {AddCampaignComponent} from "./add-campaign/add-campaign.component"


const routes: Routes = [
    {path:'products', component: ProductListComponent},
    {path:'create-product', component: CreateProductComponent},
    {path:'', redirectTo: 'products',pathMatch:'full'},
    {path: 'update-product/:id', component: UpdateProductComponent},
    {path: 'list-campaigns/:productId', component: CampaignListComponent},
    {path: 'create-campaign/:productId', component: CreateCampaignComponent},
    {path: 'listAll-campaigns', component: ListAllCampaignsComponent},
    {path: 'add-campaign', component: AddCampaignComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class ApiRoutingModule{ } 
