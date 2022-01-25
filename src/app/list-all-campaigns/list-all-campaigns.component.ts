import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Campaign } from '../campaign';
import { CampaignService } from '../campaign.service';

@Component({
  selector: 'app-list-all-campaigns',
  templateUrl: './list-all-campaigns.component.html',
  styleUrls: ['./list-all-campaigns.component.css']
})
export class ListAllCampaignsComponent implements OnInit {

  campaigns: Campaign[];
  constructor(private campaignService: CampaignService, private route: ActivatedRoute,private router: Router) { }
  ngOnInit(): void {

    this.campaignService.getAllCampaignsList().subscribe(data => {
      console.log(data);
        this.campaigns = data;
    }, error => console.log(error));
  }



  // deleteCampaign(id: number){
  //   this.campaignService.deleteCampaign(id).subscribe(data =>{
  //     console.log(data);
  //     this.ngOnInit();
  //   });
  // }
}
