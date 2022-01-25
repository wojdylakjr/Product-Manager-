import { Product } from "./product";

export class Campaign {
    campaignID: number;
    name: String;
    keywords: String;
    minAmount: number;
    fund: number;
    isEnabled: boolean;
    townName: String;
    radius: number;
    product: Product

}
