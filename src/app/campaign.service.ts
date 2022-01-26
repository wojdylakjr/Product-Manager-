import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Campaign } from './campaign';


@Injectable({
  providedIn: 'root'
})
export class CampaignService {


  private baseUrl="http://localhost:8080/products";
  private campaigns = "campaigns"
  constructor(private httpClient: HttpClient ) { }

  getCampaignList(productId:number): Observable<Campaign[]>{
    return this.httpClient.get<Campaign[]>(`${this.baseUrl}/${productId}/${this.campaigns}`);
  }
  getAllCampaignsList(): Observable<Campaign[]>{
    return this.httpClient.get<Campaign[]>(`http://localhost:8080/campaigns`);
  }
  createCampaign(campaign: Campaign, productId:number): Observable<any>{
    return this.httpClient.post(`${this.baseUrl}/${productId}/${this.campaigns}`,campaign);
  }

  addCampaign(campaign: Campaign): Observable<any>{
    return this.httpClient.post(`http://localhost:8080/campaigns`,campaign);
  }

  deleteCampaign(campaignId:number):Observable<Object>{
    return this.httpClient.delete<Campaign>(`http://localhost:8080/campaigns/${campaignId}`);
  }

  // getCampaignById(id:number):Observable<Campaign>{
  //   return this.httpClient.get<Campaign>(`${this.baseUrl}/${id}`);
  // }

  // updateCampaign(id:number, campaign: Campaign):Observable<Object>{
  //   return this.httpClient.put<Campaign>(`${this.baseUrl}/${id}`, campaign);
  // }
}
