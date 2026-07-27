import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FirmaSiparisComponent } from './firma-siparis.component';

describe('FirmaSiparisComponent', () => {
  let component: FirmaSiparisComponent;
  let fixture: ComponentFixture<FirmaSiparisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FirmaSiparisComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FirmaSiparisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
