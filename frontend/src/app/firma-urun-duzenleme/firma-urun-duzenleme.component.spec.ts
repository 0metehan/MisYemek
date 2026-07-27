import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FirmaUrunDuzenlemeComponent } from './firma-urun-duzenleme.component';

describe('FirmaUrunDuzenlemeComponent', () => {
  let component: FirmaUrunDuzenlemeComponent;
  let fixture: ComponentFixture<FirmaUrunDuzenlemeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FirmaUrunDuzenlemeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FirmaUrunDuzenlemeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
