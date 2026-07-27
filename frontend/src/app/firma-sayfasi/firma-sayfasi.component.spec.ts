import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FirmaSayfasiComponent } from './firma-sayfasi.component';

describe('FirmaSayfasiComponent', () => {
  let component: FirmaSayfasiComponent;
  let fixture: ComponentFixture<FirmaSayfasiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FirmaSayfasiComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FirmaSayfasiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
