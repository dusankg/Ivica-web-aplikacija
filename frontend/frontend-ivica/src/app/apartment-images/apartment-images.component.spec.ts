import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApartmentImagesComponent } from './apartment-images.component';

describe('ApartmentImagesComponent', () => {
  let component: ApartmentImagesComponent;
  let fixture: ComponentFixture<ApartmentImagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApartmentImagesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApartmentImagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
