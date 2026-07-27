import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SepetComponent } from './sepet.component';

describe('SepetComponent', () => {
  let component: SepetComponent;
  let fixture: ComponentFixture<SepetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SepetComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SepetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
