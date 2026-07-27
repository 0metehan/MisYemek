import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FirmaAyarlarComponent } from './firma-ayarlar.component';

describe('FirmaAyarlarComponent', () => {
  let component: FirmaAyarlarComponent;
  let fixture: ComponentFixture<FirmaAyarlarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FirmaAyarlarComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FirmaAyarlarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
