import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Campaign } from '../campaign';
import { CampaignService } from '../campaign.service';

@Component({
  selector: 'app-campaign-list',
  templateUrl: './campaign-list.component.html',
  styleUrls: ['./campaign-list.component.css']
})
export class CampaignListComponent implements OnInit {

  campaigns: Campaign[];
  productId:number;

  constructor(private campaignService: CampaignService, private route: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    this.productId = this.route.snapshot.params['productId'];

    this.campaignService.getCampaignList(this.productId).subscribe(data => {
      console.log(data);
      this.campaigns = data;
    }, error => console.log(error));
  }

  // // onSubmit(){
  // //   this.getCampaigns();
  // // }
  // private getCampaigns(){
  //   this.campaignService.getCampaignList(this.productId).subscribe(data =>{
  //     console.log(data);
  //     this.campaigns = data;
  //   });
  // }

  // updateProduct(id: number){
  //   this.router.navigate(['update-product', id]);
  // }

  deleteCampaign(id: number){
    this.campaignService.deleteCampaign(id).subscribe(data =>{
      console.log(data);
      this.ngOnInit();
    });
  }
  addCampaign(productId:number){
    this.router.navigate(['create-campaign', productId])
  }
  

  // addCampaign(id:number){}
  // deleteCampaign(id:number){}
  
  // campaignList(productId:number){
  //   this.router.navigate(['list-campaigns', productId]);
  // }

}
