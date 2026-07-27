import { ComponentFixture, TestBed } from '@angular/core/testing';

import { YemekComponent } from './yemek.component';

describe('YemekComponent', () => {
  let component: YemekComponent;
  let fixture: ComponentFixture<YemekComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [YemekComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(YemekComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
