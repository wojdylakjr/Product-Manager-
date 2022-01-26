import { Component, OnInit } from '@angular/core';
import { Campaign } from '../campaign';
import { CampaignService } from '../campaign.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-campaign',
  templateUrl: './add-campaign.component.html',
  styleUrls: ['./add-campaign.component.css']
})
export class AddCampaignComponent implements OnInit {
  campaign: Campaign = new Campaign();
  productId:number;

  constructor(private campaignService: CampaignService,private router: Router) { }

  ngOnInit(): void {
    // this.productId = this.route.snapshot.params['productId'];
  }

  saveCampaign(){
    this.campaignService.addCampaign(this.campaign).subscribe(data =>{
      console.log(data);
      this.goToCampaignList();
    },
    error => console.log(error));
  }

  goToCampaignList(){
    this.router.navigate([`listAll-campaigns`])
  }

  onSubmit(){
    console.log(this.campaign);
    this.saveCampaign();
  }
}



