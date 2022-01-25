import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAllCampaignsComponent } from './list-all-campaigns.component';

describe('ListAllCampaignsComponent', () => {
  let component: ListAllCampaignsComponent;
  let fixture: ComponentFixture<ListAllCampaignsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListAllCampaignsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAllCampaignsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
