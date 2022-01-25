import { Component, OnInit } from '@angular/core';
import { Campaign } from '../campaign';
import { CampaignService } from '../campaign.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-create-campaign',
  templateUrl: './create-campaign.component.html',
  styleUrls: ['./create-campaign.component.css']
})
export class CreateCampaignComponent implements OnInit {

  campaign: Campaign = new Campaign();
  productId:number;

  constructor(private campaignService: CampaignService,private route: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    this.productId = this.route.snapshot.params['productId'];
  }

  saveCampaign(){
    this.campaignService.createCampaign(this.campaign, this.productId).subscribe(data =>{
      console.log(data);
      this.goToCampaignList();
    },
    error => console.log(error));
  }

  goToCampaignList(){
    this.router.navigate([`/list-campaigns/${this.productId}`])
  }

  onSubmit(){
    console.log(this.campaign);
    this.saveCampaign();
  }

}
