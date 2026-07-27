import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KuryeAyarlariComponent } from './kurye-ayarlari.component';

describe('KuryeAyarlariComponent', () => {
  let component: KuryeAyarlariComponent;
  let fixture: ComponentFixture<KuryeAyarlariComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [KuryeAyarlariComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(KuryeAyarlariComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
