import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HesapComponent } from './hesap.component';

describe('HesapComponent', () => {
  let component: HesapComponent;
  let fixture: ComponentFixture<HesapComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HesapComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HesapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
