import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddApartmentForRentComponent } from './add-apartment-for-rent.component';

describe('AddApartmentForRentComponent', () => {
  let component: AddApartmentForRentComponent;
  let fixture: ComponentFixture<AddApartmentForRentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddApartmentForRentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddApartmentForRentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
