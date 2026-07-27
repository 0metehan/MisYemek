import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FirmaSiparisTakipComponent } from './firma-siparis-takip.component';

describe('FirmaSiparisTakipComponent', () => {
  let component: FirmaSiparisTakipComponent;
  let fixture: ComponentFixture<FirmaSiparisTakipComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FirmaSiparisTakipComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FirmaSiparisTakipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
