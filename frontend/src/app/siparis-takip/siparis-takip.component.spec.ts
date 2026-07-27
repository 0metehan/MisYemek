import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SiparisTakipComponent } from './siparis-takip.component';

describe('SiparisTakipComponent', () => {
  let component: SiparisTakipComponent;
  let fixture: ComponentFixture<SiparisTakipComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SiparisTakipComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SiparisTakipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
