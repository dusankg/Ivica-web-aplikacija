import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IzdvajamoIzPonudeComponent } from './izdvajamo-iz-ponude.component';

describe('IzdvajamoIzPonudeComponent', () => {
  let component: IzdvajamoIzPonudeComponent;
  let fixture: ComponentFixture<IzdvajamoIzPonudeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IzdvajamoIzPonudeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IzdvajamoIzPonudeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
