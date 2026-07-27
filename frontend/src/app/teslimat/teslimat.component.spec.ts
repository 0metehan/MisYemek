import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeslimatComponent } from './teslimat.component';

describe('TeslimatComponent', () => {
  let component: TeslimatComponent;
  let fixture: ComponentFixture<TeslimatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TeslimatComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TeslimatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
