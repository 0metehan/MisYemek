import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KayitEkraniComponent } from './kayit-ekrani.component';

describe('KayitEkraniComponent', () => {
  let component: KayitEkraniComponent;
  let fixture: ComponentFixture<KayitEkraniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [KayitEkraniComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(KayitEkraniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
