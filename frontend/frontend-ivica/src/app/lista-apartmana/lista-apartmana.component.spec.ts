import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaApartmanaComponent } from './lista-apartmana.component';

describe('ListaApartmanaComponent', () => {
  let component: ListaApartmanaComponent;
  let fixture: ComponentFixture<ListaApartmanaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaApartmanaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaApartmanaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
